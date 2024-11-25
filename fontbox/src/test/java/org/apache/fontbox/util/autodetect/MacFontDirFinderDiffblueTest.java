package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MacFontDirFinderDiffblueTest {
  /**
   * Test {@link MacFontDirFinder#getSearchableDirectories()}.
   * <p>
   * Method under test: {@link MacFontDirFinder#getSearchableDirectories()}
   */
  @Test
  @DisplayName("Test getSearchableDirectories()")
  void testGetSearchableDirectories() {
    // Arrange and Act
    String[] actualSearchableDirectories = (new MacFontDirFinder()).getSearchableDirectories();

    // Assert
    assertArrayEquals(new String[]{String.join("", System.getProperty("user.home"), "/Library/Fonts/"),
        "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"}, actualSearchableDirectories);
  }

  /**
   * Test new {@link MacFontDirFinder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link MacFontDirFinder}
   */
  @Test
  @DisplayName("Test new MacFontDirFinder (default constructor)")
  void testNewMacFontDirFinder() {
    // Arrange and Act
    MacFontDirFinder actualMacFontDirFinder = new MacFontDirFinder();

    // Assert
    assertArrayEquals(new String[]{String.join("", System.getProperty("user.home"), "/Library/Fonts/"),
        "/Library/Fonts/", "/System/Library/Fonts/", "/Network/Library/Fonts/"},
        actualMacFontDirFinder.getSearchableDirectories());
  }
}
