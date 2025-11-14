package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FontFileFinderDiffblueTest {
  @Mock private FontDirFinder fontDirFinder;

  @InjectMocks private FontFileFinder fontFileFinder;

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

  /**
   * Test {@link FontFileFinder#find()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Property is {@code java.io.tmpdir} is array of
   *       {@link String} with {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link FontFileFinder#find()}
   */
  @Test
  @DisplayName(
      "Test find(); given ArrayList() add Property is 'java.io.tmpdir' is array of String with 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FontFileFinder.find()"})
  void testFind_givenArrayListAddPropertyIsJavaIoTmpdirIsArrayOfStringWithTestTxtToFile() {
    // Arrange
    ArrayList<File> fileList = new ArrayList<>();
    fileList.add(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    when(fontDirFinder.find()).thenReturn(fileList);

    // Act
    List<URI> actualFindResult = fontFileFinder.find();

    // Assert
    verify(fontDirFinder).find();
    assertTrue(actualFindResult.isEmpty());
  }

  /**
   * Test {@link FontFileFinder#find()}.
   *
   * <ul>
   *   <li>Given {@link FontDirFinder} {@link FontDirFinder#find()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FontFileFinder#find()}
   */
  @Test
  @DisplayName("Test find(); given FontDirFinder find() return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FontFileFinder.find()"})
  void testFind_givenFontDirFinderFindReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(fontDirFinder.find()).thenReturn(new ArrayList<>());

    // Act
    List<URI> actualFindResult = fontFileFinder.find();

    // Assert
    verify(fontDirFinder).find();
    assertTrue(actualFindResult.isEmpty());
  }

  /**
   * Test {@link FontFileFinder#find()}.
   *
   * <ul>
   *   <li>Given {@link FontFileFinder} (default constructor).
   *   <li>Then return size is twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link FontFileFinder#find()}
   */
  @Test
  @DisplayName(
      "Test find(); given FontFileFinder (default constructor); then return size is twenty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FontFileFinder.find()"})
  void testFind_givenFontFileFinder_thenReturnSizeIsTwentyTwo() {
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
}
