package org.apache.pdfbox.pdmodel.common.filespecification;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDSimpleFileSpecificationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDSimpleFileSpecification#PDSimpleFileSpecification(COSString)}
   *   <li>{@link PDSimpleFileSpecification#getCOSObject()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    COSString fileName = COSString.parseHex("0123456789ABCDEF");

    // Act and Assert
    assertSame(fileName, (new PDSimpleFileSpecification(fileName)).getCOSObject());
  }

  /**
   * Test {@link PDSimpleFileSpecification#PDSimpleFileSpecification()}.
   * <p>
   * Method under test:
   * {@link PDSimpleFileSpecification#PDSimpleFileSpecification()}
   */
  @Test
  @DisplayName("Test new PDSimpleFileSpecification()")
  void testNewPDSimpleFileSpecification() {
    // Arrange and Act
    PDSimpleFileSpecification actualPdSimpleFileSpecification = new PDSimpleFileSpecification();

    // Assert
    COSBase cOSObject = actualPdSimpleFileSpecification.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertEquals("", ((COSString) cOSObject).getASCII());
    assertEquals("", ((COSString) cOSObject).getString());
    assertEquals("", ((COSString) cOSObject).toHexString());
    assertEquals("", actualPdSimpleFileSpecification.getFile());
    assertNull(cOSObject.getKey());
    assertEquals(0, ((COSString) cOSObject).getBytes().length);
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSString) cOSObject).getForceHexForm());
  }

  /**
   * Test {@link PDSimpleFileSpecification#getFile()}.
   * <ul>
   *   <li>Given {@link PDSimpleFileSpecification#PDSimpleFileSpecification()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFileSpecification#getFile()}
   */
  @Test
  @DisplayName("Test getFile(); given PDSimpleFileSpecification(); then return empty string")
  void testGetFile_givenPDSimpleFileSpecification_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new PDSimpleFileSpecification()).getFile());
  }

  /**
   * Test {@link PDSimpleFileSpecification#setFile(String)}.
   * <p>
   * Method under test: {@link PDSimpleFileSpecification#setFile(String)}
   */
  @Test
  @DisplayName("Test setFile(String)")
  void testSetFile() throws UnsupportedEncodingException {
    // Arrange
    PDSimpleFileSpecification pdSimpleFileSpecification = new PDSimpleFileSpecification();

    // Act
    pdSimpleFileSpecification.setFile("foo.txt");

    // Assert
    COSBase cOSObject = pdSimpleFileSpecification.getCOSObject();
    assertTrue(cOSObject instanceof COSString);
    assertEquals("666F6F2E747874", ((COSString) cOSObject).toHexString());
    assertEquals("foo.txt", ((COSString) cOSObject).getASCII());
    assertEquals("foo.txt", ((COSString) cOSObject).getString());
    assertEquals("foo.txt", pdSimpleFileSpecification.getFile());
    byte[] expectedBytes = "foo.txt".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((COSString) cOSObject).getBytes());
  }
}
