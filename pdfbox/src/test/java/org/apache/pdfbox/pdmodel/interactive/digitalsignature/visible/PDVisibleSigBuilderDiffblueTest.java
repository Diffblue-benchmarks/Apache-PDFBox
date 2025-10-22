package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVisibleSigBuilderDiffblueTest {
  /**
   * Test new {@link PDVisibleSigBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link PDVisibleSigBuilder}
   */
  @Test
  @DisplayName("Test new PDVisibleSigBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.<init>()"})
  void testNewPDVisibleSigBuilder() {
    // Arrange, Act and Assert
    PDFTemplateStructure structure = (new PDVisibleSigBuilder()).getStructure();
    assertNull(structure.getAffineTransform());
    assertNull(structure.getAcroFormFields());
    assertNull(structure.getProcSet());
    assertNull(structure.getAcroFormDictionary());
    assertNull(structure.getWidgetDictionary());
    assertNull(structure.getVisualSignature());
    assertNull(structure.getImageFormName());
    assertNull(structure.getImageName());
    assertNull(structure.getInnerFormName());
    assertNull(structure.getTemplate());
    assertNull(structure.getPage());
    assertNull(structure.getHolderFormResources());
    assertNull(structure.getImageFormResources());
    assertNull(structure.getInnerFormResources());
    assertNull(structure.getFormatterRectangle());
    assertNull(structure.getSignatureRectangle());
    assertNull(structure.getHolderFormStream());
    assertNull(structure.getImageFormStream());
    assertNull(structure.getInnerFormStream());
    assertNull(structure.getHolderForm());
    assertNull(structure.getImageForm());
    assertNull(structure.getInnerForm());
    assertNull(structure.getImage());
    assertNull(structure.getAppearanceDictionary());
    assertNull(structure.getPdSignature());
    assertNull(structure.getAcroForm());
    assertNull(structure.getSignatureField());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createTemplate(PDPage)}.
   * <ul>
   *   <li>Then {@link PDPage#PDPage()} COSObject toIncrement iterator next {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createTemplate(PDPage)}
   */
  @Test
  @DisplayName("Test createTemplate(PDPage); then PDPage() COSObject toIncrement iterator next COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createTemplate(PDPage)"})
  void testCreateTemplate_thenPDPageCOSObjectToIncrementIteratorNextCOSDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDPage page = new PDPage();

    // Act
    pdVisibleSigBuilder.createTemplate(page);

    // Assert
    Iterator<COSBase> iteratorResult = page.getCOSObject().toIncrement().iterator();
    COSBase nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof COSDictionary);
    assertTrue(iteratorResult.hasNext());
    assertTrue(((COSDictionary) nextResult).toIncrement().iterator().hasNext());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test createAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroForm(PDDocument)"})
  void testCreateAcroForm() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    doNothing().when(pdDocumentCatalog).setAcroForm(Mockito.<PDAcroForm>any());
    PDDocument template = mock(PDDocument.class);
    when(template.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(template).addPage(Mockito.<PDPage>any());
    template.addPage(new PDPage());

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    verify(template).addPage(isA(PDPage.class));
    verify(template).getDocumentCatalog();
    verify(pdDocumentCatalog).setAcroForm(isA(PDAcroForm.class));
    PDAcroForm acroForm = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("", acroForm.getDefaultAppearance());
    COSDictionary cOSObject = acroForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(acroForm.getDefaultResources());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(acroForm.getCalcOrder().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test createAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroForm(PDDocument)"})
  void testCreateAcroForm2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    pdVisibleSigBuilder.appendRawCommands(new ByteArrayOutputStream(1), "org.apache.logging.log4j.util.StackLocator");
    PDDocumentCatalog pdDocumentCatalog = mock(PDDocumentCatalog.class);
    doNothing().when(pdDocumentCatalog).setAcroForm(Mockito.<PDAcroForm>any());
    PDDocument template = mock(PDDocument.class);
    when(template.getDocumentCatalog()).thenReturn(pdDocumentCatalog);
    doNothing().when(template).addPage(Mockito.<PDPage>any());
    template.addPage(null);

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    verify(template).addPage(isNull());
    verify(template).getDocumentCatalog();
    verify(pdDocumentCatalog).setAcroForm(isA(PDAcroForm.class));
    PDAcroForm acroForm = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("", acroForm.getDefaultAppearance());
    COSDictionary cOSObject = acroForm.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(acroForm.getDefaultResources());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(acroForm.getCalcOrder().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test createAcroForm(PDDocument); when PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroForm(PDDocument)"})
  void testCreateAcroForm_whenPDDocument() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument template = new PDDocument();

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    PDAcroForm acroForm = template.getDocumentCatalog().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm2.getDefaultAppearance());
    assertNull(acroForm.getXFA());
    assertNull(acroForm.getScriptingHandler());
    assertEquals(0, acroForm.getQ());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getNeedAppearances());
    assertFalse(acroForm.isAppendOnly());
    assertFalse(acroForm.isCachingFields());
    assertFalse(acroForm.isSignaturesExist());
    List<PDField> calcOrder = acroForm.getCalcOrder();
    assertTrue(calcOrder.isEmpty());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(calcOrder, acroForm2.getCalcOrder());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test createAcroForm(PDDocument); when PDDocument() addPage PDPage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroForm(PDDocument)"})
  void testCreateAcroForm_whenPDDocumentAddPagePDPage() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    PDDocument template = new PDDocument();
    template.addPage(new PDPage());

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    PDAcroForm acroForm = template.getDocumentCatalog().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm2.getDefaultAppearance());
    assertNull(acroForm.getXFA());
    assertNull(acroForm.getScriptingHandler());
    assertEquals(0, acroForm.getQ());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getNeedAppearances());
    assertFalse(acroForm.isAppendOnly());
    assertFalse(acroForm.isCachingFields());
    assertFalse(acroForm.isSignaturesExist());
    List<PDField> calcOrder = acroForm.getCalcOrder();
    assertTrue(calcOrder.isEmpty());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(calcOrder, acroForm2.getCalcOrder());
  }

  /**
   * Test {@link PDVisibleSigBuilder#getStructure()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#getStructure()}
   */
  @Test
  @DisplayName("Test getStructure()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFTemplateStructure PDVisibleSigBuilder.getStructure()"})
  void testGetStructure() {
    // Arrange and Act
    PDFTemplateStructure actualStructure = (new PDVisibleSigBuilder()).getStructure();

    // Assert
    assertNull(actualStructure.getAffineTransform());
    assertNull(actualStructure.getAcroFormFields());
    assertNull(actualStructure.getProcSet());
    assertNull(actualStructure.getAcroFormDictionary());
    assertNull(actualStructure.getWidgetDictionary());
    assertNull(actualStructure.getVisualSignature());
    assertNull(actualStructure.getImageFormName());
    assertNull(actualStructure.getImageName());
    assertNull(actualStructure.getInnerFormName());
    assertNull(actualStructure.getTemplate());
    assertNull(actualStructure.getPage());
    assertNull(actualStructure.getHolderFormResources());
    assertNull(actualStructure.getImageFormResources());
    assertNull(actualStructure.getInnerFormResources());
    assertNull(actualStructure.getFormatterRectangle());
    assertNull(actualStructure.getSignatureRectangle());
    assertNull(actualStructure.getHolderFormStream());
    assertNull(actualStructure.getImageFormStream());
    assertNull(actualStructure.getInnerFormStream());
    assertNull(actualStructure.getHolderForm());
    assertNull(actualStructure.getImageForm());
    assertNull(actualStructure.getInnerForm());
    assertNull(actualStructure.getImage());
    assertNull(actualStructure.getAppearanceDictionary());
    assertNull(actualStructure.getPdSignature());
    assertNull(actualStructure.getAcroForm());
    assertNull(actualStructure.getSignatureField());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test createSignatureField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignatureField(PDAcroForm)"})
  void testCreateSignatureField() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    pdVisibleSigBuilder.createSignatureField(acroForm);

    // Assert
    PDSignatureField signatureField = pdVisibleSigBuilder.getStructure().getSignatureField();
    assertEquals("", signatureField.getValueAsString());
    assertEquals("Sig", signatureField.getFieldType());
    assertEquals("Signature1", signatureField.getFullyQualifiedName());
    assertEquals("Signature1", signatureField.getPartialName());
    assertNull(signatureField.getAlternateFieldName());
    assertNull(signatureField.getMappingName());
    assertNull(signatureField.getActions());
    assertNull(signatureField.getSeedValue());
    assertNull(signatureField.getDefaultValue());
    assertNull(signatureField.getSignature());
    assertNull(signatureField.getValue());
    assertNull(signatureField.getParent());
    assertEquals(0, signatureField.getFieldFlags());
    assertEquals(1, signatureField.getWidgets().size());
    assertFalse(signatureField.isNoExport());
    assertFalse(signatureField.isReadOnly());
    assertFalse(signatureField.isRequired());
    assertSame(acroForm, signatureField.getAcroForm());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test createSignatureField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignatureField(PDAcroForm)"})
  void testCreateSignatureField2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    pdVisibleSigBuilder.createSignatureField(acroForm);

    // Assert
    PDSignatureField signatureField = pdVisibleSigBuilder.getStructure().getSignatureField();
    assertEquals("", signatureField.getValueAsString());
    assertEquals("Sig", signatureField.getFieldType());
    assertEquals("Signature1", signatureField.getFullyQualifiedName());
    assertEquals("Signature1", signatureField.getPartialName());
    assertNull(signatureField.getAlternateFieldName());
    assertNull(signatureField.getMappingName());
    assertNull(signatureField.getActions());
    assertNull(signatureField.getSeedValue());
    assertNull(signatureField.getDefaultValue());
    assertNull(signatureField.getSignature());
    assertNull(signatureField.getValue());
    assertNull(signatureField.getParent());
    assertEquals(0, signatureField.getFieldFlags());
    assertEquals(1, signatureField.getWidgets().size());
    assertFalse(signatureField.isNoExport());
    assertFalse(signatureField.isReadOnly());
    assertFalse(signatureField.isRequired());
    assertSame(acroForm, signatureField.getAcroForm());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayList() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    float[][] values = widgets.get(0).getPage().getMatrix().getValues();
    assertEquals(3, values.length);
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationCaret()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationCaret() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCaret#PDAnnotationCaret(COSDictionary)} with field is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationCaret(COSDictionary) with field is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationCaretWithFieldIsCOSDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationCircle#PDAnnotationCircle()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationCircle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationCircle() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFileAttachment#PDAnnotationFileAttachment()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationFileAttachment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationFileAttachment() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationFreeText#PDAnnotationFreeText()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationFreeText()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationFreeText() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PDAnnotationHighlight#PDAnnotationHighlight()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList() add PDAnnotationHighlight()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_givenArrayListAddPDAnnotationHighlight() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Then {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Widgets size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); then PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Widgets size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_thenPDSignatureFieldWithAcroFormIsPDAcroFormWidgetsSizeIsOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, new PDPage(), "Signer Name");

    // Assert
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    float[][] values = widgets.get(0).getPage().getMatrix().getValues();
    assertEquals(3, values.length);
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure PdSignature Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); then PDVisibleSigBuilder (default constructor) Structure PdSignature Name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createSignature(PDSignatureField, PDPage, String)"})
  void testCreateSignature_thenPDVisibleSigBuilderStructurePdSignatureNameIsNull() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, new PDPage(), "");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertNull(pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertNull(value.getName());
    COSDictionary cOSObject = signature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertArrayEquals(new byte[]{}, pdSignature.getContents());
    assertArrayEquals(new byte[]{}, signature.getContents());
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, pdSignature.getByteRange());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroFormDictionary(PDAcroForm, PDSignatureField)"})
  void testCreateAcroFormDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDSignatureField signatureField = mock(PDSignatureField.class);
    when(signatureField.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(signatureField).getCOSObject();
    List<PDField> acroFormFields = pdVisibleSigBuilder.getStructure().getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(signatureField, acroFormFields.get(0));
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField); given COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroFormDictionary(PDAcroForm, PDSignatureField)"})
  void testCreateAcroFormDictionary_givenCOSDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDSignatureField signatureField = mock(PDSignatureField.class);
    when(signatureField.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    verify(signatureField).getCOSObject();
    List<PDField> acroFormFields = pdVisibleSigBuilder.getStructure().getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(signatureField, acroFormFields.get(0));
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroFormDictionary(PDAcroForm, PDSignatureField)"})
  void testCreateAcroFormDictionary_givenNull() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDSignatureField signatureField = mock(PDSignatureField.class);
    when(signatureField.getCOSObject()).thenReturn(null);

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    verify(signatureField).getCOSObject();
    List<PDField> acroFormFields = pdVisibleSigBuilder.getStructure().getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(signatureField, acroFormFields.get(0));
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <ul>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField); then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroFormDictionary(PDAcroForm, PDSignatureField)"})
  void testCreateAcroFormDictionary_thenCallsGetKey() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDSignatureField signatureField = mock(PDSignatureField.class);
    when(signatureField.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(signatureField).getCOSObject();
    List<PDField> acroFormFields = pdVisibleSigBuilder.getStructure().getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(signatureField, acroFormFields.get(0));
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAcroFormDictionary(PDAcroForm, PDSignatureField)"})
  void testCreateAcroFormDictionary_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);
    PDSignatureField signatureField = mock(PDSignatureField.class);
    when(signatureField.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(signatureField).getCOSObject();
    List<PDField> acroFormFields = pdVisibleSigBuilder.getStructure().getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertTrue(acroForm.getFields().isEmpty());
    assertSame(signatureField, acroFormFields.get(0));
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAffineTransform(AffineTransform)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAffineTransform(AffineTransform)}
   */
  @Test
  @DisplayName("Test createAffineTransform(AffineTransform)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAffineTransform(AffineTransform)"})
  void testCreateAffineTransform() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    AffineTransform affineTransform = new AffineTransform();

    // Act
    pdVisibleSigBuilder.createAffineTransform(affineTransform);

    // Assert
    assertSame(affineTransform, pdVisibleSigBuilder.getStructure().getAffineTransform());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createProcSetArray()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createProcSetArray()}
   */
  @Test
  @DisplayName("Test createProcSetArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createProcSetArray()"})
  void testCreateProcSetArray() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = new PDFormXObject(new COSStream());
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, new PDResources());

    // Act
    pdVisibleSigBuilder.createProcSetArray();

    // Assert
    List<? extends COSBase> toListResult = pdVisibleSigBuilder.getStructure().getProcSet().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(toListResult.get(1) instanceof COSName);
    assertTrue(toListResult.get(3) instanceof COSName);
    assertTrue(toListResult.get(4) instanceof COSName);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createProcSetArray()}.
   * <ul>
   *   <li>Given {@link PDVisibleSigBuilder} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createProcSetArray()}
   */
  @Test
  @DisplayName("Test createProcSetArray(); given PDVisibleSigBuilder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createProcSetArray()"})
  void testCreateProcSetArray_givenPDVisibleSigBuilder() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createProcSetArray();

    // Assert
    List<? extends COSBase> toListResult = pdVisibleSigBuilder.getStructure().getProcSet().toList();
    assertEquals(5, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(toListResult.get(1) instanceof COSName);
    assertTrue(toListResult.get(3) instanceof COSName);
    assertTrue(toListResult.get(4) instanceof COSName);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createFormatterRectangle(int[])}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createFormatterRectangle(int[])}
   */
  @Test
  @DisplayName("Test createFormatterRectangle(int[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createFormatterRectangle(int[])"})
  void testCreateFormatterRectangle() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createFormatterRectangle(new int[]{1000, 1, 1000, 1});

    // Assert
    PDRectangle formatterRectangle = pdVisibleSigBuilder.getStructure().getFormatterRectangle();
    COSArray cOSArray = formatterRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertEquals(0.0f, formatterRectangle.getHeight());
    assertEquals(0.0f, formatterRectangle.getWidth());
    assertEquals(1.0f, formatterRectangle.getLowerLeftY());
    assertEquals(1.0f, formatterRectangle.getUpperRightY());
    assertEquals(1000.0f, formatterRectangle.getLowerLeftX());
    assertEquals(1000.0f, formatterRectangle.getUpperRightX());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, formatterRectangle.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createHolderFormStream(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createHolderFormStream(PDDocument)"})
  void testCreateHolderFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createHolderFormStream(new PDDocument());

    // Assert
    PDStream holderFormStream = pdVisibleSigBuilder.getStructure().getHolderFormStream();
    assertNull(holderFormStream.getDecodeParms());
    assertNull(holderFormStream.getFileDecodeParams());
    assertNull(holderFormStream.getMetadata());
    assertNull(holderFormStream.getFile());
    assertEquals(-1, holderFormStream.getDecodedStreamLength());
    assertEquals(0, holderFormStream.getLength());
    List<String> fileFilters = holderFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, holderFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderFormResources()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderFormResources()}
   */
  @Test
  @DisplayName("Test createHolderFormResources()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createHolderFormResources()"})
  void testCreateHolderFormResources() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createHolderFormResources();

    // Assert
    PDResources holderFormResources = pdVisibleSigBuilder.getStructure().getHolderFormResources();
    Iterable<COSName> colorSpaceNames = holderFormResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(holderFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, holderFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, holderFormResources.getFontNames());
    assertSame(colorSpaceNames, holderFormResources.getPatternNames());
    assertSame(colorSpaceNames, holderFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, holderFormResources.getShadingNames());
    assertSame(colorSpaceNames, holderFormResources.getXObjectNames());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createHolderForm(PDResources, PDStream, PDRectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createHolderForm(PDResources, PDStream, PDRectangle)"})
  void testCreateHolderForm() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources holderFormResources = new PDResources();
    PDStream holderFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createHolderForm(holderFormResources, holderFormStream, PDRectangle.A0);

    // Assert
    float[][] values = pdVisibleSigBuilder.getStructure().getHolderForm().getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = holderFormStream.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure HolderForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createHolderForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure HolderForm BBox is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createHolderForm(PDResources, PDStream, PDRectangle)"})
  void testCreateHolderForm_thenPDVisibleSigBuilderStructureHolderFormBBoxIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.createHolderForm(holderFormResources, new PDStream(new COSDocument()), null);

    // Assert
    PDFormXObject holderForm = pdVisibleSigBuilder.getStructure().getHolderForm();
    assertNull(holderForm.getBBox());
    float[][] values = holderForm.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure HolderForm Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createHolderForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure HolderForm Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createHolderForm(PDResources, PDStream, PDRectangle)"})
  void testCreateHolderForm_thenPDVisibleSigBuilderStructureHolderFormResourcesIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createHolderForm(null, new PDStream(new COSDocument()), PDRectangle.A0);

    // Assert
    PDFormXObject holderForm = pdVisibleSigBuilder.getStructure().getHolderForm();
    assertNull(holderForm.getResources());
    float[][] values = holderForm.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAppearanceDictionary(PDFormXObject, PDSignatureField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAppearanceDictionary(PDFormXObject, PDSignatureField)"})
  void testCreateAppearanceDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject holderForml = new PDFormXObject(new COSStream());
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createAppearanceDictionary(holderForml, signatureField);

    // Assert
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAppearanceDictionary(PDFormXObject, PDSignatureField); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createAppearanceDictionary(PDFormXObject, PDSignatureField)"})
  void testCreateAppearanceDictionary_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDFormXObject holderForml = new PDFormXObject(stream);
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createAppearanceDictionary(holderForml, signatureField);

    // Assert
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createInnerFormStream(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createInnerFormStream(PDDocument)"})
  void testCreateInnerFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createInnerFormStream(new PDDocument());

    // Assert
    PDStream innerFormStream = pdVisibleSigBuilder.getStructure().getInnerFormStream();
    assertNull(innerFormStream.getDecodeParms());
    assertNull(innerFormStream.getFileDecodeParams());
    assertNull(innerFormStream.getMetadata());
    assertNull(innerFormStream.getFile());
    assertEquals(-1, innerFormStream.getDecodedStreamLength());
    assertEquals(0, innerFormStream.getLength());
    List<String> fileFilters = innerFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, innerFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerFormResource()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerFormResource()}
   */
  @Test
  @DisplayName("Test createInnerFormResource()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createInnerFormResource()"})
  void testCreateInnerFormResource() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createInnerFormResource();

    // Assert
    PDResources innerFormResources = pdVisibleSigBuilder.getStructure().getInnerFormResources();
    Iterable<COSName> colorSpaceNames = innerFormResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(innerFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, innerFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, innerFormResources.getFontNames());
    assertSame(colorSpaceNames, innerFormResources.getPatternNames());
    assertSame(colorSpaceNames, innerFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, innerFormResources.getShadingNames());
    assertSame(colorSpaceNames, innerFormResources.getXObjectNames());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createInnerForm(PDResources, PDStream, PDRectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createInnerForm(PDResources, PDStream, PDRectangle)"})
  void testCreateInnerForm() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources innerFormResources = new PDResources();
    PDStream innerFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createInnerForm(innerFormResources, innerFormStream, PDRectangle.A0);

    // Assert
    float[][] values = pdVisibleSigBuilder.getStructure().getInnerForm().getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = innerFormStream.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure InnerForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createInnerForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure InnerForm BBox is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createInnerForm(PDResources, PDStream, PDRectangle)"})
  void testCreateInnerForm_thenPDVisibleSigBuilderStructureInnerFormBBoxIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources innerFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.createInnerForm(innerFormResources, new PDStream(new COSDocument()), null);

    // Assert
    PDFormXObject innerForm = pdVisibleSigBuilder.getStructure().getInnerForm();
    assertNull(innerForm.getBBox());
    float[][] values = innerForm.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure InnerForm Resources is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createInnerForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure InnerForm Resources is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createInnerForm(PDResources, PDStream, PDRectangle)"})
  void testCreateInnerForm_thenPDVisibleSigBuilderStructureInnerFormResourcesIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createInnerForm(null, new PDStream(new COSDocument()), PDRectangle.A0);

    // Assert
    PDFormXObject innerForm = pdVisibleSigBuilder.getStructure().getInnerForm();
    assertNull(innerForm.getResources());
    float[][] values = innerForm.getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.insertInnerFormToHolderResources(PDFormXObject, PDResources)"})
  void testInsertInnerFormToHolderResources_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDFormXObject innerForm = new PDFormXObject(stream);
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); given 'true'; when COSStream() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.insertInnerFormToHolderResources(PDFormXObject, PDResources)"})
  void testInsertInnerFormToHolderResources_givenTrue_whenCOSStreamDirectIsTrue() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    COSStream stream = new COSStream();
    stream.setDirect(true);
    PDFormXObject innerForm = new PDFormXObject(stream);
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); then PDResources() XObjectNames size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.insertInnerFormToHolderResources(PDFormXObject, PDResources)"})
  void testInsertInnerFormToHolderResources_thenPDResourcesXObjectNamesSizeIsOne() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = new PDFormXObject(new COSStream());
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); then PDResources() XObjectNames size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.insertInnerFormToHolderResources(PDFormXObject, PDResources)"})
  void testInsertInnerFormToHolderResources_thenPDResourcesXObjectNamesSizeIsTwo() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = new PDFormXObject(new COSStream());

    PDResources holderFormResources = new PDResources();
    holderFormResources.add(new PDImageXObject(new PDDocument()));

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createImageFormStream(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createImageFormStream(PDDocument)"})
  void testCreateImageFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createImageFormStream(new PDDocument());

    // Assert
    PDStream imageFormStream = pdVisibleSigBuilder.getStructure().getImageFormStream();
    assertNull(imageFormStream.getDecodeParms());
    assertNull(imageFormStream.getFileDecodeParams());
    assertNull(imageFormStream.getMetadata());
    assertNull(imageFormStream.getFile());
    assertEquals(-1, imageFormStream.getDecodedStreamLength());
    assertEquals(0, imageFormStream.getLength());
    List<String> fileFilters = imageFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, imageFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageFormResources()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createImageFormResources()}
   */
  @Test
  @DisplayName("Test createImageFormResources()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createImageFormResources()"})
  void testCreateImageFormResources() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createImageFormResources();

    // Assert
    PDResources imageFormResources = pdVisibleSigBuilder.getStructure().getImageFormResources();
    Iterable<COSName> colorSpaceNames = imageFormResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = imageFormResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(imageFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, imageFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, imageFormResources.getFontNames());
    assertSame(colorSpaceNames, imageFormResources.getPatternNames());
    assertSame(colorSpaceNames, imageFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, imageFormResources.getShadingNames());
    assertSame(colorSpaceNames, imageFormResources.getXObjectNames());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure ImageName Name is {@code img2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}
   */
  @Test
  @DisplayName("Test createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject); then PDVisibleSigBuilder (default constructor) Structure ImageName Name is 'img2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)"})
  void testCreateImageForm_thenPDVisibleSigBuilderStructureImageNameNameIsImg2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    PDResources imageFormResources = new PDResources();
    imageFormResources.add(new PDImageXObject(new PDDocument()));
    PDResources innerFormResource = new PDResources();
    PDStream imageFormStream = new PDStream(new COSDocument());
    AffineTransform at = new AffineTransform();

    // Act
    pdVisibleSigBuilder.createImageForm(imageFormResources, innerFormResource, imageFormStream, PDRectangle.A0, at,
        new PDImageXObject(new PDDocument()));

    // Assert
    Iterable<COSName> xObjectNames = imageFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    PDFTemplateStructure structure = pdVisibleSigBuilder.getStructure();
    assertEquals("img2", structure.getImageName().getName());
    COSDictionary cOSObject = imageFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    float[][] values = structure.getImageForm().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure ImageForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}
   */
  @Test
  @DisplayName("Test createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject); when 'null'; then PDVisibleSigBuilder (default constructor) Structure ImageForm BBox is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)"})
  void testCreateImageForm_whenNull_thenPDVisibleSigBuilderStructureImageFormBBoxIsNull() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources imageFormResources = new PDResources();
    PDResources innerFormResource = new PDResources();
    PDStream imageFormStream = new PDStream(new COSDocument());
    AffineTransform at = new AffineTransform();

    // Act
    pdVisibleSigBuilder.createImageForm(imageFormResources, innerFormResource, imageFormStream, null, at,
        new PDImageXObject(new PDDocument()));

    // Assert
    PDFormXObject imageForm = pdVisibleSigBuilder.getStructure().getImageForm();
    assertNull(imageForm.getBBox());
    float[][] values = imageForm.getMatrix().getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = imageFormStream.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDVisibleSigBuilder#createBackgroundLayerForm(PDResources, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject toIncrement Objects Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createBackgroundLayerForm(PDResources, PDRectangle)}
   */
  @Test
  @DisplayName("Test createBackgroundLayerForm(PDResources, PDRectangle); then PDResources() COSObject toIncrement Objects Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createBackgroundLayerForm(PDResources, PDRectangle)"})
  void testCreateBackgroundLayerForm_thenPDResourcesCOSObjectToIncrementObjectsEmpty() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    pdVisibleSigBuilder.createTemplate(new PDPage());
    PDResources innerFormResource = new PDResources();

    // Act
    pdVisibleSigBuilder.createBackgroundLayerForm(innerFormResource, null);

    // Assert
    Iterable<COSName> xObjectNames = innerFormResource.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = innerFormResource.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with updateInfo is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_givenCOSUpdateStateWithUpdateInfoIsCOSArray() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();
    PDResources holderFormResources = new PDResources();
    COSArray procSet = mock(COSArray.class);
    when(procSet.isDirect()).thenReturn(true);
    when(procSet.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, holderFormResources,
        procSet);

    // Assert
    verify(procSet, atLeast(1)).getUpdateState();
    verify(procSet, atLeast(1)).isDirect();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); given 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_givenFalse_thenCallsGetKey() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();
    PDResources holderFormResources = new PDResources();
    COSArray procSet = mock(COSArray.class);
    when(procSet.isDirect()).thenReturn(false);
    when(procSet.getKey()).thenReturn(new COSObjectKey(1L, 1));

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, holderFormResources,
        procSet);

    // Assert
    verify(procSet, atLeast(1)).getKey();
    verify(procSet, atLeast(1)).isDirect();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_thenCallsSetItem() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, holderFormResources,
        new COSArray());

    // Assert
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_thenCallsSetOriginDocumentState() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();
    PDResources holderFormResources = new PDResources();
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray procSet = mock(COSArray.class);
    when(procSet.isDirect()).thenReturn(true);
    when(procSet.getUpdateState()).thenReturn(cosUpdateState);

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, holderFormResources,
        procSet);

    // Assert
    verify(procSet, atLeast(1)).getUpdateState();
    verify(procSet, atLeast(1)).isDirect();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosUpdateState, atLeast(1)).setOriginDocumentState(isNull());
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); when 'null'; then PDResources() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_whenNull_thenPDResourcesCOSObjectSizeIsZero() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, new PDResources(),
        null);

    // Assert that nothing has changed
    verify(cosDictionary).setItem(isA(COSName.class), (COSBase) isNull());
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>When {@link PDPage} {@link PDPage#getCOSObject()} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); when PDPage getCOSObject() return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDVisibleSigBuilder.injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)"})
  void testInjectProcSetArray_whenPDPageGetCOSObjectReturnCOSDictionary() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = mock(PDFormXObject.class);
    when(innerForm.getResources()).thenReturn(new PDResources());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(new COSDictionary());
    PDResources innerFormResources = new PDResources();
    PDResources imageFormResources = new PDResources();
    PDResources holderFormResources = new PDResources();

    // Act
    pdVisibleSigBuilder.injectProcSetArray(innerForm, page, innerFormResources, imageFormResources, holderFormResources,
        new COSArray());

    // Assert
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#appendRawCommands(OutputStream, String)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#appendRawCommands(OutputStream, String)}
   */
  @Test
  @DisplayName("Test appendRawCommands(OutputStream, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.appendRawCommands(OutputStream, String)"})
  void testAppendRawCommands() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    pdVisibleSigBuilder.appendRawCommands(os, "Commands");

    // Assert
    byte[] expectedToByteArrayResult = "Commands".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, os.toByteArray());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createVisualSignature(PDDocument)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createVisualSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test createVisualSignature(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createVisualSignature(PDDocument)"})
  void testCreateVisualSignature() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument template = mock(PDDocument.class);
    COSDocument cosDocument = new COSDocument();
    when(template.getDocument()).thenReturn(cosDocument);

    // Act
    pdVisibleSigBuilder.createVisualSignature(template);

    // Assert
    verify(template).getDocument();
    assertSame(cosDocument, pdVisibleSigBuilder.getStructure().getVisualSignature());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
  @DisplayName("Test createWidgetDictionary(PDSignatureField, PDResources)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createWidgetDictionary(PDSignatureField, PDResources)"})
  void testCreateWidgetDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createWidgetDictionary(signatureField, new PDResources());

    // Assert
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertSame(cOSObject, pdVisibleSigBuilder.getStructure().getWidgetDictionary());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link PDResources#PDResources()} {@link COSName#A} is {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
  @DisplayName("Test createWidgetDictionary(PDSignatureField, PDResources); given A; when PDResources() A is PDExtendedGraphicsState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDVisibleSigBuilder.createWidgetDictionary(PDSignatureField, PDResources)"})
  void testCreateWidgetDictionary_givenA_whenPDResourcesAIsPDExtendedGraphicsState() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    PDResources holderFormResources = new PDResources();
    holderFormResources.put(COSName.A, new PDExtendedGraphicsState());
    holderFormResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdVisibleSigBuilder.createWidgetDictionary(signatureField, holderFormResources);

    // Assert
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertSame(cOSObject, pdVisibleSigBuilder.getStructure().getWidgetDictionary());
  }
}
