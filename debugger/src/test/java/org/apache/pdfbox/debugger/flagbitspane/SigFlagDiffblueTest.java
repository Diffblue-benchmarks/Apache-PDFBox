package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SigFlagDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SigFlag#SigFlag(PDDocument, COSDictionary)}
   *   <li>{@link SigFlag#getFlagType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SigFlag.<init>(PDDocument, COSDictionary)", "java.lang.String SigFlag.getFlagType()"})
  void testGettersAndSetters() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Signature flag", (new SigFlag(document, new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link SigFlag#getFlagValue()}.
   * <ul>
   *   <li>Then return {@code Flag value: -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue(); then return 'Flag value: -1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String SigFlag.getFlagValue()"})
  void testGetFlagValue_thenReturnFlagValue1() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Flag value: -1", (new SigFlag(document, new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link SigFlag#getFlagBits()}.
   * <ul>
   *   <li>Then return second element is {@code AppendOnly}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SigFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits(); then return second element is 'AppendOnly'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object[][] SigFlag.getFlagBits()"})
  void testGetFlagBits_thenReturnSecondElementIsAppendOnly() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    Object[][] actualFlagBits = (new SigFlag(document, new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[1];
    assertEquals("AppendOnly", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("SignaturesExist", objectArray2[1]);
    assertEquals(1, ((Integer) objectArray2[0]).intValue());
    assertEquals(2, ((Integer) objectArray[0]).intValue());
    assertEquals(2, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
    assertFalse((Boolean) objectArray2[2]);
    assertFalse((Boolean) objectArray[2]);
  }
}
