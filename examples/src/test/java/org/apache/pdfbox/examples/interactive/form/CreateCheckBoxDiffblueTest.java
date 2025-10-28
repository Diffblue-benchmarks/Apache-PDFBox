package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.Test;

class CreateCheckBoxDiffblueTest {
  /**
   * Method under test: {@link CreateCheckBox#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  void testGetLineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateCheckBox.getLineWidth(new PDAnnotationWidget()));
  }
}
