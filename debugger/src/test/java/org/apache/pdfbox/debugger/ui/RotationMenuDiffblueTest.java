package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RotationMenuDiffblueTest {
  /**
   * Test {@link RotationMenu#setRotationSelection(String)}.
   * <ul>
   *   <li>When {@code Selection}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#setRotationSelection(String)}
   */
  @Test
  @DisplayName("Test setRotationSelection(String); when 'Selection'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RotationMenu.setRotationSelection(String)"})
  void testSetRotationSelection_whenSelection_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RotationMenu.getInstance().setRotationSelection("Selection"));
  }

  /**
   * Test {@link RotationMenu#isRotationMenu(String)}.
   * <ul>
   *   <li>When {@code Action Command}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  @DisplayName("Test isRotationMenu(String); when 'Action Command'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RotationMenu.isRotationMenu(String)"})
  void testIsRotationMenu_whenActionCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RotationMenu.isRotationMenu("Action Command"));
  }

  /**
   * Test {@link RotationMenu#isRotationMenu(String)}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_0_DEGREES}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  @DisplayName("Test isRotationMenu(String); when ROTATE_0_DEGREES; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RotationMenu.isRotationMenu(String)"})
  void testIsRotationMenu_whenRotate_0_degrees_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_0_DEGREES));
  }

  /**
   * Test {@link RotationMenu#isRotationMenu(String)}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_90_DEGREES}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  @DisplayName("Test isRotationMenu(String); when ROTATE_90_DEGREES; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RotationMenu.isRotationMenu(String)"})
  void testIsRotationMenu_whenRotate_90_degrees_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_90_DEGREES));
  }

  /**
   * Test {@link RotationMenu#isRotationMenu(String)}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_180_DEGREES}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  @DisplayName("Test isRotationMenu(String); when ROTATE_180_DEGREES; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RotationMenu.isRotationMenu(String)"})
  void testIsRotationMenu_whenRotate_180_degrees_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_180_DEGREES));
  }

  /**
   * Test {@link RotationMenu#isRotationMenu(String)}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_270_DEGREES}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  @DisplayName("Test isRotationMenu(String); when ROTATE_270_DEGREES; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RotationMenu.isRotationMenu(String)"})
  void testIsRotationMenu_whenRotate_270_degrees_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_270_DEGREES));
  }

  /**
   * Test {@link RotationMenu#getRotationDegrees(String)} with {@code String}.
   * <ul>
   *   <li>Then return one hundred eighty.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  @DisplayName("Test getRotationDegrees(String) with 'String'; then return one hundred eighty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RotationMenu.getRotationDegrees(String)"})
  void testGetRotationDegreesWithString_thenReturnOneHundredEighty() {
    // Arrange, Act and Assert
    assertEquals(180, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_180_DEGREES));
  }

  /**
   * Test {@link RotationMenu#getRotationDegrees(String)} with {@code String}.
   * <ul>
   *   <li>Then return two hundred seventy.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  @DisplayName("Test getRotationDegrees(String) with 'String'; then return two hundred seventy")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RotationMenu.getRotationDegrees(String)"})
  void testGetRotationDegreesWithString_thenReturnTwoHundredSeventy() {
    // Arrange, Act and Assert
    assertEquals(270, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_270_DEGREES));
  }

  /**
   * Test {@link RotationMenu#getRotationDegrees(String)} with {@code String}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  @DisplayName("Test getRotationDegrees(String) with 'String'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RotationMenu.getRotationDegrees(String)"})
  void testGetRotationDegreesWithString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RotationMenu.getRotationDegrees("Action Command"));
  }

  /**
   * Test {@link RotationMenu#getRotationDegrees(String)} with {@code String}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_0_DEGREES}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  @DisplayName("Test getRotationDegrees(String) with 'String'; when ROTATE_0_DEGREES; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RotationMenu.getRotationDegrees(String)"})
  void testGetRotationDegreesWithString_whenRotate_0_degrees_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_0_DEGREES));
  }

  /**
   * Test {@link RotationMenu#getRotationDegrees(String)} with {@code String}.
   * <ul>
   *   <li>When {@link RotationMenu#ROTATE_90_DEGREES}.</li>
   *   <li>Then return ninety.</li>
   * </ul>
   * <p>
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  @DisplayName("Test getRotationDegrees(String) with 'String'; when ROTATE_90_DEGREES; then return ninety")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RotationMenu.getRotationDegrees(String)"})
  void testGetRotationDegreesWithString_whenRotate_90_degrees_thenReturnNinety() {
    // Arrange, Act and Assert
    assertEquals(90, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_90_DEGREES));
  }
}
