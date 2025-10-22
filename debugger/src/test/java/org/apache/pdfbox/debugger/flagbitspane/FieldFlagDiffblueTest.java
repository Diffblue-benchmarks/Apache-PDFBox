package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldFlagDiffblueTest {
  /**
   * Test {@link FieldFlag#FieldFlag(COSDictionary)}.
   * <p>
   * Method under test: {@link FieldFlag#FieldFlag(COSDictionary)}
   */
  @Test
  @DisplayName("Test new FieldFlag(COSDictionary)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FieldFlag.<init>(COSDictionary)"})
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
    assertEquals(1, ((Integer) objectArray2[0]).intValue());
    assertEquals(2, ((Integer) objectArray3[0]).intValue());
    assertEquals(3, ((Integer) objectArray[0]).intValue());
    assertEquals(3, flagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
    assertTrue((Boolean) objectArray2[2]);
    assertTrue((Boolean) objectArray3[2]);
    assertTrue((Boolean) objectArray[2]);
    assertArrayEquals(new String[]{"Bit Position", "Name", "Set"}, actualFieldFlag.getColumnNames());
  }

  /**
   * Test {@link FieldFlag#getFlagType()}.
   * <ul>
   *   <li>Given {@link FieldFlag#FieldFlag(COSDictionary)} with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code Field flag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagType()}
   */
  @Test
  @DisplayName("Test getFlagType(); given FieldFlag(COSDictionary) with dictionary is COSDictionary(); then return 'Field flag'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FieldFlag.getFlagType()"})
  void testGetFlagType_givenFieldFlagWithDictionaryIsCOSDictionary_thenReturnFieldFlag() {
    // Arrange, Act and Assert
    assertEquals("Field flag", (new FieldFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link FieldFlag#getFlagValue()}.
   * <ul>
   *   <li>Then return {@code Flag value: -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); then return 'Flag value: -1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String FieldFlag.getFlagValue()"})
  void testGetFlagValue_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new FieldFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link FieldFlag#getFlagBits()}.
   * <ul>
   *   <li>Then return second element is {@code NoExport}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return second element is 'NoExport'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[][] FieldFlag.getFlagBits()"})
  void testGetFlagBits_thenReturnSecondElementIsNoExport() {
    // Arrange and Act
    Object[][] actualFlagBits = (new FieldFlag(new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[2];
    assertEquals("NoExport", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("ReadOnly", objectArray2[1]);
    Object[] objectArray3 = actualFlagBits[1];
    assertEquals("Required", objectArray3[1]);
    assertEquals(1, ((Integer) objectArray2[0]).intValue());
    assertEquals(2, ((Integer) objectArray3[0]).intValue());
    assertEquals(3, ((Integer) objectArray[0]).intValue());
    assertEquals(3, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray3.length);
    assertEquals(3, objectArray.length);
    assertTrue((Boolean) objectArray2[2]);
    assertTrue((Boolean) objectArray3[2]);
    assertTrue((Boolean) objectArray[2]);
  }
}
