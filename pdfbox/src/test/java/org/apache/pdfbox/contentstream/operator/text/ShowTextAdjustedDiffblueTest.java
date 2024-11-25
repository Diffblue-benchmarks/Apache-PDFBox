package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ShowTextAdjustedDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShowTextAdjusted#ShowTextAdjusted(PDFStreamEngine)}
   *   <li>{@link ShowTextAdjusted#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("TJ", (new ShowTextAdjusted(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#getTextMatrix()}
   * return {@code null}.</li>
   *   <li>Then calls {@link PDFStreamEngine#getTextMatrix()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDFStreamEngine getTextMatrix() return 'null'; then calls getTextMatrix()")
  void testProcess_givenPDFStreamEngineGetTextMatrixReturnNull_thenCallsGetTextMatrix() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getTextMatrix()).thenReturn(null);
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act
    showTextAdjusted.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).getTextMatrix();
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDFStreamEngine}
   * {@link PDFStreamEngine#showTextStrings(COSArray)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDFStreamEngine showTextStrings(COSArray) does nothing")
  void testProcess_givenPDFStreamEngineShowTextStringsDoesNothing() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).showTextStrings(Mockito.<COSArray>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act
    showTextAdjusted.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).getTextMatrix();
    verify(context).showTextStrings(isA(COSArray.class));
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then throw IOException")
  void testProcess_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException("foo")).when(context).showTextStrings(Mockito.<COSArray>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> showTextAdjusted.process(operator, arguments));
    verify(context).getTextMatrix();
    verify(context).showTextStrings(isA(COSArray.class));
  }
}
