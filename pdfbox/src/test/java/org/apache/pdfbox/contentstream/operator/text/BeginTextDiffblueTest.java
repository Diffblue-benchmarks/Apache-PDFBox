package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BeginTextDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BeginText#BeginText(PDFStreamEngine)}
   *   <li>{@link BeginText#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeginText.<init>(PDFStreamEngine)",
    "java.lang.String BeginText.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("BT", new BeginText(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link BeginText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PDFStreamEngine#beginText()}.
   * </ul>
   *
   * <p>Method under test: {@link BeginText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls beginText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginText.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsBeginText() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).beginText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    BeginText beginText = new BeginText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    beginText.process(operator, arguments);

    // Assert
    verify(context).beginText();
    verify(context).setTextLineMatrix(isA(Matrix.class));
    verify(context).setTextMatrix(isA(Matrix.class));
  }

  /**
   * Test {@link BeginText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link PDFStreamEngine#beginText()}.
   * </ul>
   *
   * <p>Method under test: {@link BeginText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls beginText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginText.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsBeginText2() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).beginText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    BeginText beginText = new BeginText(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    beginText.process(operator, arguments);

    // Assert
    verify(context).beginText();
    verify(context).setTextLineMatrix(isA(Matrix.class));
    verify(context).setTextMatrix(isA(Matrix.class));
  }

  /**
   * Test {@link BeginText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#beginText()} does nothing.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BeginText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine beginText() does nothing; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginText.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineBeginTextDoesNothing_whenArrayList() throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).beginText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    BeginText beginText = new BeginText(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    beginText.process(operator, new ArrayList<>());

    // Assert
    verify(context).beginText();
    verify(context).setTextLineMatrix(isA(Matrix.class));
    verify(context).setTextMatrix(isA(Matrix.class));
  }

  /**
   * Test {@link BeginText#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link PDFStreamEngine} {@link PDFStreamEngine#beginText()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link BeginText#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given PDFStreamEngine beginText() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginText.process(Operator, List)"})
  void testProcess_givenPDFStreamEngineBeginTextThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doThrow(new IOException()).when(context).beginText();
    doNothing().when(context).setTextLineMatrix(Mockito.<Matrix>any());
    doNothing().when(context).setTextMatrix(Mockito.<Matrix>any());
    BeginText beginText = new BeginText(context);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(IOException.class, () -> beginText.process(operator, new ArrayList<>()));
    verify(context).beginText();
    verify(context).setTextLineMatrix(isA(Matrix.class));
    verify(context).setTextMatrix(isA(Matrix.class));
  }
}
