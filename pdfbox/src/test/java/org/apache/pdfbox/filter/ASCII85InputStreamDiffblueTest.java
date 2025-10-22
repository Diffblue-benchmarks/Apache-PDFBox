package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCII85InputStreamDiffblueTest {
  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', 'd', -62, -114, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf82() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', 'd', -62, -114, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf83() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', 'd', -62, -114, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A~AXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A~AXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf84() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithMax_valueAndX() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertThrows(IOException.class, () -> ascii85InputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithMinusOneAndX() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with three and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with array of byte with three and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithArrayOfByteWithThreeAndX() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{3, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));

    // Act and Assert
    assertThrows(IOException.class, () -> ascii85InputStream.read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', 'e', -105, -108, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', -84, 'R', 'z', 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf82() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', -84, 'R', 'z', 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf83() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', -84, 'R', 'z', 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code ~XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with '~XAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf84() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("~XAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(0, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code zXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'zXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithZXAXAXAXBytesIsUtf8() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("zXAXAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(3, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals(new byte[]{'A', 'X', 0, 0, 0, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenReturnOne() throws IOException {
    // Arrange
    ASCII85InputStream ascii85InputStream = new ASCII85InputStream(
        new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8")));
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(1, ascii85InputStream.read(data, 2, 3));
    assertArrayEquals("AXeXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A~AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'A~AXAXAX' Bytes is 'UTF-8'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new ASCII85InputStream(new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred() throws IOException {
    // Arrange, Act and Assert
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one hundred.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred3() throws IOException {
    // Arrange, Act and Assert
    assertEquals(100, (new ASCII85InputStream(new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with {@link Byte#MAX_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with MAX_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithMax_valueAndX() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new ASCII85InputStream(
        new ByteArrayInputStream(new byte[]{Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with minus one and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with minus one and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithMinusOneAndX() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1,
        (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{-1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithZeroAndX() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ASCII85InputStream(new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'})))
            .read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AX~XAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return one hundred one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AX~XAXAX' Bytes is 'UTF-8'; then return one hundred one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxXaxaxBytesIsUtf8_thenReturnOneHundredOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(101, (new ASCII85InputStream(new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertEquals(101, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code ~XAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with '~XAXAXAX' Bytes is 'UTF-8'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8_thenReturnMinusOne() throws IOException {
    // Arrange, Act and Assert
    assertEquals(-1, (new ASCII85InputStream(new ByteArrayInputStream("~XAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code zXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'zXAXAXAX' Bytes is 'UTF-8'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithZXAXAXAXBytesIsUtf8_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0, (new ASCII85InputStream(new ByteArrayInputStream("zXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Then return one hundred seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Then return one hundred seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   * <ul>
   *   <li>Then return one hundred seventy-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo3() throws IOException {
    // Arrange, Act and Assert
    assertEquals(172, (new ASCII85InputStream(new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")))).read());
  }

  /**
   * Test {@link ASCII85InputStream#markSupported()}.
   * <p>
   * Method under test: {@link ASCII85InputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ASCII85InputStream.markSupported()"})
  void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse((new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).markSupported());
  }

  /**
   * Test {@link ASCII85InputStream#skip(long)}.
   * <p>
   * Method under test: {@link ASCII85InputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ASCII85InputStream.skip(long)"})
  void testSkip() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0L, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).skip(42L));
  }

  /**
   * Test {@link ASCII85InputStream#available()}.
   * <p>
   * Method under test: {@link ASCII85InputStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ASCII85InputStream.available()"})
  void testAvailable() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(0, (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).available());
  }

  /**
   * Test {@link ASCII85InputStream#reset()}.
   * <p>
   * Method under test: {@link ASCII85InputStream#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ASCII85InputStream.reset()"})
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))).reset());
  }
}
