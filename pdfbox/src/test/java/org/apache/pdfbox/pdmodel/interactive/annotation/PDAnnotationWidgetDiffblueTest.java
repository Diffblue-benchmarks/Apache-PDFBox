package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.action.PDAnnotationAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDTerminalField;
import org.junit.jupiter.api.Test;

class PDAnnotationWidgetDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationWidget#getHighlightingMode()}
   */
  @Test
  void testGetHighlightingMode() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLink.HIGHLIGHT_MODE_INVERT, (new PDAnnotationWidget()).getHighlightingMode());
  }

  /**
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new PDAnnotationWidget()).setHighlightingMode("Highlighting Mode"));
  }

  /**
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode2() {
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
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode3() {
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
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode4() {
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
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode5() {
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
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode6() {
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
   * Method under test: {@link PDAnnotationWidget#setHighlightingMode(String)}
   */
  @Test
  void testSetHighlightingMode7() {
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
   * Method under test: {@link PDAnnotationWidget#getAppearanceCharacteristics()}
   */
  @Test
  void testGetAppearanceCharacteristics() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAppearanceCharacteristics());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
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
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  void testSetAppearanceCharacteristics2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(new PDAppearanceCharacteristicsDictionary(null));

    // Assert
    assertNull(pdAnnotationWidget.getAppearanceCharacteristics());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  void testSetAppearanceCharacteristics3() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setAppearanceCharacteristics(null);

    // Assert
    assertNull(pdAnnotationWidget.getAppearanceCharacteristics());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  void testSetAppearanceCharacteristics4() {
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
   * Method under test:
   * {@link PDAnnotationWidget#setAppearanceCharacteristics(PDAppearanceCharacteristicsDictionary)}
   */
  @Test
  void testSetAppearanceCharacteristics5() {
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
   * Method under test: {@link PDAnnotationWidget#getAction()}
   */
  @Test
  void testGetAction() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getAction());
  }

  /**
   * Method under test: {@link PDAnnotationWidget#setAction(PDAction)}
   */
  @Test
  void testSetAction() throws IOException {
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
   * Method under test: {@link PDAnnotationWidget#getActions()}
   */
  @Test
  void testGetActions() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getActions());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  void testSetActions() {
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
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  void testSetActions2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setActions(null);

    // Assert
    assertNull(pdAnnotationWidget.getActions());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  void testSetActions3() {
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
   * Method under test:
   * {@link PDAnnotationWidget#setActions(PDAnnotationAdditionalActions)}
   */
  @Test
  void testSetActions4() {
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
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
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
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle2() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setBorderStyle(null);

    // Assert
    assertNull(pdAnnotationWidget.getBorderStyle());
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle3() {
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
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDAnnotationWidget#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle4() {
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
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderStyle.getStyle());
    assertSame(dict, borderStyle.getCOSObject());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationWidget#getBorderStyle()}
   */
  @Test
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationWidget()).getBorderStyle());
  }

  /**
   * Method under test: {@link PDAnnotationWidget#setParent(PDTerminalField)}
   */
  @Test
  void testSetParent() {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();

    // Act
    pdAnnotationWidget.setParent(new PDCheckBox(new PDAcroForm(new PDDocument())));

    // Assert
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationWidget#setParent(PDTerminalField)}
   */
  @Test
  void testSetParent2() throws IOException {
    // Arrange
    PDAnnotationWidget pdAnnotationWidget = new PDAnnotationWidget();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationWidget.setParent(new PDCheckBox(new PDAcroForm(new PDDocument(streamCacheCreateFunction))));

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdAnnotationWidget.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }
}
