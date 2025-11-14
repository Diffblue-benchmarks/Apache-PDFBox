package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDICCBased;
import org.apache.pdfbox.pdmodel.graphics.color.PDIndexed;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.color.PDSeparation;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SetColorDiffblueTest {
  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess2() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    PDColorSpace colorSpace = setNonStrokingColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess3() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    PDColorSpace colorSpace = setNonStrokingColor.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDColor color = setNonStrokingColor.getColor();
    assertNull(color.getColorSpace());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {}, color.getComponents(), 0.0f);
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess4() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDICCBased(new PDDocument()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    setNonStrokingColor.process(operator, new ArrayList<>());

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess5() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    arguments.add(cosStream);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given A; when ArrayList() add A; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenA_whenArrayListAddA_thenCallsSetNonStrokingColor() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given A; when ArrayList() add A; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenA_whenArrayListAddA_thenCallsSetNonStrokingColor2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given A; when ArrayList() add A; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenA_whenArrayListAddA_thenCallsSetNonStrokingColor3() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    arguments.add(COSName.A);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSArray(); when ArrayList() add COSArray(); then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSArray_whenArrayListAddCOSArray_thenCallsSetNonStrokingColor()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSArray(); when ArrayList() add COSArray(); then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSArray_whenArrayListAddCOSArray_thenCallsSetNonStrokingColor2()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    arguments.add(new COSArray());

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSDictionary_whenArrayListAddCOSDictionary() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSDictionary());

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSDictionary_whenArrayListAddCOSDictionary2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    arguments.add(new COSDictionary());

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    arguments.add(cosObject);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    arguments.add(cosObject);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSetNonStrokingColor()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSetNonStrokingColor2()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given 'null'; when ArrayList() add 'null'; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenNull_whenArrayListAddNull_thenCallsSetNonStrokingColor()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(null);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor3() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);
    arguments.add(COSBoolean.FALSE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor4() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);
    arguments.add(COSInteger.ONE);

    // Act
    setNonStrokingColor.process(operator, arguments);

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return
   *       {@link PDCalGray#PDCalGray()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDCalGray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDCalGray()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDCalGray());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return
   *       {@link PDCalRGB#PDCalRGB()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDCalRGB() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDCalRGB());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return
   *       {@link PDIndexed#PDIndexed()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDIndexed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDIndexed()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDIndexed());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return
   *       {@link PDLab#PDLab()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDLab()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDLab() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDLab());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return
   *       {@link PDSeparation#PDSeparation()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDSeparation()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDSeparation()
      throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDSeparation());

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_whenArrayList() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDPattern(new PDResources()));

    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    setNonStrokingColor.process(operator, new ArrayList<>());

    // Assert
    verify(context, atLeast(1)).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
    verify(pdGraphicsState).setNonStrokingColor(isA(PDColor.class));
  }
}
