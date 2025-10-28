package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TilingPaintFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate2() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(9000000.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern, atLeast(1)).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate3() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(0.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate4() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(-0.5f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate5() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(0.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate6() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(-0.5f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate7() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(null);
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate8() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, null, color, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isNull(), isA(PDColor.class),
        isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate9() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, null, new AffineTransform());

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isNull(), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }

  /**
   * Method under test:
   * {@link TilingPaintFactory#create(PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testCreate10() throws IOException {
    // Arrange
    PageDrawer drawer = mock(PageDrawer.class);
    doNothing().when(drawer)
        .drawTilingPattern(Mockito.<Graphics2D>any(), Mockito.<PDTilingPattern>any(), Mockito.<PDColorSpace>any(),
            Mockito.<PDColor>any(), Mockito.<Matrix>any());
    when(drawer.getInitialMatrix()).thenReturn(new Matrix());
    TilingPaintFactory tilingPaintFactory = new TilingPaintFactory(drawer);
    PDTilingPattern pattern = mock(PDTilingPattern.class);
    when(pattern.getXStep()).thenReturn(10.0f);
    when(pattern.getYStep()).thenReturn(10.0f);
    when(pattern.getBBox()).thenReturn(PDRectangle.A0);
    when(pattern.getCOSObject()).thenReturn(new COSDictionary());
    when(pattern.getMatrix()).thenReturn(new Matrix());
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act
    Paint actualCreateResult = tilingPaintFactory.create(pattern, PDDeviceGray.INSTANCE, color,
        AffineTransform.getQuadrantRotateInstance(7));

    // Assert
    verify(drawer, atLeast(1)).getInitialMatrix();
    verify(pattern).getCOSObject();
    verify(pattern).getMatrix();
    verify(pattern, atLeast(1)).getBBox();
    verify(pattern, atLeast(1)).getXStep();
    verify(pattern, atLeast(1)).getYStep();
    verify(drawer).drawTilingPattern(isA(Graphics2D.class), isA(PDTilingPattern.class), isA(PDColorSpace.class),
        isA(PDColor.class), isA(Matrix.class));
    assertTrue(actualCreateResult instanceof TilingPaint);
    assertEquals(3, actualCreateResult.getTransparency());
  }
}
