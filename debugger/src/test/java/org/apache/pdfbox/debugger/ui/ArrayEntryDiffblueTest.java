package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ArrayEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ArrayEntry.<init>()",
    "int ArrayEntry.getIndex()",
    "COSBase ArrayEntry.getItem()",
    "COSBase ArrayEntry.getValue()",
    "void ArrayEntry.setIndex(int)",
    "void ArrayEntry.setItem(COSBase)",
    "void ArrayEntry.setValue(COSBase)"
  })
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

    // Assert
    assertTrue(actualItem instanceof COSArray);
    assertEquals(1, actualIndex);
    assertSame(val, actualItem);
    assertSame(val2, actualArrayEntry.getValue());
  }
}
