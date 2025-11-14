package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

class PDImmutableRectangleDiffblueTest {
  /**
   * Test {@link PDImmutableRectangle#PDImmutableRectangle(float, float)}.
   *
   * <p>Method under test: {@link PDImmutableRectangle#PDImmutableRectangle(float, float)}
   */
  @Test
  @DisplayName("Test new PDImmutableRectangle(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImmutableRectangle.<init>(float, float)"})
  void testNewPDImmutableRectangle() {
    // Arrange and Act
    PDImmutableRectangle actualPdImmutableRectangle = new PDImmutableRectangle(10.0f, 10.0f);

    // Assert
    COSArray cOSArray = actualPdImmutableRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertEquals(0.0f, actualPdImmutableRectangle.getLowerLeftX());
    assertEquals(0.0f, actualPdImmutableRectangle.getLowerLeftY());
    assertEquals(10.0f, actualPdImmutableRectangle.getHeight());
    assertEquals(10.0f, actualPdImmutableRectangle.getUpperRightX());
    assertEquals(10.0f, actualPdImmutableRectangle.getUpperRightY());
    assertEquals(10.0f, actualPdImmutableRectangle.getWidth());
    assertEquals(getResult, getResult2);
    assertEquals(getResult3, getResult4);
    assertSame(cOSArray, actualPdImmutableRectangle.getCOSObject());
  }

  /**
   * Test {@link PDImmutableRectangle#setUpperRightY(float)}.
   *
   * <p>Method under test: {@link PDImmutableRectangle#setUpperRightY(float)}
   */
  @Test
  @DisplayName("Test setUpperRightY(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImmutableRectangle.setUpperRightY(float)"})
  void testSetUpperRightY() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDImmutableRectangle(10.0f, 10.0f).setUpperRightY(10.0f));
  }

  /**
   * Test {@link PDImmutableRectangle#setUpperRightX(float)}.
   *
   * <p>Method under test: {@link PDImmutableRectangle#setUpperRightX(float)}
   */
  @Test
  @DisplayName("Test setUpperRightX(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImmutableRectangle.setUpperRightX(float)"})
  void testSetUpperRightX() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDImmutableRectangle(10.0f, 10.0f).setUpperRightX(10.0f));
  }

  /**
   * Test {@link PDImmutableRectangle#setLowerLeftY(float)}.
   *
   * <p>Method under test: {@link PDImmutableRectangle#setLowerLeftY(float)}
   */
  @Test
  @DisplayName("Test setLowerLeftY(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImmutableRectangle.setLowerLeftY(float)"})
  void testSetLowerLeftY() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDImmutableRectangle(10.0f, 10.0f).setLowerLeftY(10.0f));
  }

  /**
   * Test {@link PDImmutableRectangle#setLowerLeftX(float)}.
   *
   * <p>Method under test: {@link PDImmutableRectangle#setLowerLeftX(float)}
   */
  @Test
  @DisplayName("Test setLowerLeftX(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImmutableRectangle.setLowerLeftX(float)"})
  void testSetLowerLeftX() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDImmutableRectangle(10.0f, 10.0f).setLowerLeftX(10.0f));
  }
}
