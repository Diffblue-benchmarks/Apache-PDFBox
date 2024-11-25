package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EncryptFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EncryptFlag#EncryptFlag(COSDictionary)}
   *   <li>{@link EncryptFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Encrypt flag", (new EncryptFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link EncryptFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link EncryptFlag#EncryptFlag(COSDictionary)} with encryptDict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given EncryptFlag(COSDictionary) with encryptDict is COSDictionary()")
  void testGetFlagValue_givenEncryptFlagWithEncryptDictIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new EncryptFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link EncryptFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link EncryptFlag#EncryptFlag(COSDictionary)} with encryptDict is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code Flag value:-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given EncryptFlag(COSDictionary) with encryptDict is COSStream(); then return 'Flag value:-1'")
  void testGetFlagValue_givenEncryptFlagWithEncryptDictIsCOSStream_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new EncryptFlag(new COSStream())).getFlagValue());
  }

  /**
   * Test {@link EncryptFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link EncryptFlag#EncryptFlag(COSDictionary)} with encryptDict is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given EncryptFlag(COSDictionary) with encryptDict is COSDictionary()")
  void testGetFlagBits_givenEncryptFlagWithEncryptDictIsCOSDictionary() {
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
   * Test {@link EncryptFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link EncryptFlag#EncryptFlag(COSDictionary)} with encryptDict is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given EncryptFlag(COSDictionary) with encryptDict is COSStream()")
  void testGetFlagBits_givenEncryptFlagWithEncryptDictIsCOSStream() {
    // Arrange and Act
    Object[][] actualFlagBits = (new EncryptFlag(new COSStream())).getFlagBits();

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
}
