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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

class DomHelperDiffblueTest {
  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetUniqueElementChild_givenIIOMetadataNodeWithFoo_thenReturnNull() throws XmpParsingException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(DomHelper.getUniqueElementChild(description));
  }

  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   * <ul>
   *   <li>Then return {@link IIOMetadataNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); then return IIOMetadataNode")
  void testGetUniqueElementChild_thenReturnIIOMetadataNode() throws XmpParsingException, DOMException {
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
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   * <ul>
   *   <li>Then throw {@link XmpParsingException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); then throw XmpParsingException")
  void testGetUniqueElementChild_thenThrowXmpParsingException() throws XmpParsingException {
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
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); when IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetUniqueElementChild_whenIIOMetadataNodeWithFoo_thenReturnNull() throws XmpParsingException {
    // Arrange, Act and Assert
    assertNull(DomHelper.getUniqueElementChild(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); given IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetFirstChildElement_givenIIOMetadataNodeWithFoo_thenReturnNull() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode("foo");
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode("foo");
    description.insertBefore(iioMetadataNode, new IIOMetadataNode("foo"));

    // Act and Assert
    assertNull(DomHelper.getFirstChildElement(description));
  }

  /**
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   * <ul>
   *   <li>Then return {@link IIOMetadataNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); then return IIOMetadataNode")
  void testGetFirstChildElement_thenReturnIIOMetadataNode() throws DOMException {
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
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); when IIOMetadataNode(String) with 'foo'; then return 'null'")
  void testGetFirstChildElement_whenIIOMetadataNodeWithFoo_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DomHelper.getFirstChildElement(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link DomHelper#getElementChildren(Element)}.
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); given IIOMetadataNode(String) with 'foo'; then return Empty")
  void testGetElementChildren_givenIIOMetadataNodeWithFoo_thenReturnEmpty() {
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
   * Test {@link DomHelper#getElementChildren(Element)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); then return size is one")
  void testGetElementChildren_thenReturnSizeIsOne() {
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
   * Test {@link DomHelper#getElementChildren(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); when IIOMetadataNode(String) with 'foo'; then return Empty")
  void testGetElementChildren_whenIIOMetadataNodeWithFoo_thenReturnEmpty() {
    // Arrange and Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(new IIOMetadataNode("foo"));

    // Assert
    assertTrue(actualElementChildren.isEmpty());
  }

  /**
   * Test {@link DomHelper#getQName(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return NamespaceURI is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#getQName(Element)}
   */
  @Test
  @DisplayName("Test getQName(Element); when IIOMetadataNode(String) with 'foo'; then return NamespaceURI is empty string")
  void testGetQName_whenIIOMetadataNodeWithFoo_thenReturnNamespaceURIIsEmptyString() {
    // Arrange and Act
    QName actualQName = DomHelper.getQName(new IIOMetadataNode("foo"));

    // Assert
    assertEquals("", actualQName.getNamespaceURI());
    assertEquals("", actualQName.getPrefix());
    assertEquals("foo", actualQName.getLocalPart());
  }

  /**
   * Test {@link DomHelper#isRdfDescription(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#isRdfDescription(Element)}
   */
  @Test
  @DisplayName("Test isRdfDescription(Element); when IIOMetadataNode(String) with 'foo'; then return 'false'")
  void testIsRdfDescription_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isRdfDescription(new IIOMetadataNode("foo")));
  }

  /**
   * Test {@link DomHelper#isParseTypeResource(Element)}.
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with
   * {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomHelper#isParseTypeResource(Element)}
   */
  @Test
  @DisplayName("Test isParseTypeResource(Element); when IIOMetadataNode(String) with 'foo'; then return 'false'")
  void testIsParseTypeResource_whenIIOMetadataNodeWithFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isParseTypeResource(new IIOMetadataNode("foo")));
  }
}
