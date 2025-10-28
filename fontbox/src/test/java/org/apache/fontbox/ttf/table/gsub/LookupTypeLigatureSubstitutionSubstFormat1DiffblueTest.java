package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.Test;

class LookupTypeLigatureSubstitutionSubstFormat1DiffblueTest {
  /**
   * Method under test:
   * {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(1, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution2() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(2, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution3() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(3, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeLigatureSubstitutionSubstFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution4() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LookupTypeLigatureSubstitutionSubstFormat1(3, coverageTable,
            new LigatureSetTable[]{new LigatureSetTable(3, new LigatureTable[]{mock(LigatureTable.class)})}))
                .doSubstitution(4, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeLigatureSubstitutionSubstFormat1#LookupTypeLigatureSubstitutionSubstFormat1(int, CoverageTable, LigatureSetTable[])}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#toString()}
   *   <li>{@link LookupTypeLigatureSubstitutionSubstFormat1#getLigatureSetTables()}
   * </ul>
   */
  @Test
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
}
