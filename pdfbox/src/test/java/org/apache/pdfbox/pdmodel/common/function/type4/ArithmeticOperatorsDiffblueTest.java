package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArithmeticOperatorsDiffblueTest {
  /**
   * Test Abs {@link Abs#execute(ExecutionContext)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Abs#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Abs execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Abs.execute(ExecutionContext)"})
  void testAbsExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Abs abs = new Abs();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Abs#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Abs execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Abs.execute(ExecutionContext)"})
  void testAbsExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Abs abs = new Abs();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given Stack (default constructor) add '42'; when ExecutionContext popNumber() return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Add.execute(ExecutionContext)"})
  void testAddExecute_givenStackAdd42_whenExecutionContextPopNumberReturnA() {
    // Arrange
    Add add = new Add();

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
   * Method under test: {@link Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Add.execute(ExecutionContext)"})
  void testAddExecute_givenValueOfMax_value() {
    // Arrange
    Add add = new Add();
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
   * Method under test: {@link Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Add.execute(ExecutionContext)"})
  void testAddExecute_givenValueOfMin_value() {
    // Arrange
    Add add = new Add();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Add#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Add execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Add.execute(ExecutionContext)"})
  void testAddExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Add add = new Add();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return {@code -0.5}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Atan#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Atan execute(ExecutionContext); given '-0.5'; when ExecutionContext popReal() return '-0.5'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Atan.execute(ExecutionContext)"})
  void testAtanExecute_given05_whenExecutionContextPopRealReturn05_thenCallsGetStack() {
    // Arrange
    Atan atan = new Atan();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Atan#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Atan execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Atan.execute(ExecutionContext)"})
  void testAtanExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
    // Arrange
    Atan atan = new Atan();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ceiling#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ceiling execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Ceiling.execute(ExecutionContext)"})
  void testCeilingExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Ceiling ceiling = new Ceiling();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Ceiling#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ceiling execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Ceiling.execute(ExecutionContext)"})
  void testCeilingExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Ceiling ceiling = new Ceiling();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Cos#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cos execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Cos.execute(ExecutionContext)"})
  void testCosExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
    // Arrange
    Cos cos = new Cos();
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
   * Method under test: {@link Cvi#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cvi execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Cvi.execute(ExecutionContext)"})
  void testCviExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Cvi cvi = new Cvi();
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
   * Method under test: {@link Cvr#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Cvr execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Cvr.execute(ExecutionContext)"})
  void testCvrExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Cvr cvr = new Cvr();
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
   * Method under test: {@link Div#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Div execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Div.execute(ExecutionContext)"})
  void testDivExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Div div = new Div();
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
   * Method under test: {@link Exp#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Exp execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Exp.execute(ExecutionContext)"})
  void testExpExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Exp exp = new Exp();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Floor#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Floor execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Floor.execute(ExecutionContext)"})
  void testFloorExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Floor floor = new Floor();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Floor#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Floor execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Floor.execute(ExecutionContext)"})
  void testFloorExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Floor floor = new Floor();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popInt()} return one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link IDiv#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test IDiv execute(ExecutionContext); given one; when ExecutionContext popInt() return one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IDiv.execute(ExecutionContext)"})
  void testIDivExecute_givenOne_whenExecutionContextPopIntReturnOne_thenCallsGetStack() {
    // Arrange
    IDiv iDiv = new IDiv();
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
   * Method under test: {@link Ln#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Ln execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Ln.execute(ExecutionContext)"})
  void testLnExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Ln ln = new Ln();
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
   * Method under test: {@link Log#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Log execute(ExecutionContext); given valueOf one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Log.execute(ExecutionContext)"})
  void testLogExecute_givenValueOfOne_thenCallsGetStack() {
    // Arrange
    Log log = new Log();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popInt()} return one.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mod#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mod execute(ExecutionContext); given one; when ExecutionContext popInt() return one; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Mod.execute(ExecutionContext)"})
  void testModExecute_givenOne_whenExecutionContextPopIntReturnOne_thenCallsGetStack() {
    // Arrange
    Mod mod = new Mod();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given Stack (default constructor) add '42'; when ExecutionContext popNumber() return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Mul.execute(ExecutionContext)"})
  void testMulExecute_givenStackAdd42_whenExecutionContextPopNumberReturnA() {
    // Arrange
    Mul mul = new Mul();

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
   * Method under test: {@link Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given valueOf MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Mul.execute(ExecutionContext)"})
  void testMulExecute_givenValueOfMin_value() {
    // Arrange
    Mul mul = new Mul();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Mul#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Mul execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Mul.execute(ExecutionContext)"})
  void testMulExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Mul mul = new Mul();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Neg.execute(ExecutionContext)"})
  void testNegExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Neg neg = new Neg();
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
   * Method under test: {@link Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given valueOf MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Neg.execute(ExecutionContext)"})
  void testNegExecute_givenValueOfMin_value() {
    // Arrange
    Neg neg = new Neg();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Neg#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Neg execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Neg.execute(ExecutionContext)"})
  void testNegExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Neg neg = new Neg();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Round#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Round execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Round.execute(ExecutionContext)"})
  void testRoundExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Round round = new Round();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Round#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Round execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Round.execute(ExecutionContext)"})
  void testRoundExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Round round = new Round();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sin#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sin execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Sin.execute(ExecutionContext)"})
  void testSinExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
    // Arrange
    Sin sin = new Sin();
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
   * Method under test: {@link Sqrt#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sqrt execute(ExecutionContext); given '-0.5'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Sqrt.execute(ExecutionContext)"})
  void testSqrtExecute_given05_thenThrowIllegalArgumentException() {
    // Arrange
    Sqrt sqrt = new Sqrt();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popReal()} return ten.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sqrt#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sqrt execute(ExecutionContext); given ten; when ExecutionContext popReal() return ten; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Sqrt.execute(ExecutionContext)"})
  void testSqrtExecute_givenTen_whenExecutionContextPopRealReturnTen_thenCallsGetStack() {
    // Arrange
    Sqrt sqrt = new Sqrt();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   *   <li>Then calls {@link ExecutionContext#getStack()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sub#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sub execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'; then calls getStack()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Sub.execute(ExecutionContext)"})
  void testSubExecute_givenA_whenExecutionContextPopNumberReturnA_thenCallsGetStack() {
    // Arrange
    Sub sub = new Sub();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return valueOf one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Sub#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Sub execute(ExecutionContext); given valueOf one; when ExecutionContext popNumber() return valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Sub.execute(ExecutionContext)"})
  void testSubExecute_givenValueOfOne_whenExecutionContextPopNumberReturnValueOfOne() {
    // Arrange
    Sub sub = new Sub();
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
   *   <li>When {@link ExecutionContext} {@link ExecutionContext#popNumber()} return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Truncate#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Truncate execute(ExecutionContext); given 'A'; when ExecutionContext popNumber() return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Truncate.execute(ExecutionContext)"})
  void testTruncateExecute_givenA_whenExecutionContextPopNumberReturnA() {
    // Arrange
    Truncate truncate = new Truncate();
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
   * Method under test: {@link Truncate#execute(ExecutionContext)}
   */
  @Test
  @DisplayName("Test Truncate execute(ExecutionContext); given valueOf one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Truncate.execute(ExecutionContext)"})
  void testTruncateExecute_givenValueOfOne() {
    // Arrange
    Truncate truncate = new Truncate();
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
