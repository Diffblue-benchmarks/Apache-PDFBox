package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFieldTreeDiffblueTest {
  /**
   * Test {@link PDFieldTree#PDFieldTree(PDAcroForm)}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  @DisplayName(
      "Test new PDFieldTree(PDAcroForm); then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFieldTree.<init>(PDAcroForm)"})
  void testNewPDFieldTree_thenReturnSpliteratorExactSizeIfKnownIsMinusOne() {
    // Arrange and Act
    PDFieldTree actualPdFieldTree = new PDFieldTree(new PDAcroForm(new PDDocument()));
    Iterator<PDField> actualIteratorResult = actualPdFieldTree.iterator();

    // Assert
    assertEquals(-1L, actualPdFieldTree.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link PDFieldTree#iterator()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return not hasNext.
   * </ul>
   *
   * <p>Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return not hasNext")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDFieldTree.iterator()"})
  void testIterator_givenPDAcroFormWithDocIsPDDocument_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse(new PDFieldTree(new PDAcroForm(new PDDocument())).iterator().hasNext());
  }
}
