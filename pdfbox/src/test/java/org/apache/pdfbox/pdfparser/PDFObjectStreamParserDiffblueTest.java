package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDFObjectStreamParserDiffblueTest {
  /**
   * Test {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream,
   * COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFObjectStreamParser(COSStream, COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFObjectStreamParser.<init>(COSStream, COSDocument)"})
  void testNewPDFObjectStreamParser() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFObjectStreamParser(stream, new COSDocument()));
  }

  /**
   * Test {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream,
   * COSDocument)}
   */
  @Test
  @DisplayName("Test new PDFObjectStreamParser(COSStream, COSDocument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFObjectStreamParser.<init>(COSStream, COSDocument)"})
  void testNewPDFObjectStreamParser2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 1L, 1L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFObjectStreamParser(stream, new COSDocument()));
  }

  /**
   * Test {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream, COSDocument)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#PDFObjectStreamParser(COSStream,
   * COSDocument)}
   */
  @Test
  @DisplayName(
      "Test new PDFObjectStreamParser(COSStream, COSDocument); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFObjectStreamParser.<init>(COSStream, COSDocument)"})
  void testNewPDFObjectStreamParser_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 1L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFObjectStreamParser(stream, new COSDocument()));
  }

  /**
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName("Test parseObject(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFObjectStreamParser.parseObject(long)"})
  void testParseObject() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(new RandomAccessReadWriteBuffer());
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getInt(COSName)} return zero.
   *   <li>Then calls {@link RandomAccessRead#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName(
      "Test parseObject(long); given COSStream getInt(COSName) return zero; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFObjectStreamParser.parseObject(long)"})
  void testParseObject_givenCOSStreamGetIntReturnZero_thenCallsClose() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();

    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead).getPosition();
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
  }

  /**
   * Test {@link PDFObjectStreamParser#parseObject(long)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()} return one.
   *   <li>Then calls {@link RandomAccessRead#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseObject(long)}
   */
  @Test
  @DisplayName(
      "Test parseObject(long); given RandomAccessRead getPosition() return one; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDFObjectStreamParser.parseObject(long)"})
  void testParseObject_givenRandomAccessReadGetPositionReturnOne_thenCallsClose()
      throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();

    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    COSBase actualParseObjectResult = pdfObjectStreamParser.parseObject(1L);

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    assertNull(actualParseObjectResult);
    assertNull(pdfObjectStreamParser.document);
  }

  /**
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.parseAllObjects()"})
  void testParseAllObjects() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(new RandomAccessReadWriteBuffer());
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult =
        pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName("Test parseAllObjects()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.parseAllObjects()"})
  void testParseAllObjects2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    when(stream.createView()).thenReturn(new RandomAccessReadBuffer(input));
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult =
        pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getInt(COSName)} return zero.
   *   <li>Then calls {@link RandomAccessRead#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName(
      "Test parseAllObjects(); given COSStream getInt(COSName) return zero; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.parseAllObjects()"})
  void testParseAllObjects_givenCOSStreamGetIntReturnZero_thenCallsClose() throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();

    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult =
        pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
  }

  /**
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()} return one.
   *   <li>Then calls {@link RandomAccessRead#close()}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName(
      "Test parseAllObjects(); given RandomAccessRead getPosition() return one; then calls close()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.parseAllObjects()"})
  void testParseAllObjects_givenRandomAccessReadGetPositionReturnOne_thenCallsClose()
      throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(1L);
    doNothing().when(randomAccessRead).close();

    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult =
        pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
  }

  /**
   * Test {@link PDFObjectStreamParser#parseAllObjects()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessRead} {@link RandomAccessRead#getPosition()} return zero.
   *   <li>Then calls {@link RandomAccessRead#skip(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#parseAllObjects()}
   */
  @Test
  @DisplayName(
      "Test parseAllObjects(); given RandomAccessRead getPosition() return zero; then calls skip(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.parseAllObjects()"})
  void testParseAllObjects_givenRandomAccessReadGetPositionReturnZero_thenCallsSkip()
      throws IOException {
    // Arrange
    RandomAccessRead randomAccessRead = mock(RandomAccessRead.class);
    when(randomAccessRead.getPosition()).thenReturn(0L);
    doNothing().when(randomAccessRead).close();
    doNothing().when(randomAccessRead).skip(anyInt());

    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(randomAccessRead);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<COSObjectKey, COSBase> actualParseAllObjectsResult =
        pdfObjectStreamParser.parseAllObjects();

    // Assert
    verify(randomAccessRead).close();
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    verify(randomAccessRead, atLeast(1)).getPosition();
    verify(randomAccessRead).skip(1);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualParseAllObjectsResult.isEmpty());
  }

  /**
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.readObjectNumbers()"})
  void testReadObjectNumbers() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    when(stream.createView()).thenReturn(new RandomAccessReadWriteBuffer());
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.readObjectNumbers()"})
  void testReadObjectNumbers2() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    when(stream.createView()).thenReturn(new NonSeekableRandomAccessReadInputStream(inputStream));
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof NonSeekableRandomAccessReadInputStream);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.readObjectNumbers()"})
  void testReadObjectNumbers3() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L, true);
    when(stream.createView()).thenReturn(randomAccessReadView);
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadView);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   *
   * <p>Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.readObjectNumbers()"})
  void testReadObjectNumbers4() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(1);
    ByteArrayInputStream inputStream =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(inputStream);
    when(stream.createView()).thenReturn(new RandomAccessReadView(randomAccessRead, 1L, 3L));
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead2 = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead2 instanceof RandomAccessReadView);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead2.isClosed());
  }

  /**
   * Test {@link PDFObjectStreamParser#readObjectNumbers()}.
   *
   * <ul>
   *   <li>Given {@link COSStream} {@link COSStream#getInt(COSName)} return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDFObjectStreamParser#readObjectNumbers()}
   */
  @Test
  @DisplayName("Test readObjectNumbers(); given COSStream getInt(COSName) return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map PDFObjectStreamParser.readObjectNumbers()"})
  void testReadObjectNumbers_givenCOSStreamGetIntReturnZero() throws IOException {
    // Arrange
    COSStream stream = mock(COSStream.class);
    when(stream.getInt(Mockito.<COSName>any())).thenReturn(0);
    when(stream.createView()).thenReturn(new RandomAccessReadWriteBuffer());
    PDFObjectStreamParser pdfObjectStreamParser =
        new PDFObjectStreamParser(stream, new COSDocument());

    // Act
    Map<Long, Integer> actualReadObjectNumbersResult = pdfObjectStreamParser.readObjectNumbers();

    // Assert
    verify(stream, atLeast(1)).getInt(Mockito.<COSName>any());
    verify(stream).createView();
    RandomAccessRead randomAccessRead = pdfObjectStreamParser.source;
    assertTrue(randomAccessRead instanceof RandomAccessReadWriteBuffer);
    assertNull(pdfObjectStreamParser.document);
    assertTrue(actualReadObjectNumbersResult.isEmpty());
    assertTrue(randomAccessRead.isClosed());
  }
}
