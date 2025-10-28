package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.junit.jupiter.api.Test;

class XMPSchemaDiffblueTest {
  /**
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  void testGetAbstractProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAbstractProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  void testGetAbstractProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getAbstractProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  void testGetAbstractProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    AbstractField actualAbstractProperty = adobePDFSchema.getAbstractProperty("Qualified Name");

    // Assert
    assertTrue(actualAbstractProperty instanceof ArrayProperty);
    List<AbstractField> allProperties = ((ArrayProperty) actualAbstractProperty).getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) actualAbstractProperty).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Bag Value", elementsAsString.get(0));
    assertEquals("Bag Value", ((TextType) getResult).getStringValue());
    assertEquals("Bag Value", ((TextType) getResult).getRawValue());
    assertEquals("Bag Value", ((TextType) getResult).getValue());
    assertEquals("Qualified Name", actualAbstractProperty.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualAbstractProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", actualAbstractProperty.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) actualAbstractProperty).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualAbstractProperty.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) actualAbstractProperty).getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, ((ArrayProperty) actualAbstractProperty).getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualAbstractProperty.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getAboutAttribute()}
   */
  @Test
  void testGetAboutAttribute() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAboutAttribute());
  }

  /**
   * Method under test: {@link XMPSchema#getAboutValue()}
   */
  @Test
  void testGetAboutValue() {
    // Arrange, Act and Assert
    assertEquals("", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAboutValue());
  }

  /**
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  void testSetAbout() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class,
        () -> adobePDFSchema.setAbout(new Attribute("Ns URI", "Local Name", "42")));
  }

  /**
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  void testSetAbout2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema
        .setAbout(new Attribute("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "Local Name", "42")));
  }

  /**
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  void testSetAbout3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    Attribute about = new Attribute("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "about", "42");

    // Act
    adobePDFSchema.setAbout(about);

    // Assert
    assertEquals("42", adobePDFSchema.getAboutValue());
    List<Attribute> allAttributes = adobePDFSchema.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertSame(about, allAttributes.get(0));
    assertSame(about, adobePDFSchema.getAboutAttribute());
    assertSame(metadata, adobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setAboutAsSimple(String)}
   */
  @Test
  void testSetAboutAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setAboutAsSimple("About");

    // Assert
    assertEquals("About", adobePDFSchema.getAboutValue());
    Attribute aboutAttribute = adobePDFSchema.getAboutAttribute();
    assertEquals("About", aboutAttribute.getValue());
    assertEquals("about", aboutAttribute.getName());
    assertEquals("http://www.w3.org/1999/02/22-rdf-syntax-ns#", aboutAttribute.getNamespace());
    List<Attribute> allAttributes = adobePDFSchema.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertSame(aboutAttribute, allAttributes.get(0));
    assertSame(metadata, adobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setAboutAsSimple(String)}
   */
  @Test
  void testSetAboutAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setAboutAsSimple(null);

    // Assert
    assertEquals("", adobePDFSchema.getAboutValue());
    assertNull(adobePDFSchema.getAboutAttribute());
    assertTrue(adobePDFSchema.getAllAttributes().isEmpty());
    assertSame(metadata, adobePDFSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  void testSetTextProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    TextType prop = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    adobePDFSchema.setTextProperty(prop);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(prop, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  void testSetTextProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    TextType prop = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    adobePDFSchema.setTextProperty(prop);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertSame(prop, allProperties.get(1));
  }

  /**
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  void testSetTextProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Property Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    TextType prop = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    adobePDFSchema.setTextProperty(prop);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    assertTrue(allProperties.get(0) instanceof ArrayProperty);
    assertTrue(allProperties.get(1) instanceof ArrayProperty);
    assertSame(prop, allProperties.get(2));
  }

  /**
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  void testSetTextProperty4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Property Name", "Bag Value");
    TextType prop = new TextType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value");

    // Act
    adobePDFSchema.setTextProperty(prop);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(prop, allProperties.get(0));
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("Qualified Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Qualified Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof TextType);
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Qualified Name", getResult3.getPropertyName());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  void testSetTextPropertyValue6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof TextType);
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("42", "Simple Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof TextType);
    assertEquals("42", getResult.getPropertyName());
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("42", ((TextType) getResult).getStringValue());
    assertEquals("42", ((TextType) getResult).getRawValue());
    assertEquals("42", ((TextType) getResult).getValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  void testSetTextPropertyValueAsSimple6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  void testGetUnqualifiedTextProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedTextProperty("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  void testGetUnqualifiedTextProperty2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  void testGetUnqualifiedTextProperty3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  void testGetUnqualifiedTextProperty4() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  void testGetUnqualifiedTextPropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  void testGetUnqualifiedTextPropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  void testGetUnqualifiedTextPropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  void testGetUnqualifiedTextPropertyValue4() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  void testGetDateProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDateProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  void testGetDateProperty2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDateProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  void testGetDateProperty3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDateProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  void testGetDatePropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  void testGetDatePropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  void testGetDatePropertyValueAsSimple3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  void testGetDatePropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  void testGetDatePropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  void testGetDatePropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDatePropertyValue("Qualified Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("42", "Simple Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof DateType);
    assertEquals("42", getResult.getPropertyName());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValueAsSimple6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("Qualified Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Qualified Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof DateType);
    assertEquals("Qualified Name", getResult3.getPropertyName());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  void testSetDatePropertyValue6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  void testGetBooleanProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  void testGetBooleanProperty2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  void testGetBooleanProperty3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  void testGetBooleanPropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  void testGetBooleanPropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  void testGetBooleanPropertyValueAsSimple3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  void testGetBooleanPropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  void testGetBooleanPropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  void testGetBooleanPropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof BooleanType);
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("True", ((BooleanType) getResult2).getStringValue());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult2).getValue());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("42", "Simple Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof BooleanType);
    assertEquals("42", getResult.getPropertyName());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("True", ((BooleanType) getResult3).getStringValue());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult3).getValue());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValueAsSimple7() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", null);

    // Assert
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof BooleanType);
    assertEquals("Qualified Name", getResult2.getPropertyName());
    assertEquals("True", ((BooleanType) getResult2).getStringValue());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult2).getValue());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Qualified Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof BooleanType);
    assertEquals("Qualified Name", getResult3.getPropertyName());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("True", ((BooleanType) getResult3).getStringValue());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult3).getValue());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((BooleanType) getResult).getValue());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  void testSetBooleanPropertyValue7() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", null);

    // Assert
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  void testGetIntegerProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  void testGetIntegerProperty2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  void testGetIntegerProperty3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerProperty("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  void testGetIntegerPropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  void testGetIntegerPropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  void testGetIntegerPropertyValueAsSimple3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  void testGetIntegerPropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  void testGetIntegerPropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  void testGetIntegerPropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult2).getStringValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertEquals(42, ((IntegerType) getResult2).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("42", "Simple Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof IntegerType);
    assertEquals("42", getResult.getPropertyName());
    assertEquals("42", ((IntegerType) getResult3).getStringValue());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(42, ((IntegerType) getResult3).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValueAsSimple6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult2).getStringValue());
    assertEquals("Qualified Name", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertNull(getResult2.getNamespace());
    assertEquals(42, ((IntegerType) getResult2).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Qualified Name");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult3).getStringValue());
    assertEquals("Qualified Name", getResult3.getPropertyName());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("pdf", getResult3.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(42, ((IntegerType) getResult3).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult2.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  void testSetIntegerPropertyValue6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertEquals(AdobePDFSchema.KEYWORDS, getResult.getPropertyName());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  void testRemoveUnqualifiedBagValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.removeUnqualifiedBagValue("Bag Name", "42");

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  void testRemoveUnqualifiedBagValue2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedBagValue("Bag Name", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  void testRemoveUnqualifiedBagValue3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Bag Name", "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedBagValue("Bag Name", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  void testRemoveUnqualifiedBagValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Bag Name", "42");
    adobePDFSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    adobePDFSchema.removeUnqualifiedBagValue("Bag Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(((ArrayProperty) getResult).getAllProperties().isEmpty());
    assertTrue(((ArrayProperty) getResult).getElementsAsString().isEmpty());
  }

  /**
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  void testAddBagValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  void testAddBagValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");

    // Act
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("li", elementsAsString.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", ((TextType) getResult2).getStringValue());
    assertEquals("li", ((TextType) getResult2).getRawValue());
    assertEquals("li", ((TextType) getResult2).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  void testAddBagValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "li");

    // Act
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("Simple Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult3).getStringValue());
    assertEquals("li", ((TextType) getResult3).getRawValue());
    assertEquals("li", ((TextType) getResult3).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  void testAddBagValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("RDF", "42");
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "li");

    // Act
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<String> elementsAsString2 = ((ArrayProperty) getResult3).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("42", elementsAsString2.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    assertEquals("RDF", getResult.getPropertyName());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("Simple Seq Name", getResult2.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    List<String> elementsAsString3 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString3.size());
    assertEquals("li", elementsAsString3.get(0));
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getStringValue());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("li", ((TextType) getResult5).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult3).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  void testAddQualifiedBagValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.addQualifiedBagValue("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  void testAddQualifiedBagValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");

    // Act
    adobePDFSchema.addQualifiedBagValue("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("li", elementsAsString.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", ((TextType) getResult2).getStringValue());
    assertEquals("li", ((TextType) getResult2).getRawValue());
    assertEquals("li", ((TextType) getResult2).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  void testAddQualifiedBagValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "li");

    // Act
    adobePDFSchema.addQualifiedBagValue("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("Simple Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult3).getStringValue());
    assertEquals("li", ((TextType) getResult3).getRawValue());
    assertEquals("li", ((TextType) getResult3).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  void testAddQualifiedBagValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("RDF", "42");
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "li");

    // Act
    adobePDFSchema.addQualifiedBagValue("Simple Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    List<String> elementsAsString2 = ((ArrayProperty) getResult3).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("42", elementsAsString2.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    assertEquals("RDF", getResult.getPropertyName());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("Simple Seq Name", getResult2.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    List<String> elementsAsString3 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString3.size());
    assertEquals("li", elementsAsString3.get(0));
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getStringValue());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("li", ((TextType) getResult5).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult3).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  void testGetUnqualifiedBagValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedBagValueList("Bag Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  void testGetUnqualifiedBagValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedBagValueList("Bag Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  void testGetUnqualifiedBagValueList3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Bag Name", "Bag Value");

    // Act
    List<String> actualUnqualifiedBagValueList = adobePDFSchema.getUnqualifiedBagValueList("Bag Name");

    // Assert
    assertEquals(1, actualUnqualifiedBagValueList.size());
    assertEquals("Bag Value", actualUnqualifiedBagValueList.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  void testAddUnqualifiedSequenceValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("Simple Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  void testAddUnqualifiedSequenceValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("Simple Seq Name", getResult2.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult3).getStringValue());
    assertEquals("li", ((TextType) getResult3).getRawValue());
    assertEquals("li", ((TextType) getResult3).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  void testAddUnqualifiedSequenceValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "li");

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult3).getStringValue());
    assertEquals("42", ((TextType) getResult3).getRawValue());
    assertEquals("42", ((TextType) getResult3).getValue());
    assertEquals("Simple Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("li", elementsAsString.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", ((TextType) getResult2).getStringValue());
    assertEquals("li", ((TextType) getResult2).getRawValue());
    assertEquals("li", ((TextType) getResult2).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  void testAddUnqualifiedSequenceValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("li", "Simple Seq Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult3).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("Simple Seq Name", elementsAsString2.get(0));
    assertEquals("Simple Seq Name", getResult3.getPropertyName());
    assertEquals("Simple Seq Name", ((TextType) getResult4).getStringValue());
    assertEquals("Simple Seq Name", ((TextType) getResult4).getRawValue());
    assertEquals("Simple Seq Name", ((TextType) getResult4).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    List<String> elementsAsString3 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString3.size());
    assertEquals("li", elementsAsString3.get(0));
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getStringValue());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("li", ((TextType) getResult5).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult3).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedSequenceValueList("Seq Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedSequenceValueList("Seq Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceValueList3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Seq Name", "Bag Value");

    // Act
    List<String> actualUnqualifiedSequenceValueList = adobePDFSchema.getUnqualifiedSequenceValueList("Seq Name");

    // Assert
    assertEquals(1, actualUnqualifiedSequenceValueList.size());
    assertEquals("Bag Value", actualUnqualifiedSequenceValueList.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testRemoveUnqualifiedSequenceDateValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.removeUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testRemoveUnqualifiedSequenceDateValue2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testRemoveUnqualifiedSequenceDateValue3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Seq Name", "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testRemoveUnqualifiedSequenceDateValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Act
    adobePDFSchema.removeUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(((ArrayProperty) getResult).getAllProperties().isEmpty());
    assertTrue(((ArrayProperty) getResult).getElementsAsString().isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testRemoveUnqualifiedSequenceDateValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addSequenceDateValueAsSimple("Seq Name", new GregorianCalendar(-1, 1, 1));
    adobePDFSchema.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act
    adobePDFSchema.removeUnqualifiedSequenceDateValue("Seq Name", new GregorianCalendar(1, 1, 1));

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  void testAddSequenceDateValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addSequenceDateValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("RDF", getResult2.getPrefix());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult2.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  void testAddSequenceDateValueAsSimple2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addSequenceDateValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof DateType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult3.getPrefix());
    assertEquals("RDF", ((TextType) getResult4).getRawValue());
    assertEquals("Simple Name", getResult2.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult2).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  void testAddSequenceDateValueAsSimple3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addSequenceDateValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof DateType);
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult3.getPrefix());
    assertEquals("RDF", ((TextType) getResult5).getRawValue());
    assertEquals("Simple Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", ((TextType) getResult4).getRawValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  void testAddSequenceDateValueAsSimple4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("RDF", "li");
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addSequenceDateValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof DateType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult4.getPrefix());
    assertEquals("RDF", getResult.getPropertyName());
    assertEquals("RDF", ((TextType) getResult6).getRawValue());
    assertEquals("Simple Name", getResult3.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertNull(getResult4.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult3).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult3).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult4).getRawValue());
    assertSame(date, ((DateType) getResult4).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testAddUnqualifiedSequenceDateValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("RDF", getResult2.getPrefix());
    assertEquals("Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult2.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testAddUnqualifiedSequenceDateValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof DateType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult3.getPrefix());
    assertEquals("RDF", ((TextType) getResult4).getRawValue());
    assertEquals("Seq Name", getResult2.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult2).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testAddUnqualifiedSequenceDateValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Seq Name", "li");
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(1);
    assertTrue(getResult3 instanceof DateType);
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult3.getPrefix());
    assertEquals("RDF", ((TextType) getResult5).getRawValue());
    assertEquals("Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", ((TextType) getResult4).getRawValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertNull(getResult3.getNamespace());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult3).getRawValue());
    assertSame(date, ((DateType) getResult3).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  void testAddUnqualifiedSequenceDateValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("RDF", "li");
    adobePDFSchema.addBagValueAsSimple("li", "RDF");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof DateType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("RDF", elementsAsString.get(0));
    assertEquals("RDF", getResult4.getPrefix());
    assertEquals("RDF", getResult.getPropertyName());
    assertEquals("RDF", ((TextType) getResult6).getRawValue());
    assertEquals("Seq Name", getResult3.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertNull(getResult4.getNamespace());
    assertEquals(1, ((ArrayProperty) getResult3).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult3).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(getResult6.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(date, ((DateType) getResult4).getRawValue());
    assertSame(date, ((DateType) getResult4).getValue());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceDateValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedSequenceDateValueList("Seq Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceDateValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedSequenceDateValueList("Seq Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceDateValueList3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Seq Name", "Bag Value");

    // Act and Assert
    assertTrue(adobePDFSchema.getUnqualifiedSequenceDateValueList("Seq Name").isEmpty());
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  void testGetUnqualifiedSequenceDateValueList4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    adobePDFSchema.addUnqualifiedSequenceDateValue("Seq Name", date);

    // Act
    List<Calendar> actualUnqualifiedSequenceDateValueList = adobePDFSchema
        .getUnqualifiedSequenceDateValueList("Seq Name");

    // Assert
    assertEquals(1, actualUnqualifiedSequenceDateValueList.size());
    assertSame(date, actualUnqualifiedSequenceDateValueList.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "en", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("Name", getResult.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("en", getResult3.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("http://www.w3.org/XML/1998/namespace", "li");

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "en", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult3 = allProperties2.get(0);
    assertTrue(getResult3 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult4 = allProperties3.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult4).getStringValue());
    assertEquals("42", ((TextType) getResult4).getRawValue());
    assertEquals("42", ((TextType) getResult4).getValue());
    assertEquals("Name", getResult2.getPropertyName());
    List<Attribute> allAttributes = getResult4.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult5 = allAttributes.get(0);
    assertEquals("en", getResult5.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult.getPropertyName());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult5.getNamespace());
    assertEquals("lang", getResult5.getName());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("li", elementsAsString2.get(0));
    assertEquals("li", getResult3.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", ((TextType) getResult3).getStringValue());
    assertEquals("li", ((TextType) getResult3).getRawValue());
    assertEquals("li", ((TextType) getResult3).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult2).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("li", "Name");
    adobePDFSchema.addBagValueAsSimple("http://www.w3.org/XML/1998/namespace", "li");

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "en", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    AbstractField getResult2 = allProperties.get(1);
    assertTrue(getResult2 instanceof ArrayProperty);
    AbstractField getResult3 = allProperties.get(2);
    assertTrue(getResult3 instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult4 = allProperties2.get(0);
    assertTrue(getResult4 instanceof TextType);
    List<AbstractField> allProperties3 = ((ArrayProperty) getResult2).getAllProperties();
    assertEquals(1, allProperties3.size());
    AbstractField getResult5 = allProperties3.get(0);
    assertTrue(getResult5 instanceof TextType);
    List<AbstractField> allProperties4 = ((ArrayProperty) getResult3).getAllProperties();
    assertEquals(1, allProperties4.size());
    AbstractField getResult6 = allProperties4.get(0);
    assertTrue(getResult6 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult3).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("42", elementsAsString.get(0));
    assertEquals("42", ((TextType) getResult6).getStringValue());
    assertEquals("42", ((TextType) getResult6).getRawValue());
    assertEquals("42", ((TextType) getResult6).getValue());
    List<String> elementsAsString2 = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(1, elementsAsString2.size());
    assertEquals("Name", elementsAsString2.get(0));
    assertEquals("Name", getResult3.getPropertyName());
    assertEquals("Name", ((TextType) getResult4).getStringValue());
    assertEquals("Name", ((TextType) getResult4).getRawValue());
    assertEquals("Name", ((TextType) getResult4).getValue());
    List<Attribute> allAttributes = getResult6.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult7 = allAttributes.get(0);
    assertEquals("en", getResult7.getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult3.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult4.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult5.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult6.getNamespace());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult2.getPropertyName());
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult7.getNamespace());
    assertEquals("lang", getResult7.getName());
    List<String> elementsAsString3 = ((ArrayProperty) getResult2).getElementsAsString();
    assertEquals(1, elementsAsString3.size());
    assertEquals("li", elementsAsString3.get(0));
    assertEquals("li", getResult.getPropertyName());
    assertEquals("li", getResult4.getPropertyName());
    assertEquals("li", getResult5.getPropertyName());
    assertEquals("li", getResult6.getPropertyName());
    assertEquals("li", ((TextType) getResult5).getStringValue());
    assertEquals("li", ((TextType) getResult5).getRawValue());
    assertEquals("li", ((TextType) getResult5).getValue());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("pdf", getResult3.getPrefix());
    assertEquals("pdf", getResult4.getPrefix());
    assertEquals("pdf", getResult5.getPrefix());
    assertEquals("pdf", getResult6.getPrefix());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult3).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult2).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertTrue(getResult3.getAllAttributes().isEmpty());
    assertTrue(getResult4.getAllAttributes().isEmpty());
    assertTrue(getResult5.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult2).getAllNamespacesWithPrefix().isEmpty());
    assertTrue(((ArrayProperty) getResult3).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
    assertSame(metadata, getResult3.getMetadata());
    assertSame(metadata, getResult4.getMetadata());
    assertSame(metadata, getResult5.getMetadata());
    assertSame(metadata, getResult6.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", null, "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("x-default", getResult3.getValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue5() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
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
    assertEquals("Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", getResult2.getPrefix());
    assertEquals("x-default", getResult3.getValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue6() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value");

    adobePDFSchema.addProperty(obj);

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "en", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(obj, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  void testSetUnqualifiedLanguagePropertyValue7() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    ArrayProperty obj = new ArrayProperty(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", Cardinality.Simple);

    adobePDFSchema.addProperty(obj);

    // Act
    adobePDFSchema.setUnqualifiedLanguagePropertyValue("Name", "en", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(obj, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyValue("Name", "en"));
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyValue("Name", null));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyValue4() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyLanguagesValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(
        (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyLanguagesValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyLanguagesValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act
    List<String> actualUnqualifiedLanguagePropertyLanguagesValue = adobePDFSchema
        .getUnqualifiedLanguagePropertyLanguagesValue("Name");

    // Assert
    assertEquals(1, actualUnqualifiedLanguagePropertyLanguagesValue.size());
    assertEquals("x-default", actualUnqualifiedLanguagePropertyLanguagesValue.get(0));
  }

  /**
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  void testGetUnqualifiedLanguagePropertyLanguagesValue4() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class,
        () -> adobePDFSchema.getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  void testGetUnqualifiedArrayList() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedArrayList("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  void testGetUnqualifiedArrayList2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedArrayList("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  void testGetUnqualifiedArrayList3() throws BadFieldValueException {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act
    List<AbstractField> actualUnqualifiedArrayList = adobePDFSchema.getUnqualifiedArrayList("Name");

    // Assert
    assertEquals(1, actualUnqualifiedArrayList.size());
    AbstractField getResult = actualUnqualifiedArrayList.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Bag Value", ((TextType) getResult).getStringValue());
    assertEquals("Bag Value", ((TextType) getResult).getRawValue());
    assertEquals("Bag Value", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  void testGetUnqualifiedArrayList4() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedArrayList("Name"));
  }

  /**
   * Method under test: {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}
   */
  @Test
  void testNewXMPSchema() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualXmpSchema = new XMPSchema(metadata, "Namespace URI", "Prefix");

    // Assert
    assertEquals("", actualXmpSchema.getAboutValue());
    assertEquals("Namespace URI", actualXmpSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("Namespace URI"));
    assertEquals("Prefix", actualXmpSchema.getPreferedPrefix());
    assertEquals("Prefix", actualXmpSchema.getPrefix());
    assertNull(actualXmpSchema.getPropertyName());
    assertNull(actualXmpSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpSchema.getMetadata());
  }

  /**
   * Method under test: {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}
   */
  @Test
  void testNewXMPSchema2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualXmpSchema = new XMPSchema(metadata, "Namespace URI", null);

    // Assert
    assertEquals("", actualXmpSchema.getAboutValue());
    assertEquals("Namespace URI", actualXmpSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Namespace URI"));
    assertNull(actualXmpSchema.getPropertyName());
    assertNull(actualXmpSchema.getPreferedPrefix());
    assertNull(actualXmpSchema.getPrefix());
    assertNull(actualXmpSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}
   */
  @Test
  void testNewXMPSchema3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualXmpSchema = new XMPSchema(metadata, "Namespace URI", "Prefix", "Name");

    // Assert
    assertEquals("", actualXmpSchema.getAboutValue());
    assertEquals("Name", actualXmpSchema.getPropertyName());
    assertEquals("Namespace URI", actualXmpSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("Namespace URI"));
    assertEquals("Prefix", actualXmpSchema.getPreferedPrefix());
    assertEquals("Prefix", actualXmpSchema.getPrefix());
    assertNull(actualXmpSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpSchema.getMetadata());
  }

  /**
   * Method under test:
   * {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}
   */
  @Test
  void testNewXMPSchema4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    XMPSchema actualXmpSchema = new XMPSchema(metadata, "Namespace URI", null, "Name");

    // Assert
    assertEquals("", actualXmpSchema.getAboutValue());
    assertEquals("Name", actualXmpSchema.getPropertyName());
    assertEquals("Namespace URI", actualXmpSchema.getNamespace());
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Namespace URI"));
    assertNull(actualXmpSchema.getPreferedPrefix());
    assertNull(actualXmpSchema.getPrefix());
    assertNull(actualXmpSchema.getAboutAttribute());
    List<AbstractField> allProperties = actualXmpSchema.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualXmpSchema.getAllAttributes().isEmpty());
    assertSame(allProperties, actualXmpSchema.getContainer().getAllProperties());
    assertSame(metadata, actualXmpSchema.getMetadata());
  }
}
