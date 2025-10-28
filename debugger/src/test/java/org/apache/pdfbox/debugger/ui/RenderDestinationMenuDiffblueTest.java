package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.Test;

class RenderDestinationMenuDiffblueTest {
  /**
   * Method under test:
   * {@link RenderDestinationMenu#setRenderDestinationSelection(String)}
   */
  @Test
  void testSetRenderDestinationSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> RenderDestinationMenu.getInstance().setRenderDestinationSelection("Selection"));
  }

  /**
   * Method under test:
   * {@link RenderDestinationMenu#isRenderDestinationMenu(String)}
   */
  @Test
  void testIsRenderDestinationMenu() {
    // Arrange, Act and Assert
    assertFalse(RenderDestinationMenu.isRenderDestinationMenu("Action Command"));
    assertTrue(RenderDestinationMenu.isRenderDestinationMenu(RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
    assertTrue(RenderDestinationMenu.isRenderDestinationMenu(RenderDestinationMenu.RENDER_DESTINATION_PRINT));
    assertTrue(RenderDestinationMenu.isRenderDestinationMenu(RenderDestinationMenu.RENDER_DESTINATION_VIEW));
  }

  /**
   * Method under test: {@link RenderDestinationMenu#getRenderDestination(String)}
   */
  @Test
  void testGetRenderDestination() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> RenderDestinationMenu.getRenderDestination("Action Command"));
    assertEquals(RenderDestination.EXPORT,
        RenderDestinationMenu.getRenderDestination(RenderDestinationMenu.RENDER_DESTINATION_EXPORT));
    assertEquals(RenderDestination.PRINT,
        RenderDestinationMenu.getRenderDestination(RenderDestinationMenu.RENDER_DESTINATION_PRINT));
    assertEquals(RenderDestination.VIEW,
        RenderDestinationMenu.getRenderDestination(RenderDestinationMenu.RENDER_DESTINATION_VIEW));
  }
}
