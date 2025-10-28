package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class LigatureDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Ligature#Ligature(String, String)}
   *   <li>{@link Ligature#getLigature()}
   *   <li>{@link Ligature#getSuccessor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    Ligature actualLigature = new Ligature("Successor", "Ligature");
    String actualLigature2 = actualLigature.getLigature();

    // Assert
    assertEquals("Ligature", actualLigature2);
    assertEquals("Successor", actualLigature.getSuccessor());
  }
}
