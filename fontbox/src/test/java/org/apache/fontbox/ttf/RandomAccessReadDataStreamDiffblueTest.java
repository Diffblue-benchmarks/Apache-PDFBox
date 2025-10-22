package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RandomAccessReadDataStreamDiffblueTest {
  /**
   * Test {@link RandomAccessReadDataStream#getCurrentPosition()}.
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#getCurrentPosition()}
   */
  @Test
  @DisplayName("Test getCurrentPosition()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadDataStream.getCurrentPosition()"})
  void testGetCurrentPosition() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).getCurrentPosition());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RandomAccessReadDataStream#close()}
   *   <li>{@link RandomAccessReadDataStream#getOriginalDataSize()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadDataStream.close()",
      "long RandomAccessReadDataStream.getOriginalDataSize()"})
  void testGettersAndSetters() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));

    // Act
    randomAccessReadDataStream.close();

    // Assert
    assertEquals(8L, randomAccessReadDataStream.getOriginalDataSize());
  }

  /**
   * Test {@link RandomAccessReadDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream(new byte[]{}));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(-1, randomAccessReadDataStream.read(b, 1, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadDataStream#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return three.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadDataStream.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnThree() throws IOException {
    // Arrange
    RandomAccessReadDataStream randomAccessReadDataStream = new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] b = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, randomAccessReadDataStream.read(b, 1, 3));
    assertArrayEquals("AAXAAXAX".getBytes("UTF-8"), b);
  }

  /**
   * Test {@link RandomAccessReadDataStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadDataStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange, Act and Assert
    assertEquals(65, (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link RandomAccessReadDataStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with empty array of byte; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int RandomAccessReadDataStream.read()"})
  void testRead_givenByteArrayInputStreamWithEmptyArrayOfByte_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).read());
  }

  /**
   * Test {@link RandomAccessReadDataStream#readLong()}.
   * <ul>
   *   <li>Then return {@code -72340168543109377}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '-72340168543109377'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadDataStream.readLong()"})
  void testReadLong_thenReturn72340168543109377() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-72340168543109377L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream(new byte[]{}))).readLong());
  }

  /**
   * Test {@link RandomAccessReadDataStream#readLong()}.
   * <ul>
   *   <li>Then return {@code 4708585257725083992}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#readLong()}
   */
  @Test
  @DisplayName("Test readLong(); then return '4708585257725083992'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long RandomAccessReadDataStream.readLong()"})
  void testReadLong_thenReturn4708585257725083992() throws IOException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).readLong());
  }

  /**
   * Test {@link RandomAccessReadDataStream#seek(long)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); when minus one; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RandomAccessReadDataStream.seek(long)"})
  void testSeek_whenMinusOne_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).seek(-1L));
  }

  /**
   * Test {@link RandomAccessReadDataStream#createSubView(long)}.
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#createSubView(long)}
   */
  @Test
  @DisplayName("Test createSubView(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RandomAccessRead RandomAccessReadDataStream.createSubView(long)"})
  void testCreateSubView() throws IOException {
    // Arrange and Act
    RandomAccessRead actualCreateSubViewResult = (new RandomAccessReadDataStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).createSubView(3L);

    // Assert
    assertTrue(actualCreateSubViewResult instanceof RandomAccessReadView);
    assertEquals(0L, actualCreateSubViewResult.getPosition());
    assertEquals(3, actualCreateSubViewResult.available());
    assertFalse(actualCreateSubViewResult.isClosed());
  }

  /**
   * Test {@link RandomAccessReadDataStream#getOriginalData()}.
   * <p>
   * Method under test: {@link RandomAccessReadDataStream#getOriginalData()}
   */
  @Test
  @DisplayName("Test getOriginalData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream RandomAccessReadDataStream.getOriginalData()"})
  void testGetOriginalData() throws IOException {
    // Arrange, Act and Assert
    byte[] byteArray = new byte[8];
    assertEquals(8,
        (new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).getOriginalData()
            .read(byteArray));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }
}
