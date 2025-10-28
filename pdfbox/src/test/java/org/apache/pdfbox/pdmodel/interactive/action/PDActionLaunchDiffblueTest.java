package org.apache.pdfbox.pdmodel.interactive.action;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.Test;

class PDActionLaunchDiffblueTest {
  /**
   * Method under test: {@link PDActionLaunch#getFile()}
   */
  @Test
  void testGetFile() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getFile());
  }

  /**
   * Method under test: {@link PDActionLaunch#getFile()}
   */
  @Test
  void testGetFile2() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("foo");

    // Act
    PDFileSpecification actualFile = pdActionLaunch.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("666F6F", ((COSString) cOSObject).toHexString());
    assertEquals("foo", ((COSString) cOSObject).getASCII());
    assertEquals("foo", ((COSString) cOSObject).getString());
    assertEquals("foo", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSObject).getBytes());
  }

  /**
   * Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(pdActionLaunch.getF());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile2() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    assertEquals("", pdActionLaunch.getF());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionLaunch#setFile(PDFileSpecification)}
   */
  @Test
  void testSetFile3() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setFile(null);

    // Assert
    assertNull(pdActionLaunch.getF());
    assertNull(pdActionLaunch.getFile());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  void testGetWinLaunchParams() {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getWinLaunchParams());
  }

  /**
   * Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  void testGetWinLaunchParams2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams());

    // Act
    PDWindowsLaunchParams actualWinLaunchParams = pdActionLaunch.getWinLaunchParams();

    // Assert
    assertNull(actualWinLaunchParams.getDirectory());
    assertNull(actualWinLaunchParams.getExecuteParam());
    assertNull(actualWinLaunchParams.getFilename());
    COSDictionary cOSObject = actualWinLaunchParams.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, actualWinLaunchParams.getOperation());
  }

  /**
   * Method under test: {@link PDActionLaunch#getWinLaunchParams()}
   */
  @Test
  void testGetWinLaunchParams3() {
    // Arrange
    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));
    PDWindowsLaunchParams win = new PDWindowsLaunchParams(p);

    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setWinLaunchParams(win);

    // Act
    PDWindowsLaunchParams actualWinLaunchParams = pdActionLaunch.getWinLaunchParams();

    // Assert
    assertNull(actualWinLaunchParams.getDirectory());
    assertNull(actualWinLaunchParams.getExecuteParam());
    assertNull(actualWinLaunchParams.getFilename());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, actualWinLaunchParams.getOperation());
    assertSame(p, actualWinLaunchParams.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  void testSetWinLaunchParams() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams());

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
  }

  /**
   * Method under test:
   * {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  void testSetWinLaunchParams2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setWinLaunchParams(null);

    // Assert
    assertNull(pdActionLaunch.getWinLaunchParams());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  void testSetWinLaunchParams3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary p = new COSDictionary();
    p.setDirect(true);

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams(p));

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
    assertSame(p, winLaunchParams.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDActionLaunch#setWinLaunchParams(PDWindowsLaunchParams)}
   */
  @Test
  void testSetWinLaunchParams4() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    COSDictionary p = new COSDictionary();
    p.setKey(new COSObjectKey(1L, 1));

    // Act
    pdActionLaunch.setWinLaunchParams(new PDWindowsLaunchParams(p));

    // Assert
    PDWindowsLaunchParams winLaunchParams = pdActionLaunch.getWinLaunchParams();
    assertNull(winLaunchParams.getDirectory());
    assertNull(winLaunchParams.getExecuteParam());
    assertNull(winLaunchParams.getFilename());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDWindowsLaunchParams.OPERATION_OPEN, winLaunchParams.getOperation());
    assertSame(p, winLaunchParams.getCOSObject());
  }

  /**
   * Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  void testGetF() {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getF());
  }

  /**
   * Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  void testGetF2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getF());
  }

  /**
   * Method under test: {@link PDActionLaunch#getF()}
   */
  @Test
  void testGetF3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setF("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getF());
  }

  /**
   * Method under test: {@link PDActionLaunch#setF(String)}
   */
  @Test
  void testSetF() throws IOException {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setF("foo");

    // Assert
    PDFileSpecification file = pdActionLaunch.getFile();
    COSBase cOSObject = file.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("666F6F", ((COSString) cOSObject).toHexString());
    assertEquals("foo", ((COSString) cOSObject).getASCII());
    assertEquals("foo", ((COSString) cOSObject).getString());
    assertEquals("foo", file.getFile());
    assertEquals("foo", pdActionLaunch.getF());
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    byte[] expectedBytes = "foo".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSObject).getBytes());
  }

  /**
   * Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  void testGetD() {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getD());
  }

  /**
   * Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  void testGetD2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setD("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getD());
  }

  /**
   * Method under test: {@link PDActionLaunch#getD()}
   */
  @Test
  void testGetD3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setD("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getD());
  }

  /**
   * Method under test: {@link PDActionLaunch#setD(String)}
   */
  @Test
  void testSetD() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setD("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getD());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  void testGetO() {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getO());
  }

  /**
   * Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  void testGetO2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setO("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getO());
  }

  /**
   * Method under test: {@link PDActionLaunch#getO()}
   */
  @Test
  void testGetO3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setO("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getO());
  }

  /**
   * Method under test: {@link PDActionLaunch#setO(String)}
   */
  @Test
  void testSetO() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setO("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getO());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  void testGetP() {
    // Arrange, Act and Assert
    assertNull((new PDActionLaunch()).getP());
  }

  /**
   * Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  void testGetP2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setP("foo");

    // Act and Assert
    assertEquals("foo", pdActionLaunch.getP());
  }

  /**
   * Method under test: {@link PDActionLaunch#getP()}
   */
  @Test
  void testGetP3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();
    pdActionLaunch.setP("");

    // Act and Assert
    assertEquals("", pdActionLaunch.getP());
  }

  /**
   * Method under test: {@link PDActionLaunch#setP(String)}
   */
  @Test
  void testSetP() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setP("foo");

    // Assert
    assertEquals("foo", pdActionLaunch.getP());
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDActionLaunch#getOpenInNewWindow()}
   */
  @Test
  void testGetOpenInNewWindow() {
    // Arrange, Act and Assert
    assertEquals(OpenMode.USER_PREFERENCE, (new PDActionLaunch()).getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.USER_PREFERENCE);

    // Assert
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow2() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.SAME_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.SAME_WINDOW, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionLaunch#setOpenInNewWindow(OpenMode)}
   */
  @Test
  void testSetOpenInNewWindow3() {
    // Arrange
    PDActionLaunch pdActionLaunch = new PDActionLaunch();

    // Act
    pdActionLaunch.setOpenInNewWindow(OpenMode.NEW_WINDOW);

    // Assert
    COSDictionary cOSObject = pdActionLaunch.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.NEW_WINDOW, pdActionLaunch.getOpenInNewWindow());
  }

  /**
   * Method under test: {@link PDActionLaunch#PDActionLaunch(COSDictionary)}
   */
  @Test
  void testNewPDActionLaunch() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new PDActionLaunch(a)).getCOSObject());
  }

  /**
   * Method under test: {@link PDActionLaunch#PDActionLaunch()}
   */
  @Test
  void testNewPDActionLaunch2() throws IOException {
    // Arrange and Act
    PDActionLaunch actualPdActionLaunch = new PDActionLaunch();

    // Assert
    assertNull(actualPdActionLaunch.getD());
    assertNull(actualPdActionLaunch.getF());
    assertNull(actualPdActionLaunch.getO());
    assertNull(actualPdActionLaunch.getP());
    assertNull(actualPdActionLaunch.getNext());
    COSDictionary cOSObject = actualPdActionLaunch.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdActionLaunch.getFile());
    assertNull(actualPdActionLaunch.getWinLaunchParams());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, actualPdActionLaunch.getOpenInNewWindow());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(PDAction.TYPE, actualPdActionLaunch.getType());
    assertEquals(PDActionLaunch.SUB_TYPE, actualPdActionLaunch.getSubType());
  }
}
