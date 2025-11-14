package org.apache.xmpbox.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

class DomHelperDiffblueTest {
  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); given IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getUniqueElementChild(Element)"})
  void testGetUniqueElementChild_givenIIOMetadataNode_thenReturnNull() throws XmpParsingException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act and Assert
    assertNull(DomHelper.getUniqueElementChild(description));
  }

  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   *
   * <ul>
   *   <li>Then ParentNode return {@link IIOMetadataNode}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); then ParentNode return IIOMetadataNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getUniqueElementChild(Element)"})
  void testGetUniqueElementChild_thenParentNodeReturnIIOMetadataNode()
      throws XmpParsingException, DOMException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    description.appendChild(new IIOMetadataNode());
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act
    Element actualUniqueElementChild = DomHelper.getUniqueElementChild(description);

    // Assert
    Node parentNode = actualUniqueElementChild.getParentNode();
    assertTrue(parentNode instanceof IIOMetadataNode);
    assertTrue(actualUniqueElementChild instanceof IIOMetadataNode);
    assertNull(((IIOMetadataNode) actualUniqueElementChild).getUserObject());
    assertNull(actualUniqueElementChild.getTagName());
    assertNull(actualUniqueElementChild.getLocalName());
    assertNull(actualUniqueElementChild.getNamespaceURI());
    assertNull(actualUniqueElementChild.getNodeName());
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
    assertSame(description, parentNode);
  }

  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   *
   * <ul>
   *   <li>Then throw {@link XmpParsingException}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); then throw XmpParsingException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getUniqueElementChild(Element)"})
  void testGetUniqueElementChild_thenThrowXmpParsingException() throws XmpParsingException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    description.appendChild(new IIOMetadataNode());
    description.appendChild(new IIOMetadataNode());
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act and Assert
    assertThrows(XmpParsingException.class, () -> DomHelper.getUniqueElementChild(description));
  }

  /**
   * Test {@link DomHelper#getUniqueElementChild(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getUniqueElementChild(Element)}
   */
  @Test
  @DisplayName("Test getUniqueElementChild(Element); when IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getUniqueElementChild(Element)"})
  void testGetUniqueElementChild_whenIIOMetadataNode_thenReturnNull() throws XmpParsingException {
    // Arrange, Act and Assert
    assertNull(DomHelper.getUniqueElementChild(new IIOMetadataNode()));
  }

  /**
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); given IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getFirstChildElement(Element)"})
  void testGetFirstChildElement_givenIIOMetadataNode_thenReturnNull() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act and Assert
    assertNull(DomHelper.getFirstChildElement(description));
  }

  /**
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   *
   * <ul>
   *   <li>Then ParentNode return {@link IIOMetadataNode}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); then ParentNode return IIOMetadataNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getFirstChildElement(Element)"})
  void testGetFirstChildElement_thenParentNodeReturnIIOMetadataNode() throws DOMException {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    description.appendChild(new IIOMetadataNode());
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act
    Element actualFirstChildElement = DomHelper.getFirstChildElement(description);

    // Assert
    Node parentNode = actualFirstChildElement.getParentNode();
    assertTrue(parentNode instanceof IIOMetadataNode);
    assertTrue(actualFirstChildElement instanceof IIOMetadataNode);
    assertNull(((IIOMetadataNode) actualFirstChildElement).getUserObject());
    assertNull(actualFirstChildElement.getTagName());
    assertNull(actualFirstChildElement.getLocalName());
    assertNull(actualFirstChildElement.getNamespaceURI());
    assertNull(actualFirstChildElement.getNodeName());
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
    assertSame(description, parentNode);
  }

  /**
   * Test {@link DomHelper#getFirstChildElement(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getFirstChildElement(Element)}
   */
  @Test
  @DisplayName("Test getFirstChildElement(Element); when IIOMetadataNode(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Element DomHelper.getFirstChildElement(Element)"})
  void testGetFirstChildElement_whenIIOMetadataNode_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DomHelper.getFirstChildElement(new IIOMetadataNode()));
  }

  /**
   * Test {@link DomHelper#getElementChildren(Element)}.
   *
   * <ul>
   *   <li>Given {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); given IIOMetadataNode(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DomHelper.getElementChildren(Element)"})
  void testGetElementChildren_givenIIOMetadataNode_thenReturnEmpty() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode, new IIOMetadataNode());

    // Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(description);

    // Assert
    assertTrue(actualElementChildren.isEmpty());
  }

  /**
   * Test {@link DomHelper#getElementChildren(Element)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DomHelper.getElementChildren(Element)"})
  void testGetElementChildren_thenReturnSizeIsOne() {
    // Arrange
    IIOMetadataNode description = new IIOMetadataNode();
    IIOMetadataNode iioMetadataNode = new IIOMetadataNode();
    description.appendChild(iioMetadataNode);
    IIOMetadataNode iioMetadataNode2 = new IIOMetadataNode();
    description.insertBefore(iioMetadataNode2, new IIOMetadataNode());

    // Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(description);

    // Assert
    assertEquals(1, actualElementChildren.size());
    assertSame(iioMetadataNode, actualElementChildren.get(0));
  }

  /**
   * Test {@link DomHelper#getElementChildren(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getElementChildren(Element)}
   */
  @Test
  @DisplayName("Test getElementChildren(Element); when IIOMetadataNode(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DomHelper.getElementChildren(Element)"})
  void testGetElementChildren_whenIIOMetadataNode_thenReturnEmpty() {
    // Arrange and Act
    List<Element> actualElementChildren = DomHelper.getElementChildren(new IIOMetadataNode());

    // Assert
    assertTrue(actualElementChildren.isEmpty());
  }

  /**
   * Test {@link DomHelper#getQName(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode(String)} with {@code Node Name}.
   *   <li>Then return NamespaceURI is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#getQName(Element)}
   */
  @Test
  @DisplayName(
      "Test getQName(Element); when IIOMetadataNode(String) with 'Node Name'; then return NamespaceURI is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"QName DomHelper.getQName(Element)"})
  void testGetQName_whenIIOMetadataNodeWithNodeName_thenReturnNamespaceURIIsEmptyString() {
    // Arrange and Act
    QName actualQName = DomHelper.getQName(new IIOMetadataNode("Node Name"));

    // Assert
    assertEquals("", actualQName.getNamespaceURI());
    assertEquals("", actualQName.getPrefix());
    assertEquals("Node Name", actualQName.getLocalPart());
  }

  /**
   * Test {@link DomHelper#isRdfDescription(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#isRdfDescription(Element)}
   */
  @Test
  @DisplayName("Test isRdfDescription(Element); when IIOMetadataNode(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DomHelper.isRdfDescription(Element)"})
  void testIsRdfDescription_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isRdfDescription(new IIOMetadataNode()));
  }

  /**
   * Test {@link DomHelper#isParseTypeResource(Element)}.
   *
   * <ul>
   *   <li>When {@link IIOMetadataNode#IIOMetadataNode()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DomHelper#isParseTypeResource(Element)}
   */
  @Test
  @DisplayName("Test isParseTypeResource(Element); when IIOMetadataNode(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DomHelper.isParseTypeResource(Element)"})
  void testIsParseTypeResource_whenIIOMetadataNode_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(DomHelper.isParseTypeResource(new IIOMetadataNode()));
  }
}
