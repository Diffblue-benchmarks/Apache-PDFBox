package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CCITTFactoryDiffblueTest {
  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName("Test createFromImage(PDDocument, BufferedImage)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        CCITTFactory.createFromImage(
            document, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    DataBuffer dataBuffer = actualCreateFromImageResult.getRawRaster().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new float[] {0.0f}, colorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, image.getColorModel().getComponentSize());
    assertArrayEquals(
        new int[] {8},
        actualCreateFromImageResult.getOpaqueImage().getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then RawRaster DataBuffer return {@link DataBufferByte}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); given 'null'; then RawRaster DataBuffer return DataBufferByte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_givenNull_thenRawRasterDataBufferReturnDataBufferByte()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        CCITTFactory.createFromImage(
            document, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    DataBuffer dataBuffer = actualCreateFromImageResult.getRawRaster().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage image = actualCreateFromImageResult.getImage();
    SampleModel sampleModel = image.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualCreateFromImageResult.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertArrayEquals(new byte[] {0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new float[] {0.0f}, colorSpace.getInitialColor().getComponents(), 0.0f);
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[] {0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[] {0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[] {8}, image.getColorModel().getComponentSize());
    assertArrayEquals(
        new int[] {8},
        actualCreateFromImageResult.getOpaqueImage().getColorModel().getComponentSize());
    assertArrayEquals(new int[] {8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then OpaqueImage SampleModel return {@link PixelInterleavedSampleModel}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then OpaqueImage SampleModel return PixelInterleavedSampleModel")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenOpaqueImageSampleModelReturnPixelInterleavedSampleModel()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualCreateFromImageResult =
        CCITTFactory.createFromImage(
            document, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    assertTrue(
        actualCreateFromImageResult.getOpaqueImage().getSampleModel()
            instanceof PixelInterleavedSampleModel);
    assertTrue(
        actualCreateFromImageResult.getRawRaster().getSampleModel()
            instanceof PixelInterleavedSampleModel);
  }

  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then return Image TileWidth is eight.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then return Image TileWidth is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenReturnImageTileWidthIsEight() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        CCITTFactory.createFromImage(
            document, new BufferedImage(8, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getSampleModel() instanceof PixelInterleavedSampleModel);
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertEquals(8, image.getTileWidth());
    assertEquals(8, opaqueImage.getTileWidth());
    assertEquals(8, image.getWidth());
    assertEquals(8, opaqueImage.getWidth());
    assertEquals(8, rawRaster.getWidth());
    assertEquals(8, actualCreateFromImageResult.getWidth());
  }

  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then return Image TileWidth is twelve.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then return Image TileWidth is twelve")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenReturnImageTileWidthIsTwelve() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualCreateFromImageResult =
        CCITTFactory.createFromImage(
            document,
            new BufferedImage(BufferedImage.TYPE_BYTE_BINARY, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(streamCacheCreateFunction).create();
    BufferedImage opaqueImage = actualCreateFromImageResult.getOpaqueImage();
    assertTrue(opaqueImage.getSampleModel() instanceof PixelInterleavedSampleModel);
    WritableRaster rawRaster = actualCreateFromImageResult.getRawRaster();
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    BufferedImage image = actualCreateFromImageResult.getImage();
    assertEquals(12, image.getTileWidth());
    assertEquals(12, opaqueImage.getTileWidth());
    assertEquals(12, image.getWidth());
    assertEquals(12, opaqueImage.getWidth());
    assertEquals(12, rawRaster.getWidth());
    assertEquals(12, actualCreateFromImageResult.getWidth());
  }

  /**
   * Test {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromImage(PDDocument, BufferedImage)}
   */
  @Test
  @DisplayName(
      "Test createFromImage(PDDocument, BufferedImage); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromImage(PDDocument, BufferedImage)"})
  void testCreateFromImage_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> CCITTFactory.createFromImage(document, new BufferedImage(1, 1, 1)));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)} with {@code document},
   * {@code byteArray}, {@code number}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], int) with 'document', 'byteArray', 'number'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[], int)"})
  void testCreateFromByteArrayWithDocumentByteArrayNumber_whenAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)} with {@code document},
   * {@code byteArray}, {@code number}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], int) with 'document', 'byteArray', 'number'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[], int)"})
  void testCreateFromByteArrayWithDocumentByteArrayNumber_whenEmptyArrayOfByte()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(), new byte[] {}, 10));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)} with {@code document},
   * {@code byteArray}, {@code number}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[], int)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], int) with 'document', 'byteArray', 'number'; when 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[], int)"})
  void testCreateFromByteArrayWithDocumentByteArrayNumber_whenXxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(), "XXAXAXAX".getBytes("UTF-8"), 10));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[])} with {@code document}, {@code
   * byteArray}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[]) with 'document', 'byteArray'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[])"})
  void testCreateFromByteArrayWithDocumentByteArray_whenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(), "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[])} with {@code document}, {@code
   * byteArray}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[]) with 'document', 'byteArray'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[])"})
  void testCreateFromByteArrayWithDocumentByteArray_whenEmptyArrayOfByte() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> CCITTFactory.createFromByteArray(new PDDocument(), new byte[] {}));
  }

  /**
   * Test {@link CCITTFactory#createFromByteArray(PDDocument, byte[])} with {@code document}, {@code
   * byteArray}.
   *
   * <ul>
   *   <li>When {@code XXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFactory#createFromByteArray(PDDocument, byte[])}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[]) with 'document', 'byteArray'; when 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject CCITTFactory.createFromByteArray(PDDocument, byte[])"})
  void testCreateFromByteArrayWithDocumentByteArray_whenXxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> CCITTFactory.createFromByteArray(new PDDocument(), "XXAXAXAX".getBytes("UTF-8")));
  }
}
