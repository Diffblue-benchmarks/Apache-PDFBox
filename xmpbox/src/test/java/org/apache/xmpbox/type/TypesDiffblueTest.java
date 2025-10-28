package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TypesDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Types#getBasic()}
   *   <li>{@link Types#getImplementingClass()}
   *   <li>{@link Types#isSimple()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    Types valueOfResult = Types.valueOf("Structured");

    // Act
    Types actualBasic = valueOfResult.getBasic();
    Class<? extends AbstractField> actualImplementingClass = valueOfResult.getImplementingClass();

    // Assert
    assertNull(actualImplementingClass);
    assertNull(actualBasic);
    assertFalse(valueOfResult.isSimple());
  }

  /**
   * Method under test: {@link Types#isBasic()}
   */
  @Test
  void testIsBasic() {
    // Arrange, Act and Assert
    assertTrue(Types.Structured.isBasic());
    assertFalse(Types.GPSCoordinate.isBasic());
  }

  /**
   * Method under test: {@link Types#isDefined()}
   */
  @Test
  void testIsDefined() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isDefined());
    assertTrue(Types.DefinedType.isDefined());
  }

  /**
   * Method under test: {@link Types#isStructured()}
   */
  @Test
  void testIsStructured() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isStructured());
  }
}
