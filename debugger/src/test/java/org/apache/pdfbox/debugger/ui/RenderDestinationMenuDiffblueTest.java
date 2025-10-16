package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RenderDestinationMenuDiffblueTest {
  /**
   * Test {@link RenderDestinationMenu#setRenderDestinationSelection(String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  @DisplayName("Test setRenderDestinationSelection(String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RenderDestinationMenu.setRenderDestinationSelection(String)"})
  void testSetRenderDestinationSelection_thenThrowIllegalArgumentException() {
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
