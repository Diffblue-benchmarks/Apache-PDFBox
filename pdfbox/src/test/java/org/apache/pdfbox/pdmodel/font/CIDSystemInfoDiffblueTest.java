package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CIDSystemInfoDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CIDSystemInfo#CIDSystemInfo(String, String, int)}
   *   <li>{@link CIDSystemInfo#toString()}
   *   <li>{@link CIDSystemInfo#getOrdering()}
   *   <li>{@link CIDSystemInfo#getRegistry()}
   *   <li>{@link CIDSystemInfo#getSupplement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CIDSystemInfo actualCidSystemInfo = new CIDSystemInfo("Registry", "Ordering", 1);
    String actualToStringResult = actualCidSystemInfo.toString();
    String actualOrdering = actualCidSystemInfo.getOrdering();
    String actualRegistry = actualCidSystemInfo.getRegistry();

    // Assert
    assertEquals("Ordering", actualOrdering);
    assertEquals("Registry", actualRegistry);
    assertEquals("Registry-Ordering-1", actualToStringResult);
    assertEquals(1, actualCidSystemInfo.getSupplement());
  }
}
