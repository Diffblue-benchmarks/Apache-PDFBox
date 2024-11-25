package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.Map;
import org.apache.fontbox.FontBoxFont;
import org.apache.fontbox.ttf.TTFTable;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextPositionDiffblueTest {
  /**
   * Test
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}.
   * <ul>
   *   <li>When one hundred eighty.</li>
   *   <li>Then return Y is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}
   */
  @Test
  @DisplayName("Test new TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int); when one hundred eighty; then return Y is zero")
  void testNewTextPosition_whenOneHundredEighty_thenReturnYIsZero() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act
    TextPosition actualTextPosition = new TextPosition(180, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Assert
    PDFont font = actualTextPosition.getFont();
    FontBoxFont fontBoxFont = ((PDMMType1Font) font).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(font instanceof PDMMType1Font);
    assertEquals(0.0f, actualTextPosition.getY());
    assertEquals(10.0f, actualTextPosition.getX());
    assertEquals(180, actualTextPosition.getRotation());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
  }

  /**
   * Test
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Rotation is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}
   */
  @Test
  @DisplayName("Test new TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int); when one; then return Rotation is one")
  void testNewTextPosition_whenOne_thenReturnRotationIsOne() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act
    TextPosition actualTextPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Assert
    PDFont font = actualTextPosition.getFont();
    FontBoxFont fontBoxFont = ((PDMMType1Font) font).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(font instanceof PDMMType1Font);
    assertEquals(1, actualTextPosition.getRotation());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
  }

  /**
   * Test
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return Rotation is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextPosition#TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int)}
   */
  @Test
  @DisplayName("Test new TextPosition(int, float, float, Matrix, float, float, float, float, float, String, int[], PDFont, float, int); when zero; then return Rotation is zero")
  void testNewTextPosition_whenZero_thenReturnRotationIsZero() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act
    TextPosition actualTextPosition = new TextPosition(0, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Assert
    PDFont font = actualTextPosition.getFont();
    FontBoxFont fontBoxFont = ((PDMMType1Font) font).getFontBoxFont();
    assertTrue(fontBoxFont instanceof TrueTypeFont);
    assertTrue(font instanceof PDMMType1Font);
    assertEquals(0, actualTextPosition.getRotation());
    Map<String, TTFTable> tableMap = ((TrueTypeFont) fontBoxFont).getTableMap();
    assertEquals(25, tableMap.size());
    assertEquals(3, ((TrueTypeFont) fontBoxFont).getCmap().getCmaps().length);
    assertTrue(tableMap.containsKey("fpgm"));
    assertTrue(tableMap.containsKey("gasp"));
  }

  /**
   * Test {@link TextPosition#getVisuallyOrderedUnicode()}.
   * <p>
   * Method under test: {@link TextPosition#getVisuallyOrderedUnicode()}
   */
  @Test
  @DisplayName("Test getVisuallyOrderedUnicode()")
  void testGetVisuallyOrderedUnicode() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals("Unicode", (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getVisuallyOrderedUnicode());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextPosition#setUnicode(String)}
   *   <li>{@link TextPosition#toString()}
   *   <li>{@link TextPosition#getCharacterCodes()}
   *   <li>{@link TextPosition#getEndX()}
   *   <li>{@link TextPosition#getEndY()}
   *   <li>{@link TextPosition#getFont()}
   *   <li>{@link TextPosition#getFontSize()}
   *   <li>{@link TextPosition#getHeight()}
   *   <li>{@link TextPosition#getHeightDir()}
   *   <li>{@link TextPosition#getIndividualWidths()}
   *   <li>{@link TextPosition#getPageHeight()}
   *   <li>{@link TextPosition#getPageWidth()}
   *   <li>{@link TextPosition#getRotation()}
   *   <li>{@link TextPosition#getTextMatrix()}
   *   <li>{@link TextPosition#getUnicode()}
   *   <li>{@link TextPosition#getWidthOfSpace()}
   *   <li>{@link TextPosition#getX()}
   *   <li>{@link TextPosition#getY()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    PDMMType1Font font = new PDMMType1Font(new COSDictionary());
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, font, 10.0f, 3);

    // Act
    textPosition.setUnicode("Unicode");
    String actualToStringResult = textPosition.toString();
    int[] actualCharacterCodes = textPosition.getCharacterCodes();
    float actualEndX = textPosition.getEndX();
    float actualEndY = textPosition.getEndY();
    PDFont actualFont = textPosition.getFont();
    float actualFontSize = textPosition.getFontSize();
    float actualHeight = textPosition.getHeight();
    float actualHeightDir = textPosition.getHeightDir();
    float[] actualIndividualWidths = textPosition.getIndividualWidths();
    float actualPageHeight = textPosition.getPageHeight();
    float actualPageWidth = textPosition.getPageWidth();
    int actualRotation = textPosition.getRotation();
    Matrix actualTextMatrix = textPosition.getTextMatrix();
    String actualUnicode = textPosition.getUnicode();
    float actualWidthOfSpace = textPosition.getWidthOfSpace();
    float actualX = textPosition.getX();

    // Assert that nothing has changed
    assertEquals("Unicode", actualUnicode);
    assertEquals("Unicode", actualToStringResult);
    assertEquals(0.0f, actualX);
    assertEquals(1, actualRotation);
    assertEquals(10.0f, actualEndX);
    assertEquals(10.0f, actualEndY);
    assertEquals(10.0f, actualFontSize);
    assertEquals(10.0f, actualHeight);
    assertEquals(10.0f, actualHeightDir);
    assertEquals(10.0f, actualPageHeight);
    assertEquals(10.0f, actualPageWidth);
    assertEquals(10.0f, actualWidthOfSpace);
    assertEquals(10.0f, textPosition.getY());
    assertSame(font, actualFont);
    assertSame(textMatrix, actualTextMatrix);
    assertArrayEquals(new float[]{10.0f}, actualIndividualWidths, 0.0f);
    assertArrayEquals(new int[]{1, 0, 1, 0}, actualCharacterCodes);
  }

  /**
   * Test {@link TextPosition#getDir()}.
   * <p>
   * Method under test: {@link TextPosition#getDir()}
   */
  @Test
  @DisplayName("Test getDir()")
  void testGetDir() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getDir());
  }

  /**
   * Test {@link TextPosition#getDir()}.
   * <p>
   * Method under test: {@link TextPosition#getDir()}
   */
  @Test
  @DisplayName("Test getDir()")
  void testGetDir2() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(1.0f, -1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getDir());
  }

  /**
   * Test {@link TextPosition#getDir()}.
   * <p>
   * Method under test: {@link TextPosition#getDir()}
   */
  @Test
  @DisplayName("Test getDir()")
  void testGetDir3() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(0.0f, -1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getDir());
  }

  /**
   * Test {@link TextPosition#getDir()}.
   * <p>
   * Method under test: {@link TextPosition#getDir()}
   */
  @Test
  @DisplayName("Test getDir()")
  void testGetDir4() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, 1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getDir());
  }

  /**
   * Test {@link TextPosition#getDir()}.
   * <ul>
   *   <li>Then return one hundred eighty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getDir()}
   */
  @Test
  @DisplayName("Test getDir(); then return one hundred eighty")
  void testGetDir_thenReturnOneHundredEighty() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);

    // Act and Assert
    assertEquals(180.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getDir());
  }

  /**
   * Test {@link TextPosition#getXDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getXDirAdj()}
   */
  @Test
  @DisplayName("Test getXDirAdj()")
  void testGetXDirAdj() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXDirAdj());
  }

  /**
   * Test {@link TextPosition#getXDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getXDirAdj()}
   */
  @Test
  @DisplayName("Test getXDirAdj()")
  void testGetXDirAdj2() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(1.0f, -1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXDirAdj());
  }

  /**
   * Test {@link TextPosition#getXDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getXDirAdj()}
   */
  @Test
  @DisplayName("Test getXDirAdj()")
  void testGetXDirAdj3() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(0.0f, -1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXDirAdj());
  }

  /**
   * Test {@link TextPosition#getXDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getXDirAdj()}
   */
  @Test
  @DisplayName("Test getXDirAdj()")
  void testGetXDirAdj4() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, 1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXDirAdj());
  }

  /**
   * Test {@link TextPosition#getXDirAdj()}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getXDirAdj()}
   */
  @Test
  @DisplayName("Test getXDirAdj(); then return ten")
  void testGetXDirAdj_thenReturnTen() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXDirAdj());
  }

  /**
   * Test {@link TextPosition#getYDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getYDirAdj()}
   */
  @Test
  @DisplayName("Test getYDirAdj()")
  void testGetYDirAdj() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYDirAdj());
  }

  /**
   * Test {@link TextPosition#getYDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getYDirAdj()}
   */
  @Test
  @DisplayName("Test getYDirAdj()")
  void testGetYDirAdj2() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(1.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYDirAdj());
  }

  /**
   * Test {@link TextPosition#getYDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getYDirAdj()}
   */
  @Test
  @DisplayName("Test getYDirAdj()")
  void testGetYDirAdj3() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(0.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYDirAdj());
  }

  /**
   * Test {@link TextPosition#getYDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getYDirAdj()}
   */
  @Test
  @DisplayName("Test getYDirAdj()")
  void testGetYDirAdj4() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, 1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYDirAdj());
  }

  /**
   * Test {@link TextPosition#getYDirAdj()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getYDirAdj()}
   */
  @Test
  @DisplayName("Test getYDirAdj(); then return zero")
  void testGetYDirAdj_thenReturnZero() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);

    // Act and Assert
    assertEquals(0.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYDirAdj());
  }

  /**
   * Test {@link TextPosition#getWidth()}.
   * <ul>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); then return ten")
  void testGetWidth_thenReturnTen() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidth());
  }

  /**
   * Test {@link TextPosition#getWidthDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getWidthDirAdj()}
   */
  @Test
  @DisplayName("Test getWidthDirAdj()")
  void testGetWidthDirAdj() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidthDirAdj());
  }

  /**
   * Test {@link TextPosition#getWidthDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getWidthDirAdj()}
   */
  @Test
  @DisplayName("Test getWidthDirAdj()")
  void testGetWidthDirAdj2() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidthDirAdj());
  }

  /**
   * Test {@link TextPosition#getWidthDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getWidthDirAdj()}
   */
  @Test
  @DisplayName("Test getWidthDirAdj()")
  void testGetWidthDirAdj3() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(1.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidthDirAdj());
  }

  /**
   * Test {@link TextPosition#getWidthDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getWidthDirAdj()}
   */
  @Test
  @DisplayName("Test getWidthDirAdj()")
  void testGetWidthDirAdj4() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(0.0f, -1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidthDirAdj());
  }

  /**
   * Test {@link TextPosition#getWidthDirAdj()}.
   * <p>
   * Method under test: {@link TextPosition#getWidthDirAdj()}
   */
  @Test
  @DisplayName("Test getWidthDirAdj()")
  void testGetWidthDirAdj5() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, 1.0f);

    // Act and Assert
    assertEquals(10.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getWidthDirAdj());
  }

  /**
   * Test {@link TextPosition#getFontSizeInPt()}.
   * <p>
   * Method under test: {@link TextPosition#getFontSizeInPt()}
   */
  @Test
  @DisplayName("Test getFontSizeInPt()")
  void testGetFontSizeInPt() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(3.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getFontSizeInPt());
  }

  /**
   * Test {@link TextPosition#getXScale()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getXScale()}
   */
  @Test
  @DisplayName("Test getXScale(); then return one")
  void testGetXScale_thenReturnOne() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(1.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getXScale());
  }

  /**
   * Test {@link TextPosition#getYScale()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#getYScale()}
   */
  @Test
  @DisplayName("Test getYScale(); then return one")
  void testGetYScale_thenReturnOne() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertEquals(1.0f, (new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).getYScale());
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, -1.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertFalse(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains2() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 90.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertFalse(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains3() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertFalse(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains4() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getTranslateInstance(-1.0f, -1.0f);
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertTrue(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains5() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 0.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertFalse(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition)")
  void testContains6() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = Matrix.getTranslateInstance(-1.0f, -1.0f);

    // Act and Assert
    assertTrue(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#contains(TextPosition)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#contains(TextPosition)}
   */
  @Test
  @DisplayName("Test contains(TextPosition); then return 'true'")
  void testContains_thenReturnTrue() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertTrue(textPosition.contains(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPosition#mergeDiacritic(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#mergeDiacritic(TextPosition)}
   */
  @Test
  @DisplayName("Test mergeDiacritic(TextPosition)")
  void testMergeDiacritic() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();
    TextPosition diacritic = new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Act
    textPosition.mergeDiacritic(diacritic);

    // Assert that nothing has changed
    assertEquals("Unicode", diacritic.getUnicode());
    assertEquals("Unicode", diacritic.getVisuallyOrderedUnicode());
    assertEquals(1, diacritic.getIndividualWidths().length);
  }

  /**
   * Test {@link TextPosition#mergeDiacritic(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#mergeDiacritic(TextPosition)}
   */
  @Test
  @DisplayName("Test mergeDiacritic(TextPosition)")
  void testMergeDiacritic2() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, -1.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act
    textPosition.mergeDiacritic(new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "ー",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));

    // Assert
    assertEquals("Unicode", textPosition.getUnicode());
    assertEquals("Unicode", textPosition.getVisuallyOrderedUnicode());
    assertEquals(1, textPosition.getIndividualWidths().length);
  }

  /**
   * Test {@link TextPosition#mergeDiacritic(TextPosition)}.
   * <p>
   * Method under test: {@link TextPosition#mergeDiacritic(TextPosition)}
   */
  @Test
  @DisplayName("Test mergeDiacritic(TextPosition)")
  void testMergeDiacritic3() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "ー",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();
    TextPosition diacritic = new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "ー",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Act
    textPosition.mergeDiacritic(diacritic);

    // Assert
    assertEquals("ー", diacritic.getUnicode());
    assertEquals("ー", diacritic.getVisuallyOrderedUnicode());
    assertEquals(1, diacritic.getIndividualWidths().length);
  }

  /**
   * Test {@link TextPosition#isDiacritic()}.
   * <p>
   * Method under test: {@link TextPosition#isDiacritic()}
   */
  @Test
  @DisplayName("Test isDiacritic()")
  void testIsDiacritic() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertFalse((new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)).isDiacritic());
  }

  /**
   * Test {@link TextPosition#isDiacritic()}.
   * <p>
   * Method under test: {@link TextPosition#isDiacritic()}
   */
  @Test
  @DisplayName("Test isDiacritic()")
  void testIsDiacritic2() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    textPosition.setUnicode("ー");

    // Act and Assert
    assertFalse(textPosition.isDiacritic());
  }

  /**
   * Test {@link TextPosition#equals(Object)}, and
   * {@link TextPosition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TextPosition#equals(Object)}
   *   <li>{@link TextPosition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    // Act and Assert
    assertEquals(textPosition, textPosition);
    int expectedHashCodeResult = textPosition.hashCode();
    assertEquals(expectedHashCodeResult, textPosition.hashCode());
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(3, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, -1.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, -1.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws IOException {
    // Arrange
    Matrix textMatrix = Matrix.getScaleInstance(10.0f, 10.0f);
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, -1.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, -1.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, -1.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, -1.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{3, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), -1.0f, 3);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();
    TextPosition textPosition = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 1);
    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertNotEquals(textPosition, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f,
        "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3));
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertNotEquals(new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3), null);
  }

  /**
   * Test {@link TextPosition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TextPosition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() throws IOException {
    // Arrange
    Matrix textMatrix = new Matrix();

    // Act and Assert
    assertNotEquals(new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3), "Different type to TextPosition");
  }
}
