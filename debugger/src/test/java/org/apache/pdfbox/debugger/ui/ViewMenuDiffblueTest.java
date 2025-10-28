package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.Test;

class ViewMenuDiffblueTest {
  /**
   * Method under test: {@link ViewMenu#isRenderingOption(String)}
   */
  @Test
  void testIsRenderingOption() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isRenderingOption("Action Command"));
    assertTrue(ViewMenu.isRenderingOption("Show TextStripper TextPositions"));
    assertTrue(ViewMenu.isRenderingOption("Show TextStripper Beads"));
    assertTrue(ViewMenu.isRenderingOption("Show Approximate Text Bounds"));
    assertTrue(ViewMenu.isRenderingOption("Show Glyph Bounds"));
    assertTrue(ViewMenu.isRenderingOption("Allow subsampling"));
  }

  /**
   * Method under test: {@link ViewMenu#isExtractTextEvent(ActionEvent)}
   */
  @Test
  void testIsExtractTextEvent() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isExtractTextEvent(new ActionEvent("42", 1, "foo")));
    assertTrue(ViewMenu.isExtractTextEvent(new ActionEvent("42", 1, "Extract Text")));
  }

  /**
   * Method under test: {@link ViewMenu#isRepairAcroformEvent(ActionEvent)}
   */
  @Test
  void testIsRepairAcroformEvent() {
    // Arrange, Act and Assert
    assertFalse(ViewMenu.isRepairAcroformEvent(new ActionEvent("42", 1, "foo")));
    assertTrue(ViewMenu.isRepairAcroformEvent(new ActionEvent("42", 1, "Repair AcroForm")));
  }
}
