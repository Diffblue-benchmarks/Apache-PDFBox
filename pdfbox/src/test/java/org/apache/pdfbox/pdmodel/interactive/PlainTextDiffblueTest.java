package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.interactive.PlainText.Line;
import org.apache.pdfbox.pdmodel.interactive.PlainText.Paragraph;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlainTextDiffblueTest {
  /**
   * Test Line {@link Line#addWord(Word)}.
   * <p>
   * Method under test: {@link PlainText.Line#addWord(PlainText.Word)}
   */
  @Test
  @DisplayName("Test Line addWord(Word)")
  void testLineAddWord() {
    // Arrange
    PlainText.Line line = new PlainText.Line();
    PlainText.Word word = new PlainText.Word("Text");

    // Act
    line.addWord(word);

    // Assert
    List<PlainText.Word> words = line.getWords();
    assertEquals(1, words.size());
    assertSame(word, words.get(0));
  }

  /**
   * Test Line {@link Line#calculateWidth(PDFont, float)}.
   * <ul>
   *   <li>Given {@link Line} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText.Line#calculateWidth(PDFont, float)}
   */
  @Test
  @DisplayName("Test Line calculateWidth(PDFont, float); given Line (default constructor); then return zero")
  void testLineCalculateWidth_givenLine_thenReturnZero() throws IOException {
    // Arrange
    PlainText.Line line = new PlainText.Line();

    // Act and Assert
    assertEquals(0.0f, line.calculateWidth(new PDMMType1Font(new COSDictionary()), 10.0f));
  }

  /**
   * Test Line {@link Line#getInterWordSpacing(float)}.
   * <p>
   * Method under test: {@link PlainText.Line#getInterWordSpacing(float)}
   */
  @Test
  @DisplayName("Test Line getInterWordSpacing(float)")
  void testLineGetInterWordSpacing() {
    // Arrange, Act and Assert
    assertEquals(-10.0f, (new PlainText.Line()).getInterWordSpacing(10.0f));
  }

  /**
   * Test Line getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PlainText.Line}
   *   <li>{@link PlainText.Line#setWidth(float)}
   *   <li>{@link PlainText.Line#getWidth()}
   *   <li>{@link PlainText.Line#getWords()}
   * </ul>
   */
  @Test
  @DisplayName("Test Line getters and setters")
  void testLineGettersAndSetters() {
    // Arrange and Act
    PlainText.Line actualLine = new PlainText.Line();
    actualLine.setWidth(10.0f);
    float actualWidth = actualLine.getWidth();

    // Assert that nothing has changed
    assertEquals(10.0f, actualWidth);
    assertTrue(actualLine.getWords().isEmpty());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return Paragraphs size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName("Test new PlainText(List); given '42'; when ArrayList() add '42'; then return Paragraphs size is two")
  void testNewPlainText_given42_whenArrayListAdd42_thenReturnParagraphsSizeIsTwo() {
    // Arrange
    ArrayList<String> listValue = new ArrayList<>();
    listValue.add("42");
    listValue.add("foo");

    // Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText(listValue)).getParagraphs();
    assertEquals(2, paragraphs.size());
    assertEquals("42", paragraphs.get(0).getText());
    assertEquals("foo", paragraphs.get(1).getText());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   *   <li>Then return Paragraphs size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName("Test new PlainText(List); given 'foo'; when ArrayList() add 'foo'; then return Paragraphs size is one")
  void testNewPlainText_givenFoo_whenArrayListAddFoo_thenReturnParagraphsSizeIsOne() {
    // Arrange
    ArrayList<String> listValue = new ArrayList<>();
    listValue.add("foo");

    // Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText(listValue)).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("foo", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#PlainText(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return Paragraphs first Text is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  @DisplayName("Test new PlainText(String); when '42'; then return Paragraphs first Text is '42'")
  void testNewPlainText_when42_thenReturnParagraphsFirstTextIs42() {
    // Arrange, Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText("42")).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("42", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Paragraphs Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName("Test new PlainText(List); when ArrayList(); then return Paragraphs Empty")
  void testNewPlainText_whenArrayList_thenReturnParagraphsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PlainText(new ArrayList<>())).getParagraphs().isEmpty());
  }

  /**
   * Test {@link PlainText#PlainText(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Paragraphs first Text is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  @DisplayName("Test new PlainText(String); when empty string; then return Paragraphs first Text is empty string")
  void testNewPlainText_whenEmptyString_thenReturnParagraphsFirstTextIsEmptyString() {
    // Arrange, Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText("")).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#getParagraphs()}.
   * <p>
   * Method under test: {@link PlainText#getParagraphs()}
   */
  @Test
  @DisplayName("Test getParagraphs()")
  void testGetParagraphs() {
    // Arrange and Act
    List<PlainText.Paragraph> actualParagraphs = (new PlainText("42")).getParagraphs();

    // Assert
    assertEquals(1, actualParagraphs.size());
    assertEquals("42", actualParagraphs.get(0).getText());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   * <ul>
   *   <li>Given {@link Paragraph#Paragraph(String)} with text is
   * {@code .notdef}.</li>
   *   <li>Then return size is five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName("Test Paragraph getLines(PDFont, float, float); given Paragraph(String) with text is '.notdef'; then return size is five")
  void testParagraphGetLines_givenParagraphWithTextIsNotdef_thenReturnSizeIsFive() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph(".notdef");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(5, actualLines.size());
    PlainText.Line getResult = actualLines.get(3);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("de", words.get(0).getText());
    PlainText.Line getResult2 = actualLines.get(4);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("f", words2.get(0).getText());
    PlainText.Line getResult3 = actualLines.get(1);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("n", words3.get(0).getText());
    PlainText.Line getResult4 = actualLines.get(2);
    List<PlainText.Word> words4 = getResult4.getWords();
    assertEquals(1, words4.size());
    assertEquals("ot", words4.get(0).getText());
    assertEquals(2.5f, actualLines.get(0).getWidth());
    assertEquals(3.3300781f, getResult2.getWidth());
    assertEquals(5.0f, getResult3.getWidth());
    assertEquals(7.7783203f, getResult4.getWidth());
    assertEquals(9.438477f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   * <ul>
   *   <li>Given {@link Paragraph#Paragraph(String)} with text is
   * {@code .notdef}.</li>
   *   <li>When {@code 2.5}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName("Test Paragraph getLines(PDFont, float, float); given Paragraph(String) with text is '.notdef'; when '2.5'; then return size is one")
  void testParagraphGetLines_givenParagraphWithTextIsNotdef_when25_thenReturnSizeIsOne() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph(".notdef");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 2.5f, 10.0f);

    // Assert
    assertEquals(1, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(2, words.size());
    assertEquals("notdef", words.get(1).getText());
    assertEquals(7.0117188f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName("Test Paragraph getLines(PDFont, float, float); then return size is three")
  void testParagraphGetLines_thenReturnSizeIsThree() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("Text");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(3, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("T", words.get(0).getText());
    PlainText.Line getResult2 = actualLines.get(1);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("ex", words2.get(0).getText());
    PlainText.Line getResult3 = actualLines.get(2);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("t", words3.get(0).getText());
    assertEquals(2.7783203f, getResult3.getWidth());
    assertEquals(6.1083984f, getResult.getWidth());
    assertEquals(9.438477f, getResult2.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   * <ul>
   *   <li>When {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName("Test Paragraph getLines(PDFont, float, float); when PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testParagraphGetLines_whenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("Text");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSStream()), 10.0f, 10.0f);

    // Assert
    assertEquals(3, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("T", words.get(0).getText());
    PlainText.Line getResult2 = actualLines.get(1);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("ex", words2.get(0).getText());
    PlainText.Line getResult3 = actualLines.get(2);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("t", words3.get(0).getText());
    assertEquals(2.7783203f, getResult3.getWidth());
    assertEquals(6.1083984f, getResult.getWidth());
    assertEquals(9.438477f, getResult2.getWidth());
  }

  /**
   * Test Paragraph getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlainText.Paragraph#Paragraph(String)}
   *   <li>{@link PlainText.Paragraph#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test Paragraph getters and setters")
  void testParagraphGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Text", (new PlainText.Paragraph("Text")).getText());
  }

  /**
   * Test Word getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PlainText.Word#Word(String)}
   *   <li>{@link PlainText.Word#setAttributes(AttributedString)}
   *   <li>{@link PlainText.Word#getAttributes()}
   *   <li>{@link PlainText.Word#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test Word getters and setters")
  void testWordGettersAndSetters() {
    // Arrange and Act
    PlainText.Word actualWord = new PlainText.Word("Text");
    AttributedString as = new AttributedString("foo");
    actualWord.setAttributes(as);
    AttributedString actualAttributes = actualWord.getAttributes();

    // Assert that nothing has changed
    assertEquals("Text", actualWord.getText());
    assertSame(as, actualAttributes);
  }
}
