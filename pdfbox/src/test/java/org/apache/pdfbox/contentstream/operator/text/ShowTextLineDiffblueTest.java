package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ShowTextLineDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShowTextLine#ShowTextLine(PDFStreamEngine)}
   *   <li>{@link ShowTextLine#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("'", (new ShowTextLine(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link ShowTextLine#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    ShowTextLine showTextLine = new ShowTextLine(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    showTextLine.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context, atLeast(1)).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
  }

  /**
   * Method under test: {@link ShowTextLine#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    ShowTextLine showTextLine = new ShowTextLine(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    showTextLine.process(operator, arguments);

    // Assert that nothing has changed
    verify(context, atLeast(1)).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
  }

  /**
   * Method under test: {@link ShowTextLine#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    ShowTextLine showTextLine = new ShowTextLine(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    showTextLine.process(operator, arguments);

    // Assert that nothing has changed
    verify(context, atLeast(1)).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
  }
}
