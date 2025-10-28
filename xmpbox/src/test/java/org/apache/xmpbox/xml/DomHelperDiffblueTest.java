package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

class DomHelperDiffblueTest {
  /**
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  void testGetUniqueElementChild() throws XmpParsingException {
    // Arrange, Act and Assert
    assertNull(DomHelper.getUniqueElementChild(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  void testGetUniqueElementChild2() throws XmpParsingException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(DomHelper.getUniqueElementChild(description));
  }

  /**
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  void testGetUniqueElementChild3() throws XmpParsingException, DOMException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    description.appendChild(new IIOMetadataNode("foo"));
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act
    Element actualUniqueElementChild = DomHelper.getUniqueElementChild(description);

    // Assert
    assertTrue(actualUniqueElementChild instanceof IIOMetadataNode);
    assertEquals("foo", actualUniqueElementChild.getTagName());
    assertEquals("foo", actualUniqueElementChild.getLocalName());
    assertEquals("foo", actualUniqueElementChild.getNodeName());
    assertNull(((IIOMetadataNode) actualUniqueElementChild).getUserObject());
    assertNull(actualUniqueElementChild.getNamespaceURI());
    assertNull(actualUniqueElementChild.getNodeValue());
    assertNull(actualUniqueElementChild.getPrefix());
    assertNull(actualUniqueElementChild.getOwnerDocument());
    assertNull(actualUniqueElementChild.getFirstChild());
    assertNull(actualUniqueElementChild.getLastChild());
    assertNull(actualUniqueElementChild.getNextSibling());
    assertNull(actualUniqueElementChild.getPreviousSibling());
    assertEquals(0, ((IIOMetadataNode) actualUniqueElementChild).getLength());
    assertEquals((short) 1, actualUniqueElementChild.getNodeType());
    assertFalse(actualUniqueElementChild.hasAttributes());
    assertFalse(actualUniqueElementChild.hasChildNodes());
    assertSame(description, actualUniqueElementChild.getParentNode());
  }

  /**
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  void testGetUniqueElementChild4() throws XmpParsingException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    description.appendChild(new IIOMetadataNode("foo"));
    description.appendChild(new IIOMetadataNode("foo"));
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> DomHelper.getUniqueElementChild(description));
  }

  /**
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  void testGetFirstChildElement() {
    // Arrange, Act and Assert
    assertNull(DomHelper.getFirstChildElement(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  void testGetFirstChildElement2() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(DomHelper.getFirstChildElement(description));
  }

  /**
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  void testGetFirstChildElement3() throws DOMException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    description.appendChild(new IIOMetadataNode("foo"));
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act
    Element actualFirstChildElement = DomHelper.getFirstChildElement(description);

    // Assert
    assertTrue(actualFirstChildElement instanceof IIOMetadataNode);
    assertEquals("foo", actualFirstChildElement.getTagName());
    assertEquals("foo", actualFirstChildElement.getLocalName());
    assertEquals("foo", actualFirstChildElement.getNodeName());
    assertNull(((IIOMetadataNode) actualFirstChildElement).getUserObject());
    assertNull(actualFirstChildElement.getNamespaceURI());
    assertNull(actualFirstChildElement.getNodeValue());
    assertNull(actualFirstChildElement.getPrefix());
    assertNull(actualFirstChildElement.getOwnerDocument());
    assertNull(actualFirstChildElement.getFirstChild());
    assertNull(actualFirstChildElement.getLastChild());
    assertNull(actualFirstChildElement.getNextSibling());
    assertNull(actualFirstChildElement.getPreviousSibling());
    assertEquals(0, ((IIOMetadataNode) actualFirstChildElement).getLength());
    assertEquals((short) 1, actualFirstChildElement.getNodeType());
    assertFalse(actualFirstChildElement.hasAttributes());
    assertFalse(actualFirstChildElement.hasChildNodes());
    assertSame(description, actualFirstChildElement.getParentNode());
  }

  /**
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  void testGetElementChildren() {
    // Arrange and Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(actualElementChildren.isEmpty());
  }

  /**
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  void testGetElementChildren2() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(description);

    // Assert
    assertTrue(actualElementChildren.isEmpty());
  }

  /**
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  void testGetElementChildren3() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.appendChild(iioMetadataNode);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode2, new IIOMetadataNode("foo"));

    // Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(description);

    // Assert
    assertEquals(1, actualElementChildren.size());
    assertSame(iioMetadataNode, actualElementChildren.get(0));
  }

  /**
   * Method under test: {@link DomHelper#getQName(Element)}
   */
  @Test
  void testGetQName() {
    // Arrange and Act
    QName actualQName = DomHelper.getQName(new IIOMetadataNode("foo"));

    // Assert
    assertEquals("", actualQName.getNamespaceURI());
    assertEquals("", actualQName.getPrefix());
    assertEquals("foo", actualQName.getLocalPart());
  }

  /**
   * Method under test: {@link DomHelper#isRdfDescription(Element)}
   */
  @Test
  void testIsRdfDescription() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isRdfDescription(new IIOMetadataNode("foo")));
  }

  /**
   * Method under test: {@link DomHelper#isParseTypeResource(Element)}
   */
  @Test
  void testIsParseTypeResource() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isParseTypeResource(new IIOMetadataNode("foo")));
  }
}
