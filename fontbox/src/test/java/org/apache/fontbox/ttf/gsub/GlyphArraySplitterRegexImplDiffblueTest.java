package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GlyphArraySplitterRegexImplDiffblueTest {
  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add twenty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); given ArrayList() add twenty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_givenArrayListAddTwenty() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(20);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);
    glyphIds.add(20);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(glyphIds);

    // Assert
    assertEquals(2, actualSplitResult.size());
    List<Integer> getResult = actualSplitResult.get(0);
    assertEquals(1, getResult.size());
    List<Integer> getResult2 = actualSplitResult.get(1);
    assertEquals(1, getResult2.size());
    assertEquals(2, getResult.get(0).intValue());
    assertEquals(20, getResult2.get(0).intValue());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Then return split {@link ArrayList#ArrayList()} first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); then return split ArrayList() first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_thenReturnSplitArrayListFirstEmpty() {
    // Arrange
    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(new ArrayList<>());

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(new ArrayList<>());

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertTrue(actualSplitResult.get(0).isEmpty());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Then return split {@link ArrayList#ArrayList()} first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); then return split ArrayList() first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_thenReturnSplitArrayListFirstEmpty2() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(new ArrayList<>());

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertTrue(actualSplitResult.get(0).isEmpty());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Then return split {@link ArrayList#ArrayList()} first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); then return split ArrayList() first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_thenReturnSplitArrayListFirstEmpty3() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(new ArrayList<>());
    matchers.add(integerList);

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(new ArrayList<>());

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertTrue(actualSplitResult.get(0).isEmpty());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Then return split {@link ArrayList#ArrayList()} first is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); then return split ArrayList() first is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_thenReturnSplitArrayListFirstIsArrayList() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(20);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(glyphIds);

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertEquals(glyphIds, actualSplitResult.get(0));
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}.
   * <ul>
   *   <li>Then return split {@link ArrayList#ArrayList()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  @DisplayName("Test new GlyphArraySplitterRegexImpl(Set); then return split ArrayList() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GlyphArraySplitterRegexImpl.<init>(Set)"})
  void testNewGlyphArraySplitterRegexImpl_thenReturnSplitArrayListSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);

    // Act
    GlyphArraySplitterRegexImpl actualGlyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);
    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);
    glyphIds.add(20);
    List<List<Integer>> actualSplitResult = actualGlyphArraySplitterRegexImpl.split(glyphIds);

    // Assert
    assertEquals(2, actualSplitResult.size());
    List<Integer> getResult = actualSplitResult.get(0);
    assertEquals(1, getResult.size());
    List<Integer> getResult2 = actualSplitResult.get(1);
    assertEquals(1, getResult2.size());
    assertEquals(2, getResult.get(0).intValue());
    assertEquals(20, getResult2.get(0).intValue());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#split(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>When {@link ArrayList#ArrayList()} add two.</li>
   *   <li>Then return first is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  @DisplayName("Test split(List); given ArrayList() add two; when ArrayList() add two; then return first is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GlyphArraySplitterRegexImpl.split(List)"})
  void testSplit_givenArrayListAddTwo_whenArrayListAddTwo_thenReturnFirstIsArrayList() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);
    GlyphArraySplitterRegexImpl glyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(2);

    // Act
    List<List<Integer>> actualSplitResult = glyphArraySplitterRegexImpl.split(glyphIds);

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertEquals(integerList, actualSplitResult.get(0));
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#split(List)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  @DisplayName("Test split(List); given ArrayList() add two; when ArrayList(); then return first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GlyphArraySplitterRegexImpl.split(List)"})
  void testSplit_givenArrayListAddTwo_whenArrayList_thenReturnFirstEmpty() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);
    GlyphArraySplitterRegexImpl glyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);

    // Act
    List<List<Integer>> actualSplitResult = glyphArraySplitterRegexImpl.split(new ArrayList<>());

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertTrue(actualSplitResult.get(0).isEmpty());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#split(List)}.
   * <ul>
   *   <li>Given twenty.</li>
   *   <li>When {@link ArrayList#ArrayList()} add twenty.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  @DisplayName("Test split(List); given twenty; when ArrayList() add twenty; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GlyphArraySplitterRegexImpl.split(List)"})
  void testSplit_givenTwenty_whenArrayListAddTwenty_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);

    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(integerList);
    GlyphArraySplitterRegexImpl glyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);

    ArrayList<Integer> glyphIds = new ArrayList<>();
    glyphIds.add(20);
    glyphIds.add(2);

    // Act
    List<List<Integer>> actualSplitResult = glyphArraySplitterRegexImpl.split(glyphIds);

    // Assert
    assertEquals(2, actualSplitResult.size());
    List<Integer> getResult = actualSplitResult.get(0);
    assertEquals(1, getResult.size());
    List<Integer> getResult2 = actualSplitResult.get(1);
    assertEquals(1, getResult2.size());
    assertEquals(2, getResult2.get(0).intValue());
    assertEquals(20, getResult.get(0).intValue());
  }

  /**
   * Test {@link GlyphArraySplitterRegexImpl#split(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return first Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  @DisplayName("Test split(List); when ArrayList(); then return first Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List GlyphArraySplitterRegexImpl.split(List)"})
  void testSplit_whenArrayList_thenReturnFirstEmpty() {
    // Arrange
    HashSet<List<Integer>> matchers = new HashSet<>();
    matchers.add(new ArrayList<>());
    GlyphArraySplitterRegexImpl glyphArraySplitterRegexImpl = new GlyphArraySplitterRegexImpl(matchers);

    // Act
    List<List<Integer>> actualSplitResult = glyphArraySplitterRegexImpl.split(new ArrayList<>());

    // Assert
    assertEquals(1, actualSplitResult.size());
    assertTrue(actualSplitResult.get(0).isEmpty());
  }
}
