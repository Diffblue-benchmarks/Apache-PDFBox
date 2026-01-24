package org.apache.pdfbox.pdmodel.graphics;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDLineDashPatternDiffblueTest {
  /**
   * Test {@link PDLineDashPattern#PDLineDashPattern(COSArray, int)}.
   *
   * <ul>
   *   <li>Then return COSObject toList first toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLineDashPattern#PDLineDashPattern(COSArray, int)}
   */
  @Test
  @DisplayName(
      "Test new PDLineDashPattern(COSArray, int); then return COSObject toList first toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLineDashPattern.<init>(COSArray, int)"})
  void testNewPDLineDashPattern_thenReturnCOSObjectToListFirstToListSizeIsOne() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    PDLineDashPattern actualPdLineDashPattern = new PDLineDashPattern(array, 1);

    // Assert
    COSBase cOSObject = actualPdLineDashPattern.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
    assertArrayEquals(new float[] {0.0f}, actualPdLineDashPattern.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDLineDashPattern#getCOSObject()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return toList first toList size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLineDashPattern#getCOSObject()}
   */
  @Test
  @DisplayName(
      "Test getCOSObject(); given COSArray() add FALSE; then return toList first toList size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDLineDashPattern.getCOSObject()"})
  void testGetCOSObject_givenCOSArrayAddFalse_thenReturnToListFirstToListSizeIsOne() {
    // Arrange
    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    COSBase actualCOSObject = new PDLineDashPattern(array, 1).getCOSObject();

    // Assert
    List<? extends COSBase> toListResult = ((COSArray) actualCOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(actualCOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult2.getKey());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDLineDashPattern#toString()}
   *   <li>{@link PDLineDashPattern#getPhase()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDLineDashPattern.getPhase()", "String PDLineDashPattern.toString()"})
  void testGettersAndSetters() {
    // Arrange
    PDLineDashPattern pdLineDashPattern = new PDLineDashPattern();

    // Act
    String actualToStringResult = pdLineDashPattern.toString();

    // Assert
    assertEquals("PDLineDashPattern{array=[], phase=0}", actualToStringResult);
    assertEquals(0, pdLineDashPattern.getPhase());
  }

  /**
   * Test {@link PDLineDashPattern#getDashArray()}.
   *
   * <p>Method under test: {@link PDLineDashPattern#getDashArray()}
   */
  @Test
  @DisplayName("Test getDashArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDLineDashPattern.getDashArray()"})
  void testGetDashArray() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[] {}, new PDLineDashPattern().getDashArray(), 0.0f);
  }
}
