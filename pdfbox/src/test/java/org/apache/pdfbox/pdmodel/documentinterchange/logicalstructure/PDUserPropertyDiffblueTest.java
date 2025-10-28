package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.Test;

class PDUserPropertyDiffblueTest {
  /**
   * Method under test: {@link PDUserProperty#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getName());
  }

  /**
   * Method under test: {@link PDUserProperty#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);

    // Act
    String actualName = (new PDUserProperty(userAttributeObject)).getName();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualName);
  }

  /**
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  void testSetName3() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act
    pdUserProperty.setName("NameName");

    // Assert
    assertEquals("NameName", pdUserProperty.getName());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDUserProperty#setName(String)}
   */
  @Test
  void testSetName4() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);
    PDUserProperty pdUserProperty = new PDUserProperty(userAttributeObject);

    // Act
    pdUserProperty.setName("Name");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("Name", pdUserProperty.getName());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDUserProperty#getValue()}
   */
  @Test
  void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getValue());
  }

  /**
   * Method under test: {@link PDUserProperty#getValue()}
   */
  @Test
  void testGetValue2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);

    // Act
    COSBase actualValue = (new PDUserProperty(userAttributeObject)).getValue();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualValue);
  }

  /**
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  void testSetValue3() {
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
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  void testSetValue4() {
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
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  void testSetValue5() {
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
   * Method under test: {@link PDUserProperty#setValue(COSBase)}
   */
  @Test
  void testSetValue6() throws IOException {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());
    COSDocument value = new COSDocument(streamCacheCreateFunction);

    // Act
    pdUserProperty.setValue(value);

    // Assert
    verify(streamCacheCreateFunction).create();
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(value, pdUserProperty.getValue());
  }

  /**
   * Method under test: {@link PDUserProperty#getFormattedValue()}
   */
  @Test
  void testGetFormattedValue() {
    // Arrange, Act and Assert
    assertNull((new PDUserProperty(new PDUserAttributeObject())).getFormattedValue());
  }

  /**
   * Method under test: {@link PDUserProperty#getFormattedValue()}
   */
  @Test
  void testGetFormattedValue2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);

    // Act
    String actualFormattedValue = (new PDUserProperty(userAttributeObject)).getFormattedValue();

    // Assert
    verify(objectable).getCOSObject();
    assertNull(actualFormattedValue);
  }

  /**
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setFormattedValue(String)}
   */
  @Test
  void testSetFormattedValue3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);
    PDUserProperty pdUserProperty = new PDUserProperty(userAttributeObject);

    // Act
    pdUserProperty.setFormattedValue("42");

    // Assert
    verify(objectable).getCOSObject();
    assertEquals("42", pdUserProperty.getFormattedValue());
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Method under test: {@link PDUserProperty#isHidden()}
   */
  @Test
  void testIsHidden() {
    // Arrange, Act and Assert
    assertFalse((new PDUserProperty(new PDUserAttributeObject())).isHidden());
  }

  /**
   * Method under test: {@link PDUserProperty#isHidden()}
   */
  @Test
  void testIsHidden2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);

    // Act
    boolean actualIsHiddenResult = (new PDUserProperty(userAttributeObject)).isHidden();

    // Assert
    verify(objectable).getCOSObject();
    assertFalse(actualIsHiddenResult);
  }

  /**
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
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
   * Method under test: {@link PDUserProperty#setHidden(boolean)}
   */
  @Test
  void testSetHidden3() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);
    PDUserProperty pdUserProperty = new PDUserProperty(userAttributeObject);

    // Act
    pdUserProperty.setHidden(true);

    // Assert
    verify(objectable).getCOSObject();
    COSDictionary cOSObject = pdUserProperty.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdUserProperty.isHidden());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDUserProperty#equals(Object)}
   *   <li>{@link PDUserProperty#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act and Assert
    assertEquals(pdUserProperty, pdUserProperty);
    int expectedHashCodeResult = pdUserProperty.hashCode();
    assertEquals(expectedHashCodeResult, pdUserProperty.hashCode());
  }

  /**
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(new PDUserAttributeObject());

    // Act and Assert
    assertNotEquals(pdUserProperty, new PDUserProperty(new PDUserAttributeObject()));
  }

  /**
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PDUserProperty pdUserProperty = new PDUserProperty(mock(PDUserAttributeObject.class));

    // Act and Assert
    assertNotEquals(pdUserProperty, new PDUserProperty(new PDUserAttributeObject()));
  }

  /**
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDUserProperty(new PDUserAttributeObject()), null);
  }

  /**
   * Method under test: {@link PDUserProperty#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PDUserProperty(new PDUserAttributeObject()), "Different type to PDUserProperty");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PDUserProperty#PDUserProperty(COSDictionary, PDUserAttributeObject)}
   *   <li>{@link PDUserProperty#toString()}
   * </ul>
   */
  @Test
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
   * Method under test:
   * {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)}
   */
  @Test
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
   * Method under test:
   * {@link PDUserProperty#PDUserProperty(PDUserAttributeObject)}
   */
  @Test
  void testNewPDUserProperty2() {
    // Arrange
    COSObjectable objectable = mock(COSObjectable.class);
    when(objectable.getCOSObject()).thenReturn(COSBoolean.FALSE);

    PDStructureElement structureElement = new PDStructureElement(new COSDictionary());
    structureElement.appendObjectableKid(objectable);

    PDUserAttributeObject userAttributeObject = new PDUserAttributeObject();
    userAttributeObject.setStructureElement(structureElement);

    // Act
    PDUserProperty actualPdUserProperty = new PDUserProperty(userAttributeObject);

    // Assert
    verify(objectable).getCOSObject();
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
}
