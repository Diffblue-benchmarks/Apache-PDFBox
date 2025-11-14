package org.apache.pdfbox.pdmodel.common.function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDFunctionType4DiffblueTest {
  /**
   * Test {@link PDFunctionType4#PDFunctionType4(COSBase)}.
   *
   * <p>Method under test: {@link PDFunctionType4#PDFunctionType4(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType4(COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionType4.<init>(COSBase)"})
  void testNewPDFunctionType4() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream functionStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    PDFunctionType4 actualPdFunctionType4 = new PDFunctionType4(functionStream);

    // Assert
    assertSame(functionStream, actualPdFunctionType4.getPDStream().getCOSObject());
    assertSame(functionStream, actualPdFunctionType4.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType4#PDFunctionType4(COSBase)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType4#PDFunctionType4(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType4(COSBase); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionType4.<init>(COSBase)"})
  void testNewPDFunctionType4_whenA() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream functionStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    PDFunctionType4 actualPdFunctionType4 = new PDFunctionType4(functionStream);

    // Assert
    assertSame(functionStream, actualPdFunctionType4.getPDStream().getCOSObject());
    assertSame(functionStream, actualPdFunctionType4.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType4#PDFunctionType4(COSBase)}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType4#PDFunctionType4(COSBase)}
   */
  @Test
  @DisplayName("Test new PDFunctionType4(COSBase); when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDFunctionType4.<init>(COSBase)"})
  void testNewPDFunctionType4_whenA2() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 0, -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream functionStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));

    // Act
    PDFunctionType4 actualPdFunctionType4 = new PDFunctionType4(functionStream);

    // Assert
    assertSame(functionStream, actualPdFunctionType4.getPDStream().getCOSObject());
    assertSame(functionStream, actualPdFunctionType4.getCOSObject());
  }

  /**
   * Test {@link PDFunctionType4#eval(float[])}.
   *
   * <ul>
   *   <li>When empty array of {@code float}.
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDFunctionType4#eval(float[])}
   */
  @Test
  @DisplayName("Test eval(float[]); when empty array of float; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDFunctionType4.eval(float[])"})
  void testEval_whenEmptyArrayOfFloat_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream functionStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));

    // Act
    float[] actualEvalResult = new PDFunctionType4(functionStream).eval(new float[] {});

    // Assert
    assertArrayEquals(new float[] {}, actualEvalResult, 0.0f);
  }
}
