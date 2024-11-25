package org.apache.fontbox.ttf.table.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.apache.fontbox.ttf.table.common.CoverageTable;
import org.apache.fontbox.ttf.table.common.CoverageTableFormat1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LookupTypeMultipleSubstitutionFormat1DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LookupTypeMultipleSubstitutionFormat1#LookupTypeMultipleSubstitutionFormat1(int, CoverageTable, SequenceTable[])}
   *   <li>{@link LookupTypeMultipleSubstitutionFormat1#getSequenceTables()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when four")
  void testDoSubstitution_whenFour() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(4, 1));
  }

  /**
   * Test {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when one")
  void testDoSubstitution_whenOne() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(1, 1));
  }

  /**
   * Test {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when three")
  void testDoSubstitution_whenThree() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(3, 1));
  }

  /**
   * Test {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}.
   * <ul>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LookupTypeMultipleSubstitutionFormat1#doSubstitution(int, int)}
   */
  @Test
  @DisplayName("Test doSubstitution(int, int); when two")
  void testDoSubstitution_whenTwo() {
    // Arrange
    CoverageTableFormat1 coverageTable = new CoverageTableFormat1(3, new int[]{3, 1, 3, 1});

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new LookupTypeMultipleSubstitutionFormat1(3, coverageTable,
        new SequenceTable[]{new SequenceTable(3, new int[]{1, 2, 1, 2})})).doSubstitution(2, 1));
  }
}
