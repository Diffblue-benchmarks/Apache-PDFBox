package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DefaultGsubWorkerDiffblueTest {
  /**
   * Test {@link DefaultGsubWorker#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given three hundred.
   *   <li>When {@link ArrayList#ArrayList()} add three hundred.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given three hundred; when ArrayList() add three hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultGsubWorker.applyTransforms(List)"})
  void testApplyTransforms_givenThreeHundred_whenArrayListAddThreeHundred() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(300);
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = defaultGsubWorker.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link DefaultGsubWorker#applyTransforms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  @DisplayName(
      "Test applyTransforms(List); given two; when ArrayList() add two; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultGsubWorker.applyTransforms(List)"})
  void testApplyTransforms_givenTwo_whenArrayListAddTwo_thenReturnArrayList() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = defaultGsubWorker.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(originalGlyphIds, actualApplyTransformsResult);
  }

  /**
   * Test {@link DefaultGsubWorker#applyTransforms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); when ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DefaultGsubWorker.applyTransforms(List)"})
  void testApplyTransforms_whenArrayList_thenReturnEmpty() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    // Act and Assert
    assertTrue(defaultGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
