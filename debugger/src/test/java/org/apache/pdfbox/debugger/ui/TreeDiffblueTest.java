package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Canvas;
import java.awt.Point;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TreeDiffblueTest {
  /**
   * Test {@link Tree#getPopupLocation(MouseEvent)}.
   * <ul>
   *   <li>Then return {@link Point#x} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tree#getPopupLocation(MouseEvent)}
   */
  @Test
  @DisplayName("Test getPopupLocation(MouseEvent); then return x is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Point Tree.getPopupLocation(MouseEvent)"})
  void testGetPopupLocation_thenReturnXIsOne() {
    // Arrange
    Tree tree = new Tree();

    // Act
    Point actualPopupLocation = tree.getPopupLocation(new MouseEvent(new Canvas(), 1, 1L, 1, 1, 1, 1, true));

    // Assert
    assertEquals(1, actualPopupLocation.x);
    assertEquals(1, actualPopupLocation.y);
    assertEquals(1.0d, actualPopupLocation.getX());
    assertEquals(1.0d, actualPopupLocation.getY());
    assertEquals(actualPopupLocation, actualPopupLocation.getLocation());
  }

  /**
   * Test {@link Tree#getPopupLocation(MouseEvent)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Tree#getPopupLocation(MouseEvent)}
   */
  @Test
  @DisplayName("Test getPopupLocation(MouseEvent); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Point Tree.getPopupLocation(MouseEvent)"})
  void testGetPopupLocation_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new Tree()).getPopupLocation(null));
  }
}
