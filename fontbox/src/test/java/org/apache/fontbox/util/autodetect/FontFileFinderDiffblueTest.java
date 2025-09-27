package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.URI;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontFileFinderDiffblueTest {
  /**
   * Test {@link FontFileFinder#find()}.
   *
   * <p>Method under test: {@link FontFileFinder#find()}
   */
  @Test
  @DisplayName("Test find()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FontFileFinder.find()"})
  void testFind() {
    // Arrange and Act
    List<URI> actualFindResult = new FontFileFinder().find();

    // Assert
    assertEquals(22, actualFindResult.size());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf",
        actualFindResult.get(0).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSans.ttf", actualFindResult.get(1).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSansMono-Bold.ttf",
        actualFindResult.get(2).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSansMono.ttf",
        actualFindResult.get(3).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSerif-Bold.ttf",
        actualFindResult.get(4).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/dejavu/DejaVuSerif.ttf",
        actualFindResult.get(5).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSansNarrow-Italic.ttf",
        actualFindResult.get(Short.SIZE).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSansNarrow-Regular.ttf",
        actualFindResult.get(17).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSerif-Bold.ttf",
        actualFindResult.get(18).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSerif-BoldItalic.ttf",
        actualFindResult.get(19).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSerif-Italic.ttf",
        actualFindResult.get(20).toString());
    assertEquals(
        "file:/usr/share/fonts/truetype/liberation/LiberationSerif-Regular.ttf",
        actualFindResult.get(21).toString());
  }

  /**
   * Test {@link FontFileFinder#find(String)} with {@code String}.
   *
   * <p>Method under test: {@link FontFileFinder#find(String)}
   */
  @Test
  @DisplayName("Test find(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FontFileFinder.find(String)"})
  void testFindWithString() {
    // Arrange, Act and Assert
    assertTrue(new FontFileFinder().find("Dir").isEmpty());
  }
}
