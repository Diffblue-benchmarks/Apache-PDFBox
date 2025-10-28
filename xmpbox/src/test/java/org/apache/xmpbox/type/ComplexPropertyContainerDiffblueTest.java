package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.Test;

class ComplexPropertyContainerDiffblueTest {
  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(complexPropertyContainer.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Local Name", "Local Name", "Local Name", "Value"));
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(complexPropertyContainer.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  void testGetFirstEquivalentProperty3() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(complexPropertyContainer.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#addProperty(AbstractField)}
   */
  @Test
  void testAddProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act
    complexPropertyContainer.addProperty(obj);

    // Assert
    List<AbstractField> allProperties = complexPropertyContainer.getAllProperties();
    assertEquals(1, allProperties.size());
    assertSame(obj, allProperties.get(0));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  void testGetPropertiesByLocalName() {
    // Arrange, Act and Assert
    assertNull((new ComplexPropertyContainer()).getPropertiesByLocalName("Local Name"));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  void testGetPropertiesByLocalName2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AgentNameType obj = new AgentNameType(XMPMetadata.createXMPMetadata(), "Local Name", "Local Name", "Local Name",
        "Value");

    complexPropertyContainer.addProperty(obj);

    // Act
    List<AbstractField> actualPropertiesByLocalName = complexPropertyContainer.getPropertiesByLocalName("Local Name");

    // Assert
    assertEquals(1, actualPropertiesByLocalName.size());
    assertSame(obj, actualPropertiesByLocalName.get(0));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  void testGetPropertiesByLocalName3() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);

    // Act and Assert
    assertNull(complexPropertyContainer.getPropertiesByLocalName("Local Name"));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  void testIsSameProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertTrue(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  void testIsSameProperty2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AgentNameType prop1 = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  void testIsSameProperty3() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    prop1.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  void testIsSameProperty4() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AgentNameType prop1 = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1,
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value")));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  void testIsSameProperty5() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    AdobePDFSchema prop2 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    prop2.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, prop2));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertTrue(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty3() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty4() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty5() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value")));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  void testContainsProperty6() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    AdobePDFSchema property = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    property.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(property));
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  void testRemovePropertiesByName() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    // Act
    complexPropertyContainer.removePropertiesByName("Local Name");

    // Assert that nothing has changed
    assertTrue(complexPropertyContainer.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  void testRemovePropertiesByName2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Local Name", "Local Name", "Local Name", "Value"));

    // Act
    complexPropertyContainer.removePropertiesByName("Local Name");

    // Assert that nothing has changed
    assertTrue(complexPropertyContainer.getAllProperties().isEmpty());
  }

  /**
   * Method under test:
   * {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  void testRemovePropertiesByName3() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);

    // Act
    complexPropertyContainer.removePropertiesByName("Local Name");

    // Assert that nothing has changed
    assertEquals(1, complexPropertyContainer.getAllProperties().size());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ComplexPropertyContainer}
   *   <li>{@link ComplexPropertyContainer#getAllProperties()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new ComplexPropertyContainer()).getAllProperties().isEmpty());
  }
}
