package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDocumentNameDictionaryDiffblueTest {
  /**
   * Test {@link PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog,
   * COSDictionary)}.
   *
   * <p>Method under test: {@link
   * PDDocumentNameDictionary#PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDocumentNameDictionary(PDDocumentCatalog, COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDocumentNameDictionary.<init>(PDDocumentCatalog, COSDictionary)"})
  void testNewPDDocumentNameDictionary() {
    // Arrange
    PDDocumentCatalog cat = new PDDocumentCatalog(new PDDocument());
    COSDictionary names = new COSDictionary();

    // Act
    PDDocumentNameDictionary actualPdDocumentNameDictionary =
        new PDDocumentNameDictionary(cat, names);

    // Assert
    assertSame(names, actualPdDocumentNameDictionary.getCOSObject());
  }
}
