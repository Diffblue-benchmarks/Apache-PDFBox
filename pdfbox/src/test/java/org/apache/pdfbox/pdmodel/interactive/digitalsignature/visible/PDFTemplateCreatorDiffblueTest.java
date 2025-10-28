package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class PDFTemplateCreatorDiffblueTest {
  /**
   * Method under test: {@link PDFTemplateCreator#getPdfStructure()}
   */
  @Test
  void testGetPdfStructure() {
    // Arrange and Act
    PDFTemplateStructure actualPdfStructure = (new PDFTemplateCreator(new PDVisibleSigBuilder())).getPdfStructure();

    // Assert
    assertNull(actualPdfStructure.getAffineTransform());
    assertNull(actualPdfStructure.getAcroFormFields());
    assertNull(actualPdfStructure.getProcSet());
    assertNull(actualPdfStructure.getAcroFormDictionary());
    assertNull(actualPdfStructure.getWidgetDictionary());
    assertNull(actualPdfStructure.getVisualSignature());
    assertNull(actualPdfStructure.getImageFormName());
    assertNull(actualPdfStructure.getImageName());
    assertNull(actualPdfStructure.getInnerFormName());
    assertNull(actualPdfStructure.getTemplate());
    assertNull(actualPdfStructure.getPage());
    assertNull(actualPdfStructure.getHolderFormResources());
    assertNull(actualPdfStructure.getImageFormResources());
    assertNull(actualPdfStructure.getInnerFormResources());
    assertNull(actualPdfStructure.getFormatterRectangle());
    assertNull(actualPdfStructure.getSignatureRectangle());
    assertNull(actualPdfStructure.getHolderFormStream());
    assertNull(actualPdfStructure.getImageFormStream());
    assertNull(actualPdfStructure.getInnerFormStream());
    assertNull(actualPdfStructure.getHolderForm());
    assertNull(actualPdfStructure.getImageForm());
    assertNull(actualPdfStructure.getInnerForm());
    assertNull(actualPdfStructure.getImage());
    assertNull(actualPdfStructure.getAppearanceDictionary());
    assertNull(actualPdfStructure.getPdSignature());
    assertNull(actualPdfStructure.getAcroForm());
    assertNull(actualPdfStructure.getSignatureField());
  }

  /**
   * Method under test:
   * {@link PDFTemplateCreator#PDFTemplateCreator(PDFTemplateBuilder)}
   */
  @Test
  void testNewPDFTemplateCreator() {
    // Arrange, Act and Assert
    PDFTemplateStructure pdfStructure = (new PDFTemplateCreator(new PDVisibleSigBuilder())).getPdfStructure();
    assertNull(pdfStructure.getAffineTransform());
    assertNull(pdfStructure.getAcroFormFields());
    assertNull(pdfStructure.getProcSet());
    assertNull(pdfStructure.getAcroFormDictionary());
    assertNull(pdfStructure.getWidgetDictionary());
    assertNull(pdfStructure.getVisualSignature());
    assertNull(pdfStructure.getImageFormName());
    assertNull(pdfStructure.getImageName());
    assertNull(pdfStructure.getInnerFormName());
    assertNull(pdfStructure.getTemplate());
    assertNull(pdfStructure.getPage());
    assertNull(pdfStructure.getHolderFormResources());
    assertNull(pdfStructure.getImageFormResources());
    assertNull(pdfStructure.getInnerFormResources());
    assertNull(pdfStructure.getFormatterRectangle());
    assertNull(pdfStructure.getSignatureRectangle());
    assertNull(pdfStructure.getHolderFormStream());
    assertNull(pdfStructure.getImageFormStream());
    assertNull(pdfStructure.getInnerFormStream());
    assertNull(pdfStructure.getHolderForm());
    assertNull(pdfStructure.getImageForm());
    assertNull(pdfStructure.getInnerForm());
    assertNull(pdfStructure.getImage());
    assertNull(pdfStructure.getAppearanceDictionary());
    assertNull(pdfStructure.getPdSignature());
    assertNull(pdfStructure.getAcroForm());
    assertNull(pdfStructure.getSignatureField());
  }
}
