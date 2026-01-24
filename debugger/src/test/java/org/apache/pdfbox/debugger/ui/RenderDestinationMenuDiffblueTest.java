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
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RenderDestinationMenuDiffblueTest {
  @Mock private JRadioButtonMenuItem jRadioButtonMenuItem;

  @InjectMocks private RenderDestinationMenu renderDestinationMenu;

  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>Then calls {@link JRadioButtonMenuItem#setSelected(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName("Test setRenderDestinationSelection(String); then calls setSelected(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_thenCallsSetSelected() {
    // Arrange
    doThrow(new IllegalArgumentException()).when(jRadioButtonMenuItem).setSelected(anyBoolean());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            renderDestinationMenu.setRenderDestinationSelection(
                RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
    verify(jRadioButtonMenuItem).setSelected(true);
  }

  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_EXPORT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setRenderDestinationSelection(String); when RENDER_DESTINATION_EXPORT; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_whenRender_destination_export_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            RenderDestinationMenu.getInstance()
                .setRenderDestinationSelection(RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
  }

  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_PRINT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setRenderDestinationSelection(String); when RENDER_DESTINATION_PRINT; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_whenRender_destination_print_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            RenderDestinationMenu.getInstance()
                .setRenderDestinationSelection(RenderDestinationMenu.RENDER_DESTINATION_PRINT));
  }

  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_VIEW}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName(
      "Test setRenderDestinationSelection(String); when RENDER_DESTINATION_VIEW; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_whenRender_destination_view_thenDoesNotThrow() {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () ->
            RenderDestinationMenu.getInstance()
                .setRenderDestinationSelection(RenderDestinationMenu.RENDER_DESTINATION_VIEW));
  }

  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>When {@code Selection}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName("Test setRenderDestinationSelection(String); when 'Selection'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_whenSelection() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> RenderDestinationMenu.getInstance().setRenderDestinationSelection("Selection"));
  }

  /**
   * Test {@link RenderDestinationMenu#isRenderDestinationMenu(String)}.
   *
   * <ul>
   *   <li>When {@code Action Command}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#isRenderDestinationMenu(String)}
   */
  @Test
  @DisplayName("Test isRenderDestinationMenu(String); when 'Action Command'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderDestinationMenu.isRenderDestinationMenu(String)"})
  void testIsRenderDestinationMenu_whenActionCommand_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(RenderDestinationMenu.isRenderDestinationMenu("Action Command"));
  }

  /**
   * Test {@link RenderDestinationMenu#isRenderDestinationMenu(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_EXPORT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#isRenderDestinationMenu(String)}
   */
  @Test
  @DisplayName(
      "Test isRenderDestinationMenu(String); when RENDER_DESTINATION_EXPORT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderDestinationMenu.isRenderDestinationMenu(String)"})
  void testIsRenderDestinationMenu_whenRender_destination_export_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        RenderDestinationMenu.isRenderDestinationMenu(
            RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
  }

  /**
   * Test {@link RenderDestinationMenu#isRenderDestinationMenu(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_PRINT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#isRenderDestinationMenu(String)}
   */
  @Test
  @DisplayName(
      "Test isRenderDestinationMenu(String); when RENDER_DESTINATION_PRINT; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderDestinationMenu.isRenderDestinationMenu(String)"})
  void testIsRenderDestinationMenu_whenRender_destination_print_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        RenderDestinationMenu.isRenderDestinationMenu(
            RenderDestinationMenu.RENDER_DESTINATION_PRINT));
  }

  /**
   * Test {@link RenderDestinationMenu#isRenderDestinationMenu(String)}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_VIEW}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#isRenderDestinationMenu(String)}
   */
  @Test
  @DisplayName(
      "Test isRenderDestinationMenu(String); when RENDER_DESTINATION_VIEW; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean RenderDestinationMenu.isRenderDestinationMenu(String)"})
  void testIsRenderDestinationMenu_whenRender_destination_view_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        RenderDestinationMenu.isRenderDestinationMenu(
            RenderDestinationMenu.RENDER_DESTINATION_VIEW));
  }

  /**
   * Test {@link RenderDestinationMenu#getRenderDestination()}.
   *
   * <p>Method under test: {@link RenderDestinationMenu#getRenderDestination()}
   */
  @Test
  @DisplayName("Test getRenderDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderDestination RenderDestinationMenu.getRenderDestination()"})
  void testGetRenderDestination() {
    // Arrange, Act and Assert
    assertEquals(RenderDestination.EXPORT, RenderDestinationMenu.getRenderDestination());
  }

  /**
   * Test {@link RenderDestinationMenu#getRenderDestination(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then return {@code EXPORT}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#getRenderDestination(String)}
   */
  @Test
  @DisplayName("Test getRenderDestination(String) with 'String'; then return 'EXPORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderDestination RenderDestinationMenu.getRenderDestination(String)"})
  void testGetRenderDestinationWithString_thenReturnExport() {
    // Arrange, Act and Assert
    assertEquals(
        RenderDestination.EXPORT,
        RenderDestinationMenu.getRenderDestination(
            RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
  }

  /**
   * Test {@link RenderDestinationMenu#getRenderDestination(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#getRenderDestination(String)}
   */
  @Test
  @DisplayName(
      "Test getRenderDestination(String) with 'String'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderDestination RenderDestinationMenu.getRenderDestination(String)"})
  void testGetRenderDestinationWithString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> RenderDestinationMenu.getRenderDestination("Action Command"));
  }

  /**
   * Test {@link RenderDestinationMenu#getRenderDestination(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_PRINT}.
   *   <li>Then return {@code PRINT}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#getRenderDestination(String)}
   */
  @Test
  @DisplayName(
      "Test getRenderDestination(String) with 'String'; when RENDER_DESTINATION_PRINT; then return 'PRINT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderDestination RenderDestinationMenu.getRenderDestination(String)"})
  void testGetRenderDestinationWithString_whenRender_destination_print_thenReturnPrint() {
    // Arrange, Act and Assert
    assertEquals(
        RenderDestination.PRINT,
        RenderDestinationMenu.getRenderDestination(RenderDestinationMenu.RENDER_DESTINATION_PRINT));
  }

  /**
   * Test {@link RenderDestinationMenu#getRenderDestination(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link RenderDestinationMenu#RENDER_DESTINATION_VIEW}.
   *   <li>Then return {@code VIEW}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#getRenderDestination(String)}
   */
  @Test
  @DisplayName(
      "Test getRenderDestination(String) with 'String'; when RENDER_DESTINATION_VIEW; then return 'VIEW'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RenderDestination RenderDestinationMenu.getRenderDestination(String)"})
  void testGetRenderDestinationWithString_whenRender_destination_view_thenReturnView() {
    // Arrange, Act and Assert
    assertEquals(
        RenderDestination.VIEW,
        RenderDestinationMenu.getRenderDestination(RenderDestinationMenu.RENDER_DESTINATION_VIEW));
  }
}
