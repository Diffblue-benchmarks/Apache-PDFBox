package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AdobePDFSchemaDiffblueTest {
  /**
   * Test {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new AdobePDFSchema(XMPMetadata)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.<init>(XMPMetadata)"})
  void testNewAdobePDFSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata);

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertEquals("pdf", actualAdobePDFSchema.getPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualAdobePDFSchema.getAllProperties().isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/pdf/1.3/"));
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Prefix is {@code pdf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new AdobePDFSchema(XMPMetadata, String); when 'null'; then return Prefix is 'pdf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.<init>(XMPMetadata, String)"})
  void testNewAdobePDFSchema_whenNull_thenReturnPrefixIsPdf() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata, null);

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertEquals("pdf", actualAdobePDFSchema.getPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualAdobePDFSchema.getAllProperties().isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/pdf/1.3/"));
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}.
   * <ul>
   *   <li>When {@code Own Prefix}.</li>
   *   <li>Then return Prefix is {@code Own Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new AdobePDFSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.<init>(XMPMetadata, String)"})
  void testNewAdobePDFSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualAdobePDFSchema = new AdobePDFSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualAdobePDFSchema.getAboutValue());
    assertEquals("Own Prefix", actualAdobePDFSchema.getPrefix());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAdobePDFSchema.getNamespace());
    assertEquals("pdf", actualAdobePDFSchema.getPreferedPrefix());
    assertNull(actualAdobePDFSchema.getKeywords());
    assertNull(actualAdobePDFSchema.getPDFVersion());
    assertNull(actualAdobePDFSchema.getProducer());
    assertNull(actualAdobePDFSchema.getPropertyName());
    assertNull(actualAdobePDFSchema.getAboutAttribute());
    assertNull(actualAdobePDFSchema.getKeywordsProperty());
    assertNull(actualAdobePDFSchema.getPDFVersionProperty());
    assertNull(actualAdobePDFSchema.getProducerProperty());
    Map<String, String> allNamespacesWithPrefix = actualAdobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualAdobePDFSchema.getAllProperties().isEmpty());
    assertTrue(actualAdobePDFSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/pdf/1.3/"));
    assertSame(metadata, actualAdobePDFSchema.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setKeywords(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  @DisplayName("Test setKeywords(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywords(String)"})
  void testSetKeywords() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(0));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setKeywords(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  @DisplayName("Test setKeywords(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywords(String)"})
  void testSetKeywords2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(1));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setKeywords(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  @DisplayName("Test setKeywords(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywords(String)"})
  void testSetKeywords3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(1));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setKeywords(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywords(String)}
   */
  @Test
  @DisplayName("Test setKeywords(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywords(String)"})
  void testSetKeywords_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setKeywords("42");

    // Assert
    assertEquals("42", adobePDFSchema.getKeywords());
    TextType keywordsProperty = adobePDFSchema.getKeywordsProperty();
    assertEquals("42", keywordsProperty.getStringValue());
    assertEquals("42", keywordsProperty.getRawValue());
    assertEquals("42", keywordsProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", keywordsProperty.getNamespace());
    assertEquals("pdf", keywordsProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(keywordsProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, keywordsProperty.getPropertyName());
    assertSame(keywordsProperty, allProperties.get(0));
    assertSame(metadata, keywordsProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setKeywordsProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setKeywordsProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywordsProperty(TextType)"})
  void testSetKeywordsProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType keywords = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setKeywordsProperty(keywords);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(keywords, allProperties.get(0));
  }

  /**
   * Test {@link AdobePDFSchema#setKeywordsProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setKeywordsProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywordsProperty(TextType)"})
  void testSetKeywordsProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType keywords = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setKeywordsProperty(keywords);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(keywords, allProperties.get(1));
  }

  /**
   * Test {@link AdobePDFSchema#setKeywordsProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setKeywordsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setKeywordsProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setKeywordsProperty(TextType)"})
  void testSetKeywordsProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setKeywordsProperty(
        new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersion(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  @DisplayName("Test setPDFVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersion(String)"})
  void testSetPDFVersion() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(0));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersion(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  @DisplayName("Test setPDFVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersion(String)"})
  void testSetPDFVersion2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(1));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersion(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  @DisplayName("Test setPDFVersion(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersion(String)"})
  void testSetPDFVersion3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(1));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersion(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersion(String)}
   */
  @Test
  @DisplayName("Test setPDFVersion(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersion(String)"})
  void testSetPDFVersion_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setPDFVersion("42");

    // Assert
    assertEquals("42", adobePDFSchema.getPDFVersion());
    TextType pDFVersionProperty = adobePDFSchema.getPDFVersionProperty();
    assertEquals("42", pDFVersionProperty.getStringValue());
    assertEquals("42", pDFVersionProperty.getRawValue());
    assertEquals("42", pDFVersionProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", pDFVersionProperty.getNamespace());
    assertEquals("pdf", pDFVersionProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(pDFVersionProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PDF_VERSION, pDFVersionProperty.getPropertyName());
    assertSame(pDFVersionProperty, allProperties.get(0));
    assertSame(metadata, pDFVersionProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersionProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setPDFVersionProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersionProperty(TextType)"})
  void testSetPDFVersionProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType version = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setPDFVersionProperty(version);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(version, allProperties.get(0));
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersionProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setPDFVersionProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersionProperty(TextType)"})
  void testSetPDFVersionProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType version = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setPDFVersionProperty(version);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(version, allProperties.get(1));
  }

  /**
   * Test {@link AdobePDFSchema#setPDFVersionProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setPDFVersionProperty(TextType)}
   */
  @Test
  @DisplayName("Test setPDFVersionProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setPDFVersionProperty(TextType)"})
  void testSetPDFVersionProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setPDFVersionProperty(
        new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
  }

  /**
   * Test {@link AdobePDFSchema#setProducer(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  @DisplayName("Test setProducer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducer(String)"})
  void testSetProducer() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(0));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setProducer(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  @DisplayName("Test setProducer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducer(String)"})
  void testSetProducer2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(1));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setProducer(String)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  @DisplayName("Test setProducer(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducer(String)"})
  void testSetProducer3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(1));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setProducer(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducer(String)}
   */
  @Test
  @DisplayName("Test setProducer(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducer(String)"})
  void testSetProducer_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setProducer("42");

    // Assert
    assertEquals("42", adobePDFSchema.getProducer());
    TextType producerProperty = adobePDFSchema.getProducerProperty();
    assertEquals("42", producerProperty.getStringValue());
    assertEquals("42", producerProperty.getRawValue());
    assertEquals("42", producerProperty.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", producerProperty.getNamespace());
    assertEquals("pdf", producerProperty.getPrefix());
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(producerProperty.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.PRODUCER, producerProperty.getPropertyName());
    assertSame(producerProperty, allProperties.get(0));
    assertSame(metadata, producerProperty.getMetadata());
  }

  /**
   * Test {@link AdobePDFSchema#setProducerProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  @DisplayName("Test setProducerProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducerProperty(TextType)"})
  void testSetProducerProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType producer = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setProducerProperty(producer);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(producer, allProperties.get(0));
  }

  /**
   * Test {@link AdobePDFSchema#setProducerProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  @DisplayName("Test setProducerProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducerProperty(TextType)"})
  void testSetProducerProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    TextType producer = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act
    adobePDFSchema.setProducerProperty(producer);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertSame(producer, allProperties.get(1));
  }

  /**
   * Test {@link AdobePDFSchema#setProducerProperty(TextType)}.
   * <p>
   * Method under test: {@link AdobePDFSchema#setProducerProperty(TextType)}
   */
  @Test
  @DisplayName("Test setProducerProperty(TextType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AdobePDFSchema.setProducerProperty(TextType)"})
  void testSetProducerProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    adobePDFSchema.setProducerProperty(
        new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
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
    assertEquals("Simple Name", getResult.getPropertyName());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywordsProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  @DisplayName("Test getKeywordsProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getKeywordsProperty()"})
  void testGetKeywordsProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywordsProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  @DisplayName("Test getKeywordsProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getKeywordsProperty()"})
  void testGetKeywordsProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywordsProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  @DisplayName("Test getKeywordsProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getKeywordsProperty()"})
  void testGetKeywordsProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.KEYWORDS,
        AdobePDFSchema.KEYWORDS, AdobePDFSchema.KEYWORDS, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getKeywordsProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywordsProperty()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywordsProperty()}
   */
  @Test
  @DisplayName("Test getKeywordsProperty(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getKeywordsProperty()"})
  void testGetKeywordsProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getKeywordsProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywords()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getKeywords()"})
  void testGetKeywords() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywords());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywords()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getKeywords()"})
  void testGetKeywords2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.KEYWORDS);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getKeywords());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywords()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getKeywords()"})
  void testGetKeywords_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getKeywords());
  }

  /**
   * Test {@link AdobePDFSchema#getKeywords()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getKeywords()}
   */
  @Test
  @DisplayName("Test getKeywords(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getKeywords()"})
  void testGetKeywords_thenReturnValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.KEYWORDS,
        AdobePDFSchema.KEYWORDS, AdobePDFSchema.KEYWORDS, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getKeywords());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersionProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  @DisplayName("Test getPDFVersionProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getPDFVersionProperty()"})
  void testGetPDFVersionProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersionProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  @DisplayName("Test getPDFVersionProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getPDFVersionProperty()"})
  void testGetPDFVersionProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersionProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  @DisplayName("Test getPDFVersionProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getPDFVersionProperty()"})
  void testGetPDFVersionProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PDF_VERSION,
        AdobePDFSchema.PDF_VERSION, AdobePDFSchema.PDF_VERSION, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getPDFVersionProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersionProperty()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersionProperty()}
   */
  @Test
  @DisplayName("Test getPDFVersionProperty(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getPDFVersionProperty()"})
  void testGetPDFVersionProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPDFVersionProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersion()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  @DisplayName("Test getPDFVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getPDFVersion()"})
  void testGetPDFVersion() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersion());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersion()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  @DisplayName("Test getPDFVersion()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getPDFVersion()"})
  void testGetPDFVersion2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PDF_VERSION);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PDF_VERSION, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getPDFVersion());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersion()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  @DisplayName("Test getPDFVersion(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getPDFVersion()"})
  void testGetPDFVersion_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getPDFVersion());
  }

  /**
   * Test {@link AdobePDFSchema#getPDFVersion()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getPDFVersion()}
   */
  @Test
  @DisplayName("Test getPDFVersion(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getPDFVersion()"})
  void testGetPDFVersion_thenReturnValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PDF_VERSION,
        AdobePDFSchema.PDF_VERSION, AdobePDFSchema.PDF_VERSION, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getPDFVersion());
  }

  /**
   * Test {@link AdobePDFSchema#getProducerProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  @DisplayName("Test getProducerProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getProducerProperty()"})
  void testGetProducerProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducerProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getProducerProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  @DisplayName("Test getProducerProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getProducerProperty()"})
  void testGetProducerProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducerProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getProducerProperty()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  @DisplayName("Test getProducerProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getProducerProperty()"})
  void testGetProducerProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PRODUCER,
        AdobePDFSchema.PRODUCER, AdobePDFSchema.PRODUCER, "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getProducerProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getProducerProperty()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducerProperty()}
   */
  @Test
  @DisplayName("Test getProducerProperty(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TextType AdobePDFSchema.getProducerProperty()"})
  void testGetProducerProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProducerProperty());
  }

  /**
   * Test {@link AdobePDFSchema#getProducer()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getProducer()"})
  void testGetProducer() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducer());
  }

  /**
   * Test {@link AdobePDFSchema#getProducer()}.
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getProducer()"})
  void testGetProducer2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", AdobePDFSchema.PRODUCER);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.PRODUCER, "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProducer());
  }

  /**
   * Test {@link AdobePDFSchema#getProducer()}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer(); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getProducer()"})
  void testGetProducer_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProducer());
  }

  /**
   * Test {@link AdobePDFSchema#getProducer()}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdobePDFSchema#getProducer()}
   */
  @Test
  @DisplayName("Test getProducer(); then return 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AdobePDFSchema.getProducer()"})
  void testGetProducer_thenReturnValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), AdobePDFSchema.PRODUCER,
        AdobePDFSchema.PRODUCER, AdobePDFSchema.PRODUCER, "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getProducer());
  }
}
