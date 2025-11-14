package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class XrefParserDiffblueTest {
  /**
   * Test {@link XrefParser#XrefParser(COSParser)}.
   *
   * <ul>
   *   <li>Then return XrefTable is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#XrefParser(COSParser)}
   */
  @Test
  @DisplayName("Test new XrefParser(COSParser); then return XrefTable is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XrefParser.<init>(COSParser)"})
  void testNewXrefParser_thenReturnXrefTableIsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new XrefParser(new COSParser(new RandomAccessReadWriteBuffer())).getXrefTable());
  }

  /**
   * Test {@link XrefParser#getXrefTable()}.
   *
   * <ul>
   *   <li>Given {@link XrefParser#XrefParser(COSParser)} with cosParser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#getXrefTable()}
   */
  @Test
  @DisplayName(
      "Test getXrefTable(); given XrefParser(COSParser) with cosParser is COSParser(RandomAccessRead); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map XrefParser.getXrefTable()"})
  void testGetXrefTable_givenXrefParserWithCosParserIsCOSParser_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new XrefParser(new COSParser(new RandomAccessReadWriteBuffer())).getXrefTable());
  }

  /**
   * Test {@link XrefParser#getXrefTable()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#getXrefTable()}
   */
  @Test
  @DisplayName("Test getXrefTable(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map XrefParser.getXrefTable()"})
  void testGetXrefTable_thenReturnEmpty() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(new COSParser(new RandomAccessReadWriteBuffer()));
    xrefParser.parseXref(new COSDocument(), 1L);

    // Act and Assert
    assertTrue(xrefParser.getXrefTable().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref() throws IOException {
    // Arrange
    XrefParser xrefParser =
        new XrefParser(
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L)));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref2() throws IOException {
    // Arrange
    XrefParser xrefParser =
        new XrefParser(
            new COSParser(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, Long.MIN_VALUE)));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref3() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    XrefParser xrefParser =
        new XrefParser(new COSParser(new RandomAccessReadView(randomAccessRead, 1L, 3L)));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref4() throws IOException {
    // Arrange
    XrefParser xrefParser =
        new XrefParser(
            new COSParser(
                new RandomAccessReadView(
                    new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L), 1L, 3L)));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName("Test parseXref(COSDocument, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref5() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    XrefParser xrefParser =
        new XrefParser(
            new COSParser(
                new RandomAccessReadView(
                    new RandomAccessReadView(randomAccessRead, -1L, 3L), 1L, 3L)));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and {@code s}.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName(
      "Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with array of byte with 'A' and 's'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref_givenByteArrayInputStreamWithArrayOfByteWithAAndS() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 's', 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);
    XrefParser xrefParser = new XrefParser(cosParser);
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with tab and one.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName(
      "Test parseXref(COSDocument, long); given ByteArrayInputStream(byte[]) with array of byte with tab and one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref_givenByteArrayInputStreamWithArrayOfByteWithTabAndOne() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'\t', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);
    XrefParser xrefParser = new XrefParser(cosParser);
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName(
      "Test parseXref(COSDocument, long); given COSParser(RandomAccessRead) with source is RandomAccessReadBuffer(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref_givenCOSParserWithSourceIsRandomAccessReadBuffer() throws IOException {
    // Arrange
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);
    XrefParser xrefParser = new XrefParser(cosParser);
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link XrefParser#parseXref(COSDocument, long)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link XrefParser#parseXref(COSDocument, long)}
   */
  @Test
  @DisplayName(
      "Test parseXref(COSDocument, long); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary XrefParser.parseXref(COSDocument, long)"})
  void testParseXref_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    XrefParser xrefParser = new XrefParser(new COSParser(new RandomAccessReadWriteBuffer()));
    COSDocument document = new COSDocument();

    // Act
    COSDictionary actualParseXrefResult = xrefParser.parseXref(document, 1L);

    // Assert
    assertNull(document.getDocumentID());
    assertNull(document.getEncryptionDictionary());
    assertNull(actualParseXrefResult.getKey());
    assertEquals(0, actualParseXrefResult.size());
    COSIncrement toIncrementResult = actualParseXrefResult.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualParseXrefResult.isDirect());
    COSUpdateState updateState = actualParseXrefResult.getUpdateState();
    assertFalse(updateState.getOriginDocumentState().isAcceptingUpdates());
    assertFalse(actualParseXrefResult.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualParseXrefResult.getValues().isEmpty());
    assertTrue(xrefParser.getXrefTable().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
