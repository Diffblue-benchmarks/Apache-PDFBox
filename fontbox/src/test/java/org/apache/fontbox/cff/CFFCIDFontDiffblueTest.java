package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFCIDFontDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CFFCIDFont#setFdSelect(FDSelect)}
   *   <li>{@link CFFCIDFont#setFontDict(List)}
   *   <li>{@link CFFCIDFont#setOrdering(String)}
   *   <li>{@link CFFCIDFont#setPrivDict(List)}
   *   <li>{@link CFFCIDFont#setRegistry(String)}
   *   <li>{@link CFFCIDFont#setSupplement(int)}
   *   <li>{@link CFFCIDFont#getFdSelect()}
   *   <li>{@link CFFCIDFont#getFontDicts()}
   *   <li>{@link CFFCIDFont#getOrdering()}
   *   <li>{@link CFFCIDFont#getPrivDicts()}
   *   <li>{@link CFFCIDFont#getRegistry()}
   *   <li>{@link CFFCIDFont#getSupplement()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FDSelect CFFCIDFont.getFdSelect()", "List CFFCIDFont.getFontDicts()",
      "String CFFCIDFont.getOrdering()", "List CFFCIDFont.getPrivDicts()", "String CFFCIDFont.getRegistry()",
      "int CFFCIDFont.getSupplement()", "void CFFCIDFont.setFdSelect(FDSelect)", "void CFFCIDFont.setFontDict(List)",
      "void CFFCIDFont.setOrdering(String)", "void CFFCIDFont.setPrivDict(List)", "void CFFCIDFont.setRegistry(String)",
      "void CFFCIDFont.setSupplement(int)"})
  void testGettersAndSetters() {
    // Arrange
    CFFCIDFont cffcidFont = new CFFCIDFont();
    FDSelect fdSelect = mock(FDSelect.class);

    // Act
    cffcidFont.setFdSelect(fdSelect);
    ArrayList<Map<String, Object>> fontDict = new ArrayList<>();
    cffcidFont.setFontDict(fontDict);
    cffcidFont.setOrdering("Ordering");
    ArrayList<Map<String, Object>> privDict = new ArrayList<>();
    cffcidFont.setPrivDict(privDict);
    cffcidFont.setRegistry("Registry");
    cffcidFont.setSupplement(1);
    FDSelect actualFdSelect = cffcidFont.getFdSelect();
    List<Map<String, Object>> actualFontDicts = cffcidFont.getFontDicts();
    String actualOrdering = cffcidFont.getOrdering();
    List<Map<String, Object>> actualPrivDicts = cffcidFont.getPrivDicts();
    String actualRegistry = cffcidFont.getRegistry();

    // Assert
    assertEquals("Ordering", actualOrdering);
    assertEquals("Registry", actualRegistry);
    assertEquals(1, cffcidFont.getSupplement());
    assertTrue(actualFontDicts.isEmpty());
    assertTrue(actualPrivDicts.isEmpty());
    assertSame(fontDict, actualFontDicts);
    assertSame(privDict, actualPrivDicts);
    assertSame(fdSelect, actualFdSelect);
  }

  /**
   * Test {@link CFFCIDFont#getPath(String)}.
   * <ul>
   *   <li>Given {@link CFFCIDFont} (default constructor).</li>
   *   <li>When {@code Selector}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCIDFont#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String); given CFFCIDFont (default constructor); when 'Selector'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.awt.geom.GeneralPath CFFCIDFont.getPath(String)"})
  void testGetPath_givenCFFCIDFont_whenSelector_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CFFCIDFont()).getPath("Selector"));
  }

  /**
   * Test {@link CFFCIDFont#getWidth(String)}.
   * <ul>
   *   <li>Given {@link CFFCIDFont} (default constructor).</li>
   *   <li>When {@code Selector}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCIDFont#getWidth(String)}
   */
  @Test
  @DisplayName("Test getWidth(String); given CFFCIDFont (default constructor); when 'Selector'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float CFFCIDFont.getWidth(String)"})
  void testGetWidth_givenCFFCIDFont_whenSelector_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CFFCIDFont()).getWidth("Selector"));
  }

  /**
   * Test {@link CFFCIDFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code \42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCIDFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when '\\42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFCIDFont.hasGlyph(String)"})
  void testHasGlyph_when42_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new CFFCIDFont()).hasGlyph("\\42"));
  }

  /**
   * Test {@link CFFCIDFont#hasGlyph(String)}.
   * <ul>
   *   <li>When {@code Selector}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCIDFont#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); when 'Selector'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFCIDFont.hasGlyph(String)"})
  void testHasGlyph_whenSelector_thenThrowIllegalArgumentException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new CFFCIDFont()).hasGlyph("Selector"));
  }

  /**
   * Test new {@link CFFCIDFont} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CFFCIDFont}
   */
  @Test
  @DisplayName("Test new CFFCIDFont (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFCIDFont.<init>()"})
  void testNewCFFCIDFont() {
    // Arrange and Act
    CFFCIDFont actualCffcidFont = new CFFCIDFont();

    // Assert
    assertNull(actualCffcidFont.charStrings);
    assertNull(actualCffcidFont.globalSubrIndex);
    assertNull(actualCffcidFont.getOrdering());
    assertNull(actualCffcidFont.getRegistry());
    assertNull(actualCffcidFont.getName());
    assertNull(actualCffcidFont.getFontMatrix());
    assertNull(actualCffcidFont.getCharset());
    assertNull(actualCffcidFont.getFdSelect());
    assertEquals(0, actualCffcidFont.getSupplement());
    List<Map<String, Object>> fontDicts = actualCffcidFont.getFontDicts();
    assertTrue(fontDicts.isEmpty());
    assertTrue(actualCffcidFont.getTopDict().isEmpty());
    assertSame(fontDicts, actualCffcidFont.getPrivDicts());
  }
}
