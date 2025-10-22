package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RunLengthDecodeFilterDiffblueTest {
  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"})
  void testDecodeWithEncodedDecodedParametersIndex() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"})
  void testDecodeWithEncodedDecodedParametersIndex2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(
        new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
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
    assertArrayEquals(new byte[]{}, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"})
  void testDecodeWithEncodedDecodedParametersIndex3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XXXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)} with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DecodeResult RunLengthDecodeFilter.decode(InputStream, OutputStream, COSDictionary, int)"})
  void testDecodeWithEncodedDecodedParametersIndex4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);
    COSDictionary parameters = new COSDictionary();

    // Act
    DecodeResult actualDecodeResult = runLengthDecodeFilter.decode(encoded, decoded, parameters, 1);

    // Assert
    assertNull(actualDecodeResult.getJPXSMask());
    assertNull(actualDecodeResult.getJPXColorSpace());
    assertEquals(-1, encoded.read(new byte[]{}));
    assertSame(parameters, actualDecodeResult.getParameters());
    byte[] expectedToByteArrayResult = "XAAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedToByteArrayResult, decoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{7, 'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters2() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{-1, 'X', 5, 'A', 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters3() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AAAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{-2, 'A', 4, 'X', 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters4() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXXXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{0, 'A', -2, 'X', 3, 'A', 'X', 'A', 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters5() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAAAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{3, 'A', 'X', 'A', 'X', -2, 'A', 0, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters6() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXXX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{4, 'A', 'X', 'A', 'X', 'A', -2, 'X', Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)} with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test: {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RunLengthDecodeFilter.encode(InputStream, OutputStream, COSDictionary)"})
  void testEncodeWithInputEncodedParameters7() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    assertEquals(-1, input.read(new byte[]{}));
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, encoded.toByteArray());
  }
}
