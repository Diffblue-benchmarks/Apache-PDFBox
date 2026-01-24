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
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.LayerType;
import org.apache.xmpbox.type.ProperNameType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URIType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PhotoshopSchemaDiffblueTest {
  /**
   * Test {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new PhotoshopSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.<init>(XMPMetadata)"})
  void testNewPhotoshopSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata);

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertEquals("photoshop", actualPhotoshopSchema.getPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPhotoshopSchema.getAllProperties().isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/photoshop/1.0/"));
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code photoshop}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new PhotoshopSchema(XMPMetadata, String); when 'null'; then return Prefix is 'photoshop'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.<init>(XMPMetadata, String)"})
  void testNewPhotoshopSchema_whenNull_thenReturnPrefixIsPhotoshop() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata, null);

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertEquals("photoshop", actualPhotoshopSchema.getPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPhotoshopSchema.getAllProperties().isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/photoshop/1.0/"));
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Own Prefix}.
   *   <li>Then return Prefix is {@code Own Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName(
      "Test new PhotoshopSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.<init>(XMPMetadata, String)"})
  void testNewPhotoshopSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix()
      throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualPhotoshopSchema = new PhotoshopSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualPhotoshopSchema.getAboutValue());
    assertEquals("Own Prefix", actualPhotoshopSchema.getPrefix());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualPhotoshopSchema.getNamespace());
    assertEquals("photoshop", actualPhotoshopSchema.getPreferedPrefix());
    assertNull(actualPhotoshopSchema.getColorMode());
    assertNull(actualPhotoshopSchema.getUrgency());
    assertNull(actualPhotoshopSchema.getAncestorID());
    assertNull(actualPhotoshopSchema.getAuthorsPosition());
    assertNull(actualPhotoshopSchema.getCaptionWriter());
    assertNull(actualPhotoshopSchema.getCategory());
    assertNull(actualPhotoshopSchema.getCity());
    assertNull(actualPhotoshopSchema.getCountry());
    assertNull(actualPhotoshopSchema.getCredit());
    assertNull(actualPhotoshopSchema.getDateCreated());
    assertNull(actualPhotoshopSchema.getHeadline());
    assertNull(actualPhotoshopSchema.getHistory());
    assertNull(actualPhotoshopSchema.getICCProfile());
    assertNull(actualPhotoshopSchema.getInstructions());
    assertNull(actualPhotoshopSchema.getSource());
    assertNull(actualPhotoshopSchema.getState());
    assertNull(actualPhotoshopSchema.getSupplementalCategories());
    assertNull(actualPhotoshopSchema.getTransmissionReference());
    assertNull(actualPhotoshopSchema.getPropertyName());
    assertNull(actualPhotoshopSchema.getDocumentAncestors());
    assertNull(actualPhotoshopSchema.getTextLayers());
    assertNull(actualPhotoshopSchema.getDocumentAncestorsProperty());
    assertNull(actualPhotoshopSchema.getAboutAttribute());
    assertNull(actualPhotoshopSchema.getDateCreatedProperty());
    assertNull(actualPhotoshopSchema.getColorModeProperty());
    assertNull(actualPhotoshopSchema.getUrgencyProperty());
    assertNull(actualPhotoshopSchema.getAuthorsPositionProperty());
    assertNull(actualPhotoshopSchema.getCaptionWriterProperty());
    assertNull(actualPhotoshopSchema.getCategoryProperty());
    assertNull(actualPhotoshopSchema.getCityProperty());
    assertNull(actualPhotoshopSchema.getCountryProperty());
    assertNull(actualPhotoshopSchema.getCreditProperty());
    assertNull(actualPhotoshopSchema.getHeadlineProperty());
    assertNull(actualPhotoshopSchema.getHistoryProperty());
    assertNull(actualPhotoshopSchema.getICCProfileProperty());
    assertNull(actualPhotoshopSchema.getInstructionsProperty());
    assertNull(actualPhotoshopSchema.getSourceProperty());
    assertNull(actualPhotoshopSchema.getStateProperty());
    assertNull(actualPhotoshopSchema.getSupplementalCategoriesProperty());
    assertNull(actualPhotoshopSchema.getTransmissionReferenceProperty());
    assertNull(actualPhotoshopSchema.getAncestorIDProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualPhotoshopSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualPhotoshopSchema.getAllProperties().isEmpty());
    assertTrue(actualPhotoshopSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/photoshop/1.0/"));
    assertSame(metadata, actualPhotoshopSchema.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorIDProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  @DisplayName("Test getAncestorIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URIType PhotoshopSchema.getAncestorIDProperty()"})
  void testGetAncestorIDProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorIDProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorIDProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  @DisplayName("Test getAncestorIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URIType PhotoshopSchema.getAncestorIDProperty()"})
  void testGetAncestorIDProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorIDProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorIDProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorIDProperty()}
   */
  @Test
  @DisplayName(
      "Test getAncestorIDProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URIType PhotoshopSchema.getAncestorIDProperty()"})
  void testGetAncestorIDProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getAncestorIDProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorID()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  @DisplayName("Test getAncestorID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAncestorID()"})
  void testGetAncestorID() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorID());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorID()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  @DisplayName("Test getAncestorID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAncestorID()"})
  void testGetAncestorID2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act and Assert
    assertNull(photoshopSchema.getAncestorID());
  }

  /**
   * Test {@link PhotoshopSchema#getAncestorID()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getAncestorID()}
   */
  @Test
  @DisplayName(
      "Test getAncestorID(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAncestorID()"})
  void testGetAncestorID_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getAncestorID());
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorID(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  @DisplayName("Test setAncestorID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorID(String)"})
  void testSetAncestorID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(1));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorID(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  @DisplayName("Test setAncestorID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorID(String)"})
  void testSetAncestorID2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ANCESTORID);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorID(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  @DisplayName("Test setAncestorID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorID(String)"})
  void testSetAncestorID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.ANCESTORID, "42");

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(0));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorID(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorID(String)}
   */
  @Test
  @DisplayName(
      "Test setAncestorID(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorID(String)"})
  void testSetAncestorID_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setAncestorID("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAncestorID());
    URIType ancestorIDProperty = photoshopSchema.getAncestorIDProperty();
    assertEquals("Text", ancestorIDProperty.getStringValue());
    assertEquals("Text", ancestorIDProperty.getRawValue());
    assertEquals("Text", ancestorIDProperty.getValue());
    assertEquals("photoshop", ancestorIDProperty.getPrefix());
    assertNull(ancestorIDProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(ancestorIDProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ANCESTORID, ancestorIDProperty.getPropertyName());
    assertSame(ancestorIDProperty, allProperties.get(0));
    assertSame(metadata, ancestorIDProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorIDProperty(URIType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setAncestorIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorIDProperty(URIType)"})
  void testSetAncestorIDProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    URIType text =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorIDProperty(URIType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setAncestorIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorIDProperty(URIType)"})
  void testSetAncestorIDProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    URIType text =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorIDProperty(URIType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setAncestorIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorIDProperty(URIType)"})
  void testSetAncestorIDProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    URIType text =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setAncestorIDProperty(URIType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAncestorIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setAncestorIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAncestorIDProperty(URIType)"})
  void testSetAncestorIDProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    URIType text =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAncestorIDProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPositionProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  @DisplayName("Test getAuthorsPositionProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getAuthorsPositionProperty()"})
  void testGetAuthorsPositionProperty() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getAuthorsPositionProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPositionProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  @DisplayName("Test getAuthorsPositionProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getAuthorsPositionProperty()"})
  void testGetAuthorsPositionProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPositionProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPositionProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPositionProperty()}
   */
  @Test
  @DisplayName("Test getAuthorsPositionProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getAuthorsPositionProperty()"})
  void testGetAuthorsPositionProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPositionProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPosition()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  @DisplayName("Test getAuthorsPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAuthorsPosition()"})
  void testGetAuthorsPosition() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPosition());
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPosition()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  @DisplayName("Test getAuthorsPosition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAuthorsPosition()"})
  void testGetAuthorsPosition2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act and Assert
    assertNull(photoshopSchema.getAuthorsPosition());
  }

  /**
   * Test {@link PhotoshopSchema#getAuthorsPosition()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getAuthorsPosition()}
   */
  @Test
  @DisplayName(
      "Test getAuthorsPosition(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getAuthorsPosition()"})
  void testGetAuthorsPosition_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getAuthorsPosition());
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPosition(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  @DisplayName("Test setAuthorsPosition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPosition(String)"})
  void testSetAuthorsPosition() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(1));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPosition(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  @DisplayName("Test setAuthorsPosition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPosition(String)"})
  void testSetAuthorsPosition2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.AUTHORS_POSITION);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPosition(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  @DisplayName("Test setAuthorsPosition(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPosition(String)"})
  void testSetAuthorsPosition3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.AUTHORS_POSITION, "42");

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(0));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPosition(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPosition(String)}
   */
  @Test
  @DisplayName(
      "Test setAuthorsPosition(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPosition(String)"})
  void testSetAuthorsPosition_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setAuthorsPosition("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getAuthorsPosition());
    TextType authorsPositionProperty = photoshopSchema.getAuthorsPositionProperty();
    assertEquals("Text", authorsPositionProperty.getStringValue());
    assertEquals("Text", authorsPositionProperty.getRawValue());
    assertEquals("Text", authorsPositionProperty.getValue());
    assertEquals("photoshop", authorsPositionProperty.getPrefix());
    assertNull(authorsPositionProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(authorsPositionProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.AUTHORS_POSITION, authorsPositionProperty.getPropertyName());
    assertSame(authorsPositionProperty, allProperties.get(0));
    assertSame(metadata, authorsPositionProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAuthorsPositionProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPositionProperty(TextType)"})
  void testSetAuthorsPositionProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAuthorsPositionProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPositionProperty(TextType)"})
  void testSetAuthorsPositionProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAuthorsPositionProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPositionProperty(TextType)"})
  void testSetAuthorsPositionProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setAuthorsPositionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setAuthorsPositionProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setAuthorsPositionProperty(TextType)"})
  void testSetAuthorsPositionProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setAuthorsPositionProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriterProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  @DisplayName("Test getCaptionWriterProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCaptionWriterProperty()"})
  void testGetCaptionWriterProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriterProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriterProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  @DisplayName("Test getCaptionWriterProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCaptionWriterProperty()"})
  void testGetCaptionWriterProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriterProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriterProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriterProperty()}
   */
  @Test
  @DisplayName(
      "Test getCaptionWriterProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCaptionWriterProperty()"})
  void testGetCaptionWriterProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCaptionWriterProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriter()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  @DisplayName("Test getCaptionWriter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCaptionWriter()"})
  void testGetCaptionWriter() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriter());
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriter()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  @DisplayName("Test getCaptionWriter()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCaptionWriter()"})
  void testGetCaptionWriter2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act and Assert
    assertNull(photoshopSchema.getCaptionWriter());
  }

  /**
   * Test {@link PhotoshopSchema#getCaptionWriter()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCaptionWriter()}
   */
  @Test
  @DisplayName(
      "Test getCaptionWriter(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCaptionWriter()"})
  void testGetCaptionWriter_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCaptionWriter());
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriter(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  @DisplayName("Test setCaptionWriter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriter(String)"})
  void testSetCaptionWriter() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriter(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  @DisplayName("Test setCaptionWriter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriter(String)"})
  void testSetCaptionWriter2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CAPTION_WRITER);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriter(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  @DisplayName("Test setCaptionWriter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriter(String)"})
  void testSetCaptionWriter3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CAPTION_WRITER, "42");

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriter(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriter(String)}
   */
  @Test
  @DisplayName(
      "Test setCaptionWriter(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriter(String)"})
  void testSetCaptionWriter_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCaptionWriter("Text");

    // Assert
    TextType captionWriterProperty = photoshopSchema.getCaptionWriterProperty();
    assertTrue(captionWriterProperty instanceof ProperNameType);
    assertEquals("Text", photoshopSchema.getCaptionWriter());
    assertEquals("Text", captionWriterProperty.getStringValue());
    assertEquals("Text", captionWriterProperty.getRawValue());
    assertEquals("Text", captionWriterProperty.getValue());
    assertEquals("photoshop", captionWriterProperty.getPrefix());
    assertNull(captionWriterProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(captionWriterProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CAPTION_WRITER, captionWriterProperty.getPropertyName());
    assertSame(metadata, captionWriterProperty.getMetadata());
    assertSame(captionWriterProperty, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  @DisplayName("Test setCaptionWriterProperty(ProperNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriterProperty(ProperNameType)"})
  void testSetCaptionWriterProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    ProperNameType text =
        new ProperNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  @DisplayName("Test setCaptionWriterProperty(ProperNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriterProperty(ProperNameType)"})
  void testSetCaptionWriterProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text =
        new ProperNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  @DisplayName("Test setCaptionWriterProperty(ProperNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriterProperty(ProperNameType)"})
  void testSetCaptionWriterProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text =
        new ProperNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCaptionWriterProperty(ProperNameType)}
   */
  @Test
  @DisplayName("Test setCaptionWriterProperty(ProperNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCaptionWriterProperty(ProperNameType)"})
  void testSetCaptionWriterProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    ProperNameType text =
        new ProperNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCaptionWriterProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getCategoryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  @DisplayName("Test getCategoryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCategoryProperty()"})
  void testGetCategoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCategoryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  @DisplayName("Test getCategoryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCategoryProperty()"})
  void testGetCategoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCategoryProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategoryProperty()}
   */
  @Test
  @DisplayName(
      "Test getCategoryProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCategoryProperty()"})
  void testGetCategoryProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCategoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCategory()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  @DisplayName("Test getCategory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCategory()"})
  void testGetCategory() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategory());
  }

  /**
   * Test {@link PhotoshopSchema#getCategory()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  @DisplayName("Test getCategory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCategory()"})
  void testGetCategory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act and Assert
    assertNull(photoshopSchema.getCategory());
  }

  /**
   * Test {@link PhotoshopSchema#getCategory()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCategory()}
   */
  @Test
  @DisplayName(
      "Test getCategory(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCategory()"})
  void testGetCategory_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCategory());
  }

  /**
   * Test {@link PhotoshopSchema#setCategory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  @DisplayName("Test setCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategory(String)"})
  void testSetCategory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(1));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCategory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  @DisplayName("Test setCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategory(String)"})
  void testSetCategory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CATEGORY);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setCategory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  @DisplayName("Test setCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategory(String)"})
  void testSetCategory3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CATEGORY, "42");

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(0));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCategory(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategory(String)}
   */
  @Test
  @DisplayName(
      "Test setCategory(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategory(String)"})
  void testSetCategory_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCategory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCategory());
    TextType categoryProperty = photoshopSchema.getCategoryProperty();
    assertEquals("Text", categoryProperty.getStringValue());
    assertEquals("Text", categoryProperty.getRawValue());
    assertEquals("Text", categoryProperty.getValue());
    assertEquals("photoshop", categoryProperty.getPrefix());
    assertNull(categoryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(categoryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CATEGORY, categoryProperty.getPropertyName());
    assertSame(categoryProperty, allProperties.get(0));
    assertSame(metadata, categoryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCategoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCategoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategoryProperty(TextType)"})
  void testSetCategoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCategoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCategoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategoryProperty(TextType)"})
  void testSetCategoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCategoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCategoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategoryProperty(TextType)"})
  void testSetCategoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setCategoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCategoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCategoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCategoryProperty(TextType)"})
  void testSetCategoryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCategoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getCityProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  @DisplayName("Test getCityProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCityProperty()"})
  void testGetCityProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCityProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCityProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  @DisplayName("Test getCityProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCityProperty()"})
  void testGetCityProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCityProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCityProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCityProperty()}
   */
  @Test
  @DisplayName(
      "Test getCityProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCityProperty()"})
  void testGetCityProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCityProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCity()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCity()"})
  void testGetCity() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCity());
  }

  /**
   * Test {@link PhotoshopSchema#getCity()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  @DisplayName("Test getCity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCity()"})
  void testGetCity2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act and Assert
    assertNull(photoshopSchema.getCity());
  }

  /**
   * Test {@link PhotoshopSchema#getCity()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCity()}
   */
  @Test
  @DisplayName(
      "Test getCity(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCity()"})
  void testGetCity_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCity());
  }

  /**
   * Test {@link PhotoshopSchema#setCity(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  @DisplayName("Test setCity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCity(String)"})
  void testSetCity() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(1));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCity(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  @DisplayName("Test setCity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCity(String)"})
  void testSetCity2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CITY);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setCity(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  @DisplayName("Test setCity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCity(String)"})
  void testSetCity3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CITY, "42");

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(0));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCity(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setCity(String)}
   */
  @Test
  @DisplayName(
      "Test setCity(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCity(String)"})
  void testSetCity_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCity("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCity());
    TextType cityProperty = photoshopSchema.getCityProperty();
    assertEquals("Text", cityProperty.getStringValue());
    assertEquals("Text", cityProperty.getRawValue());
    assertEquals("Text", cityProperty.getValue());
    assertEquals("photoshop", cityProperty.getPrefix());
    assertNull(cityProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(cityProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CITY, cityProperty.getPropertyName());
    assertSame(cityProperty, allProperties.get(0));
    assertSame(metadata, cityProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCityProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCityProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCityProperty(TextType)"})
  void testSetCityProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCityProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCityProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCityProperty(TextType)"})
  void testSetCityProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCityProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCityProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCityProperty(TextType)"})
  void testSetCityProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setCityProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCityProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCityProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCityProperty(TextType)"})
  void testSetCityProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCityProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getColorModeProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  @DisplayName("Test getColorModeProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getColorModeProperty()"})
  void testGetColorModeProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorModeProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getColorModeProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  @DisplayName("Test getColorModeProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getColorModeProperty()"})
  void testGetColorModeProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorModeProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getColorModeProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorModeProperty()}
   */
  @Test
  @DisplayName(
      "Test getColorModeProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getColorModeProperty()"})
  void testGetColorModeProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getColorModeProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getColorMode()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  @DisplayName("Test getColorMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getColorMode()"})
  void testGetColorMode() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorMode());
  }

  /**
   * Test {@link PhotoshopSchema#getColorMode()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  @DisplayName("Test getColorMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getColorMode()"})
  void testGetColorMode2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COLOR_MODE);

    // Act and Assert
    assertNull(photoshopSchema.getColorMode());
  }

  /**
   * Test {@link PhotoshopSchema#getColorMode()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getColorMode()}
   */
  @Test
  @DisplayName(
      "Test getColorMode(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getColorMode()"})
  void testGetColorMode_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getColorMode());
  }

  /**
   * Test {@link PhotoshopSchema#setColorMode(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  @DisplayName("Test setColorMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorMode(String)"})
  void testSetColorMode() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(0));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setColorMode(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  @DisplayName("Test setColorMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorMode(String)"})
  void testSetColorMode2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(1));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setColorMode(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  @DisplayName("Test setColorMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorMode(String)"})
  void testSetColorMode3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.COLOR_MODE, PhotoshopSchema.COLOR_MODE);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setColorMode(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorMode(String)}
   */
  @Test
  @DisplayName("Test setColorMode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorMode(String)"})
  void testSetColorMode4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.COLOR_MODE, "42");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setColorMode("42");

    // Assert
    IntegerType colorModeProperty = photoshopSchema.getColorModeProperty();
    assertEquals("42", colorModeProperty.getStringValue());
    assertEquals("42", colorModeProperty.getRawValue());
    assertEquals("photoshop", colorModeProperty.getPrefix());
    assertNull(colorModeProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getColorMode().intValue());
    assertEquals(42, colorModeProperty.getValue().intValue());
    assertTrue(colorModeProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COLOR_MODE, colorModeProperty.getPropertyName());
    assertSame(colorModeProperty, allProperties.get(1));
    assertSame(metadata, colorModeProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setColorModeProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setColorModeProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorModeProperty(IntegerType)"})
  void testSetColorModeProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setColorModeProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setColorModeProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorModeProperty(IntegerType)"})
  void testSetColorModeProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setColorModeProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setColorModeProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorModeProperty(IntegerType)"})
  void testSetColorModeProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setColorModeProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setColorModeProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setColorModeProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setColorModeProperty(IntegerType)"})
  void testSetColorModeProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setColorModeProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
  }

  /**
   * Test {@link PhotoshopSchema#getCountryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  @DisplayName("Test getCountryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCountryProperty()"})
  void testGetCountryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCountryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  @DisplayName("Test getCountryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCountryProperty()"})
  void testGetCountryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCountryProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountryProperty()}
   */
  @Test
  @DisplayName(
      "Test getCountryProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCountryProperty()"})
  void testGetCountryProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCountryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCountry()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCountry()"})
  void testGetCountry() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountry());
  }

  /**
   * Test {@link PhotoshopSchema#getCountry()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  @DisplayName("Test getCountry()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCountry()"})
  void testGetCountry2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act and Assert
    assertNull(photoshopSchema.getCountry());
  }

  /**
   * Test {@link PhotoshopSchema#getCountry()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCountry()}
   */
  @Test
  @DisplayName(
      "Test getCountry(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCountry()"})
  void testGetCountry_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCountry());
  }

  /**
   * Test {@link PhotoshopSchema#setCountry(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  @DisplayName("Test setCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountry(String)"})
  void testSetCountry() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(1));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCountry(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  @DisplayName("Test setCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountry(String)"})
  void testSetCountry2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.COUNTRY);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setCountry(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  @DisplayName("Test setCountry(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountry(String)"})
  void testSetCountry3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.COUNTRY, "42");

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(0));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCountry(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountry(String)}
   */
  @Test
  @DisplayName(
      "Test setCountry(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountry(String)"})
  void testSetCountry_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCountry("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCountry());
    TextType countryProperty = photoshopSchema.getCountryProperty();
    assertEquals("Text", countryProperty.getStringValue());
    assertEquals("Text", countryProperty.getRawValue());
    assertEquals("Text", countryProperty.getValue());
    assertEquals("photoshop", countryProperty.getPrefix());
    assertNull(countryProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(countryProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.COUNTRY, countryProperty.getPropertyName());
    assertSame(countryProperty, allProperties.get(0));
    assertSame(metadata, countryProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCountryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCountryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountryProperty(TextType)"})
  void testSetCountryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCountryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCountryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountryProperty(TextType)"})
  void testSetCountryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCountryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCountryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountryProperty(TextType)"})
  void testSetCountryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setCountryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCountryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCountryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCountryProperty(TextType)"})
  void testSetCountryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCountryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getCreditProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  @DisplayName("Test getCreditProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCreditProperty()"})
  void testGetCreditProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCreditProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCreditProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  @DisplayName("Test getCreditProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCreditProperty()"})
  void testGetCreditProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCreditProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCreditProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCreditProperty()}
   */
  @Test
  @DisplayName(
      "Test getCreditProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getCreditProperty()"})
  void testGetCreditProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCreditProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getCredit()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  @DisplayName("Test getCredit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCredit()"})
  void testGetCredit() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCredit());
  }

  /**
   * Test {@link PhotoshopSchema#getCredit()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  @DisplayName("Test getCredit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCredit()"})
  void testGetCredit2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act and Assert
    assertNull(photoshopSchema.getCredit());
  }

  /**
   * Test {@link PhotoshopSchema#getCredit()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getCredit()}
   */
  @Test
  @DisplayName(
      "Test getCredit(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getCredit()"})
  void testGetCredit_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getCredit());
  }

  /**
   * Test {@link PhotoshopSchema#setCredit(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  @DisplayName("Test setCredit(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCredit(String)"})
  void testSetCredit() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(1));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCredit(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  @DisplayName("Test setCredit(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCredit(String)"})
  void testSetCredit2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.CREDIT);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setCredit(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  @DisplayName("Test setCredit(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCredit(String)"})
  void testSetCredit3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.CREDIT, "42");

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(0));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCredit(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setCredit(String)}
   */
  @Test
  @DisplayName(
      "Test setCredit(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCredit(String)"})
  void testSetCredit_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setCredit("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getCredit());
    TextType creditProperty = photoshopSchema.getCreditProperty();
    assertEquals("Text", creditProperty.getStringValue());
    assertEquals("Text", creditProperty.getRawValue());
    assertEquals("Text", creditProperty.getValue());
    assertEquals("photoshop", creditProperty.getPrefix());
    assertNull(creditProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(creditProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.CREDIT, creditProperty.getPropertyName());
    assertSame(creditProperty, allProperties.get(0));
    assertSame(metadata, creditProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setCreditProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCreditProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCreditProperty(TextType)"})
  void testSetCreditProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setCreditProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCreditProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCreditProperty(TextType)"})
  void testSetCreditProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setCreditProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCreditProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCreditProperty(TextType)"})
  void testSetCreditProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setCreditProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setCreditProperty(TextType)}
   */
  @Test
  @DisplayName("Test setCreditProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setCreditProperty(TextType)"})
  void testSetCreditProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setCreditProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreatedProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  @DisplayName("Test getDateCreatedProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType PhotoshopSchema.getDateCreatedProperty()"})
  void testGetDateCreatedProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreatedProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreatedProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  @DisplayName("Test getDateCreatedProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType PhotoshopSchema.getDateCreatedProperty()"})
  void testGetDateCreatedProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreatedProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreatedProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreatedProperty()}
   */
  @Test
  @DisplayName(
      "Test getDateCreatedProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DateType PhotoshopSchema.getDateCreatedProperty()"})
  void testGetDateCreatedProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getDateCreatedProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreated()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  @DisplayName("Test getDateCreated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getDateCreated()"})
  void testGetDateCreated() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreated());
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreated()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  @DisplayName("Test getDateCreated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getDateCreated()"})
  void testGetDateCreated2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act and Assert
    assertNull(photoshopSchema.getDateCreated());
  }

  /**
   * Test {@link PhotoshopSchema#getDateCreated()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDateCreated()}
   */
  @Test
  @DisplayName(
      "Test getDateCreated(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getDateCreated()"})
  void testGetDateCreated_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getDateCreated());
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreated(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreated(String)}
   */
  @Test
  @DisplayName("Test setDateCreated(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreated(String)"})
  void testSetDateCreated() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setDateCreated("");

    // Assert
    DateType dateCreatedProperty = photoshopSchema.getDateCreatedProperty();
    assertEquals("", dateCreatedProperty.getRawValue());
    assertEquals("photoshop", dateCreatedProperty.getPrefix());
    assertNull(dateCreatedProperty.getNamespace());
    assertNull(dateCreatedProperty.getValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(dateCreatedProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.DATE_CREATED, dateCreatedProperty.getPropertyName());
    assertSame(dateCreatedProperty, allProperties.get(0));
    assertSame(metadata, dateCreatedProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreated(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreated(String)}
   */
  @Test
  @DisplayName("Test setDateCreated(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreated(String)"})
  void testSetDateCreated2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act
    photoshopSchema.setDateCreated("");

    // Assert
    DateType dateCreatedProperty = photoshopSchema.getDateCreatedProperty();
    assertEquals("", dateCreatedProperty.getRawValue());
    assertEquals("photoshop", dateCreatedProperty.getPrefix());
    assertNull(dateCreatedProperty.getNamespace());
    assertNull(dateCreatedProperty.getValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(dateCreatedProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.DATE_CREATED, dateCreatedProperty.getPropertyName());
    assertSame(dateCreatedProperty, allProperties.get(1));
    assertSame(metadata, dateCreatedProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreated(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreated(String)}
   */
  @Test
  @DisplayName("Test setDateCreated(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreated(String)"})
  void testSetDateCreated3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.DATE_CREATED, "42");

    // Act
    photoshopSchema.setDateCreated("");

    // Assert
    DateType dateCreatedProperty = photoshopSchema.getDateCreatedProperty();
    assertEquals("", dateCreatedProperty.getRawValue());
    assertEquals("photoshop", dateCreatedProperty.getPrefix());
    assertNull(dateCreatedProperty.getNamespace());
    assertNull(dateCreatedProperty.getValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(dateCreatedProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.DATE_CREATED, dateCreatedProperty.getPropertyName());
    assertSame(dateCreatedProperty, allProperties.get(0));
    assertSame(metadata, dateCreatedProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreated(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreated(String)}
   */
  @Test
  @DisplayName("Test setDateCreated(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreated(String)"})
  void testSetDateCreated4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DATE_CREATED);

    // Act
    photoshopSchema.setDateCreated("");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreatedProperty(DateType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  @DisplayName("Test setDateCreatedProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreatedProperty(DateType)"})
  void testSetDateCreatedProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    DateType text =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreatedProperty(DateType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  @DisplayName("Test setDateCreatedProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreatedProperty(DateType)"})
  void testSetDateCreatedProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreatedProperty(DateType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  @DisplayName("Test setDateCreatedProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreatedProperty(DateType)"})
  void testSetDateCreatedProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setDateCreatedProperty(DateType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setDateCreatedProperty(DateType)}
   */
  @Test
  @DisplayName("Test setDateCreatedProperty(DateType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setDateCreatedProperty(DateType)"})
  void testSetDateCreatedProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    DateType text =
        new DateType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "");

    // Act
    photoshopSchema.setDateCreatedProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
  }

  /**
   * Test {@link PhotoshopSchema#addDocumentAncestors(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  @DisplayName("Test addDocumentAncestors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addDocumentAncestors(String)"})
  void testAddDocumentAncestors() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, documentAncestorsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties.get(0));
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#addDocumentAncestors(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  @DisplayName("Test addDocumentAncestors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addDocumentAncestors(String)"})
  void testAddDocumentAncestors2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(2, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(1));
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertEquals(1, photoshopSchema.getAllProperties().size());
    assertEquals(2, documentAncestorsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestors.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#addDocumentAncestors(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  @DisplayName("Test addDocumentAncestors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addDocumentAncestors(String)"})
  void testAddDocumentAncestors3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers("li", "li");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(2, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(1));
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertEquals(2, photoshopSchema.getAllProperties().size());
    assertEquals(2, documentAncestorsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestors.get(0));
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#addDocumentAncestors(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  @DisplayName("Test addDocumentAncestors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addDocumentAncestors(String)"})
  void testAddDocumentAncestors4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertEquals(1, documentAncestorsProperty.getAllProperties().size());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties.get(1));
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#addDocumentAncestors(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addDocumentAncestors(String)}
   */
  @Test
  @DisplayName("Test addDocumentAncestors(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addDocumentAncestors(String)"})
  void testAddDocumentAncestors5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple("Simple Name", "42");
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.addDocumentAncestors("Text");

    // Assert
    List<String> documentAncestors = photoshopSchema.getDocumentAncestors();
    assertEquals(1, documentAncestors.size());
    assertEquals("Text", documentAncestors.get(0));
    ArrayProperty documentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();
    assertEquals("http://ns.adobe.com/photoshop/1.0/", documentAncestorsProperty.getNamespace());
    assertEquals("photoshop", documentAncestorsProperty.getPrefix());
    assertEquals(1, documentAncestorsProperty.getAllProperties().size());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertEquals(Cardinality.Bag, documentAncestorsProperty.getArrayType());
    assertTrue(documentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(documentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(documentAncestors, documentAncestorsProperty.getElementsAsString());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, documentAncestorsProperty.getPropertyName());
    assertSame(documentAncestorsProperty, allProperties.get(2));
    assertSame(metadata, documentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestorsProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  @DisplayName("Test getDocumentAncestorsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty PhotoshopSchema.getDocumentAncestorsProperty()"})
  void testGetDocumentAncestorsProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    ArrayProperty actualDocumentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();

    // Assert
    assertEquals(
        "http://ns.adobe.com/photoshop/1.0/", actualDocumentAncestorsProperty.getNamespace());
    assertEquals("photoshop", actualDocumentAncestorsProperty.getPrefix());
    assertEquals(1, actualDocumentAncestorsProperty.getAllProperties().size());
    assertEquals(1, actualDocumentAncestorsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualDocumentAncestorsProperty.getArrayType());
    assertTrue(actualDocumentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(
        PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestorsProperty.getPropertyName());
    assertSame(metadata, actualDocumentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestorsProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/photoshop/1.0/}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  @DisplayName(
      "Test getDocumentAncestorsProperty(); then return Namespace is 'http://ns.adobe.com/photoshop/1.0/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty PhotoshopSchema.getDocumentAncestorsProperty()"})
  void testGetDocumentAncestorsProperty_thenReturnNamespaceIsHttpNsAdobeComPhotoshop10() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    ArrayProperty actualDocumentAncestorsProperty = photoshopSchema.getDocumentAncestorsProperty();

    // Assert
    assertEquals(
        "http://ns.adobe.com/photoshop/1.0/", actualDocumentAncestorsProperty.getNamespace());
    assertEquals("photoshop", actualDocumentAncestorsProperty.getPrefix());
    assertEquals(1, actualDocumentAncestorsProperty.getAllProperties().size());
    assertEquals(1, actualDocumentAncestorsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualDocumentAncestorsProperty.getArrayType());
    assertTrue(actualDocumentAncestorsProperty.getAllAttributes().isEmpty());
    assertTrue(actualDocumentAncestorsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(
        PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestorsProperty.getPropertyName());
    assertSame(metadata, actualDocumentAncestorsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestorsProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestorsProperty()}
   */
  @Test
  @DisplayName("Test getDocumentAncestorsProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty PhotoshopSchema.getDocumentAncestorsProperty()"})
  void testGetDocumentAncestorsProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getDocumentAncestorsProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestors()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  @DisplayName("Test getDocumentAncestors()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getDocumentAncestors()"})
  void testGetDocumentAncestors() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    List<String> actualDocumentAncestors = photoshopSchema.getDocumentAncestors();

    // Assert
    assertEquals(1, actualDocumentAncestors.size());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestors.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestors()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  @DisplayName("Test getDocumentAncestors(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getDocumentAncestors()"})
  void testGetDocumentAncestors_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getDocumentAncestors());
  }

  /**
   * Test {@link PhotoshopSchema#getDocumentAncestors()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getDocumentAncestors()}
   */
  @Test
  @DisplayName("Test getDocumentAncestors(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getDocumentAncestors()"})
  void testGetDocumentAncestors_thenReturnSizeIsOne() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    List<String> actualDocumentAncestors = photoshopSchema.getDocumentAncestors();

    // Assert
    assertEquals(1, actualDocumentAncestors.size());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, actualDocumentAncestors.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#getHeadlineProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  @DisplayName("Test getHeadlineProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHeadlineProperty()"})
  void testGetHeadlineProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadlineProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHeadlineProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  @DisplayName("Test getHeadlineProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHeadlineProperty()"})
  void testGetHeadlineProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadlineProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHeadlineProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadlineProperty()}
   */
  @Test
  @DisplayName(
      "Test getHeadlineProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHeadlineProperty()"})
  void testGetHeadlineProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getHeadlineProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHeadline()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  @DisplayName("Test getHeadline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHeadline()"})
  void testGetHeadline() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadline());
  }

  /**
   * Test {@link PhotoshopSchema#getHeadline()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  @DisplayName("Test getHeadline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHeadline()"})
  void testGetHeadline2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act and Assert
    assertNull(photoshopSchema.getHeadline());
  }

  /**
   * Test {@link PhotoshopSchema#getHeadline()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getHeadline()}
   */
  @Test
  @DisplayName(
      "Test getHeadline(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHeadline()"})
  void testGetHeadline_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getHeadline());
  }

  /**
   * Test {@link PhotoshopSchema#setHeadline(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  @DisplayName("Test setHeadline(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadline(String)"})
  void testSetHeadline() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(1));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHeadline(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  @DisplayName("Test setHeadline(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadline(String)"})
  void testSetHeadline2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HEADLINE);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setHeadline(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  @DisplayName("Test setHeadline(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadline(String)"})
  void testSetHeadline3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.HEADLINE, "42");

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(0));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHeadline(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadline(String)}
   */
  @Test
  @DisplayName(
      "Test setHeadline(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadline(String)"})
  void testSetHeadline_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setHeadline("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHeadline());
    TextType headlineProperty = photoshopSchema.getHeadlineProperty();
    assertEquals("Text", headlineProperty.getStringValue());
    assertEquals("Text", headlineProperty.getRawValue());
    assertEquals("Text", headlineProperty.getValue());
    assertEquals("photoshop", headlineProperty.getPrefix());
    assertNull(headlineProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(headlineProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HEADLINE, headlineProperty.getPropertyName());
    assertSame(headlineProperty, allProperties.get(0));
    assertSame(metadata, headlineProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHeadlineProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHeadlineProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadlineProperty(TextType)"})
  void testSetHeadlineProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setHeadlineProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHeadlineProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadlineProperty(TextType)"})
  void testSetHeadlineProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setHeadlineProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHeadlineProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadlineProperty(TextType)"})
  void testSetHeadlineProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setHeadlineProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHeadlineProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHeadlineProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHeadlineProperty(TextType)"})
  void testSetHeadlineProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHeadlineProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getHistoryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName("Test getHistoryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHistoryProperty()"})
  void testGetHistoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHistoryProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName("Test getHistoryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHistoryProperty()"})
  void testGetHistoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHistoryProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName(
      "Test getHistoryProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getHistoryProperty()"})
  void testGetHistoryProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getHistoryProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getHistory()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  @DisplayName("Test getHistory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHistory()"})
  void testGetHistory() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistory());
  }

  /**
   * Test {@link PhotoshopSchema#getHistory()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  @DisplayName("Test getHistory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHistory()"})
  void testGetHistory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act and Assert
    assertNull(photoshopSchema.getHistory());
  }

  /**
   * Test {@link PhotoshopSchema#getHistory()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getHistory()}
   */
  @Test
  @DisplayName(
      "Test getHistory(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getHistory()"})
  void testGetHistory_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getHistory());
  }

  /**
   * Test {@link PhotoshopSchema#setHistory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  @DisplayName("Test setHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistory(String)"})
  void testSetHistory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(1));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHistory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  @DisplayName("Test setHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistory(String)"})
  void testSetHistory2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.HISTORY);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setHistory(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  @DisplayName("Test setHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistory(String)"})
  void testSetHistory3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.HISTORY, "42");

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(0));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHistory(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistory(String)}
   */
  @Test
  @DisplayName(
      "Test setHistory(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistory(String)"})
  void testSetHistory_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setHistory("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getHistory());
    TextType historyProperty = photoshopSchema.getHistoryProperty();
    assertEquals("Text", historyProperty.getStringValue());
    assertEquals("Text", historyProperty.getRawValue());
    assertEquals("Text", historyProperty.getValue());
    assertEquals("photoshop", historyProperty.getPrefix());
    assertNull(historyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(0));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setHistoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHistoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistoryProperty(TextType)"})
  void testSetHistoryProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setHistoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHistoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistoryProperty(TextType)"})
  void testSetHistoryProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setHistoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHistoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistoryProperty(TextType)"})
  void testSetHistoryProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setHistoryProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setHistoryProperty(TextType)}
   */
  @Test
  @DisplayName("Test setHistoryProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setHistoryProperty(TextType)"})
  void testSetHistoryProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setHistoryProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfileProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  @DisplayName("Test getICCProfileProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getICCProfileProperty()"})
  void testGetICCProfileProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfileProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfileProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  @DisplayName("Test getICCProfileProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getICCProfileProperty()"})
  void testGetICCProfileProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfileProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfileProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfileProperty()}
   */
  @Test
  @DisplayName(
      "Test getICCProfileProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getICCProfileProperty()"})
  void testGetICCProfileProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getICCProfileProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfile()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  @DisplayName("Test getICCProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getICCProfile()"})
  void testGetICCProfile() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfile());
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfile()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  @DisplayName("Test getICCProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getICCProfile()"})
  void testGetICCProfile2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act and Assert
    assertNull(photoshopSchema.getICCProfile());
  }

  /**
   * Test {@link PhotoshopSchema#getICCProfile()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getICCProfile()}
   */
  @Test
  @DisplayName(
      "Test getICCProfile(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getICCProfile()"})
  void testGetICCProfile_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getICCProfile());
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfile(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  @DisplayName("Test setICCProfile(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfile(String)"})
  void testSetICCProfile() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(1));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfile(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  @DisplayName("Test setICCProfile(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfile(String)"})
  void testSetICCProfile2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.ICC_PROFILE);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfile(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  @DisplayName("Test setICCProfile(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfile(String)"})
  void testSetICCProfile3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.ICC_PROFILE, "42");

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(0));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfile(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfile(String)}
   */
  @Test
  @DisplayName(
      "Test setICCProfile(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfile(String)"})
  void testSetICCProfile_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setICCProfile("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getICCProfile());
    TextType iCCProfileProperty = photoshopSchema.getICCProfileProperty();
    assertEquals("Text", iCCProfileProperty.getStringValue());
    assertEquals("Text", iCCProfileProperty.getRawValue());
    assertEquals("Text", iCCProfileProperty.getValue());
    assertEquals("photoshop", iCCProfileProperty.getPrefix());
    assertNull(iCCProfileProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(iCCProfileProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.ICC_PROFILE, iCCProfileProperty.getPropertyName());
    assertSame(iCCProfileProperty, allProperties.get(0));
    assertSame(metadata, iCCProfileProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfileProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  @DisplayName("Test setICCProfileProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfileProperty(TextType)"})
  void testSetICCProfileProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfileProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  @DisplayName("Test setICCProfileProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfileProperty(TextType)"})
  void testSetICCProfileProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfileProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  @DisplayName("Test setICCProfileProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfileProperty(TextType)"})
  void testSetICCProfileProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setICCProfileProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setICCProfileProperty(TextType)}
   */
  @Test
  @DisplayName("Test setICCProfileProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setICCProfileProperty(TextType)"})
  void testSetICCProfileProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setICCProfileProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getInstructionsProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  @DisplayName("Test getInstructionsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getInstructionsProperty()"})
  void testGetInstructionsProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructionsProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getInstructionsProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  @DisplayName("Test getInstructionsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getInstructionsProperty()"})
  void testGetInstructionsProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructionsProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getInstructionsProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructionsProperty()}
   */
  @Test
  @DisplayName(
      "Test getInstructionsProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getInstructionsProperty()"})
  void testGetInstructionsProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getInstructionsProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getInstructions()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  @DisplayName("Test getInstructions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getInstructions()"})
  void testGetInstructions() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructions());
  }

  /**
   * Test {@link PhotoshopSchema#getInstructions()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  @DisplayName("Test getInstructions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getInstructions()"})
  void testGetInstructions2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act and Assert
    assertNull(photoshopSchema.getInstructions());
  }

  /**
   * Test {@link PhotoshopSchema#getInstructions()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getInstructions()}
   */
  @Test
  @DisplayName(
      "Test getInstructions(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getInstructions()"})
  void testGetInstructions_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getInstructions());
  }

  /**
   * Test {@link PhotoshopSchema#setInstructions(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  @DisplayName("Test setInstructions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructions(String)"})
  void testSetInstructions() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(1));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setInstructions(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  @DisplayName("Test setInstructions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructions(String)"})
  void testSetInstructions2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.INSTRUCTIONS);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setInstructions(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  @DisplayName("Test setInstructions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructions(String)"})
  void testSetInstructions3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.INSTRUCTIONS, "42");

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(0));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setInstructions(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructions(String)}
   */
  @Test
  @DisplayName(
      "Test setInstructions(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructions(String)"})
  void testSetInstructions_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setInstructions("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getInstructions());
    TextType instructionsProperty = photoshopSchema.getInstructionsProperty();
    assertEquals("Text", instructionsProperty.getStringValue());
    assertEquals("Text", instructionsProperty.getRawValue());
    assertEquals("Text", instructionsProperty.getValue());
    assertEquals("photoshop", instructionsProperty.getPrefix());
    assertNull(instructionsProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instructionsProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.INSTRUCTIONS, instructionsProperty.getPropertyName());
    assertSame(instructionsProperty, allProperties.get(0));
    assertSame(metadata, instructionsProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setInstructionsProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setInstructionsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructionsProperty(TextType)"})
  void testSetInstructionsProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setInstructionsProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setInstructionsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructionsProperty(TextType)"})
  void testSetInstructionsProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setInstructionsProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setInstructionsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructionsProperty(TextType)"})
  void testSetInstructionsProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setInstructionsProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setInstructionsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setInstructionsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setInstructionsProperty(TextType)"})
  void testSetInstructionsProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setInstructionsProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getSourceProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  @DisplayName("Test getSourceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSourceProperty()"})
  void testGetSourceProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSourceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSourceProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  @DisplayName("Test getSourceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSourceProperty()"})
  void testGetSourceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSourceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSourceProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getSourceProperty()}
   */
  @Test
  @DisplayName(
      "Test getSourceProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSourceProperty()"})
  void testGetSourceProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getSourceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSource()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSource()"})
  void testGetSource() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSource());
  }

  /**
   * Test {@link PhotoshopSchema#getSource()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  @DisplayName("Test getSource()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSource()"})
  void testGetSource2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act and Assert
    assertNull(photoshopSchema.getSource());
  }

  /**
   * Test {@link PhotoshopSchema#getSource()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getSource()}
   */
  @Test
  @DisplayName(
      "Test getSource(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSource()"})
  void testGetSource_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getSource());
  }

  /**
   * Test {@link PhotoshopSchema#setSource(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSource(String)"})
  void testSetSource() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(1));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSource(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSource(String)"})
  void testSetSource2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SOURCE);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setSource(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  @DisplayName("Test setSource(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSource(String)"})
  void testSetSource3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.SOURCE, "42");

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSource(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setSource(String)}
   */
  @Test
  @DisplayName(
      "Test setSource(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSource(String)"})
  void testSetSource_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setSource("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSource());
    TextType sourceProperty = photoshopSchema.getSourceProperty();
    assertEquals("Text", sourceProperty.getStringValue());
    assertEquals("Text", sourceProperty.getRawValue());
    assertEquals("Text", sourceProperty.getValue());
    assertEquals("photoshop", sourceProperty.getPrefix());
    assertNull(sourceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(sourceProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.SOURCE, sourceProperty.getPropertyName());
    assertSame(sourceProperty, allProperties.get(0));
    assertSame(metadata, sourceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSourceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSourceProperty(TextType)"})
  void testSetSourceProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setSourceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSourceProperty(TextType)"})
  void testSetSourceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setSourceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSourceProperty(TextType)"})
  void testSetSourceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setSourceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSourceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSourceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSourceProperty(TextType)"})
  void testSetSourceProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSourceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getStateProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  @DisplayName("Test getStateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getStateProperty()"})
  void testGetStateProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getStateProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getStateProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  @DisplayName("Test getStateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getStateProperty()"})
  void testGetStateProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getStateProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getStateProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getStateProperty()}
   */
  @Test
  @DisplayName(
      "Test getStateProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getStateProperty()"})
  void testGetStateProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getStateProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getState()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getState()"})
  void testGetState() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getState());
  }

  /**
   * Test {@link PhotoshopSchema#getState()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  @DisplayName("Test getState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getState()"})
  void testGetState2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act and Assert
    assertNull(photoshopSchema.getState());
  }

  /**
   * Test {@link PhotoshopSchema#getState()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getState()}
   */
  @Test
  @DisplayName(
      "Test getState(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getState()"})
  void testGetState_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getState());
  }

  /**
   * Test {@link PhotoshopSchema#setState(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setState(String)"})
  void testSetState() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(1));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setState(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setState(String)"})
  void testSetState2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.STATE);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setState(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  @DisplayName("Test setState(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setState(String)"})
  void testSetState3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.STATE, "42");

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(0));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setState(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setState(String)}
   */
  @Test
  @DisplayName(
      "Test setState(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setState(String)"})
  void testSetState_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setState("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getState());
    TextType stateProperty = photoshopSchema.getStateProperty();
    assertEquals("Text", stateProperty.getStringValue());
    assertEquals("Text", stateProperty.getRawValue());
    assertEquals("Text", stateProperty.getValue());
    assertEquals("photoshop", stateProperty.getPrefix());
    assertNull(stateProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(stateProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.STATE, stateProperty.getPropertyName());
    assertSame(stateProperty, allProperties.get(0));
    assertSame(metadata, stateProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setStateProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  @DisplayName("Test setStateProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setStateProperty(TextType)"})
  void testSetStateProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setStateProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  @DisplayName("Test setStateProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setStateProperty(TextType)"})
  void testSetStateProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setStateProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  @DisplayName("Test setStateProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setStateProperty(TextType)"})
  void testSetStateProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setStateProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setStateProperty(TextType)}
   */
  @Test
  @DisplayName("Test setStateProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setStateProperty(TextType)"})
  void testSetStateProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setStateProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategoriesProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  @DisplayName("Test getSupplementalCategoriesProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSupplementalCategoriesProperty()"})
  void testGetSupplementalCategoriesProperty() {
    // Arrange, Act and Assert
    assertNull(
        new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getSupplementalCategoriesProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategoriesProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  @DisplayName("Test getSupplementalCategoriesProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSupplementalCategoriesProperty()"})
  void testGetSupplementalCategoriesProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategoriesProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategoriesProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategoriesProperty()}
   */
  @Test
  @DisplayName("Test getSupplementalCategoriesProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getSupplementalCategoriesProperty()"})
  void testGetSupplementalCategoriesProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategoriesProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategories()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  @DisplayName("Test getSupplementalCategories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSupplementalCategories()"})
  void testGetSupplementalCategories() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getSupplementalCategories());
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategories()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  @DisplayName("Test getSupplementalCategories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSupplementalCategories()"})
  void testGetSupplementalCategories2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategories());
  }

  /**
   * Test {@link PhotoshopSchema#getSupplementalCategories()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getSupplementalCategories()}
   */
  @Test
  @DisplayName("Test getSupplementalCategories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getSupplementalCategories()"})
  void testGetSupplementalCategories3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act and Assert
    assertNull(photoshopSchema.getSupplementalCategories());
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategories(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  @DisplayName("Test setSupplementalCategories(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategories(String)"})
  void testSetSupplementalCategories() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(0));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategories(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  @DisplayName("Test setSupplementalCategories(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategories(String)"})
  void testSetSupplementalCategories2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(1));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategories(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  @DisplayName("Test setSupplementalCategories(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategories(String)"})
  void testSetSupplementalCategories3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES);

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategories(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategories(String)}
   */
  @Test
  @DisplayName("Test setSupplementalCategories(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategories(String)"})
  void testSetSupplementalCategories4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, "42");

    // Act
    photoshopSchema.setSupplementalCategories("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getSupplementalCategories());
    TextType supplementalCategoriesProperty = photoshopSchema.getSupplementalCategoriesProperty();
    assertEquals("Text", supplementalCategoriesProperty.getStringValue());
    assertEquals("Text", supplementalCategoriesProperty.getRawValue());
    assertEquals("Text", supplementalCategoriesProperty.getValue());
    assertEquals("photoshop", supplementalCategoriesProperty.getPrefix());
    assertNull(supplementalCategoriesProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(supplementalCategoriesProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.SUPPLEMENTAL_CATEGORIES, supplementalCategoriesProperty.getPropertyName());
    assertSame(supplementalCategoriesProperty, allProperties.get(0));
    assertSame(metadata, supplementalCategoriesProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSupplementalCategoriesProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategoriesProperty(TextType)"})
  void testSetSupplementalCategoriesProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSupplementalCategoriesProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategoriesProperty(TextType)"})
  void testSetSupplementalCategoriesProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSupplementalCategoriesProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategoriesProperty(TextType)"})
  void testSetSupplementalCategoriesProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setSupplementalCategoriesProperty(TextType)}
   */
  @Test
  @DisplayName("Test setSupplementalCategoriesProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setSupplementalCategoriesProperty(TextType)"})
  void testSetSupplementalCategoriesProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setSupplementalCategoriesProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#addTextLayers(String, String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  @DisplayName("Test addTextLayers(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addTextLayers(String, String)"})
  void testAddTextLayers() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("photoshop", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#addTextLayers(String, String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  @DisplayName("Test addTextLayers(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addTextLayers(String, String)"})
  void testAddTextLayers2() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.TEXT_LAYERS, PhotoshopSchema.TEXT_LAYERS);

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals(2, photoshopSchema.getTextLayers().size());
  }

  /**
   * Test {@link PhotoshopSchema#addTextLayers(String, String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  @DisplayName("Test addTextLayers(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addTextLayers(String, String)"})
  void testAddTextLayers3() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals(1, photoshopSchema.getTextLayers().size());
  }

  /**
   * Test {@link PhotoshopSchema#addTextLayers(String, String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#addTextLayers(String, String)}
   */
  @Test
  @DisplayName("Test addTextLayers(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.addTextLayers(String, String)"})
  void testAddTextLayers4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors("parseType");
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    List<LayerType> textLayers = photoshopSchema.getTextLayers();
    assertEquals(1, textLayers.size());
    LayerType getResult2 = textLayers.get(0);
    assertEquals("Layer Name", getResult2.getLayerName());
    assertEquals("Layer Text", getResult2.getLayerText());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult2.getNamespace());
    assertEquals("photoshop", getResult2.getPreferedPrefix());
    assertEquals("photoshop", getResult2.getPrefix());
    assertNull(getResult2.getPropertyName());
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, getResult2.getAllAttributes().size());
    assertEquals(2, getResult2.getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult2.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getTextLayers()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  @DisplayName("Test getTextLayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getTextLayers()"})
  void testGetTextLayers() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TEXT_LAYERS, "42");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> photoshopSchema.getTextLayers());
  }

  /**
   * Test {@link PhotoshopSchema#getTextLayers()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  @DisplayName("Test getTextLayers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getTextLayers()"})
  void testGetTextLayers2() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            PhotoshopSchema.TEXT_LAYERS,
            PhotoshopSchema.TEXT_LAYERS,
            PhotoshopSchema.TEXT_LAYERS,
            "Value");
    photoshopSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> photoshopSchema.getTextLayers());
  }

  /**
   * Test {@link PhotoshopSchema#getTextLayers()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  @DisplayName(
      "Test getTextLayers(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getTextLayers()"})
  void testGetTextLayers_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getTextLayers());
  }

  /**
   * Test {@link PhotoshopSchema#getTextLayers()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  @DisplayName("Test getTextLayers(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getTextLayers()"})
  void testGetTextLayers_thenReturnNull() throws BadFieldValueException {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TEXT_LAYERS);

    // Act and Assert
    assertNull(photoshopSchema.getTextLayers());
  }

  /**
   * Test {@link PhotoshopSchema#getTextLayers()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getTextLayers()}
   */
  @Test
  @DisplayName("Test getTextLayers(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PhotoshopSchema.getTextLayers()"})
  void testGetTextLayers_thenReturnSizeIsOne() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TEXT_LAYERS);

    // Act
    List<LayerType> actualTextLayers = photoshopSchema.getTextLayers();

    // Assert
    assertEquals(1, actualTextLayers.size());
    LayerType getResult = actualTextLayers.get(0);
    assertEquals("http://ns.adobe.com/photoshop/1.0/", getResult.getNamespace());
    assertEquals("photoshop", getResult.getPreferedPrefix());
    assertEquals("photoshop", getResult.getPrefix());
    assertNull(getResult.getPropertyName());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(2, getResult.getAllProperties().size());
    assertTrue(getResult.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, getResult.getLayerName());
    assertEquals(PhotoshopSchema.DOCUMENT_ANCESTORS, getResult.getLayerText());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReferenceProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  @DisplayName("Test getTransmissionReferenceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getTransmissionReferenceProperty()"})
  void testGetTransmissionReferenceProperty() {
    // Arrange, Act and Assert
    assertNull(
        new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getTransmissionReferenceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReferenceProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  @DisplayName("Test getTransmissionReferenceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getTransmissionReferenceProperty()"})
  void testGetTransmissionReferenceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReferenceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReferenceProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReferenceProperty()}
   */
  @Test
  @DisplayName("Test getTransmissionReferenceProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType PhotoshopSchema.getTransmissionReferenceProperty()"})
  void testGetTransmissionReferenceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReferenceProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReference()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  @DisplayName("Test getTransmissionReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getTransmissionReference()"})
  void testGetTransmissionReference() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReference());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReference()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  @DisplayName("Test getTransmissionReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getTransmissionReference()"})
  void testGetTransmissionReference2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act and Assert
    assertNull(photoshopSchema.getTransmissionReference());
  }

  /**
   * Test {@link PhotoshopSchema#getTransmissionReference()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getTransmissionReference()}
   */
  @Test
  @DisplayName(
      "Test getTransmissionReference(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PhotoshopSchema.getTransmissionReference()"})
  void testGetTransmissionReference_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getTransmissionReference());
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReference(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  @DisplayName("Test setTransmissionReference(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReference(String)"})
  void testSetTransmissionReference() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(1));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReference(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  @DisplayName("Test setTransmissionReference(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReference(String)"})
  void testSetTransmissionReference2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.TRANSMISSION_REFERENCE);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReference(String)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  @DisplayName("Test setTransmissionReference(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReference(String)"})
  void testSetTransmissionReference3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.TRANSMISSION_REFERENCE, "42");

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(0));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReference(String)}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReference(String)}
   */
  @Test
  @DisplayName(
      "Test setTransmissionReference(String); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReference(String)"})
  void testSetTransmissionReference_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setTransmissionReference("Text");

    // Assert
    assertEquals("Text", photoshopSchema.getTransmissionReference());
    TextType transmissionReferenceProperty = photoshopSchema.getTransmissionReferenceProperty();
    assertEquals("Text", transmissionReferenceProperty.getStringValue());
    assertEquals("Text", transmissionReferenceProperty.getRawValue());
    assertEquals("Text", transmissionReferenceProperty.getValue());
    assertEquals("photoshop", transmissionReferenceProperty.getPrefix());
    assertNull(transmissionReferenceProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(transmissionReferenceProperty.getAllAttributes().isEmpty());
    assertEquals(
        PhotoshopSchema.TRANSMISSION_REFERENCE, transmissionReferenceProperty.getPropertyName());
    assertSame(transmissionReferenceProperty, allProperties.get(0));
    assertSame(metadata, transmissionReferenceProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTransmissionReferenceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReferenceProperty(TextType)"})
  void testSetTransmissionReferenceProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTransmissionReferenceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReferenceProperty(TextType)"})
  void testSetTransmissionReferenceProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTransmissionReferenceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReferenceProperty(TextType)"})
  void testSetTransmissionReferenceProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Property Name", "Property Name");
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setTransmissionReferenceProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTransmissionReferenceProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setTransmissionReferenceProperty(TextType)"})
  void testSetTransmissionReferenceProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors("Text");
    TextType text =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    photoshopSchema.setTransmissionReferenceProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#getUrgencyProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  @DisplayName("Test getUrgencyProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getUrgencyProperty()"})
  void testGetUrgencyProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgencyProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getUrgencyProperty()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  @DisplayName("Test getUrgencyProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getUrgencyProperty()"})
  void testGetUrgencyProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgencyProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getUrgencyProperty()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgencyProperty()}
   */
  @Test
  @DisplayName(
      "Test getUrgencyProperty(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType PhotoshopSchema.getUrgencyProperty()"})
  void testGetUrgencyProperty_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getUrgencyProperty());
  }

  /**
   * Test {@link PhotoshopSchema#getUrgency()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  @DisplayName("Test getUrgency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getUrgency()"})
  void testGetUrgency() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgency());
  }

  /**
   * Test {@link PhotoshopSchema#getUrgency()}.
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  @DisplayName("Test getUrgency()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getUrgency()"})
  void testGetUrgency2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act and Assert
    assertNull(photoshopSchema.getUrgency());
  }

  /**
   * Test {@link PhotoshopSchema#getUrgency()}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#getUrgency()}
   */
  @Test
  @DisplayName(
      "Test getUrgency(); given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer PhotoshopSchema.getUrgency()"})
  void testGetUrgency_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new PhotoshopSchema(XMPMetadata.createXMPMetadata()).getUrgency());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(Integer)} with {@code Integer}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  @DisplayName("Test setUrgency(Integer) with 'Integer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(Integer)"})
  void testSetUrgencyWithInteger() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    assertEquals(1, ((Integer) urgencyProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(Integer)} with {@code Integer}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  @DisplayName("Test setUrgency(Integer) with 'Integer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(Integer)"})
  void testSetUrgencyWithInteger2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(
        PhotoshopSchema.DOCUMENT_ANCESTORS, PhotoshopSchema.DOCUMENT_ANCESTORS);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.URGENCY);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(Integer)} with {@code Integer}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  @DisplayName("Test setUrgency(Integer) with 'Integer'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(Integer)"})
  void testSetUrgencyWithInteger3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.URGENCY, "42");

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    assertEquals(1, ((Integer) urgencyProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(Integer)} with {@code Integer}.
   *
   * <ul>
   *   <li>Given {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(Integer)}
   */
  @Test
  @DisplayName(
      "Test setUrgency(Integer) with 'Integer'; given PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(Integer)"})
  void testSetUrgencyWithInteger_givenPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setUrgency(1);

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("1", urgencyProperty.getStringValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    assertEquals(1, photoshopSchema.getUrgency().intValue());
    assertEquals(1, urgencyProperty.getValue().intValue());
    assertEquals(1, ((Integer) urgencyProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(String)} with {@code String}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  @DisplayName("Test setUrgency(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(String)"})
  void testSetUrgencyWithString() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(0));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(String)} with {@code String}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  @DisplayName("Test setUrgency(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(String)"})
  void testSetUrgencyWithString2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(String)} with {@code String}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  @DisplayName("Test setUrgency(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(String)"})
  void testSetUrgencyWithString3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers(PhotoshopSchema.URGENCY, PhotoshopSchema.URGENCY);
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link PhotoshopSchema#setUrgency(String)} with {@code String}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgency(String)}
   */
  @Test
  @DisplayName("Test setUrgency(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgency(String)"})
  void testSetUrgencyWithString4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    PhotoshopSchema photoshopSchema = new PhotoshopSchema(metadata);
    photoshopSchema.addBagValueAsSimple(PhotoshopSchema.URGENCY, "42");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);

    // Act
    photoshopSchema.setUrgency("42");

    // Assert
    IntegerType urgencyProperty = photoshopSchema.getUrgencyProperty();
    assertEquals("42", urgencyProperty.getStringValue());
    assertEquals("42", urgencyProperty.getRawValue());
    assertEquals("photoshop", urgencyProperty.getPrefix());
    assertNull(urgencyProperty.getNamespace());
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(42, photoshopSchema.getUrgency().intValue());
    assertEquals(42, urgencyProperty.getValue().intValue());
    assertTrue(urgencyProperty.getAllAttributes().isEmpty());
    assertEquals(PhotoshopSchema.URGENCY, urgencyProperty.getPropertyName());
    assertSame(urgencyProperty, allProperties.get(1));
    assertSame(metadata, urgencyProperty.getMetadata());
  }

  /**
   * Test {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setUrgencyProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgencyProperty(IntegerType)"})
  void testSetUrgencyProperty() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(text, allProperties.get(0));
  }

  /**
   * Test {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setUrgencyProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgencyProperty(IntegerType)"})
  void testSetUrgencyProperty2() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(text, allProperties.get(1));
  }

  /**
   * Test {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setUrgencyProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgencyProperty(IntegerType)"})
  void testSetUrgencyProperty3() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
    assertSame(text, allProperties.get(2));
  }

  /**
   * Test {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}.
   *
   * <p>Method under test: {@link PhotoshopSchema#setUrgencyProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setUrgencyProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PhotoshopSchema.setUrgencyProperty(IntegerType)"})
  void testSetUrgencyProperty4() {
    // Arrange
    PhotoshopSchema photoshopSchema = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    photoshopSchema.addBagValueAsSimple("Property Name", PhotoshopSchema.TEXT_LAYERS);
    photoshopSchema.addTextLayers("Layer Name", "Layer Text");
    photoshopSchema.addDocumentAncestors(PhotoshopSchema.DOCUMENT_ANCESTORS);
    IntegerType text =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    photoshopSchema.setUrgencyProperty(text);

    // Assert
    List<AbstractField> allProperties = photoshopSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertEquals(PhotoshopSchema.TEXT_LAYERS, getResult.getPropertyName());
  }
}
