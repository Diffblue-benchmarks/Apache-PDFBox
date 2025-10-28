package org.apache.fontbox.type1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class Type1LexerDiffblueTest {
  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("AXAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("AXAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("AXAXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("AXAXAXAX", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken2() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\nAXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertEquals("AXAXAX", type1Lexer.peekToken().getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken3() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("AXAXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("AXAXAXA", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken4() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A%AXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken5() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n(XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken6() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new Type1Lexer("A\n)XAXAX".getBytes("UTF-8"))).nextToken());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken7() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer(new byte[]{'A', '\n', 0, 'X', 'A', 'X', 'A', 'X'});

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertEquals("XAXAX", type1Lexer.peekToken().getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken8() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n[XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("[", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Token.Kind.START_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken9() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n{XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("{", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Token.Kind.START_PROC, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken10() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n]XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("]", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.END_ARRAY, peekTokenResult.getKind());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken11() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n#XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("#XAXAX", type1Lexer.peekToken().getText());
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken12() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA%AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken13() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA\nAXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken14() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA(AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken15() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA)AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken16() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA[AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken17() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA{AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken18() throws IOException {
    // Arrange and Act
    Token actualNextTokenResult = (new Type1Lexer("A\nA]AXAX".getBytes("UTF-8"))).nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken19() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A%AXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken20() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A(AXAXA\n".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken21() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A%\rXAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertEquals("XAXAX", type1Lexer.peekToken().getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken22() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n}XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("}", peekTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.END_PROC, peekTokenResult.getKind());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken23() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A((XAXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertNull(type1Lexer.peekToken());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#nextToken()}
   */
  @Test
  void testNextToken24() throws IOException {
    // Arrange
    Type1Lexer type1Lexer = new Type1Lexer("A\n()AXAX".getBytes("UTF-8"));

    // Act
    Token actualNextTokenResult = type1Lexer.nextToken();

    // Assert
    Token peekTokenResult = type1Lexer.peekToken();
    assertEquals("", peekTokenResult.getText());
    assertEquals("A", actualNextTokenResult.getText());
    assertNull(actualNextTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualNextTokenResult.getKind());
    assertEquals(Token.Kind.STRING, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#peekToken()}
   */
  @Test
  void testPeekToken() throws IOException {
    // Arrange and Act
    Token actualPeekTokenResult = (new Type1Lexer("AXAXAXAX".getBytes("UTF-8"))).peekToken();

    // Assert
    assertEquals("AXAXAXAX", actualPeekTokenResult.getText());
    assertNull(actualPeekTokenResult.getData());
    assertEquals(Token.Kind.NAME, actualPeekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#peekKind(Token.Kind)}
   */
  @Test
  void testPeekKind() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new Type1Lexer("AXAXAXAX".getBytes("UTF-8"))).peekKind(Token.Kind.NONE));
    assertFalse((new Type1Lexer(new byte[]{})).peekKind(Token.Kind.NONE));
    assertTrue((new Type1Lexer("AXAXAXAX".getBytes("UTF-8"))).peekKind(Token.Kind.NAME));
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer2() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer("%XAXAXAX".getBytes("UTF-8"))).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer3() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer("(XAXAXAX".getBytes("UTF-8"))).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer4() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new Type1Lexer(")XAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer5() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})).peekToken();
    assertEquals("XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer6() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("[XAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("[", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.START_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer7() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("\nXAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer8() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("{XAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("{", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.START_PROC, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer9() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("]XAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("]", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.END_ARRAY, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer10() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("#XAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("#XAXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer11() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A%AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer12() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A(AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer13() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A)AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer14() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A[AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer15() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A\nAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer16() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A{AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer17() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("A]AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("A", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer18() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("}XAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("}", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.END_PROC, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer19() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("%\rAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("AXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer20() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("%\nAXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("AXAXAX", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer21() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer("((AXAXAX".getBytes("UTF-8"))).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer22() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer("(\nAXAXAX".getBytes("UTF-8"))).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer23() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer("()AXAXAX".getBytes("UTF-8"))).peekToken();
    assertEquals("", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.STRING, peekTokenResult.getKind());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer24() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer("(\\AXAXAX".getBytes("UTF-8"))).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer25() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new Type1Lexer("(XAXAXA\\".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer26() throws IOException {
    // Arrange, Act and Assert
    assertNull((new Type1Lexer(new byte[]{0, '%', 'A', 'X', 'A', 'X', 'A', 'X'})).peekToken());
  }

  /**
   * Method under test: {@link Type1Lexer#Type1Lexer(byte[])}
   */
  @Test
  void testNewType1Lexer27() throws IOException {
    // Arrange, Act and Assert
    Token peekTokenResult = (new Type1Lexer(new byte[]{0, 'X', '}', 'X', 'A', 'X', 'A', 'X'})).peekToken();
    assertEquals("X", peekTokenResult.getText());
    assertNull(peekTokenResult.getData());
    assertEquals(Token.Kind.NAME, peekTokenResult.getKind());
  }
}
