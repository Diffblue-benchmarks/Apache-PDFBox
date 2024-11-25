package org.apache.pdfbox.contentstream;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDContentStreamDiffblueTest {
  /**
   * Test {@link PDContentStream#getContentsForStreamParsing()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDContentStream#getContentsForStreamParsing()}
   */
  @Test
  @DisplayName("Test getContentsForStreamParsing(); then return 'null'")
  void testGetContentsForStreamParsing_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDTilingPattern(new COSDictionary())).getContentsForStreamParsing());
  }
}
