package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.Test;

class LookupTypeAlternateSubstitutionFormat1DiffblueTest {
  /**
   * Method under test:
   * {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeAlternateSubstitutionFormat1(3,
        coverageTable, new AlternateSetTable[]{new AlternateSetTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(1, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution2() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeAlternateSubstitutionFormat1(3,
        coverageTable, new AlternateSetTable[]{new AlternateSetTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(2, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution3() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeAlternateSubstitutionFormat1(3,
        coverageTable, new AlternateSetTable[]{new AlternateSetTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(3, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeAlternateSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution4() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeAlternateSubstitutionFormat1(3,
        coverageTable, new AlternateSetTable[]{new AlternateSetTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(4, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeAlternateSubstitutionFormat1#LookupTypeAlternateSubstitutionFormat1(int, CoverageTable, AlternateSetTable[])}
   *   <li>{@link LookupTypeAlternateSubstitutionFormat1#getAlternateSetTables()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    AlternateSetTable[] alternateSetTables = new AlternateSetTable[]{new AlternateSetTable(3, new int[]{1, 2, 1, 2})};

    // Act
    LookupTypeAlternateSubstitutionFormat1 actualLookupTypeAlternateSubstitutionFormat1 = new LookupTypeAlternateSubstitutionFormat1(
        1, coverageTable, alternateSetTables);
    AlternateSetTable[] actualAlternateSetTables = actualLookupTypeAlternateSubstitutionFormat1.getAlternateSetTables();

    // Assert
    assertEquals(1, actualLookupTypeAlternateSubstitutionFormat1.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeAlternateSubstitutionFormat1.getCoverageTable());
    assertSame(alternateSetTables, actualAlternateSetTables);
  }
}
