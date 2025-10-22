package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDefaultAttributeObjectDiffblueTest {
  /**
   * Test {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDDefaultAttributeObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.<init>()", "void PDDefaultAttributeObject.<init>(COSDictionary)"})
  void testNewPDDefaultAttributeObject() {
    // Arrange, Act and Assert
    COSDictionary cOSObject = (new PDDefaultAttributeObject()).getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)}.
   * <ul>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDefaultAttributeObject(COSDictionary); then return COSObject is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.<init>()", "void PDDefaultAttributeObject.<init>(COSDictionary)"})
  void testNewPDDefaultAttributeObject_thenReturnCOSObjectIsCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, (new PDDefaultAttributeObject(dictionary)).getCOSObject());
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeNames()}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  @DisplayName("Test getAttributeNames(); given PDDefaultAttributeObject(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDefaultAttributeObject.getAttributeNames()"})
  void testGetAttributeNames_givenPDDefaultAttributeObject_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new PDDefaultAttributeObject()).getAttributeNames().isEmpty());
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeNames()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  @DisplayName("Test getAttributeNames(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PDDefaultAttributeObject.getAttributeNames()"})
  void testGetAttributeNames_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualAttributeNames = (new PDDefaultAttributeObject(new COSStream())).getAttributeNames();

    // Assert
    assertEquals(1, actualAttributeNames.size());
    assertEquals("Length", actualAttributeNames.get(0));
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String)} with {@code attrName}.
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String) with 'attrName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String)"})
  void testGetAttributeValueWithAttrName() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject(new COSDictionary())).getAttributeValue("Attr Name"));
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)} with {@code attrName}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String, COSBase) with 'attrName', 'defaultValue'; when '42'; then return FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String, COSBase)"})
  void testGetAttributeValueWithAttrNameDefaultValue_when42_thenReturnFalse() {
    // Arrange and Act
    COSBase actualAttributeValue = (new PDDefaultAttributeObject()).getAttributeValue("42", COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)} with {@code attrName}, {@code defaultValue}.
   * <ul>
   *   <li>When {@code Attr Name}.</li>
   *   <li>Then return {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String, COSBase) with 'attrName', 'defaultValue'; when 'Attr Name'; then return FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String, COSBase)"})
  void testGetAttributeValueWithAttrNameDefaultValue_whenAttrName_thenReturnFalse() {
    // Arrange and Act
    COSBase actualAttributeValue = (new PDDefaultAttributeObject()).getAttributeValue("Attr Name", COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String)} with {@code attrName}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String) with 'attrName'; given PDDefaultAttributeObject(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String)"})
  void testGetAttributeValueWithAttrName_givenPDDefaultAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject()).getAttributeValue("Attr Name"));
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", COSBoolean.FALSE);

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute2() {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.addAttribute(new PDDefaultAttributeObject());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", COSBoolean.FALSE);

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute3() {
    // Arrange
    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.incrementRevisionNumber();

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", COSBoolean.FALSE);

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>When {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); given PDDefaultAttributeObject(); when COSArray()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_givenPDDefaultAttributeObject_whenCOSArray() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSArray());

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); given PDDefaultAttributeObject(); when COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_givenPDDefaultAttributeObject_whenCOSDictionary() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSDictionary());

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>When {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); given PDDefaultAttributeObject(); when FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_givenPDDefaultAttributeObject_whenFalse() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", COSBoolean.FALSE);

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    List<String> attributeNames = pdDefaultAttributeObject.getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Attr Name", attributeNames.get(0));
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} COSObject size is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); when 'null'; then PDDefaultAttributeObject() COSObject size is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_whenNull_thenPDDefaultAttributeObjectCOSObjectSizeIsZero() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setAttribute("Attr Name", null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(pdDefaultAttributeObject.getAttributeNames().isEmpty());
  }

  /**
   * Test {@link PDDefaultAttributeObject#toString()}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return {@code O=null, attributes={}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDDefaultAttributeObject(); then return 'O=null, attributes={}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDefaultAttributeObject.toString()"})
  void testToString_givenPDDefaultAttributeObject_thenReturnONullAttributes() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", (new PDDefaultAttributeObject()).toString());
  }

  /**
   * Test {@link PDDefaultAttributeObject#toString()}.
   * <ul>
   *   <li>Then return {@code O=null, attributes={Length=COSInt{0}}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDDefaultAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null, attributes={Length=COSInt{0}}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PDDefaultAttributeObject.toString()"})
  void testToString_thenReturnONullAttributesLengthCOSInt0() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={Length=COSInt{0}}", (new PDDefaultAttributeObject(new COSStream())).toString());
  }
}
