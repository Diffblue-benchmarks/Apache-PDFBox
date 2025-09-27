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

class CIDKeyedType2CharStringDiffblueTest {
  /**
   * Test {@link CIDKeyedType2CharString#CIDKeyedType2CharString(Type1CharStringReader, String, int,
   * int, List, int, int)}.
   *
   * <p>Method under test: {@link
   * CIDKeyedType2CharString#CIDKeyedType2CharString(Type1CharStringReader, String, int, int, List,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test new CIDKeyedType2CharString(Type1CharStringReader, String, int, int, List, int, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CIDKeyedType2CharString.<init>(Type1CharStringReader, String, int, int, List, int, int)"
  })
  void testNewCIDKeyedType2CharString() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);

    // Act
    CIDKeyedType2CharString actualCidKeyedType2CharString =
        new CIDKeyedType2CharString(font, "Font Name", 1, 1, new ArrayList<>(), 1, 1);

    // Assert
    assertTrue(actualCidKeyedType2CharString.getBounds() instanceof Float);
    assertEquals("0001", actualCidKeyedType2CharString.getName());
    assertNull(actualCidKeyedType2CharString.getLastSequenceEntry());
    assertEquals(0, actualCidKeyedType2CharString.getWidth());
    assertEquals(1, actualCidKeyedType2CharString.getCID());
    assertEquals(1, actualCidKeyedType2CharString.getGID());
    assertTrue(actualCidKeyedType2CharString.isSequenceEmpty());
  }

  /**
   * Test {@link CIDKeyedType2CharString#getCID()}.
   *
   * <p>Method under test: {@link CIDKeyedType2CharString#getCID()}
   */
  @Test
  @DisplayName("Test getCID()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int CIDKeyedType2CharString.getCID()"})
  void testGetCID() {
    // Arrange
    Type1CharStringReader font = mock(Type1CharStringReader.class);
    CIDKeyedType2CharString cidKeyedType2CharString =
        new CIDKeyedType2CharString(font, "Font Name", 1, 1, new ArrayList<>(), 1, 1);

    // Act and Assert
    assertEquals(1, cidKeyedType2CharString.getCID());
  }
}
