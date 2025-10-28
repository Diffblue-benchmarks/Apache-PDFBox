package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;

class PDComplexFileSpecificationDiffblueTest {
  /**
   * Method under test: {@link PDComplexFileSpecification#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDComplexFileSpecification()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  void testGetFilename() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFilename());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  void testGetFilename2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFilename());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFilename()}
   */
  @Test
  void testGetFilename3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFilename());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  void testGetFileUnicode() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileUnicode());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  void testGetFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileUnicode()}
   */
  @Test
  void testGetFileUnicode3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileUnicode("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileUnicode());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#setFileUnicode(String)}
   */
  @Test
  void testSetFileUnicode() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileUnicode("File");

    // Assert
    assertEquals("File", pdComplexFileSpecification.getFileUnicode());
    assertEquals("File", pdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  void testGetFile() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  void testGetFile2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("File");

    // Act and Assert
    assertEquals("File", pdComplexFileSpecification.getFile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFile()}
   */
  @Test
  void testGetFile3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFile("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#setFile(String)}
   */
  @Test
  void testSetFile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFile("File");

    // Assert
    assertEquals("File", pdComplexFileSpecification.getFile());
    assertEquals("File", pdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileDos()}
   */
  @Test
  void testGetFileDos() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileDos());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileMac()}
   */
  @Test
  void testGetFileMac() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileMac());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileUnix()}
   */
  @Test
  void testGetFileUnix() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileUnix());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  void testSetVolatile() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setVolatile(true);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#setVolatile(boolean)}
   */
  @Test
  void testSetVolatile2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setVolatile(false);

    // Assert
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  void testIsVolatile() {
    // Arrange, Act and Assert
    assertFalse((new PDComplexFileSpecification()).isVolatile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  void testIsVolatile2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(true);

    // Act and Assert
    assertTrue(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#isVolatile()}
   */
  @Test
  void testIsVolatile3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setVolatile(false);

    // Act and Assert
    assertFalse(pdComplexFileSpecification.isVolatile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  void testGetEmbeddedFile() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFile());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  void testGetEmbeddedFile2() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Act
    PDEmbeddedFile actualEmbeddedFile = pdComplexFileSpecification.getEmbeddedFile();

    // Assert
    assertNull(actualEmbeddedFile.getCheckSum());
    assertNull(actualEmbeddedFile.getMacCreator());
    assertNull(actualEmbeddedFile.getMacResFork());
    assertNull(actualEmbeddedFile.getMacSubtype());
    assertNull(actualEmbeddedFile.getSubtype());
    assertNull(actualEmbeddedFile.getCreationDate());
    assertNull(actualEmbeddedFile.getModDate());
    assertNull(actualEmbeddedFile.getDecodeParms());
    assertNull(actualEmbeddedFile.getFileDecodeParams());
    assertNull(actualEmbeddedFile.getMetadata());
    assertNull(actualEmbeddedFile.getFile());
    assertEquals(-1, actualEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFile.getSize());
    assertEquals(0, actualEmbeddedFile.getLength());
    List<String> fileFilters = actualEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFile.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFile.getFilters());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  void testGetEmbeddedFile3() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(file);

    // Act
    PDEmbeddedFile actualEmbeddedFile = pdComplexFileSpecification.getEmbeddedFile();

    // Assert
    assertNull(actualEmbeddedFile.getCheckSum());
    assertNull(actualEmbeddedFile.getMacCreator());
    assertNull(actualEmbeddedFile.getMacResFork());
    assertNull(actualEmbeddedFile.getMacSubtype());
    assertNull(actualEmbeddedFile.getSubtype());
    assertNull(actualEmbeddedFile.getCreationDate());
    assertNull(actualEmbeddedFile.getModDate());
    assertNull(actualEmbeddedFile.getDecodeParms());
    assertNull(actualEmbeddedFile.getFileDecodeParams());
    assertNull(actualEmbeddedFile.getMetadata());
    assertNull(actualEmbeddedFile.getFile());
    assertEquals(-1, actualEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFile.getSize());
    assertEquals(0, actualEmbeddedFile.getLength());
    List<String> fileFilters = actualEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFile.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFile.getFilters());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFile()}
   */
  @Test
  void testGetEmbeddedFile4() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(file);

    // Act
    PDEmbeddedFile actualEmbeddedFile = pdComplexFileSpecification.getEmbeddedFile();

    // Assert
    assertNull(actualEmbeddedFile.getCheckSum());
    assertNull(actualEmbeddedFile.getMacCreator());
    assertNull(actualEmbeddedFile.getMacResFork());
    assertNull(actualEmbeddedFile.getMacSubtype());
    assertNull(actualEmbeddedFile.getSubtype());
    assertNull(actualEmbeddedFile.getCreationDate());
    assertNull(actualEmbeddedFile.getModDate());
    assertNull(actualEmbeddedFile.getDecodeParms());
    assertNull(actualEmbeddedFile.getFileDecodeParams());
    assertNull(actualEmbeddedFile.getMetadata());
    assertNull(actualEmbeddedFile.getFile());
    assertEquals(-1, actualEmbeddedFile.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFile.getSize());
    assertEquals(0, actualEmbeddedFile.getLength());
    List<String> fileFilters = actualEmbeddedFile.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFile.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFile.getFilters());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile((COSStream) null));

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFile());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFile());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile4() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile5() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile6() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFile = pdComplexFileSpecification.getEmbeddedFile();
    assertNull(embeddedFile.getCheckSum());
    assertNull(embeddedFile.getMacCreator());
    assertNull(embeddedFile.getMacResFork());
    assertNull(embeddedFile.getMacSubtype());
    assertNull(embeddedFile.getSubtype());
    assertNull(embeddedFile.getCreationDate());
    assertNull(embeddedFile.getModDate());
    assertNull(embeddedFile.getDecodeParms());
    assertNull(embeddedFile.getFileDecodeParams());
    assertNull(embeddedFile.getMetadata());
    assertNull(embeddedFile.getFile());
    assertEquals(-1, embeddedFile.getDecodedStreamLength());
    assertEquals(-1, embeddedFile.getSize());
    assertEquals(0, embeddedFile.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFile.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFile(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFile7() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFile(null);

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFile());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  void testGetEmbeddedFileDos() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileDos());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  void testGetEmbeddedFileDos2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileDos());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileDos()}
   */
  @Test
  void testGetEmbeddedFileDos3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileDos());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  void testGetEmbeddedFileMac() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileMac());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  void testGetEmbeddedFileMac2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileMac());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileMac()}
   */
  @Test
  void testGetEmbeddedFileMac3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileMac());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  void testGetEmbeddedFileUnix() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileUnix());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  void testGetEmbeddedFileUnix2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnix());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getEmbeddedFileUnix()}
   */
  @Test
  void testGetEmbeddedFileUnix3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnix());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  void testGetEmbeddedFileUnicode() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getEmbeddedFileUnicode());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  void testGetEmbeddedFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act and Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  void testGetEmbeddedFileUnicode3() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    assertNull(actualEmbeddedFileUnicode.getCheckSum());
    assertNull(actualEmbeddedFileUnicode.getMacCreator());
    assertNull(actualEmbeddedFileUnicode.getMacResFork());
    assertNull(actualEmbeddedFileUnicode.getMacSubtype());
    assertNull(actualEmbeddedFileUnicode.getSubtype());
    assertNull(actualEmbeddedFileUnicode.getCreationDate());
    assertNull(actualEmbeddedFileUnicode.getModDate());
    assertNull(actualEmbeddedFileUnicode.getDecodeParms());
    assertNull(actualEmbeddedFileUnicode.getFileDecodeParams());
    assertNull(actualEmbeddedFileUnicode.getMetadata());
    assertNull(actualEmbeddedFileUnicode.getFile());
    assertEquals(-1, actualEmbeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileUnicode.getSize());
    assertEquals(0, actualEmbeddedFileUnicode.getLength());
    List<String> fileFilters = actualEmbeddedFileUnicode.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFileUnicode.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileUnicode.getFilters());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  void testGetEmbeddedFileUnicode4() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFileUnicode(file);

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    assertNull(actualEmbeddedFileUnicode.getCheckSum());
    assertNull(actualEmbeddedFileUnicode.getMacCreator());
    assertNull(actualEmbeddedFileUnicode.getMacResFork());
    assertNull(actualEmbeddedFileUnicode.getMacSubtype());
    assertNull(actualEmbeddedFileUnicode.getSubtype());
    assertNull(actualEmbeddedFileUnicode.getCreationDate());
    assertNull(actualEmbeddedFileUnicode.getModDate());
    assertNull(actualEmbeddedFileUnicode.getDecodeParms());
    assertNull(actualEmbeddedFileUnicode.getFileDecodeParams());
    assertNull(actualEmbeddedFileUnicode.getMetadata());
    assertNull(actualEmbeddedFileUnicode.getFile());
    assertEquals(-1, actualEmbeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileUnicode.getSize());
    assertEquals(0, actualEmbeddedFileUnicode.getLength());
    List<String> fileFilters = actualEmbeddedFileUnicode.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFileUnicode.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileUnicode.getFilters());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#getEmbeddedFileUnicode()}
   */
  @Test
  void testGetEmbeddedFileUnicode5() throws IOException {
    // Arrange
    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));
    PDEmbeddedFile file = new PDEmbeddedFile(str);

    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));
    pdComplexFileSpecification.setEmbeddedFileUnicode(file);

    // Act
    PDEmbeddedFile actualEmbeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();

    // Assert
    assertNull(actualEmbeddedFileUnicode.getCheckSum());
    assertNull(actualEmbeddedFileUnicode.getMacCreator());
    assertNull(actualEmbeddedFileUnicode.getMacResFork());
    assertNull(actualEmbeddedFileUnicode.getMacSubtype());
    assertNull(actualEmbeddedFileUnicode.getSubtype());
    assertNull(actualEmbeddedFileUnicode.getCreationDate());
    assertNull(actualEmbeddedFileUnicode.getModDate());
    assertNull(actualEmbeddedFileUnicode.getDecodeParms());
    assertNull(actualEmbeddedFileUnicode.getFileDecodeParams());
    assertNull(actualEmbeddedFileUnicode.getMetadata());
    assertNull(actualEmbeddedFileUnicode.getFile());
    assertEquals(-1, actualEmbeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, actualEmbeddedFileUnicode.getSize());
    assertEquals(0, actualEmbeddedFileUnicode.getLength());
    List<String> fileFilters = actualEmbeddedFileUnicode.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualEmbeddedFileUnicode.getCOSObject());
    assertSame(fileFilters, actualEmbeddedFileUnicode.getFilters());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile((COSStream) null));

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode4() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));
    COSStream str = new COSStream();

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode5() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode6() throws IOException {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(new PDEmbeddedFile(str));

    // Assert
    PDEmbeddedFile embeddedFileUnicode = pdComplexFileSpecification.getEmbeddedFileUnicode();
    assertNull(embeddedFileUnicode.getCheckSum());
    assertNull(embeddedFileUnicode.getMacCreator());
    assertNull(embeddedFileUnicode.getMacResFork());
    assertNull(embeddedFileUnicode.getMacSubtype());
    assertNull(embeddedFileUnicode.getSubtype());
    assertNull(embeddedFileUnicode.getCreationDate());
    assertNull(embeddedFileUnicode.getModDate());
    assertNull(embeddedFileUnicode.getDecodeParms());
    assertNull(embeddedFileUnicode.getFileDecodeParams());
    assertNull(embeddedFileUnicode.getMetadata());
    assertNull(embeddedFileUnicode.getFile());
    assertEquals(-1, embeddedFileUnicode.getDecodedStreamLength());
    assertEquals(-1, embeddedFileUnicode.getSize());
    assertEquals(0, embeddedFileUnicode.getLength());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, embeddedFileUnicode.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setEmbeddedFileUnicode(PDEmbeddedFile)}
   */
  @Test
  void testSetEmbeddedFileUnicode7() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setEmbeddedFile(new PDEmbeddedFile(new COSStream()));

    // Act
    pdComplexFileSpecification.setEmbeddedFileUnicode(null);

    // Assert
    assertNull(pdComplexFileSpecification.getEmbeddedFileUnicode());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#setFileDescription(String)}
   */
  @Test
  void testSetFileDescription() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();

    // Act
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Assert
    assertEquals("The characteristics of someone or something", pdComplexFileSpecification.getFileDescription());
    COSDictionary cOSObject = pdComplexFileSpecification.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  void testGetFileDescription() {
    // Arrange, Act and Assert
    assertNull((new PDComplexFileSpecification()).getFileDescription());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  void testGetFileDescription2() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("The characteristics of someone or something");

    // Act and Assert
    assertEquals("The characteristics of someone or something", pdComplexFileSpecification.getFileDescription());
  }

  /**
   * Method under test: {@link PDComplexFileSpecification#getFileDescription()}
   */
  @Test
  void testGetFileDescription3() {
    // Arrange
    PDComplexFileSpecification pdComplexFileSpecification = new PDComplexFileSpecification();
    pdComplexFileSpecification.setFileDescription("");

    // Act and Assert
    assertEquals("", pdComplexFileSpecification.getFileDescription());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification()}
   */
  @Test
  void testNewPDComplexFileSpecification() {
    // Arrange and Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification();

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = actualPdComplexFileSpecification.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  void testNewPDComplexFileSpecification2() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification(dict);

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertSame(dict, actualPdComplexFileSpecification.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDComplexFileSpecification#PDComplexFileSpecification(COSDictionary)}
   */
  @Test
  void testNewPDComplexFileSpecification3() {
    // Arrange and Act
    PDComplexFileSpecification actualPdComplexFileSpecification = new PDComplexFileSpecification(null);

    // Assert
    assertNull(actualPdComplexFileSpecification.getFile());
    assertNull(actualPdComplexFileSpecification.getFileDescription());
    assertNull(actualPdComplexFileSpecification.getFileDos());
    assertNull(actualPdComplexFileSpecification.getFileMac());
    assertNull(actualPdComplexFileSpecification.getFileUnicode());
    assertNull(actualPdComplexFileSpecification.getFileUnix());
    assertNull(actualPdComplexFileSpecification.getFilename());
    COSDictionary cOSObject = actualPdComplexFileSpecification.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFile());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileDos());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileMac());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnicode());
    assertNull(actualPdComplexFileSpecification.getEmbeddedFileUnix());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdComplexFileSpecification.isVolatile());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
