package org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.Test;

class PDNamedDestinationDiffblueTest {
  /**
   * Method under test: {@link PDNamedDestination#getNamedDestination()}
   */
  @Test
  void testGetNamedDestination() {
    // Arrange, Act and Assert
    assertEquals("Dest", (new PDNamedDestination("Dest")).getNamedDestination());
    assertEquals("", (new PDNamedDestination("")).getNamedDestination());
    assertNull((new PDNamedDestination()).getNamedDestination());
    assertEquals("A", (new PDNamedDestination(COSName.A)).getNamedDestination());
  }

  /**
   * Method under test: {@link PDNamedDestination#setNamedDestination(String)}
   */
  @Test
  void testSetNamedDestination() throws IOException {
    // Arrange
    PDNamedDestination pdNamedDestination = new PDNamedDestination("Dest");

    // Act
    pdNamedDestination.setNamedDestination("Dest");

    // Assert
    assertTrue(pdNamedDestination.getCOSObject() instanceof COSString);
    assertEquals("Dest", pdNamedDestination.getNamedDestination());
  }

  /**
   * Method under test: {@link PDNamedDestination#setNamedDestination(String)}
   */
  @Test
  void testSetNamedDestination2() throws IOException {
    // Arrange
    PDNamedDestination pdNamedDestination = new PDNamedDestination("Dest");

    // Act
    pdNamedDestination.setNamedDestination(null);

    // Assert
    assertNull(pdNamedDestination.getNamedDestination());
    assertNull(pdNamedDestination.getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination()}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull((new PDNamedDestination()).getCOSObject());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination(COSName)}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    COSBase actualCOSObject = (new PDNamedDestination(COSName.A)).getCOSObject();

    // Assert
    assertSame(((COSName) actualCOSObject).A, actualCOSObject);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDNamedDestination#PDNamedDestination(COSString)}
   *   <li>{@link PDNamedDestination#getCOSObject()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() throws IOException {
    // Arrange
    COSString dest = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertSame(dest, (new PDNamedDestination(dest)).getCOSObject());
  }

  /**
   * Method under test: {@link PDNamedDestination#PDNamedDestination(String)}
   */
  @Test
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
}
