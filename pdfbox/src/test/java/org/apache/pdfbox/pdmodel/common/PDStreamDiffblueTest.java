package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInputStream;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.filter.DecodeOptions;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.io.ScratchFile;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.filespecification.PDComplexFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDFileSpecification;
import org.apache.pdfbox.pdmodel.common.filespecification.PDSimpleFileSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDStreamDiffblueTest {
  /**
   * Test {@link PDStream#PDStream(COSStream)}.
   *
   * <p>Method under test: {@link PDStream#PDStream(COSStream)}
   */
  @Test
  @DisplayName("Test new PDStream(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(COSStream)"})
  void testNewPDStream() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, new PDStream(str).getCOSObject());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream)}.
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDStream(PDDocument, InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream)"})
  void testNewPDStream2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSArray); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSArray)"})
  void testNewPDStream_givenIllegalStateException_thenThrowIllegalStateException()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IllegalStateException());
    doThrow(new IllegalStateException()).when(input).close();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> new PDStream(doc, input, (COSArray) null));
    verify(input).close();
    verify(input).transferTo(isA(OutputStream.class));
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSName)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSName)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSName); given 'null'; then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSName)"})
  void testNewPDStream_givenNull_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSName) null);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream)"})
  void testNewPDStream_givenNull_whenStreamCacheCreateFunctionCreateReturnNull()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return COSObject Filters is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSArray); given one; then return COSObject Filters is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSArray)"})
  void testNewPDStream_givenOne_thenReturnCOSObjectFiltersIsNull() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    doNothing().when(input).close();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSArray) null);

    // Assert
    verify(input).close();
    verify(input).transferTo(isA(OutputStream.class));
    COSStream cOSObject = actualPdStream.getCOSObject();
    assertNull(cOSObject.getFilters());
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, cOSObject.getLength());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSArray); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSArray)"})
  void testNewPDStream_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSArray) null);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSName)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSName)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSName); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSName)"})
  void testNewPDStream_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne2()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSName) null);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code
   *       byte} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream); then ByteArrayInputStream(byte[]) with empty array of byte read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream)"})
  void testNewPDStream_thenByteArrayInputStreamWithEmptyArrayOfByteReadIsMinusOne()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSName)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code
   *       byte} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSName)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSName); then ByteArrayInputStream(byte[]) with empty array of byte read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSName)"})
  void testNewPDStream_thenByteArrayInputStreamWithEmptyArrayOfByteReadIsMinusOne2()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSName) null);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, actualPdStream.getLength());
    assertEquals(0L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}.
   *
   * <ul>
   *   <li>Then COSObject Filters return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument, InputStream, COSArray); then COSObject Filters return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSArray)"})
  void testNewPDStream_thenCOSObjectFiltersReturnCOSArray() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    COSArray filters = new COSArray();

    // Act
    PDStream actualPdStream = new PDStream(doc, input, filters);

    // Assert
    COSStream cOSObject = actualPdStream.getCOSObject();
    COSBase filters2 = cOSObject.getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) filters2).toList().isEmpty());
    assertTrue(actualPdStream.getFilters().isEmpty());
    assertSame(filters, filters2);
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream, COSName)}.
   *
   * <ul>
   *   <li>Then calls {@link RandomAccessStreamCache.StreamCacheCreateFunction#create()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream, COSName)}
   */
  @Test
  @DisplayName("Test new PDStream(PDDocument, InputStream, COSName); then calls create()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream, COSName)"})
  void testNewPDStream_thenCallsCreate() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-100L);
    when(streamCacheCreateFunction.create()).thenReturn(new ScratchFile(memUsageSetting));
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input, (COSName) null);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(COSDocument)}.
   *
   * <ul>
   *   <li>When {@link COSDocument#COSDocument()}.
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(COSDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(COSDocument); when COSDocument(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(COSDocument)"})
  void testNewPDStream_whenCOSDocument_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDStream actualPdStream = new PDStream(new COSDocument());

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument, InputStream)}
   */
  @Test
  @DisplayName("Test new PDStream(PDDocument, InputStream); when PDDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument, InputStream)"})
  void testNewPDStream_whenPDDocument() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDStream actualPdStream = new PDStream(doc, input);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdStream.getLength());
    assertEquals(8L, actualPdStream.getCOSObject().getLength());
  }

  /**
   * Test {@link PDStream#PDStream(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#PDStream(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDStream(PDDocument); when PDDocument(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.<init>(PDDocument)"})
  void testNewPDStream_whenPDDocument_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDStream actualPdStream = new PDStream(new PDDocument());

    // Assert
    assertNull(actualPdStream.getDecodeParms());
    assertNull(actualPdStream.getFileDecodeParams());
    assertNull(actualPdStream.getMetadata());
    assertNull(actualPdStream.getFile());
    assertEquals(-1, actualPdStream.getDecodedStreamLength());
    assertEquals(0, actualPdStream.getLength());
    List<String> fileFilters = actualPdStream.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualPdStream.getFilters());
  }

  /**
   * Test {@link PDStream#getCOSObject()}.
   *
   * <p>Method under test: {@link PDStream#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSStream PDStream.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange and Act
    COSStream actualCOSObject = new PDStream(new COSDocument()).getCOSObject();

    // Assert
    assertNull(actualCOSObject.getFilters());
    COSUpdateState updateState = actualCOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualCOSObject.getKey());
    assertEquals(0L, actualCOSObject.getLength());
    assertEquals(1, actualCOSObject.getValues().size());
    assertEquals(1, actualCOSObject.size());
    COSIncrement toIncrementResult = actualCOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualCOSObject.isDirect());
    assertFalse(actualCOSObject.hasData());
    assertFalse(actualCOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDStream#createOutputStream()}.
   *
   * <p>Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  @DisplayName("Test createOutputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream()"})
  void testCreateOutputStream() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata pdMetadata =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    pdMetadata.createOutputStream();

    // Assert that nothing has changed
    assertTrue(pdMetadata.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream(COSName)} with {@code COSName}.
   *
   * <p>Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSName) with 'COSName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream(COSName)"})
  void testCreateOutputStreamWithCOSName() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.createOutputStream(null);

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream(COSName)} with {@code COSName}.
   *
   * <p>Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  @DisplayName("Test createOutputStream(COSName) with 'COSName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream(COSName)"})
  void testCreateOutputStreamWithCOSName2() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata pdMetadata =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    pdMetadata.createOutputStream(null);

    // Assert that nothing has changed
    assertTrue(pdMetadata.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSStream)} with str is {@link COSStream#COSStream()}
   *       COSObject hasData.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSName) with 'COSName'; then PDStream(COSStream) with str is COSStream() COSObject hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream(COSName)"})
  void testCreateOutputStreamWithCOSName_thenPDStreamWithStrIsCOSStreamCOSObjectHasData()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSStream());

    // Act
    pdStream.createOutputStream(null);

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream(COSName)} with {@code COSName}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSStream)} with str is {@link COSStream#COSStream()}
   *       COSObject hasData.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream(COSName)}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(COSName) with 'COSName'; then PDStream(COSStream) with str is COSStream() COSObject hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream(COSName)"})
  void testCreateOutputStreamWithCOSName_thenPDStreamWithStrIsCOSStreamCOSObjectHasData2()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSStream());
    pdStream.setFilters(new ArrayList<>());

    // Act
    pdStream.createOutputStream(null);

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(); given PDStream(COSDocument) with document is COSDocument()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream()"})
  void testCreateOutputStream_givenPDStreamWithDocumentIsCOSDocument() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.createOutputStream();

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream()}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} COSObject hasData.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(); then PDStream(COSDocument) with document is COSDocument() COSObject hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream()"})
  void testCreateOutputStream_thenPDStreamWithDocumentIsCOSDocumentCOSObjectHasData()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFilters(new ArrayList<>());

    // Act
    pdStream.createOutputStream();

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream()}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSStream)} with str is {@link COSStream#COSStream()}
   *       COSObject hasData.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(); then PDStream(COSStream) with str is COSStream() COSObject hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream()"})
  void testCreateOutputStream_thenPDStreamWithStrIsCOSStreamCOSObjectHasData() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSStream());

    // Act
    pdStream.createOutputStream();

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createOutputStream()}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSStream)} with str is {@link
   *       COSStream#COSStream(RandomAccessStreamCache)} COSObject hasData.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createOutputStream()}
   */
  @Test
  @DisplayName(
      "Test createOutputStream(); then PDStream(COSStream) with str is COSStream(RandomAccessStreamCache) COSObject hasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OutputStream PDStream.createOutputStream()"})
  void testCreateOutputStream_thenPDStreamWithStrIsCOSStreamCOSObjectHasData2() throws IOException {
    // Arrange
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile streamCache = new ScratchFile(memUsageSetting);
    COSStream str = new COSStream(streamCache);
    PDStream pdStream = new PDStream(str);

    // Act
    pdStream.createOutputStream();

    // Assert
    assertTrue(pdStream.getCOSObject().hasData());
  }

  /**
   * Test {@link PDStream#createInputStream(DecodeOptions)} with {@code options}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createInputStream(DecodeOptions)}
   */
  @Test
  @DisplayName("Test createInputStream(DecodeOptions) with 'options'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInputStream PDStream.createInputStream(DecodeOptions)"})
  void testCreateInputStreamWithOptions_thenReturnNull() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    when(cosName.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(cosName);

    COSStream str = mock(COSStream.class);
    when(str.createInputStream(Mockito.<DecodeOptions>any())).thenReturn(null);
    doNothing().when(str).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDMetadata pdMetadata = new PDMetadata(str);
    pdMetadata.setFilters(filters);

    // Act
    COSInputStream actualCreateInputStreamResult =
        pdMetadata.createInputStream(DecodeOptions.DEFAULT);

    // Assert
    verify(cosName).getCOSObject();
    verify(str).setItem(isA(COSName.class), isA(COSBase.class));
    verify(str).createInputStream(isA(DecodeOptions.class));
    assertNull(actualCreateInputStreamResult);
  }

  /**
   * Test {@link PDStream#createInputStream(List)} with {@code stopFilters}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createInputStream(List)}
   */
  @Test
  @DisplayName("Test createInputStream(List) with 'stopFilters'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDStream.createInputStream(List)"})
  void testCreateInputStreamWithStopFilters_thenThrowIllegalStateException() throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    when(cosName.getCOSObject()).thenReturn(mock(COSName.class));

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(cosName);

    COSArray cosArray = mock(COSArray.class);
    Mockito.<List<? extends COSBase>>when(cosArray.toList()).thenThrow(new IllegalStateException());

    COSStream str = mock(COSStream.class);
    when(str.createRawInputStream())
        .thenReturn(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    when(str.getFilters()).thenReturn(cosArray);
    doNothing().when(str).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDMetadata pdMetadata = new PDMetadata(str);
    pdMetadata.setFilters(filters);

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> pdMetadata.createInputStream(new ArrayList<>()));
    verify(cosArray).toList();
    verify(cosName).getCOSObject();
    verify(str).setItem(isA(COSName.class), isA(COSBase.class));
    verify(str).createRawInputStream();
    verify(str).getFilters();
  }

  /**
   * Test {@link PDStream#createInputStream()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#createInputStream()} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#createInputStream()}
   */
  @Test
  @DisplayName(
      "Test createInputStream(); given COSStream createInputStream() return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSInputStream PDStream.createInputStream()"})
  void testCreateInputStream_givenCOSStreamCreateInputStreamReturnNull_thenReturnNull()
      throws IOException {
    // Arrange
    COSName cosName = mock(COSName.class);
    when(cosName.getCOSObject()).thenReturn(COSBoolean.FALSE);

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(cosName);

    COSStream str = mock(COSStream.class);
    when(str.createInputStream()).thenReturn(null);
    doNothing().when(str).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDMetadata pdMetadata = new PDMetadata(str);
    pdMetadata.setFilters(filters);

    // Act
    COSInputStream actualCreateInputStreamResult = pdMetadata.createInputStream();

    // Assert
    verify(cosName).getCOSObject();
    verify(str).setItem(isA(COSName.class), isA(COSBase.class));
    verify(str).createInputStream();
    assertNull(actualCreateInputStreamResult);
  }

  /**
   * Test {@link PDStream#getLength()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getLength()}
   */
  @Test
  @DisplayName(
      "Test getLength(); given PDStream(COSDocument) with document is COSDocument(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStream.getLength()"})
  void testGetLength_givenPDStreamWithDocumentIsCOSDocument_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new PDStream(new COSDocument()).getLength());
  }

  /**
   * Test {@link PDStream#getFilters()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} Filters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFilters()}
   */
  @Test
  @DisplayName(
      "Test getFilters(); given PDStream(COSDocument) with document is COSDocument() Filters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFilters()"})
  void testGetFilters_givenPDStreamWithDocumentIsCOSDocumentFiltersIsArrayList() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFilters(new ArrayList<>());

    // Act and Assert
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#getFilters()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFilters()}
   */
  @Test
  @DisplayName(
      "Test getFilters(); given PDStream(COSDocument) with document is COSDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFilters()"})
  void testGetFilters_givenPDStreamWithDocumentIsCOSDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDStream(new COSDocument()).getFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#setFilters(List)}.
   *
   * <p>Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFilters(List)"})
  void testSetFilters() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);

    // Act
    pdStream.setFilters(filters);

    // Assert
    COSBase filters2 = pdStream.getCOSObject().getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(1, ((COSArray) filters2).toList().size());
    assertEquals(1, pdStream.getFilters().size());
  }

  /**
   * Test {@link PDStream#setFilters(List)}.
   *
   * <p>Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFilters(List)"})
  void testSetFilters2() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(COSName.A);
    filters.add(COSName.A);

    // Act
    pdStream.setFilters(filters);

    // Assert
    COSBase filters2 = pdStream.getCOSObject().getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(filters, ((COSArray) filters2).toList());
    assertEquals(filters, pdStream.getFilters());
  }

  /**
   * Test {@link PDStream#setFilters(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  @DisplayName("Test setFilters(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFilters(List)"})
  void testSetFilters_givenNull_whenArrayListAddNull() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<COSName> filters = new ArrayList<>();
    filters.add(null);

    // Act
    pdStream.setFilters(filters);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters2 = cOSObject.getFilters();
    assertTrue(filters2 instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(filters, ((COSArray) filters2).toList());
    assertEquals(filters, pdStream.getFilters());
  }

  /**
   * Test {@link PDStream#setFilters(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} COSObject Filters toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFilters(List)}
   */
  @Test
  @DisplayName(
      "Test setFilters(List); then PDStream(COSDocument) with document is COSDocument() COSObject Filters toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFilters(List)"})
  void testSetFilters_thenPDStreamWithDocumentIsCOSDocumentCOSObjectFiltersToListEmpty() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFilters(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    COSBase filters = cOSObject.getFilters();
    assertTrue(filters instanceof COSArray);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(((COSArray) filters).toList().isEmpty());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms2() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms3() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSName.A, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms4() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given 'A'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenA_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject cosObject = new COSObject(key, parser);
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAdd42_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given ArrayList() add COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAddCOSArray_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSArray());

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then return first Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName(
      "Test getDecodeParms(); given ArrayList() add COSDictionary(); then return first Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAddCOSDictionary_thenReturnFirstEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSDictionary());

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act
    List<Object> actualDecodeParms = pdStream.getDecodeParms();

    // Assert
    assertEquals(1, actualDecodeParms.size());
    Object getResult = actualDecodeParms.get(0);
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given ArrayList() add empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAddEmptyString_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given ArrayList() add 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAddNull_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given ArrayList() add two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenArrayListAddTwo_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(2);
    decodeParams.add("42");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName(
      "Test getDecodeParms(); given COSFloat(float) with aFloat is '-3.4028235E38'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenCOSFloatWithAFloatIs34028235e38_thenReturnEmpty()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSFloat object = new COSFloat(-3.4028235E38f);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); given COSFloat(float) with aFloat is ten; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenCOSFloatWithAFloatIsTen_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSFloat object = new COSFloat(10.0f);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link COSObject#COSObject(COSBase, COSObjectKey)} with object is {@link
   *       COSBoolean#FALSE} and objectKey is {@link COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName(
      "Test getDecodeParms(); given COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName(
      "Test getDecodeParms(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName(
      "Test getDecodeParms(); given PDStream(COSDocument) with document is COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_givenPDStreamWithDocumentIsCOSDocument_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDStream(new COSDocument()).getDecodeParms());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_thenReturnEmpty() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(new ArrayList<>());

    // Act and Assert
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getDecodeParms()}.
   *
   * <ul>
   *   <li>Then return first size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodeParms()}
   */
  @Test
  @DisplayName("Test getDecodeParms(); then return first size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getDecodeParms()"})
  void testGetDecodeParms_thenReturnFirstSizeIsOne() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSStream object = new COSStream();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodeParms(decodeParams);

    // Act
    List<Object> actualDecodeParms = pdStream.getDecodeParms();

    // Assert
    assertEquals(1, actualDecodeParms.size());
    Object getResult = actualDecodeParms.get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(0, ((Map<String, Integer>) getResult).get("Length").intValue());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams2() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSFloat.ONE, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams3() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(COSName.A, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams4() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams5() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObject cosObject = new COSObject(new COSObjectKey(1L, 1), null);
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given 'A'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenA_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObjectKey key = new COSObjectKey(1L, 1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser parser = new COSParser(source);

    COSObject cosObject = new COSObject(key, parser);
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given ArrayList() add '42'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAdd42_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given ArrayList() add COSArray(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAddCOSArray_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSArray());

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then return first Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName(
      "Test getFileDecodeParams(); given ArrayList() add COSDictionary(); then return first Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAddCOSDictionary_thenReturnFirstEmpty()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSDictionary());

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act
    List<Object> actualFileDecodeParams = pdStream.getFileDecodeParams();

    // Assert
    assertEquals(1, actualFileDecodeParams.size());
    Object getResult = actualFileDecodeParams.get(0);
    assertTrue(getResult instanceof Map);
    assertTrue(((Map<Object, Object>) getResult).isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given ArrayList() add empty string; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAddEmptyString_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given ArrayList() add 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAddNull_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add two.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); given ArrayList() add two; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenArrayListAddTwo_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(2);
    decodeParams.add("42");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is {@code -3.4028235E38}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName(
      "Test getFileDecodeParams(); given COSFloat(float) with aFloat is '-3.4028235E38'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenCOSFloatWithAFloatIs34028235e38_thenReturnEmpty()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSFloat object = new COSFloat(-3.4028235E38f);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link COSFloat#COSFloat(float)} with aFloat is ten.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName(
      "Test getFileDecodeParams(); given COSFloat(float) with aFloat is ten; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenCOSFloatWithAFloatIsTen_thenReturnEmpty() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSFloat object = new COSFloat(10.0f);
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName(
      "Test getFileDecodeParams(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName(
      "Test getFileDecodeParams(); given PDStream(COSDocument) with document is COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_givenPDStreamWithDocumentIsCOSDocument_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDStream(new COSDocument()).getFileDecodeParams());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_thenReturnEmpty() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(new ArrayList<>());

    // Act and Assert
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileDecodeParams()}.
   *
   * <ul>
   *   <li>Then return first size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileDecodeParams()}
   */
  @Test
  @DisplayName("Test getFileDecodeParams(); then return first size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileDecodeParams()"})
  void testGetFileDecodeParams_thenReturnFirstSizeIsOne() throws IOException {
    // Arrange
    ArrayList<Object> decodeParams = new ArrayList<>();
    COSStream object = new COSStream();
    COSObject cosObject = new COSObject(object, new COSObjectKey(1L, 1));
    decodeParams.add(cosObject);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileDecodeParams(decodeParams);

    // Act
    List<Object> actualFileDecodeParams = pdStream.getFileDecodeParams();

    // Assert
    assertEquals(1, actualFileDecodeParams.size());
    Object getResult = actualFileDecodeParams.get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(0, ((Map<String, Integer>) getResult).get("Length").intValue());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new PDMetadata(new COSStream()));
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    List<Object> decodeParms = pdStream.getDecodeParms();
    assertEquals(1, decodeParms.size());
    Object getResult = decodeParms.get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(0, ((Map<String, Integer>) getResult).get("Length").intValue());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given COSArray(); when ArrayList() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_givenCOSArray_whenArrayListAddCOSArray() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSArray());
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_givenNull_whenArrayListAddNull() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<?> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link ArrayList#ArrayList()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given ten; when ArrayList() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_givenTen_whenArrayListAddTen() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0d);
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link ArrayList#ArrayList()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given ten; when ArrayList() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_givenTen_whenArrayListAddTen2() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0f);
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); given two; when ArrayList() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_givenTwo_whenArrayListAddTwo() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(2);

    // Act
    pdStream.setDecodeParms(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName(
      "Test setDecodeParms(List); then PDStream(COSDocument) with document is COSDocument() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_thenPDStreamWithDocumentIsCOSDocumentCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodeParms(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_whenArrayList() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodeParms(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#setDecodeParms(List)}.
   *
   * <ul>
   *   <li>When {@link COSArrayList#COSArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setDecodeParms(List)}
   */
  @Test
  @DisplayName("Test setDecodeParms(List); when COSArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodeParms(List)"})
  void testSetDecodeParms_whenCOSArrayList() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodeParms(new COSArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getDecodeParms().isEmpty());
  }

  /**
   * Test {@link PDStream#getFile()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFile()}
   */
  @Test
  @DisplayName(
      "Test getFile(); given PDStream(COSDocument) with document is COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDStream.getFile()"})
  void testGetFile_givenPDStreamWithDocumentIsCOSDocument_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDStream(new COSDocument()).getFile());
  }

  /**
   * Test {@link PDStream#getFile()}.
   *
   * <ul>
   *   <li>Then COSObject return {@link COSString}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then COSObject return COSString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDStream.getFile()"})
  void testGetFile_thenCOSObjectReturnCOSString() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFile(new PDSimpleFileSpecification());

    // Act
    PDFileSpecification actualFile = pdStream.getFile();

    // Assert
    COSBase cOSObject = actualFile.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertTrue(actualFile instanceof PDSimpleFileSpecification);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualFile.getFile());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    assertArrayEquals(new byte[] {}, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDStream#getFile()}.
   *
   * <ul>
   *   <li>Then return {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); then return PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFileSpecification PDStream.getFile()"})
  void testGetFile_thenReturnPDComplexFileSpecification() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFile(new PDComplexFileSpecification());

    // Act
    PDFileSpecification actualFile = pdStream.getFile();

    // Assert
    assertTrue(actualFile instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) actualFile).getFileDescription());
    assertNull(((PDComplexFileSpecification) actualFile).getFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getFileUnix());
    assertNull(((PDComplexFileSpecification) actualFile).getFilename());
    assertNull(actualFile.getFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) actualFile).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) actualFile).isVolatile());
  }

  /**
   * Test {@link PDStream#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} COSObject Values size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDStream(COSDocument) with document is COSDocument() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFile(PDFileSpecification)"})
  void testSetFile_thenPDStreamWithDocumentIsCOSDocumentCOSObjectValuesSizeIsOne() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFile(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} File {@link PDComplexFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDStream(COSDocument) with document is COSDocument() File PDComplexFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFile(PDFileSpecification)"})
  void testSetFile_thenPDStreamWithDocumentIsCOSDocumentFilePDComplexFileSpecification()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFile(new PDComplexFileSpecification());

    // Assert
    PDFileSpecification file = pdStream.getFile();
    assertTrue(file instanceof PDComplexFileSpecification);
    assertNull(((PDComplexFileSpecification) file).getFileDescription());
    assertNull(((PDComplexFileSpecification) file).getFileDos());
    assertNull(((PDComplexFileSpecification) file).getFileMac());
    assertNull(((PDComplexFileSpecification) file).getFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getFileUnix());
    assertNull(((PDComplexFileSpecification) file).getFilename());
    assertNull(file.getFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFile());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileDos());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileMac());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnicode());
    assertNull(((PDComplexFileSpecification) file).getEmbeddedFileUnix());
    assertFalse(((PDComplexFileSpecification) file).isVolatile());
  }

  /**
   * Test {@link PDStream#setFile(PDFileSpecification)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} File {@link PDSimpleFileSpecification}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFile(PDFileSpecification)}
   */
  @Test
  @DisplayName(
      "Test setFile(PDFileSpecification); then PDStream(COSDocument) with document is COSDocument() File PDSimpleFileSpecification")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFile(PDFileSpecification)"})
  void testSetFile_thenPDStreamWithDocumentIsCOSDocumentFilePDSimpleFileSpecification()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFile(new PDSimpleFileSpecification());

    // Assert
    PDFileSpecification file = pdStream.getFile();
    assertTrue(file instanceof PDSimpleFileSpecification);
    assertEquals("", file.getFile());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDStream#getFileFilters()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  @DisplayName("Test getFileFilters(); given ArrayList() add '42'; then return ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileFilters()"})
  void testGetFileFilters_givenArrayListAdd42_thenReturnArrayList() {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileFilters(filters);

    // Act and Assert
    assertEquals(filters, pdStream.getFileFilters());
  }

  /**
   * Test {@link PDStream#getFileFilters()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  @DisplayName("Test getFileFilters(); given ArrayList() add 'foo'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileFilters()"})
  void testGetFileFilters_givenArrayListAddFoo_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileFilters(filters);

    // Act
    List<String> actualFileFilters = pdStream.getFileFilters();

    // Assert
    assertEquals(1, actualFileFilters.size());
    assertEquals("foo", actualFileFilters.get(0));
  }

  /**
   * Test {@link PDStream#getFileFilters()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  @DisplayName(
      "Test getFileFilters(); given PDStream(COSDocument) with document is COSDocument(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileFilters()"})
  void testGetFileFilters_givenPDStreamWithDocumentIsCOSDocument_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDStream(new COSDocument()).getFileFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#getFileFilters()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getFileFilters()}
   */
  @Test
  @DisplayName("Test getFileFilters(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDStream.getFileFilters()"})
  void testGetFileFilters_thenReturnEmpty() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setFileFilters(new ArrayList<>());

    // Act and Assert
    assertTrue(pdStream.getFileFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileFilters(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  @DisplayName("Test setFileFilters(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileFilters(List)"})
  void testSetFileFilters_given42_whenArrayListAdd42() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<String> filters = new ArrayList<>();
    filters.add("42");
    filters.add("foo");

    // Act
    pdStream.setFileFilters(filters);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFilters().isEmpty());
    assertEquals(filters, pdStream.getFileFilters());
  }

  /**
   * Test {@link PDStream#setFileFilters(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} FileFilters Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  @DisplayName(
      "Test setFileFilters(List); then PDStream(COSDocument) with document is COSDocument() FileFilters Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileFilters(List)"})
  void testSetFileFilters_thenPDStreamWithDocumentIsCOSDocumentFileFiltersEmpty() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileFilters(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileFilters().isEmpty());
    assertTrue(pdStream.getFilters().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileFilters(List)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} FileFilters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileFilters(List)}
   */
  @Test
  @DisplayName(
      "Test setFileFilters(List); then PDStream(COSDocument) with document is COSDocument() FileFilters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileFilters(List)"})
  void testSetFileFilters_thenPDStreamWithDocumentIsCOSDocumentFileFiltersIsArrayList() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<String> filters = new ArrayList<>();
    filters.add("foo");

    // Act
    pdStream.setFileFilters(filters);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFilters().isEmpty());
    assertEquals(filters, pdStream.getFileFilters());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileDecodeParams(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams2() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new PDMetadata(new COSStream()));
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    List<Object> fileDecodeParams = pdStream.getFileDecodeParams();
    assertEquals(1, fileDecodeParams.size());
    Object getResult = fileDecodeParams.get(0);
    assertTrue(getResult instanceof Map);
    assertEquals(1, ((Map<String, Integer>) getResult).size());
    assertEquals(0, ((Map<String, Integer>) getResult).get("Length").intValue());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add("42");
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given COSArray(); when ArrayList() add COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_givenCOSArray_whenArrayListAddCOSArray() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(new COSArray());
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_givenNull_whenArrayListAddNull() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<?> decodeParams = new ArrayList<>();
    decodeParams.add(null);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link ArrayList#ArrayList()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given ten; when ArrayList() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_givenTen_whenArrayListAddTen() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0d);
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given ten.
   *   <li>When {@link ArrayList#ArrayList()} add ten.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given ten; when ArrayList() add ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_givenTen_whenArrayListAddTen2() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(10.0f);
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ArrayList#ArrayList()} add two.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); given two; when ArrayList() add two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_givenTwo_whenArrayListAddTwo() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    ArrayList<Object> decodeParams = new ArrayList<>();
    decodeParams.add(2);

    // Act
    pdStream.setFileDecodeParams(decodeParams);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_whenArrayList() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileDecodeParams(new ArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#setFileDecodeParams(List)}.
   *
   * <ul>
   *   <li>When {@link COSArrayList#COSArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setFileDecodeParams(List)}
   */
  @Test
  @DisplayName("Test setFileDecodeParams(List); when COSArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setFileDecodeParams(List)"})
  void testSetFileDecodeParams_whenCOSArrayList() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setFileDecodeParams(new COSArrayList<>());

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdStream.getFileDecodeParams().isEmpty());
  }

  /**
   * Test {@link PDStream#toByteArray()}.
   *
   * <ul>
   *   <li>Given {@link PDMetadata#PDMetadata(PDDocument, InputStream)} with doc is {@link
   *       PDDocument#PDDocument()} and str is {@link
   *       ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#toByteArray()}
   */
  @Test
  @DisplayName(
      "Test toByteArray(); given PDMetadata(PDDocument, InputStream) with doc is PDDocument() and str is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDStream.toByteArray()"})
  void testToByteArray_givenPDMetadataWithDocIsPDDocumentAndStrIsByteArrayInputStream()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    PDMetadata pdMetadata =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), pdMetadata.toByteArray());
  }

  /**
   * Test {@link PDStream#toByteArray()}.
   *
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#toByteArray()}
   */
  @Test
  @DisplayName("Test toByteArray(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDStream.toByteArray()"})
  void testToByteArray_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();

    PDMetadata pdMetadata =
        new PDMetadata(doc, new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    pdMetadata.setFilters(new ArrayList<>());

    // Act and Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), pdMetadata.toByteArray());
  }

  /**
   * Test {@link PDStream#getMetadata()}.
   *
   * <ul>
   *   <li>Given {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  @DisplayName(
      "Test getMetadata(); given PDStream(COSDocument) with document is COSDocument(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMetadata PDStream.getMetadata()"})
  void testGetMetadata_givenPDStreamWithDocumentIsCOSDocument_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDStream(new COSDocument()).getMetadata());
  }

  /**
   * Test {@link PDStream#getMetadata()}.
   *
   * <ul>
   *   <li>Then return COSObject Key is {@link COSObjectKey#COSObjectKey(long, int)} with num is one
   *       and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  @DisplayName(
      "Test getMetadata(); then return COSObject Key is COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMetadata PDStream.getMetadata()"})
  void testGetMetadata_thenReturnCOSObjectKeyIsCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    COSStream str = new COSStream();
    COSObjectKey key = new COSObjectKey(1L, 1);
    str.setKey(key);
    PDMetadata meta = new PDMetadata(str);

    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setMetadata(meta);

    // Act and Assert
    assertSame(key, pdStream.getMetadata().getCOSObject().getKey());
  }

  /**
   * Test {@link PDStream#getMetadata()}.
   *
   * <ul>
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getMetadata()}
   */
  @Test
  @DisplayName("Test getMetadata(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDMetadata PDStream.getMetadata()"})
  void testGetMetadata_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    COSStream str = new COSStream();
    pdStream.setMetadata(new PDMetadata(str));

    // Act
    PDMetadata actualMetadata = pdStream.getMetadata();

    // Assert
    assertNull(actualMetadata.getDecodeParms());
    assertNull(actualMetadata.getFileDecodeParams());
    assertNull(actualMetadata.getFile());
    assertEquals(-1, actualMetadata.getDecodedStreamLength());
    assertEquals(0, actualMetadata.getLength());
    List<String> fileFilters = actualMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(str, actualMetadata.getCOSObject());
    assertSame(fileFilters, actualMetadata.getFilters());
  }

  /**
   * Test {@link PDStream#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setMetadata(PDMetadata)"})
  void testSetMetadata_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    COSStream str = new COSStream();
    str.setKey(new COSObjectKey(1L, 1));

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDStream#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSStream#COSStream()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); given 'true'; when COSStream() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setMetadata(PDMetadata)"})
  void testSetMetadata_givenTrue_whenCOSStreamDirectIsTrue() throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    COSStream str = new COSStream();
    str.setDirect(true);

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDStream#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>Then {@link PDStream#PDStream(COSDocument)} with document is {@link
   *       COSDocument#COSDocument()} Metadata DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName(
      "Test setMetadata(PDMetadata); then PDStream(COSDocument) with document is COSDocument() Metadata DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setMetadata(PDMetadata)"})
  void testSetMetadata_thenPDStreamWithDocumentIsCOSDocumentMetadataDecodeParmsIsNull()
      throws IOException {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    COSStream str = new COSStream();

    // Act
    pdStream.setMetadata(new PDMetadata(str));

    // Assert
    PDMetadata metadata = pdStream.getMetadata();
    assertNull(metadata.getDecodeParms());
    assertNull(metadata.getFileDecodeParams());
    assertNull(metadata.getMetadata());
    assertNull(metadata.getFile());
    assertEquals(-1, metadata.getDecodedStreamLength());
    assertEquals(0, metadata.getLength());
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertSame(str, metadata.getCOSObject());
  }

  /**
   * Test {@link PDStream#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setMetadata(PDMetadata)"})
  void testSetMetadata_whenNull() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setMetadata(null);

    // Assert that nothing has changed
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#setMetadata(PDMetadata)}.
   *
   * <ul>
   *   <li>When {@link PDMetadata#PDMetadata(COSStream)} with str is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#setMetadata(PDMetadata)}
   */
  @Test
  @DisplayName("Test setMetadata(PDMetadata); when PDMetadata(COSStream) with str is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setMetadata(PDMetadata)"})
  void testSetMetadata_whenPDMetadataWithStrIsNull() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setMetadata(new PDMetadata((COSStream) null));

    // Assert that nothing has changed
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDStream#getDecodedStreamLength()}.
   *
   * <ul>
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodedStreamLength()}
   */
  @Test
  @DisplayName("Test getDecodedStreamLength(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStream.getDecodedStreamLength()"})
  void testGetDecodedStreamLength_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, new PDStream(new COSDocument()).getDecodedStreamLength());
  }

  /**
   * Test {@link PDStream#getDecodedStreamLength()}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link PDStream#getDecodedStreamLength()}
   */
  @Test
  @DisplayName("Test getDecodedStreamLength(); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDStream.getDecodedStreamLength()"})
  void testGetDecodedStreamLength_thenReturnThree() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());
    pdStream.setDecodedStreamLength(3);

    // Act and Assert
    assertEquals(3, pdStream.getDecodedStreamLength());
  }

  /**
   * Test {@link PDStream#setDecodedStreamLength(int)}.
   *
   * <p>Method under test: {@link PDStream#setDecodedStreamLength(int)}
   */
  @Test
  @DisplayName("Test setDecodedStreamLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodedStreamLength(int)"})
  void testSetDecodedStreamLength() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodedStreamLength(3);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdStream.getDecodedStreamLength());
  }

  /**
   * Test {@link PDStream#setDecodedStreamLength(int)}.
   *
   * <p>Method under test: {@link PDStream#setDecodedStreamLength(int)}
   */
  @Test
  @DisplayName("Test setDecodedStreamLength(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDStream.setDecodedStreamLength(int)"})
  void testSetDecodedStreamLength2() {
    // Arrange
    PDStream pdStream = new PDStream(new COSDocument());

    // Act
    pdStream.setDecodedStreamLength(Integer.MIN_VALUE);

    // Assert
    COSStream cOSObject = pdStream.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(Integer.MIN_VALUE, pdStream.getDecodedStreamLength());
  }
}
