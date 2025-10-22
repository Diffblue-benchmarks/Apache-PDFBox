package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StrokePathDiffblueTest {
  /**
   * Test {@link StrokePath#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#strokePath()} does nothing.</li>
   *   <li>Then calls {@link PageDrawer#strokePath()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StrokePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer strokePath() does nothing; then calls strokePath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void StrokePath.process(Operator, List)"})
  void testProcess_givenPageDrawerStrokePathDoesNothing_thenCallsStrokePath() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).strokePath();
    StrokePath strokePath = new StrokePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    strokePath.process(operator, new ArrayList<>());

    // Assert
    verify(context).strokePath();
  }
}
