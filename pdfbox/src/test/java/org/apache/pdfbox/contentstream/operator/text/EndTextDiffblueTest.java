package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EndTextDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EndText#EndText(PDFStreamEngine)}
   *   <li>{@link EndText#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("ET", (new EndText(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link EndText#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).endText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    EndText endText = new EndText(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    endText.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).endText();
    verify(context).setTextLineMatrix(isNull());
    verify(context).setTextMatrix(isNull());
  }

  /**
   * Method under test: {@link EndText#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).endText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    EndText endText = new EndText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    endText.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).endText();
    verify(context).setTextLineMatrix(isNull());
    verify(context).setTextMatrix(isNull());
  }

  /**
   * Method under test: {@link EndText#process(Operator, List)}
   */
  @Test
  void testProcess3() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).endText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    EndText endText = new EndText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    endText.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).endText();
    verify(context).setTextLineMatrix(isNull());
    verify(context).setTextMatrix(isNull());
  }

  /**
   * Method under test: {@link EndText#process(Operator, List)}
   */
  @Test
  void testProcess4() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException("foo")).when(context).endText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    EndText endText = new EndText(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(IOException.class, () -> endText.process(operator, new ArrayList<>()));
    verify(context).endText();
    verify(context).setTextLineMatrix(isNull());
    verify(context).setTextMatrix(isNull());
  }
}
