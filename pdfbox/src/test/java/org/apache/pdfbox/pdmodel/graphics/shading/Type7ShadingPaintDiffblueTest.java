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

class Type7ShadingPaintDiffblueTest {
  /**
   * Method under test:
   * {@link Type7ShadingPaint#createContext(ColorModel, Rectangle, Rectangle2D, AffineTransform, RenderingHints)}
   */
  @Test
  void testCreateContext() {
    // Arrange
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(COSBoolean.FALSE);
    PDShadingType7 shading = new PDShadingType7(shadingDictionary);
    Type7ShadingPaint type7ShadingPaint = new Type7ShadingPaint(shading, new Matrix());
    DirectColorModel cm = new DirectColorModel(1, 1, 1, 1);

    Rectangle deviceBounds = new Rectangle(1, 1);

    Rectangle userBounds = new Rectangle(1, 1);

    // Act
    type7ShadingPaint.createContext(cm, deviceBounds, userBounds, new AffineTransform(), null);

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Type7ShadingPaint#Type7ShadingPaint(PDShadingType7, Matrix)}
   *   <li>{@link Type7ShadingPaint#getTransparency()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    PDShadingType7 shading = new PDShadingType7(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Type7ShadingPaint actualType7ShadingPaint = new Type7ShadingPaint(shading, matrix);

    // Assert
    assertEquals(0, actualType7ShadingPaint.getTransparency());
    assertSame(shading, actualType7ShadingPaint.getShading());
    assertSame(matrix, actualType7ShadingPaint.getMatrix());
  }
}
