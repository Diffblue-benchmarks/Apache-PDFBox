package org.apache.pdfbox.contentstream.operator.graphics;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;
import org.apache.pdfbox.rendering.RenderDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BeginInlineImageDiffblueTest {
  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginInlineImage.process(Operator, List)"})
  void testProcess_givenEmptyArrayOfByte() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    BeginInlineImage beginInlineImage = new BeginInlineImage(context);

    Operator operator = Operator.getOperator("Operator");
    operator.setImageData(new byte[] {});

    // Act
    beginInlineImage.process(operator, new ArrayList<>());

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }

  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When Operator is {@code Operator} ImageData is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); given 'null'; when Operator is 'Operator' ImageData is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BeginInlineImage.process(Operator, List)"})
  void testProcess_givenNull_whenOperatorIsOperatorImageDataIsNull() throws IOException {
    // Arrange
    PageDrawerParameters parameters = mock(PageDrawerParameters.class);
    when(parameters.isSubsamplingAllowed()).thenReturn(true);
    when(parameters.getImageDownscalingOptimizationThreshold()).thenReturn(10.0f);
    when(parameters.getRenderingHints()).thenReturn(null);
    when(parameters.getPage()).thenReturn(new PDPage());
    when(parameters.getDestination()).thenReturn(RenderDestination.EXPORT);
    PageDrawer context = new PageDrawer(parameters);
    BeginInlineImage beginInlineImage = new BeginInlineImage(context);

    Operator operator = Operator.getOperator("Operator");
    operator.setImageData(null);

    // Act
    beginInlineImage.process(operator, new ArrayList<>());

    // Assert
    verify(parameters).getDestination();
    verify(parameters).getImageDownscalingOptimizationThreshold();
    verify(parameters).getPage();
    verify(parameters).getRenderingHints();
    verify(parameters).isSubsamplingAllowed();
  }
}
