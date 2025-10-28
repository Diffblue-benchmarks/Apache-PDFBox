package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDSquareAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDSquareAppearanceHandler#getLineWidth()}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDSquareAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDSquareAppearanceHandler#PDSquareAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSquareAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSquareAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
}
