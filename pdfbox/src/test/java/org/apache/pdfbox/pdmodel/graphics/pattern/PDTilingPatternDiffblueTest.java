package org.apache.pdfbox.pdmodel.graphics.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDTilingPatternDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTilingPattern.<init>(COSDictionary)",
    "void PDTilingPattern.<init>(COSDictionary, ResourceCache)",
    "int PDTilingPattern.getPatternType()"
  })
  void testGettersAndSetters_whenCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern(dictionary);

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link DefaultResourceCache} (default constructor).
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDTilingPattern#PDTilingPattern(COSDictionary, ResourceCache)}
   *   <li>{@link PDTilingPattern#getPatternType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when DefaultResourceCache (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDTilingPattern.<init>(COSDictionary)",
    "void PDTilingPattern.<init>(COSDictionary, ResourceCache)",
    "int PDTilingPattern.getPatternType()"
  })
  void testGettersAndSetters_whenDefaultResourceCache() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDTilingPattern actualPdTilingPattern =
        new PDTilingPattern(dictionary, new DefaultResourceCache());

    // Assert
    assertEquals(1, actualPdTilingPattern.getPatternType());
    assertSame(dictionary, actualPdTilingPattern.getCOSObject());
  }

  /**
   * Test {@link PDTilingPattern#PDTilingPattern()}.
   *
   * <p>Method under test: {@link PDTilingPattern#PDTilingPattern()}
   */
  @Test
  @DisplayName("Test new PDTilingPattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.<init>()"})
  void testNewPDTilingPattern() {
    // Arrange and Act
    PDTilingPattern actualPdTilingPattern = new PDTilingPattern();

    // Assert
    assertTrue(actualPdTilingPattern.getCOSObject() instanceof COSStream);
    assertEquals("Pattern", actualPdTilingPattern.getType());
    assertNull(actualPdTilingPattern.getBBox());
    assertEquals(0, actualPdTilingPattern.getPaintType());
    assertEquals(0, actualPdTilingPattern.getTilingType());
    assertEquals(0.0f, actualPdTilingPattern.getXStep());
    assertEquals(0.0f, actualPdTilingPattern.getYStep());
    assertEquals(1, actualPdTilingPattern.getPatternType());
  }

  /**
   * Test {@link PDTilingPattern#setPaintType(int)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>When one.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} PaintType is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  @DisplayName(
      "Test setPaintType(int); given PDTilingPattern(); when one; then PDTilingPattern() PaintType is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setPaintType(int)"})
  void testSetPaintType_givenPDTilingPattern_whenOne_thenPDTilingPatternPaintTypeIsOne() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setPaintType(1);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdTilingPattern.getPaintType());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#setPaintType(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} PaintType is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setPaintType(int)}
   */
  @Test
  @DisplayName(
      "Test setPaintType(int); when MIN_VALUE; then PDTilingPattern() PaintType is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setPaintType(int)"})
  void testSetPaintType_whenMin_value_thenPDTilingPatternPaintTypeIsMin_value() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setPaintType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdTilingPattern.getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#getPaintType()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName(
      "Test getPaintType(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTilingPattern.getPaintType()"})
  void testGetPaintType_givenPDTilingPatternWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, new PDTilingPattern(new COSDictionary()).getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#getPaintType()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getPaintType()}
   */
  @Test
  @DisplayName("Test getPaintType(); given PDTilingPattern(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTilingPattern.getPaintType()"})
  void testGetPaintType_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDTilingPattern().getPaintType());
  }

  /**
   * Test {@link PDTilingPattern#setTilingType(int)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} TilingType is one.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  @DisplayName(
      "Test setTilingType(int); given PDTilingPattern(); then PDTilingPattern() TilingType is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setTilingType(int)"})
  void testSetTilingType_givenPDTilingPattern_thenPDTilingPatternTilingTypeIsOne() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setTilingType(1);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(1, pdTilingPattern.getTilingType());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#setTilingType(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} TilingType is {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setTilingType(int)}
   */
  @Test
  @DisplayName(
      "Test setTilingType(int); when MIN_VALUE; then PDTilingPattern() TilingType is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setTilingType(int)"})
  void testSetTilingType_whenMin_value_thenPDTilingPatternTilingTypeIsMin_value() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setTilingType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdTilingPattern.getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#getTilingType()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  @DisplayName(
      "Test getTilingType(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTilingPattern.getTilingType()"})
  void testGetTilingType_givenPDTilingPatternWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, new PDTilingPattern(new COSDictionary()).getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#getTilingType()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getTilingType()}
   */
  @Test
  @DisplayName("Test getTilingType(); given PDTilingPattern(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDTilingPattern.getTilingType()"})
  void testGetTilingType_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDTilingPattern().getTilingType());
  }

  /**
   * Test {@link PDTilingPattern#setXStep(float)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setXStep(float)}
   */
  @Test
  @DisplayName(
      "Test setXStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setXStep(float)"})
  void testSetXStep_givenPDTilingPattern_thenPDTilingPatternCOSObjectCOSStream() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setXStep(10.0f);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(10.0f, pdTilingPattern.getXStep());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#getXStep()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  @DisplayName(
      "Test getXStep(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTilingPattern.getXStep()"})
  void testGetXStep_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDTilingPattern(new COSDictionary()).getXStep());
  }

  /**
   * Test {@link PDTilingPattern#getXStep()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getXStep()}
   */
  @Test
  @DisplayName("Test getXStep(); given PDTilingPattern(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTilingPattern.getXStep()"})
  void testGetXStep_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDTilingPattern().getXStep());
  }

  /**
   * Test {@link PDTilingPattern#setYStep(float)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject {@link COSStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setYStep(float)}
   */
  @Test
  @DisplayName(
      "Test setYStep(float); given PDTilingPattern(); then PDTilingPattern() COSObject COSStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setYStep(float)"})
  void testSetYStep_givenPDTilingPattern_thenPDTilingPatternCOSObjectCOSStream() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setYStep(10.0f);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(10.0f, pdTilingPattern.getYStep());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#getYStep()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  @DisplayName(
      "Test getYStep(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTilingPattern.getYStep()"})
  void testGetYStep_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDTilingPattern(new COSDictionary()).getYStep());
  }

  /**
   * Test {@link PDTilingPattern#getYStep()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getYStep()}
   */
  @Test
  @DisplayName("Test getYStep(); given PDTilingPattern(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDTilingPattern.getYStep()"})
  void testGetYStep_givenPDTilingPattern_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDTilingPattern().getYStep());
  }

  /**
   * Test {@link PDTilingPattern#getContentStream()}.
   *
   * <p>Method under test: {@link PDTilingPattern#getContentStream()}
   */
  @Test
  @DisplayName("Test getContentStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDStream PDTilingPattern.getContentStream()"})
  void testGetContentStream() throws IOException {
    // Arrange and Act
    PDStream actualContentStream = new PDTilingPattern().getContentStream();

    // Assert
    assertNull(actualContentStream.getDecodeParms());
    assertNull(actualContentStream.getFileDecodeParams());
    assertNull(actualContentStream.getMetadata());
    assertNull(actualContentStream.getFile());
    assertEquals(-1, actualContentStream.getDecodedStreamLength());
    assertEquals(0, actualContentStream.getLength());
    List<String> fileFilters = actualContentStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualContentStream.getFilters());
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   *
   * <p>Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName("Test getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDTilingPattern.getContents()"})
  void testGetContents() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    new PDTilingPattern(dictionary).getContents();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   *
   * <p>Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName("Test getContents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDTilingPattern.getContents()"})
  void testGetContents2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 1L));

    // Act
    new PDTilingPattern(dictionary).getContents();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDTilingPattern.getContents()"})
  void testGetContents_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDTilingPattern(new COSDictionary()).getContents());
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is three.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName(
      "Test getContents(); given RandomAccessReadWriteBuffer(int) with definedChunkSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDTilingPattern.getContents()"})
  void testGetContents_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsThree()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(3), 1L, 3L));

    // Act
    new PDTilingPattern(dictionary).getContents();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDTilingPattern#getContents()}.
   *
   * <ul>
   *   <li>Then return {@link RandomAccessInputStream}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContents()}
   */
  @Test
  @DisplayName("Test getContents(); then return RandomAccessInputStream")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDTilingPattern.getContents()"})
  void testGetContents_thenReturnRandomAccessInputStream() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 1L));

    // Act
    InputStream actualContents = new PDTilingPattern(dictionary).getContents();

    // Assert
    assertTrue(actualContents instanceof RandomAccessInputStream);
    assertEquals(1, actualContents.available());
  }

  /**
   * Test {@link PDTilingPattern#getContentsForRandomAccess()}.
   *
   * <p>Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDTilingPattern.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 1L));

    // Act
    RandomAccessRead actualContentsForRandomAccess =
        new PDTilingPattern(dictionary).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDTilingPattern#getContentsForRandomAccess()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName(
      "Test getContentsForRandomAccess(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDTilingPattern.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream dictionary =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 1L));

    // Act
    RandomAccessRead actualContentsForRandomAccess =
        new PDTilingPattern(dictionary).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(1, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDTilingPattern#getContentsForRandomAccess()}.
   *
   * <ul>
   *   <li>Then return available is three.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return available is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDTilingPattern.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess_thenReturnAvailableIsThree() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream dictionary =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    RandomAccessRead actualContentsForRandomAccess =
        new PDTilingPattern(dictionary).getContentsForRandomAccess();

    // Assert
    assertTrue(actualContentsForRandomAccess instanceof RandomAccessReadView);
    assertEquals(0L, actualContentsForRandomAccess.getPosition());
    assertEquals(3, actualContentsForRandomAccess.available());
    assertFalse(actualContentsForRandomAccess.isClosed());
  }

  /**
   * Test {@link PDTilingPattern#getContentsForRandomAccess()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getContentsForRandomAccess()}
   */
  @Test
  @DisplayName("Test getContentsForRandomAccess(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RandomAccessRead PDTilingPattern.getContentsForRandomAccess()"})
  void testGetContentsForRandomAccess_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDTilingPattern(new COSDictionary()).getContentsForRandomAccess());
  }

  /**
   * Test {@link PDTilingPattern#getResources()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then ColorSpaceNames return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDTilingPattern(); then ColorSpaceNames return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDTilingPattern.getResources()"})
  void testGetResources_givenPDTilingPattern_thenColorSpaceNamesReturnSet() {
    // Arrange and Act
    PDResources actualResources = new PDTilingPattern().getResources();

    // Assert
    Iterable<COSName> colorSpaceNames = actualResources.getColorSpaceNames();
    assertTrue(colorSpaceNames instanceof Set);
    COSDictionary cOSObject = actualResources.getCOSObject();
    assertNull(cOSObject.getKey());
    assertNull(actualResources.getResourceCache());
    assertEquals(0, cOSObject.size());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(((Set<COSName>) colorSpaceNames).isEmpty());
    assertSame(colorSpaceNames, actualResources.getExtGStateNames());
    assertSame(colorSpaceNames, actualResources.getFontNames());
    assertSame(colorSpaceNames, actualResources.getPatternNames());
    assertSame(colorSpaceNames, actualResources.getPropertiesNames());
    assertSame(colorSpaceNames, actualResources.getShadingNames());
    assertSame(colorSpaceNames, actualResources.getXObjectNames());
  }

  /**
   * Test {@link PDTilingPattern#getResources()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDResources PDTilingPattern.getResources()"})
  void testGetResources_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTilingPattern(new COSDictionary()).getResources());
  }

  /**
   * Test {@link PDTilingPattern#setResources(PDResources)}.
   *
   * <ul>
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName(
      "Test setResources(PDResources); then PDTilingPattern() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setResources(PDResources)"})
  void testSetResources_thenPDTilingPatternCOSObjectValuesSizeIsFour() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setResources(new PDResources());

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#setResources(PDResources)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} Resources is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setResources(PDResources)}
   */
  @Test
  @DisplayName(
      "Test setResources(PDResources); when 'null'; then PDTilingPattern() Resources is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setResources(PDResources)"})
  void testSetResources_whenNull_thenPDTilingPatternResourcesIsNull() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setResources(null);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertNull(pdTilingPattern.getResources());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern(COSDictionary)} with dictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given PDTilingPattern(COSDictionary) with dictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDTilingPattern.getBBox()"})
  void testGetBBox_givenPDTilingPatternWithDictionaryIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTilingPattern(new COSDictionary()).getBBox());
  }

  /**
   * Test {@link PDTilingPattern#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDTilingPattern(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDTilingPattern.getBBox()"})
  void testGetBBox_givenPDTilingPattern_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDTilingPattern().getBBox());
  }

  /**
   * Test {@link PDTilingPattern#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} COSObject Values size is four.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBBox(PDRectangle); given PDTilingPattern(); then PDTilingPattern() COSObject Values size is four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setBBox(PDRectangle)"})
  void testSetBBox_givenPDTilingPattern_thenPDTilingPatternCOSObjectValuesSizeIsFour() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Test {@link PDTilingPattern#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Given {@link PDTilingPattern#PDTilingPattern()}.
   *   <li>When {@link PDRectangle#A0}.
   *   <li>Then {@link PDTilingPattern#PDTilingPattern()} BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDTilingPattern#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBBox(PDRectangle); given PDTilingPattern(); when A0; then PDTilingPattern() BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDTilingPattern.setBBox(PDRectangle)"})
  void testSetBBox_givenPDTilingPattern_whenA0_thenPDTilingPatternBBoxLowerLeftXIsZero() {
    // Arrange
    PDTilingPattern pdTilingPattern = new PDTilingPattern();

    // Act
    pdTilingPattern.setBBox(PDRectangle.A0);

    // Assert
    COSDictionary cOSObject = pdTilingPattern.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    PDRectangle bBox = pdTilingPattern.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertEquals(5, cOSObject.getValues().size());
    assertEquals(5, cOSObject.size());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }
}
