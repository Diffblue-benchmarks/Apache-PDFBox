package org.apache.fontbox.util.autodetect;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WindowsFontDirFinderDiffblueTest {
  /**
   * Test {@link WindowsFontDirFinder#find()}.
   * <p>
   * Method under test: {@link WindowsFontDirFinder#find()}
   */
  @Test
  @DisplayName("Test find()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List WindowsFontDirFinder.find()"})
  void testFind() {
    // Arrange, Act and Assert
    assertTrue((new WindowsFontDirFinder()).find().isEmpty());
  }
}
