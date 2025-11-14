package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ScratchFileBufferDiffblueTest {
  @Mock private ScratchFile scratchFile;

  @InjectMocks private ScratchFileBuffer scratchFileBuffer;

  /**
   * Test {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)}.
   *
   * <p>Method under test: {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)}
   */
  @Test
  @DisplayName("Test new ScratchFileBuffer(ScratchFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.<init>(ScratchFile)"})
  void testNewScratchFileBuffer() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(4096L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act
    ScratchFileBuffer actualScratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Assert
    assertEquals(0, actualScratchFileBuffer.available());
    assertEquals(0L, actualScratchFileBuffer.getPosition());
    assertEquals(0L, actualScratchFileBuffer.length());
    assertFalse(actualScratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#length()}.
   *
   * <p>Method under test: {@link ScratchFileBuffer#length()}
   */
  @Test
  @DisplayName("Test length()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ScratchFileBuffer.length()"})
  void testLength() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertEquals(0L, new ScratchFileBuffer(pageHandler).length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link ScratchFileBuffer#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[])"})
  void testWriteWithByte() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(8L, scratchFileBuffer.getPosition());
    assertEquals(8L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)} with pageHandler is {@link
   *       ScratchFile#ScratchFile(MemoryUsageSetting)} Position is one.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#write(int)}
   */
  @Test
  @DisplayName(
      "Test write(int) with 'int'; then ScratchFileBuffer(ScratchFile) with pageHandler is ScratchFile(MemoryUsageSetting) Position is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.write(int)"})
  void testWriteWithInt_thenScratchFileBufferWithPageHandlerIsScratchFilePositionIsOne()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write(19088743);

    // Assert
    assertEquals(1L, scratchFileBuffer.getPosition());
    assertEquals(1L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#getPosition()}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#getPosition()}
   */
  @Test
  @DisplayName(
      "Test getPosition(); given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long ScratchFileBuffer.getPosition()"})
  void testGetPosition_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertEquals(0L, new ScratchFileBuffer(pageHandler).getPosition());
  }

  /**
   * Test {@link ScratchFileBuffer#seek(long)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#seek(long)}
   */
  @Test
  @DisplayName(
      "Test seek(long); given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.seek(long)"})
  void testSeek_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertThrows(EOFException.class, () -> new ScratchFileBuffer(pageHandler).seek(1L));
  }

  /**
   * Test {@link ScratchFileBuffer#seek(long)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#seek(long)}
   */
  @Test
  @DisplayName(
      "Test seek(long); given Property is 'java.io.tmpdir' is array of String with 'foo'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.seek(long)"})
  void testSeek_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFoo_thenDoesNotThrow()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertDoesNotThrow(() -> new ScratchFileBuffer(pageHandler).seek(0L));
  }

  /**
   * Test {@link ScratchFileBuffer#isClosed()}.
   *
   * <p>Method under test: {@link ScratchFileBuffer#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScratchFileBuffer.isClosed()"})
  void testIsClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertFalse(new ScratchFileBuffer(pageHandler).isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#isEOF()}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#isEOF()}
   */
  @Test
  @DisplayName(
      "Test isEOF(); given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ScratchFileBuffer.isEOF()"})
  void testIsEOF_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42_thenReturnTrue()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertTrue(new ScratchFileBuffer(pageHandler).isEOF());
  }

  /**
   * Test {@link ScratchFileBuffer#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#read(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test read(byte[], int, int) with 'b', 'off', 'len'; given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScratchFileBuffer.read(byte[], int, int)"})
  void testReadWithBOffLen_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertEquals(-1, new ScratchFileBuffer(pageHandler).read("AXAXAXAX".getBytes("UTF-8"), 1, 3));
  }

  /**
   * Test {@link ScratchFileBuffer#read()}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#read()}
   */
  @Test
  @DisplayName(
      "Test read(); given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ScratchFileBuffer.read()"})
  void testRead_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);

    // Act and Assert
    assertEquals(-1, new ScratchFileBuffer(pageHandler).read());
  }

  /**
   * Test {@link ScratchFileBuffer#close(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code 42}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  @DisplayName(
      "Test close(boolean) with 'boolean'; given Property is 'java.io.tmpdir' is array of String with '42'; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close(boolean)"})
  void testCloseWithBoolean_givenPropertyIsJavaIoTmpdirIsArrayOfStringWith42_whenFalse()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.close(false);

    // Assert
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir} is array of {@link String} with {@code foo} and
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  @DisplayName(
      "Test close(boolean) with 'boolean'; given Property is 'java.io.tmpdir' is array of String with 'foo' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close(boolean)"})
  void testCloseWithBoolean_givenPropertyIsJavaIoTmpdirIsArrayOfStringWithFooAnd42()
      throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.close(true);

    // Assert
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then {@link ScratchFileBuffer} Closed.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  @DisplayName("Test close(boolean) with 'boolean'; then ScratchFileBuffer Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close(boolean)"})
  void testCloseWithBoolean_thenScratchFileBufferClosed() {
    // Arrange
    doNothing().when(scratchFile).markPagesAsFree(Mockito.<int[]>any(), anyInt(), anyInt());
    doNothing().when(scratchFile).removeBuffer(Mockito.<ScratchFileBuffer>any());

    // Act
    scratchFileBuffer.close(true);

    // Assert
    verify(scratchFile).markPagesAsFree(isA(int[].class), eq(0), eq(1));
    verify(scratchFile).removeBuffer(isA(ScratchFileBuffer.class));
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close(boolean)} with {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  @DisplayName("Test close(boolean) with 'boolean'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close(boolean)"})
  void testCloseWithBoolean_thenThrowUnsupportedOperationException() {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(scratchFile)
        .markPagesAsFree(Mockito.<int[]>any(), anyInt(), anyInt());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> scratchFileBuffer.close(true));
    verify(scratchFile).markPagesAsFree(isA(int[].class), eq(0), eq(1));
  }

  /**
   * Test {@link ScratchFileBuffer#close()}.
   *
   * <ul>
   *   <li>Given {@link ScratchFile} {@link ScratchFile#markPagesAsFree(int[], int, int)} does
   *       nothing.
   *   <li>Then {@link ScratchFileBuffer} Closed.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close()}
   */
  @Test
  @DisplayName(
      "Test close(); given ScratchFile markPagesAsFree(int[], int, int) does nothing; then ScratchFileBuffer Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close()"})
  void testClose_givenScratchFileMarkPagesAsFreeDoesNothing_thenScratchFileBufferClosed()
      throws IOException {
    // Arrange
    doNothing().when(scratchFile).markPagesAsFree(Mockito.<int[]>any(), anyInt(), anyInt());
    doNothing().when(scratchFile).removeBuffer(Mockito.<ScratchFileBuffer>any());

    // Act
    scratchFileBuffer.close();

    // Assert
    verify(scratchFile).markPagesAsFree(isA(int[].class), eq(0), eq(1));
    verify(scratchFile).removeBuffer(isA(ScratchFileBuffer.class));
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close()}.
   *
   * <ul>
   *   <li>Then {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)} with pageHandler is {@link
   *       ScratchFile#ScratchFile(MemoryUsageSetting)} Closed.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close()}
   */
  @Test
  @DisplayName(
      "Test close(); then ScratchFileBuffer(ScratchFile) with pageHandler is ScratchFile(MemoryUsageSetting) Closed")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close()"})
  void testClose_thenScratchFileBufferWithPageHandlerIsScratchFileClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42");
    MemoryUsageSetting memUsageSetting = MemoryUsageSetting.setupMainMemoryOnly(-1L);
    ScratchFile pageHandler = new ScratchFile(memUsageSetting);
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.close();

    // Assert
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ScratchFileBuffer#close()}
   */
  @Test
  @DisplayName("Test close(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScratchFileBuffer.close()"})
  void testClose_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    doThrow(new UnsupportedOperationException())
        .when(scratchFile)
        .markPagesAsFree(Mockito.<int[]>any(), anyInt(), anyInt());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> scratchFileBuffer.close());
    verify(scratchFile).markPagesAsFree(isA(int[].class), eq(0), eq(1));
  }

  /**
   * Test {@link ScratchFileBuffer#createView(long, long)}.
   *
   * <p>Method under test: {@link ScratchFileBuffer#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.io.RandomAccessReadView ScratchFileBuffer.createView(long, long)"
  })
  void testCreateView() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> scratchFileBuffer.createView(1L, 3L));
  }
}
