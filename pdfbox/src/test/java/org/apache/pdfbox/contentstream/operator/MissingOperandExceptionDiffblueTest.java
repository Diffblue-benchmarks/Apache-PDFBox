package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MissingOperandExceptionDiffblueTest {
  /**
   * Test {@link MissingOperandException#MissingOperandException(Operator, List)}.
   *
   * <p>Method under test: {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  @DisplayName("Test new MissingOperandException(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MissingOperandException.<init>(Operator, List)"})
  void testNewMissingOperandException() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    // Act
    MissingOperandException actualMissingOperandException =
        new MissingOperandException(operator, new ArrayList<>());

    // Assert
    assertEquals(
        "Operator Operator has too few operands: []",
        actualMissingOperandException.getLocalizedMessage());
    assertEquals(
        "Operator Operator has too few operands: []", actualMissingOperandException.getMessage());
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }

  /**
   * Test {@link MissingOperandException#MissingOperandException(Operator, List)}.
   *
   * <p>Method under test: {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  @DisplayName("Test new MissingOperandException(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MissingOperandException.<init>(Operator, List)"})
  void testNewMissingOperandException2() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    MissingOperandException actualMissingOperandException =
        new MissingOperandException(operator, operands);

    // Assert
    assertEquals(
        "Operator Operator has too few operands: [false]",
        actualMissingOperandException.getLocalizedMessage());
    assertEquals(
        "Operator Operator has too few operands: [false]",
        actualMissingOperandException.getMessage());
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }

  /**
   * Test {@link MissingOperandException#MissingOperandException(Operator, List)}.
   *
   * <p>Method under test: {@link MissingOperandException#MissingOperandException(Operator, List)}
   */
  @Test
  @DisplayName("Test new MissingOperandException(Operator, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MissingOperandException.<init>(Operator, List)"})
  void testNewMissingOperandException3() {
    // Arrange
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act
    MissingOperandException actualMissingOperandException =
        new MissingOperandException(operator, operands);

    // Assert
    assertEquals(
        "Operator Operator has too few operands: [false, false]",
        actualMissingOperandException.getLocalizedMessage());
    assertEquals(
        "Operator Operator has too few operands: [false, false]",
        actualMissingOperandException.getMessage());
    assertNull(actualMissingOperandException.getCause());
    assertEquals(0, actualMissingOperandException.getSuppressed().length);
  }
}
