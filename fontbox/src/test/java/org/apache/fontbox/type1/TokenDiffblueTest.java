package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

class TokenDiffblueTest {
  /**
   * Method under test: {@link Token#intValue()}
   */
  @Test
  void testIntValue() {
    // Arrange, Act and Assert
    assertEquals(1, (new Token('1', Token.Kind.NONE)).intValue());
  }

  /**
   * Method under test: {@link Token#floatValue()}
   */
  @Test
  void testFloatValue() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new Token('1', Token.Kind.NONE)).floatValue());
  }

  /**
   * Method under test: {@link Token#booleanValue()}
   */
  @Test
  void testBooleanValue() {
    // Arrange, Act and Assert
    assertFalse((new Token('A', Token.Kind.NONE)).booleanValue());
    assertTrue((new Token(Boolean.TRUE.toString(), Token.Kind.NONE)).booleanValue());
  }

  /**
   * Method under test: {@link Token#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Token[kind=NONE, text=A]", (new Token('A', Token.Kind.NONE)).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Token#Token(String, Token.Kind)}
   *   <li>{@link Token#getData()}
   *   <li>{@link Token#getKind()}
   *   <li>{@link Token#getText()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link Token#Token(byte[], Token.Kind)}
   *   <li>{@link Token#getData()}
   *   <li>{@link Token#getKind()}
   *   <li>{@link Token#getText()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() throws UnsupportedEncodingException {
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
   * Method under test: {@link Token#Token(char, Token.Kind)}
   */
  @Test
  void testNewToken() {
    // Arrange and Act
    Token actualToken = new Token('A', Token.Kind.NONE);

    // Assert
    assertEquals("A", actualToken.getText());
    assertNull(actualToken.getData());
    assertEquals(Token.Kind.NONE, actualToken.getKind());
  }
}
