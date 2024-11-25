package org.apache.pdfbox.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDMarkedContent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFMarkedContentExtractorDiffblueTest {
  /**
   * Test {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}.
   * <p>
   * Method under test:
   * {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor()}
   */
  @Test
  @DisplayName("Test new PDFMarkedContentExtractor()")
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
   * <p>
   * Method under test:
   * {@link PDFMarkedContentExtractor#PDFMarkedContentExtractor(String)}
   */
  @Test
  @DisplayName("Test new PDFMarkedContentExtractor(String)")
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

  /**
   * Test
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
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
   * Test
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDFMarkedContentExtractor#beginMarkedContentSequence(COSName, COSDictionary)}
   */
  @Test
  @DisplayName("Test beginMarkedContentSequence(COSName, COSDictionary)")
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
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDFMarkedContentExtractor#setSuppressDuplicateOverlappingText(boolean)}
   *   <li>{@link PDFMarkedContentExtractor#getMarkedContents()}
   *   <li>{@link PDFMarkedContentExtractor#isSuppressDuplicateOverlappingText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
}
