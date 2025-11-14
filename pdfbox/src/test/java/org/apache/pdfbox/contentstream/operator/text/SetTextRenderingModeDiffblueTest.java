package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetTextRenderingModeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetTextRenderingMode#SetTextRenderingMode(PDFStreamEngine)}
   *   <li>{@link SetTextRenderingMode#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetTextRenderingMode.<init>(PDFStreamEngine)",
    "java.lang.String SetTextRenderingMode.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tr", new SetTextRenderingMode(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is {@link Float#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat(float) with aFloat is NEGATIVE_INFINITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsNegative_infinity() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(Float.NEGATIVE_INFINITY));

    // Act and Assert
    assertDoesNotThrow(() -> setTextRenderingMode.process(operator, arguments));
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)} with aFloat is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen()
      throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertDoesNotThrow(() -> setTextRenderingMode.process(operator, arguments));
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> setTextRenderingMode.process(operator, arguments));
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow2() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> setTextRenderingMode.process(operator, arguments));
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given forty-two.
   *   <li>When {@link ArrayList#ArrayList()} add forty-two.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given forty-two; when ArrayList() add forty-two; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_givenFortyTwo_whenArrayListAddFortyTwo_thenDoesNotThrow() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.get(42L));

    // Act and Assert
    assertDoesNotThrow(() -> setTextRenderingMode.process(operator, arguments));
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode =
        new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setTextRenderingMode.process(operator, new ArrayList<>()));
  }
}
