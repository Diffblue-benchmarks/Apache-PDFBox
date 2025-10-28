package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.Test;

class PDSoundAppearanceHandlerDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDSoundAppearanceHandler#PDSoundAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSoundAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSoundAppearanceHandler#generateNormalAppearance()}
   *   <li>{@link PDSoundAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDSoundAppearanceHandler actualPdSoundAppearanceHandler = new PDSoundAppearanceHandler(annotation);
    actualPdSoundAppearanceHandler.generateDownAppearance();
    actualPdSoundAppearanceHandler.generateNormalAppearance();
    actualPdSoundAppearanceHandler.generateRolloverAppearance();

    // Assert that nothing has changed
    assertTrue(actualPdSoundAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdSoundAppearanceHandler.getAnnotation());
  }
}
