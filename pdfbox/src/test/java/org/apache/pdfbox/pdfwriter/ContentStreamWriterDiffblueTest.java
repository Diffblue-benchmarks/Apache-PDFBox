package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContentStreamWriterDiffblueTest {
  /**
   * Test {@link ContentStreamWriter#writeToken(COSBase)} with {@code base}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeToken(COSBase)}
   */
  @Test
  @DisplayName("Test writeToken(COSBase) with 'base'; when 'null'; then throw IOException")
  void testWriteTokenWithBase_whenNull_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ContentStreamWriter(new ByteArrayOutputStream(1))).writeToken((COSBase) null));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given '42'; when ArrayList() add '42'; then throw IOException")
  void testWriteTokensWithList_given42_whenArrayListAdd42_thenThrowIOException() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given '42'; when ArrayList() add '42'; then throw IOException")
  void testWriteTokensWithList_given42_whenArrayListAdd42_thenThrowIOException2() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add("42");
    tokens.add("42");

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given 'A'")
  void testWriteTokensWithList_givenA() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSObject(COSBoolean.FALSE, new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1})))));

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link COSDocument#COSDocument()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given COSDocument(); when ArrayList() add COSDocument()")
  void testWriteTokensWithList_givenCOSDocument_whenArrayListAddCOSDocument() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSDocument());

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(List)} with {@code List}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(List)}
   */
  @Test
  @DisplayName("Test writeTokens(List) with 'List'; given COSObjectKey(long, int) with num is one and gen is one")
  void testWriteTokensWithList_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    ArrayList<Object> tokens = new ArrayList<>();
    tokens.add(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(tokens));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; when 'A'; then throw IOException")
  void testWriteTokensWithObject_whenA_thenThrowIOException() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(new COSObject(COSBoolean.FALSE, new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}))))));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; when COSDocument(); then throw IOException")
  void testWriteTokensWithObject_whenCOSDocument_thenThrowIOException() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IOException.class, () -> contentStreamWriter.writeTokens(new COSDocument()));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; when COSObjectKey(long, int) with num is one and gen is one")
  void testWriteTokensWithObject_whenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    ContentStreamWriter contentStreamWriter = new ContentStreamWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IOException.class,
        () -> contentStreamWriter.writeTokens(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link ContentStreamWriter#writeTokens(Object[])} with {@code Object[]}.
   * <ul>
   *   <li>When {@code Tokens}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContentStreamWriter#writeTokens(Object[])}
   */
  @Test
  @DisplayName("Test writeTokens(Object[]) with 'Object[]'; when 'Tokens'; then throw IOException")
  void testWriteTokensWithObject_whenTokens_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ContentStreamWriter(new ByteArrayOutputStream(1))).writeTokens("Tokens"));
  }
}
