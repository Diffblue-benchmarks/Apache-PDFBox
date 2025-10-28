package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class DigitalSignatureTableDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link DigitalSignatureTable}
   */
  @Test
  void testNewDigitalSignatureTable() {
    // Arrange and Act
    DigitalSignatureTable actualDigitalSignatureTable = new DigitalSignatureTable();

    // Assert
    assertNull(actualDigitalSignatureTable.getTag());
    assertEquals(0L, actualDigitalSignatureTable.getCheckSum());
    assertEquals(0L, actualDigitalSignatureTable.getLength());
    assertEquals(0L, actualDigitalSignatureTable.getOffset());
    assertFalse(actualDigitalSignatureTable.getInitialized());
  }
}
