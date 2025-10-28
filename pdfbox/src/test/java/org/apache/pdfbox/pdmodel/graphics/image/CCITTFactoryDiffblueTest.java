package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class CCITTFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateFromImage() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> CCITTFactory.createFromImage(document, new BufferedImage(1, 1, 1)));
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  void testCreateFromByteArray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  void testCreateFromByteArray2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "XXAXAXAX".getBytes("UTF-8")));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  void testCreateFromByteArray3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act and Assert
    assertThrows(IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(streamCacheCreateFunction), new byte[]{}));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  void testCreateFromByteArray4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  void testCreateFromByteArray5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IOException.class, () -> CCITTFactory.createFromByteArray(document, "XXAXAXAX".getBytes("UTF-8"), 10));
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  void testCreateFromByteArray6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act and Assert
    assertThrows(IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(streamCacheCreateFunction), new byte[]{}, 10));
    verify(streamCacheCreateFunction).create();
  }
}
