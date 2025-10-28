package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class GlyphArraySplitterRegexImplDiffblueTest {
  /**
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl() {
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
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl2() {
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
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl3() {
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
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl4() {
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
    List<Integer> getResult = actualSplitResult.get(0);
    assertEquals(1, getResult.size());
    assertEquals(20, getResult.get(0).intValue());
  }

  /**
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl5() {
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
   * Method under test:
   * {@link GlyphArraySplitterRegexImpl#GlyphArraySplitterRegexImpl(Set)}
   */
  @Test
  void testNewGlyphArraySplitterRegexImpl6() {
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
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  void testSplit() {
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

  /**
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  void testSplit2() {
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
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  void testSplit3() {
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
    List<Integer> getResult = actualSplitResult.get(0);
    assertEquals(1, getResult.size());
    assertEquals(2, getResult.get(0).intValue());
  }

  /**
   * Method under test: {@link GlyphArraySplitterRegexImpl#split(List)}
   */
  @Test
  void testSplit4() {
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
}
