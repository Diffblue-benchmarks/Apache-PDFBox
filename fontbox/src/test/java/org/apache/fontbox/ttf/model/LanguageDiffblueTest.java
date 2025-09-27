package org.apache.fontbox.ttf.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LanguageDiffblueTest {
  /**
   * Test {@link Language#getScriptNames()}.
   *
   * <p>Method under test: {@link Language#getScriptNames()}
   */
  @Test
  @DisplayName("Test getScriptNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] Language.getScriptNames()"})
  void testGetScriptNames() {
    // Arrange, Act and Assert
    assertArrayEquals(new String[] {"bng2", "beng"}, Language.valueOf("BENGALI").getScriptNames());
  }
}
