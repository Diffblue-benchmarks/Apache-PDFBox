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
import org.apache.xmpbox.type.BooleanType;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XMPRightsManagementSchemaDiffblueTest {
  /**
   * Test {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPRightsManagementSchema(XMPMetadata)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.<init>(XMPMetadata)"})
  void testNewXMPRightsManagementSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema =
        new XMPRightsManagementSchema(metadata);

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
    assertEquals("xmpRights", actualXmpRightsManagementSchema.getPreferedPrefix());
    assertEquals("xmpRights", actualXmpRightsManagementSchema.getPrefix());
    assertNull(actualXmpRightsManagementSchema.getMarked());
    assertNull(actualXmpRightsManagementSchema.getCertificate());
    assertNull(actualXmpRightsManagementSchema.getUsageTerms());
    assertNull(actualXmpRightsManagementSchema.getWebStatement());
    assertNull(actualXmpRightsManagementSchema.getPropertyName());
    assertNull(actualXmpRightsManagementSchema.getOwners());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsLanguages());
    assertNull(actualXmpRightsManagementSchema.getOwnersProperty());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsProperty());
    assertNull(actualXmpRightsManagementSchema.getAboutAttribute());
    assertNull(actualXmpRightsManagementSchema.getMarkedProperty());
    assertNull(actualXmpRightsManagementSchema.getCertificateProperty());
    assertNull(actualXmpRightsManagementSchema.getWebStatementProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpRightsManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/rights/"));
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Prefix is {@code xmpRights}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new XMPRightsManagementSchema(XMPMetadata, String); when 'null'; then return Prefix is 'xmpRights'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.<init>(XMPMetadata, String)"})
  void testNewXMPRightsManagementSchema_whenNull_thenReturnPrefixIsXmpRights()
      throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema =
        new XMPRightsManagementSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
    assertEquals("xmpRights", actualXmpRightsManagementSchema.getPreferedPrefix());
    assertEquals("xmpRights", actualXmpRightsManagementSchema.getPrefix());
    assertNull(actualXmpRightsManagementSchema.getMarked());
    assertNull(actualXmpRightsManagementSchema.getCertificate());
    assertNull(actualXmpRightsManagementSchema.getUsageTerms());
    assertNull(actualXmpRightsManagementSchema.getWebStatement());
    assertNull(actualXmpRightsManagementSchema.getPropertyName());
    assertNull(actualXmpRightsManagementSchema.getOwners());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsLanguages());
    assertNull(actualXmpRightsManagementSchema.getOwnersProperty());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsProperty());
    assertNull(actualXmpRightsManagementSchema.getAboutAttribute());
    assertNull(actualXmpRightsManagementSchema.getMarkedProperty());
    assertNull(actualXmpRightsManagementSchema.getCertificateProperty());
    assertNull(actualXmpRightsManagementSchema.getWebStatementProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpRightsManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/rights/"));
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}.
   *
   * <ul>
   *   <li>When {@code Own Prefix}.
   *   <li>Then return Prefix is {@code Own Prefix}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata,
   * String)}
   */
  @Test
  @DisplayName(
      "Test new XMPRightsManagementSchema(XMPMetadata, String); when 'Own Prefix'; then return Prefix is 'Own Prefix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.<init>(XMPMetadata, String)"})
  void testNewXMPRightsManagementSchema_whenOwnPrefix_thenReturnPrefixIsOwnPrefix()
      throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema =
        new XMPRightsManagementSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    assertEquals("Own Prefix", actualXmpRightsManagementSchema.getPrefix());
    assertEquals(
        "http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
    assertEquals("xmpRights", actualXmpRightsManagementSchema.getPreferedPrefix());
    assertNull(actualXmpRightsManagementSchema.getMarked());
    assertNull(actualXmpRightsManagementSchema.getCertificate());
    assertNull(actualXmpRightsManagementSchema.getUsageTerms());
    assertNull(actualXmpRightsManagementSchema.getWebStatement());
    assertNull(actualXmpRightsManagementSchema.getPropertyName());
    assertNull(actualXmpRightsManagementSchema.getOwners());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsLanguages());
    assertNull(actualXmpRightsManagementSchema.getOwnersProperty());
    assertNull(actualXmpRightsManagementSchema.getUsageTermsProperty());
    assertNull(actualXmpRightsManagementSchema.getAboutAttribute());
    assertNull(actualXmpRightsManagementSchema.getMarkedProperty());
    assertNull(actualXmpRightsManagementSchema.getCertificateProperty());
    assertNull(actualXmpRightsManagementSchema.getWebStatementProperty());
    Map<String, String> allNamespacesWithPrefix =
        actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertTrue(actualXmpRightsManagementSchema.getAllProperties().isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/xap/1.0/rights/"));
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addOwner(String)"})
  void testAddOwner() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    assertEquals("42", owners.get(0));
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, ownersProperty.getAllProperties().size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties.get(0));
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addOwner(String)"})
  void testAddOwner2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(1));
    assertEquals(1, xmpRightsManagementSchema.getAllProperties().size());
    assertEquals(2, xmpRightsManagementSchema.getOwnersProperty().getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addOwner(String)"})
  void testAddOwner3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("li", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(1));
    assertEquals(2, xmpRightsManagementSchema.getAllProperties().size());
    assertEquals(2, xmpRightsManagementSchema.getOwnersProperty().getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addOwner(String)"})
  void testAddOwner4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, "42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    assertEquals("42", owners.get(0));
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    assertEquals(1, ownersProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(owners, xmpRightsManagementSchema.getUsageTermsProperty().getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties.get(1));
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addOwner(String)"})
  void testAddOwner5() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple("Simple Name", "42");
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, "42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
  }

  /**
   * Test {@link XMPRightsManagementSchema#removeOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.removeOwner(String)"})
  void testRemoveOwner() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert that nothing has changed
    assertNull(xmpRightsManagementSchema.getOwners());
  }

  /**
   * Test {@link XMPRightsManagementSchema#removeOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.removeOwner(String)"})
  void testRemoveOwner2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert
    assertTrue(xmpRightsManagementSchema.getOwners().isEmpty());
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertTrue(ownersProperty.getAllProperties().isEmpty());
    assertTrue(ownersProperty.getElementsAsString().isEmpty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#removeOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.removeOwner(String)"})
  void testRemoveOwner3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner(XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertEquals(1, ownersProperty.getAllProperties().size());
    assertEquals(owners, ownersProperty.getElementsAsString());
  }

  /**
   * Test {@link XMPRightsManagementSchema#removeOwner(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.removeOwner(String)"})
  void testRemoveOwner4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("42", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert
    assertTrue(xmpRightsManagementSchema.getOwners().isEmpty());
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertTrue(ownersProperty.getAllProperties().isEmpty());
    assertTrue(ownersProperty.getElementsAsString().isEmpty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwnersProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName("Test getOwnersProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getOwnersProperty()"})
  void testGetOwnersProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualOwnersProperty = xmpRightsManagementSchema.getOwnersProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualOwnersProperty.getNamespace());
    assertEquals("xmpRights", actualOwnersProperty.getPrefix());
    assertEquals(1, actualOwnersProperty.getAllProperties().size());
    assertEquals(1, actualOwnersProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualOwnersProperty.getArrayType());
    assertTrue(actualOwnersProperty.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, actualOwnersProperty.getPropertyName());
    assertSame(metadata, actualOwnersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwnersProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/rights/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName(
      "Test getOwnersProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/rights/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getOwnersProperty()"})
  void testGetOwnersProperty_thenReturnNamespaceIsHttpNsAdobeComXap10Rights() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualOwnersProperty = xmpRightsManagementSchema.getOwnersProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualOwnersProperty.getNamespace());
    assertEquals("xmpRights", actualOwnersProperty.getPrefix());
    assertEquals(1, actualOwnersProperty.getAllProperties().size());
    assertEquals(1, actualOwnersProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualOwnersProperty.getArrayType());
    assertTrue(actualOwnersProperty.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, actualOwnersProperty.getPropertyName());
    assertSame(metadata, actualOwnersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwnersProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName("Test getOwnersProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getOwnersProperty()"})
  void testGetOwnersProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getOwnersProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwners()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getOwners()"})
  void testGetOwners() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    List<String> actualOwners = xmpRightsManagementSchema.getOwners();

    // Assert
    assertEquals(1, actualOwners.size());
    assertEquals("42", actualOwners.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwners()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getOwners()"})
  void testGetOwners_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getOwners());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwners()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getOwners()"})
  void testGetOwners_thenReturnSizeIsOne() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act
    List<String> actualOwners = xmpRightsManagementSchema.getOwners();

    // Assert
    assertEquals(1, actualOwners.size());
    assertEquals("42", actualOwners.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarked(Boolean)"})
  void testSetMarked() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setMarked(true);

    // Assert
    BooleanType markedProperty = xmpRightsManagementSchema.getMarkedProperty();
    assertEquals("True", markedProperty.getStringValue());
    assertEquals("True", markedProperty.getRawValue());
    assertEquals("xmpRights", markedProperty.getPrefix());
    assertNull(markedProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(markedProperty.getAllAttributes().isEmpty());
    assertTrue(xmpRightsManagementSchema.getMarked());
    assertTrue(markedProperty.getValue());
    assertEquals(XMPRightsManagementSchema.MARKED, markedProperty.getPropertyName());
    assertSame(markedProperty, allProperties.get(1));
    assertSame(metadata, markedProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarked(Boolean)"})
  void testSetMarked2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("True", XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setMarked(true);

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarked(Boolean)"})
  void testSetMarked3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.MARKED, "42");

    // Act
    xmpRightsManagementSchema.setMarked(true);

    // Assert
    BooleanType markedProperty = xmpRightsManagementSchema.getMarkedProperty();
    assertEquals("True", markedProperty.getStringValue());
    assertEquals("True", markedProperty.getRawValue());
    assertEquals("xmpRights", markedProperty.getPrefix());
    assertNull(markedProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(markedProperty.getAllAttributes().isEmpty());
    assertTrue(xmpRightsManagementSchema.getMarked());
    assertTrue(markedProperty.getValue());
    assertEquals(XMPRightsManagementSchema.MARKED, markedProperty.getPropertyName());
    assertSame(markedProperty, allProperties.get(0));
    assertSame(metadata, markedProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   *
   * <ul>
   *   <li>Given {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName(
      "Test setMarked(Boolean); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarked(Boolean)"})
  void testSetMarked_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.setMarked(true);

    // Assert
    BooleanType markedProperty = xmpRightsManagementSchema.getMarkedProperty();
    assertEquals("True", markedProperty.getStringValue());
    assertEquals("True", markedProperty.getRawValue());
    assertEquals("xmpRights", markedProperty.getPrefix());
    assertNull(markedProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(markedProperty.getAllAttributes().isEmpty());
    assertTrue(xmpRightsManagementSchema.getMarked());
    assertTrue(markedProperty.getValue());
    assertEquals(XMPRightsManagementSchema.MARKED, markedProperty.getPropertyName());
    assertSame(markedProperty, allProperties.get(0));
    assertSame(metadata, markedProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarkedProperty(BooleanType)"})
  void testSetMarkedProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    BooleanType marked =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(marked, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarkedProperty(BooleanType)"})
  void testSetMarkedProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(marked, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarkedProperty(BooleanType)"})
  void testSetMarkedProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", "Property Name");
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(marked, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setMarkedProperty(BooleanType)"})
  void testSetMarkedProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(
        "Property Name", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addUsageTerms("Lang", "Property Name");
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(marked, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BooleanType XMPRightsManagementSchema.getMarkedProperty()"})
  void testGetMarkedProperty() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BooleanType XMPRightsManagementSchema.getMarkedProperty()"})
  void testGetMarkedProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BooleanType XMPRightsManagementSchema.getMarkedProperty()"})
  void testGetMarkedProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName("Test getMarked()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean XMPRightsManagementSchema.getMarked()"})
  void testGetMarked() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName("Test getMarked()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean XMPRightsManagementSchema.getMarked()"})
  void testGetMarked2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   *
   * <ul>
   *   <li>Given {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName(
      "Test getMarked(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean XMPRightsManagementSchema.getMarked()"})
  void testGetMarked_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(usageTermsProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(1));
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
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
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple(
        "Simple Name", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(2));
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.addUsageTerms(String, String)"})
  void testAddUsageTerms7() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            "Value");
    xmpRightsManagementSchema.addProperty(obj);

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(0));
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(1));
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert that nothing has changed
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple(
        "x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    assertEquals(1, usageTermsProperty.getAllProperties().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(2));
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms5() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals(1, getResult.getAllAttributes().size());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(1));
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms6() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            "Value");
    xmpRightsManagementSchema.addProperty(obj);

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert that nothing has changed
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof AgentNameType);
    assertSame(obj, getResult);
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setUsageTerms(String)"})
  void testSetUsageTerms7() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(2) instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(3, elementsAsString.size());
    assertEquals("42", elementsAsString.get(2));
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(3, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(2));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName("Test getUsageTermsProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getUsageTermsProperty()"})
  void testGetUsageTermsProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getUsageTermsProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   *
   * <ul>
   *   <li>Then return Namespace is {@code http://ns.adobe.com/xap/1.0/rights/}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName(
      "Test getUsageTermsProperty(); then return Namespace is 'http://ns.adobe.com/xap/1.0/rights/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getUsageTermsProperty()"})
  void testGetUsageTermsProperty_thenReturnNamespaceIsHttpNsAdobeComXap10Rights() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualUsageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();

    // Assert
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualUsageTermsProperty.getNamespace());
    assertEquals("xmpRights", actualUsageTermsProperty.getPrefix());
    assertEquals(1, actualUsageTermsProperty.getAllProperties().size());
    assertEquals(1, actualUsageTermsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, actualUsageTermsProperty.getArrayType());
    assertTrue(actualUsageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(actualUsageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, actualUsageTermsProperty.getPropertyName());
    assertSame(metadata, actualUsageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName("Test getUsageTermsProperty(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ArrayProperty XMPRightsManagementSchema.getUsageTermsProperty()"})
  void testGetUsageTermsProperty_thenReturnNull() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getUsageTermsLanguages()"})
  void testGetUsageTermsLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getUsageTermsLanguages());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@link XMPRightsManagementSchema#OWNER}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return first is OWNER")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getUsageTermsLanguages()"})
  void testGetUsageTermsLanguages_thenReturnFirstIsOwner() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    List<String> actualUsageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();

    // Assert
    assertEquals(1, actualUsageTermsLanguages.size());
    assertEquals(XMPRightsManagementSchema.OWNER, actualUsageTermsLanguages.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   *
   * <ul>
   *   <li>Then return first is {@code x-default}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return first is 'x-default'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getUsageTermsLanguages()"})
  void testGetUsageTermsLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act
    List<String> actualUsageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();

    // Assert
    assertEquals(1, actualUsageTermsLanguages.size());
    assertEquals("x-default", actualUsageTermsLanguages.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getUsageTermsLanguages()"})
  void testGetUsageTermsLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsLanguages());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List XMPRightsManagementSchema.getUsageTermsLanguages()"})
  void testGetUsageTermsLanguages_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            "Value");
    xmpRightsManagementSchema.addProperty(obj);

    // Act and Assert
    assertThrows(
        BadFieldValueException.class, () -> xmpRightsManagementSchema.getUsageTermsLanguages());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString4() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@link XMPRightsManagementSchema#USAGETERMS}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'; then return USAGETERMS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString_thenReturnUsageterms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertEquals(
        XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'; then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms(String)"})
  void testGetUsageTermsWithString_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            "Value");
    xmpRightsManagementSchema.addProperty(obj);

    // Act and Assert
    assertThrows(
        BadFieldValueException.class, () -> xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <ul>
   *   <li>Given {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName(
      "Test getUsageTerms(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata()
      throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <ul>
   *   <li>Then return {@link XMPRightsManagementSchema#USAGETERMS}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms(); then return USAGETERMS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms_thenReturnUsageterms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   *
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms(); then throw BadFieldValueException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getUsageTerms()"})
  void testGetUsageTerms_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj =
        new AgentNameType(
            XMPMetadata.createXMPMetadata(),
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            XMPRightsManagementSchema.USAGETERMS,
            "Value");
    xmpRightsManagementSchema.addProperty(obj);

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getWebStatementProperty()"})
  void testGetWebStatementProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getWebStatementProperty()"})
  void testGetWebStatementProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getWebStatementProperty()"})
  void testGetWebStatementProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getWebStatement()"})
  void testGetWebStatement() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getWebStatement()"})
  void testGetWebStatement2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getWebStatement()"})
  void testGetWebStatement3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatement(String)"})
  void testSetWebStatement() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.setWebStatement("https://example.org/example");

    // Assert
    TextType webStatementProperty = xmpRightsManagementSchema.getWebStatementProperty();
    assertTrue(webStatementProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getWebStatement());
    assertEquals("https://example.org/example", webStatementProperty.getStringValue());
    assertEquals("https://example.org/example", webStatementProperty.getRawValue());
    assertEquals("https://example.org/example", webStatementProperty.getValue());
    assertEquals("xmpRights", webStatementProperty.getPrefix());
    assertNull(webStatementProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(webStatementProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.WEBSTATEMENT, webStatementProperty.getPropertyName());
    assertSame(metadata, webStatementProperty.getMetadata());
    assertSame(webStatementProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatement(String)"})
  void testSetWebStatement2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setWebStatement("https://example.org/example");

    // Assert
    TextType webStatementProperty = xmpRightsManagementSchema.getWebStatementProperty();
    assertTrue(webStatementProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getWebStatement());
    assertEquals("https://example.org/example", webStatementProperty.getStringValue());
    assertEquals("https://example.org/example", webStatementProperty.getRawValue());
    assertEquals("https://example.org/example", webStatementProperty.getValue());
    assertEquals("xmpRights", webStatementProperty.getPrefix());
    assertNull(webStatementProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(webStatementProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.WEBSTATEMENT, webStatementProperty.getPropertyName());
    assertSame(metadata, webStatementProperty.getMetadata());
    assertSame(webStatementProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatement(String)"})
  void testSetWebStatement3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setWebStatement("https://example.org/example");

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatement(String)"})
  void testSetWebStatement4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.WEBSTATEMENT, "42");

    // Act
    xmpRightsManagementSchema.setWebStatement("https://example.org/example");

    // Assert
    TextType webStatementProperty = xmpRightsManagementSchema.getWebStatementProperty();
    assertTrue(webStatementProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getWebStatement());
    assertEquals("https://example.org/example", webStatementProperty.getStringValue());
    assertEquals("https://example.org/example", webStatementProperty.getRawValue());
    assertEquals("https://example.org/example", webStatementProperty.getValue());
    assertEquals("xmpRights", webStatementProperty.getPrefix());
    assertNull(webStatementProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(webStatementProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.WEBSTATEMENT, webStatementProperty.getPropertyName());
    assertSame(metadata, webStatementProperty.getMetadata());
    assertSame(webStatementProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatementProperty(URLType)"})
  void testSetWebStatementProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatementProperty(URLType)"})
  void testSetWebStatementProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatementProperty(URLType)"})
  void testSetWebStatementProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        "https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(url, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setWebStatementProperty(URLType)"})
  void testSetWebStatementProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(
        "https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getCertificateProperty()"})
  void testGetCertificateProperty() {
    // Arrange, Act and Assert
    assertNull(
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getCertificateProperty()"})
  void testGetCertificateProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TextType XMPRightsManagementSchema.getCertificateProperty()"})
  void testGetCertificateProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName("Test getCertificate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getCertificate()"})
  void testGetCertificate() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName("Test getCertificate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getCertificate()"})
  void testGetCertificate2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   *
   * <ul>
   *   <li>Given {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName(
      "Test getCertificate(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XMPRightsManagementSchema.getCertificate()"})
  void testGetCertificate_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull(new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata()).getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificate(String)"})
  void testSetCertificate() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setCertificate("https://example.org/example");

    // Assert
    TextType certificateProperty = xmpRightsManagementSchema.getCertificateProperty();
    assertTrue(certificateProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getCertificate());
    assertEquals("https://example.org/example", certificateProperty.getStringValue());
    assertEquals("https://example.org/example", certificateProperty.getRawValue());
    assertEquals("https://example.org/example", certificateProperty.getValue());
    assertEquals("xmpRights", certificateProperty.getPrefix());
    assertNull(certificateProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(certificateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.CERTIFICATE, certificateProperty.getPropertyName());
    assertSame(metadata, certificateProperty.getMetadata());
    assertSame(certificateProperty, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificate(String)"})
  void testSetCertificate2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setCertificate("https://example.org/example");

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificate(String)"})
  void testSetCertificate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.CERTIFICATE, "42");

    // Act
    xmpRightsManagementSchema.setCertificate("https://example.org/example");

    // Assert
    TextType certificateProperty = xmpRightsManagementSchema.getCertificateProperty();
    assertTrue(certificateProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getCertificate());
    assertEquals("https://example.org/example", certificateProperty.getStringValue());
    assertEquals("https://example.org/example", certificateProperty.getRawValue());
    assertEquals("https://example.org/example", certificateProperty.getValue());
    assertEquals("xmpRights", certificateProperty.getPrefix());
    assertNull(certificateProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(certificateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.CERTIFICATE, certificateProperty.getPropertyName());
    assertSame(metadata, certificateProperty.getMetadata());
    assertSame(certificateProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   *
   * <ul>
   *   <li>Given {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   *       metadata is createXMPMetadata.
   * </ul>
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName(
      "Test setCertificate(String); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificate(String)"})
  void testSetCertificate_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.setCertificate("https://example.org/example");

    // Assert
    TextType certificateProperty = xmpRightsManagementSchema.getCertificateProperty();
    assertTrue(certificateProperty instanceof URLType);
    assertEquals("https://example.org/example", xmpRightsManagementSchema.getCertificate());
    assertEquals("https://example.org/example", certificateProperty.getStringValue());
    assertEquals("https://example.org/example", certificateProperty.getRawValue());
    assertEquals("https://example.org/example", certificateProperty.getValue());
    assertEquals("xmpRights", certificateProperty.getPrefix());
    assertNull(certificateProperty.getNamespace());
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertTrue(certificateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.CERTIFICATE, certificateProperty.getPropertyName());
    assertSame(metadata, certificateProperty.getMetadata());
    assertSame(certificateProperty, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificateProperty(URLType)"})
  void testSetCertificateProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificateProperty(URLType)"})
  void testSetCertificateProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificateProperty(URLType)"})
  void testSetCertificateProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(
        "https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(url, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   *
   * <p>Method under test: {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XMPRightsManagementSchema.setCertificateProperty(URLType)"})
  void testSetCertificateProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema =
        new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(
        "https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url =
        new URLType(
            XMPMetadata.createXMPMetadata(),
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example",
            "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }
}
