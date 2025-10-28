package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDPolylineAppearanceHandlerDiffblueTest {
  /**
   * Method under test: {@link PDPolylineAppearanceHandler#getLineWidth()}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDPolylineAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDPolylineAppearanceHandler#PDPolylineAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDPolylineAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDPolylineAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDPolylineAppearanceHandler actualPdPolylineAppearanceHandler = new PDPolylineAppearanceHandler(annotation);
    actualPdPolylineAppearanceHandler.generateDownAppearance();
    actualPdPolylineAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdPolylineAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdPolylineAppearanceHandler.getAnnotation());
  }
}
