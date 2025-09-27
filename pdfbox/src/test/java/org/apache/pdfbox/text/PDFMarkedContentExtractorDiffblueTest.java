package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFMarkedContentExtractorDiffblueTest {
  /**
   * Test {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}.
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   */
  @Test
  @DisplayName("Test new PDFMarkedContentExtractor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMarkedContentExtractor.<init>()"})
  void testNewPDFMarkedContentExtractor() {
    // Arrange and Act
    PDFMarkedContentExtractor actualPdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Assert
    assertNull(actualPdfMarkedContentExtractor.getCurrentPage());
    assertNull(actualPdfMarkedContentExtractor.getResources());
    assertNull(actualPdfMarkedContentExtractor.getGraphicsState());
    assertNull(actualPdfMarkedContentExtractor.getInitialMatrix());
    assertEquals(0, actualPdfMarkedContentExtractor.getGraphicsStackSize());
    assertEquals(0, actualPdfMarkedContentExtractor.getLevel());
    assertTrue(actualPdfMarkedContentExtractor.getMarkedContents().isEmpty());
    assertTrue(actualPdfMarkedContentExtractor.isSuppressDuplicateOverlappingText());
  }

  /**
   * Test {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor(String)}.
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor(String)}
   */
  @Test
  @DisplayName("Test new PDFMarkedContentExtractor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMarkedContentExtractor.<init>(String)"})
  void testNewPDFMarkedContentExtractor2() {
    // Arrange and Act
    PDFMarkedContentExtractor actualPdfMarkedContentExtractor =
        new PDFMarkedContentExtractor("UTF-8");

    // Assert
    assertNull(actualPdfMarkedContentExtractor.getCurrentPage());
    assertNull(actualPdfMarkedContentExtractor.getResources());
    assertNull(actualPdfMarkedContentExtractor.getGraphicsState());
    assertNull(actualPdfMarkedContentExtractor.getInitialMatrix());
    assertEquals(0, actualPdfMarkedContentExtractor.getGraphicsStackSize());
    assertEquals(0, actualPdfMarkedContentExtractor.getLevel());
    assertTrue(actualPdfMarkedContentExtractor.getMarkedContents().isEmpty());
    assertTrue(actualPdfMarkedContentExtractor.isSuppressDuplicateOverlappingText());
  }

  /**
   * Test {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFMarkedContentExtractor.beginMarkedContentSequence(COSName, COSDictionary)"
  })
  void testBeginMarkedContentSequence() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSDictionary properties = new COSDictionary();

    // Act
    pdfMarkedContentExtractor.beginMarkedContentSequence(COSName.A, properties);

    // Assert
    List<PDMarkedContent> markedContents = pdfMarkedContentExtractor.getMarkedContents();
    assertEquals(1, markedContents.size());
    PDMarkedContent getResult = markedContents.get(0);
    assertEquals("A", getResult.getTag());
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertEquals(-1, getResult.getMCID());
    assertTrue(getResult.getContents().isEmpty());
    assertSame(properties, getResult.getProperties());
  }

  /**
   * Test {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}.
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName,
   * COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFMarkedContentExtractor.beginMarkedContentSequence(COSName, COSDictionary)"
  })
  void testBeginMarkedContentSequence2() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSDictionary properties = new COSDictionary();

    // Act
    pdfMarkedContentExtractor.beginMarkedContentSequence(null, properties);

    // Assert
    List<PDMarkedContent> markedContents = pdfMarkedContentExtractor.getMarkedContents();
    assertEquals(1, markedContents.size());
    PDMarkedContent getResult = markedContents.get(0);
    assertNull(getResult.getActualText());
    assertNull(getResult.getAlternateDescription());
    assertNull(getResult.getExpandedForm());
    assertNull(getResult.getLanguage());
    assertNull(getResult.getTag());
    assertEquals(-1, getResult.getMCID());
    assertTrue(getResult.getContents().isEmpty());
    assertSame(properties, getResult.getProperties());
  }

  /**
   * Test {@link PDFMarkedContentExtractor#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Given {@code ー}.
   *   <li>Then calls {@link TextPosition#getUnicode()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName("Test processTextPosition(TextPosition); given 'ー'; then calls getUnicode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMarkedContentExtractor.processTextPosition(TextPosition)"})
  void testProcessTextPosition_given_thenCallsGetUnicode() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    TextPosition text = mock(TextPosition.class);
    when(text.getUnicode()).thenReturn("ー");
    when(text.getWidth()).thenReturn(10.0f);
    when(text.getX()).thenReturn(10.0f);
    when(text.getY()).thenReturn(10.0f);

    // Act
    pdfMarkedContentExtractor.processTextPosition(text);

    // Assert
    verify(text).getUnicode();
    verify(text).getWidth();
    verify(text).getX();
    verify(text).getY();
  }

  /**
   * Test {@link PDFMarkedContentExtractor#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>When {@link Matrix} {@link Matrix#getTranslateX()} return ten.
   *   <li>Then calls {@link Matrix#getTranslateX()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFMarkedContentExtractor#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); when Matrix getTranslateX() return ten; then calls getTranslateX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFMarkedContentExtractor.processTextPosition(TextPosition)"})
  void testProcessTextPosition_whenMatrixGetTranslateXReturnTen_thenCallsGetTranslateX()
      throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    Matrix textMatrix = mock(Matrix.class);
    when(textMatrix.getTranslateX()).thenReturn(10.0f);

    // Act
    pdfMarkedContentExtractor.processTextPosition(
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
            new int[] {1, 0, 1, 0},
            new PDMMType1Font(new COSDictionary()),
            10.0f,
            3));

    // Assert
    verify(textMatrix).getTranslateX();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFMarkedContentExtractor#setSuppressDuplicateOverlappingText(boolean)}
   *   <li>{@link PDFMarkedContentExtractor#getMarkedContents()}
   *   <li>{@link PDFMarkedContentExtractor#isSuppressDuplicateOverlappingText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PDFMarkedContentExtractor.getMarkedContents()",
    "boolean PDFMarkedContentExtractor.isSuppressDuplicateOverlappingText()",
    "void PDFMarkedContentExtractor.setSuppressDuplicateOverlappingText(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.setSuppressDuplicateOverlappingText(true);
    List<PDMarkedContent> actualMarkedContents = pdfMarkedContentExtractor.getMarkedContents();
    boolean actualIsSuppressDuplicateOverlappingTextResult =
        pdfMarkedContentExtractor.isSuppressDuplicateOverlappingText();

    // Assert
    assertTrue(actualMarkedContents.isEmpty());
    assertTrue(actualIsSuppressDuplicateOverlappingTextResult);
  }
}
