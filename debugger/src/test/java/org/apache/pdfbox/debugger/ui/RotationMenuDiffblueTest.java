package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RotationMenuDiffblueTest {
  /**
   * Method under test: {@link RotationMenu#setRotationSelection(String)}
   */
  @Test
  void testSetRotationSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RotationMenu.getInstance().setRotationSelection("Selection"));
  }

  /**
   * Method under test: {@link RotationMenu#isRotationMenu(String)}
   */
  @Test
  void testIsRotationMenu() {
    // Arrange, Act and Assert
    assertFalse(RotationMenu.isRotationMenu("Action Command"));
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_0_DEGREES));
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_90_DEGREES));
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_180_DEGREES));
    assertTrue(RotationMenu.isRotationMenu(RotationMenu.ROTATE_270_DEGREES));
  }

  /**
   * Method under test: {@link RotationMenu#getRotationDegrees(String)}
   */
  @Test
  void testGetRotationDegrees() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RotationMenu.getRotationDegrees("Action Command"));
    assertEquals(0, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_0_DEGREES));
    assertEquals(90, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_90_DEGREES));
    assertEquals(180, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_180_DEGREES));
    assertEquals(270, RotationMenu.getRotationDegrees(RotationMenu.ROTATE_270_DEGREES));
  }
}
