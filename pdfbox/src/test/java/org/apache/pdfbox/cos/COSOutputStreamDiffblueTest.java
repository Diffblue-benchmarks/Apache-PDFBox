package org.apache.pdfbox.cos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.filter.Filter;
import org.apache.pdfbox.filter.JPXFilter;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class COSOutputStreamDiffblueTest {
  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private COSOutputStream cOSOutputStream;

  @Mock private List<Filter> list;

  @Mock private OutputStream outputStream;

  @Mock private RandomAccessStreamCache randomAccessStreamCache;

  /**
   * Test {@link COSOutputStream#COSOutputStream(List, COSDictionary, OutputStream,
   * RandomAccessStreamCache)}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessStreamCache}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#COSOutputStream(List, COSDictionary, OutputStream,
   * RandomAccessStreamCache)}
   */
  @Test
  @DisplayName(
      "Test new COSOutputStream(List, COSDictionary, OutputStream, RandomAccessStreamCache); given RandomAccessStreamCache; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void COSOutputStream.<init>(List, COSDictionary, OutputStream, RandomAccessStreamCache)"
  })
  void testNewCOSOutputStream_givenRandomAccessStreamCache_thenDoesNotThrow() throws IOException {
    // Arrange
    ArrayList<Filter> filters = new ArrayList<>();

    // Act
    assertDoesNotThrow(
        () ->
            new COSOutputStream(
                filters, cOSDictionary, new ByteArrayOutputStream(), randomAccessStreamCache));
  }

  /**
   * Test {@link COSOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} does nothing.
   *   <li>When one.
   *   <li>Then calls {@link OutputStream#write(int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int, int) with 'byte[]', 'int', 'int'; given OutputStream write(int) does nothing; when one; then calls write(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[], int, int)"})
  void testWriteWithByteIntInt_givenOutputStreamWriteDoesNothing_whenOne_thenCallsWrite()
      throws IOException {
    // Arrange
    doNothing().when(outputStream).write(ArgumentMatchers.anyInt());

    // Act
    cOSOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    verify(outputStream, atLeast(1)).write(ArgumentMatchers.anyInt());
  }

  /**
   * Test {@link COSOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[], int, int)"})
  void testWriteWithByteIntInt_thenThrowIOException() throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(ArgumentMatchers.anyInt());

    // Act and Assert
    assertThrows(
        IOException.class, () -> cOSOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 3));
    verify(outputStream).write(88);
  }

  /**
   * Test {@link COSOutputStream#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test write(byte[], int, int) with 'byte[]', 'int', 'int'; when zero; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[], int, int)"})
  void testWriteWithByteIntInt_whenZero_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> cOSOutputStream.write("AXAXAXAX".getBytes("UTF-8"), 1, 0));
  }

  /**
   * Test {@link COSOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} does nothing.
   *   <li>Then calls {@link OutputStream#write(int)}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[])}
   */
  @Test
  @DisplayName(
      "Test write(byte[]) with 'byte[]'; given OutputStream write(int) does nothing; then calls write(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[])"})
  void testWriteWithByte_givenOutputStreamWriteDoesNothing_thenCallsWrite() throws IOException {
    // Arrange
    doNothing().when(outputStream).write(ArgumentMatchers.anyInt());

    // Act
    cOSOutputStream.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(outputStream, atLeast(1)).write(ArgumentMatchers.anyInt());
  }

  /**
   * Test {@link COSOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[])}
   */
  @Test
  @DisplayName(
      "Test write(byte[]) with 'byte[]'; given OutputStream write(int) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[])"})
  void testWriteWithByte_givenOutputStreamWriteThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(ArgumentMatchers.anyInt());

    // Act and Assert
    assertThrows(IOException.class, () -> cOSOutputStream.write("AXAXAXAX".getBytes("UTF-8")));
    verify(outputStream).write(65);
  }

  /**
   * Test {@link COSOutputStream#write(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'; when empty array of byte; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(byte[])"})
  void testWriteWithByte_whenEmptyArrayOfByte_thenDoesNotThrow() throws IOException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> cOSOutputStream.write(new byte[] {}));
  }

  /**
   * Test {@link COSOutputStream#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(int)}
   */
  @Test
  @DisplayName("Test write(int) with 'int'; given OutputStream write(int) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(int)"})
  void testWriteWithInt_givenOutputStreamWriteDoesNothing() throws IOException {
    // Arrange
    doNothing().when(outputStream).write(ArgumentMatchers.anyInt());

    // Act
    cOSOutputStream.write(19088743);

    // Assert
    verify(outputStream).write(19088743);
  }

  /**
   * Test {@link COSOutputStream#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#write(int)} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#write(int)}
   */
  @Test
  @DisplayName(
      "Test write(int) with 'int'; given OutputStream write(int) throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.write(int)"})
  void testWriteWithInt_givenOutputStreamWriteThrowIOException_thenThrowIOException()
      throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).write(ArgumentMatchers.anyInt());

    // Act and Assert
    assertThrows(IOException.class, () -> cOSOutputStream.write(19088743));
    verify(outputStream).write(19088743);
  }

  /**
   * Test {@link COSOutputStream#flush()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#flush()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#flush()}
   */
  @Test
  @DisplayName("Test flush(); given OutputStream flush() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.flush()"})
  void testFlush_givenOutputStreamFlushDoesNothing() throws IOException {
    // Arrange
    doNothing().when(outputStream).flush();

    // Act
    cOSOutputStream.flush();

    // Assert
    verify(outputStream).flush();
  }

  /**
   * Test {@link COSOutputStream#flush()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#flush()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#flush()}
   */
  @Test
  @DisplayName(
      "Test flush(); given OutputStream flush() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.flush()"})
  void testFlush_givenOutputStreamFlushThrowIOException_thenThrowIOException() throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).flush();

    // Act and Assert
    assertThrows(IOException.class, () -> cOSOutputStream.flush());
    verify(outputStream).flush();
  }

  /**
   * Test {@link COSOutputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#close()}
   */
  @Test
  @DisplayName("Test close(); given OutputStream close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.close()"})
  void testClose_givenOutputStreamCloseDoesNothing() throws IOException {
    // Arrange
    doNothing().when(outputStream).close();
    doNothing().when(outputStream).flush();

    // Act
    cOSOutputStream.close();

    // Assert
    verify(outputStream).close();
    verify(outputStream).flush();
  }

  /**
   * Test {@link COSOutputStream#close()}.
   *
   * <ul>
   *   <li>Given {@link OutputStream} {@link OutputStream#close()} throw {@link
   *       IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link COSOutputStream#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given OutputStream close() throw IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void COSOutputStream.close()"})
  void testClose_givenOutputStreamCloseThrowIOException_thenThrowIOException() throws IOException {
    // Arrange
    doThrow(new IOException()).when(outputStream).close();
    doThrow(new IOException()).when(outputStream).flush();

    // Act and Assert
    assertThrows(IOException.class, () -> cOSOutputStream.close());
    verify(outputStream).close();
    verify(outputStream).flush();
  }
}
