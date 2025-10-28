package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.Test;

class BruteForceParserDiffblueTest {
  /**
   * Method under test: {@link BruteForceParser#bfSearchTriggered()}
   */
  @Test
  void testBfSearchTriggered() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertFalse((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .bfSearchTriggered());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertTrue((new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getBFCOSObjectOffsets()
            .isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = (new BruteForceParser(cosDocument,
        new COSParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'})))))
                .getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAX%X".getBytes("UTF-8"))))))
            .getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets5() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = (new BruteForceParser(cosDocument,
        new COSParser(
            new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 'A', 0})))))
                .getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  void testGetBFCOSObjectOffsets6() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXA%".getBytes("UTF-8"))))))
            .getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  void testBfSearchForXRef() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();

    // Act and Assert
    assertEquals(-1L,
        (new BruteForceParser(cosDocument,
            new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
                .bfSearchForXRef(1L));
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  void testBfSearchForXRef2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    long actualBfSearchForXRefResult = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1L, actualBfSearchForXRefResult);
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  void testBfSearchForXRef3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    long actualBfSearchForXRefResult = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXxX".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1L, actualBfSearchForXRefResult);
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  void testBfSearchForXRef4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    long actualBfSearchForXRefResult = (new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAx".getBytes("UTF-8"))))))
            .bfSearchForXRef(1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1L, actualBfSearchForXRefResult);
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  void testBfSearchForObjStreams() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  void testBfSearchForObjStreams2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, new COSParser(
        new RandomAccessReadBuffer(new ByteArrayInputStream(new byte[]{'A', 'X', 'A', 'X', 'A', 'X', 0, 'X'}))));

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  void testBfSearchForObjStreams3() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAX/X".getBytes("UTF-8")))));

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  void testBfSearchForObjStreams4() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXA/".getBytes("UTF-8")))));

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test:
   * {@link BruteForceParser#BruteForceParser(COSDocument, COSParser)}
   */
  @Test
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
   * Method under test:
   * {@link BruteForceParser#BruteForceParser(COSDocument, COSParser)}
   */
  @Test
  void testNewBruteForceParser2() throws IOException {
    // Arrange
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);

    // Act
    BruteForceParser actualBruteForceParser = new BruteForceParser(cosDocument,
        new COSParser(new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBruteForceParser.getBFCOSObjectOffsets().isEmpty());
    assertTrue(actualBruteForceParser.bfSearchTriggered());
  }
}
