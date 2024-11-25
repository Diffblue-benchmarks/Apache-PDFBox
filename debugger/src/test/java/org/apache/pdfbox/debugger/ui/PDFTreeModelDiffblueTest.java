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
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDFTreeModelDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
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
   * Test getters and setters.
   * <ul>
   *   <li>Then return Root is {@code null}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; then return Root is 'null'")
  void testGettersAndSetters_thenReturnRootIsNull() {
    // Arrange and Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel();
    actualPdfTreeModel.addTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener((new BasicTreeUI()).new TreeModelHandler());
    actualPdfTreeModel.valueForPathChanged(new TreePath(new Object[]{"42"}), "New Value");

    // Assert that nothing has changed
    assertNull(actualPdfTreeModel.getRoot());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then Root return {@link XrefEntries}.</li>
   * </ul>
   * <p>
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
  @DisplayName("Test getters and setters; then Root return XrefEntries")
  void testGettersAndSetters_thenRootReturnXrefEntries() {
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
   * Test {@link PDFTreeModel#PDFTreeModel(PDDocument)}.
   * <ul>
   *   <li>Then return Root is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#PDFTreeModel(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFTreeModel(PDDocument); then return Root is COSDictionary()")
  void testNewPDFTreeModel_thenReturnRootIsCOSDictionary() {
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

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   * <ul>
   *   <li>Then return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return COSArray")
  void testGetChild_thenReturnCOSArray() {
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
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   * <ul>
   *   <li>Then return Dict is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return Dict is COSDictionary()")
  void testGetChild_thenReturnDictIsCOSDictionary() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    COSDictionary pageDictionary = new COSDictionary();
    doc.addPage(new PDPage(pageDictionary));

    // Act
    Object actualChild = pdfTreeModel.getChild(new DocumentEntry(doc, "foo.txt"), 1);

    // Assert
    assertTrue(actualChild instanceof PageEntry);
    assertSame(pageDictionary, ((PageEntry) actualChild).getDict());
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   * <ul>
   *   <li>Then return Item is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return Item is 'null'")
  void testGetChild_thenReturnItemIsNull() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    Object actualChild = pdfTreeModel.getChild(new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null), 1);

    // Assert
    assertTrue(actualChild instanceof ArrayEntry);
    assertNull(((ArrayEntry) actualChild).getItem());
    assertNull(((ArrayEntry) actualChild).getValue());
    assertEquals(1, ((ArrayEntry) actualChild).getIndex());
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   * <ul>
   *   <li>Then Value return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then Value return COSArray")
  void testGetChild_thenValueReturnCOSArray() {
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
    assertTrue(((COSArray) value).toList().isEmpty());
    assertSame(object, value);
    assertSame(cosObject, ((ArrayEntry) actualChild).getItem());
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   * <ul>
   *   <li>When {@code Parent}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); when 'Parent'; then throw IllegalArgumentException")
  void testGetChild_whenParent_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTreeModel()).getChild("Parent", 1));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object)")
  void testGetChildCount() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(1,
        pdfTreeModel.getChildCount(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object)")
  void testGetChildCount2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link MapEntry} (default constructor) Item is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); given COSArray(); when MapEntry (default constructor) Item is COSArray(); then return zero")
  void testGetChildCount_givenCOSArray_whenMapEntryItemIsCOSArray_thenReturnZero() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(mapEntry));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); given one; when ArrayEntry (default constructor) Index is one; then return zero")
  void testGetChildCount_givenOne_whenArrayEntryIndexIsOne_thenReturnZero() {
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
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.</li>
   *   <li>When {@link PDDocument#PDDocument()} addPage
   * {@link PDPage#PDPage()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); given PDPage(); when PDDocument() addPage PDPage(); then return one")
  void testGetChildCount_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act and Assert
    assertEquals(1, pdfTreeModel.getChildCount(new DocumentEntry(doc, "foo.txt")));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when COSDictionary(); then return zero")
  void testGetChildCount_whenCOSDictionary_thenReturnZero() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new COSDictionary()));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when COSObjectKey(long, int) with num is one and gen is one; then return one")
  void testGetChildCount_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();

    // Act and Assert
    assertEquals(1, pdfTreeModel.getChildCount(new COSObject(object, new COSObjectKey(1L, 1))));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>When {@link DocumentEntry#DocumentEntry(PDDocument, String)} with doc is
   * {@link PDDocument#PDDocument()} and filename is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when DocumentEntry(PDDocument, String) with doc is PDDocument() and filename is 'foo.txt'")
  void testGetChildCount_whenDocumentEntryWithDocIsPDDocumentAndFilenameIsFooTxt() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new DocumentEntry(new PDDocument(), "foo.txt")));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>When {@code Parent}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when 'Parent'; then return zero")
  void testGetChildCount_whenParent_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDFTreeModel()).getChildCount("Parent"));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   * <ul>
   *   <li>When {@link XrefEntries#XrefEntries(PDDocument)} with document is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when XrefEntries(PDDocument) with document is PDDocument(); then return zero")
  void testGetChildCount_whenXrefEntriesWithDocumentIsPDDocument_thenReturnZero() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(0, pdfTreeModel.getChildCount(new XrefEntries(new PDDocument())));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   * <ul>
   *   <li>When {@code A}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName("Test getIndexOfChild(Object, Object); when 'A'; then return zero")
  void testGetIndexOfChild_whenA_thenReturnZero() throws IOException {
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
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   * <ul>
   *   <li>When {@link ArrayEntry} (default constructor).</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName("Test getIndexOfChild(Object, Object); when ArrayEntry (default constructor); then return minus one")
  void testGetIndexOfChild_whenArrayEntry_thenReturnMinusOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(new ArrayEntry(), "Child"));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   * <ul>
   *   <li>When {@link MapEntry} (default constructor).</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName("Test getIndexOfChild(Object, Object); when MapEntry (default constructor); then return minus one")
  void testGetIndexOfChild_whenMapEntry_thenReturnMinusOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(new MapEntry(), "Child"));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   * <ul>
   *   <li>When {@code Parent}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName("Test getIndexOfChild(Object, Object); when 'Parent'; then throw IllegalArgumentException")
  void testGetIndexOfChild_whenParent_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new PDFTreeModel()).getIndexOfChild("Parent", "Child"));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object)")
  void testIsLeaf() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null)));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.</li>
   *   <li>When {@link MapEntry} (default constructor) Item is
   * {@link COSArray#COSArray()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); given COSArray(); when MapEntry (default constructor) Item is COSArray(); then return 'false'")
  void testIsLeaf_givenCOSArray_whenMapEntryItemIsCOSArray_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(mapEntry));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); given one; when ArrayEntry (default constructor) Index is one; then return 'false'")
  void testIsLeaf_givenOne_whenArrayEntryIndexIsOne_thenReturnFalse() {
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
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link ArrayEntry} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when ArrayEntry (default constructor); then return 'true'")
  void testIsLeaf_whenArrayEntry_thenReturnTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new ArrayEntry()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when COSDictionary(); then return 'false'")
  void testIsLeaf_whenCOSDictionary_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDictionary()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when COSDocument(); then return 'false'")
  void testIsLeaf_whenCOSDocument_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDocument()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSArray#COSArray()} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when COSObject(COSBase, COSObjectKey) with object is COSArray() and objectKey is COSObjectKey(long, int)")
  void testIsLeaf_whenCOSObjectWithObjectIsCOSArrayAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);

    COSArray object = new COSArray();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new XrefEntry(1, key, 1L, new COSObject(object, new COSObjectKey(1L, 1)))));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link DocumentEntry#DocumentEntry(PDDocument, String)} with doc is
   * {@link PDDocument#PDDocument()} and filename is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when DocumentEntry(PDDocument, String) with doc is PDDocument() and filename is 'foo.txt'")
  void testIsLeaf_whenDocumentEntryWithDocIsPDDocumentAndFilenameIsFooTxt() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new DocumentEntry(new PDDocument(), "foo.txt")));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link MapEntry} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when MapEntry (default constructor); then return 'true'")
  void testIsLeaf_whenMapEntry_thenReturnTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new MapEntry()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@code Node}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when 'Node'; then return 'true'")
  void testIsLeaf_whenNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new PDFTreeModel()).isLeaf("Node"));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link PageEntry#PageEntry(COSDictionary, int, String)} with page is
   * {@link COSDictionary#COSDictionary()} and pageNum is ten and
   * {@code Page Label}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when PageEntry(COSDictionary, int, String) with page is COSDictionary() and pageNum is ten and 'Page Label'")
  void testIsLeaf_whenPageEntryWithPageIsCOSDictionaryAndPageNumIsTenAndPageLabel() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new PageEntry(new COSDictionary(), 10, "Page Label")));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   * <ul>
   *   <li>When {@link XrefEntries#XrefEntries(PDDocument)} with document is
   * {@link PDDocument#PDDocument()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when XrefEntries(PDDocument) with document is PDDocument(); then return 'false'")
  void testIsLeaf_whenXrefEntriesWithDocumentIsPDDocument_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new XrefEntries(new PDDocument())));
  }
}
