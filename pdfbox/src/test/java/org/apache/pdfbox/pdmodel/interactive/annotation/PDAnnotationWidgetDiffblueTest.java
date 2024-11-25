package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
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
import org.junit.jupiter.api.Test;

class PDAnnotationWidgetDiffblueTest {
  /**
   * Test {@link PDAnnotationWidget#PDAnnotationWidget()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#PDAnnotationWidget()}
   */
  @Test
  @DisplayName("Test new PDAnnotationWidget()")
  void testNewPDAnnotationWidget() {
    // Arrange and Act
    PDAnnotationWidget actualPdAnnotationWidget = new PDAnnotationWidget();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationWidget.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationWidget.getAnnotationName());
    assertNull(actualPdAnnotationWidget.getContents());
    assertNull(actualPdAnnotationWidget.getModifiedDate());
    COSDictionary cOSObject = actualPdAnnotationWidget.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationWidget.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
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
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
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
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, actualPdAnnotationWidget.getHighlightingMode());
    assertEquals(PDAnnotationWidget.SUB_TYPE, actualPdAnnotationWidget.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationWidget(COSDictionary); when COSDictionary(); then COSDictionary() size is two")
  void testNewPDAnnotationWidget_whenCOSDictionary_thenCOSDictionarySizeIsTwo() {
    // Arrange
    COSDictionary field = new COSDictionary();

    // Act
    PDAnnotationWidget actualPdAnnotationWidget = new PDAnnotationWidget(field);

    // Assert
    assertEquals(2, field.size());
    List<? extends COSBase> toListResult = actualPdAnnotationWidget.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(field, actualPdAnnotationWidget.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationWidget(COSDictionary); when COSStream(); then COSStream() size is three")
  void testNewPDAnnotationWidget_whenCOSStream_thenCOSStreamSizeIsThree() {
    // Arrange
    COSStream field = new COSStream();

    // Act
    PDAnnotationWidget actualPdAnnotationWidget = new PDAnnotationWidget(field);

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationWidget.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertEquals(3, field.size());
    assertSame(field, actualPdAnnotationWidget.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationWidget#getHighlightingMode()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getHighlightingMode()}
   */
  @Test
  @DisplayName("Test getHighlightingMode()")
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
  void testSetHighlightingMode_whenHighlightingMode_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDAnnotationWidget()).setHighlightingMode("Highlighting Mode"));
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when 'null'; then PDAnnotationWidget() COSObject Values size is two")
  void testSetHighlightingMode_whenNull_thenPDAnnotationWidgetCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setHighlightingMode(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, pdAnnotationWidget.getHighlightingMode());
  }

  /**
   * Test {@link PDAnnotationWidget#setHighlightingMode(String)}.
   * <ul>
   *   <li>When {@code T}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} HighlightingMode is
   * {@code T}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  @DisplayName("Test setHighlightingMode(String); when 'T'; then PDAnnotationWidget() HighlightingMode is 'T'")
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
  void testGetAppearanceCharacteristics() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAppearanceCharacteristics());
  }

  /**
   * Test
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)")
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
   * Test
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)")
  void testSetAppearanceCharacteristics2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(null));

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); given COSObjectKey(long, int) with num is one and gen is one")
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
   * Test
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); given 'true'; when COSDictionary() Direct is 'true'")
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
   * Test
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  @DisplayName("Test setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary); when 'null'")
  void testSetAppearanceCharacteristics_whenNull() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(null);

    // Assert
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
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAction());
  }

  /**
   * Test {@link PDAnnotationWidget#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} Action
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationWidget() Action PDActionEmbeddedGoTo")
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
   * Test {@link PDAnnotationWidget#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget(COSDictionary)} with
   * field is {@link COSDictionary#COSDictionary()} Action is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDAnnotationWidget(COSDictionary) with field is COSDictionary() Action is 'null'")
  void testSetAction_thenPDAnnotationWidgetWithFieldIsCOSDictionaryActionIsNull() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget(new COSDictionary());

    // Act
    pdAnnotationWidget.setAction(null);

    // Assert
    assertNull(pdAnnotationWidget.getAction());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#getActions()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getActions()}
   */
  @Test
  @DisplayName("Test getActions()")
  void testGetActions() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getActions());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); given COSObjectKey(long, int) with num is one and gen is one")
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
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); given 'true'; when COSDictionary() Direct is 'true'")
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
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); when 'null'; then PDAnnotationWidget() COSObject Values size is two")
  void testSetActions_whenNull_thenPDAnnotationWidgetCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setActions(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}.
   * <ul>
   *   <li>When
   * {@link PDAnnotationAdditionalActions#PDAnnotationAdditionalActions()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  @DisplayName("Test setActions(PDAnnotationAdditionalActions); when PDAnnotationAdditionalActions()")
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
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary)")
  void testSetBorderStyle() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationWidget.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult2 = ((COSArray) getResult).toList();
    assertEquals(1, toListResult2.size());
    assertTrue(toListResult2.get(0) instanceof COSFloat);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetBorderStyle_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationWidget.getBorderStyle();
    COSBase cOSObject = borderStyle.getDashStyle().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetBorderStyle_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationWidget.setBorderStyle(new PDBorderStyleDictionary(dict));

    // Assert
    PDBorderStyleDictionary borderStyle = pdAnnotationWidget.getBorderStyle();
    COSBase cOSObject = borderStyle.getDashStyle().getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertSame(dict, borderStyle.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values
   * size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  @DisplayName("Test setBorderStyle(PDBorderStyleDictionary); when 'null'; then PDAnnotationWidget() COSObject Values size is two")
  void testSetBorderStyle_whenNull_thenPDAnnotationWidgetCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setBorderStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationWidget#getBorderStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationWidget#getBorderStyle()}
   */
  @Test
  @DisplayName("Test getBorderStyle()")
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getBorderStyle());
  }

  /**
   * Test {@link PDAnnotationWidget#setParent(PDTerminalField)}.
   * <ul>
   *   <li>Then {@link PDAnnotationWidget#PDAnnotationWidget()} COSObject Values
   * size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationWidget#setParent(PDTerminalField)}
   */
  @Test
  @DisplayName("Test setParent(PDTerminalField); then PDAnnotationWidget() COSObject Values size is three")
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
