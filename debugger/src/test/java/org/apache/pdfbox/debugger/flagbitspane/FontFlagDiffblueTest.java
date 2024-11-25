package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FontFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FontFlag#FontFlag(COSDictionary)}
   *   <li>{@link FontFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font flag", (new FontFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link FontFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link FontFlag#FontFlag(COSDictionary)} with fontDescDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given FontFlag(COSDictionary) with fontDescDictionary is COSDictionary()")
  void testGetFlagValue_givenFontFlagWithFontDescDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new FontFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link FontFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link FontFlag#FontFlag(COSDictionary)} with fontDescDictionary is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given FontFlag(COSDictionary) with fontDescDictionary is COSStream()")
  void testGetFlagValue_givenFontFlagWithFontDescDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new FontFlag(new COSStream())).getFlagValue());
  }

  /**
   * Test {@link FontFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link FontFlag#FontFlag(COSDictionary)} with fontDescDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given FontFlag(COSDictionary) with fontDescDictionary is COSDictionary()")
  void testGetFlagBits_givenFontFlagWithFontDescDictionaryIsCOSDictionary() {
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
   * Test {@link FontFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link FontFlag#FontFlag(COSDictionary)} with fontDescDictionary is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FontFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given FontFlag(COSDictionary) with fontDescDictionary is COSStream()")
  void testGetFlagBits_givenFontFlagWithFontDescDictionaryIsCOSStream() {
    // Arrange and Act
    Object[][] actualFlagBits = (new FontFlag(new COSStream())).getFlagBits();

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
}
