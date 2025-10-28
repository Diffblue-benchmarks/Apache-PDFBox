package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.Test;

class FieldFlagDiffblueTest {
  /**
   * Method under test: {@link FieldFlag#getFlagType()}
   */
  @Test
  void testGetFlagType() {
    // Arrange, Act and Assert
    assertEquals("Field flag", (new FieldFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Method under test: {@link FieldFlag#getFlagValue()}
   */
  @Test
  void testGetFlagValue() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new FieldFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Method under test: {@link FieldFlag#getFlagBits()}
   */
  @Test
  void testGetFlagBits() {
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
   * Method under test: {@link FieldFlag#FieldFlag(COSDictionary)}
   */
  @Test
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
}
