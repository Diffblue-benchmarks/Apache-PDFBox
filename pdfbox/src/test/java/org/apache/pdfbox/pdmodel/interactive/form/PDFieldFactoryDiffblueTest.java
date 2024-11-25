package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFieldFactoryDiffblueTest {
  /**
   * Test
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test createField(PDAcroForm, COSDictionary, PDNonTerminalField); when COSDictionary(); then return 'null'")
  void testCreateField_whenCOSDictionary_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertNull(PDFieldFactory.createField(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }

  /**
   * Test
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDFieldFactory#createField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test createField(PDAcroForm, COSDictionary, PDNonTerminalField); when COSStream(); then return 'null'")
  void testCreateField_whenCOSStream_thenReturnNull() {
    // Arrange
    PDAcroForm form = new PDAcroForm(new PDDocument());
    COSStream field = new COSStream();

    // Act and Assert
    assertNull(PDFieldFactory.createField(form, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));
  }
}
