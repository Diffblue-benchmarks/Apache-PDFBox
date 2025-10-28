package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class MapEntryDiffblueTest {
  /**
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

  /**
   * Method under test: {@link MapEntry#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("(null)", (new MapEntry()).toString());
  }

  /**
   * Method under test: {@link MapEntry#toString()}
   */
  @Test
  void testToString2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument val = new COSDocument(streamCacheCreateFunction);

    MapEntry mapEntry = new MapEntry();
    mapEntry.setValue(val);

    // Act
    String actualToStringResult = mapEntry.toString();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("(null)", actualToStringResult);
  }
}
