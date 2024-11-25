package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TilingPaintDiffblueTest {
  /**
   * Test
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, AffineTransform)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, AffineTransform)}
   */
  @Test
  @DisplayName("Test new TilingPaint(PageDrawer, PDTilingPattern, AffineTransform); given PDPage(); then throw IOException")
  void testNewTilingPaint_givenPDPage_thenThrowIOException() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer drawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    drawer.processPage(new PDPage());
    PDTilingPattern pattern = new PDTilingPattern();

    // Act and Assert
    assertThrows(IOException.class, () -> new TilingPaint(drawer, pattern, new AffineTransform()));

  }

  /**
   * Test
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TilingPaint#TilingPaint(PageDrawer, PDTilingPattern, PDColorSpace, PDColor, AffineTransform)}
   */
  @Test
  @DisplayName("Test new TilingPaint(PageDrawer, PDTilingPattern, PDColorSpace, PDColor, AffineTransform); given PDPage(); then throw IOException")
  void testNewTilingPaint_givenPDPage_thenThrowIOException2() throws IOException {
    // Arrange
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    PageDrawer drawer = new PageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));
    drawer.processPage(new PDPage());
    PDTilingPattern pattern = new PDTilingPattern();
    PDColor color = new PDColor(new COSArray(), PDDeviceGray.INSTANCE);

    // Act and Assert
    assertThrows(IOException.class,
        () -> new TilingPaint(drawer, pattern, PDDeviceGray.INSTANCE, color, new AffineTransform()));

  }
}
