package org.apache.fontbox.encoding;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EncodingDiffblueTest {
  /**
   * Test {@link Encoding#getName(int)}.
   *
   * <ul>
   *   <li>Given {@link StandardEncoding} (default constructor).
   *   <li>Then return {@code .notdef}.
   * </ul>
   *
   * <p>Method under test: {@link Encoding#getName(int)}
   */
  @Test
  @DisplayName(
      "Test getName(int); given StandardEncoding (default constructor); then return '.notdef'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String Encoding.getName(int)"})
  void testGetName_givenStandardEncoding_thenReturnNotdef() {
    // Arrange, Act and Assert
    assertEquals(".notdef", new StandardEncoding().getName(1));
  }
}
