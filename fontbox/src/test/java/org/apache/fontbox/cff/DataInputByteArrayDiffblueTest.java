package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataInputByteArrayDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DataInputByteArray#DataInputByteArray(byte[])}
   *   <li>{@link DataInputByteArray#getPosition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DataInputByteArray.<init>(byte[])",
    "int DataInputByteArray.getPosition()"
  })
  void testGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).getPosition());
  }

  /**
   * Test {@link DataInputByteArray#hasRemaining()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataInputByteArray.hasRemaining()"})
  void testHasRemaining_thenReturnFalse() throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertFalse(dataInputByteArray.hasRemaining());
  }

  /**
   * Test {@link DataInputByteArray#hasRemaining()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#hasRemaining()}
   */
  @Test
  @DisplayName("Test hasRemaining(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DataInputByteArray.hasRemaining()"})
  void testHasRemaining_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).hasRemaining());
  }

  /**
   * Test {@link DataInputByteArray#setPosition(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#setPosition(int)}
   */
  @Test
  @DisplayName(
      "Test setPosition(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataInputByteArray.setPosition(int)"})
  void testSetPosition_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte() throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertThrows(IOException.class, () -> dataInputByteArray.setPosition(1));
  }

  /**
   * Test {@link DataInputByteArray#setPosition(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#setPosition(int)}
   */
  @Test
  @DisplayName("Test setPosition(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DataInputByteArray.setPosition(int)"})
  void testSetPosition_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).setPosition(-1));
  }

  /**
   * Test {@link DataInputByteArray#readByte()}.
   *
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer is {@code
   *       AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readByte()}
   */
  @Test
  @DisplayName(
      "Test readByte(); given DataInputByteArray(byte[]) with buffer is 'AXAXAXAX' Bytes is 'UTF-8'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte DataInputByteArray.readByte()"})
  void testReadByte_givenDataInputByteArrayWithBufferIsAxaxaxaxBytesIsUtf8_thenReturnA()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals('A', new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readByte());
  }

  /**
   * Test {@link DataInputByteArray#readByte()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readByte()}
   */
  @Test
  @DisplayName("Test readByte(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte DataInputByteArray.readByte()"})
  void testReadByte_thenThrowIOException() throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertThrows(IOException.class, () -> dataInputByteArray.readByte());
  }

  /**
   * Test {@link DataInputByteArray#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.readUnsignedByte()"})
  void testReadUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readUnsignedByte());
  }

  /**
   * Test {@link DataInputByteArray#readUnsignedByte()}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readUnsignedByte()}
   */
  @Test
  @DisplayName("Test readUnsignedByte(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.readUnsignedByte()"})
  void testReadUnsignedByte_thenThrowIOException() throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertThrows(IOException.class, () -> dataInputByteArray.readUnsignedByte());
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName(
      "Test peekUnsignedByte(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte()
      throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertThrows(IOException.class, () -> dataInputByteArray.peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).peekUnsignedByte(2));
  }

  /**
   * Test {@link DataInputByteArray#peekUnsignedByte(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#peekUnsignedByte(int)}
   */
  @Test
  @DisplayName("Test peekUnsignedByte(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.peekUnsignedByte(int)"})
  void testPeekUnsignedByte_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).peekUnsignedByte(-1));
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   *
   * <ul>
   *   <li>Given {@link DataInputByteArray#DataInputByteArray(byte[])} with buffer is empty array of
   *       {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName(
      "Test readBytes(int); given DataInputByteArray(byte[]) with buffer is empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputByteArray.readBytes(int)"})
  void testReadBytes_givenDataInputByteArrayWithBufferIsEmptyArrayOfByte() throws IOException {
    // Arrange
    DataInputByteArray dataInputByteArray = new DataInputByteArray(new byte[] {});

    // Act and Assert
    assertThrows(IOException.class, () -> dataInputByteArray.readBytes(3));
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   *
   * <ul>
   *   <li>Then return {@code AXA} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); then return 'AXA' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputByteArray.readBytes(int)"})
  void testReadBytes_thenReturnAxaBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXA".getBytes("UTF-8"), new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readBytes(3));
  }

  /**
   * Test {@link DataInputByteArray#readBytes(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link DataInputByteArray#readBytes(int)}
   */
  @Test
  @DisplayName("Test readBytes(int); when minus one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] DataInputByteArray.readBytes(int)"})
  void testReadBytes_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).readBytes(-1));
  }

  /**
   * Test {@link DataInputByteArray#length()}.
   *
   * <p>Method under test: {@link DataInputByteArray#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int DataInputByteArray.length()"})
  void testLength() throws IOException {
    // Arrange, Act and Assert
    assertEquals(8, new DataInputByteArray("AXAXAXAX".getBytes("UTF-8")).length());
  }
}
