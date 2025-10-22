package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CFFCharsetCIDDiffblueTest {
  /**
   * Test {@link CFFCharsetCID#isCIDFont()}.
   * <p>
   * Method under test: {@link CFFCharsetCID#isCIDFont()}
   */
  @Test
  @DisplayName("Test isCIDFont()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CFFCharsetCID.isCIDFont()"})
  void testIsCIDFont() {
    // Arrange, Act and Assert
    assertTrue((new CFFCharsetCID()).isCIDFont());
  }

  /**
   * Test {@link CFFCharsetCID#addSID(int, int, String)}.
   * <p>
   * Method under test: {@link CFFCharsetCID#addSID(int, int, String)}
   */
  @Test
  @DisplayName("Test addSID(int, int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFCharsetCID.addSID(int, int, String)"})
  void testAddSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).addSID(1, 1, "Name"));
  }

  /**
   * Test {@link CFFCharsetCID#getSIDForGID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetCID#getSIDForGID(int)}
   */
  @Test
  @DisplayName("Test getSIDForGID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getSIDForGID(int)"})
  void testGetSIDForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getSIDForGID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getGIDForSID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetCID#getGIDForSID(int)}
   */
  @Test
  @DisplayName("Test getGIDForSID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getGIDForSID(int)"})
  void testGetGIDForSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getGIDForSID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getGIDForCID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetCID} (default constructor) addCID one and one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetCID#getGIDForCID(int)}
   */
  @Test
  @DisplayName("Test getGIDForCID(int); given CFFCharsetCID (default constructor) addCID one and one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getGIDForCID(int)"})
  void testGetGIDForCID_givenCFFCharsetCIDAddCIDOneAndOne_thenReturnOne() {
    // Arrange
    CFFCharsetCID cffCharsetCID = new CFFCharsetCID();
    cffCharsetCID.addCID(1, 1);

    // Act and Assert
    assertEquals(1, cffCharsetCID.getGIDForCID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getGIDForCID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetCID} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetCID#getGIDForCID(int)}
   */
  @Test
  @DisplayName("Test getGIDForCID(int); given CFFCharsetCID (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getGIDForCID(int)"})
  void testGetGIDForCID_givenCFFCharsetCID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetCID()).getGIDForCID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getSID(String)}.
   * <p>
   * Method under test: {@link CFFCharsetCID#getSID(String)}
   */
  @Test
  @DisplayName("Test getSID(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getSID(String)"})
  void testGetSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getSID("Name"));
  }

  /**
   * Test {@link CFFCharsetCID#getNameForGID(int)}.
   * <p>
   * Method under test: {@link CFFCharsetCID#getNameForGID(int)}
   */
  @Test
  @DisplayName("Test getNameForGID(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String CFFCharsetCID.getNameForGID(int)"})
  void testGetNameForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getNameForGID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getCIDForGID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetCID} (default constructor) addCID one and one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetCID#getCIDForGID(int)}
   */
  @Test
  @DisplayName("Test getCIDForGID(int); given CFFCharsetCID (default constructor) addCID one and one; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getCIDForGID(int)"})
  void testGetCIDForGID_givenCFFCharsetCIDAddCIDOneAndOne_thenReturnOne() {
    // Arrange
    CFFCharsetCID cffCharsetCID = new CFFCharsetCID();
    cffCharsetCID.addCID(1, 1);

    // Act and Assert
    assertEquals(1, cffCharsetCID.getCIDForGID(1));
  }

  /**
   * Test {@link CFFCharsetCID#getCIDForGID(int)}.
   * <ul>
   *   <li>Given {@link CFFCharsetCID} (default constructor).</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CFFCharsetCID#getCIDForGID(int)}
   */
  @Test
  @DisplayName("Test getCIDForGID(int); given CFFCharsetCID (default constructor); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CFFCharsetCID.getCIDForGID(int)"})
  void testGetCIDForGID_givenCFFCharsetCID_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetCID()).getCIDForGID(1));
  }

  /**
   * Test new {@link CFFCharsetCID} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link CFFCharsetCID}
   */
  @Test
  @DisplayName("Test new CFFCharsetCID (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CFFCharsetCID.<init>()"})
  void testNewCFFCharsetCID() {
    // Arrange, Act and Assert
    assertTrue((new CFFCharsetCID()).isCIDFont());
  }
}
