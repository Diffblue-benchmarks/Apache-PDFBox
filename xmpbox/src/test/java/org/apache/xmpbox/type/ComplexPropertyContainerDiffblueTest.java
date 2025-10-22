package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ComplexPropertyContainerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ComplexPropertyContainer}
   *   <li>{@link ComplexPropertyContainer#getAllProperties()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexPropertyContainer.<init>()", "List ComplexPropertyContainer.getAllProperties()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new ComplexPropertyContainer()).getAllProperties().isEmpty());
  }

  /**
   * Test {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField ComplexPropertyContainer.getFirstEquivalentProperty(String, Class)"})
  void testGetFirstEquivalentProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Local Name", "Local Name", "Local Name", "Value"));
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(complexPropertyContainer.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Test {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField ComplexPropertyContainer.getFirstEquivalentProperty(String, Class)"})
  void testGetFirstEquivalentProperty2() {
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
   * Test {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}.
   * <ul>
   *   <li>Given {@link ComplexPropertyContainer} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class); given ComplexPropertyContainer (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField ComplexPropertyContainer.getFirstEquivalentProperty(String, Class)"})
  void testGetFirstEquivalentProperty_givenComplexPropertyContainer_thenReturnNull() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(complexPropertyContainer.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Test {@link ComplexPropertyContainer#addProperty(AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#addProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test addProperty(AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexPropertyContainer.addProperty(AbstractField)"})
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
   * Test {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  @DisplayName("Test getPropertiesByLocalName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ComplexPropertyContainer.getPropertiesByLocalName(String)"})
  void testGetPropertiesByLocalName() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);

    // Act and Assert
    assertNull(complexPropertyContainer.getPropertiesByLocalName("Local Name"));
  }

  /**
   * Test {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}.
   * <ul>
   *   <li>Given {@link ComplexPropertyContainer} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  @DisplayName("Test getPropertiesByLocalName(String); given ComplexPropertyContainer (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ComplexPropertyContainer.getPropertiesByLocalName(String)"})
  void testGetPropertiesByLocalName_givenComplexPropertyContainer_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new ComplexPropertyContainer()).getPropertiesByLocalName("Local Name"));
  }

  /**
   * Test {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#getPropertiesByLocalName(String)}
   */
  @Test
  @DisplayName("Test getPropertiesByLocalName(String); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ComplexPropertyContainer.getPropertiesByLocalName(String)"})
  void testGetPropertiesByLocalName_thenReturnSizeIsOne() {
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
   * Test {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  @DisplayName("Test isSameProperty(AbstractField, AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.isSameProperty(AbstractField, AbstractField)"})
  void testIsSameProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AgentNameType prop1 = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  @DisplayName("Test isSameProperty(AbstractField, AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.isSameProperty(AbstractField, AbstractField)"})
  void testIsSameProperty2() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AgentNameType prop1 = new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "Value");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1,
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value")));
  }

  /**
   * Test {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  @DisplayName("Test isSameProperty(AbstractField, AbstractField); given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.isSameProperty(AbstractField, AbstractField)"})
  void testIsSameProperty_given42() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    prop1.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  @DisplayName("Test isSameProperty(AbstractField, AbstractField); given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.isSameProperty(AbstractField, AbstractField)"})
  void testIsSameProperty_given422() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    AdobePDFSchema prop2 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    prop2.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.isSameProperty(prop1, prop2));
  }

  /**
   * Test {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#isSameProperty(AbstractField, AbstractField)}
   */
  @Test
  @DisplayName("Test isSameProperty(AbstractField, AbstractField); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.isSameProperty(AbstractField, AbstractField)"})
  void testIsSameProperty_thenReturnTrue() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    AdobePDFSchema prop1 = new AdobePDFSchema(XMPMetadata.createXMPMetadata());

    // Act and Assert
    assertTrue(complexPropertyContainer.isSameProperty(prop1, new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty2() {
    // Arrange
    AdobePDFSchema obj = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    obj.setPropertyName("42");

    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(obj);

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty3() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value")));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField); given '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty_given42() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    AdobePDFSchema property = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    property.setPropertyName("42");

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(property));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <ul>
   *   <li>Given {@link ComplexPropertyContainer} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField); given ComplexPropertyContainer (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty_givenComplexPropertyContainer_thenReturnFalse() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    // Act and Assert
    assertFalse(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#containsProperty(AbstractField)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#containsProperty(AbstractField)}
   */
  @Test
  @DisplayName("Test containsProperty(AbstractField); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ComplexPropertyContainer.containsProperty(AbstractField)"})
  void testContainsProperty_thenReturnTrue() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata()));

    // Act and Assert
    assertTrue(complexPropertyContainer.containsProperty(new AdobePDFSchema(XMPMetadata.createXMPMetadata())));
  }

  /**
   * Test {@link ComplexPropertyContainer#removePropertiesByName(String)}.
   * <p>
   * Method under test: {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  @DisplayName("Test removePropertiesByName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexPropertyContainer.removePropertiesByName(String)"})
  void testRemovePropertiesByName() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();
    complexPropertyContainer.addProperty(
        new AgentNameType(XMPMetadata.createXMPMetadata(), "Local Name", "Local Name", "Local Name", "Value"));

    // Act
    complexPropertyContainer.removePropertiesByName("Local Name");

    // Assert
    assertTrue(complexPropertyContainer.getAllProperties().isEmpty());
  }

  /**
   * Test {@link ComplexPropertyContainer#removePropertiesByName(String)}.
   * <ul>
   *   <li>Given {@link ComplexPropertyContainer} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  @DisplayName("Test removePropertiesByName(String); given ComplexPropertyContainer (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexPropertyContainer.removePropertiesByName(String)"})
  void testRemovePropertiesByName_givenComplexPropertyContainer() {
    // Arrange
    ComplexPropertyContainer complexPropertyContainer = new ComplexPropertyContainer();

    // Act
    complexPropertyContainer.removePropertiesByName("Local Name");

    // Assert that nothing has changed
    assertTrue(complexPropertyContainer.getAllProperties().isEmpty());
  }

  /**
   * Test {@link ComplexPropertyContainer#removePropertiesByName(String)}.
   * <ul>
   *   <li>Then {@link ComplexPropertyContainer} (default constructor) AllProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ComplexPropertyContainer#removePropertiesByName(String)}
   */
  @Test
  @DisplayName("Test removePropertiesByName(String); then ComplexPropertyContainer (default constructor) AllProperties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ComplexPropertyContainer.removePropertiesByName(String)"})
  void testRemovePropertiesByName_thenComplexPropertyContainerAllPropertiesSizeIsOne() {
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
}
