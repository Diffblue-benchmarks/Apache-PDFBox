package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class COSStreamDiffblueTest {
  /**
   * Method under test: {@link COSStream#createRawInputStream()}
   */
  @Test
  void testCreateRawInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createRawInputStream());
  }

  /**
   * Method under test: {@link COSStream#createInputStream()}
   */
  @Test
  void testCreateInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createInputStream());
    assertThrows(IOException.class, () -> (new COSStream()).createInputStream(DecodeOptions.DEFAULT));
  }

  /**
   * Method under test: {@link COSStream#createView()}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createView());
  }

  /**
   * Method under test: {@link COSStream#createOutputStream()}
   */
  @Test
  void testCreateOutputStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  void testCreateOutputStream2() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSBoolean filters = COSBoolean.FALSE;

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertTrue(cosStream.hasData());
    COSBoolean expectedFilters = filters.FALSE;
    assertSame(expectedFilters, cosStream.getFilters());
  }

  /**
   * Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  void testCreateRawOutputStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  void testCreateRawOutputStream2() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream(new RandomAccessStreamCacheImpl());

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Method under test: {@link COSStream#getLength()}
   */
  @Test
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0L, (new COSStream()).getLength());
  }

  /**
   * Method under test: {@link COSStream#getFilters()}
   */
  @Test
  void testGetFilters() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getFilters());
  }

  /**
   * Method under test: {@link COSStream#toTextString()}
   */
  @Test
  void testToTextString() {
    // Arrange, Act and Assert
    assertEquals("", (new COSStream()).toTextString());
  }

  /**
   * Method under test: {@link COSStream#hasData()}
   */
  @Test
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse((new COSStream()).hasData());
  }

  /**
   * Method under test: {@link COSStream#COSStream()}
   */
  @Test
  void testNewCOSStream() {
    // Arrange and Act
    COSStream actualCosStream = new COSStream();

    // Assert
    assertNull(actualCosStream.getFilters());
    COSUpdateState updateState = actualCosStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosStream.getKey());
    assertEquals(0L, actualCosStream.getLength());
    assertEquals(1, actualCosStream.getValues().size());
    assertEquals(1, actualCosStream.items.size());
    assertEquals(1, actualCosStream.size());
    COSIncrement toIncrementResult = actualCosStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosStream.isDirect());
    assertFalse(actualCosStream.hasData());
    assertFalse(actualCosStream.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link COSStream#COSStream(RandomAccessStreamCache)}
   */
  @Test
  void testNewCOSStream2() {
    // Arrange and Act
    COSStream actualCosStream = new COSStream(new RandomAccessStreamCacheImpl());

    // Assert
    assertNull(actualCosStream.getFilters());
    COSUpdateState updateState = actualCosStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosStream.getKey());
    assertEquals(0L, actualCosStream.getLength());
    assertEquals(1, actualCosStream.getValues().size());
    assertEquals(1, actualCosStream.items.size());
    assertEquals(1, actualCosStream.size());
    COSIncrement toIncrementResult = actualCosStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosStream.isDirect());
    assertFalse(actualCosStream.hasData());
    assertFalse(actualCosStream.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link COSStream#COSStream(RandomAccessStreamCache, RandomAccessReadView)}
   */
  @Test
  void testNewCOSStream3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();

    // Act
    COSStream actualCosStream = new COSStream(streamCache, new RandomAccessReadView(
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), 1L, 3L));

    // Assert
    assertNull(actualCosStream.getFilters());
    COSUpdateState updateState = actualCosStream.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCosStream.getKey());
    assertEquals(1, actualCosStream.getValues().size());
    assertEquals(1, actualCosStream.items.size());
    assertEquals(1, actualCosStream.size());
    assertEquals(3L, actualCosStream.getLength());
    COSIncrement toIncrementResult = actualCosStream.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = updateState.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(actualCosStream.isDirect());
    assertFalse(actualCosStream.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
    assertTrue(actualCosStream.hasData());
  }
}
