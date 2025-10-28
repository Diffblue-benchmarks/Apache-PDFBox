package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class DrawObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DrawObject#DrawObject(PDFStreamEngine)}
   *   <li>{@link DrawObject#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDFMarkedContentExtractor context = new PDFMarkedContentExtractor();

    // Act
    DrawObject actualDrawObject = new DrawObject(context);

    // Assert
    assertEquals(OperatorName.DRAW_OBJECT, actualDrawObject.getName());
    assertSame(context, actualDrawObject.getContext());
  }

  /**
   * Method under test: {@link DrawObject#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> drawObject.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link DrawObject#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosDocument);

    // Act
    drawObject.process(operator, arguments);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }
}
