package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SetLineMiterLimitDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SetLineMiterLimit#SetLineMiterLimit(PDFStreamEngine)}
   *   <li>{@link SetLineMiterLimit#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SetLineMiterLimit.<init>(PDFStreamEngine)",
    "java.lang.String SetLineMiterLimit.getName()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("M", new SetLineMiterLimit(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link SetLineMiterLimit#process(Operator, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link MissingOperandException}.
   * </ul>
   *
   * <p>Method under test: {@link SetLineMiterLimit#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SetLineMiterLimit.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    SetLineMiterLimit setLineMiterLimit = new SetLineMiterLimit(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        MissingOperandException.class,
        () -> setLineMiterLimit.process(operator, new ArrayList<>()));
  }
}
