package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFTextStripperByAreaDiffblueTest {
  /**
   * Test {@link PDFTextStripperByArea#PDFTextStripperByArea()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PDFTextStripperByArea}
   */
  @Test
  @DisplayName("Test new PDFTextStripperByArea()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.<init>()"})
  void testNewPDFTextStripperByArea() throws IOException {
    // Arrange and Act
    PDFTextStripperByArea actualPdfTextStripperByArea = new PDFTextStripperByArea();

    // Assert
    assertEquals(" ", actualPdfTextStripperByArea.getWordSeparator());
    assertEquals("", actualPdfTextStripperByArea.getArticleEnd());
    assertEquals("", actualPdfTextStripperByArea.getArticleStart());
    assertEquals("", actualPdfTextStripperByArea.getPageStart());
    assertEquals("", actualPdfTextStripperByArea.getParagraphEnd());
    assertEquals("", actualPdfTextStripperByArea.getParagraphStart());
    assertEquals("\n", actualPdfTextStripperByArea.getLineSeparator());
    assertEquals("\n", actualPdfTextStripperByArea.getPageEnd());
    assertNull(actualPdfTextStripperByArea.getOutput());
    assertNull(actualPdfTextStripperByArea.actualText);
    assertNull(actualPdfTextStripperByArea.document);
    assertNull(actualPdfTextStripperByArea.getCurrentPage());
    assertNull(actualPdfTextStripperByArea.getResources());
    assertNull(actualPdfTextStripperByArea.getGraphicsState());
    assertNull(actualPdfTextStripperByArea.getEndBookmark());
    assertNull(actualPdfTextStripperByArea.getStartBookmark());
    assertNull(actualPdfTextStripperByArea.getInitialMatrix());
    assertEquals(0, actualPdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(0, actualPdfTextStripperByArea.getLevel());
    assertEquals(0.3f, actualPdfTextStripperByArea.getAverageCharTolerance());
    assertEquals(0.5f, actualPdfTextStripperByArea.getSpacingTolerance());
    assertEquals(1, actualPdfTextStripperByArea.getCurrentPageNo());
    assertEquals(1, actualPdfTextStripperByArea.getStartPage());
    assertEquals(10, actualPdfTextStripperByArea.getListItemPatterns().size());
    assertEquals(2.0f, actualPdfTextStripperByArea.getIndentThreshold());
    assertEquals(2.5f, actualPdfTextStripperByArea.getDropThreshold());
    assertFalse(actualPdfTextStripperByArea.getAddMoreFormatting());
    assertFalse(actualPdfTextStripperByArea.getSeparateByBeads());
    assertFalse(actualPdfTextStripperByArea.getSortByPosition());
    assertFalse(actualPdfTextStripperByArea.firstActualTextPosition);
    assertTrue(actualPdfTextStripperByArea.getCharactersByArticle().isEmpty());
    assertTrue(actualPdfTextStripperByArea.getRegions().isEmpty());
    assertTrue(actualPdfTextStripperByArea.getSuppressDuplicateOverlappingText());
    assertEquals(Integer.MAX_VALUE, actualPdfTextStripperByArea.getEndPage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDFTextStripperByArea#setShouldSeparateByBeads(boolean)}
   *   <li>{@link PDFTextStripperByArea#getRegions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List PDFTextStripperByArea.getRegions()",
    "void PDFTextStripperByArea.setShouldSeparateByBeads(boolean)"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    // Act
    pdfTextStripperByArea.setShouldSeparateByBeads(true);

    // Assert
    assertTrue(pdfTextStripperByArea.getRegions().isEmpty());
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getBounds2D() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions2() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.setSortByPosition(true);
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getBounds2D() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions3() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.setSortByPosition(true);
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    PDRectangle cropBox =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions4() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.setSortByPosition(true);
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    PDRectangle cropBox = new PDRectangle(0.0f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    page.setCropBox(cropBox);
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle#A0}.
   *   <li>When {@link PDPage#PDPage()} CropBox is {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage); given A0; when PDPage() CropBox is A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_givenA0_whenPDPageCropBoxIsA0() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.setSortByPosition(true);
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    PDPage page = new PDPage();
    page.setCropBox(PDRectangle.A0);
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    assertTrue(currentClippingPaths.get(0) instanceof Path2D.Double);
    assertTrue(graphicsState.getCurrentClippingPath().getBounds2D() instanceof Double);
    assertArrayEquals(new float[] {}, graphicsState.getLineDashPattern().getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#extractRegions(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDFTextStripperByArea#PDFTextStripperByArea()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  @DisplayName("Test extractRegions(PDPage); given PDFTextStripperByArea()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.extractRegions(PDPage)"})
  void testExtractRegions_givenPDFTextStripperByArea() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    PDPage page = new PDPage();
    page.setContents(new PDStream(new COSDocument()));

    // Act
    pdfTextStripperByArea.extractRegions(page);

    // Assert
    PDGraphicsState graphicsState = pdfTextStripperByArea.getGraphicsState();
    List<Path2D> currentClippingPaths = graphicsState.getCurrentClippingPaths();
    assertEquals(1, currentClippingPaths.size());
    Path2D getResult = currentClippingPaths.get(0);
    assertTrue(getResult instanceof Path2D.Double);
    assertTrue(getResult.getBounds2D() instanceof Double);
    PDLineDashPattern lineDashPattern = graphicsState.getLineDashPattern();
    COSBase cOSObject = lineDashPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(1) instanceof COSInteger);
    assertArrayEquals(new float[] {}, lineDashPattern.getDashArray(), 0.0f);
    assertArrayEquals(
        new float[] {0.0f}, graphicsState.getNonStrokingColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDFTextStripperByArea#processTextPosition(TextPosition)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link TextPosition} {@link TextPosition#getX()} return ten.
   *   <li>Then calls {@link TextPosition#getX()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTextStripperByArea#processTextPosition(TextPosition)}
   */
  @Test
  @DisplayName(
      "Test processTextPosition(TextPosition); given ten; when TextPosition getX() return ten; then calls getX()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTextStripperByArea.processTextPosition(TextPosition)"})
  void testProcessTextPosition_givenTen_whenTextPositionGetXReturnTen_thenCallsGetX()
      throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Double());

    TextPosition text = mock(TextPosition.class);
    when(text.getX()).thenReturn(10.0f);
    when(text.getY()).thenReturn(10.0f);

    // Act
    pdfTextStripperByArea.processTextPosition(text);

    // Assert
    verify(text).getX();
    verify(text).getY();
  }
}
