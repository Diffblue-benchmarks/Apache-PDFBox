package org.apache.pdfbox.pdmodel.interactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDMMType1Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.junit.jupiter.api.Test;

class PlainTextDiffblueTest {
  /**
   * Method under test: {@link PlainText#getParagraphs()}
   */
  @Test
  void testGetParagraphs() {
    // Arrange and Act
    List<PlainText.Paragraph> actualParagraphs = (new PlainText("42")).getParagraphs();

    // Assert
    assertEquals(1, actualParagraphs.size());
    assertEquals("42", actualParagraphs.get(0).getText());
  }

  /**
   * Method under test: {@link PlainText.Line#addWord(PlainText.Word)}
   */
  @Test
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
   * Method under test: {@link PlainText.Line#calculateWidth(PDFont, float)}
   */
  @Test
  void testLineCalculateWidth() throws IOException {
    // Arrange
    PlainText.Line line = new PlainText.Line();

    // Act and Assert
    assertEquals(0.0f, line.calculateWidth(new PDMMType1Font(new COSDictionary()), 10.0f));
  }

  /**
   * Method under test: {@link PlainText.Line#getInterWordSpacing(float)}
   */
  @Test
  void testLineGetInterWordSpacing() {
    // Arrange, Act and Assert
    assertEquals(-10.0f, (new PlainText.Line()).getInterWordSpacing(10.0f));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PlainText.Line}
   *   <li>{@link PlainText.Line#setWidth(float)}
   *   <li>{@link PlainText.Line#getWidth()}
   *   <li>{@link PlainText.Line#getWords()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  void testNewPlainText() {
    // Arrange, Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText("42")).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("42", paragraphs.get(0).getText());
  }

  /**
   * Method under test: {@link PlainText#PlainText(String)}
   */
  @Test
  void testNewPlainText2() {
    // Arrange, Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText("")).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("", paragraphs.get(0).getText());
  }

  /**
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  void testNewPlainText3() {
    // Arrange, Act and Assert
    assertTrue((new PlainText(new ArrayList<>())).getParagraphs().isEmpty());
  }

  /**
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  void testNewPlainText4() {
    // Arrange
    ArrayList<String> listValue = new ArrayList<>();
    listValue.add("foo");

    // Act and Assert
    List<PlainText.Paragraph> paragraphs = (new PlainText(listValue)).getParagraphs();
    assertEquals(1, paragraphs.size());
    assertEquals("foo", paragraphs.get(0).getText());
  }

  /**
   * Method under test: {@link PlainText#PlainText(List)}
   */
  @Test
  void testNewPlainText5() {
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
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines() throws IOException {
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
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines2() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph(".notdef");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(5, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals(".", words.get(0).getText());
    PlainText.Line getResult2 = actualLines.get(3);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("de", words2.get(0).getText());
    PlainText.Line getResult3 = actualLines.get(4);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("f", words3.get(0).getText());
    PlainText.Line getResult4 = actualLines.get(1);
    List<PlainText.Word> words4 = getResult4.getWords();
    assertEquals(1, words4.size());
    assertEquals("n", words4.get(0).getText());
    PlainText.Line getResult5 = actualLines.get(2);
    List<PlainText.Word> words5 = getResult5.getWords();
    assertEquals(1, words5.size());
    assertEquals("ot", words5.get(0).getText());
    assertEquals(2.5f, getResult.getWidth());
    assertEquals(3.3300781f, getResult3.getWidth());
    assertEquals(5.0f, getResult4.getWidth());
    assertEquals(7.7783203f, getResult5.getWidth());
    assertEquals(9.438477f, getResult2.getWidth());
  }

  /**
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines3() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph(".notdef");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 2.5f, 10.0f);

    // Assert
    assertEquals(1, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(2, words.size());
    assertEquals(".", words.get(0).getText());
    assertEquals("notdef", words.get(1).getText());
    assertEquals(7.0117188f, getResult.getWidth());
  }

  /**
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines4() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("maxp");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDType1CFont(new COSDictionary()), 10.0f, 10.0f);

    // Assert
    assertEquals(1, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("maxp", words.get(0).getText());
    assertEquals(0.0f, getResult.getWidth());
  }

  /**
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines5() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("No embedded CFF font, returning 0");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDType1CFont(new COSDictionary()), 10.0f, 0.0f);

    // Assert
    assertEquals(6, actualLines.size());
    PlainText.Line getResult = actualLines.get(5);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(1, words.size());
    assertEquals("0", words.get(0).getText());
    PlainText.Line getResult2 = actualLines.get(2);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(1, words2.size());
    assertEquals("CFF ", words2.get(0).getText());
    PlainText.Line getResult3 = actualLines.get(0);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("No ", words3.get(0).getText());
    PlainText.Line getResult4 = actualLines.get(1);
    List<PlainText.Word> words4 = getResult4.getWords();
    assertEquals(1, words4.size());
    assertEquals("embedded ", words4.get(0).getText());
    PlainText.Line getResult5 = actualLines.get(3);
    List<PlainText.Word> words5 = getResult5.getWords();
    assertEquals(1, words5.size());
    assertEquals("font, ", words5.get(0).getText());
    PlainText.Line getResult6 = actualLines.get(4);
    List<PlainText.Word> words6 = getResult6.getWords();
    assertEquals(1, words6.size());
    assertEquals("returning ", words6.get(0).getText());
    assertEquals(0.0f, getResult3.getWidth());
    assertEquals(0.0f, getResult4.getWidth());
    assertEquals(0.0f, getResult2.getWidth());
    assertEquals(0.0f, getResult5.getWidth());
    assertEquals(0.0f, getResult6.getWidth());
    assertEquals(0.0f, getResult.getWidth());
  }

  /**
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines6() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("No embedded CFF font, returning 0");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), -0.5f, -0.5f);

    // Assert
    assertEquals(1, actualLines.size());
    PlainText.Line getResult = actualLines.get(0);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(6, words.size());
    assertEquals("0", words.get(5).getText());
    assertEquals("No ", words.get(0).getText());
    assertEquals("embedded ", words.get(1).getText());
    assertEquals("returning ", words.get(4).getText());
    assertEquals(-7.1936035f, getResult.getWidth());
  }

  /**
   * Method under test: {@link PlainText.Paragraph#getLines(PDFont, float, float)}
   */
  @Test
  void testParagraphGetLines7() throws IOException {
    // Arrange
    PlainText.Paragraph paragraph = new PlainText.Paragraph("No embedded CFF font, returning 0");

    // Act
    List<PlainText.Line> actualLines = paragraph.getLines(new PDMMType1Font(new COSDictionary()), 10.0f, 14.72168f);

    // Assert
    assertEquals(12, actualLines.size());
    PlainText.Line getResult = actualLines.get(10);
    List<PlainText.Word> words = getResult.getWords();
    assertEquals(2, words.size());
    assertEquals(" ", words.get(1).getText());
    PlainText.Line getResult2 = actualLines.get(3);
    List<PlainText.Word> words2 = getResult2.getWords();
    assertEquals(2, words2.size());
    assertEquals(" ", words2.get(1).getText());
    PlainText.Line getResult3 = actualLines.get(11);
    List<PlainText.Word> words3 = getResult3.getWords();
    assertEquals(1, words3.size());
    assertEquals("0", words3.get(0).getText());
    PlainText.Line getResult4 = actualLines.get(4);
    List<PlainText.Word> words4 = getResult4.getWords();
    assertEquals(1, words4.size());
    assertEquals("CF", words4.get(0).getText());
    PlainText.Line getResult5 = actualLines.get(5);
    List<PlainText.Word> words5 = getResult5.getWords();
    assertEquals(1, words5.size());
    assertEquals("F ", words5.get(0).getText());
    PlainText.Line getResult6 = actualLines.get(0);
    List<PlainText.Word> words6 = getResult6.getWords();
    assertEquals(1, words6.size());
    assertEquals("No ", words6.get(0).getText());
    PlainText.Line getResult7 = actualLines.get(2);
    List<PlainText.Word> words7 = getResult7.getWords();
    assertEquals(1, words7.size());
    assertEquals("bed", words7.get(0).getText());
    assertEquals("ded", words2.get(0).getText());
    PlainText.Line getResult8 = actualLines.get(1);
    List<PlainText.Word> words8 = getResult8.getWords();
    assertEquals(1, words8.size());
    assertEquals("em", words8.get(0).getText());
    PlainText.Line getResult9 = actualLines.get(6);
    List<PlainText.Word> words9 = getResult9.getWords();
    assertEquals(1, words9.size());
    assertEquals("fon", words9.get(0).getText());
    assertEquals("ing", words.get(0).getText());
    PlainText.Line getResult10 = actualLines.get(8);
    List<PlainText.Word> words10 = getResult10.getWords();
    assertEquals(1, words10.size());
    assertEquals("ret", words10.get(0).getText());
    PlainText.Line getResult11 = actualLines.get(7);
    List<PlainText.Word> words11 = getResult11.getWords();
    assertEquals(1, words11.size());
    assertEquals("t, ", words11.get(0).getText());
    PlainText.Line getResult12 = actualLines.get(9);
    List<PlainText.Word> words12 = getResult12.getWords();
    assertEquals(1, words12.size());
    assertEquals("urn", words12.get(0).getText());
    assertEquals(10.546875f, getResult10.getWidth());
    assertEquals(12.216797f, getResult8.getWidth());
    assertEquals(12.22168f, getResult6.getWidth());
    assertEquals(12.231445f, getResult4.getWidth());
    assertEquals(12.77832f, getResult.getWidth());
    assertEquals(13.330078f, getResult9.getWidth());
    assertEquals(13.330078f, getResult12.getWidth());
    assertEquals(14.438477f, getResult7.getWidth());
    assertEquals(14.438477f, getResult2.getWidth());
    assertEquals(5.0f, getResult3.getWidth());
    assertEquals(5.2783203f, getResult11.getWidth());
    assertEquals(5.5615234f, getResult5.getWidth());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlainText.Paragraph#Paragraph(String)}
   *   <li>{@link PlainText.Paragraph#getText()}
   * </ul>
   */
  @Test
  void testParagraphGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Text", (new PlainText.Paragraph("Text")).getText());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlainText.Word#Word(String)}
   *   <li>{@link PlainText.Word#setAttributes(AttributedString)}
   *   <li>{@link PlainText.Word#getAttributes()}
   *   <li>{@link PlainText.Word#getText()}
   * </ul>
   */
  @Test
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
