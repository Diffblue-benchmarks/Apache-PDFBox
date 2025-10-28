package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class FlagDiffblueTest {
  /**
   * Method under test: {@link Flag#getColumnNames()}
   */
  @Test
  void testGetColumnNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[]{"Bit Position", "Name", "Set"},
        (new AnnotFlag(new COSDictionary())).getColumnNames());
  }
}
