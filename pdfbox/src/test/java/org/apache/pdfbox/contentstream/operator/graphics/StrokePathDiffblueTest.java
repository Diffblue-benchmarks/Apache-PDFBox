package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.Test;

class StrokePathDiffblueTest {
  /**
   * Method under test: {@link StrokePath#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).strokePath();
    StrokePath strokePath = new StrokePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    strokePath.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).strokePath();
  }
}
