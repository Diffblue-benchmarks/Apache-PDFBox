package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetTextRenderingModeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetTextRenderingMode#SetTextRenderingMode(PDFStreamEngine)}
   *   <li>{@link SetTextRenderingMode#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetTextRenderingMode.<init>(PDFStreamEngine)",
      "java.lang.String SetTextRenderingMode.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tr", (new SetTextRenderingMode(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetTextRenderingMode#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetTextRenderingMode.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode = new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setTextRenderingMode.process(operator, new ArrayList<>()));
  }
}
