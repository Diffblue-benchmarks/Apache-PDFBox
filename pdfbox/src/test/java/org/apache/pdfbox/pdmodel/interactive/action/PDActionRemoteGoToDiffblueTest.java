package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;

class PDActionRemoteGoToDiffblueTest {
  /**
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo()).getFile());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionRemoteGoTo.getFile();

    // Assert
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFile).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFile).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFile).getFilename());
    assertNull(actualFile.getFile());
    COSBase cOSObject = actualFile.getCOSObject();
    COSUpdateState updateState = ((COSDictionary) cOSObject).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertEquals(1, ((COSDictionary) cOSObject).getValues().size());
    assertEquals(1, ((COSDictionary) cOSObject).size());
    COSIncrement toIncrementResult = ((COSDictionary) cOSObject).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSDictionary) cOSObject).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  void testGetFile3() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionRemoteGoTo.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getFile()}
   */
  @Test
  void testGetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(d);

    // Act
    PDFileSpecification actualFile = pdActionRemoteGoTo.getFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFile);
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setFile(null);

    // Assert
    assertNull(pdActionRemoteGoTo.getFile());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(d);

    // Act
    pdActionRemoteGoTo.setFile(new PDComplexFileSpecification());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDFileSpecification file = pdActionRemoteGoTo.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  void testGetD() {
    // Arrange, Act and Assert
    assertNull((new PDActionRemoteGoTo()).getD());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  void testGetD2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(d);

    // Act
    COSBase actualD = pdActionRemoteGoTo.getD();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(d, actualD);
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getD()}
   */
  @Test
  void testGetD3() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualD = pdActionRemoteGoTo.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSBoolean d = COSBoolean.FALSE;

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedD = d.FALSE;
    assertSame(expectedD, pdActionRemoteGoTo.getD());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD2() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSDictionary d = new COSDictionary();

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD3() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSArray d = new COSArray();

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD4() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(null);

    // Assert
    assertNull(pdActionRemoteGoTo.getD());
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD5() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setD(COSBase)}
   */
  @Test
  void testSetD6() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray d = new COSArray();
    d.add(object);

    // Act
    pdActionRemoteGoTo.setD(d);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionRemoteGoTo.getD());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getOpenInNewWindow()}
   */
  @Test
  void testGetOpenInNewWindow() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionRemoteGoTo()).getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#getOpenInNewWindow()}
   */
  @Test
  void testGetOpenInNewWindow2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(d);

    // Act
    OpenMode actualOpenInNewWindow = pdActionRemoteGoTo.getOpenInNewWindow();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(OpenMode.USER_PREFERENCE, actualOpenInNewWindow);
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow2() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.SAME_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.SAME_WINDOW, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow3() {
    // Arrange
    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.NEW_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.NEW_WINDOW, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionRemoteGoTo pdActionRemoteGoTo = new PDActionRemoteGoTo();
    pdActionRemoteGoTo.setD(d);

    // Act
    pdActionRemoteGoTo.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdActionRemoteGoTo.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionRemoteGoTo.getOpenInNewWindow());
  }

  /**
   * Method under test:
   * {@link PDActionRemoteGoTo#PDActionRemoteGoTo(COSDictionary)}
   */
  @Test
  void testNewPDActionRemoteGoTo() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionRemoteGoTo(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionRemoteGoTo#PDActionRemoteGoTo()}
   */
  @Test
  void testNewPDActionRemoteGoTo2() throws IOException {
    // Arrange and Act
    PDActionRemoteGoTo actualPdActionRemoteGoTo = new PDActionRemoteGoTo();

    // Assert
    assertNull(actualPdActionRemoteGoTo.getNext());
    assertNull(actualPdActionRemoteGoTo.getD());
    COSDictionary cOSObject = actualPdActionRemoteGoTo.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionRemoteGoTo.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionRemoteGoTo.getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionRemoteGoTo.getType());
    assertEquals(PDActionRemoteGoTo.SUB_TYPE, actualPdActionRemoteGoTo.getSubType());
  }
}
