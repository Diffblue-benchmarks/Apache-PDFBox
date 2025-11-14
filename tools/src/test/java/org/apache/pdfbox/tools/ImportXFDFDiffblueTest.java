package org.apache.pdfbox.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImportXFDFDiffblueTest {
  @Mock private File file;

  @InjectMocks private ImportXFDF importXFDF;

  /**
   * Test {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}.
   *
   * <ul>
   *   <li>Given {@link ImportXFDF} (default constructor).
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test importFDF(PDDocument, FDFDocument); given ImportXFDF (default constructor); then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportXFDF.importFDF(PDDocument, FDFDocument)"})
  void testImportFDF_givenImportXFDF_thenPDDocumentSignatureFieldsSizeIsOne() throws IOException {
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

  /**
   * Test {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}.
   *
   * <ul>
   *   <li>Given {@link ImportXFDF} (default constructor).
   *   <li>Then {@link PDDocument#PDDocument()} SignatureFields size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImportXFDF#importFDF(PDDocument, FDFDocument)}
   */
  @Test
  @DisplayName(
      "Test importFDF(PDDocument, FDFDocument); given ImportXFDF (default constructor); then PDDocument() SignatureFields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ImportXFDF.importFDF(PDDocument, FDFDocument)"})
  void testImportFDF_givenImportXFDF_thenPDDocumentSignatureFieldsSizeIsOne2() throws IOException {
    // Arrange
    ImportXFDF importXFDF = new ImportXFDF();

    PDDocument pdfDocument = new PDDocument();
    pdfDocument.addPage(new PDPage());
    pdfDocument.addSignature(new PDSignature());

    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    importXFDF.importFDF(pdfDocument, fdfDocument);

    // Assert
    List<PDSignatureField> signatureFields = pdfDocument.getSignatureFields();
    assertEquals(1, signatureFields.size());
    assertTrue(signatureFields.get(0).getAcroForm().isCachingFields());
  }

  /**
   * Test {@link ImportXFDF#call()}.
   *
   * <p>Method under test: {@link ImportXFDF#call()}
   */
  @Test
  @DisplayName("Test call()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ImportXFDF.call()"})
  void testCall() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), ""));

    // Act
    Integer actualCallResult = importXFDF.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }

  /**
   * Test {@link ImportXFDF#call()}.
   *
   * <ul>
   *   <li>Given {@link File} {@link File#toPath()} return Property is {@code java.io.tmpdir} is
   *       array of {@link String} with {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link ImportXFDF#call()}
   */
  @Test
  @DisplayName(
      "Test call(); given File toPath() return Property is 'java.io.tmpdir' is array of String with 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer ImportXFDF.call()"})
  void testCall_givenFileToPathReturnPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxt() {
    // Arrange
    when(file.toPath()).thenReturn(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"));

    // Act
    Integer actualCallResult = importXFDF.call();

    // Assert
    verify(file).toPath();
    assertEquals(4, actualCallResult.intValue());
  }
}
