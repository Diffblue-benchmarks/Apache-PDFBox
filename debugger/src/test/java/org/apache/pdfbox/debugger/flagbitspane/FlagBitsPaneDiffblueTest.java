package org.apache.pdfbox.debugger.flagbitspane;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class FlagBitsPaneDiffblueTest {
  /**
   * Method under test:
   * {@link FlagBitsPane#FlagBitsPane(PDDocument, COSDictionary, COSName)}
   */
  @Test
  void testNewFlagBitsPane() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    new FlagBitsPane(document, new COSDictionary(), null);

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
