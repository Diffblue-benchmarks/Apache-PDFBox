package org.apache.pdfbox.pdmodel.common.function.type4;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.logging.log4j.message.SimpleMessage;
import org.apache.pdfbox.contentstream.operator.OperatorName;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.SyntaxHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ParserDiffblueTest {
  /**
   * Test {@link Parser#parse(CharSequence, SyntaxHandler)}.
   *
   * <ul>
   *   <li>Then calls {@link SyntaxHandler#whitespace(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link Parser#parse(CharSequence, SyntaxHandler)}
   */
  @Test
  @DisplayName("Test parse(CharSequence, SyntaxHandler); then calls whitespace(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Parser.parse(CharSequence, SyntaxHandler)"})
  void testParse_thenCallsWhitespace() {
    // Arrange
    SimpleMessage input = new SimpleMessage("Not all who wander are lost");

    SyntaxHandler handler = mock(SyntaxHandler.class);
    doNothing().when(handler).whitespace(Mockito.<CharSequence>any());
    doNothing().when(handler).token(Mockito.<CharSequence>any());

    // Act
    Parser.parse(input, handler);

    // Assert
    verify(handler, atLeast(1)).token(isA(CharSequence.class));
    verify(handler, atLeast(1)).whitespace(isA(CharSequence.class));
  }

  /**
   * Test {@link Parser#parse(CharSequence, SyntaxHandler)}.
   *
   * <ul>
   *   <li>When {@link OperatorName#APPEND_RECT}.
   *   <li>Then calls {@link SyntaxHandler#token(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link Parser#parse(CharSequence, SyntaxHandler)}
   */
  @Test
  @DisplayName(
      "Test parse(CharSequence, SyntaxHandler); when APPEND_RECT; then calls token(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Parser.parse(CharSequence, SyntaxHandler)"})
  void testParse_whenAppend_rect_thenCallsToken() {
    // Arrange
    SyntaxHandler handler = mock(SyntaxHandler.class);
    doNothing().when(handler).token(Mockito.<CharSequence>any());

    // Act
    Parser.parse(OperatorName.APPEND_RECT, handler);

    // Assert
    verify(handler).token(isA(CharSequence.class));
  }

  /**
   * Test {@link Parser#parse(CharSequence, SyntaxHandler)}.
   *
   * <ul>
   *   <li>When lineSeparator.
   *   <li>Then calls {@link SyntaxHandler#newLine(CharSequence)}.
   * </ul>
   *
   * <p>Method under test: {@link Parser#parse(CharSequence, SyntaxHandler)}
   */
  @Test
  @DisplayName(
      "Test parse(CharSequence, SyntaxHandler); when lineSeparator; then calls newLine(CharSequence)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Parser.parse(CharSequence, SyntaxHandler)"})
  void testParse_whenLineSeparator_thenCallsNewLine() {
    // Arrange
    String input = System.lineSeparator();

    SyntaxHandler handler = mock(SyntaxHandler.class);
    doNothing().when(handler).newLine(Mockito.<CharSequence>any());

    // Act
    Parser.parse(input, handler);

    // Assert
    verify(handler).newLine(isA(CharSequence.class));
  }
}
