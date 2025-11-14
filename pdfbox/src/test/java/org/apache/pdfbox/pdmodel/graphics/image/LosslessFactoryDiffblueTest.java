package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LosslessFactoryDiffblueTest {
  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@link ScratchFile#ScratchFile(MemoryUsageSetting)} with memUsageSetting is
   *       setupMainMemoryOnly zero.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); given ScratchFile(MemoryUsageSetting) with memUsageSetting is setupMainMemoryOnly zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_givenScratchFileWithMemUsageSettingIsSetupMainMemoryOnlyZero()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getColorModel() instanceof DirectColorModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then ColorSpace return {@link PDDeviceGray}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then ColorSpace return PDDeviceGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenColorSpaceReturnPDDeviceGray() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(
            document, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_GRAY));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceGray);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then Image ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then Image ColorModel return DirectColorModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenImageColorModelReturnDirectColorModel() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertTrue(image.getColorModel() instanceof DirectColorModel);
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getColorModel() instanceof DirectColorModel);
    assertTrue(image.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertTrue(actualCreateFromImageResult.getColorSpace() instanceof PDDeviceRGB);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then Image SampleModel return {@link PixelInterleavedSampleModel}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then Image SampleModel return PixelInterleavedSampleModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenImageSampleModelReturnPixelInterleavedSampleModel()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(
            document, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage image = actualCreateFromImageResult.getImage();
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    SampleModel sampleModel2 = opaqueImage.getSampleModel();
    assertTrue(sampleModel2 instanceof PixelInterleavedSampleModel);
    SampleModel sampleModel3 = actualCreateFromImageResult.getRawRaster().getSampleModel();
    assertTrue(sampleModel3 instanceof PixelInterleavedSampleModel);
    assertEquals(1, actualCreateFromImageResult.getBitsPerComponent());
    assertEquals(10, image.getType());
    assertEquals(10, opaqueImage.getType());
    assertEquals(sampleModel, sampleModel2);
    assertEquals(sampleModel, sampleModel3);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then return Stream DecodeParms size is one.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then return Stream DecodeParms size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenReturnStreamDecodeParmsSizeIsOne() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(
            document, new BufferedImage(BufferedImage.TYPE_BYTE_GRAY, 1, 1));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
    assertEquals(1, actualCreateFromImageResult.getStream().getDecodeParms().size());
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertEquals(10, image.getTileWidth());
    assertEquals(10, opaqueImage.getTileWidth());
    assertEquals(10, image.getWidth());
    assertEquals(10, opaqueImage.getWidth());
    assertEquals(10, actualCreateFromImageResult.getRawRaster().getWidth());
    assertEquals(10, actualCreateFromImageResult.getWidth());
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and eight.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndEight() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 8));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and five.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndFive() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 5));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and four.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndFour() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 4));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and six.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndSix() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 6));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getSampleModel()
            instanceof SinglePixelPackedSampleModel);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    assertTrue(softMask.getCOSObject() instanceof COSStream);
    assertTrue(softMask.getColorSpace() instanceof PDDeviceGray);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and three.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndThree() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 3));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getSampleModel()
            instanceof SinglePixelPackedSampleModel);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    assertTrue(softMask.getCOSObject() instanceof COSStream);
    assertTrue(softMask.getColorSpace() instanceof PDDeviceGray);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and two.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); when BufferedImage(int, int, int) with one and one and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenBufferedImageWithOneAndOneAndTwo() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 2));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getSampleModel()
            instanceof SinglePixelPackedSampleModel);
    PDImageXObject softMask = actualCreateFromImageResult.getSoftMask();
    assertTrue(softMask.getCOSObject() instanceof COSStream);
    assertTrue(softMask.getColorSpace() instanceof PDDeviceGray);
  }

  /**
   * Test {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage); when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject LosslessFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_whenPDDocument() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    BufferedImage opaqueImage =
        LosslessFactory.createFromImage(document, new BufferedImage(1, 1, 1)).getOpaqueImage();
    assertTrue(opaqueImage.getColorModel() instanceof DirectColorModel);
    assertTrue(opaqueImage.getSampleModel() instanceof SinglePixelPackedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject() throws IOException {
    // Arrange and Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    assertTrue(
        actualPrepareImageXObjectResult.getOpaqueImage().getSampleModel()
            instanceof PixelInterleavedSampleModel);
    assertTrue(
        actualPrepareImageXObjectResult.getRawRaster().getSampleModel()
            instanceof PixelInterleavedSampleModel);
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));

    // Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(streamCacheCreateFunction),
            "AXAXAXAX".getBytes("UTF-8"),
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    DataBuffer dataBuffer = actualPrepareImageXObjectResult.getRawRaster().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new float[] {0.0f}, colorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, image.getColorModel().getComponentSize());
    assertArrayEquals(
        new int[] {8},
        actualPrepareImageXObjectResult.getOpaqueImage().getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject_givenNull_whenStreamCacheCreateFunctionCreateReturnNull()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    // Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(streamCacheCreateFunction),
            "AXAXAXAX".getBytes("UTF-8"),
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    DataBuffer dataBuffer = actualPrepareImageXObjectResult.getRawRaster().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new float[] {0.0f}, colorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, image.getColorModel().getComponentSize());
    assertArrayEquals(
        new int[] {8},
        actualPrepareImageXObjectResult.getOpaqueImage().getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when 'A'; then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject_whenA_thenCOSObjectReturnCOSStream() throws IOException {
    // Arrange and Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, null);

    // Assert
    COSDictionary cOSObject = actualPrepareImageXObjectResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDStream stream = actualPrepareImageXObjectResult.getStream();
    assertEquals(1, stream.getFilters().size());
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertSame(cOSObject, stream.getCOSObject());
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return Width is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when MIN_VALUE; then return Width is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject_whenMin_value_thenReturnWidthIsMin_value() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(streamCacheCreateFunction),
            "AXAXAXAX".getBytes("UTF-8"),
            Integer.MIN_VALUE,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals(1, actualPrepareImageXObjectResult.getStream().getFilters().size());
    assertEquals(Integer.MIN_VALUE, actualPrepareImageXObjectResult.getWidth());
    PDColor initialColor = colorSpace.getInitialColor();
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.
   *   <li>Then Image ColorModel return {@link DirectColorModel}.
   * </ul>
   *
   * <p>Method under test: {@link LosslessFactory#prepareImageXObject(PDDocument, byte[], int, int,
   * int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace); when PDCalGray(); then Image ColorModel return DirectColorModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject LosslessFactory.prepareImageXObject(PDDocument, byte[], int, int, int, PDColorSpace)"
  })
  void testPrepareImageXObject_whenPDCalGray_thenImageColorModelReturnDirectColorModel()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");

    // Act
    PDImageXObject actualPrepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1, new PDCalGray());

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage image = actualPrepareImageXObjectResult.getImage();
    ColorModel colorModel = image.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    BufferedImage opaqueImage = actualPrepareImageXObjectResult.getOpaqueImage();
    ColorModel colorModel2 = opaqueImage.getColorModel();
    assertTrue(colorModel2 instanceof DirectColorModel);
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    SampleModel sampleModel2 = opaqueImage.getSampleModel();
    assertTrue(sampleModel2 instanceof SinglePixelPackedSampleModel);
    PDColorSpace colorSpace = actualPrepareImageXObjectResult.getColorSpace();
    assertTrue(colorSpace.getCOSObject() instanceof COSArray);
    assertTrue(colorSpace instanceof PDCalGray);
    assertEquals("CalGray", colorSpace.getName());
    assertEquals(1, image.getType());
    assertEquals(1, opaqueImage.getType());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) colorSpace).getGamma());
    assertEquals(colorModel, colorModel2);
    assertEquals(sampleModel, sampleModel2);
  }
}
