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
import java.io.IOException;
import java.util.Iterator;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDPageTreeDiffblueTest {
  /**
   * Method under test:
   * {@link PDPageTree#getInheritableAttribute(COSDictionary, COSName)}
   */
  @Test
  void testGetInheritableAttribute() {
    // Arrange, Act and Assert
    assertNull(PDPageTree.getInheritableAttribute(new COSDictionary(), COSName.A));
    assertNull(PDPageTree.getInheritableAttribute(new COSDictionary(), null));
  }

  /**
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  void testIterator() {
    // Arrange, Act and Assert
    assertFalse((new PDPageTree()).iterator().hasNext());
    assertFalse((new PDPageTree(new COSDictionary())).iterator().hasNext());
  }

  /**
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  void testIterator2() {
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
   * Method under test: {@link PDPageTree#iterator()}
   */
  @Test
  void testIterator3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    Iterator<PDPage> actualIteratorResult = (new PDPageTree(new COSDictionary(), document)).iterator();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link PDPageTree#get(int)}
   */
  @Test
  void testGet() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSDictionary())).get(1));
  }

  /**
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  void testIndexOf() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  void testIndexOf2() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree(new COSDictionary());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  void testIndexOf3() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage());

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  void testIndexOf4() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    pdPageTree.add(new PDPage(new COSDictionary()));

    // Act and Assert
    assertEquals(-1, pdPageTree.indexOf(new PDPage()));
  }

  /**
   * Method under test: {@link PDPageTree#indexOf(PDPage)}
   */
  @Test
  void testIndexOf5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    PDPageTree pdPageTree = new PDPageTree(new COSDictionary(), document);

    // Act
    int actualIndexOfResult = pdPageTree.indexOf(new PDPage());

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1, actualIndexOfResult);
  }

  /**
   * Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  void testGetCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDPageTree()).getCount());
    assertEquals(0, (new PDPageTree(new COSDictionary())).getCount());
  }

  /**
   * Method under test: {@link PDPageTree#getCount()}
   */
  @Test
  void testGetCount2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);

    // Act
    int actualCount = (new PDPageTree(new COSDictionary(), document)).getCount();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualCount);
  }

  /**
   * Method under test: {@link PDPageTree#getCOSObject()}
   */
  @Test
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
   * Method under test: {@link PDPageTree#getCOSObject()}
   */
  @Test
  void testGetCOSObject2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument document = new PDDocument(streamCacheCreateFunction);
    COSDictionary root = new COSDictionary();

    // Act
    COSDictionary actualCOSObject = (new PDPageTree(root, document)).getCOSObject();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertSame(root, actualCOSObject);
  }

  /**
   * Method under test: {@link PDPageTree#remove(int)}
   */
  @Test
  void testRemove() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDPageTree(new COSDictionary())).remove(1));
  }

  /**
   * Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  void testRemove2() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    pdPageTree.remove(page);

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary2).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDPageTree#remove(PDPage)}
   */
  @Test
  void testRemove3() {
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
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getCOSDictionary(Mockito.<COSName>any(), Mockito.<COSName>any())).thenReturn(cosDictionary);
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(cosDictionary2);

    // Act
    pdPageTree.remove(page);

    // Assert
    verify(cosArray).removeObject(isA(COSBase.class));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary2, atLeast(1)).getCOSDictionary(isA(COSName.class), isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    verify(cosDictionary).setInt(isA(COSName.class), eq(0));
    verify(page).getCOSObject();
  }

  /**
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  void testAdd() {
    // Arrange
    PDPageTree pdPageTree = new PDPageTree();
    PDPage page = mock(PDPage.class);
    when(page.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdPageTree.add(page);

    // Assert
    verify(page).getCOSObject();
    assertEquals(1, pdPageTree.getCount());
    assertFalse(pdPageTree.iterator().hasNext());
  }

  /**
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  void testAdd2() {
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
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  void testAdd3() {
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
   * Method under test: {@link PDPageTree#add(PDPage)}
   */
  @Test
  void testAdd4() {
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
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  void testInsertBefore() {
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
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  void testInsertBefore2() {
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
   * Method under test: {@link PDPageTree#insertBefore(PDPage, PDPage)}
   */
  @Test
  void testInsertBefore3() {
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
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  void testInsertAfter() {
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

  /**
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  void testInsertAfter2() {
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
   * Method under test: {@link PDPageTree#insertAfter(PDPage, PDPage)}
   */
  @Test
  void testInsertAfter3() {
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
   * Method under test: {@link PDPageTree#PDPageTree()}
   */
  @Test
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
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  void testNewPDPageTree2() {
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
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary)}
   */
  @Test
  void testNewPDPageTree3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null));
  }

  /**
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  void testNewPDPageTree4() {
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
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  void testNewPDPageTree5() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDPageTree(null, new PDDocument()));

  }

  /**
   * Method under test: {@link PDPageTree#PDPageTree(COSDictionary, PDDocument)}
   */
  @Test
  void testNewPDPageTree6() throws IOException {
    // Arrange
    COSDictionary root = new COSDictionary();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    PDPageTree actualPdPageTree = new PDPageTree(root, new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(0, actualPdPageTree.getCount());
    assertFalse(actualPdPageTree.iterator().hasNext());
    assertSame(root, actualPdPageTree.getCOSObject());
  }
}
