package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDLab;
import org.apache.pdfbox.pdmodel.graphics.color.PDTristimulus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDImageXObjectDiffblueTest {
  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return Stream Filters first Name is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList() add A; then return Stream Filters first Name is 'A'")
  void testNewPDImageXObject_givenArrayListAddA_thenReturnStreamFiltersFirstNameIsA() {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream stream = new PDStream(new COSDocument());
    stream.setFilters(filters);

    // Act and Assert
    PDStream stream2 = (new PDImageXObject(stream, new PDResources())).getStream();
    COSBase filters2 = stream2.getCOSObject().getFilters();
    assertTrue(filters2 instanceof COSArray);
    List<COSName> filters3 = stream2.getFilters();
    assertEquals(1, filters3.size());
    COSName getResult = filters3.get(0);
    assertEquals("A", getResult.getName());
    assertNull(getResult.getKey());
    List<? extends COSBase> toListResult = ((COSArray) filters2).toList();
    assertEquals(1, toListResult.size());
    assertFalse(getResult.isDirect());
    assertFalse(getResult.isEmpty());
    assertSame(getResult, toListResult.get(0));
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Suffix is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList() add 'null'; then return Suffix is 'null'")
  void testNewPDImageXObject_givenArrayListAddNull_thenReturnSuffixIsNull() {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    PDStream stream = new PDStream(new COSDocument());
    stream.setFilters(filters);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(stream, new PDResources());

    // Assert
    PDStream stream2 = actualPdImageXObject.getStream();
    COSBase filters2 = stream2.getCOSObject().getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertNull(actualPdImageXObject.getSuffix());
    List<? extends COSBase> toListResult = ((COSArray) filters2).toList();
    assertEquals(1, toListResult.size());
    assertNull(toListResult.get(0));
    List<COSName> filters3 = stream2.getFilters();
    assertEquals(1, filters3.size());
    assertNull(filters3.get(0));
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Suffix is {@code png}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList(); then return Suffix is 'png'")
  void testNewPDImageXObject_givenArrayList_thenReturnSuffixIsPng() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());
    stream.setFilters(new ArrayList<>());

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(stream, new PDResources());

    // Assert
    PDStream stream2 = actualPdImageXObject.getStream();
    COSStream cOSObject = stream2.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSArray);
    assertEquals("png", actualPdImageXObject.getSuffix());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(stream2.getFilters().isEmpty());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link StreamCacheCreateFunction}
   * {@link StreamCacheCreateFunction#create()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  void testNewPDImageXObject_givenNull_whenStreamCacheCreateFunctionCreateReturnNull() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), COSBoolean.FALSE, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPdImageXObject.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPdImageXObject.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPdImageXObject.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Stream Length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); given one; then return Stream Length is zero")
  void testNewPDImageXObject_givenOne_thenReturnStreamLengthIsZero() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, COSBoolean.FALSE, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDStream stream = actualPdImageXObject.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0L, stream.getCOSObject().getLength());
    assertTrue(actualPdImageXObject.isEmpty());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code 4096}.</li>
   *   <li>Then return Width is {@code 4096}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); given one; when '4096'; then return Width is '4096'")
  void testNewPDImageXObject_givenOne_when4096_thenReturnWidthIs4096() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, COSBoolean.FALSE, 4096, 1, 1,
        PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDStream stream = actualPdImageXObject.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0L, stream.getCOSObject().getLength());
    assertEquals(4096, actualPdImageXObject.getWidth());
    assertTrue(actualPdImageXObject.isEmpty());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code A}.</li>
   *   <li>Then return Stream Length is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); given one; when 'A'; then return Stream Length is zero")
  void testNewPDImageXObject_givenOne_whenA_thenReturnStreamLengthIsZero() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream,
        new COSObject(COSBoolean.FALSE,
            new COSParser(new RandomAccessReadBuffer(
                new ByteArrayInputStream(new byte[]{'A', -100, 'A', -100, 'A', -100, 'A', -100})))),
        1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDStream stream = actualPdImageXObject.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0L, stream.getCOSObject().getLength());
    assertTrue(actualPdImageXObject.isEmpty());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then return Width is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); given one; when MIN_VALUE; then return Width is MIN_VALUE")
  void testNewPDImageXObject_givenOne_whenMin_value_thenReturnWidthIsMin_value() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, COSBoolean.FALSE,
        Integer.MIN_VALUE, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    PDStream stream = actualPdImageXObject.getStream();
    assertEquals(0, stream.getLength());
    assertEquals(0L, stream.getCOSObject().getLength());
    assertTrue(actualPdImageXObject.isEmpty());
    assertEquals(Integer.MIN_VALUE, actualPdImageXObject.getWidth());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Then return Stream COSObject Filters is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); then return Stream COSObject Filters is COSDictionary()")
  void testNewPDImageXObject_thenReturnStreamCOSObjectFiltersIsCOSDictionary() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    COSDictionary cosFilter = new COSDictionary();

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, cosFilter, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertSame(cosFilter, actualPdImageXObject.getStream().getCOSObject().getFilters());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Then return Stream COSObject Filters is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); then return Stream COSObject Filters is 'null'")
  void testNewPDImageXObject_thenReturnStreamCOSObjectFiltersIsNull() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act and Assert
    COSStream cOSObject = (new PDImageXObject(stream, new PDResources())).getStream().getCOSObject();
    assertNull(cOSObject.getFilters());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>Then return Stream Length is twenty-four.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); then return Stream Length is twenty-four")
  void testNewPDImageXObject_thenReturnStreamLengthIsTwentyFour() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document,
        new ByteArrayInputStream("AXAXAXAXAXAXAXAXAXAXAXAX".getBytes("UTF-8")), COSBoolean.FALSE, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Assert
    verify(streamCacheCreateFunction).create();
    WritableRaster rawRaster = actualPdImageXObject.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPdImageXObject.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPdImageXObject.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    PDStream stream = actualPdImageXObject.getStream();
    assertEquals(24, stream.getLength());
    assertEquals(24L, stream.getCOSObject().getLength());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.</li>
   *   <li>Then Stream COSObject Filters return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when COSArray(); then Stream COSObject Filters return COSArray")
  void testNewPDImageXObject_whenCOSArray_thenStreamCOSObjectFiltersReturnCOSArray() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    COSArray cosFilter = new COSArray();

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, cosFilter, 1, 1, 1,
        PDDeviceGray.INSTANCE);

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDStream stream = actualPdImageXObject.getStream();
    COSBase filters = stream.getCOSObject().getFilters();
    assertTrue(filters instanceof COSArray);
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(stream.getFilters().isEmpty());
    assertSame(cosFilter, filters);
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDCalGray#PDCalGray()}.</li>
   *   <li>Then ColorSpace COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when PDCalGray(); then ColorSpace COSObject return COSArray")
  void testNewPDImageXObject_whenPDCalGray_thenColorSpaceCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    DataInputStream encodedStream = mock(DataInputStream.class);
    when(encodedStream.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document, encodedStream, COSBoolean.FALSE, 1, 1, 1,
        new PDCalGray());

    // Assert
    verify(encodedStream).transferTo(isA(OutputStream.class));
    verify(streamCacheCreateFunction).create();
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus blackPoint = ((PDCalGray) colorSpace).getBlackPoint();
    COSBase cOSObject2 = blackPoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDTristimulus whitepoint = ((PDCalGray) colorSpace).getWhitepoint();
    COSBase cOSObject3 = whitepoint.getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult3.size());
    COSBase getResult3 = toListResult3.get(0);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(0);
    assertTrue(getResult4 instanceof COSName);
    assertTrue(colorSpace instanceof PDCalGray);
    assertEquals("CalGray", ((COSName) getResult4).getName());
    assertEquals("CalGray", colorSpace.getName());
    COSUpdateState updateState = ((COSDictionary) getResult).getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult4.getKey());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(getResult3.getKey());
    assertEquals(0, ((COSDictionary) getResult).size());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) colorSpace).getGamma());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    COSIncrement toIncrementResult = ((COSDictionary) getResult).toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult4.isDirect());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(((COSName) getResult4).isEmpty());
    assertFalse(((COSDictionary) getResult).isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(((COSDictionary) getResult).getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertSame(getResult3, toListResult3.get(1));
    assertSame(getResult3, toListResult3.get(2));
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then RawRaster Bounds Bounds2D return {@link Rectangle}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when PDDocument(); then RawRaster Bounds Bounds2D return Rectangle")
  void testNewPDImageXObject_whenPDDocument_thenRawRasterBoundsBounds2DReturnRectangle() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), COSBoolean.FALSE, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    WritableRaster rawRaster = actualPdImageXObject.getRawRaster();
    Rectangle bounds = rawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    BufferedImage image = actualPdImageXObject.getImage();
    Raster data = image.getData();
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    BufferedImage opaqueImage = actualPdImageXObject.getOpaqueImage();
    Raster data2 = opaqueImage.getData();
    DataBuffer dataBuffer2 = data2.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    WritableRaster raster = image.getRaster();
    DataBuffer dataBuffer3 = raster.getDataBuffer();
    assertTrue(dataBuffer3 instanceof DataBufferByte);
    WritableRaster raster2 = opaqueImage.getRaster();
    DataBuffer dataBuffer4 = raster2.getDataBuffer();
    assertTrue(dataBuffer4 instanceof DataBufferByte);
    DataBuffer dataBuffer5 = rawRaster.getDataBuffer();
    assertTrue(dataBuffer5 instanceof DataBufferByte);
    SampleModel sampleModel = opaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertTrue(rawRaster.getSampleModel() instanceof PixelInterleavedSampleModel);
    PDColorSpace colorSpace = actualPdImageXObject.getColorSpace();
    assertTrue(colorSpace instanceof PDDeviceGray);
    Point[] writableTileIndices = image.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    Point[] writableTileIndices2 = opaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices2.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer3).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer4).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer5).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, data.getBounds());
    assertEquals(bounds, data2.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, raster2.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, writableTileIndices2[0]);
    FontMetrics expectedFontMetrics = image.getGraphics().getFontMetrics();
    assertSame(expectedFontMetrics, opaqueImage.getGraphics().getFontMetrics());
    assertSame(sampleModel, data2.getSampleModel());
    assertSame(sampleModel, raster2.getSampleModel());
    assertSame(colorSpace, colorSpace.getInitialColor().getColorSpace());
  }

  /**
   * Test
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Stream COSObject Values size is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when PDDocument(); then return Stream COSObject Values size is seven")
  void testNewPDImageXObject_whenPDDocument_thenReturnStreamCOSObjectValuesSizeIsSeven() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    PDStream stream = (new PDImageXObject(document, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
        COSBoolean.FALSE, 1, 1, 1, null)).getStream();
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertEquals(8, stream.getLength());
    assertEquals(8L, cOSObject.getLength());
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDDocument)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Suffix is {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#PDImageXObject(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument); when PDDocument(); then return Suffix is 'png'")
  void testNewPDImageXObject_whenPDDocument_thenReturnSuffixIsPng() throws IOException {
    // Arrange and Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(new PDDocument());

    // Assert
    assertEquals("png", actualPdImageXObject.getSuffix());
    PDStream stream = actualPdImageXObject.getStream();
    assertNull(stream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(actualPdImageXObject.getColorKeyMask());
    assertNull(actualPdImageXObject.getDecode());
    COSStream cOSObject = stream.getCOSObject();
    assertNull(cOSObject.getFilters());
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(stream.getMetadata());
    assertNull(actualPdImageXObject.getMetadata());
    assertNull(stream.getFile());
    assertNull(actualPdImageXObject.getOptionalContent());
    assertNull(actualPdImageXObject.getMask());
    assertNull(actualPdImageXObject.getSoftMask());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, actualPdImageXObject.getBitsPerComponent());
    assertEquals(-1, actualPdImageXObject.getHeight());
    assertEquals(-1, actualPdImageXObject.getStructParent());
    assertEquals(-1, actualPdImageXObject.getWidth());
    assertEquals(0, stream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.hasData());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdImageXObject.getInterpolate());
    assertFalse(actualPdImageXObject.isStencil());
    List<String> fileFilters = stream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdImageXObject.isEmpty());
    assertSame(fileFilters, stream.getFilters());
  }

  /**
   * Test {@link PDImageXObject#createThumbnail(COSStream)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return Suffix is {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createThumbnail(COSStream)}
   */
  @Test
  @DisplayName("Test createThumbnail(COSStream); when COSStream(); then return Suffix is 'png'")
  void testCreateThumbnail_whenCOSStream_thenReturnSuffixIsPng() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    PDImageXObject actualCreateThumbnailResult = PDImageXObject.createThumbnail(cosStream);

    // Assert
    assertEquals("png", actualCreateThumbnailResult.getSuffix());
    PDStream stream = actualCreateThumbnailResult.getStream();
    assertNull(stream.getDecodeParms());
    assertNull(stream.getFileDecodeParams());
    assertNull(actualCreateThumbnailResult.getColorKeyMask());
    assertNull(actualCreateThumbnailResult.getDecode());
    assertNull(stream.getMetadata());
    assertNull(actualCreateThumbnailResult.getMetadata());
    assertNull(stream.getFile());
    assertNull(actualCreateThumbnailResult.getOptionalContent());
    assertNull(actualCreateThumbnailResult.getMask());
    assertNull(actualCreateThumbnailResult.getSoftMask());
    assertEquals(-1, stream.getDecodedStreamLength());
    assertEquals(-1, actualCreateThumbnailResult.getBitsPerComponent());
    assertEquals(-1, actualCreateThumbnailResult.getHeight());
    assertEquals(-1, actualCreateThumbnailResult.getStructParent());
    assertEquals(-1, actualCreateThumbnailResult.getWidth());
    assertEquals(0, stream.getLength());
    assertEquals(3, cosStream.size());
    assertFalse(actualCreateThumbnailResult.getInterpolate());
    assertFalse(actualCreateThumbnailResult.isStencil());
    List<String> fileFilters = stream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertTrue(actualCreateThumbnailResult.isEmpty());
    assertSame(cosStream, stream.getCOSObject());
    assertSame(fileFilters, stream.getFilters());
  }

  /**
   * Test {@link PDImageXObject#createFromFile(String, PDDocument)}.
   * <ul>
   *   <li>When {@code Image Path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createFromFile(String, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFile(String, PDDocument); when 'Image Path'")
  void testCreateFromFile_whenImagePath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PDImageXObject.createFromFile("Image Path", new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFile(String, PDDocument)}.
   * <ul>
   *   <li>When
   * {@code org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createFromFile(String, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFile(String, PDDocument); when 'org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject'")
  void testCreateFromFile_whenOrgApachePdfboxPdmodelGraphicsImagePDImageXObject() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PDImageXObject
        .createFromFile("org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject", new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code jpg} toFile.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'jpg' toFile")
  void testCreateFromFileByExtension_whenPropertyIsJavaIoTmpdirIsJpgToFile() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "jpg").toFile();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PDImageXObject.createFromFileByExtension(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  void testCreateFromFileByExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToFile() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PDImageXObject.createFromFileByExtension(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByContent(File, PDDocument)}.
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromFileByContent(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByContent(File, PDDocument)")
  void testCreateFromFileByContent() throws IOException {
    // Arrange
    File file = Paths
        .get(System.getProperty("java.io.tmpdir"), "Stream ended before file's magic number could be determined.")
        .toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> PDImageXObject.createFromFileByContent(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByContent(File, PDDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromFileByContent(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByContent(File, PDDocument); then throw IllegalArgumentException")
  void testCreateFromFileByContent_thenThrowIllegalArgumentException() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "foo").toFile();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PDImageXObject.createFromFileByContent(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByContent(File, PDDocument)}.
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromFileByContent(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByContent(File, PDDocument); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  void testCreateFromFileByContent_whenPropertyIsJavaIoTmpdirIsTestTxtToFile() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertThrows(IOException.class, () -> PDImageXObject.createFromFileByContent(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'A'; then throw IllegalArgumentException")
  void testCreateFromByteArray_whenA_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PDImageXObject.createFromByteArray(new PDDocument(),
        new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "Name"));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  void testCreateFromByteArray_whenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PDImageXObject.createFromByteArray(document, "AXAXAXAX".getBytes("UTF-8"), "Name"));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when empty array of byte; then throw IllegalArgumentException")
  void testCreateFromByteArray_whenEmptyArrayOfByte_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PDImageXObject.createFromByteArray(new PDDocument(), new byte[]{}, "Name"));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'null'; then throw IllegalArgumentException")
  void testCreateFromByteArray_whenNull_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> PDImageXObject.createFromByteArray(null, "AXAXAXAX".getBytes("UTF-8"), "Name"));
  }

  /**
   * Test {@link PDImageXObject#getMetadata()}.
   * <p>
   * Method under test: {@link PDImageXObject#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata()")
  void testGetMetadata() {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getMetadata());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDStream stream = createThumbnailResult.getStream();
    PDMetadata metadata = stream.getMetadata();
    assertNull(metadata.getDecodeParms());
    PDMetadata metadata2 = createThumbnailResult.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata2.getMetadata());
    assertNull(metadata.getFile());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
    assertSame(str, metadata2.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given 'true'; when COSStream() Direct is 'true'")
  void testSetMetadata_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDStream stream = createThumbnailResult.getStream();
    PDMetadata metadata = stream.getMetadata();
    assertNull(metadata.getDecodeParms());
    PDMetadata metadata2 = createThumbnailResult.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata2.getMetadata());
    assertNull(metadata.getFile());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
    assertSame(str, metadata2.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream Metadata
   * DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then createThumbnail COSStream() Stream Metadata DecodeParms is 'null'")
  void testSetMetadata_thenCreateThumbnailCOSStreamStreamMetadataDecodeParmsIsNull() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    COSStream str = new COSStream();

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDStream stream = createThumbnailResult.getStream();
    PDMetadata metadata = stream.getMetadata();
    assertNull(metadata.getDecodeParms());
    PDMetadata metadata2 = createThumbnailResult.getMetadata();
    assertNull(metadata2.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata2.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata2.getMetadata());
    assertNull(metadata.getFile());
    assertNull(metadata2.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(-1, metadata2.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(0, metadata2.getLength());
    COSStream cOSObject = stream.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
    assertSame(str, metadata2.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); when 'null'")
  void testSetMetadata_whenNull() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setMetadata(null);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>When {@link PDMetadata#PDMetadata(COSStream)} with str is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); when PDMetadata(COSStream) with str is 'null'")
  void testSetMetadata_whenPDMetadataWithStrIsNull() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setMetadata(new PDMetadata((COSStream) null));

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getStructParent()}.
   * <p>
   * Method under test: {@link PDImageXObject#getStructParent()}
   */
  @Test
  @DisplayName("Test getStructParent()")
  void testGetStructParent() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is
   * {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); then createThumbnail COSStream() StructParent is '9000000'")
  void testSetStructParent_thenCreateThumbnailCOSStreamStructParentIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(9000000);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); then createThumbnail COSStream() StructParent is MIN_VALUE")
  void testSetStructParent_thenCreateThumbnailCOSStreamStructParentIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when one; then createThumbnail COSStream() StructParent is one")
  void testSetStructParent_whenOne_thenCreateThumbnailCOSStreamStructParentIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(1);

    // Assert
    assertEquals(1, createThumbnailResult.getStructParent());
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage2() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage3() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage4() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceRGB.INSTANCE)
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray())
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  void testGetImage6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB())
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    DataBuffer dataBuffer = actualImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt3() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 0, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1,
        new PDCalGray());

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetImageWithRectangleInt7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1,
        new PDCalRGB());

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <ul>
   *   <li>Then return Data Bounds Bounds is Data Bounds.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; then return Data Bounds Bounds is Data Bounds")
  void testGetImageWithRectangleInt_thenReturnDataBoundsBoundsIsDataBounds() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE)
        .getImage(null, 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <ul>
   *   <li>Then return first element is Data DataBuffer Data.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; then return first element is Data DataBuffer Data")
  void testGetImageWithRectangleInt_thenReturnFirstElementIsDataDataBufferData() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 2, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{5592405}, data2);
    assertArrayEquals(new int[]{5592405}, data3);
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle},
   * {@code int}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; then throw IOException")
  void testGetImageWithRectangleInt_thenThrowIOException() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, null);

    // Act and Assert
    assertThrows(IOException.class, () -> prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code byte} with minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage(); then return Data DataBuffer Data is array of byte with minus one")
  void testGetImage_thenReturnDataDataBufferDataIsArrayOfByteWithMinusOne() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    DataBuffer dataBuffer = actualImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <ul>
   *   <li>Then return first element is Data DataBuffer Data.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage(); then return first element is Data DataBuffer Data")
  void testGetImage_thenReturnFirstElementIsDataDataBufferData() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 2,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    Raster data = actualImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{5592405}, data2);
    assertArrayEquals(new int[]{5592405}, data3);
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage(); then throw IOException")
  void testGetImage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, null)
            .getImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6,
                PDDeviceGray.INSTANCE)
            .getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  void testGetRawImage2() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertNull(LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalGray())
        .getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage(); given createThumbnail COSStream(); then throw IOException")
  void testGetRawImage_givenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDImageXObject.createThumbnail(new COSStream()).getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster2() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceRGB.INSTANCE)
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray())
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  void testGetRawRaster4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB())
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <ul>
   *   <li>Then DataBuffer return {@link DataBufferUShort}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster(); then DataBuffer return DataBufferUShort")
  void testGetRawRaster_thenDataBufferReturnDataBufferUShort() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12,
            PDDeviceGray.INSTANCE)
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferUShort);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, dataBuffer.getDataType());
    assertEquals(1, actualRawRaster.getTransferType());
    assertEquals(1, sampleModel.getDataType());
    assertEquals(1, sampleModel.getTransferType());
    short[][] bankData = ((DataBufferUShort) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    short[] data = ((DataBufferUShort) dataBuffer).getData();
    assertSame(data, bankData[0]);
    assertArrayEquals(new int[]{Short.SIZE}, sampleModel.getSampleSize());
    assertArrayEquals(new short[]{16644}, data);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <ul>
   *   <li>Then return Bounds CenterX is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster(); then return Bounds CenterX is one")
  void testGetRawRaster_thenReturnBoundsCenterXIsOne() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 2, 1, 1,
            PDDeviceGray.INSTANCE)
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(2, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(2, dataBuffer.getSize());
    assertEquals(2, actualRawRaster.getWidth());
    assertEquals(2, sampleModel.getWidth());
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertEquals(2, data.length);
    Dimension size = bounds.getSize();
    assertEquals(2, size.width);
    assertEquals(2, bounds.width);
    assertEquals(2.0d, size.getWidth());
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds.getMaxX());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertSame(data, bankData[0]);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <ul>
   *   <li>Then return eighth element is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster(); then return eighth element is minus one")
  void testGetRawRaster_thenReturnEighthElementIsMinusOne() throws IOException {
    // Arrange and Act
    WritableRaster actualRawRaster = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 8, 1, 1,
            PDDeviceGray.INSTANCE)
        .getRawRaster();

    // Assert
    Rectangle bounds = actualRawRaster.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    byte[] data = ((DataBufferByte) dataBuffer).getData();
    assertEquals((byte) -1, data[7]);
    assertEquals((byte) 0, data[3]);
    assertEquals((byte) 0, data[4]);
    assertEquals((byte) 0, data[5]);
    assertEquals((byte) 0, data[6]);
    byte[][] bankData = ((DataBufferByte) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, actualRawRaster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, data.length);
    Dimension size = bounds.getSize();
    assertEquals(8, size.width);
    assertEquals(8, bounds.width);
    assertEquals(8.0d, size.getWidth());
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    Point location = bounds.getLocation();
    assertEquals(location, location.getLocation());
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertSame(data, bankData[0]);
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster(); then throw IOException")
  void testGetRawRaster_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, null)
            .getRawRaster());
  }

  /**
   * Test {@link PDImageXObject#getStencilImage(Paint)}.
   * <ul>
   *   <li>When decode {@code 42}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); when decode '42'; then throw IllegalStateException")
  void testGetStencilImage_whenDecode42_thenThrowIllegalStateException() throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> createThumbnailResult.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage2() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage3() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage4() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceRGB.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray())
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB())
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  void testGetOpaqueImage7() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 8, PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    DataBuffer dataBuffer = actualOpaqueImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualOpaqueImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt3() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt4() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt5() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  void testGetOpaqueImageWithRectangleInt8() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        8, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferInt) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferInt) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then return Data Bounds Bounds is Data Bounds.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; then return Data Bounds Bounds is Data Bounds")
  void testGetOpaqueImageWithRectangleInt_thenReturnDataBoundsBoundsIsDataBounds() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage(null, 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then return first element is Data DataBuffer Data.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; then return first element is Data DataBuffer Data")
  void testGetOpaqueImageWithRectangleInt_thenReturnFirstElementIsDataDataBufferData() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{4276545}, data2);
    assertArrayEquals(new int[]{4276545}, data3);
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; then throw IOException")
  void testGetOpaqueImageWithRectangleInt_thenThrowIOException() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, null);

    // Act and Assert
    assertThrows(IOException.class, () -> prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with
   * {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>When twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; when twelve")
  void testGetOpaqueImageWithRectangleInt_whenTwelve() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 12);

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle bounds2 = bounds.getBounds();
    Rectangle bounds3 = bounds2.getBounds();
    Rectangle2D bounds2D = bounds3.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    WritableRaster raster = actualOpaqueImage.getRaster();
    Rectangle bounds4 = raster.getBounds();
    Rectangle bounds5 = bounds4.getBounds();
    Rectangle bounds6 = bounds5.getBounds();
    Rectangle2D bounds2D2 = bounds6.getBounds2D();
    assertTrue(bounds2D2 instanceof Rectangle);
    Rectangle2D bounds2D3 = bounds2.getBounds2D();
    assertTrue(bounds2D3 instanceof Rectangle);
    Rectangle2D bounds2D4 = bounds5.getBounds2D();
    assertTrue(bounds2D4 instanceof Rectangle);
    Rectangle2D bounds2D5 = bounds.getBounds2D();
    assertTrue(bounds2D5 instanceof Rectangle);
    Rectangle2D bounds2D6 = bounds4.getBounds2D();
    assertTrue(bounds2D6 instanceof Rectangle);
    Rectangle2D bounds2D7 = bounds2D5.getBounds2D();
    assertTrue(bounds2D7 instanceof Rectangle);
    Rectangle2D bounds2D8 = bounds2D6.getBounds2D();
    assertTrue(bounds2D8 instanceof Rectangle);
    Rectangle2D frame = bounds2.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    Rectangle2D frame2 = bounds5.getFrame();
    assertTrue(frame2 instanceof Rectangle2D.Double);
    Rectangle2D frame3 = bounds.getFrame();
    assertTrue(frame3 instanceof Rectangle2D.Double);
    Rectangle2D frame4 = bounds4.getFrame();
    assertTrue(frame4 instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    assertEquals(1, ((DataBufferByte) dataBuffer).getBankData().length);
    assertEquals(1, ((DataBufferByte) dataBuffer2).getBankData().length);
    Dimension size = bounds.getSize();
    Rectangle bounds7 = bounds3.getBounds();
    Dimension size2 = bounds7.getSize();
    assertEquals(size, size2.getSize());
    Rectangle bounds8 = bounds6.getBounds();
    assertEquals(size, bounds8.getSize().getSize());
    Rectangle bounds9 = bounds2D5.getBounds();
    assertEquals(size, bounds9.getSize().getSize());
    Rectangle bounds10 = bounds2D6.getBounds();
    assertEquals(size, bounds10.getSize().getSize());
    Rectangle bounds11 = frame3.getBounds();
    assertEquals(size, bounds11.getSize().getSize());
    Rectangle bounds12 = frame4.getBounds();
    assertEquals(size, bounds12.getSize().getSize());
    assertEquals(size, size.getSize());
    assertEquals(size, ((Rectangle) bounds2D3).getSize().getSize());
    assertEquals(size, ((Rectangle) bounds2D4).getSize().getSize());
    Rectangle bounds13 = bounds7.getBounds();
    assertEquals(size, bounds13.getSize());
    Rectangle bounds14 = bounds8.getBounds();
    assertEquals(size, bounds14.getSize());
    assertEquals(size, size2);
    assertEquals(size, bounds3.getSize());
    assertEquals(size, bounds6.getSize());
    Rectangle bounds15 = bounds9.getBounds();
    assertEquals(size, bounds15.getSize());
    Rectangle bounds16 = bounds10.getBounds();
    assertEquals(size, bounds16.getSize());
    Rectangle bounds17 = bounds11.getBounds();
    assertEquals(size, bounds17.getSize());
    Rectangle bounds18 = bounds12.getBounds();
    assertEquals(size, bounds18.getSize());
    assertEquals(size, bounds2.getSize());
    assertEquals(size, bounds5.getSize());
    Rectangle bounds19 = bounds2D3.getBounds();
    assertEquals(size, bounds19.getSize());
    Rectangle bounds20 = bounds2D4.getBounds();
    assertEquals(size, bounds20.getSize());
    Rectangle bounds21 = frame.getBounds();
    assertEquals(size, bounds21.getSize());
    Rectangle bounds22 = frame2.getBounds();
    assertEquals(size, bounds22.getSize());
    assertEquals(size, bounds4.getSize());
    assertEquals(size, ((Rectangle) bounds2D).getSize());
    assertEquals(size, ((Rectangle) bounds2D2).getSize());
    assertEquals(size, ((Rectangle) bounds2D5).getSize());
    assertEquals(size, ((Rectangle) bounds2D6).getSize());
    assertEquals(size, ((Rectangle) bounds2D7).getSize());
    assertEquals(size, ((Rectangle) bounds2D8).getSize());
    Point point = writableTileIndices[0];
    Point location = bounds7.getLocation();
    assertEquals(point, location.getLocation());
    assertEquals(point, bounds8.getLocation().getLocation());
    assertEquals(point, bounds9.getLocation().getLocation());
    assertEquals(point, bounds10.getLocation().getLocation());
    assertEquals(point, bounds11.getLocation().getLocation());
    assertEquals(point, bounds12.getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D3).getLocation().getLocation());
    assertEquals(point, ((Rectangle) bounds2D4).getLocation().getLocation());
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds13.getLocation());
    assertEquals(point, bounds14.getLocation());
    assertEquals(point, location);
    assertEquals(point, bounds3.getLocation());
    assertEquals(point, bounds6.getLocation());
    assertEquals(point, bounds15.getLocation());
    assertEquals(point, bounds16.getLocation());
    assertEquals(point, bounds17.getLocation());
    assertEquals(point, bounds18.getLocation());
    assertEquals(point, bounds2.getLocation());
    assertEquals(point, bounds5.getLocation());
    assertEquals(point, bounds19.getLocation());
    assertEquals(point, bounds20.getLocation());
    assertEquals(point, bounds21.getLocation());
    assertEquals(point, bounds22.getLocation());
    assertEquals(point, bounds.getLocation());
    assertEquals(point, bounds4.getLocation());
    assertEquals(point, ((Rectangle) bounds2D).getLocation());
    assertEquals(point, ((Rectangle) bounds2D2).getLocation());
    assertEquals(point, ((Rectangle) bounds2D5).getLocation());
    assertEquals(point, ((Rectangle) bounds2D6).getLocation());
    assertEquals(point, ((Rectangle) bounds2D7).getLocation());
    assertEquals(point, ((Rectangle) bounds2D8).getLocation());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code byte} with minus
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage(); then return Data DataBuffer Data is array of byte with minus one")
  void testGetOpaqueImage_thenReturnDataDataBufferDataIsArrayOfByteWithMinusOne() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    DataBuffer dataBuffer = actualOpaqueImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualOpaqueImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code int} with
   * {@code 4276545}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage(); then return Data DataBuffer Data is array of int with '4276545'")
  void testGetOpaqueImage_thenReturnDataDataBufferDataIsArrayOfIntWith4276545() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{4276545}, data2);
    assertArrayEquals(new int[]{4276545}, data3);
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <ul>
   *   <li>Then return Data DataBuffer Data is array of {@code int} with
   * {@code 9144472}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage(); then return Data DataBuffer Data is array of int with '9144472'")
  void testGetOpaqueImage_thenReturnDataDataBufferDataIsArrayOfIntWith9144472() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, new PDCalGray())
        .getOpaqueImage();

    // Assert
    Raster data = actualOpaqueImage.getData();
    Rectangle bounds = data.getBounds();
    Rectangle2D bounds2D = bounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle);
    Rectangle2D frame = bounds.getFrame();
    assertTrue(frame instanceof Rectangle2D.Double);
    DataBuffer dataBuffer = data.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferInt);
    WritableRaster raster = actualOpaqueImage.getRaster();
    DataBuffer dataBuffer2 = raster.getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferInt);
    Point[] writableTileIndices = actualOpaqueImage.getWritableTileIndices();
    assertEquals(1, writableTileIndices.length);
    int[][] bankData = ((DataBufferInt) dataBuffer).getBankData();
    assertEquals(1, bankData.length);
    int[][] bankData2 = ((DataBufferInt) dataBuffer2).getBankData();
    assertEquals(1, bankData2.length);
    Dimension size = bounds.getSize();
    assertEquals(size, size.getSize());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, raster.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    Point point = writableTileIndices[0];
    assertEquals(point, point.getLocation());
    assertEquals(point, bounds.getLocation());
    int[] data2 = ((DataBufferInt) dataBuffer).getData();
    assertSame(data2, bankData[0]);
    int[] data3 = ((DataBufferInt) dataBuffer2).getData();
    assertSame(data3, bankData2[0]);
    assertArrayEquals(new int[]{9144472}, data2);
    assertArrayEquals(new int[]{9144472}, data3);
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage(); then throw IOException")
  void testGetOpaqueImage_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, null)
            .getOpaqueImage());
  }

  /**
   * Test {@link PDImageXObject#getMask()}.
   * <p>
   * Method under test: {@link PDImageXObject#getMask()}
   */
  @Test
  @DisplayName("Test getMask()")
  void testGetMask() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getMask());
  }

  /**
   * Test {@link PDImageXObject#getColorKeyMask()}.
   * <p>
   * Method under test: {@link PDImageXObject#getColorKeyMask()}
   */
  @Test
  @DisplayName("Test getColorKeyMask()")
  void testGetColorKeyMask() {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getColorKeyMask());
  }

  /**
   * Test {@link PDImageXObject#getSoftMask()}.
   * <p>
   * Method under test: {@link PDImageXObject#getSoftMask()}
   */
  @Test
  @DisplayName("Test getSoftMask()")
  void testGetSoftMask() throws IOException {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getSoftMask());
  }

  /**
   * Test {@link PDImageXObject#getBitsPerComponent()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); given 'A'; then return six")
  void testGetBitsPerComponent_givenA_thenReturnSix() throws IOException {
    // Arrange, Act and Assert
    assertEquals(6,
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6,
                PDDeviceGray.INSTANCE)
            .getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#getBitsPerComponent()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); given createThumbnail COSStream(); then return minus one")
  void testGetBitsPerComponent_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is
   * {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is '9000000'")
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(9000000);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is
   * forty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is forty-six")
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsFortySix() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(46);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(46, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is MIN_VALUE")
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is one")
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(1);

    // Assert
    assertEquals(1, createThumbnailResult.getBitsPerComponent());
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given createThumbnail COSStream(); then throw IOException")
  void testGetColorSpace_givenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDImageXObject.createThumbnail(new COSStream()).getColorSpace());
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then COSObject toList second return {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then COSObject toList second return COSDictionary")
  void testGetColorSpace_thenCOSObjectToListSecondReturnCOSDictionary() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalRGB())
        .getColorSpace();

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDCalRGB) actualColorSpace).getBlackPoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    COSBase cOSObject3 = ((PDCalRGB) actualColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSDictionary);
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    COSArray cOSArray = gamma.getCOSArray();
    List<? extends COSBase> toListResult2 = cOSArray.toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(0);
    assertTrue(getResult3 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", ((COSName) getResult3).getName());
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult2.getKey());
    assertEquals(1, ((COSDictionary) getResult).getValues().size());
    assertEquals(1, ((COSDictionary) getResult).size());
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult3.size());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    assertEquals(toListResult2, ((COSArray) cOSObject3).toList());
    COSBase getResult4 = toListResult3.get(0);
    assertSame(getResult4, toListResult3.get(1));
    assertSame(getResult4, toListResult3.get(2));
    assertSame(cOSArray, gamma.getCOSObject());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return ARange COSArray toList size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return ARange COSArray toList size is four")
  void testGetColorSpace_thenReturnARangeCOSArrayToListSizeIsFour() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDLab())
        .getColorSpace();

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDLab) actualColorSpace).getBlackPoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    COSBase cOSObject3 = ((PDLab) actualColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    PDRange aRange = ((PDLab) actualColorSpace).getARange();
    COSArray cOSArray = aRange.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult2.size());
    COSBase getResult5 = toListResult2.get(0);
    assertTrue(getResult5 instanceof COSName);
    assertTrue(actualColorSpace instanceof PDLab);
    assertEquals("Lab", ((COSName) getResult5).getName());
    assertEquals("Lab", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = ((PDLab) actualColorSpace).getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult3.size());
    List<? extends COSBase> toListResult4 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult4.size());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(initialColor.isPattern());
    COSArray cOSArray2 = bRange.getCOSArray();
    assertEquals(toListResult, cOSArray2.toList());
    assertEquals(getResult, getResult3);
    assertEquals(getResult2, getResult4);
    COSBase getResult6 = toListResult3.get(0);
    assertSame(getResult6, toListResult3.get(1));
    assertSame(getResult6, toListResult3.get(2));
    COSBase getResult7 = toListResult4.get(0);
    assertSame(getResult7, toListResult4.get(1));
    assertSame(getResult7, toListResult4.get(2));
    assertSame(cOSArray, aRange.getCOSObject());
    assertSame(cOSArray2, bRange.getCOSObject());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  void testGetColorSpace_thenReturnInstance() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6,
            PDDeviceGray.INSTANCE)
        .getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  void testGetColorSpace_thenReturnInstance2() throws IOException {
    // Arrange and Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6,
            PDDeviceRGB.INSTANCE)
        .getColorSpace();

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDCalGray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return PDCalGray")
  void testGetColorSpace_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalGray())
        .getColorSpace();

    // Assert
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = ((PDCalGray) actualColorSpace).getBlackPoint().getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    COSBase cOSObject3 = ((PDCalGray) actualColorSpace).getWhitepoint().getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSName);
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", ((COSName) getResult).getName());
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject3).toList();
    assertEquals(3, toListResult3.size());
    assertFalse(initialColor.isPattern());
    COSBase getResult2 = toListResult2.get(0);
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    COSBase getResult3 = toListResult3.get(0);
    assertSame(getResult3, toListResult3.get(1));
    assertSame(getResult3, toListResult3.get(2));
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#createInputStream(DecodeOptions)} with
   * {@code options}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'; then return read is eight")
  void testCreateInputStreamWithOptions_thenReturnReadIsEight() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE)
            .createInputStream(DecodeOptions.DEFAULT)
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDImageXObject#createInputStream(DecodeOptions)} with
   * {@code options}.
   * <ul>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'; then return read is minus one")
  void testCreateInputStreamWithOptions_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
            .createInputStream(DecodeOptions.DEFAULT)
            .read(new byte[]{}));
  }

  /**
   * Test {@link PDImageXObject#createInputStream(List)} with {@code stopFilters}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'; then return read is eight")
  void testCreateInputStreamWithStopFilters_thenReturnReadIsEight() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8, prepareImageXObjectResult.createInputStream(new ArrayList<>()).read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDImageXObject#createInputStream(List)} with {@code stopFilters}.
   * <ul>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'; then return read is minus one")
  void testCreateInputStreamWithStopFilters_thenReturnReadIsMinusOne() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        1, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertEquals(-1, prepareImageXObjectResult.createInputStream(new ArrayList<>()).read(new byte[]{}));
  }

  /**
   * Test {@link PDImageXObject#createInputStream()}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream()}
   */
  @Test
  @DisplayName("Test createInputStream(); then return read is eight")
  void testCreateInputStream_thenReturnReadIsEight() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        LosslessFactory.prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE)
            .createInputStream()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDImageXObject#createInputStream()}.
   * <ul>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream()}
   */
  @Test
  @DisplayName("Test createInputStream(); then return read is minus one")
  void testCreateInputStream_thenReturnReadIsMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
            .createInputStream()
            .read(new byte[]{}));
  }

  /**
   * Test {@link PDImageXObject#isEmpty()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given 'A'; then return 'false'")
  void testIsEmpty_givenA_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse(
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
                PDDeviceGray.INSTANCE)
            .isEmpty());
  }

  /**
   * Test {@link PDImageXObject#isEmpty()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given createThumbnail COSStream(); then return 'true'")
  void testIsEmpty_givenCreateThumbnailCOSStream_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(PDImageXObject.createThumbnail(new COSStream()).isEmpty());
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  void testSetColorSpace() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setColorSpace(new PDCalGray());

    // Assert
    PDColorSpace colorSpace = createThumbnailResult.getColorSpace();
    PDTristimulus blackPoint = ((PDCalGray) colorSpace).getBlackPoint();
    assertTrue(blackPoint.getCOSObject() instanceof COSArray);
    PDTristimulus whitepoint = ((PDCalGray) colorSpace).getWhitepoint();
    assertTrue(whitepoint.getCOSObject() instanceof COSArray);
    assertTrue(colorSpace instanceof PDCalGray);
    assertEquals("CalGray", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) colorSpace).getGamma());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject
   * Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); then createThumbnail COSStream() Stream COSObject Values size is four")
  void testSetColorSpace_thenCreateThumbnailCOSStreamStreamCOSObjectValuesSizeIsFour() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    PDDeviceGray cs = PDDeviceGray.INSTANCE;

    // Act
    createThumbnailResult.setColorSpace(cs);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    PDDeviceGray expectedColorSpace = cs.INSTANCE;
    assertSame(expectedColorSpace, createThumbnailResult.getColorSpace());
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject
   * Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); then createThumbnail COSStream() Stream COSObject Values size is three")
  void testSetColorSpace_thenCreateThumbnailCOSStreamStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setColorSpace(null);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getHeight()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); given 'A'")
  void testGetHeight_givenA() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, 1, -1, -1,
                PDDeviceGray.INSTANCE)
            .getHeight());
  }

  /**
   * Test {@link PDImageXObject#getHeight()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); given createThumbnail COSStream()")
  void testGetHeight_givenCreateThumbnailCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   * <ul>
   *   <li>When {@code 9000000}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is
   * {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when '9000000'; then createThumbnail COSStream() Height is '9000000'")
  void testSetHeight_when9000000_thenCreateThumbnailCOSStreamHeightIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(9000000);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when MIN_VALUE; then createThumbnail COSStream() Height is MIN_VALUE")
  void testSetHeight_whenMin_value_thenCreateThumbnailCOSStreamHeightIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when one; then createThumbnail COSStream() Height is one")
  void testSetHeight_whenOne_thenCreateThumbnailCOSStreamHeightIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(1);

    // Assert
    assertEquals(1, createThumbnailResult.getHeight());
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getWidth()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given 'A'; then return one")
  void testGetWidth_givenA_thenReturnOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(1,
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1}, 1, -1, -1,
                PDDeviceGray.INSTANCE)
            .getWidth());
  }

  /**
   * Test {@link PDImageXObject#getWidth()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given createThumbnail COSStream(); then return minus one")
  void testGetWidth_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   * <ul>
   *   <li>When {@code 9000000}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is
   * {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when '9000000'; then createThumbnail COSStream() Width is '9000000'")
  void testSetWidth_when9000000_thenCreateThumbnailCOSStreamWidthIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(9000000);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when MIN_VALUE; then createThumbnail COSStream() Width is MIN_VALUE")
  void testSetWidth_whenMin_value_thenCreateThumbnailCOSStreamWidthIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when one; then createThumbnail COSStream() Width is one")
  void testSetWidth_whenOne_thenCreateThumbnailCOSStreamWidthIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(1);

    // Assert
    assertEquals(1, createThumbnailResult.getWidth());
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getInterpolate()}.
   * <p>
   * Method under test: {@link PDImageXObject#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate()")
  void testGetInterpolate() {
    // Arrange, Act and Assert
    assertFalse(PDImageXObject.createThumbnail(new COSStream()).getInterpolate());
  }

  /**
   * Test {@link PDImageXObject#setInterpolate(boolean)}.
   * <p>
   * Method under test: {@link PDImageXObject#setInterpolate(boolean)}
   */
  @Test
  @DisplayName("Test setInterpolate(boolean)")
  void testSetInterpolate() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setInterpolate(true);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(createThumbnailResult.getInterpolate());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject
   * Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray); then createThumbnail COSStream() Stream COSObject Values size is four")
  void testSetDecode_thenCreateThumbnailCOSStreamStreamCOSObjectValuesSizeIsFour() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    COSArray decode = new COSArray();

    // Act
    createThumbnailResult.setDecode(decode);

    // Assert
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(decode, createThumbnailResult.getDecode());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Decode is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray); when 'null'; then createThumbnail COSStream() Decode is 'null'")
  void testSetDecode_whenNull_thenCreateThumbnailCOSStreamDecodeIsNull() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setDecode(null);

    // Assert
    assertNull(createThumbnailResult.getDecode());
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getDecode()}.
   * <p>
   * Method under test: {@link PDImageXObject#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode()")
  void testGetDecode() {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getDecode());
  }

  /**
   * Test {@link PDImageXObject#isStencil()}.
   * <p>
   * Method under test: {@link PDImageXObject#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil()")
  void testIsStencil() {
    // Arrange, Act and Assert
    assertFalse(PDImageXObject.createThumbnail(new COSStream()).isStencil());
  }

  /**
   * Test {@link PDImageXObject#setStencil(boolean)}.
   * <p>
   * Method under test: {@link PDImageXObject#setStencil(boolean)}
   */
  @Test
  @DisplayName("Test setStencil(boolean)")
  void testSetStencil() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStencil(true);

    // Assert
    PDColorSpace colorSpace = createThumbnailResult.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", ((COSName) cOSObject).getName());
    assertEquals("DeviceGray", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1, createThumbnailResult.getBitsPerComponent());
    COSStream cOSObject2 = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject2.getValues().size());
    assertEquals(4, cOSObject2.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertTrue(createThumbnailResult.isStencil());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getSuffix()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given 'A'")
  void testGetSuffix_givenA() throws IOException {
    // Arrange, Act and Assert
    assertEquals("png",
        LosslessFactory
            .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
                PDDeviceGray.INSTANCE)
            .getSuffix());
  }

  /**
   * Test {@link PDImageXObject#getSuffix()}.
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given createThumbnail COSStream()")
  void testGetSuffix_givenCreateThumbnailCOSStream() {
    // Arrange, Act and Assert
    assertEquals("png", PDImageXObject.createThumbnail(new COSStream()).getSuffix());
  }

  /**
   * Test {@link PDImageXObject#getOptionalContent()}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOptionalContent()}
   */
  @Test
  @DisplayName("Test getOptionalContent(); then return COSObject is COSDictionary()")
  void testGetOptionalContent_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSStream cosStream = mock(COSStream.class);
    when(cosStream.getFilters()).thenReturn(COSBoolean.FALSE);
    COSDictionary cosDictionary = new COSDictionary();
    when(cosStream.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(cosStream).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    COSDictionary actualCOSObject = PDImageXObject.createThumbnail(cosStream).getOptionalContent().getCOSObject();

    // Assert
    verify(cosStream).getCOSDictionary(isA(COSName.class));
    verify(cosStream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(cosStream).getFilters();
    assertSame(cosDictionary, actualCOSObject);
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   * <p>
   * Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  void testSetOptionalContent() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   * <p>
   * Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  void testSetOptionalContent2() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSDictionary cosDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    cosDictionary.setKey(key);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    assertSame(key, createThumbnailResult.getOptionalContent().getCOSObject().getKey());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  void testSetOptionalContent_givenCOSDictionary() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, createThumbnailResult.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  void testSetOptionalContent_givenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSDictionary cosDictionary = new COSDictionary();
    cosDictionary.setDirect(true);
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(cosDictionary);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert
    verify(oc).getCOSObject();
    COSStream cOSObject = createThumbnailResult.getStream().getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, createThumbnailResult.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); then throw IllegalArgumentException")
  void testSetOptionalContent_thenThrowIllegalArgumentException() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> createThumbnailResult.setOptionalContent(oc));
    verify(oc).getCOSObject();
  }
}
