package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
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
   * Test {@link BaseParser#skipWhiteSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipWhiteSpaces()}
   */
  @Test
  @DisplayName("Test skipWhiteSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipWhiteSpaces()"})
  void testSkipWhiteSpaces() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipWhiteSpaces();

    // Assert that nothing has changed
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(pdfStreamParser.isSpace());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipWhiteSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipWhiteSpaces()}
   */
  @Test
  @DisplayName("Test skipWhiteSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipWhiteSpaces()"})
  void testSkipWhiteSpaces2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {' ', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipWhiteSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isSpace());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipWhiteSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipWhiteSpaces()}
   */
  @Test
  @DisplayName("Test skipWhiteSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipWhiteSpaces()"})
  void testSkipWhiteSpaces3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\r', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipWhiteSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isSpace());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipWhiteSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipWhiteSpaces()}
   */
  @Test
  @DisplayName("Test skipWhiteSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipWhiteSpaces()"})
  void testSkipWhiteSpaces4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\n', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipWhiteSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isSpace());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipWhiteSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipWhiteSpaces()}
   */
  @Test
  @DisplayName("Test skipWhiteSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipWhiteSpaces()"})
  void testSkipWhiteSpaces5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\r', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipWhiteSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(2L, randomAccessRead.getPosition());
    assertEquals(6, randomAccessRead.available());
    assertFalse(pdfStreamParser.isSpace());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#parseCOSString()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#parseCOSString()}
   */
  @Test
  @DisplayName("Test parseCOSString(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSString BaseParser.parseCOSString()"})
  void testParseCOSString_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDFStreamParser(new PDPage()).parseCOSString());
  }

  /**
   * Test {@link BaseParser#parseCOSArray()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#parseCOSArray()}
   */
  @Test
  @DisplayName("Test parseCOSArray(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.cos.COSArray BaseParser.parseCOSArray()"})
  void testParseCOSArray_thenThrowIOException() throws IOException {
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
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    pdfStreamParser.parseDirObject();

    // Assert that nothing has changed
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\b', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject7() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject8() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.parseDirObject();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <ul>
   *   <li>Then return String is {@code (AÿAÿAÿ}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject(); then return String is '(AÿAÿAÿ'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject_thenReturnStringIsAAA() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'(', '(', 'A', -1, 'A', -1, 'A', -1});

    // Act
    COSBase actualParseDirObjectResult = pdfStreamParser.parseDirObject();

    // Assert
    assertTrue(actualParseDirObjectResult instanceof COSString);
    assertEquals("(AÿAÿAÿ", ((COSString) actualParseDirObjectResult).getString());
    assertEquals("(A�A�A�", ((COSString) actualParseDirObjectResult).getASCII());
    assertEquals("2841FF41FF41FF", ((COSString) actualParseDirObjectResult).toHexString());
    assertArrayEquals(
        new byte[] {'(', 'A', -1, 'A', -1, 'A', -1},
        ((COSString) actualParseDirObjectResult).getBytes());
  }

  /**
   * Test {@link BaseParser#parseDirObject()}.
   *
   * <ul>
   *   <li>Then return toHexString is {@code FF41FF41FF41FF}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#parseDirObject()}
   */
  @Test
  @DisplayName("Test parseDirObject(); then return toHexString is 'FF41FF41FF41FF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase BaseParser.parseDirObject()"})
  void testParseDirObject_thenReturnToHexStringIsFf41ff41ff41ff() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'(', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    COSBase actualParseDirObjectResult = pdfStreamParser.parseDirObject();

    // Assert
    assertTrue(actualParseDirObjectResult instanceof COSString);
    assertEquals("FF41FF41FF41FF", ((COSString) actualParseDirObjectResult).toHexString());
    assertEquals("ÿAÿAÿAÿ", ((COSString) actualParseDirObjectResult).getString());
    assertEquals("�A�A�A�", ((COSString) actualParseDirObjectResult).getASCII());
    assertArrayEquals(
        new byte[] {-1, 'A', -1, 'A', -1, 'A', -1},
        ((COSString) actualParseDirObjectResult).getBytes());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿAÿAÿAÿ", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿAÿAÿ", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", actualReadStringResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿAÿAÿ", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString()}.
   *
   * <p>Method under test: {@link BaseParser#readString()}
   */
  @Test
  @DisplayName("Test readString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString()"})
  void testReadString7() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿAÿAÿ", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿA", actualReadStringResult);
    assertEquals(3L, randomAccessRead.getPosition());
    assertEquals(5, randomAccessRead.available());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("ÿAÿ", actualReadStringResult);
    assertEquals(4, randomAccessRead.available());
    assertEquals(4L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', '\t', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A", actualReadStringResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿA", actualReadStringResult);
    assertEquals(3, randomAccessRead.available());
    assertEquals(5L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt7() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("AÿA", actualReadStringResult);
    assertEquals(3, randomAccessRead.available());
    assertEquals(5L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readString(int)} with {@code int}.
   *
   * <p>Method under test: {@link BaseParser#readString(int)}
   */
  @Test
  @DisplayName("Test readString(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readString(int)"})
  void testReadStringWithInt8() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'(', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    String actualReadStringResult = pdfStreamParser.readString(3);

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringResult);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString() throws IOException {
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
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName("Test readExpectedString(char[], boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(PDContentStream)} with pdContentstream is
   *       {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName(
      "Test readExpectedString(char[], boolean); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_givenPDFStreamParserWithPdContentstreamIsPDPage() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdfStreamParser.readExpectedString("A A ".toCharArray(), true));
  }

  /**
   * Test {@link BaseParser#readExpectedString(char[], boolean)}.
   *
   * <ul>
   *   <li>When empty array of {@code char}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readExpectedString(char[], boolean)}
   */
  @Test
  @DisplayName(
      "Test readExpectedString(char[], boolean); when empty array of char; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedString(char[], boolean)"})
  void testReadExpectedString_whenEmptyArrayOfChar_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new PDFStreamParser(new PDPage()).readExpectedString(new char[] {}, true));
  }

  /**
   * Test {@link BaseParser#readExpectedChar(char)}.
   *
   * <p>Method under test: {@link BaseParser#readExpectedChar(char)}
   */
  @Test
  @DisplayName("Test readExpectedChar(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.readExpectedChar(char)"})
  void testReadExpectedChar() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.readExpectedChar('A');

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
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
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readLine()"})
  void testReadLine() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    String actualReadLineResult = pdfStreamParser.readLine();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A\u0001A\u0001A\u0001A\u0001", actualReadLineResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#readLine()}.
   *
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readLine()"})
  void testReadLine2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\n', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    String actualReadLineResult = pdfStreamParser.readLine();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadLineResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readLine()}.
   *
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readLine()"})
  void testReadLine3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\r', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act
    String actualReadLineResult = pdfStreamParser.readLine();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadLineResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readLine()}.
   *
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readLine()"})
  void testReadLine4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\r', '\n', 'A', 1, 'A', 1, 'A', 1});

    // Act
    String actualReadLineResult = pdfStreamParser.readLine();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadLineResult);
    assertEquals(2L, randomAccessRead.getPosition());
    assertEquals(6, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#readLine()}.
   *
   * <ul>
   *   <li>Given cr.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLine()}
   */
  @Test
  @DisplayName("Test readLine(); given cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseParser.readLine()"})
  void testReadLine_givenCr() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', '\r'});

    // Act
    String actualReadLineResult = pdfStreamParser.readLine();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("A\u0001A\u0001A\u0001A", actualReadLineResult);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
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
  @MethodsUnderTest({"String BaseParser.readLine()"})
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
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName(
      "Test isWhitespace(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne()
      throws IOException {
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
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName(
      "Test isWhitespace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isWhitespace());
  }

  /**
   * Test {@link BaseParser#isWhitespace()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isWhitespace()}
   */
  @Test
  @DisplayName("Test isWhitespace(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isWhitespace()"})
  void testIsWhitespace_thenReturnTrue() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {0, -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertTrue(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName(
      "Test isSpace(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
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
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName(
      "Test isSpace(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isSpace());
  }

  /**
   * Test {@link BaseParser#isSpace()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isSpace()}
   */
  @Test
  @DisplayName("Test isSpace(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isSpace()"})
  void testIsSpace_thenReturnTrue() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {' ', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertTrue(pdfStreamParser.isSpace());
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
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName(
      "Test isDigit(); given PDFStreamParser(byte[]) with bytes is array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenPDFStreamParserWithBytesIsArrayOfByteWithAAndMinusOne() throws IOException {
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
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName(
      "Test isDigit(); given PDFStreamParser(PDContentStream) with pdContentstream is PDPage(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_givenPDFStreamParserWithPdContentstreamIsPDPage_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDFStreamParser(new PDPage()).isDigit());
  }

  /**
   * Test {@link BaseParser#isDigit()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#isDigit()}
   */
  @Test
  @DisplayName("Test isDigit(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseParser.isDigit()"})
  void testIsDigit_thenReturnTrue() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertTrue(pdfStreamParser.isDigit());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    pdfStreamParser.skipSpaces();

    // Assert that nothing has changed
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipSpaces();

    // Assert that nothing has changed
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'\t', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, randomAccessRead.available());
    assertEquals(8L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isWhitespace());
    assertTrue(pdfStreamParser.isEOF());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(2L, randomAccessRead.getPosition());
    assertEquals(6, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
  }

  /**
   * Test {@link BaseParser#skipSpaces()}.
   *
   * <p>Method under test: {@link BaseParser#skipSpaces()}
   */
  @Test
  @DisplayName("Test skipSpaces()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseParser.skipSpaces()"})
  void testSkipSpaces6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act
    pdfStreamParser.skipSpaces();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(2L, randomAccessRead.getPosition());
    assertEquals(6, randomAccessRead.available());
    assertFalse(pdfStreamParser.isEOF());
    assertFalse(pdfStreamParser.isWhitespace());
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
   * <p>Method under test: {@link BaseParser#readObjectNumber()}
   */
  @Test
  @DisplayName("Test readObjectNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readObjectNumber()"})
  void testReadObjectNumber2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readObjectNumber());
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
  void testReadObjectNumber3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readObjectNumber());
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
  void testReadObjectNumber4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readObjectNumber());
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
  void testReadObjectNumber5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    long actualReadObjectNumberResult = pdfStreamParser.readObjectNumber();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualReadObjectNumberResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
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
   * <p>Method under test: {@link BaseParser#readGenerationNumber()}
   */
  @Test
  @DisplayName("Test readGenerationNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readGenerationNumber()"})
  void testReadGenerationNumber3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

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
  void testReadGenerationNumber4() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

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
  void testReadGenerationNumber5() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

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
  void testReadGenerationNumber6() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    int actualReadGenerationNumberResult = pdfStreamParser.readGenerationNumber();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, actualReadGenerationNumberResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
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
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName("Test readInt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    int actualReadIntResult = pdfStreamParser.readInt();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0, actualReadIntResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
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
   *       with {@code %} and cr.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndCr()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code %} and lf.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndLf()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readInt());
  }

  /**
   * Test {@link BaseParser#readInt()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code %} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readInt()}
   */
  @Test
  @DisplayName(
      "Test readInt(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BaseParser.readInt()"})
  void testReadInt_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndMinusOne()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

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
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName("Test readLong()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    long actualReadLongResult = pdfStreamParser.readLong();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals(0L, actualReadLongResult);
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
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
   *       with {@code %} and cr.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName(
      "Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and cr")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndCr()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\r', 'A', -1, 'A', -1, 'A', -1});

    // Act and Assert
    assertThrows(IOException.class, () -> pdfStreamParser.readLong());
  }

  /**
   * Test {@link BaseParser#readLong()}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamParser#PDFStreamParser(byte[])} with bytes is array of {@code byte}
   *       with {@code %} and lf.
   * </ul>
   *
   * <p>Method under test: {@link BaseParser#readLong()}
   */
  @Test
  @DisplayName(
      "Test readLong(); given PDFStreamParser(byte[]) with bytes is array of byte with '%' and lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseParser.readLong()"})
  void testReadLong_givenPDFStreamParserWithBytesIsArrayOfByteWithPercentSignAndLf()
      throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'%', '\n', 'A', -1, 'A', -1, 'A', -1});

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
   * <p>Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser = new PDFStreamParser(new PDPage());

    // Act
    StringBuilder actualReadStringNumberResult = pdfStreamParser.readStringNumber();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringNumberResult.toString());
    assertEquals(0, randomAccessRead.available());
    assertEquals(0L, randomAccessRead.getPosition());
    assertFalse(pdfStreamParser.isDigit());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   *
   * <p>Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber2() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    StringBuilder actualReadStringNumberResult = pdfStreamParser.readStringNumber();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("", actualReadStringNumberResult.toString());
    assertEquals(0L, randomAccessRead.getPosition());
    assertEquals(8, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
  }

  /**
   * Test {@link BaseParser#readStringNumber()}.
   *
   * <p>Method under test: {@link BaseParser#readStringNumber()}
   */
  @Test
  @DisplayName("Test readStringNumber()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder BaseParser.readStringNumber()"})
  void testReadStringNumber3() throws IOException {
    // Arrange
    PDFStreamParser pdfStreamParser =
        new PDFStreamParser(new byte[] {'0', -1, 'A', -1, 'A', -1, 'A', -1});

    // Act
    StringBuilder actualReadStringNumberResult = pdfStreamParser.readStringNumber();

    // Assert
    RandomAccessRead randomAccessRead = pdfStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertEquals("0", actualReadStringNumberResult.toString());
    assertEquals(1L, randomAccessRead.getPosition());
    assertEquals(7, randomAccessRead.available());
    assertFalse(pdfStreamParser.isDigit());
  }
}
