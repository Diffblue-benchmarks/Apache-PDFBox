package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooleanTypeDiffblueTest {
  /**
   * Test
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code FALSE}.</li>
   *   <li>Then return RawValue is {@code FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new BooleanType(XMPMetadata, String, String, String, Object); when 'FALSE'; then return RawValue is 'FALSE'")
  void testNewBooleanType_whenFalse_thenReturnRawValueIsFalse() {
    // Arrange and Act
    BooleanType actualBooleanType = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "FALSE");

    // Assert
    assertEquals("FALSE", actualBooleanType.getRawValue());
    assertFalse(actualBooleanType.getValue());
    assertEquals(BooleanType.FALSE, actualBooleanType.getStringValue());
  }

  /**
   * Test
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new BooleanType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  void testNewBooleanType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));

  }

  /**
   * Test
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Namespace is {@code Namespace URI}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new BooleanType(XMPMetadata, String, String, String, Object); when 'true'; then return Namespace is 'Namespace URI'")
  void testNewBooleanType_whenTrue_thenReturnNamespaceIsNamespaceUri() {
    // Arrange
    XMPMetadata metadata = XMPMetadata.createXMPMetadata();

    // Act
    BooleanType actualBooleanType = new BooleanType(metadata, "Namespace URI", "Prefix", "Property Name", true);

    // Assert
    assertEquals("Namespace URI", actualBooleanType.getNamespace());
    assertEquals("Prefix", actualBooleanType.getPrefix());
    assertEquals("Property Name", actualBooleanType.getPropertyName());
    assertTrue(actualBooleanType.getAllAttributes().isEmpty());
    assertSame(metadata, actualBooleanType.getMetadata());
  }

  /**
   * Test
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code TRUE}.</li>
   *   <li>Then return RawValue is {@code TRUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new BooleanType(XMPMetadata, String, String, String, Object); when 'TRUE'; then return RawValue is 'TRUE'")
  void testNewBooleanType_whenTrue_thenReturnRawValueIsTrue() {
    // Arrange and Act
    BooleanType actualBooleanType = new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix",
        "Property Name", "TRUE");

    // Assert
    assertEquals("TRUE", actualBooleanType.getRawValue());
    assertTrue(actualBooleanType.getValue());
    assertEquals(BooleanType.TRUE, actualBooleanType.getStringValue());
  }

  /**
   * Test
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new BooleanType(XMPMetadata, String, String, String, Object); when 'Value'; then throw IllegalArgumentException")
  void testNewBooleanType_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "Value"));

  }

  /**
   * Test {@link BooleanType#getValue()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'false'")
  void testGetValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
        .getValue());
  }

  /**
   * Test {@link BooleanType#getValue()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'true'")
  void testGetValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE"))
        .getValue());
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   * <p>
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  void testSetValue() {
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
   * Test {@link BooleanType#setValue(Object)}.
   * <p>
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  void testSetValue2() {
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
   * Test {@link BooleanType#setValue(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when forty-two; then throw IllegalArgumentException")
  void testSetValue_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .setValue(42));
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   * <ul>
   *   <li>When {@code TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'TRUE'")
  void testSetValue_whenTrue() {
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
   * Test {@link BooleanType#setValue(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'Value'; then throw IllegalArgumentException")
  void testSetValue_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .setValue("Value"));
  }

  /**
   * Test {@link BooleanType#getStringValue()}.
   * <ul>
   *   <li>Then return {@link BooleanType#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return FALSE")
  void testGetStringValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertEquals(BooleanType.FALSE,
        (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE"))
            .getStringValue());
  }

  /**
   * Test {@link BooleanType#getStringValue()}.
   * <ul>
   *   <li>Then return {@link BooleanType#TRUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BooleanType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return TRUE")
  void testGetStringValue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertEquals(BooleanType.TRUE,
        (new BooleanType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE"))
            .getStringValue());
  }
}
