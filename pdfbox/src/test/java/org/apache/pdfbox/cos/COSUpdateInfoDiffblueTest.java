package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSUpdateInfoDiffblueTest {
  /**
   * Test {@link COSUpdateInfo#isNeedToBeUpdated()}.
   *
   * <p>Method under test: {@link COSUpdateInfo#isNeedToBeUpdated()}
   */
  @Test
  @DisplayName("Test isNeedToBeUpdated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSUpdateInfo.isNeedToBeUpdated()"})
  void testIsNeedToBeUpdated() {
    // Arrange, Act and Assert
    assertFalse(new COSArray().isNeedToBeUpdated());
  }

  /**
   * Test {@link COSUpdateInfo#toIncrement()}.
   *
   * <p>Method under test: {@link COSUpdateInfo#toIncrement()}
   */
  @Test
  @DisplayName("Test toIncrement()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSIncrement COSUpdateInfo.toIncrement()"})
  void testToIncrement() {
    // Arrange and Act
    COSIncrement actualToIncrementResult = new COSArray().toIncrement();

    // Assert
    assertFalse(actualToIncrementResult.iterator().hasNext());
    assertTrue(actualToIncrementResult.getObjects().isEmpty());
  }
}
