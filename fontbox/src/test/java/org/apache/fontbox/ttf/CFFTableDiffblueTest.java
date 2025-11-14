package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.cff.CFFFont;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFTableDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CFFTable}
   *   <li>{@link CFFTable#getFont()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CFFTable.<init>()", "CFFFont CFFTable.getFont()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CFFTable actualCffTable = new CFFTable();
    CFFFont actualFont = actualCffTable.getFont();

    // Assert
    assertNull(actualCffTable.getTag());
    assertNull(actualFont);
    assertEquals(0L, actualCffTable.getCheckSum());
    assertEquals(0L, actualCffTable.getLength());
    assertEquals(0L, actualCffTable.getOffset());
    assertFalse(actualCffTable.getInitialized());
  }
}
