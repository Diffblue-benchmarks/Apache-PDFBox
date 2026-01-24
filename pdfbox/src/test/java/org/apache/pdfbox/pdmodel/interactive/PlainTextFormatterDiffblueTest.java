package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDAppearanceContentStream;
import org.apache.pdfbox.pdmodel.interactive.PlainTextFormatter.Builder;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlainTextFormatterDiffblueTest {
  /**
   * Test Builder {@link Builder#initialOffset(float, float)}.
   *
   * <p>Method under test: {@link Builder#initialOffset(float, float)}
   */
  @Test
  @DisplayName("Test Builder initialOffset(float, float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.initialOffset(float, float)"})
  void testBuilderInitialOffset() throws IOException {
    // Arrange
    PDAppearanceContentStream contents =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    Builder builder = new Builder(contents);

    // Act
    Builder actualInitialOffsetResult = builder.initialOffset(10.0f, 10.0f);

    // Assert
    assertSame(builder, actualInitialOffsetResult);
  }

  /**
   * Test Builder {@link Builder#textAlign(int)} with {@code int}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#textAlign(int)}
   */
  @Test
  @DisplayName("Test Builder textAlign(int) with 'int'; when minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.textAlign(int)"})
  void testBuilderTextAlignWithInt_whenMinusOne() throws IOException {
    // Arrange
    PDAppearanceContentStream contents =
        new PDAppearanceContentStream(new PDAppearanceStream(new COSStream()));
    Builder builder = new Builder(contents);

    // Act
    Builder actualTextAlignResult = builder.textAlign(-1);

    // Assert
    assertSame(builder, actualTextAlignResult);
  }
}
