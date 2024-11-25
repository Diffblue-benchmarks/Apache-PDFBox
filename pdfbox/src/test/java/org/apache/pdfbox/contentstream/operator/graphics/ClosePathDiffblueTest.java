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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClosePathDiffblueTest {
  /**
   * Test {@link ClosePath#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#closePath()} does
   * nothing.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PageDrawer#closePath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer closePath() does nothing; when ArrayList(); then calls closePath()")
  void testProcess_givenPageDrawerClosePathDoesNothing_whenArrayList_thenCallsClosePath() throws IOException {
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
   * Test {@link ClosePath#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#getCurrentPoint()} return
   * {@code null}.</li>
   *   <li>Then calls {@link PageDrawer#getCurrentPoint()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClosePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer getCurrentPoint() return 'null'; then calls getCurrentPoint()")
  void testProcess_givenPageDrawerGetCurrentPointReturnNull_thenCallsGetCurrentPoint() throws IOException {
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
