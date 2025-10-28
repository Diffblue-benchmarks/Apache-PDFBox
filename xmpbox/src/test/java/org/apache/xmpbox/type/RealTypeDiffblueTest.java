package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.Test;

class RealTypeDiffblueTest {
  /**
   * Method under test: {@link RealType#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertEquals(42.0f,
        (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42")).getValue()
            .floatValue());
  }

  /**
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  void testSetValue() {
    // Arrange
    RealType realType = new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42");

    // Act
    realType.setValue("42");

    // Assert
    assertEquals("42.0", realType.getStringValue());
    assertEquals(42.0f, realType.getValue().floatValue());
  }

  /**
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  void testSetValue2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"))
            .setValue(42));
  }

  /**
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  void testSetValue3() {
    // Arrange
    RealType realType = new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42");

    // Act
    realType.setValue(10.0f);

    // Assert
    assertEquals("10.0", realType.getStringValue());
    assertEquals(10.0f, realType.getValue().floatValue());
  }

  /**
   * Method under test: {@link RealType#getStringValue()}
   */
  @Test
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("42.0",
        (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"))
            .getStringValue());
  }

  /**
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewRealType() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RealType actualRealType = new RealType(metadata, "Namespace URI", "Prefix", "Property Name", "42");

    // Assert
    assertEquals("42", actualRealType.getRawValue());
    assertEquals("42.0", actualRealType.getStringValue());
    assertEquals("Namespace URI", actualRealType.getNamespace());
    assertEquals("Prefix", actualRealType.getPrefix());
    assertEquals("Property Name", actualRealType.getPropertyName());
    assertEquals(42.0f, actualRealType.getValue().floatValue());
    assertTrue(actualRealType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRealType.getMetadata());
  }

  /**
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewRealType2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));

  }

  /**
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  void testNewRealType3() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    RealType actualRealType = new RealType(metadata, "Namespace URI", "Prefix", "Property Name", 10.0f);

    // Assert
    assertEquals("10.0", actualRealType.getStringValue());
    assertEquals("Namespace URI", actualRealType.getNamespace());
    assertEquals("Prefix", actualRealType.getPrefix());
    assertEquals("Property Name", actualRealType.getPropertyName());
    assertEquals(10.0f, actualRealType.getValue().floatValue());
    assertEquals(10.0f, ((Float) actualRealType.getRawValue()).floatValue());
    assertTrue(actualRealType.getAllAttributes().isEmpty());
    assertSame(metadata, actualRealType.getMetadata());
  }
}
