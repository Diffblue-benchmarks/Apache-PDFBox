package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TypesDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Types#getBasic()}
   *   <li>{@link Types#getImplementingClass()}
   *   <li>{@link Types#isSimple()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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
   * Test {@link Types#isBasic()}.
   * <ul>
   *   <li>Given {@code GPSCoordinate}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Types#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); given 'GPSCoordinate'; then return 'false'")
  void testIsBasic_givenGPSCoordinate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Types.GPSCoordinate.isBasic());
  }

  /**
   * Test {@link Types#isBasic()}.
   * <ul>
   *   <li>Given {@code Structured}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Types#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); given 'Structured'; then return 'true'")
  void testIsBasic_givenStructured_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Types.Structured.isBasic());
  }

  /**
   * Test {@link Types#isDefined()}.
   * <ul>
   *   <li>Given {@link Types#DefinedType}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Types#isDefined()}
   */
  @Test
  @DisplayName("Test isDefined(); given DefinedType; then return 'true'")
  void testIsDefined_givenDefinedType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Types.DefinedType.isDefined());
  }

  /**
   * Test {@link Types#isDefined()}.
   * <ul>
   *   <li>Given {@code Structured}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Types#isDefined()}
   */
  @Test
  @DisplayName("Test isDefined(); given 'Structured'; then return 'false'")
  void testIsDefined_givenStructured_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isDefined());
  }

  /**
   * Test {@link Types#isStructured()}.
   * <p>
   * Method under test: {@link Types#isStructured()}
   */
  @Test
  @DisplayName("Test isStructured()")
  void testIsStructured() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isStructured());
  }
}
