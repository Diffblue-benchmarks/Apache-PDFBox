package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class XrefEntryDiffblueTest {
  /**
   * Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  void testGetObject() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act
    COSBase actualObject = (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getObject();

    // Assert
    assertTrue(actualObject instanceof COSArray);
    assertTrue(((COSArray) actualObject).toList().isEmpty());
    assertSame(object, actualObject);
  }

  /**
   * Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  void testGetObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    COSBase actualObject = (new XrefEntry(1, new COSObjectKey(1L, 1), 1L, cosObject)).getObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(object, actualObject);
  }

  /**
   * Method under test: {@link XrefEntry#getObject()}
   */
  @Test
  void testGetObject3() {
    // Arrange, Act and Assert
    assertNull((new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null)).getObject());
  }

  /**
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  void testGetPath() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Offset: 1 [1 1 R]",
        (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  void testGetPath2() {
    // Arrange
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/(null)", (new XrefEntry(1, null, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  void testGetPath3() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("CRT/Compressed object stream: 1 [1 1 R]",
        (new XrefEntry(1, key, -1L, new COSObject(object, new COSObjectKey(1L, 1)))).getPath());
  }

  /**
   * Method under test: {@link XrefEntry#getPath()}
   */
  @Test
  void testGetPath4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    String actualPath = (new XrefEntry(1, new COSObjectKey(1L, 1), 1L, cosObject)).getPath();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("CRT/Offset: 1 [1 1 R]", actualPath);
  }

  /**
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("Offset: 1 [1 1 R]",
        (new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }

  /**
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("(null)", (new XrefEntry(1, null, 1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }

  /**
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals("Compressed object stream: 1 [1 1 R]",
        (new XrefEntry(1, key, -1L, new COSObject(object, new COSObjectKey(1L, 1)))).toString());
  }

  /**
   * Method under test: {@link XrefEntry#toString()}
   */
  @Test
  void testToString4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    String actualToStringResult = (new XrefEntry(1, new COSObjectKey(1L, 1), 1L, cosObject)).toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("Offset: 1 [1 1 R]", actualToStringResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link XrefEntry#getCOSObject()}
   *   <li>{@link XrefEntry#getIndex()}
   *   <li>{@link XrefEntry#getKey()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    COSObject actualCOSObject = xrefEntry.getCOSObject();
    int actualIndex = xrefEntry.getIndex();

    // Assert
    assertEquals(1, actualIndex);
    assertSame(cosObject, actualCOSObject);
    assertSame(key, xrefEntry.getKey());
  }

  /**
   * Method under test:
   * {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}
   */
  @Test
  void testNewXrefEntry() {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    XrefEntry actualXrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Assert
    COSBase object2 = actualXrefEntry.getObject();
    assertTrue(object2 instanceof COSArray);
    assertEquals("CRT/Offset: 1 [1 1 R]", actualXrefEntry.getPath());
    assertEquals(1, actualXrefEntry.getIndex());
    assertTrue(((COSArray) object2).toList().isEmpty());
    assertSame(object, object2);
    assertSame(cosObject, actualXrefEntry.getCOSObject());
    assertSame(key, actualXrefEntry.getKey());
  }

  /**
   * Method under test:
   * {@link XrefEntry#XrefEntry(int, COSObjectKey, long, COSObject)}
   */
  @Test
  void testNewXrefEntry2() throws IOException {
    // Arrange
    COSObjectKey key = new COSObjectKey(1L, 1);

    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument object = new COSDocument(streamCacheCreateFunction);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    XrefEntry actualXrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("CRT/Offset: 1 [1 1 R]", actualXrefEntry.getPath());
    assertEquals(1, actualXrefEntry.getIndex());
    assertSame(object, actualXrefEntry.getObject());
    assertSame(cosObject, actualXrefEntry.getCOSObject());
    assertSame(key, actualXrefEntry.getKey());
  }
}
