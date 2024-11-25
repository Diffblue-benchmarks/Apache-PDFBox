package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.fontbox.encoding.Encoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Type1FontDiffblueTest {
  /**
   * Test {@link Type1Font#Type1Font(byte[], byte[])}.
   * <p>
   * Method under test: {@link Type1Font#Type1Font(byte[], byte[])}
   */
  @Test
  @DisplayName("Test new Type1Font(byte[], byte[])")
  void testNewType1Font() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");
    byte[] segment2 = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Type1Font actualType1Font = new Type1Font(segment1, segment2);

    // Assert
    assertEquals("", actualType1Font.getFamilyName());
    assertEquals("", actualType1Font.getFontID());
    assertEquals("", actualType1Font.getFontName());
    assertEquals("", actualType1Font.getFullName());
    assertEquals("", actualType1Font.getName());
    assertEquals("", actualType1Font.getNotice());
    assertEquals("", actualType1Font.getVersion());
    assertEquals("", actualType1Font.getWeight());
    assertNull(actualType1Font.getEncoding());
    assertEquals(0, actualType1Font.getBlueFuzz());
    assertEquals(0, actualType1Font.getBlueShift());
    assertEquals(0, actualType1Font.getFontType());
    assertEquals(0, actualType1Font.getLanguageGroup());
    assertEquals(0, actualType1Font.getPaintType());
    assertEquals(0, actualType1Font.getUniqueID());
    assertEquals(0.0f, actualType1Font.getBlueScale());
    assertEquals(0.0f, actualType1Font.getItalicAngle());
    assertEquals(0.0f, actualType1Font.getStrokeWidth());
    assertEquals(0.0f, actualType1Font.getUnderlinePosition());
    assertEquals(0.0f, actualType1Font.getUnderlineThickness());
    assertFalse(actualType1Font.isFixedPitch());
    assertFalse(actualType1Font.isForceBold());
    assertTrue(actualType1Font.getBlueValues().isEmpty());
    assertTrue(actualType1Font.getFamilyBlues().isEmpty());
    assertTrue(actualType1Font.getFamilyOtherBlues().isEmpty());
    assertTrue(actualType1Font.getFontMatrix().isEmpty());
    assertTrue(actualType1Font.getOtherBlues().isEmpty());
    assertTrue(actualType1Font.getStdHW().isEmpty());
    assertTrue(actualType1Font.getStdVW().isEmpty());
    assertTrue(actualType1Font.getStemSnapH().isEmpty());
    assertTrue(actualType1Font.getStemSnapV().isEmpty());
    assertTrue(actualType1Font.getSubrsArray().isEmpty());
    assertTrue(actualType1Font.blueValues.isEmpty());
    assertTrue(actualType1Font.familyBlues.isEmpty());
    assertTrue(actualType1Font.familyOtherBlues.isEmpty());
    assertTrue(actualType1Font.fontBBox.isEmpty());
    assertTrue(actualType1Font.fontMatrix.isEmpty());
    assertTrue(actualType1Font.otherBlues.isEmpty());
    assertTrue(actualType1Font.stdHW.isEmpty());
    assertTrue(actualType1Font.stdVW.isEmpty());
    assertTrue(actualType1Font.stemSnapH.isEmpty());
    assertTrue(actualType1Font.stemSnapV.isEmpty());
    assertTrue(actualType1Font.subrs.isEmpty());
    assertTrue(actualType1Font.getCharStringsDict().isEmpty());
    assertTrue(actualType1Font.charstrings.isEmpty());
    assertSame(segment1, actualType1Font.getASCIISegment());
    assertSame(segment2, actualType1Font.getBinarySegment());
  }

  /**
   * Test {@link Type1Font#getSubrsArray()}.
   * <p>
   * Method under test: {@link Type1Font#getSubrsArray()}
   */
  @Test
  @DisplayName("Test getSubrsArray()")
  void testGetSubrsArray() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getSubrsArray().isEmpty());
  }

  /**
   * Test {@link Type1Font#getCharStringsDict()}.
   * <p>
   * Method under test: {@link Type1Font#getCharStringsDict()}
   */
  @Test
  @DisplayName("Test getCharStringsDict()")
  void testGetCharStringsDict() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getCharStringsDict().isEmpty());
  }

  /**
   * Test {@link Type1Font#getPath(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String); when 'Name'; then throw IOException")
  void testGetPath_whenName_thenThrowIOException() throws IOException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getPath("Name"));
  }

  /**
   * Test {@link Type1Font#getWidth(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Font#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); when 'Name'; then throw IOException")
  void testGetWidth_whenName_thenThrowIOException() throws IOException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getWidth("Name"));
  }

  /**
   * Test {@link Type1Font#hasGlyph(String)}.
   * <p>
   * Method under test: {@link Type1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String)")
  void testHasGlyph() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertFalse((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).hasGlyph("Name"));
  }

  /**
   * Test {@link Type1Font#getType1CharString(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Font#getType1CharString(String)}
   */
  @Test
  @DisplayName("Test getType1CharString(String); when 'Name'; then throw IOException")
  void testGetType1CharString_whenName_thenThrowIOException() throws IOException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class,
        () -> (new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getType1CharString("Name"));
  }

  /**
   * Test {@link Type1Font#getFontMatrix()}.
   * <p>
   * Method under test: {@link Type1Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  void testGetFontMatrix() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getFontMatrix().isEmpty());
  }

  /**
   * Test {@link Type1Font#getFontBBox()}.
   * <p>
   * Method under test: {@link Type1Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox()")
  void testGetFontBBox() throws IOException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertThrows(IOException.class, () -> (new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getFontBBox());
  }

  /**
   * Test {@link Type1Font#getBlueValues()}.
   * <p>
   * Method under test: {@link Type1Font#getBlueValues()}
   */
  @Test
  @DisplayName("Test getBlueValues()")
  void testGetBlueValues() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getBlueValues().isEmpty());
  }

  /**
   * Test {@link Type1Font#getOtherBlues()}.
   * <p>
   * Method under test: {@link Type1Font#getOtherBlues()}
   */
  @Test
  @DisplayName("Test getOtherBlues()")
  void testGetOtherBlues() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getOtherBlues().isEmpty());
  }

  /**
   * Test {@link Type1Font#getFamilyBlues()}.
   * <p>
   * Method under test: {@link Type1Font#getFamilyBlues()}
   */
  @Test
  @DisplayName("Test getFamilyBlues()")
  void testGetFamilyBlues() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getFamilyBlues().isEmpty());
  }

  /**
   * Test {@link Type1Font#getFamilyOtherBlues()}.
   * <p>
   * Method under test: {@link Type1Font#getFamilyOtherBlues()}
   */
  @Test
  @DisplayName("Test getFamilyOtherBlues()")
  void testGetFamilyOtherBlues() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getFamilyOtherBlues().isEmpty());
  }

  /**
   * Test {@link Type1Font#getStdHW()}.
   * <p>
   * Method under test: {@link Type1Font#getStdHW()}
   */
  @Test
  @DisplayName("Test getStdHW()")
  void testGetStdHW() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getStdHW().isEmpty());
  }

  /**
   * Test {@link Type1Font#getStdVW()}.
   * <p>
   * Method under test: {@link Type1Font#getStdVW()}
   */
  @Test
  @DisplayName("Test getStdVW()")
  void testGetStdVW() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getStdVW().isEmpty());
  }

  /**
   * Test {@link Type1Font#getStemSnapH()}.
   * <p>
   * Method under test: {@link Type1Font#getStemSnapH()}
   */
  @Test
  @DisplayName("Test getStemSnapH()")
  void testGetStemSnapH() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getStemSnapH().isEmpty());
  }

  /**
   * Test {@link Type1Font#getStemSnapV()}.
   * <p>
   * Method under test: {@link Type1Font#getStemSnapV()}
   */
  @Test
  @DisplayName("Test getStemSnapV()")
  void testGetStemSnapV() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertTrue((new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"))).getStemSnapV().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Type1Font#toString()}
   *   <li>{@link Type1Font#getASCIISegment()}
   *   <li>{@link Type1Font#getBinarySegment()}
   *   <li>{@link Type1Font#getBlueFuzz()}
   *   <li>{@link Type1Font#getBlueScale()}
   *   <li>{@link Type1Font#getBlueShift()}
   *   <li>{@link Type1Font#getEncoding()}
   *   <li>{@link Type1Font#getFamilyName()}
   *   <li>{@link Type1Font#getFontID()}
   *   <li>{@link Type1Font#getFontName()}
   *   <li>{@link Type1Font#getFontType()}
   *   <li>{@link Type1Font#getFullName()}
   *   <li>{@link Type1Font#getItalicAngle()}
   *   <li>{@link Type1Font#getLanguageGroup()}
   *   <li>{@link Type1Font#getName()}
   *   <li>{@link Type1Font#getNotice()}
   *   <li>{@link Type1Font#getPaintType()}
   *   <li>{@link Type1Font#getStrokeWidth()}
   *   <li>{@link Type1Font#getUnderlinePosition()}
   *   <li>{@link Type1Font#getUnderlineThickness()}
   *   <li>{@link Type1Font#getUniqueID()}
   *   <li>{@link Type1Font#getVersion()}
   *   <li>{@link Type1Font#getWeight()}
   *   <li>{@link Type1Font#isFixedPitch()}
   *   <li>{@link Type1Font#isForceBold()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange
    byte[] segment1 = "AXAXAXAX".getBytes("UTF-8");
    Type1Font type1Font = new Type1Font(segment1, "AXAXAXAX".getBytes("UTF-8"));

    // Act
    String actualToStringResult = type1Font.toString();
    byte[] actualASCIISegment = type1Font.getASCIISegment();
    byte[] actualBinarySegment = type1Font.getBinarySegment();
    int actualBlueFuzz = type1Font.getBlueFuzz();
    float actualBlueScale = type1Font.getBlueScale();
    int actualBlueShift = type1Font.getBlueShift();
    Encoding actualEncoding = type1Font.getEncoding();
    String actualFamilyName = type1Font.getFamilyName();
    String actualFontID = type1Font.getFontID();
    String actualFontName = type1Font.getFontName();
    int actualFontType = type1Font.getFontType();
    String actualFullName = type1Font.getFullName();
    float actualItalicAngle = type1Font.getItalicAngle();
    int actualLanguageGroup = type1Font.getLanguageGroup();
    String actualName = type1Font.getName();
    String actualNotice = type1Font.getNotice();
    int actualPaintType = type1Font.getPaintType();
    float actualStrokeWidth = type1Font.getStrokeWidth();
    float actualUnderlinePosition = type1Font.getUnderlinePosition();
    float actualUnderlineThickness = type1Font.getUnderlineThickness();
    int actualUniqueID = type1Font.getUniqueID();
    String actualVersion = type1Font.getVersion();
    String actualWeight = type1Font.getWeight();
    boolean actualIsFixedPitchResult = type1Font.isFixedPitch();

    // Assert
    assertEquals("", actualFamilyName);
    assertEquals("", actualFontID);
    assertEquals("", actualFontName);
    assertEquals("", actualFullName);
    assertEquals("", actualName);
    assertEquals("", actualNotice);
    assertEquals("", actualVersion);
    assertEquals("", actualWeight);
    assertEquals("org.apache.fontbox.type1.Type1Font[fontName=, fullName=, encoding=null, charStringsDict={}]",
        actualToStringResult);
    assertNull(actualEncoding);
    assertEquals(0, actualBlueFuzz);
    assertEquals(0, actualBlueShift);
    assertEquals(0, actualFontType);
    assertEquals(0, actualLanguageGroup);
    assertEquals(0, actualPaintType);
    assertEquals(0, actualUniqueID);
    assertEquals(0.0f, actualBlueScale);
    assertEquals(0.0f, actualItalicAngle);
    assertEquals(0.0f, actualStrokeWidth);
    assertEquals(0.0f, actualUnderlinePosition);
    assertEquals(0.0f, actualUnderlineThickness);
    assertFalse(actualIsFixedPitchResult);
    assertFalse(type1Font.isForceBold());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualASCIISegment);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualBinarySegment);
  }
}
