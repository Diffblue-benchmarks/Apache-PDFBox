package org.apache.pdfbox.contentstream.operator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DrawObjectDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DrawObject#DrawObject(PDFStreamEngine)}
   *   <li>{@link DrawObject#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DrawObject.<init>(PDFStreamEngine)", "java.lang.String DrawObject.getName()"})
  void testGettersAndSetters() {
    // Arrange
    PDFMarkedContentExtractor context = new PDFMarkedContentExtractor();

    // Act
    DrawObject actualDrawObject = new DrawObject(context);

    // Assert
    assertEquals(OperatorName.DRAW_OBJECT, actualDrawObject.getName());
    assertSame(context, actualDrawObject.getContext());
  }

  /**
   * Test {@link DrawObject#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DrawObject#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DrawObject.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    DrawObject drawObject = new DrawObject(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> drawObject.process(operator, new ArrayList<>()));
  }
}
