package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.Test;

class LookupTypeMultipleSubstitutionFormat1DiffblueTest {
  /**
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(1, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution2() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(2, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution3() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(3, 1));
  }

  /**
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  void testDoSubstitution4() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(4, 1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeMultipleSubstitutionFormat1#LookupTypeMultipleSubstitutionFormat1(int, CoverageTable, SequenceTable[])}
   *   <li>{@link LookupTypeMultipleSubstitutionFormat1#getSequenceTables()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(1, new int[]{1, -1, 1, -1});

    SequenceTable[] sequenceTables = new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})};

    // Act
    LookupTypeMultipleSubstitutionFormat1 actualLookupTypeMultipleSubstitutionFormat1 = new LookupTypeMultipleSubstitutionFormat1(
        1, coverageTable, sequenceTables);
    SequenceTable[] actualSequenceTables = actualLookupTypeMultipleSubstitutionFormat1.getSequenceTables();

    // Assert
    assertEquals(1, actualLookupTypeMultipleSubstitutionFormat1.getSubstFormat());
    assertSame(coverageTable, actualLookupTypeMultipleSubstitutionFormat1.getCoverageTable());
    assertSame(sequenceTables, actualSequenceTables);
  }
}
