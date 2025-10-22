package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MacFontDirFinderDiffblueTest {
  /**
   * Test {@link MacFontDirFinder#getSearchableDirectories()}.
   * <p>
   * Method under test: {@link MacFontDirFinder#getSearchableDirectories()}
   */
  @Test
  @DisplayName("Test getSearchableDirectories()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] MacFontDirFinder.getSearchableDirectories()"})
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
   * Test new {@link MacFontDirFinder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MacFontDirFinder}
   */
  @Test
  @DisplayName("Test new MacFontDirFinder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MacFontDirFinder.<init>()"})
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
