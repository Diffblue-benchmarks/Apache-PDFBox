package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFMarkedContentExtractorDiffblueTest {
  /**
   * Method under test:
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDFMarkedContentExtractor#processTextPosition(TextPosition)}
   */
  @Test
  void testProcessTextPosition() throws IOException {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    PDMMType1Font font = new PDMMType1Font(fontDictionary);

    // Act
    pdfMarkedContentExtractor.processTextPosition(new TextPosition(1, 10.0f, 10.0f, new Matrix(), 10.0f, 10.0f, 10.0f,
        10.0f, 10.0f, "Unicode", new int[]{1, 0, 1, 0}, font, 10.0f, 3));

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDFMarkedContentExtractor#setSuppressDuplicateOverlappingText(boolean)}
   *   <li>{@link PDFMarkedContentExtractor#getMarkedContents()}
   *   <li>{@link PDFMarkedContentExtractor#isSuppressDuplicateOverlappingText()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDFMarkedContentExtractor pdfMarkedContentExtractor = new PDFMarkedContentExtractor();

    // Act
    pdfMarkedContentExtractor.setSuppressDuplicateOverlappingText(true);
    List<PDMarkedContent> actualMarkedContents = pdfMarkedContentExtractor.getMarkedContents();
    boolean actualIsSuppressDuplicateOverlappingTextResult = pdfMarkedContentExtractor
        .isSuppressDuplicateOverlappingText();

    // Assert that nothing has changed
    assertTrue(actualMarkedContents.isEmpty());
    assertTrue(actualIsSuppressDuplicateOverlappingTextResult);
  }

  /**
   * Method under test:
   * {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   */
  @Test
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
   * Method under test:
   * {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor(String)}
   */
  @Test
  void testNewPDFMarkedContentExtractor2() {
    // Arrange and Act
    PDFMarkedContentExtractor actualPdfMarkedContentExtractor = new PDFMarkedContentExtractor("UTF-8");

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
}
