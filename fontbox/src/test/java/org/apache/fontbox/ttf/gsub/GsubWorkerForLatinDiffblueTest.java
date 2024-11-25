package org.apache.fontbox.ttf.gsub;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.fontbox.ttf.CmapSubtable;
import org.apache.fontbox.ttf.model.Language;
import org.apache.fontbox.ttf.model.MapBackedGsubData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GsubWorkerForLatinDiffblueTest {
  /**
   * Test {@link GsubWorkerForLatin#applyTransforms(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GsubWorkerForLatin#applyTransforms(List)}
   */
  @Test
  @DisplayName("Test applyTransforms(List); then return Empty")
  void testApplyTransforms_thenReturnEmpty() {
    // Arrange
    CmapSubtable cmapLookup = new CmapSubtable();
    GsubWorkerForLatin gsubWorkerForLatin = new GsubWorkerForLatin(cmapLookup,
        new MapBackedGsubData(Language.BENGALI, "Active Script Name", new HashMap<>()));

    // Act and Assert
    assertTrue(gsubWorkerForLatin.applyTransforms(new ArrayList<>()).isEmpty());
  }
}
