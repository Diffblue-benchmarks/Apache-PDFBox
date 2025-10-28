package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class FontFlagDiffblueTest {
  /**
   * Method under test: {@link FontFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new FontFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Method under test: {@link FontFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits() {
    // Arrange and Act
    Object[][] actualFlagBits = (new FontFlag(new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[6];
    assertEquals("AllCap", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("FixedPitch", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[8];
    assertEquals("ForceBold", objectArray3[1]);
    Object[] objectArray4 = actualFlagBits[5];
    assertEquals("Italic", objectArray4[1]);
    Object[] objectArray5 = actualFlagBits[4];
    assertEquals("NonSymbolic", objectArray5[1]);
    Object[] objectArray6 = actualFlagBits[3];
    assertEquals("Script", objectArray6[1]);
    Object[] objectArray7 = actualFlagBits[1];
    assertEquals("Serif", objectArray7[1]);
    Object[] objectArray8 = actualFlagBits[7];
    assertEquals("SmallCap", objectArray8[1]);
    Object[] objectArray9 = actualFlagBits[2];
    assertEquals("Symbolic", objectArray9[1]);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray7.length);
    assertEquals(3, objectArray9.length);
    assertEquals(3, objectArray6.length);
    assertEquals(3, objectArray5.length);
    assertEquals(3, objectArray4.length);
    assertEquals(3, objectArray.length);
    assertEquals(3, objectArray8.length);
    assertEquals(3, objectArray3.length);
    assertEquals(9, actualFlagBits.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FontFlag#FontFlag(COSDictionary)}
   *   <li>{@link FontFlag#getFlagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font flag", (new FontFlag(new COSDictionary())).getFlagType());
  }
}
