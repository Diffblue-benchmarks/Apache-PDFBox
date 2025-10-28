package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.Test;

class CurveToDiffblueTest {
  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess4() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess5() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess6() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }

  /**
   * Method under test: {@link CurveTo#process(Operator, List)}
   */
  @Test
  void testProcess7() throws IOException {
    // Arrange
    CurveTo curveTo = new CurveTo(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveTo.process(operator, operands));
  }
}
