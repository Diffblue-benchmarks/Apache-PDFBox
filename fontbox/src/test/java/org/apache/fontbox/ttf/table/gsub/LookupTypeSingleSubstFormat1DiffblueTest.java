package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupTypeSingleSubstFormat1DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupTypeSingleSubstFormat1#LookupTypeSingleSubstFormat1(int, CoverageTable, short)}
   *   <li>{@link LookupTypeSingleSubstFormat1#toString()}
   *   <li>{@link LookupTypeSingleSubstFormat1#getDeltaGlyphID()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LookupTypeSingleSubstFormat1.<init>(int, CoverageTable, short)",
      "short LookupTypeSingleSubstFormat1.getDeltaGlyphID()", "String LookupTypeSingleSubstFormat1.toString()"})
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    // Act
    LookupTypeSingleSubstFormat1 actualLookupTypeSingleSubstFormat1 = new LookupTypeSingleSubstFormat1(1, coverageTable,
        (short) 1);
    String actualToStringResult = actualLookupTypeSingleSubstFormat1.toString();
    short actualDeltaGlyphID = actualLookupTypeSingleSubstFormat1.getDeltaGlyphID();

    // Assert
    assertEquals("LookupTypeSingleSubstFormat1[substFormat=1,deltaGlyphID=1]", actualToStringResult);
    assertEquals(1, actualLookupTypeSingleSubstFormat1.getSubstFormat());
    assertEquals((short) 1, actualDeltaGlyphID);
    assertSame(coverageTable, actualLookupTypeSingleSubstFormat1.getCoverageTable());
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when minus one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenMinusOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, -1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when one; then return eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenOne_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two; then return nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenTwo_thenReturnNine() {
    // Arrange, Act and Assert
    assertEquals(9, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(2, 1));
  }

  /**
   * Test {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeSingleSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when zero; then return eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeSingleSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenZero_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, (new LookupTypeSingleSubstFormat1(3, new CoverageTableFormat1(3, new int[]{3, 1, 3, 1}), (short) 7))
        .doSubstitution(1, 0));
  }
}
