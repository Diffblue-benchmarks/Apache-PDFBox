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
import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ScratchFileBufferDiffblueTest {
  /**
   * Method under test: {@link ScratchFileBuffer#length()}
   */
  @Test
  void testLength() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0L, (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).length());
  }

  /**
   * Method under test: {@link ScratchFileBuffer#write(int)}
   */
  @Test
  void testWrite() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#write(byte[])}
   */
  @Test
  void testWrite2() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#write(byte[])}
   */
  @Test
  void testWrite3() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  void testWrite4() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  void testWrite5() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#write(byte[], int, int)}
   */
  @Test
  void testWrite6() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#clear()}
   */
  @Test
  void testClear() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#getPosition()}
   */
  @Test
  void testGetPosition() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(0L,
        (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).getPosition());
  }

  /**
   * Method under test: {@link ScratchFileBuffer#seek(long)}
   */
  @Test
  void testSeek() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(EOFException.class,
        () -> (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).seek(1L));
  }

  /**
   * Method under test: {@link ScratchFileBuffer#isClosed()}
   */
  @Test
  void testIsClosed() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertFalse((new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).isClosed());
  }

  /**
   * Method under test: {@link ScratchFileBuffer#isEOF()}
   */
  @Test
  void testIsEOF() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertTrue((new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).isEOF());
  }

  /**
   * Method under test: {@link ScratchFileBuffer#read()}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertEquals(-1, (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).read());
  }

  /**
   * Method under test: {@link ScratchFileBuffer#read(byte[], int, int)}
   */
  @Test
  void testRead2() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#close()}
   */
  @Test
  void testClose() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#close(boolean)}
   */
  @Test
  void testClose2() throws IOException {
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
   * Method under test: {@link ScratchFileBuffer#createView(long, long)}
   */
  @Test
  void testCreateView() throws IOException {
    // Arrange
    Paths.get(System.getProperty("java.io.tmpdir"), "foo", "42").toFile();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ScratchFileBuffer(new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly(-1L)))).createView(1L, 3L));
  }

  /**
   * Method under test: {@link ScratchFileBuffer#ScratchFileBuffer(ScratchFile)}
   */
  @Test
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
}
