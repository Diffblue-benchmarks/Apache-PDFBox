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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFileAttachment;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationFreeText;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationHighlight;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDVisibleSigBuilderDiffblueTest {
  /**
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  void testCreateAcroForm() {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDDocument template = new PDDocument();

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    PDAcroForm acroForm = template.getDocumentCatalog().getAcroForm();
    PDResources defaultResources = acroForm.getDefaultResources();
    Iterable<COSName> colorSpaceNames = defaultResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = defaultResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("/Helv 0 Tf 0 g ", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm2.getDefaultAppearance());
    COSDictionary cOSObject = defaultResources.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(acroForm.getXFA());
    assertNull(acroForm2.getXFA());
    assertNull(acroForm.getScriptingHandler());
    assertNull(acroForm2.getScriptingHandler());
    assertEquals(0, acroForm.getQ());
    assertEquals(0, acroForm2.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(4, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult2.getObjects().size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm2.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertFalse(acroForm2.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(acroForm.getNeedAppearances());
    assertFalse(acroForm2.getNeedAppearances());
    assertFalse(acroForm.isAppendOnly());
    assertFalse(acroForm2.isAppendOnly());
    assertFalse(acroForm.isCachingFields());
    assertFalse(acroForm2.isCachingFields());
    assertFalse(acroForm.isSignaturesExist());
    assertFalse(acroForm2.isSignaturesExist());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult2.iterator();
    assertTrue(iteratorResult2.hasNext());
    List<PDField> calcOrder = acroForm.getCalcOrder();
    assertTrue(calcOrder.isEmpty());
    assertTrue(acroForm.getFields().isEmpty());
    assertTrue(acroForm2.getFields().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject.getUpdateState().isUpdated());
    assertTrue(cOSObject2.getUpdateState().isUpdated());
    assertSame(cOSObject, iteratorResult.next());
    PDResources defaultResources2 = acroForm2.getDefaultResources();
    assertSame(cOSObject, defaultResources2.getCOSObject());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, acroForm2.getCOSObject());
    assertSame(calcOrder, acroForm2.getCalcOrder());
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
    assertSame(fontNames, defaultResources2.getFontNames());
  }

  /**
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  void testCreateAcroForm2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAcroForm acroForm = template.getDocumentCatalog().getAcroForm();
    PDResources defaultResources = acroForm.getDefaultResources();
    Iterable<COSName> colorSpaceNames = defaultResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = defaultResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("/Helv 0 Tf 0 g ", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm2.getDefaultAppearance());
    COSDictionary cOSObject = defaultResources.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(acroForm.getXFA());
    assertNull(acroForm2.getXFA());
    assertNull(acroForm.getScriptingHandler());
    assertNull(acroForm2.getScriptingHandler());
    assertEquals(0, acroForm.getQ());
    assertEquals(0, acroForm2.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(4, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult2.getObjects().size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm2.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertFalse(acroForm2.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(acroForm.getNeedAppearances());
    assertFalse(acroForm2.getNeedAppearances());
    assertFalse(acroForm.isAppendOnly());
    assertFalse(acroForm2.isAppendOnly());
    assertFalse(acroForm.isCachingFields());
    assertFalse(acroForm2.isCachingFields());
    assertFalse(acroForm.isSignaturesExist());
    assertFalse(acroForm2.isSignaturesExist());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult2.iterator();
    assertTrue(iteratorResult2.hasNext());
    List<PDField> calcOrder = acroForm.getCalcOrder();
    assertTrue(calcOrder.isEmpty());
    assertTrue(acroForm.getFields().isEmpty());
    assertTrue(acroForm2.getFields().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject.getUpdateState().isUpdated());
    assertTrue(cOSObject2.getUpdateState().isUpdated());
    assertSame(cOSObject, iteratorResult.next());
    PDResources defaultResources2 = acroForm2.getDefaultResources();
    assertSame(cOSObject, defaultResources2.getCOSObject());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, acroForm2.getCOSObject());
    assertSame(calcOrder, acroForm2.getCalcOrder());
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
    assertSame(fontNames, defaultResources2.getFontNames());
  }

  /**
   * Method under test: {@link PDVisibleSigBuilder#createAcroForm(PDDocument)}
   */
  @Test
  void testCreateAcroForm3() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument template = new PDDocument(streamCacheCreateFunction);
    template.addPage(new PDPage());

    // Act
    pdVisibleSigBuilder.createAcroForm(template);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDAcroForm acroForm = template.getDocumentCatalog().getAcroForm();
    PDResources defaultResources = acroForm.getDefaultResources();
    Iterable<COSName> colorSpaceNames = defaultResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    Iterable<COSName> fontNames = defaultResources.getFontNames();
    assertTrue(fontNames instanceof Set);
    assertEquals("/Helv 0 Tf 0 g ", acroForm.getDefaultAppearance());
    PDAcroForm acroForm2 = pdVisibleSigBuilder.getStructure().getAcroForm();
    assertEquals("/Helv 0 Tf 0 g ", acroForm2.getDefaultAppearance());
    COSDictionary cOSObject = defaultResources.getCOSObject();
    assertNull(cOSObject.getKey());
    COSDictionary cOSObject2 = acroForm.getCOSObject();
    assertNull(cOSObject2.getKey());
    assertNull(acroForm.getXFA());
    assertNull(acroForm2.getXFA());
    assertNull(acroForm.getScriptingHandler());
    assertNull(acroForm2.getScriptingHandler());
    assertEquals(0, acroForm.getQ());
    assertEquals(0, acroForm2.getQ());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(2, ((Set<COSName>) fontNames).size());
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(4, toIncrementResult.getObjects().size());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertEquals(5, toIncrementResult2.getObjects().size());
    assertFalse(acroForm.getFieldIterator().hasNext());
    assertFalse(acroForm2.getFieldIterator().hasNext());
    assertFalse(acroForm.getFieldTree().iterator().hasNext());
    assertFalse(acroForm2.getFieldTree().iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject2.isDirect());
    assertFalse(acroForm.getNeedAppearances());
    assertFalse(acroForm2.getNeedAppearances());
    assertFalse(acroForm.isAppendOnly());
    assertFalse(acroForm2.isAppendOnly());
    assertFalse(acroForm.isCachingFields());
    assertFalse(acroForm2.isCachingFields());
    assertFalse(acroForm.isSignaturesExist());
    assertFalse(acroForm2.isSignaturesExist());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    assertTrue(iteratorResult.hasNext());
    Iterator<COSBase> iteratorResult2 = toIncrementResult2.iterator();
    assertTrue(iteratorResult2.hasNext());
    List<PDField> calcOrder = acroForm.getCalcOrder();
    assertTrue(calcOrder.isEmpty());
    assertTrue(acroForm.getFields().isEmpty());
    assertTrue(acroForm2.getFields().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertTrue(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject2.isNeedToBeUpdated());
    assertTrue(cOSObject.getUpdateState().isUpdated());
    assertTrue(cOSObject2.getUpdateState().isUpdated());
    assertSame(cOSObject, iteratorResult.next());
    PDResources defaultResources2 = acroForm2.getDefaultResources();
    assertSame(cOSObject, defaultResources2.getCOSObject());
    assertSame(cOSObject2, iteratorResult2.next());
    assertSame(cOSObject2, acroForm2.getCOSObject());
    assertSame(calcOrder, acroForm2.getCalcOrder());
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
    assertSame(fontNames, defaultResources2.getFontNames());
  }

  /**
   * Method under test: {@link PDVisibleSigBuilder#getStructure()}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));
    PDPage page = new PDPage();

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertEquals(widgets, page.getAnnotations());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));
    PDPage page = new PDPage();

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "");

    // Assert
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertNull(pdSignature.getContactInfo());
    PDSignature signature = pdSignatureField.getSignature();
    assertNull(signature.getContactInfo());
    PDSignature value = pdSignatureField.getValue();
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getName());
    assertNull(signature.getName());
    assertNull(value.getName());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    assertEquals(1, cOSObject.getValues().size());
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(1, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertEquals(widgets, page.getAnnotations());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature3() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));
    PDPage page = new PDPage();

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertEquals(widgets, page.getAnnotations());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature4() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    PDPage page = new PDPage();
    page.setAnnotations(new ArrayList<>());

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertEquals(widgets, page.getAnnotations());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature5() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature6() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCaret(new COSDictionary()));

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature7() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationCircle());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature8() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFileAttachment());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature9() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationFreeText());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignature(PDSignatureField, PDPage, String)}
   */
  @Test
  void testCreateSignature10() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    ArrayList<PDAnnotation> annotations = new ArrayList<>();
    annotations.add(new PDAnnotationHighlight());

    PDPage page = new PDPage();
    page.setAnnotations(annotations);

    // Act
    pdVisibleSigBuilder.createSignature(pdSignatureField, page, "Signer Name");

    // Assert
    verify(streamCacheCreateFunction).create();
    PDSignature pdSignature = pdVisibleSigBuilder.getStructure().getPdSignature();
    assertEquals("Signer Name", pdSignature.getName());
    PDSignature signature = pdSignatureField.getSignature();
    assertEquals("Signer Name", signature.getName());
    PDSignature value = pdSignatureField.getValue();
    assertEquals("Signer Name", value.getName());
    assertNull(pdSignature.getContactInfo());
    assertNull(signature.getContactInfo());
    assertNull(value.getContactInfo());
    assertNull(pdSignature.getFilter());
    assertNull(signature.getFilter());
    assertNull(value.getFilter());
    assertNull(pdSignature.getLocation());
    assertNull(signature.getLocation());
    assertNull(value.getLocation());
    assertNull(pdSignature.getReason());
    assertNull(signature.getReason());
    assertNull(value.getReason());
    assertNull(pdSignature.getSubFilter());
    assertNull(signature.getSubFilter());
    assertNull(value.getSubFilter());
    assertNull(pdSignature.getSignDate());
    assertNull(signature.getSignDate());
    assertNull(value.getSignDate());
    COSDictionary cOSObject = signature.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(pdSignature.getPropBuild());
    assertNull(signature.getPropBuild());
    assertNull(value.getPropBuild());
    assertEquals(0, pdSignature.getByteRange().length);
    assertEquals(0, signature.getByteRange().length);
    assertEquals(0, value.getByteRange().length);
    assertEquals(0, pdSignature.getContents().length);
    assertEquals(0, signature.getContents().length);
    assertEquals(0, value.getContents().length);
    List<PDAnnotationWidget> widgets = pdSignatureField.getWidgets();
    assertEquals(1, widgets.size());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSDictionary cOSObject2 = pdSignatureField.getCOSObject();
    assertEquals(7, cOSObject2.getValues().size());
    assertEquals(7, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(page, widgets.get(0).getPage());
    assertSame(cOSObject, pdSignature.getCOSObject());
    assertSame(cOSObject, value.getCOSObject());
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createAffineTransform(AffineTransform)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage2() throws IOException {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage3() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage4() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage5() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage6() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 2));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage7() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 3));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage8() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 4));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage9() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 5));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage10() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 6));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage11() throws IOException {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage12() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template,
        new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, BufferedImage.TYPE_BYTE_GRAY, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createSignatureImage(PDDocument, BufferedImage)}
   */
  @Test
  void testCreateSignatureImage13() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument template = new PDDocument(streamCacheCreateFunction);

    // Act
    pdVisibleSigBuilder.createSignatureImage(template, new BufferedImage(1, 1, 8));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createFormatterRectangle(int[])}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createHolderFormStream(PDDocument)}
   */
  @Test
  void testCreateHolderFormStream2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdVisibleSigBuilder.createHolderFormStream(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDVisibleSigBuilder#createHolderFormResources()}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createHolderForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  void testCreateHolderForm() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources holderFormResources = new PDResources();
    PDStream holderFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createHolderForm(holderFormResources, holderFormStream, null);

    // Assert
    PDFormXObject holderForm = pdVisibleSigBuilder.getStructure().getHolderForm();
    PDStream contentStream = holderForm.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(holderForm.getResources().getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(holderForm.getBBox());
    assertNull(contentStream.getFile());
    assertNull(holderForm.getOptionalContent());
    assertNull(holderForm.getGroup());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, holderForm.getStructParents());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = holderForm.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, holderForm.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = holderFormStream.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(holderFormStream, holderForm.getStream());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, holderForm.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  void testCreateAppearanceDictionary2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    COSStream stream = new COSStream();
    PDFormXObject holderForml = new PDFormXObject(stream);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdVisibleSigBuilder.createAppearanceDictionary(holderForml, signatureField);

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createAppearanceDictionary(PDFormXObject, PDSignatureField)}
   */
  @Test
  void testCreateAppearanceDictionary3() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDFormXObject holderForml = new PDFormXObject(stream);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdVisibleSigBuilder.createAppearanceDictionary(holderForml, signatureField);

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createInnerFormStream(PDDocument)}
   */
  @Test
  void testCreateInnerFormStream2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdVisibleSigBuilder.createInnerFormStream(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDVisibleSigBuilder#createInnerFormResource()}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createInnerForm(PDResources, PDStream, PDRectangle)}
   */
  @Test
  void testCreateInnerForm() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources innerFormResources = new PDResources();
    PDStream innerFormStream = new PDStream(new COSDocument());

    // Act
    pdVisibleSigBuilder.createInnerForm(innerFormResources, innerFormStream, null);

    // Assert
    PDFormXObject innerForm = pdVisibleSigBuilder.getStructure().getInnerForm();
    PDStream contentStream = innerForm.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(innerForm.getResources().getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(innerForm.getBBox());
    assertNull(contentStream.getFile());
    assertNull(innerForm.getOptionalContent());
    assertNull(innerForm.getGroup());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, innerForm.getStructParents());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = innerForm.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    assertEquals(1, innerForm.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSStream cOSObject = innerFormStream.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(innerFormStream, innerForm.getStream());
    assertSame(cOSObject, contentStream.getCOSObject());
    assertSame(cOSObject, innerForm.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageFormStream(PDDocument)}
   */
  @Test
  void testCreateImageFormStream2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdVisibleSigBuilder.createImageFormStream(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
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
   * Method under test: {@link PDVisibleSigBuilder#createImageFormResources()}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createImageForm(PDResources, PDResources, PDStream, PDRectangle, AffineTransform, PDImageXObject)}
   */
  @Test
  void testCreateImageForm() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    PDResources imageFormResources = new PDResources();
    PDResources innerFormResource = new PDResources();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDStream imageFormStream = new PDStream(new COSDocument(streamCacheCreateFunction));
    AffineTransform at = new AffineTransform();

    // Act
    pdVisibleSigBuilder.createImageForm(imageFormResources, innerFormResource, imageFormStream, null, at,
        new PDImageXObject(new PDDocument()));

    // Assert
    verify(streamCacheCreateFunction).create();
    Iterable<COSName> xObjectNames = imageFormResources.getXObjectNames();
    assertTrue(xObjectNames instanceof Set);
    PDFTemplateStructure structure = pdVisibleSigBuilder.getStructure();
    COSName imageName = structure.getImageName();
    assertEquals("img1", imageName.getName());
    COSName imageFormName = structure.getImageFormName();
    assertEquals("n2", imageFormName.getName());
    PDFormXObject imageForm = structure.getImageForm();
    PDStream contentStream = imageForm.getContentStream();
    assertNull(contentStream.getDecodeParms());
    assertNull(contentStream.getFileDecodeParams());
    assertNull(imageFormName.getKey());
    assertNull(imageName.getKey());
    PDResources resources = imageForm.getResources();
    assertNull(resources.getResourceCache());
    assertNull(contentStream.getMetadata());
    assertNull(imageForm.getBBox());
    assertNull(contentStream.getFile());
    assertNull(imageForm.getOptionalContent());
    assertNull(imageForm.getGroup());
    assertEquals(-1, contentStream.getDecodedStreamLength());
    assertEquals(-1, imageForm.getStructParents());
    assertEquals(0, contentStream.getLength());
    Matrix matrix = imageForm.getMatrix();
    assertEquals(0.0f, matrix.getShearX());
    assertEquals(0.0f, matrix.getShearY());
    assertEquals(0.0f, matrix.getTranslateX());
    assertEquals(0.0f, matrix.getTranslateY());
    COSDictionary cOSObject = imageFormResources.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, ((Set<COSName>) xObjectNames).size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, imageForm.getFormType());
    assertEquals(1.0f, matrix.getScaleX());
    assertEquals(1.0f, matrix.getScaleY());
    assertEquals(1.0f, matrix.getScalingFactorX());
    assertEquals(1.0f, matrix.getScalingFactorY());
    float[][] values = matrix.getValues();
    assertEquals(3, values.length);
    COSStream cOSObject2 = imageFormStream.getCOSObject();
    assertEquals(6, cOSObject2.getValues().size());
    assertEquals(6, cOSObject2.size());
    COSIncrement toIncrementResult = cOSObject2.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(imageFormName.isDirect());
    assertFalse(imageName.isDirect());
    assertFalse(imageFormName.isEmpty());
    assertFalse(imageName.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(cOSObject.isDirect());
    assertSame(imageFormStream, imageForm.getStream());
    assertSame(cOSObject, resources.getCOSObject());
    assertSame(cOSObject2, contentStream.getCOSObject());
    assertSame(cOSObject2, imageForm.getCOSObject());
    assertSame(xObjectNames, resources.getXObjectNames());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createBackgroundLayerForm(PDResources, PDRectangle)}
   */
  @Test
  void testCreateBackgroundLayerForm() throws IOException {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray2() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray3() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray4() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray5() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#injectProcSetArray(PDFormXObject, PDPage, PDResources, PDResources, PDResources, COSArray)}
   */
  @Test
  void testInjectProcSetArray6() {
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
   * Method under test:
   * {@link PDVisibleSigBuilder#appendRawCommands(OutputStream, String)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createVisualSignature(PDDocument)}
   */
  @Test
  void testCreateVisualSignature() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdVisibleSigBuilder.createVisualSignature(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
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
   * Method under test:
   * {@link PDVisibleSigBuilder#createWidgetDictionary(PDSignatureField, PDResources)}
   */
  @Test
  void testCreateWidgetDictionary2() throws IOException {
    // Arrange
    PDVisibleSigBuilder pdVisibleSigBuilder = new PDVisibleSigBuilder();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument(streamCacheCreateFunction)));

    // Act
    pdVisibleSigBuilder.createWidgetDictionary(signatureField, new PDResources());

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = signatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertSame(cOSObject, pdVisibleSigBuilder.getStructure().getWidgetDictionary());
  }

  /**
   * Method under test: {@link PDVisibleSigBuilder#closeTemplate(PDDocument)}
   */
  @Test
  void testCloseTemplate() throws IOException {
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

  /**
   * Method under test: default or parameterless constructor of
   * {@link PDVisibleSigBuilder}
   */
  @Test
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
}
