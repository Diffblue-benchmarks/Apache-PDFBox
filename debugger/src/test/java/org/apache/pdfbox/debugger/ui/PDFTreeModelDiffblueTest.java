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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.swing.event.TreeModelListener;
import javax.swing.plaf.basic.BasicTreeUI;
import javax.swing.tree.TreePath;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFTreeModelDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFTreeModel.<init>()",
    "void PDFTreeModel.<init>(DocumentEntry)",
    "void PDFTreeModel.<init>(XrefEntries)",
    "void PDFTreeModel.addTreeModelListener(TreeModelListener)",
    "Object PDFTreeModel.getRoot()",
    "void PDFTreeModel.removeTreeModelListener(TreeModelListener)",
    "void PDFTreeModel.valueForPathChanged(TreePath, Object)"
  })
  void testGettersAndSetters() {
    // Arrange
    DocumentEntry docEntry = new DocumentEntry(new PDDocument(), "foo.txt");

    // Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel(docEntry);
    actualPdfTreeModel.addTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    Object[] objectArray = new Object[] {"Path"};
    TreePath path = new TreePath(objectArray);
    actualPdfTreeModel.valueForPathChanged(path, "New Value");

    // Assert
    assertSame(docEntry, actualPdfTreeModel.getRoot());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Root is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFTreeModel.<init>()",
    "void PDFTreeModel.<init>(DocumentEntry)",
    "void PDFTreeModel.<init>(XrefEntries)",
    "void PDFTreeModel.addTreeModelListener(TreeModelListener)",
    "Object PDFTreeModel.getRoot()",
    "void PDFTreeModel.removeTreeModelListener(TreeModelListener)",
    "void PDFTreeModel.valueForPathChanged(TreePath, Object)"
  })
  void testGettersAndSetters_thenReturnRootIsNull() {
    // Arrange and Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel();
    actualPdfTreeModel.addTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    Object[] objectArray = new Object[] {"Path"};
    TreePath path = new TreePath(objectArray);
    actualPdfTreeModel.valueForPathChanged(path, "New Value");

    // Assert
    assertNull(actualPdfTreeModel.getRoot());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then Root return {@link XrefEntries}.
   * </ul>
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDFTreeModel.<init>()",
    "void PDFTreeModel.<init>(DocumentEntry)",
    "void PDFTreeModel.<init>(XrefEntries)",
    "void PDFTreeModel.addTreeModelListener(TreeModelListener)",
    "Object PDFTreeModel.getRoot()",
    "void PDFTreeModel.removeTreeModelListener(TreeModelListener)",
    "void PDFTreeModel.valueForPathChanged(TreePath, Object)"
  })
  void testGettersAndSetters_thenRootReturnXrefEntries() {
    // Arrange
    XrefEntries xrefEntries = new XrefEntries(new PDDocument());

    // Act
    PDFTreeModel actualPdfTreeModel = new PDFTreeModel(xrefEntries);
    actualPdfTreeModel.addTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    actualPdfTreeModel.removeTreeModelListener(new BasicTreeUI().new TreeModelHandler());
    Object[] objectArray = new Object[] {"Path"};
    TreePath path = new TreePath(objectArray);
    actualPdfTreeModel.valueForPathChanged(path, "New Value");
    Object actualRoot = actualPdfTreeModel.getRoot();

    // Assert
    assertTrue(actualRoot instanceof XrefEntries);
    assertSame(xrefEntries, actualRoot);
  }

  /**
   * Test {@link PDFTreeModel#PDFTreeModel(PDDocument)}.
   *
   * <ul>
   *   <li>Then return Root is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#PDFTreeModel(PDDocument)}
   */
  @Test
  @DisplayName("Test new PDFTreeModel(PDDocument); then return Root is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFTreeModel.<init>(PDDocument)"})
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
   *
   * <ul>
   *   <li>Then return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_thenReturnCOSArray() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    Object actualChild = pdfTreeModel.getChild(cosObject, 1);

    // Assert
    assertTrue(actualChild instanceof COSArray);
    assertTrue(((COSArray) actualChild).toList().isEmpty());
    assertSame(object, actualChild);
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   *
   * <ul>
   *   <li>Then return Dict is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return Dict is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_thenReturnDictIsCOSDictionary() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());
    COSDictionary pageDictionary = new COSDictionary();
    doc.addPage(new PDPage(pageDictionary));
    doc.addPage(new PDPage());

    // Act
    Object actualChild = pdfTreeModel.getChild(new DocumentEntry(doc, "foo.txt"), 1);

    // Assert
    assertTrue(actualChild instanceof PageEntry);
    assertSame(pageDictionary, ((PageEntry) actualChild).getDict());
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   *
   * <ul>
   *   <li>Then return Item is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then return Item is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_thenReturnItemIsNull() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    XrefEntry xrefEntry = new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null);

    // Act
    Object actualChild = pdfTreeModel.getChild(xrefEntry, 1);

    // Assert
    assertTrue(actualChild instanceof ArrayEntry);
    assertNull(((ArrayEntry) actualChild).getItem());
    assertNull(((ArrayEntry) actualChild).getValue());
    assertEquals(1, ((ArrayEntry) actualChild).getIndex());
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   *
   * <ul>
   *   <li>Then Value return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); then Value return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_thenValueReturnCOSArray() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    Object actualChild = pdfTreeModel.getChild(xrefEntry, 1);

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
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName(
      "Test getChild(Object, int); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser() throws IOException {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertNull(pdfTreeModel.getChild(cosObject, 1));
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSObjectKey, ICOSParser)} with key is {@link
   *       COSObjectKey#COSObjectKey(long, int)} and parser is {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName(
      "Test getChild(Object, int); when COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_whenCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull_thenReturnNull() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);

    // Act and Assert
    assertNull(pdfTreeModel.getChild(cosObject, 1));
  }

  /**
   * Test {@link PDFTreeModel#getChild(Object, int)}.
   *
   * <ul>
   *   <li>When {@code Parent}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChild(Object, int)}
   */
  @Test
  @DisplayName("Test getChild(Object, int); when 'Parent'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDFTreeModel.getChild(Object, int)"})
  void testGetChild_whenParent_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new PDFTreeModel().getChild("Parent", 1));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    int actualChildCount =
        pdfTreeModel.getChildCount(new PageEntry(new COSDictionary(), 10, "Page Label"));

    // Assert
    assertEquals(0, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    int actualChildCount = pdfTreeModel.getChildCount(xrefEntry);

    // Assert
    assertEquals(1, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link MapEntry} (default constructor) Item is {@link COSArray#COSArray()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); given COSArray(); when MapEntry (default constructor) Item is COSArray(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); given one; when ArrayEntry (default constructor) Index is one; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
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
   *
   * <ul>
   *   <li>Given {@link PDPage#PDPage()}.
   *   <li>When {@link PDDocument#PDDocument()} addPage {@link PDPage#PDPage()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); given PDPage(); when PDDocument() addPage PDPage(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount_givenPDPage_whenPDDocumentAddPagePDPage_thenReturnOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    PDDocument doc = new PDDocument();
    doc.addPage(new PDPage());

    // Act
    int actualChildCount = pdfTreeModel.getChildCount(new DocumentEntry(doc, "foo.txt"));

    // Assert
    assertEquals(1, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); when COSObjectKey(long, int) with num is one and gen is one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount_whenCOSObjectKeyWithNumIsOneAndGenIsOne_thenReturnOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    // Act
    int actualChildCount = pdfTreeModel.getChildCount(cosObject);

    // Assert
    assertEquals(1, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <ul>
   *   <li>When {@link DocumentEntry#DocumentEntry(PDDocument, String)} with doc is {@link
   *       PDDocument#PDDocument()} and filename is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); when DocumentEntry(PDDocument, String) with doc is PDDocument() and filename is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount_whenDocumentEntryWithDocIsPDDocumentAndFilenameIsFooTxt() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    int actualChildCount =
        pdfTreeModel.getChildCount(new DocumentEntry(new PDDocument(), "foo.txt"));

    // Assert
    assertEquals(0, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <ul>
   *   <li>When {@code Parent}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName("Test getChildCount(Object); when 'Parent'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount_whenParent_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDFTreeModel().getChildCount("Parent"));
  }

  /**
   * Test {@link PDFTreeModel#getChildCount(Object)}.
   *
   * <ul>
   *   <li>When {@link XrefEntries#XrefEntries(PDDocument)} with document is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getChildCount(Object)}
   */
  @Test
  @DisplayName(
      "Test getChildCount(Object); when XrefEntries(PDDocument) with document is PDDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getChildCount(Object)"})
  void testGetChildCount_whenXrefEntriesWithDocumentIsPDDocument_thenReturnZero() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    int actualChildCount = pdfTreeModel.getChildCount(new XrefEntries(new PDDocument()));

    // Assert
    assertEquals(0, actualChildCount);
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName("Test getIndexOfChild(Object, Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    PageEntry pageEntry = new PageEntry(new COSDictionary(), 10, "Page Label");

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());
    mapEntry.setKey(mock(COSName.class));

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(pageEntry, mapEntry));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given Boolean is {@code true}.
   *   <li>When {@link ArrayEntry} (default constructor) Value is Boolean is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given Boolean is 'true'; when ArrayEntry (default constructor) Value is Boolean is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenBooleanIsTrue_whenArrayEntryValueIsBooleanIsTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(COSBoolean.getBoolean(true));

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());
    mapEntry.setKey(mock(COSName.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfTreeModel.getIndexOfChild(arrayEntry, mapEntry));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given Boolean is {@code true}.
   *   <li>When {@link MapEntry} (default constructor) Value is Boolean is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given Boolean is 'true'; when MapEntry (default constructor) Value is Boolean is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenBooleanIsTrue_whenMapEntryValueIsBooleanIsTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(COSBoolean.getBoolean(true));

    MapEntry mapEntry2 = new MapEntry();
    mapEntry2.setItem(new COSArray());
    mapEntry2.setValue(new COSArray());
    mapEntry2.setKey(mock(COSName.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> pdfTreeModel.getIndexOfChild(mapEntry, mapEntry2));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given COSArray(); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenCOSArray_whenNull_thenReturnMinusOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(mapEntry, null));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.
   *   <li>When {@link MapEntry} (default constructor) Value is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given COSStream(); when MapEntry (default constructor) Value is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenCOSStream_whenMapEntryValueIsCOSStream() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSStream());

    MapEntry mapEntry2 = new MapEntry();
    mapEntry2.setItem(new COSArray());
    mapEntry2.setValue(new COSArray());
    mapEntry2.setKey(mock(COSName.class));

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(mapEntry, mapEntry2));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MapEntry} (default constructor) Value is {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given 'null'; when MapEntry (default constructor) Value is 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenNull_whenMapEntryValueIsNull_thenReturnMinusOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(null);

    MapEntry mapEntry2 = new MapEntry();
    mapEntry2.setItem(new COSArray());
    mapEntry2.setValue(new COSArray());
    mapEntry2.setKey(mock(COSName.class));

    // Act and Assert
    assertEquals(-1, pdfTreeModel.getIndexOfChild(mapEntry, mapEntry2));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayEntry} (default constructor) Value is {@link COSArray#COSArray()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given one; when ArrayEntry (default constructor) Value is COSArray(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenOne_whenArrayEntryValueIsCOSArray_thenReturnOne() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    MapEntry mapEntry = new MapEntry();
    mapEntry.setItem(new COSArray());
    mapEntry.setValue(new COSArray());

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    // Act and Assert
    assertEquals(1, pdfTreeModel.getIndexOfChild(mapEntry, arrayEntry));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayEntry} (default constructor) Value is {@link COSArray#COSArray()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); given one; when ArrayEntry (default constructor) Value is COSArray(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_givenOne_whenArrayEntryValueIsCOSArray_thenReturnOne2() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    ArrayEntry arrayEntry = new ArrayEntry();
    arrayEntry.setIndex(1);
    arrayEntry.setItem(new COSArray());
    arrayEntry.setValue(new COSArray());

    ArrayEntry arrayEntry2 = new ArrayEntry();
    arrayEntry2.setIndex(1);
    arrayEntry2.setItem(new COSArray());
    arrayEntry2.setValue(new COSArray());

    // Act and Assert
    assertEquals(1, pdfTreeModel.getIndexOfChild(arrayEntry, arrayEntry2));
  }

  /**
   * Test {@link PDFTreeModel#getIndexOfChild(Object, Object)}.
   *
   * <ul>
   *   <li>When {@code Parent}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#getIndexOfChild(Object, Object)}
   */
  @Test
  @DisplayName(
      "Test getIndexOfChild(Object, Object); when 'Parent'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDFTreeModel.getIndexOfChild(Object, Object)"})
  void testGetIndexOfChild_whenParent_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new PDFTreeModel().getIndexOfChild("Parent", "Child"));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    XrefEntry xrefEntry = new XrefEntry(1, new COSObjectKey(1L, 1), 1L, null);

    // Act
    boolean actualIsLeafResult = pdfTreeModel.isLeaf(xrefEntry);

    // Assert
    assertTrue(actualIsLeafResult);
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link MapEntry} (default constructor) Item is {@link COSArray#COSArray()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); given COSArray(); when MapEntry (default constructor) Item is COSArray(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
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
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayEntry} (default constructor) Index is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); given one; when ArrayEntry (default constructor) Index is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
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
   *
   * <ul>
   *   <li>When {@link ArrayEntry} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when ArrayEntry (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenArrayEntry_thenReturnTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new ArrayEntry()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when COSDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenCOSDictionary_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDictionary()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when COSDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenCOSDocument_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertFalse(pdfTreeModel.isLeaf(new COSDocument()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSArray#COSArray()} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); when COSObject(COSBase, COSObjectKey) with object is COSArray() and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenCOSObjectWithObjectIsCOSArrayAndObjectKeyIsCOSObjectKey() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSArray object = new COSArray();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));

    XrefEntry xrefEntry = new XrefEntry(1, key, 1L, cosObject);

    // Act
    boolean actualIsLeafResult = pdfTreeModel.isLeaf(xrefEntry);

    // Assert
    assertFalse(actualIsLeafResult);
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link DocumentEntry#DocumentEntry(PDDocument, String)} with doc is {@link
   *       PDDocument#PDDocument()} and filename is {@code foo.txt}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); when DocumentEntry(PDDocument, String) with doc is PDDocument() and filename is 'foo.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenDocumentEntryWithDocIsPDDocumentAndFilenameIsFooTxt() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    boolean actualIsLeafResult =
        pdfTreeModel.isLeaf(new DocumentEntry(new PDDocument(), "foo.txt"));

    // Assert
    assertFalse(actualIsLeafResult);
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link MapEntry} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when MapEntry (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenMapEntry_thenReturnTrue() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act and Assert
    assertTrue(pdfTreeModel.isLeaf(new MapEntry()));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@code Node}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName("Test isLeaf(Object); when 'Node'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenNode_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PDFTreeModel().isLeaf("Node"));
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link PageEntry#PageEntry(COSDictionary, int, String)} with page is {@link
   *       COSDictionary#COSDictionary()} and pageNum is ten and {@code Page Label}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); when PageEntry(COSDictionary, int, String) with page is COSDictionary() and pageNum is ten and 'Page Label'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenPageEntryWithPageIsCOSDictionaryAndPageNumIsTenAndPageLabel() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    boolean actualIsLeafResult =
        pdfTreeModel.isLeaf(new PageEntry(new COSDictionary(), 10, "Page Label"));

    // Assert
    assertFalse(actualIsLeafResult);
  }

  /**
   * Test {@link PDFTreeModel#isLeaf(Object)}.
   *
   * <ul>
   *   <li>When {@link XrefEntries#XrefEntries(PDDocument)} with document is {@link
   *       PDDocument#PDDocument()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDFTreeModel#isLeaf(Object)}
   */
  @Test
  @DisplayName(
      "Test isLeaf(Object); when XrefEntries(PDDocument) with document is PDDocument(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDFTreeModel.isLeaf(Object)"})
  void testIsLeaf_whenXrefEntriesWithDocumentIsPDDocument_thenReturnFalse() {
    // Arrange
    PDFTreeModel pdfTreeModel = new PDFTreeModel();

    // Act
    boolean actualIsLeafResult = pdfTreeModel.isLeaf(new XrefEntries(new PDDocument()));

    // Assert
    assertFalse(actualIsLeafResult);
  }
}
