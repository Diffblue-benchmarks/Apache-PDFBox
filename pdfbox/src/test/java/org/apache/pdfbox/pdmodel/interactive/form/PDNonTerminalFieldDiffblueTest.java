package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDNonTerminalFieldDiffblueTest {
  /**
   * Test {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}.
   *
   * <p>Method under test: {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm, COSDictionary,
   * PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDNonTerminalField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDNonTerminalField.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"
  })
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
   *
   * <p>Method under test: {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDNonTerminalField(PDAcroForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.<init>(PDAcroForm)"})
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
    assertNull(actualPdNonTerminalField.getActions());
    assertNull(actualPdNonTerminalField.getParent());
    assertEquals(0, actualPdNonTerminalField.getFieldFlags());
    assertFalse(actualPdNonTerminalField.isNoExport());
    assertFalse(actualPdNonTerminalField.isReadOnly());
    assertFalse(actualPdNonTerminalField.isRequired());
    assertTrue(actualPdNonTerminalField.getChildren().isEmpty());
    assertTrue(actualPdNonTerminalField.getWidgets().isEmpty());
    assertSame(acroForm, actualPdNonTerminalField.getAcroForm());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldFlags()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName(
      "Test getFieldFlags(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDNonTerminalField.getFieldFlags()"})
  void testGetFieldFlags_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDNonTerminalField(new PDAcroForm(new PDDocument())).getFieldFlags());
  }

  /**
   * Test {@link PDNonTerminalField#getFieldFlags()}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getFieldFlags()}
   */
  @Test
  @DisplayName("Test getFieldFlags(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDNonTerminalField.getFieldFlags()"})
  void testGetFieldFlags_thenReturnOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    pdNonTerminalField.setReadOnly(true);

    // Act and Assert
    assertEquals(1, pdNonTerminalField.getFieldFlags());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF2() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FDFField#FDFField()}.
   *   <li>When {@link FDFField#FDFField()} Kids is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given ArrayList() add FDFField(); when FDFField() Kids is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenArrayListAddFDFField_whenFDFFieldKidsIsArrayList() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    ArrayList<FDFField> kids = new ArrayList<>();
    kids.add(new FDFField());

    FDFField fdfField = new FDFField();
    fdfField.setKids(kids);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link FDFField#FDFField()} Kids is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given ArrayList(); when FDFField() Kids is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenArrayList_whenFDFFieldKidsIsArrayList() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    fdfField.setKids(new ArrayList<>());

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); given COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenCOSStream() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    FDFField fdfField = new FDFField();
    COSStream cosStream = new COSStream();
    fdfField.setValue((Object) cosStream);

    // Act
    pdNonTerminalField.importFDF(fdfField);

    // Assert
    assertEquals(
        "COSDictionary{Create InputStream called without data being written before to stream.}",
        pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(cosStream, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#importFDF(FDFField)}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} ReadOnly is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) ReadOnly is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroFormReadOnlyIsTrue()
      throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
   *
   * <ul>
   *   <li>Then {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName(
      "Test importFDF(FDFField); then PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Value is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_thenPDNonTerminalFieldWithAcroFormIsPDAcroFormValueIsNull()
      throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_whenFDFField() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} FieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() FieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldFieldFlagsIsOne() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>When {@link FDFField#FDFField()} SetFieldFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#importFDF(FDFField)}
   */
  @Test
  @DisplayName("Test importFDF(FDFField); when FDFField() SetFieldFlags is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.importFDF(FDFField)"})
  void testImportFDF_whenFDFFieldSetFieldFlagsIsOne() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   * Test {@link PDNonTerminalField#exportFDF()}.
   *
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName(
      "Test exportFDF(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFField PDNonTerminalField.exportFDF()"})
  void testExportFDF_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() throws IOException {
    // Arrange and Act
    FDFField actualExportFDFResult =
        new PDNonTerminalField(new PDAcroForm(new PDDocument())).exportFDF();

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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   *
   * <ul>
   *   <li>Then return PartialFieldName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFField PDNonTerminalField.exportFDF()"})
  void testExportFDF_thenReturnPartialFieldNameIsEmptyString() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#exportFDF()}.
   *
   * <ul>
   *   <li>Then return PartialFieldName is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#exportFDF()}
   */
  @Test
  @DisplayName("Test exportFDF(); then return PartialFieldName is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFField PDNonTerminalField.exportFDF()"})
  void testExportFDF_thenReturnPartialFieldNameIsName() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
    assertNull(actualExportFDFResult.getIconFit());
    assertNull(actualExportFDFResult.getAppearanceStreamReference());
    assertNull(actualExportFDFResult.getAction());
    assertNull(actualExportFDFResult.getAdditionalActions());
    assertNull(actualExportFDFResult.getAppearanceDictionary());
    assertTrue(actualExportFDFResult.getKids().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#getChildren()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getChildren()}
   */
  @Test
  @DisplayName("Test getChildren(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDNonTerminalField.getChildren()"})
  void testGetChildren_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDNonTerminalField(new PDAcroForm(new PDDocument())).getChildren().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setChildren(List)"})
  void testSetChildren_givenNull_whenArrayListAddNull() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>Then {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Children size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName(
      "Test setChildren(List); then PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Children size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setChildren(List)"})
  void testSetChildren_thenPDNonTerminalFieldWithAcroFormIsPDAcroFormChildrenSizeIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(1, children2.size());
    assertTrue(children2.get(0) instanceof PDCheckBox);
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   *
   * <ul>
   *   <li>Then {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link
   *       PDAcroForm#PDAcroForm(PDDocument)} Children size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName(
      "Test setChildren(List); then PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument) Children size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setChildren(List)"})
  void testSetChildren_thenPDNonTerminalFieldWithAcroFormIsPDAcroFormChildrenSizeIsTwo() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    ArrayList<PDField> children = new ArrayList<>();
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));
    children.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Act
    pdNonTerminalField.setChildren(children);

    // Assert
    List<PDField> children2 = pdNonTerminalField.getChildren();
    assertEquals(2, children2.size());
    assertTrue(children2.get(1) instanceof PDCheckBox);
  }

  /**
   * Test {@link PDNonTerminalField#setChildren(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setChildren(List)}
   */
  @Test
  @DisplayName("Test setChildren(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setChildren(List)"})
  void testSetChildren_whenArrayList() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getFieldType()}
   */
  @Test
  @DisplayName("Test getFieldType(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNonTerminalField.getFieldType()"})
  void testGetFieldType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDNonTerminalField(new PDAcroForm(new PDDocument())).getFieldType());
  }

  /**
   * Test {@link PDNonTerminalField#getValue()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDNonTerminalField.getValue()"})
  void testGetValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDNonTerminalField(new PDAcroForm(new PDDocument())).getValue());
  }

  /**
   * Test {@link PDNonTerminalField#getValueAsString()}.
   *
   * <ul>
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDNonTerminalField.getValueAsString()"})
  void testGetValueAsString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new PDNonTerminalField(new PDAcroForm(new PDDocument())).getValueAsString());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Boolean.FALSE.toString(), pdNonTerminalField.getValueAsString());
    assertSame(COSBoolean.FALSE, pdNonTerminalField.getValue());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject2() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue((COSBase) null);

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(COSBase)} with {@code object}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject3() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setValue(COSBase) with 'object'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase) with 'object'; when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject_whenCOSDictionary() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setValue(COSBase) with 'object'; when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(COSBase)"})
  void testSetValueWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setValue(object);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertEquals(Boolean.FALSE.toString(), pdNonTerminalField.getValueAsString());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(String)"})
  void testSetValueWithValue() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
    assertArrayEquals(new byte[] {'4', '2'}, ((COSString) value).getBytes());
  }

  /**
   * Test {@link PDNonTerminalField#setValue(String)} with {@code value}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setValue(String)"})
  void testSetValueWithValue2() throws IOException {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setValue((String) null);

    // Assert that nothing has changed
    assertEquals("", pdNonTerminalField.getValueAsString());
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#getDefaultValue()}.
   *
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link
   *       PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDNonTerminalField.getDefaultValue()"})
  void testGetDefaultValue_givenPDAcroFormWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertNull(new PDNonTerminalField(new PDAcroForm(new PDDocument())).getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setDefaultValue(COSBoolean.FALSE);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(COSBoolean.FALSE, pdNonTerminalField.getDefaultValue());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue2() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    pdNonTerminalField.setDefaultValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDNonTerminalField#setDefaultValue(COSBase)}.
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue3() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));

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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName("Test setDefaultValue(COSBase); when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue_whenCOSDictionary() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
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
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDNonTerminalField#setDefaultValue(COSBase)}
   */
  @Test
  @DisplayName(
      "Test setDefaultValue(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDNonTerminalField.setDefaultValue(COSBase)"})
  void testSetDefaultValue_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDNonTerminalField pdNonTerminalField =
        new PDNonTerminalField(new PDAcroForm(new PDDocument()));
    COSObject value = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    // Act
    pdNonTerminalField.setDefaultValue(value);

    // Assert
    COSDictionary cOSObject = pdNonTerminalField.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDNonTerminalField#getWidgets()}.
   *
   * <p>Method under test: {@link PDNonTerminalField#getWidgets()}
   */
  @Test
  @DisplayName("Test getWidgets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDNonTerminalField.getWidgets()"})
  void testGetWidgets() {
    // Arrange, Act and Assert
    assertTrue(new PDNonTerminalField(new PDAcroForm(new PDDocument())).getWidgets().isEmpty());
  }
}
