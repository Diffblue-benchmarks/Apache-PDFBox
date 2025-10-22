package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDStandardAttributeObjectDiffblueTest {
  /**
   * Test {@link PDStandardAttributeObject#isSpecified(String)}.
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with {@code Owner}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#isSpecified(String)}
   */
  @Test
  @DisplayName("Test isSpecified(String); given PDExportFormatAttributeObject(String) with 'Owner'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStandardAttributeObject.isSpecified(String)"})
  void testIsSpecified_givenPDExportFormatAttributeObjectWithOwner() {
    // Arrange, Act and Assert
    assertFalse((new PDExportFormatAttributeObject("Owner"))
        .isSpecified("org.apache.pdfbox.cos.COSArrayorg.apache.pdfbox.cos.COSArray"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDStandardAttributeObject.isSpecified(String)"})
  void testIsSpecified_givenPDLayoutAttributeObject_whenName_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDLayoutAttributeObject()).isSpecified("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getString(String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getString(String)}
   */
  @Test
  @DisplayName("Test getString(String); given PDLayoutAttributeObject(); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getString(String)"})
  void testGetString_givenPDLayoutAttributeObject_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getString("42"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getString(String)"})
  void testGetString_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setString(String, String)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setString(String, String)"})
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
   * Test {@link PDStandardAttributeObject#setString(String, String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setString(String, String)}
   */
  @Test
  @DisplayName("Test setString(String, String); when 'org.apache.pdfbox.cos.COSNumber'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setString(String, String)"})
  void testSetString_whenOrgApachePdfboxCosCOSNumber() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setString("org.apache.pdfbox.cos.COSNumber", "org.apache.pdfbox.cos.COSNumber");

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] PDStandardAttributeObject.getArrayOfString(String)"})
  void testGetArrayOfString_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getArrayOfString(String)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getArrayOfString(String)}
   */
  @Test
  @DisplayName("Test getArrayOfString(String); when 'org.apache.pdfbox.cos.COSArray'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String[] PDStandardAttributeObject.getArrayOfString(String)"})
  void testGetArrayOfString_whenOrgApachePdfboxCosCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getArrayOfString("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfString(String, String[])}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setArrayOfString(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfString(String, String[]); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setArrayOfString(String, String[])"})
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
   * Test {@link PDStandardAttributeObject#getName(String, String)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String, String)}
   */
  @Test
  @DisplayName("Test getName(String, String) with 'name', 'defaultValue'; given PDLayoutAttributeObject(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getName(String, String)"})
  void testGetNameWithNameDefaultValue_givenPDLayoutAttributeObject_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String, String)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String, String)}
   */
  @Test
  @DisplayName("Test getName(String, String) with 'name', 'defaultValue'; when 'org.apache.pdfbox.cos.COSArray'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getName(String, String)"})
  void testGetNameWithNameDefaultValue_whenOrgApachePdfboxCosCOSArray_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getName("org.apache.pdfbox.cos.COSArray", "42"));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getName(String)"})
  void testGetNameWithName_givenPDLayoutAttributeObject_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getName("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getName(String)} with {@code name}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getName(String)}
   */
  @Test
  @DisplayName("Test getName(String) with 'name'; when 'org.apache.pdfbox.cos.COSArray'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDStandardAttributeObject.getName(String)"})
  void testGetNameWithName_whenOrgApachePdfboxCosCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getName("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNameOrArrayOfName(String, String)}
   */
  @Test
  @DisplayName("Test getNameOrArrayOfName(String, String); given PDLayoutAttributeObject(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNameOrArrayOfName(String, String)"})
  void testGetNameOrArrayOfName_givenPDLayoutAttributeObject_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNameOrArrayOfName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setName(String, String)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setName(String, String)"})
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
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setName(String, String)}
   */
  @Test
  @DisplayName("Test setName(String, String); when 'Value'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setName(String, String)"})
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
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfName(String, String[]); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setArrayOfName(String, String[])"})
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
   *   <li>When array of {@link String} with {@code Values}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setArrayOfName(String, String[])}
   */
  @Test
  @DisplayName("Test setArrayOfName(String, String[]); when array of String with 'Values'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setArrayOfName(String, String[])"})
  void testSetArrayOfName_whenArrayOfStringWithValues() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setArrayOfName("Name", new String[]{"Values"});

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)} with dictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  @DisplayName("Test getNumberOrName(String, String); given PDLayoutAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNumberOrName(String, String)"})
  void testGetNumberOrName_givenPDLayoutAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertEquals("42",
        (new PDLayoutAttributeObject(new COSDictionary())).getNumberOrName("org.apache.pdfbox.cos.COSArray", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrName(String, String)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumberOrName(String, String)}
   */
  @Test
  @DisplayName("Test getNumberOrName(String, String); given PDLayoutAttributeObject(); when 'Name'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNumberOrName(String, String)"})
  void testGetNumberOrName_givenPDLayoutAttributeObject_whenName_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new PDLayoutAttributeObject()).getNumberOrName("Name", "42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getInteger(String, int)}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getInteger(String, int)}
   */
  @Test
  @DisplayName("Test getInteger(String, int); given PDLayoutAttributeObject(); when '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDStandardAttributeObject.getInteger(String, int)"})
  void testGetInteger_givenPDLayoutAttributeObject_when42_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("42", 42));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDStandardAttributeObject.getInteger(String, int)"})
  void testGetInteger_givenPDLayoutAttributeObject_whenName_thenReturnFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, (new PDLayoutAttributeObject()).getInteger("Name", 42));
  }

  /**
   * Test {@link PDStandardAttributeObject#setInteger(String, int)}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setInteger(String, int)"})
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
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int); when MIN_VALUE; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setInteger(String, int)"})
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
   * Test {@link PDStandardAttributeObject#setInteger(String, int)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setInteger(String, int)}
   */
  @Test
  @DisplayName("Test setInteger(String, int); when 'org.apache.pdfbox.cos.COSArray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setInteger(String, int)"})
  void testSetInteger_whenOrgApachePdfboxCosCOSArray() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setInteger("org.apache.pdfbox.cos.COSArray", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String, float)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumber(String, float) with 'name', 'defaultValue'; given PDLayoutAttributeObject(); then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDStandardAttributeObject.getNumber(String, float)"})
  void testGetNumberWithNameDefaultValue_givenPDLayoutAttributeObject_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("Name", 10.0f));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String, float)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumber(String, float) with 'name', 'defaultValue'; when '42'; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDStandardAttributeObject.getNumber(String, float)"})
  void testGetNumberWithNameDefaultValue_when42_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDLayoutAttributeObject()).getNumber("42", 10.0f));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDStandardAttributeObject.getNumber(String)"})
  void testGetNumberWithName_givenPDLayoutAttributeObject_whenName_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumber(String)} with {@code name}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumber(String)}
   */
  @Test
  @DisplayName("Test getNumber(String) with 'name'; when 'org.apache.pdfbox.cos.COSArray'; then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDStandardAttributeObject.getNumber(String)"})
  void testGetNumberWithName_whenOrgApachePdfboxCosCOSArray_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, (new PDLayoutAttributeObject()).getNumber("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>Then return floatValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); then return floatValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNumberOrArrayOfNumber(String, float)"})
  void testGetNumberOrArrayOfNumber_thenReturnFloatValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, ((Float) (new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", 10.0f)).floatValue());
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); when minus one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNumberOrArrayOfNumber(String, float)"})
  void testGetNumberOrArrayOfNumber_whenMinusOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("Name", -1.0f));
  }

  /**
   * Test {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getNumberOrArrayOfNumber(String, float)}
   */
  @Test
  @DisplayName("Test getNumberOrArrayOfNumber(String, float); when 'org.apache.pdfbox.cos.COSArray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getNumberOrArrayOfNumber(String, float)"})
  void testGetNumberOrArrayOfNumber_whenOrgApachePdfboxCosCOSArray() {
    // Arrange, Act and Assert
    assertEquals(10.0f,
        ((Float) (new PDLayoutAttributeObject()).getNumberOrArrayOfNumber("org.apache.pdfbox.cos.COSArray", 10.0f))
            .floatValue());
  }

  /**
   * Test {@link PDStandardAttributeObject#setNumber(String, float)} with {@code String}, {@code float}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, float)}
   */
  @Test
  @DisplayName("Test setNumber(String, float) with 'String', 'float'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setNumber(String, float)"})
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
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with {@code String}, {@code int}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setNumber(String, int)"})
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
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with {@code String}, {@code int}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'; when MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setNumber(String, int)"})
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
   * Test {@link PDStandardAttributeObject#setNumber(String, int)} with {@code String}, {@code int}.
   * <ul>
   *   <li>When {@code org.apache.pdfbox.cos.COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setNumber(String, int)}
   */
  @Test
  @DisplayName("Test setNumber(String, int) with 'String', 'int'; when 'org.apache.pdfbox.cos.COSArray'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setNumber(String, int)"})
  void testSetNumberWithStringInt_whenOrgApachePdfboxCosCOSArray() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setNumber("org.apache.pdfbox.cos.COSArray", 42);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}.
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setArrayOfNumber(String, float[])}
   */
  @Test
  @DisplayName("Test setArrayOfNumber(String, float[]); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setArrayOfNumber(String, float[])"})
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
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String); when '42'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDStandardAttributeObject.getColor(String)"})
  void testGetColor_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor("42"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColor(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColor(String)}
   */
  @Test
  @DisplayName("Test getColor(String); when 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDGamma PDStandardAttributeObject.getColor(String)"})
  void testGetColor_whenName_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColor("Name"));
  }

  /**
   * Test {@link PDStandardAttributeObject#getColorOrFourColors(String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  @DisplayName("Test getColorOrFourColors(String); when 'Name'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getColorOrFourColors(String)"})
  void testGetColorOrFourColors_whenName_thenReturnNull() {
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
   * Method under test: {@link PDStandardAttributeObject#getColorOrFourColors(String)}
   */
  @Test
  @DisplayName("Test getColorOrFourColors(String); when 'org.apache.pdfbox.cos.COSArray'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object PDStandardAttributeObject.getColorOrFourColors(String)"})
  void testGetColorOrFourColors_whenOrgApachePdfboxCosCOSArray_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDLayoutAttributeObject()).getColorOrFourColors("org.apache.pdfbox.cos.COSArray"));
  }

  /**
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setColor(String, PDGamma)"})
  void testSetColor() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject(new COSDictionary());

    // Act
    pdLayoutAttributeObject.setColor("org.apache.pdfbox.cos.COSArray", null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma); when 'Name'; then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setColor(String, PDGamma)"})
  void testSetColor_whenName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor("Name", null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setColor(String, PDGamma)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setColor(String, PDGamma)}
   */
  @Test
  @DisplayName("Test setColor(String, PDGamma); when 'Name'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setColor(String, PDGamma)"})
  void testSetColor_whenName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours); when '42'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setFourColors(String, PDFourColours)"})
  void testSetFourColors_when42_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setFourColors("42", new PDFourColours());

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours); when 'Name'; then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setFourColors(String, PDFourColours)"})
  void testSetFourColors_whenName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setFourColors("Name", null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDStandardAttributeObject#setFourColors(String, PDFourColours)}
   */
  @Test
  @DisplayName("Test setFourColors(String, PDFourColours); when 'Name'; then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDStandardAttributeObject.setFourColors(String, PDFourColours)"})
  void testSetFourColors_whenName_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
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
}
