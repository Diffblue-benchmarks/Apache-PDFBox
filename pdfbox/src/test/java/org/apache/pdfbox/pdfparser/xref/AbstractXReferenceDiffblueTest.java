package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class AbstractXReferenceDiffblueTest {
  /**
   * Method under test: {@link AbstractXReference#getType()}
   */
  @Test
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals(XReferenceType.FREE, FreeXReference.NULL_ENTRY.getType());
  }

  /**
   * Method under test: {@link AbstractXReference#getFirstColumnValue()}
   */
  @Test
  void testGetFirstColumnValue() {
    // Arrange, Act and Assert
    assertEquals(0L, FreeXReference.NULL_ENTRY.getFirstColumnValue());
  }

  /**
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, FreeXReference.NULL_ENTRY.compareTo(FreeXReference.NULL_ENTRY));
    assertEquals(1, FreeXReference.NULL_ENTRY.compareTo(null));
    assertEquals(-1, (new FreeXReference(null, 1L)).compareTo(FreeXReference.NULL_ENTRY));
    assertEquals(1, FreeXReference.NULL_ENTRY.compareTo(new FreeXReference(null, 1L)));
  }

  /**
   * Method under test: {@link AbstractXReference#compareTo(XReferenceEntry)}
   */
  @Test
  void testCompareTo2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    // Act
    int actualCompareToResult = FreeXReference.NULL_ENTRY
        .compareTo(new NormalXReference(1L, new COSObjectKey(1L, 1), object));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, actualCompareToResult);
  }
}
