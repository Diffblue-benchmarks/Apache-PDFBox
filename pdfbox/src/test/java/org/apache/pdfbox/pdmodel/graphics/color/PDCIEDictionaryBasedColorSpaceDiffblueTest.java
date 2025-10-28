package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.junit.jupiter.api.Test;

class PDCIEDictionaryBasedColorSpaceDiffblueTest {
  /**
   * Method under test: {@link PDCIEDictionaryBasedColorSpace#isWhitePoint()}
   */
  @Test
  void testIsWhitePoint() {
    // Arrange, Act and Assert
    assertTrue((new PDCalGray()).isWhitePoint());
  }

  /**
   * Method under test:
   * {@link PDCIEDictionaryBasedColorSpace#convXYZtoRGB(float, float, float)}
   */
  @Test
  void testConvXYZtoRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).convXYZtoRGB(10.0f, 10.0f, 10.0f), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).convXYZtoRGB(0.0f, 0.0f, -1.0E-5f), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).convXYZtoRGB(0.0f, -1.0E-5f, 0.0f), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalGray()).convXYZtoRGB(-1.0E-5f, 0.0f, 0.0f), 0.0f);
  }

  /**
   * Method under test: {@link PDCIEDictionaryBasedColorSpace#getBlackPoint()}
   */
  @Test
  void testGetBlackPoint() {
    // Arrange and Act
    PDTristimulus actualBlackPoint = (new PDCalGray()).getBlackPoint();

    // Assert
    COSBase cOSObject = actualBlackPoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualBlackPoint.getX());
    assertEquals(0.0f, actualBlackPoint.getY());
    assertEquals(0.0f, actualBlackPoint.getZ());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Method under test:
   * {@link PDCIEDictionaryBasedColorSpace#setWhitePoint(PDTristimulus)}
   */
  @Test
  void testSetWhitePoint() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setWhitePoint(new PDTristimulus());

    // Assert
    PDTristimulus whitepoint = pdCalGray.getWhitepoint();
    assertEquals(0.0f, whitepoint.getX());
    assertEquals(0.0f, whitepoint.getY());
    assertEquals(0.0f, whitepoint.getZ());
    assertEquals(0.0f, pdCalGray.wpX);
    assertEquals(0.0f, pdCalGray.wpY);
    assertEquals(0.0f, pdCalGray.wpZ);
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
  }

  /**
   * Method under test:
   * {@link PDCIEDictionaryBasedColorSpace#setBlackPoint(PDTristimulus)}
   */
  @Test
  void testSetBlackPoint() {
    // Arrange
    PDCalGray pdCalGray = new PDCalGray();

    // Act
    pdCalGray.setBlackPoint(new PDTristimulus());

    // Assert
    COSDictionary cosDictionary = pdCalGray.dictionary;
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
  }
}
