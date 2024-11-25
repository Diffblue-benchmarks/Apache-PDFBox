package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOutlineNodeDiffblueTest {
  /**
   * Test {@link PDOutlineNode#getParent()}.
   * <p>
   * Method under test: {@link PDOutlineNode#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentOutline()).getParent());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetParent_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentOutline parent = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    assertTrue(parent2 instanceof PDDocumentOutline);
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(parent, parent2);
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetParent_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDDocumentOutline parent = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    PDOutlineNode parent2 = pdDocumentOutline.getParent();
    assertTrue(parent2 instanceof PDDocumentOutline);
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(parent, parent2);
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} Parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); when 'null'; then PDDocumentOutline() Parent is 'null'")
  void testSetParent_whenNull_thenPDDocumentOutlineParentIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setParent(null);

    // Assert
    assertNull(pdDocumentOutline.getParent());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#setParent(PDOutlineNode)}.
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} Parent is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setParent(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setParent(PDOutlineNode); when PDDocumentOutline(); then PDDocumentOutline() Parent is 'null'")
  void testSetParent_whenPDDocumentOutline_thenPDDocumentOutlineParentIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline parent = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setParent(parent);

    // Assert
    assertNull(parent.getParent());
    COSDictionary cOSObject = parent.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#addLast(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#addLast(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test addLast(PDOutlineItem); when PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testAddLast_whenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addLast(newChild));
  }

  /**
   * Test {@link PDOutlineNode#addLast(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingBefore
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#addLast(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test addLast(PDOutlineItem); when PDOutlineItem() insertSiblingBefore PDOutlineItem()")
  void testAddLast_whenPDOutlineItemInsertSiblingBeforePDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingBefore(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addLast(newChild));
  }

  /**
   * Test {@link PDOutlineNode#addFirst(PDOutlineItem)}.
   * <p>
   * Method under test: {@link PDOutlineNode#addFirst(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test addFirst(PDOutlineItem)")
  void testAddFirst() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();

    // Act
    pdDocumentOutline.addFirst(newChild);

    // Assert
    PDOutlineNode parent = newChild.getParent();
    assertTrue(parent instanceof PDDocumentOutline);
    PDOutlineItem firstChild = parent.getFirstChild();
    PDOutlineNode parent2 = firstChild.getParent();
    assertTrue(parent2 instanceof PDDocumentOutline);
    PDOutlineItem firstChild2 = parent2.getFirstChild();
    PDOutlineNode parent3 = firstChild2.getParent();
    assertTrue(parent3 instanceof PDDocumentOutline);
    PDOutlineItem lastChild = parent.getLastChild();
    PDOutlineNode parent4 = lastChild.getParent();
    PDOutlineItem firstChild3 = parent4.getFirstChild();
    PDOutlineNode parent5 = firstChild3.getParent();
    assertTrue(parent5 instanceof PDDocumentOutline);
    assertTrue(parent4 instanceof PDDocumentOutline);
    PDOutlineItem lastChild2 = parent2.getLastChild();
    PDOutlineNode parent6 = lastChild2.getParent();
    assertTrue(parent6 instanceof PDDocumentOutline);
    PDOutlineItem lastChild3 = parent4.getLastChild();
    PDOutlineNode parent7 = lastChild3.getParent();
    assertTrue(parent7 instanceof PDDocumentOutline);
    PDColor textColor = firstChild2.getTextColor();
    assertNull(textColor.getPatternName());
    PDColor textColor2 = firstChild3.getTextColor();
    assertNull(textColor2.getPatternName());
    PDColor textColor3 = lastChild2.getTextColor();
    assertNull(textColor3.getPatternName());
    PDColor textColor4 = lastChild3.getTextColor();
    assertNull(textColor4.getPatternName());
    assertNull(newChild.getNextSibling());
    assertNull(firstChild.getNextSibling());
    assertNull(firstChild2.getNextSibling());
    assertNull(firstChild3.getNextSibling());
    assertNull(lastChild.getPreviousSibling());
    assertNull(lastChild2.getPreviousSibling());
    assertNull(lastChild3.getPreviousSibling());
    assertNull(parent3.getParent());
    assertNull(parent5.getParent());
    assertNull(parent6.getParent());
    assertNull(parent7.getParent());
    assertEquals(1, pdDocumentOutline.getOpenCount());
    assertEquals(1, parent.getOpenCount());
    assertEquals(1, parent2.getOpenCount());
    assertEquals(1, parent3.getOpenCount());
    assertEquals(1, parent5.getOpenCount());
    assertEquals(1, parent4.getOpenCount());
    assertEquals(1, parent6.getOpenCount());
    assertEquals(1, parent7.getOpenCount());
    COSDictionary cOSObject = newChild.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(textColor.isPattern());
    assertFalse(textColor2.isPattern());
    assertFalse(textColor3.isPattern());
    assertFalse(textColor4.isPattern());
    assertTrue(pdDocumentOutline.hasChildren());
    assertTrue(parent3.hasChildren());
    assertTrue(parent5.hasChildren());
    assertTrue(parent6.hasChildren());
    assertTrue(parent7.hasChildren());
    assertTrue(parent3.isNodeOpen());
    assertTrue(parent5.isNodeOpen());
    assertTrue(parent6.isNodeOpen());
    assertTrue(parent7.isNodeOpen());
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
    assertEquals(newChild, parent3.getFirstChild());
    assertEquals(newChild, parent5.getFirstChild());
    assertEquals(newChild, parent6.getFirstChild());
    assertEquals(newChild, parent7.getFirstChild());
    assertEquals(newChild, pdDocumentOutline.getLastChild());
    assertEquals(newChild, parent3.getLastChild());
    assertEquals(newChild, parent5.getLastChild());
    assertEquals(newChild, parent6.getLastChild());
    assertEquals(newChild, parent7.getLastChild());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor2.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor3.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor4.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineNode#addFirst(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#addFirst(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test addFirst(PDOutlineItem); when PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testAddFirst_whenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addFirst(newChild));
  }

  /**
   * Test {@link PDOutlineNode#addFirst(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingBefore
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#addFirst(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test addFirst(PDOutlineItem); when PDOutlineItem() insertSiblingBefore PDOutlineItem()")
  void testAddFirst_whenPDOutlineItemInsertSiblingBeforePDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingBefore(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.addFirst(newChild));
  }

  /**
   * Test {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test requireSingleNode(PDOutlineItem); when PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testRequireSingleNode_whenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem node = new PDOutlineItem();
    node.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.requireSingleNode(node));
  }

  /**
   * Test {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}.
   * <ul>
   *   <li>When {@link PDOutlineItem#PDOutlineItem()} insertSiblingBefore
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#requireSingleNode(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test requireSingleNode(PDOutlineItem); when PDOutlineItem() insertSiblingBefore PDOutlineItem()")
  void testRequireSingleNode_whenPDOutlineItemInsertSiblingBeforePDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem node = new PDOutlineItem();
    node.insertSiblingBefore(new PDOutlineItem());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdDocumentOutline.requireSingleNode(node));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   * <p>
   * Method under test:
   * {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test updateParentOpenCountForAddedChild(PDOutlineItem)")
  void testUpdateParentOpenCountForAddedChild() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    PDOutlineItem newChild = new PDOutlineItem();
    newChild.insertSiblingAfter(new PDOutlineItem());

    // Act
    pdDocumentOutline.updateParentOpenCountForAddedChild(newChild);

    // Assert that nothing has changed
    PDOutlineItem nextSibling = newChild.getNextSibling();
    assertEquals(0, nextSibling.getOpenCount());
    assertEquals(0, nextSibling.getPreviousSibling().getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   * <p>
   * Method under test:
   * {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test updateParentOpenCountForAddedChild(PDOutlineItem)")
  void testUpdateParentOpenCountForAddedChild2() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDocumentOutline.updateParentOpenCountForAddedChild(new PDOutlineItem(dic)));
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary).setInt(isA(COSName.class), eq(3));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}.
   * <p>
   * Method under test:
   * {@link PDOutlineNode#updateParentOpenCountForAddedChild(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test updateParentOpenCountForAddedChild(PDOutlineItem)")
  void testUpdateParentOpenCountForAddedChild3() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    doThrow(new IllegalArgumentException("foo")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> pdDocumentOutline.updateParentOpenCountForAddedChild(new PDOutlineItem(dic)));
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSName(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2).setInt(isA(COSName.class), eq(3));
  }

  /**
   * Test {@link PDOutlineNode#hasChildren()}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is
   * {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#hasChildren()}
   */
  @Test
  @DisplayName("Test hasChildren(); given COSDictionary() Key is COSObjectKey(long, int) with num is one and gen is one")
  void testHasChildren_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newChild = new PDOutlineItem(dic);

    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#hasChildren()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()} addLast
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#hasChildren()}
   */
  @Test
  @DisplayName("Test hasChildren(); given PDDocumentOutline() addLast PDOutlineItem(); then return 'true'")
  void testHasChildren_givenPDDocumentOutlineAddLastPDOutlineItem_thenReturnTrue() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(new PDOutlineItem());

    // Act and Assert
    assertTrue(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#hasChildren()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#hasChildren()}
   */
  @Test
  @DisplayName("Test hasChildren(); given PDDocumentOutline(); then return 'false'")
  void testHasChildren_givenPDDocumentOutline_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDDocumentOutline()).hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#getOutlineItem(COSName)}.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getOutlineItem(COSName)}
   */
  @Test
  @DisplayName("Test getOutlineItem(COSName); when A")
  void testGetOutlineItem_whenA() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentOutline()).getOutlineItem(COSName.A));
  }

  /**
   * Test {@link PDOutlineNode#getOutlineItem(COSName)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getOutlineItem(COSName)}
   */
  @Test
  @DisplayName("Test getOutlineItem(COSName); when 'null'")
  void testGetOutlineItem_whenNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentOutline()).getOutlineItem(null));
  }

  /**
   * Test {@link PDOutlineNode#getFirstChild()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getFirstChild()}
   */
  @Test
  @DisplayName("Test getFirstChild(); given PDDocumentOutline(); then return 'null'")
  void testGetFirstChild_givenPDDocumentOutline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentOutline()).getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#getFirstChild()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getFirstChild()}
   */
  @Test
  @DisplayName("Test getFirstChild(); then return PDOutlineItem()")
  void testGetFirstChild_thenReturnPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#getFirstChild()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getFirstChild()}
   */
  @Test
  @DisplayName("Test getFirstChild(); then return PDOutlineItem(COSDictionary) with dic is COSDictionary()")
  void testGetFirstChild_thenReturnPDOutlineItemWithDicIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newChild = new PDOutlineItem(dic);

    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetFirstChild_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentOutline outlineNode = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdDocumentOutline.hasChildren());
    assertEquals(outlineNode, pdDocumentOutline.getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetFirstChild_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDDocumentOutline outlineNode = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdDocumentOutline.hasChildren());
    assertEquals(outlineNode, pdDocumentOutline.getFirstChild());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} FirstChild is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); when 'null'; then PDDocumentOutline() FirstChild is 'null'")
  void testSetFirstChild_whenNull_thenPDDocumentOutlineFirstChildIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setFirstChild(null);

    // Assert
    assertNull(pdDocumentOutline.getFirstChild());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdDocumentOutline.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#setFirstChild(PDOutlineNode)}.
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} FirstChild is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setFirstChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setFirstChild(PDOutlineNode); when PDDocumentOutline(); then PDDocumentOutline() FirstChild is 'null'")
  void testSetFirstChild_whenPDDocumentOutline_thenPDDocumentOutlineFirstChildIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline outlineNode = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setFirstChild(outlineNode);

    // Assert
    assertNull(outlineNode.getFirstChild());
    COSDictionary cOSObject = outlineNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(outlineNode.hasChildren());
  }

  /**
   * Test {@link PDOutlineNode#getLastChild()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getLastChild()}
   */
  @Test
  @DisplayName("Test getLastChild(); given PDDocumentOutline(); then return 'null'")
  void testGetLastChild_givenPDDocumentOutline_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDocumentOutline()).getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#getLastChild()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getLastChild()}
   */
  @Test
  @DisplayName("Test getLastChild(); then return PDOutlineItem()")
  void testGetLastChild_thenReturnPDOutlineItem() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDOutlineItem newChild = new PDOutlineItem();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#getLastChild()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getLastChild()}
   */
  @Test
  @DisplayName("Test getLastChild(); then return PDOutlineItem(COSDictionary) with dic is COSDictionary()")
  void testGetLastChild_thenReturnPDOutlineItemWithDicIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newChild = new PDOutlineItem(dic);

    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(newChild);

    // Act and Assert
    assertEquals(newChild, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetLastChild_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDDocumentOutline outlineNode = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(outlineNode, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); given 'true'; when COSDictionary() Direct is 'true'")
  void testSetLastChild_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    COSDictionary dic = new COSDictionary();
    dic.setDirect(true);
    PDDocumentOutline outlineNode = new PDDocumentOutline(dic);

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(outlineNode, pdDocumentOutline.getLastChild());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} LastChild is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); when 'null'; then PDDocumentOutline() LastChild is 'null'")
  void testSetLastChild_whenNull_thenPDDocumentOutlineLastChildIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setLastChild(null);

    // Assert
    assertNull(pdDocumentOutline.getLastChild());
    COSDictionary cOSObject = pdDocumentOutline.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#setLastChild(PDOutlineNode)}.
   * <ul>
   *   <li>When {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} LastChild is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setLastChild(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setLastChild(PDOutlineNode); when PDDocumentOutline(); then PDDocumentOutline() LastChild is 'null'")
  void testSetLastChild_whenPDDocumentOutline_thenPDDocumentOutlineLastChildIsNull() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    PDDocumentOutline outlineNode = new PDDocumentOutline();

    // Act
    pdDocumentOutline.setLastChild(outlineNode);

    // Assert
    assertNull(outlineNode.getLastChild());
    COSDictionary cOSObject = outlineNode.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDOutlineNode#getOpenCount()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()} addLast
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getOpenCount()}
   */
  @Test
  @DisplayName("Test getOpenCount(); given PDDocumentOutline() addLast PDOutlineItem(); then return one")
  void testGetOpenCount_givenPDDocumentOutlineAddLastPDOutlineItem_thenReturnOne() {
    // Arrange
    PDDocumentOutline pdDocumentOutline = new PDDocumentOutline();
    pdDocumentOutline.addLast(new PDOutlineItem());

    // Act and Assert
    assertEquals(1, pdDocumentOutline.getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#getOpenCount()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#getOpenCount()}
   */
  @Test
  @DisplayName("Test getOpenCount(); given PDDocumentOutline(); then return zero")
  void testGetOpenCount_givenPDDocumentOutline_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDDocumentOutline()).getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#setOpenCount(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} OpenCount is
   * {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setOpenCount(int)}
   */
  @Test
  @DisplayName("Test setOpenCount(int); when MIN_VALUE; then PDDocumentOutline() OpenCount is MIN_VALUE")
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
   * <ul>
   *   <li>When three.</li>
   *   <li>Then {@link PDDocumentOutline#PDDocumentOutline()} OpenCount is
   * three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#setOpenCount(int)}
   */
  @Test
  @DisplayName("Test setOpenCount(int); when three; then PDDocumentOutline() OpenCount is three")
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
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} FirstChild Parent
   * {@link PDOutlineItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#openNode()}
   */
  @Test
  @DisplayName("Test openNode(); then PDOutlineItem() FirstChild Parent PDOutlineItem")
  void testOpenNode_thenPDOutlineItemFirstChildParentPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.addLast(new PDOutlineItem());

    // Act
    pdOutlineItem.openNode();

    // Assert
    PDOutlineNode parent = pdOutlineItem.getFirstChild().getParent();
    assertTrue(parent instanceof PDOutlineItem);
    PDOutlineNode parent2 = parent.getFirstChild().getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    PDOutlineNode parent3 = parent2.getFirstChild().getParent();
    assertTrue(parent3 instanceof PDOutlineItem);
    PDOutlineNode parent4 = parent3.getFirstChild().getParent();
    assertTrue(parent4 instanceof PDOutlineItem);
    PDOutlineNode parent5 = pdOutlineItem.getLastChild().getParent();
    PDOutlineNode parent6 = parent5.getFirstChild().getParent();
    PDOutlineNode parent7 = parent6.getFirstChild().getParent();
    assertTrue(parent7 instanceof PDOutlineItem);
    assertTrue(parent6 instanceof PDOutlineItem);
    PDOutlineNode parent8 = parent.getLastChild().getParent();
    PDOutlineNode parent9 = parent8.getFirstChild().getParent();
    assertTrue(parent9 instanceof PDOutlineItem);
    PDOutlineNode parent10 = parent5.getLastChild().getParent();
    PDOutlineNode parent11 = parent10.getFirstChild().getParent();
    assertTrue(parent11 instanceof PDOutlineItem);
    assertTrue(parent5 instanceof PDOutlineItem);
    assertTrue(parent8 instanceof PDOutlineItem);
    PDOutlineNode parent12 = parent2.getLastChild().getParent();
    assertTrue(parent12 instanceof PDOutlineItem);
    PDOutlineNode parent13 = parent6.getLastChild().getParent();
    assertTrue(parent13 instanceof PDOutlineItem);
    assertTrue(parent10 instanceof PDOutlineItem);
    PDOutlineNode parent14 = parent8.getLastChild().getParent();
    assertTrue(parent14 instanceof PDOutlineItem);
    PDOutlineNode parent15 = parent10.getLastChild().getParent();
    assertTrue(parent15 instanceof PDOutlineItem);
    assertEquals(1, pdOutlineItem.getOpenCount());
    assertEquals(1, parent.getOpenCount());
    assertEquals(1, parent2.getOpenCount());
    assertEquals(1, parent3.getOpenCount());
    assertEquals(1, parent4.getOpenCount());
    assertEquals(1, parent7.getOpenCount());
    assertEquals(1, parent6.getOpenCount());
    assertEquals(1, parent9.getOpenCount());
    assertEquals(1, parent11.getOpenCount());
    assertEquals(1, parent5.getOpenCount());
    assertEquals(1, parent8.getOpenCount());
    assertEquals(1, parent12.getOpenCount());
    assertEquals(1, parent13.getOpenCount());
    assertEquals(1, parent10.getOpenCount());
    assertEquals(1, parent14.getOpenCount());
    assertEquals(1, parent15.getOpenCount());
    assertTrue(pdOutlineItem.isNodeOpen());
    assertTrue(parent.isNodeOpen());
    assertTrue(parent2.isNodeOpen());
    assertTrue(parent3.isNodeOpen());
    assertTrue(parent4.isNodeOpen());
    assertTrue(parent7.isNodeOpen());
    assertTrue(parent6.isNodeOpen());
    assertTrue(parent9.isNodeOpen());
    assertTrue(parent11.isNodeOpen());
    assertTrue(parent5.isNodeOpen());
    assertTrue(parent8.isNodeOpen());
    assertTrue(parent12.isNodeOpen());
    assertTrue(parent13.isNodeOpen());
    assertTrue(parent10.isNodeOpen());
    assertTrue(parent14.isNodeOpen());
    assertTrue(parent15.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#openNode()}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic is
   * {@link COSDictionary} Parent {@link PDOutlineItem}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#openNode()}
   */
  @Test
  @DisplayName("Test openNode(); then PDOutlineItem(COSDictionary) with dic is COSDictionary Parent PDOutlineItem")
  void testOpenNode_thenPDOutlineItemWithDicIsCOSDictionaryParentPDOutlineItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(Integer.MIN_VALUE);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dic).setInt(Mockito.<COSName>any(), anyInt());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.openNode();

    // Assert
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(dic).setInt(isA(COSName.class), eq(-2147483648));
    PDOutlineNode parent = pdOutlineItem.getParent();
    assertTrue(parent instanceof PDOutlineItem);
    assertEquals(Integer.MIN_VALUE, pdOutlineItem.getNextSibling().getOpenCount());
    assertEquals(Integer.MIN_VALUE, pdOutlineItem.getPreviousSibling().getOpenCount());
    assertEquals(Integer.MIN_VALUE, pdOutlineItem.getFirstChild().getOpenCount());
    assertEquals(Integer.MIN_VALUE, pdOutlineItem.getLastChild().getOpenCount());
    assertEquals(Integer.MIN_VALUE, parent.getOpenCount());
  }

  /**
   * Test {@link PDOutlineNode#openNode()}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#openNode()}
   */
  @Test
  @DisplayName("Test openNode(); then throw IllegalArgumentException")
  void testOpenNode_thenThrowIllegalArgumentException() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(0);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(dic).setInt(Mockito.<COSName>any(), anyInt());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDOutlineItem(dic)).openNode());
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(dic).setInt(isA(COSName.class), eq(0));
    verify(cosDictionary).setInt(isA(COSName.class), eq(1));
  }

  /**
   * Test {@link PDOutlineNode#closeNode()}.
   * <p>
   * Method under test: {@link PDOutlineNode#closeNode()}
   */
  @Test
  @DisplayName("Test closeNode()")
  void testCloseNode() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(dic).setInt(Mockito.<COSName>any(), anyInt());
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDOutlineItem(dic)).closeNode());
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(dic).setInt(isA(COSName.class), eq(-1));
    verify(cosDictionary).setInt(isA(COSName.class), eq(0));
  }

  /**
   * Test {@link PDOutlineNode#closeNode()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#closeNode()}
   */
  @Test
  @DisplayName("Test closeNode(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  void testCloseNode_givenCOSDictionaryGetCOSDictionaryReturnNull() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(dic).setInt(Mockito.<COSName>any(), anyInt());
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    // Act
    (new PDOutlineItem(dic)).closeNode();

    // Assert that nothing has changed
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(dic).setInt(isA(COSName.class), eq(-1));
  }

  /**
   * Test {@link PDOutlineNode#closeNode()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#setInt(COSName, int)}
   * throw {@link IllegalArgumentException#IllegalArgumentException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#closeNode()}
   */
  @Test
  @DisplayName("Test closeNode(); given COSDictionary setInt(COSName, int) throw IllegalArgumentException(String) with 'foo'")
  void testCloseNode_givenCOSDictionarySetIntThrowIllegalArgumentExceptionWithFoo() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doThrow(new IllegalArgumentException("foo")).when(dic).setInt(Mockito.<COSName>any(), anyInt());
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDOutlineItem(dic)).closeNode());
    verify(dic, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(dic).setInt(isA(COSName.class), eq(-1));
  }

  /**
   * Test {@link PDOutlineNode#closeNode()}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} FirstChild OpenCount is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#closeNode()}
   */
  @Test
  @DisplayName("Test closeNode(); then PDOutlineItem() FirstChild OpenCount is zero")
  void testCloseNode_thenPDOutlineItemFirstChildOpenCountIsZero() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.addLast(new PDOutlineItem());
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act
    pdOutlineItem.closeNode();

    // Assert that nothing has changed
    PDOutlineItem nextSibling = pdOutlineItem.getNextSibling();
    assertEquals(0, nextSibling.getOpenCount());
    PDOutlineItem firstChild = pdOutlineItem.getFirstChild();
    assertEquals(0, firstChild.getOpenCount());
    PDOutlineItem lastChild = pdOutlineItem.getLastChild();
    assertEquals(0, lastChild.getOpenCount());
    assertFalse(nextSibling.isNodeOpen());
    assertFalse(firstChild.isNodeOpen());
    assertFalse(lastChild.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#closeNode()}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} NextSibling PreviousSibling
   * OpenCount is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#closeNode()}
   */
  @Test
  @DisplayName("Test closeNode(); then PDOutlineItem() NextSibling PreviousSibling OpenCount is zero")
  void testCloseNode_thenPDOutlineItemNextSiblingPreviousSiblingOpenCountIsZero() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act
    pdOutlineItem.closeNode();

    // Assert that nothing has changed
    PDOutlineItem nextSibling = pdOutlineItem.getNextSibling();
    assertEquals(0, nextSibling.getOpenCount());
    PDOutlineItem previousSibling = nextSibling.getPreviousSibling();
    assertEquals(0, previousSibling.getOpenCount());
    assertFalse(nextSibling.isNodeOpen());
    assertFalse(previousSibling.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} addLast
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem() addLast PDOutlineItem(); then return 'false'")
  void testIsNodeOpen_givenPDOutlineItemAddLastPDOutlineItem_thenReturnFalse() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.addLast(new PDOutlineItem());
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem() insertSiblingAfter PDOutlineItem(); then return 'false'")
  void testIsNodeOpen_givenPDOutlineItemInsertSiblingAfterPDOutlineItem_thenReturnFalse() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#isNodeOpen()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#isNodeOpen()}
   */
  @Test
  @DisplayName("Test isNodeOpen(); given PDOutlineItem(); then return 'false'")
  void testIsNodeOpen_givenPDOutlineItem_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItem()).isNodeOpen());
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCount(int)}.
   * <p>
   * Method under test: {@link PDOutlineNode#updateParentOpenCount(int)}
   */
  @Test
  @DisplayName("Test updateParentOpenCount(int)")
  void testUpdateParentOpenCount() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    doNothing().when(dic).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDDocumentOutline(dic)).updateParentOpenCount(2));
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary).setInt(isA(COSName.class), eq(3));
    verify(dic).setName(isA(COSName.class), eq("Outlines"));
  }

  /**
   * Test {@link PDOutlineNode#updateParentOpenCount(int)}.
   * <p>
   * Method under test: {@link PDOutlineNode#updateParentOpenCount(int)}
   */
  @Test
  @DisplayName("Test updateParentOpenCount(int)")
  void testUpdateParentOpenCount2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException("foo"));
    doThrow(new IllegalArgumentException("foo")).when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cosDictionary2.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    doNothing().when(cosDictionary2).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);
    doNothing().when(dic).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDDocumentOutline(dic)).updateParentOpenCount(2));
    verify(dic).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary2).getCOSName(isA(COSName.class));
    verify(cosDictionary).getCOSName(isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getInt(isA(COSName.class), eq(0));
    verify(cosDictionary2).setInt(isA(COSName.class), eq(3));
    verify(dic).setName(isA(COSName.class), eq("Outlines"));
  }

  /**
   * Test {@link PDOutlineNode#children()}.
   * <ul>
   *   <li>Given {@link PDDocumentOutline#PDDocumentOutline()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineNode#children()}
   */
  @Test
  @DisplayName("Test children(); given PDDocumentOutline()")
  void testChildren_givenPDDocumentOutline() {
    // Arrange and Act
    Iterator<PDOutlineItem> actualIteratorResult = (new PDDocumentOutline()).children().iterator();

    // Assert
    assertTrue(actualIteratorResult instanceof PDOutlineItemIterator);
    assertFalse(actualIteratorResult.hasNext());
  }
}
