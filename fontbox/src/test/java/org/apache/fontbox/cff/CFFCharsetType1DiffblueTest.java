package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class CFFCharsetType1DiffblueTest {
  /**
   * Method under test: {@link CFFCharsetType1#isCIDFont()}
   */
  @Test
  void testIsCIDFont() {
    // Arrange, Act and Assert
    assertFalse((new CFFCharsetType1()).isCIDFont());
  }

  /**
   * Method under test: {@link CFFCharsetType1#addCID(int, int)}
   */
  @Test
  void testAddCID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).addCID(1, 1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getSIDForGID(int)}
   */
  @Test
  void testGetSIDForGID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getSIDForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getSIDForGID(int)}
   */
  @Test
  void testGetSIDForGID2() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getSIDForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getGIDForSID(int)}
   */
  @Test
  void testGetGIDForSID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getGIDForSID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getGIDForSID(int)}
   */
  @Test
  void testGetGIDForSID2() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getGIDForSID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getGIDForCID(int)}
   */
  @Test
  void testGetGIDForCID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).getGIDForCID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getSID(String)}
   */
  @Test
  void testGetSID() {
    // Arrange, Act and Assert
    assertEquals(0, (new CFFCharsetType1()).getSID("Name"));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getSID(String)}
   */
  @Test
  void testGetSID2() {
    // Arrange
    CFFCharsetType1 cffCharsetType1 = new CFFCharsetType1();
    cffCharsetType1.addSID(1, 1, "Name");

    // Act and Assert
    assertEquals(1, cffCharsetType1.getSID("Name"));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getNameForGID(int)}
   */
  @Test
  void testGetNameForGID() {
    // Arrange, Act and Assert
    assertNull((new CFFCharsetType1()).getNameForGID(1));
  }

  /**
   * Method under test: {@link CFFCharsetType1#getCIDForGID(int)}
   */
  @Test
  void testGetCIDForGID() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new CFFCharsetType1()).getCIDForGID(1));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CFFCharsetType1}
   */
  @Test
  void testNewCFFCharsetType1() {
    // Arrange, Act and Assert
    assertFalse((new CFFCharsetType1()).isCIDFont());
  }
}
