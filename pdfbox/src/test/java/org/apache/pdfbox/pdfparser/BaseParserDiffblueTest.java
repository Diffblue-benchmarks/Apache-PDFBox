package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseParserDiffblueTest {
  /**
   * Test {@link BaseParser#getObjectKey(long, int)}.
   * <p>
   * Method under test: {@link BaseParser#getObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test getObjectKey(long, int)")
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
   * Test {@link BaseParser#parseCOSDictionary(boolean)}.
   * <p>
   * Method under test: {@link BaseParser#parseCOSDictionary(boolean)}
   */
  @Test
  @DisplayName("Test parseCOSDictionary(boolean)")
  void testParseCOSDictionary() throws IOException {
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
  void testParseCOSString() throws IOException {
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
  void testParseCOSArray() throws IOException {
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
  void testIsEndOfName_whenMinusOne_thenReturnTrue() {
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
  void testIsEndOfName_whenOne_thenReturnFalse() {
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
  void testParseCOSName() throws IOException {
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
  void testReadExpectedString() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

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
  void testReadExpectedChar() throws IOException {
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
  void testIsClosing_whenNinetyThree_thenReturnTrue() {
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
  void testIsClosing_whenOne_thenReturnFalse() {
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
  void testReadLine() throws IOException {
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
  void testIsEOF() throws IOException {
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
  void testIsEOL_whenOne_thenReturnFalse() {
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
  void testIsEOL_whenTen_thenReturnTrue() {
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
  void testIsEOL_whenThirteen_thenReturnTrue() {
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
  void testIsWhitespaceWithInt_whenOne_thenReturnFalse() {
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
  void testIsWhitespaceWithInt_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isWhitespace(0));
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   * <p>
   * Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace()")
  void testIsSpace() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDFStreamParser(new PDPage())).isSpace());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   * <p>
   * Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit()")
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
  void testIsDigitWithInt_whenFiftyEight_thenReturnFalse() {
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
  void testIsDigitWithInt_whenFortyEight_thenReturnTrue() {
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
  void testIsDigitWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(1));
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadObjectNumber_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with
   * pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  void testReadObjectNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadGenerationNumber_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with
   * pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  void testReadGenerationNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadInt_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with
   * pdContentstream is {@link PDPage#PDPage()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then throw IOException")
  void testReadInt_givenPDFStreamParserWithPdContentstreamIsPDPage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readInt());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testReadLong_givenPDFStreamParserWithBytesIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser("AXAXAXAX".getBytes("UTF-8"))).readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with
   * pdContentstream is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  void testReadLong_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDFStreamParser(new PDPage())).readLong());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   * <p>
   * Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber()")
  void testReadStringNumber() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", (new PDFStreamParser(new PDPage())).readStringNumber().toString());
  }
}
