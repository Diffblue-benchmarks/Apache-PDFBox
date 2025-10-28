package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionTypeIdentity;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class SoftMaskDiffblueTest {
  /**
   * Method under test:
   * {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}
   */
  @Test
  void testNewSoftMask() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    TilingPaint paint = new TilingPaint(drawer, pattern, new AffineTransform());

    BufferedImage mask = new BufferedImage(1, 1, 1);

    Rectangle bboxDevice = new Rectangle(1, 1);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    PDColor backdropColor = new PDColor(array, PDDeviceGray.INSTANCE);

    // Act
    SoftMask actualSoftMask = new SoftMask(paint, mask, bboxDevice, backdropColor,
        new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    verify(drawer).getInitialMatrix();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isNull(),
        isA(Matrix.class));
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Method under test:
   * {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}
   */
  @Test
  void testNewSoftMask2() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    TilingPaint paint = new TilingPaint(drawer, pattern, new AffineTransform());

    BufferedImage mask = new BufferedImage(1, 1, 1);

    Rectangle bboxDevice = new Rectangle(1, 1);

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.toRGB(Mockito.<float[]>any())).thenThrow(new IOException("foo"));
    PDColor backdropColor = new PDColor(new COSArray(), colorSpace);

    // Act
    SoftMask actualSoftMask = new SoftMask(paint, mask, bboxDevice, backdropColor,
        new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    verify(drawer).getInitialMatrix();
    verify(colorSpace).toRGB(isA(float[].class));
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isNull(),
        isA(Matrix.class));
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Method under test:
   * {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}
   */
  @Test
  void testNewSoftMask3() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    TilingPaint paint = new TilingPaint(drawer, pattern, new AffineTransform());

    BufferedImage mask = new BufferedImage(1, 1, 1);

    Rectangle bboxDevice = new Rectangle(1, 1);

    new IOException("foo");

    // Act
    SoftMask actualSoftMask = new SoftMask(paint, mask, bboxDevice, null, new PDFunctionType0(COSBoolean.FALSE));

    // Assert
    verify(drawer).getInitialMatrix();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isNull(),
        isA(Matrix.class));
    assertEquals(3, actualSoftMask.getTransparency());
  }

  /**
   * Method under test:
   * {@link SoftMask#SoftMask(Paint, BufferedImage, Rectangle2D, PDColor, PDFunction)}
   */
  @Test
  void testNewSoftMask4() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    TilingPaint paint = new TilingPaint(drawer, pattern, new AffineTransform());

    BufferedImage mask = new BufferedImage(1, 1, 1);

    Rectangle bboxDevice = new Rectangle(1, 1);

    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.toRGB(Mockito.<float[]>any())).thenThrow(new IOException("foo"));
    PDColor backdropColor = new PDColor(new COSArray(), colorSpace);

    // Act
    SoftMask actualSoftMask = new SoftMask(paint, mask, bboxDevice, backdropColor,
        new PDFunctionTypeIdentity(COSBoolean.FALSE));

    // Assert
    verify(drawer).getInitialMatrix();
    verify(colorSpace).toRGB(isA(float[].class));
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isNull(),
        isA(Matrix.class));
    assertEquals(3, actualSoftMask.getTransparency());
  }
}
