package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

class RunLengthDecodeFilterDiffblueTest {
  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream,
   * COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream,
   * COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

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
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream,
   * COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XXXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream,
   * COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded =
        new ByteArrayInputStream(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    int actualReadResult = encoded.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with
   * {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream,
   * COSDictionary, int)}
   */
  @Test
  @DisplayName(
      "Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"
  })
  void testDecodeWithEncodedDecodedParametersIndex_thenThrowIOException() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();

    DataInputStream encoded = mock(DataInputStream.class);
    when(encoded.read()).thenThrow(new IOException());
    ByteArrayOutputStream decoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> runLengthDecodeFilter.decode(encoded, decoded, new COSDictionary(), 1));
    verify(encoded).read();
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {7, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE},
        encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {-1, 'X', 5, 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE},
        encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AAAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {-2, 'A', 4, 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXXXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {0, 'A', -2, 'X', 3, 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters5() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAAAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {3, 'A', 'X', 'A', 'X', -2, 'A', 0, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters6() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXXX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(
        new byte[] {4, 'A', 'X', 'A', 'X', 'A', -2, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters7() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    int actualReadResult = input.read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertArrayEquals(new byte[] {Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code
   * input}, {@code encoded}, {@code parameters}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream,
   * COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters_givenIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();

    DataInputStream input = mock(DataInputStream.class);
    when(input.read()).thenThrow(new IOException());
    ByteArrayOutputStream encoded = new ByteArrayOutputStream();

    // Act and Assert
    assertThrows(
        IOException.class, () -> runLengthDecodeFilter.encode(input, encoded, new COSDictionary()));
    verify(input).read();
  }
}
