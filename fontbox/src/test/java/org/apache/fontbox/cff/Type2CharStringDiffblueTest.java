package org.apache.fontbox.cff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.type1.Type1CharStringReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class Type2CharStringDiffblueTest {
  /**
   * Test {@link Type2CharString#Type2CharString(Type1CharStringReader, String, String, int, List,
   * int, int)}.
   *
   * <p>Method under test: {@link Type2CharString#Type2CharString(Type1CharStringReader, String,
   * String, int, List, int, int)}
   */
  @Test
  @DisplayName(
      "Test new Type2CharString(Type1CharStringReader, String, String, int, List, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Type2CharString.<init>(Type1CharStringReader, String, String, int, List, int, int)"
  })
  void testNewType2CharString() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act
    Type2CharString actualType2CharString =
        new Type2CharString(font, "Font Name", "Glyph Name", 1, new ArrayList<>(), 1, 1);

    // Assert
    assertTrue(actualType2CharString.getBounds() instanceof Float);
    assertEquals("Glyph Name", actualType2CharString.getName());
    assertNull(actualType2CharString.getLastSequenceEntry());
    assertEquals(0, actualType2CharString.getWidth());
    assertEquals(1, actualType2CharString.getGID());
    assertTrue(actualType2CharString.isSequenceEmpty());
  }

  /**
   * Test {@link Type2CharString#getGID()}.
   *
   * <p>Method under test: {@link Type2CharString#getGID()}
   */
  @Test
  @DisplayName("Test getGID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Type2CharString.getGID()"})
  void testGetGID() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);
    Type2CharString type2CharString =
        new Type2CharString(font, "Font Name", "Glyph Name", 1, new ArrayList<>(), 1, 1);

    // Act and Assert
    assertEquals(1, type2CharString.getGID());
  }
}
