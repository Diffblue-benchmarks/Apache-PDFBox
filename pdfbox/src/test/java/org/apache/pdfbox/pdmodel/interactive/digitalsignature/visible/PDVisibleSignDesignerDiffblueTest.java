package org.apache.pdfbox.pdmodel.interactive.digitalsignature.visible;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.Test;

class PDVisibleSignDesignerDiffblueTest {
  /**
   * Method under test:
   * {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}
   */
  @Test
  void testNewPDVisibleSignDesigner() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.addPage(new PDPage());
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act
    PDVisibleSignDesigner actualPdVisibleSignDesigner = new PDVisibleSignDesigner(document, image, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("sig", actualPdVisibleSignDesigner.getSignatureFieldName());
    AffineTransform transform = actualPdVisibleSignDesigner.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getHeight());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getWidth());
    assertEquals(100.0f, actualPdVisibleSignDesigner.getImageSizeInPercents());
    assertEquals(612.0f, actualPdVisibleSignDesigner.getPageWidth());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getPageHeight());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getTemplateHeight());
    assertTrue(transform.isIdentity());
    assertSame(image, actualPdVisibleSignDesigner.getImage());
    assertArrayEquals(new int[]{0, 0, 1, 1}, actualPdVisibleSignDesigner.getFormatterRectangleParameters());
  }

  /**
   * Method under test:
   * {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}
   */
  @Test
  void testNewPDVisibleSignDesigner2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    PDDocument document = new PDDocument(streamCacheCreateFunction);
    document.save(new ByteArrayOutputStream(4), CompressParameters.DEFAULT_COMPRESSION);
    document.addPage(new PDPage());
    BufferedImage image = new BufferedImage(1, 1, 1);

    // Act
    PDVisibleSignDesigner actualPdVisibleSignDesigner = new PDVisibleSignDesigner(document, image, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("sig", actualPdVisibleSignDesigner.getSignatureFieldName());
    AffineTransform transform = actualPdVisibleSignDesigner.getTransform();
    assertEquals(0, transform.getType());
    assertEquals(0.0d, transform.getShearX());
    assertEquals(0.0d, transform.getShearY());
    assertEquals(0.0d, transform.getTranslateX());
    assertEquals(0.0d, transform.getTranslateY());
    assertEquals(1.0d, transform.getDeterminant());
    assertEquals(1.0d, transform.getScaleX());
    assertEquals(1.0d, transform.getScaleY());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getHeight());
    assertEquals(1.0f, actualPdVisibleSignDesigner.getWidth());
    assertEquals(100.0f, actualPdVisibleSignDesigner.getImageSizeInPercents());
    assertEquals(612.0f, actualPdVisibleSignDesigner.getPageWidth());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getPageHeight());
    assertEquals(792.0f, actualPdVisibleSignDesigner.getTemplateHeight());
    assertTrue(transform.isIdentity());
    assertSame(image, actualPdVisibleSignDesigner.getImage());
    assertArrayEquals(new int[]{0, 0, 1, 1}, actualPdVisibleSignDesigner.getFormatterRectangleParameters());
  }

  /**
   * Method under test:
   * {@link PDVisibleSignDesigner#PDVisibleSignDesigner(PDDocument, BufferedImage, int)}
   */
  @Test
  void testNewPDVisibleSignDesigner3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> new PDVisibleSignDesigner(document, new BufferedImage(1, 1, 1), 0));

    verify(streamCacheCreateFunction).create();
  }
}
