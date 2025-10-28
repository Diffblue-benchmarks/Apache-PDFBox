package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.Test;

class SetNonStrokingColorSpaceDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SetNonStrokingColorSpace#SetNonStrokingColorSpace(PDFStreamEngine)}
   *   <li>{@link SetNonStrokingColorSpace#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("cs", (new SetNonStrokingColorSpace(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Method under test: {@link SetNonStrokingColorSpace#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    SetNonStrokingColorSpace setNonStrokingColorSpace = new SetNonStrokingColorSpace(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosDocument);

    // Act
    setNonStrokingColorSpace.process(operator, arguments);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
  }
}
