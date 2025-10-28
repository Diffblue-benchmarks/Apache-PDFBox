package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RelationalOperatorsDiffblueTest {
  /**
   * Method under test: {@link RelationalOperators.Eq#isEqual(Object, Object)}
   */
  @Test
  void testEqIsEqual() {
    // Arrange, Act and Assert
    assertFalse((new RelationalOperators.Eq()).isEqual("Op1", "Op2"));
    assertFalse((new RelationalOperators.Eq()).isEqual((byte) 'A', "Op2"));
    assertTrue((new RelationalOperators.Eq()).isEqual("Op2", "Op2"));
    assertTrue((new RelationalOperators.Eq()).isEqual((byte) 'A', (byte) 'A'));
    assertFalse((new RelationalOperators.Eq()).isEqual((byte) 'A', 1));
  }

  /**
   * Method under test: {@link RelationalOperators.Ge#compare(Number, Number)}
   */
  @Test
  void testGeCompare() {
    // Arrange
    RelationalOperators.Ge ge = new RelationalOperators.Ge();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertTrue(ge.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Ge#compare(Number, Number)}
   */
  @Test
  void testGeCompare2() {
    // Arrange
    RelationalOperators.Ge ge = new RelationalOperators.Ge();
    Integer num1 = Integer.valueOf(0);

    // Act and Assert
    assertFalse(ge.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Gt#compare(Number, Number)}
   */
  @Test
  void testGtCompare() {
    // Arrange
    RelationalOperators.Gt gt = new RelationalOperators.Gt();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertFalse(gt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Gt#compare(Number, Number)}
   */
  @Test
  void testGtCompare2() {
    // Arrange
    RelationalOperators.Gt gt = new RelationalOperators.Gt();

    // Act and Assert
    assertTrue(gt.compare(10, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Le#compare(Number, Number)}
   */
  @Test
  void testLeCompare() {
    // Arrange
    RelationalOperators.Le le = new RelationalOperators.Le();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertTrue(le.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Le#compare(Number, Number)}
   */
  @Test
  void testLeCompare2() {
    // Arrange
    RelationalOperators.Le le = new RelationalOperators.Le();

    // Act and Assert
    assertFalse(le.compare(10, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Lt#compare(Number, Number)}
   */
  @Test
  void testLtCompare() {
    // Arrange
    RelationalOperators.Lt lt = new RelationalOperators.Lt();
    Integer num1 = Integer.valueOf(1);

    // Act and Assert
    assertFalse(lt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Lt#compare(Number, Number)}
   */
  @Test
  void testLtCompare2() {
    // Arrange
    RelationalOperators.Lt lt = new RelationalOperators.Lt();
    Integer num1 = Integer.valueOf(0);

    // Act and Assert
    assertTrue(lt.compare(num1, Integer.valueOf(1)));
  }

  /**
   * Method under test: {@link RelationalOperators.Ne#isEqual(Object, Object)}
   */
  @Test
  void testNeIsEqual() {
    // Arrange, Act and Assert
    assertTrue((new RelationalOperators.Ne()).isEqual("Op1", "Op2"));
    assertTrue((new RelationalOperators.Ne()).isEqual((byte) 'A', "Op2"));
    assertFalse((new RelationalOperators.Ne()).isEqual("Op2", "Op2"));
    assertFalse((new RelationalOperators.Ne()).isEqual((byte) 'A', (byte) 'A'));
    assertTrue((new RelationalOperators.Ne()).isEqual((byte) 'A', 1));
  }
}
