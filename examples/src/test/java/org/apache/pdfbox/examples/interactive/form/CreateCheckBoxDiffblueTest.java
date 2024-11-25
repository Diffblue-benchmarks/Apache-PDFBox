package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateCheckBoxDiffblueTest {
  /**
   * Test {@link CreateCheckBox#getLineWidth(PDAnnotationWidget)}.
   * <ul>
   *   <li>When {@link PDAnnotationWidget#PDAnnotationWidget()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CreateCheckBox#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  @DisplayName("Test getLineWidth(PDAnnotationWidget); when PDAnnotationWidget(); then return one")
  void testGetLineWidth_whenPDAnnotationWidget_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateCheckBox.getLineWidth(new PDAnnotationWidget()));
  }
}
