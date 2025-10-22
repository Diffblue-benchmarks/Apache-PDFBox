package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.apache.xmpbox.schema.AdobePDFSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractComplexPropertyDiffblueTest {
  /**
   * Test {@link AbstractComplexProperty#addNamespace(String, String)}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#addNamespace(String, String)}
   */
  @Test
  @DisplayName("Test addNamespace(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractComplexProperty.addNamespace(String, String)"})
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
   * Test {@link AbstractComplexProperty#getNamespacePrefix(String)}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getNamespacePrefix(String)}
   */
  @Test
  @DisplayName("Test getNamespacePrefix(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractComplexProperty.getNamespacePrefix(String)"})
  void testGetNamespacePrefix() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getNamespacePrefix("Namespace"));
  }

  /**
   * Test {@link AbstractComplexProperty#getAllNamespacesWithPrefix()}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getAllNamespacesWithPrefix()}
   */
  @Test
  @DisplayName("Test getAllNamespacesWithPrefix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map AbstractComplexProperty.getAllNamespacesWithPrefix()"})
  void testGetAllNamespacesWithPrefix() {
    // Arrange and Act
    Map<String, String> actualAllNamespacesWithPrefix = (new AdobePDFSchema(XMPMetadata.createXMPMetadata()))
        .getAllNamespacesWithPrefix();

    // Assert
    assertEquals(1, actualAllNamespacesWithPrefix.size());
    assertEquals("pdf", actualAllNamespacesWithPrefix.get("http://ns.adobe.com/pdf/1.3/"));
  }

  /**
   * Test {@link AbstractComplexProperty#getContainer()}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getContainer()}
   */
  @Test
  @DisplayName("Test getContainer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.xmpbox.type.ComplexPropertyContainer AbstractComplexProperty.getContainer()"})
  void testGetContainer() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getContainer().getAllProperties().isEmpty());
  }

  /**
   * Test {@link AbstractComplexProperty#getAllProperties()}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getAllProperties()}
   */
  @Test
  @DisplayName("Test getAllProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List AbstractComplexProperty.getAllProperties()"})
  void testGetAllProperties() {
    // Arrange, Act and Assert
    assertTrue((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getAllProperties().isEmpty());
  }

  /**
   * Test {@link AbstractComplexProperty#getProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getProperty(String)"})
  void testGetProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getProperty("Field Name"));
  }

  /**
   * Test {@link AbstractComplexProperty#getProperty(String)}.
   * <ul>
   *   <li>Then return {@link ArrayProperty}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); then return ArrayProperty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getProperty(String)"})
  void testGetProperty_thenReturnArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    AbstractField actualProperty = adobePDFSchema.getProperty("Field Name");

    // Assert
    assertTrue(actualProperty instanceof ArrayProperty);
    assertEquals("Field Name", actualProperty.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualProperty.getNamespace());
    assertEquals("pdf", actualProperty.getPrefix());
    assertEquals(1, ((ArrayProperty) actualProperty).getAllProperties().size());
    assertEquals(1, ((ArrayProperty) actualProperty).getElementsAsString().size());
    assertEquals(Cardinality.Bag, ((ArrayProperty) actualProperty).getArrayType());
    assertTrue(actualProperty.getAllAttributes().isEmpty());
    assertTrue(((ArrayProperty) actualProperty).getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualProperty.getMetadata());
  }

  /**
   * Test {@link AbstractComplexProperty#getProperty(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getProperty(String)}
   */
  @Test
  @DisplayName("Test getProperty(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getProperty(String)"})
  void testGetProperty_thenReturnNull() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getProperty("Field Name"));
  }

  /**
   * Test {@link AbstractComplexProperty#getArrayProperty(String)}.
   * <ul>
   *   <li>Given {@link AdobePDFSchema#AdobePDFSchema(XMPMetadata)} with metadata is createXMPMetadata.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  @DisplayName("Test getArrayProperty(String); given AdobePDFSchema(XMPMetadata) with metadata is createXMPMetadata")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty AbstractComplexProperty.getArrayProperty(String)"})
  void testGetArrayProperty_givenAdobePDFSchemaWithMetadataIsCreateXMPMetadata() {
    // Arrange, Act and Assert
    assertNull((new AdobePDFSchema(XMPMetadata.createXMPMetadata())).getArrayProperty("Field Name"));
  }

  /**
   * Test {@link AbstractComplexProperty#getArrayProperty(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  @DisplayName("Test getArrayProperty(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty AbstractComplexProperty.getArrayProperty(String)"})
  void testGetArrayProperty_thenReturnNull() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act and Assert
    assertNull(adobePDFSchema.getArrayProperty("Field Name"));
  }

  /**
   * Test {@link AbstractComplexProperty#getArrayProperty(String)}.
   * <ul>
   *   <li>Then return PropertyName is {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractComplexProperty#getArrayProperty(String)}
   */
  @Test
  @DisplayName("Test getArrayProperty(String); then return PropertyName is 'Field Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ArrayProperty AbstractComplexProperty.getArrayProperty(String)"})
  void testGetArrayProperty_thenReturnPropertyNameIsFieldName() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(metadata);
    adobePDFSchema.addBagValueAsSimple("Field Name", "Simple Name");
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");

    // Act
    ArrayProperty actualArrayProperty = adobePDFSchema.getArrayProperty("Field Name");

    // Assert
    assertEquals("Field Name", actualArrayProperty.getPropertyName());
    assertEquals("http://ns.adobe.com/pdf/1.3/", actualArrayProperty.getNamespace());
    assertEquals("pdf", actualArrayProperty.getPrefix());
    assertEquals(1, actualArrayProperty.getAllProperties().size());
    assertEquals(1, actualArrayProperty.getElementsAsString().size());
    assertEquals(Cardinality.Bag, actualArrayProperty.getArrayType());
    assertTrue(actualArrayProperty.getAllAttributes().isEmpty());
    assertTrue(actualArrayProperty.getAllNamespacesWithPrefix().isEmpty());
    assertSame(metadata, actualArrayProperty.getMetadata());
  }

  /**
   * Test {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getFirstEquivalentProperty(String, Class)"})
  void testGetFirstEquivalentProperty() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(adobePDFSchema.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Test {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getFirstEquivalentProperty(String, Class)"})
  void testGetFirstEquivalentProperty2() {
    // Arrange
    AdobePDFSchema adobePDFSchema = new AdobePDFSchema(XMPMetadata.createXMPMetadata());
    adobePDFSchema.addBagValueAsSimple("Simple Name", "42");
    Class<AbstractField> type = AbstractField.class;

    // Act and Assert
    assertNull(adobePDFSchema.getFirstEquivalentProperty("Local Name", type));
  }

  /**
   * Test {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}.
   * <p>
   * Method under test: {@link AbstractComplexProperty#getFirstEquivalentProperty(String, Class)}
   */
  @Test
  @DisplayName("Test getFirstEquivalentProperty(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AbstractField AbstractComplexProperty.getFirstEquivalentProperty(String, Class)"})
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
