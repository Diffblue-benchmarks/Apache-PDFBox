package org.apache.xmpbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.apache.xmpbox.schema.DublinCoreSchema;
import org.apache.xmpbox.schema.PDFAExtensionSchema;
import org.apache.xmpbox.schema.PDFAIdentificationSchema;
import org.apache.xmpbox.schema.PhotoshopSchema;
import org.apache.xmpbox.schema.XMPBasicJobTicketSchema;
import org.apache.xmpbox.schema.XMPBasicSchema;
import org.apache.xmpbox.schema.XMPMediaManagementSchema;
import org.apache.xmpbox.schema.XMPRightsManagementSchema;
import org.apache.xmpbox.schema.XMPSchema;
import org.apache.xmpbox.schema.XmpSchemaException;
import org.apache.xmpbox.type.BadFieldValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPMetadataDiffblueTest {
  /**
   * Test {@link XMPMetadata#XMPMetadata()}.
   *
   * <p>Method under test: {@link XMPMetadata#XMPMetadata()}
   */
  @Test
  @DisplayName("Test new XMPMetadata()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMetadata.<init>()"})
  void testNewXMPMetadata() {
    // Arrange and Act
    XMPMetadata actualXmpMetadata = new XMPMetadata();

    // Assert
    assertNull(actualXmpMetadata.getXpacketBytes());
    assertNull(actualXmpMetadata.getAdobePDFSchema());
    assertNull(actualXmpMetadata.getDublinCoreSchema());
    assertNull(actualXmpMetadata.getPDFExtensionSchema());
    assertNull(actualXmpMetadata.getPDFAIdentificationSchema());
    assertNull(actualXmpMetadata.getPhotoshopSchema());
    assertNull(actualXmpMetadata.getBasicJobTicketSchema());
    assertNull(actualXmpMetadata.getXMPBasicSchema());
    assertNull(actualXmpMetadata.getXMPMediaManagementSchema());
    assertNull(actualXmpMetadata.getXMPRightsManagementSchema());
    assertTrue(actualXmpMetadata.getAllSchemas().isEmpty());
    assertEquals(XmpConstants.DEFAULT_XPACKET_BEGIN, actualXmpMetadata.getXpacketBegin());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualXmpMetadata.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualXmpMetadata.getEndXPacket());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ID, actualXmpMetadata.getXpacketId());
  }

  /**
   * Test {@link XMPMetadata#XMPMetadata(String, String, String, String)}.
   *
   * <p>Method under test: {@link XMPMetadata#XMPMetadata(String, String, String, String)}
   */
  @Test
  @DisplayName("Test new XMPMetadata(String, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMetadata.<init>(String, String, String, String)"})
  void testNewXMPMetadata2() {
    // Arrange and Act
    XMPMetadata actualXmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);

    // Assert
    assertEquals("42", actualXmpMetadata.getXpacketId());
    assertEquals("Xpacket Begin", actualXmpMetadata.getXpacketBegin());
    assertEquals("Xpacket Bytes", actualXmpMetadata.getXpacketBytes());
    assertNull(actualXmpMetadata.getAdobePDFSchema());
    assertNull(actualXmpMetadata.getDublinCoreSchema());
    assertNull(actualXmpMetadata.getPDFExtensionSchema());
    assertNull(actualXmpMetadata.getPDFAIdentificationSchema());
    assertNull(actualXmpMetadata.getPhotoshopSchema());
    assertNull(actualXmpMetadata.getBasicJobTicketSchema());
    assertNull(actualXmpMetadata.getXMPBasicSchema());
    assertNull(actualXmpMetadata.getXMPMediaManagementSchema());
    assertNull(actualXmpMetadata.getXMPRightsManagementSchema());
    assertTrue(actualXmpMetadata.getAllSchemas().isEmpty());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualXmpMetadata.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualXmpMetadata.getEndXPacket());
  }

  /**
   * Test {@link XMPMetadata#createXMPMetadata()}.
   *
   * <p>Method under test: {@link XMPMetadata#createXMPMetadata()}
   */
  @Test
  @DisplayName("Test createXMPMetadata()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMetadata XMPMetadata.createXMPMetadata()"})
  void testCreateXMPMetadata() {
    // Arrange and Act
    XMPMetadata actualCreateXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Assert
    assertNull(actualCreateXMPMetadataResult.getXpacketBytes());
    assertNull(actualCreateXMPMetadataResult.getAdobePDFSchema());
    assertNull(actualCreateXMPMetadataResult.getDublinCoreSchema());
    assertNull(actualCreateXMPMetadataResult.getPDFExtensionSchema());
    assertNull(actualCreateXMPMetadataResult.getPDFAIdentificationSchema());
    assertNull(actualCreateXMPMetadataResult.getPhotoshopSchema());
    assertNull(actualCreateXMPMetadataResult.getBasicJobTicketSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPBasicSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPMediaManagementSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPRightsManagementSchema());
    assertTrue(actualCreateXMPMetadataResult.getAllSchemas().isEmpty());
    assertEquals(
        XmpConstants.DEFAULT_XPACKET_BEGIN, actualCreateXMPMetadataResult.getXpacketBegin());
    assertEquals(
        XmpConstants.DEFAULT_XPACKET_ENCODING, actualCreateXMPMetadataResult.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualCreateXMPMetadataResult.getEndXPacket());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ID, actualCreateXMPMetadataResult.getXpacketId());
  }

  /**
   * Test {@link XMPMetadata#createXMPMetadata(String, String, String, String)} with {@code String},
   * {@code String}, {@code String}, {@code String}.
   *
   * <p>Method under test: {@link XMPMetadata#createXMPMetadata(String, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test createXMPMetadata(String, String, String, String) with 'String', 'String', 'String', 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMetadata XMPMetadata.createXMPMetadata(String, String, String, String)"})
  void testCreateXMPMetadataWithStringStringStringString() {
    // Arrange and Act
    XMPMetadata actualCreateXMPMetadataResult =
        XMPMetadata.createXMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);

    // Assert
    assertEquals("42", actualCreateXMPMetadataResult.getXpacketId());
    assertEquals("Xpacket Begin", actualCreateXMPMetadataResult.getXpacketBegin());
    assertEquals("Xpacket Bytes", actualCreateXMPMetadataResult.getXpacketBytes());
    assertNull(actualCreateXMPMetadataResult.getAdobePDFSchema());
    assertNull(actualCreateXMPMetadataResult.getDublinCoreSchema());
    assertNull(actualCreateXMPMetadataResult.getPDFExtensionSchema());
    assertNull(actualCreateXMPMetadataResult.getPDFAIdentificationSchema());
    assertNull(actualCreateXMPMetadataResult.getPhotoshopSchema());
    assertNull(actualCreateXMPMetadataResult.getBasicJobTicketSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPBasicSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPMediaManagementSchema());
    assertNull(actualCreateXMPMetadataResult.getXMPRightsManagementSchema());
    assertTrue(actualCreateXMPMetadataResult.getAllSchemas().isEmpty());
    assertEquals(
        XmpConstants.DEFAULT_XPACKET_ENCODING, actualCreateXMPMetadataResult.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualCreateXMPMetadataResult.getEndXPacket());
  }

  /**
   * Test {@link XMPMetadata#getAllSchemas()}.
   *
   * <p>Method under test: {@link XMPMetadata#getAllSchemas()}
   */
  @Test
  @DisplayName("Test getAllSchemas()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMetadata.getAllSchemas()"})
  void testGetAllSchemas() {
    // Arrange, Act and Assert
    assertTrue(XMPMetadata.createXMPMetadata().getAllSchemas().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link XMPMetadata#setEndXPacket(String)}
   *   <li>{@link XMPMetadata#getEndXPacket()}
   *   <li>{@link XMPMetadata#getTypeMapping()}
   *   <li>{@link XMPMetadata#getXpacketBegin()}
   *   <li>{@link XMPMetadata#getXpacketBytes()}
   *   <li>{@link XMPMetadata#getXpacketEncoding()}
   *   <li>{@link XMPMetadata#getXpacketId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String XMPMetadata.getEndXPacket()",
    "org.apache.xmpbox.type.TypeMapping XMPMetadata.getTypeMapping()",
    "String XMPMetadata.getXpacketBegin()",
    "String XMPMetadata.getXpacketBytes()",
    "String XMPMetadata.getXpacketEncoding()",
    "String XMPMetadata.getXpacketId()",
    "void XMPMetadata.setEndXPacket(String)"
  })
  void testGettersAndSetters() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    createXMPMetadataResult.setEndXPacket("Data");
    String actualEndXPacket = createXMPMetadataResult.getEndXPacket();
    createXMPMetadataResult.getTypeMapping();
    String actualXpacketBegin = createXMPMetadataResult.getXpacketBegin();
    String actualXpacketBytes = createXMPMetadataResult.getXpacketBytes();
    String actualXpacketEncoding = createXMPMetadataResult.getXpacketEncoding();

    // Assert
    assertEquals("Data", actualEndXPacket);
    assertNull(actualXpacketBytes);
    assertEquals(XmpConstants.DEFAULT_XPACKET_BEGIN, actualXpacketBegin);
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualXpacketEncoding);
    assertEquals(XmpConstants.DEFAULT_XPACKET_ID, createXMPMetadataResult.getXpacketId());
  }

  /**
   * Test {@link XMPMetadata#getSchema(String)} with {@code nsURI}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>When {@code Ns URI}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  @DisplayName(
      "Test getSchema(String) with 'nsURI'; given createXMPMetadata; when 'Ns URI'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String)"})
  void testGetSchemaWithNsURI_givenCreateXMPMetadata_whenNsUri_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getSchema("Ns URI"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String)} with {@code nsURI}.
   *
   * <ul>
   *   <li>Then return {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  @DisplayName(
      "Test getSchema(String) with 'nsURI'; then return AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String)"})
  void testGetSchemaWithNsURI_thenReturnAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getSchema("http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String)} with {@code nsURI}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  @DisplayName("Test getSchema(String) with 'nsURI'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String)"})
  void testGetSchemaWithNsURI_thenReturnNull() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Ns URI"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String, String)} with {@code prefix}, {@code nsURI}.
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  @DisplayName("Test getSchema(String, String) with 'prefix', 'nsURI'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String, String)"})
  void testGetSchemaWithPrefixNsURI() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getSchema("pdf", "http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String, String)} with {@code prefix}, {@code nsURI}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>When {@code Ns URI}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  @DisplayName(
      "Test getSchema(String, String) with 'prefix', 'nsURI'; given createXMPMetadata; when 'Ns URI'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String, String)"})
  void testGetSchemaWithPrefixNsURI_givenCreateXMPMetadata_whenNsUri_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getSchema("Prefix", "Ns URI"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String, String)} with {@code prefix}, {@code nsURI}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  @DisplayName("Test getSchema(String, String) with 'prefix', 'nsURI'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String, String)"})
  void testGetSchemaWithPrefixNsURI_thenReturnNull() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Prefix", "http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Test {@link XMPMetadata#getSchema(String, String)} with {@code prefix}, {@code nsURI}.
   *
   * <ul>
   *   <li>When {@code Ns URI}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  @DisplayName(
      "Test getSchema(String, String) with 'prefix', 'nsURI'; when 'Ns URI'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.getSchema(String, String)"})
  void testGetSchemaWithPrefixNsURI_whenNsUri_thenReturnNull() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Prefix", "Ns URI"));
  }

  /**
   * Test {@link XMPMetadata#createAndAddDefaultSchema(String, String)}.
   *
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Ns URI} is {@code Ns Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddDefaultSchema(String, String)}
   */
  @Test
  @DisplayName(
      "Test createAndAddDefaultSchema(String, String); then return AllNamespacesWithPrefix 'Ns URI' is 'Ns Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.createAndAddDefaultSchema(String, String)"})
  void testCreateAndAddDefaultSchema_thenReturnAllNamespacesWithPrefixNsUriIsNsPrefix() {
    // Arrange and Act
    XMPSchema actualCreateAndAddDefaultSchemaResult =
        XMPMetadata.createXMPMetadata().createAndAddDefaultSchema("Ns Prefix", "Ns URI");

    // Assert
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddDefaultSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Ns Prefix", allNamespacesWithPrefix.get("Ns URI"));
    assertEquals("Ns Prefix", actualCreateAndAddDefaultSchemaResult.getPreferedPrefix());
    assertEquals("Ns Prefix", actualCreateAndAddDefaultSchemaResult.getPrefix());
    List<XMPSchema> allSchemas =
        actualCreateAndAddDefaultSchemaResult.getMetadata().getAllSchemas();
    assertEquals(1, allSchemas.size());
    assertEquals(1, actualCreateAndAddDefaultSchemaResult.getAllAttributes().size());
    assertSame(actualCreateAndAddDefaultSchemaResult, allSchemas.get(0));
  }

  /**
   * Test {@link XMPMetadata#createAndAddDefaultSchema(String, String)}.
   *
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Ns URI} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddDefaultSchema(String, String)}
   */
  @Test
  @DisplayName(
      "Test createAndAddDefaultSchema(String, String); then return AllNamespacesWithPrefix 'Ns URI' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPSchema XMPMetadata.createAndAddDefaultSchema(String, String)"})
  void testCreateAndAddDefaultSchema_thenReturnAllNamespacesWithPrefixNsUriIsNull() {
    // Arrange and Act
    XMPSchema actualCreateAndAddDefaultSchemaResult =
        XMPMetadata.createXMPMetadata().createAndAddDefaultSchema(null, "Ns URI");

    // Assert
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddDefaultSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Ns URI"));
    assertNull(actualCreateAndAddDefaultSchemaResult.getPreferedPrefix());
    assertNull(actualCreateAndAddDefaultSchemaResult.getPrefix());
    List<XMPSchema> allSchemas =
        actualCreateAndAddDefaultSchemaResult.getMetadata().getAllSchemas();
    assertEquals(1, allSchemas.size());
    assertEquals(1, actualCreateAndAddDefaultSchemaResult.getAllAttributes().size());
    assertSame(actualCreateAndAddDefaultSchemaResult, allSchemas.get(0));
  }

  /**
   * Test {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithDefaultNS()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithDefaultNS()}
   */
  @Test
  @DisplayName("Test createAndAddPDFAExtensionSchemaWithDefaultNS()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDFAExtensionSchema XMPMetadata.createAndAddPDFAExtensionSchemaWithDefaultNS()"
  })
  void testCreateAndAddPDFAExtensionSchemaWithDefaultNS() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult =
        createXMPMetadataResult.createAndAddPDFAExtensionSchemaWithDefaultNS();

    // Assert
    assertEquals("", actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAboutValue());
    assertEquals(
        "http://www.aiim.org/pdfa/ns/extension/",
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getNamespace());
    assertEquals(
        "pdfaExtension",
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPreferedPrefix());
    assertEquals(
        "pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPrefix());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getSchemasProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(
        1, actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/extension/"));
    assertSame(
        createXMPMetadataResult,
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithNS(Map)}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithNS(Map)}
   */
  @Test
  @DisplayName("Test createAndAddPDFAExtensionSchemaWithNS(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAExtensionSchema XMPMetadata.createAndAddPDFAExtensionSchemaWithNS(Map)"})
  void testCreateAndAddPDFAExtensionSchemaWithNS() throws XmpSchemaException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualCreateAndAddPDFAExtensionSchemaWithNSResult =
        createXMPMetadataResult.createAndAddPDFAExtensionSchemaWithNS(new HashMap<>());

    // Assert
    assertEquals("", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAboutValue());
    assertEquals(
        "http://www.aiim.org/pdfa/ns/extension/",
        actualCreateAndAddPDFAExtensionSchemaWithNSResult.getNamespace());
    assertEquals(
        "pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPreferedPrefix());
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPrefix());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getSchemasProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/extension/"));
    assertSame(
        createXMPMetadataResult, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getPDFExtensionSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  @DisplayName("Test getPDFExtensionSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAExtensionSchema XMPMetadata.getPDFExtensionSchema()"})
  void testGetPDFExtensionSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    PDFAExtensionSchema obj = new PDFAExtensionSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getPDFExtensionSchema());
  }

  /**
   * Test {@link XMPMetadata#getPDFExtensionSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  @DisplayName("Test getPDFExtensionSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAExtensionSchema XMPMetadata.getPDFExtensionSchema()"})
  void testGetPDFExtensionSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getPDFExtensionSchema());
  }

  /**
   * Test {@link XMPMetadata#getPDFExtensionSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  @DisplayName("Test getPDFExtensionSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAExtensionSchema XMPMetadata.getPDFExtensionSchema()"})
  void testGetPDFExtensionSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPDFExtensionSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddPDFAIdentificationSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddPDFAIdentificationSchema()}
   */
  @Test
  @DisplayName("Test createAndAddPDFAIdentificationSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAIdentificationSchema XMPMetadata.createAndAddPDFAIdentificationSchema()"})
  void testCreateAndAddPDFAIdentificationSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualCreateAndAddPDFAIdentificationSchemaResult =
        createXMPMetadataResult.createAndAddPDFAIdentificationSchema();

    // Assert
    assertEquals("", actualCreateAndAddPDFAIdentificationSchemaResult.getAboutValue());
    assertEquals(
        "http://www.aiim.org/pdfa/ns/id/",
        actualCreateAndAddPDFAIdentificationSchemaResult.getNamespace());
    assertEquals("pdfaid", actualCreateAndAddPDFAIdentificationSchemaResult.getPreferedPrefix());
    assertEquals("pdfaid", actualCreateAndAddPDFAIdentificationSchemaResult.getPrefix());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getPart());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getAmd());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getAmendment());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getConformance());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getPartProperty());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getAmdProperty());
    assertNull(actualCreateAndAddPDFAIdentificationSchemaResult.getConformanceProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddPDFAIdentificationSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddPDFAIdentificationSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddPDFAIdentificationSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://www.aiim.org/pdfa/ns/id/"));
    assertSame(
        createXMPMetadataResult, actualCreateAndAddPDFAIdentificationSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getPDFAIdentificationSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  @DisplayName("Test getPDFAIdentificationSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAIdentificationSchema XMPMetadata.getPDFAIdentificationSchema()"})
  void testGetPDFAIdentificationSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    PDFAIdentificationSchema obj = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getPDFAIdentificationSchema());
  }

  /**
   * Test {@link XMPMetadata#getPDFAIdentificationSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  @DisplayName("Test getPDFAIdentificationSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAIdentificationSchema XMPMetadata.getPDFAIdentificationSchema()"})
  void testGetPDFAIdentificationSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getPDFAIdentificationSchema());
  }

  /**
   * Test {@link XMPMetadata#getPDFAIdentificationSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  @DisplayName("Test getPDFAIdentificationSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFAIdentificationSchema XMPMetadata.getPDFAIdentificationSchema()"})
  void testGetPDFAIdentificationSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPDFAIdentificationSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddDublinCoreSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddDublinCoreSchema()}
   */
  @Test
  @DisplayName("Test createAndAddDublinCoreSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DublinCoreSchema XMPMetadata.createAndAddDublinCoreSchema()"})
  void testCreateAndAddDublinCoreSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    DublinCoreSchema actualCreateAndAddDublinCoreSchemaResult =
        createXMPMetadataResult.createAndAddDublinCoreSchema();

    // Assert
    assertEquals("", actualCreateAndAddDublinCoreSchemaResult.getAboutValue());
    assertEquals("dc", actualCreateAndAddDublinCoreSchemaResult.getPreferedPrefix());
    assertEquals("dc", actualCreateAndAddDublinCoreSchemaResult.getPrefix());
    assertEquals(
        "http://purl.org/dc/elements/1.1/",
        actualCreateAndAddDublinCoreSchemaResult.getNamespace());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getCoverage());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getDescription());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getFormat());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getIdentifier());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getRights());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getSource());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getTitle());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getContributors());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getCreators());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getDescriptionLanguages());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getLanguages());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getPublishers());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getRelations());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getRightsLanguages());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getSubjects());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getTitleLanguages());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getTypes());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getDates());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getContributorsProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getCreatorsProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getDatesProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getDescriptionProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getLanguagesProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getPublishersProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getRelationsProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getRightsProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getSubjectsProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getTitleProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getTypesProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getCoverageProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getFormatProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getIdentifierProperty());
    assertNull(actualCreateAndAddDublinCoreSchemaResult.getSourceProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddDublinCoreSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddDublinCoreSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddDublinCoreSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://purl.org/dc/elements/1.1/"));
    assertSame(createXMPMetadataResult, actualCreateAndAddDublinCoreSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getDublinCoreSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  @DisplayName("Test getDublinCoreSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DublinCoreSchema XMPMetadata.getDublinCoreSchema()"})
  void testGetDublinCoreSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    DublinCoreSchema obj = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getDublinCoreSchema());
  }

  /**
   * Test {@link XMPMetadata#getDublinCoreSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  @DisplayName("Test getDublinCoreSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DublinCoreSchema XMPMetadata.getDublinCoreSchema()"})
  void testGetDublinCoreSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getDublinCoreSchema());
  }

  /**
   * Test {@link XMPMetadata#getDublinCoreSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  @DisplayName("Test getDublinCoreSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DublinCoreSchema XMPMetadata.getDublinCoreSchema()"})
  void testGetDublinCoreSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getDublinCoreSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddBasicJobTicketSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddBasicJobTicketSchema()}
   */
  @Test
  @DisplayName("Test createAndAddBasicJobTicketSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicJobTicketSchema XMPMetadata.createAndAddBasicJobTicketSchema()"})
  void testCreateAndAddBasicJobTicketSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualCreateAndAddBasicJobTicketSchemaResult =
        createXMPMetadataResult.createAndAddBasicJobTicketSchema();

    // Assert
    assertEquals("", actualCreateAndAddBasicJobTicketSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/bj/",
        actualCreateAndAddBasicJobTicketSchemaResult.getNamespace());
    assertEquals("xmpBJ", actualCreateAndAddBasicJobTicketSchemaResult.getPreferedPrefix());
    assertEquals("xmpBJ", actualCreateAndAddBasicJobTicketSchemaResult.getPrefix());
    assertNull(actualCreateAndAddBasicJobTicketSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddBasicJobTicketSchemaResult.getJobs());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddBasicJobTicketSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddBasicJobTicketSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddBasicJobTicketSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/bj/"));
    assertSame(createXMPMetadataResult, actualCreateAndAddBasicJobTicketSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getBasicJobTicketSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  @DisplayName("Test getBasicJobTicketSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicJobTicketSchema XMPMetadata.getBasicJobTicketSchema()"})
  void testGetBasicJobTicketSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    XMPBasicJobTicketSchema obj = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getBasicJobTicketSchema());
  }

  /**
   * Test {@link XMPMetadata#getBasicJobTicketSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  @DisplayName("Test getBasicJobTicketSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicJobTicketSchema XMPMetadata.getBasicJobTicketSchema()"})
  void testGetBasicJobTicketSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getBasicJobTicketSchema());
  }

  /**
   * Test {@link XMPMetadata#getBasicJobTicketSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  @DisplayName("Test getBasicJobTicketSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicJobTicketSchema XMPMetadata.getBasicJobTicketSchema()"})
  void testGetBasicJobTicketSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getBasicJobTicketSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddXMPRightsManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddXMPRightsManagementSchema()}
   */
  @Test
  @DisplayName("Test createAndAddXMPRightsManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "XMPRightsManagementSchema XMPMetadata.createAndAddXMPRightsManagementSchema()"
  })
  void testCreateAndAddXMPRightsManagementSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualCreateAndAddXMPRightsManagementSchemaResult =
        createXMPMetadataResult.createAndAddXMPRightsManagementSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPRightsManagementSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/rights/",
        actualCreateAndAddXMPRightsManagementSchemaResult.getNamespace());
    assertEquals(
        "xmpRights", actualCreateAndAddXMPRightsManagementSchemaResult.getPreferedPrefix());
    assertEquals("xmpRights", actualCreateAndAddXMPRightsManagementSchemaResult.getPrefix());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getMarked());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getCertificate());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getUsageTerms());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getWebStatement());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getOwners());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getUsageTermsLanguages());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getOwnersProperty());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getUsageTermsProperty());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getMarkedProperty());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getCertificateProperty());
    assertNull(actualCreateAndAddXMPRightsManagementSchemaResult.getWebStatementProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddXMPRightsManagementSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddXMPRightsManagementSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddXMPRightsManagementSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/rights/"));
    assertSame(
        createXMPMetadataResult, actualCreateAndAddXMPRightsManagementSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getXMPRightsManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getXMPRightsManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPRightsManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPRightsManagementSchema XMPMetadata.getXMPRightsManagementSchema()"})
  void testGetXMPRightsManagementSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    XMPRightsManagementSchema obj = new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getXMPRightsManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPRightsManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getXMPRightsManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPRightsManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPRightsManagementSchema XMPMetadata.getXMPRightsManagementSchema()"})
  void testGetXMPRightsManagementSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getXMPRightsManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPRightsManagementSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getXMPRightsManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPRightsManagementSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPRightsManagementSchema XMPMetadata.getXMPRightsManagementSchema()"})
  void testGetXMPRightsManagementSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPRightsManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddXMPBasicSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddXMPBasicSchema()}
   */
  @Test
  @DisplayName("Test createAndAddXMPBasicSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicSchema XMPMetadata.createAndAddXMPBasicSchema()"})
  void testCreateAndAddXMPBasicSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualCreateAndAddXMPBasicSchemaResult =
        createXMPMetadataResult.createAndAddXMPBasicSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPBasicSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/", actualCreateAndAddXMPBasicSchemaResult.getNamespace());
    assertEquals("xmp", actualCreateAndAddXMPBasicSchemaResult.getPreferedPrefix());
    assertEquals("xmp", actualCreateAndAddXMPBasicSchemaResult.getPrefix());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getRating());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getBaseURL());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getCreatorTool());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getLabel());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getNickname());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getCreateDate());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getMetadataDate());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getModifierDate());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getModifyDate());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getAdvisory());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getIdentifiers());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getThumbnailsProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getAdvisoryProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getIdentifiersProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getCreateDateProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getMetadataDateProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getModifierDateProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getModifyDateProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getRatingProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getBaseURLProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getCreatorToolProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getLabelProperty());
    assertNull(actualCreateAndAddXMPBasicSchemaResult.getNicknameProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddXMPBasicSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddXMPBasicSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddXMPBasicSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/"));
    assertSame(createXMPMetadataResult, actualCreateAndAddXMPBasicSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getXMPBasicSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getXMPBasicSchema()}
   */
  @Test
  @DisplayName("Test getXMPBasicSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicSchema XMPMetadata.getXMPBasicSchema()"})
  void testGetXMPBasicSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getXMPBasicSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPBasicSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getXMPBasicSchema()}
   */
  @Test
  @DisplayName("Test getXMPBasicSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicSchema XMPMetadata.getXMPBasicSchema()"})
  void testGetXMPBasicSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPBasicSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPBasicSchema()}.
   *
   * <ul>
   *   <li>Then return {@link XMPBasicSchema#XMPBasicSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getXMPBasicSchema()}
   */
  @Test
  @DisplayName(
      "Test getXMPBasicSchema(); then return XMPBasicSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPBasicSchema XMPMetadata.getXMPBasicSchema()"})
  void testGetXMPBasicSchema_thenReturnXMPBasicSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    XMPBasicSchema obj = new XMPBasicSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getXMPBasicSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddXMPMediaManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddXMPMediaManagementSchema()}
   */
  @Test
  @DisplayName("Test createAndAddXMPMediaManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMediaManagementSchema XMPMetadata.createAndAddXMPMediaManagementSchema()"})
  void testCreateAndAddXMPMediaManagementSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualCreateAndAddXMPMediaManagementSchemaResult =
        createXMPMetadataResult.createAndAddXMPMediaManagementSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPMediaManagementSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/mm/",
        actualCreateAndAddXMPMediaManagementSchemaResult.getNamespace());
    assertEquals("xmpMM", actualCreateAndAddXMPMediaManagementSchemaResult.getPreferedPrefix());
    assertEquals("xmpMM", actualCreateAndAddXMPMediaManagementSchemaResult.getPrefix());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getSaveID());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getDocumentID());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getInstanceID());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getLastURL());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManageTo());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManageUI());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManager());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManagerVariant());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getOriginalDocumentID());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getRenditionClass());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getRenditionParams());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getVersionID());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getHistory());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getIngredients());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getVersions());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getHistoryProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getIngredientsProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getVersionsProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getSaveIDProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManagedFromProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getResourceRefProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getDocumentIDProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getInstanceIDProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManageToProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManageUIProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManagerProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getManagerVariantProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getOriginalDocumentIDProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getRenditionClassProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getRenditionParamsProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getVersionIDProperty());
    assertNull(actualCreateAndAddXMPMediaManagementSchemaResult.getLastURLProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddXMPMediaManagementSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddXMPMediaManagementSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddXMPMediaManagementSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/mm/"));
    assertSame(
        createXMPMetadataResult, actualCreateAndAddXMPMediaManagementSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#createAndAddPhotoshopSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddPhotoshopSchema()}
   */
  @Test
  @DisplayName("Test createAndAddPhotoshopSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhotoshopSchema XMPMetadata.createAndAddPhotoshopSchema()"})
  void testCreateAndAddPhotoshopSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualCreateAndAddPhotoshopSchemaResult =
        createXMPMetadataResult.createAndAddPhotoshopSchema();

    // Assert
    assertEquals("", actualCreateAndAddPhotoshopSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/photoshop/1.0/",
        actualCreateAndAddPhotoshopSchemaResult.getNamespace());
    assertEquals("photoshop", actualCreateAndAddPhotoshopSchemaResult.getPreferedPrefix());
    assertEquals("photoshop", actualCreateAndAddPhotoshopSchemaResult.getPrefix());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getColorMode());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getUrgency());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getAncestorID());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getAuthorsPosition());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCaptionWriter());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCategory());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCity());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCountry());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCredit());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getDateCreated());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getHeadline());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getHistory());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getICCProfile());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getInstructions());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getSource());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getState());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getSupplementalCategories());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getTransmissionReference());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getDocumentAncestors());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getTextLayers());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getDocumentAncestorsProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getDateCreatedProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getColorModeProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getUrgencyProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getAuthorsPositionProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCaptionWriterProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCategoryProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCityProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCountryProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getCreditProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getHeadlineProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getHistoryProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getICCProfileProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getInstructionsProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getSourceProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getStateProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getSupplementalCategoriesProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getTransmissionReferenceProperty());
    assertNull(actualCreateAndAddPhotoshopSchemaResult.getAncestorIDProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddPhotoshopSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddPhotoshopSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddPhotoshopSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/photoshop/1.0/"));
    assertSame(createXMPMetadataResult, actualCreateAndAddPhotoshopSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getPhotoshopSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  @DisplayName("Test getPhotoshopSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhotoshopSchema XMPMetadata.getPhotoshopSchema()"})
  void testGetPhotoshopSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getPhotoshopSchema());
  }

  /**
   * Test {@link XMPMetadata#getPhotoshopSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  @DisplayName("Test getPhotoshopSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhotoshopSchema XMPMetadata.getPhotoshopSchema()"})
  void testGetPhotoshopSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPhotoshopSchema());
  }

  /**
   * Test {@link XMPMetadata#getPhotoshopSchema()}.
   *
   * <ul>
   *   <li>Then return {@link PhotoshopSchema#PhotoshopSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  @DisplayName(
      "Test getPhotoshopSchema(); then return PhotoshopSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PhotoshopSchema XMPMetadata.getPhotoshopSchema()"})
  void testGetPhotoshopSchema_thenReturnPhotoshopSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    PhotoshopSchema obj = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getPhotoshopSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPMediaManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getXMPMediaManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPMediaManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMediaManagementSchema XMPMetadata.getXMPMediaManagementSchema()"})
  void testGetXMPMediaManagementSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    XMPMediaManagementSchema obj = new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getXMPMediaManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPMediaManagementSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getXMPMediaManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPMediaManagementSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMediaManagementSchema XMPMetadata.getXMPMediaManagementSchema()"})
  void testGetXMPMediaManagementSchema2() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getXMPMediaManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#getXMPMediaManagementSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getXMPMediaManagementSchema()}
   */
  @Test
  @DisplayName("Test getXMPMediaManagementSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XMPMediaManagementSchema XMPMetadata.getXMPMediaManagementSchema()"})
  void testGetXMPMediaManagementSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPMediaManagementSchema());
  }

  /**
   * Test {@link XMPMetadata#createAndAddAdobePDFSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#createAndAddAdobePDFSchema()}
   */
  @Test
  @DisplayName("Test createAndAddAdobePDFSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdobePDFSchema XMPMetadata.createAndAddAdobePDFSchema()"})
  void testCreateAndAddAdobePDFSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualCreateAndAddAdobePDFSchemaResult =
        createXMPMetadataResult.createAndAddAdobePDFSchema();

    // Assert
    assertEquals("", actualCreateAndAddAdobePDFSchemaResult.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/pdf/1.3/", actualCreateAndAddAdobePDFSchemaResult.getNamespace());
    assertEquals("pdf", actualCreateAndAddAdobePDFSchemaResult.getPreferedPrefix());
    assertEquals("pdf", actualCreateAndAddAdobePDFSchemaResult.getPrefix());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getKeywords());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getPDFVersion());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getProducer());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getKeywordsProperty());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getPDFVersionProperty());
    assertNull(actualCreateAndAddAdobePDFSchemaResult.getProducerProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    assertEquals(1, actualCreateAndAddAdobePDFSchemaResult.getAllAttributes().size());
    Map<String, String> allNamespacesWithPrefix =
        actualCreateAndAddAdobePDFSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualCreateAndAddAdobePDFSchemaResult.getAllProperties().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/pdf/1.3/"));
    assertSame(createXMPMetadataResult, actualCreateAndAddAdobePDFSchemaResult.getMetadata());
  }

  /**
   * Test {@link XMPMetadata#getAdobePDFSchema()}.
   *
   * <p>Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  @DisplayName("Test getAdobePDFSchema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdobePDFSchema XMPMetadata.getAdobePDFSchema()"})
  void testGetAdobePDFSchema() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    xmpMetadata.addSchema(new DublinCoreSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(xmpMetadata.getAdobePDFSchema());
  }

  /**
   * Test {@link XMPMetadata#getAdobePDFSchema()}.
   *
   * <ul>
   *   <li>Given createXMPMetadata.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  @DisplayName("Test getAdobePDFSchema(); given createXMPMetadata; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdobePDFSchema XMPMetadata.getAdobePDFSchema()"})
  void testGetAdobePDFSchema_givenCreateXMPMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getAdobePDFSchema());
  }

  /**
   * Test {@link XMPMetadata#getAdobePDFSchema()}.
   *
   * <ul>
   *   <li>Then return {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   *       createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  @DisplayName(
      "Test getAdobePDFSchema(); then return AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdobePDFSchema XMPMetadata.getAdobePDFSchema()"})
  void testGetAdobePDFSchema_thenReturnAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata xmpMetadata =
        new XMPMetadata(
            "Xpacket Begin", "42", "Xpacket Bytes", XmpConstants.DEFAULT_XPACKET_ENCODING);
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    xmpMetadata.addSchema(obj);

    // Act and Assert
    assertSame(obj, xmpMetadata.getAdobePDFSchema());
  }

  /**
   * Test {@link XMPMetadata#addSchema(XMPSchema)}.
   *
   * <ul>
   *   <li>Then createXMPMetadata AllSchemas size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPMetadata#addSchema(XMPSchema)}
   */
  @Test
  @DisplayName("Test addSchema(XMPSchema); then createXMPMetadata AllSchemas size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMetadata.addSchema(XMPSchema)"})
  void testAddSchema_thenCreateXMPMetadataAllSchemasSizeIsOne() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    createXMPMetadataResult.addSchema(obj);

    // Assert
    List<XMPSchema> allSchemas = createXMPMetadataResult.getAllSchemas();
    assertEquals(1, allSchemas.size());
    assertSame(obj, allSchemas.get(0));
    assertSame(obj, createXMPMetadataResult.getAdobePDFSchema());
  }
}
