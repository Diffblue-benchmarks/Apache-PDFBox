package org.apache.pdfbox.multipdf;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LayerUtilityDiffblueTest {
  /**
   * Test {@link LayerUtility#LayerUtility(PDDocument)}.
   *
   * <p>Method under test: {@link LayerUtility#LayerUtility(PDDocument)}
   */
  @Test
  @DisplayName("Test new LayerUtility(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LayerUtility.<init>(PDDocument)"})
  void testNewLayerUtility() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, new LayerUtility(targetDoc).getDocument());
  }

  /**
   * Test {@link LayerUtility#getDocument()}.
   *
   * <p>Method under test: {@link LayerUtility#getDocument()}
   */
  @Test
  @DisplayName("Test getDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDDocument LayerUtility.getDocument()"})
  void testGetDocument() {
    // Arrange
    PDDocument targetDoc = new PDDocument();

    // Act and Assert
    assertSame(targetDoc, new LayerUtility(targetDoc).getDocument());
  }
}
