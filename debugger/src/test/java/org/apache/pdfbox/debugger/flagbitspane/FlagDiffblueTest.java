package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlagDiffblueTest {
  /**
   * Test {@link Flag#getColumnNames()}.
   *
   * <p>Method under test: {@link Flag#getColumnNames()}
   */
  @Test
  @DisplayName("Test getColumnNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] Flag.getColumnNames()"})
  void testGetColumnNames() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {"Bit Position", "Name", "Set"},
        new AnnotFlag(new COSDictionary()).getColumnNames());
  }
}
