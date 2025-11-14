package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fixup.PDDocumentFixup;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AcroFormOrphanWidgetsProcessorDiffblueTest {
  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    PDAcroForm pdAcroForm = new PDAcroForm(doc, new COSDictionary());
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.
   *   <li>Then calls {@link PDPage#getAnnotations()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given ArrayList() add PDAnnotationCaret(); then calls getAnnotations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenArrayListAddPDAnnotationCaret_thenCallsGetAnnotations() throws IOException {
    // Arrange
    PDFieldTree pdFieldTree = mock(PDFieldTree.class);

    ArrayList<PDField> pdFieldList = new ArrayList<>();
    when(pdFieldTree.iterator()).thenReturn(pdFieldList.iterator());

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(pdFieldTree);
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    ArrayList<PDAnnotation> pdAnnotationList = new ArrayList<>();
    pdAnnotationList.add(new PDAnnotationCaret());

    PDPage pdPage = mock(PDPage.class);
    when(pdPage.getAnnotations()).thenReturn(pdAnnotationList);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(pdPage);

    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
    verify(pdFieldTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDCheckBox#PDCheckBox(PDAcroForm)} with
   *       acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given ArrayList() add PDCheckBox(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenArrayListAddPDCheckBoxWithAcroFormIsPDAcroForm() {
    // Arrange
    ArrayList<PDField> pdFieldList = new ArrayList<>();
    pdFieldList.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getFields()).thenReturn(pdFieldList);

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(new PDFieldTree(acroForm));
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(acroForm).getFields();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDPage#PDPage()}.
   *   <li>Then calls {@link PDFieldTree#iterator()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given ArrayList() add PDPage(); then calls iterator()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenArrayListAddPDPage_thenCallsIterator() {
    // Arrange
    PDFieldTree pdFieldTree = mock(PDFieldTree.class);

    ArrayList<PDField> pdFieldList = new ArrayList<>();
    when(pdFieldTree.iterator()).thenReturn(pdFieldList.iterator());

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(pdFieldTree);
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(new PDPage());

    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
    verify(pdFieldTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm} {@link PDAcroForm#getFieldTree()} return {@link
   *       PDFieldTree#PDFieldTree(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDAcroForm getFieldTree() return PDFieldTree(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDAcroFormGetFieldTreeReturnPDFieldTreeWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(new PDFieldTree(new PDAcroForm(new PDDocument())));
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm} {@link PDAcroForm#getFields()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link PDAcroForm#getFields()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDAcroForm getFields() return ArrayList(); then calls getFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDAcroFormGetFieldsReturnArrayList_thenCallsGetFields() {
    // Arrange
    PDAcroForm acroForm = mock(PDAcroForm.class);
    when(acroForm.getFields()).thenReturn(new ArrayList<>());

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(new PDFieldTree(acroForm));
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(acroForm).getFields();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()} DefaultResources is {@link PDResources#PDResources()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDAcroForm(PDDocument) with doc is PDDocument() DefaultResources is PDResources()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDAcroFormWithDocIsPDDocumentDefaultResourcesIsPDResources() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentCatalog} {@link PDDocumentCatalog#getAcroForm(PDDocumentFixup)}
   *       return {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDDocumentCatalog getAcroForm(PDDocumentFixup) return PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
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
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree(COSDictionary)} with root is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDDocumentGetPagesReturnPDPageTreeWithRootIsCOSDictionary() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree(new COSDictionary()));
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return {@link
   *       PDPageTree#PDPageTree()}.
   *   <li>Then calls {@link PDDocument#getPages()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDDocument getPages() return PDPageTree(); then calls getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDDocumentGetPagesReturnPDPageTree_thenCallsGetPages() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDPage} {@link PDPage#getAnnotations()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then calls {@link PDPage#getAnnotations()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDPage getAnnotations() return ArrayList(); then calls getAnnotations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDPageGetAnnotationsReturnArrayList_thenCallsGetAnnotations()
      throws IOException {
    // Arrange
    PDFieldTree pdFieldTree = mock(PDFieldTree.class);

    ArrayList<PDField> pdFieldList = new ArrayList<>();
    when(pdFieldTree.iterator()).thenReturn(pdFieldList.iterator());

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(pdFieldTree);
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPage pdPage = mock(PDPage.class);
    when(pdPage.getAnnotations()).thenReturn(new ArrayList<>());

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(pdPage);

    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
    verify(pdFieldTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDPage} {@link PDPage#getAnnotations()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link PDPage#getAnnotations()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName(
      "Test process(); given PDPage getAnnotations() throw IOException(); then calls getAnnotations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDPageGetAnnotationsThrowIOException_thenCallsGetAnnotations()
      throws IOException {
    // Arrange
    PDFieldTree pdFieldTree = mock(PDFieldTree.class);

    ArrayList<PDField> pdFieldList = new ArrayList<>();
    when(pdFieldTree.iterator()).thenReturn(pdFieldList.iterator());

    PDAcroForm pdAcroForm = mock(PDAcroForm.class);
    when(pdAcroForm.getFieldTree()).thenReturn(pdFieldTree);
    doNothing().when(pdAcroForm).setFields(Mockito.<List<PDField>>any());
    when(pdAcroForm.getDefaultResources()).thenReturn(new PDResources());
    doNothing().when(pdAcroForm).setDefaultResources(Mockito.<PDResources>any());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPage pdPage = mock(PDPage.class);
    when(pdPage.getAnnotations()).thenThrow(new IOException());

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(pdPage);

    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    doNothing().when(pdPageTree).add(Mockito.<PDPage>any());
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).add(isA(PDPage.class));
    verify(pdPageTree).iterator();
    verify(pdAcroForm).getDefaultResources();
    verify(pdAcroForm).getFieldTree();
    verify(pdAcroForm).setDefaultResources(isA(PDResources.class));
    verify(pdAcroForm).setFields(isA(List.class));
    verify(pdFieldTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.
   *   <li>Then calls {@link PDDocument#getPages()}.
   * </ul>
   *
   * <p>Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDPageTree() add PDPage(); then calls getPages()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AcroFormOrphanWidgetsProcessor.process()"})
  void testProcess_givenPDPageTreeAddPDPage_thenCallsGetPages() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());

    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    new AcroFormOrphanWidgetsProcessor(document).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }
}
