package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class AnnotFlagDiffblueTest {
  /**
   * Method under test: {@link AnnotFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new AnnotFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Method under test: {@link AnnotFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits() {
    // Arrange and Act
    Object[][] actualFlagBits = (new AnnotFlag(new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[1];
    assertEquals("Hidden", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("Invisible", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[7];
    assertEquals("Locked", objectArray3[1]);
    Object[] objectArray4 = actualFlagBits[9];
    assertEquals("LockedContents", objectArray4[1]);
    Object[] objectArray5 = actualFlagBits[4];
    assertEquals("NoRotate", objectArray5[1]);
    Object[] objectArray6 = actualFlagBits[5];
    assertEquals("NoView", objectArray6[1]);
    Object[] objectArray7 = actualFlagBits[3];
    assertEquals("NoZoom", objectArray7[1]);
    Object[] objectArray8 = actualFlagBits[2];
    assertEquals("Print", objectArray8[1]);
    Object[] objectArray9 = actualFlagBits[6];
    assertEquals("ReadOnly", objectArray9[1]);
    Object[] objectArray10 = actualFlagBits[8];
    assertEquals("ToggleNoView", objectArray10[1]);
    assertEquals(10, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
    assertEquals(3, objectArray8.length);
    assertEquals(3, objectArray7.length);
    assertEquals(3, objectArray5.length);
    assertEquals(3, objectArray6.length);
    assertEquals(3, objectArray9.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray10.length);
    assertEquals(3, objectArray4.length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AnnotFlag#AnnotFlag(COSDictionary)}
   *   <li>{@link AnnotFlag#getFlagType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Annot flag", (new AnnotFlag(new COSDictionary())).getFlagType());
  }
}
