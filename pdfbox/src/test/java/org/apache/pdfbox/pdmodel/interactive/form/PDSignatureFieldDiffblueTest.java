package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSeedValue;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSignatureFieldDiffblueTest {
  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm, COSDictionary, PDNonTerminalField)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm, COSDictionary, PDNonTerminalField)"})
  void testNewPDSignatureField() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdSignatureField.getCOSObject());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
    assertSame(parent, actualPdSignatureField.getParent());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField2() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act and Assert
    PDAcroForm acroForm2 = (new PDSignatureField(acroForm)).getAcroForm();
    Iterator<PDField> fieldIterator = acroForm2.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    assertTrue(nextResult instanceof PDCheckBox);
    List<PDField> fields2 = acroForm2.getFields();
    assertEquals(1, fields2.size());
    PDField getResult = fields2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertNull(nextResult.getFullyQualifiedName());
    assertNull(getResult.getFullyQualifiedName());
    assertNull(nextResult.getPartialName());
    assertNull(getResult.getPartialName());
    assertFalse(fieldIterator.hasNext());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField3() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("Widget");

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(pdCheckBox);

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act and Assert
    PDAcroForm acroForm2 = (new PDSignatureField(acroForm)).getAcroForm();
    Iterator<PDField> fieldIterator = acroForm2.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    assertTrue(nextResult instanceof PDCheckBox);
    Iterator<PDField> iteratorResult = acroForm2.getFieldTree().iterator();
    PDField nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PDCheckBox);
    List<PDField> fields2 = acroForm2.getFields();
    assertEquals(1, fields2.size());
    PDField getResult = fields2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("Widget", nextResult.getFullyQualifiedName());
    assertEquals("Widget", nextResult2.getFullyQualifiedName());
    assertEquals("Widget", getResult.getFullyQualifiedName());
    assertEquals("Widget", nextResult.getPartialName());
    assertEquals("Widget", nextResult2.getPartialName());
    assertEquals("Widget", getResult.getPartialName());
    assertFalse(fieldIterator.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField4() {
    // Arrange
    PDCheckBox pdCheckBox = new PDCheckBox(new PDAcroForm(new PDDocument()));
    pdCheckBox.setPartialName("");

    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(pdCheckBox);

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act and Assert
    PDAcroForm acroForm2 = (new PDSignatureField(acroForm)).getAcroForm();
    Iterator<PDField> fieldIterator = acroForm2.getFieldIterator();
    PDField nextResult = fieldIterator.next();
    assertTrue(nextResult instanceof PDCheckBox);
    Iterator<PDField> iteratorResult = acroForm2.getFieldTree().iterator();
    PDField nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof PDCheckBox);
    List<PDField> fields2 = acroForm2.getFields();
    assertEquals(1, fields2.size());
    PDField getResult = fields2.get(0);
    assertTrue(getResult instanceof PDCheckBox);
    assertEquals("", nextResult.getFullyQualifiedName());
    assertEquals("", nextResult2.getFullyQualifiedName());
    assertEquals("", getResult.getFullyQualifiedName());
    assertEquals("", nextResult.getPartialName());
    assertEquals("", nextResult2.getPartialName());
    assertEquals("", getResult.getPartialName());
    assertFalse(fieldIterator.hasNext());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    fields.add(new PDCheckBox(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))));

    PDAcroForm acroForm2 = new PDAcroForm(new PDDocument());
    acroForm2.setFields(fields);

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm2);

    // Assert
    assertEquals("", actualPdSignatureField.getValueAsString());
    assertEquals("Sig", actualPdSignatureField.getFieldType());
    assertEquals("Signature1", actualPdSignatureField.getFullyQualifiedName());
    assertEquals("Signature1", actualPdSignatureField.getPartialName());
    assertNull(actualPdSignatureField.getAlternateFieldName());
    assertNull(actualPdSignatureField.getMappingName());
    assertNull(actualPdSignatureField.getActions());
    assertNull(actualPdSignatureField.getSeedValue());
    assertNull(actualPdSignatureField.getDefaultValue());
    assertNull(actualPdSignatureField.getSignature());
    assertNull(actualPdSignatureField.getValue());
    assertNull(actualPdSignatureField.getParent());
    assertEquals(0, actualPdSignatureField.getFieldFlags());
    assertEquals(1, actualPdSignatureField.getWidgets().size());
    assertFalse(actualPdSignatureField.isNoExport());
    assertFalse(actualPdSignatureField.isReadOnly());
    assertFalse(actualPdSignatureField.isRequired());
    assertSame(acroForm2, actualPdSignatureField.getAcroForm());
  }

  /**
   * Test {@link PDSignatureField#PDSignatureField(PDAcroForm)}.
   * <ul>
   *   <li>When {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#PDSignatureField(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDSignatureField(PDAcroForm); when PDAcroForm(PDDocument) with doc is PDDocument()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.<init>(PDAcroForm)"})
  void testNewPDSignatureField_whenPDAcroFormWithDocIsPDDocument() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDSignatureField actualPdSignatureField = new PDSignatureField(acroForm);

    // Assert
    assertEquals("", actualPdSignatureField.getValueAsString());
    assertEquals("Sig", actualPdSignatureField.getFieldType());
    assertEquals("Signature1", actualPdSignatureField.getFullyQualifiedName());
    assertEquals("Signature1", actualPdSignatureField.getPartialName());
    assertNull(actualPdSignatureField.getAlternateFieldName());
    assertNull(actualPdSignatureField.getMappingName());
    assertNull(actualPdSignatureField.getActions());
    assertNull(actualPdSignatureField.getSeedValue());
    assertNull(actualPdSignatureField.getDefaultValue());
    assertNull(actualPdSignatureField.getSignature());
    assertNull(actualPdSignatureField.getValue());
    assertNull(actualPdSignatureField.getParent());
    assertEquals(0, actualPdSignatureField.getFieldFlags());
    assertEquals(1, actualPdSignatureField.getWidgets().size());
    assertFalse(actualPdSignatureField.isNoExport());
    assertFalse(actualPdSignatureField.isReadOnly());
    assertFalse(actualPdSignatureField.isRequired());
    assertSame(acroForm, actualPdSignatureField.getAcroForm());
  }

  /**
   * Test {@link PDSignatureField#getSignature()}.
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#getSignature()}
   */
  @Test
  @DisplayName("Test getSignature(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSignature PDSignatureField.getSignature()"})
  void testGetSignature_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getSignature());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   * <p>
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature() throws IOException {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   * <p>
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature2() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDSignatureField pdSignatureField = new PDSignatureField(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdSignatureField.setValue(new PDSignature());

    // Assert
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    PDSignature signature = pdSignatureField.getSignature();
    assertArrayEquals(new byte[]{}, signature.getContents());
    PDSignature value = pdSignatureField.getValue();
    assertArrayEquals(new byte[]{}, value.getContents());
    assertArrayEquals(new int[]{}, signature.getByteRange());
    assertArrayEquals(new int[]{}, value.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setValue(PDSignature)} with {@code PDSignature}.
   * <p>
   * Method under test: {@link PDSignatureField#setValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setValue(PDSignature) with 'PDSignature'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setValue(PDSignature)"})
  void testSetValueWithPDSignature3() throws IOException {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setValue((PDSignature) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#setValue(String)} with {@code String}.
   * <p>
   * Method under test: {@link PDSignatureField#setValue(String)}
   */
  @Test
  @DisplayName("Test setValue(String) with 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setValue(String)"})
  void testSetValueWithString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDSignatureField(new PDAcroForm(new PDDocument()))).setValue("42"));
  }

  /**
   * Test {@link PDSignatureField#setDefaultValue(PDSignature)}.
   * <p>
   * Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setDefaultValue(PDSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setDefaultValue(PDSignature)"})
  void testSetDefaultValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setDefaultValue(new PDSignature());

    // Assert
    PDSignature defaultValue = pdSignatureField.getDefaultValue();
    assertNull(defaultValue.getContactInfo());
    assertNull(defaultValue.getFilter());
    assertNull(defaultValue.getLocation());
    assertNull(defaultValue.getName());
    assertNull(defaultValue.getReason());
    assertNull(defaultValue.getSubFilter());
    assertNull(defaultValue.getSignDate());
    assertNull(defaultValue.getPropBuild());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertArrayEquals(new byte[]{}, defaultValue.getContents());
    assertArrayEquals(new int[]{}, defaultValue.getByteRange());
  }

  /**
   * Test {@link PDSignatureField#setDefaultValue(PDSignature)}.
   * <p>
   * Method under test: {@link PDSignatureField#setDefaultValue(PDSignature)}
   */
  @Test
  @DisplayName("Test setDefaultValue(PDSignature)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setDefaultValue(PDSignature)"})
  void testSetDefaultValue2() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setDefaultValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#getValue()}.
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSignature PDSignatureField.getValue()"})
  void testGetValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getValue());
  }

  /**
   * Test {@link PDSignatureField#getDefaultValue()}.
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#getDefaultValue()}
   */
  @Test
  @DisplayName("Test getDefaultValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSignature PDSignatureField.getDefaultValue()"})
  void testGetDefaultValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getDefaultValue());
  }

  /**
   * Test {@link PDSignatureField#getValueAsString()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDSignatureField.getValueAsString()"})
  void testGetValueAsString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDSignatureField(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDSignatureField#getSeedValue()}.
   * <ul>
   *   <li>Given {@link PDSignatureField#PDSignatureField(PDAcroForm)} with acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#getSeedValue()}
   */
  @Test
  @DisplayName("Test getSeedValue(); given PDSignatureField(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDSeedValue PDSignatureField.getSeedValue()"})
  void testGetSeedValue_givenPDSignatureFieldWithAcroFormIsPDAcroForm_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDSignatureField(new PDAcroForm(new PDDocument()))).getSeedValue());
  }

  /**
   * Test {@link PDSignatureField#setSeedValue(PDSeedValue)}.
   * <p>
   * Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  @DisplayName("Test setSeedValue(PDSeedValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setSeedValue(PDSeedValue)"})
  void testSetSeedValue() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setSeedValue(new PDSeedValue());

    // Assert
    PDSeedValue seedValue = pdSignatureField.getSeedValue();
    assertNull(seedValue.getFilter());
    assertNull(seedValue.getSeedValueCertificate());
    assertNull(seedValue.getMDP());
    assertNull(seedValue.getTimeStamp());
    assertEquals(-1.0f, seedValue.getV());
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
    assertFalse(seedValue.isAddRevInfoRequired());
    assertFalse(seedValue.isDigestMethodRequired());
    assertFalse(seedValue.isFilterRequired());
    assertFalse(seedValue.isLegalAttestationRequired());
    assertFalse(seedValue.isReasonRequired());
    assertFalse(seedValue.isSubFilterRequired());
    assertFalse(seedValue.isVRequired());
  }

  /**
   * Test {@link PDSignatureField#setSeedValue(PDSeedValue)}.
   * <p>
   * Method under test: {@link PDSignatureField#setSeedValue(PDSeedValue)}
   */
  @Test
  @DisplayName("Test setSeedValue(PDSeedValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.setSeedValue(PDSeedValue)"})
  void testSetSeedValue2() {
    // Arrange
    PDSignatureField pdSignatureField = new PDSignatureField(new PDAcroForm(new PDDocument()));

    // Act
    pdSignatureField.setSeedValue(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdSignatureField.getCOSObject();
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray() add FALSE; then calls getObject(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray getObject(int) return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayGetObjectReturnCOSDictionary() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray getObject(int) return COSDictionary")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayGetObjectReturnCOSDictionary2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnNull() throws IOException {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(field, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnA() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnCOSStream() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSStream());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetDictionaryObjectReturnOne() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_thenCallsSetItem() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .constructAppearances();

    // Assert
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }

  /**
   * Test {@link PDSignatureField#constructAppearances()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSignatureField#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDSignatureField.constructAppearances()"})
  void testConstructAppearances_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenThrow(new UnsupportedOperationException("foo"));
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(cosDictionary).setName(Mockito.<COSName>any(), Mockito.<String>any());
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray2.isEmpty()).thenReturn(false);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray2);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDSignatureField(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
            .constructAppearances());
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2).isEmpty();
    verify(cosArray).size();
    verify(cosArray2, atLeast(1)).size();
    verify(field).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).setName(isA(COSName.class), eq("Widget"));
  }
}
