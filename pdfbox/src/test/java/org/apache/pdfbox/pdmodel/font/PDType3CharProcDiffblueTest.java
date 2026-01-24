package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDType3CharProcDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDType3CharProc#PDType3CharProc(PDType3Font, COSStream)}
   *   <li>{@link PDType3CharProc#getFont()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDType3CharProc.<init>(PDType3Font, COSStream)",
    "PDType3Font PDType3CharProc.getFont()"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    // Act
    PDType3CharProc actualPdType3CharProc = new PDType3CharProc(font, charStream);
    PDType3Font actualFont = actualPdType3CharProc.getFont();

    // Assert
    assertSame(charStream, actualPdType3CharProc.getCOSObject());
    assertSame(font, actualFont);
  }

  /**
   * Test {@link PDType3CharProc#getCOSObject()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDType3CharProc.getCOSObject()"})
  void testGetCOSObject() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertSame(charStream, pdType3CharProc.getCOSObject());
  }

  /**
   * Test {@link PDType3CharProc#getContentStream()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDType3CharProc.getContentStream()"})
  void testGetContentStream() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    COSStream charStream = new COSStream();

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    PDStream actualContentStream = pdType3CharProc.getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(charStream, actualContentStream.getCOSObject());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDType3CharProc#getContents()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getContents()}
   */
  @Test
  @DisplayName("Test getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDType3CharProc.getContents()"})
  void testGetContents() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 1L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    pdType3CharProc.getContents();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDType3CharProc#getContents()}.
   *
   * <ul>
   *   <li>Then array length is fifty-one.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then array length is fifty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDType3CharProc.getContents()"})
  void testGetContents_thenArrayLengthIsFiftyOne() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    pdType3CharProc.getContents();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDType3CharProc#getContents()}.
   *
   * <ul>
   *   <li>Then return {@link RandomAccessInputStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return RandomAccessInputStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDType3CharProc.getContents()"})
  void testGetContents_thenReturnRandomAccessInputStream() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 1L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    InputStream actualContents = pdType3CharProc.getContents();

    // Assert
    assertTrue(actualContents instanceof RandomAccessInputStream);
    assertEquals(1, actualContents.available());
  }

  /**
   * Test {@link PDType3CharProc#getContentsForRandomAccess()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDType3CharProc.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 1L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdType3CharProc.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDType3CharProc#getContentsForRandomAccess()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName(
      "Test getContentsForRandomAccess(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDType3CharProc.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 1L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdType3CharProc.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDType3CharProc#getContentsForRandomAccess()}.
   *
   * <ul>
   *   <li>Then return available is three.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return available is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDType3CharProc.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess_thenReturnAvailableIsThree() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act
    RandomAccessRead actualContentsForRandomAccess = pdType3CharProc.getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(3, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDType3CharProc#getResources()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.PDResources PDType3CharProc.getResources()"})
  void testGetResources_thenReturnNull() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, new COSStream());

    // Act and Assert
    assertNull(pdType3CharProc.getResources());
  }

  /**
   * Test {@link PDType3CharProc#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getBBox()"})
  void testGetBBox_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, new COSStream());

    // Act and Assert
    assertNull(pdType3CharProc.getBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox2() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 0L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox3() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, Long.MAX_VALUE));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName("Test getGlyphBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox4() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', '\n', 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 0L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName(
      "Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox_givenByteArrayInputStreamWithArrayOfByteWithAAndLf() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', '\n', 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getGlyphBBox()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getGlyphBBox()}
   */
  @Test
  @DisplayName(
      "Test getGlyphBBox(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.common.PDRectangle PDType3CharProc.getGlyphBBox()"})
  void testGetGlyphBBox_givenByteArrayInputStreamWithArrayOfByteWithAAndOne() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertNull(pdType3CharProc.getGlyphBBox());
  }

  /**
   * Test {@link PDType3CharProc#getMatrix()}.
   *
   * <ul>
   *   <li>Then return {@link PDFont#DEFAULT_FONT_MATRIX}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix(); then return DEFAULT_FONT_MATRIX")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.util.Matrix PDType3CharProc.getMatrix()"})
  void testGetMatrix_thenReturnDefault_font_matrix() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, new COSStream());

    // Act and Assert
    assertSame(PDFont.DEFAULT_FONT_MATRIX, pdType3CharProc.getMatrix());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth2() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 0L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth3() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', '\n', 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 0L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth4() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 10L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and lf.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName(
      "Test getWidth(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth_givenByteArrayInputStreamWithArrayOfByteWithAAndLf() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', '\n', 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and one.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName(
      "Test getWidth(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth_givenByteArrayInputStreamWithArrayOfByteWithAAndOne() throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream charStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }

  /**
   * Test {@link PDType3CharProc#getWidth()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType3CharProc#getWidth()}
   */
  @Test
  @DisplayName(
      "Test getWidth(); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3CharProc.getWidth()"})
  void testGetWidth_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    PDType3Font font = new PDType3Font(new COSDictionary());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream charStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(0), 1L, 3L));

    PDType3CharProc pdType3CharProc = new PDType3CharProc(font, charStream);

    // Act and Assert
    assertThrows(IOException.class, () -> pdType3CharProc.getWidth());
  }
}
