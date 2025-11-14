package org.apache.pdfbox.contentstream.operator.markedcontent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.DrawObject;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BeginMarkedContentSequenceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BeginMarkedContentSequence#BeginMarkedContentSequence(PDFStreamEngine)}
   *   <li>{@link BeginMarkedContentSequence#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BeginMarkedContentSequence.<init>(PDFStreamEngine)",
    "java.lang.String BeginMarkedContentSequence.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("BMC", new BeginMarkedContentSequence(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link BeginMarkedContentSequence#process(Operator, List)}.
   *
   * <ul>
   *   <li>Then calls {@link PageDrawerParameters#getDestination()}.
   * </ul>
   *
   * <p>Method under test: {@link BeginMarkedContentSequence#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); then calls getDestination()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginMarkedContentSequence.process(Operator, List)"})
  void testProcess_thenCallsGetDestination() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);

    PageDrawer context = new PageDrawer(parameters);
    context.addOperator(new DrawObject(new PDFMarkedContentExtractor()));
    BeginMarkedContentSequence beginMarkedContentSequence = new BeginMarkedContentSequence(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSName.A);

    // Act
    beginMarkedContentSequence.process(operator, arguments);

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }
}
