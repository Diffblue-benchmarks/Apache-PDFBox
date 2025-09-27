package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class UnixFontDirFinderDiffblueTest {
  /**
   * Test {@link UnixFontDirFinder#getSearchableDirectories()}.
   *
   * <p>Method under test: {@link UnixFontDirFinder#getSearchableDirectories()}
   */
  @Test
  @DisplayName("Test getSearchableDirectories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] UnixFontDirFinder.getSearchableDirectories()"})
  void testGetSearchableDirectories() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          Paths.get(System.getProperty("user.home"), ".fonts").toString(),
          "/usr/local/fonts",
          "/usr/local/share/fonts",
          "/usr/share/fonts",
          "/usr/X11R6/lib/X11/fonts",
          "/usr/share/X11/fonts"
        },
        new UnixFontDirFinder().getSearchableDirectories());
  }

  /**
   * Test new {@link UnixFontDirFinder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UnixFontDirFinder}
   */
  @Test
  @DisplayName("Test new UnixFontDirFinder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnixFontDirFinder.<init>()"})
  void testNewUnixFontDirFinder() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          Paths.get(System.getProperty("user.home"), ".fonts").toString(),
          "/usr/local/fonts",
          "/usr/local/share/fonts",
          "/usr/share/fonts",
          "/usr/X11R6/lib/X11/fonts",
          "/usr/share/X11/fonts"
        },
        new UnixFontDirFinder().getSearchableDirectories());
  }
}
