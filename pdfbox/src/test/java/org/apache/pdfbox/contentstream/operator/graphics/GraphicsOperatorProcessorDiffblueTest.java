package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.apache.pdfbox.contentstream.PDFGraphicsStreamEngine GraphicsOperatorProcessor.getGraphicsContext()"})
  void testGetGraphicsContext_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AppendRectangleToPath(null)).getGraphicsContext());
  }
}
