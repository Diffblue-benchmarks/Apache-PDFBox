package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LookupTypeLigatureSubstitutionSubstFormat1DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#LookupTypeLigatureSubstitutionSubstFormat1(int, CoverageTable, LigatureSetTable[])}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#toString()}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#getLigatureSetTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LookupTypeLigatureSubstitutionSubstFormat1.<init>(int, CoverageTable, LigatureSetTable[])",
      "LigatureSetTable[] LookupTypeLigatureSubstitutionSubstFormat1.getLigatureSetTables()",
      "String LookupTypeLigatureSubstitutionSubstFormat1.toString()"})
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    LigatureSetTable[] ligatureSetTables = new LigatureSetTable[]{
        new LigatureSetTable(3, new LigatureTable[]{new LigatureTable(1, 3, new int[]{1, 2, 1, 2})})};

    // Act
    LookupTypeLigatureSubstitutionSubstFormat1 actualLookupTypeLigatureSubstitutionSubstFormat1 = new LookupTypeLigatureSubstitutionSubstFormat1(
        1, coverageTable, ligatureSetTables);
    String actualToStringResult = actualLookupTypeLigatureSubstitutionSubstFormat1.toString();
    LigatureSetTable[] actualLigatureSetTables = actualLookupTypeLigatureSubstitutionSubstFormat1
        .getLigatureSetTables();

    // Assert
    assertEquals("LookupTypeLigatureSubstitutionSubstFormat1[substFormat=1]", actualToStringResult);
    assertEquals(1, actualLookupTypeLigatureSubstitutionSubstFormat1.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeLigatureSubstitutionSubstFormat1.getCoverageTable());
    assertSame(ligatureSetTables, actualLigatureSetTables);
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When four.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenFour() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(4, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenOne() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenThree() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(3, 1));
  }

  /**
   * Test {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LookupTypeLigatureSubstitutionSubstFormat1.doSubstitution(int, int)"})
  void testDoSubstitution_whenTwo() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(2, 1));
  }
}
