package org.apache.pdfbox.pdmodel.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDMetadataDiffblueTest {
  /**
   * Test {@link PDMetadata#PDMetadata(COSStream)}.
   *
   * <p>Method under test: {@link PDMetadata#PDMetadata(COSStream)}
   */
  @Test
  @DisplayName("Test new PDMetadata(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.<init>(COSStream)"})
  void testNewPDMetadata() {
    // Arrange
    COSStream str = new COSStream();

    // Act and Assert
    assertSame(str, new PDMetadata(str).getCOSObject());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link RandomAccessStreamCache.StreamCacheCreateFunction} {@link
   *       RandomAccessStreamCache.StreamCacheCreateFunction#create()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PDMetadata(PDDocument, InputStream); given 'null'; when StreamCacheCreateFunction create() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument, InputStream)"})
  void testNewPDMetadata_givenNull_whenStreamCacheCreateFunctionCreateReturnNull()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(null);
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = str.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, actualPdMetadata.getCOSObject().getLength());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PDMetadata(PDDocument, InputStream); then ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8' read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument, InputStream)"})
  void testNewPDMetadata_thenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8ReadIsMinusOne()
      throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    int actualReadResult = str.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(8, actualPdMetadata.getLength());
    assertEquals(8L, actualPdMetadata.getCOSObject().getLength());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument, InputStream)}.
   *
   * <ul>
   *   <li>Then {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code
   *       byte} read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#PDMetadata(PDDocument, InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PDMetadata(PDDocument, InputStream); then ByteArrayInputStream(byte[]) with empty array of byte read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument, InputStream)"})
  void testNewPDMetadata_thenByteArrayInputStreamWithEmptyArrayOfByteReadIsMinusOne()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    PDDocument doc = new PDDocument(streamCacheCreateFunction);
    ByteArrayInputStream str = new ByteArrayInputStream(new byte[] {});

    // Act
    PDMetadata actualPdMetadata = new PDMetadata(doc, str);

    // Assert
    verify(streamCacheCreateFunction).create();
    int actualReadResult = str.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, actualPdMetadata.getLength());
    assertEquals(0L, actualPdMetadata.getCOSObject().getLength());
  }

  /**
   * Test {@link PDMetadata#PDMetadata(PDDocument)}.
   *
   * <ul>
   *   <li>When {@link PDDocument#PDDocument()}.
   *   <li>Then return DecodeParms is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#PDMetadata(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDMetadata(PDDocument); when PDDocument(); then return DecodeParms is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.<init>(PDDocument)"})
  void testNewPDMetadata_whenPDDocument_thenReturnDecodeParmsIsNull() throws IOException {
    // Arrange and Act
    PDMetadata actualPdMetadata = new PDMetadata(new PDDocument());

    // Assert
    assertNull(actualPdMetadata.getDecodeParms());
    assertNull(actualPdMetadata.getFileDecodeParams());
    assertNull(actualPdMetadata.getMetadata());
    assertNull(actualPdMetadata.getFile());
    assertEquals(-1, actualPdMetadata.getDecodedStreamLength());
    assertEquals(0, actualPdMetadata.getLength());
    List<String> fileFilters = actualPdMetadata.getFileFilters();
    assertTrue(fileFilters.isEmpty());
    assertSame(fileFilters, actualPdMetadata.getFilters());
  }

  /**
   * Test {@link PDMetadata#exportXMPMetadata()}.
   *
   * <ul>
   *   <li>Then array length is fifty-one.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  @DisplayName("Test exportXMPMetadata(); then array length is fifty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDMetadata.exportXMPMetadata()"})
  void testExportXMPMetadata_thenArrayLengthIsFiftyOne() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    new PDMetadata(str).exportXMPMetadata();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDMetadata#exportXMPMetadata()}.
   *
   * <ul>
   *   <li>Then array length is fifty-one.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#exportXMPMetadata()}
   */
  @Test
  @DisplayName("Test exportXMPMetadata(); then array length is fifty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InputStream PDMetadata.exportXMPMetadata()"})
  void testExportXMPMetadata_thenArrayLengthIsFiftyOne2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream str =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    PDMetadata pdMetadata = new PDMetadata(str);
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    pdMetadata.exportXMPMetadata();

    // Assert
    assertEquals(51, new byte[51].length);
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   *
   * <p>Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName("Test importXMPMetadata(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata() throws IOException {
    // Arrange
    PDDocument doc = new PDDocument();
    ByteArrayInputStream str =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    PDMetadata pdMetadata = new PDMetadata(doc, str);

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert that nothing has changed
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   *
   * <ul>
   *   <li>Then {@link PDMetadata#PDMetadata(COSStream)} with str is {@link COSStream#COSStream()}
   *       Length is eight.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName(
      "Test importXMPMetadata(byte[]); then PDMetadata(COSStream) with str is COSStream() Length is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata_thenPDMetadataWithStrIsCOSStreamLengthIsEight() throws IOException {
    // Arrange
    PDMetadata pdMetadata = new PDMetadata(new COSStream());

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }

  /**
   * Test {@link PDMetadata#importXMPMetadata(byte[])}.
   *
   * <ul>
   *   <li>Then {@link PDMetadata#PDMetadata(COSStream)} with str is {@link COSStream#COSStream()}
   *       Length is eight.
   * </ul>
   *
   * <p>Method under test: {@link PDMetadata#importXMPMetadata(byte[])}
   */
  @Test
  @DisplayName(
      "Test importXMPMetadata(byte[]); then PDMetadata(COSStream) with str is COSStream() Length is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDMetadata.importXMPMetadata(byte[])"})
  void testImportXMPMetadata_thenPDMetadataWithStrIsCOSStreamLengthIsEight2() throws IOException {
    // Arrange
    PDMetadata pdMetadata = new PDMetadata(new COSStream());
    pdMetadata.setFilters(new ArrayList<>());

    // Act
    pdMetadata.importXMPMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8, pdMetadata.getLength());
    COSStream cOSObject = pdMetadata.getCOSObject();
    assertEquals(8L, cOSObject.getLength());
    assertTrue(cOSObject.hasData());
  }
}
