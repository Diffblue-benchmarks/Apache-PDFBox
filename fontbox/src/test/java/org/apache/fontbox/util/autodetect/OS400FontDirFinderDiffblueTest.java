package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class OS400FontDirFinderDiffblueTest {
  /**
   * Method under test: {@link OS400FontDirFinder#getSearchableDirectories()}
   */
  @Test
  void testGetSearchableDirectories() {
    // Arrange and Act
    String[] actualSearchableDirectories = (new OS400FontDirFinder()).getSearchableDirectories();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), ".fonts").toString(), "/QIBM/ProdData/OS400/Fonts"},
        actualSearchableDirectories);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OS400FontDirFinder}
   */
  @Test
  void testNewOS400FontDirFinder() {
    // Arrange and Act
    OS400FontDirFinder actualOs400FontDirFinder = new OS400FontDirFinder();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), ".fonts").toString(), "/QIBM/ProdData/OS400/Fonts"},
        actualOs400FontDirFinder.getSearchableDirectories());
  }
}
