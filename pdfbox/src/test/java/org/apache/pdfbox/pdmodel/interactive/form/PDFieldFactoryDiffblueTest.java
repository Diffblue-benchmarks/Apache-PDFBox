package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFieldFactoryDiffblueTest {
  /**
   * Test {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFieldFactory#createField(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName(
      "Test createField(PDAcroForm, COSDictionary, PDNonTerminalField); when COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDField PDFieldFactory.createField(PDAcroForm, COSDictionary, PDNonTerminalField)"
  })
  void testCreateField_whenCOSDictionary_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    PDField actualCreateFieldResult =
        PDFieldFactory.createField(
            form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Assert
    assertNull(actualCreateFieldResult);
  }
}
