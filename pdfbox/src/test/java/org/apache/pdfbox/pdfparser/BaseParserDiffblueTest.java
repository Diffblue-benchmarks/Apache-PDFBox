package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseParserDiffblueTest {
  /**
   * Test {@link BaseParser#getObjectKey(long, int)}.
   * <p>
   * Method under test: {@link BaseParser#getObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test getObjectKey(long, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey BaseParser.getObjectKey(long, int)"})
  void testGetObjectKey() throws IOException {
    // Arrange and Act
    COSObjectKey actualObjectKey = (new PDFStreamParser(new PDPage())).getObjectKey(1L, 1);

    // Assert
    assertEquals(-1, actualObjectKey.getStreamIndex());
    assertEquals(1, actualObjectKey.getGeneration());
    assertEquals(1L, actualObjectKey.getNumber());
    assertEquals(65537L, actualObjectKey.getInternalHash());
  }

  /**
   * Test {@link BaseParser#getObjectKey(long, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return StreamIndex is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#getObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test getObjectKey(long, int); when one; then return StreamIndex is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSObjectKey BaseParser.getObjectKey(long, int)"})
  void testGetObjectKey_whenOne_thenReturnStreamIndexIsMinusOne() throws IOException {
    // Arrange and Act
    COSObjectKey actualObjectKey = (new PDFStreamParser(new PDPage())).getObjectKey(1L, 1);

    // Assert
    assertEquals(-1, actualObjectKey.getStreamIndex());
    assertEquals(1, actualObjectKey.getGeneration());
    assertEquals(1L, actualObjectKey.getNumber());
    assertEquals(65537L, actualObjectKey.getInternalHash());
  }

  /**
   * Test {@link BaseParser#parseCOSDictionary(boolean)}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSDictionary(boolean)}
   */
  @Test
  @DisplayName("Test parseCOSDictionary(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSDictionary BaseParser.parseCOSDictionary(boolean)"})
  void testParseCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSDictionary(true));
  }

  /**
   * Test {@link BaseParser#parseCOSDictionary(boolean)}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSDictionary(boolean)}
   */
  @Test
  @DisplayName("Test parseCOSDictionary(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSDictionary BaseParser.parseCOSDictionary(boolean)"})
  void testParseCOSDictionary2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSDictionary(true));
  }

  /**
   * Test {@link BaseParser#parseCOSString()}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSString()}
   */
  @Test
  @DisplayName("Test parseCOSString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSString BaseParser.parseCOSString()"})
  void testParseCOSString() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSString());
  }

  /**
   * Test {@link BaseParser#parseCOSString()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#parseCOSString()}
   */
  @Test
  @DisplayName("Test parseCOSString(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSString BaseParser.parseCOSString()"})
  void testParseCOSString_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSString());
  }

  /**
   * Test {@link BaseParser#parseCOSArray()}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSArray()}
   */
  @Test
  @DisplayName("Test parseCOSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray BaseParser.parseCOSArray()"})
  void testParseCOSArray() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSArray());
  }

  /**
   * Test {@link BaseParser#parseCOSArray()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#parseCOSArray()}
   */
  @Test
  @DisplayName("Test parseCOSArray(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray BaseParser.parseCOSArray()"})
  void testParseCOSArray_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSArray());
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when minus one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEndOfName(-1));
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when minus one; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenMinusOne_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEndOfName(-1));
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEndOfName(1));
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEndOfName(1));
  }

  /**
   * Test {@link BaseParser#parseCOSName()}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSName()}
   */
  @Test
  @DisplayName("Test parseCOSName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSName BaseParser.parseCOSName()"})
  void testParseCOSName() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSName());
  }

  /**
   * Test {@link BaseParser#parseCOSName()}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSName()}
   */
  @Test
  @DisplayName("Test parseCOSName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSName BaseParser.parseCOSName()"})
  void testParseCOSName2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).parseCOSName());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   * <p>
   * Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase BaseParser.parseDirObject()"})
  void testParseDirObject() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDFStreamParser(new PDPage())).parseDirObject());
  }

  /**
   * Test {@link BaseParser#readString()}.
   * <p>
   * Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BaseParser.readString()"})
  void testReadString() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new PDFStreamParser(new PDPage())).readString());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   * <p>
   * Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BaseParser.readString(int)"})
  void testReadStringWithInt() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new PDFStreamParser(new PDPage())).readString(3));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new byte[]{'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));
    PDFStreamParser pdfStreamParser = new PDFStreamParser(pdContentstream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedChar(char)}.
   * <p>
   * Method under test: {@link BaseParser#readExpectedChar(char)}
   */
  @Test
  @DisplayName("Test readExpectedChar(char)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedChar(char)"})
  void testReadExpectedChar() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readExpectedChar('A'));
  }

  /**
   * Test {@link BaseParser#readExpectedChar(char)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readExpectedChar(char)}
   */
  @Test
  @DisplayName("Test readExpectedChar(char); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BaseParser.readExpectedChar(char)"})
  void testReadExpectedChar_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readExpectedChar('A'));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   * <ul>
   *   <li>When ninety-three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when ninety-three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenNinetyThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isClosing(93));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   * <ul>
   *   <li>When ninety-three.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when ninety-three; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenNinetyThree_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isClosing(93));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isClosing(1));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isClosing(1));
  }

  /**
   * Test {@link BaseParser#readLine()}.
   * <p>
   * Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BaseParser.readLine()"})
  void testReadLine() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readLine());
  }

  /**
   * Test {@link BaseParser#readLine()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String BaseParser.readLine()"})
  void testReadLine_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readLine());
  }

  /**
   * Test {@link BaseParser#isEOF()}.
   * <p>
   * Method under test: {@link BaseParser#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOF()"})
  void testIsEOF() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDFStreamParser(new PDPage())).isEOF());
  }

  /**
   * Test {@link BaseParser#isEOF()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); given 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOF()"})
  void testIsEOF_givenA_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})).isEOF());
  }

  /**
   * Test {@link BaseParser#isEOF()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOF()"})
  void testIsEOF_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDFStreamParser(new PDPage())).isEOF());
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEOL(1));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEOL(1));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(10));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenTen_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(10));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When thirteen.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when thirteen; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenThirteen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(13));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   * <ul>
   *   <li>When thirteen.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when thirteen; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenThirteen_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(13));
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   * <p>
   * Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isWhitespace(1));
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isWhitespace(1));
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isWhitespace(0));
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when zero; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenZero_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isWhitespace(0));
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace(); given 'A'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenA_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_thenReturnTrue() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertTrue((new PDFStreamParser(pdContentstream)).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   * <p>
   * Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isSpace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).isSpace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isSpace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDFStreamParser(new byte[]{' ', -1, 'A', -1, 'A', -1, 'A', -1})).isSpace());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   * <p>
   * Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isDigit());
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When fifty-eight.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when fifty-eight; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFiftyEight_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(58));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When fifty-eight.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when fifty-eight; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFiftyEight_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(58));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When forty-eight.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when forty-eight; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFortyEight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isDigit(48));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When forty-eight.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when forty-eight; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFortyEight_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isDigit(48));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(1));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when one; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenOne_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(1));
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).isDigit());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isDigit());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDFStreamParser(new byte[]{'0', -1, 'A', -1, 'A', -1, 'A', -1})).isDigit());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1})).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\n', 'A', -1, 'A', -1, 'A', -1})).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\r', 'A', -1, 'A', -1, 'A', -1})).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithPdContentstreamIsPDPage2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(pdContentstream)).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1})).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber3() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\n', 'A', -1, 'A', -1, 'A', -1})).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\r', 'A', -1, 'A', -1, 'A', -1})).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber_givenPDFStreamParserWithPdContentstreamIsPDPage2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(pdContentstream)).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code %} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndCr() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\r', 'A', -1, 'A', -1, 'A', -1})).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code %} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndLf() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\n', 'A', -1, 'A', -1, 'A', -1})).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code %} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1})).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithPdContentstreamIsPDPage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithPdContentstreamIsPDPage_thenThrowIOException2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(pdContentstream)).readInt());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', -1, 'A', -1, 'A', -1, 'A', -1})).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code %} and cr.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and cr")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndCr() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\r', 'A', -1, 'A', -1, 'A', -1})).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte} with {@code %} and lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and lf")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndLf() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDFStreamParser(new byte[]{'%', '\n', 'A', -1, 'A', -1, 'A', -1})).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithPdContentstreamIsPDPage2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()} Contents is {@link PDStream#PDStream(COSDocument)} with document is {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDPage() Contents is PDStream(COSDocument) with document is COSDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDPageContentsIsPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDPage pdContentstream = new PDPage();
    pdContentstream.setContents(new PDStream(new COSDocument()));

    // Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(pdContentstream)).readLong());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new PDFStreamParser(new PDPage())).readStringNumber().toString());
  }
}
