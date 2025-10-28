package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StandardEncodingDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link StandardEncoding}
   */
  @Test
  void testNewStandardEncoding() {
    // Arrange, Act and Assert
    Map<Integer, String> codeToNameMap = (new StandardEncoding()).getCodeToNameMap();
    assertEquals(149, codeToNameMap.size());
    assertEquals("dollar", codeToNameMap.get(36));
    assertEquals("exclam", codeToNameMap.get(33));
    assertEquals("numbersign", codeToNameMap.get(35));
    assertEquals("percent", codeToNameMap.get(37));
    assertEquals("quotedbl", codeToNameMap.get(34));
    assertEquals("space", codeToNameMap.get(Integer.SIZE));
  }
}
