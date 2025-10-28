package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFTextStripperByAreaDiffblueTest {
  /**
   * Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  void testExtractRegions() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    // Act
    pdfTextStripperByArea.extractRegions(new PDPage());

    // Assert that nothing has changed
    assertEquals(0, pdfTextStripperByArea.getGraphicsStackSize());
    assertTrue(pdfTextStripperByArea.getCharactersByArticle().isEmpty());
    assertEquals(Integer.MAX_VALUE, pdfTextStripperByArea.getEndPage());
  }

  /**
   * Method under test: {@link PDFTextStripperByArea#extractRegions(PDPage)}
   */
  @Test
  void testExtractRegions2() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    pdfTextStripperByArea.addRegion("us-east-2", new Rectangle(1, 1));

    // Act
    pdfTextStripperByArea.extractRegions(new PDPage());

    // Assert
    assertNull(pdfTextStripperByArea.getOutput());
    assertNull(pdfTextStripperByArea.getCurrentPage());
    assertNull(pdfTextStripperByArea.getGraphicsState());
    assertNull(pdfTextStripperByArea.getInitialMatrix());
    assertEquals(0, pdfTextStripperByArea.getGraphicsStackSize());
    assertEquals(1, pdfTextStripperByArea.getEndPage());
    assertTrue(pdfTextStripperByArea.getCharactersByArticle().isEmpty());
  }

  /**
   * Method under test:
   * {@link PDFTextStripperByArea#processTextPosition(TextPosition)}
   */
  @Test
  void testProcessTextPosition() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    // Act
    pdfTextStripperByArea.processTextPosition(new TextPosition(1, 10.0f, 10.0f, new Matrix(), 10.0f, 10.0f, 10.0f,
        10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, font, 10.0f, 3));

    // Assert that nothing has changed
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFTextStripperByArea#setShouldSeparateByBeads(boolean)}
   *   <li>{@link PDFTextStripperByArea#getRegions()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDFTextStripperByArea pdfTextStripperByArea = new PDFTextStripperByArea();

    // Act
    pdfTextStripperByArea.setShouldSeparateByBeads(true);
    pdfTextStripperByArea.setShouldSeparateByBeads(true);

    // Assert that nothing has changed
    assertTrue(pdfTextStripperByArea.getRegions().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link PDFTextStripperByArea}
   */
  @Test
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
    List<Pattern> listItemPatterns = actualPdfTextStripperByArea.getListItemPatterns();
    assertEquals(10, listItemPatterns.size());
    assertEquals("[IVXL]+\\.", listItemPatterns.get(8).pattern());
    assertEquals("[a-z]\\)", listItemPatterns.get(7).pattern());
    assertEquals("[ivxl]+\\.", listItemPatterns.get(9).pattern());
    assertEquals("\\.", listItemPatterns.get(0).pattern());
    assertEquals("\\[\\d+\\]", listItemPatterns.get(2).pattern());
    assertEquals("\\d+\\.", listItemPatterns.get(1).pattern());
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
}
