package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAbstractAppearanceHandlerDiffblueTest {
  /**
   * Test {@link PDAbstractAppearanceHandler#getDefaultFont()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDefaultFont()}
   */
  @Test
  @DisplayName("Test getDefaultFont()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFont PDAbstractAppearanceHandler.getDefaultFont()"})
  void testGetDefaultFont() {
    // Arrange and Act
    PDFont actualDefaultFont = (new PDCaretAppearanceHandler(new PDAnnotationCaret())).getDefaultFont();

    // Assert
    assertTrue(((PDType1Font) actualDefaultFont).getFontBoxFont() instanceof TrueTypeFont);
    assertTrue(actualDefaultFont instanceof PDType1Font);
    assertTrue(((PDType1Font) actualDefaultFont).getEncoding() instanceof WinAnsiEncoding);
    assertEquals("Font", actualDefaultFont.getType());
    assertEquals("Helvetica", actualDefaultFont.getName());
    assertEquals("Helvetica", ((PDType1Font) actualDefaultFont).getBaseFont());
    assertEquals("Type1", actualDefaultFont.getSubType());
    assertNull(((PDType1Font) actualDefaultFont).getType1Font());
    assertEquals(278.0f, actualDefaultFont.getSpaceWidth());
    assertEquals(542.7714f, actualDefaultFont.getAverageFontWidth());
    assertFalse(actualDefaultFont.isVertical());
    assertFalse(actualDefaultFont.isDamaged());
    assertFalse(actualDefaultFont.isEmbedded());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getAnnotation()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  @DisplayName("Test getAnnotation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAnnotation PDAbstractAppearanceHandler.getAnnotation()"})
  void testGetAnnotation() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    assertSame(annotation, (new PDCaretAppearanceHandler(annotation)).getAnnotation());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getColor()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.graphics.color.PDColor PDAbstractAppearanceHandler.getColor()"})
  void testGetColor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getColor());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return Height is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = (new PDCaretAppearanceHandler(annotation)).getRectangle();

    // Assert
    List<? extends COSBase> toListResult = actualRectangle.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDCaretAppearanceHandler(new PDAnnotationCaret())).getRectangle());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#createCOSStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream PDAbstractAppearanceHandler.createCOSStream()"})
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret())).createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#createCOSStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSStream PDAbstractAppearanceHandler.createCOSStream()"})
  void testCreateCOSStream2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act
    COSStream actualCreateCOSStreamResult = (new PDCaretAppearanceHandler(annotation, new PDDocument()))
        .createCOSStream();

    // Assert
    assertNull(actualCreateCOSStreamResult.getFilters());
    COSUpdateState updateState = actualCreateCOSStreamResult.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCreateCOSStreamResult.getKey());
    assertEquals(0L, actualCreateCOSStreamResult.getLength());
    assertEquals(1, actualCreateCOSStreamResult.getValues().size());
    assertEquals(1, actualCreateCOSStreamResult.size());
    COSIncrement toIncrementResult = actualCreateCOSStreamResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCreateCOSStreamResult.isDirect());
    assertFalse(actualCreateCOSStreamResult.hasData());
    assertFalse(actualCreateCOSStreamResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getAppearance()}.
   * <ul>
   *   <li>Then return COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceDictionary PDAbstractAppearanceHandler.getAppearance()"})
  void testGetAppearance_thenReturnCOSObjectValuesSizeIsOne() {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());

    // Act
    PDAppearanceDictionary actualAppearance = (new PDCaretAppearanceHandler(annotation)).getAppearance();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    COSDictionary cOSObject = actualAppearance.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDAppearanceEntry downAppearance = actualAppearance.getDownAppearance();
    assertFalse(downAppearance.isStream());
    PDAppearanceEntry normalAppearance = actualAppearance.getNormalAppearance();
    assertFalse(normalAppearance.isStream());
    PDAppearanceEntry rolloverAppearance = actualAppearance.getRolloverAppearance();
    assertFalse(rolloverAppearance.isStream());
    assertTrue(downAppearance.getSubDictionary().isEmpty());
    assertTrue(normalAppearance.getSubDictionary().isEmpty());
    assertTrue(rolloverAppearance.getSubDictionary().isEmpty());
    assertTrue(downAppearance.isSubDictionary());
    assertTrue(normalAppearance.isSubDictionary());
    assertTrue(rolloverAppearance.isSubDictionary());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getAppearance()}.
   * <ul>
   *   <li>Then return {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getAppearance()}
   */
  @Test
  @DisplayName("Test getAppearance(); then return PDAppearanceDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceDictionary PDAbstractAppearanceHandler.getAppearance()"})
  void testGetAppearance_thenReturnPDAppearanceDictionary() {
    // Arrange
    PDAnnotation annotation = mock(PDAnnotation.class);
    PDAppearanceDictionary pdAppearanceDictionary = new PDAppearanceDictionary();
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);

    // Act
    PDAppearanceDictionary actualAppearance = (new PDCaretAppearanceHandler(annotation)).getAppearance();

    // Assert
    verify(annotation).getAppearance();
    assertSame(pdAppearanceDictionary, actualAppearance);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"})
  void testGetNormalAppearanceAsContentStream() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-0.0f, matrix.getTranslateX());
    assertEquals(-0.0f, matrix.getTranslateY());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"})
  void testGetNormalAppearanceAsContentStream2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"})
  void testGetNormalAppearanceAsContentStreamWithBoolean() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    COSDictionary cOSObject = pdCaretAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(((COSStream) cOSObject).getFilters() instanceof COSName);
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"})
  void testGetNormalAppearanceAsContentStreamWithBoolean2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAppearanceStream appearanceStream = pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
    Matrix matrix = appearanceStream.getMatrix();
    assertEquals(-2.14748365E9f, matrix.getTranslateX());
    assertEquals(-2.14748365E9f, matrix.getTranslateY());
    PDRectangle bBox = appearanceStream.getBBox();
    assertEquals(0.0f, bBox.getHeight());
    assertEquals(0.0f, bBox.getWidth());
    assertEquals(2.14748365E9f, bBox.getLowerLeftX());
    assertEquals(2.14748365E9f, bBox.getLowerLeftY());
    assertEquals(2.14748365E9f, bBox.getUpperRightX());
    assertEquals(2.14748365E9f, bBox.getUpperRightY());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with {@code boolean}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"})
  void testGetNormalAppearanceAsContentStreamWithBoolean3() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(false);

    // Assert
    COSDictionary cOSObject = pdCaretAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(((COSStream) cOSObject).getFilters());
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    float[][] values = (new PDCaretAppearanceHandler(annotation, new PDDocument())).getDownAppearance()
        .getAppearanceStream()
        .getMatrix()
        .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance2() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setDownAppearance(new PDAppearanceEntry(new COSDictionary()));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act and Assert
    float[][] values = (new PDCaretAppearanceHandler(annotation)).getDownAppearance()
        .getAppearanceStream()
        .getMatrix()
        .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Appearance is {@link PDAppearanceDictionary#PDAppearanceDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); given PDAnnotationCaret() Appearance is PDAppearanceDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_givenPDAnnotationCaretAppearanceIsPDAppearanceDictionary() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    float[][] values = (new PDCaretAppearanceHandler(annotation)).getDownAppearance()
        .getAppearanceStream()
        .getMatrix()
        .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualDownAppearance = (new PDCaretAppearanceHandler(annotation)).getDownAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualDownAppearance.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   * <ul>
   *   <li>Then return array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return array length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_thenReturnArrayLengthIsThree() {
    // Arrange, Act and Assert
    float[][] values = (new PDCaretAppearanceHandler(new PDAnnotationCaret())).getDownAppearance()
        .getAppearanceStream()
        .getMatrix()
        .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRolloverAppearance()}.
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getRolloverAppearance()"})
  void testGetRolloverAppearance() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    float[][] values = (new PDCaretAppearanceHandler(annotation, new PDDocument())).getRolloverAppearance()
        .getAppearanceStream()
        .getMatrix()
        .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRolloverAppearance()}.
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getRolloverAppearance()"})
  void testGetRolloverAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualRolloverAppearance = (new PDCaretAppearanceHandler(annotation)).getRolloverAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualRolloverAppearance.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}
   */
  @Test
  @DisplayName("Test getPaddedRectangle(PDRectangle, float); when A0; then return COSArray toList size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getPaddedRectangle(PDRectangle, float)"})
  void testGetPaddedRectangle_whenA0_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualPaddedRectangle = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .getPaddedRectangle(PDRectangle.A0, 10.0f);

    // Assert
    COSArray cOSArray = actualPaddedRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftX());
    assertEquals(10.0f, actualPaddedRectangle.getLowerLeftY());
    assertEquals(2363.937f, actualPaddedRectangle.getWidth());
    assertEquals(2373.937f, actualPaddedRectangle.getUpperRightX());
    assertEquals(3350.3938f, actualPaddedRectangle.getHeight());
    assertEquals(3360.3938f, actualPaddedRectangle.getUpperRightY());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualPaddedRectangle.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"})
  void testAddRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    List<? extends COSBase> toListResult = actualAddRectDifferencesResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(-1.0f, actualAddRectDifferencesResult.getLowerLeftY());
    assertEquals(-10.0f, actualAddRectDifferencesResult.getLowerLeftX());
    assertEquals(2393.937f, actualAddRectDifferencesResult.getUpperRightX());
    assertEquals(2403.937f, actualAddRectDifferencesResult.getWidth());
    assertEquals(3371.3938f, actualAddRectDifferencesResult.getUpperRightY());
    assertEquals(3372.3938f, actualAddRectDifferencesResult.getHeight());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When empty array of {@code float}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"})
  void testAddRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"})
  void testAddRectDifferences_whenNull_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .addRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualAddRectDifferencesResult.A0, actualAddRectDifferencesResult);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>Then return COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"})
  void testApplyRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    List<? extends COSBase> toListResult = actualApplyRectDifferencesResult.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualApplyRectDifferencesResult.getLowerLeftY());
    assertEquals(10.0f, actualApplyRectDifferencesResult.getLowerLeftX());
    assertEquals(2363.937f, actualApplyRectDifferencesResult.getWidth());
    assertEquals(2373.937f, actualApplyRectDifferencesResult.getUpperRightX());
    assertEquals(3368.3938f, actualApplyRectDifferencesResult.getHeight());
    assertEquals(3369.3938f, actualApplyRectDifferencesResult.getUpperRightY());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When empty array of {@code float}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"})
  void testApplyRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, new float[]{});

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PDRectangle#A0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"})
  void testApplyRectDifferences_whenNull_thenReturnA0() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult = (new PDCaretAppearanceHandler(new PDAnnotationCaret()))
        .applyRectDifferences(PDRectangle.A0, null);

    // Assert
    assertSame(actualApplyRectDifferencesResult.A0, actualApplyRectDifferencesResult);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#A}.</li>
   *   <li>Then calls {@link COSDictionary#containsValue(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return A; then calls containsValue(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnA_thenCallsContainsValue() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#ADBE_PKCS7_DETACHED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_PKCS7_DETACHED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_pkcs7_detached() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link COSName#ADBE_X509_RSA_SHA1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_X509_RSA_SHA1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"})
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_x509_rsa_sha1() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 0.5f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"})
  void testDrawStyle_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f,
        10.0f, 10.0f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"})
  void testDrawStyle_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)),
        -9.223372E18f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName("Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"})
  void testDrawStyle_when9223372e18_thenCallsGetCOSDictionary2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f,
        10.0f, -9.223372E18f, true, true, true);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"})
  void testDrawArrow_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawArrow(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"})
  void testDrawArrow_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawArrow(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"})
  void testDrawDiamond_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawDiamond(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"})
  void testDrawDiamond_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawDiamond(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"})
  void testDrawCircle_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"})
  void testDrawCircle_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>Given {@link ByteArrayOutputStream#ByteArrayOutputStream(int)} with one.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float); given ByteArrayOutputStream(int) with one; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"})
  void testDrawCircle2_givenByteArrayOutputStreamWithOne_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle2(new PDAppearanceContentStream(new PDAppearanceStream(stream)), 10.0f, 10.0f,
        10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}.
   * <ul>
   *   <li>When {@code -9.223372E18}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float); when '-9.223372E18'; then calls getCOSDictionary(COSName)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"})
  void testDrawCircle2_when9223372e18_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(new PDAnnotationCaret());
    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream(1));
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    pdCaretAppearanceHandler.drawCircle2(new PDAppearanceContentStream(new PDAppearanceStream(stream)), -9.223372E18f,
        10.0f, 10.0f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   * <ul>
   *   <li>Then return Width is {@code 2373.937}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName("Test handleBorderBox(PDAnnotationSquareCircle, float); then return Width is '2373.937'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.handleBorderBox(PDAnnotationSquareCircle, float)"})
  void testHandleBorderBox_thenReturnWidthIs2373937() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCircle annotation2 = new PDAnnotationCircle();
    annotation2.setAppearance(appearance);

    // Act
    PDRectangle actualHandleBorderBoxResult = pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    assertEquals(2373.937f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2378.937f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(3360.3938f, actualHandleBorderBoxResult.getHeight());
    assertEquals(3365.3938f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertArrayEquals(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, annotation2.getRectDifferences(), 0.0f);
  }
}
