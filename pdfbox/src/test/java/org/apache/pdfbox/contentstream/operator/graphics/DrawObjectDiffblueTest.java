package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class DrawObjectDiffblueTest {
  /**
   * Method under test: {@link DrawObject#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    DrawObject drawObject = new DrawObject(null);
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
    DrawObject drawObject = new DrawObject(null);
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(cosDocument);

    // Act
    drawObject.process(operator, operands);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }
}
