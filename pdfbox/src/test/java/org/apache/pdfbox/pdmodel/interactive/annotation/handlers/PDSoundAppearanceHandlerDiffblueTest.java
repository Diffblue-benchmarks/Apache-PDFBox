package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDSoundAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDSoundAppearanceHandler#PDSoundAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDSoundAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDSoundAppearanceHandler#generateNormalAppearance()}
   *   <li>{@link PDSoundAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDSoundAppearanceHandler.<init>(PDAnnotation)",
    "void PDSoundAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDSoundAppearanceHandler.generateDownAppearance()",
    "void PDSoundAppearanceHandler.generateNormalAppearance()",
    "void PDSoundAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDSoundAppearanceHandler actualPdSoundAppearanceHandler =
        new PDSoundAppearanceHandler(annotation);
    actualPdSoundAppearanceHandler.generateDownAppearance();
    actualPdSoundAppearanceHandler.generateNormalAppearance();
    actualPdSoundAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdSoundAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdSoundAppearanceHandler.getAnnotation());
  }
}
