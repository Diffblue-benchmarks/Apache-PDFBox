package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link Restore#Restore(PDFStreamEngine)}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Restore#Restore(PDFStreamEngine)}
   *   <li>{@link Restore#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test new Restore(PDFStreamEngine)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Restore.<init>(PDFStreamEngine)", "java.lang.String Restore.getName()"})
  void testNewRestore() {
    // Arrange, Act and Assert
    assertEquals("Q", new Restore(new PDFMarkedContentExtractor()).getName());
  }

  /**
   * Test {@link Restore#process(Operator, List)}.
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link EmptyGraphicsStackException}.
   * </ul>
   *
   * <p>Method under test: {@link Restore#process(Operator, List)}
   */
  @Test
  @DisplayName(
      "Test process(Operator, List); when ArrayList(); then throw EmptyGraphicsStackException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Restore.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowEmptyGraphicsStackException() throws IOException {
    // Arrange
    Restore restore = new Restore(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(
        EmptyGraphicsStackException.class, () -> restore.process(operator, new ArrayList<>()));
  }
}
