package org.apache.pdfbox.filter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ASCII85InputStreamDiffblueTest {
  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given 'A'; when 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenA_whenA_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream is =
        new ByteArrayInputStream(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ASCII85InputStream(is)
                .read(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5));
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', 'd', -62, -114, -42, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf82()
      throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', 'd', -62, -114, -42, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf83()
      throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', 'd', -62, -114, -42, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', 'e', -105, -108, -114, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', -84, 'R', 'z', -67, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf82()
      throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', -84, 'R', 'z', -67, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given ByteArrayInputStream(byte[]) with 'XAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenByteArrayInputStreamWithXaxaxaxBytesIsUtf83()
      throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        4,
        new ASCII85InputStream(new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals(new byte[] {'A', 'X', -84, 'R', 'z', -67, 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given DataInputStream read() return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenDataInputStreamReadReturnMinusOne() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(-1);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = new ASCII85InputStream(is).read(data, 2, 3);

    // Assert
    verify(is).read();
    assertEquals(0, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one hundred
   *       twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given DataInputStream read() return one hundred twenty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenDataInputStreamReadReturnOneHundredTwentySix()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(126);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = new ASCII85InputStream(is).read(data, 2, 3);

    // Assert
    verify(is).read();
    assertEquals(0, actualReadResult);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one hundred
   *       twenty-two.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given DataInputStream read() return one hundred twenty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenDataInputStreamReadReturnOneHundredTwentyTwo()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(122);
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    int actualReadResult = new ASCII85InputStream(is).read(data, 2, 3);

    // Assert
    verify(is).read();
    assertEquals(3, actualReadResult);
    assertArrayEquals(new byte[] {'A', 'X', 0, 0, 0, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given DataInputStream read() return one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenDataInputStreamReadReturnOne_thenThrowIOException()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new ASCII85InputStream(is).read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    verify(is, atLeast(1)).read();
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; given DataInputStream read() throw IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_givenDataInputStreamReadThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> new ASCII85InputStream(is).read("AXAXAXAX".getBytes("UTF-8"), 2, 3));
    verify(is).read();
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then array of {@code byte} with {@code A} and {@code X} is {@code AXAXAXAX} Bytes is
   *       {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then array of byte with 'A' and 'X' is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenArrayOfByteWithAAndXIsAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        0,
        new ASCII85InputStream(new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenReturnOne() throws IOException {
    // Arrange
    byte[] data = new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'};

    // Act and Assert
    assertEquals(
        1,
        new ASCII85InputStream(new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8")))
            .read(data, 2, 5));
    assertArrayEquals("AXeXAXAX".getBytes("UTF-8"), data);
  }

  /**
   * Test {@link ASCII85InputStream#read(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'byte[]', 'int', 'int'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read(byte[], int, int)"})
  void testReadWithByteIntInt_thenReturnThree() throws IOException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    assertEquals(
        3,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .read(data, 2, 3));
    assertArrayEquals(new byte[] {'A', 'X', 'e', -105, -108, 'X', 'A', 'X'}, data);
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A~AXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'A~AXAXAX' Bytes is 'UTF-8'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnMinusOne()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        -1, new ASCII85InputStream(new ByteArrayInputStream("A~AXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        100,
        new ASCII85InputStream(new ByteArrayInputStream("A\nAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred2()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        100,
        new ASCII85InputStream(new ByteArrayInputStream("A\rAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return one hundred.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then return one hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenReturnOneHundred3()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        100, new ASCII85InputStream(new ByteArrayInputStream("A AXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with array of {@code
   *       byte} with {@code A} and minus one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with array of byte with 'A' and minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithArrayOfByteWithAAndMinusOne() throws IOException {
    // Arrange
    ByteArrayInputStream byteArrayInputStream =
        new ByteArrayInputStream(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    BufferedInputStream is = new BufferedInputStream(byteArrayInputStream);

    // Act and Assert
    assertEquals(-1, new ASCII85InputStream(is).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AX~XAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return one hundred one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given ByteArrayInputStream(byte[]) with 'AX~XAXAX' Bytes is 'UTF-8'; then return one hundred one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxXaxaxBytesIsUtf8_thenReturnOneHundredOne()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        101, new ASCII85InputStream(new ByteArrayInputStream("AX~XAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        101, new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return minus one.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given DataInputStream read() return minus one; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenDataInputStreamReadReturnMinusOne_thenReturnMinusOne() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(-1);

    // Act
    int actualReadResult = new ASCII85InputStream(is).read();

    // Assert
    verify(is).read();
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one hundred
   *       twenty-six.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream read() return one hundred twenty-six; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenDataInputStreamReadReturnOneHundredTwentySix_thenReturnMinusOne()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(126);

    // Act
    int actualReadResult = new ASCII85InputStream(is).read();

    // Assert
    verify(is).read();
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one hundred
   *       twenty-two.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream read() return one hundred twenty-two; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenDataInputStreamReadReturnOneHundredTwentyTwo_thenReturnZero()
      throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(122);

    // Act
    int actualReadResult = new ASCII85InputStream(is).read();

    // Assert
    verify(is).read();
    assertEquals(0, actualReadResult);
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} return one.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given DataInputStream read() return one; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenDataInputStreamReadReturnOne_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> new ASCII85InputStream(is).read());
    verify(is, atLeast(1)).read();
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given DataInputStream read() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenDataInputStreamReadThrowIOException_thenThrowIOException() throws IOException {
    // Arrange
    DataInputStream is = mock(DataInputStream.class);
    when(is.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new ASCII85InputStream(is).read());
    verify(is).read();
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Given {@code X}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); given 'X'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_givenX_thenThrowIOException() throws IOException {
    // Arrange
    ByteArrayInputStream is =
        new ByteArrayInputStream(new byte[] {Byte.MAX_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});

    // Act and Assert
    assertThrows(IOException.class, () -> new ASCII85InputStream(is).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        172,
        new ASCII85InputStream(new ByteArrayInputStream("\nXAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo2() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        172,
        new ASCII85InputStream(new ByteArrayInputStream("\rXAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#read()}.
   *
   * <ul>
   *   <li>Then return one hundred seventy-two.
   * </ul>
   *
   * <p>Method under test: {@link ASCII85InputStream#read()}
   */
  @Test
  @DisplayName("Test read(); then return one hundred seventy-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.read()"})
  void testRead_thenReturnOneHundredSeventyTwo3() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        172, new ASCII85InputStream(new ByteArrayInputStream(" XAXAXAX".getBytes("UTF-8"))).read());
  }

  /**
   * Test {@link ASCII85InputStream#markSupported()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#markSupported()}
   */
  @Test
  @DisplayName("Test markSupported()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ASCII85InputStream.markSupported()"})
  void testMarkSupported() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertFalse(
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))
            .markSupported());
  }

  /**
   * Test {@link ASCII85InputStream#skip(long)}.
   *
   * <p>Method under test: {@link ASCII85InputStream#skip(long)}
   */
  @Test
  @DisplayName("Test skip(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ASCII85InputStream.skip(long)"})
  void testSkip() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        0L,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).skip(42L));
  }

  /**
   * Test {@link ASCII85InputStream#available()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#available()}
   */
  @Test
  @DisplayName("Test available()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ASCII85InputStream.available()"})
  void testAvailable() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        0,
        new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).available());
  }

  /**
   * Test {@link ASCII85InputStream#reset()}.
   *
   * <p>Method under test: {@link ASCII85InputStream#reset()}
   */
  @Test
  @DisplayName("Test reset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ASCII85InputStream.reset()"})
  void testReset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new ASCII85InputStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).reset());
  }
}
