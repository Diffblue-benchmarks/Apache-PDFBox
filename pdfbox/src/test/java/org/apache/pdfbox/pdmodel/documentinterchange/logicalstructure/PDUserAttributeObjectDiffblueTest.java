package org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDUserAttributeObjectDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDUserAttributeObject#PDUserAttributeObject(COSDictionary)}
   *   <li>{@link PDUserAttributeObject#userPropertyChanged(PDUserProperty)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDUserAttributeObject actualPdUserAttributeObject = new PDUserAttributeObject(dictionary);
    actualPdUserAttributeObject.userPropertyChanged(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    assertSame(dictionary, actualPdUserAttributeObject.getCOSObject());
  }

  /**
   * Test {@link PDUserAttributeObject#PDUserAttributeObject()}.
   * <p>
   * Method under test: {@link PDUserAttributeObject#PDUserAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDUserAttributeObject()")
  void testNewPDUserAttributeObject() {
    // Arrange and Act
    PDUserAttributeObject actualPdUserAttributeObject = new PDUserAttributeObject();

    // Assert
    COSDictionary cOSObject = actualPdUserAttributeObject.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(actualPdUserAttributeObject.isEmpty());
    assertEquals(PDUserAttributeObject.OWNER_USER_PROPERTIES, actualPdUserAttributeObject.getOwner());
  }

  /**
   * Test {@link PDUserAttributeObject#getOwnerUserProperties()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserAttributeObject#getOwnerUserProperties()}
   */
  @Test
  @DisplayName("Test getOwnerUserProperties(); then return Empty")
  void testGetOwnerUserProperties_thenReturnEmpty() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    List<PDUserProperty> actualOwnerUserProperties = (new PDUserAttributeObject(dictionary)).getOwnerUserProperties();

    // Assert
    verify(dictionary).getCOSArray(isA(COSName.class));
    assertTrue(actualOwnerUserProperties.isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#getOwnerUserProperties()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserAttributeObject#getOwnerUserProperties()}
   */
  @Test
  @DisplayName("Test getOwnerUserProperties(); then return size is three")
  void testGetOwnerUserProperties_thenReturnSizeIsThree() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    COSDictionary cosDictionary = new COSDictionary();
    when(cosArray.getObject(anyInt())).thenReturn(cosDictionary);
    when(cosArray.size()).thenReturn(3);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    List<PDUserProperty> actualOwnerUserProperties = (new PDUserAttributeObject(dictionary)).getOwnerUserProperties();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    assertEquals(3, actualOwnerUserProperties.size());
    PDUserProperty getResult = actualOwnerUserProperties.get(0);
    assertNull(getResult.getFormattedValue());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertFalse(getResult.isHidden());
    assertEquals(getResult, actualOwnerUserProperties.get(1));
    assertEquals(getResult, actualOwnerUserProperties.get(2));
    assertSame(cosDictionary, getResult.getCOSObject());
  }

  /**
   * Test {@link PDUserAttributeObject#setUserProperties(List)}.
   * <p>
   * Method under test: {@link PDUserAttributeObject#setUserProperties(List)}
   */
  @Test
  @DisplayName("Test setUserProperties(List)")
  void testSetUserProperties() {
    // Arrange
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject();

    ArrayList<PDUserProperty> userProperties = new ArrayList<>();
    userProperties.add(new PDUserProperty(new PDUserAttributeObject()));

    // Act
    pdUserAttributeObject.setUserProperties(userProperties);

    // Assert
    List<PDUserProperty> ownerUserProperties = pdUserAttributeObject.getOwnerUserProperties();
    assertEquals(1, ownerUserProperties.size());
    PDUserProperty getResult = ownerUserProperties.get(0);
    assertNull(getResult.getFormattedValue());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertFalse(getResult.isHidden());
  }

  /**
   * Test {@link PDUserAttributeObject#setUserProperties(List)}.
   * <p>
   * Method under test: {@link PDUserAttributeObject#setUserProperties(List)}
   */
  @Test
  @DisplayName("Test setUserProperties(List)")
  void testSetUserProperties2() {
    // Arrange
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject();

    ArrayList<PDUserProperty> userProperties = new ArrayList<>();
    userProperties.add(null);

    // Act
    pdUserAttributeObject.setUserProperties(userProperties);

    // Assert
    List<PDUserProperty> ownerUserProperties = pdUserAttributeObject.getOwnerUserProperties();
    assertEquals(1, ownerUserProperties.size());
    assertNull(ownerUserProperties.get(0).getCOSObject());
    COSDictionary cOSObject = pdUserAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdUserAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#setUserProperties(List)}.
   * <ul>
   *   <li>Then {@link PDUserAttributeObject#PDUserAttributeObject()}
   * OwnerUserProperties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserAttributeObject#setUserProperties(List)}
   */
  @Test
  @DisplayName("Test setUserProperties(List); then PDUserAttributeObject() OwnerUserProperties Empty")
  void testSetUserProperties_thenPDUserAttributeObjectOwnerUserPropertiesEmpty() {
    // Arrange
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject();

    // Act
    pdUserAttributeObject.setUserProperties(new ArrayList<>());

    // Assert
    COSDictionary cOSObject = pdUserAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdUserAttributeObject.isEmpty());
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#setUserProperties(List)}.
   * <ul>
   *   <li>Then {@link PDUserAttributeObject#PDUserAttributeObject()}
   * OwnerUserProperties size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDUserAttributeObject#setUserProperties(List)}
   */
  @Test
  @DisplayName("Test setUserProperties(List); then PDUserAttributeObject() OwnerUserProperties size is two")
  void testSetUserProperties_thenPDUserAttributeObjectOwnerUserPropertiesSizeIsTwo() {
    // Arrange
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject();

    ArrayList<PDUserProperty> userProperties = new ArrayList<>();
    userProperties.add(new PDUserProperty(new PDUserAttributeObject()));
    userProperties.add(new PDUserProperty(new PDUserAttributeObject()));

    // Act
    pdUserAttributeObject.setUserProperties(userProperties);

    // Assert
    List<PDUserProperty> ownerUserProperties = pdUserAttributeObject.getOwnerUserProperties();
    assertEquals(2, ownerUserProperties.size());
    PDUserProperty getResult = ownerUserProperties.get(1);
    assertNull(getResult.getFormattedValue());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertFalse(getResult.isHidden());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty)")
  void testAddUserProperty() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert
    verify(dictionary).getCOSArray(isA(COSName.class));
    List<PDUserProperty> ownerUserProperties = pdUserAttributeObject.getOwnerUserProperties();
    assertEquals(1, ownerUserProperties.size());
    PDUserProperty getResult = ownerUserProperties.get(0);
    assertNull(getResult.getFormattedValue());
    assertNull(getResult.getName());
    assertNull(getResult.getValue());
    assertFalse(getResult.isHidden());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty)")
  void testAddUserProperty2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSArray getObject(int) return A; then calls getObject(int)")
  void testAddUserProperty_givenCOSArrayGetObjectReturnA_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testAddUserProperty_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testAddUserProperty_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testAddUserProperty_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSInteger.ONE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testAddUserProperty_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return {@link Integer#MIN_VALUE}.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSDictionary getInt(COSName, int) return MIN_VALUE; then calls getInt(COSName, int)")
  void testAddUserProperty_givenCOSDictionaryGetIntReturnMin_value_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(Integer.MIN_VALUE);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return one.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
  void testAddUserProperty_givenCOSDictionaryGetIntReturnOne_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link PDUserAttributeObject#PDUserAttributeObject(COSDictionary)}
   * with dictionary is {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); given PDUserAttributeObject(COSDictionary) with dictionary is COSDictionary")
  void testAddUserProperty_givenPDUserAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#addUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test addUserProperty(PDUserProperty); then calls attributeChanged(PDAttributeObject)")
  void testAddUserProperty_thenCallsAttributeChanged() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    doNothing().when(cosArray).add(Mockito.<COSObjectable>any());
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);

    // Act
    pdUserAttributeObject.addUserProperty(new PDUserProperty(new PDUserAttributeObject()));

    // Assert that nothing has changed
    verify(cosArray).add(isA(COSObjectable.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
    assertTrue(pdUserAttributeObject.getOwnerUserProperties().isEmpty());
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty)")
  void testRemoveUserProperty() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSArray getObject(int) return A; then calls getObject(int)")
  void testRemoveUserProperty_givenCOSArrayGetObjectReturnA_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testRemoveUserProperty_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testRemoveUserProperty_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testRemoveUserProperty_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSArray cosArray2 = mock(COSArray.class);
    when(cosArray2.getObject(anyInt())).thenReturn(COSInteger.ONE);
    when(cosArray2.size()).thenReturn(3);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray2);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray2, atLeast(1)).getObject(anyInt());
    verify(cosArray).remove(isA(COSBase.class));
    verify(cosArray2, atLeast(1)).size();
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testRemoveUserProperty_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testRemoveUserProperty_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return {@link Integer#MIN_VALUE}.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSDictionary getInt(COSName, int) return MIN_VALUE; then calls getInt(COSName, int)")
  void testRemoveUserProperty_givenCOSDictionaryGetIntReturnMin_value_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(Integer.MIN_VALUE);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return one.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
  void testRemoveUserProperty_givenCOSDictionaryGetIntReturnOne_thenCallsGetInt() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Given {@link PDUserAttributeObject#PDUserAttributeObject(COSDictionary)}
   * with dictionary is {@link COSDictionary}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); given PDUserAttributeObject(COSDictionary) with dictionary is COSDictionary")
  void testRemoveUserProperty_givenPDUserAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(userProperty).getCOSObject();
  }

  /**
   * Test {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}.
   * <ul>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDUserAttributeObject#removeUserProperty(PDUserProperty)}
   */
  @Test
  @DisplayName("Test removeUserProperty(PDUserProperty); then calls attributeChanged(PDAttributeObject)")
  void testRemoveUserProperty_thenCallsAttributeChanged() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.remove(Mockito.<COSBase>any())).thenReturn(true);
    COSDictionary dictionary = mock(COSDictionary.class);
    when(dictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDUserAttributeObject pdUserAttributeObject = new PDUserAttributeObject(dictionary);
    pdUserAttributeObject.setStructureElement(structureElement);
    PDUserProperty userProperty = mock(PDUserProperty.class);
    when(userProperty.getCOSObject()).thenReturn(new COSDictionary());

    // Act
    pdUserAttributeObject.removeUserProperty(userProperty);

    // Assert that nothing has changed
    verify(cosArray).remove(isA(COSBase.class));
    verify(dictionary).getCOSArray(isA(COSName.class));
    verify(userProperty).getCOSObject();
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }
}
