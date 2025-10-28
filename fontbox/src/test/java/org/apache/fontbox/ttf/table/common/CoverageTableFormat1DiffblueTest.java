package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class CoverageTableFormat1DiffblueTest {
  /**
   * Method under test: {@link CoverageTableFormat1#getCoverageIndex(int)}
   */
  @Test
  void testGetCoverageIndex() {
    // Arrange, Act and Assert
    assertEquals(2, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getCoverageIndex(1));
  }

  /**
   * Method under test: {@link CoverageTableFormat1#getGlyphId(int)}
   */
  @Test
  void testGetGlyphId() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getGlyphId(1));
  }

  /**
   * Method under test: {@link CoverageTableFormat1#getSize()}
   */
  @Test
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(4, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getSize());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CoverageTableFormat1#CoverageTableFormat1(int, int[])}
   *   <li>{@link CoverageTableFormat1#toString()}
   *   <li>{@link CoverageTableFormat1#getGlyphArray()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    int[] glyphArray = new int[]{1, -1, 1, -1};

    // Act
    CoverageTableFormat1 actualCoverageTableFormat1 = new CoverageTableFormat1(1, glyphArray);
    String actualToStringResult = actualCoverageTableFormat1.toString();
    int[] actualGlyphArray = actualCoverageTableFormat1.getGlyphArray();

    // Assert
    assertEquals("CoverageTableFormat1[coverageFormat=1,glyphArray=[1, -1, 1, -1]]", actualToStringResult);
    assertEquals(1, actualCoverageTableFormat1.getCoverageFormat());
    assertSame(glyphArray, actualGlyphArray);
  }
}
