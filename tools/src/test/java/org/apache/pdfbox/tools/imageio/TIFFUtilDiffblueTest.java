package org.apache.pdfbox.tools.imageio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.github.jaiimageio.impl.plugins.raw.RawImageWriteParam;
import com.github.jaiimageio.impl.plugins.tiff.TIFFIFD;
import com.github.jaiimageio.impl.plugins.tiff.TIFFImageMetadata;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

class TIFFUtilDiffblueTest {
  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   * <ul>
   *   <li>Then calls {@link ImageWriteParam#setCompressionType(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName("Test setCompressionType(ImageWriteParam, BufferedImage); then calls setCompressionType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TIFFUtil.setCompressionType(ImageWriteParam, BufferedImage)"})
  void testSetCompressionType_thenCallsSetCompressionType() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, 1));

    // Assert
    verify(param).setCompressionType(eq("LZW"));
  }

  /**
   * Test {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}.
   * <ul>
   *   <li>When {@link BufferedImage#BufferedImage(int, int, int)} with one and one and {@link BufferedImage#TYPE_BYTE_BINARY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  @DisplayName("Test setCompressionType(ImageWriteParam, BufferedImage); when BufferedImage(int, int, int) with one and one and TYPE_BYTE_BINARY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TIFFUtil.setCompressionType(ImageWriteParam, BufferedImage)"})
  void testSetCompressionType_whenBufferedImageWithOneAndOneAndType_byte_binary() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert
    verify(param).setCompressionType(eq("CCITT T.6"));
  }

  /**
   * Test {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}.
   * <p>
   * Method under test: {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}
   */
  @Test
  @DisplayName("Test updateMetadata(IIOMetadata, BufferedImage, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TIFFUtil.updateMetadata(IIOMetadata, BufferedImage, int)"})
  void testUpdateMetadata() throws IIOInvalidTreeException, DOMException {
    // Arrange
    TIFFImageMetadata metadata = new TIFFImageMetadata(new TIFFIFD(new ArrayList<>()));

    // Act
    TIFFUtil.updateMetadata(metadata, new BufferedImage(1, 1, 1), 1);

    // Assert
    IIOMetadataNode standardDimensionNode = metadata.getStandardDimensionNode();
    assertTrue(standardDimensionNode.getFirstChild() instanceof IIOMetadataNode);
    IIOMetadataNode standardTextNode = metadata.getStandardTextNode();
    Node firstChild = standardTextNode.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    assertTrue(standardDimensionNode.getLastChild() instanceof IIOMetadataNode);
    assertEquals("Text", standardTextNode.getLocalName());
    assertEquals("Text", standardTextNode.getNodeName());
    assertEquals("Text", standardTextNode.getTagName());
    assertNull(standardTextNode.getUserObject());
    assertNull(standardTextNode.getNamespaceURI());
    assertNull(standardTextNode.getNodeValue());
    assertNull(standardTextNode.getPrefix());
    assertNull(standardTextNode.getOwnerDocument());
    assertNull(standardTextNode.getNextSibling());
    assertNull(standardTextNode.getParentNode());
    assertNull(standardTextNode.getPreviousSibling());
    assertEquals(1, standardTextNode.getLength());
    assertEquals((short) 1, standardTextNode.getNodeType());
    assertEquals(3, standardDimensionNode.getLength());
    TIFFIFD rootIFD = metadata.getRootIFD();
    assertEquals(5, rootIFD.getNumTIFFFields());
    assertEquals(5, rootIFD.getTIFFFields().length);
    assertFalse(standardTextNode.hasAttributes());
    assertTrue(standardDimensionNode.hasChildNodes());
    assertTrue(standardTextNode.hasChildNodes());
    assertSame(firstChild, standardTextNode.getLastChild());
  }
}
