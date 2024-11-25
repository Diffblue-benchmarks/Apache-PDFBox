package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDCalGrayDiffblueTest {
  /**
   * Test {@link PDCalGray#PDCalGray()}.
   * <p>
   * Method under test: {@link PDCalGray#PDCalGray()}
   */
  @Test
  @DisplayName("Test new PDCalGray()")
  void testNewPDCalGray() {
    // Arrange and Act
    PDCalGray actualPdCalGray = new PDCalGray();

    // Assert
    COSBase cOSObject = actualPdCalGray.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus blackPoint = actualPdCalGray.getBlackPoint();
    COSBase cOSObject2 = blackPoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDTristimulus whitepoint = actualPdCalGray.getWhitepoint();
    COSBase cOSObject3 = whitepoint.getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult3.size());
    COSBase getResult3 = toListResult3.get(0);
    assertTrue(getResult3 instanceof COSName);
    assertEquals("CalGray", ((COSName) getResult3).getName());
    assertEquals("CalGray", actualPdCalGray.getName());
    COSDictionary cosDictionary = actualPdCalGray.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdCalGray.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult3.getKey());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(0, cosDictionary.size());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, actualPdCalGray.getNumberOfComponents());
    assertEquals(1.0f, actualPdCalGray.getGamma());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdCalGray.wpX);
    assertEquals(1.0f, actualPdCalGray.wpY);
    assertEquals(1.0f, actualPdCalGray.wpZ);
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(((COSName) getResult3).isEmpty());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(actualPdCalGray, initialColor.getColorSpace());
    assertSame(actualPdCalGray.dictionary, toListResult3.get(1));
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#PDCalGray(COSArray)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then BlackPoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName("Test new PDCalGray(COSArray); given COSDictionary(); then BlackPoint COSObject return COSArray")
  void testNewPDCalGray_givenCOSDictionary_thenBlackPointCOSObjectReturnCOSArray() {
    // Arrange
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(eq(1));
    PDTristimulus blackPoint = actualPdCalGray.getBlackPoint();
    COSBase cOSObject = blackPoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus whitepoint = actualPdCalGray.getWhitepoint();
    COSBase cOSObject2 = whitepoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals("CalGray", actualPdCalGray.getName());
    COSDictionary cosDictionary = actualPdCalGray.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdCalGray.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(0, cosDictionary.size());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, actualPdCalGray.getNumberOfComponents());
    assertEquals(1.0f, actualPdCalGray.getGamma());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdCalGray.wpX);
    assertEquals(1.0f, actualPdCalGray.wpY);
    assertEquals(1.0f, actualPdCalGray.wpZ);
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(actualPdCalGray, initialColor.getColorSpace());
    assertSame(array, actualPdCalGray.getCOSObject());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#PDCalGray(COSArray)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link PDCIEDictionaryBasedColorSpace#dictionary} return
   * {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCalGray#PDCalGray(COSArray)}
   */
  @Test
  @DisplayName("Test new PDCalGray(COSArray); given COSStream(); then dictionary return COSStream")
  void testNewPDCalGray_givenCOSStream_thenDictionaryReturnCOSStream() {
    // Arrange
    COSArray array = mock(COSArray.class);
    when(array.getObject(anyInt())).thenReturn(new COSStream());

    // Act
    PDCalGray actualPdCalGray = new PDCalGray(array);

    // Assert
    verify(array).getObject(eq(1));
    COSDictionary cosDictionary = actualPdCalGray.dictionary;
    assertTrue(cosDictionary instanceof COSStream);
    assertNull(((COSStream) cosDictionary).getFilters());
    assertEquals(0L, ((COSStream) cosDictionary).getLength());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertFalse(((COSStream) cosDictionary).hasData());
  }

  /**
   * Test {@link PDCalGray#getName()}.
   * <p>
   * Method under test: {@link PDCalGray#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalGray", (new PDCalGray()).getName());
  }

  /**
   * Test {@link PDCalGray#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDCalGray#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f}, (new PDCalGray()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCalGray#getInitialColor()}
   *   <li>{@link PDCalGray#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    PDColor actualInitialColor = pdCalGray.getInitialColor();
    int actualNumberOfComponents = pdCalGray.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(1, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalGray, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalGray#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDCalGray#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}),
        0.0f);
  }

  /**
   * Test {@link PDCalGray#getGamma()}.
   * <p>
   * Method under test: {@link PDCalGray#getGamma()}
   */
  @Test
  @DisplayName("Test getGamma()")
  void testGetGamma() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDCalGray()).getGamma());
  }

  /**
   * Test {@link PDCalGray#setGamma(float)}.
   * <p>
   * Method under test: {@link PDCalGray#setGamma(float)}
   */
  @Test
  @DisplayName("Test setGamma(float)")
  void testSetGamma() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setGamma(10.0f);

    // Assert
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(10.0f, pdCalGray.getGamma());
  }
}
