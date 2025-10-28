package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.Test;

class PDStandardAttributeObjectDiffblueTest {
  /**
   * Method under test: {@link PDStandardAttributeObject#isSpecified(String)}
   */
  @Test
  void testIsSpecified() {
    // Arrange, Act and Assert
    assertFalse((new PDLayoutAttributeObject()).isSpecified("Name"));
    assertFalse(
        (new PDExportFormatAttributeObject(new COSDictionary())).isSpecified("42org.apache.pdfbox.cos.COSNumber"));
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getString(String)}
   */
  @Test
  void testGetString() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getString("Name"));
    assertNull((new PDLayoutAttributeObject()).getString("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  void testSetString() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setString("Name", "42");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  void testSetString2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setString("org.apache.pdfbox.cos.COSArray", "42");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getArrayOfString(String)}
   */
  @Test
  void testGetArrayOfString() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("Name"));
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfString(String, String[])}
   */
  @Test
  void testSetArrayOfString() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfString("Name", new String[]{"42"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getName(String)}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getName("Name"));
    assertNull((new PDLayoutAttributeObject()).getName("42"));
    assertEquals("42", (new PDLayoutAttributeObject()).getName("Name", "42"));
    assertEquals("42", (new PDLayoutAttributeObject(new COSStream())).getName("org.apache.pdfbox.cos.COSArray", "42"));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}
   */
  @Test
  void testGetNameOrArrayOfName() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNameOrArrayOfName("Name", "42"));
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  void testSetName() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setName("Name", "42");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  void testSetArrayOfName() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfName("Name", new String[]{"42"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  void testGetNumberOrName() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNumberOrName("Name", "42"));
    assertEquals("42", (new PDLayoutAttributeObject()).getNumberOrName("org.apache.pdfbox.cos.COSArray", "42"));
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getInteger(String, int)}
   */
  @Test
  void testGetInteger() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("Name", 42));
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("org.apache.pdfbox.cos.COSArray", 42));
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  void testSetInteger() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setInteger("Name", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  void testSetInteger2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setInteger("Name", Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getNumber(String)}
   */
  @Test
  void testGetNumber() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("Name"));
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("org.apache.pdfbox.cos.COSArray"));
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("Name", 10.0f));
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("42", 10.0f));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  void testGetNumberOrArrayOfNumber() {
    // Arrange, Act and Assert
    assertEquals(10.0f, ((Float) (new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", 10.0f)).floatValue());
    assertNull((new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", -1.0f));
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, float)}
   */
  @Test
  void testSetNumber() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setNumber("Name", 10.0f);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, float)}
   */
  @Test
  void testSetNumber2() {
    // Arrange
    COSStream dictionary = new COSStream();
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(dictionary);

    // Act
    pdLayoutAttributeObject.setNumber("org.apache.pdfbox.cos.COSNumber", 10.0f);

    // Assert
    assertSame(dictionary, pdLayoutAttributeObject.getCOSObject());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  void testSetNumber3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setNumber("Name", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  void testSetNumber4() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setNumber("Name", Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}
   */
  @Test
  void testSetArrayOfNumber() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfNumber("Name", new float[]{10.0f, -1.0f, 10.0f, -1.0f});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}
   */
  @Test
  void testSetArrayOfNumber2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfNumber("org.apache.pdfbox.cos.COSArray", new float[]{10.0f, -1.0f, 10.0f, -1.0f});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor("Name"));
    assertNull((new PDLayoutAttributeObject()).getColor("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  void testGetColorOrFourColors() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColorOrFourColors("Name"));
    assertNull((new PDLayoutAttributeObject()).getColorOrFourColors("org.apache.pdfbox.cos.COSNumber42"));
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  void testSetColor() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor("Name", new PDGamma());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  void testSetColor2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor("42", new PDGamma());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  void testSetColor3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor("Name", null);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  void testSetColor4() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setColor("Name", new PDGamma(array));

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  void testSetFourColors() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setFourColors("Name", new PDFourColours());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  void testSetFourColors2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setFourColors("Name", null);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  void testSetFourColors3() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);

    // Act
    pdLayoutAttributeObject.setFourColors("Name", new PDFourColours(array));

    // Assert
    verify(object).getCOSObject();
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }
}
