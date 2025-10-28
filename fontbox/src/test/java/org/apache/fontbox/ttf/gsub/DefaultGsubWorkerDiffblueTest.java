package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DefaultGsubWorkerDiffblueTest {
  /**
   * Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    // Act and Assert
    assertTrue(defaultGsubWorker.applyTransforms(new ArrayList<>()).isEmpty());
  }

  /**
   * Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms2() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(2);

    // Act
    List<Integer> actualApplyTransformsResult = defaultGsubWorker.applyTransforms(originalGlyphIds);

    // Assert
    assertEquals(1, actualApplyTransformsResult.size());
    assertEquals(2, actualApplyTransformsResult.get(0).intValue());
  }

  /**
   * Method under test: {@link DefaultGsubWorker#applyTransforms(List)}
   */
  @Test
  void testApplyTransforms3() {
    // Arrange
    DefaultGsubWorker defaultGsubWorker = new DefaultGsubWorker();

    ArrayList<Integer> originalGlyphIds = new ArrayList<>();
    originalGlyphIds.add(300);
    originalGlyphIds.add(2);

    // Act and Assert
    assertEquals(originalGlyphIds, defaultGsubWorker.applyTransforms(originalGlyphIds));
  }
}
