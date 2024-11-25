package org.apache.pdfbox.pdfwriter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSWriterDiffblueTest {
  /**
   * Test {@link COSWriter#COSWriter(OutputStream)}.
   * <p>
   * Method under test: {@link COSWriter#COSWriter(OutputStream)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream)")
  void testNewCOSWriter() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertFalse(actualCosWriter.isCompress());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertSame(outputStream, actualCosWriter.getOutput());
  }

  /**
   * Test {@link COSWriter#COSWriter(OutputStream, CompressParameters)}.
   * <p>
   * Method under test:
   * {@link COSWriter#COSWriter(OutputStream, CompressParameters)}
   */
  @Test
  @DisplayName("Test new COSWriter(OutputStream, CompressParameters)")
  void testNewCOSWriter2() {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act
    COSWriter actualCosWriter = new COSWriter(outputStream, CompressParameters.DEFAULT_COMPRESSION);

    // Assert
    COSStandardOutputStream standardOutput = actualCosWriter.getStandardOutput();
    assertEquals(0L, standardOutput.getPos());
    assertEquals(0L, actualCosWriter.getStartxref());
    assertFalse(standardOutput.isOnNewLine());
    assertTrue(actualCosWriter.getXRefEntries().isEmpty());
    assertTrue(actualCosWriter.isCompress());
    assertSame(outputStream, actualCosWriter.getOutput());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return 'false'")
  void testIsCompress_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnFalse() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act and Assert
    assertFalse((new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).isCompress());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   * <ul>
   *   <li>Given {@link COSWriter#COSWriter(OutputStream)} with outputStream is
   * {@link ByteArrayOutputStream#ByteArrayOutputStream(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); given COSWriter(OutputStream) with outputStream is ByteArrayOutputStream(int)")
  void testIsCompress_givenCOSWriterWithOutputStreamIsByteArrayOutputStream() {
    // Arrange, Act and Assert
    assertFalse((new COSWriter(new ByteArrayOutputStream(1))).isCompress());
  }

  /**
   * Test {@link COSWriter#isCompress()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); then return 'true'")
  void testIsCompress_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new COSWriter(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION)).isCompress());
  }

  /**
   * Test {@link COSWriter#addXRefEntry(XReferenceEntry)}.
   * <p>
   * Method under test: {@link COSWriter#addXRefEntry(XReferenceEntry)}
   */
  @Test
  @DisplayName("Test addXRefEntry(XReferenceEntry)")
  void testAddXRefEntry() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));
    FreeXReference entry = FreeXReference.NULL_ENTRY;

    // Act
    cosWriter.addXRefEntry(entry);

    // Assert
    List<XReferenceEntry> xRefEntries = cosWriter.getXRefEntries();
    assertEquals(1, xRefEntries.size());
    assertSame(entry.NULL_ENTRY, xRefEntries.get(0));
  }

  /**
   * Test {@link COSWriter#getDataToSign()}.
   * <p>
   * Method under test: {@link COSWriter#getDataToSign()}
   */
  @Test
  @DisplayName("Test getDataToSign()")
  void testGetDataToSign() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new COSWriter(new ByteArrayOutputStream(1))).getDataToSign());
  }

  /**
   * Test {@link COSWriter#writeExternalSignature(byte[])}.
   * <p>
   * Method under test: {@link COSWriter#writeExternalSignature(byte[])}
   */
  @Test
  @DisplayName("Test writeExternalSignature(byte[])")
  void testWriteExternalSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.writeExternalSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   * <ul>
   *   <li>Given {@link FreeXReference#NULL_ENTRY}.</li>
   *   <li>Then return array of {@link Long} with zero and one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName("Test getXRefRanges(List); given NULL_ENTRY; then return array of Long with zero and one")
  void testGetXRefRanges_givenNull_entry_thenReturnArrayOfLongWithZeroAndOne() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    ArrayList<XReferenceEntry> xRefEntriesList = new ArrayList<>();
    xRefEntriesList.add(FreeXReference.NULL_ENTRY);

    // Act and Assert
    assertArrayEquals(new Long[]{0L, 1L}, cosWriter.getXRefRanges(xRefEntriesList));
  }

  /**
   * Test {@link COSWriter#getXRefRanges(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  @DisplayName("Test getXRefRanges(List); when ArrayList(); then return array length is zero")
  void testGetXRefRanges_whenArrayList_thenReturnArrayLengthIsZero() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertEquals(0, cosWriter.getXRefRanges(new ArrayList<>()).length);
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  void testWriteWithCOSDocument() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any()))
        .thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  void testWriteWithCOSDocument2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any()))
        .thenReturn(new COSObject(COSBoolean.TRUE, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  void testWriteWithCOSDocument3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));

    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  void testWriteWithCOSDocument4() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(new COSObject(null, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'")
  void testWriteWithCOSDocument5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    COSString object = COSString.parseHex("0123456789ABCDEF");
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSObject#getObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given COSObject getObject() return FALSE; then calls getObject()")
  void testWriteWithCOSDocument_givenCOSObjectGetObjectReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(cosObject);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSName#A} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given COSObject(COSBase, COSObjectKey) with object is A and objectKey is COSObjectKey(long, int)")
  void testWriteWithCOSDocument_givenCOSObjectWithObjectIsAAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any()))
        .thenReturn(new COSObject(COSName.A, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is
   * {@link COSFloat#ONE} and objectKey is
   * {@link COSObjectKey#COSObjectKey(long, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given COSObject(COSBase, COSObjectKey) with object is ONE and objectKey is COSObjectKey(long, int)")
  void testWriteWithCOSDocument_givenCOSObjectWithObjectIsOneAndObjectKeyIsCOSObjectKey() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any()))
        .thenReturn(new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link COSStream#COSStream()}.</li>
   *   <li>When {@link COSDocument} {@link COSDocument#getTrailer()} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given COSStream(); when COSDocument getTrailer() return COSStream()")
  void testWriteWithCOSDocument_givenCOSStream_whenCOSDocumentGetTrailerReturnCOSStream() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(cosObject);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(cosDictionary);
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSStream());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(cosDictionary).getNameAsString(isA(COSName.class));
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link COSString#COSString(String, boolean)} with text is
   * {@code MD5} and forceHex is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given COSString(String, boolean) with text is 'MD5' and forceHex is 'true'")
  void testWriteWithCOSDocument_givenCOSStringWithTextIsMd5AndForceHexIsTrue() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSDocument doc = mock(COSDocument.class);
    COSString object = new COSString("MD5", true);

    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(new COSObject(object, new COSObjectKey(1L, 1)));
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given HashMap()")
  void testWriteWithCOSDocument_givenHashMap() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getXrefTable()).thenReturn(new HashMap<>());
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code null} is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; given HashMap() 'null' is one")
  void testWriteWithCOSDocument_givenHashMapNullIsOne() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(null, 1L);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSDictionary());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSDictionary(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; then calls getCOSDictionary(COSName)")
  void testWriteWithCOSDocument_thenCallsGetCOSDictionary() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(cosDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    when(cosDictionary.toIncrement()).thenReturn(new COSIncrement(new COSArray()));
    COSDictionary cosDictionary2 = mock(COSDictionary.class);
    when(cosDictionary2.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(cosObject);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(cosDictionary2);
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(cosDictionary);
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(cosDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary2).getNameAsString(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
    verify(cosObject).getObject();
    verify(cosDictionary).toIncrement();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Then calls {@link COSDictionary#getNameAsString(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; then calls getNameAsString(COSName)")
  void testWriteWithCOSDocument_thenCallsGetNameAsString() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(cosObject);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(cosDictionary);
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(cosDictionary).getNameAsString(isA(COSName.class));
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; then throw IllegalStateException")
  void testWriteWithCOSDocument_thenThrowIllegalStateException() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getEncryptionDictionary()).thenThrow(new IllegalStateException("Standard"));
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.write(doc));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getTrailer();
    verify(doc).isEncrypted();
  }

  /**
   * Test {@link COSWriter#write(COSDocument)} with {@code COSDocument}.
   * <ul>
   *   <li>When {@link COSDocument} {@link COSDocument#getEncryptionDictionary()}
   * return {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  @DisplayName("Test write(COSDocument) with 'COSDocument'; when COSDocument getEncryptionDictionary() return COSStream()")
  void testWriteWithCOSDocument_whenCOSDocumentGetEncryptionDictionaryReturnCOSStream() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(3);
    COSWriter cosWriter = new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 3, 'A', 3, 'A', 3, 'A', 3})));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);

    HashMap<COSObjectKey, Long> cosObjectKeyResultLongMap = new HashMap<>();
    cosObjectKeyResultLongMap.put(new COSObjectKey(1L, 1), 1L);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getObjectFromPool(Mockito.<COSObjectKey>any())).thenReturn(cosObject);
    when(doc.getXrefTable()).thenReturn(cosObjectKeyResultLongMap);
    doNothing().when(doc).accept(Mockito.<ICOSVisitor>any());
    when(doc.getEncryptionDictionary()).thenReturn(new COSStream());
    when(doc.isEncrypted()).thenReturn(true);
    when(doc.getHighestXRefObjectNumber()).thenReturn(1L);
    when(doc.getTrailer()).thenReturn(new COSDictionary());
    when(doc.getDocumentState()).thenReturn(cosDocumentState);

    // Act
    cosWriter.write(doc);

    // Assert
    verify(doc).accept(isA(ICOSVisitor.class));
    verify(doc).getDocumentState();
    verify(doc).getEncryptionDictionary();
    verify(doc).getHighestXRefObjectNumber();
    verify(doc).getObjectFromPool(isA(COSObjectKey.class));
    verify(doc).getTrailer();
    verify(doc).getXrefTable();
    verify(doc).isEncrypted();
    verify(cosObject).getObject();
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes},
   * {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  void testWriteStringWithBytesOutput() throws IOException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "(AXAXAXAX)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes},
   * {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  void testWriteStringWithBytesOutput2() throws IOException {
    // Arrange
    byte[] bytes = "\rXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<0D58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes},
   * {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  void testWriteStringWithBytesOutput3() throws IOException {
    // Arrange
    byte[] bytes = "\nXAXAXAX".getBytes("UTF-8");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(bytes, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<0A58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(byte[], OutputStream)} with {@code bytes},
   * {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(byte[], OutputStream) with 'bytes', 'output'")
  void testWriteStringWithBytesOutput4() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<FF58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with
   * {@code string}, {@code output}.
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'")
  void testWriteStringWithStringOutput() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("42");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "(B)".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with
   * {@code string}, {@code output}.
   * <ul>
   *   <li>Then array length is eighteen.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'; then array length is eighteen")
  void testWriteStringWithStringOutput_thenArrayLengthIsEighteen() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert that nothing has changed
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(18, toByteArrayResult.length);
    assertEquals('0', toByteArrayResult[1]);
    assertEquals('1', toByteArrayResult[2]);
    assertEquals('2', toByteArrayResult[3]);
    assertEquals('3', toByteArrayResult[4]);
    assertEquals('4', toByteArrayResult[5]);
    assertEquals('5', toByteArrayResult[6]);
    assertEquals('6', toByteArrayResult[7]);
    assertEquals('7', toByteArrayResult[8]);
    assertEquals('8', toByteArrayResult[9]);
    assertEquals('9', toByteArrayResult[10]);
    assertEquals('>', toByteArrayResult[17]);
    assertEquals('A', toByteArrayResult[11]);
    assertEquals('B', toByteArrayResult[12]);
    assertEquals('C', toByteArrayResult[13]);
    assertEquals('D', toByteArrayResult[14]);
    assertEquals('E', toByteArrayResult[15]);
    assertEquals('F', toByteArrayResult[Short.SIZE]);
  }

  /**
   * Test {@link COSWriter#writeString(COSString, OutputStream)} with
   * {@code string}, {@code output}.
   * <ul>
   *   <li>Then array length is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  @DisplayName("Test writeString(COSString, OutputStream) with 'string', 'output'; then array length is ten")
  void testWriteStringWithStringOutput_thenArrayLengthIsTen() throws IOException {
    // Arrange
    COSString string = new COSString("Text", true);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert that nothing has changed
    byte[] toByteArrayResult = output.toByteArray();
    assertEquals(10, toByteArrayResult.length);
    assertEquals('4', toByteArrayResult[2]);
    assertEquals('4', toByteArrayResult[8]);
    assertEquals('5', toByteArrayResult[1]);
    assertEquals('5', toByteArrayResult[4]);
    assertEquals('6', toByteArrayResult[3]);
    assertEquals('7', toByteArrayResult[5]);
    assertEquals('7', toByteArrayResult[7]);
    assertEquals('8', toByteArrayResult[6]);
    assertEquals('>', toByteArrayResult[9]);
  }
}
