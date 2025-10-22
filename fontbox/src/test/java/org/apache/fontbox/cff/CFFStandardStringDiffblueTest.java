package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFStandardStringDiffblueTest {
  /**
   * Test {@link CFFStandardString#getName(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code space}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFStandardString#getName(int)}
   */
  @Test
  @DisplayName("Test getName(int); when one; then return 'space'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String CFFStandardString.getName(int)"})
  void testGetName_whenOne_thenReturnSpace() {
    // Arrange, Act and Assert
    assertEquals("space", CFFStandardString.getName(1));
  }
}
