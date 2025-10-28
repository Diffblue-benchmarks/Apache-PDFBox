package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class PrintImageLocationsDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link PrintImageLocations}
   */
  @Test
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
