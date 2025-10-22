package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExifSchemaDiffblueTest {
  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExifSchema.<init>(XMPMetadata)"})
  void testNewExifSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata);

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("exif", actualExifSchema.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualExifSchema.getAllProperties().isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/exif/1.0/"));
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Prefix is {@code exif}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata, String); when 'null'; then return Prefix is 'exif'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExifSchema.<init>(XMPMetadata, String)"})
  void testNewExifSchema_whenNull_thenReturnPrefixIsExif() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata, null);

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("exif", actualExifSchema.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualExifSchema.getAllProperties().isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/exif/1.0/"));
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#ExifSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code Own Prefix}.</li>
   *   <li>Then return Prefix is {@code Own Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#ExifSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new ExifSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExifSchema.<init>(XMPMetadata, String)"})
  void testNewExifSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ExifSchema actualExifSchema = new ExifSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualExifSchema.getAboutValue());
    assertEquals("Own Prefix", actualExifSchema.getPrefix());
    assertEquals("exif", actualExifSchema.getPreferedPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualExifSchema.getNamespace());
    assertNull(actualExifSchema.getUserComment());
    assertNull(actualExifSchema.getPropertyName());
    assertNull(actualExifSchema.getUserCommentLanguages());
    assertNull(actualExifSchema.getUserCommentProperty());
    assertNull(actualExifSchema.getAboutAttribute());
    Map<String, String> allNamespacesWithPrefix = actualExifSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualExifSchema.getAllProperties().isEmpty());
    assertTrue(actualExifSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/exif/1.0/"));
    assertSame(metadata, actualExifSchema.getMetadata());
  }

  /**
   * Test {@link ExifSchema#getUserCommentProperty()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  @DisplayName("Test getUserCommentProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty ExifSchema.getUserCommentProperty()"})
  void testGetUserCommentProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ExifSchema exifSchema = new ExifSchema(metadata);
    exifSchema.addBagValueAsSimple("Simple Name", ExifSchema.USER_COMMENT);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    ArrayProperty actualUserCommentProperty = exifSchema.getUserCommentProperty();

    // Assert
    assertEquals("exif", actualUserCommentProperty.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualUserCommentProperty.getNamespace());
    assertEquals(1, actualUserCommentProperty.getAllProperties().size());
    assertEquals(1, actualUserCommentProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualUserCommentProperty.getArrayType());
    assertTrue(actualUserCommentProperty.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ExifSchema.USER_COMMENT, actualUserCommentProperty.getPropertyName());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty ExifSchema.getUserCommentProperty()"})
  void testGetUserCommentProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserCommentProperty());
  }

  /**
   * Test {@link ExifSchema#getUserCommentProperty()}.
   * <ul>
   *   <li>Then return Prefix is {@code exif}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentProperty()}
   */
  @Test
  @DisplayName("Test getUserCommentProperty(); then return Prefix is 'exif'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty ExifSchema.getUserCommentProperty()"})
  void testGetUserCommentProperty_thenReturnPrefixIsExif() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    ExifSchema exifSchema = new ExifSchema(metadata);
    exifSchema.addBagValueAsSimple(ExifSchema.USER_COMMENT, "42");

    // Act
    ArrayProperty actualUserCommentProperty = exifSchema.getUserCommentProperty();

    // Assert
    assertEquals("exif", actualUserCommentProperty.getPrefix());
    assertEquals("http://ns.adobe.com/exif/1.0/", actualUserCommentProperty.getNamespace());
    assertEquals(1, actualUserCommentProperty.getAllProperties().size());
    assertEquals(1, actualUserCommentProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualUserCommentProperty.getArrayType());
    assertTrue(actualUserCommentProperty.getAllAttributes().isEmpty());
    assertTrue(actualUserCommentProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ExifSchema.USER_COMMENT, actualUserCommentProperty.getPropertyName());
    assertSame(metadata, actualUserCommentProperty.getMetadata());
  }

  /**
   * Test {@link ExifSchema#getUserCommentLanguages()}.
   * <p>
   * Method under test: {@link ExifSchema#getUserCommentLanguages()}
   */
  @Test
  @DisplayName("Test getUserCommentLanguages()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ExifSchema.getUserCommentLanguages()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ExifSchema.getUserCommentLanguages()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ExifSchema.getUserCommentLanguages()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment(String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment(String)"})
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
   *   <li>Given {@link ExifSchema#ExifSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserComment(String)}
   */
  @Test
  @DisplayName("Test getUserComment(String) with 'String'; given ExifSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment(String)"})
  void testGetUserCommentWithString_givenExifSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment("Lang"));
  }

  /**
   * Test {@link ExifSchema#getUserComment()}.
   * <ul>
   *   <li>Given {@link ExifSchema#ExifSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExifSchema#getUserComment()}
   */
  @Test
  @DisplayName("Test getUserComment(); given ExifSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ExifSchema.getUserComment()"})
  void testGetUserComment_givenExifSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new ExifSchema(XMPMetadata.createXMPMetadata())).getUserComment());
  }
}
