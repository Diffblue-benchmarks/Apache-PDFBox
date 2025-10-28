package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.Test;

class ClosePathDiffblueTest {
  /**
   * Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).closePath();
    when(context.getCurrentPoint()).thenReturn(new Point(1, 1));
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closePath.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).closePath();
    verify(context).getCurrentPoint();
  }

  /**
   * Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  void testProcess2() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getCurrentPoint()).thenReturn(null);
    ClosePath closePath = new ClosePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closePath.process(operator, new ArrayList<>());

    // Assert
    verify(context).getCurrentPoint();
  }
}
