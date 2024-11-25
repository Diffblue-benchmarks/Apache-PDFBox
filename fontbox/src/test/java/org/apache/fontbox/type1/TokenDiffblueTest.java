package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokenDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return Text is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Token#Token(byte[], Token.Kind)}
   *   <li>{@link Token#getData()}
   *   <li>{@link Token#getKind()}
   *   <li>{@link Token#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'AXAXAXAX' Bytes is 'UTF-8'; then return Text is 'null'")
  void testGettersAndSetters_whenAxaxaxaxBytesIsUtf8_thenReturnTextIsNull() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    Token actualToken = new Token(data, Token.Kind.NONE);
    byte[] actualData = actualToken.getData();
    Token.Kind actualKind = actualToken.getKind();

    // Assert
    assertNull(actualToken.getText());
    assertEquals(Token.Kind.NONE, actualKind);
    assertSame(data, actualData);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Text}.</li>
   *   <li>Then return {@code Text}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Token#Token(String, Token.Kind)}
   *   <li>{@link Token#getData()}
   *   <li>{@link Token#getKind()}
   *   <li>{@link Token#getText()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Text'; then return 'Text'")
  void testGettersAndSetters_whenText_thenReturnText() {
    // Arrange and Act
    Token actualToken = new Token("Text", Token.Kind.NONE);
    byte[] actualData = actualToken.getData();
    Token.Kind actualKind = actualToken.getKind();

    // Assert
    assertEquals("Text", actualToken.getText());
    assertNull(actualData);
    assertEquals(Token.Kind.NONE, actualKind);
  }

  /**
   * Test {@link Token#Token(char, Kind)}.
   * <p>
   * Method under test: {@link Token#Token(char, Token.Kind)}
   */
  @Test
  @DisplayName("Test new Token(char, Kind)")
  void testNewToken() {
    // Arrange and Act
    Token actualToken = new Token('A', Token.Kind.NONE);

    // Assert
    assertEquals("A", actualToken.getText());
    assertNull(actualToken.getData());
    assertEquals(Token.Kind.NONE, actualToken.getKind());
  }

  /**
   * Test {@link Token#intValue()}.
   * <ul>
   *   <li>Given {@link Token#Token(char, Kind)} with character is {@code 1} and
   * type is {@code NONE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Token#intValue()}
   */
  @Test
  @DisplayName("Test intValue(); given Token(char, Kind) with character is '1' and type is 'NONE'; then return one")
  void testIntValue_givenTokenWithCharacterIs1AndTypeIsNone_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new Token('1', Token.Kind.NONE)).intValue());
  }

  /**
   * Test {@link Token#floatValue()}.
   * <ul>
   *   <li>Given {@link Token#Token(char, Kind)} with character is {@code 1} and
   * type is {@code NONE}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Token#floatValue()}
   */
  @Test
  @DisplayName("Test floatValue(); given Token(char, Kind) with character is '1' and type is 'NONE'; then return one")
  void testFloatValue_givenTokenWithCharacterIs1AndTypeIsNone_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Token('1', Token.Kind.NONE)).floatValue());
  }

  /**
   * Test {@link Token#booleanValue()}.
   * <ul>
   *   <li>Given {@link Token#Token(char, Kind)} with character is {@code A} and
   * type is {@code NONE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Token#booleanValue()}
   */
  @Test
  @DisplayName("Test booleanValue(); given Token(char, Kind) with character is 'A' and type is 'NONE'; then return 'false'")
  void testBooleanValue_givenTokenWithCharacterIsAAndTypeIsNone_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new Token('A', Token.Kind.NONE)).booleanValue());
  }

  /**
   * Test {@link Token#booleanValue()}.
   * <ul>
   *   <li>Given {@link Token#Token(String, Kind)} with text is {@link Boolean#TRUE}
   * toString and type is {@code NONE}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Token#booleanValue()}
   */
  @Test
  @DisplayName("Test booleanValue(); given Token(String, Kind) with text is TRUE toString and type is 'NONE'; then return 'true'")
  void testBooleanValue_givenTokenWithTextIsTrueToStringAndTypeIsNone_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new Token(Boolean.TRUE.toString(), Token.Kind.NONE)).booleanValue());
  }

  /**
   * Test {@link Token#toString()}.
   * <ul>
   *   <li>Then return {@code Token[kind=NONE, text=A]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Token#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Token[kind=NONE, text=A]'")
  void testToString_thenReturnTokenKindNoneTextA() {
    // Arrange, Act and Assert
    assertEquals("Token[kind=NONE, text=A]", (new Token('A', Token.Kind.NONE)).toString());
  }
}
