package org.apache.pdfbox.pdfwriter.compress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CompressParametersDiffblueTest {
  /**
   * Method under test: {@link CompressParameters#getObjectStreamSize()}
   */
  @Test
  void testGetObjectStreamSize() {
    // Arrange, Act and Assert
    assertEquals(CompressParameters.DEFAULT_OBJECT_STREAM_SIZE, (new CompressParameters()).getObjectStreamSize());
  }

  /**
   * Method under test: {@link CompressParameters#isCompress()}
   */
  @Test
  void testIsCompress() {
    // Arrange, Act and Assert
    assertTrue(CompressParameters.DEFAULT_COMPRESSION.isCompress());
    assertFalse(CompressParameters.NO_COMPRESSION.isCompress());
  }

  /**
   * Method under test: {@link CompressParameters#CompressParameters()}
   */
  @Test
  void testNewCompressParameters() {
    // Arrange and Act
    CompressParameters actualCompressParameters = new CompressParameters();

    // Assert
    assertTrue(actualCompressParameters.isCompress());
    assertEquals(CompressParameters.DEFAULT_OBJECT_STREAM_SIZE, actualCompressParameters.getObjectStreamSize());
  }

  /**
   * Method under test: {@link CompressParameters#CompressParameters(int)}
   */
  @Test
  void testNewCompressParameters2() {
    // Arrange and Act
    CompressParameters actualCompressParameters = new CompressParameters(3);

    // Assert
    assertEquals(3, actualCompressParameters.getObjectStreamSize());
    assertTrue(actualCompressParameters.isCompress());
  }

  /**
   * Method under test: {@link CompressParameters#CompressParameters(int)}
   */
  @Test
  void testNewCompressParameters3() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new CompressParameters(-1));
  }
}
