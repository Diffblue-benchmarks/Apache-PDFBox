package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ImportFDFDiffblueTest {
  /**
   * Test {@link ImportFDF#importFDF(PDDocument, FDFDocument)}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog AcroForm COSObject
   * Values size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName("Test importFDF(PDDocument, FDFDocument); then PDDocument() DocumentCatalog AcroForm COSObject Values size is five")
  void testImportFDF_thenPDDocumentDocumentCatalogAcroFormCOSObjectValuesSizeIsFive() throws IOException {
    // Arrange
    ImportFDF importFDF = new ImportFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    // Act
    importFDF.importFDF(pdfDocument, new FDFDocument());

    // Assert
    COSDictionary cOSObject = pdfDocument.getDocumentCatalog().getAcroForm().getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link ImportFDF#importFDF(PDDocument, FDFDocument)}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument()} DocumentCatalog AcroForm COSObject
   * Values size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName("Test importFDF(PDDocument, FDFDocument); then PDDocument() DocumentCatalog AcroForm COSObject Values size is five")
  void testImportFDF_thenPDDocumentDocumentCatalogAcroFormCOSObjectValuesSizeIsFive2() throws IOException {
    // Arrange
    ImportFDF importFDF = new ImportFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());

    // Act
    importFDF.importFDF(pdfDocument, new FDFDocument(doc,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))));

    // Assert
    COSDictionary cOSObject = pdfDocument.getDocumentCatalog().getAcroForm().getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }
}
