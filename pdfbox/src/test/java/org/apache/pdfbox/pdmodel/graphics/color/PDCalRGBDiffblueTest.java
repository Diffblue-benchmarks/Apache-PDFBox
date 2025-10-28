package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCalRGBDiffblueTest {
  /**
   * Method under test: {@link PDCalRGB#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalRGB", (new PDCalRGB()).getName());
  }

  /**
   * Method under test: {@link PDCalRGB#getDefaultDecode(int)}
   */
  @Test
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, (new PDCalRGB()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Method under test: {@link PDCalRGB#toRGB(float[])}
   */
  @Test
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalRGB()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}),
        0.0f);
  }

  /**
   * Method under test: {@link PDCalRGB#getMatrix()}
   */
  @Test
  void testGetMatrix() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, (new PDCalRGB()).getMatrix(),
        0.0f);
  }

  /**
   * Method under test: {@link PDCalRGB#setMatrix(Matrix)}
   */
  @Test
  void testSetMatrix() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSArray rgb = mock(COSArray.class);
    when(rgb.getObject(anyInt())).thenReturn(cosDictionary);
    PDCalRGB pdCalRGB = new PDCalRGB(rgb);

    // Act
    pdCalRGB.setMatrix(new Matrix());

    // Assert
    verify(rgb).getObject(eq(1));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDCalRGB#getInitialColor()}
   *   <li>{@link PDCalRGB#getNumberOfComponents()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    PDColor actualInitialColor = pdCalRGB.getInitialColor();
    int actualNumberOfComponents = pdCalRGB.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(3, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalRGB, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }
}
