package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LigatureDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Ligature#Ligature(String, String)}
   *   <li>{@link Ligature#getLigature()}
   *   <li>{@link Ligature#getSuccessor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Ligature.<init>(String, String)",
    "String Ligature.getLigature()",
    "String Ligature.getSuccessor()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Ligature actualLigature = new Ligature("Successor", "Ligature");
    String actualLigature2 = actualLigature.getLigature();

    // Assert
    assertEquals("Ligature", actualLigature2);
    assertEquals("Successor", actualLigature.getSuccessor());
  }
}
