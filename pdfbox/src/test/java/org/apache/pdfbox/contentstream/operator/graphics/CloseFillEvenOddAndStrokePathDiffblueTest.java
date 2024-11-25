package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CloseFillEvenOddAndStrokePathDiffblueTest {
  /**
   * Test {@link CloseFillEvenOddAndStrokePath#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer}
   * {@link PDFStreamEngine#processOperator(String, List)} does nothing.</li>
   *   <li>Then calls {@link PDFStreamEngine#processOperator(String, List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CloseFillEvenOddAndStrokePath#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer processOperator(String, List) does nothing; then calls processOperator(String, List)")
  void testProcess_givenPageDrawerProcessOperatorDoesNothing_thenCallsProcessOperator() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    CloseFillEvenOddAndStrokePath closeFillEvenOddAndStrokePath = new CloseFillEvenOddAndStrokePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closeFillEvenOddAndStrokePath.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context, atLeast(1)).processOperator(Mockito.<String>any(), isA(List.class));
  }
}
