package org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureElement;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.interactive.action.OpenMode;
import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionEmbeddedGoTo;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageFitDestination;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageXYZDestination;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDOutlineItemDiffblueTest {
  /**
   * Test {@link PDOutlineItem#PDOutlineItem(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#PDOutlineItem(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDOutlineItem(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDOutlineItem_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDOutlineItem(dic)).getCOSObject());
  }

  /**
   * Test {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}.
   * <p>
   * Method under test: {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test insertSiblingAfter(PDOutlineItem)")
  void testInsertSiblingAfter() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.isDirect()).thenReturn(true);
    COSDictionary cosDictionary = new COSDictionary();
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dic.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);
    PDOutlineItem newSibling = new PDOutlineItem();

    // Act
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Assert
    verify(dic).isDirect();
    verify(dic, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(dic).getUpdateState();
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
    PDOutlineNode parent = newSibling.getParent();
    assertTrue(parent instanceof PDOutlineItem);
    PDOutlineItem previousSibling = newSibling.getPreviousSibling();
    PDOutlineNode parent2 = previousSibling.getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    PDColor textColor = ((PDOutlineItem) parent2).getTextColor();
    assertNull(textColor.getPatternName());
    PDStructureElement structureElement = previousSibling.getStructureElement();
    assertNull(structureElement.getPage());
    PDOutlineItem nextSibling = newSibling.getNextSibling();
    assertNull(nextSibling.getStructureElement());
    PDOutlineItem nextSibling2 = previousSibling.getNextSibling();
    assertNull(nextSibling2.getStructureElement());
    PDOutlineItem previousSibling2 = previousSibling.getPreviousSibling();
    assertNull(previousSibling2.getStructureElement());
    PDOutlineItem firstChild = previousSibling.getFirstChild();
    assertNull(firstChild.getStructureElement());
    PDOutlineItem lastChild = previousSibling.getLastChild();
    assertNull(lastChild.getStructureElement());
    assertNull(((PDOutlineItem) parent).getStructureElement());
    assertNull(((PDOutlineItem) parent2).getStructureElement());
    assertNull(structureElement.getParent());
    assertNull(nextSibling.getNextSibling());
    assertNull(nextSibling2.getNextSibling());
    assertNull(previousSibling2.getNextSibling());
    assertNull(firstChild.getNextSibling());
    assertNull(lastChild.getNextSibling());
    assertNull(((PDOutlineItem) parent).getNextSibling());
    assertNull(((PDOutlineItem) parent2).getNextSibling());
    assertNull(nextSibling.getFirstChild());
    assertNull(nextSibling2.getFirstChild());
    assertNull(previousSibling2.getFirstChild());
    assertNull(firstChild.getFirstChild());
    assertNull(lastChild.getFirstChild());
    assertNull(parent.getFirstChild());
    assertNull(parent2.getFirstChild());
    assertNull(nextSibling.getLastChild());
    assertNull(nextSibling2.getLastChild());
    assertNull(previousSibling2.getLastChild());
    assertNull(firstChild.getLastChild());
    assertNull(lastChild.getLastChild());
    assertNull(parent.getLastChild());
    assertNull(parent2.getLastChild());
    assertNull(nextSibling.getParent());
    assertNull(nextSibling2.getParent());
    assertNull(previousSibling2.getParent());
    assertNull(firstChild.getParent());
    assertNull(lastChild.getParent());
    assertNull(parent.getParent());
    assertNull(parent2.getParent());
    assertEquals(-1, nextSibling.getOpenCount());
    assertEquals(-1, nextSibling2.getOpenCount());
    assertEquals(-1, previousSibling2.getOpenCount());
    assertEquals(-1, firstChild.getOpenCount());
    assertEquals(-1, lastChild.getOpenCount());
    assertEquals(-1, parent.getOpenCount());
    assertEquals(-1, parent2.getOpenCount());
    assertEquals(0, structureElement.getRevisionNumber());
    assertFalse(textColor.isPattern());
    assertFalse(nextSibling.hasChildren());
    assertFalse(nextSibling2.hasChildren());
    assertFalse(previousSibling2.hasChildren());
    assertFalse(firstChild.hasChildren());
    assertFalse(lastChild.hasChildren());
    assertFalse(parent.hasChildren());
    assertFalse(parent2.hasChildren());
    assertFalse(nextSibling.isNodeOpen());
    assertFalse(nextSibling2.isNodeOpen());
    assertFalse(previousSibling2.isNodeOpen());
    assertFalse(firstChild.isNodeOpen());
    assertFalse(lastChild.isNodeOpen());
    assertFalse(parent.isNodeOpen());
    assertFalse(parent2.isNodeOpen());
    assertEquals(newSibling, nextSibling.getPreviousSibling());
    assertEquals(newSibling, nextSibling2.getPreviousSibling());
    assertEquals(newSibling, previousSibling2.getPreviousSibling());
    assertEquals(newSibling, firstChild.getPreviousSibling());
    assertEquals(newSibling, lastChild.getPreviousSibling());
    assertEquals(newSibling, ((PDOutlineItem) parent).getPreviousSibling());
    assertEquals(newSibling, ((PDOutlineItem) parent2).getPreviousSibling());
    assertSame(cosDictionary, nextSibling.getCOSObject());
    assertSame(cosDictionary, nextSibling2.getCOSObject());
    assertSame(cosDictionary, previousSibling2.getCOSObject());
    assertSame(cosDictionary, firstChild.getCOSObject());
    assertSame(cosDictionary, lastChild.getCOSObject());
    assertSame(cosDictionary, parent.getCOSObject());
    assertSame(cosDictionary, parent2.getCOSObject());
    assertSame(cosDictionary, structureElement.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}.
   * <p>
   * Method under test: {@link PDOutlineItem#insertSiblingAfter(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test insertSiblingAfter(PDOutlineItem)")
  void testInsertSiblingAfter2() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.isDirect()).thenReturn(false);
    COSDictionary cosDictionary = new COSDictionary();
    when(dic.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(dic.getKey()).thenReturn(new COSObjectKey(1L, 1));
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);
    PDOutlineItem newSibling = new PDOutlineItem();

    // Act
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Assert
    verify(dic, atLeast(1)).getKey();
    verify(dic).isDirect();
    verify(dic, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
    PDOutlineNode parent = newSibling.getParent();
    assertTrue(parent instanceof PDOutlineItem);
    PDOutlineItem previousSibling = newSibling.getPreviousSibling();
    PDOutlineNode parent2 = previousSibling.getParent();
    assertTrue(parent2 instanceof PDOutlineItem);
    PDColor textColor = ((PDOutlineItem) parent2).getTextColor();
    assertNull(textColor.getPatternName());
    PDStructureElement structureElement = previousSibling.getStructureElement();
    assertNull(structureElement.getPage());
    PDOutlineItem nextSibling = newSibling.getNextSibling();
    assertNull(nextSibling.getStructureElement());
    PDOutlineItem nextSibling2 = previousSibling.getNextSibling();
    assertNull(nextSibling2.getStructureElement());
    PDOutlineItem previousSibling2 = previousSibling.getPreviousSibling();
    assertNull(previousSibling2.getStructureElement());
    PDOutlineItem firstChild = previousSibling.getFirstChild();
    assertNull(firstChild.getStructureElement());
    PDOutlineItem lastChild = previousSibling.getLastChild();
    assertNull(lastChild.getStructureElement());
    assertNull(((PDOutlineItem) parent).getStructureElement());
    assertNull(((PDOutlineItem) parent2).getStructureElement());
    assertNull(structureElement.getParent());
    assertNull(nextSibling.getNextSibling());
    assertNull(nextSibling2.getNextSibling());
    assertNull(previousSibling2.getNextSibling());
    assertNull(firstChild.getNextSibling());
    assertNull(lastChild.getNextSibling());
    assertNull(((PDOutlineItem) parent).getNextSibling());
    assertNull(((PDOutlineItem) parent2).getNextSibling());
    assertNull(nextSibling.getFirstChild());
    assertNull(nextSibling2.getFirstChild());
    assertNull(previousSibling2.getFirstChild());
    assertNull(firstChild.getFirstChild());
    assertNull(lastChild.getFirstChild());
    assertNull(parent.getFirstChild());
    assertNull(parent2.getFirstChild());
    assertNull(nextSibling.getLastChild());
    assertNull(nextSibling2.getLastChild());
    assertNull(previousSibling2.getLastChild());
    assertNull(firstChild.getLastChild());
    assertNull(lastChild.getLastChild());
    assertNull(parent.getLastChild());
    assertNull(parent2.getLastChild());
    assertNull(nextSibling.getParent());
    assertNull(nextSibling2.getParent());
    assertNull(previousSibling2.getParent());
    assertNull(firstChild.getParent());
    assertNull(lastChild.getParent());
    assertNull(parent.getParent());
    assertNull(parent2.getParent());
    assertEquals(-1, nextSibling.getOpenCount());
    assertEquals(-1, nextSibling2.getOpenCount());
    assertEquals(-1, previousSibling2.getOpenCount());
    assertEquals(-1, firstChild.getOpenCount());
    assertEquals(-1, lastChild.getOpenCount());
    assertEquals(-1, parent.getOpenCount());
    assertEquals(-1, parent2.getOpenCount());
    assertEquals(0, structureElement.getRevisionNumber());
    assertFalse(textColor.isPattern());
    assertFalse(nextSibling.hasChildren());
    assertFalse(nextSibling2.hasChildren());
    assertFalse(previousSibling2.hasChildren());
    assertFalse(firstChild.hasChildren());
    assertFalse(lastChild.hasChildren());
    assertFalse(parent.hasChildren());
    assertFalse(parent2.hasChildren());
    assertFalse(nextSibling.isNodeOpen());
    assertFalse(nextSibling2.isNodeOpen());
    assertFalse(previousSibling2.isNodeOpen());
    assertFalse(firstChild.isNodeOpen());
    assertFalse(lastChild.isNodeOpen());
    assertFalse(parent.isNodeOpen());
    assertFalse(parent2.isNodeOpen());
    assertEquals(newSibling, nextSibling.getPreviousSibling());
    assertEquals(newSibling, nextSibling2.getPreviousSibling());
    assertEquals(newSibling, previousSibling2.getPreviousSibling());
    assertEquals(newSibling, firstChild.getPreviousSibling());
    assertEquals(newSibling, lastChild.getPreviousSibling());
    assertEquals(newSibling, ((PDOutlineItem) parent).getPreviousSibling());
    assertEquals(newSibling, ((PDOutlineItem) parent2).getPreviousSibling());
    assertSame(cosDictionary, nextSibling.getCOSObject());
    assertSame(cosDictionary, nextSibling2.getCOSObject());
    assertSame(cosDictionary, previousSibling2.getCOSObject());
    assertSame(cosDictionary, firstChild.getCOSObject());
    assertSame(cosDictionary, lastChild.getCOSObject());
    assertSame(cosDictionary, parent.getCOSObject());
    assertSame(cosDictionary, parent2.getCOSObject());
    assertSame(cosDictionary, structureElement.getCOSObject());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#insertSiblingBefore(PDOutlineItem)}.
   * <p>
   * Method under test: {@link PDOutlineItem#insertSiblingBefore(PDOutlineItem)}
   */
  @Test
  @DisplayName("Test insertSiblingBefore(PDOutlineItem)")
  void testInsertSiblingBefore() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();

    // Act
    pdOutlineItem.insertSiblingBefore(newSibling);

    // Assert
    PDOutlineItem previousSibling = newSibling.getNextSibling().getPreviousSibling();
    PDOutlineItem previousSibling2 = previousSibling.getNextSibling().getPreviousSibling();
    PDOutlineItem previousSibling3 = previousSibling2.getNextSibling().getPreviousSibling();
    PDOutlineItem nextSibling = previousSibling3.getNextSibling();
    assertNull(nextSibling.getTitle());
    PDColor textColor = nextSibling.getTextColor();
    assertNull(textColor.getPatternName());
    PDColor textColor2 = previousSibling3.getTextColor();
    assertNull(textColor2.getPatternName());
    assertNull(nextSibling.getStructureElement());
    assertNull(nextSibling.getAction());
    assertNull(nextSibling.getDestination());
    assertNull(nextSibling.getNextSibling());
    assertNull(newSibling.getPreviousSibling());
    assertNull(previousSibling.getPreviousSibling());
    assertNull(previousSibling2.getPreviousSibling());
    assertNull(previousSibling3.getPreviousSibling());
    assertNull(nextSibling.getFirstChild());
    assertNull(previousSibling.getFirstChild());
    assertNull(previousSibling2.getFirstChild());
    assertNull(previousSibling3.getFirstChild());
    assertNull(nextSibling.getLastChild());
    assertNull(previousSibling.getLastChild());
    assertNull(previousSibling2.getLastChild());
    assertNull(previousSibling3.getLastChild());
    assertNull(nextSibling.getParent());
    assertEquals(0, nextSibling.getOpenCount());
    assertEquals(0, previousSibling.getOpenCount());
    assertEquals(0, previousSibling2.getOpenCount());
    assertEquals(0, previousSibling3.getOpenCount());
    COSDictionary cOSObject = newSibling.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(textColor.isPattern());
    assertFalse(textColor2.isPattern());
    assertFalse(nextSibling.isBold());
    assertFalse(nextSibling.isItalic());
    assertFalse(nextSibling.hasChildren());
    assertFalse(previousSibling.hasChildren());
    assertFalse(previousSibling2.hasChildren());
    assertFalse(previousSibling3.hasChildren());
    assertFalse(nextSibling.isNodeOpen());
    assertEquals(newSibling, nextSibling.getPreviousSibling());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, textColor2.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#getPreviousSibling()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  @DisplayName("Test getPreviousSibling(); given PDOutlineItem(); then return 'null'")
  void testGetPreviousSibling_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getPreviousSibling());
  }

  /**
   * Test {@link PDOutlineItem#getPreviousSibling()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  @DisplayName("Test getPreviousSibling(); then return 'null'")
  void testGetPreviousSibling_thenReturnNull() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertNull(pdOutlineItem.getPreviousSibling());
  }

  /**
   * Test {@link PDOutlineItem#getPreviousSibling()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getPreviousSibling()}
   */
  @Test
  @DisplayName("Test getPreviousSibling(); then return PDOutlineItem()")
  void testGetPreviousSibling_thenReturnPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingBefore(newSibling);
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getPreviousSibling());
  }

  /**
   * Test {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setPreviousSibling(PDOutlineNode); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetPreviousSibling_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setPreviousSibling(mock(PDOutlineNode.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} PreviousSibling COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setPreviousSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setPreviousSibling(PDOutlineNode); then PDOutlineItem() PreviousSibling COSObject is COSDictionary()")
  void testSetPreviousSibling_thenPDOutlineItemPreviousSiblingCOSObjectIsCOSDictionary() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdOutlineItem.setPreviousSibling(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    assertSame(cosDictionary, pdOutlineItem.getPreviousSibling().getCOSObject());
  }

  /**
   * Test {@link PDOutlineItem#getNextSibling()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  @DisplayName("Test getNextSibling(); given PDOutlineItem(); then return 'null'")
  void testGetNextSibling_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getNextSibling());
  }

  /**
   * Test {@link PDOutlineItem#getNextSibling()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  @DisplayName("Test getNextSibling(); then return PDOutlineItem()")
  void testGetNextSibling_thenReturnPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineItem newSibling = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getNextSibling());
  }

  /**
   * Test {@link PDOutlineItem#getNextSibling()}.
   * <ul>
   *   <li>Then return {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getNextSibling()}
   */
  @Test
  @DisplayName("Test getNextSibling(); then return PDOutlineItem(COSDictionary) with dic is COSDictionary()")
  void testGetNextSibling_thenReturnPDOutlineItemWithDicIsCOSDictionary() {
    // Arrange
    COSDictionary dic = new COSDictionary();
    dic.setKey(new COSObjectKey(1L, 1));
    PDOutlineItem newSibling = new PDOutlineItem(dic);

    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(newSibling);

    // Act and Assert
    assertEquals(newSibling, pdOutlineItem.getNextSibling());
  }

  /**
   * Test {@link PDOutlineItem#setNextSibling(PDOutlineNode)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setNextSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setNextSibling(PDOutlineNode); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetNextSibling_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setNextSibling(mock(PDOutlineNode.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDOutlineItem#setNextSibling(PDOutlineNode)}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} NextSibling COSObject is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setNextSibling(PDOutlineNode)}
   */
  @Test
  @DisplayName("Test setNextSibling(PDOutlineNode); then PDOutlineItem() NextSibling COSObject is COSDictionary()")
  void testSetNextSibling_thenPDOutlineItemNextSiblingCOSObjectIsCOSDictionary() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    PDOutlineNode outlineNode = mock(PDOutlineNode.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(outlineNode.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdOutlineItem.setNextSibling(outlineNode);

    // Assert
    verify(outlineNode).getCOSObject();
    assertSame(cosDictionary, pdOutlineItem.getNextSibling().getCOSObject());
  }

  /**
   * Test {@link PDOutlineItem#getTitle()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDOutlineItem() insertSiblingAfter PDOutlineItem(); then return 'null'")
  void testGetTitle_givenPDOutlineItemInsertSiblingAfterPDOutlineItem_thenReturnNull() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertNull(pdOutlineItem.getTitle());
  }

  /**
   * Test {@link PDOutlineItem#getTitle()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); given PDOutlineItem(); then return 'null'")
  void testGetTitle_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getTitle());
  }

  /**
   * Test {@link PDOutlineItem#setTitle(String)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setString(COSName, String)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setString(COSName, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String); given COSDictionary setString(COSName, String) does nothing; then calls setString(COSName, String)")
  void testSetTitle_givenCOSDictionarySetStringDoesNothing_thenCallsSetString() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setString(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDOutlineItem(dic)).setTitle("Dr");

    // Assert that nothing has changed
    verify(dic).setString(isA(COSName.class), eq("Dr"));
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDDestination)} with {@code dest}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination
   * {@link PDPageFitDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setDestination(PDDestination)}
   */
  @Test
  @DisplayName("Test setDestination(PDDestination) with 'dest'; then PDOutlineItem() Destination PDPageFitDestination")
  void testSetDestinationWithDest_thenPDOutlineItemDestinationPDPageFitDestination() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination(new PDPageFitDestination());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageFitDestination);
    assertNull(((PDPageFitDestination) destination).getPage());
    assertEquals(-1, ((PDPageFitDestination) destination).getPageNumber());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   * <p>
   * Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName("Test setDestination(PDPage) with 'page'")
  void testSetDestinationWithPage() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem(new COSDictionary());

    // Act
    pdOutlineItem.setDestination(new PDPage());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageXYZDestination);
    PDPage page = ((PDPageXYZDestination) destination).getPage();
    PDRectangle artBox = page.getArtBox();
    assertSame(artBox, page.getBBox());
    assertSame(artBox, page.getBleedBox());
    assertSame(artBox, page.getCropBox());
    assertSame(artBox, page.getMediaBox());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination
   * {@link PDPageXYZDestination}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName("Test setDestination(PDPage) with 'page'; then PDOutlineItem() Destination PDPageXYZDestination")
  void testSetDestinationWithPage_thenPDOutlineItemDestinationPDPageXYZDestination() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination(new PDPage());

    // Assert
    PDDestination destination = pdOutlineItem.getDestination();
    assertTrue(destination instanceof PDPageXYZDestination);
    PDPage page = ((PDPageXYZDestination) destination).getPage();
    PDRectangle artBox = page.getArtBox();
    assertSame(artBox, page.getBBox());
    assertSame(artBox, page.getBleedBox());
    assertSame(artBox, page.getCropBox());
    assertSame(artBox, page.getMediaBox());
  }

  /**
   * Test {@link PDOutlineItem#setDestination(PDPage)} with {@code page}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Destination is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setDestination(PDPage)}
   */
  @Test
  @DisplayName("Test setDestination(PDPage) with 'page'; when 'null'; then PDOutlineItem() Destination is 'null'")
  void testSetDestinationWithPage_whenNull_thenPDOutlineItemDestinationIsNull() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setDestination((PDPage) null);

    // Assert
    assertNull(pdOutlineItem.getDestination());
  }

  /**
   * Test {@link PDOutlineItem#findDestinationPage(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#findDestinationPage(PDDocument)}
   */
  @Test
  @DisplayName("Test findDestinationPage(PDDocument); given PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testFindDestinationPage_givenPDOutlineItemInsertSiblingAfterPDOutlineItem() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertNull(pdOutlineItem.findDestinationPage(new PDDocument()));
  }

  /**
   * Test {@link PDOutlineItem#findDestinationPage(PDDocument)}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#findDestinationPage(PDDocument)}
   */
  @Test
  @DisplayName("Test findDestinationPage(PDDocument); given PDOutlineItem(); then return 'null'")
  void testFindDestinationPage_givenPDOutlineItem_thenReturnNull() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act and Assert
    assertNull(pdOutlineItem.findDestinationPage(new PDDocument()));
  }

  /**
   * Test {@link PDOutlineItem#getAction()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given PDOutlineItem() insertSiblingAfter PDOutlineItem(); then return 'null'")
  void testGetAction_givenPDOutlineItemInsertSiblingAfterPDOutlineItem_thenReturnNull() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertNull(pdOutlineItem.getAction());
  }

  /**
   * Test {@link PDOutlineItem#getAction()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getAction()}
   */
  @Test
  @DisplayName("Test getAction(); given PDOutlineItem(); then return 'null'")
  void testGetAction_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getAction());
  }

  /**
   * Test {@link PDOutlineItem#setAction(PDAction)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>When {@link PDAction}.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); given COSDictionary setItem(COSName, COSObjectable) does nothing; when PDAction; then calls setItem(COSName, COSObjectable)")
  void testSetAction_givenCOSDictionarySetItemDoesNothing_whenPDAction_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    // Act
    (new PDOutlineItem(dic)).setAction(mock(PDAction.class));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDOutlineItem#setAction(PDAction)}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} Action
   * {@link PDActionEmbeddedGoTo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setAction(PDAction)}
   */
  @Test
  @DisplayName("Test setAction(PDAction); then PDOutlineItem() Action PDActionEmbeddedGoTo")
  void testSetAction_thenPDOutlineItemActionPDActionEmbeddedGoTo() throws IOException {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setAction(new PDActionEmbeddedGoTo());

    // Assert
    PDAction action = pdOutlineItem.getAction();
    assertTrue(action instanceof PDActionEmbeddedGoTo);
    assertEquals("Action", action.getType());
    assertEquals("GoToE", action.getSubType());
    assertNull(action.getNext());
    assertNull(((PDActionEmbeddedGoTo) action).getFile());
    assertNull(((PDActionEmbeddedGoTo) action).getTargetDirectory());
    assertNull(((PDActionEmbeddedGoTo) action).getDestination());
    assertEquals(OpenMode.USER_PREFERENCE, ((PDActionEmbeddedGoTo) action).getOpenInNewWindow());
  }

  /**
   * Test {@link PDOutlineItem#getStructureElement()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getStructureElement()}
   */
  @Test
  @DisplayName("Test getStructureElement(); given PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testGetStructureElement_givenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertNull(pdOutlineItem.getStructureElement());
  }

  /**
   * Test {@link PDOutlineItem#getStructureElement()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getStructureElement()}
   */
  @Test
  @DisplayName("Test getStructureElement(); given PDOutlineItem(); then return 'null'")
  void testGetStructureElement_givenPDOutlineItem_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDOutlineItem()).getStructureElement());
  }

  /**
   * Test {@link PDOutlineItem#setStructureElement(PDStructureElement)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSObjectable)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDOutlineItem#setStructureElement(PDStructureElement)}
   */
  @Test
  @DisplayName("Test setStructureElement(PDStructureElement); given COSDictionary setItem(COSName, COSObjectable) does nothing; then calls setItem(COSName, COSObjectable)")
  void testSetStructureElement_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.setStructureElement(new PDStructureElement(mock(COSDictionary.class)));

    // Assert that nothing has changed
    verify(dic).setItem(isA(COSName.class), isA(COSObjectable.class));
  }

  /**
   * Test {@link PDOutlineItem#getTextColor()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getTextColor()}
   */
  @Test
  @DisplayName("Test getTextColor(); given PDOutlineItem() insertSiblingAfter PDOutlineItem()")
  void testGetTextColor_givenPDOutlineItemInsertSiblingAfterPDOutlineItem() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act
    PDColor actualTextColor = pdOutlineItem.getTextColor();

    // Assert
    PDColorSpace colorSpace = actualTextColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualTextColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertFalse(actualTextColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualTextColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#getTextColor()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then ColorSpace COSObject return {@link COSName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#getTextColor()}
   */
  @Test
  @DisplayName("Test getTextColor(); given PDOutlineItem(); then ColorSpace COSObject return COSName")
  void testGetTextColor_givenPDOutlineItem_thenColorSpaceCOSObjectReturnCOSName() {
    // Arrange and Act
    PDColor actualTextColor = (new PDOutlineItem()).getTextColor();

    // Assert
    PDColorSpace colorSpace = actualTextColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceRGB);
    assertEquals("DeviceRGB", ((COSName) cOSObject).getName());
    assertEquals("DeviceRGB", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(actualTextColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(3, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertFalse(actualTextColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualTextColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(Color)} with {@code Color}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#setItem(COSName, COSBase)} does nothing.</li>
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setTextColor(Color)}
   */
  @Test
  @DisplayName("Test setTextColor(Color) with 'Color'; given COSDictionary setItem(COSName, COSBase) does nothing; then calls setItem(COSName, COSBase)")
  void testSetTextColorWithColor_givenCOSDictionarySetItemDoesNothing_thenCallsSetItem() throws NumberFormatException {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.setTextColor(Color.decode("42"));

    // Assert
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName("Test setTextColor(PDColor) with 'PDColor'; given FALSE; when COSArray() add FALSE")
  void testSetTextColorWithPDColor_givenFalse_whenCOSArrayAddFalse() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdOutlineItem.setTextColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor textColor = pdOutlineItem.getTextColor();
    assertNull(textColor.getPatternName());
    assertFalse(textColor.isPattern());
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} TextColor Pattern.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName("Test setTextColor(PDColor) with 'PDColor'; then PDOutlineItem() TextColor Pattern")
  void testSetTextColorWithPDColor_thenPDOutlineItemTextColorPattern() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setTextColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    assertTrue(pdOutlineItem.getTextColor().isPattern());
  }

  /**
   * Test {@link PDOutlineItem#setTextColor(PDColor)} with {@code PDColor}.
   * <ul>
   *   <li>Then {@link PDOutlineItem#PDOutlineItem()} TextColor PatternName is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setTextColor(PDColor)}
   */
  @Test
  @DisplayName("Test setTextColor(PDColor) with 'PDColor'; then PDOutlineItem() TextColor PatternName is 'null'")
  void testSetTextColorWithPDColor_thenPDOutlineItemTextColorPatternNameIsNull() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();

    // Act
    pdOutlineItem.setTextColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor textColor = pdOutlineItem.getTextColor();
    assertNull(textColor.getPatternName());
    assertFalse(textColor.isPattern());
  }

  /**
   * Test {@link PDOutlineItem#isItalic()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#isItalic()}
   */
  @Test
  @DisplayName("Test isItalic(); given PDOutlineItem() insertSiblingAfter PDOutlineItem(); then return 'false'")
  void testIsItalic_givenPDOutlineItemInsertSiblingAfterPDOutlineItem_thenReturnFalse() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isItalic());
  }

  /**
   * Test {@link PDOutlineItem#isItalic()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#isItalic()}
   */
  @Test
  @DisplayName("Test isItalic(); given PDOutlineItem(); then return 'false'")
  void testIsItalic_givenPDOutlineItem_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItem()).isItalic());
  }

  /**
   * Test {@link PDOutlineItem#setItalic(boolean)}.
   * <ul>
   *   <li>Then not {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic is
   * {@link COSDictionary} Italic.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setItalic(boolean)}
   */
  @Test
  @DisplayName("Test setItalic(boolean); then not PDOutlineItem(COSDictionary) with dic is COSDictionary Italic")
  void testSetItalic_thenNotPDOutlineItemWithDicIsCOSDictionaryItalic() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.setItalic(true);

    // Assert that nothing has changed
    verify(dic).setFlag(isA(COSName.class), eq(1), eq(true));
    assertFalse(pdOutlineItem.isItalic());
  }

  /**
   * Test {@link PDOutlineItem#isBold()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()} insertSiblingAfter
   * {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#isBold()}
   */
  @Test
  @DisplayName("Test isBold(); given PDOutlineItem() insertSiblingAfter PDOutlineItem(); then return 'false'")
  void testIsBold_givenPDOutlineItemInsertSiblingAfterPDOutlineItem_thenReturnFalse() {
    // Arrange
    PDOutlineItem pdOutlineItem = new PDOutlineItem();
    pdOutlineItem.insertSiblingAfter(new PDOutlineItem());

    // Act and Assert
    assertFalse(pdOutlineItem.isBold());
  }

  /**
   * Test {@link PDOutlineItem#isBold()}.
   * <ul>
   *   <li>Given {@link PDOutlineItem#PDOutlineItem()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#isBold()}
   */
  @Test
  @DisplayName("Test isBold(); given PDOutlineItem(); then return 'false'")
  void testIsBold_givenPDOutlineItem_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDOutlineItem()).isBold());
  }

  /**
   * Test {@link PDOutlineItem#setBold(boolean)}.
   * <ul>
   *   <li>Then not {@link PDOutlineItem#PDOutlineItem(COSDictionary)} with dic is
   * {@link COSDictionary} Bold.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDOutlineItem#setBold(boolean)}
   */
  @Test
  @DisplayName("Test setBold(boolean); then not PDOutlineItem(COSDictionary) with dic is COSDictionary Bold")
  void testSetBold_thenNotPDOutlineItemWithDicIsCOSDictionaryBold() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFlag(Mockito.<COSName>any(), anyInt(), anyBoolean());
    PDOutlineItem pdOutlineItem = new PDOutlineItem(dic);

    // Act
    pdOutlineItem.setBold(true);

    // Assert that nothing has changed
    verify(dic).setFlag(isA(COSName.class), eq(2), eq(true));
    assertFalse(pdOutlineItem.isBold());
  }
}
