package org.apache.pdfbox.pdmodel.interactive.annotation.handlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationCaret;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAbstractAppearanceHandlerDiffblueTest {
  /**
   * Test {@link PDAbstractAppearanceHandler#getAnnotation()}.
   *
   * <p>Method under test: {@link PDAbstractAppearanceHandler#getAnnotation()}
   */
  @Test
  @DisplayName("Test getAnnotation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation PDAbstractAppearanceHandler.getAnnotation()"
  })
  void testGetAnnotation() {
    // Arrange
    PDAnnotationCaret annotation = new PDAnnotationCaret();

    // Act and Assert
    assertSame(annotation, new PDCaretAppearanceHandler(annotation).getAnnotation());
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
}
