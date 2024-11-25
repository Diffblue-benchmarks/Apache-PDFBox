package org.apache.pdfbox.pdmodel.interactive.form;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFieldTreeDiffblueTest {
  /**
   * Test {@link PDFieldTree#PDFieldTree(PDAcroForm)}.
   * <ul>
   *   <li>Then iterator next return {@link PDCheckBox}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDFieldTree(PDAcroForm); then iterator next return PDCheckBox")
  void testNewPDFieldTree_thenIteratorNextReturnPDCheckBox() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(acroForm)).iterator();

    // Assert
    PDField nextResult = actualIteratorResult.next();
    assertTrue(nextResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) nextResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult).getOnValue());
    assertEquals("Btn", nextResult.getFieldType());
    assertEquals("Off", ((PDCheckBox) nextResult).getValue());
    assertEquals("Off", nextResult.getValueAsString());
    assertNull(nextResult.getAlternateFieldName());
    assertNull(nextResult.getFullyQualifiedName());
    assertNull(nextResult.getMappingName());
    assertNull(nextResult.getPartialName());
    assertNull(nextResult.getActions());
    assertNull(nextResult.getParent());
    assertEquals(0, nextResult.getFieldFlags());
    assertFalse(actualIteratorResult.hasNext());
    assertFalse(((PDCheckBox) nextResult).isPushButton());
    assertFalse(((PDCheckBox) nextResult).isRadioButton());
    assertFalse(nextResult.isNoExport());
    assertFalse(nextResult.isReadOnly());
    assertFalse(nextResult.isRequired());
    assertSame(acroForm, nextResult.getAcroForm());
  }

  /**
   * Test {@link PDFieldTree#PDFieldTree(PDAcroForm)}.
   * <ul>
   *   <li>When {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#PDFieldTree(PDAcroForm)}
   */
  @Test
  @DisplayName("Test new PDFieldTree(PDAcroForm); when PDAcroForm(PDDocument) with doc is PDDocument()")
  void testNewPDFieldTree_whenPDAcroFormWithDocIsPDDocument() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Test {@link PDFieldTree#iterator()}.
   * <ul>
   *   <li>Given {@link PDAcroForm#PDAcroForm(PDDocument)} with doc is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return not hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDAcroForm(PDDocument) with doc is PDDocument(); then return not hasNext")
  void testIterator_givenPDAcroFormWithDocIsPDDocument_thenReturnNotHasNext() {
    // Arrange, Act and Assert
    assertFalse((new PDFieldTree(new PDAcroForm(new PDDocument()))).iterator().hasNext());
  }

  /**
   * Test {@link PDFieldTree#iterator()}.
   * <ul>
   *   <li>Then return next Widgets size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFieldTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); then return next Widgets size is one")
  void testIterator_thenReturnNextWidgetsSizeIsOne() {
    // Arrange
    ArrayList<PDField> fields = new ArrayList<>();
    fields.add(new PDCheckBox(new PDAcroForm(new PDDocument())));

    PDAcroForm acroForm = new PDAcroForm(new PDDocument());
    acroForm.setFields(fields);

    // Act
    Iterator<PDField> actualIteratorResult = (new PDFieldTree(acroForm)).iterator();

    // Assert
    PDField nextResult = actualIteratorResult.next();
    List<PDAnnotationWidget> widgets = nextResult.getWidgets();
    assertEquals(1, widgets.size());
    PDAnnotationWidget getResult = widgets.get(0);
    List<? extends COSBase> toListResult = getResult.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSInteger);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSInteger);
    assertTrue(nextResult instanceof PDCheckBox);
    assertEquals("", ((PDCheckBox) nextResult).getDefaultValue());
    assertEquals("", ((PDCheckBox) nextResult).getOnValue());
    assertEquals("Btn", nextResult.getFieldType());
    assertEquals("I", getResult.getHighlightingMode());
    assertEquals("Off", ((PDCheckBox) nextResult).getValue());
    assertEquals("Off", nextResult.getValueAsString());
    assertEquals("Widget", getResult.getSubtype());
    assertNull(getResult.getAnnotationName());
    assertNull(getResult.getContents());
    assertNull(getResult.getModifiedDate());
    assertNull(nextResult.getAlternateFieldName());
    assertNull(nextResult.getFullyQualifiedName());
    assertNull(nextResult.getMappingName());
    assertNull(nextResult.getPartialName());
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
    assertNull(getResult.getAppearanceCharacteristics());
    assertNull(getResult.getAppearance());
    assertNull(getResult.getNormalAppearanceStream());
    assertNull(getResult.getBorderStyle());
    assertNull(nextResult.getParent());
    assertEquals(-1, getResult.getStructParent());
    assertEquals(0, getResult.getAnnotationFlags());
    assertEquals(0, nextResult.getFieldFlags());
    Set<String> onValues = ((PDCheckBox) nextResult).getOnValues();
    assertEquals(1, onValues.size());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualIteratorResult.hasNext());
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
    assertFalse(((PDCheckBox) nextResult).isPushButton());
    assertFalse(((PDCheckBox) nextResult).isRadioButton());
    assertFalse(nextResult.isNoExport());
    assertFalse(nextResult.isReadOnly());
    assertFalse(nextResult.isRequired());
    assertTrue(((PDCheckBox) nextResult).getExportValues().isEmpty());
    assertTrue(onValues.contains(""));
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult2).isValid());
    assertTrue(((COSInteger) getResult3).isValid());
    assertSame(acroForm, nextResult.getAcroForm());
    assertSame(cOSObject, getResult.getCOSObject());
  }
}
