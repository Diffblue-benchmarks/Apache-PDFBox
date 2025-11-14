package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOutlineNodeDiffblueTest {
  /**
   * Test {@link PDOutlineNode#getParent()}.
   *
   * <p>Method under test: {@link PDOutlineNode#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineNode PDOutlineNode.getParent()"})
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull(new PDDocumentOutline().getParent());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDOutlineNode parent = mock(PDOutlineNode.class);
    when(parent.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(parent).getCOSObject();
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    assertNull(((PDOutlineItem) parent2).getTitle());
    assertNull(((PDOutlineItem) parent2).getStructureElement());
    assertNull(((PDOutlineItem) parent2).getAction());
    assertNull(((PDOutlineItem) parent2).getDestination());
    assertNull(((PDOutlineItem) parent2).getNextSibling());
    assertNull(((PDOutlineItem) parent2).getPreviousSibling());
    assertNull(parent2.getFirstChild());
    assertNull(parent2.getLastChild());
    assertNull(parent2.getParent());
    assertEquals(0, parent2.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDOutlineItem) parent2).isBold());
    assertFalse(((PDOutlineItem) parent2).isItalic());
    assertFalse(parent2.hasChildren());
    assertFalse(parent2.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSDictionary#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDOutlineNode); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDOutlineNode parent = mock(PDOutlineNode.class);
    when(parent.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(parent).getCOSObject();
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    assertNull(((PDOutlineItem) parent2).getTitle());
    assertNull(((PDOutlineItem) parent2).getStructureElement());
    assertNull(((PDOutlineItem) parent2).getAction());
    assertNull(((PDOutlineItem) parent2).getDestination());
    assertNull(((PDOutlineItem) parent2).getNextSibling());
    assertNull(((PDOutlineItem) parent2).getPreviousSibling());
    assertNull(parent2.getFirstChild());
    assertNull(parent2.getLastChild());
    assertNull(parent2.getParent());
    assertEquals(0, parent2.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDOutlineItem) parent2).isBold());
    assertFalse(((PDOutlineItem) parent2).isItalic());
    assertFalse(parent2.hasChildren());
    assertFalse(parent2.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDOutlineNode); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDOutlineNode parent = mock(PDOutlineNode.class);
    when(parent.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.setParent(parent));
    verify(cosDictionary).isDirect();
    verify(parent).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_givenIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode parent = mock(PDOutlineNode.class);
    when(parent.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.setParent(parent));
    verify(parent).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);

    PDOutlineNode parent = mock(PDOutlineNode.class);
    when(parent.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(parent).getCOSObject();
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    assertNull(((PDOutlineItem) parent2).getTitle());
    assertNull(((PDOutlineItem) parent2).getStructureElement());
    assertNull(((PDOutlineItem) parent2).getAction());
    assertNull(((PDOutlineItem) parent2).getDestination());
    assertNull(((PDOutlineItem) parent2).getNextSibling());
    assertNull(((PDOutlineItem) parent2).getPreviousSibling());
    assertNull(parent2.getFirstChild());
    assertNull(parent2.getLastChild());
    assertNull(parent2.getParent());
    assertEquals(0, parent2.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(((PDOutlineItem) parent2).isBold());
    assertFalse(((PDOutlineItem) parent2).isItalic());
    assertFalse(parent2.hasChildren());
    assertFalse(parent2.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} Parent TextColor ColorSpace {@link
   *       PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDOutlineNode); then PDDocumentOutline() Parent TextColor ColorSpace PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_thenPDDocumentOutlineParentTextColorColorSpacePDDeviceRGB() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode parent = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(parent.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    verify(parent).getCOSObject();
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    PDColor textColor = ((PDOutlineItem) parent2).getTextColor();
    assertTrue(textColor.getColorSpace() instanceof PDDeviceRGB);
    assertTrue(parent2 instanceof PDOutlineItem);
    assertSame(cosDictionary, parent2.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setParent(PDOutlineNode); when 'null'; then PDDocumentOutline() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_whenNull_thenPDDocumentOutlineCOSObjectValuesSizeIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setParent(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); when PDDocumentOutline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setParent(PDOutlineNode)"})
  void testSetParent_whenPDDocumentOutline() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline parent = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert that nothing has changed
    COSDictionary cOSObject = parent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#addLast(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#addLast(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test addLast(PDOutlineItem); given PDOutlineItem(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.addLast(PDOutlineItem)"})
  void testAddLast_givenPDOutlineItem_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addLast(newChild));
  }

  /**
   * Test {@link PDOutlineNode#addLast(PDOutlineItem)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} PreviousSibling is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#addLast(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test addLast(PDOutlineItem); when PDOutlineItem(); then PDOutlineItem() PreviousSibling is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.addLast(PDOutlineItem)"})
  void testAddLast_whenPDOutlineItem_thenPDOutlineItemPreviousSiblingIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();

    // Act
    pdDocumentOutline.addLast(newChild);

    // Assert
    assertNull(newChild.getPreviousSibling());
    assertEquals(1, pdDocumentOutline.getOpenCount());
    assertTrue(pdDocumentOutline.hasChildren());
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
    assertEquals(newChild, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#addFirst(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#addFirst(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test addFirst(PDOutlineItem); given PDOutlineItem(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.addFirst(PDOutlineItem)"})
  void testAddFirst_givenPDOutlineItem_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addFirst(newChild));
  }

  /**
   * Test {@link PDOutlineNode#addFirst(PDOutlineItem)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} NextSibling is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#addFirst(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test addFirst(PDOutlineItem); when PDOutlineItem(); then PDOutlineItem() NextSibling is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.addFirst(PDOutlineItem)"})
  void testAddFirst_whenPDOutlineItem_thenPDOutlineItemNextSiblingIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();

    // Act
    pdDocumentOutline.addFirst(newChild);

    // Assert
    assertNull(newChild.getNextSibling());
    assertEquals(1, pdDocumentOutline.getOpenCount());
    assertTrue(pdDocumentOutline.hasChildren());
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
    assertEquals(newChild, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test requireSingleNode(PDOutlineItem); given PDOutlineItem(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.requireSingleNode(PDOutlineItem)"})
  void testRequireSingleNode_givenPDOutlineItem_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem node = new PDOutlineItem();
    node.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.requireSingleNode(node));
  }

  /**
   * Test {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test requireSingleNode(PDOutlineItem); when PDOutlineItem(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.requireSingleNode(PDOutlineItem)"})
  void testRequireSingleNode_whenPDOutlineItem_thenDoesNotThrow() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act and Assert
    assertDoesNotThrow(() -> pdDocumentOutline.requireSingleNode(new PDOutlineItem()));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   *
   * <p>Method under test: {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test updateParentOpenCountForAddedChild(PDOutlineItem)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.updateParentOpenCountForAddedChild(PDOutlineItem)"})
  void testUpdateParentOpenCountForAddedChild() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertDoesNotThrow(() -> pdDocumentOutline.updateParentOpenCountForAddedChild(newChild));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link PDOutlineItem#updateParentOpenCount(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test updateParentOpenCountForAddedChild(PDOutlineItem); given three; then calls updateParentOpenCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.updateParentOpenCountForAddedChild(PDOutlineItem)"})
  void testUpdateParentOpenCountForAddedChild_givenThree_thenCallsUpdateParentOpenCount() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = mock(PDOutlineItem.class);
    when(newChild.getOpenCount()).thenReturn(3);
    when(newChild.isNodeOpen()).thenReturn(true);
    doNothing().when(newChild).insertSiblingAfter(Mockito.<PDOutlineItem>any());
    doNothing().when(newChild).updateParentOpenCount(anyInt());
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act
    pdDocumentOutline.updateParentOpenCountForAddedChild(newChild);

    // Assert
    verify(newChild).insertSiblingAfter(isA(PDOutlineItem.class));
    verify(newChild).getOpenCount();
    verify(newChild).isNodeOpen();
    verify(newChild).updateParentOpenCount(4);
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test updateParentOpenCountForAddedChild(PDOutlineItem); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.updateParentOpenCountForAddedChild(PDOutlineItem)"})
  void testUpdateParentOpenCountForAddedChild_thenThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = mock(PDOutlineItem.class);
    when(newChild.getOpenCount()).thenThrow(new IllegalArgumentException());
    when(newChild.isNodeOpen()).thenReturn(true);
    doNothing().when(newChild).insertSiblingAfter(Mockito.<PDOutlineItem>any());
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> pdDocumentOutline.updateParentOpenCountForAddedChild(newChild));
    verify(newChild).insertSiblingAfter(isA(PDOutlineItem.class));
    verify(newChild).getOpenCount();
    verify(newChild).isNodeOpen();
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} addLast {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test updateParentOpenCountForAddedChild(PDOutlineItem); when PDOutlineItem() addLast PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.updateParentOpenCountForAddedChild(PDOutlineItem)"})
  void testUpdateParentOpenCountForAddedChild_whenPDOutlineItemAddLastPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.addLast(new PDOutlineItem());
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertDoesNotThrow(() -> pdDocumentOutline.updateParentOpenCountForAddedChild(newChild));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   *
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName(
      "Test updateParentOpenCountForAddedChild(PDOutlineItem); when PDOutlineItem(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.updateParentOpenCountForAddedChild(PDOutlineItem)"})
  void testUpdateParentOpenCountForAddedChild_whenPDOutlineItem_thenDoesNotThrow() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act and Assert
    assertDoesNotThrow(
        () -> pdDocumentOutline.updateParentOpenCountForAddedChild(new PDOutlineItem()));
  }

  /**
   * Test {@link PDOutlineNode#hasChildren()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()} addLast {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#hasChildren()}
   */
  @Test
  @DisplayName(
      "Test hasChildren(); given PDDocumentOutline() addLast PDOutlineItem(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineNode.hasChildren()"})
  void testHasChildren_givenPDDocumentOutlineAddLastPDOutlineItem_thenReturnTrue() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(new PDOutlineItem());

    // Act and Assert
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#hasChildren()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#hasChildren()}
   */
  @Test
  @DisplayName("Test hasChildren(); given PDDocumentOutline(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineNode.hasChildren()"})
  void testHasChildren_givenPDDocumentOutline_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDDocumentOutline().hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#getOutlineItem(COSName)}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getOutlineItem(COSName)}
   */
  @Test
  @DisplayName("Test getOutlineItem(COSName); when A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getOutlineItem(COSName)"})
  void testGetOutlineItem_whenA() {
    // Arrange, Act and Assert
    assertNull(new PDDocumentOutline().getOutlineItem(COSName.A));
  }

  /**
   * Test {@link PDOutlineNode#getOutlineItem(COSName)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getOutlineItem(COSName)}
   */
  @Test
  @DisplayName("Test getOutlineItem(COSName); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getOutlineItem(COSName)"})
  void testGetOutlineItem_whenNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocumentOutline().getOutlineItem(null));
  }

  /**
   * Test {@link PDOutlineNode#getFirstChild()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getFirstChild()}
   */
  @Test
  @DisplayName("Test getFirstChild(); given PDDocumentOutline(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getFirstChild()"})
  void testGetFirstChild_givenPDDocumentOutline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocumentOutline().getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#getFirstChild()}.
   *
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getFirstChild()}
   */
  @Test
  @DisplayName("Test getFirstChild(); then return PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getFirstChild()"})
  void testGetFirstChild_thenReturnPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(outlineNode).getCOSObject();
    PDOutlineItem firstChild = pdDocumentOutline.getFirstChild();
    assertNull(firstChild.getTitle());
    assertNull(firstChild.getStructureElement());
    assertNull(firstChild.getAction());
    assertNull(firstChild.getDestination());
    assertNull(firstChild.getNextSibling());
    assertNull(firstChild.getPreviousSibling());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getParent());
    assertEquals(0, firstChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(firstChild.isBold());
    assertFalse(firstChild.isItalic());
    assertFalse(firstChild.hasChildren());
    assertFalse(firstChild.isNodeOpen());
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSDictionary#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setFirstChild(PDOutlineNode); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey()
      throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(outlineNode).getCOSObject();
    PDOutlineItem firstChild = pdDocumentOutline.getFirstChild();
    assertNull(firstChild.getTitle());
    assertNull(firstChild.getStructureElement());
    assertNull(firstChild.getAction());
    assertNull(firstChild.getDestination());
    assertNull(firstChild.getNextSibling());
    assertNull(firstChild.getPreviousSibling());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getParent());
    assertEquals(0, firstChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(firstChild.isBold());
    assertFalse(firstChild.isItalic());
    assertFalse(firstChild.hasChildren());
    assertFalse(firstChild.isNodeOpen());
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setFirstChild(PDOutlineNode); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdDocumentOutline.setFirstChild(outlineNode));
    verify(cosDictionary).isDirect();
    verify(outlineNode).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_givenIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdDocumentOutline.setFirstChild(outlineNode));
    verify(outlineNode).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setFirstChild(PDOutlineNode); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(outlineNode).getCOSObject();
    PDOutlineItem firstChild = pdDocumentOutline.getFirstChild();
    assertNull(firstChild.getTitle());
    assertNull(firstChild.getStructureElement());
    assertNull(firstChild.getAction());
    assertNull(firstChild.getDestination());
    assertNull(firstChild.getNextSibling());
    assertNull(firstChild.getPreviousSibling());
    assertNull(firstChild.getFirstChild());
    assertNull(firstChild.getLastChild());
    assertNull(firstChild.getParent());
    assertEquals(0, firstChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(firstChild.isBold());
    assertFalse(firstChild.isItalic());
    assertFalse(firstChild.hasChildren());
    assertFalse(firstChild.isNodeOpen());
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} FirstChild TextColor ColorSpace {@link
   *       PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setFirstChild(PDOutlineNode); then PDDocumentOutline() FirstChild TextColor ColorSpace PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_thenPDDocumentOutlineFirstChildTextColorColorSpacePDDeviceRGB() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    PDOutlineItem firstChild = pdDocumentOutline.getFirstChild();
    PDColor textColor = firstChild.getTextColor();
    assertTrue(textColor.getColorSpace() instanceof PDDeviceRGB);
    assertSame(cosDictionary, firstChild.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setFirstChild(PDOutlineNode); when 'null'; then PDDocumentOutline() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_whenNull_thenPDDocumentOutlineCOSObjectValuesSizeIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setFirstChild(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); when PDDocumentOutline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setFirstChild(PDOutlineNode)"})
  void testSetFirstChild_whenPDDocumentOutline() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline outlineNode = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert that nothing has changed
    COSDictionary cOSObject = outlineNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(outlineNode.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#getLastChild()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getLastChild()}
   */
  @Test
  @DisplayName("Test getLastChild(); given PDDocumentOutline(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getLastChild()"})
  void testGetLastChild_givenPDDocumentOutline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDocumentOutline().getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#getLastChild()}.
   *
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getLastChild()}
   */
  @Test
  @DisplayName("Test getLastChild(); then return PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDOutlineItem PDOutlineNode.getLastChild()"})
  void testGetLastChild_thenReturnPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(outlineNode).getCOSObject();
    PDOutlineItem lastChild = pdDocumentOutline.getLastChild();
    assertNull(lastChild.getTitle());
    assertNull(lastChild.getStructureElement());
    assertNull(lastChild.getAction());
    assertNull(lastChild.getDestination());
    assertNull(lastChild.getNextSibling());
    assertNull(lastChild.getPreviousSibling());
    assertNull(lastChild.getFirstChild());
    assertNull(lastChild.getLastChild());
    assertNull(lastChild.getParent());
    assertEquals(0, lastChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(lastChild.isBold());
    assertFalse(lastChild.isItalic());
    assertFalse(lastChild.hasChildren());
    assertFalse(lastChild.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSDictionary#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setLastChild(PDOutlineNode); given COSDictionary isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_givenCOSDictionaryIsDirectReturnFalse_thenCallsGetKey() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(false);
    when(cosDictionary.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    verify(cosDictionary, atLeast(1)).getKey();
    verify(cosDictionary).isDirect();
    verify(outlineNode).getCOSObject();
    PDOutlineItem lastChild = pdDocumentOutline.getLastChild();
    assertNull(lastChild.getTitle());
    assertNull(lastChild.getStructureElement());
    assertNull(lastChild.getAction());
    assertNull(lastChild.getDestination());
    assertNull(lastChild.getNextSibling());
    assertNull(lastChild.getPreviousSibling());
    assertNull(lastChild.getFirstChild());
    assertNull(lastChild.getLastChild());
    assertNull(lastChild.getParent());
    assertEquals(0, lastChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(lastChild.isBold());
    assertFalse(lastChild.isItalic());
    assertFalse(lastChild.hasChildren());
    assertFalse(lastChild.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#isDirect()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setLastChild(PDOutlineNode); given COSDictionary isDirect() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_givenCOSDictionaryIsDirectThrowIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenThrow(new IllegalArgumentException());

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.setLastChild(outlineNode));
    verify(cosDictionary).isDirect();
    verify(outlineNode).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_givenIllegalArgumentException() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.setLastChild(outlineNode));
    verify(outlineNode).getCOSObject();
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then calls {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setLastChild(PDOutlineNode); then calls setOriginDocumentState(COSDocumentState)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_thenCallsSetOriginDocumentState() throws IOException {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(cosUpdateState);

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getUpdateState();
    verify(cosUpdateState).setOriginDocumentState(isNull());
    verify(outlineNode).getCOSObject();
    PDOutlineItem lastChild = pdDocumentOutline.getLastChild();
    assertNull(lastChild.getTitle());
    assertNull(lastChild.getStructureElement());
    assertNull(lastChild.getAction());
    assertNull(lastChild.getDestination());
    assertNull(lastChild.getNextSibling());
    assertNull(lastChild.getPreviousSibling());
    assertNull(lastChild.getFirstChild());
    assertNull(lastChild.getLastChild());
    assertNull(lastChild.getParent());
    assertEquals(0, lastChild.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(lastChild.isBold());
    assertFalse(lastChild.isItalic());
    assertFalse(lastChild.hasChildren());
    assertFalse(lastChild.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} LastChild TextColor ColorSpace {@link
   *       PDDeviceRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setLastChild(PDOutlineNode); then PDDocumentOutline() LastChild TextColor ColorSpace PDDeviceRGB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_thenPDDocumentOutlineLastChildTextColorColorSpacePDDeviceRGB() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    PDOutlineItem lastChild = pdDocumentOutline.getLastChild();
    PDColor textColor = lastChild.getTextColor();
    assertTrue(textColor.getColorSpace() instanceof PDDeviceRGB);
    assertSame(cosDictionary, lastChild.getCOSObject());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName(
      "Test setLastChild(PDOutlineNode); when 'null'; then PDDocumentOutline() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_whenNull_thenPDDocumentOutlineCOSObjectValuesSizeIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setLastChild(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   *
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); when PDDocumentOutline()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setLastChild(PDOutlineNode)"})
  void testSetLastChild_whenPDDocumentOutline() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline outlineNode = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert that nothing has changed
    COSDictionary cOSObject = outlineNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#getOpenCount()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()} addLast {@link
   *       PDOutlineItem#PDOutlineItem()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getOpenCount()}
   */
  @Test
  @DisplayName(
      "Test getOpenCount(); given PDDocumentOutline() addLast PDOutlineItem(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDOutlineNode.getOpenCount()"})
  void testGetOpenCount_givenPDDocumentOutlineAddLastPDOutlineItem_thenReturnOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(new PDOutlineItem());

    // Act and Assert
    assertEquals(1, pdDocumentOutline.getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#getOpenCount()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#getOpenCount()}
   */
  @Test
  @DisplayName("Test getOpenCount(); given PDDocumentOutline(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDOutlineNode.getOpenCount()"})
  void testGetOpenCount_givenPDDocumentOutline_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDDocumentOutline().getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#setOpenCount(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} OpenCount is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setOpenCount(int)}
   */
  @Test
  @DisplayName(
      "Test setOpenCount(int); when MIN_VALUE; then PDDocumentOutline() OpenCount is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setOpenCount(int)"})
  void testSetOpenCount_whenMin_value_thenPDDocumentOutlineOpenCountIsMin_value() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setOpenCount(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdDocumentOutline.getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#setOpenCount(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} OpenCount is three.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#setOpenCount(int)}
   */
  @Test
  @DisplayName("Test setOpenCount(int); when three; then PDDocumentOutline() OpenCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.setOpenCount(int)"})
  void testSetOpenCount_whenThree_thenPDDocumentOutlineOpenCountIsThree() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setOpenCount(3);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdDocumentOutline.getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#openNode()}.
   *
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} OpenCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#openNode()}
   */
  @Test
  @DisplayName(
      "Test openNode(); given PDDocumentOutline(); then PDDocumentOutline() OpenCount is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.openNode()"})
  void testOpenNode_givenPDDocumentOutline_thenPDDocumentOutlineOpenCountIsZero() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.openNode();

    // Assert that nothing has changed
    assertEquals(0, pdDocumentOutline.getOpenCount());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#openNode()}.
   *
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} FirstChild Parent {@link PDOutlineItem}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#openNode()}
   */
  @Test
  @DisplayName("Test openNode(); then PDOutlineItem() FirstChild Parent PDOutlineItem")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDOutlineNode.openNode()"})
  void testOpenNode_thenPDOutlineItemFirstChildParentPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.addLast(new PDOutlineItem());

    // Act
    pdOutlineItem.openNode();

    // Assert
    PDOutlineNode parent = pdOutlineItem.getFirstChild().getParent();
    assertTrue(parent instanceof PDOutlineItem);
    PDOutlineNode parent2 = pdOutlineItem.getLastChild().getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    assertEquals(1, pdOutlineItem.getOpenCount());
    assertEquals(1, parent.getOpenCount());
    assertEquals(1, parent2.getOpenCount());
    assertTrue(pdOutlineItem.isNodeOpen());
    assertTrue(parent.isNodeOpen());
    assertTrue(parent2.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineNode.isNodeOpen()"})
  void testIsNodeOpen_givenPDOutlineItem() {
    // Arrange, Act and Assert
    assertFalse(new PDOutlineItem().isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} addLast {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem() addLast PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineNode.isNodeOpen()"})
  void testIsNodeOpen_givenPDOutlineItemAddLastPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.addLast(new PDOutlineItem());
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   *
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter {@link
   *       PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDOutlineNode.isNodeOpen()"})
  void testIsNodeOpen_givenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#children()}.
   *
   * <ul>
   *   <li>Then return iterator next is {@link PDOutlineItem#PDOutlineItem()}.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#children()}
   */
  @Test
  @DisplayName("Test children(); then return iterator next is PDOutlineItem()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDOutlineNode.children()"})
  void testChildren_thenReturnIteratorNextIsPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    pdDocumentOutline.addLast(newChild);

    // Act
    Iterator<PDOutlineItem> actualIteratorResult = pdDocumentOutline.children().iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof PDOutlineItemIterator);
    PDOutlineItem actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertEquals(newChild, actualNextResult);
  }

  /**
   * Test {@link PDOutlineNode#children()}.
   *
   * <ul>
   *   <li>Then return spliterator ExactSizeIfKnown is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDOutlineNode#children()}
   */
  @Test
  @DisplayName("Test children(); then return spliterator ExactSizeIfKnown is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable PDOutlineNode.children()"})
  void testChildren_thenReturnSpliteratorExactSizeIfKnownIsMinusOne() {
    // Arrange and Act
    Iterable<PDOutlineItem> actualChildrenResult = new PDDocumentOutline().children();
    Iterator<PDOutlineItem> actualIteratorResult = actualChildrenResult.iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof PDOutlineItemIterator);
    assertEquals(-1L, actualChildrenResult.spliterator().getExactSizeIfKnown());
    assertFalse(actualIteratorResult.hasNext());
  }
}
