package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFType1FontDiffblueTest {
  /**
   * Test {@link CFFType1Font#hasGlyph(String)}.
   * <ul>
   *   <li>Given {@link CFFCharsetType1#addSID(int, int, String)} with gid is two and sid is zero and name is {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); given addSID(int, int, String) with gid is two and sid is zero and name is '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFType1Font.hasGlyph(String)"})
  void testHasGlyph_givenAddSIDWithGidIsTwoAndSidIsZeroAndNameIs42_thenReturnTrue() {
    // Arrange
    CFFCharsetType1 charset = new CFFCharsetType1();
    charset.addSID(2, 0, "42");

    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(charset);

    // Act and Assert
    assertTrue(cffType1Font.hasGlyph("Name"));
  }

  /**
   * Test {@link CFFType1Font#hasGlyph(String)}.
   * <ul>
   *   <li>Given {@link CFFType1Font} (default constructor) Charset is {@link CFFCharsetType1} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFType1Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); given CFFType1Font (default constructor) Charset is CFFCharsetType1 (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFType1Font.hasGlyph(String)"})
  void testHasGlyph_givenCFFType1FontCharsetIsCFFCharsetType1_thenReturnFalse() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(new CFFCharsetType1());

    // Act and Assert
    assertFalse(cffType1Font.hasGlyph("Name"));
  }

  /**
   * Test {@link CFFType1Font#nameToGID(String)}.
   * <ul>
   *   <li>Given {@link CFFType1Font} (default constructor) Charset is {@link CFFCharsetType1} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFType1Font#nameToGID(String)}
   */
  @Test
  @DisplayName("Test nameToGID(String); given CFFType1Font (default constructor) Charset is CFFCharsetType1 (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFType1Font.nameToGID(String)"})
  void testNameToGID_givenCFFType1FontCharsetIsCFFCharsetType1_thenReturnZero() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();
    cffType1Font.setCharset(new CFFCharsetType1());

    // Act and Assert
    assertEquals(0, cffType1Font.nameToGID("Name"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CFFType1Font#setEncoding(CFFEncoding)}
   *   <li>{@link CFFType1Font#getPrivateDict()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map CFFType1Font.getPrivateDict()", "void CFFType1Font.setEncoding(CFFEncoding)"})
  void testGettersAndSetters() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.setEncoding(CFFExpertEncoding.getInstance());

    // Assert
    assertTrue(cffType1Font.getPrivateDict().isEmpty());
  }

  /**
   * Test {@link CFFType1Font#addToPrivateDict(String, Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link CFFType1Font} (default constructor) PrivateDict Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFType1Font#addToPrivateDict(String, Object)}
   */
  @Test
  @DisplayName("Test addToPrivateDict(String, Object); when 'null'; then CFFType1Font (default constructor) PrivateDict Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFType1Font.addToPrivateDict(String, Object)"})
  void testAddToPrivateDict_whenNull_thenCFFType1FontPrivateDictEmpty() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.addToPrivateDict("Name", null);

    // Assert that nothing has changed
    assertTrue(cffType1Font.getPrivateDict().isEmpty());
  }

  /**
   * Test {@link CFFType1Font#addToPrivateDict(String, Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link CFFType1Font} (default constructor) PrivateDict size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFType1Font#addToPrivateDict(String, Object)}
   */
  @Test
  @DisplayName("Test addToPrivateDict(String, Object); when 'Value'; then CFFType1Font (default constructor) PrivateDict size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFType1Font.addToPrivateDict(String, Object)"})
  void testAddToPrivateDict_whenValue_thenCFFType1FontPrivateDictSizeIsOne() {
    // Arrange
    CFFType1Font cffType1Font = new CFFType1Font();

    // Act
    cffType1Font.addToPrivateDict("Name", "Value");

    // Assert
    Map<String, Object> privateDict = cffType1Font.getPrivateDict();
    assertEquals(1, privateDict.size());
    assertEquals("Value", privateDict.get("Name"));
  }

  /**
   * Test {@link CFFType1Font#getEncoding()}.
   * <p>
   * Method under test: {@link CFFType1Font#getEncoding()}
   */
  @Test
  @DisplayName("Test getEncoding()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CFFEncoding CFFType1Font.getEncoding()"})
  void testGetEncoding() {
    // Arrange, Act and Assert
    assertNull((new CFFType1Font()).getEncoding());
  }

  /**
   * Test new {@link CFFType1Font} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CFFType1Font}
   */
  @Test
  @DisplayName("Test new CFFType1Font (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFType1Font.<init>()"})
  void testNewCFFType1Font() {
    // Arrange and Act
    CFFType1Font actualCffType1Font = new CFFType1Font();

    // Assert
    assertNull(actualCffType1Font.charStrings);
    assertNull(actualCffType1Font.globalSubrIndex);
    assertNull(actualCffType1Font.getName());
    assertNull(actualCffType1Font.getFontMatrix());
    assertNull(actualCffType1Font.getCharset());
    assertNull(actualCffType1Font.getEncoding());
    assertTrue(actualCffType1Font.getTopDict().isEmpty());
    assertTrue(actualCffType1Font.getPrivateDict().isEmpty());
  }
}
