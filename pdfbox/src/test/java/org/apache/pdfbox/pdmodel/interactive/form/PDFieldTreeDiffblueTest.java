package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDFieldTree.iterator()"})
  void testIterator_thenThrowIllegalArgumentException() {
    // Arrange
    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getFields()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDFieldTree(acroForm).iterator());
    verify(acroForm).getFields();
  }
}
