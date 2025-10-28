package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDSignatureField;
import org.junit.jupiter.api.Test;

class PDFTemplateStructureDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PDFTemplateStructure}
   *   <li>{@link PDFTemplateStructure#setAcroForm(PDAcroForm)}
   *   <li>{@link PDFTemplateStructure#setAcroFormDictionary(COSDictionary)}
   *   <li>{@link PDFTemplateStructure#setAcroFormFields(List)}
   *   <li>{@link PDFTemplateStructure#setAffineTransform(AffineTransform)}
   *   <li>
   * {@link PDFTemplateStructure#setAppearanceDictionary(PDAppearanceDictionary)}
   *   <li>{@link PDFTemplateStructure#setFormatterRectangle(PDRectangle)}
   *   <li>{@link PDFTemplateStructure#setHolderForm(PDFormXObject)}
   *   <li>{@link PDFTemplateStructure#setHolderFormResources(PDResources)}
   *   <li>{@link PDFTemplateStructure#setHolderFormStream(PDStream)}
   *   <li>{@link PDFTemplateStructure#setImage(PDImageXObject)}
   *   <li>{@link PDFTemplateStructure#setImageForm(PDFormXObject)}
   *   <li>{@link PDFTemplateStructure#setImageFormName(COSName)}
   *   <li>{@link PDFTemplateStructure#setImageFormResources(PDResources)}
   *   <li>{@link PDFTemplateStructure#setImageFormStream(PDStream)}
   *   <li>{@link PDFTemplateStructure#setImageName(COSName)}
   *   <li>{@link PDFTemplateStructure#setInnerForm(PDFormXObject)}
   *   <li>{@link PDFTemplateStructure#setInnerFormName(COSName)}
   *   <li>{@link PDFTemplateStructure#setInnerFormResources(PDResources)}
   *   <li>{@link PDFTemplateStructure#setInnterFormStream(PDStream)}
   *   <li>{@link PDFTemplateStructure#setPage(PDPage)}
   *   <li>{@link PDFTemplateStructure#setPdSignature(PDSignature)}
   *   <li>{@link PDFTemplateStructure#setProcSet(COSArray)}
   *   <li>{@link PDFTemplateStructure#setSignatureField(PDSignatureField)}
   *   <li>{@link PDFTemplateStructure#setSignatureRectangle(PDRectangle)}
   *   <li>{@link PDFTemplateStructure#setTemplate(PDDocument)}
   *   <li>{@link PDFTemplateStructure#setVisualSignature(COSDocument)}
   *   <li>{@link PDFTemplateStructure#setWidgetDictionary(COSDictionary)}
   *   <li>{@link PDFTemplateStructure#getAcroForm()}
   *   <li>{@link PDFTemplateStructure#getAcroFormDictionary()}
   *   <li>{@link PDFTemplateStructure#getAcroFormFields()}
   *   <li>{@link PDFTemplateStructure#getAffineTransform()}
   *   <li>{@link PDFTemplateStructure#getAppearanceDictionary()}
   *   <li>{@link PDFTemplateStructure#getFormatterRectangle()}
   *   <li>{@link PDFTemplateStructure#getHolderForm()}
   *   <li>{@link PDFTemplateStructure#getHolderFormResources()}
   *   <li>{@link PDFTemplateStructure#getHolderFormStream()}
   *   <li>{@link PDFTemplateStructure#getImage()}
   *   <li>{@link PDFTemplateStructure#getImageForm()}
   *   <li>{@link PDFTemplateStructure#getImageFormName()}
   *   <li>{@link PDFTemplateStructure#getImageFormResources()}
   *   <li>{@link PDFTemplateStructure#getImageFormStream()}
   *   <li>{@link PDFTemplateStructure#getImageName()}
   *   <li>{@link PDFTemplateStructure#getInnerForm()}
   *   <li>{@link PDFTemplateStructure#getInnerFormName()}
   *   <li>{@link PDFTemplateStructure#getInnerFormResources()}
   *   <li>{@link PDFTemplateStructure#getInnerFormStream()}
   *   <li>{@link PDFTemplateStructure#getPage()}
   *   <li>{@link PDFTemplateStructure#getPdSignature()}
   *   <li>{@link PDFTemplateStructure#getProcSet()}
   *   <li>{@link PDFTemplateStructure#getSignatureField()}
   *   <li>{@link PDFTemplateStructure#getSignatureRectangle()}
   *   <li>{@link PDFTemplateStructure#getTemplate()}
   *   <li>{@link PDFTemplateStructure#getVisualSignature()}
   *   <li>{@link PDFTemplateStructure#getWidgetDictionary()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PDFTemplateStructure actualPdfTemplateStructure = new PDFTemplateStructure();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    actualPdfTemplateStructure.setAcroForm(acroForm);
    COSDictionary acroFormDictionary = new COSDictionary();
    actualPdfTemplateStructure.setAcroFormDictionary(acroFormDictionary);
    ArrayList<PDField> acroFormFields = new ArrayList<>();
    actualPdfTemplateStructure.setAcroFormFields(acroFormFields);
    AffineTransform affineTransform = new AffineTransform();
    actualPdfTemplateStructure.setAffineTransform(affineTransform);
    PDAppearanceDictionary appearanceDictionary = new PDAppearanceDictionary();
    actualPdfTemplateStructure.setAppearanceDictionary(appearanceDictionary);
    actualPdfTemplateStructure.setFormatterRectangle(PDRectangle.A0);
    PDFormXObject holderForm = new PDFormXObject(new COSStream());
    actualPdfTemplateStructure.setHolderForm(holderForm);
    PDResources holderFormResources = new PDResources();
    actualPdfTemplateStructure.setHolderFormResources(holderFormResources);
    PDStream holderFormStream = new PDStream(new COSDocument());
    actualPdfTemplateStructure.setHolderFormStream(holderFormStream);
    PDImageXObject image = new PDImageXObject(new PDDocument());
    actualPdfTemplateStructure.setImage(image);
    PDFormXObject imageForm = new PDFormXObject(new COSStream());
    actualPdfTemplateStructure.setImageForm(imageForm);
    actualPdfTemplateStructure.setImageFormName(COSName.A);
    PDResources imageFormResources = new PDResources();
    actualPdfTemplateStructure.setImageFormResources(imageFormResources);
    PDStream imageFormStream = new PDStream(new COSDocument());
    actualPdfTemplateStructure.setImageFormStream(imageFormStream);
    actualPdfTemplateStructure.setImageName(COSName.A);
    PDFormXObject innerForm = new PDFormXObject(new COSStream());
    actualPdfTemplateStructure.setInnerForm(innerForm);
    actualPdfTemplateStructure.setInnerFormName(COSName.A);
    PDResources innerFormResources = new PDResources();
    actualPdfTemplateStructure.setInnerFormResources(innerFormResources);
    PDStream innerFormStream = new PDStream(new COSDocument());
    actualPdfTemplateStructure.setInnterFormStream(innerFormStream);
    PDPage page = new PDPage();
    actualPdfTemplateStructure.setPage(page);
    PDSignature pdSignature = new PDSignature();
    actualPdfTemplateStructure.setPdSignature(pdSignature);
    COSArray procSet = new COSArray();
    actualPdfTemplateStructure.setProcSet(procSet);
    PDSignatureField signatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));
    actualPdfTemplateStructure.setSignatureField(signatureField);
    actualPdfTemplateStructure.setSignatureRectangle(PDRectangle.A0);
    PDDocument template = new PDDocument();
    actualPdfTemplateStructure.setTemplate(template);
    COSDocument visualSignature = new COSDocument();
    actualPdfTemplateStructure.setVisualSignature(visualSignature);
    COSDictionary widgetDictionary = new COSDictionary();
    actualPdfTemplateStructure.setWidgetDictionary(widgetDictionary);
    PDAcroForm actualAcroForm = actualPdfTemplateStructure.getAcroForm();
    COSDictionary actualAcroFormDictionary = actualPdfTemplateStructure.getAcroFormDictionary();
    List<PDField> actualAcroFormFields = actualPdfTemplateStructure.getAcroFormFields();
    AffineTransform actualAffineTransform = actualPdfTemplateStructure.getAffineTransform();
    PDAppearanceDictionary actualAppearanceDictionary = actualPdfTemplateStructure.getAppearanceDictionary();
    PDRectangle actualFormatterRectangle = actualPdfTemplateStructure.getFormatterRectangle();
    PDFormXObject actualHolderForm = actualPdfTemplateStructure.getHolderForm();
    PDResources actualHolderFormResources = actualPdfTemplateStructure.getHolderFormResources();
    PDStream actualHolderFormStream = actualPdfTemplateStructure.getHolderFormStream();
    PDImageXObject actualImage = actualPdfTemplateStructure.getImage();
    PDFormXObject actualImageForm = actualPdfTemplateStructure.getImageForm();
    COSName actualImageFormName = actualPdfTemplateStructure.getImageFormName();
    PDResources actualImageFormResources = actualPdfTemplateStructure.getImageFormResources();
    PDStream actualImageFormStream = actualPdfTemplateStructure.getImageFormStream();
    COSName actualImageName = actualPdfTemplateStructure.getImageName();
    PDFormXObject actualInnerForm = actualPdfTemplateStructure.getInnerForm();
    COSName actualInnerFormName = actualPdfTemplateStructure.getInnerFormName();
    PDResources actualInnerFormResources = actualPdfTemplateStructure.getInnerFormResources();
    PDStream actualInnerFormStream = actualPdfTemplateStructure.getInnerFormStream();
    PDPage actualPage = actualPdfTemplateStructure.getPage();
    PDSignature actualPdSignature = actualPdfTemplateStructure.getPdSignature();
    COSArray actualProcSet = actualPdfTemplateStructure.getProcSet();
    PDSignatureField actualSignatureField = actualPdfTemplateStructure.getSignatureField();
    PDRectangle actualSignatureRectangle = actualPdfTemplateStructure.getSignatureRectangle();
    PDDocument actualTemplate = actualPdfTemplateStructure.getTemplate();
    COSDocument actualVisualSignature = actualPdfTemplateStructure.getVisualSignature();
    COSDictionary actualWidgetDictionary = actualPdfTemplateStructure.getWidgetDictionary();

    // Assert that nothing has changed
    assertTrue(actualAcroFormFields.isEmpty());
    assertSame(affineTransform, actualAffineTransform);
    assertSame(acroFormFields, actualAcroFormFields);
    assertSame(procSet, actualProcSet);
    assertSame(acroFormDictionary, actualAcroFormDictionary);
    assertSame(widgetDictionary, actualWidgetDictionary);
    assertSame(visualSignature, actualVisualSignature);
    assertSame(template, actualTemplate);
    assertSame(page, actualPage);
    assertSame(holderFormResources, actualHolderFormResources);
    assertSame(imageFormResources, actualImageFormResources);
    assertSame(innerFormResources, actualInnerFormResources);
    assertSame(holderFormStream, actualHolderFormStream);
    assertSame(imageFormStream, actualImageFormStream);
    assertSame(innerFormStream, actualInnerFormStream);
    assertSame(holderForm, actualHolderForm);
    assertSame(imageForm, actualImageForm);
    assertSame(innerForm, actualInnerForm);
    assertSame(image, actualImage);
    assertSame(appearanceDictionary, actualAppearanceDictionary);
    assertSame(pdSignature, actualPdSignature);
    assertSame(acroForm, actualAcroForm);
    assertSame(signatureField, actualSignatureField);
    COSName cosName = actualInnerFormName.A;
    assertSame(cosName, actualImageFormName);
    assertSame(cosName, actualImageName);
    assertSame(cosName, actualInnerFormName);
    PDRectangle pdRectangle = actualSignatureRectangle.A0;
    assertSame(pdRectangle, actualFormatterRectangle);
    assertSame(pdRectangle, actualSignatureRectangle);
  }
}
