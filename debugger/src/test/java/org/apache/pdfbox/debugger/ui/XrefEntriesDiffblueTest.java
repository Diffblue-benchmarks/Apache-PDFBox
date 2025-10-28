package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class XrefEntriesDiffblueTest {
  /**
   * Method under test: {@link XrefEntries#getXrefEntryCount()}
   */
  @Test
  void testGetXrefEntryCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new XrefEntries(new PDDocument())).getXrefEntryCount());
  }

  /**
   * Method under test: {@link XrefEntries#getXrefEntryCount()}
   */
  @Test
  void testGetXrefEntryCount2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    int actualXrefEntryCount = (new XrefEntries(new PDDocument(streamCacheCreateFunction))).getXrefEntryCount();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualXrefEntryCount);
  }

  /**
   * Method under test: {@link XrefEntries#indexOf(XrefEntry)}
   */
  @Test
  void testIndexOf() {
    // Arrange
    XrefEntries xrefEntries = new XrefEntries(new PDDocument());
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(0, xrefEntries.indexOf(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Method under test: {@link XrefEntries#indexOf(XrefEntry)}
   */
  @Test
  void testIndexOf2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    XrefEntries xrefEntries = new XrefEntries(new PDDocument(streamCacheCreateFunction));
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act
    int actualIndexOfResult = xrefEntries
        .indexOf(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualIndexOfResult);
  }

  /**
   * Method under test: {@link XrefEntries#XrefEntries(PDDocument)}
   */
  @Test
  void testNewXrefEntries() {
    // Arrange, Act and Assert
    assertEquals(0, (new XrefEntries(new PDDocument())).getXrefEntryCount());
  }

  /**
   * Method under test: {@link XrefEntries#XrefEntries(PDDocument)}
   */
  @Test
  void testNewXrefEntries2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    XrefEntries actualXrefEntries = new XrefEntries(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualXrefEntries.getXrefEntryCount());
  }

  /**
   * Method under test: {@link XrefEntries#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(XrefEntries.PATH, (new XrefEntries(new PDDocument())).toString());
  }
}
