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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_ProfileGray;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.filter.DecodeOptions;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDImageXObjectDiffblueTest {
  /**
   * Test {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <p>
   * Method under test: {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)"})
  void testNewPDImageXObject() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(document,
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), COSBoolean.FALSE, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Assert
    BufferedImage opaqueImage = actualPdImageXObject.getOpaqueImage();
    assertTrue(opaqueImage.getSampleModel() instanceof PixelInterleavedSampleModel);
    assertTrue(actualPdImageXObject.getRawRaster().getSampleModel() instanceof PixelInterleavedSampleModel);
    assertEquals(1, actualPdImageXObject.getImage().getWritableTileIndices().length);
    assertEquals(1, opaqueImage.getWritableTileIndices().length);
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.</li>
   *   <li>Then return Stream Filters first Name is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList() add A; then return Stream Filters first Name is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
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
   * Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList() add 'null'; then return Suffix is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
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
   * Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); given ArrayList(); then return Suffix is 'png'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
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
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   * <ul>
   *   <li>Then return Stream COSObject Filters is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDStream, PDResources); then return Stream COSObject Filters is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
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
   * Test {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}.
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return Stream COSObject Values size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName("Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when PDDocument(); then return Stream COSObject Values size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.<init>(PDDocument)"})
  void testNewPDImageXObject_whenPDDocument_thenReturnSuffixIsPng() throws IOException {
    // Arrange and Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(new PDDocument());

    // Assert
    assertEquals("png", actualPdImageXObject.getSuffix());
    assertNull(actualPdImageXObject.getColorKeyMask());
    assertNull(actualPdImageXObject.getDecode());
    assertNull(actualPdImageXObject.getMetadata());
    assertNull(actualPdImageXObject.getOptionalContent());
    assertNull(actualPdImageXObject.getMask());
    assertNull(actualPdImageXObject.getSoftMask());
    assertEquals(-1, actualPdImageXObject.getBitsPerComponent());
    assertEquals(-1, actualPdImageXObject.getHeight());
    assertEquals(-1, actualPdImageXObject.getStructParent());
    assertEquals(-1, actualPdImageXObject.getWidth());
    assertFalse(actualPdImageXObject.getInterpolate());
    assertFalse(actualPdImageXObject.isStencil());
    assertTrue(actualPdImageXObject.isEmpty());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createThumbnail(COSStream)"})
  void testCreateThumbnail_whenCOSStream_thenReturnSuffixIsPng() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    PDImageXObject actualCreateThumbnailResult = PDImageXObject.createThumbnail(cosStream);

    // Assert
    assertEquals("png", actualCreateThumbnailResult.getSuffix());
    assertNull(actualCreateThumbnailResult.getColorKeyMask());
    assertNull(actualCreateThumbnailResult.getDecode());
    assertNull(actualCreateThumbnailResult.getMetadata());
    assertNull(actualCreateThumbnailResult.getOptionalContent());
    assertNull(actualCreateThumbnailResult.getMask());
    assertNull(actualCreateThumbnailResult.getSoftMask());
    assertEquals(-1, actualCreateThumbnailResult.getBitsPerComponent());
    assertEquals(-1, actualCreateThumbnailResult.getHeight());
    assertEquals(-1, actualCreateThumbnailResult.getStructParent());
    assertEquals(-1, actualCreateThumbnailResult.getWidth());
    assertEquals(3, cosStream.size());
    assertFalse(actualCreateThumbnailResult.getInterpolate());
    assertFalse(actualCreateThumbnailResult.isStencil());
    assertTrue(actualCreateThumbnailResult.isEmpty());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFile(String, PDDocument)"})
  void testCreateFromFile_whenImagePath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> PDImageXObject.createFromFile("Image Path", new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFile(String, PDDocument)}.
   * <ul>
   *   <li>When {@code PDImageXObject}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createFromFile(String, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFile(String, PDDocument); when 'org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFile(String, PDDocument)"})
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
   * Method under test: {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'jpg' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByExtension(File, PDDocument)"})
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
   * Method under test: {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByExtension(File, PDDocument)"})
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
   * Method under test: {@link PDImageXObject#createFromFileByContent(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByContent(File, PDDocument)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByContent(File, PDDocument)"})
  void testCreateFromFileByContent() throws IOException {
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
   * Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'A'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"})
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
   * Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"})
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
   * Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when empty array of byte; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"})
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
   * Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName("Test createFromByteArray(PDDocument, byte[], String); when 'null'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDMetadata PDImageXObject.getMetadata()"})
  void testGetMetadata() {
    // Arrange, Act and Assert
    assertNull(PDImageXObject.createThumbnail(new COSStream()).getMetadata());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertSame(str, metadata.getCOSObject());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Metadata DecodeParms is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); then createThumbnail COSStream() Metadata DecodeParms is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_thenCreateThumbnailCOSStreamMetadataDecodeParmsIsNull() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    COSStream str = new COSStream();

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#getStructParent()}.
   * <p>
   * Method under test: {@link PDImageXObject#getStructParent()}
   */
  @Test
  @DisplayName("Test getStructParent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getStructParent()"})
  void testGetStructParent() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); then createThumbnail COSStream() StructParent is '9000000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); then createThumbnail COSStream() StructParent is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName("Test setStructParent(int); when one; then createThumbnail COSStream() StructParent is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage2() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage3() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage4() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 2,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage5() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceRGB.INSTANCE)
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray())
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB())
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 0, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt4() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 2, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt5() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1,
        new PDCalGray());

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    byte[] byteArray = "AXAXAXAX".getBytes("UTF-8");
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document, byteArray, 1, 1, 1,
        new PDCalRGB());

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt8() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(document, "AXAXAXAX".getBytes("UTF-8"), 1, 1, 1, PDDeviceGray.INSTANCE)
        .getImage(null, 1);

    // Assert
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualImage.getData().getSampleModel());
    assertSame(sampleModel, actualImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; given 'A'; then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
  void testGetImageWithRectangleInt_givenA_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualImage = prepareImageXObjectResult.getImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileGray);
    DataBuffer dataBuffer = actualImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getImage(Rectangle, int) with 'Rectangle', 'int'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage(Rectangle, int)"})
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
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getImage()}
   */
  @Test
  @DisplayName("Test getImage(); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
  void testGetImage_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange and Act
    BufferedImage actualImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getImage();

    // Assert
    ColorModel colorModel = actualImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileGray);
    DataBuffer dataBuffer = actualImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getRawImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getRawImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getRawImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0, 0, 0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0, 1, 2}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferUShort);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1, dataBuffer.getDataType());
    assertEquals(1, actualRawRaster.getTransferType());
    assertEquals(1, sampleModel.getDataType());
    assertEquals(1, sampleModel.getTransferType());
    assertEquals(1, ((DataBufferUShort) dataBuffer).getBankData().length);
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{Short.SIZE}, sampleModel.getSampleSize());
    assertArrayEquals(new short[]{16644}, ((DataBufferUShort) dataBuffer).getData());
  }

  /**
   * Test {@link PDImageXObject#getRawRaster()}.
   * <ul>
   *   <li>Then return Bounds CenterX is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getRawRaster()}
   */
  @Test
  @DisplayName("Test getRawRaster(); then return Bounds CenterX is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
  void testGetRawRaster_thenReturnBoundsCenterXIsFour() throws IOException {
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(4.0d, bounds.getCenterX());
    assertEquals(8, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(8, dataBuffer.getSize());
    assertEquals(8, actualRawRaster.getWidth());
    assertEquals(8, sampleModel.getWidth());
    assertEquals(8, bounds.width);
    assertEquals(8.0d, bounds.getWidth());
    assertEquals(8.0d, bounds.getMaxX());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1, 0, 0, 0, 0, 0, -1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
    assertTrue(frame instanceof Double);
    DataBuffer dataBuffer = actualRawRaster.getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    SampleModel sampleModel = actualRawRaster.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertEquals(1.0d, bounds.getCenterX());
    assertEquals(2, ((PixelInterleavedSampleModel) sampleModel).getScanlineStride());
    assertEquals(2, dataBuffer.getSize());
    assertEquals(2, actualRawRaster.getWidth());
    assertEquals(2, sampleModel.getWidth());
    assertEquals(2, bounds.width);
    assertEquals(2.0d, bounds.getWidth());
    assertEquals(2.0d, bounds.getMaxX());
    assertEquals(bounds, bounds.getBounds());
    assertEquals(bounds, bounds2D);
    assertEquals(bounds, frame);
    assertArrayEquals(new byte[]{0, -1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WritableRaster PDImageXObject.getRawRaster()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getStencilImage(Paint)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage2() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 1, PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage3() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage4() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage5() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceRGB.INSTANCE)
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray())
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB())
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage8() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1, 8, PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage9() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, new PDCalGray())
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt3() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 12, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt4() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 0, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt5() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceRGB.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt6() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalGray());

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(document,
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, new PDCalRGB());

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt8() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(), new byte[]{}, 1, 1,
        8, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    assertTrue(colorModel instanceof DirectColorModel);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof SinglePixelPackedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((DirectColorModel) colorModel).getMasks());
    assertArrayEquals(new int[]{16711680, 65280, 255}, ((SinglePixelPackedSampleModel) sampleModel).getBitMasks());
    assertArrayEquals(new int[]{8, 8, 8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8, 8, 8}, sampleModel.getSampleSize());
    assertArrayEquals(new int[]{Short.SIZE, 8, 0}, ((SinglePixelPackedSampleModel) sampleModel).getBitOffsets());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1);

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileGray);
    DataBuffer dataBuffer = actualOpaqueImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualOpaqueImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt_thenThrowIOException() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, null);

    // Act and Assert
    assertThrows(IOException.class, () -> prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 1));
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt_whenNull() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage(null, 1);

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage(Rectangle, int)} with {@code Rectangle}, {@code int}.
   * <ul>
   *   <li>When twelve.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage(Rectangle, int)}
   */
  @Test
  @DisplayName("Test getOpaqueImage(Rectangle, int) with 'Rectangle', 'int'; when twelve")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage(Rectangle, int)"})
  void testGetOpaqueImageWithRectangleInt_whenTwelve() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult = LosslessFactory.prepareImageXObject(new PDDocument(),
        new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1, PDDeviceGray.INSTANCE);

    // Act
    BufferedImage actualOpaqueImage = prepareImageXObjectResult.getOpaqueImage(new Rectangle(1, 1), 12);

    // Assert
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertSame(sampleModel, actualOpaqueImage.getData().getSampleModel());
    assertSame(sampleModel, actualOpaqueImage.getRaster().getSampleModel());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{8}, actualOpaqueImage.getColorModel().getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
  }

  /**
   * Test {@link PDImageXObject#getOpaqueImage()}.
   * <ul>
   *   <li>Then ColorModel ColorSpace return {@link ICC_ColorSpace}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getOpaqueImage()}
   */
  @Test
  @DisplayName("Test getOpaqueImage(); then ColorModel ColorSpace return ICC_ColorSpace")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
  void testGetOpaqueImage_thenColorModelColorSpaceReturnICC_ColorSpace() throws IOException {
    // Arrange and Act
    BufferedImage actualOpaqueImage = LosslessFactory
        .prepareImageXObject(new PDDocument(), new byte[]{-1, 1, 'A', 1, 'A', 1, 'A', 1}, 1, 1, 1,
            PDDeviceGray.INSTANCE)
        .getOpaqueImage();

    // Assert
    ColorModel colorModel = actualOpaqueImage.getColorModel();
    ColorSpace colorSpace = colorModel.getColorSpace();
    assertTrue(colorSpace instanceof ICC_ColorSpace);
    assertTrue(((ICC_ColorSpace) colorSpace).getProfile() instanceof ICC_ProfileGray);
    DataBuffer dataBuffer = actualOpaqueImage.getData().getDataBuffer();
    assertTrue(dataBuffer instanceof DataBufferByte);
    DataBuffer dataBuffer2 = actualOpaqueImage.getRaster().getDataBuffer();
    assertTrue(dataBuffer2 instanceof DataBufferByte);
    SampleModel sampleModel = actualOpaqueImage.getSampleModel();
    assertTrue(sampleModel instanceof PixelInterleavedSampleModel);
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer).getData());
    assertArrayEquals(new byte[]{-1}, ((DataBufferByte) dataBuffer2).getData());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBandOffsets());
    assertArrayEquals(new int[]{0}, ((PixelInterleavedSampleModel) sampleModel).getBankIndices());
    assertArrayEquals(new int[]{0}, dataBuffer.getOffsets());
    assertArrayEquals(new int[]{0}, dataBuffer2.getOffsets());
    assertArrayEquals(new int[]{8}, colorModel.getComponentSize());
    assertArrayEquals(new int[]{8}, sampleModel.getSampleSize());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BufferedImage PDImageXObject.getOpaqueImage()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.getMask()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDImageXObject.getColorKeyMask()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDImageXObject PDImageXObject.getSoftMask()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getBitsPerComponent()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getBitsPerComponent()"})
  void testGetBitsPerComponent_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is '9000000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is forty-six.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is forty-six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_givenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDImageXObject.createThumbnail(new COSStream()).getColorSpace());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalGray())
        .getColorSpace();

    // Assert
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDCalRGB}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return PDCalRGB")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnPDCalRGB() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalRGB())
        .getColorSpace();

    // Assert
    assertTrue(actualColorSpace instanceof PDCalRGB);
    assertEquals("CalRGB", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDGamma gamma = ((PDCalRGB) actualColorSpace).getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   * <ul>
   *   <li>Then return {@link PDLab}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return PDLab")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnPDLab() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDColorSpace actualColorSpace = LosslessFactory
        .prepareImageXObject(document, new byte[]{'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDLab())
        .getColorSpace();

    // Assert
    assertTrue(actualColorSpace instanceof PDLab);
    assertEquals("Lab", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    PDRange aRange = ((PDLab) actualColorSpace).getARange();
    assertEquals(-100.0f, aRange.getMin());
    PDRange bRange = ((PDLab) actualColorSpace).getBRange();
    assertEquals(-100.0f, bRange.getMin());
    assertEquals(100.0f, aRange.getMax());
    assertEquals(100.0f, bRange.getMax());
    assertEquals(3, actualColorSpace.getNumberOfComponents());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#createInputStream(DecodeOptions)} with {@code options}.
   * <ul>
   *   <li>Then return read is eight.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'; then return read is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream(DecodeOptions)"})
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
   * Test {@link PDImageXObject#createInputStream(DecodeOptions)} with {@code options}.
   * <ul>
   *   <li>Then return read is minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'; then return read is minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream(DecodeOptions)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream(List)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"InputStream PDImageXObject.createInputStream()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDImageXObject.isEmpty()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDImageXObject.isEmpty()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setColorSpace(PDColorSpace)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); then createThumbnail COSStream() Stream COSObject Values size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setColorSpace(PDColorSpace)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); then createThumbnail COSStream() Stream COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setColorSpace(PDColorSpace)"})
  void testSetColorSpace_thenCreateThumbnailCOSStreamStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setColorSpace(null);

    // Assert that nothing has changed
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getHeight()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getHeight()"})
  void testGetHeight_givenCreateThumbnailCOSStream() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   * <ul>
   *   <li>When {@code 9000000}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when '9000000'; then createThumbnail COSStream() Height is '9000000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when MIN_VALUE; then createThumbnail COSStream() Height is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getWidth()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDImageXObject.getWidth()"})
  void testGetWidth_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, PDImageXObject.createThumbnail(new COSStream()).getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   * <ul>
   *   <li>When {@code 9000000}.</li>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is {@code 9000000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when '9000000'; then createThumbnail COSStream() Width is '9000000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when MIN_VALUE; then createThumbnail COSStream() Width is MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDImageXObject.getInterpolate()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setInterpolate(boolean)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject Values size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray); then createThumbnail COSStream() Stream COSObject Values size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
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
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Stream COSObject Values size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray); then createThumbnail COSStream() Stream COSObject Values size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
  void testSetDecode_thenCreateThumbnailCOSStreamStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setDecode(null);

    // Assert that nothing has changed
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDImageXObject.getDecode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDImageXObject.isStencil()"})
  void testIsStencil() {
    // Arrange, Act and Assert
    assertFalse(PDImageXObject.createThumbnail(new COSStream()).isStencil());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDImageXObject.getSuffix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDImageXObject.getSuffix()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDPropertyList PDImageXObject.getOptionalContent()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert that nothing has changed
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
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
