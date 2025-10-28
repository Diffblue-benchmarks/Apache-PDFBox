package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class OTLTableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of {@link OTLTable}
   */
  @Test
  void testNewOTLTable() {
    // Arrange and Act
    OTLTable actualOtlTable = new OTLTable();

    // Assert
    assertNull(actualOtlTable.getTag());
    assertEquals(0L, actualOtlTable.getCheckSum());
    assertEquals(0L, actualOtlTable.getLength());
    assertEquals(0L, actualOtlTable.getOffset());
    assertFalse(actualOtlTable.getInitialized());
  }
}
