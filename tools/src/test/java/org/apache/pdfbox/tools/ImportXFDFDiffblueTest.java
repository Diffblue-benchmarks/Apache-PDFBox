package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImportXFDFDiffblueTest {
  /**
   * Test {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}.
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test importFDF(PDDocument, FDFDocument); given PDPage(); then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportXFDF.importFDF(PDDocument, FDFDocument)"})
  void testImportFDF_givenPDPage_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
    // Arrange
    ImportXFDF importXFDF = new ImportXFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    // Act
    importXFDF.importFDF(pdfDocument, new FDFDocument());

    // Assert
    List<PDSignatureField> signatureFields = pdfDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertTrue(signatureFields.get(0).getAcroForm().isCachingFields());
  }
}
