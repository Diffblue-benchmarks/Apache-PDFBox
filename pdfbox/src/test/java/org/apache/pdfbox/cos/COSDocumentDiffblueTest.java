package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.JPXFilter;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.io.RandomAccessReadMemoryMappedFile;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class COSDocumentDiffblueTest {
  /**
   * Test {@link COSDocument#COSDocument()}.
   *
   * <p>Method under test: {@link COSDocument#COSDocument()}
   */
  @Test
  @DisplayName("Test new COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.<init>()"})
  void testNewCOSDocument() {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument();

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(ICOSParser)}.
   *
   * <p>Method under test: {@link COSDocument#COSDocument(ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(ICOSParser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.<init>(ICOSParser)"})
  void testNewCOSDocument2() throws IOException {
    // Arrange and Act
    COSDocument actualCosDocument =
        new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction)"})
  void testNewCOSDocument_givenIOException() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction, ICOSParser); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)"
  })
  void testNewCOSDocument_givenIOException2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException());

    // Act
    COSDocument actualCosDocument =
        new COSDocument(
            streamCacheCreateFunction, new COSParser(new RandomAccessReadWriteBuffer()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName(
      "Test new COSDocument(StreamCacheCreateFunction); given RandomAccessStreamCacheImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction)"})
  void testNewCOSDocument_givenRandomAccessStreamCacheImpl() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDocument actualCosDocument = new COSDocument(streamCacheCreateFunction);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName(
      "Test new COSDocument(StreamCacheCreateFunction, ICOSParser); given RandomAccessStreamCacheImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)"
  })
  void testNewCOSDocument_givenRandomAccessStreamCacheImpl2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    COSDocument actualCosDocument =
        new COSDocument(
            streamCacheCreateFunction, new COSParser(new RandomAccessReadWriteBuffer()));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction)"})
  void testNewCOSDocument_whenNull() {
    // Arrange and Act
    COSDocument actualCosDocument = new COSDocument((StreamCacheCreateFunction) null);

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#COSDocument(StreamCacheCreateFunction, ICOSParser)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * COSDocument#COSDocument(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)}
   */
  @Test
  @DisplayName("Test new COSDocument(StreamCacheCreateFunction, ICOSParser); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSDocument.<init>(RandomAccessStreamCache.StreamCacheCreateFunction, ICOSParser)"
  })
  void testNewCOSDocument_whenNull2() throws IOException {
    // Arrange and Act
    COSDocument actualCosDocument =
        new COSDocument(null, new COSParser(new RandomAccessReadWriteBuffer()));

    // Assert
    assertNull(actualCosDocument.getLinearizedDictionary());
    assertNull(actualCosDocument.getTrailer());
    assertNull(actualCosDocument.getKey());
    assertEquals(0L, actualCosDocument.getHighestXRefObjectNumber());
    assertEquals(0L, actualCosDocument.getStartXref());
    assertEquals(1.4f, actualCosDocument.getVersion());
    assertFalse(actualCosDocument.isDirect());
    assertFalse(actualCosDocument.hasHybridXRef());
    assertFalse(actualCosDocument.isClosed());
    assertFalse(actualCosDocument.isDecrypted());
    assertFalse(actualCosDocument.isEncrypted());
    assertFalse(actualCosDocument.isXRefStream());
    assertTrue(actualCosDocument.getXrefTable().isEmpty());
  }

  /**
   * Test {@link COSDocument#createCOSStream()}.
   *
   * <p>Method under test: {@link COSDocument#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream()"})
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult = new COSDocument().createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong() throws IOException {
    // Arrange
    RandomAccessReadBufferedFile source = new RandomAccessReadBufferedFile("foo.txt");
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser parser = new COSParser(source, "iloveyou", keyStore, "Key Alias");
    COSDocument cosDocument = new COSDocument(parser);

    // Act
    COSStream actualCreateCOSStreamResult =
        cosDocument.createCOSStream(new COSDictionary(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(3L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong2() throws IOException {
    // Arrange
    RandomAccessReadMemoryMappedFile source = new RandomAccessReadMemoryMappedFile("foo.txt");
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser parser = new COSParser(source, "iloveyou", keyStore, "Key Alias");
    COSDocument cosDocument = new COSDocument(parser);

    // Act
    COSStream actualCreateCOSStreamResult =
        cosDocument.createCOSStream(new COSDictionary(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(3L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then return Length is three.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; then return Length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong_thenReturnLengthIsThree() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSStream actualCreateCOSStreamResult =
        cosDocument.createCOSStream(new COSDictionary(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(3L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <ul>
   *   <li>Then return Length is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; then return Length is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong_thenReturnLengthIsZero() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSStream actualCreateCOSStreamResult = cosDocument.createCOSStream(new COSStream(), 1L, 3L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@code 4096}.
   *   <li>Then return Length is {@code 4096}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; when '4096'; then return Length is '4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong_when4096_thenReturnLengthIs4096()
      throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));

    // Act
    COSStream actualCreateCOSStreamResult =
        cosDocument.createCOSStream(new COSDictionary(), 1L, 4096L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    assertEquals(4096L, actualCreateCOSStreamResult.getLength());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#createCOSStream(COSDictionary, long, long)} with {@code COSDictionary},
   * {@code long}, {@code long}.
   *
   * <ul>
   *   <li>When {@code -4096}.
   *   <li>Then return Length is {@code -4096}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#createCOSStream(COSDictionary, long, long)}
   */
  @Test
  @DisplayName(
      "Test createCOSStream(COSDictionary, long, long) with 'COSDictionary', 'long', 'long'; when '-4096'; then return Length is '-4096'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream COSDocument.createCOSStream(COSDictionary, long, long)"})
  void testCreateCOSStreamWithCOSDictionaryLongLong_when4096_thenReturnLengthIs40962()
      throws IOException {
    // Arrange
    RandomAccessReadBufferedFile source = new RandomAccessReadBufferedFile("foo.txt");
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser parser = new COSParser(source, "iloveyou", keyStore, "Key Alias");
    COSDocument cosDocument = new COSDocument(parser);

    // Act
    COSStream actualCreateCOSStreamResult =
        cosDocument.createCOSStream(new COSDictionary(), 1L, -4096L);

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(-4096L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.items.size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualCreateCOSStreamResult.hasData());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary() {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);

    COSDocument cosDocument = new COSDocument();
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertNull(cosDocument.getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary2() {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(42L, 42), 1L);
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);

    COSDocument cosDocument = new COSDocument();
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertNull(cosDocument.getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary3() throws IOException {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);

    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertNull(cosDocument.getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary4() {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 0L);

    COSDocument cosDocument = new COSDocument();
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertNull(cosDocument.getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName(
      "Test getLinearizedDictionary(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser parser = new COSParser(source);

    COSDocument cosDocument = new COSDocument(parser);
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertNull(cosDocument.getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getLinearizedDictionary()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getLinearizedDictionary()}
   */
  @Test
  @DisplayName("Test getLinearizedDictionary(); given COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getLinearizedDictionary()"})
  void testGetLinearizedDictionary_givenCOSDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSDocument().getLinearizedDictionary());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   *
   * <p>Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName) with 'type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName)"})
  void testGetObjectsByTypeWithType() throws IOException {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);

    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertTrue(cosDocument.getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName, COSName)} with {@code type1}, {@code type2}.
   *
   * <p>Method under test: {@link COSDocument#getObjectsByType(COSName, COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName, COSName) with 'type1', 'type2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName, COSName)"})
  void testGetObjectsByTypeWithType1Type2() {
    // Arrange, Act and Assert
    assertTrue(new COSDocument().getObjectsByType(COSName.A, COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName(
      "Test getObjectsByType(COSName) with 'type'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName)"})
  void testGetObjectsByTypeWithType_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser parser = new COSParser(source);

    COSDocument cosDocument = new COSDocument(parser);
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertTrue(cosDocument.getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} addXRefTable {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName(
      "Test getObjectsByType(COSName) with 'type'; given COSDocument() addXRefTable HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName)"})
  void testGetObjectsByTypeWithType_givenCOSDocumentAddXRefTableHashMap_thenReturnEmpty() {
    // Arrange
    HashMap<COSObjectKey, Long> xrefTableValues = new HashMap<>();
    xrefTableValues.put(new COSObjectKey(1L, 1), 42L);

    COSDocument cosDocument = new COSDocument();
    cosDocument.addXRefTable(xrefTableValues);

    // Act and Assert
    assertTrue(cosDocument.getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#getObjectsByType(COSName)} with {@code type}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getObjectsByType(COSName)}
   */
  @Test
  @DisplayName("Test getObjectsByType(COSName) with 'type'; given COSDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List COSDocument.getObjectsByType(COSName)"})
  void testGetObjectsByTypeWithType_givenCOSDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new COSDocument().getObjectsByType(COSName.A).isEmpty());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDocument.isEncrypted()"})
  void testIsEncrypted_givenCOSDocument() {
    // Arrange, Act and Assert
    assertFalse(new COSDocument().isEncrypted());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDocument.isEncrypted()"})
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertFalse(cosDocument.isEncrypted());
  }

  /**
   * Test {@link COSDocument#isEncrypted()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#isEncrypted()}
   */
  @Test
  @DisplayName("Test isEncrypted(); given COSDocument() Trailer is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean COSDocument.isEncrypted()"})
  void testIsEncrypted_givenCOSDocumentTrailerIsCOSStream() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertFalse(cosDocument.isEncrypted());
  }

  /**
   * Test {@link COSDocument#getEncryptionDictionary()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getEncryptionDictionary()}
   */
  @Test
  @DisplayName("Test getEncryptionDictionary(); given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getEncryptionDictionary()"})
  void testGetEncryptionDictionary_givenCOSDocumentTrailerIsCOSDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getEncryptionDictionary());
  }

  /**
   * Test {@link COSDocument#getEncryptionDictionary()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getEncryptionDictionary()}
   */
  @Test
  @DisplayName(
      "Test getEncryptionDictionary(); given COSDocument() Trailer is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary COSDocument.getEncryptionDictionary()"})
  void testGetEncryptionDictionary_givenCOSDocumentTrailerIsCOSStream_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertNull(cosDocument.getEncryptionDictionary());
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSDictionary encDictionary = new COSDictionary();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary2() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSStream encDictionary = new COSStream();

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(originDocumentState, trailer.getUpdateState().getOriginDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   *
   * <p>Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName("Test setEncryptionDictionary(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary3() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary(new COSDictionary());
    encDictionary.setDirect(false);
    encDictionary.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(originDocumentState, trailer.getUpdateState().getOriginDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test setEncryptionDictionary(COSDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSDictionary encDictionary = new COSDictionary();
    encDictionary.setDirect(true);

    // Act
    cosDocument.setEncryptionDictionary(encDictionary);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    COSDocumentState originDocumentState = encDictionary.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertTrue(cosDocument.isEncrypted());
    assertSame(encDictionary, cosDocument.getEncryptionDictionary());
    assertSame(originDocumentState, cosDocument.getDocumentState());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setEncryptionDictionary(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDocument#COSDocument()} Trailer size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setEncryptionDictionary(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test setEncryptionDictionary(COSDictionary); when 'null'; then COSDocument() Trailer size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setEncryptionDictionary(COSDictionary)"})
  void testSetEncryptionDictionary_whenNull_thenCOSDocumentTrailerSizeIsZero() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setEncryptionDictionary(null);

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertFalse(cosDocument.isEncrypted());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#getDocumentID()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getDocumentID()}
   */
  @Test
  @DisplayName(
      "Test getDocumentID(); given COSDocument() Trailer is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSDocument.getDocumentID()"})
  void testGetDocumentID_givenCOSDocumentTrailerIsCOSDictionary_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act and Assert
    assertNull(cosDocument.getDocumentID());
  }

  /**
   * Test {@link COSDocument#getDocumentID()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getDocumentID()}
   */
  @Test
  @DisplayName(
      "Test getDocumentID(); given COSDocument() Trailer is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray COSDocument.getDocumentID()"})
  void testGetDocumentID_givenCOSDocumentTrailerIsCOSStream_thenReturnNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSStream());

    // Act and Assert
    assertNull(cosDocument.getDocumentID());
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   *
   * <p>Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSArray id = new COSArray(new ArrayList<>());
    id.setDirect(false);
    id.setKey(new COSObjectKey(1L, 1));

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDocumentID(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    COSArray id = new COSArray(new ArrayList<>());
    id.setDirect(false);
    id.setKey(null);

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@link COSArray} with floats is ten
   *       and {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDocumentID(COSArray); then COSDocument() DocumentID is COSArray with floats is ten and '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_thenCOSDocumentDocumentIDIsCOSArrayWithFloatsIsTenAnd05() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = COSArray.of(10.0f, 0.5f, 10.0f, 0.5f);

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then {@link COSDocument#COSDocument()} DocumentID is {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDocumentID(COSArray); when COSArray(); then COSDocument() DocumentID is COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_whenCOSArray_thenCOSDocumentDocumentIDIsCOSArray() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    COSArray id = new COSArray();

    // Act
    cosDocument.setDocumentID(id);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(id, cosDocument.getDocumentID());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#setDocumentID(COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link COSDocument#COSDocument()} Trailer size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setDocumentID(COSArray)}
   */
  @Test
  @DisplayName("Test setDocumentID(COSArray); when 'null'; then COSDocument() Trailer size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setDocumentID(COSArray)"})
  void testSetDocumentID_whenNull_thenCOSDocumentTrailerSizeIsZero() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.setDocumentID(null);

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   *
   * <p>Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName("Test setTrailer(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setTrailer(COSDictionary)"})
  void testSetTrailer() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#setTrailer(COSDictionary)}.
   *
   * <ul>
   *   <li>Then not {@link COSStream#COSStream()} UpdateState OriginDocumentState AcceptingUpdates.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#setTrailer(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test setTrailer(COSDictionary); then not COSStream() UpdateState OriginDocumentState AcceptingUpdates")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.setTrailer(COSDictionary)"})
  void testSetTrailer_thenNotCOSStreamUpdateStateOriginDocumentStateAcceptingUpdates() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSStream newTrailer = new COSStream();

    // Act
    cosDocument.setTrailer(newTrailer);

    // Assert
    assertNull(cosDocument.getDocumentID());
    assertNull(cosDocument.getEncryptionDictionary());
    COSDocumentState originDocumentState = newTrailer.getUpdateState().getOriginDocumentState();
    assertFalse(originDocumentState.isAcceptingUpdates());
    assertSame(newTrailer, cosDocument.getTrailer());
    assertSame(originDocumentState, cosDocument.getDocumentState());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = ((COSStream) trailer).items;
    assertEquals(2, cosNameCosBaseMap.size());
    assertEquals(2, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());
    ArrayList<Filter> filters = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    COSOutputStream outputStream =
        new COSOutputStream(filters, parameters, output, new RandomAccessStreamCacheImpl());

    // Act
    cosDocument.accept(new COSWriter(outputStream));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept4() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    COSWriter visitor = new COSWriter(new ByteArrayOutputStream());
    visitor.doWriteObject(COSBoolean.FALSE);

    // Act
    cosDocument.accept(visitor);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_givenA() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = ((COSStream) trailer).items;
    assertEquals(2, cosNameCosBaseMap.size());
    assertEquals(2, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} IsXRefStream is {@code true}.
   *   <li>Then {@link COSDocument#COSDocument()} Trailer size is zero.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); given COSDocument() IsXRefStream is 'true'; then COSDocument() Trailer size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_givenCOSDocumentIsXRefStreamIsTrue_thenCOSDocumentTrailerSizeIsZero()
      throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_givenFalse() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    COSWriter visitor = new COSWriter(new ByteArrayOutputStream());
    visitor.doWriteObject(COSBoolean.FALSE);

    // Act
    cosDocument.accept(visitor);

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Given {@link JPXFilter} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link JPXFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); given JPXFilter (default constructor); when ArrayList() add JPXFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_givenJPXFilter_whenArrayListAddJPXFilter() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(new JPXFilter());
    COSDictionary parameters = new COSDictionary();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    COSOutputStream outputStream =
        new COSOutputStream(filters, parameters, output, new RandomAccessStreamCacheImpl());

    // Act
    cosDocument.accept(new COSWriter(outputStream));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); given StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_givenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(true);
    cosDocument.setTrailer(new COSDictionary());

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert that nothing has changed
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(0, trailer.size());
    assertTrue(trailer.getValues().isEmpty());
    assertTrue(trailer.items.isEmpty());
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer {@link COSDictionary#items} is {@link
   *       COSDictionary#COSDictionary()} {@link COSDictionary#items}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); then COSDocument() Trailer items is COSDictionary() items")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerItemsIsCOSDictionaryItems() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter visitor = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosDocument.accept(visitor);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(2, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(2, cosNameCosBaseMap.size());
    assertEquals(2, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer {@link COSDictionary#items} is {@link
   *       COSStream#COSStream()} {@link COSDictionary#items}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer items is COSStream() items")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerItemsIsCOSStreamItems() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSStream newTrailer = new COSStream();
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(2, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = ((COSStream) trailer).items;
    assertEquals(2, cosNameCosBaseMap.size());
    assertEquals(2, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerValuesSizeIsOne() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerValuesSizeIsOne2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setIsXRefStream(true);
    COSStream newTrailer = new COSStream();
    cosDocument.setTrailer(newTrailer);

    // Act
    cosDocument.accept(new COSWriter(new ByteArrayOutputStream()));

    // Assert that nothing has changed
    COSDictionary trailer = cosDocument.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = ((COSStream) trailer).items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerValuesSizeIsOne3() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    cosDocument.setIsXRefStream(true);
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter visitor = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosDocument.accept(visitor);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument()} Trailer Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName("Test accept(ICOSVisitor); then COSDocument() Trailer Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentTrailerValuesSizeIsThree() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSStream newTrailer = new COSStream();
    cosDocument.setTrailer(newTrailer);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    COSWriter visitor = new COSWriter(outputStream, new RandomAccessReadWriteBuffer());

    // Act
    cosDocument.accept(visitor);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertTrue(trailer instanceof COSStream);
    assertEquals(3, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = ((COSStream) trailer).items;
    assertEquals(3, cosNameCosBaseMap.size());
    assertEquals(3, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument(StreamCacheCreateFunction)} with {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction} Trailer Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); then COSDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction Trailer Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_thenCOSDocumentWithStreamCacheCreateFunctionTrailerValuesSizeIsOne()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    cosDocument.setIsXRefStream(false);
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    ArrayList<Filter> filters = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    COSOutputStream outputStream =
        new COSOutputStream(filters, parameters, output, new RandomAccessStreamCacheImpl());

    // Act
    cosDocument.accept(new COSWriter(outputStream));

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(1, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(1, cosNameCosBaseMap.size());
    assertEquals(1, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#accept(ICOSVisitor)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then {@link COSDocument#COSDocument()} Trailer {@link COSDictionary#items} is {@link
   *       COSDictionary#COSDictionary()} {@link COSDictionary#items}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#accept(ICOSVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(ICOSVisitor); when 'A'; then COSDocument() Trailer items is COSDictionary() items")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.accept(ICOSVisitor)"})
  void testAccept_whenA_thenCOSDocumentTrailerItemsIsCOSDictionaryItems() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSDictionary newTrailer = new COSDictionary();
    cosDocument.setTrailer(newTrailer);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer inputData = new RandomAccessReadBuffer(input);

    COSWriter visitor = new COSWriter(outputStream, inputData);

    // Act
    cosDocument.accept(visitor);

    // Assert
    COSDictionary trailer = cosDocument.getTrailer();
    assertEquals(2, trailer.getValues().size());
    Map<COSName, COSBase> cosNameCosBaseMap = trailer.items;
    assertEquals(2, cosNameCosBaseMap.size());
    assertEquals(2, trailer.size());
    assertSame(newTrailer.items, cosNameCosBaseMap);
  }

  /**
   * Test {@link COSDocument#close()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.
   *   <li>Then {@link COSDocument#COSDocument()} Closed.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given COSDocument(); then COSDocument() Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.close()"})
  void testClose_givenCOSDocument_thenCOSDocumentClosed() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.close();

    // Assert
    assertTrue(cosDocument.isClosed());
  }

  /**
   * Test {@link COSDocument#close()}.
   *
   * <ul>
   *   <li>Then {@link COSDocument#COSDocument(StreamCacheCreateFunction)} with {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction} Closed.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#close()}
   */
  @Test
  @DisplayName(
      "Test close(); then COSDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSDocument.close()"})
  void testClose_thenCOSDocumentWithStreamCacheCreateFunctionClosed() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    cosDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(cosDocument.isClosed());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   *
   * <ul>
   *   <li>Then return Object is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); then return Object is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObject COSDocument.getObjectFromPool(COSObjectKey)"})
  void testGetObjectFromPool_thenReturnObjectIsNull() {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSObjectKey key = new COSObjectKey(1L, 1);

    // Act
    COSObject actualObjectFromPool = cosDocument.getObjectFromPool(key);

    // Assert
    assertNull(actualObjectFromPool.getObject());
    COSUpdateState updateState = actualObjectFromPool.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = actualObjectFromPool.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualObjectFromPool.isDirect());
    assertFalse(actualObjectFromPool.isDereferenced());
    assertFalse(actualObjectFromPool.isNeedToBeUpdated());
    assertFalse(updateState.isAcceptingUpdates());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualObjectFromPool.isObjectNull());
    assertSame(key, actualObjectFromPool.getKey());
  }

  /**
   * Test {@link COSDocument#getObjectFromPool(COSObjectKey)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link COSDocument#getObjectFromPool(COSObjectKey)}
   */
  @Test
  @DisplayName("Test getObjectFromPool(COSObjectKey); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObject COSDocument.getObjectFromPool(COSObjectKey)"})
  void testGetObjectFromPool_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new COSDocument().getObjectFromPool(null));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link COSDocument#setHighestXRefObjectNumber(long)}
   *   <li>{@link COSDocument#setIsXRefStream(boolean)}
   *   <li>{@link COSDocument#setStartXref(long)}
   *   <li>{@link COSDocument#setVersion(float)}
   *   <li>{@link COSDocument#setDecrypted()}
   *   <li>{@link COSDocument#setHasHybridXRef()}
   *   <li>{@link COSDocument#getDocumentState()}
   *   <li>{@link COSDocument#getHighestXRefObjectNumber()}
   *   <li>{@link COSDocument#getStartXref()}
   *   <li>{@link COSDocument#getTrailer()}
   *   <li>{@link COSDocument#getVersion()}
   *   <li>{@link COSDocument#getXrefTable()}
   *   <li>{@link COSDocument#hasHybridXRef()}
   *   <li>{@link COSDocument#isClosed()}
   *   <li>{@link COSDocument#isDecrypted()}
   *   <li>{@link COSDocument#isXRefStream()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "COSDocumentState COSDocument.getDocumentState()",
    "long COSDocument.getHighestXRefObjectNumber()",
    "long COSDocument.getStartXref()",
    "COSDictionary COSDocument.getTrailer()",
    "float COSDocument.getVersion()",
    "Map COSDocument.getXrefTable()",
    "boolean COSDocument.hasHybridXRef()",
    "boolean COSDocument.isClosed()",
    "boolean COSDocument.isDecrypted()",
    "boolean COSDocument.isXRefStream()",
    "void COSDocument.setDecrypted()",
    "void COSDocument.setHasHybridXRef()",
    "void COSDocument.setHighestXRefObjectNumber(long)",
    "void COSDocument.setIsXRefStream(boolean)",
    "void COSDocument.setStartXref(long)",
    "void COSDocument.setVersion(float)"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    cosDocument.setHighestXRefObjectNumber(1L);
    cosDocument.setIsXRefStream(true);
    cosDocument.setStartXref(42L);
    cosDocument.setVersion(10.0f);
    cosDocument.setDecrypted();
    cosDocument.setHasHybridXRef();
    COSDocumentState actualDocumentState = cosDocument.getDocumentState();
    long actualHighestXRefObjectNumber = cosDocument.getHighestXRefObjectNumber();
    long actualStartXref = cosDocument.getStartXref();
    COSDictionary actualTrailer = cosDocument.getTrailer();
    float actualVersion = cosDocument.getVersion();
    Map<COSObjectKey, Long> actualXrefTable = cosDocument.getXrefTable();
    boolean actualHasHybridXRefResult = cosDocument.hasHybridXRef();
    boolean actualIsClosedResult = cosDocument.isClosed();
    boolean actualIsDecryptedResult = cosDocument.isDecrypted();
    boolean actualIsXRefStreamResult = cosDocument.isXRefStream();

    // Assert
    assertNull(actualTrailer);
    assertEquals(10.0f, actualVersion);
    assertEquals(1L, actualHighestXRefObjectNumber);
    assertEquals(42L, actualStartXref);
    assertFalse(actualIsClosedResult);
    assertFalse(actualDocumentState.isAcceptingUpdates());
    assertTrue(actualXrefTable.isEmpty());
    assertTrue(actualHasHybridXRefResult);
    assertTrue(actualIsDecryptedResult);
    assertTrue(actualIsXRefStreamResult);
  }
}
