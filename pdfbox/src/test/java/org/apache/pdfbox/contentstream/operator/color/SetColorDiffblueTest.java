package org.apache.pdfbox.contentstream.operator.color;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
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
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess2() throws IOException {
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
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess3() throws IOException {
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

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess5() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDICCBased(new PDDocument()));
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
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given A; when ArrayList() add A; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSName#A}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given A; when ArrayList() add A; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSArray(); when ArrayList() add COSArray(); then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenCOSArray_whenArrayListAddCOSArray_thenCallsSetNonStrokingColor() throws IOException {
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
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSetNonStrokingColor() throws IOException {
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
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSetNonStrokingColor2() throws IOException {
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
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given 'null'; when ArrayList() add 'null'; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenNull_whenArrayListAddNull_thenCallsSetNonStrokingColor() throws IOException {
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
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDICCBased(new PDDocument()));
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
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsSetNonStrokingColor2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    doNothing().when(pdGraphicsState).setNonStrokingColor(Mockito.<PDColor>any());
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDICCBased(new PDDocument()));
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
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link PDGraphicsState#setNonStrokingColor(PDColor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls setNonStrokingColor(PDColor)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDDeviceRGB#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return INSTANCE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnInstance() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(PDDeviceRGB.INSTANCE);
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, arguments));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDCalGray#PDCalGray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDCalGray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDCalGray() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDCalGray());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDCalRGB#PDCalRGB()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDCalRGB()")
  @Tag("MaintainedByDiffblue")
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
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDIndexed#PDIndexed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDIndexed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDIndexed() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDIndexed());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDLab#PDLab()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDLab()")
  @Tag("MaintainedByDiffblue")
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
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }

  /**
   * Test {@link SetColor#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PDGraphicsState} {@link PDGraphicsState#getNonStrokingColorSpace()} return {@link PDSeparation#PDSeparation()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetColor#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PDGraphicsState getNonStrokingColorSpace() return PDSeparation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SetColor.process(Operator, List)"})
  void testProcess_givenPDGraphicsStateGetNonStrokingColorSpaceReturnPDSeparation() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getNonStrokingColorSpace()).thenReturn(new PDSeparation());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetNonStrokingColor setNonStrokingColor = new SetNonStrokingColor(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setNonStrokingColor.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getNonStrokingColorSpace();
  }
}
