package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompressParametersDiffblueTest {
  /**
   * Test {@link CompressParameters#CompressParameters()}.
   * <p>
   * Method under test: {@link CompressParameters#CompressParameters()}
   */
  @Test
  @DisplayName("Test new CompressParameters()")
  void testNewCompressParameters() {
    // Arrange and Act
    CompressParameters actualCompressParameters = new CompressParameters();

    // Assert
    assertTrue(actualCompressParameters.isCompress());
    assertEquals(CompressParameters.DEFAULT_OBJECT_STREAM_SIZE, actualCompressParameters.getObjectStreamSize());
  }

  /**
   * Test {@link CompressParameters#CompressParameters(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressParameters#CompressParameters(int)}
   */
  @Test
  @DisplayName("Test new CompressParameters(int); when minus one; then throw IllegalArgumentException")
  void testNewCompressParameters_whenMinusOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CompressParameters(-1));
  }

  /**
   * Test {@link CompressParameters#CompressParameters(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return ObjectStreamSize is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressParameters#CompressParameters(int)}
   */
  @Test
  @DisplayName("Test new CompressParameters(int); when three; then return ObjectStreamSize is three")
  void testNewCompressParameters_whenThree_thenReturnObjectStreamSizeIsThree() {
    // Arrange and Act
    CompressParameters actualCompressParameters = new CompressParameters(3);

    // Assert
    assertEquals(3, actualCompressParameters.getObjectStreamSize());
    assertTrue(actualCompressParameters.isCompress());
  }

  /**
   * Test {@link CompressParameters#getObjectStreamSize()}.
   * <p>
   * Method under test: {@link CompressParameters#getObjectStreamSize()}
   */
  @Test
  @DisplayName("Test getObjectStreamSize()")
  void testGetObjectStreamSize() {
    // Arrange, Act and Assert
    assertEquals(CompressParameters.DEFAULT_OBJECT_STREAM_SIZE, (new CompressParameters()).getObjectStreamSize());
  }

  /**
   * Test {@link CompressParameters#isCompress()}.
   * <ul>
   *   <li>Given {@link CompressParameters#DEFAULT_COMPRESSION}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressParameters#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); given DEFAULT_COMPRESSION; then return 'true'")
  void testIsCompress_givenDefault_compression_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(CompressParameters.DEFAULT_COMPRESSION.isCompress());
  }

  /**
   * Test {@link CompressParameters#isCompress()}.
   * <ul>
   *   <li>Given {@link CompressParameters#NO_COMPRESSION}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CompressParameters#isCompress()}
   */
  @Test
  @DisplayName("Test isCompress(); given NO_COMPRESSION; then return 'false'")
  void testIsCompress_givenNo_compression_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(CompressParameters.NO_COMPRESSION.isCompress());
  }
}
