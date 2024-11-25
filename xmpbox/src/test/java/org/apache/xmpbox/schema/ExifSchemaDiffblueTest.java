package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExifSchemaDiffblueTest {
  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata)")
  void testNewExifSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata);

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("exif", allNamespacesWithPrefix.get("http://ns.adobe.com/exif/1.0/"));
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("exif", actualExifSchema.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualExifSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualExifSchema.getContainer().getAllProperties());
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata, String)}.
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata, String)")
  void testNewExifSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/exif/1.0/"));
    assertEquals("Own Prefix", actualExifSchema.getPrefix());
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualExifSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualExifSchema.getContainer().getAllProperties());
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code http://ns.adobe.com/exif/1.0/}
   * is {@code exif}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata, String); then return AllNamespacesWithPrefix 'http://ns.adobe.com/exif/1.0/' is 'exif'")
  void testNewExifSchema_thenReturnAllNamespacesWithPrefixHttpNsAdobeComExif10IsExif() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata, null);

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("exif", allNamespacesWithPrefix.get("http://ns.adobe.com/exif/1.0/"));
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("exif", actualExifSchema.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualExifSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualExifSchema.getContainer().getAllProperties());
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#getUserCommentProperty()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  @DisplayName("Test getUserCommentProperty()")
  void testGetUserCommentProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ExifSchema exifSchema = new ExifSchema(metadata);
    exifSchema.addBagValueAsSimple("Simple Name", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    ArrayProperty actualUserCommentProperty = exifSchema.getUserCommentProperty();

    // Assert
    List<AbstractField> allProperties = actualUserCommentProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualUserCommentProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("exif", getResult.getPrefix());
    assertEquals("exif", actualUserCommentProperty.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualUserCommentProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(Cardinality.Bag, actualUserCommentProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ExifSchema.USER_COMMENT, actualUserCommentProperty.getPropertyName());
    assertSame(allProperties, actualUserCommentProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualUserCommentProperty.getMetadata());
  }

  /**
   * Test {@link ExifSchema#getUserCommentProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  @DisplayName("Test getUserCommentProperty(); then return AllProperties size is one")
  void testGetUserCommentProperty_thenReturnAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ExifSchema exifSchema = new ExifSchema(metadata);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    ArrayProperty actualUserCommentProperty = exifSchema.getUserCommentProperty();

    // Assert
    List<AbstractField> allProperties = actualUserCommentProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualUserCommentProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("exif", getResult.getPrefix());
    assertEquals("exif", actualUserCommentProperty.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualUserCommentProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals(Cardinality.Bag, actualUserCommentProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ExifSchema.USER_COMMENT, actualUserCommentProperty.getPropertyName());
    assertSame(allProperties, actualUserCommentProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualUserCommentProperty.getMetadata());
  }

  /**
   * Test {@link ExifSchema#getUserCommentProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  @DisplayName("Test getUserCommentProperty(); then return 'null'")
  void testGetUserCommentProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserCommentProperty());
  }

  /**
   * Test {@link ExifSchema#getUserCommentLanguages()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  @DisplayName("Test getUserCommentLanguages()")
  void testGetUserCommentLanguages() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple("lang", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    List<String> actualUserCommentLanguages = exifSchema.getUserCommentLanguages();

    // Assert
    assertEquals(1, actualUserCommentLanguages.size());
    assertEquals("x-default", actualUserCommentLanguages.get(0));
  }

  /**
   * Test {@link ExifSchema#getUserCommentLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  @DisplayName("Test getUserCommentLanguages(); then return 'null'")
  void testGetUserCommentLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserCommentLanguages());
  }

  /**
   * Test {@link ExifSchema#getUserCommentLanguages()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  @DisplayName("Test getUserCommentLanguages(); then return size is one")
  void testGetUserCommentLanguages_thenReturnSizeIsOne() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    List<String> actualUserCommentLanguages = exifSchema.getUserCommentLanguages();

    // Assert
    assertEquals(1, actualUserCommentLanguages.size());
    assertEquals("x-default", actualUserCommentLanguages.get(0));
  }

  /**
   * Test {@link ExifSchema#getUserComment()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  @DisplayName("Test getUserComment()")
  void testGetUserComment() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment());
  }

  /**
   * Test {@link ExifSchema#getUserComment()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  @DisplayName("Test getUserComment()")
  void testGetUserComment2() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple("x-default", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment());
  }

  /**
   * Test {@link ExifSchema#getUserComment(String)} with {@code String}.
   * <p>
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  @DisplayName("Test getUserComment(String) with 'String'")
  void testGetUserCommentWithString() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment("Lang"));
  }

  /**
   * Test {@link ExifSchema#getUserComment(String)} with {@code String}.
   * <p>
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  @DisplayName("Test getUserComment(String) with 'String'")
  void testGetUserCommentWithString2() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple("lang", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment("Lang"));
  }

  /**
   * Test {@link ExifSchema#getUserComment(String)} with {@code String}.
   * <ul>
   *   <li>Given {@link ExifSchema#ExifSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  @DisplayName("Test getUserComment(String) with 'String'; given ExifSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetUserCommentWithString_givenExifSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment("Lang"));
  }

  /**
   * Test {@link ExifSchema#getUserComment()}.
   * <ul>
   *   <li>Given {@link ExifSchema#ExifSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  @DisplayName("Test getUserComment(); given ExifSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  void testGetUserComment_givenExifSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment());
  }
}
