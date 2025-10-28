package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class GraphicsOperatorProcessorDiffblueTest {
  /**
   * Method under test: {@link GraphicsOperatorProcessor#getGraphicsContext()}
   */
  @Test
  void testGetGraphicsContext() {
    // Arrange, Act and Assert
    assertNull((new AppendRectangleToPath(null)).getGraphicsContext());
  }
}
