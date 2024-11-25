package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CurveToReplicateFinalPointDiffblueTest {
  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is
   * {@code -3.4028235E38}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat(float) with aFloat is '-3.4028235E38'")
  void testProcess_givenCOSFloatWithAFloatIs34028235e38() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSFloat(-3.4028235E38f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)}
   * with aFloat is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException2() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException2() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, operands));
  }

  /**
   * Test {@link CurveToReplicateFinalPoint#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CurveToReplicateFinalPoint#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    CurveToReplicateFinalPoint curveToReplicateFinalPoint = new CurveToReplicateFinalPoint(null);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> curveToReplicateFinalPoint.process(operator, new ArrayList<>()));
  }
}
