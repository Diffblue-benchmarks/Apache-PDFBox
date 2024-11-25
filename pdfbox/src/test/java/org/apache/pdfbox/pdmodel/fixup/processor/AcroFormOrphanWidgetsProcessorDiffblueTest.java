package org.apache.pdfbox.pdmodel.fixup.processor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AcroFormOrphanWidgetsProcessorDiffblueTest {
  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process()")
  void testProcess() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    PDDocument doc = new PDDocument();
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any()))
        .thenReturn(new PDAcroForm(doc, new COSDictionary()));
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert that nothing has changed
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process()")
  void testProcess2() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPage pdPage = mock(PDPage.class);
    when(pdPage.getAnnotations()).thenThrow(new IOException("rebuilding fields from widgets"));

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(pdPage);
    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   *   <li>Then calls {@link PDPage#getAnnotations()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given ArrayList() add PDAnnotationCaret(); then calls getAnnotations()")
  void testProcess_givenArrayListAddPDAnnotationCaret_thenCallsGetAnnotations() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
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
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDPage#PDPage()}.</li>
   *   <li>Then calls {@link PDPageTree#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given ArrayList() add PDPage(); then calls iterator()")
  void testProcess_givenArrayListAddPDPage_thenCallsIterator() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(new PDPage());
    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return
   * {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDDocument getPages() return PDPageTree(COSDictionary) with root is COSDictionary()")
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
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDDocument} {@link PDDocument#getPages()} return
   * {@link PDPageTree#PDPageTree()}.</li>
   *   <li>Then calls {@link PDDocument#getPages()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDDocument getPages() return PDPageTree(); then calls getPages()")
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
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDPage} {@link PDPage#getAnnotations()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PDPage#getAnnotations()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDPage getAnnotations() return ArrayList(); then calls getAnnotations()")
  void testProcess_givenPDPageGetAnnotationsReturnArrayList_thenCallsGetAnnotations() throws IOException {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPage pdPage = mock(PDPage.class);
    when(pdPage.getAnnotations()).thenReturn(new ArrayList<>());

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    pdPageList.add(pdPage);
    PDPageTree pdPageTree = mock(PDPageTree.class);
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPage).getAnnotations();
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.</li>
   *   <li>Then calls {@link PDDocument#getPages()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDPageTree() add PDPage(); then calls getPages()")
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
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Given {@link PDPageTree} {@link PDPageTree#iterator()} return
   * {@link ArrayList#ArrayList()} iterator.</li>
   *   <li>Then calls {@link PDPageTree#iterator()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); given PDPageTree iterator() return ArrayList() iterator; then calls iterator()")
  void testProcess_givenPDPageTreeIteratorReturnArrayListIterator_thenCallsIterator() {
    // Arrange
    PDAcroForm pdAcroForm = new PDAcroForm(new PDDocument());
    pdAcroForm.setDefaultResources(new PDResources());
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(pdAcroForm);
    PDPageTree pdPageTree = mock(PDPageTree.class);

    ArrayList<PDPage> pdPageList = new ArrayList<>();
    when(pdPageTree.iterator()).thenReturn(pdPageList.iterator());
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(pdPageTree);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(document).getPages();
    verify(pdDocumentCatalog).getAcroForm(isNull());
    verify(pdPageTree).iterator();
  }

  /**
   * Test {@link AcroFormOrphanWidgetsProcessor#process()}.
   * <ul>
   *   <li>Then calls {@link PDDocument#addPage(PDPage)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AcroFormOrphanWidgetsProcessor#process()}
   */
  @Test
  @DisplayName("Test process(); then calls addPage(PDPage)")
  void testProcess_thenCallsAddPage() {
    // Arrange
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    when(pdDocumentCatalog.getAcroForm(Mockito.<PDDocumentFixup>any())).thenReturn(new PDAcroForm(new PDDocument()));
    PDDocument document = mock(PDDocument.class);
    when(document.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(document).addPage(Mockito.<PDPage>any());
    document.addPage(new PDPage());

    // Act
    (new AcroFormOrphanWidgetsProcessor(document)).process();

    // Assert that nothing has changed
    verify(document).addPage(isA(PDPage.class));
    verify(document).getDocumentCatalog();
    verify(pdDocumentCatalog).getAcroForm(isNull());
  }
}
