package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FontFlagDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FontFlag#FontFlag(COSDictionary)}
   *   <li>{@link FontFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FontFlag.<init>(COSDictionary)",
    "java.lang.String FontFlag.getFlagType()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Font flag", new FontFlag(new COSDictionary()).getFlagType());
  }

  /**
   * Test {@link FontFlag#getFlagValue()}.
   *
   * <ul>
   *   <li>Then return {@code Flag value:-1}.
   * </ul>
   *
   * <p>Method under test: {@link FontFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); then return 'Flag value:-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String FontFlag.getFlagValue()"})
  void testGetFlagValue_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", new FontFlag(new COSDictionary()).getFlagValue());
  }

  /**
   * Test {@link FontFlag#getFlagBits()}.
   *
   * <ul>
   *   <li>Then return array length is three.
   * </ul>
   *
   * <p>Method under test: {@link FontFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return array length is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object[][] FontFlag.getFlagBits()"})
  void testGetFlagBits_thenReturnArrayLengthIsThree() {
    // Arrange and Act
    Object[][] actualFlagBits = new FontFlag(new COSDictionary()).getFlagBits();

    // Assert
    assertEquals(3, actualFlagBits[0].length);
    assertEquals(3, actualFlagBits[1].length);
    assertEquals(3, actualFlagBits[2].length);
    assertEquals(3, actualFlagBits[3].length);
    assertEquals(3, actualFlagBits[4].length);
    assertEquals(3, actualFlagBits[5].length);
    assertEquals(3, actualFlagBits[6].length);
    assertEquals(3, actualFlagBits[7].length);
    assertEquals(3, actualFlagBits[8].length);
    assertEquals(9, actualFlagBits.length);
  }
}
