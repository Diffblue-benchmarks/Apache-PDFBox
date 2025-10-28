package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDCircleAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDCircleAppearanceHandler#getLineWidth()}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCircleAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDCircleAppearanceHandler#PDCircleAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDCircleAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDCircleAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDCircleAppearanceHandler actualPdCircleAppearanceHandler = new PDCircleAppearanceHandler(annotation);
    actualPdCircleAppearanceHandler.generateDownAppearance();
    actualPdCircleAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdCircleAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdCircleAppearanceHandler.getAnnotation());
  }
}
