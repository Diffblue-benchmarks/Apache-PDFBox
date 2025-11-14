package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFExpertEncodingDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link CFFExpertEncoding#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CFFExpertEncoding CFFExpertEncoding.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CFFExpertEncoding actualInstance = CFFExpertEncoding.getInstance();
    CFFExpertEncoding actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }
}
