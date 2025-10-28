package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class UnixFontDirFinderDiffblueTest {
  /**
   * Method under test: {@link UnixFontDirFinder#getSearchableDirectories()}
   */
  @Test
  void testGetSearchableDirectories() {
    // Arrange and Act
    String[] actualSearchableDirectories = (new UnixFontDirFinder()).getSearchableDirectories();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), ".fonts").toString(), "/usr/local/fonts",
            "/usr/local/share/fonts", "/usr/share/fonts", "/usr/X11R6/lib/X11/fonts", "/usr/share/X11/fonts"},
        actualSearchableDirectories);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link UnixFontDirFinder}
   */
  @Test
  void testNewUnixFontDirFinder() {
    // Arrange and Act
    UnixFontDirFinder actualUnixFontDirFinder = new UnixFontDirFinder();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), ".fonts").toString(), "/usr/local/fonts",
            "/usr/local/share/fonts", "/usr/share/fonts", "/usr/X11R6/lib/X11/fonts", "/usr/share/X11/fonts"},
        actualUnixFontDirFinder.getSearchableDirectories());
  }
}
