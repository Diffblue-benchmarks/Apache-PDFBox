package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
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
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
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
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 0, 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
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
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets3() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer(0));

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
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
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets4() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    RandomAccessReadView source =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L);
    ByteArrayInputStream keyStore =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    COSParser cosParser = new COSParser(source, "iloveyou", keyStore, "ndo");

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
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
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
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
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <ul>
   *   <li>Given {@code %}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given '%'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets_givenPercentSign_thenReturnEmpty() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, '%', 1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <ul>
   *   <li>Given {@code %}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given '%'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets_givenPercentSign_thenReturnEmpty2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 0, '%'});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertTrue(bruteForceParser.getBFCOSObjectOffsets().isEmpty());
  }

  /**
   * Test {@link BruteForceParser#getBFCOSObjectOffsets()}.
   *
   * <ul>
   *   <li>Given {@code %}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#getBFCOSObjectOffsets()}
   */
  @Test
  @DisplayName("Test getBFCOSObjectOffsets(); given '%'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map BruteForceParser.getBFCOSObjectOffsets()"})
  void testGetBFCOSObjectOffsets_givenPercentSign_thenReturnEmpty3() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, '%', '%'});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

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
    COSDocument cosDocument = new COSDocument();
    BruteForceParser bruteForceParser =
        new BruteForceParser(cosDocument, new COSParser(new RandomAccessReadWriteBuffer()));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
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
  void testBfSearchForXRef2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L)));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
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
  void testBfSearchForXRef3() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 4096L)));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
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
  void testBfSearchForXRef4() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument, new COSParser(new RandomAccessReadView(randomAccessRead, 1L, 4096L)));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
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
  void testBfSearchForXRef5() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument(new COSParser(new RandomAccessReadWriteBuffer()));
    BruteForceParser bruteForceParser =
        new BruteForceParser(
            cosDocument,
            new COSParser(
                new RandomAccessReadView(
                    new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L),
                    -1L,
                    3L)));

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadBuffer#RandomAccessReadBuffer(InputStream)}.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName(
      "Test bfSearchForXRef(long); given COSParser(RandomAccessRead) with source is RandomAccessReadBuffer(InputStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenCOSParserWithSourceIsRandomAccessReadBuffer() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName(
      "Test bfSearchForXRef(long); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    COSParser cosParser = new COSParser(new RandomAccessReadWriteBuffer(0));

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@code x}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given 'x'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenX_thenReturnMinusOne() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'x', -1});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@code x}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given 'x'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenX_thenReturnMinusOne2() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', 'x'});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertEquals(-1L, bruteForceParser.bfSearchForXRef(1L));
  }

  /**
   * Test {@link BruteForceParser#bfSearchForXRef(long)}.
   *
   * <ul>
   *   <li>Given {@code x}.
   *   <li>Then return seven.
   * </ul>
   *
   * <p>Method under test: {@link BruteForceParser#bfSearchForXRef(long)}
   */
  @Test
  @DisplayName("Test bfSearchForXRef(long); given 'x'; then return seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BruteForceParser.bfSearchForXRef(long)"})
  void testBfSearchForXRef_givenX_thenReturnSeven() throws IOException {
    // Arrange
    COSDocument cosDocument = new COSDocument();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 0, 'x'});
    RandomAccessReadBuffer source = new RandomAccessReadBuffer(input);
    COSParser cosParser = new COSParser(source);

    BruteForceParser bruteForceParser = new BruteForceParser(cosDocument, cosParser);

    // Act and Assert
    assertEquals(7L, bruteForceParser.bfSearchForXRef(1L));
  }
}
