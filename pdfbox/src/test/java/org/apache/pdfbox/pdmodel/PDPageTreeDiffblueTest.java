package org.apache.pdfbox.pdmodel;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageTreeDiffblueTest {
  /**
   * Test {@link PDPageTree#PDPageTree()}.
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree()}
   */
  @Test
  @DisplayName("Test new PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>()"})
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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Count is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary); when COSDictionary(); then return Count is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary)"})
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
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Count is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary, PDDocument); when COSDictionary(); then return Count is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary, PDDocument)"})
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
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary)"})
  void testNewPDPageTree_whenCOSStream_thenReturnCOSObjectIsCOSStream() {
    // Arrange
    COSStream root = new COSStream();

    // Act and Assert
    assertSame(root, new PDPageTree(root).getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary, PDDocument); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary, PDDocument)"})
  void testNewPDPageTree_whenCOSStream_thenReturnCOSObjectIsCOSStream2() {
    // Arrange
    COSStream root = new COSStream();

    // Act
    PDPageTree actualPdPageTree = new PDPageTree(root, new PDDocument());

    // Assert
    assertSame(root, actualPdPageTree.getCOSObject());
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary)"})
  void testNewPDPageTree_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null));
  }

  /**
   * Test {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDPageTree(COSDictionary, PDDocument); when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.<init>(COSDictionary, PDDocument)"})
  void testNewPDPageTree_whenNull_thenThrowIllegalArgumentException2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null, new PDDocument()));
  }

  /**
   * Test {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSDictionary, COSName); when COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDPageTree.getInheritableAttribute(COSDictionary, COSName)"})
  void testGetInheritableAttribute_whenCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDPageTree.getInheritableAttribute(new COSDictionary(), COSName.A));
  }

  /**
   * Test {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}
   */
  @Test
  @DisplayName(
      "Test getInheritableAttribute(COSDictionary, COSName); when COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDPageTree.getInheritableAttribute(COSDictionary, COSName)"})
  void testGetInheritableAttribute_whenCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(PDPageTree.getInheritableAttribute(new COSStream(), COSName.A));
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()} Key is {@link COSObjectKey#COSObjectKey(long,
   *       int)} with num is five and gen is five.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName(
      "Test iterator(); given COSDictionary() Key is COSObjectKey(long, int) with num is five and gen is five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPageTree.iterator()"})
  void testIterator_givenCOSDictionaryKeyIsCOSObjectKeyWithNumIsFiveAndGenIsFive() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    pageDictionary.setKey(new COSObjectKey(5L, 5));
    PDPage page = new PDPage(pageDictionary);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(page);

    // Act and Assert
    assertFalse(pdPageTree.iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPageTree.iterator()"})
  void testIterator_givenPDPageTree() {
    // Arrange, Act and Assert
    assertFalse(new PDPageTree().iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#iterator()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.
   *   <li>Then return next is {@link PDPage#PDPage()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree() add PDPage(); then return next is PDPage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPageTree.iterator()"})
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
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  @DisplayName("Test iterator(); given PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterator PDPageTree.iterator()"})
  void testIterator_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDPageTree(new COSDictionary()).iterator().hasNext());
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int) with 'index'; given PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageTree.get(int)"})
  void testGetWithIndex_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDPageTree(new COSDictionary()).get(1));
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int) with 'index'; given PDPageTree(COSDictionary) with root is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageTree.get(int)"})
  void testGetWithIndex_givenPDPageTreeWithRootIsCOSStream() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDPageTree(new COSStream()).get(1));
  }

  /**
   * Test {@link PDPageTree#get(int)} with {@code index}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  @DisplayName(
      "Test get(int) with 'index'; then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDPage PDPageTree.get(int)"})
  void testGetWithIndex_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSDictionary pageDictionary = new COSDictionary();
    COSObjectKey key = new COSObjectKey(1L, 1);
    pageDictionary.setKey(key);
    PDPage page = new PDPage(pageDictionary);

    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());
    pdPageTree.add(page);

    // Act
    PDPage actualGetResult = pdPageTree.get(1);

    // Assert
    float[][] values = actualGetResult.getMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(key, actualGetResult.getCOSObject().getKey());
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
    assertArrayEquals(new float[] {0.0f, 1.0f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {1.0f, 0.0f, 0.0f}, values[0], 0.0f);
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage(COSDictionary)} with
   *       pageDictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName(
      "Test indexOf(PDPage); given PDPageTree() add PDPage(COSDictionary) with pageDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.indexOf(PDPage)"})
  void testIndexOf_givenPDPageTreeAddPDPageWithPageDictionaryIsCOSDictionary() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage(new COSDictionary()));

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()} add {@link PDPage#PDPage()}.
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName(
      "Test indexOf(PDPage); given PDPageTree() add PDPage(); when PDPage(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.indexOf(PDPage)"})
  void testIndexOf_givenPDPageTreeAddPDPage_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName(
      "Test indexOf(PDPage); given PDPageTree(COSDictionary) with root is COSDictionary(); when PDPage(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.indexOf(PDPage)"})
  void testIndexOf_givenPDPageTreeWithRootIsCOSDictionary_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree(new COSDictionary());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#indexOf(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  @DisplayName("Test indexOf(PDPage); given PDPageTree(); when PDPage(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.indexOf(PDPage)"})
  void testIndexOf_givenPDPageTree_whenPDPage_thenReturnMinusOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Test {@link PDPageTree#getCount()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  @DisplayName("Test getCount(); given PDPageTree()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.getCount()"})
  void testGetCount_givenPDPageTree() {
    // Arrange, Act and Assert
    assertEquals(0, new PDPageTree().getCount());
  }

  /**
   * Test {@link PDPageTree#getCount()}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  @DisplayName("Test getCount(); given PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDPageTree.getCount()"})
  void testGetCount_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(0, new PDPageTree(new COSDictionary()).getCount());
  }

  /**
   * Test {@link PDPageTree#getCOSObject()}.
   *
   * <p>Method under test: {@link PDPageTree#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDPageTree.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSDictionary actualCOSObject = new PDPageTree().getCOSObject();

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
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int) with 'index'; given PDPageTree(COSDictionary) with root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.remove(int)"})
  void testRemoveWithIndex_givenPDPageTreeWithRootIsCOSDictionary() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDPageTree(new COSDictionary()).remove(1));
  }

  /**
   * Test {@link PDPageTree#remove(int)} with {@code index}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree(COSDictionary)} with root is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int) with 'index'; given PDPageTree(COSDictionary) with root is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.remove(int)"})
  void testRemoveWithIndex_givenPDPageTreeWithRootIsCOSStream() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDPageTree(new COSStream()).remove(1));
  }

  /**
   * Test {@link PDPageTree#remove(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  @DisplayName(
      "Test remove(PDPage) with 'page'; given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.remove(PDPage)"})
  void testRemoveWithPage_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    // Act
    pdPageTree.remove(new PDPage(pageDictionary));

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
  }

  /**
   * Test {@link PDPageTree#remove(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  @DisplayName(
      "Test remove(PDPage) with 'page'; given COSDictionary getInt(COSName) return one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.remove(PDPage)"})
  void testRemoveWithPage_givenCOSDictionaryGetIntReturnOne_thenCallsSetInt() {
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
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

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
   * Test {@link PDPageTree#remove(PDPage)} with {@code page}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  @DisplayName("Test remove(PDPage) with 'page'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.remove(PDPage)"})
  void testRemoveWithPage_thenThrowIllegalArgumentException() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.removeObject(Mockito.<COSBase>any())).thenReturn(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary pageDictionary = mock(COSDictionary.class);
    when(pageDictionary.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdPageTree.remove(new PDPage(pageDictionary)));
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(pageDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName(
      "Test add(PDPage); given COSDictionary getCOSArray(COSName) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.add(PDPage)"})
  void testAdd_givenCOSDictionaryGetCOSArrayThrowIllegalArgumentException() {
    // Arrange
    COSDictionary root = mock(COSDictionary.class);
    when(root.getCOSArray(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException());
    when(root.isDirect()).thenReturn(true);
    when(root.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(root.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDPageTree pdPageTree = new PDPageTree(root);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.add(new PDPage()));
    verify(root).isDirect();
    verify(root).getCOSArray(isA(COSName.class));
    verify(root).getCOSName(isA(COSName.class));
    verify(root).getUpdateState();
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName(
      "Test add(PDPage); given COSDictionary getInt(COSName) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.add(PDPage)"})
  void testAdd_givenCOSDictionaryGetIntThrowIllegalArgumentException() {
    // Arrange
    COSDictionary root = mock(COSDictionary.class);
    when(root.getInt(Mockito.<COSName>any())).thenThrow(new IllegalArgumentException());
    when(root.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(root.isDirect()).thenReturn(true);
    when(root.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(root.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDPageTree pdPageTree = new PDPageTree(root);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.add(new PDPage()));
    verify(root).isDirect();
    verify(root).getCOSArray(isA(COSName.class));
    verify(root).getCOSName(isA(COSName.class));
    verify(root).getInt(isA(COSName.class));
    verify(root).getUpdateState();
  }

  /**
   * Test {@link PDPageTree#add(PDPage)}.
   *
   * <ul>
   *   <li>Given {@link PDPageTree#PDPageTree()}.
   *   <li>When {@link PDPage#PDPage()}.
   *   <li>Then {@link PDPageTree#PDPageTree()} Count is one.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  @DisplayName(
      "Test add(PDPage); given PDPageTree(); when PDPage(); then PDPageTree() Count is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.add(PDPage)"})
  void testAdd_givenPDPageTree_whenPDPage_thenPDPageTreeCountIsOne() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage page = new PDPage();

    // Act
    pdPageTree.add(page);

    // Assert
    assertEquals(1, pdPageTree.getCount());
    Iterator<PDPage> iteratorResult = pdPageTree.iterator();
    PDPage actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertEquals(page, actualNextResult);
  }

  /**
   * Test {@link PDPageTree#insertBefore(PDPage, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDPage, PDPage); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertBefore(PDPage, PDPage)"})
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
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

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
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDPage, PDPage); given COSArray getObject(int) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertBefore(PDPage, PDPage)"})
  void testInsertBefore_givenCOSArrayGetObjectThrowIllegalArgumentException() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new IllegalArgumentException());
    when(cosArray.size()).thenReturn(3);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    PDPage nextPage = mock(PDPage.class);
    when(nextPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertBefore(newPage, nextPage));
    verify(cosArray).getObject(0);
    verify(cosArray).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(nextPage).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertBefore(PDPage, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertBefore(PDPage, PDPage); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertBefore(PDPage, PDPage)"})
  void testInsertBefore_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

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
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertAfter(PDPage, PDPage); given COSArray getObject(int) return COSDictionary(); then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertAfter(PDPage, PDPage)"})
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
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

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
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertAfter(PDPage, PDPage); given COSArray getObject(int) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertAfter(PDPage, PDPage)"})
  void testInsertAfter_givenCOSArrayGetObjectThrowIllegalArgumentException() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenThrow(new IllegalArgumentException());
    when(cosArray.size()).thenReturn(3);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    PDPage prevPage = mock(PDPage.class);
    when(prevPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertAfter(newPage, prevPage));
    verify(cosArray).getObject(0);
    verify(cosArray).size();
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(prevPage).getCOSObject();
  }

  /**
   * Test {@link PDPageTree#insertAfter(PDPage, PDPage)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  @DisplayName(
      "Test insertAfter(PDPage, PDPage); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDPageTree.insertAfter(PDPage, PDPage)"})
  void testInsertAfter_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage newPage = new PDPage();

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosDictionary);

    PDPage prevPage = mock(PDPage.class);
    when(prevPage.getCOSObject()).thenReturn(cosDictionary2);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> pdPageTree.insertAfter(newPage, prevPage));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(prevPage).getCOSObject();
  }
}
