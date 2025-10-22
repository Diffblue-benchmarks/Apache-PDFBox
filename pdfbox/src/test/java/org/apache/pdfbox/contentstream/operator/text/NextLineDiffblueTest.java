package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NextLineDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NextLine#NextLine(PDFStreamEngine)}
   *   <li>{@link NextLine#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.<init>(PDFStreamEngine)", "String NextLine.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("T*", (new NextLine(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link NextLine#process(Operator, List)}.
   * <p>
   * Method under test: {@link NextLine#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.process(Operator, List)"})
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    NextLine nextLine = new NextLine(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    nextLine.process(operator, new ArrayList<>());

    // Assert
    verify(context).getGraphicsState();
    verify(context).processOperator(eq("Td"), isA(List.class));
  }

  /**
   * Test {@link NextLine#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDGraphicsState#getTextState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NextLine#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls getTextState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsGetTextState() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getTextState()).thenReturn(new PDTextState());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    NextLine nextLine = new NextLine(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    nextLine.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
    verify(context).processOperator(eq("Td"), isA(List.class));
    verify(pdGraphicsState).getTextState();
  }

  /**
   * Test {@link NextLine#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDGraphicsState#getTextState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NextLine#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls getTextState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsGetTextState2() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getTextState()).thenReturn(new PDTextState());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    NextLine nextLine = new NextLine(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    nextLine.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
    verify(context).processOperator(eq("Td"), isA(List.class));
    verify(pdGraphicsState).getTextState();
  }

  /**
   * Test {@link NextLine#process(Operator, List)}.
   * <ul>
   *   <li>Then calls {@link PDGraphicsState#getTextState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NextLine#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then calls getTextState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.process(Operator, List)"})
  void testProcess_thenCallsGetTextState() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getTextState()).thenReturn(new PDTextState());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    NextLine nextLine = new NextLine(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    nextLine.process(operator, new ArrayList<>());

    // Assert
    verify(context).getGraphicsState();
    verify(context).processOperator(eq("Td"), isA(List.class));
    verify(pdGraphicsState).getTextState();
  }

  /**
   * Test {@link NextLine#process(Operator, List)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NextLine#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NextLine.process(Operator, List)"})
  void testProcess_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException("Td")).when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    NextLine nextLine = new NextLine(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(IOException.class, () -> nextLine.process(operator, new ArrayList<>()));
    verify(context).getGraphicsState();
    verify(context).processOperator(eq("Td"), isA(List.class));
  }
}
