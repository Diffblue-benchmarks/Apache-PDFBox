package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetTextRiseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetTextRise#SetTextRise(PDFStreamEngine)}
   *   <li>{@link SetTextRise#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetTextRise.<init>(PDFStreamEngine)",
    "java.lang.String SetTextRise.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Ts", new SetTextRise(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat} {@link COSFloat#floatValue()} return ten.
   *   <li>Then calls {@link COSFloat#floatValue()}.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat floatValue() return ten; then calls floatValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRise.process(Operator, List)"})
  void testProcess_givenCOSFloatFloatValueReturnTen_thenCallsFloatValue() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
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
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then calls getGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRise.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenCallsGetGraphicsState() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getGraphicsState()).thenReturn(new PDGraphicsState(PDRectangle.A0));
    SetTextRise setTextRise = new SetTextRise(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act
    setTextRise.process(operator, arguments);

    // Assert
    verify(context).getGraphicsState();
  }

  /**
   * Test {@link SetTextRise#process(Operator, List)}.
   *
   * <ul>
   *   <li>Then calls {@link PDFStreamEngine#getGraphicsState()}.
   * </ul>
   *
   * <p>Method under test: {@link SetTextRise#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then calls getGraphicsState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetTextRise.process(Operator, List)"})
  void testProcess_thenCallsGetGraphicsState() throws IOException {
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
}
