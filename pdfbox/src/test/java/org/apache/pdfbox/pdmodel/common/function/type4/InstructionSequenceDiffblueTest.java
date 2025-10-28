package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class InstructionSequenceDiffblueTest {
  /**
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    ExecutionContext context = new ExecutionContext(new Operators());

    // Act
    instructionSequence.execute(context);

    // Assert that nothing has changed
    assertTrue(context.getStack().isEmpty());
  }

  /**
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute2() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addName("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }

  /**
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute3() {
    // Arrange
    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addInteger(2);
    instructionSequence.addName("Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }

  /**
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute4() {
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
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute5() {
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
   * Method under test: {@link InstructionSequence#execute(ExecutionContext)}
   */
  @Test
  void testExecute6() {
    // Arrange
    InstructionSequence child = new InstructionSequence();
    child.addName("Name");

    InstructionSequence instructionSequence = new InstructionSequence();
    instructionSequence.addProc(child);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> instructionSequence.execute(new ExecutionContext(new Operators())));
  }
}
