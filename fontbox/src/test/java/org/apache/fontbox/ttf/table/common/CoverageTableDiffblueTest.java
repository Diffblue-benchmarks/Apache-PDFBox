package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CoverageTableDiffblueTest {
  /**
   * Test {@link CoverageTable#getCoverageFormat()}.
   * <p>
   * Method under test: {@link CoverageTable#getCoverageFormat()}
   */
  @Test
  @DisplayName("Test getCoverageFormat()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CoverageTable.getCoverageFormat()"})
  void testGetCoverageFormat() {
    // Arrange, Act and Assert
    assertEquals(1, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getCoverageFormat());
  }
}
