package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseParserDiffblueTest {
  /**
   * Test {@link BaseParser#getObjectKey(long, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return StreamIndex is minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#getObjectKey(long, int)}
   */
  @Test
  @DisplayName("Test getObjectKey(long, int); when one; then return StreamIndex is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSObjectKey BaseParser.getObjectKey(long, int)"})
  void testGetObjectKey_whenOne_thenReturnStreamIndexIsMinusOne() throws IOException {
    // Arrange and Act
    COSObjectKey actualObjectKey = new PDFStreamParser(new PDPage()).getObjectKey(1L, 1);

    // Assert
    assertEquals(-1, actualObjectKey.getStreamIndex());
    assertEquals(1, actualObjectKey.getGeneration());
    assertEquals(1L, actualObjectKey.getNumber());
    assertEquals(65537L, actualObjectKey.getInternalHash());
  }

  /**
   * Test {@link BaseParser#parseCOSDictionary(boolean)}.
   *
   * <p>Method under test: {@link BaseParser#parseCOSDictionary(boolean)}
   */
  @Test
  @DisplayName("Test parseCOSDictionary(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSDictionary BaseParser.parseCOSDictionary(boolean)"})
  void testParseCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDFStreamParser(new PDPage()).parseCOSDictionary(true));
  }

  /**
   * Test {@link BaseParser#parseCOSString()}.
   *
   * <p>Method under test: {@link BaseParser#parseCOSString()}
   */
  @Test
  @DisplayName("Test parseCOSString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSString BaseParser.parseCOSString()"})
  void testParseCOSString() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).parseCOSString());
  }

  /**
   * Test {@link BaseParser#parseCOSArray()}.
   *
   * <p>Method under test: {@link BaseParser#parseCOSArray()}
   */
  @Test
  @DisplayName("Test parseCOSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray BaseParser.parseCOSArray()"})
  void testParseCOSArray() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).parseCOSArray());
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when minus one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenMinusOne_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEndOfName(-1));
  }

  /**
   * Test {@link BaseParser#isEndOfName(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEndOfName(int)}
   */
  @Test
  @DisplayName("Test isEndOfName(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEndOfName(int)"})
  void testIsEndOfName_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEndOfName(1));
  }

  /**
   * Test {@link BaseParser#parseCOSName()}.
   *
   * <p>Method under test: {@link BaseParser#parseCOSName()}
   */
  @Test
  @DisplayName("Test parseCOSName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSName BaseParser.parseCOSName()"})
  void testParseCOSName() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).parseCOSName());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSBase BaseParser.parseDirObject()"})
  void testParseDirObject_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDFStreamParser(new PDPage()).parseDirObject());
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@code A A} toCharArray.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName(
      "Test readExpectedString(char[], boolean); given 'A'; when 'A A' toCharArray; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_givenA_whenAAToCharArray_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedChar(char)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readExpectedChar(char)}
   */
  @Test
  @DisplayName("Test readExpectedChar(char); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedChar(char)"})
  void testReadExpectedChar_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readExpectedChar('A'));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   *
   * <ul>
   *   <li>When ninety-three.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when ninety-three; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenNinetyThree_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isClosing(93));
  }

  /**
   * Test {@link BaseParser#isClosing(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isClosing(int)}
   */
  @Test
  @DisplayName("Test isClosing(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isClosing(int)"})
  void testIsClosing_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isClosing(1));
  }

  /**
   * Test {@link BaseParser#readLine()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String BaseParser.readLine()"})
  void testReadLine_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readLine());
  }

  /**
   * Test {@link BaseParser#isEOF()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); given 'A'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEOF()"})
  void testIsEOF_givenA_thenReturnFalse() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertFalse(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#isEOF()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEOF()}
   */
  @Test
  @DisplayName(
      "Test isEOF(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEOF()"})
  void testIsEOF_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnTrue()
      throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDFStreamParser(new PDPage()).isEOF());
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isEOL(1));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when ten; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(10));
  }

  /**
   * Test {@link BaseParser#isEOL(int)}.
   *
   * <ul>
   *   <li>When thirteen.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isEOL(int)}
   */
  @Test
  @DisplayName("Test isEOL(int); when thirteen; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isEOL(int)"})
  void testIsEOL_whenThirteen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isEOL(13));
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isWhitespace(1));
  }

  /**
   * Test {@link BaseParser#isWhitespace(int)} with {@code int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace(int)}
   */
  @Test
  @DisplayName("Test isWhitespace(int) with 'int'; when zero; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace(int)"})
  void testIsWhitespaceWithInt_whenZero_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isWhitespace(0));
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenA() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName(
      "Test isWhitespace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenA() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertFalse(pdfStreamParser.isSpace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName(
      "Test isSpace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isSpace());
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   *
   * <ul>
   *   <li>When fifty-eight.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when fifty-eight; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFiftyEight_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(58));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   *
   * <ul>
   *   <li>When forty-eight.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when forty-eight; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenFortyEight_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(BaseParser.isDigit(48));
  }

  /**
   * Test {@link BaseParser#isDigit(int)} with {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit(int)}
   */
  @Test
  @DisplayName("Test isDigit(int) with 'int'; when one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit(int)"})
  void testIsDigitWithInt_whenOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(BaseParser.isDigit(1));
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenA() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertFalse(pdfStreamParser.isDigit());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName(
      "Test isDigit(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isDigit());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   *
   * <p>Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName(
      "Test readObjectNumber(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readObjectNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName(
      "Test readObjectNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readObjectNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   *
   * <p>Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   *
   * <p>Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readGenerationNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName(
      "Test readGenerationNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber_givenPDFStreamParserWithPdContentstreamIsPDPage()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readGenerationNumber());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with tab and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with tab and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithTabAndMinusOne()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithPdContentstreamIsPDPage_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readInt());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName(
      "Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with tab and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName(
      "Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with tab and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithTabAndMinusOne()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName(
      "Test readLong(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).readLong());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber_givenA() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertEquals("", pdfStreamParser.readStringNumber().toString());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName(
      "Test readStringNumber(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange, Act and Assert
    assertEquals("", new PDFStreamParser(new PDPage()).readStringNumber().toString());
  }
}
