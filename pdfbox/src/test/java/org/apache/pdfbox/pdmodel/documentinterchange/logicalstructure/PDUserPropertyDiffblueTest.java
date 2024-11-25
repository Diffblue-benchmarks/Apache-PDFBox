package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import org.junit.jupiter.api.Test;

class PDUserPropertyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDUserProperty#PDUserProperty(COSDictionary, PDUserAttributeObject)}
   *   <li>{@link PDUserProperty#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDUserProperty actualPdUserProperty = new PDUserProperty(dictionary, new PDUserAttributeObject());

    // Assert
    assertEquals("Name=null, Value=null, FormattedValue=null, Hidden=false", actualPdUserProperty.toString());
    assertSame(dictionary, actualPdUserProperty.getCOSObject());
  }

  /**
   * Test {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)}.
   * <p>
   * Method under test:
   * {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)}
   */
  @Test
  @DisplayName("Test new PDUserProperty(PDUserAttributeObject)")
  void testNewPDUserProperty() {
    // Arrange and Act
    PDUserProperty actualPdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Assert
    assertNull(actualPdUserProperty.getFormattedValue());
    assertNull(actualPdUserProperty.getName());
    assertNull(actualPdUserProperty.getValue());
    COSDictionary cOSObject = actualPdUserProperty.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdUserProperty.isHidden());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDUserProperty#getName()}.
   * <p>
   * Method under test: {@link PDUserProperty#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act and Assert
    assertNull((new PDUserProperty(dictionary, new PDUserAttributeObject())).getName());
  }

  /**
   * Test {@link PDUserProperty#getName()}.
   * <ul>
   *   <li>Given {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)} with
   * userAttributeObject is
   * {@link PDUserAttributeObject#PDUserAttributeObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDUserProperty(PDUserAttributeObject) with userAttributeObject is PDUserAttributeObject()")
  void testGetName_givenPDUserPropertyWithUserAttributeObjectIsPDUserAttributeObject() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getName());
  }

  /**
   * Test {@link PDUserProperty#setName(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  void testSetName() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setName("Name");

    // Assert
    assertEquals("Name", pdUserProperty.getName());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#setName(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  void testSetName2() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setName(null);

    // Assert
    assertNull(pdUserProperty.getName());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDUserProperty#setName(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  void testSetName3() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setName("42");

    // Assert
    assertEquals("42", pdUserProperty.getName());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#setName(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  void testSetName4() {
    // Arrange
    COSStream dictionary = new COSStream();
    PDUserProperty pdUserProperty = new PDUserProperty(dictionary, new PDUserAttributeObject());

    // Act
    pdUserProperty.setName("Name");

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals("Name", pdUserProperty.getName());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#getValue()}.
   * <p>
   * Method under test: {@link PDUserProperty#getValue()}
   */
  @Test
  @DisplayName("Test getValue()")
  void testGetValue() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act and Assert
    assertNull((new PDUserProperty(dictionary, new PDUserAttributeObject())).getValue());
  }

  /**
   * Test {@link PDUserProperty#getValue()}.
   * <ul>
   *   <li>Given {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)} with
   * userAttributeObject is
   * {@link PDUserAttributeObject#PDUserAttributeObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#getValue()}
   */
  @Test
  @DisplayName("Test getValue(); given PDUserProperty(PDUserAttributeObject) with userAttributeObject is PDUserAttributeObject()")
  void testGetValue_givenPDUserPropertyWithUserAttributeObjectIsPDUserAttributeObject() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getValue());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase)")
  void testSetValue() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());
    COSBoolean value = COSBoolean.FALSE;

    // Act
    pdUserProperty.setValue(value);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSBoolean expectedValue = value.FALSE;
    assertSame(expectedValue, pdUserProperty.getValue());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase)")
  void testSetValue2() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());
    COSArray value = new COSArray();

    // Act
    pdUserProperty.setValue(value);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdUserProperty.getValue());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase)")
  void testSetValue3() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setValue(null);

    // Assert
    assertNull(pdUserProperty.getValue());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase); given COSObjectKey(long, int) with num is one and gen is one")
  void testSetValue_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    COSDictionary value = new COSDictionary();
    value.setKey(new COSObjectKey(1L, 1));

    // Act
    pdUserProperty.setValue(value);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdUserProperty.getValue());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase); when COSDictionary()")
  void testSetValue_whenCOSDictionary() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());
    COSDictionary value = new COSDictionary();

    // Act
    pdUserProperty.setValue(value);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdUserProperty.getValue());
  }

  /**
   * Test {@link PDUserProperty#setValue(COSBase)}.
   * <ul>
   *   <li>When {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen
   * is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  @DisplayName("Test setValue(COSBase); when COSObjectKey(long, int) with num is one and gen is one")
  void testSetValue_whenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setValue(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#getFormattedValue()}.
   * <p>
   * Method under test: {@link PDUserProperty#getFormattedValue()}
   */
  @Test
  @DisplayName("Test getFormattedValue()")
  void testGetFormattedValue() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getFormattedValue());
  }

  /**
   * Test {@link PDUserProperty#getFormattedValue()}.
   * <p>
   * Method under test: {@link PDUserProperty#getFormattedValue()}
   */
  @Test
  @DisplayName("Test getFormattedValue()")
  void testGetFormattedValue2() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act and Assert
    assertNull((new PDUserProperty(dictionary, new PDUserAttributeObject())).getFormattedValue());
  }

  /**
   * Test {@link PDUserProperty#setFormattedValue(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
  @DisplayName("Test setFormattedValue(String)")
  void testSetFormattedValue() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setFormattedValue("42");

    // Assert
    assertEquals("42", pdUserProperty.getFormattedValue());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#setFormattedValue(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
  @DisplayName("Test setFormattedValue(String)")
  void testSetFormattedValue2() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setFormattedValue(null);

    // Assert
    assertNull(pdUserProperty.getFormattedValue());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDUserProperty#setFormattedValue(String)}.
   * <p>
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
  @DisplayName("Test setFormattedValue(String)")
  void testSetFormattedValue3() {
    // Arrange
    COSStream dictionary = new COSStream();
    PDUserProperty pdUserProperty = new PDUserProperty(dictionary, new PDUserAttributeObject());

    // Act
    pdUserProperty.setFormattedValue("42");

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals("42", pdUserProperty.getFormattedValue());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDUserProperty#isHidden()}.
   * <p>
   * Method under test: {@link PDUserProperty#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden()")
  void testIsHidden() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act and Assert
    assertFalse((new PDUserProperty(dictionary, new PDUserAttributeObject())).isHidden());
  }

  /**
   * Test {@link PDUserProperty#isHidden()}.
   * <ul>
   *   <li>Given {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)} with
   * userAttributeObject is
   * {@link PDUserAttributeObject#PDUserAttributeObject()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#isHidden()}
   */
  @Test
  @DisplayName("Test isHidden(); given PDUserProperty(PDUserAttributeObject) with userAttributeObject is PDUserAttributeObject()")
  void testIsHidden_givenPDUserPropertyWithUserAttributeObjectIsPDUserAttributeObject() {
    // Arrange, Act and Assert
    assertFalse((new PDUserProperty(new PDUserAttributeObject())).isHidden());
  }

  /**
   * Test {@link PDUserProperty#setHidden(boolean)}.
   * <p>
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean)")
  void testSetHidden() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setHidden(true);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdUserProperty.isHidden());
  }

  /**
   * Test {@link PDUserProperty#setHidden(boolean)}.
   * <p>
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean)")
  void testSetHidden2() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setHidden(false);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdUserProperty.isHidden());
  }

  /**
   * Test {@link PDUserProperty#setHidden(boolean)}.
   * <p>
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
  @DisplayName("Test setHidden(boolean)")
  void testSetHidden3() {
    // Arrange
    COSStream dictionary = new COSStream();
    PDUserProperty pdUserProperty = new PDUserProperty(dictionary, new PDUserAttributeObject());

    // Act
    pdUserProperty.setHidden(true);

    // Assert
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertTrue(cOSObject instanceof COSStream);
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertTrue(pdUserProperty.isHidden());
  }

  /**
   * Test {@link PDUserProperty#equals(Object)}, and
   * {@link PDUserProperty#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDUserProperty#equals(Object)}
   *   <li>{@link PDUserProperty#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act and Assert
    assertEquals(pdUserProperty, pdUserProperty);
    int expectedHashCodeResult = pdUserProperty.hashCode();
    assertEquals(expectedHashCodeResult, pdUserProperty.hashCode());
  }

  /**
   * Test {@link PDUserProperty#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act and Assert
    assertNotEquals(pdUserProperty, new PDUserProperty(new PDUserAttributeObject()));
  }

  /**
   * Test {@link PDUserProperty#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDUserProperty(new PDUserAttributeObject()), null);
  }

  /**
   * Test {@link PDUserProperty#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDUserProperty(new PDUserAttributeObject()), "Different type to PDUserProperty");
  }
}
