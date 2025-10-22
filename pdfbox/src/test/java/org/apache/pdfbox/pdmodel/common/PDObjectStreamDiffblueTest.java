package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDObjectStreamDiffblueTest {
  /**
   * Test {@link PDObjectStream#PDObjectStream(COSStream)}.
   * <p>
   * Method under test: {@link PDObjectStream#PDObjectStream(COSStream)}
   */
  @Test
  @DisplayName("Test new PDObjectStream(COSStream)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectStream.<init>(COSStream)"})
  void testNewPDObjectStream() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, (new PDObjectStream(str)).getCOSObject());
  }

  /**
   * Test {@link PDObjectStream#createStream(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Type is {@code ObjStm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#createStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createStream(PDDocument); when PDDocument(); then return Type is 'ObjStm'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDObjectStream PDObjectStream.createStream(PDDocument)"})
  void testCreateStream_whenPDDocument_thenReturnTypeIsObjStm() throws IOException {
    // Arrange and Act
    PDObjectStream actualCreateStreamResult = PDObjectStream.createStream(new PDDocument());

    // Assert
    assertEquals("ObjStm", actualCreateStreamResult.getType());
    assertNull(actualCreateStreamResult.getDecodeParms());
    assertNull(actualCreateStreamResult.getFileDecodeParams());
    assertNull(actualCreateStreamResult.getMetadata());
    assertNull(actualCreateStreamResult.getExtends());
    assertNull(actualCreateStreamResult.getFile());
    assertEquals(-1, actualCreateStreamResult.getDecodedStreamLength());
    assertEquals(0, actualCreateStreamResult.getFirstByteOffset());
    assertEquals(0, actualCreateStreamResult.getNumberOfObjects());
    assertEquals(0, actualCreateStreamResult.getLength());
    List<String> fileFilters = actualCreateStreamResult.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualCreateStreamResult.getFilters());
  }

  /**
   * Test {@link PDObjectStream#getType()}.
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code ObjStm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  @DisplayName("Test getType(); given createStream PDDocument(); then return 'ObjStm'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDObjectStream.getType()"})
  void testGetType_givenCreateStreamPDDocument_thenReturnObjStm() {
    // Arrange, Act and Assert
    assertEquals("ObjStm", PDObjectStream.createStream(new PDDocument()).getType());
  }

  /**
   * Test {@link PDObjectStream#getType()}.
   * <ul>
   *   <li>Given {@link PDObjectStream#PDObjectStream(COSStream)} with str is {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  @DisplayName("Test getType(); given PDObjectStream(COSStream) with str is COSStream(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDObjectStream.getType()"})
  void testGetType_givenPDObjectStreamWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDObjectStream(new COSStream())).getType());
  }

  /**
   * Test {@link PDObjectStream#getNumberOfObjects()}.
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#getNumberOfObjects()}
   */
  @Test
  @DisplayName("Test getNumberOfObjects(); given createStream PDDocument(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDObjectStream.getNumberOfObjects()"})
  void testGetNumberOfObjects_givenCreateStreamPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PDObjectStream.createStream(new PDDocument()).getNumberOfObjects());
  }

  /**
   * Test {@link PDObjectStream#setNumberOfObjects(int)}.
   * <ul>
   *   <li>Then createStream {@link PDDocument#PDDocument()} NumberOfObjects is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#setNumberOfObjects(int)}
   */
  @Test
  @DisplayName("Test setNumberOfObjects(int); then createStream PDDocument() NumberOfObjects is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectStream.setNumberOfObjects(int)"})
  void testSetNumberOfObjects_thenCreateStreamPDDocumentNumberOfObjectsIsOne() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setNumberOfObjects(1);

    // Assert
    assertEquals(1, createStreamResult.getNumberOfObjects());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDObjectStream#getFirstByteOffset()}.
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#getFirstByteOffset()}
   */
  @Test
  @DisplayName("Test getFirstByteOffset(); given createStream PDDocument(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDObjectStream.getFirstByteOffset()"})
  void testGetFirstByteOffset_givenCreateStreamPDDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, PDObjectStream.createStream(new PDDocument()).getFirstByteOffset());
  }

  /**
   * Test {@link PDObjectStream#setFirstByteOffset(int)}.
   * <ul>
   *   <li>Then createStream {@link PDDocument#PDDocument()} FirstByteOffset is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#setFirstByteOffset(int)}
   */
  @Test
  @DisplayName("Test setFirstByteOffset(int); then createStream PDDocument() FirstByteOffset is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDObjectStream.setFirstByteOffset(int)"})
  void testSetFirstByteOffset_thenCreateStreamPDDocumentFirstByteOffsetIsOne() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setFirstByteOffset(1);

    // Assert
    assertEquals(1, createStreamResult.getFirstByteOffset());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDObjectStream#getExtends()}.
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDObjectStream#getExtends()}
   */
  @Test
  @DisplayName("Test getExtends(); given createStream PDDocument(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDObjectStream PDObjectStream.getExtends()"})
  void testGetExtends_givenCreateStreamPDDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDObjectStream.createStream(new PDDocument()).getExtends());
  }
}
