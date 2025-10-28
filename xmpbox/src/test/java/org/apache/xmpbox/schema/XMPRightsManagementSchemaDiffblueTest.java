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
import org.junit.jupiter.api.Test;

class XMPRightsManagementSchemaDiffblueTest {
  /**
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
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
    List<String> elementsAsString = ownersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTermsProperty());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(0));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  void testAddOwner2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    List<AbstractField> allProperties = ownersProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(0));
    assertEquals("42", owners.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTermsProperty());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(0));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  void testAddOwner3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("li", XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    List<AbstractField> allProperties = ownersProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(2, owners.size());
    assertEquals("42", owners.get(0));
    assertEquals("42", owners.get(1));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(owners, ownersProperty.getElementsAsString());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(1));
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
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
    List<String> elementsAsString = ownersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties2.get(1));
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#addOwner(String)}
   */
  @Test
  void testAddOwner5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple("Simple Name", "42");
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, "42");

    // Act
    xmpRightsManagementSchema.addOwner("42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    List<AbstractField> allProperties2 = ownersProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    List<String> owners = xmpRightsManagementSchema.getOwners();
    assertEquals(1, owners.size());
    assertEquals("42", owners.get(0));
    List<String> elementsAsString = ownersProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", ownersProperty.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", ownersProperty.getPrefix());
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    assertEquals(1, usageTermsProperty.getElementsAsString().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ownersProperty.getArrayType());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllAttributes().isEmpty());
    assertTrue(ownersProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, ownersProperty.getPropertyName());
    assertSame(ownersProperty, allProperties.get(2));
    assertSame(usageTermsProperty, allProperties.get(1));
    assertSame(allProperties2, ownersProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, ownersProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  void testRemoveOwner() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert that nothing has changed
    assertNull(xmpRightsManagementSchema.getOwners());
    assertNull(xmpRightsManagementSchema.getOwnersProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
  void testRemoveOwner3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner(XMPRightsManagementSchema.OWNER);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.removeOwner("42");

    // Assert
    assertEquals(1, xmpRightsManagementSchema.getOwners().size());
    ArrayProperty ownersProperty = xmpRightsManagementSchema.getOwnersProperty();
    assertEquals(1, ownersProperty.getAllProperties().size());
    assertEquals(1, ownersProperty.getElementsAsString().size());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#removeOwner(String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  void testGetOwnersProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getOwnersProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  void testGetOwnersProperty2() {
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
   * Method under test: {@link XMPRightsManagementSchema#getOwnersProperty()}
   */
  @Test
  void testGetOwnersProperty3() {
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
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  void testGetOwners() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getOwners());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  void testGetOwners2() {
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
   * Method under test: {@link XMPRightsManagementSchema#getOwners()}
   */
  @Test
  void testGetOwners3() {
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
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  void testSetMarked() {
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
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  void testSetMarked2() {
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
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  void testSetMarked3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("True", XMPRightsManagementSchema.MARKED);
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
    assertEquals(3, allProperties.size());
    assertTrue(markedProperty.getAllAttributes().isEmpty());
    assertTrue(xmpRightsManagementSchema.getMarked());
    assertTrue(markedProperty.getValue());
    assertEquals(XMPRightsManagementSchema.MARKED, markedProperty.getPropertyName());
    assertSame(markedProperty, allProperties.get(2));
    assertSame(metadata, markedProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setMarked(Boolean)}
   */
  @Test
  void testSetMarked4() {
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setMarkedProperty(BooleanType)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  void testGetMarkedProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getMarkedProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
  void testGetMarkedProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarkedProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getMarkedProperty()}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  void testGetMarked() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getMarked());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  void testGetMarked2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getMarked()}
   */
  @Test
  void testGetMarked3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.MARKED);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getMarked());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTerms());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
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
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTerms());
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
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTerms());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, usageTermsLanguages.get(0));
    assertEquals(XMPRightsManagementSchema.OWNER, getResult4.getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(0));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getValue());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTerms());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
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
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
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
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("Lang", getResult3.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult4.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(0));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult).getValue());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms6() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple("Simple Name", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("Lang", "42");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties2 = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult = allProperties2.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(0));
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("Lang", getResult2.getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertNull(xmpRightsManagementSchema.getUsageTerms());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(2));
    assertSame(allProperties2, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms7() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);

    // Act
    xmpRightsManagementSchema.addUsageTerms("", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
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
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
  void testAddUsageTerms8() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.addUsageTerms("x-default", "42");

    // Assert
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties = usageTermsProperty.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.OWNER, usageTermsLanguages.get(1));
    assertEquals(XMPRightsManagementSchema.OWNER, getResult4.getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getValue());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#addUsageTerms(String, String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
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
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
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
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
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
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
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
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  void testSetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
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
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(2, allProperties2.size());
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
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
  void testSetUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addBagValueAsSimple("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act
    xmpRightsManagementSchema.setUsageTerms("Terms");

    // Assert
    List<AbstractField> allProperties = xmpRightsManagementSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    ArrayProperty usageTermsProperty = xmpRightsManagementSchema.getUsageTermsProperty();
    List<AbstractField> allProperties2 = usageTermsProperty.getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult = allProperties2.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult2 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getNamespace());
    assertEquals("lang", getResult2.getName());
    assertEquals("li", getResult.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(1, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult2.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertSame(usageTermsProperty, allProperties.get(2));
    assertSame(allProperties2, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
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
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes = getResult.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    List<Attribute> allAttributes2 = getResult2.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult4 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(2, usageTermsLanguages.size());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult3.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, getResult4.getValue());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
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
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof TextType);
    List<String> elementsAsString = usageTermsProperty.getElementsAsString();
    assertEquals(3, elementsAsString.size());
    assertEquals("42", elementsAsString.get(2));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    List<String> usageTermsLanguages = xmpRightsManagementSchema.getUsageTermsLanguages();
    assertEquals(3, usageTermsLanguages.size());
    assertEquals("Lang", usageTermsLanguages.get(1));
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult4 = allAttributes.get(0);
    assertEquals("Lang", getResult4.getValue());
    assertEquals("Terms", elementsAsString.get(0));
    assertEquals("Terms", xmpRightsManagementSchema.getUsageTerms());
    assertEquals("Terms", ((TextType) getResult).getStringValue());
    assertEquals("Terms", ((TextType) getResult).getRawValue());
    assertEquals("Terms", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/xap/1.0/rights/", usageTermsProperty.getNamespace());
    List<Attribute> allAttributes2 = getResult.getAllAttributes();
    assertEquals(1, allAttributes2.size());
    Attribute getResult5 = allAttributes2.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult5.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult4.getNamespace());
    List<Attribute> allAttributes3 = getResult3.getAllAttributes();
    assertEquals(1, allAttributes3.size());
    Attribute getResult6 = allAttributes3.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult6.getNamespace());
    assertEquals("lang", getResult5.getName());
    assertEquals("lang", getResult4.getName());
    assertEquals("lang", getResult6.getName());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("x-default", usageTermsLanguages.get(0));
    assertEquals("x-default", getResult5.getValue());
    assertEquals("xmpRights", getResult.getPrefix());
    assertEquals("xmpRights", getResult2.getPrefix());
    assertEquals("xmpRights", getResult3.getPrefix());
    assertEquals("xmpRights", usageTermsProperty.getPrefix());
    List<AbstractField> allProperties2 = xmpRightsManagementSchema.getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Alt, usageTermsProperty.getArrayType());
    assertTrue(usageTermsProperty.getAllAttributes().isEmpty());
    assertTrue(usageTermsProperty.getAllNamespacesWithPrefix().isEmpty());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsLanguages.get(2));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, elementsAsString.get(1));
    assertEquals(XMPRightsManagementSchema.USAGETERMS, usageTermsProperty.getPropertyName());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, getResult6.getValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getStringValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getRawValue());
    assertEquals(XMPRightsManagementSchema.USAGETERMS, ((TextType) getResult2).getValue());
    assertSame(usageTermsProperty, allProperties2.get(0));
    assertSame(allProperties, usageTermsProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, usageTermsProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setUsageTerms(String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  void testGetUsageTermsProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTermsProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  void testGetUsageTermsProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsProperty()}
   */
  @Test
  void testGetUsageTermsProperty3() {
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
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  void testGetUsageTermsLanguages() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTermsLanguages());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  void testGetUsageTermsLanguages2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTermsLanguages());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  void testGetUsageTermsLanguages3() throws BadFieldValueException {
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
   * Method under test: {@link XMPRightsManagementSchema#getUsageTermsLanguages()}
   */
  @Test
  void testGetUsageTermsLanguages4() throws BadFieldValueException {
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
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  void testGetUsageTerms() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTerms());
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getUsageTerms("Lang"));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  void testGetUsageTerms2() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  void testGetUsageTerms3() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("x-default", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  void testGetUsageTerms4() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms()}
   */
  @Test
  void testGetUsageTerms5() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  void testGetUsageTerms6() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  void testGetUsageTerms7() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  void testGetUsageTerms8() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addBagValueAsSimple(XMPRightsManagementSchema.USAGETERMS, "42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getUsageTerms(String)}
   */
  @Test
  void testGetUsageTerms9() throws BadFieldValueException {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms("Lang", XMPRightsManagementSchema.USAGETERMS);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertEquals(XMPRightsManagementSchema.USAGETERMS, xmpRightsManagementSchema.getUsageTerms("Lang"));
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  void testGetWebStatementProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getWebStatementProperty());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
  void testGetWebStatementProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatementProperty());
  }

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#getWebStatementProperty()}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  void testGetWebStatement() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getWebStatement());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
  void testGetWebStatement2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getWebStatement());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getWebStatement()}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
  void testSetWebStatement3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.WEBSTATEMENT);
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
    assertEquals(3, allProperties.size());
    assertTrue(webStatementProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.WEBSTATEMENT, webStatementProperty.getPropertyName());
    assertSame(metadata, webStatementProperty.getMetadata());
    assertSame(webStatementProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setWebStatement(String)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setWebStatementProperty(URLType)}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  void testGetCertificateProperty() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getCertificateProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
  void testGetCertificateProperty2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificateProperty());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getCertificateProperty()}
   */
  @Test
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
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  void testGetCertificate() {
    // Arrange, Act and Assert
    assertNull((new XMPRightsManagementSchema(XMPMetadata.createXMPMetadata())).getCertificate());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  void testGetCertificate2() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#getCertificate()}
   */
  @Test
  void testGetCertificate3() {
    // Arrange
    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(
        XMPMetadata.createXMPMetadata());
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
    xmpRightsManagementSchema.addOwner("42");

    // Act and Assert
    assertNull(xmpRightsManagementSchema.getCertificate());
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  void testSetCertificate() {
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
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  void testSetCertificate2() {
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
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  void testSetCertificate3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    XMPRightsManagementSchema xmpRightsManagementSchema = new XMPRightsManagementSchema(metadata);
    xmpRightsManagementSchema.addUsageTerms(XMPRightsManagementSchema.OWNER, XMPRightsManagementSchema.CERTIFICATE);
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
    assertEquals(3, allProperties.size());
    assertTrue(certificateProperty.getAllAttributes().isEmpty());
    assertEquals(XMPRightsManagementSchema.CERTIFICATE, certificateProperty.getPropertyName());
    assertSame(metadata, certificateProperty.getMetadata());
    assertSame(certificateProperty, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPRightsManagementSchema#setCertificate(String)}
   */
  @Test
  void testSetCertificate4() {
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#setCertificateProperty(URLType)}
   */
  @Test
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

  /**
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}
   */
  @Test
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
   * Method under test:
   * {@link XMPRightsManagementSchema#XMPRightsManagementSchema(XMPMetadata, String)}
   */
  @Test
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
}
