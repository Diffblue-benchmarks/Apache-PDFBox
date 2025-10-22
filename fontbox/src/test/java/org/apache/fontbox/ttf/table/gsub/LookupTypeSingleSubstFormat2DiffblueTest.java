package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupTypeSingleSubstFormat2DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupTypeSingleSubstFormat2#LookupTypeSingleSubstFormat2(int, CoverageTable, int[])}
   *   <li>{@link LookupTypeSingleSubstFormat2#toString()}
   *   <li>{@link LookupTypeSingleSubstFormat2#getSubstituteGlyphIDs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LookupTypeSingleSubstFormat2.<init>(int, CoverageTable, int[])",
      "int[] LookupTypeSingleSubstFormat2.getSubstituteGlyphIDs()", "String LookupTypeSingleSubstFormat2.toString()"})
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    int[] substituteGlyphIDs = new int[]{1, 2, 1, 2};

    // Act
    LookupTypeSingleSubstFormat2 actualLookupTypeSingleSubstFormat2 = new LookupTypeSingleSubstFormat2(1, coverageTable,
        substituteGlyphIDs);
    String actualToStringResult = actualLookupTypeSingleSubstFormat2.toString();
    int[] actualSubstituteGlyphIDs = actualLookupTypeSingleSubstFormat2.getSubstituteGlyphIDs();

    // Assert
    assertEquals("LookupTypeSingleSubstFormat2[substFormat=1,substituteGlyphIDs=[1, 2, 1, 2]]", actualToStringResult);
    assertEquals(1, actualLookupTypeSingleSubstFormat2.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeSingleSubstFormat2.getCoverageTable());
    assertSame(substituteGlyphIDs, actualSubstituteGlyphIDs);
    assertArrayEquals(new int[]{1, 2, 1, 2}, actualSubstituteGlyphIDs);
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}.
   * <ul>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat2.doSubstitution(int, int)"})
  void testDoSubstitution_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when minus one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat2.doSubstitution(int, int)"})
  void testDoSubstitution_whenMinusOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, -1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat2.doSubstitution(int, int)"})
  void testDoSubstitution_whenTwo_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(2, 1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat2#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when zero; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat2.doSubstitution(int, int)"})
  void testDoSubstitution_whenZero_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1,
        (new LookupTypeSingleSubstFormat2(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), new int[]{1, 2, 1, 2}))
            .doSubstitution(1, 0));
  }
}
