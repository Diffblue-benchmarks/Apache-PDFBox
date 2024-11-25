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
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
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
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDShadingPattern;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationUnknown;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVisibleSigBuilderDiffblueTest {
  /**
   * Test new {@link PDVisibleSigBuilder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link PDVisibleSigBuilder}
   */
  @Test
  @DisplayName("Test new PDVisibleSigBuilder (default constructor)")
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
   *   <li>Then {@link PDPage#PDPage()} COSObject toIncrement iterator next
   * {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createTemplate(PDPage)}
   */
  @Test
  @DisplayName("Test createTemplate(PDPage); then PDPage() COSObject toIncrement iterator next COSDictionary")
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
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  @DisplayName("Test createAcroForm(PDDocument); given PDPage(); when PDDocument() addPage PDPage()")
  void testCreateAcroForm_givenPDPage_whenPDDocumentAddPagePDPage() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    PDDocument template = new PDDocument();
    template.addPage(new PDPage());

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    PDDocumentCatalog documentCatalog = template.getDocumentCatalog();
    assertTrue(documentCatalog.getCOSObject().toIncrement().iterator().hasNext());
    PDAcroForm acroForm = documentCatalog.getAcroForm();
    PDResources defaultResources = acroForm.getDefaultResources();
    COSDictionary cOSObject = defaultResources.getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    assertTrue(iteratorResult.hasNext());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    assertTrue(iteratorResult2.hasNext());
    assertSame(cOSObject, iteratorResult.next());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    PDResources defaultResources2 = acroForm2.getDefaultResources();
    assertSame(cOSObject, defaultResources2.getCOSObject());
    Iterable<COSName> colorSpaceNames = defaultResources.getColorSpaceNames();
    assertSame(colorSpaceNames, defaultResources2.getColorSpaceNames());
    assertSame(colorSpaceNames, defaultResources.getExtGStateNames());
    assertSame(colorSpaceNames, defaultResources2.getExtGStateNames());
    assertSame(colorSpaceNames, defaultResources.getPatternNames());
    assertSame(colorSpaceNames, defaultResources2.getPatternNames());
    assertSame(colorSpaceNames, defaultResources.getPropertiesNames());
    assertSame(colorSpaceNames, defaultResources2.getPropertiesNames());
    assertSame(colorSpaceNames, defaultResources.getShadingNames());
    assertSame(colorSpaceNames, defaultResources2.getShadingNames());
    assertSame(colorSpaceNames, defaultResources.getXObjectNames());
    assertSame(colorSpaceNames, defaultResources2.getXObjectNames());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, acroForm2.getCOSObject());
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
  void testCreateAcroForm_whenPDDocument() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument template = new PDDocument();

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    PDDocumentCatalog documentCatalog = template.getDocumentCatalog();
    assertTrue(documentCatalog.getCOSObject().toIncrement().iterator().hasNext());
    PDAcroForm acroForm = documentCatalog.getAcroForm();
    PDResources defaultResources = acroForm.getDefaultResources();
    COSDictionary cOSObject = defaultResources.getCOSObject();
    Iterator<COSBase> iteratorResult = cOSObject.toIncrement().iterator();
    assertTrue(iteratorResult.hasNext());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    Iterator<COSBase> iteratorResult2 = cOSObject2.toIncrement().iterator();
    assertTrue(iteratorResult2.hasNext());
    assertSame(cOSObject, iteratorResult.next());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    PDResources defaultResources2 = acroForm2.getDefaultResources();
    assertSame(cOSObject, defaultResources2.getCOSObject());
    Iterable<COSName> colorSpaceNames = defaultResources.getColorSpaceNames();
    assertSame(colorSpaceNames, defaultResources2.getColorSpaceNames());
    assertSame(colorSpaceNames, defaultResources.getExtGStateNames());
    assertSame(colorSpaceNames, defaultResources2.getExtGStateNames());
    assertSame(colorSpaceNames, defaultResources.getPatternNames());
    assertSame(colorSpaceNames, defaultResources2.getPatternNames());
    assertSame(colorSpaceNames, defaultResources.getPropertiesNames());
    assertSame(colorSpaceNames, defaultResources2.getPropertiesNames());
    assertSame(colorSpaceNames, defaultResources.getShadingNames());
    assertSame(colorSpaceNames, defaultResources2.getShadingNames());
    assertSame(colorSpaceNames, defaultResources.getXObjectNames());
    assertSame(colorSpaceNames, defaultResources2.getXObjectNames());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, acroForm2.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#getStructure()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#getStructure()}
   */
  @Test
  @DisplayName("Test getStructure()")
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test createSignatureField(PDAcroForm)")
  void testCreateSignatureField() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    pdVisibleSigBuilder.createSignatureField(acroForm);

    // Assert
    PDSignatureField signatureField = pdVisibleSigBuilder.getStructure().getSignatureField();
    List<PDAnnotationWidget> widgets = signatureField.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", signatureField.getValueAsString());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Sig", signatureField.getFieldType());
    assertEquals("Signature1", signatureField.getFullyQualifiedName());
    assertEquals("Signature1", signatureField.getPartialName());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(signatureField.getAlternateFieldName());
    assertNull(signatureField.getMappingName());
    COSDictionary cOSObject = signatureField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getAppearanceState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getOptionalContent());
    assertNull(getResult.getColor());
    assertNull(getResult.getAction());
    assertNull(getResult.getActions());
    assertNull(signatureField.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(signatureField.getSeedValue());
    assertNull(signatureField.getDefaultValue());
    assertNull(signatureField.getSignature());
    assertNull(signatureField.getValue());
    assertNull(signatureField.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, signatureField.getFieldFlags());
    assertEquals(132, getResult.getAnnotationFlags());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(signatureField.isNoExport());
    assertFalse(signatureField.isReadOnly());
    assertFalse(signatureField.isRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(getResult.isLocked());
    assertTrue(getResult.isPrinted());
    assertSame(acroForm, signatureField.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test createSignatureField(PDAcroForm)")
  void testCreateSignatureField2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument doc = new PDDocument();
    PDAcroForm acroForm = new PDAcroForm(doc, new COSDictionary());

    // Act
    pdVisibleSigBuilder.createSignatureField(acroForm);

    // Assert
    PDSignatureField signatureField = pdVisibleSigBuilder.getStructure().getSignatureField();
    List<PDAnnotationWidget> widgets = signatureField.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", signatureField.getValueAsString());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Sig", signatureField.getFieldType());
    assertEquals("Signature1", signatureField.getFullyQualifiedName());
    assertEquals("Signature1", signatureField.getPartialName());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(signatureField.getAlternateFieldName());
    assertNull(signatureField.getMappingName());
    COSDictionary cOSObject = signatureField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getAppearanceState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getOptionalContent());
    assertNull(getResult.getColor());
    assertNull(getResult.getAction());
    assertNull(getResult.getActions());
    assertNull(signatureField.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(signatureField.getSeedValue());
    assertNull(signatureField.getDefaultValue());
    assertNull(signatureField.getSignature());
    assertNull(signatureField.getValue());
    assertNull(signatureField.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, signatureField.getFieldFlags());
    assertEquals(132, getResult.getAnnotationFlags());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(signatureField.isNoExport());
    assertFalse(signatureField.isReadOnly());
    assertFalse(signatureField.isRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(getResult.isLocked());
    assertTrue(getResult.isPrinted());
    assertSame(acroForm, signatureField.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));
    PDPage page = new PDPage(new COSDictionary());

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations = page.getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(page, getResult.getPage());
    assertEquals(page, widgets.get(0).getPage());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret();
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationCaret);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationCaret);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationCaret);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationCaret);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationCaret, getResult2);
    assertEquals(pdAnnotationCaret, getResult4);
    assertEquals(pdAnnotationCaret, getResult6);
    assertEquals(pdAnnotationCaret, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature3() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    COSDictionary pageDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    pageDictionary.setKey(key);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, new PDPage(pageDictionary), "Signer Name");

    // Assert
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    COSDictionary cOSObject = widgets.get(0).getPage().getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(key, cOSObject.getKey());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature4() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCaret pdAnnotationCaret = new PDAnnotationCaret(new COSDictionary());
    annotations.add(pdAnnotationCaret);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationUnknown);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationUnknown);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationUnknown);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationUnknown);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationCaret, getResult2);
    assertEquals(pdAnnotationCaret, getResult4);
    assertEquals(pdAnnotationCaret, getResult6);
    assertEquals(pdAnnotationCaret, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature5() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationCircle pdAnnotationCircle = new PDAnnotationCircle();
    annotations.add(pdAnnotationCircle);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationCircle);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationCircle);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationCircle);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationCircle);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationCircle, getResult2);
    assertEquals(pdAnnotationCircle, getResult4);
    assertEquals(pdAnnotationCircle, getResult6);
    assertEquals(pdAnnotationCircle, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature6() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFileAttachment pdAnnotationFileAttachment = new PDAnnotationFileAttachment();
    annotations.add(pdAnnotationFileAttachment);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationFileAttachment);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationFileAttachment);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationFileAttachment);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationFileAttachment);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationFileAttachment, getResult2);
    assertEquals(pdAnnotationFileAttachment, getResult4);
    assertEquals(pdAnnotationFileAttachment, getResult6);
    assertEquals(pdAnnotationFileAttachment, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature7() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationFreeText pdAnnotationFreeText = new PDAnnotationFreeText();
    annotations.add(pdAnnotationFreeText);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationFreeText);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationFreeText);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationFreeText);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationFreeText);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationFreeText, getResult2);
    assertEquals(pdAnnotationFreeText, getResult4);
    assertEquals(pdAnnotationFreeText, getResult6);
    assertEquals(pdAnnotationFreeText, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String)")
  void testCreateSignature8() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight();
    annotations.add(pdAnnotationHighlight);

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations2 = page.getAnnotations();
    assertEquals(2, annotations2.size());
    PDAnnotation getResult = annotations2.get(1);
    List<PDAnnotation> annotations3 = getResult.getPage().getAnnotations();
    assertEquals(2, annotations3.size());
    PDAnnotation getResult2 = annotations3.get(0);
    assertTrue(getResult2 instanceof PDAnnotationHighlight);
    PDAnnotation getResult3 = annotations3.get(1);
    List<PDAnnotation> annotations4 = getResult3.getPage().getAnnotations();
    assertEquals(2, annotations4.size());
    PDAnnotation getResult4 = annotations4.get(0);
    assertTrue(getResult4 instanceof PDAnnotationHighlight);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations5 = widgets.get(0).getPage().getAnnotations();
    assertEquals(2, annotations5.size());
    PDAnnotation getResult5 = annotations5.get(1);
    List<PDAnnotation> annotations6 = getResult5.getPage().getAnnotations();
    assertEquals(2, annotations6.size());
    PDAnnotation getResult6 = annotations6.get(0);
    assertTrue(getResult6 instanceof PDAnnotationHighlight);
    PDAnnotation getResult7 = annotations5.get(0);
    assertTrue(getResult7 instanceof PDAnnotationHighlight);
    assertTrue(getResult instanceof PDAnnotationWidget);
    assertTrue(getResult3 instanceof PDAnnotationWidget);
    assertTrue(getResult5 instanceof PDAnnotationWidget);
    assertEquals(pdAnnotationHighlight, getResult2);
    assertEquals(pdAnnotationHighlight, getResult4);
    assertEquals(pdAnnotationHighlight, getResult6);
    assertEquals(pdAnnotationHighlight, getResult7);
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Annotations size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); given ArrayList(); then PDPage() Annotations size is one")
  void testCreateSignature_givenArrayList_thenPDPageAnnotationsSizeIsOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations = page.getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure
   * PdSignature Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); then PDVisibleSigBuilder (default constructor) Structure PdSignature Name is 'null'")
  void testCreateSignature_thenPDVisibleSigBuilderStructurePdSignatureNameIsNull() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, new PDPage(), "");

    // Assert
    assertNull(pdVisibleSigBuilder.getStructure().getPdSignature().getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getName());
    assertNull(pdSignatureField.getValue().getName());
    COSDictionary cOSObject = signature.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}.
   * <ul>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then {@link PDPage#PDPage()} Annotations size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  @DisplayName("Test createSignature(PDSignatureField, PDPage, String); when PDPage(); then PDPage() Annotations size is one")
  void testCreateSignature_whenPDPage_thenPDPageAnnotationsSizeIsOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));
    PDPage page = new PDPage();

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    List<PDAnnotation> annotations = page.getAnnotations();
    assertEquals(1, annotations.size());
    PDAnnotation getResult = annotations.get(0);
    assertTrue(getResult instanceof PDAnnotationWidget);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    List<PDAnnotation> annotations2 = widgets.get(0).getPage().getAnnotations();
    assertEquals(1, annotations2.size());
    PDAnnotation getResult2 = annotations2.get(0);
    assertTrue(getResult2 instanceof PDAnnotationWidget);
    assertEquals(page, getResult.getPage());
    assertEquals(page, getResult2.getPage());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createAcroFormDictionary(PDAcroForm, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAcroFormDictionary(PDAcroForm, PDSignatureField)")
  void testCreateAcroFormDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createAcroFormDictionary(acroForm, signatureField);

    // Assert
    Iterator<PDField> fieldIterator = acroForm.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    List<PDAnnotationWidget> widgets = nextResult.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertTrue(nextResult instanceof PDSignatureField);
    Iterator<PDField> iteratorResult = acroForm.getFieldTree().iterator();
    PDField nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PDSignatureField);
    List<PDField> fields = acroForm.getFields();
    assertEquals(1, fields.size());
    PDField getResult4 = fields.get(0);
    assertTrue(getResult4 instanceof PDSignatureField);
    assertEquals("", nextResult.getValueAsString());
    assertEquals("", nextResult2.getValueAsString());
    assertEquals("", getResult4.getValueAsString());
    assertEquals("/sylfaen 0 Tf 0 g", acroForm.getDefaultAppearance());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Sig", nextResult.getFieldType());
    assertEquals("Sig", nextResult2.getFieldType());
    assertEquals("Sig", getResult4.getFieldType());
    assertEquals("Signature1", nextResult.getFullyQualifiedName());
    assertEquals("Signature1", nextResult2.getFullyQualifiedName());
    assertEquals("Signature1", getResult4.getFullyQualifiedName());
    assertEquals("Signature1", nextResult.getPartialName());
    assertEquals("Signature1", nextResult2.getPartialName());
    assertEquals("Signature1", getResult4.getPartialName());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(nextResult.getAlternateFieldName());
    assertNull(nextResult2.getAlternateFieldName());
    assertNull(getResult4.getAlternateFieldName());
    assertNull(nextResult.getMappingName());
    assertNull(nextResult2.getMappingName());
    assertNull(getResult4.getMappingName());
    COSDictionary cOSObject = nextResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(getResult.getAppearanceState());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(cOSObject.getKey());
    assertNull(getResult.getPage());
    assertNull(getResult.getRectangle());
    assertNull(getResult.getOptionalContent());
    assertNull(getResult.getColor());
    assertNull(getResult.getAction());
    assertNull(getResult.getActions());
    assertNull(nextResult.getActions());
    assertNull(nextResult2.getActions());
    assertNull(getResult4.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(((PDSignatureField) nextResult).getSeedValue());
    assertNull(((PDSignatureField) nextResult2).getSeedValue());
    assertNull(((PDSignatureField) getResult4).getSeedValue());
    assertNull(((PDSignatureField) nextResult).getDefaultValue());
    assertNull(((PDSignatureField) nextResult2).getDefaultValue());
    assertNull(((PDSignatureField) getResult4).getDefaultValue());
    assertNull(((PDSignatureField) nextResult).getSignature());
    assertNull(((PDSignatureField) nextResult2).getSignature());
    assertNull(((PDSignatureField) getResult4).getSignature());
    assertNull(((PDSignatureField) nextResult).getValue());
    assertNull(((PDSignatureField) nextResult2).getValue());
    assertNull(((PDSignatureField) getResult4).getValue());
    assertNull(nextResult.getParent());
    assertNull(nextResult2.getParent());
    assertNull(getResult4.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, nextResult.getFieldFlags());
    assertEquals(0, nextResult2.getFieldFlags());
    assertEquals(0, getResult4.getFieldFlags());
    PDFTemplateStructure structure = pdVisibleSigBuilder.getStructure();
    List<PDField> acroFormFields = structure.getAcroFormFields();
    assertEquals(1, acroFormFields.size());
    List<PDAnnotationWidget> widgets2 = signatureField.getWidgets();
    assertEquals(1, widgets2.size());
    assertEquals(132, getResult.getAnnotationFlags());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(fieldIterator.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(nextResult.isNoExport());
    assertFalse(nextResult2.isNoExport());
    assertFalse(getResult4.isNoExport());
    assertFalse(nextResult.isReadOnly());
    assertFalse(nextResult2.isReadOnly());
    assertFalse(getResult4.isReadOnly());
    assertFalse(nextResult.isRequired());
    assertFalse(nextResult2.isRequired());
    assertFalse(getResult4.isRequired());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject2.isDirect());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(getResult.isLocked());
    assertTrue(getResult.isPrinted());
    assertTrue(acroForm.isAppendOnly());
    assertTrue(acroForm.isSignaturesExist());
    assertSame(acroForm, nextResult.getAcroForm());
    assertSame(acroForm, nextResult2.getAcroForm());
    assertSame(acroForm, getResult4.getAcroForm());
    assertSame(signatureField, acroFormFields.get(0));
    assertSame(cOSObject2, structure.getAcroFormDictionary());
    assertSame(cOSObject, getResult.getCOSObject());
    assertSame(cOSObject, widgets2.get(0).getCOSObject());
    assertSame(cOSObject, signatureField.getCOSObject());
    assertSame(cOSObject, nextResult2.getCOSObject());
    assertSame(cOSObject, getResult4.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createAffineTransform(AffineTransform)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createAffineTransform(AffineTransform)}
   */
  @Test
  @DisplayName("Test createAffineTransform(AffineTransform)")
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
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSName);
    COSBase getResult4 = toListResult.get(4);
    assertTrue(getResult4 instanceof COSName);
    assertEquals("ImageC", ((COSName) getResult3).getName());
    assertEquals("ImageI", ((COSName) getResult4).getName());
    assertEquals("PDF", ((COSName) getResult).getName());
    assertEquals("Text", ((COSName) getResult2).getName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertFalse(((COSName) getResult2).isEmpty());
    assertFalse(((COSName) getResult3).isEmpty());
    assertFalse(((COSName) getResult4).isEmpty());
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
  void testCreateProcSetArray_givenPDVisibleSigBuilder() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createProcSetArray();

    // Assert
    List<? extends COSBase> toListResult = pdVisibleSigBuilder.getStructure().getProcSet().toList();
    assertEquals(5, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSName);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSName);
    COSBase getResult4 = toListResult.get(4);
    assertTrue(getResult4 instanceof COSName);
    assertEquals("ImageC", ((COSName) getResult3).getName());
    assertEquals("ImageI", ((COSName) getResult4).getName());
    assertEquals("PDF", ((COSName) getResult).getName());
    assertEquals("Text", ((COSName) getResult2).getName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(((COSName) getResult).isEmpty());
    assertFalse(((COSName) getResult2).isEmpty());
    assertFalse(((COSName) getResult3).isEmpty());
    assertFalse(((COSName) getResult4).isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage)")
  void testCreateSignatureImage() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(0L)));
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage)")
  void testCreateSignatureImage2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template,
        new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, BufferedImage.TYPE_BYTE_GRAY, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and eight")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndEight() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 8));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and five.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and five")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndFive() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 5));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and four")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndFour() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 4));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and one")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and six.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and six")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndSix() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 6));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and three")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndThree() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 3));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given 'null'; when BufferedImage(int, int, int) with one and one and two")
  void testCreateSignatureImage_givenNull_whenBufferedImageWithOneAndOneAndTwo() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 2));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>Given {@link RandomAccessStreamCacheImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); given RandomAccessStreamCacheImpl (default constructor)")
  void testCreateSignatureImage_givenRandomAccessStreamCacheImpl() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument template = new PDDocument(streamCacheCreateFunction);
    template.save(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and {@link BufferedImage#TYPE_BYTE_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and TYPE_BYTE_BINARY")
  void testCreateSignatureImage_whenBufferedImageWithOneAndOneAndType_byte_binary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one
   * and {@link BufferedImage#TYPE_BYTE_GRAY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and TYPE_BYTE_GRAY")
  void testCreateSignatureImage_whenBufferedImageWithOneAndOneAndType_byte_gray() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with
   * {@link BufferedImage#TYPE_BYTE_GRAY} and one and one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createSignatureImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with TYPE_BYTE_GRAY and one and one")
  void testCreateSignatureImage_whenBufferedImageWithType_byte_grayAndOneAndOne() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link PDVisibleSigBuilder#createFormatterRectangle(int[])}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createFormatterRectangle(int[])}
   */
  @Test
  @DisplayName("Test createFormatterRectangle(int[])")
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
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, formatterRectangle.getHeight());
    assertEquals(0.0f, formatterRectangle.getWidth());
    assertEquals(1.0f, formatterRectangle.getLowerLeftY());
    assertEquals(1.0f, formatterRectangle.getUpperRightY());
    assertEquals(1000.0f, formatterRectangle.getLowerLeftX());
    assertEquals(1000.0f, formatterRectangle.getUpperRightX());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, formatterRectangle.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createHolderFormStream(PDDocument)")
  void testCreateHolderFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createHolderFormStream(new PDDocument());

    // Assert
    PDStream holderFormStream = pdVisibleSigBuilder.getStructure().getHolderFormStream();
    assertNull(holderFormStream.getDecodeParms());
    assertNull(holderFormStream.getFileDecodeParams());
    COSStream cOSObject = holderFormStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(holderFormStream.getMetadata());
    assertNull(holderFormStream.getFile());
    assertEquals(-1, holderFormStream.getDecodedStreamLength());
    assertEquals(0, holderFormStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = holderFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, holderFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createHolderFormResources()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createHolderFormResources()}
   */
  @Test
  @DisplayName("Test createHolderFormResources()")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(holderFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, holderFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, holderFormResources.getFontNames());
    assertSame(colorSpaceNames, holderFormResources.getPatternNames());
    assertSame(colorSpaceNames, holderFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, holderFormResources.getShadingNames());
    assertSame(colorSpaceNames, holderFormResources.getXObjectNames());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure
   * HolderForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createHolderForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure HolderForm BBox is 'null'")
  void testCreateHolderForm_thenPDVisibleSigBuilderStructureHolderFormBBoxIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources holderFormResources = new PDResources();
    PDStream holderFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createHolderForm(holderFormResources, holderFormStream, null);

    // Assert
    PDFormXObject holderForm = pdVisibleSigBuilder.getStructure().getHolderForm();
    assertNull(holderForm.getResources().getResourceCache());
    assertNull(holderForm.getBBox());
    COSStream cOSObject = holderFormStream.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAppearanceDictionary(PDFormXObject, PDSignatureField)")
  void testCreateAppearanceDictionary() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    COSStream stream = new COSStream();
    PDFormXObject holderForml = new PDFormXObject(stream);
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdVisibleSigBuilder.createAppearanceDictionary(holderForml, signatureField);

    // Assert
    List<PDAnnotationWidget> widgets = signatureField.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    PDAppearanceStream normalAppearanceStream = getResult.getNormalAppearanceStream();
    PDStream stream2 = normalAppearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceDictionary appearance = getResult.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceDictionary appearanceDictionary = pdVisibleSigBuilder.getStructure().getAppearanceDictionary();
    PDAppearanceEntry downAppearance2 = appearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream2 = downAppearance2.getAppearanceStream();
    PDStream stream4 = appearanceStream2.getStream();
    assertNull(stream4.getDecodeParms());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream3 = normalAppearance.getAppearanceStream();
    PDStream stream5 = appearanceStream3.getStream();
    assertNull(stream5.getDecodeParms());
    PDAppearanceEntry normalAppearance2 = appearanceDictionary.getNormalAppearance();
    PDAppearanceStream appearanceStream4 = normalAppearance2.getAppearanceStream();
    PDStream stream6 = appearanceStream4.getStream();
    assertNull(stream6.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream5 = rolloverAppearance.getAppearanceStream();
    PDStream stream7 = appearanceStream5.getStream();
    assertNull(stream7.getDecodeParms());
    PDAppearanceEntry rolloverAppearance2 = appearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream6 = rolloverAppearance2.getAppearanceStream();
    PDStream stream8 = appearanceStream6.getStream();
    assertNull(stream8.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    PDStream contentStream5 = appearanceStream4.getContentStream();
    assertNull(contentStream5.getDecodeParms());
    PDStream contentStream6 = appearanceStream5.getContentStream();
    assertNull(contentStream6.getDecodeParms());
    PDStream contentStream7 = appearanceStream6.getContentStream();
    assertNull(contentStream7.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(stream5.getFileDecodeParams());
    assertNull(stream6.getFileDecodeParams());
    assertNull(stream7.getFileDecodeParams());
    assertNull(stream8.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    assertNull(contentStream5.getFileDecodeParams());
    assertNull(contentStream6.getFileDecodeParams());
    assertNull(contentStream7.getFileDecodeParams());
    COSDictionary cOSObject = appearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(normalAppearanceStream.getResources());
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream3.getResources());
    assertNull(appearanceStream4.getResources());
    assertNull(appearanceStream5.getResources());
    assertNull(appearanceStream6.getResources());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(stream5.getMetadata());
    assertNull(stream6.getMetadata());
    assertNull(stream7.getMetadata());
    assertNull(stream8.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(contentStream5.getMetadata());
    assertNull(contentStream6.getMetadata());
    assertNull(contentStream7.getMetadata());
    assertNull(normalAppearanceStream.getBBox());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertNull(appearanceStream3.getBBox());
    assertNull(appearanceStream4.getBBox());
    assertNull(appearanceStream5.getBBox());
    assertNull(appearanceStream6.getBBox());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(stream5.getFile());
    assertNull(stream6.getFile());
    assertNull(stream7.getFile());
    assertNull(stream8.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(contentStream5.getFile());
    assertNull(contentStream6.getFile());
    assertNull(contentStream7.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(appearanceStream4.getOptionalContent());
    assertNull(appearanceStream5.getOptionalContent());
    assertNull(appearanceStream6.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertNull(appearanceStream4.getGroup());
    assertNull(appearanceStream5.getGroup());
    assertNull(appearanceStream6.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, stream5.getDecodedStreamLength());
    assertEquals(-1, stream6.getDecodedStreamLength());
    assertEquals(-1, stream7.getDecodedStreamLength());
    assertEquals(-1, stream8.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, contentStream5.getDecodedStreamLength());
    assertEquals(-1, contentStream6.getDecodedStreamLength());
    assertEquals(-1, contentStream7.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(-1, appearanceStream4.getStructParents());
    assertEquals(-1, appearanceStream5.getStructParents());
    assertEquals(-1, appearanceStream6.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, stream5.getLength());
    assertEquals(0, stream6.getLength());
    assertEquals(0, stream7.getLength());
    assertEquals(0, stream8.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    assertEquals(0, contentStream4.getLength());
    assertEquals(0, contentStream5.getLength());
    assertEquals(0, contentStream6.getLength());
    assertEquals(0, contentStream7.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1, appearanceStream4.getFormType());
    assertEquals(1, appearanceStream5.getFormType());
    assertEquals(1, appearanceStream6.getFormType());
    COSDictionary cOSObject2 = signatureField.getCOSObject();
    assertEquals(6, cOSObject2.getValues().size());
    assertEquals(6, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(downAppearance2.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(normalAppearance2.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertFalse(rolloverAppearance2.isSubDictionary());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(downAppearance.isStream());
    assertTrue(downAppearance2.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(normalAppearance2.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertTrue(rolloverAppearance2.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, stream3.getCOSObject());
    assertSame(stream, stream4.getCOSObject());
    assertSame(stream, stream5.getCOSObject());
    assertSame(stream, stream6.getCOSObject());
    assertSame(stream, stream7.getCOSObject());
    assertSame(stream, stream8.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, contentStream2.getCOSObject());
    assertSame(stream, contentStream3.getCOSObject());
    assertSame(stream, contentStream4.getCOSObject());
    assertSame(stream, contentStream5.getCOSObject());
    assertSame(stream, contentStream6.getCOSObject());
    assertSame(stream, contentStream7.getCOSObject());
    assertSame(stream, normalAppearanceStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, appearanceStream2.getCOSObject());
    assertSame(stream, appearanceStream3.getCOSObject());
    assertSame(stream, appearanceStream4.getCOSObject());
    assertSame(stream, appearanceStream5.getCOSObject());
    assertSame(stream, appearanceStream6.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, downAppearance2.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, normalAppearance2.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance2.getCOSObject());
    assertSame(cOSObject, appearanceDictionary.getCOSObject());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  @DisplayName("Test createAppearanceDictionary(PDFormXObject, PDSignatureField); given COSObjectKey(long, int) with num is one and gen is one")
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
    List<PDAnnotationWidget> widgets = signatureField.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    PDAppearanceStream normalAppearanceStream = getResult.getNormalAppearanceStream();
    PDStream stream2 = normalAppearanceStream.getStream();
    assertNull(stream2.getDecodeParms());
    PDAppearanceDictionary appearance = getResult.getAppearance();
    PDAppearanceEntry downAppearance = appearance.getDownAppearance();
    PDAppearanceStream appearanceStream = downAppearance.getAppearanceStream();
    PDStream stream3 = appearanceStream.getStream();
    assertNull(stream3.getDecodeParms());
    PDAppearanceDictionary appearanceDictionary = pdVisibleSigBuilder.getStructure().getAppearanceDictionary();
    PDAppearanceEntry downAppearance2 = appearanceDictionary.getDownAppearance();
    PDAppearanceStream appearanceStream2 = downAppearance2.getAppearanceStream();
    PDStream stream4 = appearanceStream2.getStream();
    assertNull(stream4.getDecodeParms());
    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
    PDAppearanceStream appearanceStream3 = normalAppearance.getAppearanceStream();
    PDStream stream5 = appearanceStream3.getStream();
    assertNull(stream5.getDecodeParms());
    PDAppearanceEntry normalAppearance2 = appearanceDictionary.getNormalAppearance();
    PDAppearanceStream appearanceStream4 = normalAppearance2.getAppearanceStream();
    PDStream stream6 = appearanceStream4.getStream();
    assertNull(stream6.getDecodeParms());
    PDAppearanceEntry rolloverAppearance = appearance.getRolloverAppearance();
    PDAppearanceStream appearanceStream5 = rolloverAppearance.getAppearanceStream();
    PDStream stream7 = appearanceStream5.getStream();
    assertNull(stream7.getDecodeParms());
    PDAppearanceEntry rolloverAppearance2 = appearanceDictionary.getRolloverAppearance();
    PDAppearanceStream appearanceStream6 = rolloverAppearance2.getAppearanceStream();
    PDStream stream8 = appearanceStream6.getStream();
    assertNull(stream8.getDecodeParms());
    PDStream contentStream = normalAppearanceStream.getContentStream();
    assertNull(contentStream.getDecodeParms());
    PDStream contentStream2 = appearanceStream.getContentStream();
    assertNull(contentStream2.getDecodeParms());
    PDStream contentStream3 = appearanceStream2.getContentStream();
    assertNull(contentStream3.getDecodeParms());
    PDStream contentStream4 = appearanceStream3.getContentStream();
    assertNull(contentStream4.getDecodeParms());
    PDStream contentStream5 = appearanceStream4.getContentStream();
    assertNull(contentStream5.getDecodeParms());
    PDStream contentStream6 = appearanceStream5.getContentStream();
    assertNull(contentStream6.getDecodeParms());
    PDStream contentStream7 = appearanceStream6.getContentStream();
    assertNull(contentStream7.getDecodeParms());
    assertNull(stream2.getFileDecodeParams());
    assertNull(stream3.getFileDecodeParams());
    assertNull(stream4.getFileDecodeParams());
    assertNull(stream5.getFileDecodeParams());
    assertNull(stream6.getFileDecodeParams());
    assertNull(stream7.getFileDecodeParams());
    assertNull(stream8.getFileDecodeParams());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(contentStream2.getFileDecodeParams());
    assertNull(contentStream3.getFileDecodeParams());
    assertNull(contentStream4.getFileDecodeParams());
    assertNull(contentStream5.getFileDecodeParams());
    assertNull(contentStream6.getFileDecodeParams());
    assertNull(contentStream7.getFileDecodeParams());
    COSDictionary cOSObject = appearance.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(normalAppearanceStream.getResources());
    assertNull(appearanceStream.getResources());
    assertNull(appearanceStream2.getResources());
    assertNull(appearanceStream3.getResources());
    assertNull(appearanceStream4.getResources());
    assertNull(appearanceStream5.getResources());
    assertNull(appearanceStream6.getResources());
    assertNull(stream2.getMetadata());
    assertNull(stream3.getMetadata());
    assertNull(stream4.getMetadata());
    assertNull(stream5.getMetadata());
    assertNull(stream6.getMetadata());
    assertNull(stream7.getMetadata());
    assertNull(stream8.getMetadata());
    assertNull(contentStream.getMetadata());
    assertNull(contentStream2.getMetadata());
    assertNull(contentStream3.getMetadata());
    assertNull(contentStream4.getMetadata());
    assertNull(contentStream5.getMetadata());
    assertNull(contentStream6.getMetadata());
    assertNull(contentStream7.getMetadata());
    assertNull(normalAppearanceStream.getBBox());
    assertNull(appearanceStream.getBBox());
    assertNull(appearanceStream2.getBBox());
    assertNull(appearanceStream3.getBBox());
    assertNull(appearanceStream4.getBBox());
    assertNull(appearanceStream5.getBBox());
    assertNull(appearanceStream6.getBBox());
    assertNull(stream2.getFile());
    assertNull(stream3.getFile());
    assertNull(stream4.getFile());
    assertNull(stream5.getFile());
    assertNull(stream6.getFile());
    assertNull(stream7.getFile());
    assertNull(stream8.getFile());
    assertNull(contentStream.getFile());
    assertNull(contentStream2.getFile());
    assertNull(contentStream3.getFile());
    assertNull(contentStream4.getFile());
    assertNull(contentStream5.getFile());
    assertNull(contentStream6.getFile());
    assertNull(contentStream7.getFile());
    assertNull(normalAppearanceStream.getOptionalContent());
    assertNull(appearanceStream.getOptionalContent());
    assertNull(appearanceStream2.getOptionalContent());
    assertNull(appearanceStream3.getOptionalContent());
    assertNull(appearanceStream4.getOptionalContent());
    assertNull(appearanceStream5.getOptionalContent());
    assertNull(appearanceStream6.getOptionalContent());
    assertNull(normalAppearanceStream.getGroup());
    assertNull(appearanceStream.getGroup());
    assertNull(appearanceStream2.getGroup());
    assertNull(appearanceStream3.getGroup());
    assertNull(appearanceStream4.getGroup());
    assertNull(appearanceStream5.getGroup());
    assertNull(appearanceStream6.getGroup());
    assertEquals(-1, stream2.getDecodedStreamLength());
    assertEquals(-1, stream3.getDecodedStreamLength());
    assertEquals(-1, stream4.getDecodedStreamLength());
    assertEquals(-1, stream5.getDecodedStreamLength());
    assertEquals(-1, stream6.getDecodedStreamLength());
    assertEquals(-1, stream7.getDecodedStreamLength());
    assertEquals(-1, stream8.getDecodedStreamLength());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, contentStream2.getDecodedStreamLength());
    assertEquals(-1, contentStream3.getDecodedStreamLength());
    assertEquals(-1, contentStream4.getDecodedStreamLength());
    assertEquals(-1, contentStream5.getDecodedStreamLength());
    assertEquals(-1, contentStream6.getDecodedStreamLength());
    assertEquals(-1, contentStream7.getDecodedStreamLength());
    assertEquals(-1, normalAppearanceStream.getStructParents());
    assertEquals(-1, appearanceStream.getStructParents());
    assertEquals(-1, appearanceStream2.getStructParents());
    assertEquals(-1, appearanceStream3.getStructParents());
    assertEquals(-1, appearanceStream4.getStructParents());
    assertEquals(-1, appearanceStream5.getStructParents());
    assertEquals(-1, appearanceStream6.getStructParents());
    assertEquals(0, stream2.getLength());
    assertEquals(0, stream3.getLength());
    assertEquals(0, stream4.getLength());
    assertEquals(0, stream5.getLength());
    assertEquals(0, stream6.getLength());
    assertEquals(0, stream7.getLength());
    assertEquals(0, stream8.getLength());
    assertEquals(0, contentStream.getLength());
    assertEquals(0, contentStream2.getLength());
    assertEquals(0, contentStream3.getLength());
    assertEquals(0, contentStream4.getLength());
    assertEquals(0, contentStream5.getLength());
    assertEquals(0, contentStream6.getLength());
    assertEquals(0, contentStream7.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, normalAppearanceStream.getFormType());
    assertEquals(1, appearanceStream.getFormType());
    assertEquals(1, appearanceStream2.getFormType());
    assertEquals(1, appearanceStream3.getFormType());
    assertEquals(1, appearanceStream4.getFormType());
    assertEquals(1, appearanceStream5.getFormType());
    assertEquals(1, appearanceStream6.getFormType());
    COSDictionary cOSObject2 = signatureField.getCOSObject();
    assertEquals(6, cOSObject2.getValues().size());
    assertEquals(6, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(downAppearance.isSubDictionary());
    assertFalse(downAppearance2.isSubDictionary());
    assertFalse(normalAppearance.isSubDictionary());
    assertFalse(normalAppearance2.isSubDictionary());
    assertFalse(rolloverAppearance.isSubDictionary());
    assertFalse(rolloverAppearance2.isSubDictionary());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertTrue(downAppearance.isStream());
    assertTrue(downAppearance2.isStream());
    assertTrue(normalAppearance.isStream());
    assertTrue(normalAppearance2.isStream());
    assertTrue(rolloverAppearance.isStream());
    assertTrue(rolloverAppearance2.isStream());
    assertSame(stream, stream2.getCOSObject());
    assertSame(stream, stream3.getCOSObject());
    assertSame(stream, stream4.getCOSObject());
    assertSame(stream, stream5.getCOSObject());
    assertSame(stream, stream6.getCOSObject());
    assertSame(stream, stream7.getCOSObject());
    assertSame(stream, stream8.getCOSObject());
    assertSame(stream, contentStream.getCOSObject());
    assertSame(stream, contentStream2.getCOSObject());
    assertSame(stream, contentStream3.getCOSObject());
    assertSame(stream, contentStream4.getCOSObject());
    assertSame(stream, contentStream5.getCOSObject());
    assertSame(stream, contentStream6.getCOSObject());
    assertSame(stream, contentStream7.getCOSObject());
    assertSame(stream, normalAppearanceStream.getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, appearanceStream2.getCOSObject());
    assertSame(stream, appearanceStream3.getCOSObject());
    assertSame(stream, appearanceStream4.getCOSObject());
    assertSame(stream, appearanceStream5.getCOSObject());
    assertSame(stream, appearanceStream6.getCOSObject());
    assertSame(stream, downAppearance.getCOSObject());
    assertSame(stream, downAppearance2.getCOSObject());
    assertSame(stream, normalAppearance.getCOSObject());
    assertSame(stream, normalAppearance2.getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
    assertSame(stream, rolloverAppearance2.getCOSObject());
    assertSame(cOSObject, appearanceDictionary.getCOSObject());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createInnerFormStream(PDDocument)")
  void testCreateInnerFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createInnerFormStream(new PDDocument());

    // Assert
    PDStream innerFormStream = pdVisibleSigBuilder.getStructure().getInnerFormStream();
    assertNull(innerFormStream.getDecodeParms());
    assertNull(innerFormStream.getFileDecodeParams());
    COSStream cOSObject = innerFormStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(innerFormStream.getMetadata());
    assertNull(innerFormStream.getFile());
    assertEquals(-1, innerFormStream.getDecodedStreamLength());
    assertEquals(0, innerFormStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = innerFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, innerFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createInnerFormResource()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createInnerFormResource()}
   */
  @Test
  @DisplayName("Test createInnerFormResource()")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(innerFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, innerFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, innerFormResources.getFontNames());
    assertSame(colorSpaceNames, innerFormResources.getPatternNames());
    assertSame(colorSpaceNames, innerFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, innerFormResources.getShadingNames());
    assertSame(colorSpaceNames, innerFormResources.getXObjectNames());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure
   * InnerForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  @DisplayName("Test createInnerForm(PDResources, PDStream, PDRectangle); then PDVisibleSigBuilder (default constructor) Structure InnerForm BBox is 'null'")
  void testCreateInnerForm_thenPDVisibleSigBuilderStructureInnerFormBBoxIsNull() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources innerFormResources = new PDResources();
    PDStream innerFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createInnerForm(innerFormResources, innerFormStream, null);

    // Assert
    PDFormXObject innerForm = pdVisibleSigBuilder.getStructure().getInnerForm();
    assertNull(innerForm.getResources().getResourceCache());
    assertNull(innerForm.getBBox());
    COSStream cOSObject = innerFormStream.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources)")
  void testInsertInnerFormToHolderResources() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(null, new PDResources());

    // Assert
    COSName innerFormName = pdVisibleSigBuilder.getStructure().getInnerFormName();
    assertEquals("FRM", innerFormName.getName());
    assertNull(innerFormName.getKey());
    assertFalse(innerFormName.isDirect());
    assertFalse(innerFormName.isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); given 'true'; when COSStream() Direct is 'true'")
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
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); then PDResources() COSObject Values size is one")
  void testInsertInnerFormToHolderResources_thenPDResourcesCOSObjectValuesSizeIsOne() {
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
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); then PDResources() COSObject Values size is two")
  void testInsertInnerFormToHolderResources_thenPDResourcesCOSObjectValuesSizeIsTwo() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = new PDFormXObject(new COSStream());

    PDResources holderFormResources = new PDResources();
    holderFormResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} XObjectNames size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#insertInnerFormToHolderResources(PDFormXObject, PDResources)}
   */
  @Test
  @DisplayName("Test insertInnerFormToHolderResources(PDFormXObject, PDResources); then PDResources() XObjectNames size is two")
  void testInsertInnerFormToHolderResources_thenPDResourcesXObjectNamesSizeIsTwo() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDFormXObject innerForm = new PDFormXObject(new COSStream());

    PDResources holderFormResources = new PDResources();
    holderFormResources.add(new PDImageXObject(new PDDocument()));
    holderFormResources.add(new PDMMType1Font(new COSDictionary()));

    // Act
    pdVisibleSigBuilder.insertInnerFormToHolderResources(innerForm, holderFormResources);

    // Assert
    Iterable<COSName> xObjectNames = holderFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    COSDictionary cOSObject = holderFormResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}
   */
  @Test
  @DisplayName("Test createImageFormStream(PDDocument)")
  void testCreateImageFormStream() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    // Act
    pdVisibleSigBuilder.createImageFormStream(new PDDocument());

    // Assert
    PDStream imageFormStream = pdVisibleSigBuilder.getStructure().getImageFormStream();
    assertNull(imageFormStream.getDecodeParms());
    assertNull(imageFormStream.getFileDecodeParams());
    COSStream cOSObject = imageFormStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(imageFormStream.getMetadata());
    assertNull(imageFormStream.getFile());
    assertEquals(-1, imageFormStream.getDecodedStreamLength());
    assertEquals(0, imageFormStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    List<String> fileFilters = imageFormStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(fileFilters, imageFormStream.getFilters());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createImageFormResources()}.
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#createImageFormResources()}
   */
  @Test
  @DisplayName("Test createImageFormResources()")
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
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(imageFormResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, imageFormResources.getExtGStateNames());
    assertSame(colorSpaceNames, imageFormResources.getFontNames());
    assertSame(colorSpaceNames, imageFormResources.getPatternNames());
    assertSame(colorSpaceNames, imageFormResources.getPropertiesNames());
    assertSame(colorSpaceNames, imageFormResources.getShadingNames());
    assertSame(colorSpaceNames, imageFormResources.getXObjectNames());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}.
   * <ul>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure
   * ImageName Name is {@code img2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}
   */
  @Test
  @DisplayName("Test createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject); then PDVisibleSigBuilder (default constructor) Structure ImageName Name is 'img2'")
  void testCreateImageForm_thenPDVisibleSigBuilderStructureImageNameNameIsImg2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    PDResources imageFormResources = new PDResources();
    imageFormResources.add(new PDImageXObject(new PDDocument()));
    imageFormResources.add(new PDMMType1Font(new COSDictionary()));
    PDResources innerFormResource = new PDResources();
    PDStream imageFormStream = new PDStream(new COSDocument());
    AffineTransform at = new AffineTransform();

    // Act
    pdVisibleSigBuilder.createImageForm(imageFormResources, innerFormResource, imageFormStream, PDRectangle.A0, at,
        new PDImageXObject(new PDDocument()));

    // Assert
    Iterable<COSName> xObjectNames = imageFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    assertEquals("img2", pdVisibleSigBuilder.getStructure().getImageName().getName());
    COSDictionary cOSObject = imageFormResources.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, ((Set<COSName>) xObjectNames).size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDVisibleSigBuilder} (default constructor) Structure
   * ImageForm BBox is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}
   */
  @Test
  @DisplayName("Test createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject); when 'null'; then PDVisibleSigBuilder (default constructor) Structure ImageForm BBox is 'null'")
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
    assertNull(pdVisibleSigBuilder.getStructure().getImageForm().getBBox());
    COSStream cOSObject = imageFormStream.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#createBackgroundLayerForm(PDResources, PDRectangle)}.
   * <ul>
   *   <li>Then {@link PDResources#PDResources()} COSObject toIncrement Objects
   * Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createBackgroundLayerForm(PDResources, PDRectangle)}
   */
  @Test
  @DisplayName("Test createBackgroundLayerForm(PDResources, PDRectangle); then PDResources() COSObject toIncrement Objects Empty")
  void testCreateBackgroundLayerForm_thenPDResourcesCOSObjectToIncrementObjectsEmpty() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    pdVisibleSigBuilder.createTemplate(new PDPage());
    PDResources innerFormResource = new PDResources();

    // Act
    pdVisibleSigBuilder.createBackgroundLayerForm(innerFormResource, null);

    // Assert
    COSDictionary cOSObject = innerFormResource.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Given {@link COSUpdateState#COSUpdateState(COSUpdateInfo)} with
   * updateInfo is {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); given COSUpdateState(COSUpdateInfo) with updateInfo is COSArray()")
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
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); given 'false'; then calls getKey()")
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
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); then calls setItem(COSName, COSBase)")
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
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); then calls setOriginDocumentState(COSDocumentState)")
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
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDResources#PDResources()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); when 'null'; then PDResources() COSObject size is zero")
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

    // Assert
    verify(cosDictionary).setItem(isA(COSName.class), (COSBase) isNull());
    verify(page).getCOSObject();
    verify(innerForm).getResources();
    COSDictionary cOSObject = innerFormResources.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}.
   * <ul>
   *   <li>When {@link PDPage} {@link PDPage#getCOSObject()} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  @DisplayName("Test injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray); when PDPage getCOSObject() return COSDictionary()")
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
   * Method under test:
   * {@link PDVisibleSigBuilder#appendRawCommands(OutputStream, String)}
   */
  @Test
  @DisplayName("Test appendRawCommands(OutputStream, String)")
  void testAppendRawCommands() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    ByteArrayOutputStream os = new ByteArrayOutputStream(1);

    // Act
    pdVisibleSigBuilder.appendRawCommands(os, "Commands");

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "Commands".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, os.toByteArray());
  }

  /**
   * Test {@link PDVisibleSigBuilder#createVisualSignature(PDDocument)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createVisualSignature(PDDocument)}
   */
  @Test
  @DisplayName("Test createVisualSignature(PDDocument)")
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
   * Test
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}.
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
  @DisplayName("Test createWidgetDictionary(PDSignatureField, PDResources)")
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
   * Test
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}.
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link PDResources#PDResources()} {@link COSName#A} is
   * {@link PDExtendedGraphicsState#PDExtendedGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
  @DisplayName("Test createWidgetDictionary(PDSignatureField, PDResources); given A; when PDResources() A is PDExtendedGraphicsState()")
  void testCreateWidgetDictionary_givenA_whenPDResourcesAIsPDExtendedGraphicsState() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    PDResources holderFormResources = new PDResources();
    holderFormResources.put(COSName.A, new PDExtendedGraphicsState());
    holderFormResources.add(new PDShadingPattern());

    // Act
    pdVisibleSigBuilder.createWidgetDictionary(signatureField, holderFormResources);

    // Assert
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertSame(cOSObject, pdVisibleSigBuilder.getStructure().getWidgetDictionary());
  }

  /**
   * Test {@link PDVisibleSigBuilder#closeTemplate(PDDocument)}.
   * <ul>
   *   <li>Then {@link PDDocument#PDDocument(StreamCacheCreateFunction)} with
   * {@link StreamCacheCreateFunction} Document Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDVisibleSigBuilder#closeTemplate(PDDocument)}
   */
  @Test
  @DisplayName("Test closeTemplate(PDDocument); then PDDocument(StreamCacheCreateFunction) with StreamCacheCreateFunction Document Closed")
  void testCloseTemplate_thenPDDocumentWithStreamCacheCreateFunctionDocumentClosed() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    pdVisibleSigBuilder.createTemplate(new PDPage());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.closeTemplate(template);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(template.getDocument().isClosed());
    assertTrue(pdVisibleSigBuilder.getStructure().getTemplate().getDocument().isClosed());
  }
}
