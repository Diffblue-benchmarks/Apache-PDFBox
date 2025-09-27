package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Set;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AngleCollectorDiffblueTest {
  /**
   * Test {@link AngleCollector#AngleCollector()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link AngleCollector}
   */
  @Test
  @DisplayName("Test new AngleCollector()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.<init>()"})
  void testNewAngleCollector() throws IOException {
    // Arrange and Act
    AngleCollector actualAngleCollector = new AngleCollector();

    // Assert
    assertEquals(" ", actualAngleCollector.getWordSeparator());
    assertEquals("", actualAngleCollector.getArticleEnd());
    assertEquals("", actualAngleCollector.getArticleStart());
    assertEquals("", actualAngleCollector.getPageStart());
    assertEquals("", actualAngleCollector.getParagraphEnd());
    assertEquals("", actualAngleCollector.getParagraphStart());
    assertEquals("\n", actualAngleCollector.getLineSeparator());
    assertEquals("\n", actualAngleCollector.getPageEnd());
    assertNull(actualAngleCollector.getCurrentPage());
    assertNull(actualAngleCollector.getResources());
    assertNull(actualAngleCollector.getGraphicsState());
    assertNull(actualAngleCollector.getEndBookmark());
    assertNull(actualAngleCollector.getStartBookmark());
    assertNull(actualAngleCollector.getInitialMatrix());
    assertEquals(0, actualAngleCollector.getGraphicsStackSize());
    assertEquals(0, actualAngleCollector.getLevel());
    assertEquals(0.3f, actualAngleCollector.getAverageCharTolerance());
    assertEquals(0.5f, actualAngleCollector.getSpacingTolerance());
    assertEquals(1, actualAngleCollector.getStartPage());
    assertEquals(2.0f, actualAngleCollector.getIndentThreshold());
    assertEquals(2.5f, actualAngleCollector.getDropThreshold());
    assertFalse(actualAngleCollector.getAddMoreFormatting());
    assertFalse(actualAngleCollector.getSortByPosition());
    assertTrue(actualAngleCollector.getAngles().isEmpty());
    assertTrue(actualAngleCollector.getSeparateByBeads());
    assertTrue(actualAngleCollector.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualAngleCollector.getEndPage());
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition() throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    angleCollector.addOperator(new DrawObject(new PDFTextStripper()));
    Matrix textMatrix = new Matrix();

    // Act
    angleCollector.processTextPosition(
        new TextPosition(
            1,
            10.0f,
            10.0f,
            textMatrix,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            "Unicode",
            new int[] {1, -1, 1, -1},
            new PDMMType1Font(new COSDictionary()),
            10.0f,
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }

  /**
   * Test {@link AngleCollector#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Then {@link AngleCollector#AngleCollector()} Angles size is one.
   * </ul>
   *
   * <p>Method under test: {@link AngleCollector#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition); then AngleCollector() Angles size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AngleCollector.processTextPosition(TextPosition)"})
  void testProcessTextPosition_thenAngleCollectorAnglesSizeIsOne() throws IOException {
    // Arrange
    AngleCollector angleCollector = new AngleCollector();
    Matrix textMatrix = new Matrix();

    // Act
    angleCollector.processTextPosition(
        new TextPosition(
            1,
            10.0f,
            10.0f,
            textMatrix,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            10.0f,
            "Unicode",
            new int[] {1, -1, 1, -1},
            new PDMMType1Font(new COSDictionary()),
            10.0f,
            3));

    // Assert
    Set<Integer> angles = angleCollector.getAngles();
    assertEquals(1, angles.size());
    assertTrue(angles.contains(0));
  }
}
