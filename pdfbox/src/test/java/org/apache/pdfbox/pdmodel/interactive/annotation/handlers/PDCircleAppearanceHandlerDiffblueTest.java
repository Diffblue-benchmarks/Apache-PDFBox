package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDCircleAppearanceHandlerDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCircleAppearanceHandler#PDCircleAppearanceHandler(PDAnnotation)}
   *   <li>{@link PDCircleAppearanceHandler#generateDownAppearance()}
   *   <li>{@link PDCircleAppearanceHandler#generateRolloverAppearance()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDCircleAppearanceHandler.<init>(PDAnnotation)",
      "void PDCircleAppearanceHandler.<init>(PDAnnotation, org.apache.pdfbox.pdmodel.PDDocument)",
      "void PDCircleAppearanceHandler.generateDownAppearance()",
      "void PDCircleAppearanceHandler.generateRolloverAppearance()"})
  void testGettersAndSetters_whenPDAnnotationCaret() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    PDCircleAppearanceHandler actualPdCircleAppearanceHandler = new PDCircleAppearanceHandler(annotation);
    actualPdCircleAppearanceHandler.generateDownAppearance();
    actualPdCircleAppearanceHandler.generateRolloverAppearance();

    // Assert
    assertTrue(actualPdCircleAppearanceHandler.getDefaultFont() instanceof PDType1Font);
    assertSame(annotation, actualPdCircleAppearanceHandler.getAnnotation());
  }

  /**
   * Test {@link PDCircleAppearanceHandler#getLineWidth()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCircleAppearanceHandler#getLineWidth()}
   */
  @Test
  @DisplayName("Test getLineWidth(); then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDCircleAppearanceHandler.getLineWidth()"})
  void testGetLineWidth_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCircleAppearanceHandler(new PDAnnotationCaret())).getLineWidth());
  }
}
