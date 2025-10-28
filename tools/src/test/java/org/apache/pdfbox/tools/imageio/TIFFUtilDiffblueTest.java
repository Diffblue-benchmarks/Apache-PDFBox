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
import com.github.jaiimageio.impl.plugins.raw.RawImageWriteParam;
import com.github.jaiimageio.impl.plugins.tiff.TIFFIFD;
import com.github.jaiimageio.impl.plugins.tiff.TIFFImageMetadata;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageWriteParam;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

class TIFFUtilDiffblueTest {
  /**
   * Method under test:
   * {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  void testSetCompressionType() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, 1));

    // Assert that nothing has changed
    verify(param).setCompressionType(eq("LZW"));
  }

  /**
   * Method under test:
   * {@link TIFFUtil#setCompressionType(ImageWriteParam, BufferedImage)}
   */
  @Test
  void testSetCompressionType2() {
    // Arrange
    RawImageWriteParam param = mock(RawImageWriteParam.class);
    doNothing().when(param).setCompressionType(Mockito.<String>any());

    // Act
    TIFFUtil.setCompressionType(param, new BufferedImage(1, 1, BufferedImage.TYPE_BYTE_BINARY));

    // Assert that nothing has changed
    verify(param).setCompressionType(eq("CCITT T.6"));
  }

