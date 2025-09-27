package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionSequenceDiffblueTest {
  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link InstructionSequence} (default constructor) addName {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test execute(ExecutionContext); given InstructionSequence (default constructor) addName 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionSequence.execute(ExecutionContext)"})
  void testExecute_givenInstructionSequenceAddNameFoo() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addName("foo");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   *
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with operatorSet is {@link
   *       Operators} (default constructor) Stack Empty.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionSequence.execute(ExecutionContext)"})
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
   *
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with operatorSet is {@link
   *       Operators} (default constructor) Stack Empty.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionSequence.execute(ExecutionContext)"})
  void testExecute_thenExecutionContextWithOperatorSetIsOperatorsStackEmpty2() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addProc(new InstructionSequence());
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert that nothing has changed
    assertTrue(context.getStack().isEmpty());
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   *
   * <ul>
   *   <li>Then {@link ExecutionContext#ExecutionContext(Operators)} with operatorSet is {@link
   *       Operators} (default constructor) Stack size is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test execute(ExecutionContext); then ExecutionContext(Operators) with operatorSet is Operators (default constructor) Stack size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionSequence.execute(ExecutionContext)"})
  void testExecute_thenExecutionContextWithOperatorSetIsOperatorsStackSizeIsOne() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addInteger(42);
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert
    Stack<Object> stack = context.getStack();
    assertEquals(1, stack.size());
    assertEquals(42, ((Integer) stack.get(0)).intValue());
  }

  /**
   * Test {@link InstructionSequence#execute(ExecutionContext)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test execute(ExecutionContext); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionSequence.execute(ExecutionContext)"})
  void testExecute_thenThrowUnsupportedOperationException() {
    // Arrange
    InstructionSequence child = new InstructionSequence();
    child.addName("Name");

    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addProc(child);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }
}
