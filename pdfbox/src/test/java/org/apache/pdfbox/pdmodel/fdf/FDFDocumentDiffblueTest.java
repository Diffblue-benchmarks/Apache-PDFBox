package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFDocumentDiffblueTest {
  /**
   * Test {@link FDFDocument#FDFDocument()}.
   *
   * <p>Method under test: {@link FDFDocument#FDFDocument()}
   */
  @Test
  @DisplayName("Test new FDFDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.<init>()"})
  void testNewFDFDocument() {
    // Arrange and Act
    FDFDocument actualFdfDocument = new FDFDocument();

    // Assert
    FDFCatalog catalog = actualFdfDocument.getCatalog();
    assertNull(catalog.getVersion());
    COSDocument document = actualFdfDocument.getDocument();
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(document.getLinearizedDictionary());
    assertNull(document.getKey());
    assertNull(catalog.getSignature());
    assertEquals(0L, document.getHighestXRefObjectNumber());
    assertEquals(0L, document.getStartXref());
    assertEquals(1.2f, document.getVersion());
    assertFalse(document.isDirect());
    assertFalse(document.hasHybridXRef());
    assertFalse(document.isClosed());
    assertFalse(document.isDecrypted());
    assertFalse(document.isEncrypted());
    assertFalse(document.isXRefStream());
    assertTrue(document.getXrefTable().isEmpty());
  }

  /**
   * Test {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}.
   *
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.
   *   <li>Then return Document is {@link COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#FDFDocument(COSDocument, RandomAccessRead)}
   */
  @Test
  @DisplayName(
      "Test new FDFDocument(COSDocument, RandomAccessRead); when COSDocument(); then return Document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.<init>(COSDocument, RandomAccessRead)"})
  void testNewFDFDocument_whenCOSDocument_thenReturnDocumentIsCOSDocument() {
    // Arrange
    COSDocument doc = new COSDocument();

    // Act
    FDFDocument actualFdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Assert
    assertSame(doc, actualFdfDocument.getDocument());
  }

  /**
   * Test {@link FDFDocument#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  @DisplayName("Test writeXML(Writer); given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.writeXML(Writer)"})
  void testWriteXML_givenCOSDocumentTrailerIsCOSDictionary() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.writeXML(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#writeXML(Writer)}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>When {@link StringWriter#StringWriter()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#writeXML(Writer)}
   */
  @Test
  @DisplayName(
      "Test writeXML(Writer); given FDFDocument(); when StringWriter(); then StringWriter() toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.writeXML(Writer)"})
  void testWriteXML_givenFDFDocument_whenStringWriter_thenStringWriterToStringIsAString()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.writeXML(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSDictionary#setItem(COSName, COSObjectable)}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName(
      "Test getCatalog(); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls setItem(COSName, COSObjectable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFCatalog FDFDocument.getCatalog()"})
  void testGetCatalog_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsSetItem() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    FDFCatalog actualCatalog = fdfDocument.getCatalog();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    verify(doc).getDocumentState();
    verify(doc, atLeast(1)).getTrailer();
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   *
   * <ul>
   *   <li>Given {@link COSDocument} {@link COSDocument#getTrailer()} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); given COSDocument getTrailer() return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFCatalog FDFDocument.getCatalog()"})
  void testGetCatalog_givenCOSDocumentGetTrailerReturnCOSDictionary() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    FDFCatalog actualCatalog = fdfDocument.getCatalog();

    // Assert
    verify(doc).getDocumentState();
    verify(doc, atLeast(1)).getTrailer();
    COSDictionary cOSObject = actualCatalog.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSDictionary cOSObject2 = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState2 = cOSObject2.getUpdateState();
    assertNull(updateState2.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    COSIncrement toIncrementResult2 = cOSObject2.toIncrement();
    assertFalse(toIncrementResult2.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(cOSObject2.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(updateState2.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(toIncrementResult2.getObjects().isEmpty());
  }

  /**
   * Test {@link FDFDocument#getCatalog()}.
   *
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#getCatalog()}
   */
  @Test
  @DisplayName("Test getCatalog(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"FDFCatalog FDFDocument.getCatalog()"})
  void testGetCatalog_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    COSDictionary cosDictionary2 = new COSDictionary();
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary2);

    COSDocument doc = mock(COSDocument.class);
    when(doc.getTrailer()).thenReturn(cosDictionary);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    FDFCatalog actualCatalog = fdfDocument.getCatalog();

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(doc).getDocumentState();
    verify(doc).getTrailer();
    COSDictionary cOSObject = actualCatalog.getFDF().getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(cosDictionary2, actualCatalog.getCOSObject());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    COSArray id = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    id.add((COSBase) object);

    FDFDictionary fdf = new FDFDictionary();
    fdf.setID(id);

    FDFCatalog cat = new FDFCatalog();
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    List<? extends COSBase> toListResult = cat.getFDF().getID().toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    assertTrue(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).getUpdateState().isUpdated());
    assertSame(id, fdfDocument.getCatalog().getFDF().getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog); given COSArray() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_givenCOSArrayAddCOSArray() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();

    COSArray id = new COSArray();
    id.add((COSBase) new COSArray());
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName("Test setCatalog(FDFCatalog); given COSArray() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_givenCOSArrayAddFalse() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();

    COSArray id = new COSArray();
    id.add(COSBoolean.FALSE);
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName(
      "Test setCatalog(FDFCatalog); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    COSArray id = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    id.add((COSBase) object);

    FDFDictionary fdf = new FDFDictionary();
    fdf.setID(id);

    FDFCatalog cat = new FDFCatalog();
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    List<? extends COSBase> toListResult = cat.getFDF().getID().toList();
    assertEquals(1, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSObject);
    assertTrue(((COSObject) getResult).isNeedToBeUpdated());
    assertTrue(((COSObject) getResult).getUpdateState().isUpdated());
    assertSame(id, fdfDocument.getCatalog().getFDF().getID());
  }

  /**
   * Test {@link FDFDocument#setCatalog(FDFCatalog)}.
   *
   * <ul>
   *   <li>Then {@link FDFCatalog#FDFCatalog()} COSObject toIncrement Objects size is two.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#setCatalog(FDFCatalog)}
   */
  @Test
  @DisplayName(
      "Test setCatalog(FDFCatalog); then FDFCatalog() COSObject toIncrement Objects size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.setCatalog(FDFCatalog)"})
  void testSetCatalog_thenFDFCatalogCOSObjectToIncrementObjectsSizeIsTwo() {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    FDFCatalog cat = new FDFCatalog();

    FDFDictionary fdf = new FDFDictionary();
    COSArray id = new COSArray();
    fdf.setID(id);
    cat.setFDF(fdf);

    // Act
    fdfDocument.setCatalog(cat);

    // Assert
    COSDictionary cOSObject = cat.getCOSObject();
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertEquals(2, toIncrementResult.getObjects().size());
    Iterator<COSBase> iteratorResult = toIncrementResult.iterator();
    COSBase actualNextResult = iteratorResult.next();
    COSBase actualNextResult2 = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(cOSObject, actualNextResult);
    COSDictionary cOSObject2 = cat.getFDF().getCOSObject();
    assertEquals(1, cOSObject2.toIncrement().getObjects().size());
    assertSame(cOSObject2, actualNextResult2);
    FDFCatalog catalog = fdfDocument.getCatalog();
    assertSame(cOSObject, catalog.getCOSObject());
    FDFDictionary fDF = catalog.getFDF();
    assertSame(cOSObject2, fDF.getCOSObject());
    assertSame(id, fDF.getID());
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(115, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream2() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 0L));
    doc.setTrailer(newTrailer);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(115, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream3() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(0L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));

    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(158, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then array length is one hundred eighteen.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given 'A'; then array length is one hundred eighteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenA_thenArrayLengthIsOneHundredEighteen() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 3, 'A', 3, 'A', 3, 'A', 3});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream newTrailer =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(118, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} IsXRefStream is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given COSDocument() IsXRefStream is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenCOSDocumentIsXRefStreamIsTrue() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(158, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenCOSDocumentTrailerIsCOSDictionary() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(158, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given COSDocument() Trailer is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenCOSDocumentTrailerIsCOSStream() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSStream());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(115, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given COSDocument() Trailer is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenCOSDocumentTrailerIsCOSStream2() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSStream());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(158, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSDocument doc = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream newTrailer =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));
    doc.setTrailer(newTrailer);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(115, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then array length is one hundred thirty-eight.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given FDFDocument(); then array length is one hundred thirty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenFDFDocument_thenArrayLengthIsOneHundredThirtyEight()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(138, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName(
      "Test save(OutputStream) with 'OutputStream'; given StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_givenStreamCacheCreateFunctionCreateReturnNull()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);

    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    doc.setIsXRefStream(true);
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(158, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#save(OutputStream)} with {@code OutputStream}.
   *
   * <ul>
   *   <li>Then array length is eighty-five.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#save(OutputStream)}
   */
  @Test
  @DisplayName("Test save(OutputStream) with 'OutputStream'; then array length is eighty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.save(OutputStream)"})
  void testSaveWithOutputStream_thenArrayLengthIsEightyFive() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    // Act
    fdfDocument.save(output);

    // Assert
    assertEquals(85, output.toByteArray().length);
  }

  /**
   * Test {@link FDFDocument#saveXFDF(Writer)} with {@code Writer}.
   *
   * <ul>
   *   <li>Given {@link COSDocument#COSDocument()} Trailer is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  @DisplayName(
      "Test saveXFDF(Writer) with 'Writer'; given COSDocument() Trailer is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.saveXFDF(Writer)"})
  void testSaveXFDFWithWriter_givenCOSDocumentTrailerIsCOSDictionary() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    doc.setTrailer(new COSDictionary());
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.saveXFDF(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#saveXFDF(Writer)} with {@code Writer}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then {@link StringWriter#StringWriter()} toString is a string.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#saveXFDF(Writer)}
   */
  @Test
  @DisplayName(
      "Test saveXFDF(Writer) with 'Writer'; given FDFDocument(); then StringWriter() toString is a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.saveXFDF(Writer)"})
  void testSaveXFDFWithWriter_givenFDFDocument_thenStringWriterToStringIsAString()
      throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();
    StringWriter output = new StringWriter();

    // Act
    fdfDocument.saveXFDF(output);

    // Assert
    assertEquals(
        "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<xfdf xmlns=\"http://ns.adobe.com/xfdf/\" xml:space=\"preserve\">\n"
            + "</xfdf>\n",
        output.toString());
  }

  /**
   * Test {@link FDFDocument#close()}.
   *
   * <p>Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.close()"})
  void testClose() throws IOException {
    // Arrange
    COSDocument doc = new COSDocument();
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }

  /**
   * Test {@link FDFDocument#close()}.
   *
   * <p>Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.close()"})
  void testClose2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    FDFDocument fdfDocument = new FDFDocument(doc, new RandomAccessReadWriteBuffer());

    // Act
    fdfDocument.close();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(fdfDocument.getDocument().isClosed());
  }

  /**
   * Test {@link FDFDocument#close()}.
   *
   * <ul>
   *   <li>Given {@link FDFDocument#FDFDocument()}.
   *   <li>Then {@link FDFDocument#FDFDocument()} Document Closed.
   * </ul>
   *
   * <p>Method under test: {@link FDFDocument#close()}
   */
  @Test
  @DisplayName("Test close(); given FDFDocument(); then FDFDocument() Document Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FDFDocument.close()"})
  void testClose_givenFDFDocument_thenFDFDocumentDocumentClosed() throws IOException {
    // Arrange
    FDFDocument fdfDocument = new FDFDocument();

    // Act
    fdfDocument.close();

    // Assert
    assertTrue(fdfDocument.getDocument().isClosed());
  }
}
