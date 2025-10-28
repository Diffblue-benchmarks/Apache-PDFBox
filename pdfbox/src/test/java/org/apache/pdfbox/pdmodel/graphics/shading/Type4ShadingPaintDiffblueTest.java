package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class Type4ShadingPaintDiffblueTest {
  /**
   * Method under test:
   * {@link Type4ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext() {
    // Arrange
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(COSBoolean.FALSE);
    PDShadingType4 shading = new PDShadingType4(shadingDictionary);
    Type4ShadingPaint type4ShadingPaint = new Type4ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    type4ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type4ShadingPaint#Type4ShadingPaint(PDShadingType4, Matrix)}
   *   <li>{@link Type4ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDShadingType4 shading = new PDShadingType4(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Type4ShadingPaint actualType4ShadingPaint = new Type4ShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualType4ShadingPaint.getTransparency());
    assertSame(shading, actualType4ShadingPaint.getShading());
    assertSame(matrix, actualType4ShadingPaint.getMatrix());
  }
}
