package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.ttf.model.GsubData;
import org.junit.jupiter.api.Test;

class GlyphSubstitutionTableDiffblueTest {
  /**
   * Method under test:
   * {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readString(anyInt())).thenReturn("String");
    when(data.getOriginalDataSize()).thenReturn(3L);
    when(data.readUnsignedShort()).thenReturn(4);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act and Assert
    assertThrows(IOException.class, () -> glyphSubstitutionTable.read(ttf, data));
    verify(inputStream).readAllBytes();
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).getOriginalDataSize();
    verify(data, atLeast(1)).seek(anyLong());
    verify(data, atLeast(1)).readString(eq(4));
    verify(data, atLeast(1)).readUnsignedShort();
  }

  /**
   * Method under test:
   * {@link GlyphSubstitutionTable#read(TrueTypeFont, TTFDataStream)}
   */
  @Test
  void testRead2() throws IOException {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    TrueTypeFont ttf = new TrueTypeFont(new RandomAccessReadDataStream(inputStream));
    RandomAccessReadDataStream data = mock(RandomAccessReadDataStream.class);
    when(data.readUnsignedShort()).thenReturn(0);
    when(data.getCurrentPosition()).thenReturn(1L);
    doNothing().when(data).seek(anyLong());

    // Act
    glyphSubstitutionTable.read(ttf, data);

    // Assert
    verify(inputStream).readAllBytes();
    verify(data).getCurrentPosition();
    verify(data, atLeast(1)).seek(eq(1L));
    verify(data, atLeast(1)).readUnsignedShort();
    assertTrue(glyphSubstitutionTable.getSupportedScriptTags().isEmpty());
    assertTrue(glyphSubstitutionTable.getInitialized());
  }

  /**
   * Method under test:
   * {@link GlyphSubstitutionTable#getSubstitution(int, String[], List)}
   */
  @Test
  void testGetSubstitution() {
    // Arrange
    GlyphSubstitutionTable glyphSubstitutionTable = new GlyphSubstitutionTable();

    // Act and Assert
    assertEquals(-1, glyphSubstitutionTable.getSubstitution(-1, new String[]{}, new ArrayList<>()));
  }

  /**
   * Method under test: {@link GlyphSubstitutionTable#getUnsubstitution(int)}
   */
  @Test
  void testGetUnsubstitution() {
    // Arrange, Act and Assert
    assertEquals(1, (new GlyphSubstitutionTable()).getUnsubstitution(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GlyphSubstitutionTable}
   *   <li>{@link GlyphSubstitutionTable#getGsubData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GlyphSubstitutionTable actualGlyphSubstitutionTable = new GlyphSubstitutionTable();
    GsubData actualGsubData = actualGlyphSubstitutionTable.getGsubData();

    // Assert
    assertNull(actualGlyphSubstitutionTable.getTag());
    assertNull(actualGsubData);
    assertEquals(0L, actualGlyphSubstitutionTable.getCheckSum());
    assertEquals(0L, actualGlyphSubstitutionTable.getLength());
    assertEquals(0L, actualGlyphSubstitutionTable.getOffset());
    assertFalse(actualGlyphSubstitutionTable.getInitialized());
  }
}
