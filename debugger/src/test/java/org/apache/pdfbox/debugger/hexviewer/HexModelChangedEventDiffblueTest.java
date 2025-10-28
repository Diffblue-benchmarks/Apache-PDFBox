package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class HexModelChangedEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HexModelChangedEvent#HexModelChangedEvent(int, int)}
   *   <li>{@link HexModelChangedEvent#getChangeType()}
   *   <li>{@link HexModelChangedEvent#getStartIndex()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    HexModelChangedEvent actualHexModelChangedEvent = new HexModelChangedEvent(1, 1);
    int actualChangeType = actualHexModelChangedEvent.getChangeType();

    // Assert
    assertEquals(1, actualChangeType);
    assertEquals(1, actualHexModelChangedEvent.getStartIndex());
  }
}
