package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationWidgetDiffblueTest {
  /**
   * Test {@link PDAnnotationWidget#PDAnnotationWidget()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#PDAnnotationWidget()}
   */
  @Test
  @DisplayName("Test new PDAnnotationWidget()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.<init>()"})
  void testNewPDAnnotationWidget() {
    // Arrange and Act
    PDAnnotationWidget actualPdAnnotationWidget = new PDAnnotationWidget();

    // Assert
    assertNull(actualPdAnnotationWidget.getAnnotationName());
    assertNull(actualPdAnnotationWidget.getContents());
    assertNull(actualPdAnnotationWidget.getModifiedDate());
    assertNull(actualPdAnnotationWidget.getAppearanceState());
    assertNull(actualPdAnnotationWidget.getPage());
    assertNull(actualPdAnnotationWidget.getRectangle());
    assertNull(actualPdAnnotationWidget.getOptionalContent());
    assertNull(actualPdAnnotationWidget.getColor());
    assertNull(actualPdAnnotationWidget.getAction());
    assertNull(actualPdAnnotationWidget.getActions());
    assertNull(actualPdAnnotationWidget.getAppearanceCharacteristics());
    assertNull(actualPdAnnotationWidget.getAppearance());
    assertNull(actualPdAnnotationWidget.getNormalAppearanceStream());
    assertNull(actualPdAnnotationWidget.getBorderStyle());
    assertEquals(-1, actualPdAnnotationWidget.getStructParent());
    assertEquals(0, actualPdAnnotationWidget.getAnnotationFlags());
    assertFalse(actualPdAnnotationWidget.isHidden());
    assertFalse(actualPdAnnotationWidget.isInvisible());
    assertFalse(actualPdAnnotationWidget.isLocked());
    assertFalse(actualPdAnnotationWidget.isLockedContents());
    assertFalse(actualPdAnnotationWidget.isNoRotate());
    assertFalse(actualPdAnnotationWidget.isNoView());
    assertFalse(actualPdAnnotationWidget.isNoZoom());
    assertFalse(actualPdAnnotationWidget.isPrinted());
    assertFalse(actualPdAnnotationWidget.isReadOnly());
    assertFalse(actualPdAnnotationWidget.isToggleNoView());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationWidget.getHighlightingMode());
    assertEquals(PDAnnotationWidget.SUB_TYPE, actualPdAnnotationWidget.getSubtype());
  }

  /**
   * Test {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return AnnotationName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationWidget(COSDictionary); when COSDictionary(); then return AnnotationName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.<init>(COSDictionary)"})
  void testNewPDAnnotationWidget_whenCOSDictionary_thenReturnAnnotationNameIsNull() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationWidget actualPdAnnotationWidget = new PDAnnotationWidget(field);

    // Assert
    assertNull(actualPdAnnotationWidget.getAnnotationName());
    assertNull(actualPdAnnotationWidget.getContents());
    assertNull(actualPdAnnotationWidget.getModifiedDate());
    assertNull(actualPdAnnotationWidget.getAppearanceState());
    assertNull(actualPdAnnotationWidget.getPage());
    assertNull(actualPdAnnotationWidget.getRectangle());
    assertNull(actualPdAnnotationWidget.getOptionalContent());
    assertNull(actualPdAnnotationWidget.getColor());
    assertNull(actualPdAnnotationWidget.getAction());
    assertNull(actualPdAnnotationWidget.getActions());
    assertNull(actualPdAnnotationWidget.getAppearanceCharacteristics());
    assertNull(actualPdAnnotationWidget.getAppearance());
    assertNull(actualPdAnnotationWidget.getNormalAppearanceStream());
    assertNull(actualPdAnnotationWidget.getBorderStyle());
    assertEquals(-1, actualPdAnnotationWidget.getStructParent());
    assertEquals(0, actualPdAnnotationWidget.getAnnotationFlags());
    assertEquals(2, field.size());
    assertFalse(actualPdAnnotationWidget.isHidden());
    assertFalse(actualPdAnnotationWidget.isInvisible());
    assertFalse(actualPdAnnotationWidget.isLocked());
    assertFalse(actualPdAnnotationWidget.isLockedContents());
    assertFalse(actualPdAnnotationWidget.isNoRotate());
    assertFalse(actualPdAnnotationWidget.isNoView());
    assertFalse(actualPdAnnotationWidget.isNoZoom());
    assertFalse(actualPdAnnotationWidget.isPrinted());
    assertFalse(actualPdAnnotationWidget.isReadOnly());
    assertFalse(actualPdAnnotationWidget.isToggleNoView());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationWidget.getHighlightingMode());
    assertEquals(PDAnnotationWidget.SUB_TYPE, actualPdAnnotationWidget.getSubtype());
    assertSame(field, actualPdAnnotationWidget.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#getHighlightingMode()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getHighlightingMode()}
   */
  @Test
  @DisplayName("Test getHighlightingMode()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDAnnotationWidget.getHighlightingMode()"})
  void testGetHighlightingMode() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, (new PDAnnotationWidget()).getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(PDAnnotationLink.HIGHLIGHT_MODE_NONE);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_NONE, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode3() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(PDAnnotationLink.HIGHLIGHT_MODE_PUSH);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_PUSH, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@link PDAnnotationLink#HIGHLIGHT_MODE_INVERT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when HIGHLIGHT_MODE_INVERT")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode_whenHighlight_mode_invert() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(PDAnnotationLink.HIGHLIGHT_MODE_INVERT);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@code Highlighting Mode}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when 'Highlighting Mode'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode_whenHighlightingMode_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDAnnotationWidget()).setHighlightingMode("Highlighting Mode"));
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when 'null'; then PDAnnotationWidget() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode_whenNull_thenPDAnnotationWidgetCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@code T}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} HighlightingMode is {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when 'T'; then PDAnnotationWidget() HighlightingMode is 'T'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setHighlightingMode(String)"})
  void testSetHighlightingMode_whenT_thenPDAnnotationWidgetHighlightingModeIsT() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode("T");

    // Assert
    assertEquals("T", pdAnnotationWidget.getHighlightingMode());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#getAppearanceCharacteristics()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getAppearanceCharacteristics()}
   */
  @Test
  @DisplayName("Test getAppearanceCharacteristics()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceCharacteristicsDictionary PDAnnotationWidget.getAppearanceCharacteristics()"})
  void testGetAppearanceCharacteristics() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAppearanceCharacteristics());
  }

  /**
   * Test {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)"})
  void testSetAppearanceCharacteristics() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    COSDictionary dict = new COSDictionary();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(dict));

    // Assert
    PDAppearanceCharacteristicsDictionary appearanceCharacteristics = pdAnnotationWidget.getAppearanceCharacteristics();
    assertNull(appearanceCharacteristics.getAlternateCaption());
    assertNull(appearanceCharacteristics.getNormalCaption());
    assertNull(appearanceCharacteristics.getRolloverCaption());
    assertNull(appearanceCharacteristics.getBackground());
    assertNull(appearanceCharacteristics.getBorderColour());
    assertNull(appearanceCharacteristics.getAlternateIcon());
    assertNull(appearanceCharacteristics.getNormalIcon());
    assertNull(appearanceCharacteristics.getRolloverIcon());
    assertEquals(0, appearanceCharacteristics.getRotation());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dict, appearanceCharacteristics.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)"})
  void testSetAppearanceCharacteristics2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(null));

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)"})
  void testSetAppearanceCharacteristics_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(dict));

    // Assert
    PDAppearanceCharacteristicsDictionary appearanceCharacteristics = pdAnnotationWidget.getAppearanceCharacteristics();
    assertNull(appearanceCharacteristics.getAlternateCaption());
    assertNull(appearanceCharacteristics.getNormalCaption());
    assertNull(appearanceCharacteristics.getRolloverCaption());
    assertNull(appearanceCharacteristics.getBackground());
    assertNull(appearanceCharacteristics.getBorderColour());
    assertNull(appearanceCharacteristics.getAlternateIcon());
    assertNull(appearanceCharacteristics.getNormalIcon());
    assertNull(appearanceCharacteristics.getRolloverIcon());
    assertEquals(0, appearanceCharacteristics.getRotation());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dict, appearanceCharacteristics.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)"})
  void testSetAppearanceCharacteristics_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(dict));

    // Assert
    PDAppearanceCharacteristicsDictionary appearanceCharacteristics = pdAnnotationWidget.getAppearanceCharacteristics();
    assertNull(appearanceCharacteristics.getAlternateCaption());
    assertNull(appearanceCharacteristics.getNormalCaption());
    assertNull(appearanceCharacteristics.getRolloverCaption());
    assertNull(appearanceCharacteristics.getBackground());
    assertNull(appearanceCharacteristics.getBorderColour());
    assertNull(appearanceCharacteristics.getAlternateIcon());
    assertNull(appearanceCharacteristics.getNormalIcon());
    assertNull(appearanceCharacteristics.getRolloverIcon());
    assertEquals(0, appearanceCharacteristics.getRotation());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(dict, appearanceCharacteristics.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)"})
  void testSetAppearanceCharacteristics_whenNull() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#getAction()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getAction()}
   */
  @Test
  @DisplayName("Test getAction()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAction PDAnnotationWidget.getAction()"})
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAction());
  }

  /**
   * Test {@link PDAnnotationWidget#setAction(PDAction)}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAction(PDAction)"})
  void testSetAction() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget(new COSDictionary());

    // Act
    pdAnnotationWidget.setAction(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} Action {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationWidget() Action PDActionEmbeddedGoTo")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setAction(PDAction)"})
  void testSetAction_thenPDAnnotationWidgetActionPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAction(new PDActionEmbeddedGoTo());

    // Assert
    PDAction action = pdAnnotationWidget.getAction();
    assertTrue(action instanceof PDActionEmbeddedGoTo);
    assertEquals("Action", action.getType());
    assertEquals("GoToE", action.getSubType());
    assertNull(action.getNext());
    assertNull(((PDActionEmbeddedGoTo) action).getFile());
    assertNull(((PDActionEmbeddedGoTo) action).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) action).getDestination());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) action).getOpenInNewWindow());
  }

  /**
   * Test {@link PDAnnotationWidget#getActions()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getActions()}
   */
  @Test
  @DisplayName("Test getActions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAnnotationAdditionalActions PDAnnotationWidget.getActions()"})
  void testGetActions() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getActions());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setActions(PDAnnotationAdditionalActions)"})
  void testSetActions_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary a = new COSDictionary();
    a.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationWidget.setActions(new PDAnnotationAdditionalActions(a));

    // Assert
    PDAnnotationAdditionalActions actions = pdAnnotationWidget.getActions();
    assertNull(actions.getBl());
    assertNull(actions.getD());
    assertNull(actions.getE());
    assertNull(actions.getFo());
    assertNull(actions.getPC());
    assertNull(actions.getPI());
    assertNull(actions.getPO());
    assertNull(actions.getPV());
    assertNull(actions.getU());
    assertNull(actions.getX());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(a, actions.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setActions(PDAnnotationAdditionalActions)"})
  void testSetActions_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary a = new COSDictionary();
    a.setDirect(true);

    // Act
    pdAnnotationWidget.setActions(new PDAnnotationAdditionalActions(a));

    // Assert
    PDAnnotationAdditionalActions actions = pdAnnotationWidget.getActions();
    assertNull(actions.getBl());
    assertNull(actions.getD());
    assertNull(actions.getE());
    assertNull(actions.getFo());
    assertNull(actions.getPC());
    assertNull(actions.getPI());
    assertNull(actions.getPO());
    assertNull(actions.getPV());
    assertNull(actions.getU());
    assertNull(actions.getX());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertSame(a, actions.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); when 'null'; then PDAnnotationWidget() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setActions(PDAnnotationAdditionalActions)"})
  void testSetActions_whenNull_thenPDAnnotationWidgetCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setActions(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>When {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); when PDAnnotationAdditionalActions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setActions(PDAnnotationAdditionalActions)"})
  void testSetActions_whenPDAnnotationAdditionalActions() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setActions(new PDAnnotationAdditionalActions());

    // Assert
    PDAnnotationAdditionalActions actions = pdAnnotationWidget.getActions();
    assertNull(actions.getBl());
    assertNull(actions.getD());
    assertNull(actions.getE());
    assertNull(actions.getFo());
    assertNull(actions.getPC());
    assertNull(actions.getPI());
    assertNull(actions.getPO());
    assertNull(actions.getPV());
    assertNull(actions.getU());
    assertNull(actions.getX());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationWidget.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationWidget.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>When {@link PDBorderStyleDictionary#PDBorderStyleDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when PDBorderStyleDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setBorderStyle(PDBorderStyleDictionary)"})
  void testSetBorderStyle_whenPDBorderStyleDictionary() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDLineDashPattern dashStyle = pdAnnotationWidget.getBorderStyle().getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationWidget#getBorderStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDBorderStyleDictionary PDAnnotationWidget.getBorderStyle()"})
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getBorderStyle());
  }

  /**
   * Test {@link PDAnnotationWidget#setParent(PDTerminalField)}.
   * <ul>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setParent(PDTerminalField)}
   */
  @Test
  @DisplayName("Test setParent(PDTerminalField); then PDAnnotationWidget() COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationWidget.setParent(PDTerminalField)"})
  void testSetParent_thenPDAnnotationWidgetCOSObjectValuesSizeIsThree() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setParent(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
