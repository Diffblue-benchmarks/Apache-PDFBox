package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OS400FontDirFinderDiffblueTest {
  /**
   * Test {@link OS400FontDirFinder#getSearchableDirectories()}.
   *
   * <p>Method under test: {@link OS400FontDirFinder#getSearchableDirectories()}
   */
  @Test
  @DisplayName("Test getSearchableDirectories()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] OS400FontDirFinder.getSearchableDirectories()"})
  void testGetSearchableDirectories() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          Paths.get(System.getProperty("user.home"), ".fonts").toString(),
          "/QIBM/ProdData/OS400/Fonts"
        },
        new OS400FontDirFinder().getSearchableDirectories());
  }

  /**
   * Test new {@link OS400FontDirFinder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OS400FontDirFinder}
   */
  @Test
  @DisplayName("Test new OS400FontDirFinder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OS400FontDirFinder.<init>()"})
  void testNewOS400FontDirFinder() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new String[] {
          Paths.get(System.getProperty("user.home"), ".fonts").toString(),
          "/QIBM/ProdData/OS400/Fonts"
        },
        new OS400FontDirFinder().getSearchableDirectories());
  }
}
