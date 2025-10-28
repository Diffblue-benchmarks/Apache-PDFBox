package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.junit.jupiter.api.Test;

class ShadingFillDiffblueTest {
  /**
   * Method under test: {@link ShadingFill#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    ShadingFill shadingFill = new ShadingFill(null);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> shadingFill.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link ShadingFill#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    ShadingFill shadingFill = new ShadingFill(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> shadingFill.process(operator, operands));
  }

  /**
   * Method under test: {@link ShadingFill#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    ShadingFill shadingFill = new ShadingFill(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> shadingFill.process(operator, operands));
  }
}
