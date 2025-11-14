package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JPEGFactoryDiffblueTest {
  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(72, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    COSDictionary cOSObject = actualCreateFromImageResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDStream stream = actualCreateFromImageResult.getStream();
    assertEquals(647, stream.getLength());
    assertEquals(647L, ((COSStream) cOSObject).getLength());
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertEquals(72, image.getTileWidth());
    assertEquals(72, opaqueImage.getTileWidth());
    assertEquals(72, image.getWidth());
    assertEquals(72, opaqueImage.getWidth());
    assertEquals(72, actualCreateFromImageResult.getRawRaster().getWidth());
    assertEquals(72, actualCreateFromImageResult.getWidth());
    assertSame(cOSObject, stream.getCOSObject());
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)} with {@code
   * document}, {@code image}, {@code quality}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float) with 'document', 'image', 'quality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float)"
  })
  void testCreateFromImageWithDocumentImageQuality() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f);

    // Assert
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    assertEquals(1, actualCreateFromImageResult.getImage().getWritableTileIndices().length);
    assertEquals(1, opaqueImage.getWritableTileIndices().length);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)} with {@code
   * document}, {@code image}, {@code quality}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float) with 'document', 'image', 'quality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float)"
  })
  void testCreateFromImageWithDocumentImageQuality2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)} with {@code
   * document}, {@code image}, {@code quality}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float) with 'document', 'image', 'quality'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float)"
  })
  void testCreateFromImageWithDocumentImageQuality3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float, int)} with {@code
   * document}, {@code image}, {@code quality}, {@code dpi}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float, int) with 'document', 'image', 'quality', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float, int)"
  })
  void testCreateFromImageWithDocumentImageQualityDpi() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f, 1);

    // Assert
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    assertEquals(1, actualCreateFromImageResult.getImage().getWritableTileIndices().length);
    assertEquals(1, opaqueImage.getWritableTileIndices().length);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float, int)} with {@code
   * document}, {@code image}, {@code quality}, {@code dpi}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float, int) with 'document', 'image', 'quality', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float, int)"
  })
  void testCreateFromImageWithDocumentImageQualityDpi2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float, int)} with {@code
   * document}, {@code image}, {@code quality}, {@code dpi}.
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float, int) with 'document', 'image', 'quality', 'dpi'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float, int)"
  })
  void testCreateFromImageWithDocumentImageQualityDpi3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1), 0.5f, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float, int)} with {@code
   * document}, {@code image}, {@code quality}, {@code dpi}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float,
   * int)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float, int) with 'document', 'image', 'quality', 'dpi'; then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float, int)"
  })
  void testCreateFromImageWithDocumentImageQualityDpi_thenCOSObjectReturnCOSStream()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 2), 0.5f, 1);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCreateFromImageResult.getCOSObject() instanceof COSStream);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)} with {@code
   * document}, {@code image}, {@code quality}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage, float)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage, float) with 'document', 'image', 'quality'; then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage, float)"
  })
  void testCreateFromImageWithDocumentImageQuality_thenCOSObjectReturnCOSStream()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 2), 0.5f);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCreateFromImageResult.getCOSObject() instanceof COSStream);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <ul>
   *   <li>Then ColorSpace return {@link PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'; then ColorSpace return PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage_thenColorSpaceReturnPDDeviceRGB() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 2));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualCreateFromImageResult.getCOSObject() instanceof COSStream);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <ul>
   *   <li>Then RawRaster DataBuffer return {@link DataBufferByte}.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'; then RawRaster DataBuffer return DataBufferByte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage_thenRawRasterDataBufferReturnDataBufferByte()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getDataBuffer() instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)} with {@code document},
   * {@code image}.
   *
   * <ul>
   *   <li>Then return Stream Filters size is one.
   * </ul>
   *
   * <p>Method under test: {@link JPEGFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage) with 'document', 'image'; then return Stream Filters size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject JPEGFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImageWithDocumentImage_thenReturnStreamFiltersSizeIsOne() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult =
        JPEGFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateFromImageResult.getStream().getFilters().size());
    assertEquals(1, actualCreateFromImageResult.getImage().getWritableTileIndices().length);
    assertEquals(1, opaqueImage.getWritableTileIndices().length);
  }
}
