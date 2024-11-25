package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FilterDiffblueTest {
  /**
   * Test
   * {@link Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index},
   * {@code options}.
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions) with 'encoded', 'decoded', 'parameters', 'index', 'options'; then return JPXSMask is 'null'")
  void testDecodeWithEncodedDecodedParametersIndexOptions_thenReturnJPXSMaskIsNull() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1, DecodeOptions.DEFAULT);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[]{'e', -105, -108, -114, 'e', -105, -108, -114}, decoded.toByteArray());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filterList = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, new ArrayList<>()));
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults2() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(8, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults3() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filterList = new ArrayList<>();
    COSStream parameters = new COSStream();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, new ArrayList<>()));
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults4() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(1, results.size());
    assertEquals(0, actualDecodeResult.available());
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, results.get(0).getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults5() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCIIHexFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(4, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults6() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    COSStream parameters = new COSStream();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(8, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults7() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    filterList.add(new ASCII85Filter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, results);

    // Assert
    assertEquals(2, results.size());
    DecodeResult getResult = results.get(1);
    assertNull(getResult.getJPXSMask());
    assertNull(getResult.getJPXColorSpace());
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, getResult.getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults8() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AAAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCIIHexFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(4, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'")
  void testDecodeWithEncodedFilterListParametersOptionsResults9() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{});

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCIIHexFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(0, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <ul>
   *   <li>Given {@link CCITTFaxFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'; given CCITTFaxFilter (default constructor)")
  void testDecodeWithEncodedFilterListParametersOptionsResults_givenCCITTFaxFilter() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new CCITTFaxFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(0, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <ul>
   *   <li>Given {@link CCITTFaxFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'; given CCITTFaxFilter (default constructor)")
  void testDecodeWithEncodedFilterListParametersOptionsResults_givenCCITTFaxFilter2() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    filterList.add(new CCITTFaxFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, results);

    // Assert
    assertEquals(2, results.size());
    DecodeResult getResult = results.get(1);
    assertNull(getResult.getJPXSMask());
    assertNull(getResult.getJPXColorSpace());
    assertSame(parameters, getResult.getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <ul>
   *   <li>Given createDefault.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'; given createDefault")
  void testDecodeWithEncodedFilterListParametersOptionsResults_givenCreateDefault() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new ASCII85Filter());
    COSDictionary parameters = new COSDictionary();

    ArrayList<DecodeResult> results = new ArrayList<>();
    results.add(DecodeResult.createDefault());

    // Act
    Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, results);

    // Assert
    assertEquals(2, results.size());
    DecodeResult getResult = results.get(1);
    assertNull(getResult.getJPXSMask());
    assertNull(getResult.getJPXColorSpace());
    assertSame(parameters, getResult.getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <ul>
   *   <li>Given {@link CryptFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'; given CryptFilter (default constructor)")
  void testDecodeWithEncodedFilterListParametersOptionsResults_givenCryptFilter() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new CryptFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(8, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   * with {@code encoded}, {@code filterList}, {@code parameters},
   * {@code options}, {@code results}.
   * <ul>
   *   <li>Given {@link FlateFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  @DisplayName("Test decode(InputStream, List, COSDictionary, DecodeOptions, List) with 'encoded', 'filterList', 'parameters', 'options', 'results'; given FlateFilter (default constructor)")
  void testDecodeWithEncodedFilterListParametersOptionsResults_givenFlateFilter() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    ArrayList<Filter> filterList = new ArrayList<>();
    filterList.add(new FlateFilter());
    COSDictionary parameters = new COSDictionary();
    ArrayList<DecodeResult> results = new ArrayList<>();

    // Act
    RandomAccessRead actualDecodeResult = Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT,
        results);

    // Assert
    assertTrue(actualDecodeResult instanceof RandomAccessReadWriteBuffer);
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(1, results.size());
    assertEquals(0, actualDecodeResult.available());
    assertSame(parameters, results.get(0).getParameters());
  }

  /**
   * Test {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code InputStream}, {@code OutputStream}, {@code COSDictionary},
   * {@code int}.
   * <p>
   * Method under test:
   * {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary, int) with 'InputStream', 'OutputStream', 'COSDictionary', 'int'")
  void testEncodeWithInputStreamOutputStreamCOSDictionaryInt() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary(), 1);

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    byte[] expectedToByteArrayResult = "6!-ET6!-ET~>\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }

  /**
   * Test {@link Filter#getDecodeParams(COSDictionary, int)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Filter#getDecodeParams(COSDictionary, int)}
   */
  @Test
  @DisplayName("Test getDecodeParams(COSDictionary, int); when COSDictionary()")
  void testGetDecodeParams_whenCOSDictionary() {
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
   * Test {@link Filter#getDecodeParams(COSDictionary, int)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return UpdateState OriginDocumentState is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Filter#getDecodeParams(COSDictionary, int)}
   */
  @Test
  @DisplayName("Test getDecodeParams(COSDictionary, int); when COSStream(); then return UpdateState OriginDocumentState is 'null'")
  void testGetDecodeParams_whenCOSStream_thenReturnUpdateStateOriginDocumentStateIsNull() {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    // Act
    COSDictionary actualDecodeParams = ascii85Filter.getDecodeParams(new COSStream(), 1);

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
   * <p>
   * Method under test: {@link Filter#findImageReader(String, String)}
   */
  @Test
  @DisplayName("Test findImageReader(String, String)")
  void testFindImageReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(MissingImageReaderException.class, () -> Filter.findImageReader("Format Name", "An error occurred"));
  }

  /**
   * Test {@link Filter#findRasterReader(String, String)}.
   * <p>
   * Method under test: {@link Filter#findRasterReader(String, String)}
   */
  @Test
  @DisplayName("Test findRasterReader(String, String)")
  void testFindRasterReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(MissingImageReaderException.class, () -> Filter.findRasterReader("Format Name", "An error occurred"));
  }

  /**
   * Test {@link Filter#getCompressionLevel()}.
   * <p>
   * Method under test: {@link Filter#getCompressionLevel()}
   */
  @Test
  @DisplayName("Test getCompressionLevel()")
  void testGetCompressionLevel() {
    // Arrange, Act and Assert
    assertEquals(-1, Filter.getCompressionLevel());
  }
}
