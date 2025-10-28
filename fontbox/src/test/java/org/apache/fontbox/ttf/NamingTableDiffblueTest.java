package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NamingTableDiffblueTest {
  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(1, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertNull(getResult.getString());
    assertEquals(1, getResult.getLanguageId());
    assertEquals(1, getResult.getNameId());
    assertEquals(1, getResult.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult.getStringLength());
    assertEquals(1, getResult.getStringOffset());
    assertTrue(namingTable.getInitialized());
  }

  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(4);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(4, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertNull(getResult.getString());
    NameRecord getResult2 = nameRecords.get(1);
    assertNull(getResult2.getString());
    NameRecord getResult3 = nameRecords.get(2);
    assertNull(getResult3.getString());
    NameRecord getResult4 = nameRecords.get(3);
    assertNull(getResult4.getString());
    assertEquals(4, getResult.getLanguageId());
    assertEquals(4, getResult2.getLanguageId());
    assertEquals(4, getResult3.getLanguageId());
    assertEquals(4, getResult4.getLanguageId());
    assertEquals(4, getResult.getNameId());
    assertEquals(4, getResult2.getNameId());
    assertEquals(4, getResult3.getNameId());
    assertEquals(4, getResult4.getNameId());
    assertEquals(4, getResult.getPlatformEncodingId());
    assertEquals(4, getResult2.getPlatformEncodingId());
    assertEquals(4, getResult3.getPlatformEncodingId());
    assertEquals(4, getResult4.getPlatformEncodingId());
    assertEquals(4, getResult.getPlatformId());
    assertEquals(4, getResult2.getPlatformId());
    assertEquals(4, getResult3.getPlatformId());
    assertEquals(4, getResult4.getPlatformId());
    assertEquals(4, getResult.getStringLength());
    assertEquals(4, getResult2.getStringLength());
    assertEquals(4, getResult3.getStringLength());
    assertEquals(4, getResult4.getStringLength());
    assertEquals(4, getResult.getStringOffset());
    assertEquals(4, getResult2.getStringOffset());
    assertEquals(4, getResult3.getStringOffset());
    assertEquals(4, getResult4.getStringOffset());
    assertTrue(namingTable.getInitialized());
  }

  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead3() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data).seek(eq(19L));
    verify(data).readString(eq(1), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(1, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("String", getResult.getString());
    assertEquals(1, getResult.getLanguageId());
    assertEquals(1, getResult.getNameId());
    assertEquals(1, getResult.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult.getStringLength());
    assertEquals(1, getResult.getStringOffset());
    assertTrue(namingTable.getInitialized());
  }

  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead4() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(3);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).seek(eq(45L));
    verify(data, atLeast(1)).readString(eq(3), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(3, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("String", getResult.getString());
    NameRecord getResult2 = nameRecords.get(1);
    assertEquals("String", getResult2.getString());
    NameRecord getResult3 = nameRecords.get(2);
    assertEquals("String", getResult3.getString());
    assertEquals(3, getResult.getLanguageId());
    assertEquals(3, getResult2.getLanguageId());
    assertEquals(3, getResult3.getLanguageId());
    assertEquals(3, getResult.getNameId());
    assertEquals(3, getResult2.getNameId());
    assertEquals(3, getResult3.getNameId());
    assertEquals(3, getResult.getPlatformEncodingId());
    assertEquals(3, getResult2.getPlatformEncodingId());
    assertEquals(3, getResult3.getPlatformEncodingId());
    assertEquals(3, getResult.getPlatformId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult.getStringLength());
    assertEquals(3, getResult2.getStringLength());
    assertEquals(3, getResult3.getStringLength());
    assertEquals(3, getResult.getStringOffset());
    assertEquals(3, getResult2.getStringOffset());
    assertEquals(3, getResult3.getStringOffset());
    assertTrue(namingTable.getInitialized());
  }

  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead5() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).seek(eq(32L));
    verify(data, atLeast(1)).readString(eq(2), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(2, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals("String", getResult.getString());
    NameRecord getResult2 = nameRecords.get(1);
    assertEquals("String", getResult2.getString());
    assertEquals(2, getResult.getLanguageId());
    assertEquals(2, getResult2.getLanguageId());
    assertEquals(2, getResult.getNameId());
    assertEquals(2, getResult2.getNameId());
    assertEquals(2, getResult.getPlatformEncodingId());
    assertEquals(2, getResult2.getPlatformEncodingId());
    assertEquals(2, getResult.getPlatformId());
    assertEquals(2, getResult2.getPlatformId());
    assertEquals(2, getResult.getStringLength());
    assertEquals(2, getResult2.getStringLength());
    assertEquals(2, getResult.getStringOffset());
    assertEquals(2, getResult2.getStringOffset());
    assertTrue(namingTable.getInitialized());
  }

  /**
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead6() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    doThrow(new IOException("foo")).when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> namingTable.read(ttf, data));
    verify(inputStream).readAllBytes();
    verify(data).seek(eq(19L));
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test:
   * {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   */
  @Test
  void testReadHeaders() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    namingTable.readHeaders(ttf, data, outHeaders);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(outHeaders.getName());
    assertTrue(namingTable.getNameRecords().isEmpty());
  }

  /**
   * Method under test:
   * {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   */
  @Test
  void testReadHeaders2() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(6);

    FontHeaders outHeaders = new FontHeaders();
    outHeaders.setError("Exception");
    outHeaders.setHeaderMacStyle(1);
    outHeaders.setIsOTFAndPostScript(true);
    outHeaders.setName("Name");
    outHeaders.setNonOtfGcid142("AXAXAXAX".getBytes("UTF-8"));
    outHeaders.setOs2Windows(new OS2WindowsMetricsTable());

    // Act
    namingTable.readHeaders(ttf, data, outHeaders);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(outHeaders.getName());
    assertTrue(namingTable.getNameRecords().isEmpty());
  }

  /**
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(ttf, data);

    // Act
    String actualName = namingTable.getName(1, 1, 1, 1);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  void testGetName2() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);

    NamingTable namingTable = new NamingTable();
    namingTable.read(ttf, data);

    // Act
    String actualName = namingTable.getName(1, 1, 1, 1);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  void testGetName3() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(ttf, data);

    // Act
    String actualName = namingTable.getName(1, 2, 1, 1);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  void testGetName4() throws IOException {
    // Arrange
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(ttf, data);

    // Act
    String actualName = namingTable.getName(1, 1, 2, 1);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NamingTable}
   *   <li>{@link NamingTable#getFontFamily()}
   *   <li>{@link NamingTable#getFontSubFamily()}
   *   <li>{@link NamingTable#getNameRecords()}
   *   <li>{@link NamingTable#getPostScriptName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NamingTable actualNamingTable = new NamingTable();
    String actualFontFamily = actualNamingTable.getFontFamily();
    String actualFontSubFamily = actualNamingTable.getFontSubFamily();
    List<NameRecord> actualNameRecords = actualNamingTable.getNameRecords();

    // Assert
    assertNull(actualFontFamily);
    assertNull(actualFontSubFamily);
    assertNull(actualNamingTable.getPostScriptName());
    assertNull(actualNamingTable.getTag());
    assertNull(actualNameRecords);
    assertEquals(0L, actualNamingTable.getCheckSum());
    assertEquals(0L, actualNamingTable.getLength());
    assertEquals(0L, actualNamingTable.getOffset());
    assertFalse(actualNamingTable.getInitialized());
  }
}
