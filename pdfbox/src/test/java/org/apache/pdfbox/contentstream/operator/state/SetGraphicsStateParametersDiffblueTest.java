package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetGraphicsStateParametersDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SetGraphicsStateParameters#SetGraphicsStateParameters(PDFStreamEngine)}
   *   <li>{@link SetGraphicsStateParameters#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("gs", (new SetGraphicsStateParameters(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetGraphicsStateParameters#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetGraphicsStateParameters#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetGraphicsStateParameters setGraphicsStateParameters = new SetGraphicsStateParameters(
        new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setGraphicsStateParameters.process(operator, new ArrayList<>()));
  }
}
