package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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

class FillEvenOddRuleDiffblueTest {
  /**
   * Test {@link FillEvenOddRule#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#fillPath(int)} does nothing.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PageDrawer#fillPath(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FillEvenOddRule#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer fillPath(int) does nothing; when ArrayList(); then calls fillPath(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FillEvenOddRule.process(Operator, List)"})
  void testProcess_givenPageDrawerFillPathDoesNothing_whenArrayList_thenCallsFillPath() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).fillPath(anyInt());
    FillEvenOddRule fillEvenOddRule = new FillEvenOddRule(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    fillEvenOddRule.process(operator, new ArrayList<>());

    // Assert
    verify(context).fillPath(eq(0));
  }
}
