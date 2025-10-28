package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class ShowTextLineAndSpaceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShowTextLineAndSpace#ShowTextLineAndSpace(PDFStreamEngine)}
   *   <li>{@link ShowTextLineAndSpace#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("\"", (new ShowTextLineAndSpace(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link ShowTextLineAndSpace#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    ShowTextLineAndSpace showTextLineAndSpace = new ShowTextLineAndSpace(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> showTextLineAndSpace.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link ShowTextLineAndSpace#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    ShowTextLineAndSpace showTextLineAndSpace = new ShowTextLineAndSpace(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> showTextLineAndSpace.process(operator, arguments));
  }

  /**
   * Method under test: {@link ShowTextLineAndSpace#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    ShowTextLineAndSpace showTextLineAndSpace = new ShowTextLineAndSpace(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> showTextLineAndSpace.process(operator, arguments));
  }
}
