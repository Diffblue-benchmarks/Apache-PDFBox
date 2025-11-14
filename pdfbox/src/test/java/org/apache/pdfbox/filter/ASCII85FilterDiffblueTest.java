package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doThrow;
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
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ASCII85FilterDiffblueTest {
  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

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
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
    assertArrayEquals(new byte[] {}, decoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[] {-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[] {-84, 'R', 'z', -67, -84, 'R', 'z', -67}, decoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex5() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[] {'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex6() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = ascii85Filter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals(new byte[] {'d', -62, -114, -42, 'd', -62, -114, -42}, decoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code
   * encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85Filter#decode(InputStream, OutputStream, COSDictionary,
   * int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult ASCII85Filter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    DataInputStream encoded = mock(DataInputStream.class);
    when(encoded.read()).thenThrow(new IOException());
    doThrow(new IOException()).when(encoded).close();
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> ascii85Filter.decode(encoded, decoded, new COSDictionary(), 1));
    verify(encoded).close();
    verify(encoded).read();
  }

  /**
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85Filter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    byte[] expectedToByteArrayResult = "6!-ET6!-ET~>\n".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, encoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85Filter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    ascii85Filter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {}, encoded.toByteArray());
  }

  /**
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85Filter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters_givenIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> ascii85Filter.encode(input, encoded, new COSDictionary()));
    verify(input).transferTo(isA(OutputStream.class));
  }

  /**
   * Test {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)} with {@code input},
   * {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85Filter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; when 'null'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85Filter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters_whenNull_thenThrowIOException() throws IOException {
    // Arrange
    ASCII85Filter ascii85Filter = new ASCII85Filter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.transferTo(Mockito.<OutputStream>any())).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> ascii85Filter.encode(input, null, new COSDictionary()));
    verify(input).transferTo(isA(OutputStream.class));
  }
}
