package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.apache.pdfbox.pdmodel.interactive.PlainText.Line;
import org.apache.pdfbox.pdmodel.interactive.PlainText.Paragraph;
import org.apache.pdfbox.pdmodel.interactive.PlainText.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PlainTextDiffblueTest {
  /**
   * Test Line {@link Line#addWord(Word)}.
   *
   * <p>Method under test: {@link Line#addWord(Word)}
   */
  @Test
  @DisplayName("Test Line addWord(Word)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Line.addWord(Word)"})
  void testLineAddWord() {
    // Arrange
    Line line = new Line();
    Word word = new Word("Text");

    // Act
    line.addWord(word);

    // Assert
    List<Word> words = line.getWords();
    assertEquals(1, words.size());
    assertSame(word, words.get(0));
  }

  /**
   * Test Line {@link Line#calculateWidth(PDFont, float)}.
   *
   * <ul>
   *   <li>Given {@link Line} (default constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link Line#calculateWidth(PDFont, float)}
   */
  @Test
  @DisplayName(
      "Test Line calculateWidth(PDFont, float); given Line (default constructor); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Line.calculateWidth(PDFont, float)"})
  void testLineCalculateWidth_givenLine_thenReturnZero() throws IOException {
    // Arrange
    Line line = new Line();

    // Act and Assert
    assertEquals(0.0f, line.calculateWidth(new PDMMType1Font(new COSDictionary()), 10.0f));
  }

  /**
   * Test Line {@link Line#getInterWordSpacing(float)}.
   *
   * <p>Method under test: {@link Line#getInterWordSpacing(float)}
   */
  @Test
  @DisplayName("Test Line getInterWordSpacing(float)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float Line.getInterWordSpacing(float)"})
  void testLineGetInterWordSpacing() {
    // Arrange, Act and Assert
    assertEquals(-10.0f, new Line().getInterWordSpacing(10.0f));
  }

  /**
   * Test Line getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Line}
   *   <li>{@link Line#setWidth(float)}
   *   <li>{@link Line#getWidth()}
   *   <li>{@link Line#getWords()}
   * </ul>
   */
  @Test
  @DisplayName("Test Line getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Line.<init>()",
    "float Line.getWidth()",
    "List Line.getWords()",
    "void Line.setWidth(float)"
  })
  void testLineGettersAndSetters() {
    // Arrange and Act
    Line actualLine = new Line();
    actualLine.setWidth(10.0f);
    float actualWidth = actualLine.getWidth();

    // Assert
    assertEquals(10.0f, actualWidth);
    assertTrue(actualLine.getWords().isEmpty());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Paragraphs size is two.
   * </ul>
   *
   * <p>Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName(
      "Test new PlainText(List); given '42'; when ArrayList() add '42'; then return Paragraphs size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainText.<init>(List)"})
  void testNewPlainText_given42_whenArrayListAdd42_thenReturnParagraphsSizeIsTwo() {
    // Arrange
    ArrayList<String> listValue = new ArrayList<>();
    listValue.add("42");
    listValue.add("foo");

    // Act and Assert
    List<Paragraph> paragraphs = new PlainText(listValue).getParagraphs();
    assertEquals(2, paragraphs.size());
    assertEquals("42", paragraphs.get(0).getText());
    assertEquals("foo", paragraphs.get(1).getText());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Paragraphs size is one.
   * </ul>
   *
   * <p>Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName(
      "Test new PlainText(List); given 'foo'; when ArrayList() add 'foo'; then return Paragraphs size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainText.<init>(List)"})
  void testNewPlainText_givenFoo_whenArrayListAddFoo_thenReturnParagraphsSizeIsOne() {
    // Arrange
    ArrayList<String> listValue = new ArrayList<>();
    listValue.add("foo");

    // Act and Assert
    List<Paragraph> paragraphs = new PlainText(listValue).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("foo", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#PlainText(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return Paragraphs first Text is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  @DisplayName("Test new PlainText(String); when '42'; then return Paragraphs first Text is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainText.<init>(String)"})
  void testNewPlainText_when42_thenReturnParagraphsFirstTextIs42() {
    // Arrange, Act and Assert
    List<Paragraph> paragraphs = new PlainText("42").getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("42", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#PlainText(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Paragraphs Empty.
   * </ul>
   *
   * <p>Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  @DisplayName("Test new PlainText(List); when ArrayList(); then return Paragraphs Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainText.<init>(List)"})
  void testNewPlainText_whenArrayList_thenReturnParagraphsEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PlainText(new ArrayList<>()).getParagraphs().isEmpty());
  }

  /**
   * Test {@link PlainText#PlainText(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return Paragraphs first Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  @DisplayName(
      "Test new PlainText(String); when empty string; then return Paragraphs first Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PlainText.<init>(String)"})
  void testNewPlainText_whenEmptyString_thenReturnParagraphsFirstTextIsEmptyString() {
    // Arrange, Act and Assert
    List<Paragraph> paragraphs = new PlainText("").getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("", paragraphs.get(0).getText());
  }

  /**
   * Test {@link PlainText#getParagraphs()}.
   *
   * <p>Method under test: {@link PlainText#getParagraphs()}
   */
  @Test
  @DisplayName("Test getParagraphs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PlainText.getParagraphs()"})
  void testGetParagraphs() {
    // Arrange and Act
    List<Paragraph> actualParagraphs = new PlainText("42").getParagraphs();

    // Assert
    assertEquals(1, actualParagraphs.size());
    assertEquals("42", actualParagraphs.get(0).getText());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>Given {@link Paragraph#Paragraph(String)} with text is {@code .notdef}.
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); given Paragraph(String) with text is '.notdef'; then return size is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_givenParagraphWithTextIsNotdef_thenReturnSizeIsFive()
      throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph(".notdef");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(5, actualLines.size());
    assertEquals(2.5f, actualLines.get(0).getWidth());
    assertEquals(3.3300781f, actualLines.get(4).getWidth());
    assertEquals(5.0f, actualLines.get(1).getWidth());
    assertEquals(7.7783203f, actualLines.get(2).getWidth());
    assertEquals(9.438477f, actualLines.get(3).getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>Given {@link Paragraph#Paragraph(String)} with {@code Text}.
   *   <li>Then return first Words first Text is {@code T}.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); given Paragraph(String) with 'Text'; then return first Words first Text is 'T'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_givenParagraphWithText_thenReturnFirstWordsFirstTextIsT()
      throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("Text");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(3, actualLines.size());
    Line getResult = actualLines.get(0);
    List<Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("T", words.get(0).getText());
    Line getResult2 = actualLines.get(1);
    List<Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("ex", words2.get(0).getText());
    Line getResult3 = actualLines.get(2);
    List<Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("t", words3.get(0).getText());
    assertEquals(2.7783203f, getResult3.getWidth());
    assertEquals(6.1083984f, getResult.getWidth());
    assertEquals(9.438477f, getResult2.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>Then return first Words first Text is {@code maxp}.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); then return first Words first Text is 'maxp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_thenReturnFirstWordsFirstTextIsMaxp() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("maxp");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDType1CFont(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(1, actualLines.size());
    Line getResult = actualLines.get(0);
    List<Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("maxp", words.get(0).getText());
    assertEquals(0.0f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>Then return second Words first Text is {@code ax}.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); then return second Words first Text is 'ax'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_thenReturnSecondWordsFirstTextIsAx() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("maxp");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDType1Font(FontName.TIMES_ROMAN), 10.0f, 10.0f);

    // Assert
    assertEquals(3, actualLines.size());
    Line getResult = actualLines.get(1);
    List<Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("ax", words.get(0).getText());
    Line getResult2 = actualLines.get(0);
    List<Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("m", words2.get(0).getText());
    Line getResult3 = actualLines.get(2);
    List<Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("p", words3.get(0).getText());
    assertEquals(5.0f, getResult3.getWidth());
    assertEquals(7.7799997f, getResult2.getWidth());
    assertEquals(9.44f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return first Words size is six.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); when '-0.5'; then return first Words size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_when05_thenReturnFirstWordsSizeIsSix() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("No embedded CFF font, returning 0");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDMMType1Font(new COSDictionary()), -0.5f, -0.5f);

    // Assert
    assertEquals(1, actualLines.size());
    Line getResult = actualLines.get(0);
    List<Word> words = getResult.getWords();
    assertEquals(6, words.size());
    assertEquals("0", words.get(5).getText());
    assertEquals("embedded ", words.get(1).getText());
    assertEquals("returning ", words.get(4).getText());
    assertEquals(-7.1936035f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>When {@code 2.5}.
   *   <li>Then return first Words size is two.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); when '2.5'; then return first Words size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_when25_thenReturnFirstWordsSizeIsTwo() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph(".notdef");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDMMType1Font(new COSDictionary()), 2.5f, 10.0f);

    // Assert
    assertEquals(1, actualLines.size());
    Line getResult = actualLines.get(0);
    List<Word> words = getResult.getWords();
    assertEquals(2, words.size());
    assertEquals(".", words.get(0).getText());
    assertEquals("notdef", words.get(1).getText());
    assertEquals(7.0117188f, getResult.getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>When {@code 14.72168}.
   *   <li>Then return size is twelve.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName(
      "Test Paragraph getLines(PDFont, float, float); when '14.72168'; then return size is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_when1472168_thenReturnSizeIsTwelve() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("No embedded CFF font, returning 0");

    // Act
    List<Line> actualLines =
        paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 14.72168f);

    // Assert
    assertEquals(12, actualLines.size());
    Line getResult = actualLines.get(11);
    assertEquals(1, getResult.getWords().size());
    Line getResult2 = actualLines.get(6);
    assertEquals(1, getResult2.getWords().size());
    Line getResult3 = actualLines.get(7);
    assertEquals(1, getResult3.getWords().size());
    Line getResult4 = actualLines.get(8);
    assertEquals(1, getResult4.getWords().size());
    Line getResult5 = actualLines.get(9);
    assertEquals(1, getResult5.getWords().size());
    assertEquals(10.546875f, getResult4.getWidth());
    assertEquals(12.216797f, actualLines.get(1).getWidth());
    assertEquals(12.22168f, actualLines.get(0).getWidth());
    assertEquals(12.231445f, actualLines.get(4).getWidth());
    Line getResult6 = actualLines.get(10);
    assertEquals(12.77832f, getResult6.getWidth());
    assertEquals(13.330078f, getResult2.getWidth());
    assertEquals(13.330078f, getResult5.getWidth());
    assertEquals(14.438477f, actualLines.get(2).getWidth());
    Line getResult7 = actualLines.get(3);
    assertEquals(14.438477f, getResult7.getWidth());
    assertEquals(2, getResult6.getWords().size());
    assertEquals(2, getResult7.getWords().size());
    assertEquals(5.0f, getResult.getWidth());
    assertEquals(5.2783203f, getResult3.getWidth());
    assertEquals(5.5615234f, actualLines.get(5).getWidth());
  }

  /**
   * Test Paragraph {@link Paragraph#getLines(PDFont, float, float)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  @DisplayName("Test Paragraph getLines(PDFont, float, float); when zero; then return size is six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Paragraph.getLines(PDFont, float, float)"})
  void testParagraphGetLines_whenZero_thenReturnSizeIsSix() throws IOException {
    // Arrange
    Paragraph paragraph = new Paragraph("No embedded CFF font, returning 0");

    // Act
    List<Line> actualLines = paragraph.getLines(new PDType1CFont(new COSDictionary()), 10.0f, 0.0f);

    // Assert
    assertEquals(6, actualLines.size());
    assertEquals(0.0f, actualLines.get(1).getWidth());
    assertEquals(0.0f, actualLines.get(2).getWidth());
    assertEquals(0.0f, actualLines.get(3).getWidth());
    assertEquals(0.0f, actualLines.get(4).getWidth());
    assertEquals(0.0f, actualLines.get(5).getWidth());
  }

  /**
   * Test Paragraph getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Paragraph#Paragraph(String)}
   *   <li>{@link Paragraph#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test Paragraph getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Paragraph.<init>(String)", "String Paragraph.getText()"})
  void testParagraphGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Text", new Paragraph("Text").getText());
  }

  /**
   * Test Word getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Word#Word(String)}
   *   <li>{@link Word#setAttributes(AttributedString)}
   *   <li>{@link Word#getAttributes()}
   *   <li>{@link Word#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test Word getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Word.<init>(String)",
    "AttributedString Word.getAttributes()",
    "String Word.getText()",
    "void Word.setAttributes(AttributedString)"
  })
  void testWordGettersAndSetters() {
    // Arrange and Act
    Word actualWord = new Word("Text");
    AttributedString as = new AttributedString("Text");
    actualWord.setAttributes(as);
    AttributedString actualAttributes = actualWord.getAttributes();

    // Assert
    assertEquals("Text", actualWord.getText());
    assertSame(as, actualAttributes);
  }
}
