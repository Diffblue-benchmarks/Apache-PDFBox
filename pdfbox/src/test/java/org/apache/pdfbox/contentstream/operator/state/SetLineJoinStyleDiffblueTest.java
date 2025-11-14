package org.apache.pdfbox.contentstream.operator.state;

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
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetLineJoinStyleDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetLineJoinStyle#SetLineJoinStyle(PDFStreamEngine)}
   *   <li>{@link SetLineJoinStyle#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetLineJoinStyle.<init>(PDFStreamEngine)",
    "java.lang.String SetLineJoinStyle.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("j", new SetLineJoinStyle(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetLineJoinStyle#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SetLineJoinStyle#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineJoinStyle.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow() throws IOException {
    // Arrange
    SetLineJoinStyle setLineJoinStyle = new SetLineJoinStyle(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> setLineJoinStyle.process(operator, arguments));
  }

  /**
   * Test {@link SetLineJoinStyle#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link SetLineJoinStyle#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineJoinStyle.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow2() throws IOException {
    // Arrange
    SetLineJoinStyle setLineJoinStyle = new SetLineJoinStyle(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> setLineJoinStyle.process(operator, arguments));
  }

  /**
   * Test {@link SetLineJoinStyle#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineJoinStyle#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineJoinStyle.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetLineJoinStyle setLineJoinStyle = new SetLineJoinStyle(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineJoinStyle.process(operator, new ArrayList<>()));
  }
}
