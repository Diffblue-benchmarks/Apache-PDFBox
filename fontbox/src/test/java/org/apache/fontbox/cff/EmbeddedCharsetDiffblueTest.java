package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EmbeddedCharsetDiffblueTest {
  /**
   * Test {@link EmbeddedCharset#EmbeddedCharset(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return not CIDFont.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#EmbeddedCharset(boolean)}
   */
  @Test
  @DisplayName("Test new EmbeddedCharset(boolean); when 'false'; then return not CIDFont")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmbeddedCharset.<init>(boolean)"})
  void testNewEmbeddedCharset_whenFalse_thenReturnNotCIDFont() {
    // Arrange, Act and Assert
    assertFalse(new EmbeddedCharset(false).isCIDFont());
  }

  /**
   * Test {@link EmbeddedCharset#EmbeddedCharset(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return CIDFont.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#EmbeddedCharset(boolean)}
   */
  @Test
  @DisplayName("Test new EmbeddedCharset(boolean); when 'true'; then return CIDFont")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EmbeddedCharset.<init>(boolean)"})
  void testNewEmbeddedCharset_whenTrue_thenReturnCIDFont() {
    // Arrange, Act and Assert
    assertTrue(new EmbeddedCharset(true).isCIDFont());
  }

  /**
   * Test {@link EmbeddedCharset#getCIDForGID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getCIDForGID(int)}
   */
  @Test
  @DisplayName(
      "Test getCIDForGID(int); given EmbeddedCharset(boolean) with isCIDFont is 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getCIDForGID(int)"})
  void testGetCIDForGID_givenEmbeddedCharsetWithIsCIDFontIsTrue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new EmbeddedCharset(true).getCIDForGID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getCIDForGID(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getCIDForGID(int)}
   */
  @Test
  @DisplayName("Test getCIDForGID(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getCIDForGID(int)"})
  void testGetCIDForGID_thenReturnOne() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(true);
    embeddedCharset.addCID(1, 1);

    // Act and Assert
    assertEquals(1, embeddedCharset.getCIDForGID(1));
  }

  /**
   * Test {@link EmbeddedCharset#isCIDFont()}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#isCIDFont()}
   */
  @Test
  @DisplayName(
      "Test isCIDFont(); given EmbeddedCharset(boolean) with isCIDFont is 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmbeddedCharset.isCIDFont()"})
  void testIsCIDFont_givenEmbeddedCharsetWithIsCIDFontIsFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EmbeddedCharset(false).isCIDFont());
  }

  /**
   * Test {@link EmbeddedCharset#isCIDFont()}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#isCIDFont()}
   */
  @Test
  @DisplayName(
      "Test isCIDFont(); given EmbeddedCharset(boolean) with isCIDFont is 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EmbeddedCharset.isCIDFont()"})
  void testIsCIDFont_givenEmbeddedCharsetWithIsCIDFontIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new EmbeddedCharset(true).isCIDFont());
  }

  /**
   * Test {@link EmbeddedCharset#getSIDForGID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#addSID(int, int, String)} with gid is one and sid is two and
   *       name is {@code 42}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getSIDForGID(int)}
   */
  @Test
  @DisplayName(
      "Test getSIDForGID(int); given addSID(int, int, String) with gid is one and sid is two and name is '42'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getSIDForGID(int)"})
  void testGetSIDForGID_givenAddSIDWithGidIsOneAndSidIsTwoAndNameIs42_thenReturnTwo() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(1, 2, "42");

    // Act and Assert
    assertEquals(2, embeddedCharset.getSIDForGID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getSIDForGID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getSIDForGID(int)}
   */
  @Test
  @DisplayName(
      "Test getSIDForGID(int); given EmbeddedCharset(boolean) with isCIDFont is 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getSIDForGID(int)"})
  void testGetSIDForGID_givenEmbeddedCharsetWithIsCIDFontIsFalse_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new EmbeddedCharset(false).getSIDForGID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getGIDForSID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#addSID(int, int, String)} with gid is two and sid is one and
   *       name is {@code 42}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getGIDForSID(int)}
   */
  @Test
  @DisplayName(
      "Test getGIDForSID(int); given addSID(int, int, String) with gid is two and sid is one and name is '42'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getGIDForSID(int)"})
  void testGetGIDForSID_givenAddSIDWithGidIsTwoAndSidIsOneAndNameIs42_thenReturnTwo() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(2, 1, "42");

    // Act and Assert
    assertEquals(2, embeddedCharset.getGIDForSID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getGIDForSID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getGIDForSID(int)}
   */
  @Test
  @DisplayName(
      "Test getGIDForSID(int); given EmbeddedCharset(boolean) with isCIDFont is 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getGIDForSID(int)"})
  void testGetGIDForSID_givenEmbeddedCharsetWithIsCIDFontIsFalse_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new EmbeddedCharset(false).getGIDForSID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getGIDForCID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code true}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getGIDForCID(int)}
   */
  @Test
  @DisplayName(
      "Test getGIDForCID(int); given EmbeddedCharset(boolean) with isCIDFont is 'true'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getGIDForCID(int)"})
  void testGetGIDForCID_givenEmbeddedCharsetWithIsCIDFontIsTrue_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new EmbeddedCharset(true).getGIDForCID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getGIDForCID(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getGIDForCID(int)}
   */
  @Test
  @DisplayName("Test getGIDForCID(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getGIDForCID(int)"})
  void testGetGIDForCID_thenReturnOne() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(true);
    embeddedCharset.addCID(1, 1);

    // Act and Assert
    assertEquals(1, embeddedCharset.getGIDForCID(1));
  }

  /**
   * Test {@link EmbeddedCharset#getSID(String)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#addSID(int, int, String)} with gid is two and sid is two and
   *       {@code Name}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getSID(String)}
   */
  @Test
  @DisplayName(
      "Test getSID(String); given addSID(int, int, String) with gid is two and sid is two and 'Name'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getSID(String)"})
  void testGetSID_givenAddSIDWithGidIsTwoAndSidIsTwoAndName_thenReturnTwo() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(2, 2, "Name");

    // Act and Assert
    assertEquals(2, embeddedCharset.getSID("Name"));
  }

  /**
   * Test {@link EmbeddedCharset#getSID(String)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code false}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getSID(String)}
   */
  @Test
  @DisplayName(
      "Test getSID(String); given EmbeddedCharset(boolean) with isCIDFont is 'false'; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EmbeddedCharset.getSID(String)"})
  void testGetSID_givenEmbeddedCharsetWithIsCIDFontIsFalse_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, new EmbeddedCharset(false).getSID("Name"));
  }

  /**
   * Test {@link EmbeddedCharset#getNameForGID(int)}.
   *
   * <ul>
   *   <li>Given {@link EmbeddedCharset#EmbeddedCharset(boolean)} with isCIDFont is {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EmbeddedCharset#getNameForGID(int)}
   */
  @Test
  @DisplayName(
      "Test getNameForGID(int); given EmbeddedCharset(boolean) with isCIDFont is 'false'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EmbeddedCharset.getNameForGID(int)"})
  void testGetNameForGID_givenEmbeddedCharsetWithIsCIDFontIsFalse_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new EmbeddedCharset(false).getNameForGID(1));
  }
}
