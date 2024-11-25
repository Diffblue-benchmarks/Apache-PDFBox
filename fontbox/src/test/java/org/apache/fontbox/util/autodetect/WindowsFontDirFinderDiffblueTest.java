package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WindowsFontDirFinderDiffblueTest {
  /**
   * Test {@link WindowsFontDirFinder#find()}.
   * <p>
   * Method under test: {@link WindowsFontDirFinder#find()}
   */
  @Test
  @DisplayName("Test find()")
  void testFind() {
    // Arrange and Act
    List<File> actualFindResult = (new WindowsFontDirFinder()).find();

    // Assert
    assertEquals(2, actualFindResult.size());
    File getResult = actualFindResult.get(0);
    assertEquals("FONTS", getResult.getName());
    File getResult2 = actualFindResult.get(1);
    assertEquals("Fonts", getResult2.getName());
    assertTrue(getResult.isAbsolute());
    assertTrue(getResult2.isAbsolute());
  }
}
