package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDNonTerminalFieldDiffblueTest {
  /**
   * Test
   * {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDNonTerminalField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  void testNewPDNonTerminalField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDNonTerminalField actualPdNonTerminalField = new PDNonTerminalField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdNonTerminalField.getCOSObject());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
    assertSame(parent, actualPdNonTerminalField.getParent());
  }

  /**
   * Test {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDNonTerminalField(PDAcroForm)")
  void testNewPDNonTerminalField2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDNonTerminalField actualPdNonTerminalField = new PDNonTerminalField(acroForm);

    // Assert
    assertEquals("", actualPdNonTerminalField.getValueAsString());
    assertNull(actualPdNonTerminalField.getAlternateFieldName());
    assertNull(actualPdNonTerminalField.getFullyQualifiedName());
    assertNull(actualPdNonTerminalField.getMappingName());
    assertNull(actualPdNonTerminalField.getPartialName());
    assertNull(actualPdNonTerminalField.getFieldType());
    assertNull(actualPdNonTerminalField.getDefaultValue());
    assertNull(actualPdNonTerminalField.getValue());
    COSDictionary cOSObject = actualPdNonTerminalField.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualPdNonTerminalField.getActions());
    assertNull(actualPdNonTerminalField.getParent());
    assertEquals(0, cOSObject.size());
    assertEquals(0, actualPdNonTerminalField.getFieldFlags());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdNonTerminalField.isNoExport());
    assertFalse(actualPdNonTerminalField.isReadOnly());
    assertFalse(actualPdNonTerminalField.isRequired());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdNonTerminalField.getChildren().isEmpty());
    assertTrue(actualPdNonTerminalField.getWidgets().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getFieldFlags());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldFlags()}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); then return one")
  void testGetFieldFlags_thenReturnOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertEquals(1, pdNonTerminalField.getFieldFlags());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue("Value");

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("COSString{Value}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF2() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    COSArray cosArray = new COSArray();
    fdfField.setValue((Object) cosArray);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("COSArray{[]}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(cosArray, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF3() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    COSStream cosStream = new COSStream();
    fdfField.setValue((Object) cosStream);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("COSDictionary{Create InputStream called without data being written before to stream.}",
        pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(cosStream, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  void testImportFDF4() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setValue(COSName.A);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("COSName{A}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.</li>
   *   <li>When {@link FDFField#FDFField()} Kids is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given ArrayList() add FDFField(); when FDFField() Kids is ArrayList()")
  void testImportFDF_givenArrayListAddFDFField_whenFDFFieldKidsIsArrayList() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    FDFField fdfField = new FDFField();
    fdfField.setKids(kids);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>When {@link FDFField#FDFField()} Kids is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given ArrayList(); when FDFField() Kids is ArrayList()")
  void testImportFDF_givenArrayList_whenFDFFieldKidsIsArrayList() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setKids(new ArrayList<>());

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testImportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act
    pdNonTerminalField.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField()")
  void testImportFDF_whenFDFField() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.importFDF(new FDFField());

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} ClearFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() ClearFieldFlags is one")
  void testImportFDF_whenFDFFieldClearFieldFlagsIsOne() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setClearFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} FieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() FieldFlags is one")
  void testImportFDF_whenFDFFieldFieldFlagsIsOne() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdNonTerminalField.getFieldFlags());
    assertTrue(pdNonTerminalField.isReadOnly());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  void testImportFDF_whenFDFFieldSetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setSetFieldFlags((Integer) 1);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(1, pdNonTerminalField.getFieldFlags());
    assertTrue(pdNonTerminalField.isReadOnly());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when IIOMetadataNode(String) with 'foo'")
  void testImportFDF_whenIIOMetadataNodeWithFoo() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.importFDF(new FDFField(new IIOMetadataNode("foo")));

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testExportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange and Act
    FDFField actualExportFDFResult = (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).exportFDF();

    // Assert
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testExportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act
    FDFField actualExportFDFResult = pdNonTerminalField.exportFDF();

    // Assert
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   * <ul>
   *   <li>Then return PartialFieldName is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is empty string")
  void testExportFDF_thenReturnPartialFieldNameIsEmptyString() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setPartialName("");

    // Act
    FDFField actualExportFDFResult = pdNonTerminalField.exportFDF();

    // Assert
    assertEquals("", actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   * <ul>
   *   <li>Then return PartialFieldName is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'Name'")
  void testExportFDF_thenReturnPartialFieldNameIsName() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setPartialName("Name");

    // Act
    FDFField actualExportFDFResult = pdNonTerminalField.exportFDF();

    // Assert
    assertEquals("Name", actualExportFDFResult.getPartialFieldName());
    assertNull(actualExportFDFResult.getClearFieldFlags());
    assertNull(actualExportFDFResult.getClearWidgetFieldFlags());
    assertNull(actualExportFDFResult.getFieldFlags());
    assertNull(actualExportFDFResult.getSetFieldFlags());
    assertNull(actualExportFDFResult.getSetWidgetFieldFlags());
    assertNull(actualExportFDFResult.getWidgetFieldFlags());
    assertNull(actualExportFDFResult.getValue());
    assertNull(actualExportFDFResult.getRichText());
    assertNull(actualExportFDFResult.getOptions());
    assertNull(actualExportFDFResult.getCOSValue());
    COSDictionary cOSObject = actualExportFDFResult.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#getChildren()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testGetChildren_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertTrue(pdNonTerminalField.getChildren().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#getChildren()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return Empty")
  void testGetChildren_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getChildren().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); given 'null'; when ArrayList() add 'null'")
  void testSetChildren_givenNull_whenArrayListAddNull() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    ArrayList<PDField> children = new ArrayList<>();
    children.add(null);

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdNonTerminalField.getChildren().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   * <ul>
   *   <li>Then {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Children size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); then PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Children size is one")
  void testSetChildren_thenPDNonTerminalFieldWithAcroFormIsPDAcroFormChildrenSizeIsOne() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(acroForm);

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(1, children2.size());
    PDField getResult = children2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", getResult.getValueAsString());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(getResult.getMappingName());
    assertNull(getResult.getPartialName());
    assertNull(getResult.getActions());
    assertEquals(0, getResult.getFieldFlags());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isRequired());
    assertSame(acroForm, getResult.getAcroForm());
    assertSame(pdNonTerminalField, getResult.getParent());
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   * <ul>
   *   <li>Then {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} Children size is
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); then PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Children size is two")
  void testSetChildren_thenPDNonTerminalFieldWithAcroFormIsPDAcroFormChildrenSizeIsTwo() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(acroForm);

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(2, children2.size());
    PDField getResult = children2.get(1);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) getResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) getResult).getOnValue());
    assertEquals("Btn", getResult.getFieldType());
    assertEquals("Off", ((PDCheckBox) getResult).getValue());
    assertEquals("Off", getResult.getValueAsString());
    assertNull(getResult.getAlternateFieldName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(getResult.getMappingName());
    assertNull(getResult.getPartialName());
    assertNull(getResult.getActions());
    assertEquals(0, getResult.getFieldFlags());
    assertEquals(1, getResult.getWidgets().size());
    assertFalse(((PDCheckBox) getResult).isPushButton());
    assertFalse(((PDCheckBox) getResult).isRadioButton());
    assertFalse(getResult.isNoExport());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isRequired());
    assertSame(acroForm, getResult.getAcroForm());
    assertSame(pdNonTerminalField, getResult.getParent());
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); when ArrayList()")
  void testSetChildren_whenArrayList() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setChildren(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdNonTerminalField.getChildren().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldType()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testGetFieldType_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertNull(pdNonTerminalField.getFieldType());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldType()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetFieldType_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getFieldType());
  }

  /**
   * Test {@link PDNonTerminalField#getValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertNull(pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#getValue()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  void testGetValue_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Test {@link PDNonTerminalField#getValueAsString()}.
   * <p>
   * Method under test: {@link PDNonTerminalField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  void testGetValueAsString() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertEquals("", pdNonTerminalField.getValueAsString());
  }

  /**
   * Test {@link PDNonTerminalField#getValueAsString()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return empty string")
  void testGetValueAsString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  void testSetValueWithObject() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSBoolean object = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, pdNonTerminalField.getValueAsString());
    COSBoolean expectedValue = object.FALSE;
    assertSame(expectedValue, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  void testSetValueWithObject2() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSArray object = new COSArray();

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    assertEquals("COSArray{[]}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  void testSetValueWithObject3() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue((COSBase) null);

    // Assert
    assertEquals("", pdNonTerminalField.getValueAsString());
    assertNull(pdNonTerminalField.getValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'; given COSObjectKey(long, int) with num is one and gen is one")
  void testSetValueWithObject_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    COSDictionary object = new COSDictionary();
    object.setKey(new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    assertEquals("COSDictionary{}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'; when COSDictionary()")
  void testSetValueWithObject_whenCOSDictionary() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSDictionary object = new COSDictionary();

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    assertEquals("COSDictionary{}", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(object, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'; when COSObjectKey(long, int) with num is one and gen is one")
  void testSetValueWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    String expectedValueAsString = Boolean.FALSE.toString();
    assertEquals(expectedValueAsString, pdNonTerminalField.getValueAsString());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(String)} with {@code value}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  void testSetValueWithValue() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue("42");

    // Assert
    COSBase value = pdNonTerminalField.getValue();
    assertTrue(value instanceof COSString);
    assertEquals("3432", ((COSString) value).toHexString());
    assertEquals("42", ((COSString) value).getASCII());
    assertEquals("42", ((COSString) value).getString());
    assertEquals("COSString{42}", pdNonTerminalField.getValueAsString());
    assertNull(value.getKey());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(value.isDirect());
    assertFalse(((COSString) value).getForceHexForm());
    assertArrayEquals(new byte[]{'4', '2'}, ((COSString) value).getBytes());
  }

  /**
   * Test {@link PDNonTerminalField#getDefaultValue()}.
   * <p>
   * Method under test: {@link PDNonTerminalField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue()")
  void testGetDefaultValue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertNull(pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#getDefaultValue()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); then return 'null'")
  void testGetDefaultValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  void testSetDefaultValue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSBoolean value = COSBoolean.FALSE;

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSBoolean expectedDefaultValue = value.FALSE;
    assertSame(expectedDefaultValue, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  void testSetDefaultValue2() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSArray value = new COSArray();

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  void testSetDefaultValue3() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setDefaultValue(null);

    // Assert
    assertNull(pdNonTerminalField.getDefaultValue());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetDefaultValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase); when COSDictionary()")
  void testSetDefaultValue_whenCOSDictionary() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSDictionary value = new COSDictionary();

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetDefaultValue_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setDefaultValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#getWidgets()}.
   * <p>
   * Method under test: {@link PDNonTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets()")
  void testGetWidgets() {
    // Arrange, Act and Assert
    assertTrue((new PDNonTerminalField(new PDAcroForm(new PDDocument()))).getWidgets().isEmpty());
  }
}
