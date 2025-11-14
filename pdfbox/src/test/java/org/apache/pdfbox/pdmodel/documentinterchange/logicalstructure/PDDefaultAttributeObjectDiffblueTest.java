package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDDefaultAttributeObjectDiffblueTest {
  /**
   * Test {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDDefaultAttributeObject(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.<init>(COSDictionary)"})
  void testNewPDDefaultAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDDefaultAttributeObject(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDDefaultAttributeObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.<init>()"})
  void testNewPDDefaultAttributeObject2() {
    // Arrange and Act
    PDDefaultAttributeObject actualPdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Assert
    assertNull(actualPdDefaultAttributeObject.getOwner());
    COSDictionary cOSObject = actualPdDefaultAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdDefaultAttributeObject.isEmpty());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(actualPdDefaultAttributeObject.getAttributeNames().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeNames()}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  @DisplayName("Test getAttributeNames(); given PDDefaultAttributeObject(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDefaultAttributeObject.getAttributeNames()"})
  void testGetAttributeNames_givenPDDefaultAttributeObject_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(new PDDefaultAttributeObject().getAttributeNames().isEmpty());
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeNames()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeNames()}
   */
  @Test
  @DisplayName("Test getAttributeNames(); then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PDDefaultAttributeObject.getAttributeNames()"})
  void testGetAttributeNames_thenReturnSizeIsOne() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject =
        new PDDefaultAttributeObject(new COSStream());
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act
    List<String> actualAttributeNames = pdDefaultAttributeObject.getAttributeNames();

    // Assert
    assertEquals(1, actualAttributeNames.size());
    assertEquals("Length", actualAttributeNames.get(0));
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String)} with {@code attrName}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String) with 'attrName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String)"})
  void testGetAttributeValueWithAttrName() {
    // Arrange, Act and Assert
    assertNull(new PDDefaultAttributeObject(new COSDictionary()).getAttributeValue("Attr Name"));
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String)} with {@code attrName}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String) with 'attrName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String)"})
  void testGetAttributeValueWithAttrName2() {
    // Arrange, Act and Assert
    assertNull(new PDDefaultAttributeObject(new COSStream()).getAttributeValue("Attr Name"));
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)} with {@code attrName},
   * {@code defaultValue}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  @DisplayName("Test getAttributeValue(String, COSBase) with 'attrName', 'defaultValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String, COSBase)"})
  void testGetAttributeValueWithAttrNameDefaultValue() {
    // Arrange and Act
    COSBase actualAttributeValue =
        new PDDefaultAttributeObject(new COSStream())
            .getAttributeValue("Attr Name", COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)} with {@code attrName},
   * {@code defaultValue}.
   *
   * <ul>
   *   <li>Then return {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test getAttributeValue(String, COSBase) with 'attrName', 'defaultValue'; then return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String, COSBase)"})
  void testGetAttributeValueWithAttrNameDefaultValue_thenReturnFalse() {
    // Arrange and Act
    COSBase actualAttributeValue =
        new PDDefaultAttributeObject().getAttributeValue("Attr Name", COSBoolean.FALSE);

    // Assert
    assertSame(((COSBoolean) actualAttributeValue).FALSE, actualAttributeValue);
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)} with {@code attrName},
   * {@code defaultValue}.
   *
   * <ul>
   *   <li>When {@link COSName#A}.
   *   <li>Then return {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String, COSBase)}
   */
  @Test
  @DisplayName(
      "Test getAttributeValue(String, COSBase) with 'attrName', 'defaultValue'; when A; then return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String, COSBase)"})
  void testGetAttributeValueWithAttrNameDefaultValue_whenA_thenReturnA() {
    // Arrange and Act
    COSBase actualAttributeValue =
        new PDDefaultAttributeObject().getAttributeValue("Attr Name", COSName.A);

    // Assert
    assertSame(((COSName) actualAttributeValue).A, actualAttributeValue);
  }

  /**
   * Test {@link PDDefaultAttributeObject#getAttributeValue(String)} with {@code attrName}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#getAttributeValue(String)}
   */
  @Test
  @DisplayName(
      "Test getAttributeValue(String) with 'attrName'; given PDDefaultAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSBase PDDefaultAttributeObject.getAttributeValue(String)"})
  void testGetAttributeValueWithAttrName_givenPDDefaultAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDefaultAttributeObject().getAttributeValue("Attr Name"));
  }

  /**
   * Test {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}.
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute2() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSStream()));

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
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute3() {
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
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute4() {
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
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#setAttribute(String, COSBase)}
   */
  @Test
  @DisplayName("Test setAttribute(String, COSBase); given PDDefaultAttributeObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDDefaultAttributeObject.setAttribute(String, COSBase)"})
  void testSetAttribute_givenPDDefaultAttributeObject() {
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
   * Test {@link PDDefaultAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return {@code O=null, attributes={}}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDDefaultAttributeObject(); then return 'O=null, attributes={}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDefaultAttributeObject.toString()"})
  void testToString_givenPDDefaultAttributeObject_thenReturnONullAttributes() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", new PDDefaultAttributeObject().toString());
  }

  /**
   * Test {@link PDDefaultAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Then return {@code O=null, attributes={Length=COSInt{0}}}.
   * </ul>
   *
   * <p>Method under test: {@link PDDefaultAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null, attributes={Length=COSInt{0}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDefaultAttributeObject.toString()"})
  void testToString_thenReturnONullAttributesLengthCOSInt0() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject =
        new PDDefaultAttributeObject(new COSStream());
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertEquals("O=null, attributes={Length=COSInt{0}}", pdDefaultAttributeObject.toString());
  }
}
