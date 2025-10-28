package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetCharSpacingDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetCharSpacing#SetCharSpacing(PDFStreamEngine)}
   *   <li>{@link SetCharSpacing#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tc", (new SetCharSpacing(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link SetCharSpacing#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    SetCharSpacing setCharSpacing = new SetCharSpacing(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setCharSpacing.process(operator, new ArrayList<>()));
  }
}
