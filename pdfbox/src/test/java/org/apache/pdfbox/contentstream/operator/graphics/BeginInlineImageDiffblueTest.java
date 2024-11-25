package org.apache.pdfbox.contentstream.operator.graphics;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.rendering.PageDrawer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BeginInlineImageDiffblueTest {
  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link NullPointerException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw NullPointerException")
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowNullPointerException() throws IOException {
    // Arrange
    BeginInlineImage beginInlineImage = new BeginInlineImage(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> beginInlineImage.process(operator, operands));
  }

  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link NullPointerException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw NullPointerException")
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowNullPointerException2() throws IOException {
    // Arrange
    BeginInlineImage beginInlineImage = new BeginInlineImage(null);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(NullPointerException.class, () -> beginInlineImage.process(operator, operands));
  }

  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#drawImage(PDImage)} does
   * nothing.</li>
   *   <li>Then calls {@link PDFStreamEngine#getResources()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer drawImage(PDImage) does nothing; then calls getResources()")
  void testProcess_givenPageDrawerDrawImageDoesNothing_thenCallsGetResources() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getResources()).thenReturn(new PDResources());
    doNothing().when(context).drawImage(Mockito.<PDImage>any());
    BeginInlineImage beginInlineImage = new BeginInlineImage(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act
    beginInlineImage.process(operator, operands);

    // Assert
    verify(context).getResources();
    verify(context).drawImage(isA(PDImage.class));
  }

  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link PageDrawer} {@link PageDrawer#drawImage(PDImage)} throw
   * {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given PageDrawer drawImage(PDImage) throw IOException(String) with 'foo'; then throw IOException")
  void testProcess_givenPageDrawerDrawImageThrowIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    PageDrawer context = mock(PageDrawer.class);
    when(context.getResources()).thenReturn(new PDResources());
    doThrow(new IOException("foo")).when(context).drawImage(Mockito.<PDImage>any());
    BeginInlineImage beginInlineImage = new BeginInlineImage(context);
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> operands = new ArrayList<>();
    operands.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> beginInlineImage.process(operator, operands));
    verify(context).getResources();
    verify(context).drawImage(isA(PDImage.class));
  }

  /**
   * Test {@link BeginInlineImage#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link NullPointerException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BeginInlineImage#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw NullPointerException")
  void testProcess_whenArrayList_thenThrowNullPointerException() throws IOException {
    // Arrange
    BeginInlineImage beginInlineImage = new BeginInlineImage(null);
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(NullPointerException.class, () -> beginInlineImage.process(operator, new ArrayList<>()));
  }
}
