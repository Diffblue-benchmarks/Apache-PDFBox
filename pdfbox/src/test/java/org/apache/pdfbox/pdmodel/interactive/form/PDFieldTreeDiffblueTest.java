package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFieldTreeDiffblueTest {
  /**
   * Test {@link PDFieldTree#PDFieldTree(PDAcroForm)}.
   * <ul>
   *   <li>Then iterator next return {@link PDCheckBox}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDFieldTree(PDAcroForm); then iterator next return PDCheckBox")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFieldTree.<init>(PDAcroForm)"})
  void testNewPDFieldTree_thenIteratorNextReturnPDCheckBox() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(acroForm)).iterator();

    // Assert
    assertTrue(actualIteratorResult.next() instanceof PDCheckBox);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link PDFieldTree#PDFieldTree(PDAcroForm)}.
   * <ul>
   *   <li>When {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDFieldTree(PDAcroForm); when PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDFieldTree.<init>(PDAcroForm)"})
  void testNewPDFieldTree_whenPDAcroFormWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Test {@link PDFieldTree#iterator()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return not hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDFieldTree.iterator()"})
  void testIterator_givenPDAcroFormWithDocIsPDDocument_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Test {@link PDFieldTree#iterator()}.
   * <ul>
   *   <li>Then next return {@link PDCheckBox}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then next return PDCheckBox")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterator PDFieldTree.iterator()"})
  void testIterator_thenNextReturnPDCheckBox() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(acroForm)).iterator();

    // Assert
    assertTrue(actualIteratorResult.next() instanceof PDCheckBox);
    assertFalse(actualIteratorResult.hasNext());
  }
}
