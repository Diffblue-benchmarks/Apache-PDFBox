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

class PDActionThreadDiffblueTest {
  /**
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  void testGetD() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getD());
  }

  /**
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  void testGetD2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(d);

    // Act
    COSBase actualD = pdActionThread.getD();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(d, actualD);
  }

  /**
   * Method under test: {@link PDActionThread#getD()}
   */
  @Test
  void testGetD3() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act
    COSBase actualD = pdActionThread.getD();

    // Assert
    assertSame(((COSBoolean) actualD).FALSE, actualD);
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSBoolean d = COSBoolean.FALSE;

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedD = d.FALSE;
    assertSame(expectedD, pdActionThread.getD());
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD2() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSDictionary d = new COSDictionary();

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD3() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSArray d = new COSArray();

    // Act
    pdActionThread.setD(d);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD4() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(null);

    // Assert
    assertNull(pdActionThread.getD());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD5() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setD(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setD(COSBase)}
   */
  @Test
  void testSetD6() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray d = new COSArray();
    d.add(object);

    // Act
    pdActionThread.setD(d);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(d, pdActionThread.getD());
  }

  /**
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getFile());
  }

  /**
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionThread.getFile();

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
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  void testGetFile3() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdActionThread.getFile();

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
   * Method under test: {@link PDActionThread#getFile()}
   */
  @Test
  void testGetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(d);

    // Act
    PDFileSpecification actualFile = pdActionThread.getFile();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualFile);
  }

  /**
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionThread.getFile();
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
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionThread.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setFile(null);

    // Assert
    assertNull(pdActionThread.getFile());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(d);

    // Act
    pdActionThread.setFile(new PDComplexFileSpecification());

    // Assert
    verify(streamCacheCreateFunction).create();
    PDFileSpecification file = pdActionThread.getFile();
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
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionThread#getB()}
   */
  @Test
  void testGetB() {
    // Arrange, Act and Assert
    assertNull((new PDActionThread()).getB());
  }

  /**
   * Method under test: {@link PDActionThread#getB()}
   */
  @Test
  void testGetB2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument d = new COSDocument(streamCacheCreateFunction);

    PDActionThread pdActionThread = new PDActionThread();
    pdActionThread.setD(d);

    // Act
    COSBase actualB = pdActionThread.getB();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertNull(actualB);
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSBoolean b = COSBoolean.FALSE;

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSBoolean expectedB = b.FALSE;
    assertSame(expectedB, pdActionThread.getB());
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB2() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSDictionary b = new COSDictionary();

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB3() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSArray b = new COSArray();

    // Act
    pdActionThread.setB(b);

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB4() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(null);

    // Assert
    assertNull(pdActionThread.getB());
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB5() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();

    // Act
    pdActionThread.setB(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionThread#setB(COSBase)}
   */
  @Test
  void testSetB6() {
    // Arrange
    PDActionThread pdActionThread = new PDActionThread();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray b = new COSArray();
    b.add(object);

    // Act
    pdActionThread.setB(b);

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdActionThread.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(b, pdActionThread.getB());
  }

  /**
   * Method under test: {@link PDActionThread#PDActionThread(COSDictionary)}
   */
  @Test
  void testNewPDActionThread() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionThread(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionThread#PDActionThread()}
   */
  @Test
  void testNewPDActionThread2() throws IOException {
    // Arrange and Act
    PDActionThread actualPdActionThread = new PDActionThread();

    // Assert
    assertNull(actualPdActionThread.getNext());
    assertNull(actualPdActionThread.getB());
    assertNull(actualPdActionThread.getD());
    COSDictionary cOSObject = actualPdActionThread.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionThread.getFile());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionThread.getType());
    assertEquals(PDActionThread.SUB_TYPE, actualPdActionThread.getSubType());
  }
}
