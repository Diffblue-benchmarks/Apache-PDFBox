package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BruteForceParserDiffblueTest {
  /**
   * Test {@link BruteForceParser#BruteForceParser(COSDocument, COSParser)}.
   * <p>
   * Method under test:
   * {@link BruteForceParser#BruteForceParser(COSDocument, COSParser)}
   */
  @Test
  @DisplayName("Test new BruteForceParser(COSDocument, COSParser)")
  void testNewBruteForceParser() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act
    BruteForceParser actualBruteForceParser = new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    assertTrue(actualBruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualBruteForceParser.bfSearchTriggered());
  }

  /**
   * Test {@link BruteForceParser#bfSearchTriggered()}.
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchTriggered()}
   */
  @Test
  @DisplayName("Test bfSearchTriggered()")
  void testBfSearchTriggered() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertFalse((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
        .bfSearchTriggered());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given 'A'")
  void testGetBFCOSObjectOffsets_givenA() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given 'A'")
  void testGetBFCOSObjectOffsets_givenA2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0})))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAX%%} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given ByteArrayInputStream(byte[]) with 'AXAXAX%%' Bytes is 'UTF-8'")
  void testGetBFCOSObjectOffsets_givenByteArrayInputStreamWithAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAX%%".getBytes("UTF-8"))))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAX%X} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given ByteArrayInputStream(byte[]) with 'AXAXAX%X' Bytes is 'UTF-8'")
  void testGetBFCOSObjectOffsets_givenByteArrayInputStreamWithAxaxaxXBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAX%X".getBytes("UTF-8"))))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXA%} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given ByteArrayInputStream(byte[]) with 'AXAXAXA%' Bytes is 'UTF-8'")
  void testGetBFCOSObjectOffsets_givenByteArrayInputStreamWithAxaxaxaBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXA%".getBytes("UTF-8"))))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testGetBFCOSObjectOffsets_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
        .getBFCOSObjectOffsets()
        .isEmpty());
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   * <ul>
   *   <li>Given {@code A}.</li>
   *   <li>Then return seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given 'A'; then return seven")
  void testBfSearchForXRef_givenA_thenReturnSeven() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertEquals(7L,
        (new BruteForceParser(cosDocument, new COSParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'x'})))))
            .bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAx} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given ByteArrayInputStream(byte[]) with 'AXAXAXAx' Bytes is 'UTF-8'")
  void testBfSearchForXRef_givenByteArrayInputStreamWithAXAXAXAxBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertEquals(-1L,
        (new BruteForceParser(cosDocument,
            new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAx".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXxX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given ByteArrayInputStream(byte[]) with 'AXAXAXxX' Bytes is 'UTF-8'")
  void testBfSearchForXRef_givenByteArrayInputStreamWithAXAXAXxXBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertEquals(-1L,
        (new BruteForceParser(cosDocument,
            new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXxX".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testBfSearchForXRef_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertEquals(-1L,
        (new BruteForceParser(cosDocument,
            new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForObjStreams(Map)}.
   * <ul>
   *   <li>Then calls {@link RandomAccessRead#getPosition()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  @DisplayName("Test bfSearchForObjStreams(Map); then calls getPosition()")
  void testBfSearchForObjStreams_thenCallsGetPosition() throws IOException {
    // Arrange
    RandomAccessRead source = mock(RandomAccessRead.class);
    when(source.isEOF()).thenReturn(true);
    when(source.read()).thenReturn(-1);
    when(source.getPosition()).thenReturn(1L);
    when(source.length()).thenReturn(3L);
    doNothing().when(source).seek(anyLong());
    COSParser cosParser = new COSParser(source);
    BruteForceParser bruteForceParser = new BruteForceParser(new COSDocument(), cosParser);

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(source, atLeast(1)).getPosition();
    verify(source).isEOF();
    verify(source).length();
    verify(source, atLeast(1)).read();
    verify(source, atLeast(1)).seek(anyLong());
  }
}
