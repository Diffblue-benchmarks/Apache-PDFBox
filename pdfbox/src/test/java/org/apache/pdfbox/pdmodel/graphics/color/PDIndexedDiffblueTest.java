package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDIndexedDiffblueTest {
  /**
   * Test {@link PDIndexed#PDIndexed()}.
   * <p>
   * Method under test: {@link PDIndexed#PDIndexed()}
   */
  @Test
  @DisplayName("Test new PDIndexed()")
  void testNewPDIndexed() {
    // Arrange and Act
    PDIndexed actualPdIndexed = new PDIndexed();

    // Assert
    COSBase cOSObject = actualPdIndexed.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof COSName);
    COSBase getResult3 = toListResult.get(1);
    assertTrue(getResult3 instanceof COSName);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSNull);
    assertEquals("DeviceRGB", ((COSName) getResult3).getName());
    assertEquals("Indexed", ((COSName) getResult2).getName());
    assertEquals("Indexed", actualPdIndexed.getName());
    PDColor initialColor = actualPdIndexed.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult.getKey());
    assertNull(getResult4.getKey());
    assertNull(actualPdIndexed.getBaseColorSpace());
    assertEquals(1, actualPdIndexed.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(getResult4.isDirect());
    assertFalse(((COSName) getResult2).isEmpty());
    assertFalse(((COSName) getResult3).isEmpty());
    assertFalse(initialColor.isPattern());
    assertTrue(((COSInteger) getResult).isValid());
    assertSame(actualPdIndexed, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   * <p>
   * Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName("Test new PDIndexed(COSArray)")
  void testNewPDIndexed2() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosDictionary);
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(cosObject);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(eq(1));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosObject).getObject();
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   * <p>
   * Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName("Test new PDIndexed(COSArray)")
  void testNewPDIndexed3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosDictionary2);
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(cosObject);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(eq(1));
    verify(cosDictionary2).containsKey(isA(COSName.class));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary2).getDictionaryObject(isA(COSName.class));
    verify(cosObject).getObject();
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} throw
   * {@link IllegalArgumentException#IllegalArgumentException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName("Test new PDIndexed(COSArray); given COSObject getObject() throw IllegalArgumentException(String) with 'foo'")
  void testNewPDIndexed_givenCOSObjectGetObjectThrowIllegalArgumentExceptionWithFoo() throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenThrow(new IllegalArgumentException("foo"));
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    COSObject cosObject2 = mock(COSObject.class);
    when(cosObject2.getObject()).thenReturn(cosDictionary);
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(cosObject2);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(eq(1));
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosObject2).getObject();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link PDIndexed#PDIndexed(COSArray)}.
   * <ul>
   *   <li>Then calls {@link COSArray#isEmpty()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDIndexed#PDIndexed(COSArray)}
   */
  @Test
  @DisplayName("Test new PDIndexed(COSArray); then calls isEmpty()")
  void testNewPDIndexed_thenCallsIsEmpty() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty())
        .thenThrow(new IllegalArgumentException("First element in colorspace array must be a name"));
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);
    COSArray indexedArray = mock(COSArray.class);
    when(indexedArray.get(anyInt())).thenReturn(cosObject);
    doNothing().when(indexedArray).add(Mockito.<COSObjectable>any());
    indexedArray.add(mock(COSObjectable.class));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDIndexed(indexedArray));
    verify(indexedArray).add(isA(COSObjectable.class));
    verify(indexedArray).get(eq(1));
    verify(cosArray).isEmpty();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link PDIndexed#getName()}.
   * <p>
   * Method under test: {@link PDIndexed#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Indexed", (new PDIndexed()).getName());
  }

  /**
   * Test {@link PDIndexed#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDIndexed#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDIndexed()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test {@link PDIndexed#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDIndexed#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDIndexed()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDIndexed#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDIndexed#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull((new PDIndexed()).toRawImage(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDIndexed#getBaseColorSpace()}
   *   <li>{@link PDIndexed#getInitialColor()}
   *   <li>{@link PDIndexed#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDIndexed pdIndexed = new PDIndexed();

    // Act
    PDColorSpace actualBaseColorSpace = pdIndexed.getBaseColorSpace();
    PDColor actualInitialColor = pdIndexed.getInitialColor();
    int actualNumberOfComponents = pdIndexed.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertNull(actualBaseColorSpace);
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdIndexed, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDIndexed#setBaseColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDIndexed#setBaseColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setBaseColorSpace(PDColorSpace)")
  void testSetBaseColorSpace() {
    // Arrange
    PDIndexed pdIndexed = new PDIndexed();
    PDDeviceGray base = PDDeviceGray.INSTANCE;

    // Act
    pdIndexed.setBaseColorSpace(base);

    // Assert
    COSBase cOSObject = pdIndexed.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(4, ((COSArray) cOSObject).toList().size());
    PDDeviceGray expectedBaseColorSpace = base.INSTANCE;
    assertSame(expectedBaseColorSpace, pdIndexed.getBaseColorSpace());
  }
}
