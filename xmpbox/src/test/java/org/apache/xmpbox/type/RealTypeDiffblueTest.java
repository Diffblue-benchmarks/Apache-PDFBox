package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RealTypeDiffblueTest {
  /**
   * Test {@link RealType#RealType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return RawValue is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new RealType(XMPMetadata, String, String, String, Object); when '42'; then return RawValue is '42'")
  void testNewRealType_when42_thenReturnRawValueIs42() {
    // Arrange and Act
    RealType actualRealType = new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        "42");

    // Assert
    assertEquals("42", actualRealType.getRawValue());
    assertEquals("42.0", actualRealType.getStringValue());
    assertEquals(42.0f, actualRealType.getValue().floatValue());
  }

  /**
   * Test {@link RealType#RealType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new RealType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  void testNewRealType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));

  }

  /**
   * Test {@link RealType#RealType(XMPMetadata, String, String, String, Object)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return StringValue is {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RealType#RealType(XMPMetadata, String, String, String, Object)}
   */
  @Test
  @DisplayName("Test new RealType(XMPMetadata, String, String, String, Object); when ten; then return StringValue is '10.0'")
  void testNewRealType_whenTen_thenReturnStringValueIs100() {
    // Arrange and Act
    RealType actualRealType = new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name",
        10.0f);

    // Assert
    assertEquals("10.0", actualRealType.getStringValue());
    assertEquals(10.0f, actualRealType.getValue().floatValue());
    assertEquals(10.0f, ((Float) actualRealType.getRawValue()).floatValue());
  }

  /**
   * Test {@link RealType#getValue()}.
   * <ul>
   *   <li>Then return floatValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link RealType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return floatValue is forty-two")
  void testGetValue_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f,
        (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42")).getValue()
            .floatValue());
  }

  /**
   * Test {@link RealType#setValue(Object)}.
   * <p>
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
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
   * Test {@link RealType#setValue(Object)}.
   * <p>
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  void testSetValue2() {
    // Arrange
    RealType realType = new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42");

    // Act
    realType.setValue(10.0f);

    // Assert
    assertEquals("10.0", realType.getStringValue());
    assertEquals(10.0f, realType.getValue().floatValue());
  }

  /**
   * Test {@link RealType#setValue(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RealType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when forty-two; then throw IllegalArgumentException")
  void testSetValue_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"))
            .setValue(42));
  }

  /**
   * Test {@link RealType#getStringValue()}.
   * <ul>
   *   <li>Then return {@code 42.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RealType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return '42.0'")
  void testGetStringValue_thenReturn420() {
    // Arrange, Act and Assert
    assertEquals("42.0",
        (new RealType(XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "42"))
            .getStringValue());
  }
}
