package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class MacFontDirFinderDiffblueTest {
  /**
   * Method under test: {@link MacFontDirFinder#getSearchableDirectories()}
   */
  @Test
  void testGetSearchableDirectories() {
    // Arrange and Act
    String[] actualSearchableDirectories = (new MacFontDirFinder()).getSearchableDirectories();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), "Library", "Fonts").toString().concat(File.separator),
            "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"},
        actualSearchableDirectories);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link MacFontDirFinder}
   */
  @Test
  void testNewMacFontDirFinder() {
    // Arrange and Act
    MacFontDirFinder actualMacFontDirFinder = new MacFontDirFinder();

    // Assert
    assertArrayEquals(
        new String[]{Paths.get(System.getProperty("user.home"), "Library", "Fonts").toString().concat(File.separator),
            "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"},
        actualMacFontDirFinder.getSearchableDirectories());
  }
}
