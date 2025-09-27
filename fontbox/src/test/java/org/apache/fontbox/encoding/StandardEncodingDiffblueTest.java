package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StandardEncodingDiffblueTest {
  /**
   * Test new {@link StandardEncoding} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link StandardEncoding}
   */
  @Test
  @DisplayName("Test new StandardEncoding (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StandardEncoding.<init>()"})
  void testNewStandardEncoding() {
    // Arrange, Act and Assert
    Map<Integer, String> codeToNameMap = new StandardEncoding().getCodeToNameMap();
    assertEquals(149, codeToNameMap.size());
    assertEquals("dollar", codeToNameMap.get(36));
    assertEquals("exclam", codeToNameMap.get(33));
    assertEquals("numbersign", codeToNameMap.get(35));
    assertEquals("percent", codeToNameMap.get(37));
    assertEquals("quotedbl", codeToNameMap.get(34));
    assertEquals("space", codeToNameMap.get(Integer.SIZE));
  }
}
