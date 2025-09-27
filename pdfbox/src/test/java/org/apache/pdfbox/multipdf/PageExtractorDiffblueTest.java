package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PageExtractorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PageExtractor.<init>(PDDocument, int, int)",
    "int PageExtractor.getEndPage()",
    "int PageExtractor.getStartPage()",
    "void PageExtractor.setEndPage(int)",
    "void PageExtractor.setStartPage(int)"
  })
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then return EndPage is one.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); given PDPage(); then return EndPage is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return EndPage is zero.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#PageExtractor(PDDocument)}
   */
  @Test
  @DisplayName("Test new PageExtractor(PDDocument); when PDDocument(); then return EndPage is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PageExtractor.<init>(PDDocument)"})
  void testNewPageExtractor_whenPDDocument_thenReturnEndPageIsZero() {
    // Arrange and Act
    PageExtractor actualPageExtractor = new PageExtractor(new PDDocument());

    // Assert
    assertEquals(0, actualPageExtractor.getEndPage());
    assertEquals(1, actualPageExtractor.getStartPage());
  }

  /**
   * Test {@link PageExtractor#extract()}.
   *
   * <ul>
   *   <li>Then ResourceCache return {@link DefaultResourceCache}.
   * </ul>
   *
   * <p>Method under test: {@link PageExtractor#extract()}
   */
  @Test
  @DisplayName("Test extract(); then ResourceCache return DefaultResourceCache")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument PageExtractor.extract()"})
  void testExtract_thenResourceCacheReturnDefaultResourceCache() throws IOException {
    // Arrange and Act
    PDDocument actualExtractResult = new PageExtractor(new PDDocument()).extract();

    // Assert
    assertTrue(actualExtractResult.getResourceCache() instanceof DefaultResourceCache);
    assertNull(actualExtractResult.getDocumentId());
    assertNull(actualExtractResult.getEncryption());
    assertNull(actualExtractResult.getLastSignatureDictionary());
    assertEquals(0, actualExtractResult.getNumberOfPages());
    assertEquals(1.4f, actualExtractResult.getVersion());
    assertFalse(actualExtractResult.isAllSecurityToBeRemoved());
    assertFalse(actualExtractResult.isEncrypted());
    assertTrue(actualExtractResult.getSignatureDictionaries().isEmpty());
    assertTrue(actualExtractResult.getSignatureFields().isEmpty());
  }
}
