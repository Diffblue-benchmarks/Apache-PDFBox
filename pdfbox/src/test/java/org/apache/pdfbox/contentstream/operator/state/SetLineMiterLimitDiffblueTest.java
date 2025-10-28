package org.apache.pdfbox.contentstream.operator.state;

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

class SetLineMiterLimitDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SetLineMiterLimit#SetLineMiterLimit(PDFStreamEngine)}
   *   <li>{@link SetLineMiterLimit#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("M", (new SetLineMiterLimit(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link SetLineMiterLimit#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    SetLineMiterLimit setLineMiterLimit = new SetLineMiterLimit(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setLineMiterLimit.process(operator, new ArrayList<>()));
  }

  /**
   * Method under test: {@link SetLineMiterLimit#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    SetLineMiterLimit setLineMiterLimit = new SetLineMiterLimit(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosDocument);

    // Act
    setLineMiterLimit.process(operator, arguments);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }
}
