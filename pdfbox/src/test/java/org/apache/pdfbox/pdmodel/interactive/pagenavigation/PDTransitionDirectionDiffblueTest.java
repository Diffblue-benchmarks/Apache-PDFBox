package org.apache.pdfbox.pdmodel.interactive.pagenavigation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTransitionDirectionDiffblueTest {
  /**
   * Test {@link PDTransitionDirection#getCOSBase()}.
   *
   * <ul>
   *   <li>Given {@code LEFT_TO_RIGHT}.
   *   <li>Then return {@link COSInteger#ZERO}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  @DisplayName("Test getCOSBase(); given 'LEFT_TO_RIGHT'; then return ZERO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDTransitionDirection.getCOSBase()"})
  void testGetCOSBase_givenLeftToRight_thenReturnZero() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.LEFT_TO_RIGHT.getCOSBase();

    // Assert
    assertSame(((COSInteger) actualCOSBase).ZERO, actualCOSBase);
  }

  /**
   * Test {@link PDTransitionDirection#getCOSBase()}.
   *
   * <ul>
   *   <li>Given {@code NONE}.
   *   <li>Then return {@link COSName#NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  @DisplayName("Test getCOSBase(); given 'NONE'; then return NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDTransitionDirection.getCOSBase()"})
  void testGetCOSBase_givenNone_thenReturnNone() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.NONE.getCOSBase();

    // Assert
    assertSame(((COSName) actualCOSBase).NONE, actualCOSBase);
  }

  /**
   * Test {@link PDTransitionDirection#getCOSBase()}.
   *
   * <ul>
   *   <li>Given {@code TOP_TO_BOTTOM}.
   *   <li>Then return {@link COSInteger}.
   * </ul>
   *
   * <p>Method under test: {@link PDTransitionDirection#getCOSBase()}
   */
  @Test
  @DisplayName("Test getCOSBase(); given 'TOP_TO_BOTTOM'; then return COSInteger")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDTransitionDirection.getCOSBase()"})
  void testGetCOSBase_givenTopToBottom_thenReturnCOSInteger() {
    // Arrange and Act
    COSBase actualCOSBase = PDTransitionDirection.TOP_TO_BOTTOM.getCOSBase();

    // Assert
    assertTrue(actualCOSBase instanceof COSInteger);
    assertNull(actualCOSBase.getKey());
    assertFalse(actualCOSBase.isDirect());
    assertTrue(((COSInteger) actualCOSBase).isValid());
  }
}
