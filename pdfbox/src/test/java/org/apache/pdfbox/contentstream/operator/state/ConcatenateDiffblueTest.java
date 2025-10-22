package org.apache.pdfbox.contentstream.operator.state;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.contentstream.PDFStreamEngine;
import org.apache.pdfbox.contentstream.operator.MissingOperandException;
import org.apache.pdfbox.contentstream.operator.Operator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.text.PDFMarkedContentExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConcatenateDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Concatenate#Concatenate(PDFStreamEngine)}
   *   <li>{@link Concatenate#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.<init>(PDFStreamEngine)", "java.lang.String Concatenate.getName()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("cm", (new Concatenate(new PDFMarkedContentExtractor())).getName());
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSArray(); when ArrayList() add COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenCOSArray_whenArrayListAddCOSArray() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSArray());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat(float) with aFloat is '-3.4028235E38'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIs34028235e38() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(-3.4028235E38f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#COSFloat(float)} with aFloat is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSFloat(float) with aFloat is ten; when ArrayList() add COSFloat(float) with aFloat is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenCOSFloatWithAFloatIsTen_whenArrayListAddCOSFloatWithAFloatIsTen() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSFloat(10.0f));

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given COSStream(); when ArrayList() add COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenCOSStream_whenArrayListAddCOSStream() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(new COSStream());

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given FALSE; when ArrayList() add FALSE; then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenFalse_whenArrayListAddFalse_thenThrowMissingOperandException2() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSBoolean.FALSE);
    arguments.add(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSFloat#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSFloat#ONE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSFloat.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>Given {@link COSInteger#ONE}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSInteger#ONE}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); given ONE; when ArrayList() add ONE; then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_givenOne_whenArrayListAddOne_thenThrowMissingOperandException2() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    ArrayList<COSBase> arguments = new ArrayList<>();
    arguments.add(COSInteger.ONE);

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, arguments));
  }

  /**
   * Test {@link Concatenate#process(Operator, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then throw {@link MissingOperandException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Concatenate#process(Operator, List)}
   */
  @Test
  @DisplayName("Test process(Operator, List); when ArrayList(); then throw MissingOperandException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Concatenate.process(Operator, List)"})
  void testProcess_whenArrayList_thenThrowMissingOperandException() throws IOException {
    // Arrange
    Concatenate concatenate = new Concatenate(new PDFMarkedContentExtractor());
    Operator operator = Operator.getOperator("Operator");

    // Act and Assert
    assertThrows(MissingOperandException.class, () -> concatenate.process(operator, new ArrayList<>()));
  }
}
