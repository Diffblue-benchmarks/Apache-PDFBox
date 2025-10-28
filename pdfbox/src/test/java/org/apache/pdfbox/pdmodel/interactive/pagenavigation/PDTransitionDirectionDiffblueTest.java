package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.Test;

class PDTransitionDirectionDiffblueTest {
  /**
   * Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  void testGetCOSBase() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.LEFT_TO_RIGHT.getCOSBase();

    // Assert
    assertSame(((COSInteger) actualCOSBase).ZERO, actualCOSBase);
  }

  /**
   * Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  void testGetCOSBase2() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.TOP_TO_BOTTOM.getCOSBase();

    // Assert
    assertTrue(actualCOSBase instanceof COSInteger);
    assertNull(actualCOSBase.getKey());
    assertFalse(actualCOSBase.isDirect());
    assertTrue(((COSInteger) actualCOSBase).isValid());
  }

  /**
   * Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  void testGetCOSBase3() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.NONE.getCOSBase();

    // Assert
    assertSame(((COSName) actualCOSBase).NONE, actualCOSBase);
  }
}
