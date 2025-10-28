package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;

class COSWriterObjectStreamDiffblueTest {
  /**
   * Method under test:
   * {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  void testPrepareStreamObject() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(
        new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, COSBoolean.FALSE);

    // Assert
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  void testPrepareStreamObject2() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(
        new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));

    // Act
    cosWriterObjectStream.prepareStreamObject(null, null);

    // Assert that nothing has changed
    assertTrue(cosWriterObjectStream.getPreparedKeys().isEmpty());
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  void testPrepareStreamObject3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  void testPrepareStreamObject4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION));
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    cosWriterObjectStream.prepareStreamObject(key, new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> preparedKeys = cosWriterObjectStream.getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    assertSame(key, preparedKeys.get(0));
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#prepareStreamObject(COSObjectKey, COSBase)}
   */
  @Test
  void testPrepareStreamObject5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION));

    // Act
    cosWriterObjectStream.prepareStreamObject(new COSObjectKey(1L, 1), null);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    assertTrue(cosWriterObjectStream.getPreparedKeys().isEmpty());
  }

  /**
   * Method under test: {@link COSWriterObjectStream#getPreparedKeys()}
   */
  @Test
  void testGetPreparedKeys() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new COSWriterObjectStream(
        new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))).getPreparedKeys()
            .isEmpty());
  }

  /**
   * Method under test: {@link COSWriterObjectStream#getPreparedKeys()}
   */
  @Test
  void testGetPreparedKeys2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<COSObjectKey> actualPreparedKeys = (new COSWriterObjectStream(new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION))).getPreparedKeys();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualPreparedKeys.isEmpty());
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}
   */
  @Test
  void testWriteObjectsToStream() throws IOException {
    // Arrange
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(
        new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION));
    COSStream stream = new COSStream();

    // Act
    COSStream actualWriteObjectsToStreamResult = cosWriterObjectStream.writeObjectsToStream(stream);

    // Assert
    assertEquals(5, stream.size());
    assertEquals(8L, stream.getLength());
    assertTrue(stream.hasData());
    assertSame(stream, actualWriteObjectsToStreamResult);
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#writeObjectsToStream(COSStream)}
   */
  @Test
  void testWriteObjectsToStream2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterObjectStream cosWriterObjectStream = new COSWriterObjectStream(new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION));
    COSStream stream = new COSStream();

    // Act
    COSStream actualWriteObjectsToStreamResult = cosWriterObjectStream.writeObjectsToStream(stream);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(5, stream.size());
    assertEquals(8L, stream.getLength());
    assertTrue(stream.hasData());
    assertSame(stream, actualWriteObjectsToStreamResult);
  }

  /**
   * Method under test:
   * {@link COSWriterObjectStream#COSWriterObjectStream(COSWriterCompressionPool)}
   */
  @Test
  void testNewCOSWriterObjectStream() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new COSWriterObjectStream(
        new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))).getPreparedKeys()
            .isEmpty());
  }
}
