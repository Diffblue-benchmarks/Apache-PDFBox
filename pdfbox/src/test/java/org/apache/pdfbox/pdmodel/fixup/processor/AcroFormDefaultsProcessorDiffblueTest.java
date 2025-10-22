package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AcroFormDefaultsProcessorDiffblueTest {
  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIs42() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultAppearance("42");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormDefaultsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultAppearance is {@code +}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDAcroFormWithDocIsPDDocumentDefaultAppearanceIsPlusSign() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultAppearance("+");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormDefaultsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()} DefaultResources is {@link PDResources#PDResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultResources is PDResources()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDAcroFormWithDocIsPDDocumentDefaultResourcesIsPDResources() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormDefaultsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDResources dr = new PDResources();
    dr.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(dr);
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormDefaultsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   * <ul>
   *   <li>Then calls {@link PDDocument#addPage(PDPage)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); then calls addPage(PDPage)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_thenCallsAddPage() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(new PDAcroForm(new PDDocument()));
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormDefaultsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }
}
