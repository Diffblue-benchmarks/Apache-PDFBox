package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetLineDashPatternDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetLineDashPattern#SetLineDashPattern(PDFStreamEngine)}
   *   <li>{@link SetLineDashPattern#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d", (new SetLineDashPattern(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess2() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess3() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess4() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess5() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess6() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess7() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSDictionary());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess8() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess9() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2)));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  void testProcess10() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }
}
