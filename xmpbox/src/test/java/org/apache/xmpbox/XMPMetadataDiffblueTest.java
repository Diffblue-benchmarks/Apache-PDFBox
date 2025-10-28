package org.apache.xmpbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
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
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.junit.jupiter.api.Test;

class XMPMetadataDiffblueTest {
  /**
   * Method under test: {@link XMPMetadata#createXMPMetadata()}
   */
  @Test
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
    assertEquals(XmpConstants.DEFAULT_XPACKET_BEGIN, actualCreateXMPMetadataResult.getXpacketBegin());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualCreateXMPMetadataResult.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualCreateXMPMetadataResult.getEndXPacket());
    assertEquals(XmpConstants.DEFAULT_XPACKET_ID, actualCreateXMPMetadataResult.getXpacketId());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createXMPMetadata(String, String, String, String)}
   */
  @Test
  void testCreateXMPMetadata2() {
    // Arrange and Act
    XMPMetadata actualCreateXMPMetadataResult = XMPMetadata.createXMPMetadata("Xpacket Begin", "42", "Xpacket Bytes",
        XmpConstants.DEFAULT_XPACKET_ENCODING);

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
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualCreateXMPMetadataResult.getXpacketEncoding());
    assertEquals(XmpConstants.DEFAULT_XPACKET_END, actualCreateXMPMetadataResult.getEndXPacket());
  }

  /**
   * Method under test: {@link XMPMetadata#getAllSchemas()}
   */
  @Test
  void testGetAllSchemas() {
    // Arrange, Act and Assert
    assertTrue(XMPMetadata.createXMPMetadata().getAllSchemas().isEmpty());
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  void testGetSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getSchema("Ns URI"));
    assertNull(XMPMetadata.createXMPMetadata().getSchema("Prefix", "Ns URI"));
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  void testGetSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Ns URI"));
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String)}
   */
  @Test
  void testGetSchema3() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getSchema("http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  void testGetSchema4() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Prefix", "Ns URI"));
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  void testGetSchema5() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getSchema("Prefix", "http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Method under test: {@link XMPMetadata#getSchema(String, String)}
   */
  @Test
  void testGetSchema6() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getSchema("pdf", "http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddDefaultSchema(String, String)}
   */
  @Test
  void testCreateAndAddDefaultSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualCreateAndAddDefaultSchemaResult = createXMPMetadataResult.createAndAddDefaultSchema("Ns Prefix",
        "Ns URI");

    // Assert
    assertEquals("", actualCreateAndAddDefaultSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddDefaultSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddDefaultSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Ns Prefix", allNamespacesWithPrefix.get("Ns URI"));
    assertEquals("Ns Prefix", actualCreateAndAddDefaultSchemaResult.getPreferedPrefix());
    assertEquals("Ns Prefix", actualCreateAndAddDefaultSchemaResult.getPrefix());
    assertEquals("Ns URI", actualCreateAndAddDefaultSchemaResult.getNamespace());
    assertNull(actualCreateAndAddDefaultSchemaResult.getPropertyName());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddDefaultSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddDefaultSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddDefaultSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddDefaultSchemaResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddDefaultSchema(String, String)}
   */
  @Test
  void testCreateAndAddDefaultSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualCreateAndAddDefaultSchemaResult = createXMPMetadataResult.createAndAddDefaultSchema(null, "Ns URI");

    // Assert
    assertEquals("", actualCreateAndAddDefaultSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddDefaultSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("Ns URI", actualCreateAndAddDefaultSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddDefaultSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Ns URI"));
    assertNull(actualCreateAndAddDefaultSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddDefaultSchemaResult.getPreferedPrefix());
    assertNull(actualCreateAndAddDefaultSchemaResult.getPrefix());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddDefaultSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddDefaultSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddDefaultSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddDefaultSchemaResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithDefaultNS()}
   */
  @Test
  void testCreateAndAddPDFAExtensionSchemaWithDefaultNS() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult = createXMPMetadataResult
        .createAndAddPDFAExtensionSchemaWithDefaultNS();

    // Assert
    assertEquals("", actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/",
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaExtension", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPreferedPrefix());
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPrefix());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getSchemasProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties,
        actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddPDFAExtensionSchemaWithDefaultNSResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithNS(Map)}
   */
  @Test
  void testCreateAndAddPDFAExtensionSchemaWithNS() throws XmpSchemaException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAExtensionSchema actualCreateAndAddPDFAExtensionSchemaWithNSResult = createXMPMetadataResult
        .createAndAddPDFAExtensionSchemaWithNS(new HashMap<>());

    // Assert
    assertEquals("", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/",
        actualCreateAndAddPDFAExtensionSchemaWithNSResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddPDFAExtensionSchemaWithNSResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaExtension", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPreferedPrefix());
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPrefix());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getSchemasProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddPDFAExtensionSchemaWithNS(Map)}
   */
  @Test
  void testCreateAndAddPDFAExtensionSchemaWithNS2() throws XmpSchemaException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    HashMap<String, String> namespaces = new HashMap<>();
    namespaces.computeIfPresent(XmpConstants.RDF_NAMESPACE, mock(BiFunction.class));

    // Act
    PDFAExtensionSchema actualCreateAndAddPDFAExtensionSchemaWithNSResult = createXMPMetadataResult
        .createAndAddPDFAExtensionSchemaWithNS(namespaces);

    // Assert
    assertEquals("", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/extension/",
        actualCreateAndAddPDFAExtensionSchemaWithNSResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddPDFAExtensionSchemaWithNSResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaExtension", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/extension/"));
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPreferedPrefix());
    assertEquals("pdfaExtension", actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPrefix());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getPropertyName());
    assertNull(actualCreateAndAddPDFAExtensionSchemaWithNSResult.getSchemasProperty());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddPDFAExtensionSchemaWithNSResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddPDFAExtensionSchemaWithNSResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  void testGetPDFExtensionSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPDFExtensionSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  void testGetPDFExtensionSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getPDFExtensionSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFExtensionSchema()}
   */
  @Test
  void testGetPDFExtensionSchema3() {
    // Arrange
    PDFAExtensionSchema obj = new PDFAExtensionSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("http://www.aiim.org/pdfa/ns/extension/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getPDFExtensionSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddPDFAIdentificationSchema()}
   */
  @Test
  void testCreateAndAddPDFAIdentificationSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PDFAIdentificationSchema actualCreateAndAddPDFAIdentificationSchemaResult = createXMPMetadataResult
        .createAndAddPDFAIdentificationSchema();

    // Assert
    assertEquals("", actualCreateAndAddPDFAIdentificationSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddPDFAIdentificationSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://www.aiim.org/pdfa/ns/id/", actualCreateAndAddPDFAIdentificationSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddPDFAIdentificationSchemaResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdfaid", allNamespacesWithPrefix.get("http://www.aiim.org/pdfa/ns/id/"));
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
    List<Attribute> allAttributes = actualCreateAndAddPDFAIdentificationSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddPDFAIdentificationSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddPDFAIdentificationSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddPDFAIdentificationSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  void testGetPDFAIdentificationSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPDFAIdentificationSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  void testGetPDFAIdentificationSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getPDFAIdentificationSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPDFAIdentificationSchema()}
   */
  @Test
  void testGetPDFAIdentificationSchema3() {
    // Arrange
    PDFAIdentificationSchema obj = new PDFAIdentificationSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("http://www.aiim.org/pdfa/ns/id/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getPDFAIdentificationSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddDublinCoreSchema()}
   */
  @Test
  void testCreateAndAddDublinCoreSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    DublinCoreSchema actualCreateAndAddDublinCoreSchemaResult = createXMPMetadataResult.createAndAddDublinCoreSchema();

    // Assert
    assertEquals("", actualCreateAndAddDublinCoreSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddDublinCoreSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddDublinCoreSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("dc", allNamespacesWithPrefix.get("http://purl.org/dc/elements/1.1/"));
    assertEquals("dc", actualCreateAndAddDublinCoreSchemaResult.getPreferedPrefix());
    assertEquals("dc", actualCreateAndAddDublinCoreSchemaResult.getPrefix());
    assertEquals("http://purl.org/dc/elements/1.1/", actualCreateAndAddDublinCoreSchemaResult.getNamespace());
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
    List<Attribute> allAttributes = actualCreateAndAddDublinCoreSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddDublinCoreSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddDublinCoreSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddDublinCoreSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  void testGetDublinCoreSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getDublinCoreSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  void testGetDublinCoreSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getDublinCoreSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getDublinCoreSchema()}
   */
  @Test
  void testGetDublinCoreSchema3() {
    // Arrange
    DublinCoreSchema obj = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("http://purl.org/dc/elements/1.1/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getDublinCoreSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddBasicJobTicketSchema()}
   */
  @Test
  void testCreateAndAddBasicJobTicketSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicJobTicketSchema actualCreateAndAddBasicJobTicketSchemaResult = createXMPMetadataResult
        .createAndAddBasicJobTicketSchema();

    // Assert
    assertEquals("", actualCreateAndAddBasicJobTicketSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddBasicJobTicketSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/bj/", actualCreateAndAddBasicJobTicketSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddBasicJobTicketSchemaResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpBJ", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/bj/"));
    assertEquals("xmpBJ", actualCreateAndAddBasicJobTicketSchemaResult.getPreferedPrefix());
    assertEquals("xmpBJ", actualCreateAndAddBasicJobTicketSchemaResult.getPrefix());
    assertNull(actualCreateAndAddBasicJobTicketSchemaResult.getPropertyName());
    assertNull(actualCreateAndAddBasicJobTicketSchemaResult.getJobs());
    assertEquals(1, createXMPMetadataResult.getAllSchemas().size());
    List<Attribute> allAttributes = actualCreateAndAddBasicJobTicketSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddBasicJobTicketSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddBasicJobTicketSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddBasicJobTicketSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  void testGetBasicJobTicketSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getBasicJobTicketSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  void testGetBasicJobTicketSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getBasicJobTicketSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getBasicJobTicketSchema()}
   */
  @Test
  void testGetBasicJobTicketSchema3() {
    // Arrange
    XMPBasicJobTicketSchema obj = new XMPBasicJobTicketSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("http://ns.adobe.com/xap/1.0/bj/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getBasicJobTicketSchema());
  }

  /**
   * Method under test:
   * {@link XMPMetadata#createAndAddXMPRightsManagementSchema()}
   */
  @Test
  void testCreateAndAddXMPRightsManagementSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualCreateAndAddXMPRightsManagementSchemaResult = createXMPMetadataResult
        .createAndAddXMPRightsManagementSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPRightsManagementSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddXMPRightsManagementSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/",
        actualCreateAndAddXMPRightsManagementSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddXMPRightsManagementSchemaResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpRights", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/rights/"));
    assertEquals("xmpRights", actualCreateAndAddXMPRightsManagementSchemaResult.getPreferedPrefix());
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
    List<Attribute> allAttributes = actualCreateAndAddXMPRightsManagementSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddXMPRightsManagementSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddXMPRightsManagementSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddXMPRightsManagementSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPRightsManagementSchema()}
   */
  @Test
  void testGetXMPRightsManagementSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPRightsManagementSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPRightsManagementSchema()}
   */
  @Test
  void testGetXMPRightsManagementSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getXMPRightsManagementSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddXMPBasicSchema()}
   */
  @Test
  void testCreateAndAddXMPBasicSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPBasicSchema actualCreateAndAddXMPBasicSchemaResult = createXMPMetadataResult.createAndAddXMPBasicSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPBasicSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddXMPBasicSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/", actualCreateAndAddXMPBasicSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddXMPBasicSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmp", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/"));
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
    List<Attribute> allAttributes = actualCreateAndAddXMPBasicSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddXMPBasicSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddXMPBasicSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddXMPBasicSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPBasicSchema()}
   */
  @Test
  void testGetXMPBasicSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPBasicSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPBasicSchema()}
   */
  @Test
  void testGetXMPBasicSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getXMPBasicSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddXMPMediaManagementSchema()}
   */
  @Test
  void testCreateAndAddXMPMediaManagementSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualCreateAndAddXMPMediaManagementSchemaResult = createXMPMetadataResult
        .createAndAddXMPMediaManagementSchema();

    // Assert
    assertEquals("", actualCreateAndAddXMPMediaManagementSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddXMPMediaManagementSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualCreateAndAddXMPMediaManagementSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddXMPMediaManagementSchemaResult
        .getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpMM", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/mm/"));
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
    List<Attribute> allAttributes = actualCreateAndAddXMPMediaManagementSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddXMPMediaManagementSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddXMPMediaManagementSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddXMPMediaManagementSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddPhotoshopSchema()}
   */
  @Test
  void testCreateAndAddPhotoshopSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    PhotoshopSchema actualCreateAndAddPhotoshopSchemaResult = createXMPMetadataResult.createAndAddPhotoshopSchema();

    // Assert
    assertEquals("", actualCreateAndAddPhotoshopSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddPhotoshopSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/photoshop/1.0/", actualCreateAndAddPhotoshopSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddPhotoshopSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("photoshop", allNamespacesWithPrefix.get("http://ns.adobe.com/photoshop/1.0/"));
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
    List<Attribute> allAttributes = actualCreateAndAddPhotoshopSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddPhotoshopSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddPhotoshopSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddPhotoshopSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  void testGetPhotoshopSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getPhotoshopSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  void testGetPhotoshopSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getPhotoshopSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getPhotoshopSchema()}
   */
  @Test
  void testGetPhotoshopSchema3() {
    // Arrange
    PhotoshopSchema obj = new PhotoshopSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("http://ns.adobe.com/photoshop/1.0/", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getPhotoshopSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPMediaManagementSchema()}
   */
  @Test
  void testGetXMPMediaManagementSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getXMPMediaManagementSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getXMPMediaManagementSchema()}
   */
  @Test
  void testGetXMPMediaManagementSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertNull(createXMPMetadataResult.getXMPMediaManagementSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#createAndAddAdobePDFSchema()}
   */
  @Test
  void testCreateAndAddAdobePDFSchema() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    AdobePDFSchema actualCreateAndAddAdobePDFSchemaResult = createXMPMetadataResult.createAndAddAdobePDFSchema();

    // Assert
    assertEquals("", actualCreateAndAddAdobePDFSchemaResult.getAboutValue());
    Attribute aboutAttribute = actualCreateAndAddAdobePDFSchemaResult.getAboutAttribute();
    assertEquals("", aboutAttribute.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualCreateAndAddAdobePDFSchemaResult.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualCreateAndAddAdobePDFSchemaResult.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("pdf", allNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
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
    List<Attribute> allAttributes = actualCreateAndAddAdobePDFSchemaResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<AbstractField> allProperties = actualCreateAndAddAdobePDFSchemaResult.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertEquals(XmpConstants.ABOUT_NAME, aboutAttribute.getName());
    assertEquals(XmpConstants.RDF_NAMESPACE, aboutAttribute.getNamespace());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(allProperties, actualCreateAndAddAdobePDFSchemaResult.getContainer().getAllProperties());
    assertSame(createXMPMetadataResult, actualCreateAndAddAdobePDFSchemaResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  void testGetAdobePDFSchema() {
    // Arrange, Act and Assert
    assertNull(XMPMetadata.createXMPMetadata().getAdobePDFSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  void testGetAdobePDFSchema2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertSame(obj, createXMPMetadataResult.getAdobePDFSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#getAdobePDFSchema()}
   */
  @Test
  void testGetAdobePDFSchema3() {
    // Arrange
    DublinCoreSchema obj = new DublinCoreSchema(XMPMetadata.createXMPMetadata());
    obj.addBagValueAsSimple("Simple Name", "http://ns.adobe.com/pdf/1.3/");
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(obj);

    // Act and Assert
    assertNull(createXMPMetadataResult.getAdobePDFSchema());
  }

  /**
   * Method under test: {@link XMPMetadata#addSchema(XMPSchema)}
   */
  @Test
  void testAddSchema() {
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

  /**
   * Method under test: {@link XMPMetadata#clearSchemas()}
   */
  @Test
  void testClearSchemas() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    createXMPMetadataResult.clearSchemas();

    // Assert
    assertNull(createXMPMetadataResult.getAdobePDFSchema());
    assertNull(createXMPMetadataResult.getDublinCoreSchema());
    assertNull(createXMPMetadataResult.getPDFExtensionSchema());
    assertNull(createXMPMetadataResult.getPDFAIdentificationSchema());
    assertNull(createXMPMetadataResult.getPhotoshopSchema());
    assertNull(createXMPMetadataResult.getBasicJobTicketSchema());
    assertNull(createXMPMetadataResult.getXMPBasicSchema());
    assertNull(createXMPMetadataResult.getXMPMediaManagementSchema());
    assertNull(createXMPMetadataResult.getXMPRightsManagementSchema());
    assertTrue(createXMPMetadataResult.getAllSchemas().isEmpty());
  }

  /**
   * Method under test: {@link XMPMetadata#clearSchemas()}
   */
  @Test
  void testClearSchemas2() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();
    createXMPMetadataResult.addSchema(mock(AdobePDFSchema.class));

    // Act
    createXMPMetadataResult.clearSchemas();

    // Assert
    assertNull(createXMPMetadataResult.getAdobePDFSchema());
    assertNull(createXMPMetadataResult.getDublinCoreSchema());
    assertNull(createXMPMetadataResult.getPDFExtensionSchema());
    assertNull(createXMPMetadataResult.getPDFAIdentificationSchema());
    assertNull(createXMPMetadataResult.getPhotoshopSchema());
    assertNull(createXMPMetadataResult.getBasicJobTicketSchema());
    assertNull(createXMPMetadataResult.getXMPBasicSchema());
    assertNull(createXMPMetadataResult.getXMPMediaManagementSchema());
    assertNull(createXMPMetadataResult.getXMPRightsManagementSchema());
    assertTrue(createXMPMetadataResult.getAllSchemas().isEmpty());
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange
    XMPMetadata createXMPMetadataResult = XMPMetadata.createXMPMetadata();

    // Act
    createXMPMetadataResult.setEndXPacket("Data");
    String actualEndXPacket = createXMPMetadataResult.getEndXPacket();
    createXMPMetadataResult.getTypeMapping();
    String actualXpacketBegin = createXMPMetadataResult.getXpacketBegin();
    createXMPMetadataResult.getXpacketBytes();
    String actualXpacketEncoding = createXMPMetadataResult.getXpacketEncoding();

    // Assert that nothing has changed
    assertEquals("Data", actualEndXPacket);
    assertEquals(XmpConstants.DEFAULT_XPACKET_BEGIN, actualXpacketBegin);
    assertEquals(XmpConstants.DEFAULT_XPACKET_ENCODING, actualXpacketEncoding);
    assertEquals(XmpConstants.DEFAULT_XPACKET_ID, createXMPMetadataResult.getXpacketId());
  }

  /**
   * Method under test: {@link XMPMetadata#XMPMetadata()}
   */
  @Test
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
   * Method under test:
   * {@link XMPMetadata#XMPMetadata(String, String, String, String)}
   */
  @Test
  void testNewXMPMetadata2() {
    // Arrange and Act
    XMPMetadata actualXmpMetadata = new XMPMetadata("Xpacket Begin", "42", "Xpacket Bytes",
        XmpConstants.DEFAULT_XPACKET_ENCODING);

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
}
