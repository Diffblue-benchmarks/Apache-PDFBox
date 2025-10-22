package org.apache.pdfbox.debugger.streampane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDResources;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StreamDiffblueTest {
  /**
   * Test {@link Stream#Stream(COSStream, boolean)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return FilterList size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  @DisplayName("Test new Stream(COSStream, boolean); when COSStream(); then return FilterList size is three")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return FilterList size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#Stream(COSStream, boolean)}
   */
  @Test
  @DisplayName("Test new Stream(COSStream, boolean); when COSStream(); then return FilterList size is two")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Stream#isImage()}
   *   <li>{@link Stream#isXmlMetadata()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Stream#getFilterList()}
   */
  @Test
  @DisplayName("Test getFilterList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Stream.getFilterList()"})
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
   * Test {@link Stream#getStream(String)}.
   * <ul>
   *   <li>When {@link Stream#DECODED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String); when DECODED")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_whenDecoded() {
    // Arrange, Act and Assert
    assertNull((new Stream(new COSStream(), true)).getStream(Stream.DECODED));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   * <ul>
   *   <li>When {@code Encoded ()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String); when 'Encoded ()'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_whenEncoded() {
    // Arrange, Act and Assert
    assertNull((new Stream(new COSStream(), true)).getStream("Encoded ()"));
  }

  /**
   * Test {@link Stream#getStream(String)}.
   * <ul>
   *   <li>When {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#getStream(String)}
   */
  @Test
  @DisplayName("Test getStream(String); when 'Key'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream Stream.getStream(String)"})
  void testGetStream_whenKey() {
    // Arrange, Act and Assert
    assertNull((new Stream(new COSStream(), true)).getStream("Key"));
  }

  /**
   * Test {@link Stream#getImage(PDResources)}.
   * <ul>
   *   <li>Given {@link Stream#Stream(COSStream, boolean)} with cosStream is {@link COSStream#COSStream()} and isThumb is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Stream#getImage(PDResources)}
   */
  @Test
  @DisplayName("Test getImage(PDResources); given Stream(COSStream, boolean) with cosStream is COSStream() and isThumb is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.image.BufferedImage Stream.getImage(PDResources)"})
  void testGetImage_givenStreamWithCosStreamIsCOSStreamAndIsThumbIsTrue() {
    // Arrange
    Stream stream = new Stream(new COSStream(), true);

    // Act and Assert
    assertNull(stream.getImage(new PDResources()));
  }
}
