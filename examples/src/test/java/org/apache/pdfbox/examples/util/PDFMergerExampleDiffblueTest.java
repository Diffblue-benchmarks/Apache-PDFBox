package org.apache.pdfbox.examples.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class PDFMergerExampleDiffblueTest {
  /**
   * Method under test: {@link PDFMergerExample#merge(List)}
   */
  @Test
  void testMerge() throws IOException {
    // Arrange
    PDFMergerExample pdfMergerExample = new PDFMergerExample();

    // Act and Assert
    assertEquals(-1, pdfMergerExample.merge(new ArrayList<>()).read(new byte[]{}));
  }
}
