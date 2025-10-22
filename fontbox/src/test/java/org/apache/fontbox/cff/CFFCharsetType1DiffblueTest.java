package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFCharsetType1DiffblueTest {
  /**
   * Test {@link CFFCharsetType1#isCIDFont()}.
   * <p>
   * Method under test: {@link CFFCharsetType1#isCIDFont()}
   */
  @Test
  @DisplayName("Test isCIDFont()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFCharsetType1.isCIDFont()"})
  void testIsCIDFont() {
    // Arrange, Act and Assert
    assertFalse((new CFFCharsetType1()).isCIDFont());
  }

  /**
   * Test {@link CFFCharsetType1#addCID(int, int)}.
   * <p>
   * Method under test: {@link CFFCharsetType1#addCID(int, int)}
   */
  @Test
  @DisplayName("Test addCID(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFCharsetType1.addCID(int, int)"})
  void testAddCID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).addCID(1, 1));
  }

  /**
   * Test {@link CFFCharsetType1#getSIDForGID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetType1#addSID(int, int, String)} with gid is one and sid is one and {@code Name}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getSIDForGID(int)}
   */
  @Test
  @DisplayName("Test getSIDForGID(int); given addSID(int, int, String) with gid is one and sid is one and 'Name'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getSIDForGID(int)"})
  void testGetSIDForGID_givenAddSIDWithGidIsOneAndSidIsOneAndName_thenReturnOne() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getSIDForGID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getSIDForGID(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getSIDForGID(int)}
   */
  @Test
  @DisplayName("Test getSIDForGID(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getSIDForGID(int)"})
  void testGetSIDForGID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getSIDForGID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getGIDForSID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetType1#addSID(int, int, String)} with gid is one and sid is one and {@code Name}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getGIDForSID(int)}
   */
  @Test
  @DisplayName("Test getGIDForSID(int); given addSID(int, int, String) with gid is one and sid is one and 'Name'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getGIDForSID(int)"})
  void testGetGIDForSID_givenAddSIDWithGidIsOneAndSidIsOneAndName_thenReturnOne() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getGIDForSID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getGIDForSID(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getGIDForSID(int)}
   */
  @Test
  @DisplayName("Test getGIDForSID(int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getGIDForSID(int)"})
  void testGetGIDForSID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getGIDForSID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getGIDForCID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetType1#getGIDForCID(int)}
   */
  @Test
  @DisplayName("Test getGIDForCID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getGIDForCID(int)"})
  void testGetGIDForCID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).getGIDForCID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getSID(String)}.
   * <ul>
   *   <li>Given {@link CFFCharsetType1#addSID(int, int, String)} with gid is one and sid is one and {@code Name}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getSID(String)}
   */
  @Test
  @DisplayName("Test getSID(String); given addSID(int, int, String) with gid is one and sid is one and 'Name'; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getSID(String)"})
  void testGetSID_givenAddSIDWithGidIsOneAndSidIsOneAndName_thenReturnOne() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getSID("Name"));
  }

  /**
   * Test {@link CFFCharsetType1#getSID(String)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetType1#getSID(String)}
   */
  @Test
  @DisplayName("Test getSID(String); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getSID(String)"})
  void testGetSID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getSID("Name"));
  }

  /**
   * Test {@link CFFCharsetType1#getNameForGID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetType1#getNameForGID(int)}
   */
  @Test
  @DisplayName("Test getNameForGID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CFFCharsetType1.getNameForGID(int)"})
  void testGetNameForGID() {
    // Arrange, Act and Assert
    assertNull((new CFFCharsetType1()).getNameForGID(1));
  }

  /**
   * Test {@link CFFCharsetType1#getCIDForGID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetType1#getCIDForGID(int)}
   */
  @Test
  @DisplayName("Test getCIDForGID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetType1.getCIDForGID(int)"})
  void testGetCIDForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).getCIDForGID(1));
  }

  /**
   * Test new {@link CFFCharsetType1} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CFFCharsetType1}
   */
  @Test
  @DisplayName("Test new CFFCharsetType1 (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFCharsetType1.<init>()"})
  void testNewCFFCharsetType1() {
    // Arrange, Act and Assert
    assertFalse((new CFFCharsetType1()).isCIDFont());
  }
}
