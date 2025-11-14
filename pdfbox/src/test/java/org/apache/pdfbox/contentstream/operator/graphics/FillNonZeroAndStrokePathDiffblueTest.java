package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FillNonZeroAndStrokePathDiffblueTest {
  /**
   * Test {@link FillNonZeroAndStrokePath#process(Operator, List)}.
   *
   * <ul>
   *   <li>Then calls {@link PageDrawer#fillAndStrokePath(int)}.
   * </ul>
   *
   * <p>Method under test: {@link FillNonZeroAndStrokePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then calls fillAndStrokePath(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FillNonZeroAndStrokePath.process(Operator, List)"})
  void testProcess_thenCallsFillAndStrokePath() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).fillAndStrokePath(anyInt());
    FillNonZeroAndStrokePath fillNonZeroAndStrokePath = new FillNonZeroAndStrokePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    fillNonZeroAndStrokePath.process(operator, new ArrayList<>());

    // Assert
    verify(context).fillAndStrokePath(1);
  }
}
