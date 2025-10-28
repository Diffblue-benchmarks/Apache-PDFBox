package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CFFCharsetCIDDiffblueTest {
  /**
   * Method under test: {@link CFFCharsetCID#isCIDFont()}
   */
  @Test
  void testIsCIDFont() {
    // Arrange, Act and Assert
    assertTrue((new CFFCharsetCID()).isCIDFont());
  }

  /**
   * Method under test: {@link CFFCharsetCID#addSID(int, int, String)}
   */
  @Test
  void testAddSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).addSID(1, 1, "Name"));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getSIDForGID(int)}
   */
  @Test
  void testGetSIDForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getSIDForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getGIDForSID(int)}
   */
  @Test
  void testGetGIDForSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getGIDForSID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getGIDForCID(int)}
   */
  @Test
  void testGetGIDForCID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetCID()).getGIDForCID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getGIDForCID(int)}
   */
  @Test
  void testGetGIDForCID2() {
    // Arrange
    CFFCharsetCID cffCharsetCID = new CFFCharsetCID();
    cffCharsetCID.addCID(1, 1);

    // Act and Assert
    assertEquals(1, cffCharsetCID.getGIDForCID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getSID(String)}
   */
  @Test
  void testGetSID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getSID("Name"));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getNameForGID(int)}
   */
  @Test
  void testGetNameForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetCID()).getNameForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getCIDForGID(int)}
   */
  @Test
  void testGetCIDForGID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetCID()).getCIDForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetCID#getCIDForGID(int)}
   */
  @Test
  void testGetCIDForGID2() {
    // Arrange
    CFFCharsetCID cffCharsetCID = new CFFCharsetCID();
    cffCharsetCID.addCID(1, 1);

    // Act and Assert
    assertEquals(1, cffCharsetCID.getCIDForGID(1));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CFFCharsetCID}
   */
  @Test
  void testNewCFFCharsetCID() {
    // Arrange, Act and Assert
    assertTrue((new CFFCharsetCID()).isCIDFont());
  }
}
