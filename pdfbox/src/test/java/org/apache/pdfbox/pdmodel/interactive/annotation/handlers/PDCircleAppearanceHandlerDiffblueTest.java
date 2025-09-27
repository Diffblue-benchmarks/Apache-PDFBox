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
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCircleAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDCircleAppearanceHandler#PDCircleAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDCircleAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDCircleAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDCircleAppearanceHandler.<init>(PDAnnotation)",
    "void PDCircleAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDCircleAppearanceHandler.generateDownAppearance()",
    "void PDCircleAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDCircleAppearanceHandler actualPdCircleAppearanceHandler =
        new PDCircleAppearanceHandler(annotation);
    actualPdCircleAppearanceHandler.generateDownAppearance();
    actualPdCircleAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdCircleAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdCircleAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDCircleAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCircleAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCircleAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    annotation.setRectangle(PDRectangle.A0);
    PDCircleAppearanceHandler pdCircleAppearanceHandler = new PDCircleAppearanceHandler(annotation);

    // Act
    pdCircleAppearanceHandler.generateNormalAppearance();

    // Assert
    PDAnnotation annotation2 = pdCircleAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCircle);
    PDRectangle rectangle = annotation2.getRectangle();
    assertEquals(-0.5f, rectangle.getLowerLeftX());
    PDRectangle rectangle2 = pdCircleAppearanceHandler.getRectangle();
    assertEquals(-0.5f, rectangle2.getLowerLeftX());
    assertEquals(-0.5f, rectangle.getLowerLeftY());
    assertEquals(-0.5f, rectangle2.getLowerLeftY());
    assertEquals(2384.437f, rectangle.getUpperRightX());
    assertEquals(2384.437f, rectangle2.getUpperRightX());
    assertEquals(2384.937f, rectangle.getWidth());
    assertEquals(2384.937f, rectangle2.getWidth());
    assertEquals(3370.8938f, rectangle.getUpperRightY());
    assertEquals(3370.8938f, rectangle2.getUpperRightY());
    assertEquals(3371.3938f, rectangle.getHeight());
    assertEquals(3371.3938f, rectangle2.getHeight());
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f},
        ((PDAnnotationCircle) annotation2).getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDCircleAppearanceHandler#generateNormalAppearance()}.
   *
   * <p>Method under test: {@link PDCircleAppearanceHandler#generateNormalAppearance()}
   */
  @Test
  @DisplayName("Test generateNormalAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCircleAppearanceHandler.generateNormalAppearance()"})
  void testGenerateNormalAppearance2() {
    // Arrange
    PDAnnotationCircle annotation = new PDAnnotationCircle();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCircleAppearanceHandler pdCircleAppearanceHandler = new PDCircleAppearanceHandler(annotation);

    // Act
    pdCircleAppearanceHandler.generateNormalAppearance();

    // Assert
    PDAnnotation annotation2 = pdCircleAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCircle);
    PDRectangle rectangle2 = annotation2.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    PDRectangle rectangle3 = pdCircleAppearanceHandler.getRectangle();
    assertEquals(0.0f, rectangle3.getHeight());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(0.0f, rectangle3.getWidth());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle3.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle3.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle3.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightY());
    assertEquals(2.14748365E9f, rectangle3.getUpperRightY());
    assertArrayEquals(
        new float[] {0.5f, 0.5f, 0.5f, 0.5f},
        ((PDAnnotationCircle) annotation2).getRectDifferences(),
        0.0f);
  }

  /**
   * Test {@link PDCircleAppearanceHandler#getLineWidth()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCircleAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCircleAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, new PDCircleAppearanceHandler(new PDAnnotationCaret()).getLineWidth());
  }
}
