package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.swing.JRadioButtonMenuItem;
import org.apache.pdfbox.rendering.ImageType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImageTypeMenuDiffblueTest {
  @InjectMocks private ImageTypeMenu imageTypeMenu;

  @Mock private JRadioButtonMenuItem jRadioButtonMenuItem;

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_ARGB}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setImageTypeSelection(String); given Instance; when IMAGETYPE_ARGB; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_givenInstance_whenImagetype_argb_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> ImageTypeMenu.getInstance().setImageTypeSelection(ImageTypeMenu.IMAGETYPE_ARGB));
  }

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_BITONAL}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setImageTypeSelection(String); given Instance; when IMAGETYPE_BITONAL; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_givenInstance_whenImagetype_bitonal_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> ImageTypeMenu.getInstance().setImageTypeSelection(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_GRAY}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setImageTypeSelection(String); given Instance; when IMAGETYPE_GRAY; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_givenInstance_whenImagetype_gray_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> ImageTypeMenu.getInstance().setImageTypeSelection(ImageTypeMenu.IMAGETYPE_GRAY));
  }

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>Given Instance.
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_RGB}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setImageTypeSelection(String); given Instance; when IMAGETYPE_RGB; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_givenInstance_whenImagetype_rgb_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> ImageTypeMenu.getInstance().setImageTypeSelection(ImageTypeMenu.IMAGETYPE_RGB));
  }

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>Then calls {@link JRadioButtonMenuItem#setSelected(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName("Test setImageTypeSelection(String); then calls setSelected(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_thenCallsSetSelected() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(jRadioButtonMenuItem).setSelected(anyBoolean());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageTypeMenu.setImageTypeSelection(ImageTypeMenu.IMAGETYPE_ARGB));
    verify(jRadioButtonMenuItem).setSelected(true);
  }

  /**
   * Test {@link ImageTypeMenu#setImageTypeSelection(String)}.
   *
   * <ul>
   *   <li>When {@code Selection}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#setImageTypeSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setImageTypeSelection(String); when 'Selection'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImageTypeMenu.setImageTypeSelection(String)"})
  void testSetImageTypeSelection_whenSelection_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> ImageTypeMenu.getInstance().setImageTypeSelection("Selection"));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   *
   * <ul>
   *   <li>When {@code Action Command}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when 'Action Command'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageTypeMenu.isImageTypeMenu(String)"})
  void testIsImageTypeMenu_whenActionCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImageTypeMenu.isImageTypeMenu("Action Command"));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_ARGB}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_ARGB; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageTypeMenu.isImageTypeMenu(String)"})
  void testIsImageTypeMenu_whenImagetype_argb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_ARGB));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_BITONAL}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_BITONAL; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageTypeMenu.isImageTypeMenu(String)"})
  void testIsImageTypeMenu_whenImagetype_bitonal_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_GRAY}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_GRAY; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageTypeMenu.isImageTypeMenu(String)"})
  void testIsImageTypeMenu_whenImagetype_gray_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_GRAY));
  }

  /**
   * Test {@link ImageTypeMenu#isImageTypeMenu(String)}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_RGB}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#isImageTypeMenu(String)}
   */
  @Test
  @DisplayName("Test isImageTypeMenu(String); when IMAGETYPE_RGB; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageTypeMenu.isImageTypeMenu(String)"})
  void testIsImageTypeMenu_whenImagetype_rgb_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageTypeMenu.isImageTypeMenu(ImageTypeMenu.IMAGETYPE_RGB));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Action Command}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName(
      "Test getImageType(String) with 'String'; when 'Action Command'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageType ImageTypeMenu.getImageType(String)"})
  void testGetImageTypeWithString_whenActionCommand_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> ImageTypeMenu.getImageType("Action Command"));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_ARGB}.
   *   <li>Then return {@code ARGB}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_ARGB; then return 'ARGB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageType ImageTypeMenu.getImageType(String)"})
  void testGetImageTypeWithString_whenImagetype_argb_thenReturnArgb() {
    // Arrange, Act and Assert
    assertEquals(ImageType.ARGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_ARGB));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_BITONAL}.
   *   <li>Then return {@code BINARY}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName(
      "Test getImageType(String) with 'String'; when IMAGETYPE_BITONAL; then return 'BINARY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageType ImageTypeMenu.getImageType(String)"})
  void testGetImageTypeWithString_whenImagetype_bitonal_thenReturnBinary() {
    // Arrange, Act and Assert
    assertEquals(ImageType.BINARY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_BITONAL));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_GRAY}.
   *   <li>Then return {@code GRAY}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_GRAY; then return 'GRAY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageType ImageTypeMenu.getImageType(String)"})
  void testGetImageTypeWithString_whenImagetype_gray_thenReturnGray() {
    // Arrange, Act and Assert
    assertEquals(ImageType.GRAY, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_GRAY));
  }

  /**
   * Test {@link ImageTypeMenu#getImageType(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link ImageTypeMenu#IMAGETYPE_RGB}.
   *   <li>Then return {@code RGB}.
   * </ul>
   *
   * <p>Method under test: {@link ImageTypeMenu#getImageType(String)}
   */
  @Test
  @DisplayName("Test getImageType(String) with 'String'; when IMAGETYPE_RGB; then return 'RGB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageType ImageTypeMenu.getImageType(String)"})
  void testGetImageTypeWithString_whenImagetype_rgb_thenReturnRgb() {
    // Arrange, Act and Assert
    assertEquals(ImageType.RGB, ImageTypeMenu.getImageType(ImageTypeMenu.IMAGETYPE_RGB));
  }
}
