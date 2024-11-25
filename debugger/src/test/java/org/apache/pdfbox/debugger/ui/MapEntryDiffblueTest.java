package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapEntryDiffblueTest {
  /**
   * Test {@link MapEntry#toString()}.
   * <p>
   * Method under test: {@link MapEntry#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("(null)", (new MapEntry()).toString());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MapEntry}
   *   <li>{@link MapEntry#setItem(COSBase)}
   *   <li>{@link MapEntry#setKey(COSName)}
   *   <li>{@link MapEntry#setValue(COSBase)}
   *   <li>{@link MapEntry#getItem()}
   *   <li>{@link MapEntry#getKey()}
   *   <li>{@link MapEntry#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    MapEntry actualMapEntry = new MapEntry();
    COSArray val = new COSArray();
    actualMapEntry.setItem(val);
    actualMapEntry.setKey(null);
    COSArray val2 = new COSArray();
    actualMapEntry.setValue(val2);
    COSBase actualItem = actualMapEntry.getItem();
    actualMapEntry.getKey();

    // Assert that nothing has changed
    assertTrue(actualItem instanceof COSArray);
    assertSame(val, actualItem);
    assertSame(val2, actualMapEntry.getValue());
  }
}
