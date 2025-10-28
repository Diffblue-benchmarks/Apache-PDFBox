package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class BooleanTypeDiffblueTest {
  /**
   * Method under test: {@link BooleanType#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertFalse((new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
        .getValue());
    assertTrue((new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE"))
        .getValue());
  }

  /**
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  void testSetValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .setValue("Value"));
    assertThrows(IllegalArgumentException.class,
        () -> (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .setValue(42));
  }

  /**
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  void testSetValue2() {
    // Arrange
    BooleanType booleanType = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "FALSE");

    // Act
    booleanType.setValue(true);

    // Assert
    assertTrue(booleanType.getValue());
    assertEquals(BooleanType.TRUE, booleanType.getStringValue());
  }

  /**
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  void testSetValue3() {
    // Arrange
    BooleanType booleanType = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "FALSE");

    // Act
    booleanType.setValue("TRUE");

    // Assert
    assertTrue(booleanType.getValue());
    assertEquals(BooleanType.TRUE, booleanType.getStringValue());
  }

  /**
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  void testSetValue4() {
    // Arrange
    BooleanType booleanType = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "FALSE");

    // Act
    booleanType.setValue("FALSE");

    // Assert
    assertFalse(booleanType.getValue());
    assertEquals(BooleanType.FALSE, booleanType.getStringValue());
  }

  /**
   * Method under test: {@link BooleanType#getStringValue()}
   */
  @Test
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals(BooleanType.FALSE,
        (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .getStringValue());
    assertEquals(BooleanType.TRUE,
        (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE"))
            .getStringValue());
  }

  /**
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewBooleanType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

    assertThrows(IllegalArgumentException.class,
        () -> new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewBooleanType2() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualBooleanType = new BooleanType(metadata, "Namespace URI", "Prefix", "Property Name", true);

    // Assert
    assertEquals("Namespace URI", actualBooleanType.getNamespace());
    assertEquals("Prefix", actualBooleanType.getPrefix());
    assertEquals("Property Name", actualBooleanType.getPropertyName());
    assertTrue(actualBooleanType.getAllAttributes().isEmpty());
    assertTrue(actualBooleanType.getValue());
    assertEquals(BooleanType.TRUE, actualBooleanType.getStringValue());
    assertSame(metadata, actualBooleanType.getMetadata());
  }

  /**
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewBooleanType3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualBooleanType = new BooleanType(metadata, "Namespace URI", "Prefix", "Property Name", "TRUE");

    // Assert
    assertEquals("Namespace URI", actualBooleanType.getNamespace());
    assertEquals("Prefix", actualBooleanType.getPrefix());
    assertEquals("Property Name", actualBooleanType.getPropertyName());
    assertEquals("TRUE", actualBooleanType.getRawValue());
    assertTrue(actualBooleanType.getAllAttributes().isEmpty());
    assertTrue(actualBooleanType.getValue());
    assertEquals(BooleanType.TRUE, actualBooleanType.getStringValue());
    assertSame(metadata, actualBooleanType.getMetadata());
  }

  /**
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewBooleanType4() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualBooleanType = new BooleanType(metadata, "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Assert
    assertEquals("FALSE", actualBooleanType.getRawValue());
    assertEquals("Namespace URI", actualBooleanType.getNamespace());
    assertEquals("Prefix", actualBooleanType.getPrefix());
    assertEquals("Property Name", actualBooleanType.getPropertyName());
    assertFalse(actualBooleanType.getValue());
    assertTrue(actualBooleanType.getAllAttributes().isEmpty());
    assertEquals(BooleanType.FALSE, actualBooleanType.getStringValue());
    assertSame(metadata, actualBooleanType.getMetadata());
  }
}
