package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDSquareAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDSquareAppearanceHandler#PDSquareAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSquareAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSquareAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDSquareAppearanceHandler actualPdSquareAppearanceHandler = new PDSquareAppearanceHandler(annotation);
    actualPdSquareAppearanceHandler.generateDownAppearance();
    actualPdSquareAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdSquareAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdSquareAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDSquareAppearanceHandler#getLineWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSquareAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDSquareAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }
}
