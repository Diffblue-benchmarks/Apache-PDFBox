package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EndPathDiffblueTest {
  /**
   * Test {@link EndPath#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#endPath()} does nothing.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PageDrawer#endPath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EndPath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer endPath() does nothing; when ArrayList(); then calls endPath()")
  void testProcess_givenPageDrawerEndPathDoesNothing_whenArrayList_thenCallsEndPath() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).endPath();
    EndPath endPath = new EndPath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    endPath.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).endPath();
  }
}
