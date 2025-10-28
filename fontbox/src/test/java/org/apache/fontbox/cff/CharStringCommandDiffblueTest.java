package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CharStringCommandDiffblueTest {
  /**
   * Method under test: {@link CharStringCommand#getInstance(int)}
   */
  @Test
  void testGetInstance() {
    // Arrange, Act and Assert
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(1));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(0));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(-1));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(230));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(1, 1));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(17, 1));
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(0, 1));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(-1, 1));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{42, 1, 42, 1}));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{0}));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{-1}));
    assertEquals(CharStringCommand.HSTEM, CharStringCommand.getInstance(new int[]{1}));
    assertEquals(CharStringCommand.UNKNOWN, CharStringCommand.getInstance(new int[]{230}));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CharStringCommand#getType1KeyWord()}
   *   <li>{@link CharStringCommand#getType2KeyWord()}
   *   <li>{@link CharStringCommand#getValue()}
   *   <li>{@link CharStringCommand#toString()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CharStringCommand valueOfResult = CharStringCommand.valueOf("HSTEM");

    // Act
    CharStringCommand.Type1KeyWord actualType1KeyWord = valueOfResult.getType1KeyWord();
    CharStringCommand.Type2KeyWord actualType2KeyWord = valueOfResult.getType2KeyWord();
    int actualValue = valueOfResult.getValue();

    // Assert
    assertEquals("HSTEM|", valueOfResult.toString());
    assertEquals(1, actualValue);
    assertEquals(CharStringCommand.Type1KeyWord.HSTEM, actualType1KeyWord);
    assertEquals(CharStringCommand.Type2KeyWord.HSTEM, actualType2KeyWord);
  }
}