  /**
   * Method under test:
   * {@link TIFFUtil#updateMetadata(IIOMetadata, BufferedImage, int)}
   */
  @Test
  void testUpdateMetadata() throws IIOInvalidTreeException, DOMException {
    // Arrange
    TIFFIFD ifd = new TIFFIFD(new ArrayList<>());
    TIFFImageMetadata metadata = new TIFFImageMetadata(ifd);

    // Act
    TIFFUtil.updateMetadata(metadata, new BufferedImage(1, 1, 1), 1);

    // Assert
    IIOMetadataNode standardDimensionNode = metadata.getStandardDimensionNode();
    Node firstChild = standardDimensionNode.getFirstChild();
    assertTrue(firstChild instanceof IIOMetadataNode);
    TIFFImageMetadata shallowClone = metadata.getShallowClone();
    IIOMetadataNode standardDimensionNode2 = shallowClone.getStandardDimensionNode();
    assertTrue(standardDimensionNode2.getFirstChild() instanceof IIOMetadataNode);
    TIFFImageMetadata shallowClone2 = shallowClone.getShallowClone();
    IIOMetadataNode standardDimensionNode3 = shallowClone2.getStandardDimensionNode();
    assertTrue(standardDimensionNode3.getFirstChild() instanceof IIOMetadataNode);
    IIOMetadataNode standardTextNode = metadata.getStandardTextNode();
    Node firstChild2 = standardTextNode.getFirstChild();
    assertTrue(firstChild2 instanceof IIOMetadataNode);
    IIOMetadataNode standardTextNode2 = shallowClone.getStandardTextNode();
    Node firstChild3 = standardTextNode2.getFirstChild();
    assertTrue(firstChild3 instanceof IIOMetadataNode);
    IIOMetadataNode standardTextNode3 = shallowClone2.getStandardTextNode();
    assertTrue(standardTextNode3.getFirstChild() instanceof IIOMetadataNode);
    Node lastChild = standardDimensionNode.getLastChild();
    assertTrue(lastChild instanceof IIOMetadataNode);
    assertTrue(standardDimensionNode2.getLastChild() instanceof IIOMetadataNode);
    assertTrue(standardDimensionNode3.getLastChild() instanceof IIOMetadataNode);
    Node nextSibling = firstChild.getNextSibling();
    assertTrue(nextSibling instanceof IIOMetadataNode);
    assertEquals("PixelAspectRatio", ((IIOMetadataNode) firstChild).getTagName());
    assertEquals("PixelAspectRatio", firstChild.getLocalName());
    assertEquals("PixelAspectRatio", firstChild.getNodeName());
    assertEquals("Text", standardTextNode.getLocalName());
    assertEquals("Text", standardTextNode2.getLocalName());
    assertEquals("Text", standardTextNode3.getLocalName());
    assertEquals("Text", standardTextNode.getNodeName());
    assertEquals("Text", standardTextNode2.getNodeName());
    assertEquals("Text", standardTextNode3.getNodeName());
    assertEquals("Text", standardTextNode.getTagName());
    assertEquals("Text", standardTextNode2.getTagName());
    assertEquals("Text", standardTextNode3.getTagName());
    assertEquals("TextEntry", ((IIOMetadataNode) firstChild2).getTagName());
    assertEquals("TextEntry", firstChild2.getLocalName());
    assertEquals("TextEntry", firstChild2.getNodeName());
    assertEquals("VerticalPixelSize", ((IIOMetadataNode) lastChild).getTagName());
    assertEquals("VerticalPixelSize", lastChild.getLocalName());
    assertEquals("VerticalPixelSize", lastChild.getNodeName());
    assertNull(standardTextNode.getUserObject());
    assertNull(standardTextNode2.getUserObject());
    assertNull(standardTextNode3.getUserObject());
    assertNull(((IIOMetadataNode) firstChild).getUserObject());
    assertNull(((IIOMetadataNode) firstChild2).getUserObject());
    assertNull(((IIOMetadataNode) lastChild).getUserObject());
    assertNull(standardTextNode.getNamespaceURI());
    assertNull(standardTextNode2.getNamespaceURI());
    assertNull(standardTextNode3.getNamespaceURI());
    assertNull(standardTextNode.getNodeValue());
    assertNull(standardTextNode2.getNodeValue());
    assertNull(standardTextNode3.getNodeValue());
    assertNull(standardTextNode.getPrefix());
    assertNull(standardTextNode2.getPrefix());
    assertNull(standardTextNode3.getPrefix());
    assertNull(firstChild.getNamespaceURI());
    assertNull(firstChild2.getNamespaceURI());
    assertNull(lastChild.getNamespaceURI());
    assertNull(firstChild.getNodeValue());
    assertNull(firstChild2.getNodeValue());
    assertNull(lastChild.getNodeValue());
    assertNull(firstChild.getPrefix());
    assertNull(firstChild2.getPrefix());
    assertNull(lastChild.getPrefix());
    assertNull(standardTextNode.getOwnerDocument());
    assertNull(standardTextNode2.getOwnerDocument());
    assertNull(standardTextNode3.getOwnerDocument());
    assertNull(firstChild.getOwnerDocument());
    assertNull(firstChild2.getOwnerDocument());
    assertNull(lastChild.getOwnerDocument());
    assertNull(standardTextNode.getNextSibling());
    assertNull(standardTextNode2.getNextSibling());
    assertNull(standardTextNode3.getNextSibling());
    assertNull(standardTextNode.getParentNode());
    assertNull(standardTextNode2.getParentNode());
    assertNull(standardTextNode3.getParentNode());
    assertNull(standardTextNode.getPreviousSibling());
    assertNull(standardTextNode2.getPreviousSibling());
    assertNull(standardTextNode3.getPreviousSibling());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild2.getFirstChild());
    assertNull(lastChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild2.getLastChild());
    assertNull(lastChild.getLastChild());
    assertNull(firstChild2.getNextSibling());
    assertNull(lastChild.getNextSibling());
    assertNull(firstChild.getPreviousSibling());
    assertNull(firstChild2.getPreviousSibling());
    assertEquals(0, ((IIOMetadataNode) firstChild).getLength());
    assertEquals(0, ((IIOMetadataNode) firstChild2).getLength());
    assertEquals(0, ((IIOMetadataNode) lastChild).getLength());
    assertEquals(1, standardTextNode.getLength());
    assertEquals(1, standardTextNode2.getLength());
    assertEquals(1, standardTextNode3.getLength());
    assertEquals((short) 1, standardTextNode.getNodeType());
    assertEquals((short) 1, standardTextNode2.getNodeType());
    assertEquals((short) 1, standardTextNode3.getNodeType());
    assertEquals((short) 1, firstChild.getNodeType());
    assertEquals((short) 1, firstChild2.getNodeType());
    assertEquals((short) 1, lastChild.getNodeType());
    assertEquals(3, standardDimensionNode.getLength());
    assertEquals(3, standardDimensionNode2.getLength());
    assertEquals(3, standardDimensionNode3.getLength());
    assertFalse(standardTextNode.hasAttributes());
    assertFalse(standardTextNode2.hasAttributes());
    assertFalse(standardTextNode3.hasAttributes());
    assertFalse(firstChild.hasChildNodes());
    assertFalse(firstChild2.hasChildNodes());
    assertFalse(lastChild.hasChildNodes());
    assertTrue(standardDimensionNode.hasChildNodes());
    assertTrue(standardDimensionNode2.hasChildNodes());
    assertTrue(standardDimensionNode3.hasChildNodes());
    assertTrue(standardTextNode.hasChildNodes());
    assertTrue(standardTextNode2.hasChildNodes());
    assertTrue(standardTextNode3.hasChildNodes());
    assertTrue(firstChild.hasAttributes());
    assertTrue(firstChild2.hasAttributes());
    assertTrue(lastChild.hasAttributes());
    assertSame(ifd, metadata.getRootIFD());
    assertSame(standardDimensionNode, firstChild.getParentNode());
    assertSame(standardDimensionNode, lastChild.getParentNode());
    assertSame(standardTextNode, firstChild2.getParentNode());
    assertSame(firstChild3, standardTextNode2.getLastChild());
    assertSame(nextSibling, lastChild.getPreviousSibling());
  }
}
