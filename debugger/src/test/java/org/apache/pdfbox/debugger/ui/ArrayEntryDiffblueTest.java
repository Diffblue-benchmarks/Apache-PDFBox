package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.Test;

class ArrayEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ArrayEntry}
   *   <li>{@link ArrayEntry#setIndex(int)}
   *   <li>{@link ArrayEntry#setItem(COSBase)}
   *   <li>{@link ArrayEntry#setValue(COSBase)}
   *   <li>{@link ArrayEntry#getIndex()}
   *   <li>{@link ArrayEntry#getItem()}
   *   <li>{@link ArrayEntry#getValue()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ArrayEntry actualArrayEntry = new ArrayEntry();
    actualArrayEntry.setIndex(1);
    COSArray val = new COSArray();
    actualArrayEntry.setItem(val);
    COSArray val2 = new COSArray();
    actualArrayEntry.setValue(val2);
    int actualIndex = actualArrayEntry.getIndex();
    COSBase actualItem = actualArrayEntry.getItem();

    // Assert that nothing has changed
    assertTrue(actualItem instanceof COSArray);
    assertEquals(1, actualIndex);
    assertSame(val, actualItem);
    assertSame(val2, actualArrayEntry.getValue());
  }
}
