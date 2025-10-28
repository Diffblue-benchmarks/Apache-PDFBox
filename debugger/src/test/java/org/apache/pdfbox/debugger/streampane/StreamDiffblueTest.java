package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.Test;

class StreamDiffblueTest {
  /**
   * Method under test: {@link Stream#getFilterList()}
   */
  @Test
  void testGetFilterList() {
    // Arrange and Act
    List<String> actualFilterList = (new Stream(new COSStream(), true)).getFilterList();

    // Assert
    assertEquals(3, actualFilterList.size());
    assertEquals("Encoded ()", actualFilterList.get(2));
    assertEquals(Stream.DECODED, actualFilterList.get(1));
    assertEquals(Stream.IMAGE, actualFilterList.get(0));
  }

  /**
   * Method under test: {@link Stream#getStream(String)}
   */
  @Test
  void testGetStream() {
    // Arrange, Act and Assert
    assertNull((new Stream(new COSStream(), true)).getStream("Key"));
    assertNull((new Stream(new COSStream(), true)).getStream(Stream.DECODED));
    assertNull((new Stream(new COSStream(), true)).getStream("Encoded ()"));
  }

  /**
   * Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  void testGetImage() {
    // Arrange
    Stream stream = new Stream(new COSStream(), true);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }

  /**
   * Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  void testGetImage2() {
    // Arrange
    Stream stream = new Stream(new COSStream(new RandomAccessStreamCacheImpl()), true);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }

  /**
   * Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  void testGetImage3() {
    // Arrange
    Stream stream = new Stream(new COSStream(), false);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Stream#isImage()}
   *   <li>{@link Stream#isXmlMetadata()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  void testNewStream() {
    // Arrange and Act
    Stream actualStream = new Stream(new COSStream(), true);

    // Assert
    List<String> filterList = actualStream.getFilterList();
    assertEquals(3, filterList.size());
    assertEquals("Encoded ()", filterList.get(2));
    assertFalse(actualStream.isXmlMetadata());
    assertTrue(actualStream.isImage());
    assertEquals(Stream.DECODED, filterList.get(1));
    assertEquals(Stream.IMAGE, filterList.get(0));
  }

  /**
   * Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  void testNewStream2() {
    // Arrange and Act
    Stream actualStream = new Stream(new COSStream(), false);

    // Assert
    List<String> filterList = actualStream.getFilterList();
    assertEquals(2, filterList.size());
    assertEquals("Encoded ()", filterList.get(1));
    assertFalse(actualStream.isImage());
    assertFalse(actualStream.isXmlMetadata());
    assertEquals(Stream.DECODED, filterList.get(0));
  }
}
