package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class RestoreDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Restore#Restore(PDFStreamEngine)}
   *   <li>{@link Restore#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Q", (new Restore(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, arguments));
  }

  /**
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, arguments));
  }
}
