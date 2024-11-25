package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.type.AbstractField;
import org.apache.xmpbox.type.AgentNameType;
import org.apache.xmpbox.type.ArrayProperty;
import org.apache.xmpbox.type.Attribute;
import org.apache.xmpbox.type.BadFieldValueException;
import org.apache.xmpbox.type.BooleanType;
import org.apache.xmpbox.type.Cardinality;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.URLType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class XMPRightsManagementSchemaDiffblueTest {
  /**
   * Test
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)}
   */
  @Test
  @DisplayName("Test new XMPRightsManagementSchema(XMPMetadata)")
  void testNewXMPRightsManagementSchema() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpRights", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/rights/"));
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
    List<AbstractField> allProperties = actualXmpRightsManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpRightsManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPRightsManagementSchema(XMPMetadata, String)")
  void testNewXMPRightsManagementSchema2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema = new XMPRightsManagementSchema(metadata, "Own Prefix");

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    Map<String, String> allNamespacesWithPrefix = actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Own Prefix", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/rights/"));
    assertEquals("Own Prefix", actualXmpRightsManagementSchema.getPrefix());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
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
    List<AbstractField> allProperties = actualXmpRightsManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpRightsManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}
   */
  @Test
  @DisplayName("Test new XMPRightsManagementSchema(XMPMetadata, String)")
  void testNewXMPRightsManagementSchema3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPRightsManagementSchema actualXmpRightsManagementSchema = new XMPRightsManagementSchema(metadata, null);

    // Assert
    assertEquals("", actualXmpRightsManagementSchema.getAboutValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualXmpRightsManagementSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpRightsManagementSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("xmpRights", allNamespacesWithPrefix.get("http://ns.adobe.com/xap/1.0/rights/"));
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
    List<AbstractField> allProperties = actualXmpRightsManagementSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpRightsManagementSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpRightsManagementSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpRightsManagementSchema.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  void testAddOwner() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    List<AbstractField> allProperties = ownersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    assertEquals("42", owners.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(0));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  void testAddOwner2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getOwnersProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  void testAddOwner3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("li", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getOwnersProperty().getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals(2, xmpRightsManagementSchema.getAllProperties().size());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  void testAddOwner4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, "42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    List<AbstractField> allProperties = ownersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    assertEquals("42", owners.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(owners, xmpRightsManagementSchema.getUsageTermsProperty().getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(1));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  @DisplayName("Test addOwner(String)")
  void testAddOwner5() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  void testRemoveOwner() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert that nothing has changed
    assertNull(xmpRightsManagementSchema.getOwners());
  }

  /**
   * Test {@link XMPRightsManagementSchema#removeOwner(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  void testRemoveOwner2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  void testRemoveOwner3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  @DisplayName("Test removeOwner(String)")
  void testRemoveOwner4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName("Test getOwnersProperty()")
  void testGetOwnersProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualOwnersProperty = xmpRightsManagementSchema.getOwnersProperty();

    // Assert
    List<AbstractField> allProperties = actualOwnersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualOwnersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualOwnersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", actualOwnersProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualOwnersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, actualOwnersProperty.getPropertyName());
    assertSame(allProperties, actualOwnersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualOwnersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwnersProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName("Test getOwnersProperty(); then return AllProperties size is one")
  void testGetOwnersProperty_thenReturnAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualOwnersProperty = xmpRightsManagementSchema.getOwnersProperty();

    // Assert
    List<AbstractField> allProperties = actualOwnersProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = actualOwnersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualOwnersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", actualOwnersProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualOwnersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllAttributes().isEmpty());
    assertTrue(actualOwnersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, actualOwnersProperty.getPropertyName());
    assertSame(allProperties, actualOwnersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualOwnersProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwnersProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  @DisplayName("Test getOwnersProperty(); then return 'null'")
  void testGetOwnersProperty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getOwnersProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwners()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners()")
  void testGetOwners() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners(); then return 'null'")
  void testGetOwners_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getOwners());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getOwners()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  @DisplayName("Test getOwners(); then return size is one")
  void testGetOwners_thenReturnSizeIsOne() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act
    List<String> actualOwners = xmpRightsManagementSchema.getOwners();

    // Assert
    assertEquals(1, actualOwners.size());
    assertEquals("42", actualOwners.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
  void testSetMarked2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("True", XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setMarked(true);

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarked(Boolean)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean)")
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
   * <ul>
   *   <li>Given
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  @DisplayName("Test setMarked(Boolean); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
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
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  void testSetMarkedProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    BooleanType marked = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(marked, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  void testSetMarkedProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(marked, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  void testSetMarkedProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", "Property Name");
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(marked, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
  @DisplayName("Test setMarkedProperty(BooleanType)")
  void testSetMarkedProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple("Property Name", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addUsageTerms("Lang", "Property Name");
    xmpRightsManagementSchema.addOwner("Value");
    BooleanType marked = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "FALSE");

    // Act
    xmpRightsManagementSchema.setMarkedProperty(marked);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(marked, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  void testGetMarkedProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  void testGetMarkedProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarkedProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  @DisplayName("Test getMarkedProperty()")
  void testGetMarkedProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarkedProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName("Test getMarked()")
  void testGetMarked() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName("Test getMarked()")
  void testGetMarked2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getMarked()}.
   * <ul>
   *   <li>Given
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  @DisplayName("Test getMarked(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetMarked_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getMarked());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());

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
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertSame(usageTermsProperty, allProperties2.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
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
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getUsageTermsProperty().getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms5() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
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
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms6() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple("Simple Name", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertSame(usageTermsProperty, allProperties2.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms7() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());

    // Act
    xmpRightsManagementSchema.addUsageTerms("", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", xmpRightsManagementSchema.getUsageTerms());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("x-default", allAttributes.get(0).getValue());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    assertSame(usageTermsProperty, allProperties2.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms8() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("x-default", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals(XMPRightsManagementSchema.OWNER, usageTermsLanguages.get(1));
    assertEquals(XMPRightsManagementSchema.OWNER, allAttributes.get(0).getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getValue());
  }

  /**
   * Test {@link XMPRightsManagementSchema#addUsageTerms(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  @DisplayName("Test addUsageTerms(String, String)")
  void testAddUsageTerms9() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), XMPRightsManagementSchema.USAGETERMS,
        XMPRightsManagementSchema.USAGETERMS, XMPRightsManagementSchema.USAGETERMS, "Value");

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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties2.get(1));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    assertEquals(1, getResult.getAllAttributes().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(1, xmpRightsManagementSchema.getUsageTermsLanguages().size());
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties2.get(2));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
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
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, getResult2.getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(2);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(3, elementsAsString.size());
    assertEquals("42", elementsAsString.get(2));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(3, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("Lang", allAttributes.get(0).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult3 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(2));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, getResult3.getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getValue());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setUsageTerms(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  @DisplayName("Test setUsageTerms(String)")
  void testSetUsageTerms7() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), XMPRightsManagementSchema.USAGETERMS,
        XMPRightsManagementSchema.USAGETERMS, XMPRightsManagementSchema.USAGETERMS, "Value");

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
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName("Test getUsageTermsProperty()")
  void testGetUsageTermsProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTermsProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   * <ul>
   *   <li>Then return AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName("Test getUsageTermsProperty(); then return AllProperties size is one")
  void testGetUsageTermsProperty_thenReturnAllPropertiesSizeIsOne() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    ArrayProperty actualUsageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();

    // Assert
    List<AbstractField> allProperties = actualUsageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", actualUsageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", actualUsageTermsProperty.getPrefix());
    List<String> elementsAsString = actualUsageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals(Cardinality.Alt, actualUsageTermsProperty.getArrayType());
    assertTrue(actualUsageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(actualUsageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, getResult2.getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(0));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, actualUsageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getValue());
    assertSame(allProperties, actualUsageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualUsageTermsProperty.getMetadata());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsProperty()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  @DisplayName("Test getUsageTermsProperty(); then return 'null'")
  void testGetUsageTermsProperty_thenReturnNull() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages()")
  void testGetUsageTermsLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTermsLanguages());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   * <ul>
   *   <li>Then return first is {@link XMPRightsManagementSchema#OWNER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return first is OWNER")
  void testGetUsageTermsLanguages_thenReturnFirstIsOwner() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    List<String> actualUsageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();

    // Assert
    assertEquals(1, actualUsageTermsLanguages.size());
    assertEquals(XMPRightsManagementSchema.OWNER, actualUsageTermsLanguages.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   * <ul>
   *   <li>Then return first is {@code x-default}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return first is 'x-default'")
  void testGetUsageTermsLanguages_thenReturnFirstIsXDefault() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act
    List<String> actualUsageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();

    // Assert
    assertEquals(1, actualUsageTermsLanguages.size());
    assertEquals("x-default", actualUsageTermsLanguages.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTermsLanguages()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  @DisplayName("Test getUsageTermsLanguages(); then return 'null'")
  void testGetUsageTermsLanguages_thenReturnNull() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsLanguages());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  void testGetUsageTerms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  void testGetUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms()")
  void testGetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  void testGetUsageTermsWithString() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  void testGetUsageTermsWithString2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  void testGetUsageTermsWithString3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with
   * {@code String}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'")
  void testGetUsageTermsWithString4() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms(String)} with
   * {@code String}.
   * <ul>
   *   <li>Then return {@link XMPRightsManagementSchema#USAGETERMS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  @DisplayName("Test getUsageTerms(String) with 'String'; then return USAGETERMS")
  void testGetUsageTermsWithString_thenReturnUsageterms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   * <ul>
   *   <li>Given
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetUsageTerms_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getUsageTerms()}.
   * <ul>
   *   <li>Then return {@link XMPRightsManagementSchema#USAGETERMS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  @DisplayName("Test getUsageTerms(); then return USAGETERMS")
  void testGetUsageTerms_thenReturnUsageterms() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  void testGetWebStatementProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  void testGetWebStatementProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatementProperty()}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  @DisplayName("Test getWebStatementProperty()")
  void testGetWebStatementProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatementProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  void testGetWebStatement() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  void testGetWebStatement2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getWebStatement()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  @DisplayName("Test getWebStatement()")
  void testGetWebStatement3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatement());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
  void testSetWebStatement3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setWebStatement("https://example.org/example");

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatement(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  @DisplayName("Test setWebStatement(String)")
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
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  void testSetWebStatementProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  void testSetWebStatementProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  void testSetWebStatementProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(url, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
  @DisplayName("Test setWebStatementProperty(URLType)")
  void testSetWebStatementProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple("https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setWebStatementProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  void testGetCertificateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  void testGetCertificateProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificateProperty()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  @DisplayName("Test getCertificateProperty()")
  void testGetCertificateProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificateProperty());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName("Test getCertificate()")
  void testGetCertificate() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName("Test getCertificate()")
  void testGetCertificate2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#getCertificate()}.
   * <ul>
   *   <li>Given
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  @DisplayName("Test getCertificate(); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetCertificate_givenXMPRightsManagementSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getCertificate());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
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
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
  void testSetCertificate2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setCertificate("https://example.org/example");

    // Assert
    assertEquals(3, xmpRightsManagementSchema.getAllProperties().size());
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificate(String)}.
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String)")
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
   * <ul>
   *   <li>Given
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)} with
   * metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  @DisplayName("Test setCertificate(String); given XMPRightsManagementSchema(XMPMetadata) with metadata is createXMPMetadata")
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
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  void testSetCertificateProperty() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(url, allProperties.get(0));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  void testSetCertificateProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  void testSetCertificateProperty3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertSame(url, allProperties.get(2));
  }

  /**
   * Test {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}.
   * <p>
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
  @DisplayName("Test setCertificateProperty(URLType)")
  void testSetCertificateProperty4() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple("https://example.org/example", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");
    URLType url = new URLType(XMPMetadata.createXMPMetadata(), "https://example.org/example",
        "https://example.org/example", "https://example.org/example", "Value");

    // Act
    xmpRightsManagementSchema.setCertificateProperty(url);

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertSame(url, allProperties.get(1));
  }
}
