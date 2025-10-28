package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EmbeddedCharsetDiffblueTest {
  /**
   * Method under test: {@link EmbeddedCharset#getCIDForGID(int)}
   */
  @Test
  void testGetCIDForGID() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmbeddedCharset(true)).getCIDForGID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getCIDForGID(int)}
   */
  @Test
  void testGetCIDForGID2() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(true);
    embeddedCharset.addCID(1, 1);

    // Act and Assert
    assertEquals(1, embeddedCharset.getCIDForGID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#isCIDFont()}
   */
  @Test
  void testIsCIDFont() {
    // Arrange, Act and Assert
    assertTrue((new EmbeddedCharset(true)).isCIDFont());
    assertFalse((new EmbeddedCharset(false)).isCIDFont());
  }

  /**
   * Method under test: {@link EmbeddedCharset#getSIDForGID(int)}
   */
  @Test
  void testGetSIDForGID() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmbeddedCharset(false)).getSIDForGID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getSIDForGID(int)}
   */
  @Test
  void testGetSIDForGID2() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(1, 2, "42");

    // Act and Assert
    assertEquals(2, embeddedCharset.getSIDForGID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getGIDForSID(int)}
   */
  @Test
  void testGetGIDForSID() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmbeddedCharset(false)).getGIDForSID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getGIDForSID(int)}
   */
  @Test
  void testGetGIDForSID2() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(2, 1, "42");

    // Act and Assert
    assertEquals(2, embeddedCharset.getGIDForSID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getGIDForCID(int)}
   */
  @Test
  void testGetGIDForCID() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmbeddedCharset(true)).getGIDForCID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getGIDForCID(int)}
   */
  @Test
  void testGetGIDForCID2() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(true);
    embeddedCharset.addCID(1, 1);

    // Act and Assert
    assertEquals(1, embeddedCharset.getGIDForCID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getSID(String)}
   */
  @Test
  void testGetSID() {
    // Arrange, Act and Assert
    assertEquals(0, (new EmbeddedCharset(false)).getSID("Name"));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getSID(String)}
   */
  @Test
  void testGetSID2() {
    // Arrange
    EmbeddedCharset embeddedCharset = new EmbeddedCharset(false);
    embeddedCharset.addSID(2, 2, "Name");

    // Act and Assert
    assertEquals(2, embeddedCharset.getSID("Name"));
  }

  /**
   * Method under test: {@link EmbeddedCharset#getNameForGID(int)}
   */
  @Test
  void testGetNameForGID() {
    // Arrange, Act and Assert
    assertNull((new EmbeddedCharset(false)).getNameForGID(1));
  }

  /**
   * Method under test: {@link EmbeddedCharset#EmbeddedCharset(boolean)}
   */
  @Test
  void testNewEmbeddedCharset() {
    // Arrange, Act and Assert
    assertTrue((new EmbeddedCharset(true)).isCIDFont());
    assertFalse((new EmbeddedCharset(false)).isCIDFont());
  }
}
