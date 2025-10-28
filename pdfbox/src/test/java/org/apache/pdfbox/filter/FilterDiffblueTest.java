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
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FilterDiffblueTest {
  /**
   * Method under test:
   * {@link Filter#decode(InputStream, OutputStream, COSDictionary, int, DecodeOptions)}
   */
  @Test
  void testDecode() throws IOException {
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
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  void testDecode2() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filterList = new ArrayList<>();
    COSDictionary parameters = new COSDictionary();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  void testDecode3() throws IOException {
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
    assertEquals(1, results.size());
    DecodeResult getResult = results.get(0);
    assertNull(getResult.getJPXSMask());
    assertNull(getResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertEquals(0L, actualDecodeResult.getPosition());
    assertEquals(8, actualDecodeResult.available());
    assertFalse(actualDecodeResult.isClosed());
    assertSame(parameters, getResult.getParameters());
  }

  /**
   * Method under test:
   * {@link Filter#decode(InputStream, List, COSDictionary, DecodeOptions, List)}
   */
  @Test
  void testDecode4() throws IOException {
    // Arrange
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ArrayList<Filter> filterList = new ArrayList<>();
    COSStream parameters = new COSStream();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> Filter.decode(encoded, filterList, parameters, DecodeOptions.DEFAULT, new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testEncode() throws IOException {
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
   * Method under test:
   * {@link Filter#encode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  void testEncode2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenReturn(1L);
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary(), 1);

    // Assert
    verify(input).transferTo(isA(OutputStream.class));
    assertEquals(0, encoded.toByteArray().length);
  }

  /**
   * Method under test: {@link Filter#getDecodeParams(COSDictionary, int)}
   */
  @Test
  void testGetDecodeParams() {
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
   * Method under test: {@link Filter#findImageReader(String, String)}
   */
  @Test
  void testFindImageReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(MissingImageReaderException.class, () -> Filter.findImageReader("Format Name", "An error occurred"));
  }

  /**
   * Method under test: {@link Filter#findRasterReader(String, String)}
   */
  @Test
  void testFindRasterReader() throws MissingImageReaderException {
    // Arrange, Act and Assert
    assertThrows(MissingImageReaderException.class, () -> Filter.findRasterReader("Format Name", "An error occurred"));
  }

  /**
   * Method under test: {@link Filter#getCompressionLevel()}
   */
  @Test
  void testGetCompressionLevel() {
    // Arrange, Act and Assert
    assertEquals(-1, Filter.getCompressionLevel());
  }
}
