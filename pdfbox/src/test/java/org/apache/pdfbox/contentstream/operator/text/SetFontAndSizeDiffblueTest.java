package org.apache.pdfbox.contentstream.operator.text;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetFontAndSizeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetFontAndSize#SetFontAndSize(PDFStreamEngine)}
   *   <li>{@link SetFontAndSize#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetFontAndSize.<init>(PDFStreamEngine)",
    "java.lang.String SetFontAndSize.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Tf", new SetFontAndSize(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given A; when ArrayList() add A; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenA_whenArrayListAddA_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenCOSDictionary_whenArrayListAddCOSDictionary() throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSDictionary());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)} with aFloat is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen()
      throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException()
      throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException2()
      throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> setFontAndSize.process(operator, arguments));
  }

  /**
   * Test {@link SetFontAndSize#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetFontAndSize#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetFontAndSize.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetFontAndSize setFontAndSize = new SetFontAndSize(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setFontAndSize.process(operator, new ArrayList<>()));
  }
}
