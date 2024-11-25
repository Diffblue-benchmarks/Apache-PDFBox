package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.rendering.ImageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImageTypeMenuDiffblueTest {
  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   * <ul>
   *   <li>When {@code Selection}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName("Test setImageTypeSelection(String); when 'Selection'; then throw IllegalArgumentException")
  void testSetImageTypeSelection_whenSelection_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageTypeMenu.getInstance().setImageTypeSelection("Selection"));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   * <ul>
   *   <li>When {@code Action Command}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when 'Action Command'; then return 'false'")
  void testIsImageTypeMenu_whenActionCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImageTypeMenu.isImageTypeMenu("Action Command"));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_ARGB}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_ARGB; then return 'true'")
  void testIsImageTypeMenu_whenImagetype_argb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_ARGB));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_BITONAL}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_BITONAL; then return 'true'")
  void testIsImageTypeMenu_whenImagetype_bitonal_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_GRAY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_GRAY; then return 'true'")
  void testIsImageTypeMenu_whenImagetype_gray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_GRAY));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_RGB}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_RGB; then return 'true'")
  void testIsImageTypeMenu_whenImagetype_rgb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_RGB));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   * <ul>
   *   <li>When {@code Action Command}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when 'Action Command'; then throw IllegalArgumentException")
  void testGetImageTypeWithString_whenActionCommand_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ImageTypeMenu.getImageType("Action Command"));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_ARGB}.</li>
   *   <li>Then return {@code ARGB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_ARGB; then return 'ARGB'")
  void testGetImageTypeWithString_whenImagetype_argb_thenReturnArgb() {
    // Arrange, Act and Assert
    assertEquals(ImageType.ARGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_ARGB));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_BITONAL}.</li>
   *   <li>Then return {@code BINARY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_BITONAL; then return 'BINARY'")
  void testGetImageTypeWithString_whenImagetype_bitonal_thenReturnBinary() {
    // Arrange, Act and Assert
    assertEquals(ImageType.BINARY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_GRAY}.</li>
   *   <li>Then return {@code GRAY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_GRAY; then return 'GRAY'")
  void testGetImageTypeWithString_whenImagetype_gray_thenReturnGray() {
    // Arrange, Act and Assert
    assertEquals(ImageType.GRAY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_GRAY));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_RGB}.</li>
   *   <li>Then return {@code RGB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_RGB; then return 'RGB'")
  void testGetImageTypeWithString_whenImagetype_rgb_thenReturnRgb() {
    // Arrange, Act and Assert
    assertEquals(ImageType.RGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_RGB));
  }
}
