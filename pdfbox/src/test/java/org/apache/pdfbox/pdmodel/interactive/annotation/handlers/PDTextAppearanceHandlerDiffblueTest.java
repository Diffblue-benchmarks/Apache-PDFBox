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

class PDTextAppearanceHandlerDiffblueTest {
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
   *   <li>{@link PDTextAppearanceHandler#PDTextAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDTextAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDTextAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTextAppearanceHandler.<init>(PDAnnotation)",
    "void PDTextAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
    "void PDTextAppearanceHandler.generateDownAppearance()",
    "void PDTextAppearanceHandler.generateRolloverAppearance()"
  })
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDTextAppearanceHandler actualPdTextAppearanceHandler = new PDTextAppearanceHandler(annotation);
    actualPdTextAppearanceHandler.generateDownAppearance();
    actualPdTextAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdTextAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdTextAppearanceHandler.getAnnotation());
  }
}
