package org.apache.pdfbox.pdfparser.xref;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class NormalXReferenceDiffblueTest {
  /**
   * Method under test: {@link NormalXReference#getSecondColumnValue()}
   */
  @Test
  void testGetSecondColumnValue() {
    // Arrange, Act and Assert
    assertEquals(1L, (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).getSecondColumnValue());
  }

  /**
   * Method under test: {@link NormalXReference#getSecondColumnValue()}
   */
  @Test
  void testGetSecondColumnValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    // Act
    long actualSecondColumnValue = (new NormalXReference(1L, new COSObjectKey(1L, 1), object)).getSecondColumnValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1L, actualSecondColumnValue);
  }

  /**
   * Method under test: {@link NormalXReference#getThirdColumnValue()}
   */
  @Test
  void testGetThirdColumnValue() {
    // Arrange, Act and Assert
    assertEquals(1L, (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).getThirdColumnValue());
  }

  /**
   * Method under test: {@link NormalXReference#getThirdColumnValue()}
   */
  @Test
  void testGetThirdColumnValue2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    // Act
    long actualThirdColumnValue = (new NormalXReference(1L, new COSObjectKey(1L, 1), object)).getThirdColumnValue();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1L, actualThirdColumnValue);
  }

  /**
   * Method under test: {@link NormalXReference#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("NormalReference{ key=1 1 R, type=1, byteOffset=1 }",
        (new NormalXReference(1L, new COSObjectKey(1L, 1), COSBoolean.FALSE)).toString());
  }

  /**
   * Method under test: {@link NormalXReference#toString()}
   */
  @Test
  void testToString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    // Act
    String actualToStringResult = (new NormalXReference(1L, new COSObjectKey(1L, 1), object)).toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("NormalReference{ key=1 1 R, type=1, byteOffset=1 }", actualToStringResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NormalXReference#getByteOffset()}
   *   <li>{@link NormalXReference#getObject()}
   *   <li>{@link NormalXReference#getReferencedKey()}
   *   <li>{@link NormalXReference#isObjectStream()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    NormalXReference normalXReference = new NormalXReference(1L, key, COSBoolean.FALSE);

    // Act
    long actualByteOffset = normalXReference.getByteOffset();
    COSBase actualObject = normalXReference.getObject();
    COSObjectKey actualReferencedKey = normalXReference.getReferencedKey();

    // Assert
    assertEquals(1L, actualByteOffset);
    assertFalse(normalXReference.isObjectStream());
    assertSame(key, actualReferencedKey);
    assertSame(((COSBoolean) actualObject).FALSE, actualObject);
  }

  /**
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  void testNewNormalXReference() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSBoolean object = COSBoolean.FALSE;

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    assertEquals(1L, actualNormalXReference.getFirstColumnValue());
    assertEquals(1L, actualNormalXReference.getByteOffset());
    assertEquals(1L, actualNormalXReference.getSecondColumnValue());
    assertEquals(1L, actualNormalXReference.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, actualNormalXReference.getType());
    assertFalse(actualNormalXReference.isObjectStream());
    assertSame(key, actualNormalXReference.getReferencedKey());
    COSBoolean expectedObject = object.FALSE;
    assertSame(expectedObject, actualNormalXReference.getObject());
  }

  /**
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  void testNewNormalXReference2() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    assertEquals(1L, actualNormalXReference.getFirstColumnValue());
    assertEquals(1L, actualNormalXReference.getByteOffset());
    assertEquals(1L, actualNormalXReference.getSecondColumnValue());
    assertEquals(1L, actualNormalXReference.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, actualNormalXReference.getType());
    assertFalse(actualNormalXReference.isObjectStream());
    assertSame(object, actualNormalXReference.getObject());
    assertSame(key, actualNormalXReference.getReferencedKey());
  }

  /**
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  void testNewNormalXReference3() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSStream object = new COSStream();

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    assertEquals(1L, actualNormalXReference.getFirstColumnValue());
    assertEquals(1L, actualNormalXReference.getByteOffset());
    assertEquals(1L, actualNormalXReference.getSecondColumnValue());
    assertEquals(1L, actualNormalXReference.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, actualNormalXReference.getType());
    assertFalse(actualNormalXReference.isObjectStream());
    assertSame(key, actualNormalXReference.getReferencedKey());
    assertSame(object, actualNormalXReference.getObject());
  }

  /**
   * Method under test:
   * {@link NormalXReference#NormalXReference(long, COSObjectKey, COSBase)}
   */
  @Test
  void testNewNormalXReference4() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);

    // Act
    NormalXReference actualNormalXReference = new NormalXReference(1L, key, object);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(1L, actualNormalXReference.getFirstColumnValue());
    assertEquals(1L, actualNormalXReference.getByteOffset());
    assertEquals(1L, actualNormalXReference.getSecondColumnValue());
    assertEquals(1L, actualNormalXReference.getThirdColumnValue());
    assertEquals(XReferenceType.NORMAL, actualNormalXReference.getType());
    assertFalse(actualNormalXReference.isObjectStream());
    assertSame(object, actualNormalXReference.getObject());
    assertSame(key, actualNormalXReference.getReferencedKey());
  }
}
