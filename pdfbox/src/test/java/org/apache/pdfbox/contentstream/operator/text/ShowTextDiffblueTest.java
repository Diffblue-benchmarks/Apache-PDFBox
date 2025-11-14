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
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ShowTextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ShowText#ShowText(PDFStreamEngine)}
   *   <li>{@link ShowText#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ShowText.<init>(PDFStreamEngine)",
    "java.lang.String ShowText.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tj", new ShowText(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow() throws IOException {
    // Arrange
    ShowText showText = new ShowText(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> showText.process(operator, arguments));
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenDoesNotThrow2() throws IOException {
    // Arrange
    ShowText showText = new ShowText(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertDoesNotThrow(() -> showText.process(operator, arguments));
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#getTextMatrix()} return {@code
   *       null}.
   *   <li>Then calls {@link PDFStreamEngine#getTextMatrix()}.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine getTextMatrix() return 'null'; then calls getTextMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineGetTextMatrixReturnNull_thenCallsGetTextMatrix()
      throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    when(context.getTextMatrix()).thenReturn(null);
    ShowText showText = new ShowText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSString.parseHex("0123456789ABCDEF"));

    // Act
    showText.process(operator, arguments);

    // Assert
    verify(context).getTextMatrix();
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#showTextString(byte[])} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine showTextString(byte[]) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineShowTextStringDoesNothing() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).showTextString(Mockito.<byte[]>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowText showText = new ShowText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSString.parseHex("0123456789ABCDEF"));

    // Act
    showText.process(operator, arguments);

    // Assert
    verify(context).getTextMatrix();
    verify(context).showTextString(isA(byte[].class));
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_thenThrowIOException() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException()).when(context).showTextString(Mockito.<byte[]>any());
    when(context.getTextMatrix()).thenReturn(new Matrix());
    ShowText showText = new ShowText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSString.parseHex("0123456789ABCDEF"));

    // Act and Assert
    assertThrows(IOException.class, () -> showText.process(operator, arguments));
    verify(context).getTextMatrix();
    verify(context).showTextString(isA(byte[].class));
  }

  /**
   * Test {@link ShowText#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ShowText#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ShowText.process(Operator, List)"})
  void testProcess_whenArrayList_thenDoesNotThrow() throws IOException {
    // Arrange
    ShowText showText = new ShowText(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertDoesNotThrow(() -> showText.process(operator, new ArrayList<>()));
  }
}
