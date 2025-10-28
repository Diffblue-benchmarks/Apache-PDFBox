package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SaveDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Save#Save(PDFStreamEngine)}
   *   <li>{@link Save#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("q", (new Save(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  void testProcess() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    save.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }

  /**
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  void testProcess2() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    save.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }

  /**
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  void testProcess3() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    save.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }
}
