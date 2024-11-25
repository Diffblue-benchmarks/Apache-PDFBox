package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
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

class ClipNonZeroRuleDiffblueTest {
  /**
   * Test {@link ClipNonZeroRule#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#clip(int)} does nothing.</li>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PageDrawer#clip(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClipNonZeroRule#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer clip(int) does nothing; when ArrayList(); then calls clip(int)")
  void testProcess_givenPageDrawerClipDoesNothing_whenArrayList_thenCallsClip() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).clip(anyInt());
    ClipNonZeroRule clipNonZeroRule = new ClipNonZeroRule(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    clipNonZeroRule.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).clip(eq(1));
  }
}
