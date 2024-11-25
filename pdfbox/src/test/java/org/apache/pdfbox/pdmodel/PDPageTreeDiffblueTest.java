package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageTreeDiffblueTest {
  /**
   * Test {@link PDPageTree#PDPageTree()}.
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree()}
   */
  @Test
  @DisplayName("Test new PDPageTree()")
  void testNewPDPageTree() {
    // Arrange and Act
    PDPageTree actualPdPageTree = new PDPageTree();

    // Assert
    COSDictionary cOSObject = actualPdPageTree.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, actualPdPageTree.getCount());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualPdPageTree.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageTree(COSDictionary); when COSDictionary(); then return Count is zero")
  void testNewPDPageTree_whenCOSDictionary_thenReturnCountIsZero() {
    // Arrange
    COSDictionary root = new COSDictionary();

    // Act
    PDPageTree actualPdPageTree = new PDPageTree(root);

    // Assert
    assertEquals(0, actualPdPageTree.getCount());
    assertFalse(actualPdPageTree.iterator().hasNext());
    assertSame(root, actualPdPageTree.getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  @DisplayName("Test new PDPageTree(COSDictionary, PDDocument); when COSDictionary(); then return Count is zero")
  void testNewPDPageTree_whenCOSDictionary_thenReturnCountIsZero2() {
    // Arrange
    COSDictionary root = new COSDictionary();

    // Act
    PDPageTree actualPdPageTree = new PDPageTree(root, new PDDocument());

    // Assert
    assertEquals(0, actualPdPageTree.getCount());
    assertFalse(actualPdPageTree.iterator().hasNext());
    assertSame(root, actualPdPageTree.getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageTree(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewPDPageTree_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    COSStream root = new COSStream();

    // Act and Assert
    assertSame(root, (new PDPageTree(root)).getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  @DisplayName("Test new PDPageTree(COSDictionary, PDDocument); when COSStream(); then return COSObject is COSStream()")
  void testNewPDPageTree_whenCOSStream_thenReturnCOSObjectIsCOSStream2() {
    // Arrange
    COSStream root = new COSStream();

    // Act and Assert
    assertSame(root, (new PDPageTree(root, new PDDocument())).getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDPageTree(COSDictionary); when 'null'; then throw IllegalArgumentException")
  void testNewPDPageTree_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null));
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null, new PDDocument()));
  }

  /**
   * Test {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSDictionary, COSName); when COSDictionary(); then return 'null'")
  void testGetInheritableAttribute_whenCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDPageTree.getInheritableAttribute(new COSDictionary(), COSName.A));
  }

  /**
   * Test {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}
   */
  @Test
  @DisplayName("Test getInheritableAttribute(COSDictionary, COSName); when COSStream(); then return 'null'")
  void testGetInheritableAttribute_whenCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDPageTree.getInheritableAttribute(new COSStream(), COSName.A));
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree()")
  void testIterator_givenPDPageTree() {
    // Arrange, Act and Assert
    assertFalse((new PDPageTree()).iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.</li>
   *   <li>Then return next is {@link PDPage#PDPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree() add PDPage(); then return next is PDPage()")
  void testIterator_givenPDPageTreeAddPDPage_thenReturnNextIsPDPage() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage page = new PDPage();
    pdPageTree.add(page);

    // Act
    Iterator<PDPage> actualIteratorResult = pdPageTree.iterator();

    // Assert
    PDPage actualNextResult = actualIteratorResult.next();
    assertFalse(actualIteratorResult.hasNext());
    assertEquals(page, actualNextResult);
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree(COSDictionary) with root is COSDictionary()")
  void testIterator_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDPageTree(new COSDictionary())).iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName("Test get(int) with 'index'; given PDPageTree(COSDictionary) with root is COSDictionary()")
  void testGetWithIndex_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSDictionary())).get(1));
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName("Test get(int) with 'index'; given PDPageTree(COSDictionary) with root is COSStream()")
  void testGetWithIndex_givenPDPageTreeWithRootIsCOSStream() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSStream())).get(1));
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)}
   * with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName("Test get(int) with 'index'; then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  void testGetWithIndex_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);

    pageDictionary.setKey(key);
    PDPage page = new PDPage(pageDictionary);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());
    pdPageTree.add(page);

    // Act and Assert
    assertSame(key, pdPageTree.get(1).getCOSObject().getKey());
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add
   * {@link PDPage#PDPage(COSDictionary)} with pageDictionary is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName("Test indexOf(PDPage); given PDPageTree() add PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  void testIndexOf_givenPDPageTreeAddPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage(new COSDictionary()));

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName("Test indexOf(PDPage); given PDPageTree() add PDPage(); when PDPage(); then return minus one")
  void testIndexOf_givenPDPageTreeAddPDPage_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName("Test indexOf(PDPage); given PDPageTree(COSDictionary) with root is COSDictionary(); when PDPage(); then return minus one")
  void testIndexOf_givenPDPageTreeWithRootIsCOSDictionary_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree(new COSDictionary());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.</li>
   *   <li>When {@link PDPage#PDPage()}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName("Test indexOf(PDPage); given PDPageTree(); when PDPage(); then return minus one")
  void testIndexOf_givenPDPageTree_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#getCount()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  @DisplayName("Test getCount(); given PDPageTree()")
  void testGetCount_givenPDPageTree() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPageTree()).getCount());
  }

  /**
   * Test {@link PDPageTree#getCount()}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  @DisplayName("Test getCount(); given PDPageTree(COSDictionary) with root is COSDictionary()")
  void testGetCount_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPageTree(new COSDictionary())).getCount());
  }

  /**
   * Test {@link PDPageTree#getCOSObject()}.
   * <p>
   * Method under test: {@link PDPageTree#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = (new PDPageTree()).getCOSObject();

    // Assert
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(3, actualCOSObject.getValues().size());
    assertEquals(3, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDPageTree#remove(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int) with 'index'; given PDPageTree(COSDictionary) with root is COSDictionary()")
  void testRemoveWithIndex_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSDictionary())).remove(1));
  }

  /**
   * Test {@link PDPageTree#remove(int)} with {@code index}.
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int) with 'index'; given PDPageTree(COSDictionary) with root is COSStream()")
  void testRemoveWithIndex_givenPDPageTreeWithRootIsCOSStream() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSStream())).remove(1));
  }

  /**
   * Test {@link PDPageTree#remove(PDPage)} with {@code page}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  @DisplayName("Test remove(PDPage) with 'page'; given COSDictionary getCOSArray(COSName) return COSArray()")
  void testRemoveWithPage_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    pdPageTree.remove(new PDPage(pageDictionary));

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Test {@link PDPageTree#remove(PDPage)} with {@code page}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return
   * one.</li>
   *   <li>Then calls {@link COSArray#removeObject(COSBase)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  @DisplayName("Test remove(PDPage) with 'page'; given COSDictionary getInt(COSName) return one; then calls removeObject(COSBase)")
  void testRemoveWithPage_givenCOSDictionaryGetIntReturnOne_thenCallsRemoveObject() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    pdPageTree.remove(new PDPage(pageDictionary));

    // Assert
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary).setInt(isA(COSName.class), eq(0));
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName, COSName)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName("Test add(PDPage); given COSDictionary getCOSDictionary(COSName, COSName) return COSDictionary(); then calls getInt(COSName)")
  void testAdd_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary_thenCallsGetInt() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setInt(Mockito.<COSName>any(), anyInt());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(cosDictionary2.isDirect()).thenReturn(true);
    when(cosDictionary2.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary2).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    pdPageTree.add(page);

    // Assert
    verify(cosDictionary2).isDirect();
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary2).getUpdateState();
    verify(cosDictionary).setInt(isA(COSName.class), eq(2));
    verify(cosDictionary2).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
    assertEquals(0, pdPageTree.getCount());
    assertFalse(pdPageTree.iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   * <ul>
   *   <li>Then {@link PDPageTree#PDPageTree()} Count is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName("Test add(PDPage); then PDPageTree() Count is zero")
  void testAdd_thenPDPageTreeCountIsZero() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(new COSDictionary());
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act
    pdPageTree.add(page);

    // Assert
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
    assertEquals(0, pdPageTree.getCount());
    assertFalse(pdPageTree.iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName("Test add(PDPage); then throw IllegalArgumentException")
  void testAdd_thenThrowIllegalArgumentException() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenThrow(new IllegalArgumentException("foo"));
    when(cosDictionary.isDirect()).thenReturn(true);
    when(cosDictionary.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.add(page));
    verify(cosDictionary).isDirect();
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getUpdateState();
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(page).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertBefore(PDPage, PDPage)}.
   * <p>
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertBefore(PDPage, PDPage)")
  void testInsertBefore() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt()))
        .thenThrow(new IllegalArgumentException("attempted to insert before orphan page"));
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage nextPage = mock(PDPage.class);
    when(nextPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertBefore(newPage, nextPage));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(nextPage).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertBefore(PDPage, PDPage)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertBefore(PDPage, PDPage); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  void testInsertBefore_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsGetObject() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage nextPage = mock(PDPage.class);
    when(nextPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertBefore(newPage, nextPage));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(nextPage, atLeast(1)).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertBefore(PDPage, PDPage)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertBefore(PDPage, PDPage); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testInsertBefore_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage nextPage = mock(PDPage.class);
    when(nextPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertBefore(newPage, nextPage));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(nextPage).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertAfter(PDPage, PDPage)}.
   * <p>
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertAfter(PDPage, PDPage)")
  void testInsertAfter() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt()))
        .thenThrow(new IllegalArgumentException("attempted to insert before orphan page"));
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage prevPage = mock(PDPage.class);
    when(prevPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertAfter(newPage, prevPage));
    verify(cosArray).getObject(eq(0));
    verify(cosArray).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(prevPage).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertAfter(PDPage, PDPage)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertAfter(PDPage, PDPage); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  void testInsertAfter_givenCOSArrayGetObjectReturnCOSDictionary_thenCallsGetObject() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(new COSDictionary());
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage prevPage = mock(PDPage.class);
    when(prevPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertAfter(newPage, prevPage));
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(prevPage, atLeast(1)).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertAfter(PDPage, PDPage)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName("Test insertAfter(PDPage, PDPage); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testInsertAfter_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage prevPage = mock(PDPage.class);
    when(prevPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertAfter(newPage, prevPage));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(prevPage).getCOSObject();
  }
}
