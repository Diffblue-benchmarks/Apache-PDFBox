package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TextPositionComparatorDiffblueTest {
  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'")
  void testCompareWithTextPositionTextPosition() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = new Matrix();
    TextPosition pos1 = new TextPosition(1, 10.0f, -1.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(-1, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'")
  void testCompareWithTextPositionTextPosition2() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = new Matrix();
    TextPosition pos1 = new TextPosition(1, 10.0f, 1.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(0, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'")
  void testCompareWithTextPositionTextPosition3() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = new Matrix();
    TextPosition pos1 = new TextPosition(1, 10.0f, 90.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(1, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'")
  void testCompareWithTextPositionTextPosition4() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = Matrix.getScaleInstance(-1.0f, -1.0f);
    TextPosition pos1 = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(1, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'")
  void testCompareWithTextPositionTextPosition5() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = Matrix.getTranslateInstance(-1.0f, -1.0f);
    TextPosition pos1 = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(-1, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }

  /**
   * Test {@link TextPositionComparator#compare(TextPosition, TextPosition)} with
   * {@code TextPosition}, {@code TextPosition}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  @DisplayName("Test compare(TextPosition, TextPosition) with 'TextPosition', 'TextPosition'; then return zero")
  void testCompareWithTextPositionTextPosition_thenReturnZero() throws IOException {
    // Arrange
    TextPositionComparator textPositionComparator = new TextPositionComparator();
    Matrix textMatrix = new Matrix();
    TextPosition pos1 = new TextPosition(1, 10.0f, 10.0f, textMatrix, 10.0f, 10.0f, 10.0f, 10.0f, 10.0f, "Unicode",
        new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3);

    Matrix textMatrix2 = new Matrix();

    // Act and Assert
    assertEquals(0, textPositionComparator.compare(pos1, new TextPosition(1, 10.0f, 10.0f, textMatrix2, 10.0f, 10.0f,
        10.0f, 10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, new PDMMType1Font(new COSDictionary()), 10.0f, 3)));
  }
}
