package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class PNGConverterDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PNGConverter.Chunk}
   */
  @Test
  void testChunkNewChunk() {
    // Arrange and Act
    PNGConverter.Chunk actualChunk = new PNGConverter.Chunk();

    // Assert
    assertNull(actualChunk.bytes);
    assertEquals(0, actualChunk.chunkType);
    assertEquals(0, actualChunk.crc);
    assertEquals(0, actualChunk.length);
    assertEquals(0, actualChunk.start);
  }

  /**
   * Method under test: {@link PNGConverter#convertPNGImage(PDDocument, byte[])}
   */
  @Test
  void testConvertPNGImage() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act and Assert
    assertNull(PNGConverter.convertPNGImage(doc, "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link PNGConverter#convertPNGImage(PDDocument, byte[])}
   */
  @Test
  void testConvertPNGImage2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualConvertPNGImageResult = PNGConverter.convertPNGImage(doc, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualConvertPNGImageResult);
  }

  /**
   * Method under test: {@link PNGConverter#convertPNGImage(PDDocument, byte[])}
   */
  @Test
  void testConvertPNGImage3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDImageXObject actualConvertPNGImageResult = PNGConverter.convertPNGImage(new PDDocument(streamCacheCreateFunction),
        new byte[]{'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20, 'A', 20,
            'A', 20});

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualConvertPNGImageResult);
  }

  /**
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  void testMapPNGRenderIntent() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(3);

    // Assert
    assertEquals("AbsoluteColorimetric", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  void testMapPNGRenderIntent2() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(0);

    // Assert
    assertEquals("Perceptual", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  void testMapPNGRenderIntent3() {
    // Arrange and Act
    COSName actualMapPNGRenderIntentResult = PNGConverter.mapPNGRenderIntent(2);

    // Assert
    assertEquals("Saturation", actualMapPNGRenderIntentResult.getName());
    assertNull(actualMapPNGRenderIntentResult.getKey());
    assertFalse(actualMapPNGRenderIntentResult.isDirect());
    assertFalse(actualMapPNGRenderIntentResult.isEmpty());
  }

  /**
   * Method under test: {@link PNGConverter#mapPNGRenderIntent(int)}
   */
  @Test
  void testMapPNGRenderIntent4() {
    // Arrange, Act and Assert
    assertNull(PNGConverter.mapPNGRenderIntent(-1));
  }

  /**
   * Method under test:
   * {@link PNGConverter#checkConverterState(PNGConverter.PNGConverterState)}
   */
  @Test
  void testCheckConverterState() {
    // Arrange, Act and Assert
    assertFalse(PNGConverter.checkConverterState(new PNGConverter.PNGConverterState()));
    assertFalse(PNGConverter.checkConverterState(null));
  }

  /**
   * Method under test: {@link PNGConverter#checkChunkSane(PNGConverter.Chunk)}
   */
  @Test
  void testCheckChunkSane() {
    // Arrange, Act and Assert
    assertTrue(PNGConverter.checkChunkSane(null));
  }

  /**
   * Method under test: {@link PNGConverter#crc(byte[], int, int)}
   */
  @Test
  void testCrc() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(-39806785, PNGConverter.crc("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PNGConverter.PNGConverterState}
   */
  @Test
  void testPNGConverterStateNewPNGConverterState() {
    // Arrange, Act and Assert
    assertTrue((new PNGConverter.PNGConverterState()).IDATs.isEmpty());
  }
}
