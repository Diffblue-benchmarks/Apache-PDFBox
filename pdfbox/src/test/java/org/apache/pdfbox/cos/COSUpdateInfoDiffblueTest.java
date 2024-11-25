package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class COSUpdateInfoDiffblueTest {
  /**
   * Test {@link COSUpdateInfo#isNeedToBeUpdated()}.
   * <p>
   * Method under test: {@link COSUpdateInfo#isNeedToBeUpdated()}
   */
  @Test
  @DisplayName("Test isNeedToBeUpdated()")
  void testIsNeedToBeUpdated() {
    // Arrange, Act and Assert
    assertFalse((new COSArray()).isNeedToBeUpdated());
  }

  /**
   * Test {@link COSUpdateInfo#toIncrement()}.
   * <p>
   * Method under test: {@link COSUpdateInfo#toIncrement()}
   */
  @Test
  @DisplayName("Test toIncrement()")
  void testToIncrement() {
    // Arrange and Act
    COSIncrement actualToIncrementResult = (new COSArray()).toIncrement();

    // Assert
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }
}
