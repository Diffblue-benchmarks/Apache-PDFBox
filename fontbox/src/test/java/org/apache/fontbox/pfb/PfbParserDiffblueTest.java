package org.apache.fontbox.pfb;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PfbParserDiffblueTest {
  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MIN_VALUE} and one.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(InputStream); given array of byte with MIN_VALUE and one; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_givenArrayOfByteWithMin_valueAndOne_thenThrowEOFException()
      throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes())
        .thenReturn(
            new byte[] {
              Byte.MIN_VALUE,
              1,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X'
            });

    // Act and Assert
    assertThrows(EOFException.class, () -> new PfbParser(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MIN_VALUE} and two.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); given array of byte with MIN_VALUE and two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_givenArrayOfByteWithMin_valueAndTwo() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes())
        .thenReturn(
            new byte[] {
              Byte.MIN_VALUE,
              2,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X'
            });

    // Act and Assert
    assertThrows(EOFException.class, () -> new PfbParser(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Given array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); given array of byte with MIN_VALUE and 'X'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_givenArrayOfByteWithMin_valueAndX() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes())
        .thenReturn(
            new byte[] {
              Byte.MIN_VALUE,
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X'
            });

    // Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAXAXAXAXAXAXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); given 'AXAXAXAXAXAXAXAXAXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_givenAxaxaxaxaxaxaxaxaxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes()).thenReturn("AXAXAXAXAXAXAXAXAXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); given IOException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_givenIOException() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new PfbParser(in));
    verify(in).readAllBytes();
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>Then return InputStream read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName("Test new PfbParser(InputStream); then return InputStream read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_thenReturnInputStreamReadIsMinusOne() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.readAllBytes())
        .thenReturn(
            new byte[] {
              Byte.MIN_VALUE,
              3,
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X',
              'A',
              'X'
            });

    // Act
    PfbParser actualPfbParser = new PfbParser(in);

    // Assert
    verify(in).readAllBytes();
    int actualReadResult = actualPfbParser.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, actualPfbParser.size());
    assertArrayEquals(new byte[] {}, actualPfbParser.getPfbdata());
    assertArrayEquals(new byte[] {}, actualPfbParser.getSegment1());
    assertArrayEquals(new byte[] {}, actualPfbParser.getSegment2());
    assertArrayEquals(new int[] {0, 0, 0}, actualPfbParser.getLengths());
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   *
   * <ul>
   *   <li>Then return InputStream read is minus one.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName("Test new PfbParser(byte[]); then return InputStream read is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(byte[])"})
  void testNewPfbParser_thenReturnInputStreamReadIsMinusOne2() throws IOException {
    // Arrange and Act
    PfbParser actualPfbParser =
        new PfbParser(
            new byte[] {
              Byte.MIN_VALUE,
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3,
              'A',
              3
            });

    // Assert
    int actualReadResult = actualPfbParser.getInputStream().read(new byte[] {});
    assertEquals(-1, actualReadResult);
    assertEquals(0, actualPfbParser.size());
    assertArrayEquals(new byte[] {}, actualPfbParser.getPfbdata());
    assertArrayEquals(new byte[] {}, actualPfbParser.getSegment1());
    assertArrayEquals(new byte[] {}, actualPfbParser.getSegment2());
    assertArrayEquals(new int[] {0, 0, 0}, actualPfbParser.getLengths());
  }

  /**
   * Test {@link PfbParser#PfbParser(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(String)}
   */
  @Test
  @DisplayName("Test new PfbParser(String); when '42'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(String)"})
  void testNewPfbParser_when42_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser("42"));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and three.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(byte[]); when array of byte with 'A' and three; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(byte[])"})
  void testNewPfbParser_whenArrayOfByteWithAAndThree_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PfbParser(
                new byte[] {
                  'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3, 'A', 3,
                  'A', 3, 'A', 3
                }));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code A}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(byte[]); when array of byte with MIN_VALUE and 'A'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(byte[])"})
  void testNewPfbParser_whenArrayOfByteWithMin_valueAndA_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PfbParser(
                new byte[] {
                  Byte.MIN_VALUE,
                  'A',
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3
                }));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   *
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and one.
   *   <li>Then throw {@link EOFException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(byte[]); when array of byte with MIN_VALUE and one; then throw EOFException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(byte[])"})
  void testNewPfbParser_whenArrayOfByteWithMin_valueAndOne_thenThrowEOFException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        EOFException.class,
        () ->
            new PfbParser(
                new byte[] {
                  Byte.MIN_VALUE,
                  1,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3,
                  'A',
                  3
                }));
  }

  /**
   * Test {@link PfbParser#PfbParser(byte[])}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(byte[])}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(byte[])"})
  void testNewPfbParser_whenAxaxaxaxBytesIsUtf8_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PfbParser("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link PfbParser#PfbParser(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link PfbParser#PfbParser(InputStream)}
   */
  @Test
  @DisplayName(
      "Test new PfbParser(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PfbParser.<init>(InputStream)"})
  void testNewPfbParser_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new PfbParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
  }
}
