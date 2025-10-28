package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class SelectEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SelectEvent#SelectEvent(int, String)}
   *   <li>{@link SelectEvent#getHexIndex()}
   *   <li>{@link SelectEvent#getNavigation()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SelectEvent actualSelectEvent = new SelectEvent(1, "0123456789ABCDEF");
    int actualHexIndex = actualSelectEvent.getHexIndex();

    // Assert
    assertEquals("0123456789ABCDEF", actualSelectEvent.getNavigation());
    assertEquals(1, actualHexIndex);
  }
}
