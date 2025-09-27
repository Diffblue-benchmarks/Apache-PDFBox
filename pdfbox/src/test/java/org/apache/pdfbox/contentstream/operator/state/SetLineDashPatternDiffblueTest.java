package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetLineDashPatternDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetLineDashPattern#SetLineDashPattern(PDFStreamEngine)}
   *   <li>{@link SetLineDashPattern#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetLineDashPattern.<init>(PDFStreamEngine)",
    "java.lang.String SetLineDashPattern.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d", new SetLineDashPattern(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSName#A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given A; when ArrayList() add A; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenA_whenArrayListAddA_thenThrowMissingOperandException()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSArray(); when ArrayList() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenCOSArray_whenArrayListAddCOSArray() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSDictionary(); when ArrayList() add COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenCOSDictionary_whenArrayListAddCOSDictionary()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSDictionary());

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)} with aFloat is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(2L, 2));
    arguments.add(cosObject);

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException2()
      throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(
        MissingOperandException.class, () -> setLineDashPattern.process(operator, arguments));
  }

  /**
   * Test {@link SetLineDashPattern#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineDashPattern#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineDashPattern.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws MissingOperandException {
    // Arrange
    SetLineDashPattern setLineDashPattern = new SetLineDashPattern(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setLineDashPattern.process(operator, new ArrayList<>()));
  }
}
