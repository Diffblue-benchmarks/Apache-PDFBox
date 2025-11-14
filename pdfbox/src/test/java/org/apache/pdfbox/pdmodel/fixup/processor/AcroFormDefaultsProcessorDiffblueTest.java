package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AcroFormDefaultsProcessorDiffblueTest {
  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#containsKey(COSName)} return {@code
   *       false}.
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given COSDictionary containsKey(COSName) return 'false'; then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenCOSDictionaryContainsKeyReturnFalse_thenCallsContainsKey()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(false);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    doNothing().when(cosDictionary2).setNeedToBeUpdated(anyBoolean());
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    PDResources pdResources = mock(PDResources.class);
    doNothing().when(pdResources).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    when(pdResources.getCOSObject()).thenReturn(cosDictionary2);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).setNeedToBeUpdated(true);
    verify(cosDictionary, atLeast(1)).setNeedToBeUpdated(true);
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources, atLeast(1)).getCOSObject();
    verify(pdResources, atLeast(1)).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#containsKey(COSName)} return {@code
   *       true}.
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given COSDictionary containsKey(COSName) return 'true'; then calls containsKey(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenCOSDictionaryContainsKeyReturnTrue_thenCallsContainsKey()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getCOSObject()).thenReturn(cosDictionary2);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getCOSObject();
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDResources pdResources = mock(PDResources.class);
    doNothing().when(pdResources).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    when(pdResources.getCOSObject()).thenReturn(cosDictionary);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setNeedToBeUpdated(true);
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources, atLeast(1)).getCOSObject();
    verify(pdResources, atLeast(1)).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem()
      throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDResources pdResources = mock(PDResources.class);
    doNothing().when(pdResources).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    when(pdResources.getCOSObject()).thenReturn(cosDictionary);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDictionary, atLeast(1)).setNeedToBeUpdated(true);
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources, atLeast(1)).getCOSObject();
    verify(pdResources, atLeast(1)).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm} {@link PDAcroForm#getCOSObject()} return {@link COSDictionary}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDAcroForm getCOSObject() return COSDictionary")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDAcroFormGetCOSObjectReturnCOSDictionary() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setNeedToBeUpdated(anyBoolean());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSDictionary cosDictionary3 = mock(COSDictionary.class);
    when(cosDictionary3.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getCOSObject()).thenReturn(cosDictionary3);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    doNothing().when(pdAcroForm).setDefaultAppearance(Mockito.<String>any());
    when(pdAcroForm.getCOSObject()).thenReturn(cosDictionary);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary2, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary3).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setNeedToBeUpdated(true);
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getCOSObject();
    verify(pdAcroForm).getCOSObject();
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).setDefaultAppearance("/Helv 0 Tf 0 g ");
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm} {@link PDAcroForm#getDefaultResources()} return {@link
   *       PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDAcroForm getDefaultResources() return PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDAcroFormGetDefaultResourcesReturnPDResources() {
    // Arrange
    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultAppearance is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultAppearance is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultResources is {@link PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultResources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentCatalog} {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   *       return {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDDocumentCatalog getAcroForm(PDDocumentFixup) return PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDDocumentCatalogGetAcroFormReturnPDAcroFormWithDocIsPDDocument() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any()))
        .thenReturn(new PDAcroForm(new PDDocument()));

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDResources#PDResources()} add {@link
   *       PDMMType1Font#PDMMType1Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDResources() add PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDResourcesAddPDMMType1FontWithFontDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange
    PDResources pdResources = new PDResources();
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDResources} {@link PDResources#getCOSObject()} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link PDResources#put(COSName, PDFont)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDResources getCOSObject() return COSDictionary(); then calls put(COSName, PDFont)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_givenPDResourcesGetCOSObjectReturnCOSDictionary_thenCallsPut()
      throws IOException {
    // Arrange
    PDResources pdResources = mock(PDResources.class);
    doNothing().when(pdResources).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    when(pdResources.getCOSObject()).thenReturn(new COSDictionary());
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources, atLeast(1)).getCOSObject();
    verify(pdResources, atLeast(1)).put(Mockito.<COSName>any(), Mockito.<PDFont>any());
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAcroForm#setDefaultAppearance(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); then calls setDefaultAppearance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_thenCallsSetDefaultAppearance() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    PDResources pdResources = mock(PDResources.class);
    when(pdResources.getCOSObject()).thenReturn(cosDictionary2);
    when(pdResources.add(Mockito.<PDFont>any())).thenReturn(COSName.A);
    pdResources.add(new PDMMType1Font(new COSDictionary()));

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    doNothing().when(pdAcroForm).setDefaultAppearance(Mockito.<String>any());
    when(pdAcroForm.getCOSObject()).thenReturn(new COSDictionary());
    when(pdAcroForm.getDefaultResources()).thenReturn(pdResources);
    when(pdAcroForm.getDefaultAppearance()).thenReturn("");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(cosDictionary, atLeast(1)).containsKey(Mockito.<COSName>any());
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdResources).add(isA(PDFont.class));
    verify(pdResources).getCOSObject();
    verify(pdAcroForm).getCOSObject();
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).setDefaultAppearance("/Helv 0 Tf 0 g ");
  }

  /**
   * Test {@link AcroFormDefaultsProcessor#process()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAcroForm#setDefaultResources(PDResources)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormDefaultsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); then calls setDefaultResources(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormDefaultsProcessor.process()"})
  void testProcess_thenCallsSetDefaultResources() {
    // Arrange
    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getCOSObject()).thenReturn(new COSDictionary());
    when(pdAcroForm.getDefaultResources()).thenReturn(null);
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    when(pdAcroForm.getDefaultAppearance()).thenReturn("Default Appearance");

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormDefaultsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdAcroForm).getCOSObject();
    verify(pdAcroForm).getDefaultAppearance();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
  }
}
