package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
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
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDefaultFont()}
   */
  @Test
  @DisplayName("Test getDefaultFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFont PDAbstractAppearanceHandler.getDefaultFont()"})
  void testGetDefaultFont() {
    // Arrange and Act
    PDFont actualDefaultFont =
        new PDCaretAppearanceHandler(new PDAnnotationCaret()).getDefaultFont();

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
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  @DisplayName("Test getAnnotation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAnnotation PDAbstractAppearanceHandler.getAnnotation()"})
  void testGetAnnotation() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    assertSame(annotation, new PDCaretAppearanceHandler(annotation).getAnnotation());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getColor()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDColor PDAbstractAppearanceHandler.getColor()"
  })
  void testGetColor_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCaretAppearanceHandler(new PDAnnotationCaret()).getColor());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRectangle()}.
   *
   * <ul>
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = new PDCaretAppearanceHandler(annotation).getRectangle();

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
   *
   * <ul>
   *   <li>Then return Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnHeightIsZero() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);

    // Act
    PDRectangle actualRectangle = new PDCaretAppearanceHandler(annotation).getRectangle();

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getRectangle()}
   */
  @Test
  @DisplayName("Test getRectangle(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDAbstractAppearanceHandler.getRectangle()"})
  void testGetRectangle_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDCaretAppearanceHandler(new PDAnnotationCaret()).getRectangle());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#createCOSStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDAbstractAppearanceHandler.createCOSStream()"})
  void testCreateCOSStream() {
    // Arrange and Act
    COSStream actualCreateCOSStreamResult =
        new PDCaretAppearanceHandler(new PDAnnotationCaret()).createCOSStream();

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
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#createCOSStream()}
   */
  @Test
  @DisplayName("Test createCOSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDAbstractAppearanceHandler.createCOSStream()"})
  void testCreateCOSStream2() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation, new PDDocument());

    // Act
    COSStream actualCreateCOSStreamResult = pdCaretAppearanceHandler.createCOSStream();

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
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    PDRectangle bBox =
        annotation2.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    float[][] values =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
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
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream3() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation, new PDDocument());

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream4() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
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
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream5() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(new PDAppearanceDictionary(new COSDictionary()));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert that nothing has changed
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream6() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(appearance);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert that nothing has changed
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertSame(stream, annotation2.getNormalAppearanceStream().getCOSObject());
    PDAppearanceEntry rolloverAppearance = pdCaretAppearanceHandler.getRolloverAppearance();
    assertSame(stream, rolloverAppearance.getAppearanceStream().getCOSObject());
    PDAppearanceDictionary appearance2 = pdCaretAppearanceHandler.getAppearance();
    assertSame(stream, appearance2.getNormalAppearance().getCOSObject());
    assertSame(stream, appearance2.getRolloverAppearance().getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream()}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream()"
  })
  void testGetNormalAppearanceAsContentStream7() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(appearance);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream();

    // Assert that nothing has changed
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    PDRectangle bBox =
        annotation2.getAppearance().getDownAppearance().getAppearanceStream().getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    float[][] values =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertArrayEquals(new float[] {-0.0f, -0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean2() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
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
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean3() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation, new PDDocument());

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean4() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert
    PDAppearanceStream appearanceStream =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream();
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
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean5() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(new PDAppearanceDictionary(new COSDictionary()));
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert that nothing has changed
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean6() throws IOException {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(appearance);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert that nothing has changed
    PDAnnotation annotation2 = pdCaretAppearanceHandler.getAnnotation();
    assertTrue(annotation2 instanceof PDAnnotationCaret);
    assertSame(stream, annotation2.getNormalAppearanceStream().getCOSObject());
    PDAppearanceEntry rolloverAppearance = pdCaretAppearanceHandler.getRolloverAppearance();
    assertSame(stream, rolloverAppearance.getAppearanceStream().getCOSObject());
    PDAppearanceDictionary appearance2 = pdCaretAppearanceHandler.getAppearance();
    assertSame(stream, appearance2.getNormalAppearance().getCOSObject());
    assertSame(stream, appearance2.getRolloverAppearance().getCOSObject());
    assertSame(stream, rolloverAppearance.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean7() throws IOException {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));
    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    annotation.setAppearance(appearance);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(true);

    // Assert that nothing has changed
    assertTrue(pdCaretAppearanceHandler.getAnnotation() instanceof PDAnnotationCaret);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)} with
   * {@code boolean}.
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#getNormalAppearanceAsContentStream(boolean)}
   */
  @Test
  @DisplayName("Test getNormalAppearanceAsContentStream(boolean) with 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDAppearanceContentStream PDAbstractAppearanceHandler.getNormalAppearanceAsContentStream(boolean)"
  })
  void testGetNormalAppearanceAsContentStreamWithBoolean8() throws IOException {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    // Act
    pdCaretAppearanceHandler.getNormalAppearanceAsContentStream(false);

    // Assert
    COSDictionary cOSObject = pdCaretAppearanceHandler.getDownAppearance().getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(6, cOSObject.getValues().size());
    assertEquals(6, cOSObject.size());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation, new PDDocument());

    // Act and Assert
    float[][] values =
        pdCaretAppearanceHandler.getDownAppearance().getAppearanceStream().getMatrix().getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance2() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setDownAppearance(new PDAppearanceEntry(new COSDictionary()));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act and Assert
    float[][] values =
        new PDCaretAppearanceHandler(annotation)
            .getDownAppearance()
            .getAppearanceStream()
            .getMatrix()
            .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDownAppearance(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();
    dictionary.setKey(new COSObjectKey(1L, 1));

    PDAppearanceDictionary appearance = new PDAppearanceDictionary(dictionary);
    appearance.setNormalAppearance(new PDAppearanceEntry(new COSDictionary()));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act and Assert
    float[][] values =
        new PDCaretAppearanceHandler(annotation)
            .getDownAppearance()
            .getAppearanceStream()
            .getMatrix()
            .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <ul>
   *   <li>Given {@link PDAnnotationCaret#PDAnnotationCaret()} Appearance is {@link
   *       PDAppearanceDictionary#PDAppearanceDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDownAppearance(); given PDAnnotationCaret() Appearance is PDAppearanceDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_givenPDAnnotationCaretAppearanceIsPDAppearanceDictionary() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(new PDAppearanceDictionary());

    // Act and Assert
    float[][] values =
        new PDCaretAppearanceHandler(annotation)
            .getDownAppearance()
            .getAppearanceStream()
            .getMatrix()
            .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName(
      "Test getDownAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualDownAppearance =
        new PDCaretAppearanceHandler(annotation).getDownAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualDownAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualDownAppearance.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getDownAppearance()}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getDownAppearance()}
   */
  @Test
  @DisplayName("Test getDownAppearance(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getDownAppearance()"})
  void testGetDownAppearance_thenReturnArrayLengthIsThree() {
    // Arrange, Act and Assert
    float[][] values =
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .getDownAppearance()
            .getAppearanceStream()
            .getMatrix()
            .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRolloverAppearance()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  @DisplayName("Test getRolloverAppearance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getRolloverAppearance()"})
  void testGetRolloverAppearance() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(annotation, new PDDocument());

    // Act and Assert
    float[][] values =
        pdCaretAppearanceHandler
            .getRolloverAppearance()
            .getAppearanceStream()
            .getMatrix()
            .getValues();
    assertEquals(3, values.length);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getRolloverAppearance()}.
   *
   * <ul>
   *   <li>Then return AppearanceStream Stream COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getRolloverAppearance()}
   */
  @Test
  @DisplayName(
      "Test getRolloverAppearance(); then return AppearanceStream Stream COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAppearanceEntry PDAbstractAppearanceHandler.getRolloverAppearance()"})
  void testGetRolloverAppearance_thenReturnAppearanceStreamStreamCOSObjectIsCOSStream() {
    // Arrange
    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    COSStream stream = new COSStream();
    appearance.setNormalAppearance(new PDAppearanceStream(stream));

    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setAppearance(appearance);

    // Act
    PDAppearanceEntry actualRolloverAppearance =
        new PDCaretAppearanceHandler(annotation).getRolloverAppearance();

    // Assert
    PDAppearanceStream appearanceStream = actualRolloverAppearance.getAppearanceStream();
    float[][] values = appearanceStream.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(stream, appearanceStream.getStream().getCOSObject());
    assertSame(stream, appearanceStream.getContentStream().getCOSObject());
    assertSame(stream, appearanceStream.getCOSObject());
    assertSame(stream, actualRolloverAppearance.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle, float)}.
   *
   * <ul>
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getPaddedRectangle(PDRectangle,
   * float)}
   */
  @Test
  @DisplayName(
      "Test getPaddedRectangle(PDRectangle, float); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.getPaddedRectangle(PDRectangle, float)"
  })
  void testGetPaddedRectangle_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualPaddedRectangle =
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
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
   *
   * <ul>
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName(
      "Test addRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"
  })
  void testAddRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualAddRectDifferencesResult =
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .addRectDifferences(PDRectangle.A0, new float[] {10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    COSArray cOSArray = actualAddRectDifferencesResult.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
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
    assertSame(cOSArray, actualAddRectDifferencesResult.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   *
   * <ul>
   *   <li>When empty array of {@code float}.
   *   <li>Then return {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName(
      "Test addRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"
  })
  void testAddRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange, Act and Assert
    assertSame(
        PDRectangle.A0,
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .addRectDifferences(PDRectangle.A0, new float[] {}));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle, float[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#addRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName("Test addRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.addRectDifferences(PDRectangle, float[])"
  })
  void testAddRectDifferences_whenNull_thenReturnA0() {
    // Arrange, Act and Assert
    assertSame(
        PDRectangle.A0,
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .addRectDifferences(PDRectangle.A0, null));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   *
   * <ul>
   *   <li>Then return COSArray toList size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName(
      "Test applyRectDifferences(PDRectangle, float[]); then return COSArray toList size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"
  })
  void testApplyRectDifferences_thenReturnCOSArrayToListSizeIsFour() {
    // Arrange and Act
    PDRectangle actualApplyRectDifferencesResult =
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .applyRectDifferences(PDRectangle.A0, new float[] {10.0f, 1.0f, 10.0f, 1.0f});

    // Assert
    COSArray cOSArray = actualApplyRectDifferencesResult.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
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
    assertSame(cOSArray, actualApplyRectDifferencesResult.getCOSObject());
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   *
   * <ul>
   *   <li>When empty array of {@code float}.
   *   <li>Then return {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName(
      "Test applyRectDifferences(PDRectangle, float[]); when empty array of float; then return A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"
  })
  void testApplyRectDifferences_whenEmptyArrayOfFloat_thenReturnA0() {
    // Arrange, Act and Assert
    assertSame(
        PDRectangle.A0,
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .applyRectDifferences(PDRectangle.A0, new float[] {}));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle, float[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link PDRectangle#A0}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#applyRectDifferences(PDRectangle,
   * float[])}
   */
  @Test
  @DisplayName("Test applyRectDifferences(PDRectangle, float[]); when 'null'; then return A0")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.applyRectDifferences(PDRectangle, float[])"
  })
  void testApplyRectDifferences_whenNull_thenReturnA0() {
    // Arrange, Act and Assert
    assertSame(
        PDRectangle.A0,
        new PDCaretAppearanceHandler(new PDAnnotationCaret())
            .applyRectDifferences(PDRectangle.A0, null));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName("Test setOpacity(PDAppearanceContentStream, float); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnCOSStream() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName#A}.
   *   <li>Then calls {@link COSDictionary#containsValue(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return A; then calls containsValue(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnA_thenCallsContainsValue()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(COSName.A);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName#ADBE_PKCS7_DETACHED}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_PKCS7_DETACHED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_pkcs7_detached()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenReturn(COSName.ADBE_PKCS7_DETACHED);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

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
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getKeyForValue(Object)} return {@link
   *       COSName#ADBE_X509_RSA_SHA1}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSDictionary getKeyForValue(Object) return ADBE_X509_RSA_SHA1")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSDictionaryGetKeyForValueReturnAdbe_x509_rsa_sha1()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any()))
        .thenReturn(COSName.ADBE_X509_RSA_SHA1);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

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
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#writePDF(OutputStream)} does nothing.
   *   <li>Then calls {@link COSName#writePDF(OutputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSName writePDF(OutputStream) does nothing; then calls writePDF(OutputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSNameWritePDFDoesNothing_thenCallsWritePDF() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSName cosName = mock(COSName.class);
    doNothing().when(cosName).writePDF(Mockito.<OutputStream>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getKeyForValue(Mockito.<Object>any())).thenReturn(cosName);
    when(cosDictionary.containsValue(Mockito.<Object>any())).thenReturn(true);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(cosDictionary).containsValue(isA(Object.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getKeyForValue(isA(Object.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosName).writePDF(isA(OutputStream.class));
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream, float)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link COSStream} {@link COSStream#getCOSDictionary(COSName)} return {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#setOpacity(PDAppearanceContentStream,
   * float)}
   */
  @Test
  @DisplayName(
      "Test setOpacity(PDAppearanceContentStream, float); given COSStream(); when COSStream getCOSDictionary(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.setOpacity(PDAppearanceContentStream, float)"
  })
  void testSetOpacity_givenCOSStream_whenCOSStreamGetCOSDictionaryReturnCOSStream()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    COSStream stream = mock(COSStream.class);
    when(stream.createOutputStream()).thenReturn(new ByteArrayOutputStream());
    when(stream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSStream());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream appearance = new PDAppearanceStream(stream);

    // Act
    pdCaretAppearanceHandler.setOpacity(new PDAppearanceContentStream(appearance), 0.99999994f);

    // Assert
    verify(stream).getCOSDictionary(isA(COSName.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(stream).createOutputStream();
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream cs =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle("Butt", cs, 10.0f, 10.0f, 10.0f, true, true, true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Butt",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()), true),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Butt}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Butt'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenButt_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Butt",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Circle}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Circle'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenCircle_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Circle",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ClosedArrow}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'ClosedArrow'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenClosedArrow_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "ClosedArrow",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Diamond}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Diamond'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenDiamond_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Diamond",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link PDAppearanceContentStream#addRect(float, float, float, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'false'; then calls addRect(float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenFalse_thenCallsAddRect() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).addRect(anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("Square", cs, 10.0f, 10.0f, 10.0f, true, false, true);

    // Assert
    verify(cs).addRect(-20.0f, -20.0f, 60.0f, 60.0f);
    verify(cs).drawShape(10.0f, true, false);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link PDAppearanceContentStream#addRect(float, float, float, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'false'; then calls addRect(float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenFalse_thenCallsAddRect2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).addRect(anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("Square", cs, 10.0f, 10.0f, 10.0f, true, true, false);

    // Assert
    verify(cs).addRect(-20.0f, -20.0f, 60.0f, 60.0f);
    verify(cs).drawShape(10.0f, true, true);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code OpenArrow}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'OpenArrow'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenOpenArrow_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "OpenArrow",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#addRect(float,
   *       float, float, float)} does nothing.
   *   <li>Then calls {@link PDAppearanceContentStream#addRect(float, float, float, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream addRect(float, float, float, float) does nothing; then calls addRect(float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamAddRectDoesNothing_thenCallsAddRect()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).addRect(anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("Square", cs, 10.0f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(cs).addRect(-20.0f, -20.0f, 60.0f, 60.0f);
    verify(cs).drawShape(10.0f, true, true);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#closePath()} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream closePath() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamClosePathDoesNothing() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).closePath();
    doNothing().when(cs).lineTo(anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("RClosedArrow", cs, 10.0f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1)).lineTo(anyFloat(), anyFloat());
    verify(cs).moveTo(97.94228f, 55.0f);
    verify(cs).drawShape(10.0f, true, true);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#closePath()}
   *       throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream closePath() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamClosePathThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).closePath();
    doNothing().when(cs).lineTo(anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "RClosedArrow", cs, 10.0f, 10.0f, 10.0f, true, true, true));
    verify(cs).closePath();
    verify(cs, atLeast(1)).lineTo(anyFloat(), anyFloat());
    verify(cs).moveTo(97.94228f, 55.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#curveTo(float,
   *       float, float, float, float, float)} does nothing.
   *   <li>Then calls {@link PDAppearanceContentStream#curveTo(float, float, float, float, float,
   *       float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream curveTo(float, float, float, float, float, float) does nothing; then calls curveTo(float, float, float, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamCurveToDoesNothing_thenCallsCurveTo()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing()
        .when(cs)
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).closePath();
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("Circle", cs, 10.0f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1))
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    verify(cs).moveTo(10.0f, 40.0f);
    verify(cs).drawShape(10.0f, true, true);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#curveTo(float,
   *       float, float, float, float, float)} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream curveTo(float, float, float, float, float, float) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamCurveToThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException())
        .when(cs)
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Circle", cs, 10.0f, 10.0f, 10.0f, true, true, true));
    verify(cs).curveTo(26.55352f, 40.0f, 40.0f, 26.55352f, 40.0f, 10.0f);
    verify(cs).moveTo(10.0f, 40.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#lineTo(float,
   *       float)} does nothing.
   *   <li>Then calls {@link PDAppearanceContentStream#lineTo(float, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream lineTo(float, float) does nothing; then calls lineTo(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamLineToDoesNothing_thenCallsLineTo()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).lineTo(anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());
    doNothing().when(cs).drawShape(anyFloat(), anyBoolean(), anyBoolean());

    // Act
    pdCaretAppearanceHandler.drawStyle("Butt", cs, 10.0f, 10.0f, 10.0f, true, true, true);

    // Assert
    verify(cs).lineTo(10.0f, 40.0f);
    verify(cs).moveTo(10.0f, -20.0f);
    verify(cs).drawShape(10.0f, true, false);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#moveTo(float,
   *       float)} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when PDAppearanceContentStream moveTo(float, float) throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenPDAppearanceContentStreamMoveToThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            pdCaretAppearanceHandler.drawStyle("Butt", cs, 10.0f, 10.0f, 10.0f, true, true, true));
    verify(cs).moveTo(10.0f, -20.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code RClosedArrow}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'RClosedArrow'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenRClosedArrow_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "RClosedArrow",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code ROpenArrow}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'ROpenArrow'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenROpenArrow_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "ROpenArrow",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Slash}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Slash'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenSlash_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Slash",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Square}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Square'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenSquare_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Square",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawStyle(String, PDAppearanceContentStream, float,
   * float, float, boolean, boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code Style}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawStyle(String,
   * PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean); when 'Style'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawStyle(String, PDAppearanceContentStream, float, float, float, boolean, boolean, boolean)"
  })
  void testDrawStyle_whenStyle_thenDoesNotThrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawStyle(
                "Style",
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f,
                true,
                true,
                true));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawArrow() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream cs =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> pdCaretAppearanceHandler.drawArrow(cs, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawArrow(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawArrow2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawArrow(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()), true),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawArrow(PDAppearanceContentStream, float, float, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawArrow_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdCaretAppearanceHandler.drawArrow(cs, 10.0f, 10.0f, 10.0f));
    verify(cs).moveTo(18.660255f, 15.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream} {@link PDAppearanceContentStream#lineTo(float,
   *       float)} does nothing.
   *   <li>Then calls {@link PDAppearanceContentStream#lineTo(float, float)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawArrow(PDAppearanceContentStream, float, float, float); when PDAppearanceContentStream lineTo(float, float) does nothing; then calls lineTo(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawArrow_whenPDAppearanceContentStreamLineToDoesNothing_thenCallsLineTo()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).lineTo(anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act
    pdCaretAppearanceHandler.drawArrow(cs, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(cs, atLeast(1)).lineTo(anyFloat(), anyFloat());
    verify(cs).moveTo(18.660255f, 15.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)} with
   *       appearance is {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawArrow(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawArrow(PDAppearanceContentStream, float, float, float); when PDAppearanceContentStream(PDAppearanceStream) with appearance is PDAppearanceStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawArrow(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawArrow_whenPDAppearanceContentStreamWithAppearanceIsPDAppearanceStream()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawArrow(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawDiamond() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream cs =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> pdCaretAppearanceHandler.drawDiamond(cs, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawDiamond(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawDiamond2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawDiamond(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()), true),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawDiamond(PDAppearanceContentStream, float, float, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawDiamond_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdCaretAppearanceHandler.drawDiamond(cs, 10.0f, 10.0f, 10.0f));
    verify(cs).moveTo(0.0f, 10.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceContentStream#closePath()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawDiamond(PDAppearanceContentStream, float, float, float); then calls closePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawDiamond_thenCallsClosePath() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).closePath();
    doNothing().when(cs).lineTo(anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act
    pdCaretAppearanceHandler.drawDiamond(cs, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1)).lineTo(anyFloat(), anyFloat());
    verify(cs).moveTo(0.0f, 10.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)} with
   *       appearance is {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawDiamond(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawDiamond(PDAppearanceContentStream, float, float, float); when PDAppearanceContentStream(PDAppearanceStream) with appearance is PDAppearanceStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawDiamond(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawDiamond_whenPDAppearanceContentStreamWithAppearanceIsPDAppearanceStream()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawDiamond(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream cs =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> pdCaretAppearanceHandler.drawCircle(cs, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle2() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawCircle(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()), true),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle(PDAppearanceContentStream, float, float, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdCaretAppearanceHandler.drawCircle(cs, 10.0f, 10.0f, 10.0f));
    verify(cs).moveTo(10.0f, 20.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceContentStream#closePath()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle(PDAppearanceContentStream, float, float, float); then calls closePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle_thenCallsClosePath() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).closePath();
    doNothing()
        .when(cs)
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act
    pdCaretAppearanceHandler.drawCircle(cs, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1))
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    verify(cs).moveTo(10.0f, 20.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)} with
   *       appearance is {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle(PDAppearanceContentStream, float, float, float); when PDAppearanceContentStream(PDAppearanceStream) with appearance is PDAppearanceStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle_whenPDAppearanceContentStreamWithAppearanceIsPDAppearanceStream()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawCircle(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle2(PDAppearanceContentStream, float, float, float); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle2_givenIOException_thenThrowIOException() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doThrow(new IOException()).when(cs).moveTo(anyFloat(), anyFloat());

    // Act and Assert
    assertThrows(
        IOException.class, () -> pdCaretAppearanceHandler.drawCircle2(cs, 10.0f, 10.0f, 10.0f));
    verify(cs).moveTo(10.0f, 20.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceContentStream#closePath()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle2(PDAppearanceContentStream, float, float, float); then calls closePath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle2_thenCallsClosePath() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    PDAppearanceContentStream cs = mock(PDAppearanceContentStream.class);
    doNothing().when(cs).closePath();
    doNothing()
        .when(cs)
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    doNothing().when(cs).moveTo(anyFloat(), anyFloat());

    // Act
    pdCaretAppearanceHandler.drawCircle2(cs, 10.0f, 10.0f, 10.0f);

    // Assert
    verify(cs).closePath();
    verify(cs, atLeast(1))
        .curveTo(anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat(), anyFloat());
    verify(cs).moveTo(10.0f, 20.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <ul>
   *   <li>When {@link PDAppearanceContentStream#PDAppearanceContentStream(PDAppearanceStream)} with
   *       appearance is {@link PDAppearanceStream#PDAppearanceStream(COSStream)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName(
      "Test drawCircle2(PDAppearanceContentStream, float, float, float); when PDAppearanceContentStream(PDAppearanceStream) with appearance is PDAppearanceStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle2_whenPDAppearanceContentStreamWithAppearanceIsPDAppearanceStream()
      throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawCircle2(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream())),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle22() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());
    PDAppearanceStream appearance = new PDAppearanceStream(new COSStream());
    PDAppearanceContentStream cs =
        new PDAppearanceContentStream(appearance, new ByteArrayOutputStream());

    // Act and Assert
    assertDoesNotThrow(() -> pdCaretAppearanceHandler.drawCircle2(cs, 10.0f, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream, float, float,
   * float)}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#drawCircle2(PDAppearanceContentStream,
   * float, float, float)}
   */
  @Test
  @DisplayName("Test drawCircle2(PDAppearanceContentStream, float, float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDAbstractAppearanceHandler.drawCircle2(PDAppearanceContentStream, float, float, float)"
  })
  void testDrawCircle23() throws IOException {
    // Arrange
    PDCaretAppearanceHandler pdCaretAppearanceHandler =
        new PDCaretAppearanceHandler(new PDAnnotationCaret());

    // Act and Assert
    assertDoesNotThrow(
        () ->
            pdCaretAppearanceHandler.drawCircle2(
                new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()), true),
                10.0f,
                10.0f,
                10.0f));
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()} Key is {@link COSObjectKey#COSObjectKey(long, int)}
   *       with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName(
      "Test handleBorderBox(PDAnnotationSquareCircle, float); given COSStream() Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.handleBorderBox(PDAnnotationSquareCircle, float)"
  })
  void testHandleBorderBox_givenCOSStreamKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    COSStream stream = new COSStream();
    stream.setKey(new COSObjectKey(1L, 1));
    PDAppearanceStream ap = new PDAppearanceStream(stream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(ap);

    PDAnnotationCircle annotation2 = new PDAnnotationCircle();
    annotation2.setAppearance(appearance);

    // Act
    PDRectangle actualHandleBorderBoxResult =
        pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    PDRectangle rectangle = annotation2.getRectangle();
    assertEquals(-5.0f, rectangle.getLowerLeftX());
    assertEquals(-5.0f, rectangle.getLowerLeftY());
    assertEquals(2373.937f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2378.937f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(2388.937f, rectangle.getUpperRightX());
    assertEquals(2393.937f, rectangle.getWidth());
    assertEquals(3360.3938f, actualHandleBorderBoxResult.getHeight());
    assertEquals(3365.3938f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(3375.3938f, rectangle.getUpperRightY());
    assertEquals(3380.3938f, rectangle.getHeight());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertArrayEquals(new float[] {5.0f, 5.0f, 5.0f, 5.0f}, annotation2.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle Height is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName(
      "Test handleBorderBox(PDAnnotationSquareCircle, float); then PDAnnotationCircle() Rectangle Height is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.handleBorderBox(PDAnnotationSquareCircle, float)"
  })
  void testHandleBorderBox_thenPDAnnotationCircleRectangleHeightIsZero() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    PDRectangle rectangle =
        new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    annotation.setRectangle(rectangle);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCircle annotation2 = new PDAnnotationCircle();
    annotation2.setAppearance(appearance);

    // Act
    PDRectangle actualHandleBorderBoxResult =
        pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    PDRectangle rectangle2 = annotation2.getRectangle();
    assertEquals(0.0f, rectangle2.getHeight());
    assertEquals(0.0f, actualHandleBorderBoxResult.getHeight());
    assertEquals(0.0f, rectangle2.getWidth());
    assertEquals(0.0f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(2.14748365E9f, rectangle2.getLowerLeftY());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getLowerLeftY());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightX());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(2.14748365E9f, rectangle2.getUpperRightY());
    assertEquals(2.14748365E9f, actualHandleBorderBoxResult.getUpperRightY());
    assertArrayEquals(new float[] {5.0f, 5.0f, 5.0f, 5.0f}, annotation2.getRectDifferences(), 0.0f);
  }

  /**
   * Test {@link PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationCircle#PDAnnotationCircle()} Rectangle LowerLeftX is minus five.
   * </ul>
   *
   * <p>Method under test: {@link
   * PDAbstractAppearanceHandler#handleBorderBox(PDAnnotationSquareCircle, float)}
   */
  @Test
  @DisplayName(
      "Test handleBorderBox(PDAnnotationSquareCircle, float); then PDAnnotationCircle() Rectangle LowerLeftX is minus five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDRectangle PDAbstractAppearanceHandler.handleBorderBox(PDAnnotationSquareCircle, float)"
  })
  void testHandleBorderBox_thenPDAnnotationCircleRectangleLowerLeftXIsMinusFive() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();
    annotation.setRectangle(PDRectangle.A0);
    PDCaretAppearanceHandler pdCaretAppearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    appearance.setNormalAppearance(new PDAppearanceStream(new COSStream()));

    PDAnnotationCircle annotation2 = new PDAnnotationCircle();
    annotation2.setAppearance(appearance);

    // Act
    PDRectangle actualHandleBorderBoxResult =
        pdCaretAppearanceHandler.handleBorderBox(annotation2, 10.0f);

    // Assert
    PDRectangle rectangle = annotation2.getRectangle();
    assertEquals(-5.0f, rectangle.getLowerLeftX());
    assertEquals(-5.0f, rectangle.getLowerLeftY());
    assertEquals(2373.937f, actualHandleBorderBoxResult.getWidth());
    assertEquals(2378.937f, actualHandleBorderBoxResult.getUpperRightX());
    assertEquals(2388.937f, rectangle.getUpperRightX());
    assertEquals(2393.937f, rectangle.getWidth());
    assertEquals(3360.3938f, actualHandleBorderBoxResult.getHeight());
    assertEquals(3365.3938f, actualHandleBorderBoxResult.getUpperRightY());
    assertEquals(3375.3938f, rectangle.getUpperRightY());
    assertEquals(3380.3938f, rectangle.getHeight());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftX());
    assertEquals(5.0f, actualHandleBorderBoxResult.getLowerLeftY());
    assertArrayEquals(new float[] {5.0f, 5.0f, 5.0f, 5.0f}, annotation2.getRectDifferences(), 0.0f);
  }
}
