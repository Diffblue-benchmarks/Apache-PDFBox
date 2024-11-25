package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class XMLUtilDiffblueTest {
  /**
   * Test {@link XMLUtil#parse(InputStream, boolean)} with {@code is},
   * {@code nsAware}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLUtil#parse(InputStream, boolean)}
   */
  @Test
  @DisplayName("Test parse(InputStream, boolean) with 'is', 'nsAware'; then throw IOException")
  void testParseWithIsNsAware_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), true));
  }

  /**
   * Test {@link XMLUtil#parse(InputStream)} with {@code is}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLUtil#parse(InputStream)}
   */
  @Test
  @DisplayName("Test parse(InputStream) with 'is'; then throw IOException")
  void testParseWithIs_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link XMLUtil#getNodeValue(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLUtil#getNodeValue(Element)}
   */
  @Test
  @DisplayName("Test getNodeValue(Element); when IIOMetadataNode(String) with 'foo'; then return empty string")
  void testGetNodeValue_whenIIOMetadataNodeWithFoo_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", XMLUtil.getNodeValue(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link XMLUtil#getNodeValue(Element)}.
   * <ul>
   *   <li>When {@link TIFFTag#TIFFTag(String, int, int)} with {@code Name} and
   * number is {@link TIFFTag#TIFF_SRATIONAL} and dataTypes is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link XMLUtil#getNodeValue(Element)}
   */
  @Test
  @DisplayName("Test getNodeValue(Element); when TIFFTag(String, int, int) with 'Name' and number is TIFF_SRATIONAL and dataTypes is one")
  void testGetNodeValue_whenTIFFTagWithNameAndNumberIsTiff_srationalAndDataTypesIsOne() {
    // Arrange, Act and Assert
    assertEquals("",
        XMLUtil.getNodeValue(new TIFFFieldNode(new TIFFField(new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1), 42))));
  }
}
