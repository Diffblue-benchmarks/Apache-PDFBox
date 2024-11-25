package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SaveDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Save#Save(PDFStreamEngine)}
   *   <li>{@link Save#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("q", (new Save(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link Save#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDFStreamEngine#saveGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls saveGraphicsState()")
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSaveGraphicsState() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act
    save.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }

  /**
   * Test {@link Save#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link PDFStreamEngine#saveGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then calls saveGraphicsState()")
  void testProcess_givenFalse_whenArrayListAddFalse_thenCallsSaveGraphicsState2() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act
    save.process(operator, arguments);

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }

  /**
   * Test {@link Save#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PDFStreamEngine#saveGraphicsState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Save#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then calls saveGraphicsState()")
  void testProcess_whenArrayList_thenCallsSaveGraphicsState() {
    // Arrange
    PDFStreamEngine context = mock(PDFStreamEngine.class);
    doNothing().when(context).saveGraphicsState();
    Save save = new Save(context);
    Operator operator = Operator.getOperator("Operator");

    // Act
    save.process(operator, new ArrayList<>());

    // Assert that nothing has changed
    verify(context).saveGraphicsState();
  }
}
