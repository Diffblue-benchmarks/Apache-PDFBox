package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CFFFontDiffblueTest {
  /**
   * Method under test: {@link CFFFont#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getName());
  }

  /**
   * Method under test: {@link CFFFont#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act and Assert
    assertNull(cffcidFont.getName());
  }

  /**
   * Method under test: {@link CFFFont#setName(String)}
   */
  @Test
  void testSetName() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.setName("Name");

    // Assert
    assertEquals("Name", cffcidFont.getName());
  }

  /**
   * Method under test: {@link CFFFont#setName(String)}
   */
  @Test
  void testSetName2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act
    cffcidFont.setName("Name");

    // Assert
    assertEquals("Name", cffcidFont.getName());
  }

  /**
   * Method under test: {@link CFFFont#addValueToTopDict(String, Object)}
   */
  @Test
  void testAddValueToTopDict() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.addValueToTopDict("Name", "Value");

    // Assert
    Map<String, Object> topDict = cffcidFont.getTopDict();
    assertEquals(1, topDict.size());
    assertEquals("Value", topDict.get("Name"));
  }

  /**
   * Method under test: {@link CFFFont#addValueToTopDict(String, Object)}
   */
  @Test
  void testAddValueToTopDict2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.addValueToTopDict("Name", null);

    // Assert that nothing has changed
    assertTrue(cffcidFont.getTopDict().isEmpty());
  }

  /**
   * Method under test: {@link CFFFont#addValueToTopDict(String, Object)}
   */
  @Test
  void testAddValueToTopDict3() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act
    cffcidFont.addValueToTopDict("Name", "Value");

    // Assert
    Map<String, Object> topDict = cffcidFont.getTopDict();
    assertEquals(1, topDict.size());
    assertEquals("Value", topDict.get("Name"));
  }

  /**
   * Method under test: {@link CFFFont#getTopDict()}
   */
  @Test
  void testGetTopDict() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    Map<String, Object> actualTopDict = cffcidFont.getTopDict();

    // Assert
    assertTrue(actualTopDict.isEmpty());
    assertSame(cffcidFont.topDict, actualTopDict);
  }

  /**
   * Method under test: {@link CFFFont#getTopDict()}
   */
  @Test
  void testGetTopDict2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act
    Map<String, Object> actualTopDict = cffcidFont.getTopDict();

    // Assert
    assertTrue(actualTopDict.isEmpty());
    assertSame(cffcidFont.topDict, actualTopDict);
  }

  /**
   * Method under test: {@link CFFFont#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getFontMatrix());
  }

  /**
   * Method under test: {@link CFFFont#getCharset()}
   */
  @Test
  void testGetCharset() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getCharset());
  }

  /**
   * Method under test: {@link CFFFont#getCharset()}
   */
  @Test
  void testGetCharset2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act and Assert
    assertNull(cffcidFont.getCharset());
  }

  /**
   * Method under test: {@link CFFFont#setCharset(CFFCharset)}
   */
  @Test
  void testSetCharset() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    CFFCharsetCID charset = new CFFCharsetCID();

    // Act
    cffcidFont.setCharset(charset);

    // Assert
    assertSame(charset, cffcidFont.getCharset());
  }

  /**
   * Method under test: {@link CFFFont#setCharset(CFFCharset)}
   */
  @Test
  void testSetCharset2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));
    CFFCharsetCID charset = new CFFCharsetCID();

    // Act
    cffcidFont.setCharset(charset);

    // Assert
    assertSame(charset, cffcidFont.getCharset());
  }

  /**
   * Method under test: {@link CFFFont#setData(CFFParser.ByteSource)}
   */
  @Test
  void testSetData() throws IOException {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.setData(mock(CFFParser.ByteSource.class));

    // Assert
    assertNull(cffcidFont.getData());
  }

  /**
   * Method under test: {@link CFFFont#getData()}
   */
  @Test
  void testGetData() throws IOException {
    // Arrange
    CFFParser.ByteSource source = mock(CFFParser.ByteSource.class);
    when(source.getBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setData(source);

    // Act
    byte[] actualData = cffcidFont.getData();

    // Assert
    verify(source).getBytes();
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Method under test: {@link CFFFont#setGlobalSubrIndex(byte[][])}
   */
  @Test
  void testSetGlobalSubrIndex() throws UnsupportedEncodingException {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.setGlobalSubrIndex(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(1, cffcidFont.getGlobalSubrIndex().size());
    assertEquals(1, cffcidFont.globalSubrIndex.length);
  }

  /**
   * Method under test: {@link CFFFont#setGlobalSubrIndex(byte[][])}
   */
  @Test
  void testSetGlobalSubrIndex2() throws UnsupportedEncodingException {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act
    cffcidFont.setGlobalSubrIndex(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Assert
    assertEquals(1, cffcidFont.getGlobalSubrIndex().size());
    assertEquals(1, cffcidFont.globalSubrIndex.length);
  }

  /**
   * Method under test: {@link CFFFont#getGlobalSubrIndex()}
   */
  @Test
  void testGetGlobalSubrIndex() throws UnsupportedEncodingException {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setGlobalSubrIndex(new byte[][]{"AXAXAXAX".getBytes("UTF-8")});

    // Act
    List<byte[]> actualGlobalSubrIndex = cffcidFont.getGlobalSubrIndex();

    // Assert
    assertEquals(1, actualGlobalSubrIndex.size());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualGlobalSubrIndex.get(0));
  }

  /**
   * Method under test: {@link CFFFont#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("CFFCIDFont[name=null, topDict={}, charset=null, charStrings=null]", (new CFFCIDFont()).toString());
  }

  /**
   * Method under test: {@link CFFFont#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    cffcidFont.setFdSelect(mock(FDSelect.class));

    // Act and Assert
    assertEquals("CFFCIDFont[name=null, topDict={}, charset=null, charStrings=null]", cffcidFont.toString());
  }
}
