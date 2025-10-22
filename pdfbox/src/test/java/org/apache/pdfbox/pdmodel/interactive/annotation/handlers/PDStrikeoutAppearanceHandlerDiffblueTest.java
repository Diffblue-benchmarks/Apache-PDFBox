package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStrikeoutAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDStrikeoutAppearanceHandler#PDStrikeoutAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDStrikeoutAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDStrikeoutAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStrikeoutAppearanceHandler.<init>(PDAnnotation)",
      "void PDStrikeoutAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDStrikeoutAppearanceHandler.generateDownAppearance()",
      "void PDStrikeoutAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDStrikeoutAppearanceHandler actualPdStrikeoutAppearanceHandler = new PDStrikeoutAppearanceHandler(annotation);
    actualPdStrikeoutAppearanceHandler.generateDownAppearance();
    actualPdStrikeoutAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdStrikeoutAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdStrikeoutAppearanceHandler.getAnnotation());
  }
}
