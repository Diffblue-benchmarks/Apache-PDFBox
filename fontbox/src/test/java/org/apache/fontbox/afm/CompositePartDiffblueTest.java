package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompositePartDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CompositePart#CompositePart(String, int, int)}
   *   <li>{@link CompositePart#getName()}
   *   <li>{@link CompositePart#getXDisplacement()}
   *   <li>{@link CompositePart#getYDisplacement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CompositePart actualCompositePart = new CompositePart("Name", 1, 1);
    String actualName = actualCompositePart.getName();
    int actualXDisplacement = actualCompositePart.getXDisplacement();

    // Assert
    assertEquals("Name", actualName);
    assertEquals(1, actualXDisplacement);
    assertEquals(1, actualCompositePart.getYDisplacement());
  }
}
