package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDNamedDestinationDiffblueTest {
  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return COSObject is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination()}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return COSObject is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.<init>()", "void PDNamedDestination.<init>(COSName)",
      "void PDNamedDestination.<init>(COSString)", "COSBase PDNamedDestination.getCOSObject()"})
  void testGettersAndSetters_thenReturnCOSObjectIsNull() {
    // Arrange, Act and Assert
    assertNull((new PDNamedDestination()).getCOSObject());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return COSObject is parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination(COSString)}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return COSObject is parseHex '0123456789ABCDEF'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.<init>()", "void PDNamedDestination.<init>(COSName)",
      "void PDNamedDestination.<init>(COSString)", "COSBase PDNamedDestination.getCOSObject()"})
  void testGettersAndSetters_thenReturnCOSObjectIsParseHex0123456789abcdef() throws IOException {
    // Arrange
    COSString dest = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertSame(dest, (new PDNamedDestination(dest)).getCOSObject());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link COSName#A}.</li>
   *   <li>Then return COSObject is COSObject {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination(COSName)}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when A; then return COSObject is COSObject A")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.<init>()", "void PDNamedDestination.<init>(COSName)",
      "void PDNamedDestination.<init>(COSString)", "COSBase PDNamedDestination.getCOSObject()"})
  void testGettersAndSetters_whenA_thenReturnCOSObjectIsCOSObjectA() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDNamedDestination(COSName.A)).getCOSObject();

    // Assert
    assertSame(((COSName) actualCOSObject).A, actualCOSObject);
  }

  /**
   * Test {@link PDNamedDestination#PDNamedDestination(String)}.
   * <p>
   * Method under test: {@link PDNamedDestination#PDNamedDestination(String)}
   */
  @Test
  @DisplayName("Test new PDNamedDestination(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.<init>(String)"})
  void testNewPDNamedDestination() throws UnsupportedEncodingException {
    // Arrange and Act
    PDNamedDestination actualPdNamedDestination = new PDNamedDestination("Dest");

    // Assert
    COSBase cOSObject = actualPdNamedDestination.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertEquals("44657374", ((COSString) cOSObject).toHexString());
    assertEquals("Dest", ((COSString) cOSObject).getASCII());
    assertEquals("Dest", ((COSString) cOSObject).getString());
    assertEquals("Dest", actualPdNamedDestination.getNamedDestination());
    assertNull(cOSObject.getKey());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
    byte[] expectedBytes = "Dest".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSObject).getBytes());
  }

  /**
   * Test {@link PDNamedDestination#getNamedDestination()}.
   * <ul>
   *   <li>Given {@link PDNamedDestination#PDNamedDestination(COSName)} with dest is {@link COSName#A}.</li>
   *   <li>Then return {@code A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); given PDNamedDestination(COSName) with dest is A; then return 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDNamedDestination.getNamedDestination()"})
  void testGetNamedDestination_givenPDNamedDestinationWithDestIsA_thenReturnA() {
    // Arrange, Act and Assert
    assertEquals("A", (new PDNamedDestination(COSName.A)).getNamedDestination());
  }

  /**
   * Test {@link PDNamedDestination#getNamedDestination()}.
   * <ul>
   *   <li>Given {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest}.</li>
   *   <li>Then return {@code Dest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); given PDNamedDestination(String) with 'Dest'; then return 'Dest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDNamedDestination.getNamedDestination()"})
  void testGetNamedDestination_givenPDNamedDestinationWithDest_thenReturnDest() {
    // Arrange, Act and Assert
    assertEquals("Dest", (new PDNamedDestination("Dest")).getNamedDestination());
  }

  /**
   * Test {@link PDNamedDestination#getNamedDestination()}.
   * <ul>
   *   <li>Given {@link PDNamedDestination#PDNamedDestination()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); given PDNamedDestination(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDNamedDestination.getNamedDestination()"})
  void testGetNamedDestination_givenPDNamedDestination_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDNamedDestination()).getNamedDestination());
  }

  /**
   * Test {@link PDNamedDestination#getNamedDestination()}.
   * <ul>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#getNamedDestination()}
   */
  @Test
  @DisplayName("Test getNamedDestination(); then return empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDNamedDestination.getNamedDestination()"})
  void testGetNamedDestination_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDNamedDestination("")).getNamedDestination());
  }

  /**
   * Test {@link PDNamedDestination#setNamedDestination(String)}.
   * <ul>
   *   <li>Then {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest} COSObject {@link COSString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#setNamedDestination(String)}
   */
  @Test
  @DisplayName("Test setNamedDestination(String); then PDNamedDestination(String) with 'Dest' COSObject COSString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.setNamedDestination(String)"})
  void testSetNamedDestination_thenPDNamedDestinationWithDestCOSObjectCOSString() throws IOException {
    // Arrange
    PDNamedDestination pdNamedDestination = new PDNamedDestination("Dest");

    // Act
    pdNamedDestination.setNamedDestination("Dest");

    // Assert that nothing has changed
    assertTrue(pdNamedDestination.getCOSObject() instanceof COSString);
    assertEquals("Dest", pdNamedDestination.getNamedDestination());
  }

  /**
   * Test {@link PDNamedDestination#setNamedDestination(String)}.
   * <ul>
   *   <li>Then {@link PDNamedDestination#PDNamedDestination(String)} with {@code Dest} NamedDestination is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDNamedDestination#setNamedDestination(String)}
   */
  @Test
  @DisplayName("Test setNamedDestination(String); then PDNamedDestination(String) with 'Dest' NamedDestination is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDNamedDestination.setNamedDestination(String)"})
  void testSetNamedDestination_thenPDNamedDestinationWithDestNamedDestinationIsNull() throws IOException {
    // Arrange
    PDNamedDestination pdNamedDestination = new PDNamedDestination("Dest");

    // Act
    pdNamedDestination.setNamedDestination(null);

    // Assert
    assertNull(pdNamedDestination.getNamedDestination());
    assertNull(pdNamedDestination.getCOSObject());
  }
}
