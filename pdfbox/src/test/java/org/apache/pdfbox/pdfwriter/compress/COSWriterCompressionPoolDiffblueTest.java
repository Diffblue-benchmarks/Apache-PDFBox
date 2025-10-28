package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.encryption.PDEncryption;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.Test;

class COSWriterCompressionPoolDiffblueTest {
  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .contains(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).contains(COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).contains(COSBoolean.TRUE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).contains(COSFloat.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).contains(COSInteger.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).contains(COSName.A);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool
        .contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool.contains(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool.contains(new COSString("Text", true));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool
        .contains(new COSObject(COSFloat.ONE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool
        .contains(new COSObject(COSInteger.ONE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    boolean actualContainsResult = cosWriterCompressionPool
        .contains(new COSObject(COSName.A, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#contains(COSBase)}
   */
  @Test
  void testContains13() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    boolean actualContainsResult = cosWriterCompressionPool
        .contains(new COSObject(object, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey() throws IOException {
    // Arrange, Act and Assert
    assertNull((new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getKey(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getKey(COSBoolean.FALSE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getKey(COSBoolean.TRUE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getKey(COSFloat.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getKey(COSInteger.ONE);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getKey(COSName.A);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool
        .getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool.getKey(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey9() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool.getKey(new COSString("Text", true));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey10() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool
        .getKey(new COSObject(COSFloat.ONE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey11() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool
        .getKey(new COSObject(COSInteger.ONE, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey12() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool.getKey(new COSObject(COSName.A, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getKey(COSBase)}
   */
  @Test
  void testGetKey13() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    COSObjectKey actualKey = cosWriterCompressionPool.getKey(new COSObject(object, new COSObjectKey(1237L, 1237)));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act and Assert
    assertNull(cosWriterCompressionPool.getObject(new COSObjectKey(1L, 1)));
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    COSBase actualObject = cosWriterCompressionPool.getObject(new COSObjectKey(1L, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualObject);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSBase actualObject = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getObject(null);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualObject);
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#getHighestXRefObjectNumber()}
   */
  @Test
  void testGetHighestXRefObjectNumber() throws IOException {
    // Arrange, Act and Assert
    assertEquals(2L, (new COSWriterCompressionPool(new PDDocument(), CompressParameters.DEFAULT_COMPRESSION))
        .getHighestXRefObjectNumber());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#getHighestXRefObjectNumber()}
   */
  @Test
  void testGetHighestXRefObjectNumber2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    long actualHighestXRefObjectNumber = (new COSWriterCompressionPool(new PDDocument(streamCacheCreateFunction),
        CompressParameters.DEFAULT_COMPRESSION)).getHighestXRefObjectNumber();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(2L, actualHighestXRefObjectNumber);
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#createObjectStreams()}
   */
  @Test
  void testCreateObjectStreams() throws IOException {
    // Arrange and Act
    List<COSWriterObjectStream> actualCreateObjectStreamsResult = (new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION)).createObjectStreams();

    // Assert
    assertEquals(1, actualCreateObjectStreamsResult.size());
    List<COSObjectKey> preparedKeys = actualCreateObjectStreamsResult.get(0).getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    COSObjectKey getResult = preparedKeys.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(2L, getResult.getNumber());
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#createObjectStreams()}
   */
  @Test
  void testCreateObjectStreams2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    List<COSWriterObjectStream> actualCreateObjectStreamsResult = (new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION)).createObjectStreams();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualCreateObjectStreamsResult.size());
    List<COSObjectKey> preparedKeys = actualCreateObjectStreamsResult.get(0).getPreparedKeys();
    assertEquals(1, preparedKeys.size());
    COSObjectKey getResult = preparedKeys.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(2L, getResult.getNumber());
  }

  /**
   * Method under test: {@link COSWriterCompressionPool#createObjectStreams()}
   */
  @Test
  void testCreateObjectStreams3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    List<COSWriterObjectStream> actualCreateObjectStreamsResult = (new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION)).createObjectStreams();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1, actualCreateObjectStreamsResult.size());
    List<COSObjectKey> preparedKeys = actualCreateObjectStreamsResult.get(0).getPreparedKeys();
    assertEquals(2, preparedKeys.size());
    COSObjectKey getResult = preparedKeys.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = preparedKeys.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(196608L, getResult2.getInternalHash());
    assertEquals(2L, getResult.getNumber());
    assertEquals(3L, getResult2.getNumber());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link COSWriterCompressionPool#getObjectStreamObjects()}
   *   <li>{@link COSWriterCompressionPool#getTopLevelObjects()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSWriterCompressionPool cosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Act
    List<COSObjectKey> actualObjectStreamObjects = cosWriterCompressionPool.getObjectStreamObjects();
    List<COSObjectKey> actualTopLevelObjects = cosWriterCompressionPool.getTopLevelObjects();

    // Assert
    assertEquals(1, actualObjectStreamObjects.size());
    COSObjectKey getResult = actualObjectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    assertEquals(1, actualTopLevelObjects.size());
    COSObjectKey getResult2 = actualTopLevelObjects.get(0);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool() throws IOException {
    // Arrange and Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(new PDDocument(),
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(1, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult2 = topLevelObjects.get(0);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(2L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(1, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult2 = topLevelObjects.get(0);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(2L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult3 = topLevelObjects.get(0);
    assertEquals(-1, getResult3.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(196608L, getResult2.getInternalHash());
    assertEquals(1L, getResult3.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(3L, getResult2.getNumber());
    assertEquals(3L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult3.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(3, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    COSObjectKey getResult3 = objectStreamObjects.get(2);
    assertEquals(-1, getResult3.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult4 = topLevelObjects.get(0);
    assertEquals(-1, getResult4.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    assertEquals(0, getResult4.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(196608L, getResult2.getInternalHash());
    assertEquals(1L, getResult4.getNumber());
    assertEquals(262144L, getResult3.getInternalHash());
    assertEquals(2L, getResult.getNumber());
    assertEquals(3L, getResult2.getNumber());
    assertEquals(4L, getResult3.getNumber());
    assertEquals(4L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult4.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.setEncryptionDictionary(new PDEncryption());
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult3 = topLevelObjects.get(0);
    assertEquals(-1, getResult3.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(196608L, getResult2.getInternalHash());
    assertEquals(1L, getResult3.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(3L, getResult2.getNumber());
    assertEquals(3L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult3.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(2, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult3 = topLevelObjects.get(0);
    assertEquals(-1, getResult3.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult3.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(327680L, getResult2.getInternalHash());
    assertEquals(5L, getResult2.getNumber());
    assertEquals(5L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult3.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(
        new PDDocument(streamCacheCreateFunction), null);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(1, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(1, topLevelObjects.size());
    COSObjectKey getResult2 = topLevelObjects.get(0);
    assertEquals(-1, getResult2.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(1L, getResult2.getNumber());
    assertEquals(2L, getResult.getNumber());
    assertEquals(2L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
    assertEquals(65536L, getResult2.getInternalHash());
  }

  /**
   * Method under test:
   * {@link COSWriterCompressionPool#COSWriterCompressionPool(PDDocument, CompressParameters)}
   */
  @Test
  void testNewCOSWriterCompressionPool8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    document.addSignature(new PDSignature());

    // Act
    COSWriterCompressionPool actualCosWriterCompressionPool = new COSWriterCompressionPool(document,
        CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    verify(streamCacheCreateFunction).create();
    List<COSObjectKey> objectStreamObjects = actualCosWriterCompressionPool.getObjectStreamObjects();
    assertEquals(5, objectStreamObjects.size());
    COSObjectKey getResult = objectStreamObjects.get(0);
    assertEquals(-1, getResult.getStreamIndex());
    COSObjectKey getResult2 = objectStreamObjects.get(1);
    assertEquals(-1, getResult2.getStreamIndex());
    COSObjectKey getResult3 = objectStreamObjects.get(2);
    assertEquals(-1, getResult3.getStreamIndex());
    COSObjectKey getResult4 = objectStreamObjects.get(3);
    assertEquals(-1, getResult4.getStreamIndex());
    COSObjectKey getResult5 = objectStreamObjects.get(4);
    assertEquals(-1, getResult5.getStreamIndex());
    List<COSObjectKey> topLevelObjects = actualCosWriterCompressionPool.getTopLevelObjects();
    assertEquals(2, topLevelObjects.size());
    COSObjectKey getResult6 = topLevelObjects.get(0);
    assertEquals(-1, getResult6.getStreamIndex());
    COSObjectKey getResult7 = topLevelObjects.get(1);
    assertEquals(-1, getResult7.getStreamIndex());
    assertEquals(0, getResult.getGeneration());
    assertEquals(0, getResult2.getGeneration());
    assertEquals(0, getResult3.getGeneration());
    assertEquals(0, getResult4.getGeneration());
    assertEquals(0, getResult5.getGeneration());
    assertEquals(0, getResult6.getGeneration());
    assertEquals(0, getResult7.getGeneration());
    assertEquals(131072L, getResult.getInternalHash());
    assertEquals(196608L, getResult2.getInternalHash());
    assertEquals(1L, getResult6.getNumber());
    assertEquals(262144L, getResult3.getInternalHash());
    assertEquals(2L, getResult.getNumber());
    assertEquals(327680L, getResult4.getInternalHash());
    assertEquals(393216L, getResult5.getInternalHash());
    assertEquals(3L, getResult2.getNumber());
    assertEquals(458752L, getResult7.getInternalHash());
    assertEquals(4L, getResult3.getNumber());
    assertEquals(5L, getResult4.getNumber());
    assertEquals(65536L, getResult6.getInternalHash());
    assertEquals(6L, getResult5.getNumber());
    assertEquals(7L, getResult7.getNumber());
    assertEquals(7L, actualCosWriterCompressionPool.getHighestXRefObjectNumber());
  }
}
