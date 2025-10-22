package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFMergerExampleDiffblueTest {
  /**
   * Test {@link PDFMergerExample#merge(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFMergerExample#merge(List)}
   */
  @Test
  @DisplayName("Test merge(List); when ArrayList(); then return read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream PDFMergerExample.merge(List)"})
  void testMerge_whenArrayList_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    PDFMergerExample pdfMergerExample = new PDFMergerExample();

    // Act and Assert
    assertEquals(-1, pdfMergerExample.merge(new ArrayList<>()).read(new byte[]{}));
  }
}
