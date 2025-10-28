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
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSNull;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.ICOSVisitor;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdfparser.xref.FreeXReference;
import org.apache.pdfbox.pdfparser.xref.XReferenceEntry;
import org.apache.pdfbox.pdfwriter.compress.CompressParameters;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class COSWriterDiffblueTest {
  /**
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  void testIsCompress() {
    // Arrange, Act and Assert
    assertFalse((new COSWriter(new ByteArrayOutputStream(1))).isCompress());
    assertTrue((new COSWriter(new ByteArrayOutputStream(1), CompressParameters.DEFAULT_COMPRESSION)).isCompress());
  }

  /**
   * Method under test: {@link COSWriter#isCompress()}
   */
  @Test
  void testIsCompress2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    // Act and Assert
    assertFalse((new COSWriter(outputStream,
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))).isCompress());
  }

  /**
   * Method under test: {@link COSWriter#addXRefEntry(XReferenceEntry)}
   */
  @Test
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
   * Method under test: {@link COSWriter#doWriteBody(COSDocument)}
   */
  @Test
  void testDoWriteBody() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    COSDocument doc = new COSDocument(streamCacheCreateFunction);
    doc.setTrailer(new COSDictionary());

    // Act
    cosWriter.doWriteBody(doc);

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link COSWriter#getDataToSign()}
   */
  @Test
  void testGetDataToSign() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new COSWriter(new ByteArrayOutputStream(1))).getDataToSign());
  }

  /**
   * Method under test: {@link COSWriter#writeExternalSignature(byte[])}
   */
  @Test
  void testWriteExternalSignature() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> cosWriter.writeExternalSignature("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  void testGetXRefRanges() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    // Act and Assert
    assertEquals(0, cosWriter.getXRefRanges(new ArrayList<>()).length);
  }

  /**
   * Method under test: {@link COSWriter#getXRefRanges(List)}
   */
  @Test
  void testGetXRefRanges2() {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    ArrayList<XReferenceEntry> xRefEntriesList = new ArrayList<>();
    xRefEntriesList.add(FreeXReference.NULL_ENTRY);

    // Act and Assert
    assertArrayEquals(new Long[]{0L, 1L}, cosWriter.getXRefRanges(xRefEntriesList));
  }

  /**
   * Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  void testVisitFromArray() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromArray(new COSArray());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(3L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  void testVisitFromArray2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(8L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  void testVisitFromArray3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(COSBoolean.FALSE);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(14L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  void testVisitFromArray4() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    verify(object).getCOSObject();
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(14L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromArray(COSArray)}
   */
  @Test
  void testVisitFromArray5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object2 = mock(COSObjectable.class);
    when(object2.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object3 = mock(COSObjectable.class);
    when(object3.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object4 = mock(COSObjectable.class);
    when(object4.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object5 = mock(COSObjectable.class);
    when(object5.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object6 = mock(COSObjectable.class);
    when(object6.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object7 = mock(COSObjectable.class);
    when(object7.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object8 = mock(COSObjectable.class);
    when(object8.getCOSObject()).thenReturn(COSBoolean.FALSE);
    COSObjectable object9 = mock(COSObjectable.class);
    when(object9.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);
    array.add(object9);
    array.add(object8);
    array.add(object7);
    array.add(object6);
    array.add(object5);
    array.add(object4);
    array.add(object3);
    array.add(object2);
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    cosWriter.visitFromArray(array);

    // Assert
    verify(object9).getCOSObject();
    verify(object8).getCOSObject();
    verify(object7).getCOSObject();
    verify(object6).getCOSObject();
    verify(object5).getCOSObject();
    verify(object4).getCOSObject();
    verify(object3).getCOSObject();
    verify(object2).getCOSObject();
    verify(object).getCOSObject();
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(68L, standardOutput.getPos());
    assertTrue(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromBoolean(COSBoolean)}
   */
  @Test
  void testVisitFromBoolean() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromBoolean(COSBoolean.FALSE);

    // Assert
    assertEquals(5L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromBoolean(COSBoolean)}
   */
  @Test
  void testVisitFromBoolean2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromBoolean(COSBoolean.TRUE);

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  void testVisitFromFloat() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromFloat(COSFloat.ONE);

    // Assert
    assertEquals(3L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromFloat(COSFloat)}
   */
  @Test
  void testVisitFromFloat2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromFloat(new COSFloat(10.0f));

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  void testVisitFromName() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromName(COSName.A);

    // Assert
    assertEquals(2L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  void testVisitFromName2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromName(COSName.ABSOLUTE_COLORIMETRIC);

    // Assert
    assertEquals(21L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  void testVisitFromName3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromName(COSName.ADBE_PKCS7_DETACHED);

    // Assert
    assertEquals(20L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  void testVisitFromName4() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromName(COSName.ADBE_X509_RSA_SHA1);

    // Assert
    assertEquals(19L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromName(COSName)}
   */
  @Test
  void testVisitFromName5() throws IOException {
    // Arrange
    COSStandardOutputStream outputStream = new COSStandardOutputStream(new ByteArrayOutputStream(47), 47L);

    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromName(COSName.A);

    // Assert
    OutputStream output = cosWriter.getOutput();
    assertTrue(output instanceof COSStandardOutputStream);
    assertEquals(2L, cosWriter.getStandardOutput().getPos());
    assertEquals(49L, ((COSStandardOutputStream) output).getPos());
    assertSame(outputStream, output);
  }

  /**
   * Method under test: {@link COSWriter#visitFromNull(COSNull)}
   */
  @Test
  void testVisitFromNull() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromNull(COSNull.NULL);

    // Assert
    assertEquals(4L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(COSBoolean.FALSE);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(COSBoolean.TRUE);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(COSFloat.ONE);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference4() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(COSInteger.ONE);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference5() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(COSName.A);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference6() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSObjectKey(1237L, 1237));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSBase object = obj.getObject();
    assertTrue(object instanceof COSBoolean);
    COSObjectKey key = obj.getKey();
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
    assertSame(key, object.getKey());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference7() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', -43, 'A', -43, 'A', -43, 'A', -43}))));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    COSBase object = obj.getObject();
    assertTrue(object instanceof COSBoolean);
    COSObjectKey key = obj.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
    assertSame(key, object.getKey());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference8() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(new COSArray());

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference9() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);

    COSWriter cosWriter = new COSWriter(outputStream);
    cosWriter.doWriteObject(COSBoolean.FALSE);

    // Act
    cosWriter.writeReference(COSBoolean.FALSE);

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(26L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference10() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.writeReference(new COSObject(null, new COSObjectKey(1237L, 1237)));

    // Assert
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(11L, standardOutput.getPos());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#writeReference(COSBase)}
   */
  @Test
  void testWriteReference11() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}));
    COSObject obj = new COSObject(COSBoolean.FALSE, new COSParser(source, "iloveyou",
        new ByteArrayInputStream(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1}), "Key Alias", streamCacheCreateFunction));

    // Act
    cosWriter.writeReference(obj);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSBase object = obj.getObject();
    assertTrue(object instanceof COSBoolean);
    COSObjectKey key = obj.getKey();
    assertEquals(-1, key.getStreamIndex());
    assertEquals(0, key.getGeneration());
    assertEquals(1L, key.getNumber());
    COSStandardOutputStream standardOutput = cosWriter.getStandardOutput();
    assertEquals(5L, standardOutput.getPos());
    assertEquals(65536L, key.getInternalHash());
    assertFalse(standardOutput.isOnNewLine());
    assertSame(outputStream, cosWriter.getOutput());
    assertSame(key, object.getKey());
  }

  /**
   * Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  void testVisitFromString() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromString(COSString.parseHex("0123456789ABCDEF"));

    // Assert
    assertEquals(18L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  void testVisitFromString2() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromString(COSString.parseHex("42"));

    // Assert
    assertEquals(3L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#visitFromString(COSString)}
   */
  @Test
  void testVisitFromString3() throws IOException {
    // Arrange
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(1);
    COSWriter cosWriter = new COSWriter(outputStream);

    // Act
    cosWriter.visitFromString(new COSString("Text", true));

    // Assert
    assertEquals(10L, cosWriter.getStandardOutput().getPos());
    assertSame(outputStream, cosWriter.getOutput());
  }

  /**
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite() throws IOException {
    // Arrange
    COSWriter cosWriter = new COSWriter(new ByteArrayOutputStream(1));

    COSDocumentState cosDocumentState = new COSDocumentState();
    cosDocumentState.setParsing(true);
    COSDocument doc = mock(COSDocument.class);
    when(doc.getEncryptionDictionary()).thenThrow(new IllegalStateException("foo"));
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite2() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite3() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite4() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite5() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite6() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite7() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite8() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite9() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite10() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite11() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite12() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite13() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite14() throws IOException {
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
   * Method under test: {@link COSWriter#write(COSDocument)}
   */
  @Test
  void testWrite15() throws IOException {
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
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  void testWriteString() throws IOException {
    // Arrange
    COSString string = COSString.parseHex("0123456789ABCDEF");
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<0123456789ABCDEF>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  void testWriteString2() throws IOException {
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
   * Method under test: {@link COSWriter#writeString(COSString, OutputStream)}
   */
  @Test
  void testWriteString3() throws IOException {
    // Arrange
    COSString string = new COSString("Text", true);

    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(string, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<54657874>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }

  /**
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  void testWriteString4() throws IOException {
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
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  void testWriteString5() throws IOException {
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
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  void testWriteString6() throws IOException {
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
   * Method under test: {@link COSWriter#writeString(byte[], OutputStream)}
   */
  @Test
  void testWriteString7() throws IOException {
    // Arrange
    ByteArrayOutputStream output = new ByteArrayOutputStream(1);

    // Act
    COSWriter.writeString(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, output);

    // Assert that nothing has changed
    byte[] expectedToByteArrayResult = "<FF58415841584158>".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, output.toByteArray());
  }
}
