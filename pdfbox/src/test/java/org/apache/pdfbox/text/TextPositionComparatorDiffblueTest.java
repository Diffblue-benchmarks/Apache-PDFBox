package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class TextPositionComparatorDiffblueTest {
  /**
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare() throws IOException {
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

  /**
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare2() throws IOException {
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
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare3() throws IOException {
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
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare4() throws IOException {
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
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare5() throws IOException {
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
   * Method under test:
   * {@link TextPositionComparator#compare(TextPosition, TextPosition)}
   */
  @Test
  void testCompare6() throws IOException {
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
}
