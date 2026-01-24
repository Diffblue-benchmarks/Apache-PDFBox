package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CCITTFaxFilterDiffblueTest {
  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {-64, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {'A', 'X', 0, 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex5() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {'A', 'X', 'A', 'X', 0, 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex6() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {0, 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex7() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {'A', 'X', 0, 'X', 'A', 'X', 0, 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ccittFaxFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
  }

  /**
   * Test {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxFilter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult CCITTFaxFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> ccittFaxFilter.decode(encoded, decoded, new COSDictionary(), 1));
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 2, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 0, 2, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 31, -121, -2, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream5() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 2, 1L, false);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream6() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 3, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream7() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 4, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, '@', Byte.MIN_VALUE, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream8() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 7, 2, 1L, false);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 16, 6, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream9() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 1, 3, 1L, false);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream10() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();

    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 65, 2, 1L, true);
    decoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {-2, 0, 0, 0, 0, 0, 0, 31}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream11() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 7, 4, 1L, false);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 2, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName("Test readFromDecoderStream(CCITTFaxDecoderStream, byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream12() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(stream, 2, 4, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, '@', Byte.MIN_VALUE, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test readFromDecoderStream(CCITTFaxDecoderStream, byte[]); given 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream_givenAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();

    CCITTFaxDecoderStream decoderStream =
        new CCITTFaxDecoderStream(
            new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), 2, 3, 1L, true);
    decoderStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <ul>
   *   <li>Then {@code AXAXAXAX} Bytes is {@code UTF-8} is array of {@code byte} with space and
   *       space.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test readFromDecoderStream(CCITTFaxDecoderStream, byte[]); then 'AXAXAXAX' Bytes is 'UTF-8' is array of byte with space and space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream_thenAxaxaxaxBytesIsUtf8IsArrayOfByteWithSpaceAndSpace()
      throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(stream, 3, 4, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {' ', ' ', '`', -32, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream, byte[])}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte}
   *       with one and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link CCITTFaxFilter#readFromDecoderStream(CCITTFaxDecoderStream,
   * byte[])}
   */
  @Test
  @DisplayName(
      "Test readFromDecoderStream(CCITTFaxDecoderStream, byte[]); when ByteArrayInputStream(byte[]) with array of byte with one and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.readFromDecoderStream(CCITTFaxDecoderStream, byte[])"})
  void testReadFromDecoderStream_whenByteArrayInputStreamWithArrayOfByteWithOneAndX()
      throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream stream =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    CCITTFaxDecoderStream decoderStream = new CCITTFaxDecoderStream(stream, 1, 2, 1L, true);
    byte[] result = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ccittFaxFilter.readFromDecoderStream(decoderStream, result);

    // Assert
    assertArrayEquals(new byte[] {0, 0, 0, 0, 0, 0, 0, 0}, result);
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {Byte.MIN_VALUE, '\b', 0, Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {'P', 1, 0, 16, Byte.MAX_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters3() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(1);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert that nothing has changed
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {}, encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters4() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'#', -82, 'G', -8, -14, '?', -57, -111, -2, '0', 1, 0, 16, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters5() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'&', -93, 'e', 14, 23, 30, 'G', -8, -14, '?', -58, 0, ' ', 2, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters6() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(8);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {
          '&', -94, -78, -121, 5, -59, 'r', '>', -15, '\\', -113, -68, 'W', '#', -20, 0, '@', 4
        },
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters7() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 7, 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'#', -88, -123, '#', -96, -14, '?', -57, -111, -2, '0', 1, 0, 16, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters8() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'#', -86, '#', '5', 'e', 'f', 'G', -8, -14, '?', -58, 0, ' ', 2, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters9() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 'X', 1, 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(7);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {'#', -82, 'G', -30, '2', ':', '#', -4, 'y', 31, -29, 0, 16, 1, -56},
        encoded.toByteArray());
  }

  /**
   * Test {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link CCITTFaxFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CCITTFaxFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters10() throws IOException {
    // Arrange
    CCITTFaxFilter ccittFaxFilter = new CCITTFaxFilter();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {-1, 'X', -1, 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    COSDictionary parameters = mock(COSDictionary.class);
    when(parameters.getInt(Mockito.<COSName>any())).thenReturn(8);

    // Act
    ccittFaxFilter.encode(input, encoded, parameters);

    // Assert
    verify(parameters, atLeast(1)).getInt(Mockito.<COSName>any());
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {
          '&',
          -94,
          -78,
          -121,
          5,
          'B',
          '\r',
          -108,
          '8',
          '.',
          '+',
          -111,
          -9,
          -118,
          -28,
          '}',
          Byte.MIN_VALUE,
          '\b',
          0,
          Byte.MIN_VALUE
        },
        encoded.toByteArray());
  }
}
