package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDStandardAttributeObjectDiffblueTest {
  /**
   * Test {@link PDStandardAttributeObject#isSpecified(String)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#isSpecified(String)}
   */
  @Test
  @DisplayName("Test isSpecified(String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testIsSpecified_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDLayoutAttributeObject(new COSDictionary())).isSpecified("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#isSpecified(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#isSpecified(String)}
   */
  @Test
  @DisplayName("Test isSpecified(String); given PDLayoutAttributeObject(); when 'Name'; then return 'false'")
  void testIsSpecified_givenPDLayoutAttributeObject_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDLayoutAttributeObject()).isSpecified("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#isSpecified(String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#isSpecified(String)}
   */
  @Test
  @DisplayName("Test isSpecified(String); when 'org.apache.pdfbox.cos.COSArray'; then return 'false'")
  void testIsSpecified_whenOrgApachePdfboxCosCOSArray_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDLayoutAttributeObject()).isSpecified("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getString(String)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetString_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getString(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String); given PDLayoutAttributeObject(); when 'Name'; then return 'null'")
  void testGetString_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getString(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String); given PDLayoutAttributeObject(); when 'org.apache.pdfbox.cos.COSNumber'")
  void testGetString_givenPDLayoutAttributeObject_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getString("org.apache.pdfbox.cos.COSNumber"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setString(String, String)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String)")
  void testSetString() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setString("Name", "42");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setString(String, String)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetString_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#getArrayOfString(String)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getArrayOfString(String)}
   */
  @Test
  @DisplayName("Test getArrayOfString(String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetArrayOfString_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getArrayOfString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getArrayOfString(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getArrayOfString(String)}
   */
  @Test
  @DisplayName("Test getArrayOfString(String); given PDLayoutAttributeObject(); when 'Name'; then return 'null'")
  void testGetArrayOfString_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getArrayOfString(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getArrayOfString(String)}
   */
  @Test
  @DisplayName("Test getArrayOfString(String); given PDLayoutAttributeObject(); when 'org.apache.pdfbox.cos.COSArray'")
  void testGetArrayOfString_givenPDLayoutAttributeObject_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfString(String, String[])}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfString(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfString(String, String[])")
  void testSetArrayOfString() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setArrayOfString("Name", new String[]{"42"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfString(String, String[])}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfString(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfString(String, String[]); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetArrayOfString_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#getName(String, String)} with
   * {@code name}, {@code defaultValue}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String, String)}
   */
  @Test
  @DisplayName("Test getName(String, String) with 'name', 'defaultValue'")
  void testGetNameWithNameDefaultValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject(new COSDictionary())).getName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String, String)} with
   * {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String, String)}
   */
  @Test
  @DisplayName("Test getName(String, String) with 'name', 'defaultValue'; given PDLayoutAttributeObject(); then return '42'")
  void testGetNameWithNameDefaultValue_givenPDLayoutAttributeObject_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String, String)} with
   * {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String, String)}
   */
  @Test
  @DisplayName("Test getName(String, String) with 'name', 'defaultValue'; when 'org.apache.pdfbox.cos.COSNumber'")
  void testGetNameWithNameDefaultValue_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getName("org.apache.pdfbox.cos.COSNumber", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String)} with {@code name}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String)}
   */
  @Test
  @DisplayName("Test getName(String) with 'name'; given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetNameWithName_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getName("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String)}
   */
  @Test
  @DisplayName("Test getName(String) with 'name'; given PDLayoutAttributeObject(); when 'Name'; then return 'null'")
  void testGetNameWithName_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getName("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String)}
   */
  @Test
  @DisplayName("Test getName(String) with 'name'; given PDLayoutAttributeObject(); when 'org.apache.pdfbox.cos.COSArray'")
  void testGetNameWithName_givenPDLayoutAttributeObject_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getName("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}
   */
  @Test
  @DisplayName("Test getNameOrArrayOfName(String, String)")
  void testGetNameOrArrayOfName() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject(new COSDictionary())).getNameOrArrayOfName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}
   */
  @Test
  @DisplayName("Test getNameOrArrayOfName(String, String); given PDLayoutAttributeObject(); when 'Name'; then return '42'")
  void testGetNameOrArrayOfName_givenPDLayoutAttributeObject_whenName_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNameOrArrayOfName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}
   */
  @Test
  @DisplayName("Test getNameOrArrayOfName(String, String); when 'org.apache.pdfbox.cos.COSArray'")
  void testGetNameOrArrayOfName_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNameOrArrayOfName("org.apache.pdfbox.cos.COSArray", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setName(String, String)}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String)")
  void testSetName() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setName("Name", "42");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setName(String, String)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setName(String, String)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String); when 'Value'; then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetName_whenValue_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setName("Name", "Value");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfName(String, String[])}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfName(String, String[])")
  void testSetArrayOfName() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setArrayOfName("Name", new String[]{"42"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfName(String, String[])}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfName(String, String[]); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetArrayOfName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setArrayOfName(String, String[])}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfName(String, String[]); when 'org.apache.pdfbox.cos.COSNumber'")
  void testSetArrayOfName_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfName("org.apache.pdfbox.cos.COSNumber", new String[]{"42"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrName(String, String)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  @DisplayName("Test getNumberOrName(String, String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetNumberOrName_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject(new COSDictionary())).getNumberOrName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  @DisplayName("Test getNumberOrName(String, String); given PDLayoutAttributeObject(); when 'Name'; then return '42'")
  void testGetNumberOrName_givenPDLayoutAttributeObject_whenName_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNumberOrName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  @DisplayName("Test getNumberOrName(String, String); given PDLayoutAttributeObject(); when 'org.apache.pdfbox.cos.COSArray'")
  void testGetNumberOrName_givenPDLayoutAttributeObject_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNumberOrName("org.apache.pdfbox.cos.COSArray", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getInteger(String, int)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getInteger(String, int)}
   */
  @Test
  @DisplayName("Test getInteger(String, int); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetInteger_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject(new COSDictionary())).getInteger("Name", 42));
  }

  /**
   * Test {@link PDStandardAttributeObject#getInteger(String, int)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getInteger(String, int)}
   */
  @Test
  @DisplayName("Test getInteger(String, int); given PDLayoutAttributeObject(); when 'Name'; then return forty-two")
  void testGetInteger_givenPDLayoutAttributeObject_whenName_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("Name", 42));
  }

  /**
   * Test {@link PDStandardAttributeObject#getInteger(String, int)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getInteger(String, int)}
   */
  @Test
  @DisplayName("Test getInteger(String, int); given PDLayoutAttributeObject(); when 'org.apache.pdfbox.cos.COSNumber'")
  void testGetInteger_givenPDLayoutAttributeObject_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("org.apache.pdfbox.cos.COSNumber", 42));
  }

  /**
   * Test {@link PDStandardAttributeObject#setInteger(String, int)}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int)")
  void testSetInteger() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setInteger("Name", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setInteger(String, int)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetInteger_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setInteger(String, int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int); when MIN_VALUE; then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetInteger_whenMin_value_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#getNumber(String, float)} with
   * {@code name}, {@code defaultValue}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumber(String, float) with 'name', 'defaultValue'")
  void testGetNumberWithNameDefaultValue() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDLayoutAttributeObject(new COSDictionary())).getNumber("Name", 10.0f));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String, float)} with
   * {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumber(String, float) with 'name', 'defaultValue'; given PDLayoutAttributeObject(); then return ten")
  void testGetNumberWithNameDefaultValue_givenPDLayoutAttributeObject_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("Name", 10.0f));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String, float)} with
   * {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumber(String, float) with 'name', 'defaultValue'; when 'org.apache.pdfbox.cos.COSArray'")
  void testGetNumberWithNameDefaultValue_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("org.apache.pdfbox.cos.COSArray", 10.0f));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String)} with {@code name}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'name'; given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  void testGetNumberWithName_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject(new COSDictionary())).getNumber("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'name'; given PDLayoutAttributeObject(); when 'Name'; then return minus one")
  void testGetNumberWithName_givenPDLayoutAttributeObject_whenName_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String)} with {@code name}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'name'; when 'org.apache.pdfbox.cos.COSNumber'")
  void testGetNumberWithName_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("org.apache.pdfbox.cos.COSNumber"));
  }

  /**
   * Test
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float)")
  void testGetNumberOrArrayOfNumber() {
    // Arrange, Act and Assert
    assertEquals(10.0f,
        ((Float) (new PDLayoutAttributeObject(new COSDictionary())).getNumberOrArrayOfNumber("Name", 10.0f))
            .floatValue());
  }

  /**
   * Test
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>Then return floatValue is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); then return floatValue is ten")
  void testGetNumberOrArrayOfNumber_thenReturnFloatValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, ((Float) (new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", 10.0f)).floatValue());
  }

  /**
   * Test
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); when minus one; then return 'null'")
  void testGetNumberOrArrayOfNumber_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", -1.0f));
  }

  /**
   * Test
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); when 'org.apache.pdfbox.cos.COSNumber'")
  void testGetNumberOrArrayOfNumber_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange, Act and Assert
    assertEquals(10.0f,
        ((Float) (new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("org.apache.pdfbox.cos.COSNumber", 10.0f))
            .floatValue());
  }

  /**
   * Test {@link PDStandardAttributeObject#setNumber(String, float)} with
   * {@code String}, {@code float}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, float)}
   */
  @Test
  @DisplayName("Test setNumber(String, float) with 'String', 'float'")
  void testSetNumberWithStringFloat() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setNumber("Name", 10.0f);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setNumber(String, float)} with
   * {@code String}, {@code float}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, float)}
   */
  @Test
  @DisplayName("Test setNumber(String, float) with 'String', 'float'; then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetNumberWithStringFloat_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with
   * {@code String}, {@code int}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'")
  void testSetNumberWithStringInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setNumber("Name", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with
   * {@code String}, {@code int}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'; then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetNumberWithStringInt_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with
   * {@code String}, {@code int}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'; when MIN_VALUE")
  void testSetNumberWithStringInt_whenMin_value() {
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
   * Test {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}
   */
  @Test
  @DisplayName("Test setArrayOfNumber(String, float[])")
  void testSetArrayOfNumber() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setArrayOfNumber("Name", new float[]{10.0f, -1.0f, 10.0f, -1.0f});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}
   */
  @Test
  @DisplayName("Test setArrayOfNumber(String, float[]); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetArrayOfNumber_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#getColor(String)}.
   * <ul>
   *   <li>Given
   * {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with
   * dictionary is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>When {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary(); when 'Name'")
  void testGetColor_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary_whenName() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getColor("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColor(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String); given PDLayoutAttributeObject(); when 'Name'; then return 'null'")
  void testGetColor_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColor(String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String); when 'org.apache.pdfbox.cos.COSNumber'; then return 'null'")
  void testGetColor_whenOrgApachePdfboxCosCOSNumber_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor("org.apache.pdfbox.cos.COSNumber"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColorOrFourColors(String)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  @DisplayName("Test getColorOrFourColors(String)")
  void testGetColorOrFourColors() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject(new COSDictionary())).getColorOrFourColors("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColorOrFourColors(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  @DisplayName("Test getColorOrFourColors(String); given PDLayoutAttributeObject(); when 'Name'; then return 'null'")
  void testGetColorOrFourColors_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColorOrFourColors("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColorOrFourColors(String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  @DisplayName("Test getColorOrFourColors(String); when 'org.apache.pdfbox.cos.COSArray'; then return 'null'")
  void testGetColorOrFourColors_whenOrgApachePdfboxCosCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColorOrFourColors("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma)")
  void testSetColor() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setColor("Name", new PDGamma());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetColor_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma); when 'null'; then PDLayoutAttributeObject() COSObject Values size is one")
  void testSetColor_whenNull_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
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
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours)")
  void testSetFourColors() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setFourColors("Name", new PDFourColours());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours); then PDLayoutAttributeObject() COSObject Values size is two")
  void testSetFourColors_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject
   * Values size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours); when 'null'; then PDLayoutAttributeObject() COSObject Values size is one")
  void testSetFourColors_whenNull_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
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
}
