package org.apache.pdfbox.debugger.hexviewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SelectEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SelectEvent#SelectEvent(int, String)}
   *   <li>{@link SelectEvent#getHexIndex()}
   *   <li>{@link SelectEvent#getNavigation()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SelectEvent.<init>(int, String)", "int SelectEvent.getHexIndex()",
      "String SelectEvent.getNavigation()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SelectEvent actualSelectEvent = new SelectEvent(1, "0123456789ABCDEF");
    int actualHexIndex = actualSelectEvent.getHexIndex();

    // Assert
    assertEquals("0123456789ABCDEF", actualSelectEvent.getNavigation());
    assertEquals(1, actualHexIndex);
  }
}
