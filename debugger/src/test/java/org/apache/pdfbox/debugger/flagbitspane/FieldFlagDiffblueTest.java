package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FieldFlagDiffblueTest {
  /**
   * Test {@link FieldFlag#FieldFlag(COSDictionary)}.
   * <p>
   * Method under test: {@link FieldFlag#FieldFlag(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FieldFlag(COSDictionary)")
  void testNewFieldFlag() {
    // Arrange and Act
    FieldFlag actualFieldFlag = new FieldFlag(new COSDictionary());

    // Assert
    assertEquals("Field flag", actualFieldFlag.getFlagType());
    assertEquals("Flag value: -1", actualFieldFlag.getFlagValue());
    Object[][] flagBits = actualFieldFlag.getFlagBits();
    Object[] objectArray = flagBits[2];
    assertEquals("NoExport", objectArray[1]);
    Object[] objectArray2 = flagBits[0];
    assertEquals("ReadOnly", objectArray2[1]);
    Object[] objectArray3 = flagBits[1];
    assertEquals("Required", objectArray3[1]);
    assertEquals(3, flagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
    assertArrayEquals(new String[]{"Bit Position", "Name", "Set"}, actualFieldFlag.getColumnNames());
  }

  /**
   * Test {@link FieldFlag#getFlagType()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code Field flag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagType()}
   */
  @Test
  @DisplayName("Test getFlagType(); given FieldFlag(COSDictionary) with dictionary is COSDictionary(); then return 'Field flag'")
  void testGetFlagType_givenFieldFlagWithDictionaryIsCOSDictionary_thenReturnFieldFlag() {
    // Arrange, Act and Assert
    assertEquals("Field flag", (new FieldFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link FieldFlag#getFlagType()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code Field flag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagType()}
   */
  @Test
  @DisplayName("Test getFlagType(); given FieldFlag(COSDictionary) with dictionary is COSStream(); then return 'Field flag'")
  void testGetFlagType_givenFieldFlagWithDictionaryIsCOSStream_thenReturnFieldFlag() {
    // Arrange, Act and Assert
    assertEquals("Field flag", (new FieldFlag(new COSStream())).getFlagType());
  }

  /**
   * Test {@link FieldFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given FieldFlag(COSDictionary) with dictionary is COSDictionary()")
  void testGetFlagValue_givenFieldFlagWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new FieldFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link FieldFlag#getFlagValue()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code Flag value: -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); given FieldFlag(COSDictionary) with dictionary is COSStream(); then return 'Flag value: -1'")
  void testGetFlagValue_givenFieldFlagWithDictionaryIsCOSStream_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new FieldFlag(new COSStream())).getFlagValue());
  }

  /**
   * Test {@link FieldFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given FieldFlag(COSDictionary) with dictionary is COSDictionary()")
  void testGetFlagBits_givenFieldFlagWithDictionaryIsCOSDictionary() {
    // Arrange and Act
    Object[][] actualFlagBits = (new FieldFlag(new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[2];
    assertEquals("NoExport", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("ReadOnly", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[1];
    assertEquals("Required", objectArray3[1]);
    assertEquals(3, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
  }

  /**
   * Test {@link FieldFlag#getFlagBits()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); given FieldFlag(COSDictionary) with dictionary is COSStream()")
  void testGetFlagBits_givenFieldFlagWithDictionaryIsCOSStream() {
    // Arrange and Act
    Object[][] actualFlagBits = (new FieldFlag(new COSStream())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[2];
    assertEquals("NoExport", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("ReadOnly", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[1];
    assertEquals("Required", objectArray3[1]);
    assertEquals(3, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
  }
}
