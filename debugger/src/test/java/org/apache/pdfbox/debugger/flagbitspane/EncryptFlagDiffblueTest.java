package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EncryptFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EncryptFlag#EncryptFlag(COSDictionary)}
   *   <li>{@link EncryptFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EncryptFlag.<init>(COSDictionary)", "java.lang.String EncryptFlag.getFlagType()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Encrypt flag", (new EncryptFlag(new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link EncryptFlag#getFlagValue()}.
   * <ul>
   *   <li>Then return {@code Flag value:-1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); then return 'Flag value:-1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EncryptFlag.getFlagValue()"})
  void testGetFlagValue_thenReturnFlagValue1() {
    // Arrange, Act and Assert
    assertEquals("Flag value:-1", (new EncryptFlag(new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link EncryptFlag#getFlagBits()}.
   * <ul>
   *   <li>Then return array length is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EncryptFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return array length is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[][] EncryptFlag.getFlagBits()"})
  void testGetFlagBits_thenReturnArrayLengthIsThree() {
    // Arrange and Act
    Object[][] actualFlagBits = (new EncryptFlag(new COSDictionary())).getFlagBits();

    // Assert
    assertEquals(3, (actualFlagBits[0]).length);
    assertEquals(3, (actualFlagBits[1]).length);
    assertEquals(3, (actualFlagBits[2]).length);
    assertEquals(3, (actualFlagBits[3]).length);
    assertEquals(3, (actualFlagBits[4]).length);
    assertEquals(3, (actualFlagBits[5]).length);
    assertEquals(3, (actualFlagBits[6]).length);
    assertEquals(3, (actualFlagBits[7]).length);
    assertEquals(8, actualFlagBits.length);
  }
}
