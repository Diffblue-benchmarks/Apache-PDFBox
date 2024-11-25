package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDPushButtonDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDPushButton#PDPushButton(PDAcroForm, COSDictionary, PDNonTerminalField)}
   *   <li>{@link PDPushButton#constructAppearances()}
   *   <li>{@link PDPushButton#getDefaultValue()}
   *   <li>{@link PDPushButton#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    COSDictionary field = new COSDictionary();
    PDNonTerminalField parent = new PDNonTerminalField(new PDAcroForm(new PDDocument()));

    // Act
    PDPushButton actualPdPushButton = new PDPushButton(acroForm, field, parent);
    actualPdPushButton.constructAppearances();
    String actualDefaultValue = actualPdPushButton.getDefaultValue();

    // Assert that nothing has changed
    assertEquals("", actualDefaultValue);
    assertEquals("", actualPdPushButton.getValue());
    assertSame(field, actualPdPushButton.getCOSObject());
    assertSame(acroForm, actualPdPushButton.getAcroForm());
    assertSame(parent, actualPdPushButton.getParent());
  }

  /**
   * Test {@link PDPushButton#PDPushButton(PDAcroForm)}.
   * <p>
   * Method under test: {@link PDPushButton#PDPushButton(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDPushButton(PDAcroForm)")
  void testNewPDPushButton() {
    // Arrange
    PDAcroForm acroForm = new PDAcroForm(new PDDocument());

    // Act
    PDPushButton actualPdPushButton = new PDPushButton(acroForm);

    // Assert
    List<PDAnnotationWidget> widgets = actualPdPushButton.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertEquals("", actualPdPushButton.getDefaultValue());
    assertEquals("", actualPdPushButton.getValue());
    assertEquals("", actualPdPushButton.getValueAsString());
    assertEquals("Btn", actualPdPushButton.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(actualPdPushButton.getAlternateFieldName());
    assertNull(actualPdPushButton.getFullyQualifiedName());
    assertNull(actualPdPushButton.getMappingName());
    assertNull(actualPdPushButton.getPartialName());
    COSDictionary cOSObject = actualPdPushButton.getCOSObject();
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
    assertNull(actualPdPushButton.getActions());
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(actualPdPushButton.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(65536, actualPdPushButton.getFieldFlags());
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
    assertFalse(actualPdPushButton.isRadioButton());
    assertFalse(actualPdPushButton.isNoExport());
    assertFalse(actualPdPushButton.isReadOnly());
    assertFalse(actualPdPushButton.isRequired());
    assertTrue(actualPdPushButton.getExportValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdPushButton.getOnValues().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertTrue(actualPdPushButton.isPushButton());
    assertSame(acroForm, actualPdPushButton.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }

  /**
   * Test {@link PDPushButton#getExportValues()}.
   * <p>
   * Method under test: {@link PDPushButton#getExportValues()}
   */
  @Test
  @DisplayName("Test getExportValues()")
  void testGetExportValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getExportValues().isEmpty());
  }

  /**
   * Test {@link PDPushButton#setExportValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  @DisplayName("Test setExportValues(List); given 'foo'; then throw IllegalArgumentException")
  void testSetExportValues_givenFoo_thenThrowIllegalArgumentException() {
    // Arrange
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument()));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
  }

  /**
   * Test {@link PDPushButton#setExportValues(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPushButton#setExportValues(List)}
   */
  @Test
  @DisplayName("Test setExportValues(List); given 'foo'; then throw IllegalArgumentException")
  void testSetExportValues_givenFoo_thenThrowIllegalArgumentException2() {
    // Arrange
    PDPushButton pdPushButton = new PDPushButton(new PDAcroForm(new PDDocument()));

    ArrayList<String> values = new ArrayList<>();
    values.add("foo");
    values.add("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPushButton.setExportValues(values));
  }

  /**
   * Test {@link PDPushButton#getValueAsString()}.
   * <p>
   * Method under test: {@link PDPushButton#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString()")
  void testGetValueAsString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDPushButton(new PDAcroForm(new PDDocument()))).getValueAsString());
  }

  /**
   * Test {@link PDPushButton#getOnValues()}.
   * <p>
   * Method under test: {@link PDPushButton#getOnValues()}
   */
  @Test
  @DisplayName("Test getOnValues()")
  void testGetOnValues() {
    // Arrange, Act and Assert
    assertTrue((new PDPushButton(new PDAcroForm(new PDDocument()))).getOnValues().isEmpty());
  }
}
