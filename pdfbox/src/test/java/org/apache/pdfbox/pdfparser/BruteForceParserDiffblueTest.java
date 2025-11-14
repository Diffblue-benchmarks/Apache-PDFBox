package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCache.StreamCacheCreateFunction;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BruteForceParserDiffblueTest {
  /**
   * Test {@link BruteForceParser#bfSearchTriggered()}.
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchTriggered()}
   */
  @Test
  @DisplayName("Test bfSearchTriggered()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BruteForceParser.bfSearchTriggered()"})
  void testBfSearchTriggered() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    BruteForceParser bruteForceParser =
        new BruteForceParser(cosDocument, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertFalse(bruteForceParser.bfSearchTriggered());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = bruteForceParser.getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L)));

    // Act
    Map<COSObjectKey, Long> actualBFCOSObjectOffsets = bruteForceParser.getBFCOSObjectOffsets();

    // Assert
    verify(streamCacheCreateFunction).create();
    assertTrue(actualBFCOSObjectOffsets.isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName(
      "Test getBFCOSObjectOffsets(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    BruteForceParser bruteForceParser =
        new BruteForceParser(cosDocument, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L)));

    // Act
    long actualBfSearchForXRefResult = bruteForceParser.bfSearchForXRef(1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1L, actualBfSearchForXRefResult);
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName(
      "Test bfSearchForXRef(long); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer()
      throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    BruteForceParser bruteForceParser =
        new BruteForceParser(cosDocument, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)} with input is
   *       {@link ByteArrayInputStream#ByteArrayInputStream(byte[])}.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName(
      "Test bfSearchForXRef(long); given RandomAccessReadBuffer(InputStream) with input is ByteArrayInputStream(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenRandomAccessReadBufferWithInputIsByteArrayInputStream()
      throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act
    long actualBfSearchForXRefResult = bruteForceParser.bfSearchForXRef(1L);

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals(-1L, actualBfSearchForXRefResult);
  }

  /**
   * Test {@link BruteForceParser#bfSearchForObjStreams(Map)}.
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  @DisplayName("Test bfSearchForObjStreams(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BruteForceParser.bfSearchForObjStreams(Map)"})
  void testBfSearchForObjStreams() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    RandomAccessReadBuffer source =
        new RandomAccessReadBuffer(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Test {@link BruteForceParser#bfSearchForObjStreams(Map)}.
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForObjStreams(Map)}
   */
  @Test
  @DisplayName("Test bfSearchForObjStreams(Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BruteForceParser.bfSearchForObjStreams(Map)"})
  void testBfSearchForObjStreams2() throws IOException {
    // Arrange
    StreamCacheCreateFunction streamCacheCreateFunction = mock(StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument cosDocument = new COSDocument(streamCacheCreateFunction);
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L)));

    // Act
    bruteForceParser.bfSearchForObjStreams(new HashMap<>());

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
