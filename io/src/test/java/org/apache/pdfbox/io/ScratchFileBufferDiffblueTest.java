package org.apache.pdfbox.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScratchFileBufferDiffblueTest {
  /**
   * Test {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)}.
   * <p>
   * Method under test: {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)}
   */
  @Test
  @DisplayName("Test new ScratchFileBuffer(ScratchFile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.<init>(ScratchFile)"})
  void testNewScratchFileBuffer() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act
    ScratchFileBuffer actualScratchFileBuffer = new ScratchFileBuffer(
        new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(4096L)));

    // Assert
    assertEquals(0, actualScratchFileBuffer.available());
    assertEquals(0L, actualScratchFileBuffer.getPosition());
    assertEquals(0L, actualScratchFileBuffer.length());
    assertFalse(actualScratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#length()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#length()}
   */
  @Test
  @DisplayName("Test length(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ScratchFileBuffer.length()"})
  void testLength_thenReturnZero() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0L, (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[])"})
  void testWriteWithByte() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    doNothing().when(pageHandler).writePage(anyInt(), Mockito.<byte[]>any());
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler, atLeast(1)).getNewPage();
    verify(pageHandler).getPageSize();
    verify(pageHandler, atLeast(1)).writePage(eq(1), Mockito.<byte[]>any());
    assertEquals(8L, scratchFileBuffer.getPosition());
    assertEquals(8L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[])} with {@code byte[]}.
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(byte[])}
   */
  @Test
  @DisplayName("Test write(byte[]) with 'byte[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[])"})
  void testWriteWithByte2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write(new byte[]{});

    // Assert that nothing has changed
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler).getNewPage();
    verify(pageHandler).getPageSize();
    assertEquals(0L, scratchFileBuffer.getPosition());
    assertEquals(0L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write("AXAXAXAX".getBytes("UTF-8"), 3, 3);

    // Assert
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler).getNewPage();
    verify(pageHandler).getPageSize();
    assertEquals(3L, scratchFileBuffer.getPosition());
    assertEquals(3L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt2() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    scratchFileBuffer.write("AXAXAXAX".getBytes("UTF-8"), 19088743, 0);

    // Assert that nothing has changed
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler).getNewPage();
    verify(pageHandler).getPageSize();
    assertEquals(0L, scratchFileBuffer.getPosition());
    assertEquals(0L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#write(byte[], int, int)} with {@code byte[]}, {@code int}, {@code int}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  @DisplayName("Test write(byte[], int, int) with 'byte[]', 'int', 'int'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(byte[], int, int)"})
  void testWriteWithByteIntInt_thenThrowIOException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    doThrow(new IOException("foo")).when(pageHandler).writePage(anyInt(), Mockito.<byte[]>any());
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(0);
    doNothing().when(pageHandler).checkClosed();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act and Assert
    assertThrows(IOException.class, () -> scratchFileBuffer.write("AXAXAXAX".getBytes("UTF-8"), 3, 3));
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler, atLeast(1)).getNewPage();
    verify(pageHandler).getPageSize();
    verify(pageHandler).writePage(eq(1), isA(byte[].class));
  }

  /**
   * Test {@link ScratchFileBuffer#write(int)} with {@code int}.
   * <ul>
   *   <li>Then {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)} with pageHandler is {@link ScratchFile#ScratchFile(MemoryUsageSetting)} Position is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#write(int)}
   */
  @Test
  @DisplayName("Test write(int) with 'int'; then ScratchFileBuffer(ScratchFile) with pageHandler is ScratchFile(MemoryUsageSetting) Position is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.write(int)"})
  void testWriteWithInt_thenScratchFileBufferWithPageHandlerIsScratchFilePositionIsOne() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(
        new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));

    // Act
    scratchFileBuffer.write(19088743);

    // Assert
    assertEquals(1L, scratchFileBuffer.getPosition());
    assertEquals(1L, scratchFileBuffer.length());
  }

  /**
   * Test {@link ScratchFileBuffer#clear()}.
   * <ul>
   *   <li>Then calls {@link ScratchFile#checkClosed()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#clear()}
   */
  @Test
  @DisplayName("Test clear(); then calls checkClosed()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.clear()"})
  void testClear_thenCallsCheckClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    doNothing().when(pageHandler).markPagesAsFree(Mockito.<int[]>any(), anyInt(), anyInt());

    // Act
    (new ScratchFileBuffer(pageHandler)).clear();

    // Assert
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler).getNewPage();
    verify(pageHandler).getPageSize();
    verify(pageHandler).markPagesAsFree(isA(int[].class), eq(1), eq(0));
  }

  /**
   * Test {@link ScratchFileBuffer#getPosition()}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#getPosition()}
   */
  @Test
  @DisplayName("Test getPosition(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long ScratchFileBuffer.getPosition()"})
  void testGetPosition_thenReturnZero() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0L,
        (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).getPosition());
  }

  /**
   * Test {@link ScratchFileBuffer#seek(long)}.
   * <ul>
   *   <li>Then throw {@link EOFException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#seek(long)}
   */
  @Test
  @DisplayName("Test seek(long); then throw EOFException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.seek(long)"})
  void testSeek_thenThrowEOFException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(EOFException.class,
        () -> (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).seek(1L));
  }

  /**
   * Test {@link ScratchFileBuffer#isClosed()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#isClosed()}
   */
  @Test
  @DisplayName("Test isClosed(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScratchFileBuffer.isClosed()"})
  void testIsClosed_thenReturnFalse() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertFalse((new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#isEOF()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#isEOF()}
   */
  @Test
  @DisplayName("Test isEOF(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ScratchFileBuffer.isEOF()"})
  void testIsEOF_thenReturnTrue() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertTrue((new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).isEOF());
  }

  /**
   * Test {@link ScratchFileBuffer#read(byte[], int, int)} with {@code b}, {@code off}, {@code len}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#read(byte[], int, int)}
   */
  @Test
  @DisplayName("Test read(byte[], int, int) with 'b', 'off', 'len'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScratchFileBuffer.read(byte[], int, int)"})
  void testReadWithBOffLen_thenReturnMinusOne() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFile pageHandler = mock(ScratchFile.class);
    when(pageHandler.getNewPage()).thenReturn(1);
    when(pageHandler.getPageSize()).thenReturn(3);
    doNothing().when(pageHandler).checkClosed();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(pageHandler);

    // Act
    int actualReadResult = scratchFileBuffer.read("AXAXAXAX".getBytes("UTF-8"), 1, 3);

    // Assert
    verify(pageHandler, atLeast(1)).checkClosed();
    verify(pageHandler).getNewPage();
    verify(pageHandler).getPageSize();
    assertEquals(-1, actualReadResult);
  }

  /**
   * Test {@link ScratchFileBuffer#read()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#read()}
   */
  @Test
  @DisplayName("Test read(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ScratchFileBuffer.read()"})
  void testRead_thenReturnMinusOne() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(-1, (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).read());
  }

  /**
   * Test {@link ScratchFileBuffer#close(boolean)} with {@code boolean}.
   * <ul>
   *   <li>Then {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)} with pageHandler is {@link ScratchFile#ScratchFile(MemoryUsageSetting)} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  @DisplayName("Test close(boolean) with 'boolean'; then ScratchFileBuffer(ScratchFile) with pageHandler is ScratchFile(MemoryUsageSetting) Closed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.close(boolean)"})
  void testCloseWithBoolean_thenScratchFileBufferWithPageHandlerIsScratchFileClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(
        new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));

    // Act
    scratchFileBuffer.close(true);

    // Assert
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#close()}.
   * <ul>
   *   <li>Then {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)} with pageHandler is {@link ScratchFile#ScratchFile(MemoryUsageSetting)} Closed.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#close()}
   */
  @Test
  @DisplayName("Test close(); then ScratchFileBuffer(ScratchFile) with pageHandler is ScratchFile(MemoryUsageSetting) Closed")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ScratchFileBuffer.close()"})
  void testClose_thenScratchFileBufferWithPageHandlerIsScratchFileClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();
    ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(
        new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)));

    // Act
    scratchFileBuffer.close();

    // Assert
    assertTrue(scratchFileBuffer.isClosed());
  }

  /**
   * Test {@link ScratchFileBuffer#createView(long, long)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScratchFileBuffer#createView(long, long)}
   */
  @Test
  @DisplayName("Test createView(long, long); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"org.apache.pdfbox.io.RandomAccessReadView ScratchFileBuffer.createView(long, long)"})
  void testCreateView_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).createView(1L, 3L));
  }
}
