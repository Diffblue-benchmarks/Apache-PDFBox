package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreateCheckBoxDiffblueTest {
  /**
   * Test {@link CreateCheckBox#getLineWidth(PDAnnotationWidget)}.
   *
   * <ul>
   *   <li>When {@link PDAnnotationWidget#PDAnnotationWidget()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CreateCheckBox#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  @DisplayName("Test getLineWidth(PDAnnotationWidget); when PDAnnotationWidget(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float CreateCheckBox.getLineWidth(PDAnnotationWidget)"})
  void testGetLineWidth_whenPDAnnotationWidget_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateCheckBox.getLineWidth(new PDAnnotationWidget()));
  }
}
