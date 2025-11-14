package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ShowTextAdjustedDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShowTextAdjusted#ShowTextAdjusted(PDFStreamEngine)}
   *   <li>{@link ShowTextAdjusted#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShowTextAdjusted.<init>(PDFStreamEngine)",
    "java.lang.String ShowTextAdjusted.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("TJ", new ShowTextAdjusted(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow() throws IOException {
    // Arrange
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> showTextAdjusted.process(operator, arguments));
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow2() throws IOException {
    // Arrange
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> showTextAdjusted.process(operator, arguments));
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#getTextMatrix()} return {@code
   *       null}.
   *   <li>Then calls {@link PDFStreamEngine#getTextMatrix()}.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine getTextMatrix() return 'null'; then calls getTextMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineGetTextMatrixReturnNull_thenCallsGetTextMatrix()
      throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getTextMatrix()).thenReturn(null);
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act
    showTextAdjusted.process(operator, arguments);

    // Assert
    verify(context).getTextMatrix();
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#showTextStrings(COSArray)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine showTextStrings(COSArray) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineShowTextStringsDoesNothing() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).showTextStrings(Mockito.<COSArray>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act
    showTextAdjusted.process(operator, arguments);

    // Assert
    verify(context).getTextMatrix();
    verify(context).showTextStrings(isA(COSArray.class));
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException()).when(context).showTextStrings(Mockito.<COSArray>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(IOException.class, () -> showTextAdjusted.process(operator, arguments));
    verify(context).getTextMatrix();
    verify(context).showTextStrings(isA(COSArray.class));
  }

  /**
   * Test {@link ShowTextAdjusted#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowTextAdjusted#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowTextAdjusted.process(Operator, List)"})
  void testProcess_whenArrayList_thenDoesNotThrow() throws IOException {
    // Arrange
    ShowTextAdjusted showTextAdjusted = new ShowTextAdjusted(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertDoesNotThrow(() -> showTextAdjusted.process(operator, new ArrayList<>()));
  }
}
