package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnnotFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AnnotFlag#AnnotFlag(COSDictionary)}
   *   <li>{@link AnnotFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Annot flag", (new AnnotFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link AnnotFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link AnnotFlag#AnnotFlag(COSDictionary)} with annotDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given AnnotFlag(COSDictionary) with annotDictionary is COSDictionary()")
  void testGetFlagValue_givenAnnotFlagWithAnnotDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new AnnotFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link AnnotFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link AnnotFlag#AnnotFlag(COSDictionary)} with annotDictionary is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given AnnotFlag(COSDictionary) with annotDictionary is COSStream()")
  void testGetFlagValue_givenAnnotFlagWithAnnotDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new AnnotFlag(new COSStream())).getFlagValue());
  }

  /**
   * Test {@link AnnotFlag#getFlagBits()}.
   * <ul>
   *   <li>Then return second element is {@code Hidden}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return second element is 'Hidden'")
  void testGetFlagBits_thenReturnSecondElementIsHidden() {
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
}
