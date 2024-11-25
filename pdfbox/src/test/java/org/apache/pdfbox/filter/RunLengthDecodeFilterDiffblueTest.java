package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RunLengthDecodeFilterDiffblueTest {
  /**
   * Test
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then array length is six.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then array length is six")
  void testDecodeWithEncodedDecodedParametersIndex_thenArrayLengthIsSix() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    byte[] toByteArrayResult = decoded.toByteArray();
    assertEquals(6, toByteArrayResult.length);
    assertEquals('A', toByteArrayResult[2]);
    assertEquals('A', toByteArrayResult[4]);
    assertEquals('X', toByteArrayResult[3]);
    assertEquals('X', toByteArrayResult[5]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then return JPXSMask is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then return JPXSMask is 'null'")
  void testDecodeWithEncodedDecodedParametersIndex_thenReturnJPXSMaskIsNull() throws IOException {
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
    assertEquals(0, decoded.toByteArray().length);
    byte[] byteArray = new byte[7];
    assertEquals(7, encoded.read(byteArray));
    assertSame(parameters, actualDecodeResult.getParameters());
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then second element is {@code A}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then second element is 'A'")
  void testDecodeWithEncodedDecodedParametersIndex_thenSecondElementIsA() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    byte[] toByteArrayResult = decoded.toByteArray();
    assertEquals(7, toByteArrayResult.length);
    assertEquals('A', toByteArrayResult[1]);
    assertEquals('A', toByteArrayResult[3]);
    assertEquals('A', toByteArrayResult[5]);
    assertEquals('X', toByteArrayResult[2]);
    assertEquals('X', toByteArrayResult[4]);
    assertEquals('X', toByteArrayResult[6]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   * with {@code encoded}, {@code decoded}, {@code parameters}, {@code index}.
   * <ul>
   *   <li>Then second element is {@code X}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#decode(InputStream, OutputStream, COSDictionary, int)}
   */
  @Test
  @DisplayName("Test decode(InputStream, OutputStream, COSDictionary, int) with 'encoded', 'decoded', 'parameters', 'index'; then second element is 'X'")
  void testDecodeWithEncodedDecodedParametersIndex_thenSecondElementIsX() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream encoded = new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    ByteArrayOutputStream decoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.decode(encoded, decoded, new COSDictionary(), 1);

    // Assert
    byte[] toByteArrayResult = decoded.toByteArray();
    assertEquals(7, toByteArrayResult.length);
    assertEquals('A', toByteArrayResult[3]);
    assertEquals('A', toByteArrayResult[5]);
    assertEquals('X', toByteArrayResult[1]);
    assertEquals('X', toByteArrayResult[2]);
    assertEquals('X', toByteArrayResult[4]);
    assertEquals('X', toByteArrayResult[6]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'")
  void testEncodeWithInputEncodedParameters() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream(new byte[]{});
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert that nothing has changed
    assertArrayEquals(new byte[]{Byte.MIN_VALUE}, encoded.toByteArray());
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then first element is minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then first element is minus one")
  void testEncodeWithInputEncodedParameters_thenFirstElementIsMinusOne() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) -1, toByteArrayResult[0]);
    assertEquals(10, toByteArrayResult.length);
    assertEquals((byte) 5, toByteArrayResult[2]);
    assertEquals('A', toByteArrayResult[7]);
    assertEquals('X', toByteArrayResult[1]);
    assertEquals('X', toByteArrayResult[6]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then first element is minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then first element is minus two")
  void testEncodeWithInputEncodedParameters_thenFirstElementIsMinusTwo() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AAAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) -2, toByteArrayResult[0]);
    assertEquals((byte) 4, toByteArrayResult[2]);
    assertEquals(9, toByteArrayResult.length);
    assertEquals('A', toByteArrayResult[4]);
    assertEquals('X', toByteArrayResult[5]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then first element is seven.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then first element is seven")
  void testEncodeWithInputEncodedParameters_thenFirstElementIsSeven() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals(10, toByteArrayResult.length);
    assertEquals((byte) 7, toByteArrayResult[0]);
    assertEquals('A', toByteArrayResult[7]);
    assertEquals('X', toByteArrayResult[2]);
    assertEquals('X', toByteArrayResult[6]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then seventh element is minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then seventh element is minus two")
  void testEncodeWithInputEncodedParameters_thenSeventhElementIsMinusTwo() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAXXX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) -2, toByteArrayResult[6]);
    assertEquals((byte) 4, toByteArrayResult[0]);
    assertEquals(9, toByteArrayResult.length);
    assertEquals(Byte.MIN_VALUE, toByteArrayResult[8]);
    assertEquals('X', toByteArrayResult[7]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then sixth element is minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then sixth element is minus two")
  void testEncodeWithInputEncodedParameters_thenSixthElementIsMinusTwo() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXAXAAAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) -2, toByteArrayResult[5]);
    assertEquals((byte) 0, toByteArrayResult[7]);
    assertEquals(10, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[0]);
    assertEquals('A', toByteArrayResult[6]);
  }

  /**
   * Test
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   * with {@code input}, {@code encoded}, {@code parameters}.
   * <ul>
   *   <li>Then third element is minus two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RunLengthDecodeFilter#encode(InputStream, OutputStream, COSDictionary)}
   */
  @Test
  @DisplayName("Test encode(InputStream, OutputStream, COSDictionary) with 'input', 'encoded', 'parameters'; then third element is minus two")
  void testEncodeWithInputEncodedParameters_thenThirdElementIsMinusTwo() throws IOException {
    // Arrange
    RunLengthDecodeFilter runLengthDecodeFilter = new RunLengthDecodeFilter();
    ByteArrayInputStream input = new ByteArrayInputStream("AXXXAXAX".getBytes("UTF-8"));
    ByteArrayOutputStream encoded = new ByteArrayOutputStream(1);

    // Act
    runLengthDecodeFilter.encode(input, encoded, new COSDictionary());

    // Assert
    byte[] toByteArrayResult = encoded.toByteArray();
    assertEquals((byte) -2, toByteArrayResult[2]);
    assertEquals((byte) 0, toByteArrayResult[0]);
    assertEquals(10, toByteArrayResult.length);
    assertEquals((byte) 3, toByteArrayResult[4]);
    assertEquals('X', toByteArrayResult[3]);
  }
}
