package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetTextRenderingModeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetTextRenderingMode#SetTextRenderingMode(PDFStreamEngine)}
   *   <li>{@link SetTextRenderingMode#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tr", (new SetTextRenderingMode(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode = new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setTextRenderingMode.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link SetTextRenderingMode#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    SetTextRenderingMode setTextRenderingMode = new SetTextRenderingMode(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosDocument);

    // Act
    setTextRenderingMode.process(operator, arguments);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }
}
