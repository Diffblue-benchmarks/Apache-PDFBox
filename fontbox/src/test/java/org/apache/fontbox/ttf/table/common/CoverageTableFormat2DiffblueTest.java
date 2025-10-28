package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CoverageTableFormat2DiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CoverageTableFormat2#toString()}
   *   <li>{@link CoverageTableFormat2#getRangeRecords()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RangeRecord rangeRecord = new RangeRecord(1, 1, 1);

    CoverageTableFormat2 coverageTableFormat2 = new CoverageTableFormat2(1, new RangeRecord[]{rangeRecord});

    // Act
    String actualToStringResult = coverageTableFormat2.toString();
    RangeRecord[] actualRangeRecords = coverageTableFormat2.getRangeRecords();

    // Assert
    assertEquals("CoverageTableFormat2[coverageFormat=1]", actualToStringResult);
    assertEquals(1, actualRangeRecords.length);
    assertSame(rangeRecord, actualRangeRecords[0]);
  }

  /**
   * Method under test:
   * {@link CoverageTableFormat2#CoverageTableFormat2(int, RangeRecord[])}
   */
  @Test
  void testNewCoverageTableFormat2() {
    // Arrange
    RangeRecord[] rangeRecords = new RangeRecord[]{new RangeRecord(1, 1, 1)};

    // Act
    CoverageTableFormat2 actualCoverageTableFormat2 = new CoverageTableFormat2(1, rangeRecords);

    // Assert
    assertEquals(1, actualCoverageTableFormat2.getCoverageFormat());
    assertEquals(1, actualCoverageTableFormat2.getSize());
    assertSame(rangeRecords, actualCoverageTableFormat2.getRangeRecords());
    assertArrayEquals(new int[]{1}, actualCoverageTableFormat2.getGlyphArray());
  }
}
