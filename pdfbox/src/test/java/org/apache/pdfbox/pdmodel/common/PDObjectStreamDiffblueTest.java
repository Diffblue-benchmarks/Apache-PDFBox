package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDObjectStreamDiffblueTest {
  /**
   * Test {@link PDObjectStream#PDObjectStream(COSStream)}.
   *
   * <p>Method under test: {@link PDObjectStream#PDObjectStream(COSStream)}
   */
  @Test
  @DisplayName("Test new PDObjectStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectStream.<init>(COSStream)"})
  void testNewPDObjectStream() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, new PDObjectStream(str).getCOSObject());
  }

  /**
   * Test {@link PDObjectStream#createStream(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return Type is {@code ObjStm}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#createStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createStream(PDDocument); when PDDocument(); then return Type is 'ObjStm'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code ObjStm}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  @DisplayName("Test getType(); given createStream PDDocument(); then return 'ObjStm'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDObjectStream.getType()"})
  void testGetType_givenCreateStreamPDDocument_thenReturnObjStm() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act and Assert
    assertEquals("ObjStm", createStreamResult.getType());
  }

  /**
   * Test {@link PDObjectStream#getType()}.
   *
   * <ul>
   *   <li>Given {@link PDObjectStream#PDObjectStream(COSStream)} with str is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#getType()}
   */
  @Test
  @DisplayName(
      "Test getType(); given PDObjectStream(COSStream) with str is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDObjectStream.getType()"})
  void testGetType_givenPDObjectStreamWithStrIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDObjectStream(new COSStream()).getType());
  }

  /**
   * Test {@link PDObjectStream#getNumberOfObjects()}.
   *
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#getNumberOfObjects()}
   */
  @Test
  @DisplayName("Test getNumberOfObjects(); given createStream PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDObjectStream.getNumberOfObjects()"})
  void testGetNumberOfObjects_givenCreateStreamPDDocument_thenReturnZero() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act and Assert
    assertEquals(0, createStreamResult.getNumberOfObjects());
  }

  /**
   * Test {@link PDObjectStream#setNumberOfObjects(int)}.
   *
   * <ul>
   *   <li>Then createStream {@link PDDocument#PDDocument()} NumberOfObjects is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setNumberOfObjects(int)}
   */
  @Test
  @DisplayName(
      "Test setNumberOfObjects(int); then createStream PDDocument() NumberOfObjects is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#getFirstByteOffset()}
   */
  @Test
  @DisplayName("Test getFirstByteOffset(); given createStream PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDObjectStream.getFirstByteOffset()"})
  void testGetFirstByteOffset_givenCreateStreamPDDocument_thenReturnZero() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act and Assert
    assertEquals(0, createStreamResult.getFirstByteOffset());
  }

  /**
   * Test {@link PDObjectStream#setFirstByteOffset(int)}.
   *
   * <ul>
   *   <li>Then createStream {@link PDDocument#PDDocument()} FirstByteOffset is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setFirstByteOffset(int)}
   */
  @Test
  @DisplayName(
      "Test setFirstByteOffset(int); then createStream PDDocument() FirstByteOffset is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given createStream {@link PDDocument#PDDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#getExtends()}
   */
  @Test
  @DisplayName("Test getExtends(); given createStream PDDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDObjectStream PDObjectStream.getExtends()"})
  void testGetExtends_givenCreateStreamPDDocument_thenReturnNull() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act and Assert
    assertNull(createStreamResult.getExtends());
  }

  /**
   * Test {@link PDObjectStream#setExtends(PDObjectStream)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  @DisplayName(
      "Test setExtends(PDObjectStream); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectStream.setExtends(PDObjectStream)"})
  void testSetExtends_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    createStreamResult.setExtends(new PDObjectStream(str));

    // Assert
    PDObjectStream resultExtends = createStreamResult.getExtends();
    assertNull(resultExtends.getType());
    assertNull(resultExtends.getDecodeParms());
    assertNull(resultExtends.getFileDecodeParams());
    assertNull(resultExtends.getMetadata());
    assertNull(resultExtends.getExtends());
    assertNull(resultExtends.getFile());
    assertEquals(-1, resultExtends.getDecodedStreamLength());
    assertEquals(0, resultExtends.getFirstByteOffset());
    assertEquals(0, resultExtends.getNumberOfObjects());
    assertEquals(0, resultExtends.getLength());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(str, resultExtends.getCOSObject());
  }

  /**
   * Test {@link PDObjectStream#setExtends(PDObjectStream)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  @DisplayName("Test setExtends(PDObjectStream); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectStream.setExtends(PDObjectStream)"})
  void testSetExtends_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    createStreamResult.setExtends(new PDObjectStream(str));

    // Assert
    PDObjectStream resultExtends = createStreamResult.getExtends();
    assertNull(resultExtends.getType());
    assertNull(resultExtends.getDecodeParms());
    assertNull(resultExtends.getFileDecodeParams());
    assertNull(resultExtends.getMetadata());
    assertNull(resultExtends.getExtends());
    assertNull(resultExtends.getFile());
    assertEquals(-1, resultExtends.getDecodedStreamLength());
    assertEquals(0, resultExtends.getFirstByteOffset());
    assertEquals(0, resultExtends.getNumberOfObjects());
    assertEquals(0, resultExtends.getLength());
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(str, resultExtends.getCOSObject());
  }

  /**
   * Test {@link PDObjectStream#setExtends(PDObjectStream)}.
   *
   * <ul>
   *   <li>Then createStream {@link PDDocument#PDDocument()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  @DisplayName(
      "Test setExtends(PDObjectStream); then createStream PDDocument() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectStream.setExtends(PDObjectStream)"})
  void testSetExtends_thenCreateStreamPDDocumentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());
    PDObjectStream stream = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setExtends(stream);

    // Assert that nothing has changed
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDObjectStream#setExtends(PDObjectStream)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then createStream {@link PDDocument#PDDocument()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDObjectStream#setExtends(PDObjectStream)}
   */
  @Test
  @DisplayName(
      "Test setExtends(PDObjectStream); when 'null'; then createStream PDDocument() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDObjectStream.setExtends(PDObjectStream)"})
  void testSetExtends_whenNull_thenCreateStreamPDDocumentCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDObjectStream createStreamResult = PDObjectStream.createStream(new PDDocument());

    // Act
    createStreamResult.setExtends(null);

    // Assert that nothing has changed
    COSStream cOSObject = createStreamResult.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }
}
