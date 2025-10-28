package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import java.util.Map;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class DefinedStructuredTypeDiffblueTest {
  /**
   * Method under test:
   * {@link DefinedStructuredType#addProperty(String, PropertyType)}
   */
  @Test
  void testAddProperty() {
    // Arrange
    DefinedStructuredType definedStructuredType = new DefinedStructuredType(XMPMetadata.createXMPMetadata(),
        "Namespace URI", "Field Prefix", "Property Name");
    PropertyType type = mock(PropertyType.class);

    // Act
    definedStructuredType.addProperty("Name", type);

    // Assert
    Map<String, PropertyType> definedProperties = definedStructuredType.getDefinedProperties();
    assertEquals(1, definedProperties.size());
    assertSame(type, definedProperties.get("Name"));
  }

  /**
   * Method under test:
   * {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String, String, String)}
   */
  @Test
  void testNewDefinedStructuredType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DefinedStructuredType actualDefinedStructuredType = new DefinedStructuredType(metadata, "Namespace URI",
        "Field Prefix", "Property Name");

    // Assert
    assertEquals("Field Prefix", actualDefinedStructuredType.getPreferedPrefix());
    assertEquals("Field Prefix", actualDefinedStructuredType.getPrefix());
    assertEquals("Namespace URI", actualDefinedStructuredType.getNamespace());
    assertEquals("Property Name", actualDefinedStructuredType.getPropertyName());
    List<AbstractField> allProperties = actualDefinedStructuredType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDefinedStructuredType.getAllAttributes().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(actualDefinedStructuredType.getDefinedProperties().isEmpty());
    assertSame(allProperties, actualDefinedStructuredType.getContainer().getAllProperties());
    assertSame(metadata, actualDefinedStructuredType.getMetadata());
  }

  /**
   * Method under test:
   * {@link DefinedStructuredType#DefinedStructuredType(XMPMetadata, String, String, String)}
   */
  @Test
  void testNewDefinedStructuredType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    DefinedStructuredType actualDefinedStructuredType = new DefinedStructuredType(metadata, "Namespace URI", null,
        "Property Name");

    // Assert
    assertEquals("Namespace URI", actualDefinedStructuredType.getNamespace());
    assertEquals("Property Name", actualDefinedStructuredType.getPropertyName());
    assertNull(actualDefinedStructuredType.getPreferedPrefix());
    assertNull(actualDefinedStructuredType.getPrefix());
    List<AbstractField> allProperties = actualDefinedStructuredType.getAllProperties();
    assertTrue(allProperties.isEmpty());
    assertTrue(actualDefinedStructuredType.getAllAttributes().isEmpty());
    assertTrue(actualDefinedStructuredType.getAllNamespacesWithPrefix().isEmpty());
    assertTrue(actualDefinedStructuredType.getDefinedProperties().isEmpty());
    assertSame(allProperties, actualDefinedStructuredType.getContainer().getAllProperties());
    assertSame(metadata, actualDefinedStructuredType.getMetadata());
  }
}
