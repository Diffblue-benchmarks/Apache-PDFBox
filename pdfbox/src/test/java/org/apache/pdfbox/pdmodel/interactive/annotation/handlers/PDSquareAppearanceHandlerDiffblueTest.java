package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquare;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSquareAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDSquareAppearanceHandler#PDSquareAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSquareAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSquareAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDSquareAppearanceHandler.<init>(PDAnnotation)",
    "void PDSquareAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDSquareAppearanceHandler.generateDownAppearance()",
    "void PDSquareAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDSquareAppearanceHandler actualPdSquareAppearanceHandler =
        new PDSquareAppearanceHandler(annotation);
    actualPdSquareAppearanceHandler.generateDownAppearance();
    actualPdSquareAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdSquareAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdSquareAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDSquareAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDSquareAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSquareAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationSquare annotation = new PDAnnotationSquare();
    annotation.setRectangle(PDRectangle.A0);
    PDSquareAppearanceHandler pdSquareAppearanceHandler = new PDSquareAppearanceHandler(annotation);

    // Act
    pdSquareAppearanceHandler.generateNormalAppearance();

    // Assert
    PDAnnotation annotation2 = pdSquareAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationSquare);
    PDRectangle rectangle = annotation2.getRectangle();
    assertEquals(2384.437f, rectangle.getUpperRightX());
    PDRectangle rectangle2 = pdSquareAppearanceHandler.getRectangle();
    assertEquals(2384.437f, rectangle2.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(2384.937f, rectangle2.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3370.8938f, rectangle2.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    assertEquals(3371.3938f, rectangle2.getHeight());
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f},
        ((PDAnnotationSquare) annotation2).getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDSquareAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDSquareAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSquareAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationSquare annotation = new PDAnnotationSquare();
    annotation.setRectangle(PDRectangle.A4);
    PDSquareAppearanceHandler pdSquareAppearanceHandler = new PDSquareAppearanceHandler(annotation);

    // Act
    pdSquareAppearanceHandler.generateNormalAppearance();

    // Assert
    PDAnnotation annotation2 = pdSquareAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationSquare);
    PDRectangle rectangle = annotation2.getRectangle();
    assertEquals(595.77563f, rectangle.getUpperRightX());
    PDRectangle rectangle2 = pdSquareAppearanceHandler.getRectangle();
    assertEquals(595.77563f, rectangle2.getUpperRightX());
    assertEquals(596.27563f, rectangle.getWidth());
    assertEquals(596.27563f, rectangle2.getWidth());
    assertEquals(842.3898f, rectangle.getUpperRightY());
    assertEquals(842.3898f, rectangle2.getUpperRightY());
    assertEquals(842.8898f, rectangle.getHeight());
    assertEquals(842.8898f, rectangle2.getHeight());
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f},
        ((PDAnnotationSquare) annotation2).getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDSquareAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDSquareAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDSquareAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance3() {
    // Arrange
    PDAnnotationSquare annotation = new PDAnnotationSquare();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDSquareAppearanceHandler pdSquareAppearanceHandler = new PDSquareAppearanceHandler(annotation);

    // Act
    pdSquareAppearanceHandler.generateNormalAppearance();

    // Assert
    PDAnnotation annotation2 = pdSquareAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationSquare);
    PDRectangle rectangle2 = annotation2.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    PDRectangle rectangle3 = pdSquareAppearanceHandler.getRectangle();
    assertEquals(0.0f, rectangle3.getHeight());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(0.0f, rectangle3.getWidth());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle3.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightY());
    assertEquals(2.14748365E9f, rectangle3.getUpperRightY());
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f},
        ((PDAnnotationSquare) annotation2).getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDSquareAppearanceHandler#getLineWidth()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDSquareAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDSquareAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDSquareAppearanceHandler(new PDAnnotationCaret()).getLineWidth());
  }
}
