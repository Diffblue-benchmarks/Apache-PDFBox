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
import org.junit.jupiter.api.Test;

class ExifSchemaDiffblueTest {
  /**
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  void testGetUserCommentProperty() {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserCommentProperty());
  }

  /**
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  void testGetUserCommentProperty2() {
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
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  void testGetUserCommentProperty3() {
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
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  void testGetUserCommentLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserCommentLanguages());
  }

  /**
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  void testGetUserCommentLanguages2() throws BadFieldValueException {
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
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  void testGetUserCommentLanguages3() throws BadFieldValueException {
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
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  void testGetUserComment() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment());
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment("Lang"));
  }

  /**
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  void testGetUserComment2() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment());
  }

  /**
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  void testGetUserComment3() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple("x-default", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment());
  }

  /**
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  void testGetUserComment4() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment("Lang"));
  }

  /**
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  void testGetUserComment5() throws BadFieldValueException {
    // Arrange
    ExifSchema exifSchema = new ExifSchema(XMPMetadata.createXMPMetadata());
    exifSchema.addBagValueAsSimple("lang", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act and Assert
    assertNull(exifSchema.getUserComment("Lang"));
  }

  /**
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata)}
   */
  @Test
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
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
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
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
  void testNewExifSchema3() throws BadFieldValueException {
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
}
