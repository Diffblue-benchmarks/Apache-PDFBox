package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintImageLocationsDiffblueTest {
  /**
   * Test {@link PrintImageLocations#PrintImageLocations()}.
   *
   * <p>Method under test: default or parameterless constructor of {@link PrintImageLocations}
   */
  @Test
  @DisplayName("Test new PrintImageLocations()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintImageLocations.<init>()"})
  void testNewPrintImageLocations() throws IOException {
    // Arrange and Act
    PrintImageLocations actualPrintImageLocations = new PrintImageLocations();

    // Assert
    assertNull(actualPrintImageLocations.getCurrentPage());
    assertNull(actualPrintImageLocations.getResources());
    assertNull(actualPrintImageLocations.getGraphicsState());
    assertNull(actualPrintImageLocations.getInitialMatrix());
    assertEquals(0, actualPrintImageLocations.getGraphicsStackSize());
    assertEquals(0, actualPrintImageLocations.getLevel());
  }

  /**
   * Test {@link PrintImageLocations#processOperator(Operator, List)} with {@code operator}, {@code
   * operands}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link Operator#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PrintImageLocations#processOperator(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test processOperator(Operator, List) with 'operator', 'operands'; given 'Name'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PrintImageLocations.processOperator(Operator, List)"})
  void testProcessOperatorWithOperatorOperands_givenName_thenCallsGetName() throws IOException {
    // Arrange
    PrintImageLocations printImageLocations = new PrintImageLocations();

    Operator operator = mock(Operator.class);
    when(operator.getName()).thenReturn("Name");

    // Act
    printImageLocations.processOperator(operator, new ArrayList<>());

    // Assert
    verify(operator, atLeast(1)).getName();
  }
}
