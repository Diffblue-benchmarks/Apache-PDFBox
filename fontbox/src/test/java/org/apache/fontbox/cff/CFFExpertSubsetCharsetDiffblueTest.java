package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFExpertSubsetCharsetDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Method under test: {@link CFFExpertSubsetCharset#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CFFExpertSubsetCharset CFFExpertSubsetCharset.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CFFExpertSubsetCharset actualInstance = CFFExpertSubsetCharset.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance.getInstance());
  }
}
