package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.Test;

class PDContentStreamDiffblueTest {
  /**
   * Method under test: {@link PDContentStream#getContentsForStreamParsing()}
   */
  @Test
  void testGetContentsForStreamParsing() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContentsForStreamParsing());
  }
}
