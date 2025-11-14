package org.apache.fontbox.afm;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AFMParserDiffblueTest {
  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(boolean) with 'boolean'; given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse(boolean)"})
  void testParseWithBoolean_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8"))).parse(true));
  }

  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(boolean) with 'boolean'; given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse(boolean)"})
  void testParseWithBoolean_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).parse(true));
  }

  /**
   * Test {@link AFMParser#parse(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse(boolean)}
   */
  @Test
  @DisplayName(
      "Test parse(boolean) with 'boolean'; given DataInputStream read() throw IOException(); then calls read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse(boolean)"})
  void testParseWithBoolean_givenDataInputStreamReadThrowIOException_thenCallsRead()
      throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new AFMParser(in).parse(true));
    verify(in).read();
  }

  /**
   * Test {@link AFMParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code A AXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given ByteArrayInputStream(byte[]) with 'A AXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse()"})
  void testParse_givenByteArrayInputStreamWithAAxaxaxBytesIsUtf8_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new AFMParser(new ByteArrayInputStream("A\tAXAXAX".getBytes("UTF-8"))).parse());
  }

  /**
   * Test {@link AFMParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName(
      "Test parse(); given ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse()"})
  void testParse_givenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenThrowIOException()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () -> new AFMParser(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))).parse());
  }

  /**
   * Test {@link AFMParser#parse()}.
   *
   * <ul>
   *   <li>Given {@link DataInputStream} {@link DataInputStream#read()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then calls {@link DataInputStream#read()}.
   * </ul>
   *
   * <p>Method under test: {@link AFMParser#parse()}
   */
  @Test
  @DisplayName("Test parse(); given DataInputStream read() throw IOException(); then calls read()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.afm.FontMetrics AFMParser.parse()"})
  void testParse_givenDataInputStreamReadThrowIOException_thenCallsRead() throws IOException {
    // Arrange
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new IOException());

    // Act and Assert
    assertThrows(IOException.class, () -> new AFMParser(in).parse());
    verify(in).read();
  }
}
