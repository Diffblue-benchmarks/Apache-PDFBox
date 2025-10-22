package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PrintImageLocationsDiffblueTest {
  /**
   * Test {@link PrintImageLocations#PrintImageLocations()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link PrintImageLocations}
   */
  @Test
  @DisplayName("Test new PrintImageLocations()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PrintImageLocations.<init>()"})
  void testNewPrintImageLocations() throws IOException {
    // Arrange and Act
    PrintImageLocations actualPrintImageLocations = new PrintImageLocations();

    // Assert
    assertNull(actualPrintImageLocations.getCurrentPage());
    assertNull(actualPrintImageLocations.getResources());
    assertNull(actualPrintImageLocations.getGraphicsState());
    assertNull(actualPrintImageLocations.getInitialMatrix());
    assertEquals(0, actualPrintImageLocations.getGraphicsStackSize());
    assertEquals(0, actualPrintImageLocations.getLevel());
  }
}
