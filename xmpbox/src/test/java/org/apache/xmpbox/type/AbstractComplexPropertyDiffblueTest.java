package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.Test;

class AbstractComplexPropertyDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractComplexProperty#addNamespace(String, String)}
   */
  @Test
  void testAddNamespace() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addNamespace("Namespace", "Prefix");

    // Assert
    Map<String, String> allNamespacesWithPrefix = adobePDFSchema.getAllNamespacesWithPrefix();
    assertEquals(2, allNamespacesWithPrefix.size());
    assertEquals("Prefix", allNamespacesWithPrefix.get("Namespace"));
    assertTrue(allNamespacesWithPrefix.containsKey("http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getNamespacePrefix(String)}
   */
  @Test
  void testGetNamespacePrefix() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getNamespacePrefix("Namespace"));
  }

  /**
   * Method under test:
   * {@link AbstractComplexProperty#getAllNamespacesWithPrefix()}
   */
  @Test
  void testGetAllNamespacesWithPrefix() {
    // Arrange and Act
    Map<String, String> actualAllNamespacesWithPrefix = (new AdobePDFSchema(XMPMetadata.createXMPMetadata()))
        .getAllNamespacesWithPrefix();

    // Assert
    assertEquals(1, actualAllNamespacesWithPrefix.size());
    assertEquals("pdf", actualAllNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#addProperty(AbstractField)}
   */
  @Test
  void testAddProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(mock(XMPMetadata.class));
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    adobePDFSchema.addProperty(obj);

    // Assert
    List<AbstractField> allProperties = adobePDFSchema.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(obj, allProperties.get(0));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getContainer()}
   */
  @Test
  void testGetContainer() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getContainer().getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getAllProperties()}
   */
  @Test
  void testGetAllProperties() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAllProperties().isEmpty());
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  void testGetProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProperty("Field Name"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  void testGetProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProperty("Field Name"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  void testGetProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    AbstractField actualProperty = adobePDFSchema.getProperty("Field Name");

    // Assert
    assertTrue(actualProperty instanceof ArrayProperty);
    List<AbstractField> allProperties = ((ArrayProperty) actualProperty).getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Field Name", actualProperty.getPropertyName());
    List<String> elementsAsString = ((ArrayProperty) actualProperty).getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Simple Name", elementsAsString.get(0));
    assertEquals("Simple Name", ((TextType) getResult).getStringValue());
    assertEquals("Simple Name", ((TextType) getResult).getRawValue());
    assertEquals("Simple Name", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", actualProperty.getPrefix());
    assertEquals(Cardinality.Bag, ((ArrayProperty) actualProperty).getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualProperty.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) actualProperty).getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, ((ArrayProperty) actualProperty).getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualProperty.getMetadata());
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  void testGetArrayProperty() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getArrayProperty("Field Name"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  void testGetArrayProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getArrayProperty("Field Name"));
  }

  /**
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  void testGetArrayProperty3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    ArrayProperty actualArrayProperty = adobePDFSchema.getArrayProperty("Field Name");

    // Assert
    List<AbstractField> allProperties = actualArrayProperty.getAllProperties();
    assertEquals(1, allProperties.size());
    AbstractField getResult = allProperties.get(0);
    assertTrue(getResult instanceof TextType);
    assertEquals("Field Name", actualArrayProperty.getPropertyName());
    List<String> elementsAsString = actualArrayProperty.getElementsAsString();
    assertEquals(1, elementsAsString.size());
    assertEquals("Simple Name", elementsAsString.get(0));
    assertEquals("Simple Name", ((TextType) getResult).getStringValue());
    assertEquals("Simple Name", ((TextType) getResult).getRawValue());
    assertEquals("Simple Name", ((TextType) getResult).getValue());
    assertEquals("http://ns.adobe.com/pdf/1.3/", getResult.getNamespace());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualArrayProperty.getNamespace());
    assertEquals("li", getResult.getPropertyName());
    assertEquals("pdf", getResult.getPrefix());
    assertEquals("pdf", actualArrayProperty.getPrefix());
    assertEquals(Cardinality.Bag, actualArrayProperty.getArrayType());
    assertTrue(getResult.getAllAttributes().isEmpty());
    assertTrue(actualArrayProperty.getAllAttributes().isEmpty());
    assertTrue(actualArrayProperty.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualArrayProperty.getContainer().getAllProperties());
    assertSame(metadata, getResult.getMetadata());
    assertSame(metadata, actualArrayProperty.getMetadata());
  }

  /**
   * Method under test:
   * {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(adobePDFSchema.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Method under test:
   * {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(adobePDFSchema.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Method under test:
   * {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty3() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Local Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(adobePDFSchema.getFirstEquivalentProperty("Local Name", type));
  }
}
