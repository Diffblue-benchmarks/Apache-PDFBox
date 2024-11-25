package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InstructionSequenceDiffblueTest {
  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@link InstructionSequence} (default constructor) addInteger
   * two.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); given InstructionSequence (default constructor) addInteger two")
  void testExecute_givenInstructionSequenceAddIntegerTwo() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addInteger(2);
    instructionSequence.addName("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@link InstructionSequence} (default constructor) addProc
   * {@link InstructionSequence} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); given InstructionSequence (default constructor) addProc InstructionSequence (default constructor)")
  void testExecute_givenInstructionSequenceAddProcInstructionSequence() {
    // Arrange
    InstructionSequence child = new InstructionSequence();
    child.addName("Name");

    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addProc(child);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with
   * operatorSet is {@link Operators} (default constructor) Stack Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack Empty")
  void testExecute_thenExecutionContextWithOperatorSetIsOperatorsStackEmpty() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert that nothing has changed
    assertTrue(context.getStack().isEmpty());
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with
   * operatorSet is {@link Operators} (default constructor) Stack Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack Empty")
  void testExecute_thenExecutionContextWithOperatorSetIsOperatorsStackEmpty2() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addProc(new InstructionSequence());
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert
    assertTrue(context.getStack().isEmpty());
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with
   * operatorSet is {@link Operators} (default constructor) Stack size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  void testExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addInteger(42);
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert
    assertEquals(1, context.getStack().size());
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); then throw UnsupportedOperationException")
  void testExecute_thenThrowUnsupportedOperationException() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addName("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }
}
