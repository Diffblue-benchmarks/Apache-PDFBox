package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HexChangedEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HexChangedEvent#HexChangedEvent(byte, int)}
   *   <li>{@link HexChangedEvent#getByteIndex()}
   *   <li>{@link HexChangedEvent#getNewValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    HexChangedEvent actualHexChangedEvent = new HexChangedEvent((byte) 'A', 1);
    int actualByteIndex = actualHexChangedEvent.getByteIndex();

    // Assert
    assertEquals(1, actualByteIndex);
    assertEquals('A', actualHexChangedEvent.getNewValue());
  }
}
