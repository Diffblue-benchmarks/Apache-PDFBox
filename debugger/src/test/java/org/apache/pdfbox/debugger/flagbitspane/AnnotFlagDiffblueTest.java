package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnnotFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AnnotFlag#AnnotFlag(COSDictionary)}
   *   <li>{@link AnnotFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AnnotFlag.<init>(COSDictionary)", "java.lang.String AnnotFlag.getFlagType()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Annot flag", (new AnnotFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link AnnotFlag#getFlagValue()}.
   * <ul>
   *   <li>Then return {@code Flag value: -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); then return 'Flag value: -1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AnnotFlag.getFlagValue()"})
  void testGetFlagValue_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value: -1", (new AnnotFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link AnnotFlag#getFlagBits()}.
   * <ul>
   *   <li>Then return array length is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link AnnotFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return array length is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[][] AnnotFlag.getFlagBits()"})
  void testGetFlagBits_thenReturnArrayLengthIsTen() {
    // Arrange and Act
    Object[][] actualFlagBits = (new AnnotFlag(new COSDictionary())).getFlagBits();

    // Assert
    assertEquals(10, actualFlagBits.length);
    assertEquals(3, (actualFlagBits[0]).length);
    assertEquals(3, (actualFlagBits[1]).length);
    assertEquals(3, (actualFlagBits[2]).length);
    assertEquals(3, (actualFlagBits[3]).length);
    assertEquals(3, (actualFlagBits[4]).length);
    assertEquals(3, (actualFlagBits[5]).length);
    assertEquals(3, (actualFlagBits[6]).length);
    assertEquals(3, (actualFlagBits[7]).length);
    assertEquals(3, (actualFlagBits[8]).length);
    assertEquals(3, (actualFlagBits[9]).length);
  }
}
