package org.apache.pdfbox.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.tiff.TIFFFieldNode;
import com.github.jaiimageio.plugins.tiff.TIFFField;
import com.github.jaiimageio.plugins.tiff.TIFFTag;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

class XMLUtilDiffblueTest {
  /**
   * Test {@link XMLUtil#parse(InputStream, boolean)} with {@code is}, {@code nsAware}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#parse(InputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(InputStream, boolean) with 'is', 'nsAware'; given IOException(); then calls read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document XMLUtil.parse(InputStream, boolean)"})
  void testParseWithIsNsAware_givenIOException_thenCallsRead() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> XMLUtil.parse(is, true));
    verify(is).read();
  }

  /**
   * Test {@link XMLUtil#parse(InputStream, boolean)} with {@code is}, {@code nsAware}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#parse(InputStream, boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(InputStream, boolean) with 'is', 'nsAware'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document XMLUtil.parse(InputStream, boolean)"})
  void testParseWithIsNsAware_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), true));
  }

  /**
   * Test {@link XMLUtil#parse(InputStream)} with {@code is}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#parse(InputStream)}
   */
  @Test
  @DisplayName("Test parse(InputStream) with 'is'; given IOException(); then calls read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document XMLUtil.parse(InputStream)"})
  void testParseWithIs_givenIOException_thenCallsRead() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> XMLUtil.parse(is));
    verify(is).read();
  }

  /**
   * Test {@link XMLUtil#parse(InputStream)} with {@code is}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#parse(InputStream)}
   */
  @Test
  @DisplayName(
      "Test parse(InputStream) with 'is'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.w3c.dom.Document XMLUtil.parse(InputStream)"})
  void testParseWithIs_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> XMLUtil.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }

  /**
   * Test {@link XMLUtil#getNodeValue(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#getNodeValue(Element)}
   */
  @Test
  @DisplayName("Test getNodeValue(Element); when IIOMetadataNode(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XMLUtil.getNodeValue(Element)"})
  void testGetNodeValue_whenIIOMetadataNode_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", XMLUtil.getNodeValue(new IIOMetadataNode()));
  }

  /**
   * Test {@link XMLUtil#getNodeValue(Element)}.
   *
   * <ul>
   *   <li>When {@link TIFFTag#TIFFTag(String, int, int)} with {@code Name} and number is {@link
   *       TIFFTag#TIFF_SRATIONAL} and dataTypes is one.
   * </ul>
   *
   * <p>Method under test: {@link XMLUtil#getNodeValue(Element)}
   */
  @Test
  @DisplayName(
      "Test getNodeValue(Element); when TIFFTag(String, int, int) with 'Name' and number is TIFF_SRATIONAL and dataTypes is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String XMLUtil.getNodeValue(Element)"})
  void testGetNodeValue_whenTIFFTagWithNameAndNumberIsTiff_srationalAndDataTypesIsOne() {
    // Arrange
    TIFFTag tag = new TIFFTag("Name", TIFFTag.TIFF_SRATIONAL, 1);

    // Act and Assert
    assertEquals("", XMLUtil.getNodeValue(new TIFFFieldNode(new TIFFField(tag, 42))));
  }
}
