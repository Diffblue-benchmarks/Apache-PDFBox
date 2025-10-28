package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class ContentStreamWriterDiffblueTest {
  /**
   * Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  void testWriteToken() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ContentStreamWriter(new ByteArrayOutputStream(1))).writeToken((COSBase) null));
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  void testWriteToken2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    COSArray base = new COSArray();
    base.add(object);

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeToken(base));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  void testWriteTokens() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  void testWriteTokens2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  void testWriteTokens3() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  void testWriteTokens4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ContentStreamWriter(new ByteArrayOutputStream(1))).writeTokens("Tokens"));
  }

  /**
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  void testWriteTokens5() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(new COSDocument()));
  }
}
