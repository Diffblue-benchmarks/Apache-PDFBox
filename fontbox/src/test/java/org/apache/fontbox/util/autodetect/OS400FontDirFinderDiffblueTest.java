package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OS400FontDirFinderDiffblueTest {
  /**
   * Test {@link OS400FontDirFinder#getSearchableDirectories()}.
   * <p>
   * Method under test: {@link OS400FontDirFinder#getSearchableDirectories()}
   */
  @Test
  @DisplayName("Test getSearchableDirectories()")
  void testGetSearchableDirectories() {
    // Arrange and Act
    String[] actualSearchableDirectories = (new OS400FontDirFinder()).getSearchableDirectories();

    // Assert
    assertArrayEquals(
        new String[]{String.join("", System.getProperty("user.home"), "/.fonts"), "/QIBM/ProdData/OS400/Fonts"},
        actualSearchableDirectories);
  }

  /**
   * Test new {@link OS400FontDirFinder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link OS400FontDirFinder}
   */
  @Test
  @DisplayName("Test new OS400FontDirFinder (default constructor)")
  void testNewOS400FontDirFinder() {
    // Arrange and Act
    OS400FontDirFinder actualOs400FontDirFinder = new OS400FontDirFinder();

    // Assert
    assertArrayEquals(
        new String[]{String.join("", System.getProperty("user.home"), "/.fonts"), "/QIBM/ProdData/OS400/Fonts"},
        actualOs400FontDirFinder.getSearchableDirectories());
  }
}
