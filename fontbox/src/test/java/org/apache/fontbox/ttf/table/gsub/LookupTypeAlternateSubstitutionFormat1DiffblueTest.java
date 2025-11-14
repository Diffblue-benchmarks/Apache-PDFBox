package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupTypeAlternateSubstitutionFormat1DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LookupTypeAlternateSubstitutionFormat1#LookupTypeAlternateSubstitutionFormat1(int,
   *       CoverageTable, AlternateSetTable[])}
   *   <li>{@link LookupTypeAlternateSubstitutionFormat1#getAlternateSetTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupTypeAlternateSubstitutionFormat1.<init>(int, CoverageTable, AlternateSetTable[])",
    "AlternateSetTable[] LookupTypeAlternateSubstitutionFormat1.getAlternateSetTables()"
  })
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[] {1, -1, 1, -1});
    AlternateSetTable alternateSetTable = new AlternateSetTable(3, new int[] {1, 2, 1, 2});
    AlternateSetTable[] alternateSetTables = new AlternateSetTable[] {alternateSetTable};

    // Act
    LookupTypeAlternateSubstitutionFormat1 actualLookupTypeAlternateSubstitutionFormat1 =
        new LookupTypeAlternateSubstitutionFormat1(1, coverageTable, alternateSetTables);
    AlternateSetTable[] actualAlternateSetTables =
        actualLookupTypeAlternateSubstitutionFormat1.getAlternateSetTables();

    // Assert
    assertEquals(1, actualLookupTypeAlternateSubstitutionFormat1.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeAlternateSubstitutionFormat1.getCoverageTable());
    assertSame(alternateSetTables, actualAlternateSetTables);
  }

  /**
   * Test {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeAlternateSubstitutionFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenFour() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    AlternateSetTable alternateSetTable = new AlternateSetTable(3, new int[] {1, 2, 1, 2});
    AlternateSetTable[] alternateSetTables = new AlternateSetTable[] {alternateSetTable};

    LookupTypeAlternateSubstitutionFormat1 lookupTypeAlternateSubstitutionFormat1 =
        new LookupTypeAlternateSubstitutionFormat1(3, coverageTable, alternateSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeAlternateSubstitutionFormat1.doSubstitution(4, 1));
  }

  /**
   * Test {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeAlternateSubstitutionFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenOne() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    AlternateSetTable alternateSetTable = new AlternateSetTable(3, new int[] {1, 2, 1, 2});
    AlternateSetTable[] alternateSetTables = new AlternateSetTable[] {alternateSetTable};

    LookupTypeAlternateSubstitutionFormat1 lookupTypeAlternateSubstitutionFormat1 =
        new LookupTypeAlternateSubstitutionFormat1(3, coverageTable, alternateSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeAlternateSubstitutionFormat1.doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeAlternateSubstitutionFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenThree() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    AlternateSetTable alternateSetTable = new AlternateSetTable(3, new int[] {1, 2, 1, 2});
    AlternateSetTable[] alternateSetTables = new AlternateSetTable[] {alternateSetTable};

    LookupTypeAlternateSubstitutionFormat1 lookupTypeAlternateSubstitutionFormat1 =
        new LookupTypeAlternateSubstitutionFormat1(3, coverageTable, alternateSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeAlternateSubstitutionFormat1.doSubstitution(3, 1));
  }

  /**
   * Test {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeAlternateSubstitutionFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenTwo() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    AlternateSetTable alternateSetTable = new AlternateSetTable(3, new int[] {1, 2, 1, 2});
    AlternateSetTable[] alternateSetTables = new AlternateSetTable[] {alternateSetTable};

    LookupTypeAlternateSubstitutionFormat1 lookupTypeAlternateSubstitutionFormat1 =
        new LookupTypeAlternateSubstitutionFormat1(3, coverageTable, alternateSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeAlternateSubstitutionFormat1.doSubstitution(2, 1));
  }
}
