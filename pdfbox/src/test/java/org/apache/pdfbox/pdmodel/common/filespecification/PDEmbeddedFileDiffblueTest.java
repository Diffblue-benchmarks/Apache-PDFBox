package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDEmbeddedFileDiffblueTest {
  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)}.
   * <p>
   * Method under test: {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(COSStream)")
  void testNewPDEmbeddedFile() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDEmbeddedFile(str)).getCOSObject());
  }

  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}.
   * <p>
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(PDDocument, InputStream)")
  void testNewPDEmbeddedFile2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, str);

    // Assert
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(8, actualPdEmbeddedFile.getLength());
    assertEquals(8L, actualPdEmbeddedFile.getCOSObject().getLength());
  }

  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(PDDocument, InputStream); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  void testNewPDEmbeddedFile_givenNull_whenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, str);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, str.read(new byte[]{}));
    assertEquals(8, actualPdEmbeddedFile.getLength());
    assertEquals(8L, actualPdEmbeddedFile.getCOSObject().getLength());
  }

  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(PDDocument, InputStream); given one; then return CheckSum is 'null'")
  void testNewPDEmbeddedFile_givenOne_thenReturnCheckSumIsNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    DataInputStream str = mock(DataInputStream.class);
    when(str.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(str).close();

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, str);

    // Assert
    verify(str).close();
    verify(str).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    assertNull(actualPdEmbeddedFile.getCheckSum());
    assertNull(actualPdEmbeddedFile.getMacCreator());
    assertNull(actualPdEmbeddedFile.getMacResFork());
    assertNull(actualPdEmbeddedFile.getMacSubtype());
    assertNull(actualPdEmbeddedFile.getSubtype());
    assertNull(actualPdEmbeddedFile.getCreationDate());
    assertNull(actualPdEmbeddedFile.getModDate());
    assertNull(actualPdEmbeddedFile.getDecodeParms());
    assertNull(actualPdEmbeddedFile.getFileDecodeParams());
    COSStream cOSObject = actualPdEmbeddedFile.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdEmbeddedFile.getMetadata());
    assertNull(actualPdEmbeddedFile.getFile());
    assertEquals(-1, actualPdEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualPdEmbeddedFile.getSize());
    assertEquals(0, actualPdEmbeddedFile.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdEmbeddedFile.getFilters());
  }

  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(PDDocument); when PDDocument(); then return CheckSum is 'null'")
  void testNewPDEmbeddedFile_whenPDDocument_thenReturnCheckSumIsNull() throws IOException {
    // Arrange and Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(new PDDocument());

    // Assert
    assertNull(actualPdEmbeddedFile.getCheckSum());
    assertNull(actualPdEmbeddedFile.getMacCreator());
    assertNull(actualPdEmbeddedFile.getMacResFork());
    assertNull(actualPdEmbeddedFile.getMacSubtype());
    assertNull(actualPdEmbeddedFile.getSubtype());
    assertNull(actualPdEmbeddedFile.getCreationDate());
    assertNull(actualPdEmbeddedFile.getModDate());
    assertNull(actualPdEmbeddedFile.getDecodeParms());
    assertNull(actualPdEmbeddedFile.getFileDecodeParams());
    COSStream cOSObject = actualPdEmbeddedFile.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdEmbeddedFile.getMetadata());
    assertNull(actualPdEmbeddedFile.getFile());
    assertEquals(-1, actualPdEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualPdEmbeddedFile.getSize());
    assertEquals(0, actualPdEmbeddedFile.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdEmbeddedFile.getFilters());
  }

  /**
   * Test {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream, COSName)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return CheckSum is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream, COSName)}
   */
  @Test
  @DisplayName("Test new PDEmbeddedFile(PDDocument, InputStream, COSName); when PDDocument(); then return CheckSum is 'null'")
  void testNewPDEmbeddedFile_whenPDDocument_thenReturnCheckSumIsNull2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, input, null);

    // Assert
    assertNull(actualPdEmbeddedFile.getCheckSum());
    assertNull(actualPdEmbeddedFile.getMacCreator());
    assertNull(actualPdEmbeddedFile.getMacResFork());
    assertNull(actualPdEmbeddedFile.getMacSubtype());
    assertNull(actualPdEmbeddedFile.getSubtype());
    assertNull(actualPdEmbeddedFile.getCreationDate());
    assertNull(actualPdEmbeddedFile.getModDate());
    assertNull(actualPdEmbeddedFile.getDecodeParms());
    assertNull(actualPdEmbeddedFile.getFileDecodeParams());
    COSStream cOSObject = actualPdEmbeddedFile.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdEmbeddedFile.getMetadata());
    assertNull(actualPdEmbeddedFile.getFile());
    assertEquals(-1, input.read(new byte[]{}));
    assertEquals(-1, actualPdEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualPdEmbeddedFile.getSize());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(8, actualPdEmbeddedFile.getLength());
    assertEquals(8L, cOSObject.getLength());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.hasData());
    assertSame(fileFilters, actualPdEmbeddedFile.getFilters());
  }

  /**
   * Test {@link PDEmbeddedFile#setSubtype(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} Subtype is {@code Mime Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); then PDEmbeddedFile(COSStream) with str is COSStream() Subtype is 'Mime Type'")
  void testSetSubtype_thenPDEmbeddedFileWithStrIsCOSStreamSubtypeIsMimeType() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setSubtype("Mime Type");

    // Assert
    assertEquals("Mime Type", pdEmbeddedFile.getSubtype());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#setSubtype(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream(RandomAccessStreamCache)} Subtype is
   * {@code Mime Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setSubtype(String)}
   */
  @Test
  @DisplayName("Test setSubtype(String); then PDEmbeddedFile(COSStream) with str is COSStream(RandomAccessStreamCache) Subtype is 'Mime Type'")
  void testSetSubtype_thenPDEmbeddedFileWithStrIsCOSStreamSubtypeIsMimeType2() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream(new RandomAccessStreamCacheImpl()));

    // Act
    pdEmbeddedFile.setSubtype("Mime Type");

    // Assert
    assertEquals("Mime Type", pdEmbeddedFile.getSubtype());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#getSubtype()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getSubtype()}
   */
  @Test
  @DisplayName("Test getSubtype(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetSubtype_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getSubtype());
  }

  /**
   * Test {@link PDEmbeddedFile#getSize()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getSize()}
   */
  @Test
  @DisplayName("Test getSize(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return minus one")
  void testGetSize_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDEmbeddedFile(new COSStream())).getSize());
  }

  /**
   * Test {@link PDEmbeddedFile#setSize(int)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} Size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setSize(int)}
   */
  @Test
  @DisplayName("Test setSize(int); then PDEmbeddedFile(COSStream) with str is COSStream() Size is three")
  void testSetSize_thenPDEmbeddedFileWithStrIsCOSStreamSizeIsThree() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setSize(3);

    // Assert
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdEmbeddedFile.getSize());
  }

  /**
   * Test {@link PDEmbeddedFile#setSize(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} Size is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setSize(int)}
   */
  @Test
  @DisplayName("Test setSize(int); when MIN_VALUE; then PDEmbeddedFile(COSStream) with str is COSStream() Size is MIN_VALUE")
  void testSetSize_whenMin_value_thenPDEmbeddedFileWithStrIsCOSStreamSizeIsMin_value() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setSize(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdEmbeddedFile.getSize());
  }

  /**
   * Test {@link PDEmbeddedFile#getCreationDate()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getCreationDate()}
   */
  @Test
  @DisplayName("Test getCreationDate(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetCreationDate_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getCreationDate());
  }

  /**
   * Test {@link PDEmbeddedFile#setCreationDate(Calendar)}.
   * <p>
   * Method under test: {@link PDEmbeddedFile#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreationDate(Calendar)")
  void testSetCreationDate() throws IOException {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = pdEmbeddedFile.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(0, creationDate.getTimeZone().getDSTSavings());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDEmbeddedFile#setCreationDate(Calendar)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setCreationDate(Calendar)}
   */
  @Test
  @DisplayName("Test setCreationDate(Calendar); then PDEmbeddedFile(COSStream) with str is COSStream() COSObject Values size is one")
  void testSetCreationDate_thenPDEmbeddedFileWithStrIsCOSStreamCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setCreationDate(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#getModDate()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getModDate()}
   */
  @Test
  @DisplayName("Test getModDate(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetModDate_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getModDate());
  }

  /**
   * Test {@link PDEmbeddedFile#setModDate(Calendar)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setModDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModDate(Calendar); then PDEmbeddedFile(COSStream) with str is COSStream() COSObject Values size is one")
  void testSetModDate_thenPDEmbeddedFileWithStrIsCOSStreamCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setModDate(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#setModDate(Calendar)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} ModDate {@link GregorianCalendar}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setModDate(Calendar)}
   */
  @Test
  @DisplayName("Test setModDate(Calendar); then PDEmbeddedFile(COSStream) with str is COSStream() ModDate GregorianCalendar")
  void testSetModDate_thenPDEmbeddedFileWithStrIsCOSStreamModDateGregorianCalendar() throws IOException {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setModDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar modDate = pdEmbeddedFile.getModDate();
    assertTrue(modDate instanceof GregorianCalendar);
    assertEquals("gregory", modDate.getCalendarType());
    assertEquals(0, modDate.getTimeZone().getDSTSavings());
    assertEquals(1, modDate.getFirstDayOfWeek());
    assertEquals(1, modDate.getMinimalDaysInFirstWeek());
    assertEquals(1, modDate.getWeekYear());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(53, modDate.getWeeksInWeekYear());
    assertFalse(modDate.isLenient());
    assertTrue(modDate.isWeekDateSupported());
  }

  /**
   * Test {@link PDEmbeddedFile#getCheckSum()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getCheckSum()}
   */
  @Test
  @DisplayName("Test getCheckSum(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetCheckSum_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getCheckSum());
  }

  /**
   * Test {@link PDEmbeddedFile#setCheckSum(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} CheckSum is {@code Checksum}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setCheckSum(String)}
   */
  @Test
  @DisplayName("Test setCheckSum(String); then PDEmbeddedFile(COSStream) with str is COSStream() CheckSum is 'Checksum'")
  void testSetCheckSum_thenPDEmbeddedFileWithStrIsCOSStreamCheckSumIsChecksum() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setCheckSum("Checksum");

    // Assert
    assertEquals("Checksum", pdEmbeddedFile.getCheckSum());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#getMacSubtype()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getMacSubtype()}
   */
  @Test
  @DisplayName("Test getMacSubtype(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetMacSubtype_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacSubtype());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacSubtype(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacSubtype(String)}
   */
  @Test
  @DisplayName("Test setMacSubtype(String); then PDEmbeddedFile(COSStream) with str is COSStream() COSObject Values size is one")
  void testSetMacSubtype_thenPDEmbeddedFileWithStrIsCOSStreamCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacSubtype(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacSubtype(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} MacSubtype is {@code Mac Subtype}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacSubtype(String)}
   */
  @Test
  @DisplayName("Test setMacSubtype(String); then PDEmbeddedFile(COSStream) with str is COSStream() MacSubtype is 'Mac Subtype'")
  void testSetMacSubtype_thenPDEmbeddedFileWithStrIsCOSStreamMacSubtypeIsMacSubtype() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacSubtype("Mac Subtype");

    // Assert
    assertEquals("Mac Subtype", pdEmbeddedFile.getMacSubtype());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#getMacCreator()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getMacCreator()}
   */
  @Test
  @DisplayName("Test getMacCreator(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetMacCreator_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacCreator());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacCreator(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacCreator(String)}
   */
  @Test
  @DisplayName("Test setMacCreator(String); then PDEmbeddedFile(COSStream) with str is COSStream() COSObject Values size is one")
  void testSetMacCreator_thenPDEmbeddedFileWithStrIsCOSStreamCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacCreator(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacCreator(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} MacCreator is {@code Mac Creator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacCreator(String)}
   */
  @Test
  @DisplayName("Test setMacCreator(String); then PDEmbeddedFile(COSStream) with str is COSStream() MacCreator is 'Mac Creator'")
  void testSetMacCreator_thenPDEmbeddedFileWithStrIsCOSStreamMacCreatorIsMacCreator() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacCreator("Mac Creator");

    // Assert
    assertEquals("Mac Creator", pdEmbeddedFile.getMacCreator());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#getMacResFork()}.
   * <ul>
   *   <li>Given {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#getMacResFork()}
   */
  @Test
  @DisplayName("Test getMacResFork(); given PDEmbeddedFile(COSStream) with str is COSStream(); then return 'null'")
  void testGetMacResFork_givenPDEmbeddedFileWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacResFork());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacResFork(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacResFork(String)}
   */
  @Test
  @DisplayName("Test setMacResFork(String); then PDEmbeddedFile(COSStream) with str is COSStream() COSObject Values size is one")
  void testSetMacResFork_thenPDEmbeddedFileWithStrIsCOSStreamCOSObjectValuesSizeIsOne() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacResFork(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDEmbeddedFile#setMacResFork(String)}.
   * <ul>
   *   <li>Then {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)} with str is
   * {@link COSStream#COSStream()} MacResFork is {@code Mac Res Fork}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDEmbeddedFile#setMacResFork(String)}
   */
  @Test
  @DisplayName("Test setMacResFork(String); then PDEmbeddedFile(COSStream) with str is COSStream() MacResFork is 'Mac Res Fork'")
  void testSetMacResFork_thenPDEmbeddedFileWithStrIsCOSStreamMacResForkIsMacResFork() {
    // Arrange
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(new COSStream());

    // Act
    pdEmbeddedFile.setMacResFork("Mac Res Fork");

    // Assert
    assertEquals("Mac Res Fork", pdEmbeddedFile.getMacResFork());
    COSStream cOSObject = pdEmbeddedFile.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
