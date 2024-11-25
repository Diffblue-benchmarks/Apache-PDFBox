package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.pdmodel.graphics.state.PDTextState;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SetTextRiseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SetTextRise#SetTextRise(PDFStreamEngine)}
   *   <li>{@link SetTextRise#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Ts", (new SetTextRise(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   * <p>
   * Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List)")
  void testProcess() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetTextRise setTextRise = new SetTextRise(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act
    setTextRise.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat} {@link COSFloat#floatValue()} return ten.</li>
   *   <li>Then calls {@link COSFloat#floatValue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat floatValue() return ten; then calls floatValue()")
  void testProcess_givenCOSFloatFloatValueReturnTen_thenCallsFloatValue() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getTextState()).thenReturn(new PDTextState());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetTextRise setTextRise = new SetTextRise(context);
    Operator operator = Operator.getOperator("Operator");
    COSFloat cosFloat = mock(COSFloat.class);
    when(cosFloat.floatValue()).thenReturn(10.0f);

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(cosFloat);

    // Act
    setTextRise.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
    verify(cosFloat).floatValue();
    verify(pdGraphicsState).getTextState();
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link PDGraphicsState#getTextState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls getTextState()")
  void testProcess_givenOne_whenArrayListAddOne_thenCallsGetTextState() throws IOException {
    // Arrange
    PDGraphicsState pdGraphicsState = mock(PDGraphicsState.class);
    when(pdGraphicsState.getTextState()).thenReturn(new PDTextState());
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(pdGraphicsState);
    SetTextRise setTextRise = new SetTextRise(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act
    setTextRise.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
    verify(pdGraphicsState).getTextState();
  }
}
