package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class ArithmeticOperatorsDiffblueTest {
  /**
   * Method under test: {@link ArithmeticOperators.Abs#execute(ExecutionContext)}
   */
  @Test
  void testAbsExecute() {
    // Arrange
    ArithmeticOperators.Abs abs = new ArithmeticOperators.Abs();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    abs.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Abs#execute(ExecutionContext)}
   */
  @Test
  void testAbsExecute2() {
    // Arrange
    ArithmeticOperators.Abs abs = new ArithmeticOperators.Abs();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    abs.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  void testAddExecute() {
    // Arrange
    ArithmeticOperators.Add add = new ArithmeticOperators.Add();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(1));

    // Act
    add.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  void testAddExecute2() {
    // Arrange
    ArithmeticOperators.Add add = new ArithmeticOperators.Add();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(Integer.MIN_VALUE));

    // Act
    add.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  void testAddExecute3() {
    // Arrange
    ArithmeticOperators.Add add = new ArithmeticOperators.Add();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(Integer.MAX_VALUE));

    // Act
    add.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  void testAddExecute4() {
    // Arrange
    ArithmeticOperators.Add add = new ArithmeticOperators.Add();

    Stack<Object> objectList = new Stack<>();
    objectList.add("42");
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(objectList);
    when(context.popNumber()).thenReturn((byte) 'A');

    // Act
    add.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Atan#execute(ExecutionContext)}
   */
  @Test
  void testAtanExecute() {
    // Arrange
    ArithmeticOperators.Atan atan = new ArithmeticOperators.Atan();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(10.0f);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    atan.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popReal();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Atan#execute(ExecutionContext)}
   */
  @Test
  void testAtanExecute2() {
    // Arrange
    ArithmeticOperators.Atan atan = new ArithmeticOperators.Atan();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(-0.5f);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    atan.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popReal();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Ceiling#execute(ExecutionContext)}
   */
  @Test
  void testCeilingExecute() {
    // Arrange
    ArithmeticOperators.Ceiling ceiling = new ArithmeticOperators.Ceiling();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    ceiling.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Ceiling#execute(ExecutionContext)}
   */
  @Test
  void testCeilingExecute2() {
    // Arrange
    ArithmeticOperators.Ceiling ceiling = new ArithmeticOperators.Ceiling();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    ceiling.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Cos#execute(ExecutionContext)}
   */
  @Test
  void testCosExecute() {
    // Arrange
    ArithmeticOperators.Cos cos = new ArithmeticOperators.Cos();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(10.0f);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    cos.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popReal();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Cvi#execute(ExecutionContext)}
   */
  @Test
  void testCviExecute() {
    // Arrange
    ArithmeticOperators.Cvi cvi = new ArithmeticOperators.Cvi();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    cvi.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Cvr#execute(ExecutionContext)}
   */
  @Test
  void testCvrExecute() {
    // Arrange
    ArithmeticOperators.Cvr cvr = new ArithmeticOperators.Cvr();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    cvr.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Div#execute(ExecutionContext)}
   */
  @Test
  void testDivExecute() {
    // Arrange
    ArithmeticOperators.Div div = new ArithmeticOperators.Div();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    div.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Exp#execute(ExecutionContext)}
   */
  @Test
  void testExpExecute() {
    // Arrange
    ArithmeticOperators.Exp exp = new ArithmeticOperators.Exp();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(1));

    // Act
    exp.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Floor#execute(ExecutionContext)}
   */
  @Test
  void testFloorExecute() {
    // Arrange
    ArithmeticOperators.Floor floor = new ArithmeticOperators.Floor();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    floor.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Floor#execute(ExecutionContext)}
   */
  @Test
  void testFloorExecute2() {
    // Arrange
    ArithmeticOperators.Floor floor = new ArithmeticOperators.Floor();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    floor.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.IDiv#execute(ExecutionContext)}
   */
  @Test
  void testIDivExecute() {
    // Arrange
    ArithmeticOperators.IDiv iDiv = new ArithmeticOperators.IDiv();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popInt()).thenReturn(1);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    iDiv.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popInt();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Ln#execute(ExecutionContext)}
   */
  @Test
  void testLnExecute() {
    // Arrange
    ArithmeticOperators.Ln ln = new ArithmeticOperators.Ln();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    ln.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Log#execute(ExecutionContext)}
   */
  @Test
  void testLogExecute() {
    // Arrange
    ArithmeticOperators.Log log = new ArithmeticOperators.Log();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    log.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Mod#execute(ExecutionContext)}
   */
  @Test
  void testModExecute() {
    // Arrange
    ArithmeticOperators.Mod mod = new ArithmeticOperators.Mod();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popInt()).thenReturn(1);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    mod.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popInt();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  void testMulExecute() {
    // Arrange
    ArithmeticOperators.Mul mul = new ArithmeticOperators.Mul();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(1));

    // Act
    mul.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  void testMulExecute2() {
    // Arrange
    ArithmeticOperators.Mul mul = new ArithmeticOperators.Mul();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(new Stack<>());
    when(context.popNumber()).thenReturn(Integer.valueOf(Integer.MIN_VALUE));

    // Act
    mul.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  void testMulExecute3() {
    // Arrange
    ArithmeticOperators.Mul mul = new ArithmeticOperators.Mul();

    Stack<Object> objectList = new Stack<>();
    objectList.add("42");
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.getStack()).thenReturn(objectList);
    when(context.popNumber()).thenReturn((byte) 'A');

    // Act
    mul.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  void testNegExecute() {
    // Arrange
    ArithmeticOperators.Neg neg = new ArithmeticOperators.Neg();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    neg.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  void testNegExecute2() {
    // Arrange
    ArithmeticOperators.Neg neg = new ArithmeticOperators.Neg();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(Integer.MIN_VALUE));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    neg.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  void testNegExecute3() {
    // Arrange
    ArithmeticOperators.Neg neg = new ArithmeticOperators.Neg();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    neg.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Round#execute(ExecutionContext)}
   */
  @Test
  void testRoundExecute() {
    // Arrange
    ArithmeticOperators.Round round = new ArithmeticOperators.Round();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    round.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Round#execute(ExecutionContext)}
   */
  @Test
  void testRoundExecute2() {
    // Arrange
    ArithmeticOperators.Round round = new ArithmeticOperators.Round();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    round.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Sin#execute(ExecutionContext)}
   */
  @Test
  void testSinExecute() {
    // Arrange
    ArithmeticOperators.Sin sin = new ArithmeticOperators.Sin();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(10.0f);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    sin.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popReal();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Sqrt#execute(ExecutionContext)}
   */
  @Test
  void testSqrtExecute() {
    // Arrange
    ArithmeticOperators.Sqrt sqrt = new ArithmeticOperators.Sqrt();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(10.0f);
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    sqrt.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popReal();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Sqrt#execute(ExecutionContext)}
   */
  @Test
  void testSqrtExecute2() {
    // Arrange
    ArithmeticOperators.Sqrt sqrt = new ArithmeticOperators.Sqrt();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(-0.5f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sqrt.execute(context));
    verify(context).popReal();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Sub#execute(ExecutionContext)}
   */
  @Test
  void testSubExecute() {
    // Arrange
    ArithmeticOperators.Sub sub = new ArithmeticOperators.Sub();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    sub.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test: {@link ArithmeticOperators.Sub#execute(ExecutionContext)}
   */
  @Test
  void testSubExecute2() {
    // Arrange
    ArithmeticOperators.Sub sub = new ArithmeticOperators.Sub();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    sub.execute(context);

    // Assert
    verify(context).getStack();
    verify(context, atLeast(1)).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Truncate#execute(ExecutionContext)}
   */
  @Test
  void testTruncateExecute() {
    // Arrange
    ArithmeticOperators.Truncate truncate = new ArithmeticOperators.Truncate();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn(Integer.valueOf(1));
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    truncate.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }

  /**
   * Method under test:
   * {@link ArithmeticOperators.Truncate#execute(ExecutionContext)}
   */
  @Test
  void testTruncateExecute2() {
    // Arrange
    ArithmeticOperators.Truncate truncate = new ArithmeticOperators.Truncate();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popNumber()).thenReturn((byte) 'A');
    when(context.getStack()).thenReturn(new Stack<>());

    // Act
    truncate.execute(context);

    // Assert
    verify(context).getStack();
    verify(context).popNumber();
  }
}
