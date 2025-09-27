package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RangeRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RangeRecord#RangeRecord(int, int, int)}
   *   <li>{@link RangeRecord#toString()}
   *   <li>{@link RangeRecord#getEndGlyphID()}
   *   <li>{@link RangeRecord#getStartCoverageIndex()}
   *   <li>{@link RangeRecord#getStartGlyphID()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RangeRecord.<init>(int, int, int)",
    "int RangeRecord.getEndGlyphID()",
    "int RangeRecord.getStartCoverageIndex()",
    "int RangeRecord.getStartGlyphID()",
    "String RangeRecord.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RangeRecord actualRangeRecord = new RangeRecord(1, 1, 1);
    String actualToStringResult = actualRangeRecord.toString();
    int actualEndGlyphID = actualRangeRecord.getEndGlyphID();
    int actualStartCoverageIndex = actualRangeRecord.getStartCoverageIndex();

    // Assert
    assertEquals(
        "RangeRecord[startGlyphID=1,endGlyphID=1,startCoverageIndex=1]", actualToStringResult);
    assertEquals(1, actualEndGlyphID);
    assertEquals(1, actualStartCoverageIndex);
    assertEquals(1, actualRangeRecord.getStartGlyphID());
  }
}
