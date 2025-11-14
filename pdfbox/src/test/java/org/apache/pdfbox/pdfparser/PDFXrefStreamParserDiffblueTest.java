package org.apache.pdfbox.pdfparser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.NonSeekableRandomAccessReadInputStream;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFXrefStreamParserDiffblueTest {
  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   *
   * <p>Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFXrefStreamParser.<init>(COSStream)"})
  void testNewPDFXrefStreamParser() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 3L, 3L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   *
   * <p>Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName("Test new PDFXrefStreamParser(COSStream)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFXrefStreamParser.<init>(COSStream)"})
  void testNewPDFXrefStreamParser2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream stream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L), 3L, 1L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
  }

  /**
   * Test {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PDFXrefStreamParser#PDFXrefStreamParser(COSStream)}
   */
  @Test
  @DisplayName(
      "Test new PDFXrefStreamParser(COSStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFXrefStreamParser.<init>(COSStream)"})
  void testNewPDFXrefStreamParser_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    NonSeekableRandomAccessReadInputStream randomAccessRead =
        new NonSeekableRandomAccessReadInputStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    COSStream stream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 3L, 1L));

    // Act and Assert
    assertThrows(IOException.class, () -> new PDFXrefStreamParser(stream));
  }
}
