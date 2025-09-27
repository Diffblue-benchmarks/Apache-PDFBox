package org.apache.pdfbox.pdmodel.graphics.image;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Color;
import java.awt.Paint;
import java.awt.image.PixelInterleavedSampleModel;
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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.apache.pdfbox.pdmodel.graphics.color.PDTristimulus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDImageXObjectDiffblueTest {
  /**
   * Test {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int,
   * PDColorSpace)}.
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase,
   * int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDImageXObject.<init>(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)"
  })
  void testNewPDImageXObject() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualPdImageXObject =
        new PDImageXObject(
            document,
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            COSBoolean.FALSE,
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Assert
    assertTrue(
        actualPdImageXObject.getOpaqueImage().getSampleModel()
            instanceof PixelInterleavedSampleModel);
    assertTrue(
        actualPdImageXObject.getRawRaster().getSampleModel()
            instanceof PixelInterleavedSampleModel);
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSName#A}.
   *   <li>Then return Stream Filters first Name is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDStream, PDResources); given ArrayList() add A; then return Stream Filters first Name is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
  void testNewPDImageXObject_givenArrayListAddA_thenReturnStreamFiltersFirstNameIsA() {
    // Arrange
    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    PDStream stream = new PDStream(new COSDocument());
    stream.setFilters(filters);

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(stream, new PDResources());

    // Assert
    COSDictionary cOSObject = actualPdImageXObject.getCOSObject();
    COSBase filters2 = ((COSStream) cOSObject).getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertTrue(cOSObject instanceof COSStream);
    List<COSName> filters3 = actualPdImageXObject.getStream().getFilters();
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Suffix is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDStream, PDResources); given ArrayList() add 'null'; then return Suffix is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    COSDictionary cOSObject = actualPdImageXObject.getCOSObject();
    COSBase filters2 = ((COSStream) cOSObject).getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertTrue(cOSObject instanceof COSStream);
    assertNull(actualPdImageXObject.getSuffix());
    List<? extends COSBase> toListResult = ((COSArray) filters2).toList();
    assertEquals(1, toListResult.size());
    assertNull(toListResult.get(0));
    List<COSName> filters3 = actualPdImageXObject.getStream().getFilters();
    assertEquals(1, filters3.size());
    assertNull(filters3.get(0));
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return Suffix is {@code png}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDStream, PDResources); given ArrayList(); then return Suffix is 'png'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
  void testNewPDImageXObject_givenArrayList_thenReturnSuffixIsPng() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());
    stream.setFilters(new ArrayList<>());

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(stream, new PDResources());

    // Assert
    COSDictionary cOSObject = actualPdImageXObject.getCOSObject();
    COSBase filters = ((COSStream) cOSObject).getFilters();
    assertTrue(filters instanceof COSArray);
    assertTrue(cOSObject instanceof COSStream);
    assertEquals("png", actualPdImageXObject.getSuffix());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(actualPdImageXObject.getStream().getFilters().isEmpty());
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}.
   *
   * <ul>
   *   <li>Then return COSObject Filters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDStream, PDResources)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDStream, PDResources); then return COSObject Filters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.<init>(PDStream, PDResources)"})
  void testNewPDImageXObject_thenReturnCOSObjectFiltersIsNull() {
    // Arrange
    PDStream stream = new PDStream(new COSDocument());

    // Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(stream, new PDResources());

    // Assert
    COSDictionary cOSObject = actualPdImageXObject.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(((COSStream) cOSObject).getFilters());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#PDImageXObject(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDDocument); when PDDocument(); then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.<init>(PDDocument)"})
  void testNewPDImageXObject_whenPDDocument_thenCOSObjectReturnCOSStream() throws IOException {
    // Arrange and Act
    PDImageXObject actualPdImageXObject = new PDImageXObject(new PDDocument());

    // Assert
    assertTrue(actualPdImageXObject.getCOSObject() instanceof COSStream);
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
   * Test {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase, int, int, int,
   * PDColorSpace)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return COSObject Values size is seven.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#PDImageXObject(PDDocument, InputStream, COSBase,
   * int, int, int, PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test new PDImageXObject(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace); when PDDocument(); then return COSObject Values size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDImageXObject.<init>(PDDocument, InputStream, COSBase, int, int, int, PDColorSpace)"
  })
  void testNewPDImageXObject_whenPDDocument_thenReturnCOSObjectValuesSizeIsSeven()
      throws IOException {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    PDImageXObject actualPdImageXObject =
        new PDImageXObject(
            document,
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")),
            COSBoolean.FALSE,
            1,
            1,
            1,
            null);

    // Assert
    COSDictionary cOSObject = actualPdImageXObject.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(7, cOSObject.getValues().size());
    assertEquals(7, cOSObject.size());
    assertSame(cOSObject, actualPdImageXObject.getStream().getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#createThumbnail(COSStream)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then COSObject return {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createThumbnail(COSStream)}
   */
  @Test
  @DisplayName("Test createThumbnail(COSStream); when COSStream(); then COSObject return COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createThumbnail(COSStream)"})
  void testCreateThumbnail_whenCOSStream_thenCOSObjectReturnCOSStream() throws IOException {
    // Arrange
    COSStream cosStream = new COSStream();

    // Act
    PDImageXObject actualCreateThumbnailResult = PDImageXObject.createThumbnail(cosStream);

    // Assert
    COSDictionary cOSObject = actualCreateThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
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
    assertSame(cosStream, cOSObject);
  }

  /**
   * Test {@link PDImageXObject#createFromFile(String, PDDocument)}.
   *
   * <ul>
   *   <li>When {@code Image Path}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromFile(String, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFile(String, PDDocument); when 'Image Path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFile(String, PDDocument)"})
  void testCreateFromFile_whenImagePath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDImageXObject.createFromFile("Image Path", new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFile(String, PDDocument)}.
   *
   * <ul>
   *   <li>When {@code PDImageXObject}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromFile(String, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test createFromFile(String, PDDocument); when 'org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFile(String, PDDocument)"})
  void testCreateFromFile_whenOrgApachePdfboxPdmodelGraphicsImagePDImageXObject()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            PDImageXObject.createFromFile(
                "org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject", new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code jpg} toFile.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'jpg' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByExtension(File, PDDocument)"})
  void testCreateFromFileByExtension_whenPropertyIsJavaIoTmpdirIsJpgToFile() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "jpg").toFile();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDImageXObject.createFromFileByExtension(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromFileByExtension(File, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test createFromFileByExtension(File, PDDocument); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByExtension(File, PDDocument)"})
  void testCreateFromFileByExtension_whenPropertyIsJavaIoTmpdirIsTestTxtToFile()
      throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDImageXObject.createFromFileByExtension(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromFileByContent(File, PDDocument)}.
   *
   * <p>Method under test: {@link PDImageXObject#createFromFileByContent(File, PDDocument)}
   */
  @Test
  @DisplayName("Test createFromFileByContent(File, PDDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.createFromFileByContent(File, PDDocument)"})
  void testCreateFromFileByContent() throws IOException {
    // Arrange
    File file = Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile();

    // Act and Assert
    assertThrows(
        IOException.class, () -> PDImageXObject.createFromFileByContent(file, new PDDocument()));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], String); when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"
  })
  void testCreateFromByteArray_whenA_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            PDImageXObject.createFromByteArray(
                new PDDocument(), new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, "Name"));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], String); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"
  })
  void testCreateFromByteArray_whenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            PDImageXObject.createFromByteArray(
                new PDDocument(), "AXAXAXAX".getBytes("UTF-8"), "Name"));
  }

  /**
   * Test {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#createFromByteArray(PDDocument, byte[], String)}
   */
  @Test
  @DisplayName(
      "Test createFromByteArray(PDDocument, byte[], String); when empty array of byte; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PDImageXObject PDImageXObject.createFromByteArray(PDDocument, byte[], String)"
  })
  void testCreateFromByteArray_whenEmptyArrayOfByte_thenThrowIllegalArgumentException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> PDImageXObject.createFromByteArray(new PDDocument(), new byte[] {}, "Name"));
  }

  /**
   * Test {@link PDImageXObject#getMetadata()}.
   *
   * <p>Method under test: {@link PDImageXObject#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMetadata PDImageXObject.getMetadata()"})
  void testGetMetadata() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getMetadata());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Metadata DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); then createThumbnail COSStream() Metadata DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_thenCreateThumbnailCOSStreamMetadataDecodeParmsIsNull() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    COSStream str = new COSStream();

    // Act
    createThumbnailResult.setMetadata(new PDMetadata(str));

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDMetadata metadata = createThumbnailResult.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); when 'null'; then createThumbnail COSStream() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_whenNull_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setMetadata(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>When {@link PDMetadata#PDMetadata(COSStream)} with str is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); when PDMetadata(COSStream) with str is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setMetadata(PDMetadata)"})
  void testSetMetadata_whenPDMetadataWithStrIsNull() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setMetadata(new PDMetadata((COSStream) null));

    // Assert that nothing has changed
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getStructParent()}.
   *
   * <p>Method under test: {@link PDImageXObject#getStructParent()}
   */
  @Test
  @DisplayName("Test getStructParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getStructParent()"})
  void testGetStructParent() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertEquals(-1, createThumbnailResult.getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is {@code 9000000}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName(
      "Test setStructParent(int); then createThumbnail COSStream() StructParent is '9000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
  void testSetStructParent_thenCreateThumbnailCOSStreamStructParentIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(9000000);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName(
      "Test setStructParent(int); then createThumbnail COSStream() StructParent is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
  void testSetStructParent_thenCreateThumbnailCOSStreamStructParentIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getStructParent());
  }

  /**
   * Test {@link PDImageXObject#setStructParent(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} StructParent is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setStructParent(int)}
   */
  @Test
  @DisplayName(
      "Test setStructParent(int); when one; then createThumbnail COSStream() StructParent is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setStructParent(int)"})
  void testSetStructParent_whenOne_thenCreateThumbnailCOSStreamStructParentIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStructParent(1);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, createThumbnailResult.getStructParent());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            6,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            0,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage3() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalGray());

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage4() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(), new byte[] {}, 1, 6, 0, PDDeviceGray.INSTANCE);

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage5() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            6,
            12,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage6() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            0,
            PDDeviceRGB.INSTANCE);

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage7() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 0, new PDCalRGB());

    // Act and Assert
    assertNull(prepareImageXObjectResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getRawImage()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getRawImage()}
   */
  @Test
  @DisplayName("Test getRawImage(); given createThumbnail COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getRawImage()"})
  void testGetRawImage_givenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> createThumbnailResult.getRawImage());
  }

  /**
   * Test {@link PDImageXObject#getStencilImage(Paint)}.
   *
   * <ul>
   *   <li>When decode {@code 42}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getStencilImage(Paint)}
   */
  @Test
  @DisplayName("Test getStencilImage(Paint); when decode '42'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage PDImageXObject.getStencilImage(Paint)"})
  void testGetStencilImage_whenDecode42_thenThrowIllegalStateException()
      throws IOException, NumberFormatException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> createThumbnailResult.getStencilImage(Color.decode("42")));
  }

  /**
   * Test {@link PDImageXObject#getMask()}.
   *
   * <p>Method under test: {@link PDImageXObject#getMask()}
   */
  @Test
  @DisplayName("Test getMask()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.getMask()"})
  void testGetMask() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getMask());
  }

  /**
   * Test {@link PDImageXObject#getColorKeyMask()}.
   *
   * <p>Method under test: {@link PDImageXObject#getColorKeyMask()}
   */
  @Test
  @DisplayName("Test getColorKeyMask()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDImageXObject.getColorKeyMask()"})
  void testGetColorKeyMask() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getColorKeyMask());
  }

  /**
   * Test {@link PDImageXObject#getSoftMask()}.
   *
   * <p>Method under test: {@link PDImageXObject#getSoftMask()}
   */
  @Test
  @DisplayName("Test getSoftMask()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDImageXObject PDImageXObject.getSoftMask()"})
  void testGetSoftMask() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getSoftMask());
  }

  /**
   * Test {@link PDImageXObject#getBitsPerComponent()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); given 'A'; then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getBitsPerComponent()"})
  void testGetBitsPerComponent_givenA_thenReturnSix() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            6,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertEquals(6, prepareImageXObjectResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#getBitsPerComponent()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getBitsPerComponent()}
   */
  @Test
  @DisplayName(
      "Test getBitsPerComponent(); given createThumbnail COSStream(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getBitsPerComponent()"})
  void testGetBitsPerComponent_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertEquals(-1, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is {@code 9000000}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName(
      "Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is '9000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(9000000);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is forty-six.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName(
      "Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is forty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsFortySix() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(46);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(46, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName(
      "Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getBitsPerComponent());
  }

  /**
   * Test {@link PDImageXObject#setBitsPerComponent(int)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} BitsPerComponent is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName(
      "Test setBitsPerComponent(int); then createThumbnail COSStream() BitsPerComponent is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setBitsPerComponent(int)"})
  void testSetBitsPerComponent_thenCreateThumbnailCOSStreamBitsPerComponentIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setBitsPerComponent(1);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, createThumbnailResult.getBitsPerComponent());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given createThumbnail COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_givenCreateThumbnailCOSStream_thenThrowIOException() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertThrows(IOException.class, () -> createThumbnailResult.getColorSpace());
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   *
   * <ul>
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnInstance() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            6,
            PDDeviceGray.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = prepareImageXObjectResult.getColorSpace();

    // Assert
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   *
   * <ul>
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnInstance2() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6},
            1,
            6,
            6,
            PDDeviceRGB.INSTANCE);

    // Act
    PDColorSpace actualColorSpace = prepareImageXObjectResult.getColorSpace();

    // Assert
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   *
   * <ul>
   *   <li>Then return {@link PDCalGray}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return PDCalGray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnPDCalGray() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalGray());

    // Act
    PDColorSpace actualColorSpace = prepareImageXObjectResult.getColorSpace();

    // Assert
    assertTrue(actualColorSpace instanceof PDCalGray);
    assertEquals("CalGray", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertEquals(1, actualColorSpace.getNumberOfComponents());
    assertEquals(1.0f, ((PDCalGray) actualColorSpace).getGamma());
    assertFalse(initialColor.isPattern());
    assertSame(actualColorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#getColorSpace()}.
   *
   * <ul>
   *   <li>Then return {@link PDCalRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then return PDCalRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDImageXObject.getColorSpace()"})
  void testGetColorSpace_thenReturnPDCalRGB() throws IOException {
    // Arrange
    PDDocument document = new PDDocument();
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            document, new byte[] {'A', 6, 'A', 6, 'A', 6, 'A', 6}, 1, 6, 6, new PDCalRGB());

    // Act
    PDColorSpace actualColorSpace = prepareImageXObjectResult.getColorSpace();

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
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        ((PDCalRGB) actualColorSpace).getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDImageXObject#isEmpty()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given createThumbnail COSStream(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDImageXObject.isEmpty()"})
  void testIsEmpty_givenCreateThumbnailCOSStream_thenReturnTrue() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertTrue(createThumbnailResult.isEmpty());
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertArrayEquals(new float[] {0.0f}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setColorSpace(PDColorSpace); then createThumbnail COSStream() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setColorSpace(PDColorSpace)"})
  void testSetColorSpace_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsFour()
      throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setColorSpace(PDDeviceGray.INSTANCE);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(PDDeviceGray.INSTANCE, createThumbnailResult.getColorSpace());
  }

  /**
   * Test {@link PDImageXObject#setColorSpace(PDColorSpace)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName(
      "Test setColorSpace(PDColorSpace); then createThumbnail COSStream() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setColorSpace(PDColorSpace)"})
  void testSetColorSpace_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setColorSpace(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getHeight()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getHeight()"})
  void testGetHeight_givenA() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            1,
            -1,
            -1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertEquals(-1, prepareImageXObjectResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#getHeight()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); given createThumbnail COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getHeight()"})
  void testGetHeight_givenCreateThumbnailCOSStream() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertEquals(-1, createThumbnailResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   *
   * <ul>
   *   <li>When {@code 9000000}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is {@code 9000000}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName(
      "Test setHeight(int); when '9000000'; then createThumbnail COSStream() Height is '9000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
  void testSetHeight_when9000000_thenCreateThumbnailCOSStreamHeightIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(9000000);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName(
      "Test setHeight(int); when MIN_VALUE; then createThumbnail COSStream() Height is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
  void testSetHeight_whenMin_value_thenCreateThumbnailCOSStreamHeightIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getHeight());
  }

  /**
   * Test {@link PDImageXObject#setHeight(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Height is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setHeight(int)}
   */
  @Test
  @DisplayName("Test setHeight(int); when one; then createThumbnail COSStream() Height is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setHeight(int)"})
  void testSetHeight_whenOne_thenCreateThumbnailCOSStreamHeightIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setHeight(1);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, createThumbnailResult.getHeight());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getWidth()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given 'A'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getWidth()"})
  void testGetWidth_givenA_thenReturnOne() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            1,
            -1,
            -1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertEquals(1, prepareImageXObjectResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#getWidth()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); given createThumbnail COSStream(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDImageXObject.getWidth()"})
  void testGetWidth_givenCreateThumbnailCOSStream_thenReturnMinusOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertEquals(-1, createThumbnailResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   *
   * <ul>
   *   <li>When {@code 9000000}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is {@code 9000000}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName(
      "Test setWidth(int); when '9000000'; then createThumbnail COSStream() Width is '9000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
  void testSetWidth_when9000000_thenCreateThumbnailCOSStreamWidthIs9000000() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(9000000);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(9000000, createThumbnailResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName(
      "Test setWidth(int); when MIN_VALUE; then createThumbnail COSStream() Width is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
  void testSetWidth_whenMin_value_thenCreateThumbnailCOSStreamWidthIsMin_value() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, createThumbnailResult.getWidth());
  }

  /**
   * Test {@link PDImageXObject#setWidth(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} Width is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setWidth(int)}
   */
  @Test
  @DisplayName("Test setWidth(int); when one; then createThumbnail COSStream() Width is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setWidth(int)"})
  void testSetWidth_whenOne_thenCreateThumbnailCOSStreamWidthIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setWidth(1);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, createThumbnailResult.getWidth());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getInterpolate()}.
   *
   * <p>Method under test: {@link PDImageXObject#getInterpolate()}
   */
  @Test
  @DisplayName("Test getInterpolate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDImageXObject.getInterpolate()"})
  void testGetInterpolate() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertFalse(createThumbnailResult.getInterpolate());
  }

  /**
   * Test {@link PDImageXObject#setInterpolate(boolean)}.
   *
   * <p>Method under test: {@link PDImageXObject#setInterpolate(boolean)}
   */
  @Test
  @DisplayName("Test setInterpolate(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setInterpolate(boolean)"})
  void testSetInterpolate() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setInterpolate(true);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(createThumbnailResult.getInterpolate());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDecode(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
  void testSetDecode_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSArray decode = new COSArray();
    decode.setKey(new COSObjectKey(1L, 1));
    decode.setDirect(false);

    // Act
    createThumbnailResult.setDecode(decode);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(decode, createThumbnailResult.getDecode());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link COSArray#COSArray()} Direct is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName("Test setDecode(COSArray); given 'false'; when COSArray() Direct is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
  void testSetDecode_givenFalse_whenCOSArrayDirectIsFalse() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    COSArray decode = new COSArray();
    decode.setDirect(false);

    // Act
    createThumbnailResult.setDecode(decode);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(decode, createThumbnailResult.getDecode());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDecode(COSArray); when COSArray(); then createThumbnail COSStream() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
  void testSetDecode_whenCOSArray_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsFour() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());
    COSArray decode = new COSArray();

    // Act
    createThumbnailResult.setDecode(decode);

    // Assert
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(decode, createThumbnailResult.getDecode());
  }

  /**
   * Test {@link PDImageXObject#setDecode(COSArray)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setDecode(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setDecode(COSArray); when 'null'; then createThumbnail COSStream() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setDecode(COSArray)"})
  void testSetDecode_whenNull_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setDecode(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#getDecode()}.
   *
   * <p>Method under test: {@link PDImageXObject#getDecode()}
   */
  @Test
  @DisplayName("Test getDecode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDImageXObject.getDecode()"})
  void testGetDecode() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getDecode());
  }

  /**
   * Test {@link PDImageXObject#isStencil()}.
   *
   * <p>Method under test: {@link PDImageXObject#isStencil()}
   */
  @Test
  @DisplayName("Test isStencil()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDImageXObject.isStencil()"})
  void testIsStencil() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertFalse(createThumbnailResult.isStencil());
  }

  /**
   * Test {@link PDImageXObject#setStencil(boolean)}.
   *
   * <p>Method under test: {@link PDImageXObject#setStencil(boolean)}
   */
  @Test
  @DisplayName("Test setStencil(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setStencil(boolean)"})
  void testSetStencil() throws IOException {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act
    createThumbnailResult.setStencil(true);

    // Assert
    PDColorSpace colorSpace = createThumbnailResult.getColorSpace();
    assertTrue(colorSpace.getCOSObject() instanceof COSName);
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertTrue(colorSpace instanceof PDDeviceGray);
    assertEquals("DeviceGray", colorSpace.getName());
    assertEquals(1, colorSpace.getNumberOfComponents());
    assertEquals(1, createThumbnailResult.getBitsPerComponent());
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(createThumbnailResult.isStencil());
  }

  /**
   * Test {@link PDImageXObject#getSuffix()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDImageXObject.getSuffix()"})
  void testGetSuffix_givenA() throws IOException {
    // Arrange
    PDImageXObject prepareImageXObjectResult =
        LosslessFactory.prepareImageXObject(
            new PDDocument(),
            new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1},
            1,
            1,
            1,
            PDDeviceGray.INSTANCE);

    // Act and Assert
    assertEquals("png", prepareImageXObjectResult.getSuffix());
  }

  /**
   * Test {@link PDImageXObject#getSuffix()}.
   *
   * <ul>
   *   <li>Given createThumbnail {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getSuffix()}
   */
  @Test
  @DisplayName("Test getSuffix(); given createThumbnail COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDImageXObject.getSuffix()"})
  void testGetSuffix_givenCreateThumbnailCOSStream() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertEquals("png", createThumbnailResult.getSuffix());
  }

  /**
   * Test {@link PDImageXObject#getOptionalContent()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#getOptionalContent()}
   */
  @Test
  @DisplayName("Test getOptionalContent(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPropertyList PDImageXObject.getOptionalContent()"})
  void testGetOptionalContent_thenReturnNull() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    // Act and Assert
    assertNull(createThumbnailResult.getOptionalContent());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   *
   * <p>Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent() {
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
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, createThumbnailResult.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); given COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertSame(cosDictionary, createThumbnailResult.getOptionalContent().getCOSObject());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>Then createThumbnail {@link COSStream#COSStream()} COSObject Values size is three.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName(
      "Test setOptionalContent(PDPropertyList); then createThumbnail COSStream() COSObject Values size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent_thenCreateThumbnailCOSStreamCOSObjectValuesSizeIsThree() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenReturn(null);

    // Act
    createThumbnailResult.setOptionalContent(oc);

    // Assert that nothing has changed
    verify(oc).getCOSObject();
    COSDictionary cOSObject = createThumbnailResult.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDImageXObject#setOptionalContent(PDPropertyList)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDImageXObject#setOptionalContent(PDPropertyList)}
   */
  @Test
  @DisplayName("Test setOptionalContent(PDPropertyList); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDImageXObject.setOptionalContent(PDPropertyList)"})
  void testSetOptionalContent_thenThrowIllegalArgumentException() {
    // Arrange
    PDImageXObject createThumbnailResult = PDImageXObject.createThumbnail(new COSStream());

    PDPropertyList oc = mock(PDPropertyList.class);
    when(oc.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> createThumbnailResult.setOptionalContent(oc));
    verify(oc).getCOSObject();
  }
}
