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
import java.awt.image.WritableRaster;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDLabDiffblueTest {
  /**
   * Test {@link PDLab#PDLab()}.
   * <p>
   * Method under test: {@link PDLab#PDLab()}
   */
  @Test
  @DisplayName("Test new PDLab()")
  void testNewPDLab() {
    // Arrange and Act
    PDLab actualPdLab = new PDLab();

    // Assert
    COSBase cOSObject = actualPdLab.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus blackPoint = actualPdLab.getBlackPoint();
    COSBase cOSObject2 = blackPoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDTristimulus whitepoint = actualPdLab.getWhitepoint();
    COSBase cOSObject3 = whitepoint.getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    PDRange aRange = actualPdLab.getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult3.size());
    COSBase getResult6 = toListResult3.get(0);
    assertTrue(getResult6 instanceof COSFloat);
    List<? extends COSBase> toListResult4 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult4.size());
    COSBase getResult7 = toListResult4.get(0);
    assertTrue(getResult7 instanceof COSName);
    assertEquals("Lab", ((COSName) getResult7).getName());
    assertEquals("Lab", actualPdLab.getName());
    COSDictionary cosDictionary = actualPdLab.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdLab.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult7.getKey());
    assertNull(getResult5.getKey());
    assertNull(getResult6.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = actualPdLab.getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(0, cosDictionary.size());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdLab.wpX);
    assertEquals(1.0f, actualPdLab.wpY);
    assertEquals(1.0f, actualPdLab.wpZ);
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualPdLab.getNumberOfComponents());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult7.isDirect());
    assertFalse(getResult5.isDirect());
    assertFalse(getResult6.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(((COSName) getResult7).isEmpty());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray cOSArray2 = bRange.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(actualPdLab, initialColor.getColorSpace());
    assertSame(cOSArray, aRange.getCOSObject());
    assertSame(cOSArray2, bRange.getCOSObject());
    assertSame(actualPdLab.dictionary, toListResult4.get(1));
    assertSame(getResult5, toListResult2.get(1));
    assertSame(getResult5, toListResult2.get(2));
    assertSame(getResult6, toListResult3.get(1));
    assertSame(getResult6, toListResult3.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDLab#PDLab(COSArray)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then BlackPoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLab#PDLab(COSArray)}
   */
  @Test
  @DisplayName("Test new PDLab(COSArray); given COSDictionary(); then BlackPoint COSObject return COSArray")
  void testNewPDLab_givenCOSDictionary_thenBlackPointCOSObjectReturnCOSArray() {
    // Arrange
    COSArray lab = mock(COSArray.class);
    when(lab.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDLab actualPdLab = new PDLab(lab);

    // Assert
    verify(lab).getObject(eq(1));
    PDTristimulus blackPoint = actualPdLab.getBlackPoint();
    COSBase cOSObject = blackPoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus whitepoint = actualPdLab.getWhitepoint();
    COSBase cOSObject2 = whitepoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDRange aRange = actualPdLab.getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult3.size());
    COSBase getResult6 = toListResult3.get(0);
    assertTrue(getResult6 instanceof COSFloat);
    assertEquals("Lab", actualPdLab.getName());
    COSDictionary cosDictionary = actualPdLab.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdLab.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult5.getKey());
    assertNull(getResult6.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = actualPdLab.getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(0, cosDictionary.size());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdLab.wpX);
    assertEquals(1.0f, actualPdLab.wpY);
    assertEquals(1.0f, actualPdLab.wpZ);
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualPdLab.getNumberOfComponents());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult5.isDirect());
    assertFalse(getResult6.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(cosDictionary.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray cOSArray2 = bRange.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(actualPdLab, initialColor.getColorSpace());
    assertSame(cOSArray, aRange.getCOSObject());
    assertSame(cOSArray2, bRange.getCOSObject());
    assertSame(lab, actualPdLab.getCOSObject());
    assertSame(getResult5, toListResult2.get(1));
    assertSame(getResult5, toListResult2.get(2));
    assertSame(getResult6, toListResult3.get(1));
    assertSame(getResult6, toListResult3.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDLab#PDLab(COSArray)}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link PDCIEDictionaryBasedColorSpace#dictionary} return
   * {@link COSStream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDLab#PDLab(COSArray)}
   */
  @Test
  @DisplayName("Test new PDLab(COSArray); given COSStream(); then dictionary return COSStream")
  void testNewPDLab_givenCOSStream_thenDictionaryReturnCOSStream() {
    // Arrange
    COSArray lab = mock(COSArray.class);
    when(lab.getObject(anyInt())).thenReturn(new COSStream());

    // Act
    PDLab actualPdLab = new PDLab(lab);

    // Assert
    verify(lab).getObject(eq(1));
    COSDictionary cosDictionary = actualPdLab.dictionary;
    assertTrue(cosDictionary instanceof COSStream);
    assertNull(((COSStream) cosDictionary).getFilters());
    assertEquals(0L, ((COSStream) cosDictionary).getLength());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertFalse(((COSStream) cosDictionary).hasData());
  }

  /**
   * Test {@link PDLab#getName()}.
   * <p>
   * Method under test: {@link PDLab#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Lab", (new PDLab()).getName());
  }

  /**
   * Test {@link PDLab#toRawImage(WritableRaster)} with {@code raster}.
   * <p>
   * Method under test: {@link PDLab#toRawImage(WritableRaster)}
   */
  @Test
  @DisplayName("Test toRawImage(WritableRaster) with 'raster'")
  void testToRawImageWithRaster() {
    // Arrange, Act and Assert
    assertNull((new PDLab()).toRawImage(null));
  }

  /**
   * Test {@link PDLab#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDLab#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.1589685f, 0.050019074f},
        (new PDLab()).toRGB(new float[]{10.0f, -100.0f, 10.0f, -100.0f}), 0.0f);
  }

  /**
   * Test {@link PDLab#getNumberOfComponents()}.
   * <p>
   * Method under test: {@link PDLab#getNumberOfComponents()}
   */
  @Test
  @DisplayName("Test getNumberOfComponents()")
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertEquals(3, (new PDLab()).getNumberOfComponents());
  }

  /**
   * Test {@link PDLab#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDLab#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 100.0f, -100.0f, 100.0f, -100.0f, 100.0f}, (new PDLab()).getDefaultDecode(1),
        0.0f);
  }

  /**
   * Test {@link PDLab#getInitialColor()}.
   * <p>
   * Method under test: {@link PDLab#getInitialColor()}
   */
  @Test
  @DisplayName("Test getInitialColor()")
  void testGetInitialColor() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    PDColor actualInitialColor = pdLab.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdLab, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDLab#getARange()}.
   * <p>
   * Method under test: {@link PDLab#getARange()}
   */
  @Test
  @DisplayName("Test getARange()")
  void testGetARange() {
    // Arrange and Act
    PDRange actualARange = (new PDLab()).getARange();

    // Assert
    COSArray cOSArray = actualARange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, actualARange.getMin());
    assertEquals(100.0f, actualARange.getMax());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, actualARange.getCOSObject());
  }

  /**
   * Test {@link PDLab#getBRange()}.
   * <p>
   * Method under test: {@link PDLab#getBRange()}
   */
  @Test
  @DisplayName("Test getBRange()")
  void testGetBRange() {
    // Arrange and Act
    PDRange actualBRange = (new PDLab()).getBRange();

    // Assert
    COSArray cOSArray = actualBRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, actualBRange.getMin());
    assertEquals(100.0f, actualBRange.getMax());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    assertSame(cOSArray, actualBRange.getCOSObject());
  }

  /**
   * Test {@link PDLab#setARange(PDRange)}.
   * <p>
   * Method under test: {@link PDLab#setARange(PDRange)}
   */
  @Test
  @DisplayName("Test setARange(PDRange)")
  void testSetARange() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setARange(new PDRange());

    // Assert
    PDRange aRange = pdLab.getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    assertTrue(toListResult.get(1) instanceof COSFloat);
    assertEquals(0.0f, aRange.getMin());
    COSDictionary cosDictionary = pdLab.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(1.0f, aRange.getMax());
    PDRange bRange = pdLab.getBRange();
    assertSame(cOSArray, bRange.getCOSArray());
    assertSame(cOSArray, bRange.getCOSObject());
  }

  /**
   * Test {@link PDLab#setBRange(PDRange)}.
   * <p>
   * Method under test: {@link PDLab#setBRange(PDRange)}
   */
  @Test
  @DisplayName("Test setBRange(PDRange)")
  void testSetBRange() {
    // Arrange
    PDLab pdLab = new PDLab();

    // Act
    pdLab.setBRange(new PDRange());

    // Assert
    COSArray cOSArray = pdLab.getARange().getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    assertTrue(toListResult.get(2) instanceof COSFloat);
    assertTrue(toListResult.get(3) instanceof COSFloat);
    PDRange bRange = pdLab.getBRange();
    assertEquals(0.0f, bRange.getMin());
    COSDictionary cosDictionary = pdLab.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(1.0f, bRange.getMax());
    assertSame(cOSArray, bRange.getCOSArray());
    assertSame(cOSArray, bRange.getCOSObject());
  }
}
