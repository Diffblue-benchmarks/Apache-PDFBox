package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamDiffblueTest {
  /**
   * Test {@link Stream#Stream(COSStream, boolean)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return FilterList size is three.
   * </ul>
   *
   * <p>Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Stream(COSStream, boolean); when COSStream(); then return FilterList size is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stream.<init>(COSStream, boolean)"})
  void testNewStream_whenCOSStream_thenReturnFilterListSizeIsThree() {
    // Arrange and Act
    Stream actualStream = new Stream(new COSStream(), true);

    // Assert
    List<String> filterList = actualStream.getFilterList();
    assertEquals(3, filterList.size());
    assertEquals("Encoded ()", filterList.get(2));
    assertTrue(actualStream.isImage());
    assertEquals(Stream.DECODED, filterList.get(1));
    assertEquals(Stream.IMAGE, filterList.get(0));
  }

  /**
   * Test {@link Stream#Stream(COSStream, boolean)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return FilterList size is two.
   * </ul>
   *
   * <p>Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test new Stream(COSStream, boolean); when COSStream(); then return FilterList size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Stream.<init>(COSStream, boolean)"})
  void testNewStream_whenCOSStream_thenReturnFilterListSizeIsTwo() {
    // Arrange and Act
    Stream actualStream = new Stream(new COSStream(), false);

    // Assert
    List<String> filterList = actualStream.getFilterList();
    assertEquals(2, filterList.size());
    assertEquals("Encoded ()", filterList.get(1));
    assertFalse(actualStream.isImage());
    assertEquals(Stream.DECODED, filterList.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Stream#isImage()}
   *   <li>{@link Stream#isXmlMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Stream.isImage()", "boolean Stream.isXmlMetadata()"})
  void testGettersAndSetters() {
    // Arrange
    Stream stream = new Stream(new COSStream(), true);

    // Act
    boolean actualIsImageResult = stream.isImage();

    // Assert
    assertFalse(stream.isXmlMetadata());
    assertTrue(actualIsImageResult);
  }

  /**
   * Test {@link Stream#getFilterList()}.
   *
   * <p>Method under test: {@link Stream#getFilterList()}
   */
  @Test
  @DisplayName("Test getFilterList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Stream.getFilterList()"})
  void testGetFilterList() {
    // Arrange and Act
    List<String> actualFilterList = new Stream(new COSStream(), true).getFilterList();

    // Assert
    assertEquals(3, actualFilterList.size());
    assertEquals("Encoded ()", actualFilterList.get(2));
    assertEquals(Stream.DECODED, actualFilterList.get(1));
    assertEquals(Stream.IMAGE, actualFilterList.get(0));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 200L, 3L));

    // Act
    new Stream(cosStream, true).getStream("Key");

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L));

    // Act and Assert
    assertNull(new Stream(cosStream, true).getStream("Key"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 3L));

    // Act
    new Stream(cosStream, true).getStream("Key");

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream4() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), -1L, 3L));

    // Act and Assert
    assertNull(new Stream(cosStream, true).getStream("Key"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName(
      "Test getStream(String); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnNull()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream cosStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act and Assert
    assertNull(new Stream(cosStream, true).getStream("Key"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName(
      "Test getStream(String); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(0), 200L, 3L));

    // Act
    new Stream(cosStream, true).getStream("Key");

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link
   *       COSStream#COSStream()} and isThumb is {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName(
      "Test getStream(String); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsTrue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new Stream(new COSStream(), true).getStream("Key"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link
   *       COSStream#COSStream()} and isThumb is {@code true}.
   *   <li>When {@link Stream#DECODED}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName(
      "Test getStream(String); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'true'; when DECODED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsTrue_whenDecoded() {
    // Arrange, Act and Assert
    assertNull(new Stream(new COSStream(), true).getStream(Stream.DECODED));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link
   *       COSStream#COSStream()} and isThumb is {@code true}.
   *   <li>When {@code Encoded ()}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName(
      "Test getStream(String); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'true'; when 'Encoded ()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsTrue_whenEncoded() {
    // Arrange, Act and Assert
    assertNull(new Stream(new COSStream(), true).getStream("Encoded ()"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>When {@link Stream#DECODED}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String); when DECODED")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_whenDecoded() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 200L, 3L));

    // Act
    new Stream(cosStream, true).getStream(Stream.DECODED);

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link Stream#getStream(String)}.
   *
   * <ul>
   *   <li>When {@code Encoded ()}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String); when 'Encoded ()'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_whenEncoded() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 200L, 3L));

    // Act
    new Stream(cosStream, true).getStream("Encoded ()");

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link Stream#getImage(PDResources)}.
   *
   * <p>Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  @DisplayName("Test getImage(PDResources)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage Stream.getImage(PDResources)"})
  void testGetImage() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    Stream stream = new Stream(cosStream, true);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }

  /**
   * Test {@link Stream#getImage(PDResources)}.
   *
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link
   *       COSStream#COSStream()} and isThumb is {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  @DisplayName(
      "Test getImage(PDResources); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage Stream.getImage(PDResources)"})
  void testGetImage_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsFalse() {
    // Arrange
    Stream stream = new Stream(new COSStream(), false);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }

  /**
   * Test {@link Stream#getImage(PDResources)}.
   *
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link
   *       COSStream#COSStream()} and isThumb is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  @DisplayName(
      "Test getImage(PDResources); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.image.BufferedImage Stream.getImage(PDResources)"})
  void testGetImage_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsTrue() {
    // Arrange
    Stream stream = new Stream(new COSStream(), true);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }
}
