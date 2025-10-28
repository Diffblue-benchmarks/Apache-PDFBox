package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.Test;

class TilingPaintDiffblueTest {
  /**
   * Method under test:
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, AffineTransform)}
   */
  @Test
  void testNewTilingPaint() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer drawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    drawer.processPage(new PDPage());
    PDTilingPattern pattern = new PDTilingPattern();

    // Act and Assert
    assertThrows(IOException.class, () -> new TilingPaint(drawer, pattern, new AffineTransform()));

    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  void testNewTilingPaint2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDFRenderer renderer = new PDFRenderer(new PDDocument(streamCacheCreateFunction));

    PageDrawer drawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    drawer.processPage(new PDPage());
    PDTilingPattern pattern = new PDTilingPattern();
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class,
        () -> new TilingPaint(drawer, pattern, PDDeviceGray.INSTANCE, color, new AffineTransform()));

    verify(streamCacheCreateFunction).create();
  }
}
