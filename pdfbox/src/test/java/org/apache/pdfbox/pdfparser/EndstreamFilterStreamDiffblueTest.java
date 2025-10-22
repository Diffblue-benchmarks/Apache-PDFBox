package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EndstreamFilterStreamDiffblueTest {
  /**
   * Test {@link EndstreamFilterStream#calculateLength()}.
   * <p>
   * Method under test: {@link EndstreamFilterStream#calculateLength()}
   */
  @Test
  @DisplayName("Test calculateLength()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EndstreamFilterStream.calculateLength()"})
  void testCalculateLength() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EndstreamFilterStream()).calculateLength());
  }
}
