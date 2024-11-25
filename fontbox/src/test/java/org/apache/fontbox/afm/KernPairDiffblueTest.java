package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KernPairDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link KernPair#KernPair(String, String, float, float)}
   *   <li>{@link KernPair#getFirstKernCharacter()}
   *   <li>{@link KernPair#getSecondKernCharacter()}
   *   <li>{@link KernPair#getX()}
   *   <li>{@link KernPair#getY()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    KernPair actualKernPair = new KernPair("First Kern Character", "Second Kern Character", 10.0f, 10.0f);
    String actualFirstKernCharacter = actualKernPair.getFirstKernCharacter();
    String actualSecondKernCharacter = actualKernPair.getSecondKernCharacter();
    float actualX = actualKernPair.getX();

    // Assert
    assertEquals("First Kern Character", actualFirstKernCharacter);
    assertEquals("Second Kern Character", actualSecondKernCharacter);
    assertEquals(10.0f, actualX);
    assertEquals(10.0f, actualKernPair.getY());
  }
}
