package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.rendering.ImageType;
import org.junit.jupiter.api.Test;

class ImageTypeMenuDiffblueTest {
  /**
   * Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  void testSetImageTypeSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageTypeMenu.getInstance().setImageTypeSelection("Selection"));
  }

  /**
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  void testIsImageTypeMenu() {
    // Arrange, Act and Assert
    assertFalse(ImageTypeMenu.isImageTypeMenu("Action Command"));
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_RGB));
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_ARGB));
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_GRAY));
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  void testGetImageType() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageTypeMenu.getImageType("Action Command"));
    assertEquals(ImageType.RGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_RGB));
    assertEquals(ImageType.ARGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_ARGB));
    assertEquals(ImageType.GRAY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_GRAY));
    assertEquals(ImageType.BINARY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_BITONAL));
  }
}
