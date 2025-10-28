package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Iterator;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PDFieldTreeDiffblueTest {
  /**
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  void testIterator2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).iterator();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  void testNewPDFieldTree() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  void testNewPDFieldTree2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(
        new PDAcroForm(new PDDocument(streamCacheCreateFunction)))).iterator();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIteratorResult.hasNext());
  }
}
