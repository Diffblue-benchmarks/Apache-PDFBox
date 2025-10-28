package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class IntegerTypeDiffblueTest {
  /**
   * Method under test: {@link IntegerType#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(42,
        (new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42)).getValue()
            .intValue());
  }

  /**
   * Method under test: {@link IntegerType#getStringValue()}
   */
  @Test
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new IntegerType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42))
            .getStringValue());
  }

  /**
   * Method under test:
   * {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewIntegerType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualIntegerType = new IntegerType(metadata, "Namespace URI", "Prefix", "Property Name", 42);

    // Assert
    assertEquals("42", actualIntegerType.getStringValue());
    assertEquals("Namespace URI", actualIntegerType.getNamespace());
    assertEquals("Prefix", actualIntegerType.getPrefix());
    assertEquals("Property Name", actualIntegerType.getPropertyName());
    assertEquals(42, actualIntegerType.getValue().intValue());
    assertTrue(actualIntegerType.getAllAttributes().isEmpty());
    assertSame(metadata, actualIntegerType.getMetadata());
  }

  /**
   * Method under test:
   * {@link IntegerType#IntegerType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewIntegerType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    IntegerType actualIntegerType = new IntegerType(metadata, "Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualIntegerType.getStringValue());
    assertEquals("42", actualIntegerType.getRawValue());
    assertEquals("Namespace URI", actualIntegerType.getNamespace());
    assertEquals("Prefix", actualIntegerType.getPrefix());
    assertEquals("Property Name", actualIntegerType.getPropertyName());
    assertEquals(42, actualIntegerType.getValue().intValue());
    assertTrue(actualIntegerType.getAllAttributes().isEmpty());
    assertSame(metadata, actualIntegerType.getMetadata());
  }
}
