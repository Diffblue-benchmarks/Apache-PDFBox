package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.awt.image.WritableRaster;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.junit.jupiter.api.Test;

class PDLabDiffblueTest {
  /**
   * Method under test: {@link PDLab#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Lab", (new PDLab()).getName());
  }

  /**
   * Method under test: {@link PDLab#toRawImage(WritableRaster)}
   */
  @Test
  void testToRawImage() {
    // Arrange, Act and Assert
    assertNull((new PDLab()).toRawImage(null));
  }

  /**
   * Method under test: {@link PDLab#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.1589685f, 0.050019074f},
        (new PDLab()).toRGB(new float[]{10.0f, -100.0f, 10.0f, -100.0f}), 0.0f);
  }

  /**
   * Method under test: {@link PDLab#getNumberOfComponents()}
   */
  @Test
  void testGetNumberOfComponents() {
    // Arrange, Act and Assert
    assertEquals(3, (new PDLab()).getNumberOfComponents());
  }

  /**
   * Method under test: {@link PDLab#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 100.0f, -100.0f, 100.0f, -100.0f, 100.0f}, (new PDLab()).getDefaultDecode(1),
        0.0f);
  }

  /**
   * Method under test: {@link PDLab#getInitialColor()}
   */
  @Test
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
   * Method under test: {@link PDLab#getARange()}
   */
  @Test
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
   * Method under test: {@link PDLab#getBRange()}
   */
  @Test
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
   * Method under test: {@link PDLab#setARange(PDRange)}
   */
  @Test
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
   * Method under test: {@link PDLab#setBRange(PDRange)}
   */
  @Test
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
