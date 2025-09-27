package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.xmpbox.XMPMetadata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BooleanTypeDiffblueTest {
  /**
   * Test {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code FALSE}.
   *   <li>Then return RawValue is {@code FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#BooleanType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new BooleanType(XMPMetadata, String, String, String, Object); when 'FALSE'; then return RawValue is 'FALSE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewBooleanType_whenFalse_thenReturnRawValueIsFalse() {
    // Arrange and Act
    BooleanType actualBooleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Assert
    assertEquals("FALSE", actualBooleanType.getRawValue());
    assertFalse(actualBooleanType.getValue());
    assertEquals(BooleanType.FALSE, actualBooleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#BooleanType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new BooleanType(XMPMetadata, String, String, String, Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewBooleanType_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new BooleanType(
                XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", 42));
  }

  /**
   * Test {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return RawValue.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#BooleanType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new BooleanType(XMPMetadata, String, String, String, Object); when 'true'; then return RawValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewBooleanType_whenTrue_thenReturnRawValue() {
    // Arrange and Act
    BooleanType actualBooleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", true);

    // Assert
    assertTrue(actualBooleanType.getValue());
    assertTrue((Boolean) actualBooleanType.getRawValue());
    assertEquals(BooleanType.TRUE, actualBooleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code TRUE}.
   *   <li>Then return RawValue is {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#BooleanType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new BooleanType(XMPMetadata, String, String, String, Object); when 'TRUE'; then return RawValue is 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewBooleanType_whenTrue_thenReturnRawValueIsTrue() {
    // Arrange and Act
    BooleanType actualBooleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE");

    // Assert
    assertEquals("TRUE", actualBooleanType.getRawValue());
    assertTrue(actualBooleanType.getValue());
    assertEquals(BooleanType.TRUE, actualBooleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#BooleanType(XMPMetadata, String, String, String, Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#BooleanType(XMPMetadata, String, String, String,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new BooleanType(XMPMetadata, String, String, String, Object); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.<init>(XMPMetadata, String, String, String, Object)"})
  void testNewBooleanType_whenValue_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            new BooleanType(
                XMPMetadata.createXMPMetadata(),
                "Namespace URI",
                "Prefix",
                "Property Name",
                "Value"));
  }

  /**
   * Test {@link BooleanType#getValue()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BooleanType.getValue()"})
  void testGetValue_thenReturnFalse() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act and Assert
    assertFalse(booleanType.getValue());
  }

  /**
   * Test {@link BooleanType#getValue()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean BooleanType.getValue()"})
  void testGetValue_thenReturnTrue() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE");

    // Act and Assert
    assertTrue(booleanType.getValue());
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   *
   * <p>Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.setValue(Object)"})
  void testSetValue() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    booleanType.setValue(true);

    // Assert
    assertTrue(booleanType.getValue());
    assertEquals(BooleanType.TRUE, booleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   *
   * <p>Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.setValue(Object)"})
  void testSetValue2() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    booleanType.setValue("FALSE");

    // Assert that nothing has changed
    assertFalse(booleanType.getValue());
    assertEquals(BooleanType.FALSE, booleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when forty-two; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.setValue(Object)"})
  void testSetValue_whenFortyTwo_thenThrowIllegalArgumentException() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> booleanType.setValue(42));
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'TRUE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.setValue(Object)"})
  void testSetValue_whenTrue() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act
    booleanType.setValue("TRUE");

    // Assert
    assertTrue(booleanType.getValue());
    assertEquals(BooleanType.TRUE, booleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#setValue(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#setValue(Object)}
   */
  @Test
  @DisplayName("Test setValue(Object); when 'Value'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BooleanType.setValue(Object)"})
  void testSetValue_whenValue_thenThrowIllegalArgumentException() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> booleanType.setValue("Value"));
  }

  /**
   * Test {@link BooleanType#getStringValue()}.
   *
   * <ul>
   *   <li>Then return {@link BooleanType#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BooleanType.getStringValue()"})
  void testGetStringValue_thenReturnFalse() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "FALSE");

    // Act and Assert
    assertEquals(BooleanType.FALSE, booleanType.getStringValue());
  }

  /**
   * Test {@link BooleanType#getStringValue()}.
   *
   * <ul>
   *   <li>Then return {@link BooleanType#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link BooleanType#getStringValue()}
   */
  @Test
  @DisplayName("Test getStringValue(); then return TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BooleanType.getStringValue()"})
  void testGetStringValue_thenReturnTrue() {
    // Arrange
    BooleanType booleanType =
        new BooleanType(
            XMPMetadata.createXMPMetadata(), "Namespace URI", "Prefix", "Property Name", "TRUE");

    // Act and Assert
    assertEquals(BooleanType.TRUE, booleanType.getStringValue());
  }
}
