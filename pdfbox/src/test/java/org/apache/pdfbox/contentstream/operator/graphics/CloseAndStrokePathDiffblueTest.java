package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CloseAndStrokePathDiffblueTest {
  /**
   * Method under test: {@link CloseAndStrokePath#process(Operator, List)}
   */
  @Test
  void testProcess() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    doNothing().when(context).processOperator(Mockito.<String>any(), Mockito.<List<COSBase>>any());
    CloseAndStrokePath closeAndStrokePath = new CloseAndStrokePath(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    closeAndStrokePath.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context, atLeast(1)).processOperator(Mockito.<String>any(), isA(List.class));
  }
}
