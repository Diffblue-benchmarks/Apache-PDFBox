package org.apache.pdfbox.debugger.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.swing.event.TreeModelListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreePath;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDFTreeModelDiffblueTest {
  /**
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  void testGetChild() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTreeModel()).getChild("Parent", 1));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  void testGetChild2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    Object actualChild = pdfTreeModel.getChild(new XrefEntry(1, key, 1L, cosObject), 1);

    // Assert
    COSBase value = ((ArrayEntry) actualChild).getValue();
    assertTrue(value instanceof COSArray);
    assertTrue(actualChild instanceof ArrayEntry);
    assertEquals(1, ((ArrayEntry) actualChild).getIndex());
    assertTrue(((COSArray) value).toList().isEmpty());
    assertSame(object, value);
    assertSame(cosObject, ((ArrayEntry) actualChild).getItem());
  }

  /**
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  void testGetChild3() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();

    // Act
    Object actualChild = pdfTreeModel.getChild(new COSObject(object, new COSObjectKey(1L, 1)), 1);

    // Assert
    assertTrue(actualChild instanceof COSArray);
    assertTrue(((COSArray) actualChild).toList().isEmpty());
    assertSame(object, actualChild);
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFTreeModel()).getChildCount("Parent"));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(mapEntry));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount3() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(arrayEntry));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount4() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount5() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new DocumentEntry(new PDDocument(), "foo.txt")));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount6() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new XrefEntries(new PDDocument())));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount7() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(1,
        pdfTreeModel.getChildCount(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount8() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount9() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(1, pdfTreeModel.getChildCount(new COSObject(object, new COSObjectKey(1L, 1))));
  }

  /**
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  void testGetChildCount10() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(new COSArray());

    COSArray val = new COSArray();
    val.add(object);

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(val);
    mapEntry.setValue(new COSArray());

    // Act
    int actualChildCount = pdfTreeModel.getChildCount(mapEntry);

    // Assert
    verify(object).getCOSObject();
    assertEquals(0, actualChildCount);
  }

  /**
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  void testGetIndexOfChild() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTreeModel()).getIndexOfChild("Parent", "Child"));
  }

  /**
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  void testGetIndexOfChild2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(new MapEntry(), "Child"));
  }

  /**
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  void testGetIndexOfChild3() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(new ArrayEntry(), "Child"));
  }

  /**
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  void testGetIndexOfChild4() throws IOException {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getIndexOfChild(
        new COSObject(object,
            new COSParser(
                new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', -1, 'A', -1, 'A', -1, 'A', -1})))),
        "Child"));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf() {
    // Arrange, Act and Assert
    assertTrue((new PDFTreeModel()).isLeaf("Node"));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(mapEntry));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf3() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(arrayEntry));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf4() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new MapEntry()));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf5() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new ArrayEntry()));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf6() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDictionary()));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf7() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDocument()));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf8() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new DocumentEntry(new PDDocument(), "foo.txt")));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf9() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new XrefEntries(new PDDocument())));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf10() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf11() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }

  /**
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  void testIsLeaf12() throws IOException {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    boolean actualIsLeafResult = pdfTreeModel.isLeaf(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertFalse(actualIsLeafResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFTreeModel#PDFTreeModel()}
   *   <li>{@link PDFTreeModel#addTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#removeTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#valueForPathChanged(TreePath, Object)}
   *   <li>{@link PDFTreeModel#getRoot()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel();
    actualPdfTreeModel.addTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.valueForPathChanged(new TreePath(new Object[]{"42"}), "New Value");

    // Assert that nothing has changed
    assertNull(actualPdfTreeModel.getRoot());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFTreeModel#PDFTreeModel(DocumentEntry)}
   *   <li>{@link PDFTreeModel#addTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#removeTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#valueForPathChanged(TreePath, Object)}
   *   <li>{@link PDFTreeModel#getRoot()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    DocumentEntry docEntry = new DocumentEntry(new PDDocument(), "foo.txt");

    // Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel(docEntry);
    actualPdfTreeModel.addTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.valueForPathChanged(new TreePath(new Object[]{"42"}), "New Value");

    // Assert that nothing has changed
    assertSame(docEntry, actualPdfTreeModel.getRoot());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDFTreeModel#PDFTreeModel(XrefEntries)}
   *   <li>{@link PDFTreeModel#addTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#removeTreeModelListener(TreeModelListener)}
   *   <li>{@link PDFTreeModel#valueForPathChanged(TreePath, Object)}
   *   <li>{@link PDFTreeModel#getRoot()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange
    XrefEntries xrefEntries = new XrefEntries(new PDDocument());

    // Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel(xrefEntries);
    actualPdfTreeModel.addTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.valueForPathChanged(new TreePath(new Object[]{"42"}), "New Value");
    Object actualRoot = actualPdfTreeModel.getRoot();

    // Assert that nothing has changed
    assertTrue(actualRoot instanceof XrefEntries);
    assertSame(xrefEntries, actualRoot);
  }

  /**
   * Method under test: {@link PDFTreeModel#PDFTreeModel(PDDocument)}
   */
  @Test
  void testNewPDFTreeModel() {
    // Arrange
    COSDocument cosDocument = mock(COSDocument.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(cosDocument.getTrailer()).thenReturn(cosDictionary);
    PDDocument doc = mock(PDDocument.class);
    when(doc.getDocument()).thenReturn(cosDocument);

    // Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel(doc);

    // Assert
    verify(cosDocument).getTrailer();
    verify(doc).getDocument();
    assertSame(cosDictionary, actualPdfTreeModel.getRoot());
  }
}
