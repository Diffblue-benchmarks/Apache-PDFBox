package org.apache.xmpbox.type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TypesDiffblueTest {
  /**
   * Test {@link Types#isBasic()}.
   *
   * <ul>
   *   <li>Given {@code GPSCoordinate}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Types#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); given 'GPSCoordinate'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Types.isBasic()"})
  void testIsBasic_givenGPSCoordinate_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Types.GPSCoordinate.isBasic());
  }

  /**
   * Test {@link Types#isBasic()}.
   *
   * <ul>
   *   <li>Given {@code Structured}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Types#isBasic()}
   */
  @Test
  @DisplayName("Test isBasic(); given 'Structured'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Types.isBasic()"})
  void testIsBasic_givenStructured_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Types.Structured.isBasic());
  }

  /**
   * Test {@link Types#isStructured()}.
   *
   * <p>Method under test: {@link Types#isStructured()}
   */
  @Test
  @DisplayName("Test isStructured()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Types.isStructured()"})
  void testIsStructured() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isStructured());
  }

  /**
   * Test {@link Types#isDefined()}.
   *
   * <ul>
   *   <li>Given {@link Types#DefinedType}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Types#isDefined()}
   */
  @Test
  @DisplayName("Test isDefined(); given DefinedType; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Types.isDefined()"})
  void testIsDefined_givenDefinedType_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(Types.DefinedType.isDefined());
  }

  /**
   * Test {@link Types#isDefined()}.
   *
   * <ul>
   *   <li>Given {@code Structured}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Types#isDefined()}
   */
  @Test
  @DisplayName("Test isDefined(); given 'Structured'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Types.isDefined()"})
  void testIsDefined_givenStructured_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(Types.Structured.isDefined());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Types#getBasic()}
   *   <li>{@link Types#getImplementingClass()}
   *   <li>{@link Types#isSimple()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Types Types.getBasic()",
    "Class Types.getImplementingClass()",
    "boolean Types.isSimple()"
  })
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
}
