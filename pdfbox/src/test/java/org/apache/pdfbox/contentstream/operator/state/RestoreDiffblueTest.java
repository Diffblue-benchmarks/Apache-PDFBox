package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RestoreDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Restore#Restore(PDFStreamEngine)}
   *   <li>{@link Restore#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Restore.<init>(PDFStreamEngine)", "java.lang.String Restore.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Q", (new Restore(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link Restore#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Restore.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, arguments));
  }

  /**
   * Test {@link Restore#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Restore.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse2() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, arguments));
  }

  /**
   * Test {@link Restore#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link EmptyGraphicsStackException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw EmptyGraphicsStackException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Restore.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowEmptyGraphicsStackException() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(EmptyGraphicsStackException.class, () -> restore.process(operator, new ArrayList<>()));
  }
}
