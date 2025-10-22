package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CompositePart.<init>(String, int, int)", "String CompositePart.getName()",
      "int CompositePart.getXDisplacement()", "int CompositePart.getYDisplacement()"})
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
