package org.apache.xmpbox.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import org.apache.xmpbox.type.ComplexPropertyContainer;
import org.apache.xmpbox.type.DateType;
import org.apache.xmpbox.type.IntegerType;
import org.apache.xmpbox.type.TextType;
import org.apache.xmpbox.type.TypeMapping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class XMPSchemaDiffblueTest {
  /**
   * Test {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}.
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Namespace URI} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}
   */
  @Test
  @DisplayName("Test new XMPSchema(XMPMetadata, String, String); then return AllNamespacesWithPrefix 'Namespace URI' is 'null'")
  void testNewXMPSchema_thenReturnAllNamespacesWithPrefixNamespaceUriIsNull() {
    // Arrange and Act
    XMPSchema actualXmpSchema = new XMPSchema(XMPMetadata.createXMPMetadata(), "Namespace URI", null);

    // Assert
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Namespace URI"));
    assertNull(actualXmpSchema.getPreferedPrefix());
    assertNull(actualXmpSchema.getPrefix());
  }

  /**
   * Test {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}.
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Namespace URI} is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}
   */
  @Test
  @DisplayName("Test new XMPSchema(XMPMetadata, String, String, String); then return AllNamespacesWithPrefix 'Namespace URI' is 'null'")
  void testNewXMPSchema_thenReturnAllNamespacesWithPrefixNamespaceUriIsNull2() {
    // Arrange and Act
    XMPSchema actualXmpSchema = new XMPSchema(XMPMetadata.createXMPMetadata(), "Namespace URI", null, "Name");

    // Assert
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertNull(allNamespacesWithPrefix.get("Namespace URI"));
    assertNull(actualXmpSchema.getPreferedPrefix());
    assertNull(actualXmpSchema.getPrefix());
  }

  /**
   * Test {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}.
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Namespace URI} is
   * {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#XMPSchema(XMPMetadata, String, String)}
   */
  @Test
  @DisplayName("Test new XMPSchema(XMPMetadata, String, String); then return AllNamespacesWithPrefix 'Namespace URI' is 'Prefix'")
  void testNewXMPSchema_thenReturnAllNamespacesWithPrefixNamespaceUriIsPrefix() {
    // Arrange and Act
    XMPSchema actualXmpSchema = new XMPSchema(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix");

    // Assert
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("Namespace URI"));
    assertEquals("Prefix", actualXmpSchema.getPreferedPrefix());
    assertEquals("Prefix", actualXmpSchema.getPrefix());
  }

  /**
   * Test {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}.
   * <ul>
   *   <li>Then return AllNamespacesWithPrefix {@code Namespace URI} is
   * {@code Prefix}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#XMPSchema(XMPMetadata, String, String, String)}
   */
  @Test
  @DisplayName("Test new XMPSchema(XMPMetadata, String, String, String); then return AllNamespacesWithPrefix 'Namespace URI' is 'Prefix'")
  void testNewXMPSchema_thenReturnAllNamespacesWithPrefixNamespaceUriIsPrefix2() {
    // Arrange and Act
    XMPSchema actualXmpSchema = new XMPSchema(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Name");

    // Assert
    Map<String, String> allNamespacesWithPrefix = actualXmpSchema.getAllNamespacesWithPrefix();
    assertEquals(1, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("Namespace URI"));
    assertEquals("Prefix", actualXmpSchema.getPreferedPrefix());
    assertEquals("Prefix", actualXmpSchema.getPrefix());
  }

  /**
   * Test {@link XMPSchema#getAbstractProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  @DisplayName("Test getAbstractProperty(String)")
  void testGetAbstractProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getAbstractProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getAbstractProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  @DisplayName("Test getAbstractProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetAbstractProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAbstractProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getAbstractProperty(String)}.
   * <ul>
   *   <li>Then return {@link ArrayProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getAbstractProperty(String)}
   */
  @Test
  @DisplayName("Test getAbstractProperty(String); then return ArrayProperty")
  void testGetAbstractProperty_thenReturnArrayProperty() {
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
   * Test {@link XMPSchema#getAboutAttribute()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getAboutAttribute()}
   */
  @Test
  @DisplayName("Test getAboutAttribute(); then return 'null'")
  void testGetAboutAttribute_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAboutAttribute());
  }

  /**
   * Test {@link XMPSchema#getAboutValue()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getAboutValue()}
   */
  @Test
  @DisplayName("Test getAboutValue(); then return empty string")
  void testGetAboutValue_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAboutValue());
  }

  /**
   * Test {@link XMPSchema#setAbout(Attribute)}.
   * <p>
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  @DisplayName("Test setAbout(Attribute)")
  void testSetAbout() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema
        .setAbout(new Attribute("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "Local Name", "42")));
  }

  /**
   * Test {@link XMPSchema#setAbout(Attribute)}.
   * <ul>
   *   <li>Then {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata AboutValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  @DisplayName("Test setAbout(Attribute); then AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata AboutValue is '42'")
  void testSetAbout_thenAdobePDFSchemaWithMetadataIsCreateXMPMetadataAboutValueIs42() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    Attribute about = new Attribute("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "about", "42");

    // Act
    adobePDFSchema.setAbout(about);

    // Assert
    assertEquals("42", adobePDFSchema.getAboutValue());
    List<Attribute> allAttributes = adobePDFSchema.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertSame(about, allAttributes.get(0));
    assertSame(about, adobePDFSchema.getAboutAttribute());
  }

  /**
   * Test {@link XMPSchema#setAbout(Attribute)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#setAbout(Attribute)}
   */
  @Test
  @DisplayName("Test setAbout(Attribute); then throw BadFieldValueException")
  void testSetAbout_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertThrows(BadFieldValueException.class,
        () -> adobePDFSchema.setAbout(new Attribute("Ns URI", "Local Name", "42")));
  }

  /**
   * Test {@link XMPSchema#setAboutAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#setAboutAsSimple(String)}
   */
  @Test
  @DisplayName("Test setAboutAsSimple(String)")
  void testSetAboutAsSimple() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

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
  }

  /**
   * Test {@link XMPSchema#setAboutAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#setAboutAsSimple(String)}
   */
  @Test
  @DisplayName("Test setAboutAsSimple(String)")
  void testSetAboutAsSimple2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setAboutAsSimple(null);

    // Assert
    assertEquals("", adobePDFSchema.getAboutValue());
    assertTrue(adobePDFSchema.getAllAttributes().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setTextProperty(TextType)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTextProperty(TextType)")
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
   * Test {@link XMPSchema#setTextProperty(TextType)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTextProperty(TextType)")
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
   * Test {@link XMPSchema#setTextProperty(TextType)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTextProperty(TextType)")
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
   * Test {@link XMPSchema#setTextProperty(TextType)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextProperty(TextType)}
   */
  @Test
  @DisplayName("Test setTextProperty(TextType)")
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
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
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
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
  void testSetTextPropertyValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
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
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
  void testSetTextPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setTextPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#setTextPropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValue(String, String)")
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
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
  void testSetTextPropertyValueAsSimple4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
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
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
  void testSetTextPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setTextPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setTextPropertyValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test setTextPropertyValueAsSimple(String, String)")
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
   * Test {@link XMPSchema#getUnqualifiedTextProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextProperty(String)")
  void testGetUnqualifiedTextProperty() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedTextProperty("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextProperty(String)")
  void testGetUnqualifiedTextProperty2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextProperty(String)")
  void testGetUnqualifiedTextProperty3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value");

    adobePDFSchema.addProperty(obj);

    // Act and Assert
    assertSame(obj, adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextProperty(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextProperty(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextProperty(String); then throw BadFieldValueException")
  void testGetUnqualifiedTextProperty_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedTextProperty("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextPropertyValue(String)")
  void testGetUnqualifiedTextPropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextPropertyValue(String)")
  void testGetUnqualifiedTextPropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}.
   * <ul>
   *   <li>Then return {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextPropertyValue(String); then return 'Value'")
  void testGetUnqualifiedTextPropertyValue_thenReturnValue() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertEquals("Value", adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedTextPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedTextPropertyValue(String); then throw BadFieldValueException")
  void testGetUnqualifiedTextPropertyValue_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedTextPropertyValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getDateProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  @DisplayName("Test getDateProperty(String)")
  void testGetDateProperty() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDateProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getDateProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  @DisplayName("Test getDateProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDateProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDateProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getDateProperty(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getDateProperty(String)}
   */
  @Test
  @DisplayName("Test getDateProperty(String); then throw BadFieldValueException")
  void testGetDateProperty_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDateProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValueAsSimple(String)")
  void testGetDatePropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValueAsSimple(String)")
  void testGetDatePropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValueAsSimple(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValueAsSimple(String); then throw BadFieldValueException")
  void testGetDatePropertyValueAsSimple_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDatePropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValue(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValue(String)")
  void testGetDatePropertyValue() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getDatePropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValue(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValue(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetDatePropertyValue_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getDatePropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getDatePropertyValue(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getDatePropertyValue(String)}
   */
  @Test
  @DisplayName("Test getDatePropertyValue(String); then throw BadFieldValueException")
  void testGetDatePropertyValue_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getDatePropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
  void testSetDatePropertyValueAsSimple() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Simple Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
  void testSetDatePropertyValueAsSimple4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
  void testSetDatePropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setDatePropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setDatePropertyValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValueAsSimple(String, Calendar)")
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
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
  void testSetDatePropertyValue() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", new GregorianCalendar(1, 1, 1));

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
  void testSetDatePropertyValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");
    GregorianCalendar date = new GregorianCalendar(1, 1, 1);

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", date);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof DateType);
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertSame(date, ((DateType) getResult).getRawValue());
    assertSame(date, ((DateType) getResult).getValue());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
  void testSetDatePropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setDatePropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setDatePropertyValue(String, Calendar)}.
   * <p>
   * Method under test: {@link XMPSchema#setDatePropertyValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test setDatePropertyValue(String, Calendar)")
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
   * Test {@link XMPSchema#getBooleanProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  @DisplayName("Test getBooleanProperty(String)")
  void testGetBooleanProperty() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  @DisplayName("Test getBooleanProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetBooleanProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanProperty(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getBooleanProperty(String)}
   */
  @Test
  @DisplayName("Test getBooleanProperty(String); then throw BadFieldValueException")
  void testGetBooleanProperty_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValueAsSimple(String)")
  void testGetBooleanPropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValueAsSimple(String)")
  void testGetBooleanPropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValueAsSimple(String); then throw BadFieldValueException")
  void testGetBooleanPropertyValueAsSimple_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValue(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValue(String)")
  void testGetBooleanPropertyValue() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValue(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetBooleanPropertyValue_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getBooleanPropertyValue(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getBooleanPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getBooleanPropertyValue(String); then throw BadFieldValueException")
  void testGetBooleanPropertyValue_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getBooleanPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
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
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
  void testSetBooleanPropertyValueAsSimple4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(((BooleanType) getResult).getValue());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
  void testSetBooleanPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setBooleanPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
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
   * Test {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setBooleanPropertyValueAsSimple(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValueAsSimple(String, Boolean)")
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
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
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
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
  void testSetBooleanPropertyValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", true);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof BooleanType);
    assertEquals("True", ((BooleanType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertTrue(((BooleanType) getResult).getValue());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
  void testSetBooleanPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setBooleanPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
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
   * Test {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}.
   * <p>
   * Method under test: {@link XMPSchema#setBooleanPropertyValue(String, Boolean)}
   */
  @Test
  @DisplayName("Test setBooleanPropertyValue(String, Boolean)")
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
   * Test {@link XMPSchema#getIntegerProperty(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  @DisplayName("Test getIntegerProperty(String)")
  void testGetIntegerProperty() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  @DisplayName("Test getIntegerProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetIntegerProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerProperty(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getIntegerProperty(String)}
   */
  @Test
  @DisplayName("Test getIntegerProperty(String); then throw BadFieldValueException")
  void testGetIntegerProperty_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerProperty("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValueAsSimple(String)")
  void testGetIntegerPropertyValueAsSimple() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValueAsSimple(String)")
  void testGetIntegerPropertyValueAsSimple2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValueAsSimple(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValueAsSimple(String); then throw BadFieldValueException")
  void testGetIntegerPropertyValueAsSimple_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerPropertyValueAsSimple("Simple Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValue(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValue(String)")
  void testGetIntegerPropertyValue() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValue(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValue(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetIntegerPropertyValue_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#getIntegerPropertyValue(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getIntegerPropertyValue(String)}
   */
  @Test
  @DisplayName("Test getIntegerPropertyValue(String); then throw BadFieldValueException")
  void testGetIntegerPropertyValue_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getIntegerPropertyValue("Qualified Name"));
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
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
    assertEquals("Simple Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
  void testSetIntegerPropertyValueAsSimple4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
  void testSetIntegerPropertyValueAsSimple5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setIntegerPropertyValueAsSimple("Simple Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setIntegerPropertyValueAsSimple(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValueAsSimple(String, Integer)")
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
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
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
    assertEquals("Qualified Name", getResult.getPropertyName());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
  void testSetIntegerPropertyValue4() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Name", "Bag Value");

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", 42);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof IntegerType);
    assertEquals("42", ((IntegerType) getResult).getStringValue());
    assertEquals("pdf", getResult.getPrefix());
    assertNull(getResult.getNamespace());
    assertEquals(42, ((IntegerType) getResult).getValue().intValue());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
  void testSetIntegerPropertyValue5() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.setIntegerPropertyValue("Qualified Name", null);

    // Assert that nothing has changed
    assertTrue(adobePDFSchema.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#setIntegerPropertyValue(String, Integer)}.
   * <p>
   * Method under test: {@link XMPSchema#setIntegerPropertyValue(String, Integer)}
   */
  @Test
  @DisplayName("Test setIntegerPropertyValue(String, Integer)")
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
   * Test {@link XMPSchema#removeUnqualifiedBagValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedBagValue(String, String)")
  void testRemoveUnqualifiedBagValue() {
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
   * Test {@link XMPSchema#removeUnqualifiedBagValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedBagValue(String, String)")
  void testRemoveUnqualifiedBagValue2() {
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
   * Test {@link XMPSchema#removeUnqualifiedBagValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedBagValue(String, String)")
  void testRemoveUnqualifiedBagValue3() {
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
   * Test {@link XMPSchema#addBagValueAsSimple(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test addBagValueAsSimple(String, String)")
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
   * Test {@link XMPSchema#addBagValueAsSimple(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test addBagValueAsSimple(String, String)")
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
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addBagValueAsSimple(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test addBagValueAsSimple(String, String)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#addBagValueAsSimple(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValueAsSimple(String, String)}
   */
  @Test
  @DisplayName("Test addBagValueAsSimple(String, String)")
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
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
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
   * Test {@link XMPSchema#addQualifiedBagValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test addQualifiedBagValue(String, String)")
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
   * Test {@link XMPSchema#addQualifiedBagValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test addQualifiedBagValue(String, String)")
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
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addQualifiedBagValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test addQualifiedBagValue(String, String)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#addQualifiedBagValue(String, String)}.
   * <p>
   * Method under test: {@link XMPSchema#addQualifiedBagValue(String, String)}
   */
  @Test
  @DisplayName("Test addQualifiedBagValue(String, String)")
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
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(0);
    assertTrue(getResult2 instanceof TextType);
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
   * Test {@link XMPSchema#getUnqualifiedBagValueList(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedBagValueList(String)")
  void testGetUnqualifiedBagValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedBagValueList("Bag Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedBagValueList(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedBagValueList(String)")
  void testGetUnqualifiedBagValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedBagValueList("Bag Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedBagValueList(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedBagValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedBagValueList(String); then return size is one")
  void testGetUnqualifiedBagValueList_thenReturnSizeIsOne() {
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
   * Test {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)} with
   * {@code String}, {@code String}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceValue(String, String) with 'String', 'String'")
  void testRemoveUnqualifiedSequenceValueWithStringString() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedSequenceValue("Qualified Seq Name", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Test {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)} with
   * {@code String}, {@code String}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceValue(String, String) with 'String', 'String'")
  void testRemoveUnqualifiedSequenceValueWithStringString2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Qualified Seq Name", "Bag Value");

    // Act
    adobePDFSchema.removeUnqualifiedSequenceValue("Qualified Seq Name", "42");

    // Assert that nothing has changed
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals(1, ((ArrayProperty) getResult).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) getResult).getElementsAsString().size());
  }

  /**
   * Test {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)} with
   * {@code String}, {@code String}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceValue(String, String) with 'String', 'String'")
  void testRemoveUnqualifiedSequenceValueWithStringString3() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(XMPMetadata.createXMPMetadata()));
    AgentNameType seqValue = mock(AgentNameType.class);
    when(seqValue.getStringValue()).thenReturn("42");

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValue("Qualified Seq Name", seqValue);

    // Act
    adobePDFSchema.removeUnqualifiedSequenceValue("Qualified Seq Name", "42");

    // Assert
    verify(metadata).getTypeMapping();
    verify(seqValue).getStringValue();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    assertTrue(((ArrayProperty) getResult).getAllProperties().isEmpty());
    assertTrue(((ArrayProperty) getResult).getElementsAsString().isEmpty());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   * with {@code seqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, AbstractField) with 'seqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSeqNameSeqValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Seq Name", seqValue);

    // Assert
    assertTrue(seqValue.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   * with {@code seqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, AbstractField) with 'seqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSeqNameSeqValue2() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    XMPMetadata metadata2 = XMPMetadata.createXMPMetadata();
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(metadata2));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Seq Name", seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(seqValue, allProperties2.get(0));
    assertSame(metadata2, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   * with {@code seqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, AbstractField) with 'seqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSeqNameSeqValue3() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(XMPMetadata.createXMPMetadata()));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue(AdobePDFSchema.KEYWORDS, seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    assertSame(seqValue, allProperties2.get(1));
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   * with {@code seqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, AbstractField) with 'seqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSeqNameSeqValue4() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    XMPMetadata metadata2 = XMPMetadata.createXMPMetadata();
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(metadata2));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Seq Name", seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Seq, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(seqValue, allProperties2.get(0));
    assertSame(metadata2, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, String)} with
   * {@code simpleSeqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, String) with 'simpleSeqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSimpleSeqNameSeqValue() {
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
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, String)} with
   * {@code simpleSeqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, String) with 'simpleSeqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSimpleSeqNameSeqValue2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "li");

    // Act
    adobePDFSchema.addUnqualifiedSequenceValue("Simple Seq Name", "42");

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, String)} with
   * {@code simpleSeqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, String) with 'simpleSeqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSimpleSeqNameSeqValue3() {
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
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof TextType);
    List<String> elementsAsString = ((ArrayProperty) getResult).getElementsAsString();
    assertEquals(2, elementsAsString.size());
    assertEquals("42", elementsAsString.get(1));
    assertEquals("42", ((TextType) getResult2).getStringValue());
    assertEquals("42", ((TextType) getResult2).getRawValue());
    assertEquals("42", ((TextType) getResult2).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceValue(String, String)} with
   * {@code simpleSeqName}, {@code seqValue}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceValue(String, String)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceValue(String, String) with 'simpleSeqName', 'seqValue'")
  void testAddUnqualifiedSequenceValueWithSimpleSeqNameSeqValue4() {
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#getUnqualifiedSequenceValueList(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceValueList(String)")
  void testGetUnqualifiedSequenceValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedSequenceValueList("Seq Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedSequenceValueList(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceValueList(String)")
  void testGetUnqualifiedSequenceValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedSequenceValueList("Seq Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedSequenceValueList(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedSequenceValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceValueList(String); then return size is one")
  void testGetUnqualifiedSequenceValueList_thenReturnSizeIsOne() {
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
   * Test {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceDateValue(String, Calendar)")
  void testRemoveUnqualifiedSequenceDateValue() {
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
   * Test {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceDateValue(String, Calendar)")
  void testRemoveUnqualifiedSequenceDateValue2() {
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
   * Test {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceDateValue(String, Calendar)")
  void testRemoveUnqualifiedSequenceDateValue3() {
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
   * Test {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#removeUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test removeUnqualifiedSequenceDateValue(String, Calendar)")
  void testRemoveUnqualifiedSequenceDateValue4() {
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
   * Test {@link XMPSchema#addBagValue(String, AbstractField)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addBagValue(String, AbstractField)")
  void testAddBagValue() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addBagValue("Qualified Seq Name", seqValue);

    // Assert
    assertTrue(seqValue.getAllProperties().isEmpty());
  }

  /**
   * Test {@link XMPSchema#addBagValue(String, AbstractField)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addBagValue(String, AbstractField)")
  void testAddBagValue2() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    XMPMetadata metadata2 = XMPMetadata.createXMPMetadata();
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(metadata2));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addBagValue("Qualified Seq Name", seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(2, allProperties.size());
    AbstractField getResult = allProperties.get(1);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("Qualified Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(seqValue, allProperties2.get(0));
    assertSame(metadata2, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addBagValue(String, AbstractField)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addBagValue(String, AbstractField)")
  void testAddBagValue3() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(XMPMetadata.createXMPMetadata()));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addBagValue(AdobePDFSchema.KEYWORDS, seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof ArrayProperty);
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    assertSame(seqValue, allProperties2.get(1));
  }

  /**
   * Test {@link XMPSchema#addBagValue(String, AbstractField)}.
   * <p>
   * Method under test: {@link XMPSchema#addBagValue(String, AbstractField)}
   */
  @Test
  @DisplayName("Test addBagValue(String, AbstractField)")
  void testAddBagValue4() {
    // Arrange
    XMPMetadata metadata = mock(XMPMetadata.class);
    XMPMetadata metadata2 = XMPMetadata.createXMPMetadata();
    when(metadata.getTypeMapping()).thenReturn(new TypeMapping(metadata2));

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "42");
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");
    AdobePDFSchema seqValue = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addBagValue("Qualified Seq Name", seqValue);

    // Assert
    verify(metadata, atLeast(1)).getTypeMapping();
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(3, allProperties.size());
    AbstractField getResult = allProperties.get(2);
    assertTrue(getResult instanceof ArrayProperty);
    assertEquals("Qualified Seq Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(1, allProperties2.size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(seqValue, allProperties2.get(0));
    assertSame(metadata2, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test addSequenceDateValueAsSimple(String, Calendar)")
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
   * Test {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test addSequenceDateValueAsSimple(String, Calendar)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test addSequenceDateValueAsSimple(String, Calendar)")
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
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("RDF", getResult2.getPrefix());
    assertEquals("li", getResult2.getPropertyName());
    assertNull(getResult2.getNamespace());
    assertEquals(2, ((ArrayProperty) getResult).getElementsAsString().size());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addSequenceDateValueAsSimple(String, Calendar)}
   */
  @Test
  @DisplayName("Test addSequenceDateValueAsSimple(String, Calendar)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceDateValue(String, Calendar)")
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
   * Test {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceDateValue(String, Calendar)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceDateValue(String, Calendar)")
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
    List<AbstractField> allProperties2 = ((ArrayProperty) getResult).getAllProperties();
    assertEquals(2, allProperties2.size());
    AbstractField getResult2 = allProperties2.get(1);
    assertTrue(getResult2 instanceof DateType);
    assertEquals("RDF", getResult2.getPrefix());
    assertEquals("li", getResult2.getPropertyName());
    assertNull(getResult2.getNamespace());
    assertEquals(2, ((ArrayProperty) getResult).getElementsAsString().size());
    assertTrue(getResult2.getAllAttributes().isEmpty());
    assertSame(date, ((DateType) getResult2).getRawValue());
    assertSame(date, ((DateType) getResult2).getValue());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#addUnqualifiedSequenceDateValue(String, Calendar)}
   */
  @Test
  @DisplayName("Test addUnqualifiedSequenceDateValue(String, Calendar)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceDateValueList(String)")
  void testGetUnqualifiedSequenceDateValueList() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedSequenceDateValueList("Seq Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceDateValueList(String)")
  void testGetUnqualifiedSequenceDateValueList2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedSequenceDateValueList("Seq Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceDateValueList(String); then return Empty")
  void testGetUnqualifiedSequenceDateValueList_thenReturnEmpty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Seq Name", "Bag Value");

    // Act and Assert
    assertTrue(adobePDFSchema.getUnqualifiedSequenceDateValueList("Seq Name").isEmpty());
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedSequenceDateValueList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedSequenceDateValueList(String); then return size is one")
  void testGetUnqualifiedSequenceDateValueList_thenReturnSizeIsOne() {
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
   * Test {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}
   */
  @Test
  @DisplayName("Test reorganizeAltOrder(ComplexPropertyContainer)")
  void testReorganizeAltOrder() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getAttribute(Mockito.<String>any())).thenReturn(new Attribute("Ns URI", "Local Name", "42"));

    ArrayList<AbstractField> abstractFieldList = new ArrayList<>();
    abstractFieldList.add(agentNameType);
    ComplexPropertyContainer alt = mock(ComplexPropertyContainer.class);
    when(alt.getAllProperties()).thenReturn(abstractFieldList);

    // Act
    adobePDFSchema.reorganizeAltOrder(alt);

    // Assert that nothing has changed
    verify(agentNameType).getAttribute(eq("lang"));
    verify(alt).getAllProperties();
  }

  /**
   * Test {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}
   */
  @Test
  @DisplayName("Test reorganizeAltOrder(ComplexPropertyContainer)")
  void testReorganizeAltOrder2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    AgentNameType agentNameType = mock(AgentNameType.class);
    when(agentNameType.getAttribute(Mockito.<String>any()))
        .thenReturn(new Attribute("Ns URI", "Local Name", "x-default"));

    ArrayList<AbstractField> abstractFieldList = new ArrayList<>();
    abstractFieldList.add(agentNameType);
    ComplexPropertyContainer alt = mock(ComplexPropertyContainer.class);
    when(alt.getAllProperties()).thenReturn(abstractFieldList);

    // Act
    adobePDFSchema.reorganizeAltOrder(alt);

    // Assert that nothing has changed
    verify(agentNameType).getAttribute(eq("lang"));
    verify(alt).getAllProperties();
  }

  /**
   * Test {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link ComplexPropertyContainer#getAllProperties()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#reorganizeAltOrder(ComplexPropertyContainer)}
   */
  @Test
  @DisplayName("Test reorganizeAltOrder(ComplexPropertyContainer); given ArrayList(); then calls getAllProperties()")
  void testReorganizeAltOrder_givenArrayList_thenCallsGetAllProperties() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    ComplexPropertyContainer alt = mock(ComplexPropertyContainer.class);
    when(alt.getAllProperties()).thenReturn(new ArrayList<>());

    // Act
    adobePDFSchema.reorganizeAltOrder(alt);

    // Assert that nothing has changed
    verify(alt).getAllProperties();
  }

  /**
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
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
    assertEquals("Name", getResult.getPropertyName());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("en", allAttributes.get(0).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
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
    AbstractField getResult = allProperties.get(1);
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
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
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
    AbstractField getResult = allProperties.get(2);
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
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
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
    assertEquals("Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("x-default", allAttributes.get(0).getValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
  void testSetUnqualifiedLanguagePropertyValue5() {
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
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String)")
  void testSetUnqualifiedLanguagePropertyValue6() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema
        .addProperty(new ArrayProperty(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", Cardinality.Simple));

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
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult2.getNamespace());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    Attribute getResult3 = allAttributes.get(0);
    assertEquals("http://www.w3.org/XML/1998/namespace", getResult3.getNamespace());
    assertEquals("lang", getResult3.getName());
    assertEquals("li", getResult2.getPropertyName());
    assertEquals("pdf", getResult2.getPrefix());
    assertSame(metadata, getResult2.getMetadata());
  }

  /**
   * Test
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#setUnqualifiedLanguagePropertyValue(String, String, String)}
   */
  @Test
  @DisplayName("Test setUnqualifiedLanguagePropertyValue(String, String, String); when empty string")
  void testSetUnqualifiedLanguagePropertyValue_whenEmptyString() {
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
    assertEquals("Name", getResult.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("pdf", getResult.getPrefix());
    List<Attribute> allAttributes = getResult2.getAllAttributes();
    assertEquals(1, allAttributes.size());
    assertEquals("x-default", allAttributes.get(0).getValue());
    assertEquals(Cardinality.Alt, ((ArrayProperty) getResult).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) getResult).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, getResult.getMetadata());
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyValue(String, String)")
  void testGetUnqualifiedLanguagePropertyValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyValue(String, String)")
  void testGetUnqualifiedLanguagePropertyValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyValue(String, String)")
  void testGetUnqualifiedLanguagePropertyValue3() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Name", "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyValue(String, String); then throw BadFieldValueException")
  void testGetUnqualifiedLanguagePropertyValue_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedLanguagePropertyValue("Name", "en"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyValue(String, String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyValue(String, String); when 'null'")
  void testGetUnqualifiedLanguagePropertyValue_whenNull() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyValue("Name", null));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyLanguagesValue(String)")
  void testGetUnqualifiedLanguagePropertyLanguagesValue() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull(
        (new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}.
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyLanguagesValue(String)")
  void testGetUnqualifiedLanguagePropertyLanguagesValue2() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyLanguagesValue(String); then return size is one")
  void testGetUnqualifiedLanguagePropertyLanguagesValue_thenReturnSizeIsOne() throws BadFieldValueException {
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
   * Test {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XMPSchema#getUnqualifiedLanguagePropertyLanguagesValue(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedLanguagePropertyLanguagesValue(String); then throw BadFieldValueException")
  void testGetUnqualifiedLanguagePropertyLanguagesValue_thenThrowBadFieldValueException()
      throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class,
        () -> adobePDFSchema.getUnqualifiedLanguagePropertyLanguagesValue("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedArrayList(String)}.
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedArrayList(String)")
  void testGetUnqualifiedArrayList() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple(AdobePDFSchema.KEYWORDS, "Bag Value");

    // Act and Assert
    assertNull(adobePDFSchema.getUnqualifiedArrayList("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedArrayList(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is
   * createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedArrayList(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  void testGetUnqualifiedArrayList_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() throws BadFieldValueException {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getUnqualifiedArrayList("Name"));
  }

  /**
   * Test {@link XMPSchema#getUnqualifiedArrayList(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedArrayList(String); then return size is one")
  void testGetUnqualifiedArrayList_thenReturnSizeIsOne() throws BadFieldValueException {
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
   * Test {@link XMPSchema#getUnqualifiedArrayList(String)}.
   * <ul>
   *   <li>Then throw {@link BadFieldValueException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMPSchema#getUnqualifiedArrayList(String)}
   */
  @Test
  @DisplayName("Test getUnqualifiedArrayList(String); then throw BadFieldValueException")
  void testGetUnqualifiedArrayList_thenThrowBadFieldValueException() throws BadFieldValueException {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addProperty(new AgentNameType(XMPMetadata.createXMPMetadata(), "Name", "Name", "Name", "Value"));

    // Act and Assert
    assertThrows(BadFieldValueException.class, () -> adobePDFSchema.getUnqualifiedArrayList("Name"));
  }
}
