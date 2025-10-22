package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DigitalSignatureTableDiffblueTest {
  /**
   * Test {@link DigitalSignatureTable#DigitalSignatureTable()}.
   * <p>
   * Method under test: default or parameterless constructor of {@link DigitalSignatureTable}
   */
  @Test
  @DisplayName("Test new DigitalSignatureTable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DigitalSignatureTable.<init>()"})
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
