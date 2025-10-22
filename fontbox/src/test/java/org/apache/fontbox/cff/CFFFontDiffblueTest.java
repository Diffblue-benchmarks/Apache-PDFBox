package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.apache.fontbox.cff.CFFParser.ByteSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFFontDiffblueTest {
  /**
   * Test {@link CFFFont#getName()}.
   * <p>
   * Method under test: {@link CFFFont#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CFFFont.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getName());
  }

  /**
   * Test {@link CFFFont#setName(String)}.
   * <p>
   * Method under test: {@link CFFFont#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.setName(String)"})
  void testSetName() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.setName("Name");

    // Assert
    assertEquals("Name", cffcidFont.getName());
  }

  /**
   * Test {@link CFFFont#addValueToTopDict(String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CFFCIDFont} (default constructor) TopDict Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFFont#addValueToTopDict(String, Object)}
   */
  @Test
  @DisplayName("Test addValueToTopDict(String, Object); when 'null'; then CFFCIDFont (default constructor) TopDict Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.addValueToTopDict(String, Object)"})
  void testAddValueToTopDict_whenNull_thenCFFCIDFontTopDictEmpty() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.addValueToTopDict("Name", null);

    // Assert that nothing has changed
    assertTrue(cffcidFont.getTopDict().isEmpty());
  }

  /**
   * Test {@link CFFFont#addValueToTopDict(String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link CFFCIDFont} (default constructor) TopDict size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFFont#addValueToTopDict(String, Object)}
   */
  @Test
  @DisplayName("Test addValueToTopDict(String, Object); when 'Value'; then CFFCIDFont (default constructor) TopDict size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.addValueToTopDict(String, Object)"})
  void testAddValueToTopDict_whenValue_thenCFFCIDFontTopDictSizeIsOne() {
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
   * Test {@link CFFFont#getTopDict()}.
   * <p>
   * Method under test: {@link CFFFont#getTopDict()}
   */
  @Test
  @DisplayName("Test getTopDict()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map CFFFont.getTopDict()"})
  void testGetTopDict() {
    // Arrange, Act and Assert
    assertTrue((new CFFCIDFont()).getTopDict().isEmpty());
  }

  /**
   * Test {@link CFFFont#getFontMatrix()}.
   * <p>
   * Method under test: {@link CFFFont#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CFFFont.getFontMatrix()"})
  void testGetFontMatrix() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getFontMatrix());
  }

  /**
   * Test {@link CFFFont#getCharset()}.
   * <p>
   * Method under test: {@link CFFFont#getCharset()}
   */
  @Test
  @DisplayName("Test getCharset()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CFFCharset CFFFont.getCharset()"})
  void testGetCharset() {
    // Arrange, Act and Assert
    assertNull((new CFFCIDFont()).getCharset());
  }

  /**
   * Test {@link CFFFont#setCharset(CFFCharset)}.
   * <p>
   * Method under test: {@link CFFFont#setCharset(CFFCharset)}
   */
  @Test
  @DisplayName("Test setCharset(CFFCharset)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.setCharset(CFFCharset)"})
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
   * Test {@link CFFFont#setData(ByteSource)}.
   * <p>
   * Method under test: {@link CFFFont#setData(ByteSource)}
   */
  @Test
  @DisplayName("Test setData(ByteSource)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.setData(ByteSource)"})
  void testSetData() throws IOException {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();

    // Act
    cffcidFont.setData(mock(ByteSource.class));

    // Assert
    assertNull(cffcidFont.getData());
  }

  /**
   * Test {@link CFFFont#getData()}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFFont#getData()}
   */
  @Test
  @DisplayName("Test getData(); then return 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] CFFFont.getData()"})
  void testGetData_thenReturnAxaxaxaxBytesIsUtf8() throws IOException {
    // Arrange
    ByteSource source = mock(ByteSource.class);
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
   * Test {@link CFFFont#setGlobalSubrIndex(byte[][])}.
   * <p>
   * Method under test: {@link CFFFont#setGlobalSubrIndex(byte[][])}
   */
  @Test
  @DisplayName("Test setGlobalSubrIndex(byte[][])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFFont.setGlobalSubrIndex(byte[][])"})
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
   * Test {@link CFFFont#getGlobalSubrIndex()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFFont#getGlobalSubrIndex()}
   */
  @Test
  @DisplayName("Test getGlobalSubrIndex(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List CFFFont.getGlobalSubrIndex()"})
  void testGetGlobalSubrIndex_thenReturnSizeIsOne() throws UnsupportedEncodingException {
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
   * Test {@link CFFFont#toString()}.
   * <p>
   * Method under test: {@link CFFFont#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CFFFont.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("CFFCIDFont[name=null, topDict={}, charset=null, charStrings=null]", (new CFFCIDFont()).toString());
  }
}
