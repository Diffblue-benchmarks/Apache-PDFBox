package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDRangeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDRange#PDRange(COSArray)}
   *   <li>{@link PDRange#getCOSArray()}
   *   <li>{@link PDRange#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDRange.<init>(COSArray)",
    "void PDRange.<init>(COSArray, int)",
    "COSArray PDRange.getCOSArray()",
    "COSBase PDRange.getCOSObject()",
    "java.lang.String PDRange.toString()"
  })
  void testGettersAndSetters_whenCOSArray() {
    // Arrange
    COSArray range = new COSArray();

    // Act
    PDRange actualPdRange = new PDRange(range);
    COSArray actualCOSArray = actualPdRange.getCOSArray();
    COSBase actualCOSObject = actualPdRange.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(range, actualCOSArray);
    assertSame(range, actualCOSObject);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDRange#PDRange(COSArray, int)}
   *   <li>{@link PDRange#getCOSArray()}
   *   <li>{@link PDRange#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDRange.<init>(COSArray)",
    "void PDRange.<init>(COSArray, int)",
    "COSArray PDRange.getCOSArray()",
    "COSBase PDRange.getCOSObject()",
    "java.lang.String PDRange.toString()"
  })
  void testGettersAndSetters_whenOne() {
    // Arrange
    COSArray range = new COSArray();

    // Act
    PDRange actualPdRange = new PDRange(range, 1);
    COSArray actualCOSArray = actualPdRange.getCOSArray();
    COSBase actualCOSObject = actualPdRange.getCOSObject();

    // Assert
    assertTrue(actualCOSArray.toList().isEmpty());
    assertSame(range, actualCOSArray);
    assertSame(range, actualCOSObject);
  }

  /**
   * Test {@link PDRange#getMin()}.
   *
   * <ul>
   *   <li>Given {@link PDRange#PDRange()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDRange#getMin()}
   */
  @Test
  @DisplayName("Test getMin(); given PDRange(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRange.getMin()"})
  void testGetMin_givenPDRange_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDRange().getMin());
  }

  /**
   * Test {@link PDRange#setMin(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRange#PDRange()}.
   *   <li>Then {@link PDRange#PDRange()} COSArray toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDRange#setMin(float)}
   */
  @Test
  @DisplayName("Test setMin(float); given PDRange(); then PDRange() COSArray toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRange.setMin(float)"})
  void testSetMin_givenPDRange_thenPDRangeCOSArrayToListSizeIsTwo() {
    // Arrange
    PDRange pdRange = new PDRange();

    // Act
    pdRange.setMin(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdRange.getCOSArray().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdRange.getMin());
  }

  /**
   * Test {@link PDRange#getMax()}.
   *
   * <ul>
   *   <li>Given {@link PDRange#PDRange()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDRange#getMax()}
   */
  @Test
  @DisplayName("Test getMax(); given PDRange(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDRange.getMax()"})
  void testGetMax_givenPDRange_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDRange().getMax());
  }

  /**
   * Test {@link PDRange#setMax(float)}.
   *
   * <ul>
   *   <li>Given {@link PDRange#PDRange()}.
   *   <li>Then {@link PDRange#PDRange()} COSArray toList size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDRange#setMax(float)}
   */
  @Test
  @DisplayName("Test setMax(float); given PDRange(); then PDRange() COSArray toList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDRange.setMax(float)"})
  void testSetMax_givenPDRange_thenPDRangeCOSArrayToListSizeIsTwo() {
    // Arrange
    PDRange pdRange = new PDRange();

    // Act
    pdRange.setMax(10.0f);

    // Assert
    List<? extends COSBase> toListResult = pdRange.getCOSArray().toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(10.0f, pdRange.getMax());
  }
}
