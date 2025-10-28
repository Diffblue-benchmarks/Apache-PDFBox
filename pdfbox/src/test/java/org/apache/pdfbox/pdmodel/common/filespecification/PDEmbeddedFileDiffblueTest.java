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
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDEmbeddedFileDiffblueTest {
  /**
   * Method under test: {@link PDEmbeddedFile#setSubtype(String)}
   */
  @Test
  void testSetSubtype() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setSubtype("Mime Type");

    // Assert
    assertEquals("Mime Type", pdEmbeddedFile.getSubtype());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setSubtype(String)}
   */
  @Test
  void testSetSubtype2() {
    // Arrange
    COSStream str = new COSStream(new RandomAccessStreamCacheImpl());
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setSubtype("Mime Type");

    // Assert
    assertEquals("Mime Type", pdEmbeddedFile.getSubtype());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getSubtype()}
   */
  @Test
  void testGetSubtype() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getSubtype());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getSize()}
   */
  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDEmbeddedFile(new COSStream())).getSize());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setSize(int)}
   */
  @Test
  void testSetSize() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setSize(3);

    // Assert
    assertEquals(3, pdEmbeddedFile.getSize());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setSize(int)}
   */
  @Test
  void testSetSize2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setSize(Integer.MIN_VALUE);

    // Assert
    assertEquals(Integer.MIN_VALUE, pdEmbeddedFile.getSize());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getCreationDate()}
   */
  @Test
  void testGetCreationDate() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getCreationDate());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

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
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setCreationDate(null);

    // Assert that nothing has changed
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getModDate()}
   */
  @Test
  void testGetModDate() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getModDate());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setModDate(Calendar)}
   */
  @Test
  void testSetModDate() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

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
    assertEquals(53, modDate.getWeeksInWeekYear());
    assertFalse(modDate.isLenient());
    assertTrue(modDate.isWeekDateSupported());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setModDate(Calendar)}
   */
  @Test
  void testSetModDate2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setModDate(null);

    // Assert that nothing has changed
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getCheckSum()}
   */
  @Test
  void testGetCheckSum() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getCheckSum());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setCheckSum(String)}
   */
  @Test
  void testSetCheckSum() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setCheckSum("Checksum");

    // Assert
    assertEquals("Checksum", pdEmbeddedFile.getCheckSum());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getMacSubtype()}
   */
  @Test
  void testGetMacSubtype() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacSubtype());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacSubtype(String)}
   */
  @Test
  void testSetMacSubtype() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacSubtype("Mac Subtype");

    // Assert
    assertEquals("Mac Subtype", pdEmbeddedFile.getMacSubtype());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacSubtype(String)}
   */
  @Test
  void testSetMacSubtype2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacSubtype(null);

    // Assert that nothing has changed
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getMacCreator()}
   */
  @Test
  void testGetMacCreator() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacCreator());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacCreator(String)}
   */
  @Test
  void testSetMacCreator() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacCreator("Mac Creator");

    // Assert
    assertEquals("Mac Creator", pdEmbeddedFile.getMacCreator());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacCreator(String)}
   */
  @Test
  void testSetMacCreator2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacCreator(null);

    // Assert that nothing has changed
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#getMacResFork()}
   */
  @Test
  void testGetMacResFork() {
    // Arrange, Act and Assert
    assertNull((new PDEmbeddedFile(new COSStream())).getMacResFork());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacResFork(String)}
   */
  @Test
  void testSetMacResFork() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacResFork("Mac Res Fork");

    // Assert
    assertEquals("Mac Res Fork", pdEmbeddedFile.getMacResFork());
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#setMacResFork(String)}
   */
  @Test
  void testSetMacResFork2() {
    // Arrange
    COSStream str = new COSStream();
    PDEmbeddedFile pdEmbeddedFile = new PDEmbeddedFile(str);

    // Act
    pdEmbeddedFile.setMacResFork(null);

    // Assert that nothing has changed
    assertSame(str, pdEmbeddedFile.getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#PDEmbeddedFile(COSStream)}
   */
  @Test
  void testNewPDEmbeddedFile() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDEmbeddedFile(str)).getCOSObject());
  }

  /**
   * Method under test: {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument)}
   */
  @Test
  void testNewPDEmbeddedFile2() throws IOException {
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
   * Method under test: {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument)}
   */
  @Test
  void testNewPDEmbeddedFile3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(new PDDocument(streamCacheCreateFunction));

    // Assert
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
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = actualPdEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, actualPdEmbeddedFile.getFilters());
  }

  /**
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  void testNewPDEmbeddedFile4() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, str);

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
    assertEquals(-1, str.read(new byte[]{}));
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
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  void testNewPDEmbeddedFile5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDEmbeddedFile actualPdEmbeddedFile = new PDEmbeddedFile(doc, str);

    // Assert
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
    assertEquals(-1, str.read(new byte[]{}));
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
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  void testNewPDEmbeddedFile6() throws IOException {
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
    assertEquals(-1, str.read(new byte[]{}));
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
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream)}
   */
  @Test
  void testNewPDEmbeddedFile7() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenThrow(new IOException("foo"));
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
   * Method under test:
   * {@link PDEmbeddedFile#PDEmbeddedFile(PDDocument, InputStream, COSName)}
   */
  @Test
  void testNewPDEmbeddedFile8() throws IOException {
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
}
