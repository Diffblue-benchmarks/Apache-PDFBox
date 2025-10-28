package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class EncryptFlagDiffblueTest {
  /**
   * Method under test: {@link EncryptFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new EncryptFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Method under test: {@link EncryptFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits() {
    // Arrange and Act
    Object[][] actualFlagBits = (new EncryptFlag(new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[6];
    assertEquals("can assemble document", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[2];
    assertEquals("can extract content", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[5];
    assertEquals("can extract for accessibility", objectArray3[1]);
    Object[] objectArray4 = actualFlagBits[4];
    assertEquals("can fill in form fields", objectArray4[1]);
    Object[] objectArray5 = actualFlagBits[3];
    assertEquals("can modify annotations", objectArray5[1]);
    Object[] objectArray6 = actualFlagBits[1];
    assertEquals("can modify", objectArray6[1]);
    Object[] objectArray7 = actualFlagBits[7];
    assertEquals("can print faithful", objectArray7[1]);
    Object[] objectArray8 = actualFlagBits[0];
    assertEquals("can print", objectArray8[1]);
    assertEquals(3, objectArray8.length);
    assertEquals(3, objectArray6.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray5.length);
    assertEquals(3, objectArray4.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
    assertEquals(3, objectArray7.length);
    assertEquals(8, actualFlagBits.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EncryptFlag#EncryptFlag(COSDictionary)}
   *   <li>{@link EncryptFlag#getFlagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Encrypt flag", (new EncryptFlag(new COSDictionary())).getFlagType());
  }
}
