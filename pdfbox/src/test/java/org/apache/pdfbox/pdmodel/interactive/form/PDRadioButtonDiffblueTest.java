package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFField;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDRadioButtonDiffblueTest {
  /**
   * Test
   * {@link PDRadioButton#PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)}.
   * <p>
   * Method under test:
   * {@link PDRadioButton#PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)}
   */
  @Test
  @DisplayName("Test new PDRadioButton(PDAcroForm, COSDictionary, PDNonTerminalField)")
  void testNewPDRadioButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDRadioButton actualPdRadioButton = new PDRadioButton(acroForm, field, parent);

    // Assert
    assertSame(field, actualPdRadioButton.getCOSObject());
    assertSame(acroForm, actualPdRadioButton.getAcroForm());
    assertSame(parent, actualPdRadioButton.getParent());
  }

  /**
   * Test {@link PDRadioButton#PDRadioButton(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDRadioButton#PDRadioButton(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDRadioButton(PDAcroForm)")
  void testNewPDRadioButton2() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDRadioButton actualPdRadioButton = new PDRadioButton(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdRadioButton.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdRadioButton.getDefaultValue());
    assertEquals("Btn", actualPdRadioButton.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    List<String> selectedExportValues = actualPdRadioButton.getSelectedExportValues();
    assertEquals(1, selectedExportValues.size());
    assertEquals("Off", selectedExportValues.get(0));
    assertEquals("Off", actualPdRadioButton.getValue());
    assertEquals("Off", actualPdRadioButton.getValueAsString());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdRadioButton.getAlternateFieldName());
    assertNull(actualPdRadioButton.getFullyQualifiedName());
    assertNull(actualPdRadioButton.getMappingName());
    assertNull(actualPdRadioButton.getPartialName());
    COSDictionary cOSObject = actualPdRadioButton.getCOSObject();
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
    assertNull(actualPdRadioButton.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdRadioButton.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, actualPdRadioButton.getSelectedIndex());
    Set<String> onValues = actualPdRadioButton.getOnValues();
    assertEquals(1, onValues.size());
    assertEquals(32768, actualPdRadioButton.getFieldFlags());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(getResult.isHidden());
    assertFalse(getResult.isInvisible());
    assertFalse(getResult.isLocked());
    assertFalse(getResult.isLockedContents());
    assertFalse(getResult.isNoRotate());
    assertFalse(getResult.isNoView());
    assertFalse(getResult.isNoZoom());
    assertFalse(getResult.isPrinted());
    assertFalse(getResult.isReadOnly());
    assertFalse(getResult.isToggleNoView());
    assertFalse(actualPdRadioButton.isPushButton());
    assertFalse(actualPdRadioButton.isNoExport());
    assertFalse(actualPdRadioButton.isReadOnly());
    assertFalse(actualPdRadioButton.isRequired());
    assertFalse(actualPdRadioButton.isRadiosInUnison());
    assertTrue(actualPdRadioButton.getExportValues().isEmpty());
    assertTrue(onValues.contains(""));
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(actualPdRadioButton.isRadioButton());
    assertSame(acroForm, actualPdRadioButton.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDRadioButton#setRadiosInUnison(boolean)}.
   * <p>
   * Method under test: {@link PDRadioButton#setRadiosInUnison(boolean)}
   */
  @Test
  @DisplayName("Test setRadiosInUnison(boolean)")
  void testSetRadiosInUnison() {
    // Arrange
    COSDictionary field = mock(COSDictionary.class);
    doNothing().when(field).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    PDRadioButton pdRadioButton = new PDRadioButton(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())));

    // Act
    pdRadioButton.setRadiosInUnison(true);

    // Assert that nothing has changed
    verify(field).setFlag(isA(COSName.class), eq(33554432), eq(true));
    assertEquals(0, pdRadioButton.getFieldFlags());
    assertFalse(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   * <p>
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName("Test isRadiosInUnison()")
  void testIsRadiosInUnison() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertFalse((new PDRadioButton(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName("Test isRadiosInUnison(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return 'false'")
  void testIsRadiosInUnison_givenPDRadioButtonWithAcroFormIsPDAcroForm_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDRadioButton(new PDAcroForm(new PDDocument()))).isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#isRadiosInUnison()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#isRadiosInUnison()}
   */
  @Test
  @DisplayName("Test isRadiosInUnison(); then return 'true'")
  void testIsRadiosInUnison_thenReturnTrue() {
    // Arrange
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument()));
    pdRadioButton.setFieldFlags(33554432);

    // Act and Assert
    assertTrue(pdRadioButton.isRadiosInUnison());
  }

  /**
   * Test {@link PDRadioButton#getSelectedIndex()}.
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  @DisplayName("Test getSelectedIndex()")
  void testGetSelectedIndex() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act and Assert
    assertEquals(0, (new PDRadioButton(acroForm, field, new PDNonTerminalField(new PDAcroForm(new PDDocument()))))
        .getSelectedIndex());
  }

  /**
   * Test {@link PDRadioButton#getSelectedIndex()}.
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)} importFDF
   * {@link FDFField#FDFField()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  @DisplayName("Test getSelectedIndex(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument) importFDF FDFField()")
  void testGetSelectedIndex_givenPDRadioButtonWithAcroFormIsPDAcroFormImportFDFFDFField() throws IOException {
    // Arrange
    PDRadioButton pdRadioButton = new PDRadioButton(new PDAcroForm(new PDDocument()));
    pdRadioButton.importFDF(new FDFField());

    // Act and Assert
    assertEquals(0, pdRadioButton.getSelectedIndex());
  }

  /**
   * Test {@link PDRadioButton#getSelectedIndex()}.
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedIndex()}
   */
  @Test
  @DisplayName("Test getSelectedIndex(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument); then return zero")
  void testGetSelectedIndex_givenPDRadioButtonWithAcroFormIsPDAcroForm_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDRadioButton(new PDAcroForm(new PDDocument()))).getSelectedIndex());
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName("Test getSelectedExportValues()")
  void testGetSelectedExportValues() {
    // Arrange
    PDDocument doc = new PDDocument();

    // Act
    List<String> actualSelectedExportValues = (new PDRadioButton(new PDAcroForm(doc, new COSDictionary())))
        .getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   * <ul>
   *   <li>Given {@link PDNonTerminalField#PDNonTerminalField(PDAcroForm)} with
   * acroForm is {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName("Test getSelectedExportValues(); given PDNonTerminalField(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetSelectedExportValues_givenPDNonTerminalFieldWithAcroFormIsPDAcroForm() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();

    // Act
    List<String> actualSelectedExportValues = (new PDRadioButton(acroForm, field,
        new PDNonTerminalField(new PDAcroForm(new PDDocument())))).getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }

  /**
   * Test {@link PDRadioButton#getSelectedExportValues()}.
   * <ul>
   *   <li>Given {@link PDRadioButton#PDRadioButton(PDAcroForm)} with acroForm is
   * {@link PDAcroForm#PDAcroForm(PDDocument)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDRadioButton#getSelectedExportValues()}
   */
  @Test
  @DisplayName("Test getSelectedExportValues(); given PDRadioButton(PDAcroForm) with acroForm is PDAcroForm(PDDocument)")
  void testGetSelectedExportValues_givenPDRadioButtonWithAcroFormIsPDAcroForm() {
    // Arrange and Act
    List<String> actualSelectedExportValues = (new PDRadioButton(new PDAcroForm(new PDDocument())))
        .getSelectedExportValues();

    // Assert
    assertEquals(1, actualSelectedExportValues.size());
    assertEquals("Off", actualSelectedExportValues.get(0));
  }
}
