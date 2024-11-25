package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GraphicsOperatorProcessorDiffblueTest {
  /**
   * Test {@link GraphicsOperatorProcessor#getGraphicsContext()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphicsOperatorProcessor#getGraphicsContext()}
   */
  @Test
  @DisplayName("Test getGraphicsContext(); then return 'null'")
  void testGetGraphicsContext_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AppendRectangleToPath(null)).getGraphicsContext());
  }
}
