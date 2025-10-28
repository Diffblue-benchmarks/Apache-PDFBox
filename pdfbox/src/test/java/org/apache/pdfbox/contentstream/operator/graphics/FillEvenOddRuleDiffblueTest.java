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
import org.junit.jupiter.api.Test;

class FillEvenOddRuleDiffblueTest {
  /**
   * Method under test: {@link FillEvenOddRule#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).fillPath(anyInt());
    FillEvenOddRule fillEvenOddRule = new FillEvenOddRule(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    fillEvenOddRule.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).fillPath(eq(0));
  }
}
