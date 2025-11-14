package org.apache.fontbox.ttf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class WGL4NamesDiffblueTest {
  /**
   * Test {@link WGL4Names#getGlyphIndex(String)}.
   *
   * <p>Method under test: {@link WGL4Names#getGlyphIndex(String)}
   */
  @Test
  @DisplayName("Test getGlyphIndex(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Integer WGL4Names.getGlyphIndex(String)"})
  void testGetGlyphIndex() {
    // Arrange, Act and Assert
    assertNull(WGL4Names.getGlyphIndex("Name"));
  }

  /**
   * Test {@link WGL4Names#getGlyphName(int)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WGL4Names#getGlyphName(int)}
   */
  @Test
  @DisplayName("Test getGlyphName(int); when minus one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WGL4Names.getGlyphName(int)"})
  void testGetGlyphName_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(WGL4Names.getGlyphName(-1));
  }

  /**
   * Test {@link WGL4Names#getGlyphName(int)}.
   *
   * <ul>
   *   <li>When {@link WGL4Names#NUMBER_OF_MAC_GLYPHS}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WGL4Names#getGlyphName(int)}
   */
  @Test
  @DisplayName("Test getGlyphName(int); when NUMBER_OF_MAC_GLYPHS; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WGL4Names.getGlyphName(int)"})
  void testGetGlyphName_whenNumber_of_mac_glyphs_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(WGL4Names.getGlyphName(WGL4Names.NUMBER_OF_MAC_GLYPHS));
  }

  /**
   * Test {@link WGL4Names#getGlyphName(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code .null}.
   * </ul>
   *
   * <p>Method under test: {@link WGL4Names#getGlyphName(int)}
   */
  @Test
  @DisplayName("Test getGlyphName(int); when one; then return '.null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WGL4Names.getGlyphName(int)"})
  void testGetGlyphName_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals(".null", WGL4Names.getGlyphName(1));
  }

  /**
   * Test {@link WGL4Names#getAllNames()}.
   *
   * <p>Method under test: {@link WGL4Names#getAllNames()}
   */
  @Test
  @DisplayName("Test getAllNames()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] WGL4Names.getAllNames()"})
  void testGetAllNames() {
    // Arrange and Act
    String[] actualAllNames = WGL4Names.getAllNames();

    // Assert
    assertEquals(".notdef", actualAllNames[0]);
    assertEquals(".null", actualAllNames[1]);
    assertEquals("Cacute", actualAllNames[253]);
    assertEquals("Ccaron", actualAllNames[255]);
    assertEquals("Eth", actualAllNames[233]);
    assertEquals("Gbreve", actualAllNames[248]);
    assertEquals("Idotaccent", actualAllNames[250]);
    assertEquals("Scedilla", actualAllNames[251]);
    assertEquals("Thorn", actualAllNames[237]);
    assertEquals("Yacute", actualAllNames[235]);
    assertEquals("ampersand", actualAllNames[OS2WindowsMetricsTable.FAMILY_CLASS_ORNAMENTALS]);
    assertEquals("asterisk", actualAllNames[13]);
    assertEquals("cacute", actualAllNames[254]);
    assertEquals("ccaron", actualAllNames[256]);
    assertEquals("comma", actualAllNames[15]);
    assertEquals("dcroat", actualAllNames[257]);
    assertEquals("dollar", actualAllNames[7]);
    assertEquals("eth", actualAllNames[234]);
    assertEquals("exclam", actualAllNames[4]);
    assertEquals("five", actualAllNames[24]);
    assertEquals("four", actualAllNames[23]);
    assertEquals("franc", actualAllNames[247]);
    assertEquals("gbreve", actualAllNames[249]);
    assertEquals("hyphen", actualAllNames[Short.SIZE]);
    assertEquals("minus", actualAllNames[239]);
    assertEquals("multiply", actualAllNames[240]);
    assertEquals("nonmarkingreturn", actualAllNames[2]);
    assertEquals("numbersign", actualAllNames[6]);
    assertEquals("one", actualAllNames[20]);
    assertEquals("onehalf", actualAllNames[244]);
    assertEquals("onequarter", actualAllNames[245]);
    assertEquals("onesuperior", actualAllNames[241]);
    assertEquals("parenleft", actualAllNames[11]);
    assertEquals("parenright", actualAllNames[OS2WindowsMetricsTable.FAMILY_CLASS_SYMBOLIC]);
    assertEquals("percent", actualAllNames[8]);
    assertEquals("period", actualAllNames[17]);
    assertEquals("plus", actualAllNames[14]);
    assertEquals("quotedbl", actualAllNames[5]);
    assertEquals("quotesingle", actualAllNames[CmapTable.ENCODING_WIN_UNICODE_FULL]);
    assertEquals("scedilla", actualAllNames[252]);
    assertEquals("slash", actualAllNames[18]);
    assertEquals("space", actualAllNames[3]);
    assertEquals("thorn", actualAllNames[238]);
    assertEquals("three", actualAllNames[22]);
    assertEquals("threequarters", actualAllNames[246]);
    assertEquals("threesuperior", actualAllNames[243]);
    assertEquals("two", actualAllNames[21]);
    assertEquals("twosuperior", actualAllNames[242]);
    assertEquals("yacute", actualAllNames[236]);
    assertEquals("zero", actualAllNames[19]);
    assertEquals(WGL4Names.NUMBER_OF_MAC_GLYPHS, actualAllNames.length);
  }
}
