package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class ConcatenateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Concatenate#Concatenate(PDFStreamEngine)}
   *   <li>{@link Concatenate#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("cm", (new Concatenate(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess4() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess5() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess6() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess7() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  void testProcess8() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }
}
