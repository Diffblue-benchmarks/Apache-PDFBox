package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TiffSchemaDiffblueTest {
  /**
   * Test {@link TiffSchema#TiffSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link TiffSchema#TiffSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new TiffSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.<init>(XMPMetadata)"})
  void testNewTiffSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata);

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertEquals("tiff", actualTiffSchema.getPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualTiffSchema.getAllProperties().isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/tiff/1.0/"));
    assertSame(metadata, actualTiffSchema.getMetadata());
  }

  /**
   * Test {@link TiffSchema#TiffSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code tiff}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#TiffSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new TiffSchema(XMPMetadata, String); when 'null'; then return Prefix is 'tiff'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.<init>(XMPMetadata, String)"})
  void testNewTiffSchema_whenNull_thenReturnPrefixIsTiff() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata, null);

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertEquals("tiff", actualTiffSchema.getPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualTiffSchema.getAllProperties().isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/tiff/1.0/"));
    assertSame(metadata, actualTiffSchema.getMetadata());
  }

  /**
   * Test {@link TiffSchema#TiffSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Prefix}.
   *   <li>Then return {@code Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#TiffSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new TiffSchema(XMPMetadata, String); when 'Prefix'; then return 'Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.<init>(XMPMetadata, String)"})
  void testNewTiffSchema_whenPrefix_thenReturnPrefix() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    TiffSchema actualTiffSchema = new TiffSchema(metadata, "Prefix");

    // Assert
    assertEquals("", actualTiffSchema.getAboutValue());
    assertEquals("Prefix", actualTiffSchema.getPrefix());
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualTiffSchema.getNamespace());
    assertEquals("tiff", actualTiffSchema.getPreferedPrefix());
    assertNull(actualTiffSchema.getArtist());
    assertNull(actualTiffSchema.getCopyright());
    assertNull(actualTiffSchema.getImageDescription());
    assertNull(actualTiffSchema.getPropertyName());
    assertNull(actualTiffSchema.getCopyrightLanguages());
    assertNull(actualTiffSchema.getImageDescriptionLanguages());
    assertNull(actualTiffSchema.getCopyrightProperty());
    assertNull(actualTiffSchema.getImageDescriptionProperty());
    assertNull(actualTiffSchema.getAboutAttribute());
    assertNull(actualTiffSchema.getArtistProperty());
    Map<String, String> allNamespacesWithPrefix = actualTiffSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualTiffSchema.getAllProperties().isEmpty());
    assertTrue(actualTiffSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/tiff/1.0/"));
    assertSame(metadata, actualTiffSchema.getMetadata());
  }

  /**
   * Test {@link TiffSchema#getArtistProperty()}.
   *
   * <p>Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  @DisplayName("Test getArtistProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.xmpbox.type.ProperNameType TiffSchema.getArtistProperty()"})
  void testGetArtistProperty() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtistProperty());
  }

  /**
   * Test {@link TiffSchema#getArtistProperty()}.
   *
   * <p>Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  @DisplayName("Test getArtistProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.xmpbox.type.ProperNameType TiffSchema.getArtistProperty()"})
  void testGetArtistProperty2() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtistProperty());
  }

  /**
   * Test {@link TiffSchema#getArtistProperty()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getArtistProperty()}
   */
  @Test
  @DisplayName(
      "Test getArtistProperty(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.xmpbox.type.ProperNameType TiffSchema.getArtistProperty()"})
  void testGetArtistProperty_givenTiffSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getArtistProperty());
  }

  /**
   * Test {@link TiffSchema#getArtist()}.
   *
   * <p>Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  @DisplayName("Test getArtist()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getArtist()"})
  void testGetArtist() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtist());
  }

  /**
   * Test {@link TiffSchema#getArtist()}.
   *
   * <p>Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  @DisplayName("Test getArtist()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getArtist()"})
  void testGetArtist2() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act and Assert
    assertNull(tiffSchema.getArtist());
  }

  /**
   * Test {@link TiffSchema#getArtist()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getArtist()}
   */
  @Test
  @DisplayName("Test getArtist(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getArtist()"})
  void testGetArtist_givenTiffSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getArtist());
  }

  /**
   * Test {@link TiffSchema#setArtist(String)}.
   *
   * <p>Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  @DisplayName("Test setArtist(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.setArtist(String)"})
  void testSetArtist() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#setArtist(String)}.
   *
   * <p>Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  @DisplayName("Test setArtist(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.setArtist(String)"})
  void testSetArtist2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#setArtist(String)}.
   *
   * <p>Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  @DisplayName("Test setArtist(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.setArtist(String)"})
  void testSetArtist3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.ARTIST);
    tiffSchema.addImageDescription(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(TiffSchema.ARTIST, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#setArtist(String)}.
   *
   * <p>Method under test: {@link TiffSchema#setArtist(String)}
   */
  @Test
  @DisplayName("Test setArtist(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.setArtist(String)"})
  void testSetArtist4() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.ARTIST, "42");

    // Act
    tiffSchema.setArtist("Text");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Text", ((TextType) getResult).getStringValue());
    assertEquals("Text", ((TextType) getResult).getRawValue());
    assertEquals("Text", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("tiff", getResult.getPrefix());
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionProperty()}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getImageDescriptionProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getImageDescriptionProperty()"})
  void testGetImageDescriptionProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("Lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    ArrayProperty actualImageDescriptionProperty = tiffSchema.getImageDescriptionProperty();

    // Assert
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualImageDescriptionProperty.getNamespace());
    assertEquals("tiff", actualImageDescriptionProperty.getPrefix());
    assertEquals(1, actualImageDescriptionProperty.getAllProperties().size());
    assertEquals(1, actualImageDescriptionProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, actualImageDescriptionProperty.getArrayType());
    assertTrue(actualImageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(actualImageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionProperty.getPropertyName());
    assertSame(metadata, actualImageDescriptionProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/tiff/1.0/}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  @DisplayName(
      "Test getImageDescriptionProperty(); then return Namespace is 'http://ns.adobe.com/tiff/1.0/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getImageDescriptionProperty()"})
  void testGetImageDescriptionProperty_thenReturnNamespaceIsHttpNsAdobeComTiff10() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    ArrayProperty actualImageDescriptionProperty = tiffSchema.getImageDescriptionProperty();

    // Assert
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualImageDescriptionProperty.getNamespace());
    assertEquals("tiff", actualImageDescriptionProperty.getPrefix());
    assertEquals(1, actualImageDescriptionProperty.getAllProperties().size());
    assertEquals(1, actualImageDescriptionProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, actualImageDescriptionProperty.getArrayType());
    assertTrue(actualImageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(actualImageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionProperty.getPropertyName());
    assertSame(metadata, actualImageDescriptionProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionProperty()}
   */
  @Test
  @DisplayName("Test getImageDescriptionProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getImageDescriptionProperty()"})
  void testGetImageDescriptionProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getImageDescriptionProperty());
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionLanguages()}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getImageDescriptionLanguages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getImageDescriptionLanguages()"})
  void testGetImageDescriptionLanguages() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionLanguages.get(0));
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@link TiffSchema#IMAGE_DESCRIPTION}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getImageDescriptionLanguages(); then return first is IMAGE_DESCRIPTION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getImageDescriptionLanguages()"})
  void testGetImageDescriptionLanguages_thenReturnFirstIsImage_description()
      throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualImageDescriptionLanguages.get(0));
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@code x-default}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getImageDescriptionLanguages(); then return first is 'x-default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getImageDescriptionLanguages()"})
  void testGetImageDescriptionLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    List<String> actualImageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();

    // Assert
    assertEquals(1, actualImageDescriptionLanguages.size());
    assertEquals("x-default", actualImageDescriptionLanguages.get(0));
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionLanguages()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getImageDescriptionLanguages(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getImageDescriptionLanguages()"})
  void testGetImageDescriptionLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getImageDescriptionLanguages());
  }

  /**
   * Test {@link TiffSchema#getImageDescriptionLanguages()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescriptionLanguages()}
   */
  @Test
  @DisplayName("Test getImageDescriptionLanguages(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getImageDescriptionLanguages()"})
  void testGetImageDescriptionLanguages_thenThrowBadFieldValueException()
      throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getImageDescriptionLanguages());
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName("Test getImageDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName("Test getImageDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("x-default", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName("Test getImageDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription());
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName("Test getImageDescription(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName("Test getImageDescription(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName("Test getImageDescription(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertNull(tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName(
      "Test getImageDescription(String) with 'String'; given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString_givenTiffSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link TiffSchema#IMAGE_DESCRIPTION}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName("Test getImageDescription(String) with 'String'; then return IMAGE_DESCRIPTION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString_thenReturnImage_description()
      throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription("Lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription(String)}
   */
  @Test
  @DisplayName("Test getImageDescription(String) with 'String'; then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription(String)"})
  void testGetImageDescriptionWithString_thenThrowBadFieldValueException()
      throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getImageDescription("Lang"));
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName(
      "Test getImageDescription(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription_givenTiffSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getImageDescription());
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <ul>
   *   <li>Then return {@link TiffSchema#IMAGE_DESCRIPTION}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName("Test getImageDescription(); then return IMAGE_DESCRIPTION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription_thenReturnImage_description() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription("x-default", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act and Assert
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, tiffSchema.getImageDescription());
  }

  /**
   * Test {@link TiffSchema#getImageDescription()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getImageDescription()}
   */
  @Test
  @DisplayName("Test getImageDescription(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getImageDescription()"})
  void testGetImageDescription_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getImageDescription());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(imageDescriptionProperty, allProperties.get(0));
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("lang", TiffSchema.IMAGE_DESCRIPTION);
    tiffSchema.addImageDescription(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(0));
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertEquals(1, imageDescriptionProperty.getAllProperties().size());
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(imageDescriptionProperty, allProperties.get(1));
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription("Lang", "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert that nothing has changed
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(1, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(0));
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    assertEquals("http://ns.adobe.com/tiff/1.0/", imageDescriptionProperty.getNamespace());
    assertEquals("tiff", imageDescriptionProperty.getPrefix());
    assertEquals(1, tiffSchema.getAllProperties().size());
    assertEquals(1, imageDescriptionProperty.getAllProperties().size());
    assertEquals(1, imageDescriptionProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, imageDescriptionProperty.getArrayType());
    assertTrue(imageDescriptionProperty.getAllAttributes().isEmpty());
    assertTrue(imageDescriptionProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, imageDescriptionProperty.getPropertyName());
    assertSame(metadata, imageDescriptionProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription("x-default", "42");

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert
    ArrayProperty imageDescriptionProperty = tiffSchema.getImageDescriptionProperty();
    List<AbstractField> allProperties = imageDescriptionProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = imageDescriptionProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> imageDescriptionLanguages = tiffSchema.getImageDescriptionLanguages();
    assertEquals(2, imageDescriptionLanguages.size());
    assertEquals("Lang", imageDescriptionLanguages.get(1));
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addImageDescription(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addImageDescription(String, String)}
   */
  @Test
  @DisplayName("Test addImageDescription(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addImageDescription(String, String)"})
  void testAddImageDescription7() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            TiffSchema.IMAGE_DESCRIPTION,
            "Value");
    tiffSchema.addProperty(obj);

    // Act
    tiffSchema.addImageDescription("Lang", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }

  /**
   * Test {@link TiffSchema#getCopyrightProperty()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  @DisplayName(
      "Test getCopyrightProperty(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getCopyrightProperty()"})
  void testGetCopyrightProperty_givenTiffSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getCopyrightProperty());
  }

  /**
   * Test {@link TiffSchema#getCopyrightProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/tiff/1.0/}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  @DisplayName(
      "Test getCopyrightProperty(); then return Namespace is 'http://ns.adobe.com/tiff/1.0/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getCopyrightProperty()"})
  void testGetCopyrightProperty_thenReturnNamespaceIsHttpNsAdobeComTiff10() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    ArrayProperty actualCopyrightProperty = tiffSchema.getCopyrightProperty();

    // Assert
    assertEquals("http://ns.adobe.com/tiff/1.0/", actualCopyrightProperty.getNamespace());
    assertEquals("tiff", actualCopyrightProperty.getPrefix());
    assertEquals(1, actualCopyrightProperty.getAllProperties().size());
    assertEquals(1, actualCopyrightProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, actualCopyrightProperty.getArrayType());
    assertTrue(actualCopyrightProperty.getAllAttributes().isEmpty());
    assertTrue(actualCopyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, actualCopyrightProperty.getPropertyName());
    assertSame(metadata, actualCopyrightProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#getCopyrightProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightProperty()}
   */
  @Test
  @DisplayName("Test getCopyrightProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty TiffSchema.getCopyrightProperty()"})
  void testGetCopyrightProperty_thenReturnNull() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyrightProperty());
  }

  /**
   * Test {@link TiffSchema#getCopyrightLanguages()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  @DisplayName(
      "Test getCopyrightLanguages(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getCopyrightLanguages()"})
  void testGetCopyrightLanguages_givenTiffSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getCopyrightLanguages());
  }

  /**
   * Test {@link TiffSchema#getCopyrightLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@link TiffSchema#IMAGE_DESCRIPTION}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  @DisplayName("Test getCopyrightLanguages(); then return first is IMAGE_DESCRIPTION")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getCopyrightLanguages()"})
  void testGetCopyrightLanguages_thenReturnFirstIsImage_description()
      throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    List<String> actualCopyrightLanguages = tiffSchema.getCopyrightLanguages();

    // Assert
    assertEquals(1, actualCopyrightLanguages.size());
    assertEquals(TiffSchema.IMAGE_DESCRIPTION, actualCopyrightLanguages.get(0));
  }

  /**
   * Test {@link TiffSchema#getCopyrightLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@code x-default}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  @DisplayName("Test getCopyrightLanguages(); then return first is 'x-default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getCopyrightLanguages()"})
  void testGetCopyrightLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act
    List<String> actualCopyrightLanguages = tiffSchema.getCopyrightLanguages();

    // Assert
    assertEquals(1, actualCopyrightLanguages.size());
    assertEquals("x-default", actualCopyrightLanguages.get(0));
  }

  /**
   * Test {@link TiffSchema#getCopyrightLanguages()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  @DisplayName("Test getCopyrightLanguages(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getCopyrightLanguages()"})
  void testGetCopyrightLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyrightLanguages());
  }

  /**
   * Test {@link TiffSchema#getCopyrightLanguages()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyrightLanguages()}
   */
  @Test
  @DisplayName("Test getCopyrightLanguages(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TiffSchema.getCopyrightLanguages()"})
  void testGetCopyrightLanguages_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getCopyrightLanguages());
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName("Test getCopyright()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName("Test getCopyright()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName("Test getCopyright()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright());
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName("Test getCopyright(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName("Test getCopyright(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString2() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName("Test getCopyright(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString3() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addBagValueAsSimple(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertNull(tiffSchema.getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName(
      "Test getCopyright(String) with 'String'; given TiffSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString_givenTiffSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link TiffSchema#COPYRIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName("Test getCopyright(String) with 'String'; then return COPYRIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString_thenReturnCopyright() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("Lang", TiffSchema.COPYRIGHT);
    tiffSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertEquals(TiffSchema.COPYRIGHT, tiffSchema.getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright(String)}
   */
  @Test
  @DisplayName("Test getCopyright(String) with 'String'; then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright(String)"})
  void testGetCopyrightWithString_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getCopyright("Lang"));
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <ul>
   *   <li>Given {@link TiffSchema#TiffSchema(XMPMetadata)} with metadata is createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName(
      "Test getCopyright(); given TiffSchema(XMPMetadata) with metadata is createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright_givenTiffSchemaWithMetadataIsCreateXMPMetadata_thenReturnNull()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new TiffSchema(XMPMetadata.createXMPMetadata()).getCopyright());
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <ul>
   *   <li>Then return {@link TiffSchema#COPYRIGHT}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName("Test getCopyright(); then return COPYRIGHT")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright_thenReturnCopyright() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("x-default", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act and Assert
    assertEquals(TiffSchema.COPYRIGHT, tiffSchema.getCopyright());
  }

  /**
   * Test {@link TiffSchema#getCopyright()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link TiffSchema#getCopyright()}
   */
  @Test
  @DisplayName("Test getCopyright(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TiffSchema.getCopyright()"})
  void testGetCopyright_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            "Value");
    tiffSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> tiffSchema.getCopyright());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    TiffSchema tiffSchema = new TiffSchema(metadata);

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("tiff", copyrightProperty.getPrefix());
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, copyrightProperty.getAllProperties().size());
    assertEquals(1, copyrightProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties.get(0));
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertEquals(1, copyrightProperty.getAllProperties().size());
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(elementsAsString, tiffSchema.getImageDescriptionProperty().getElementsAsString());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties.get(1));
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright(TiffSchema.IMAGE_DESCRIPTION, TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(2, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(1));
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright4() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    tiffSchema.addCopyright("Lang", TiffSchema.COPYRIGHT);
    tiffSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addCopyright("x-default", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    List<AbstractField> allProperties = copyrightProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(2, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(1));
    assertEquals("http://ns.adobe.com/tiff/1.0/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("tiff", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    TiffSchema tiffSchema = new TiffSchema(metadata);
    tiffSchema.addBagValueAsSimple("Simple Name", TiffSchema.COPYRIGHT);
    tiffSchema.addImageDescription(TiffSchema.COPYRIGHT, "42");

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert
    List<String> copyrightLanguages = tiffSchema.getCopyrightLanguages();
    assertEquals(1, copyrightLanguages.size());
    assertEquals("Lang", copyrightLanguages.get(0));
    ArrayProperty copyrightProperty = tiffSchema.getCopyrightProperty();
    assertEquals("http://ns.adobe.com/tiff/1.0/", copyrightProperty.getNamespace());
    assertEquals("tiff", copyrightProperty.getPrefix());
    assertEquals(1, copyrightProperty.getAllProperties().size());
    List<String> elementsAsString = copyrightProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertEquals(Cardinality.Alt, copyrightProperty.getArrayType());
    assertTrue(copyrightProperty.getAllAttributes().isEmpty());
    assertTrue(copyrightProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(elementsAsString, tiffSchema.getImageDescriptionProperty().getElementsAsString());
    assertEquals(TiffSchema.COPYRIGHT, copyrightProperty.getPropertyName());
    assertSame(copyrightProperty, allProperties.get(2));
    assertSame(metadata, copyrightProperty.getMetadata());
  }

  /**
   * Test {@link TiffSchema#addCopyright(String, String)}.
   *
   * <p>Method under test: {@link TiffSchema#addCopyright(String, String)}
   */
  @Test
  @DisplayName("Test addCopyright(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TiffSchema.addCopyright(String, String)"})
  void testAddCopyright7() {
    // Arrange
    TiffSchema tiffSchema = new TiffSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            TiffSchema.COPYRIGHT,
            "Value");
    tiffSchema.addProperty(obj);

    // Act
    tiffSchema.addCopyright("Lang", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = tiffSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }
}
