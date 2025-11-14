package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupTypeLigatureSubstitutionSubstFormat1DiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       LookupTypeLigatureSubstitutionSubstFormat1#LookupTypeLigatureSubstitutionSubstFormat1(int,
   *       CoverageTable, LigatureSetTable[])}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#toString()}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#getLigatureSetTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LookupTypeLigatureSubstitutionSubstFormat1.<init>(int, CoverageTable, LigatureSetTable[])",
    "LigatureSetTable[] LookupTypeLigatureSubstitutionSubstFormat1.getLigatureSetTables()",
    "String LookupTypeLigatureSubstitutionSubstFormat1.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[] {1, -1, 1, -1});
    LigatureTable[] ligatureTables =
        new LigatureTable[] {new LigatureTable(1, 3, new int[] {1, 2, 1, 2})};
    LigatureSetTable ligatureSetTable = new LigatureSetTable(3, ligatureTables);
    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[] {ligatureSetTable};

    // Act
    LookupTypeLigatureSubstitutionSubstFormat1 actualLookupTypeLigatureSubstitutionSubstFormat1 =
        new LookupTypeLigatureSubstitutionSubstFormat1(1, coverageTable, ligatureSetTables);
    String actualToStringResult = actualLookupTypeLigatureSubstitutionSubstFormat1.toString();
    LigatureSetTable[] actualLigatureSetTables =
        actualLookupTypeLigatureSubstitutionSubstFormat1.getLigatureSetTables();

    // Assert
    assertEquals("LookupTypeLigatureSubstitutionSubstFormat1[substFormat=1]", actualToStringResult);
    assertEquals(1, actualLookupTypeLigatureSubstitutionSubstFormat1.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeLigatureSubstitutionSubstFormat1.getCoverageTable());
    assertSame(ligatureSetTables, actualLigatureSetTables);
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int,
   * int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenFour() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    LigatureTable[] ligatureTables = new LigatureTable[] {mock(LigatureTable.class)};
    LigatureSetTable ligatureSetTable = new LigatureSetTable(3, ligatureTables);
    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[] {ligatureSetTable};

    LookupTypeLigatureSubstitutionSubstFormat1 lookupTypeLigatureSubstitutionSubstFormat1 =
        new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable, ligatureSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(4, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int,
   * int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenOne() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    LigatureTable[] ligatureTables = new LigatureTable[] {mock(LigatureTable.class)};
    LigatureSetTable ligatureSetTable = new LigatureSetTable(3, ligatureTables);
    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[] {ligatureSetTable};

    LookupTypeLigatureSubstitutionSubstFormat1 lookupTypeLigatureSubstitutionSubstFormat1 =
        new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable, ligatureSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int,
   * int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenThree() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    LigatureTable[] ligatureTables = new LigatureTable[] {mock(LigatureTable.class)};
    LigatureSetTable ligatureSetTable = new LigatureSetTable(3, ligatureTables);
    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[] {ligatureSetTable};

    LookupTypeLigatureSubstitutionSubstFormat1 lookupTypeLigatureSubstitutionSubstFormat1 =
        new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable, ligatureSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(3, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int,
   * int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenTwo() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[] {3, 1, 3, 1});
    LigatureTable[] ligatureTables = new LigatureTable[] {mock(LigatureTable.class)};
    LigatureSetTable ligatureSetTable = new LigatureSetTable(3, ligatureTables);
    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[] {ligatureSetTable};

    LookupTypeLigatureSubstitutionSubstFormat1 lookupTypeLigatureSubstitutionSubstFormat1 =
        new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable, ligatureSetTables);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> lookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(2, 1));
  }
}
