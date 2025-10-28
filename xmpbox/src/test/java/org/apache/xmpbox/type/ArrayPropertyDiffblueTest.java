package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class ArrayPropertyDiffblueTest {
  /**
   * Method under test: {@link ArrayProperty#getElementsAsString()}
   */
  @Test
  void testGetElementsAsString() {
    // Arrange, Act and Assert
    assertTrue(
        (new ArrayProperty(XMPMetadata.createXMPMetadata(), "Namespace", "Prefix", "Property Name", Cardinality.Simple))
            .getElementsAsString()
            .isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ArrayProperty#getArrayType()}
   *   <li>{@link ArrayProperty#getNamespace()}
   *   <li>{@link ArrayProperty#getPrefix()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ArrayProperty arrayProperty = new ArrayProperty(XMPMetadata.createXMPMetadata(), "Namespace", "Prefix",
        "Property Name", Cardinality.Simple);

    // Act
    Cardinality actualArrayType = arrayProperty.getArrayType();
    String actualNamespace = arrayProperty.getNamespace();

    // Assert
    assertEquals("Namespace", actualNamespace);
    assertEquals("Prefix", arrayProperty.getPrefix());
    assertEquals(Cardinality.Simple, actualArrayType);
  }

  /**
   * Method under test:
   * {@link ArrayProperty#ArrayProperty(XMPMetadata, String, String, String, Cardinality)}
   */
  @Test
  void testNewArrayProperty() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    ArrayProperty actualArrayProperty = new ArrayProperty(metadata, "Namespace", "Prefix", "Property Name",
        Cardinality.Simple);

    // Assert
    assertEquals("Namespace", actualArrayProperty.getNamespace());
    assertEquals("Prefix", actualArrayProperty.getPrefix());
    assertEquals("Property Name", actualArrayProperty.getPropertyName());
    assertEquals(Cardinality.Simple, actualArrayProperty.getArrayType());
    List<AbstractField> allProperties = actualArrayProperty.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualArrayProperty.getAllAttributes().isEmpty());
    assertTrue(actualArrayProperty.getElementsAsString().isEmpty());
    assertTrue(actualArrayProperty.getAllNamespacesWithPrefix().isEmpty());
    assertSame(allProperties, actualArrayProperty.getContainer().getAllProperties());
    assertSame(metadata, actualArrayProperty.getMetadata());
  }
}
