package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class ZoomMenuDiffblueTest {
  /**
   * Method under test: {@link ZoomMenu#changeZoomSelection(float)}
   */
  @Test
  void testChangeZoomSelection() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ZoomMenu.getInstance().changeZoomSelection(100.0f));
  }

  /**
   * Method under test: {@link ZoomMenu#isZoomMenu(String)}
   */
  @Test
  void testIsZoomMenu() {
    // Arrange, Act and Assert
    assertFalse(ZoomMenu.isZoomMenu("Action Command"));
    assertFalse(ZoomMenu.isZoomMenu("9%"));
    assertFalse(ZoomMenu.isZoomMenu("429%"));
    assertFalse(ZoomMenu.isZoomMenu("42429%"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ZoomMenu#setImageZoomScale(float)}
   *   <li>{@link ZoomMenu#setPageZoomScale(float)}
   *   <li>{@link ZoomMenu#getImageZoomScale()}
   *   <li>{@link ZoomMenu#getPageZoomScale()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ZoomMenu instance = ZoomMenu.getInstance();

    // Act
    instance.setImageZoomScale(10.0f);
    instance.setPageZoomScale(10.0f);
    float actualImageZoomScale = instance.getImageZoomScale();

    // Assert that nothing has changed
    assertEquals(10.0f, actualImageZoomScale);
    assertEquals(10.0f, instance.getPageZoomScale());
  }
}
