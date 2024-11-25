package org.apache.pdfbox.rendering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentGroup;
import org.apache.pdfbox.pdmodel.interactive.annotation.AnnotationFilter;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFRendererDiffblueTest {
  /**
   * Test {@link PDFRenderer#PDFRenderer(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.</li>
   *   <li>Then return RenderingHints is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFRenderer#PDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFRenderer(PDDocument); given PDPageTree(); then return RenderingHints is 'null'")
  void testNewPDFRenderer_givenPDPageTree_thenReturnRenderingHintsIsNull() {
    // Arrange
    PDDocument document = mock(PDDocument.class);
    when(document.getPages()).thenReturn(new PDPageTree());

    // Act
    PDFRenderer actualPdfRenderer = new PDFRenderer(document);

    // Assert
    verify(document).getPages();
    assertNull(actualPdfRenderer.getRenderingHints());
    assertNull(actualPdfRenderer.getPageImage());
    assertNull(actualPdfRenderer.getDefaultDestination());
    assertEquals(0.5f, actualPdfRenderer.getImageDownscalingOptimizationThreshold());
    assertFalse(actualPdfRenderer.isSubsamplingAllowed());
  }

  /**
   * Test {@link PDFRenderer#PDFRenderer(PDDocument)}.
   * <ul>
   *   <li>Then return {@link PDFRenderer#document} DocumentCatalog
   * StructureTreeRoot Type is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFRenderer#PDFRenderer(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFRenderer(PDDocument); then return document DocumentCatalog StructureTreeRoot Type is 'null'")
  void testNewPDFRenderer_thenReturnDocumentDocumentCatalogStructureTreeRootTypeIsNull() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    COSDictionary newTrailer = mock(COSDictionary.class);
    when(newTrailer.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    when(newTrailer.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    COSDocument doc = new COSDocument();
    doc.setTrailer(newTrailer);

    // Act
    PDFRenderer actualPdfRenderer = new PDFRenderer(new PDDocument(doc));

    // Assert
    verify(newTrailer).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(newTrailer).getUpdateState();
    PDDocumentCatalog documentCatalog = actualPdfRenderer.document.getDocumentCatalog();
    PDStructureTreeRoot structureTreeRoot = documentCatalog.getStructureTreeRoot();
    assertNull(structureTreeRoot.getType());
    PDViewerPreferences viewerPreferences = documentCatalog.getViewerPreferences();
    assertNull(viewerPreferences.getNonFullScreenPageMode());
    assertNull(viewerPreferences.getPrintArea());
    assertNull(viewerPreferences.getPrintClip());
    assertNull(viewerPreferences.getPrintScaling());
    assertNull(viewerPreferences.getReadingDirection());
    assertNull(viewerPreferences.getViewArea());
    assertNull(viewerPreferences.getViewClip());
    assertEquals(0, structureTreeRoot.getParentTreeNextKey());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDFRenderer#setAnnotationsFilter(AnnotationFilter)}
   *   <li>{@link PDFRenderer#setDefaultDestination(RenderDestination)}
   *   <li>{@link PDFRenderer#setImageDownscalingOptimizationThreshold(float)}
   *   <li>{@link PDFRenderer#setRenderingHints(RenderingHints)}
   *   <li>{@link PDFRenderer#setSubsamplingAllowed(boolean)}
   *   <li>{@link PDFRenderer#getAnnotationsFilter()}
   *   <li>{@link PDFRenderer#getDefaultDestination()}
   *   <li>{@link PDFRenderer#getImageDownscalingOptimizationThreshold()}
   *   <li>{@link PDFRenderer#getPageImage()}
   *   <li>{@link PDFRenderer#getRenderingHints()}
   *   <li>{@link PDFRenderer#isSubsamplingAllowed()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());
    AnnotationFilter annotationsFilter = mock(AnnotationFilter.class);

    // Act
    pdfRenderer.setAnnotationsFilter(annotationsFilter);
    pdfRenderer.setDefaultDestination(RenderDestination.EXPORT);
    pdfRenderer.setImageDownscalingOptimizationThreshold(10.0f);
    pdfRenderer.setRenderingHints(null);
    pdfRenderer.setSubsamplingAllowed(true);
    AnnotationFilter actualAnnotationsFilter = pdfRenderer.getAnnotationsFilter();
    RenderDestination actualDefaultDestination = pdfRenderer.getDefaultDestination();
    float actualImageDownscalingOptimizationThreshold = pdfRenderer.getImageDownscalingOptimizationThreshold();
    pdfRenderer.getPageImage();
    pdfRenderer.getRenderingHints();

    // Assert that nothing has changed
    assertEquals(10.0f, actualImageDownscalingOptimizationThreshold);
    assertEquals(RenderDestination.EXPORT, actualDefaultDestination);
    assertTrue(pdfRenderer.isSubsamplingAllowed());
    assertSame(annotationsFilter, actualAnnotationsFilter);
  }

  /**
   * Test {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}.
   * <p>
   * Method under test: {@link PDFRenderer#isGroupEnabled(PDOptionalContentGroup)}
   */
  @Test
  @DisplayName("Test isGroupEnabled(PDOptionalContentGroup)")
  void testIsGroupEnabled() {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());

    // Act and Assert
    assertTrue(pdfRenderer.isGroupEnabled(new PDOptionalContentGroup("Name")));
  }

  /**
   * Test {@link PDFRenderer#createPageDrawer(PageDrawerParameters)}.
   * <ul>
   *   <li>Then LinePath Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFRenderer#createPageDrawer(PageDrawerParameters)}
   */
  @Test
  @DisplayName("Test createPageDrawer(PageDrawerParameters); then LinePath Bounds Bounds2D return Rectangle")
  void testCreatePageDrawer_thenLinePathBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange
    PDFRenderer pdfRenderer = new PDFRenderer(new PDDocument());
    PDFRenderer renderer = new PDFRenderer(new PDDocument());

    // Act
    PageDrawer actualCreatePageDrawerResult = pdfRenderer.createPageDrawer(
        new PageDrawerParameters(renderer, new PDPage(), true, RenderDestination.EXPORT, null, 10.0f));

    // Assert
    GeneralPath linePath = actualCreatePageDrawerResult.getLinePath();
    Rectangle bounds = linePath.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D bounds2D2 = linePath.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle2D.Float);
    assertNull(actualCreatePageDrawerResult.getGraphics());
    assertNull(linePath.getCurrentPoint());
    assertNull(actualCreatePageDrawerResult.getCurrentPoint());
    assertNull(actualCreatePageDrawerResult.getCurrentPage());
    assertNull(actualCreatePageDrawerResult.getResources());
    assertNull(actualCreatePageDrawerResult.getGraphicsState());
    assertNull(actualCreatePageDrawerResult.getInitialMatrix());
    assertEquals(0, actualCreatePageDrawerResult.getGraphicsStackSize());
    assertEquals(0, actualCreatePageDrawerResult.getLevel());
    Dimension size = bounds.getSize();
    assertEquals(0, size.height);
    assertEquals(0, size.width);
    Point location = bounds.getLocation();
    assertEquals(0, location.x);
    assertEquals(0, location.y);
    assertEquals(0, bounds.height);
    assertEquals(0, bounds.width);
    assertEquals(0, bounds.x);
    assertEquals(0, bounds.y);
    assertEquals(0.0d, size.getHeight());
    assertEquals(0.0d, size.getWidth());
    assertEquals(0.0d, location.getX());
    assertEquals(0.0d, location.getY());
    assertEquals(0.0d, bounds.getHeight());
    assertEquals(0.0d, bounds.getWidth());
    assertEquals(0.0d, bounds.getX());
    assertEquals(0.0d, bounds.getY());
    assertEquals(0.0d, bounds.getCenterX());
    assertEquals(0.0d, bounds.getCenterY());
    assertEquals(0.0d, bounds.getMaxX());
    assertEquals(0.0d, bounds.getMaxY());
    assertEquals(0.0d, bounds.getMinX());
    assertEquals(0.0d, bounds.getMinY());
    assertEquals(1, linePath.getWindingRule());
    assertTrue(bounds.isEmpty());
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertEquals(bounds, bounds2D2);
    assertSame(renderer, actualCreatePageDrawerResult.getRenderer());
  }
}
