package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImportXFDFDiffblueTest {
  /**
   * Test {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName("Test importFDF(PDDocument, FDFDocument); given COSDictionary(); then PDDocument() SignatureFields size is one")
  void testImportFDF_givenCOSDictionary_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
    // Arrange
    ImportXFDF importXFDF = new ImportXFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    importXFDF.importFDF(pdfDocument, new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))));

    // Assert
    List<PDSignatureField> signatureFields = pdfDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertTrue(signatureFields.get(0).getAcroForm().isCachingFields());
  }

  /**
   * Test {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName("Test importFDF(PDDocument, FDFDocument); given PDPage(); then PDDocument() SignatureFields size is one")
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
