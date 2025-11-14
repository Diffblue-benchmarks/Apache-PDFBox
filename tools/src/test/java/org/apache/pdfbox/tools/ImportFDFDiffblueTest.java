package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImportFDFDiffblueTest {
  /**
   * Test {@link ImportFDF#importFDF(PDDocument, FDFDocument)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link ImportFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test importFDF(PDDocument, FDFDocument); given COSDictionary(); when COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportFDF.importFDF(PDDocument, FDFDocument)"})
  void testImportFDF_givenCOSDictionary_whenCOSDocumentTrailerIsCOSDictionary() throws IOException {
    // Arrange
    ImportFDF importFDF = new ImportFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    importFDF.importFDF(pdfDocument, fdfDocument);

    // Assert
    assertEquals(1, pdfDocument.getSignatureFields().size());
    COSDictionary cOSObject = pdfDocument.getDocumentCatalog().getAcroForm().getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link ImportFDF#importFDF(PDDocument, FDFDocument)}.
   *
   * <ul>
   *   <li>Given {@link ImportFDF} (default constructor).
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImportFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test importFDF(PDDocument, FDFDocument); given ImportFDF (default constructor); then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportFDF.importFDF(PDDocument, FDFDocument)"})
  void testImportFDF_givenImportFDF_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
    // Arrange
    ImportFDF importFDF = new ImportFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    // Act
    importFDF.importFDF(pdfDocument, new FDFDocument());

    // Assert
    assertEquals(1, pdfDocument.getSignatureFields().size());
    COSDictionary cOSObject = pdfDocument.getDocumentCatalog().getAcroForm().getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }
}
