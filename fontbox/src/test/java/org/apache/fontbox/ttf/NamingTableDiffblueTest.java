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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NamingTableDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.<init>()", "String NamingTable.getFontFamily()",
      "String NamingTable.getFontSubFamily()", "List NamingTable.getNameRecords()",
      "String NamingTable.getPostScriptName()"})
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

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given four.</li>
   *   <li>Then {@link NamingTable#NamingTable()} NameRecords size is four.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given four; then NamingTable() NameRecords size is four")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenFour_thenNamingTableNameRecordsSizeIsFour() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(4);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertEquals(4, namingTable.getNameRecords().size());
  }

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given IOException(String) with 'foo'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenIOExceptionWithFoo_thenThrowIOException() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    doThrow(new IOException("foo")).when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(1);

    // Act and Assert
    assertThrows(IOException.class, () -> namingTable.read(ttf, data));
    verify(data).seek(eq(19L));
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then {@link NamingTable#NamingTable()} NameRecords first String is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given one; then NamingTable() NameRecords first String is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenOne_thenNamingTableNameRecordsFirstStringIsNull() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    namingTable.read(ttf, data);

    // Assert
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
  }

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given {@code String}.</li>
   *   <li>Then {@link NamingTable#NamingTable()} NameRecords size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given 'String'; then NamingTable() NameRecords size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenString_thenNamingTableNameRecordsSizeIsOne() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(1);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(data).seek(eq(19L));
    verify(data).readString(eq(1), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(1, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals(1, getResult.getLanguageId());
    assertEquals(1, getResult.getNameId());
    assertEquals(1, getResult.getPlatformEncodingId());
    assertEquals(1, getResult.getPlatformId());
    assertEquals(1, getResult.getStringLength());
    assertEquals(1, getResult.getStringOffset());
  }

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then {@link NamingTable#NamingTable()} NameRecords size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given three; then NamingTable() NameRecords size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenThree_thenNamingTableNameRecordsSizeIsThree() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(3);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(eq(45L));
    verify(data, atLeast(1)).readString(eq(3), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(3, nameRecords.size());
    NameRecord getResult = nameRecords.get(2);
    assertEquals("String", getResult.getString());
    NameRecord getResult2 = nameRecords.get(0);
    assertEquals(3, getResult2.getLanguageId());
    NameRecord getResult3 = nameRecords.get(1);
    assertEquals(3, getResult3.getLanguageId());
    assertEquals(3, getResult.getLanguageId());
    assertEquals(3, getResult2.getNameId());
    assertEquals(3, getResult3.getNameId());
    assertEquals(3, getResult.getNameId());
    assertEquals(3, getResult2.getPlatformEncodingId());
    assertEquals(3, getResult3.getPlatformEncodingId());
    assertEquals(3, getResult.getPlatformEncodingId());
    assertEquals(3, getResult2.getPlatformId());
    assertEquals(3, getResult3.getPlatformId());
    assertEquals(3, getResult.getPlatformId());
    assertEquals(3, getResult2.getStringLength());
    assertEquals(3, getResult3.getStringLength());
    assertEquals(3, getResult.getStringLength());
    assertEquals(3, getResult2.getStringOffset());
    assertEquals(3, getResult3.getStringOffset());
    assertEquals(3, getResult.getStringOffset());
  }

  /**
   * Test {@link NamingTable#read(TrueTypeFont, TTFDataStream)} with {@code ttf}, {@code data}.
   * <ul>
   *   <li>Given two.</li>
   *   <li>Then {@link NamingTable#NamingTable()} NameRecords size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  @DisplayName("Test read(TrueTypeFont, TTFDataStream) with 'ttf', 'data'; given two; then NamingTable() NameRecords size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.read(TrueTypeFont, TTFDataStream)"})
  void testReadWithTtfData_givenTwo_thenNamingTableNameRecordsSizeIsTwo() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    namingTable.setLength(3L);
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt(), Mockito.<Charset>any())).thenReturn("String");
    doNothing().when(data).seek(anyLong());
    when(data.readUnsignedShort()).thenReturn(2);

    // Act
    namingTable.read(ttf, data);

    // Assert
    verify(data, atLeast(1)).seek(eq(32L));
    verify(data, atLeast(1)).readString(eq(2), isA(Charset.class));
    verify(data, atLeast(1)).readUnsignedShort();
    List<NameRecord> nameRecords = namingTable.getNameRecords();
    assertEquals(2, nameRecords.size());
    NameRecord getResult = nameRecords.get(0);
    assertEquals(2, getResult.getLanguageId());
    NameRecord getResult2 = nameRecords.get(1);
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
  }

  /**
   * Test {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}.
   * <ul>
   *   <li>Given six.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   */
  @Test
  @DisplayName("Test readHeaders(TrueTypeFont, TTFDataStream, FontHeaders); given six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)"})
  void testReadHeaders_givenSix() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
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
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(outHeaders.getName());
    assertTrue(namingTable.getNameRecords().isEmpty());
  }

  /**
   * Test {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}.
   * <ul>
   *   <li>When {@link RandomAccessReadDataStream} {@link TTFDataStream#readUnsignedShort()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)}
   */
  @Test
  @DisplayName("Test readHeaders(TrueTypeFont, TTFDataStream, FontHeaders); when RandomAccessReadDataStream readUnsignedShort() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NamingTable.readHeaders(TrueTypeFont, TTFDataStream, FontHeaders)"})
  void testReadHeaders_whenRandomAccessReadDataStreamReadUnsignedShortReturnOne() throws IOException {
    // Arrange
    NamingTable namingTable = new NamingTable();
    TrueTypeFont ttf = new TrueTypeFont(
        new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))));
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
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(outHeaders.getName());
    assertTrue(namingTable.getNameRecords().isEmpty());
  }

  /**
   * Test {@link NamingTable#getName(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link RandomAccessReadDataStream} {@link TTFDataStream#readUnsignedShort()} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getName(int, int, int, int); given RandomAccessReadDataStream readUnsignedShort() return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamingTable.getName(int, int, int, int)"})
  void testGetName_givenRandomAccessReadDataStreamReadUnsignedShortReturnOne() throws IOException {
    // Arrange
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(
        new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))), data);

    // Act
    String actualName = namingTable.getName(1, 1, 1, 1);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Test {@link NamingTable#getName(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link RandomAccessReadDataStream} {@link TTFDataStream#readUnsignedShort()} return one.</li>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getName(int, int, int, int); given RandomAccessReadDataStream readUnsignedShort() return one; when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamingTable.getName(int, int, int, int)"})
  void testGetName_givenRandomAccessReadDataStreamReadUnsignedShortReturnOne_whenTwo() throws IOException {
    // Arrange
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(
        new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))), data);

    // Act
    String actualName = namingTable.getName(1, 2, 1, 1);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Test {@link NamingTable#getName(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link RandomAccessReadDataStream} {@link TTFDataStream#readUnsignedShort()} return one.</li>
   *   <li>When two.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getName(int, int, int, int); given RandomAccessReadDataStream readUnsignedShort() return one; when two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamingTable.getName(int, int, int, int)"})
  void testGetName_givenRandomAccessReadDataStreamReadUnsignedShortReturnOne_whenTwo2() throws IOException {
    // Arrange
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(1);

    NamingTable namingTable = new NamingTable();
    namingTable.read(
        new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))), data);

    // Act
    String actualName = namingTable.getName(1, 1, 2, 1);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }

  /**
   * Test {@link NamingTable#getName(int, int, int, int)}.
   * <ul>
   *   <li>Given {@link RandomAccessReadDataStream} {@link TTFDataStream#readUnsignedShort()} return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link NamingTable#getName(int, int, int, int)}
   */
  @Test
  @DisplayName("Test getName(int, int, int, int); given RandomAccessReadDataStream readUnsignedShort() return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String NamingTable.getName(int, int, int, int)"})
  void testGetName_givenRandomAccessReadDataStreamReadUnsignedShortReturnZero() throws IOException {
    // Arrange
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);

    NamingTable namingTable = new NamingTable();
    namingTable.read(
        new TrueTypeFont(new RandomAccessReadDataStream(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))), data);

    // Act
    String actualName = namingTable.getName(1, 1, 1, 1);

    // Assert
    verify(data, atLeast(1)).readUnsignedShort();
    assertNull(actualName);
  }
}
