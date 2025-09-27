package org.apache.pdfbox.examples.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CreateRadioButtonsDiffblueTest {
  /**
   * Test {@link CreateRadioButtons#getLineWidth(PDAnnotationWidget)}.
   *
   * <ul>
   *   <li>When {@link PDAnnotationWidget#PDAnnotationWidget()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CreateRadioButtons#getLineWidth(PDAnnotationWidget)}
   */
  @Test
  @DisplayName("Test getLineWidth(PDAnnotationWidget); when PDAnnotationWidget(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float CreateRadioButtons.getLineWidth(PDAnnotationWidget)"})
  void testGetLineWidth_whenPDAnnotationWidget_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, CreateRadioButtons.getLineWidth(new PDAnnotationWidget()));
  }

  /**
   * Test {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float,
   * float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle(PDAppearanceContentStream, float, float, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreateRadioButtons.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(IOException.class, () -> CreateRadioButtons.drawCircle(cs, 10.0f, 10.0f, 10.0f));
    verify(cs).moveTo(10.0f, 20.0f);
  }

  /**
   * Test {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float, float, float)}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceContentStream#closePath()}.
   * </ul>
   *
   * <p>Method under test: {@link CreateRadioButtons#drawCircle(PDAppearanceContentStream, float,
   * float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle(PDAppearanceContentStream, float, float, float); then calls closePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreateRadioButtons.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle_thenCallsClosePath() throws IOException {
    // Arrange
    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).closePath();
    doNothing()
        .when(cs)
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act
    CreateRadioButtons.drawCircle(cs, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1))
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    verify(cs).moveTo(10.0f, 20.0f);
  }
}
