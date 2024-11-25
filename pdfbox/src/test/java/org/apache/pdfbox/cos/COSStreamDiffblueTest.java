package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSStreamDiffblueTest {
  /**
   * Test {@link COSStream#COSStream()}.
   * <p>
   * Method under test: {@link COSStream#COSStream()}
   */
  @Test
  @DisplayName("Test new COSStream()")
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
   * Test {@link COSStream#COSStream(RandomAccessStreamCache)}.
   * <p>
   * Method under test: {@link COSStream#COSStream(RandomAccessStreamCache)}
   */
  @Test
  @DisplayName("Test new COSStream(RandomAccessStreamCache)")
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
   * Test
   * {@link COSStream#COSStream(RandomAccessStreamCache, RandomAccessReadView)}.
   * <ul>
   *   <li>Then return Filters is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link COSStream#COSStream(RandomAccessStreamCache, RandomAccessReadView)}
   */
  @Test
  @DisplayName("Test new COSStream(RandomAccessStreamCache, RandomAccessReadView); then return Filters is 'null'")
  void testNewCOSStream_thenReturnFiltersIsNull() throws IOException {
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

  /**
   * Test {@link COSStream#createRawInputStream()}.
   * <p>
   * Method under test: {@link COSStream#createRawInputStream()}
   */
  @Test
  @DisplayName("Test createRawInputStream()")
  void testCreateRawInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createRawInputStream());
  }

  /**
   * Test {@link COSStream#createInputStream()}.
   * <p>
   * Method under test: {@link COSStream#createInputStream()}
   */
  @Test
  @DisplayName("Test createInputStream()")
  void testCreateInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createInputStream());
  }

  /**
   * Test {@link COSStream#createInputStream(DecodeOptions)} with
   * {@code DecodeOptions}.
   * <p>
   * Method under test: {@link COSStream#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'DecodeOptions'")
  void testCreateInputStreamWithDecodeOptions() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createInputStream(DecodeOptions.DEFAULT));
  }

  /**
   * Test {@link COSStream#createView()}.
   * <p>
   * Method under test: {@link COSStream#createView()}
   */
  @Test
  @DisplayName("Test createView()")
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new COSStream()).createView());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>Then {@link COSStream#COSStream()} Filters is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; then COSStream() Filters is COSDictionary()")
  void testCreateOutputStreamWithCOSBase_thenCOSStreamFiltersIsCOSDictionary() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSDictionary filters = new COSDictionary();

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertSame(filters, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; then throw IOException")
  void testCreateOutputStreamWithCOSBase_thenThrowIOException() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act and Assert
    assertThrows(IOException.class, () -> cosStream.createOutputStream(COSArray.of(10.0f, 0.5f, 10.0f, 0.5f)));
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then {@link COSStream#COSStream()} Filters is
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; when COSArray(); then COSStream() Filters is COSArray()")
  void testCreateOutputStreamWithCOSBase_whenCOSArray_thenCOSStreamFiltersIsCOSArray() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSArray filters = new COSArray();

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    assertSame(filters, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; when COSObjectKey(long, int) with num is one and gen is one")
  void testCreateOutputStreamWithCOSBase_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   *   <li>Then {@link COSStream#COSStream()} Filters is {@link COSBoolean#FALSE}
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; when FALSE; then COSStream() Filters is FALSE FALSE")
  void testCreateOutputStreamWithCOSBase_whenFalse_thenCOSStreamFiltersIsFalseFalse() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    COSBoolean filters = COSBoolean.FALSE;

    // Act
    cosStream.createOutputStream(filters);

    // Assert
    assertEquals(2, cosStream.getValues().size());
    assertEquals(2, cosStream.items.size());
    assertEquals(2, cosStream.size());
    COSBoolean expectedFilters = filters.FALSE;
    assertSame(expectedFilters, cosStream.getFilters());
  }

  /**
   * Test {@link COSStream#createOutputStream(COSBase)} with {@code COSBase}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link COSStream#COSStream()} Filters is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream(COSBase)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSBase) with 'COSBase'; when 'null'; then COSStream() Filters is 'null'")
  void testCreateOutputStreamWithCOSBase_whenNull_thenCOSStreamFiltersIsNull() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream(null);

    // Assert
    assertNull(cosStream.getFilters());
    assertEquals(1, cosStream.getValues().size());
    assertEquals(1, cosStream.items.size());
    assertEquals(1, cosStream.size());
  }

  /**
   * Test {@link COSStream#createOutputStream()}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} hasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream()}
   */
  @Test
  @DisplayName("Test createOutputStream(); given COSStream(); then COSStream() hasData")
  void testCreateOutputStream_givenCOSStream_thenCOSStreamHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#createOutputStream()}.
   * <ul>
   *   <li>Then {@link COSStream#COSStream(RandomAccessStreamCache)} with
   * streamCache is {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   * hasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createOutputStream()}
   */
  @Test
  @DisplayName("Test createOutputStream(); then COSStream(RandomAccessStreamCache) with streamCache is ScratchFile(MemoryUsageSetting) hasData")
  void testCreateOutputStream_thenCOSStreamWithStreamCacheIsScratchFileHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(4096L)));

    // Act
    cosStream.createOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#createRawOutputStream()}.
   * <p>
   * Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  @DisplayName("Test createRawOutputStream()")
  void testCreateRawOutputStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream(new RandomAccessStreamCacheImpl());

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#createRawOutputStream()}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} hasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  @DisplayName("Test createRawOutputStream(); given COSStream(); then COSStream() hasData")
  void testCreateRawOutputStream_givenCOSStream_thenCOSStreamHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#createRawOutputStream()}.
   * <ul>
   *   <li>Then {@link COSStream#COSStream(RandomAccessStreamCache)} with
   * streamCache is {@link ScratchFile#ScratchFile(MemoryUsageSetting)}
   * hasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#createRawOutputStream()}
   */
  @Test
  @DisplayName("Test createRawOutputStream(); then COSStream(RandomAccessStreamCache) with streamCache is ScratchFile(MemoryUsageSetting) hasData")
  void testCreateRawOutputStream_thenCOSStreamWithStreamCacheIsScratchFileHasData() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(4096L)));

    // Act
    cosStream.createRawOutputStream();

    // Assert
    assertTrue(cosStream.hasData());
  }

  /**
   * Test {@link COSStream#getLength()}.
   * <p>
   * Method under test: {@link COSStream#getLength()}
   */
  @Test
  @DisplayName("Test getLength()")
  void testGetLength() {
    // Arrange, Act and Assert
    assertEquals(0L, (new COSStream()).getLength());
  }

  /**
   * Test {@link COSStream#getFilters()}.
   * <p>
   * Method under test: {@link COSStream#getFilters()}
   */
  @Test
  @DisplayName("Test getFilters()")
  void testGetFilters() {
    // Arrange, Act and Assert
    assertNull((new COSStream()).getFilters());
  }

  /**
   * Test {@link COSStream#toTextString()}.
   * <p>
   * Method under test: {@link COSStream#toTextString()}
   */
  @Test
  @DisplayName("Test toTextString()")
  void testToTextString() {
    // Arrange, Act and Assert
    assertEquals("", (new COSStream()).toTextString());
  }

  /**
   * Test {@link COSStream#accept(ICOSVisitor)}.
   * <ul>
   *   <li>When {@link ICOSVisitor} {@link ICOSVisitor#visitFromStream(COSStream)}
   * does nothing.</li>
   *   <li>Then calls {@link ICOSVisitor#visitFromStream(COSStream)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSStream#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); when ICOSVisitor visitFromStream(COSStream) does nothing; then calls visitFromStream(COSStream)")
  void testAccept_whenICOSVisitorVisitFromStreamDoesNothing_thenCallsVisitFromStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();
    ICOSVisitor visitor = mock(ICOSVisitor.class);
    doNothing().when(visitor).visitFromStream(Mockito.<COSStream>any());

    // Act
    cosStream.accept(visitor);

    // Assert
    verify(visitor).visitFromStream(isA(COSStream.class));
  }

  /**
   * Test {@link COSStream#hasData()}.
   * <p>
   * Method under test: {@link COSStream#hasData()}
   */
  @Test
  @DisplayName("Test hasData()")
  void testHasData() {
    // Arrange, Act and Assert
    assertFalse((new COSStream()).hasData());
  }
}
