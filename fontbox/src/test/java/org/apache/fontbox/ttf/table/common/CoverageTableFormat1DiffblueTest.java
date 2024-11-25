package org.apache.fontbox.ttf.table.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoverageTableFormat1DiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoverageTableFormat1#CoverageTableFormat1(int, int[])}
   *   <li>{@link CoverageTableFormat1#toString()}
   *   <li>{@link CoverageTableFormat1#getGlyphArray()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
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

  /**
   * Test {@link CoverageTableFormat1#getCoverageIndex(int)}.
   * <p>
   * Method under test: {@link CoverageTableFormat1#getCoverageIndex(int)}
   */
  @Test
  @DisplayName("Test getCoverageIndex(int)")
  void testGetCoverageIndex() {
    // Arrange, Act and Assert
    assertEquals(2, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getCoverageIndex(1));
  }

  /**
   * Test {@link CoverageTableFormat1#getGlyphId(int)}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CoverageTableFormat1#getGlyphId(int)}
   */
  @Test
  @DisplayName("Test getGlyphId(int); then return minus one")
  void testGetGlyphId_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getGlyphId(1));
  }

  /**
   * Test {@link CoverageTableFormat1#getSize()}.
   * <p>
   * Method under test: {@link CoverageTableFormat1#getSize()}
   */
  @Test
  @DisplayName("Test getSize()")
  void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(4, (new CoverageTableFormat1(1, new int[]{1, -1, 1, -1})).getSize());
  }
}
