package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.RenditionClassType;
import org.apache.xmpbox.type.ResourceRefType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URIType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPMediaManagementSchemaDiffblueTest {
  /**
   * Test {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPMediaManagementSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.<init>(XMPMetadata)"})
  void testNewXMPMediaManagementSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema =
        new XMPMediaManagementSchema(metadata);

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpMediaManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/mm/"));
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code xmpMM}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new XMPMediaManagementSchema(XMPMetadata, String); when 'null'; then return Prefix is 'xmpMM'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.<init>(XMPMetadata, String)"})
  void testNewXMPMediaManagementSchema_whenNull_thenReturnPrefixIsXmpMM() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema =
        new XMPMediaManagementSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpMediaManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/mm/"));
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Own Prefix}.
   *   <li>Then return Prefix is {@code Own Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new XMPMediaManagementSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.<init>(XMPMetadata, String)"})
  void testNewXMPMediaManagementSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPMediaManagementSchema actualXmpMediaManagementSchema =
        new XMPMediaManagementSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpMediaManagementSchema.getAboutValue());
    assertEquals("Own Prefix", actualXmpMediaManagementSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualXmpMediaManagementSchema.getNamespace());
    assertEquals("xmpMM", actualXmpMediaManagementSchema.getPreferedPrefix());
    assertNull(actualXmpMediaManagementSchema.getSaveID());
    assertNull(actualXmpMediaManagementSchema.getDocumentID());
    assertNull(actualXmpMediaManagementSchema.getInstanceID());
    assertNull(actualXmpMediaManagementSchema.getLastURL());
    assertNull(actualXmpMediaManagementSchema.getManageTo());
    assertNull(actualXmpMediaManagementSchema.getManageUI());
    assertNull(actualXmpMediaManagementSchema.getManager());
    assertNull(actualXmpMediaManagementSchema.getManagerVariant());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentID());
    assertNull(actualXmpMediaManagementSchema.getRenditionClass());
    assertNull(actualXmpMediaManagementSchema.getRenditionParams());
    assertNull(actualXmpMediaManagementSchema.getVersionID());
    assertNull(actualXmpMediaManagementSchema.getPropertyName());
    assertNull(actualXmpMediaManagementSchema.getHistory());
    assertNull(actualXmpMediaManagementSchema.getIngredients());
    assertNull(actualXmpMediaManagementSchema.getVersions());
    assertNull(actualXmpMediaManagementSchema.getHistoryProperty());
    assertNull(actualXmpMediaManagementSchema.getIngredientsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionsProperty());
    assertNull(actualXmpMediaManagementSchema.getAboutAttribute());
    assertNull(actualXmpMediaManagementSchema.getSaveIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManagedFromProperty());
    assertNull(actualXmpMediaManagementSchema.getResourceRefProperty());
    assertNull(actualXmpMediaManagementSchema.getDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getInstanceIDProperty());
    assertNull(actualXmpMediaManagementSchema.getManageToProperty());
    assertNull(actualXmpMediaManagementSchema.getManageUIProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerProperty());
    assertNull(actualXmpMediaManagementSchema.getManagerVariantProperty());
    assertNull(actualXmpMediaManagementSchema.getOriginalDocumentIDProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionClassProperty());
    assertNull(actualXmpMediaManagementSchema.getRenditionParamsProperty());
    assertNull(actualXmpMediaManagementSchema.getVersionIDProperty());
    assertNull(actualXmpMediaManagementSchema.getLastURLProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpMediaManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpMediaManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpMediaManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/mm/"));
    assertSame(metadata, actualXmpMediaManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setDerivedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDerivedFromProperty(ResourceRefType)"})
  void testSetDerivedFromProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setDerivedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDerivedFromProperty(ResourceRefType)"})
  void testSetDerivedFromProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult.getPropertyName());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDerivedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setDerivedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDerivedFromProperty(ResourceRefType)"})
  void testSetDerivedFromProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("42");
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType tt = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setDerivedFromProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult2).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, getResult.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult2.getPropertyName());
    assertSame(tt, allProperties.get(2));
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getResourceRefProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  @DisplayName("Test getResourceRefProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getResourceRefProperty()"})
  void testGetResourceRefProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getResourceRefProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getResourceRefProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  @DisplayName("Test getResourceRefProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getResourceRefProperty()"})
  void testGetResourceRefProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getResourceRefProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getResourceRefProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getResourceRefProperty()}
   */
  @Test
  @DisplayName("Test getResourceRefProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getResourceRefProperty()"})
  void testGetResourceRefProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getResourceRefProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  @DisplayName("Test setDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentID(String)"})
  void testSetDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  @DisplayName("Test setDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentID(String)"})
  void testSetDocumentID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  @DisplayName("Test setDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentID(String)"})
  void testSetDocumentID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.DOCUMENTID, "42");

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentID(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentID(String)}
   */
  @Test
  @DisplayName(
      "Test setDocumentID(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentID(String)"})
  void testSetDocumentID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setDocumentID("https://example.org/example");

    // Assert
    TextType documentIDProperty = xmpMediaManagementSchema.getDocumentIDProperty();
    assertTrue(documentIDProperty instanceof URIType);
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getDocumentID());
    assertEquals("https://example.org/example", documentIDProperty.getStringValue());
    assertEquals("https://example.org/example", documentIDProperty.getRawValue());
    assertEquals("https://example.org/example", documentIDProperty.getValue());
    assertEquals("xmpMM", documentIDProperty.getPrefix());
    assertNull(documentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(documentIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.DOCUMENTID, documentIDProperty.getPropertyName());
    assertSame(metadata, documentIDProperty.getMetadata());
    assertSame(documentIDProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setDocumentIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentIDProperty(URIType)"})
  void testSetDocumentIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setDocumentIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentIDProperty(URIType)"})
  void testSetDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setDocumentIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentIDProperty(URIType)"})
  void testSetDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setDocumentIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setDocumentIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setDocumentIDProperty(URIType)"})
  void testSetDocumentIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getDocumentIDProperty()"})
  void testGetDocumentIDProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getDocumentIDProperty()"})
  void testGetDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getDocumentIDProperty()"})
  void testGetDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getDocumentID()"})
  void testGetDocumentID() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  @DisplayName("Test getDocumentID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getDocumentID()"})
  void testGetDocumentID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getDocumentID()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getDocumentID()}
   */
  @Test
  @DisplayName(
      "Test getDocumentID(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getDocumentID()"})
  void testGetDocumentID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURL(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  @DisplayName("Test setLastURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURL(String)"})
  void testSetLastURL() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(1));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURL(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  @DisplayName("Test setLastURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURL(String)"})
  void testSetLastURL2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURL(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  @DisplayName("Test setLastURL(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURL(String)"})
  void testSetLastURL3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.LAST_URL, "42");

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(0));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURL(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURL(String)}
   */
  @Test
  @DisplayName(
      "Test setLastURL(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURL(String)"})
  void testSetLastURL_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setLastURL("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getLastURL());
    URLType lastURLProperty = xmpMediaManagementSchema.getLastURLProperty();
    assertEquals("https://example.org/example", lastURLProperty.getStringValue());
    assertEquals("https://example.org/example", lastURLProperty.getRawValue());
    assertEquals("https://example.org/example", lastURLProperty.getValue());
    assertEquals("xmpMM", lastURLProperty.getPrefix());
    assertNull(lastURLProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(lastURLProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.LAST_URL, lastURLProperty.getPropertyName());
    assertSame(lastURLProperty, allProperties.get(0));
    assertSame(metadata, lastURLProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setLastURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURLProperty(URLType)"})
  void testSetLastURLProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URLType tt =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setLastURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURLProperty(URLType)"})
  void testSetLastURLProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URLType tt =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setLastURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURLProperty(URLType)"})
  void testSetLastURLProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("https://example.org/example");
    xmpMediaManagementSchema.addVersions("42");
    URLType tt =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setLastURLProperty(URLType)}
   */
  @Test
  @DisplayName("Test setLastURLProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setLastURLProperty(URLType)"})
  void testSetLastURLProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "https://example.org/example", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URLType tt =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpMediaManagementSchema.setLastURLProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURLProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  @DisplayName("Test getLastURLProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URLType XMPMediaManagementSchema.getLastURLProperty()"})
  void testGetLastURLProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getLastURLProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURLProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  @DisplayName("Test getLastURLProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URLType XMPMediaManagementSchema.getLastURLProperty()"})
  void testGetLastURLProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURLProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURLProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURLProperty()}
   */
  @Test
  @DisplayName("Test getLastURLProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"URLType XMPMediaManagementSchema.getLastURLProperty()"})
  void testGetLastURLProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURLProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURL()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  @DisplayName("Test getLastURL()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getLastURL()"})
  void testGetLastURL() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURL());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURL()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  @DisplayName("Test getLastURL()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getLastURL()"})
  void testGetLastURL2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getLastURL());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getLastURL()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getLastURL()}
   */
  @Test
  @DisplayName(
      "Test getLastURL(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getLastURL()"})
  void testGetLastURL_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getLastURL());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveId(Integer)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  @DisplayName("Test setSaveId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveId(Integer)"})
  void testSetSaveId() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    assertEquals(1, ((Integer) saveIDProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(1));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveId(Integer)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  @DisplayName("Test setSaveId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveId(Integer)"})
  void testSetSaveId2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveId(Integer)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  @DisplayName("Test setSaveId(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveId(Integer)"})
  void testSetSaveId3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.SAVE_ID, "42");

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    assertEquals(1, ((Integer) saveIDProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(0));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveId(Integer)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveId(Integer)}
   */
  @Test
  @DisplayName(
      "Test setSaveId(Integer); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveId(Integer)"})
  void testSetSaveId_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setSaveId(1);

    // Assert
    IntegerType saveIDProperty = xmpMediaManagementSchema.getSaveIDProperty();
    assertEquals("1", saveIDProperty.getStringValue());
    assertEquals("xmpMM", saveIDProperty.getPrefix());
    assertNull(saveIDProperty.getNamespace());
    assertEquals(1, xmpMediaManagementSchema.getSaveID().intValue());
    assertEquals(1, saveIDProperty.getValue().intValue());
    assertEquals(1, ((Integer) saveIDProperty.getRawValue()).intValue());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(saveIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.SAVE_ID, saveIDProperty.getPropertyName());
    assertSame(saveIDProperty, allProperties.get(0));
    assertSame(metadata, saveIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setSaveIDProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveIDProperty(IntegerType)"})
  void testSetSaveIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    IntegerType tt =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setSaveIDProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveIDProperty(IntegerType)"})
  void testSetSaveIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setSaveIDProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveIDProperty(IntegerType)"})
  void testSetSaveIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setSaveIDProperty(IntegerType)}
   */
  @Test
  @DisplayName("Test setSaveIDProperty(IntegerType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setSaveIDProperty(IntegerType)"})
  void testSetSaveIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple("Property Name", XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("Value");
    IntegerType tt =
        new IntegerType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42);

    // Act
    xmpMediaManagementSchema.setSaveIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  @DisplayName("Test getSaveIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPMediaManagementSchema.getSaveIDProperty()"})
  void testGetSaveIDProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getSaveIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  @DisplayName("Test getSaveIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPMediaManagementSchema.getSaveIDProperty()"})
  void testGetSaveIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveIDProperty()}
   */
  @Test
  @DisplayName("Test getSaveIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IntegerType XMPMediaManagementSchema.getSaveIDProperty()"})
  void testGetSaveIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  @DisplayName("Test getSaveID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPMediaManagementSchema.getSaveID()"})
  void testGetSaveID() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  @DisplayName("Test getSaveID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPMediaManagementSchema.getSaveID()"})
  void testGetSaveID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getSaveID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getSaveID()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getSaveID()}
   */
  @Test
  @DisplayName(
      "Test getSaveID(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer XMPMediaManagementSchema.getSaveID()"})
  void testGetSaveID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getSaveID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManager(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  @DisplayName("Test setManager(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManager(String)"})
  void testSetManager() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManager(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  @DisplayName("Test setManager(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManager(String)"})
  void testSetManager2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManager(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  @DisplayName("Test setManager(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManager(String)"})
  void testSetManager3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGER, "42");

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManager(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManager(String)}
   */
  @Test
  @DisplayName(
      "Test setManager(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManager(String)"})
  void testSetManager_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManager("42");

    // Assert
    TextType managerProperty = xmpMediaManagementSchema.getManagerProperty();
    assertTrue(managerProperty instanceof AgentNameType);
    assertEquals("42", xmpMediaManagementSchema.getManager());
    assertEquals("42", managerProperty.getStringValue());
    assertEquals("42", managerProperty.getRawValue());
    assertEquals("42", managerProperty.getValue());
    assertEquals("xmpMM", managerProperty.getPrefix());
    assertNull(managerProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGER, managerProperty.getPropertyName());
    assertSame(metadata, managerProperty.getMetadata());
    assertSame(managerProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setManagerProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerProperty(AgentNameType)"})
  void testSetManagerProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType tt =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setManagerProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerProperty(AgentNameType)"})
  void testSetManagerProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setManagerProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerProperty(AgentNameType)"})
  void testSetManagerProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerProperty(AgentNameType)}
   */
  @Test
  @DisplayName("Test setManagerProperty(AgentNameType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerProperty(AgentNameType)"})
  void testSetManagerProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    AgentNameType tt =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  @DisplayName("Test getManagerProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerProperty()"})
  void testGetManagerProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManagerProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  @DisplayName("Test getManagerProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerProperty()"})
  void testGetManagerProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerProperty()}
   */
  @Test
  @DisplayName("Test getManagerProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerProperty()"})
  void testGetManagerProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManager()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  @DisplayName("Test getManager()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManager()"})
  void testGetManager() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManager());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManager()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  @DisplayName("Test getManager()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManager()"})
  void testGetManager2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManager());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManager()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManager()}
   */
  @Test
  @DisplayName(
      "Test getManager(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManager()"})
  void testGetManager_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManager());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageTo(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  @DisplayName("Test setManageTo(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageTo(String)"})
  void testSetManageTo() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageTo(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  @DisplayName("Test setManageTo(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageTo(String)"})
  void testSetManageTo2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageTo(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  @DisplayName("Test setManageTo(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageTo(String)"})
  void testSetManageTo3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGETO, "42");

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageTo(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageTo(String)}
   */
  @Test
  @DisplayName(
      "Test setManageTo(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageTo(String)"})
  void testSetManageTo_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManageTo("42");

    // Assert
    TextType manageToProperty = xmpMediaManagementSchema.getManageToProperty();
    assertTrue(manageToProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageTo());
    assertEquals("42", manageToProperty.getStringValue());
    assertEquals("42", manageToProperty.getRawValue());
    assertEquals("42", manageToProperty.getValue());
    assertEquals("xmpMM", manageToProperty.getPrefix());
    assertNull(manageToProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageToProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGETO, manageToProperty.getPropertyName());
    assertSame(metadata, manageToProperty.getMetadata());
    assertSame(manageToProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageToProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageToProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageToProperty(URIType)"})
  void testSetManageToProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageToProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageToProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageToProperty(URIType)"})
  void testSetManageToProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageToProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageToProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageToProperty(URIType)"})
  void testSetManageToProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageToProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageToProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageToProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageToProperty(URIType)"})
  void testSetManageToProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageToProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageToProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  @DisplayName("Test getManageToProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageToProperty()"})
  void testGetManageToProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManageToProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageToProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  @DisplayName("Test getManageToProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageToProperty()"})
  void testGetManageToProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageToProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageToProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageToProperty()}
   */
  @Test
  @DisplayName("Test getManageToProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageToProperty()"})
  void testGetManageToProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageToProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageTo()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  @DisplayName("Test getManageTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageTo()"})
  void testGetManageTo() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageTo());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageTo()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  @DisplayName("Test getManageTo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageTo()"})
  void testGetManageTo2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageTo());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageTo()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageTo()}
   */
  @Test
  @DisplayName(
      "Test getManageTo(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageTo()"})
  void testGetManageTo_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManageTo());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUI(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  @DisplayName("Test setManageUI(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUI(String)"})
  void testSetManageUI() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUI(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  @DisplayName("Test setManageUI(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUI(String)"})
  void testSetManageUI2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUI(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  @DisplayName("Test setManageUI(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUI(String)"})
  void testSetManageUI3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGEUI, "42");

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUI(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUI(String)}
   */
  @Test
  @DisplayName(
      "Test setManageUI(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUI(String)"})
  void testSetManageUI_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManageUI("42");

    // Assert
    TextType manageUIProperty = xmpMediaManagementSchema.getManageUIProperty();
    assertTrue(manageUIProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getManageUI());
    assertEquals("42", manageUIProperty.getStringValue());
    assertEquals("42", manageUIProperty.getRawValue());
    assertEquals("42", manageUIProperty.getValue());
    assertEquals("xmpMM", manageUIProperty.getPrefix());
    assertNull(manageUIProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(manageUIProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGEUI, manageUIProperty.getPropertyName());
    assertSame(metadata, manageUIProperty.getMetadata());
    assertSame(manageUIProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageUIProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUIProperty(URIType)"})
  void testSetManageUIProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageUIProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUIProperty(URIType)"})
  void testSetManageUIProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageUIProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUIProperty(URIType)"})
  void testSetManageUIProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManageUIProperty(URIType)}
   */
  @Test
  @DisplayName("Test setManageUIProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManageUIProperty(URIType)"})
  void testSetManageUIProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManageUIProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUIProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  @DisplayName("Test getManageUIProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageUIProperty()"})
  void testGetManageUIProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManageUIProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUIProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  @DisplayName("Test getManageUIProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageUIProperty()"})
  void testGetManageUIProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUIProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUIProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUIProperty()}
   */
  @Test
  @DisplayName("Test getManageUIProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManageUIProperty()"})
  void testGetManageUIProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUIProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUI()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  @DisplayName("Test getManageUI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageUI()"})
  void testGetManageUI() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUI());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUI()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  @DisplayName("Test getManageUI()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageUI()"})
  void testGetManageUI2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManageUI());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManageUI()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManageUI()}
   */
  @Test
  @DisplayName(
      "Test getManageUI(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManageUI()"})
  void testGetManageUI_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManageUI());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariant(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  @DisplayName("Test setManagerVariant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariant(String)"})
  void testSetManagerVariant() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(0));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariant(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  @DisplayName("Test setManagerVariant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariant(String)"})
  void testSetManagerVariant2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(1));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariant(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  @DisplayName("Test setManagerVariant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariant(String)"})
  void testSetManagerVariant3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariant(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariant(String)}
   */
  @Test
  @DisplayName("Test setManagerVariant(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariant(String)"})
  void testSetManagerVariant4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.MANAGERVARIANT, "42");

    // Act
    xmpMediaManagementSchema.setManagerVariant("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getManagerVariant());
    TextType managerVariantProperty = xmpMediaManagementSchema.getManagerVariantProperty();
    assertEquals("42", managerVariantProperty.getStringValue());
    assertEquals("42", managerVariantProperty.getRawValue());
    assertEquals("42", managerVariantProperty.getValue());
    assertEquals("xmpMM", managerVariantProperty.getPrefix());
    assertNull(managerVariantProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(managerVariantProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.MANAGERVARIANT, managerVariantProperty.getPropertyName());
    assertSame(managerVariantProperty, allProperties.get(0));
    assertSame(metadata, managerVariantProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  @DisplayName("Test setManagerVariantProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariantProperty(TextType)"})
  void testSetManagerVariantProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  @DisplayName("Test setManagerVariantProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariantProperty(TextType)"})
  void testSetManagerVariantProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  @DisplayName("Test setManagerVariantProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariantProperty(TextType)"})
  void testSetManagerVariantProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagerVariantProperty(TextType)}
   */
  @Test
  @DisplayName("Test setManagerVariantProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagerVariantProperty(TextType)"})
  void testSetManagerVariantProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setManagerVariantProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariantProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  @DisplayName("Test getManagerVariantProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerVariantProperty()"})
  void testGetManagerVariantProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManagerVariantProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariantProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  @DisplayName("Test getManagerVariantProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerVariantProperty()"})
  void testGetManagerVariantProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariantProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariantProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariantProperty()}
   */
  @Test
  @DisplayName("Test getManagerVariantProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getManagerVariantProperty()"})
  void testGetManagerVariantProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariantProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariant()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  @DisplayName("Test getManagerVariant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManagerVariant()"})
  void testGetManagerVariant() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManagerVariant());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariant()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  @DisplayName("Test getManagerVariant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManagerVariant()"})
  void testGetManagerVariant2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariant());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagerVariant()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagerVariant()}
   */
  @Test
  @DisplayName("Test getManagerVariant()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getManagerVariant()"})
  void testGetManagerVariant3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagerVariant());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  @DisplayName("Test setInstanceID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceID(String)"})
  void testSetInstanceID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  @DisplayName("Test setInstanceID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceID(String)"})
  void testSetInstanceID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  @DisplayName("Test setInstanceID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceID(String)"})
  void testSetInstanceID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.INSTANCEID, "42");

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceID(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceID(String)}
   */
  @Test
  @DisplayName(
      "Test setInstanceID(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceID(String)"})
  void testSetInstanceID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setInstanceID("42");

    // Assert
    TextType instanceIDProperty = xmpMediaManagementSchema.getInstanceIDProperty();
    assertTrue(instanceIDProperty instanceof URIType);
    assertEquals("42", xmpMediaManagementSchema.getInstanceID());
    assertEquals("42", instanceIDProperty.getStringValue());
    assertEquals("42", instanceIDProperty.getRawValue());
    assertEquals("42", instanceIDProperty.getValue());
    assertEquals("xmpMM", instanceIDProperty.getPrefix());
    assertNull(instanceIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(instanceIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.INSTANCEID, instanceIDProperty.getPropertyName());
    assertSame(metadata, instanceIDProperty.getMetadata());
    assertSame(instanceIDProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setInstanceIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceIDProperty(URIType)"})
  void testSetInstanceIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setInstanceIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceIDProperty(URIType)"})
  void testSetInstanceIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setInstanceIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceIDProperty(URIType)"})
  void testSetInstanceIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setInstanceIDProperty(URIType)}
   */
  @Test
  @DisplayName("Test setInstanceIDProperty(URIType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setInstanceIDProperty(URIType)"})
  void testSetInstanceIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    URIType tt =
        new URIType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setInstanceIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  @DisplayName("Test getInstanceIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getInstanceIDProperty()"})
  void testGetInstanceIDProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getInstanceIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  @DisplayName("Test getInstanceIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getInstanceIDProperty()"})
  void testGetInstanceIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceIDProperty()}
   */
  @Test
  @DisplayName("Test getInstanceIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getInstanceIDProperty()"})
  void testGetInstanceIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getInstanceID()"})
  void testGetInstanceID() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  @DisplayName("Test getInstanceID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getInstanceID()"})
  void testGetInstanceID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getInstanceID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getInstanceID()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getInstanceID()}
   */
  @Test
  @DisplayName(
      "Test getInstanceID(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getInstanceID()"})
  void testGetInstanceID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getInstanceID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setManagedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagedFromProperty(ResourceRefType)"})
  void testSetManagedFromProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(resourceRef, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setManagedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagedFromProperty(ResourceRefType)"})
  void testSetManagedFromProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult.getPropertyName());
    assertSame(resourceRef, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setManagedFromProperty(ResourceRefType)}
   */
  @Test
  @DisplayName("Test setManagedFromProperty(ResourceRefType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setManagedFromProperty(ResourceRefType)"})
  void testSetManagedFromProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("42");
    xmpMediaManagementSchema.addVersions("42");
    ResourceRefType resourceRef = new ResourceRefType(XMPMetadata.createXMPMetadata());

    // Act
    xmpMediaManagementSchema.setManagedFromProperty(resourceRef);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", getResult2.getNamespace());
    assertEquals("xmpMM", getResult2.getPrefix());
    assertEquals(1, ((ArrayProperty) getResult2).getAllProperties().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, getResult.getPropertyName());
    assertEquals(XMPMediaManagementSchema.VERSIONS, getResult2.getPropertyName());
    assertSame(resourceRef, allProperties.get(2));
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagedFromProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  @DisplayName("Test getManagedFromProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getManagedFromProperty()"})
  void testGetManagedFromProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getManagedFromProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagedFromProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  @DisplayName("Test getManagedFromProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getManagedFromProperty()"})
  void testGetManagedFromProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagedFromProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getManagedFromProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getManagedFromProperty()}
   */
  @Test
  @DisplayName("Test getManagedFromProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResourceRefType XMPMediaManagementSchema.getManagedFromProperty()"})
  void testGetManagedFromProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getManagedFromProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentID(String)"})
  void testSetOriginalDocumentID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(0));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentID(String)"})
  void testSetOriginalDocumentID2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(1));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentID(String)"})
  void testSetOriginalDocumentID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentID(String)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentID(String)"})
  void testSetOriginalDocumentID4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.ORIGINALDOCUMENTID, "42");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentID("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getOriginalDocumentID());
    TextType originalDocumentIDProperty = xmpMediaManagementSchema.getOriginalDocumentIDProperty();
    assertEquals("https://example.org/example", originalDocumentIDProperty.getStringValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getRawValue());
    assertEquals("https://example.org/example", originalDocumentIDProperty.getValue());
    assertEquals("xmpMM", originalDocumentIDProperty.getPrefix());
    assertNull(originalDocumentIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(originalDocumentIDProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.ORIGINALDOCUMENTID, originalDocumentIDProperty.getPropertyName());
    assertSame(originalDocumentIDProperty, allProperties.get(0));
    assertSame(metadata, originalDocumentIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentIDProperty(TextType)"})
  void testSetOriginalDocumentIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentIDProperty(TextType)"})
  void testSetOriginalDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentIDProperty(TextType)"})
  void testSetOriginalDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setOriginalDocumentIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setOriginalDocumentIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setOriginalDocumentIDProperty(TextType)"})
  void testSetOriginalDocumentIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setOriginalDocumentIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getOriginalDocumentIDProperty()"})
  void testGetOriginalDocumentIDProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata())
            .getOriginalDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getOriginalDocumentIDProperty()"})
  void testGetOriginalDocumentIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentIDProperty()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getOriginalDocumentIDProperty()"})
  void testGetOriginalDocumentIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getOriginalDocumentID()"})
  void testGetOriginalDocumentID() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getOriginalDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getOriginalDocumentID()"})
  void testGetOriginalDocumentID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getOriginalDocumentID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getOriginalDocumentID()}
   */
  @Test
  @DisplayName("Test getOriginalDocumentID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getOriginalDocumentID()"})
  void testGetOriginalDocumentID3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getOriginalDocumentID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClass(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  @DisplayName("Test setRenditionClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClass(String)"})
  void testSetRenditionClass() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClass(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  @DisplayName("Test setRenditionClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClass(String)"})
  void testSetRenditionClass2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClass(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  @DisplayName("Test setRenditionClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClass(String)"})
  void testSetRenditionClass3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClass(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionClass(String)}
   */
  @Test
  @DisplayName("Test setRenditionClass(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClass(String)"})
  void testSetRenditionClass4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.RENDITIONCLASS, "42");

    // Act
    xmpMediaManagementSchema.setRenditionClass("42");

    // Assert
    TextType renditionClassProperty = xmpMediaManagementSchema.getRenditionClassProperty();
    assertTrue(renditionClassProperty instanceof RenditionClassType);
    assertEquals("42", xmpMediaManagementSchema.getRenditionClass());
    assertEquals("42", renditionClassProperty.getStringValue());
    assertEquals("42", renditionClassProperty.getRawValue());
    assertEquals("42", renditionClassProperty.getValue());
    assertEquals("xmpMM", renditionClassProperty.getPrefix());
    assertNull(renditionClassProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionClassProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.RENDITIONCLASS, renditionClassProperty.getPropertyName());
    assertSame(metadata, renditionClassProperty.getMetadata());
    assertSame(renditionClassProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}.
   *
   * <p>Method under test: {@link
   * XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  @DisplayName("Test setRenditionClassProperty(RenditionClassType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClassProperty(RenditionClassType)"})
  void testSetRenditionClassProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    RenditionClassType tt =
        new RenditionClassType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}.
   *
   * <p>Method under test: {@link
   * XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  @DisplayName("Test setRenditionClassProperty(RenditionClassType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClassProperty(RenditionClassType)"})
  void testSetRenditionClassProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt =
        new RenditionClassType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}.
   *
   * <p>Method under test: {@link
   * XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  @DisplayName("Test setRenditionClassProperty(RenditionClassType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClassProperty(RenditionClassType)"})
  void testSetRenditionClassProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt =
        new RenditionClassType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}.
   *
   * <p>Method under test: {@link
   * XMPMediaManagementSchema#setRenditionClassProperty(RenditionClassType)}
   */
  @Test
  @DisplayName("Test setRenditionClassProperty(RenditionClassType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionClassProperty(RenditionClassType)"})
  void testSetRenditionClassProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    RenditionClassType tt =
        new RenditionClassType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionClassProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClassProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  @DisplayName("Test getRenditionClassProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionClassProperty()"})
  void testGetRenditionClassProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getRenditionClassProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClassProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  @DisplayName("Test getRenditionClassProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionClassProperty()"})
  void testGetRenditionClassProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClassProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClassProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClassProperty()}
   */
  @Test
  @DisplayName("Test getRenditionClassProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionClassProperty()"})
  void testGetRenditionClassProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClassProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClass()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  @DisplayName("Test getRenditionClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionClass()"})
  void testGetRenditionClass() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getRenditionClass());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClass()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  @DisplayName("Test getRenditionClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionClass()"})
  void testGetRenditionClass2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClass());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionClass()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionClass()}
   */
  @Test
  @DisplayName("Test getRenditionClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionClass()"})
  void testGetRenditionClass3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionClass());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParams(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  @DisplayName("Test setRenditionParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParams(String)"})
  void testSetRenditionParams() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(0));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParams(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  @DisplayName("Test setRenditionParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParams(String)"})
  void testSetRenditionParams2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(1));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParams(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  @DisplayName("Test setRenditionParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParams(String)"})
  void testSetRenditionParams3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParams(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParams(String)}
   */
  @Test
  @DisplayName("Test setRenditionParams(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParams(String)"})
  void testSetRenditionParams4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.RENDITIONPARAMS, "42");

    // Act
    xmpMediaManagementSchema.setRenditionParams("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", xmpMediaManagementSchema.getRenditionParams());
    TextType renditionParamsProperty = xmpMediaManagementSchema.getRenditionParamsProperty();
    assertEquals("https://example.org/example", renditionParamsProperty.getStringValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getRawValue());
    assertEquals("https://example.org/example", renditionParamsProperty.getValue());
    assertEquals("xmpMM", renditionParamsProperty.getPrefix());
    assertNull(renditionParamsProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(renditionParamsProperty.getAllAttributes().isEmpty());
    assertEquals(
        XMPMediaManagementSchema.RENDITIONPARAMS, renditionParamsProperty.getPropertyName());
    assertSame(renditionParamsProperty, allProperties.get(0));
    assertSame(metadata, renditionParamsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setRenditionParamsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParamsProperty(TextType)"})
  void testSetRenditionParamsProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setRenditionParamsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParamsProperty(TextType)"})
  void testSetRenditionParamsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setRenditionParamsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParamsProperty(TextType)"})
  void testSetRenditionParamsProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setRenditionParamsProperty(TextType)}
   */
  @Test
  @DisplayName("Test setRenditionParamsProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setRenditionParamsProperty(TextType)"})
  void testSetRenditionParamsProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setRenditionParamsProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParamsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  @DisplayName("Test getRenditionParamsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionParamsProperty()"})
  void testGetRenditionParamsProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getRenditionParamsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParamsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  @DisplayName("Test getRenditionParamsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionParamsProperty()"})
  void testGetRenditionParamsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParamsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParamsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParamsProperty()}
   */
  @Test
  @DisplayName("Test getRenditionParamsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getRenditionParamsProperty()"})
  void testGetRenditionParamsProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParamsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParams()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  @DisplayName("Test getRenditionParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionParams()"})
  void testGetRenditionParams() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getRenditionParams());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParams()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  @DisplayName("Test getRenditionParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionParams()"})
  void testGetRenditionParams2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParams());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getRenditionParams()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getRenditionParams()}
   */
  @Test
  @DisplayName("Test getRenditionParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getRenditionParams()"})
  void testGetRenditionParams3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getRenditionParams());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  @DisplayName("Test setVersionID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionID(String)"})
  void testSetVersionID() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(1));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  @DisplayName("Test setVersionID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionID(String)"})
  void testSetVersionID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionID(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  @DisplayName("Test setVersionID(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionID(String)"})
  void testSetVersionID3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addBagValueAsSimple(XMPMediaManagementSchema.VERSIONID, "42");

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(0));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionID(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionID(String)}
   */
  @Test
  @DisplayName(
      "Test setVersionID(String); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionID(String)"})
  void testSetVersionID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.setVersionID("42");

    // Assert
    assertEquals("42", xmpMediaManagementSchema.getVersionID());
    TextType versionIDProperty = xmpMediaManagementSchema.getVersionIDProperty();
    assertEquals("42", versionIDProperty.getStringValue());
    assertEquals("42", versionIDProperty.getRawValue());
    assertEquals("42", versionIDProperty.getValue());
    assertEquals("xmpMM", versionIDProperty.getPrefix());
    assertNull(versionIDProperty.getNamespace());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(versionIDProperty.getAllAttributes().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONID, versionIDProperty.getPropertyName());
    assertSame(versionIDProperty, allProperties.get(0));
    assertSame(metadata, versionIDProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setVersionIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionIDProperty(TextType)"})
  void testSetVersionIDProperty() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(tt, allProperties.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setVersionIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionIDProperty(TextType)"})
  void testSetVersionIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setVersionIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionIDProperty(TextType)"})
  void testSetVersionIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory("Property Name");
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(tt, allProperties.get(2));
  }

  /**
   * Test {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#setVersionIDProperty(TextType)}
   */
  @Test
  @DisplayName("Test setVersionIDProperty(TextType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.setVersionIDProperty(TextType)"})
  void testSetVersionIDProperty4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addBagValueAsSimple(
        "Property Name", XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");
    TextType tt =
        new TextType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    xmpMediaManagementSchema.setVersionIDProperty(tt);

    // Assert
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(tt, allProperties.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  @DisplayName("Test getVersionIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getVersionIDProperty()"})
  void testGetVersionIDProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getVersionIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  @DisplayName("Test getVersionIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getVersionIDProperty()"})
  void testGetVersionIDProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionIDProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionIDProperty()}
   */
  @Test
  @DisplayName("Test getVersionIDProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPMediaManagementSchema.getVersionIDProperty()"})
  void testGetVersionIDProperty3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionIDProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  @DisplayName("Test getVersionID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getVersionID()"})
  void testGetVersionID() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionID()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  @DisplayName("Test getVersionID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getVersionID()"})
  void testGetVersionID2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getVersionID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionID()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionID()}
   */
  @Test
  @DisplayName(
      "Test getVersionID(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPMediaManagementSchema.getVersionID()"})
  void testGetVersionID_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getVersionID());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addVersions(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  @DisplayName("Test addVersions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addVersions(String)"})
  void testAddVersions() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, versionsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties.get(0));
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addVersions(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  @DisplayName("Test addVersions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addVersions(String)"})
  void testAddVersions2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(2, versions.size());
    assertEquals("42", versions.get(0));
    assertEquals("42", versions.get(1));
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    assertEquals(1, xmpMediaManagementSchema.getAllProperties().size());
    assertEquals(2, versionsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addVersions(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  @DisplayName("Test addVersions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addVersions(String)"})
  void testAddVersions3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory("li");
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(2, versions.size());
    assertEquals("42", versions.get(0));
    assertEquals("42", versions.get(1));
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    assertEquals(2, xmpMediaManagementSchema.getAllProperties().size());
    assertEquals(2, versionsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addVersions(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  @DisplayName("Test addVersions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addVersions(String)"})
  void testAddVersions4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    assertEquals(1, versionsProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties.get(1));
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addVersions(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addVersions(String)}
   */
  @Test
  @DisplayName("Test addVersions(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addVersions(String)"})
  void testAddVersions5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);

    // Act
    xmpMediaManagementSchema.addVersions("42");

    // Assert
    List<String> versions = xmpMediaManagementSchema.getVersions();
    assertEquals(1, versions.size());
    assertEquals("42", versions.get(0));
    ArrayProperty versionsProperty = xmpMediaManagementSchema.getVersionsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", versionsProperty.getNamespace());
    assertEquals("xmpMM", versionsProperty.getPrefix());
    assertEquals(1, versionsProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertEquals(Cardinality.Bag, versionsProperty.getArrayType());
    assertTrue(versionsProperty.getAllAttributes().isEmpty());
    assertTrue(versionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(versions, versionsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.VERSIONS, versionsProperty.getPropertyName());
    assertSame(versionsProperty, allProperties.get(2));
    assertSame(metadata, versionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  @DisplayName("Test getVersionsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getVersionsProperty()"})
  void testGetVersionsProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualVersionsProperty = xmpMediaManagementSchema.getVersionsProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualVersionsProperty.getNamespace());
    assertEquals("xmpMM", actualVersionsProperty.getPrefix());
    assertEquals(1, actualVersionsProperty.getAllProperties().size());
    assertEquals(1, actualVersionsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualVersionsProperty.getArrayType());
    assertTrue(actualVersionsProperty.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualVersionsProperty.getPropertyName());
    assertSame(metadata, actualVersionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionsProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/mm/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  @DisplayName(
      "Test getVersionsProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/mm/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getVersionsProperty()"})
  void testGetVersionsProperty_thenReturnNamespaceIsHttpNsAdobeComXap10Mm() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualVersionsProperty = xmpMediaManagementSchema.getVersionsProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualVersionsProperty.getNamespace());
    assertEquals("xmpMM", actualVersionsProperty.getPrefix());
    assertEquals(1, actualVersionsProperty.getAllProperties().size());
    assertEquals(1, actualVersionsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualVersionsProperty.getArrayType());
    assertTrue(actualVersionsProperty.getAllAttributes().isEmpty());
    assertTrue(actualVersionsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualVersionsProperty.getPropertyName());
    assertSame(metadata, actualVersionsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersionsProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersionsProperty()}
   */
  @Test
  @DisplayName("Test getVersionsProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getVersionsProperty()"})
  void testGetVersionsProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getVersionsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersions()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getVersions()"})
  void testGetVersions() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualVersions = xmpMediaManagementSchema.getVersions();

    // Assert
    assertEquals(1, actualVersions.size());
    assertEquals("42", actualVersions.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersions()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getVersions()"})
  void testGetVersions_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getVersions());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getVersions()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getVersions()}
   */
  @Test
  @DisplayName("Test getVersions(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getVersions()"})
  void testGetVersions_thenReturnSizeIsOne() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualVersions = xmpMediaManagementSchema.getVersions();

    // Assert
    assertEquals(1, actualVersions.size());
    assertEquals("42", actualVersions.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#addHistory(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  @DisplayName("Test addHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addHistory(String)"})
  void testAddHistory() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("xmpMM", historyProperty.getPrefix());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(1, history.size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, historyProperty.getAllProperties().size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(history, historyProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(0));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addHistory(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  @DisplayName("Test addHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addHistory(String)"})
  void testAddHistory2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    ArrayProperty historyProperty = xmpMediaManagementSchema.getHistoryProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", historyProperty.getNamespace());
    assertEquals("xmpMM", historyProperty.getPrefix());
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(1, history.size());
    assertEquals(1, historyProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Seq, historyProperty.getArrayType());
    assertTrue(historyProperty.getAllAttributes().isEmpty());
    assertTrue(historyProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(history, historyProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(0));
    assertEquals(XMPMediaManagementSchema.HISTORY, historyProperty.getPropertyName());
    assertSame(historyProperty, allProperties.get(1));
    assertSame(metadata, historyProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addHistory(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  @DisplayName("Test addHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addHistory(String)"})
  void testAddHistory3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    List<String> history = xmpMediaManagementSchema.getHistory();
    assertEquals(2, history.size());
    assertEquals(2, xmpMediaManagementSchema.getAllProperties().size());
    assertEquals(2, xmpMediaManagementSchema.getHistoryProperty().getAllProperties().size());
    assertEquals(XMPMediaManagementSchema.HISTORY, history.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#addHistory(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addHistory(String)}
   */
  @Test
  @DisplayName("Test addHistory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addHistory(String)"})
  void testAddHistory4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.HISTORY);

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistoryProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName("Test getHistoryProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getHistoryProperty()"})
  void testGetHistoryProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getHistoryProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistoryProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/mm/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName(
      "Test getHistoryProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/mm/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getHistoryProperty()"})
  void testGetHistoryProperty_thenReturnNamespaceIsHttpNsAdobeComXap10Mm() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualHistoryProperty = xmpMediaManagementSchema.getHistoryProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualHistoryProperty.getNamespace());
    assertEquals("xmpMM", actualHistoryProperty.getPrefix());
    assertEquals(1, actualHistoryProperty.getAllProperties().size());
    assertEquals(1, actualHistoryProperty.getElementsAsString().size());
    assertEquals(Cardinality.Seq, actualHistoryProperty.getArrayType());
    assertTrue(actualHistoryProperty.getAllAttributes().isEmpty());
    assertTrue(actualHistoryProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.HISTORY, actualHistoryProperty.getPropertyName());
    assertSame(metadata, actualHistoryProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistoryProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistoryProperty()}
   */
  @Test
  @DisplayName("Test getHistoryProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getHistoryProperty()"})
  void testGetHistoryProperty_thenReturnNull() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getHistoryProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistory()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  @DisplayName(
      "Test getHistory(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getHistory()"})
  void testGetHistory_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getHistory());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistory()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  @DisplayName("Test getHistory(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getHistory()"})
  void testGetHistory_thenReturnNull() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getHistory());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getHistory()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getHistory()}
   */
  @Test
  @DisplayName("Test getHistory(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getHistory()"})
  void testGetHistory_thenReturnSizeIsOne() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualHistory = xmpMediaManagementSchema.getHistory();

    // Assert
    assertEquals(1, actualHistory.size());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualHistory.get(0));
  }

  /**
   * Test {@link XMPMediaManagementSchema#addIngredients(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  @DisplayName("Test addIngredients(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addIngredients(String)"})
  void testAddIngredients() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(1, ingredients.size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, ingredientsProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ingredients, ingredientsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertSame(ingredientsProperty, allProperties.get(0));
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addIngredients(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  @DisplayName("Test addIngredients(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addIngredients(String)"})
  void testAddIngredients2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    ArrayProperty ingredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", ingredientsProperty.getNamespace());
    assertEquals("xmpMM", ingredientsProperty.getPrefix());
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(1, ingredients.size());
    assertEquals(1, ingredientsProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpMediaManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Bag, ingredientsProperty.getArrayType());
    assertTrue(ingredientsProperty.getAllAttributes().isEmpty());
    assertTrue(ingredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(ingredients, ingredientsProperty.getElementsAsString());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(0));
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredientsProperty.getPropertyName());
    assertSame(ingredientsProperty, allProperties.get(1));
    assertSame(metadata, ingredientsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addIngredients(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  @DisplayName("Test addIngredients(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addIngredients(String)"})
  void testAddIngredients3() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    assertEquals(3, xmpMediaManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPMediaManagementSchema#addIngredients(String)}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#addIngredients(String)}
   */
  @Test
  @DisplayName("Test addIngredients(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPMediaManagementSchema.addIngredients(String)"})
  void testAddIngredients4() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.INGREDIENTS);

    // Assert
    List<String> ingredients = xmpMediaManagementSchema.getIngredients();
    assertEquals(2, ingredients.size());
    assertEquals(2, xmpMediaManagementSchema.getAllProperties().size());
    assertEquals(2, xmpMediaManagementSchema.getIngredientsProperty().getAllProperties().size());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, ingredients.get(1));
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredientsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  @DisplayName("Test getIngredientsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getIngredientsProperty()"})
  void testGetIngredientsProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getIngredientsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredientsProperty()}.
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  @DisplayName("Test getIngredientsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getIngredientsProperty()"})
  void testGetIngredientsProperty2() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addHistory(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredientsProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/mm/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  @DisplayName(
      "Test getIngredientsProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/mm/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getIngredientsProperty()"})
  void testGetIngredientsProperty_thenReturnNamespaceIsHttpNsAdobeComXap10Mm() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPMediaManagementSchema xmpMediaManagementSchema = new XMPMediaManagementSchema(metadata);
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    ArrayProperty actualIngredientsProperty = xmpMediaManagementSchema.getIngredientsProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/mm/", actualIngredientsProperty.getNamespace());
    assertEquals("xmpMM", actualIngredientsProperty.getPrefix());
    assertEquals(1, actualIngredientsProperty.getAllProperties().size());
    assertEquals(1, actualIngredientsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualIngredientsProperty.getArrayType());
    assertTrue(actualIngredientsProperty.getAllAttributes().isEmpty());
    assertTrue(actualIngredientsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPMediaManagementSchema.INGREDIENTS, actualIngredientsProperty.getPropertyName());
    assertSame(metadata, actualIngredientsProperty.getMetadata());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredientsProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredientsProperty()}
   */
  @Test
  @DisplayName("Test getIngredientsProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPMediaManagementSchema.getIngredientsProperty()"})
  void testGetIngredientsProperty_thenReturnNull() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredientsProperty());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredients()}.
   *
   * <ul>
   *   <li>Given {@link XMPMediaManagementSchema#XMPMediaManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  @DisplayName(
      "Test getIngredients(); given XMPMediaManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getIngredients()"})
  void testGetIngredients_givenXMPMediaManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata()).getIngredients());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredients()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  @DisplayName("Test getIngredients(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getIngredients()"})
  void testGetIngredients_thenReturnNull() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addVersions("42");

    // Act and Assert
    assertNull(xmpMediaManagementSchema.getIngredients());
  }

  /**
   * Test {@link XMPMediaManagementSchema#getIngredients()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPMediaManagementSchema#getIngredients()}
   */
  @Test
  @DisplayName("Test getIngredients(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPMediaManagementSchema.getIngredients()"})
  void testGetIngredients_thenReturnSizeIsOne() {
    // Arrange
    XMPMediaManagementSchema xmpMediaManagementSchema =
        new XMPMediaManagementSchema(XMPMetadata.createXMPMetadata());
    xmpMediaManagementSchema.addIngredients(XMPMediaManagementSchema.VERSIONS);
    xmpMediaManagementSchema.addVersions("42");

    // Act
    List<String> actualIngredients = xmpMediaManagementSchema.getIngredients();

    // Assert
    assertEquals(1, actualIngredients.size());
    assertEquals(XMPMediaManagementSchema.VERSIONS, actualIngredients.get(0));
  }
}
