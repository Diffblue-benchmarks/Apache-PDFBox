package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.fontbox.type1.Token.Kind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type1LexerDiffblueTest {
  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   * <ul>
   *   <li>Then return peekToken Text is {@code {}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName("Test new Type1Lexer(byte[]); then return peekToken Text is '{'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_thenReturnPeekTokenTextIsLeftCurlyBracket() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("{XAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("{", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.START_PROC, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>Then return peekToken Text is {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName("Test new Type1Lexer(byte[]); then return peekToken Text is '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_thenReturnPeekTokenTextIsLeftSquareBracket() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("[XAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("[", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.START_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>Then return peekToken Text is {@code ]}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName("Test new Type1Lexer(byte[]); then return peekToken Text is ']'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_thenReturnPeekTokenTextIsRightSquareBracket() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("]XAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("]", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.END_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code A%AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A%AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A%AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code A(AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A(AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA2() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A(AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code A)AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A)AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA3() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A)AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code A[AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A[AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA4() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A[AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code A AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA5() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A\nAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   * <ul>
   *   <li>When {@code A{AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return peekToken Text is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'A{AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsA6() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("A{AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code %}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName("Test new Type1Lexer(byte[]); when array of byte with zero and '%'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenArrayOfByteWithZeroAndPercentSign() throws IOException {
    // Arrange and Act
    Type1Lexer actualType1Lexer = new Type1Lexer(new byte[] {0, '%', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    assertNull(actualType1Lexer.peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.
   *   <li>Then return peekToken Text is {@code XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when array of byte with zero and 'X'; then return peekToken Text is 'XAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenArrayOfByteWithZeroAndX_thenReturnPeekTokenTextIsXaxaxax()
      throws IOException {
    // Arrange and Act
    Type1Lexer actualType1Lexer = new Type1Lexer(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Token peekTokenResult = actualType1Lexer.peekToken();
    assertEquals("XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code ((AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '((AXAXAX' Bytes is 'UTF-8'; then return peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new Type1Lexer("((AXAXAX".getBytes("UTF-8")).peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code ( AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '( AXAXAX' Bytes is 'UTF-8'; then return peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenIsNull2() throws IOException {
    // Arrange, Act and Assert
    assertNull(new Type1Lexer("(\nAXAXAX".getBytes("UTF-8")).peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code (\AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '(\\AXAXAX' Bytes is 'UTF-8'; then return peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenIsNull3() throws IOException {
    // Arrange, Act and Assert
    assertNull(new Type1Lexer("(\\AXAXAX".getBytes("UTF-8")).peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code % AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '% AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'AXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsAxaxax()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("%\rAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("AXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code % AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '% AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'AXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsAxaxax2()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("%\nAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("AXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code ()AXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is empty string.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '()AXAXAX' Bytes is 'UTF-8'; then return peekToken Text is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsEmptyString()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("()AXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.STRING, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenAxaxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsAxaxaxax()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("AXAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("AXAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code ]}.
   *   <li>Then return peekToken Text is {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName("Test new Type1Lexer(byte[]); when ']'; then return peekToken Text is 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenRightSquareBracket_thenReturnPeekTokenTextIsX() throws IOException {
    // Arrange and Act
    Type1Lexer actualType1Lexer = new Type1Lexer(new byte[] {0, 'X', ']', 'X', 'A', 'X', 'A', 'X'});

    // Assert
    Token peekTokenResult = actualType1Lexer.peekToken();
    assertEquals("X", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXA\} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '(XAXAXA\\' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new Type1Lexer("(XAXAXA\\".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code %XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '%XAXAXAX' Bytes is 'UTF-8'; then return peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaxBytesIsUtf8_thenReturnPeekTokenIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new Type1Lexer("%XAXAXAX".getBytes("UTF-8")).peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code (XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '(XAXAXAX' Bytes is 'UTF-8'; then return peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaxBytesIsUtf8_thenReturnPeekTokenIsNull2() throws IOException {
    // Arrange, Act and Assert
    assertNull(new Type1Lexer("(XAXAXAX".getBytes("UTF-8")).peekToken());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when 'XAXAXAX' Bytes is 'UTF-8'; then return peekToken Text is 'XAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsXaxaxax()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("\nXAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code #XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return peekToken Text is {@code #XAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when '#XAXAXAX' Bytes is 'UTF-8'; then return peekToken Text is '#XAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaxBytesIsUtf8_thenReturnPeekTokenTextIsXaxaxax2()
      throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = new Type1Lexer("#XAXAXAX".getBytes("UTF-8")).peekToken();
    assertEquals("#XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#Type1Lexer(byte[])}.
   *
   * <ul>
   *   <li>When {@code )XAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  @DisplayName(
      "Test new Type1Lexer(byte[]); when ')XAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Type1Lexer.<init>(byte[])"})
  void testNewType1Lexer_whenXaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new Type1Lexer(")XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n[XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("[", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.START_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken2() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n{XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("{", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.START_PROC, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken3() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n]XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("]", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.END_ARRAY, peekTokenResult.getKind());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken4() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n()AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("", peekTokenResult.getText());
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.STRING, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Given {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A )XAXAX} Bytes is
   *       {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); given Type1Lexer(byte[]) with bytes is 'A )XAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_givenType1LexerWithBytesIsAXaxaxBytesIsUtf8_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new Type1Lexer("A\n)XAXAX".getBytes("UTF-8")).nextToken());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then return Text is {@code AXAXAXA}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken(); then return Text is 'AXAXAXA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenReturnTextIsAxaxaxa() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("AXAXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("AXAXAXA", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then return Text is {@code AXAXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName("Test nextToken(); then return Text is 'AXAXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenReturnTextIsAxaxaxax() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("AXAXAXAX", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A%AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A%AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA%AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA2()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA\nAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A(AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A(AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA3()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA(AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A)AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A)AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA4()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA)AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A[AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A[AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA5()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA[AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A{AXAX} Bytes is {@code UTF-8} peekToken Text is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A{AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA6()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA{AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A A]AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A A]AXAX' Bytes is 'UTF-8' peekToken Text is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAAxaxBytesIsUtf8PeekTokenTextIsA7()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nA]AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A % AXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code AXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A % AXAX' Bytes is 'UTF-8' peekToken Text is 'AXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAxaxBytesIsUtf8PeekTokenTextIsAxax()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n%\rAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("AXAX", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A%AXAXA} Bytes is {@code
   *       UTF-8} peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A%AXAXA' Bytes is 'UTF-8' peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAxaxaBytesIsUtf8PeekTokenIsNull()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A%AXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A(AXAXA} Bytes is {@code
   *       UTF-8} peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A(AXAXA' Bytes is 'UTF-8' peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAxaxaBytesIsUtf8PeekTokenIsNull2()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A(AXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A AXAXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code AXAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A AXAXAX' Bytes is 'UTF-8' peekToken Text is 'AXAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAAxaxaxBytesIsUtf8PeekTokenTextIsAxaxax()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nAXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("AXAXAX", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A %XAXAX} Bytes is {@code
   *       UTF-8} peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A %XAXAX' Bytes is 'UTF-8' peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAXaxaxBytesIsUtf8PeekTokenIsNull()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n%XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A (XAXAX} Bytes is {@code
   *       UTF-8} peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A (XAXAX' Bytes is 'UTF-8' peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAXaxaxBytesIsUtf8PeekTokenIsNull2()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n(XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A((XAXAX} Bytes is {@code
   *       UTF-8} peekToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A((XAXAX' Bytes is 'UTF-8' peekToken is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAXaxaxBytesIsUtf8PeekTokenIsNull3()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A((XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code A #XAXAX} Bytes is {@code
   *       UTF-8} peekToken Text is {@code #XAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is 'A #XAXAX' Bytes is 'UTF-8' peekToken Text is '#XAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsAXaxaxBytesIsUtf8PeekTokenTextIsXaxax()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n#XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("#XAXAX", peekTokenResult.getText());
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#nextToken()}.
   *
   * <ul>
   *   <li>Then {@link Type1Lexer#Type1Lexer(byte[])} with bytes is array of {@code byte} with
   *       {@code A} and lf peekToken Text is {@code XAXAX}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  @DisplayName(
      "Test nextToken(); then Type1Lexer(byte[]) with bytes is array of byte with 'A' and lf peekToken Text is 'XAXAX'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.nextToken()"})
  void testNextToken_thenType1LexerWithBytesIsArrayOfByteWithAAndLfPeekTokenTextIsXaxax()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer(new byte[] {'A', '\n', 0, 'X', 'A', 'X', 'A', 'X'});

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("XAXAX", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#peekToken()}.
   *
   * <p>Method under test: {@link Type1Lexer#peekToken()}
   */
  @Test
  @DisplayName("Test peekToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Token Type1Lexer.peekToken()"})
  void testPeekToken() throws IOException {
    // Arrange and Act
    Token actualPeekTokenResult = new Type1Lexer("AXAXAXAX".getBytes("UTF-8")).peekToken();

    // Assert
    assertEquals("AXAXAXAX", actualPeekTokenResult.getText());
    assertNull(actualPeekTokenResult.getData());
    assertEquals(Kind.NAME, actualPeekTokenResult.getKind());
  }

  /**
   * Test {@link Type1Lexer#peekKind(Kind)}.
   *
   * <ul>
   *   <li>Given {@link Type1Lexer#Type1Lexer(byte[])} with bytes is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#peekKind(Kind)}
   */
  @Test
  @DisplayName(
      "Test peekKind(Kind); given Type1Lexer(byte[]) with bytes is 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Type1Lexer.peekKind(Kind)"})
  void testPeekKind_givenType1LexerWithBytesIsAxaxaxaxBytesIsUtf8_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new Type1Lexer("AXAXAXAX".getBytes("UTF-8")).peekKind(Kind.NONE));
  }

  /**
   * Test {@link Type1Lexer#peekKind(Kind)}.
   *
   * <ul>
   *   <li>Given {@link Type1Lexer#Type1Lexer(byte[])} with bytes is empty array of {@code byte}.
   *   <li>When {@code NONE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#peekKind(Kind)}
   */
  @Test
  @DisplayName(
      "Test peekKind(Kind); given Type1Lexer(byte[]) with bytes is empty array of byte; when 'NONE'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Type1Lexer.peekKind(Kind)"})
  void testPeekKind_givenType1LexerWithBytesIsEmptyArrayOfByte_whenNone_thenReturnFalse()
      throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer(new byte[] {});

    // Act and Assert
    assertFalse(type1Lexer.peekKind(Kind.NONE));
  }

  /**
   * Test {@link Type1Lexer#peekKind(Kind)}.
   *
   * <ul>
   *   <li>When {@code NAME}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Type1Lexer#peekKind(Kind)}
   */
  @Test
  @DisplayName("Test peekKind(Kind); when 'NAME'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Type1Lexer.peekKind(Kind)"})
  void testPeekKind_whenName_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new Type1Lexer("AXAXAXAX".getBytes("UTF-8")).peekKind(Kind.NAME));
  }
}
