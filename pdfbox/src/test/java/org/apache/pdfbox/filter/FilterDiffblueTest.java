package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FilterDiffblueTest {
  /**
   * Test {@link Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}, {@code options}.
   *
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#decode(InputStream, OutputStream, COSDictionary, int,
   * DecodeOptions)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions) with 'encoded', 'decoded', 'parameters', 'index', 'options'; then return JPXSMask is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult Filter.decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)"
  })
  void testDecodeWithEncodedDecodedParametersIndexOptions_thenReturnJPXSMaskIsNull()
      throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult =
        ascii85Filter.decode(encoded, decoded, parameters, 1, DecodeOptions.DEFAULT);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(
        new byte[] {'e', -105, -108, -114, 'e', -105, -108, -114}, decoded.toByteArray());
  }

  /**
   * Test {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)} with {@code
   * encoded}, {@code filterList}, {@code parameters}, {@code options}, {@code results}.
   *
   * <p>Method under test: {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions,
   * List)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.io.RandomAccessRead Filter.decode(InputStream, List, COSDictionary, DecodeOptions, List)"
  })
  void testDecodeWithEncodedFilterListParametersOptionsResults() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filterList = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            Filter.decode(
                encoded, filterList, parameters, DecodeOptions.DEFAULT, new ArrayList<>()));
  }

  /**
   * Test {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * InputStream}, {@code OutputStream}, {@code COSDictionary}, {@code int}.
   *
   * <p>Method under test: {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary, int) with 'InputStream', 'OutputStream', 'COSDictionary', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Filter.encode(InputStream, OutputStream, COSDictionary, int)"})
  void testEncodeWithInputStreamOutputStreamCOSDictionaryInt() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary(), 1);

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "6!-ET6!-ET~>\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }

  /**
   * Test {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * InputStream}, {@code OutputStream}, {@code COSDictionary}, {@code int}.
   *
   * <p>Method under test: {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary, int) with 'InputStream', 'OutputStream', 'COSDictionary', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Filter.encode(InputStream, OutputStream, COSDictionary, int)"})
  void testEncodeWithInputStreamOutputStreamCOSDictionaryInt2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any()))
        .thenThrow(new MissingImageReaderException("An error occurred"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        MissingImageReaderException.class,
        () -> ascii85Filter.encode(input, encoded, new COSDictionary(), 1));
    verify(input).transferTo(isA(OutputStream.class));
  }

  /**
   * Test {@link Filter#getDecodeParams(COSDictionary, int)}.
   *
   * <ul>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Filter#getDecodeParams(COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test getDecodeParams(COSDictionary, int); then return UpdateState OriginDocumentState is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary Filter.getDecodeParams(COSDictionary, int)"})
  void testGetDecodeParams_thenReturnUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    // Act
    COSDictionary actualDecodeParams = ascii85Filter.getDecodeParams(new COSDictionary(), 1);

    // Assert
    COSUpdateState updateState = actualDecodeParams.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualDecodeParams.getKey());
    assertEquals(0, actualDecodeParams.size());
    COSIncrement toIncrementResult = actualDecodeParams.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(actualDecodeParams.isDirect());
    assertFalse(actualDecodeParams.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(actualDecodeParams.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link Filter#findImageReader(String, String)}.
   *
   * <p>Method under test: {@link Filter#findImageReader(String, String)}
   */
  @Test
  @DisplayName("Test findImageReader(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.imageio.ImageReader Filter.findImageReader(String, String)"})
  void testFindImageReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(
        MissingImageReaderException.class,
        () -> Filter.findImageReader("Format Name", "An error occurred"));
  }

  /**
   * Test {@link Filter#findRasterReader(String, String)}.
   *
   * <p>Method under test: {@link Filter#findRasterReader(String, String)}
   */
  @Test
  @DisplayName("Test findRasterReader(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"javax.imageio.ImageReader Filter.findRasterReader(String, String)"})
  void testFindRasterReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(
        MissingImageReaderException.class,
        () -> Filter.findRasterReader("Format Name", "An error occurred"));
  }

  /**
   * Test {@link Filter#getCompressionLevel()}.
   *
   * <p>Method under test: {@link Filter#getCompressionLevel()}
   */
  @Test
  @DisplayName("Test getCompressionLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Filter.getCompressionLevel()"})
  void testGetCompressionLevel() {
    // Arrange, Act and Assert
    assertEquals(-1, Filter.getCompressionLevel());
  }
}
