package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.function.BiConsumer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFXRefStreamDiffblueTest {
  /**
   * Test {@link PDFXRefStream#PDFXRefStream(COSDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>Then calls {@link COSDocument#createCOSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#PDFXRefStream(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFXRefStream(COSDocument); given COSStream(); then calls createCOSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFXRefStream.<init>(COSDocument)"})
  void testNewPDFXRefStream_givenCOSStream_thenCallsCreateCOSStream() {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    when(cosDocument.createCOSStream()).thenReturn(new COSStream());

    // Act
    new PDFXRefStream(cosDocument);

    // Assert
    verify(cosDocument).createCOSStream();
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream() throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(-100L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    PDFXRefStream pdfxRefStream = new PDFXRefStream(cosDocument);
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return Length is twelve.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given COSObjectKey(long, int) with num is one and gen is one; then return Length is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnLengthIsTwelve()
      throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.addEntry(new FreeXReference(new COSObjectKey(1L, 1), 1L));
    pdfxRefStream.setSize(-100L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link
   *       COSDocument#COSDocument()} addEntry {@link FreeXReference#NULL_ENTRY}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() addEntry NULL_ENTRY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentAddEntryNull_entry()
      throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);
    pdfxRefStream.setSize(-100L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link
   *       COSDocument#COSDocument(StreamCacheCreateFunction)} addEntry {@link
   *       FreeXReference#NULL_ENTRY}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument(StreamCacheCreateFunction) addEntry NULL_ENTRY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentAddEntryNull_entry2()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    PDFXRefStream pdfxRefStream = new PDFXRefStream(cosDocument);
    pdfxRefStream.addEntry(FreeXReference.NULL_ENTRY);
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(12L, actualStream.getLength());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link
   *       COSDocument#COSDocument()} Size is {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() Size is MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsMax_value()
      throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(Long.MAX_VALUE);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link
   *       COSDocument#COSDocument()} Size is {@link Long#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() Size is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsMin_value()
      throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(Long.MIN_VALUE);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link PDFXRefStream#PDFXRefStream(COSDocument)} with cosDocument is {@link
   *       COSDocument#COSDocument()} Size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given PDFXRefStream(COSDocument) with cosDocument is COSDocument() Size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenPDFXRefStreamWithCosDocumentIsCOSDocumentSizeIsThree()
      throws IOException {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName(
      "Test getStream(); given StreamCacheCreateFunction create() return 'null'; then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_givenStreamCacheCreateFunctionCreateReturnNull_thenCallsCreate()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    PDFXRefStream pdfxRefStream = new PDFXRefStream(cosDocument);
    pdfxRefStream.setSize(3L);

    // Act
    COSStream actualStream = pdfxRefStream.getStream();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualStream.getFilters() instanceof COSName);
    assertNull(actualStream.getKey());
    assertEquals(6, actualStream.getValues().size());
    assertEquals(6, actualStream.size());
    assertEquals(8L, actualStream.getLength());
    assertFalse(actualStream.isDirect());
    assertFalse(actualStream.isNeedToBeUpdated());
    assertTrue(actualStream.hasData());
  }

  /**
   * Test {@link PDFXRefStream#getStream()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#getStream()}
   */
  @Test
  @DisplayName("Test getStream(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDFXRefStream.getStream()"})
  void testGetStream_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> new PDFXRefStream(new COSDocument()).getStream());
  }

  /**
   * Test {@link PDFXRefStream#addTrailerInfo(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary} {@link COSDictionary#forEach(BiConsumer)} does nothing.
   *   <li>Then calls {@link COSDictionary#forEach(BiConsumer)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXRefStream#addTrailerInfo(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test addTrailerInfo(COSDictionary); when COSDictionary forEach(BiConsumer) does nothing; then calls forEach(BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFXRefStream.addTrailerInfo(COSDictionary)"})
  void testAddTrailerInfo_whenCOSDictionaryForEachDoesNothing_thenCallsForEach() {
    // Arrange
    PDFXRefStream pdfxRefStream = new PDFXRefStream(new COSDocument());

    COSDictionary trailerDict = mock(COSDictionary.class);
    doNothing().when(trailerDict).forEach(Mockito.<BiConsumer<COSName, COSBase>>any());

    // Act
    pdfxRefStream.addTrailerInfo(trailerDict);

    // Assert
    verify(trailerDict).forEach(isA(BiConsumer.class));
  }
}
