package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageExtractorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PageExtractor#PageExtractor(PDDocument, int, int)}
   *   <li>{@link PageExtractor#setEndPage(int)}
   *   <li>{@link PageExtractor#setStartPage(int)}
   *   <li>{@link PageExtractor#getEndPage()}
   *   <li>{@link PageExtractor#getStartPage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument, int, int)", "int PageExtractor.getEndPage()",
      "int PageExtractor.getStartPage()", "void PageExtractor.setEndPage(int)", "void PageExtractor.setStartPage(int)"})
  void testGettersAndSetters() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument(), 1, 3);
    actualPageExtractor.setEndPage(3);
    actualPageExtractor.setStartPage(1);
    int actualEndPage = actualPageExtractor.getEndPage();

    // Assert
    assertEquals(1, actualPageExtractor.getStartPage());
    assertEquals(3, actualEndPage);
  }

  /**
   * Test {@link PageExtractor#PageExtractor(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then return EndPage is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); given PDPage(); then return EndPage is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument)"})
  void testNewPageExtractor_givenPDPage_thenReturnEndPageIsOne() {
    // Arrange
    PDDocument sourceDocument = new PDDocument();
    sourceDocument.addPage(new PDPage());

    // Act
    PageExtractor actualPageExtractor = new PageExtractor(sourceDocument);

    // Assert
    assertEquals(1, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Test {@link PageExtractor#PageExtractor(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return EndPage is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); when PDDocument(); then return EndPage is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument)"})
  void testNewPageExtractor_whenPDDocument_thenReturnEndPageIsZero() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument());

    // Assert
    assertEquals(0, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }
}
