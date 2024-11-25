package org.apache.pdfbox.debugger.flagbitspane;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
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
  void testGettersAndSetters() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Signature flag", (new SigFlag(document, new COSDictionary())).getFlagType());
  }

  /**
   * Test {@link SigFlag#getFlagValue()}.
   * <p>
   * Method under test: {@link SigFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue()")
  void testGetFlagValue() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Flag value: -1", (new SigFlag(document, new COSDictionary())).getFlagValue());
  }

  /**
   * Test {@link SigFlag#getFlagValue()}.
   * <p>
   * Method under test: {@link SigFlag#getFlagValue()}
   */
  @Test
  @DisplayName("Test getFlagValue()")
  void testGetFlagValue2() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act and Assert
    assertEquals("Flag value: -1", (new SigFlag(document, new COSStream())).getFlagValue());
  }

  /**
   * Test {@link SigFlag#getFlagBits()}.
   * <p>
   * Method under test: {@link SigFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits()")
  void testGetFlagBits() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    Object[][] actualFlagBits = (new SigFlag(document, new COSDictionary())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[1];
    assertEquals("AppendOnly", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("SignaturesExist", objectArray2[1]);
    assertEquals(2, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
  }

  /**
   * Test {@link SigFlag#getFlagBits()}.
   * <p>
   * Method under test: {@link SigFlag#getFlagBits()}
   */
  @Test
  @DisplayName("Test getFlagBits()")
  void testGetFlagBits2() {
    // Arrange
    PDDocument document = new PDDocument();

    // Act
    Object[][] actualFlagBits = (new SigFlag(document, new COSStream())).getFlagBits();

    // Assert
    Object[] objectArray = actualFlagBits[1];
    assertEquals("AppendOnly", objectArray[1]);
    Object[] objectArray2 = actualFlagBits[0];
    assertEquals("SignaturesExist", objectArray2[1]);
    assertEquals(2, actualFlagBits.length);
    assertEquals(3, objectArray2.length);
    assertEquals(3, objectArray.length);
  }
}
