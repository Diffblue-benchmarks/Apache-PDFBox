package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Stack;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Abs;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Add;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Atan;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Ceiling;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Cos;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Cvi;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Cvr;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Div;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Exp;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Floor;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.IDiv;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Ln;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Log;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Mod;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Mul;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Neg;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Round;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Sin;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Sqrt;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Sub;
import org.apache.pdfbox.pdmodel.common.function.type4.ArithmeticOperators.Truncate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArithmeticOperatorsDiffblueTest {
  /**
   * Test Abs {@link Abs#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Abs#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Abs execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testAbsExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Abs {@link Abs#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Abs#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Abs execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testAbsExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Add {@link Add#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@code 42}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given Stack (default constructor) add '42'; when ExecutionContext popNumber() return 'A'")
  void testAddExecute_givenStackAdd42_whenExecutionContextPopNumberReturnA() {
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
   * Test Add {@link Add#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf {@link Integer#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf MAX_VALUE")
  void testAddExecute_givenValueOfMax_value() {
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
   * Test Add {@link Add#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf MIN_VALUE")
  void testAddExecute_givenValueOfMin_value() {
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
   * Test Add {@link Add#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testAddExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Atan {@link Atan#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code -0.5}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return
   * {@code -0.5}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Atan#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Atan execute(ExecutionContext); given '-0.5'; when ExecutionContext popReal() return '-0.5'; then calls getStack()")
  void testAtanExecute_given05_whenExecutionContextPopRealReturn05_thenCallsGetStack() {
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
   * Test Atan {@link Atan#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return
   * ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Atan#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Atan execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  void testAtanExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
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
   * Test Ceiling {@link Ceiling#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Ceiling#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ceiling execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testCeilingExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Ceiling {@link Ceiling#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Ceiling#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ceiling execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testCeilingExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Cos {@link Cos#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return
   * ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Cos#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cos execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  void testCosExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
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
   * Test Cvi {@link Cvi#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Cvi#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cvi execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testCviExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Cvr {@link Cvr#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Cvr#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cvr execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testCvrExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Div {@link Div#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Div#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Div execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testDivExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Exp {@link Exp#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Exp#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Exp execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testExpExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Floor {@link Floor#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Floor#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Floor execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testFloorExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Floor {@link Floor#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Floor#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Floor execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testFloorExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test IDiv {@link IDiv#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popInt()} return
   * one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.IDiv#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test IDiv execute(ExecutionContext); given one; when ExecutionContext popInt() return one; then calls getStack()")
  void testIDivExecute_givenOne_whenExecutionContextPopIntReturnOne_thenCallsGetStack() {
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
   * Test Ln {@link Ln#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Ln#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ln execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testLnExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Log {@link Log#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Log#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Log execute(ExecutionContext); given valueOf one; then calls getStack()")
  void testLogExecute_givenValueOfOne_thenCallsGetStack() {
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
   * Test Mod {@link Mod#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popInt()} return
   * one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Mod#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mod execute(ExecutionContext); given one; when ExecutionContext popInt() return one; then calls getStack()")
  void testModExecute_givenOne_whenExecutionContextPopIntReturnOne_thenCallsGetStack() {
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
   * Test Mul {@link Mul#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@link Stack} (default constructor) add {@code 42}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given Stack (default constructor) add '42'; when ExecutionContext popNumber() return 'A'")
  void testMulExecute_givenStackAdd42_whenExecutionContextPopNumberReturnA() {
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
   * Test Mul {@link Mul#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given valueOf MIN_VALUE")
  void testMulExecute_givenValueOfMin_value() {
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
   * Test Mul {@link Mul#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testMulExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Neg {@link Neg#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testNegExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Neg {@link Neg#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given valueOf MIN_VALUE")
  void testNegExecute_givenValueOfMin_value() {
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
   * Test Neg {@link Neg#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testNegExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Round {@link Round#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Round#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Round execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testRoundExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Round {@link Round#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Round#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Round execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testRoundExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Sin {@link Sin#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return
   * ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Sin#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sin execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  void testSinExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
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
   * Test Sqrt {@link Sqrt#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code -0.5}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Sqrt#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sqrt execute(ExecutionContext); given '-0.5'; then throw IllegalArgumentException")
  void testSqrtExecute_given05_thenThrowIllegalArgumentException() {
    // Arrange
    ArithmeticOperators.Sqrt sqrt = new ArithmeticOperators.Sqrt();
    ExecutionContext context = mock(ExecutionContext.class);
    when(context.popReal()).thenReturn(-0.5f);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> sqrt.execute(context));
    verify(context).popReal();
  }

  /**
   * Test Sqrt {@link Sqrt#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return
   * ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Sqrt#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sqrt execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  void testSqrtExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
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
   * Test Sub {@link Sub#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Sub#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sub execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  void testSubExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
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
   * Test Sub {@link Sub#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ArithmeticOperators.Sub#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sub execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  void testSubExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
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
   * Test Truncate {@link Truncate#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return
   * {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Truncate#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Truncate execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'")
  void testTruncateExecute_givenA_whenExecutionContextPopNumberReturnA() {
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

  /**
   * Test Truncate {@link Truncate#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given valueOf one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ArithmeticOperators.Truncate#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Truncate execute(ExecutionContext); given valueOf one")
  void testTruncateExecute_givenValueOfOne() {
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
}
