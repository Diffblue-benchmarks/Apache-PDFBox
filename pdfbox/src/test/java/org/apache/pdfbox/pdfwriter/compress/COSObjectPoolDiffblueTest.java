package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class COSObjectPoolDiffblueTest {
  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, COSBoolean.FALSE);

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, COSBoolean.FALSE);

    // Assert
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut3() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(null, COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(131072L, actualPutResult.getInternalHash());
    assertEquals(2L, actualPutResult.getNumber());
    assertEquals(2L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut4() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key,
        new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut5() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(1L, 1), null));
    assertEquals(1L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut6() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(null, COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(1238L, actualPutResult.getNumber());
    assertEquals(1238L, cosObjectPool.getHighestXRefObjectNumber());
    assertEquals(81133568L, actualPutResult.getInternalHash());
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut7() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertNull(cosObjectPool.put(new COSObjectKey(1237L, 1237, 1), COSBoolean.FALSE));
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut8() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key,
        new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237)));

    // Assert
    assertEquals(1237L, cosObjectPool.getHighestXRefObjectNumber());
    assertSame(key, actualPutResult);
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut9() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.TRUE);

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(new COSObjectKey(1237L, 1237, 1), COSBoolean.FALSE);

    // Assert
    assertEquals(-1, actualPutResult.getStreamIndex());
    assertEquals(0, actualPutResult.getGeneration());
    assertEquals(1238L, actualPutResult.getNumber());
    assertEquals(1238L, cosObjectPool.getHighestXRefObjectNumber());
    assertEquals(81133568L, actualPutResult.getInternalHash());
  }

  /**
   * Method under test: {@link COSObjectPool#put(COSObjectKey, COSBase)}
   */
  @Test
  void testPut10() throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1237L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualPutResult = cosObjectPool.put(key, new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(key, actualPutResult);
  }

  /**
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new COSObjectPool(1L)).getKey(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  void testGetKey2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  void testGetKey3() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosObjectPool.put(key, COSBoolean.FALSE);

    // Act and Assert
    assertSame(key, cosObjectPool.getKey(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Method under test: {@link COSObjectPool#getKey(COSBase)}
   */
  @Test
  void testGetKey4() throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1237L);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSObjectKey actualKey = cosObjectPool.getKey(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualKey);
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertFalse((new COSObjectPool(1L)).contains(COSBoolean.FALSE));
    assertFalse((new COSObjectPool(1L)).contains((COSObjectKey) null));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  void testContains2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(COSBoolean.FALSE));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  void testContains3() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertFalse(cosObjectPool.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  void testContains4() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1237L, 1237), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237))));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSBase)}
   */
  @Test
  void testContains5() throws IOException {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1237L);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualContainsResult = cosObjectPool.contains(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  void testContains6() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertFalse(cosObjectPool.contains(new COSObjectKey(1L, 1)));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  void testContains7() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);
    cosObjectPool.put(new COSObjectKey(5L, 5), COSBoolean.FALSE);

    // Act and Assert
    assertTrue(cosObjectPool.contains(new COSObjectKey(1L, 1)));
  }

  /**
   * Method under test: {@link COSObjectPool#contains(COSObjectKey)}
   */
  @Test
  void testContains8() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(5L, 5), object);

    // Act
    boolean actualContainsResult = cosObjectPool.contains(new COSObjectKey(1L, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualContainsResult);
  }

  /**
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);

    // Act and Assert
    assertNull(cosObjectPool.getObject(new COSObjectKey(1L, 1)));
  }

  /**
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject2() {
    // Arrange
    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), COSBoolean.FALSE);

    // Act
    COSBase actualObject = cosObjectPool.getObject(new COSObjectKey(1L, 1));

    // Assert
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject3() {
    // Arrange, Act and Assert
    assertNull((new COSObjectPool(1L)).getObject(null));
  }

  /**
   * Method under test: {@link COSObjectPool#getObject(COSObjectKey)}
   */
  @Test
  void testGetObject4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    COSObjectPool cosObjectPool = new COSObjectPool(1L);
    cosObjectPool.put(new COSObjectKey(1L, 1), object);

    // Act
    COSBase actualObject = cosObjectPool.getObject(new COSObjectKey(1L, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(object, actualObject);
  }

  /**
   * Method under test: {@link COSObjectPool#getHighestXRefObjectNumber()}
   */
  @Test
  void testGetHighestXRefObjectNumber() {
    // Arrange, Act and Assert
    assertEquals(1L, (new COSObjectPool(1L)).getHighestXRefObjectNumber());
  }

  /**
   * Method under test: {@link COSObjectPool#COSObjectPool(long)}
   */
  @Test
  void testNewCOSObjectPool() {
    // Arrange, Act and Assert
    assertEquals(1L, (new COSObjectPool(1L)).getHighestXRefObjectNumber());
  }
}
