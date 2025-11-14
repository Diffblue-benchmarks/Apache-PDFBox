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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAttributeObjectDiffblueTest {
  /**
   * Test {@link PDAttributeObject#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return AttributeNames Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then return AttributeNames Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAttributeObject PDAttributeObject.create(COSDictionary)"})
  void testCreate_whenCOSDictionary_thenReturnAttributeNamesEmpty() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act
    PDAttributeObject actualCreateResult = PDAttributeObject.create(dictionary);

    // Assert
    assertTrue(actualCreateResult instanceof PDDefaultAttributeObject);
    assertTrue(((PDDefaultAttributeObject) actualCreateResult).getAttributeNames().isEmpty());
    assertSame(dictionary, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDAttributeObject#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return AttributeNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#create(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test create(COSDictionary); when COSStream(); then return AttributeNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDAttributeObject PDAttributeObject.create(COSDictionary)"})
  void testCreate_whenCOSStream_thenReturnAttributeNamesSizeIsOne() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act
    PDAttributeObject actualCreateResult = PDAttributeObject.create(dictionary);

    // Assert
    assertTrue(actualCreateResult instanceof PDDefaultAttributeObject);
    List<String> attributeNames =
        ((PDDefaultAttributeObject) actualCreateResult).getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Length", attributeNames.get(0));
    assertSame(dictionary, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDAttributeObject#getOwner()}.
   *
   * <p>Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.getOwner()"})
  void testGetOwner() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject =
        new PDDefaultAttributeObject(new COSStream());
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertNull(pdDefaultAttributeObject.getOwner());
  }

  /**
   * Test {@link PDAttributeObject#getOwner()}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner(); given PDDefaultAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.getOwner()"})
  void testGetOwner_givenPDDefaultAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDefaultAttributeObject().getOwner());
  }

  /**
   * Test {@link PDAttributeObject#setOwner(String)}.
   *
   * <ul>
   *   <li>When {@code CSS-1.00}.
   *   <li>Then {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} Owner is {@code
   *       CSS-1.00}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  @DisplayName(
      "Test setOwner(String); when 'CSS-1.00'; then PDDefaultAttributeObject() Owner is 'CSS-1.00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.setOwner(String)"})
  void testSetOwner_whenCss100_thenPDDefaultAttributeObjectOwnerIsCss100() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setOwner("CSS-1.00");

    // Assert
    assertEquals("CSS-1.00", pdDefaultAttributeObject.getOwner());
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDefaultAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#setOwner(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} COSObject size is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  @DisplayName(
      "Test setOwner(String); when 'null'; then PDDefaultAttributeObject() COSObject size is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.setOwner(String)"})
  void testSetOwner_whenNull_thenPDDefaultAttributeObjectCOSObjectSizeIsZero() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setOwner(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertFalse(pdDefaultAttributeObject.isEmpty());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#setOwner(String)}.
   *
   * <ul>
   *   <li>When {@code Owner}.
   *   <li>Then {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} Owner is {@code Owner}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  @DisplayName(
      "Test setOwner(String); when 'Owner'; then PDDefaultAttributeObject() Owner is 'Owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.setOwner(String)"})
  void testSetOwner_whenOwner_thenPDDefaultAttributeObjectOwnerIsOwner() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();

    // Act
    pdDefaultAttributeObject.setOwner("Owner");

    // Assert
    assertEquals("Owner", pdDefaultAttributeObject.getOwner());
    COSDictionary cOSObject = pdDefaultAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdDefaultAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#isEmpty()}.
   *
   * <p>Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAttributeObject.isEmpty()"})
  void testIsEmpty() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject =
        new PDDefaultAttributeObject(new COSStream());
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertFalse(pdDefaultAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#isEmpty()}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given PDDefaultAttributeObject(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDAttributeObject.isEmpty()"})
  void testIsEmpty_givenPDDefaultAttributeObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDDefaultAttributeObject().isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   *
   * <ul>
   *   <li>Then calls {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName(
      "Test potentiallyNotifyChanged(COSBase, COSBase); then calls attributeChanged(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.potentiallyNotifyChanged(COSBase, COSBase)"})
  void testPotentiallyNotifyChanged_thenCallsAttributeChanged() {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getDictionaryObject(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName(
      "Test potentiallyNotifyChanged(COSBase, COSBase); then calls getDictionaryObject(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.potentiallyNotifyChanged(COSBase, COSBase)"})
  void testPotentiallyNotifyChanged_thenCallsGetDictionaryObject() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSName#A}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSArray getObject(int) return A; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSArrayGetObjectReturnA_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray.size()).thenReturn(3);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSFloat#ONE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(3);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSInteger.ONE);
    when(cosArray.size()).thenReturn(3);

    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosArray);
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return {@link
   *       Integer#MIN_VALUE}.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSDictionary getInt(COSName, int) return MIN_VALUE; then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSDictionaryGetIntReturnMin_value_thenCallsGetInt() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(Integer.MIN_VALUE);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return one.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSDictionaryGetIntReturnOne_thenCallsGetInt() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return two hundred
   *       fifty-six.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName(
      "Test notifyChanged(); given COSDictionary getInt(COSName, int) return two hundred fifty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_givenCOSDictionaryGetIntReturnTwoHundredFiftySix() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(256);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dic).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(dic).getDictionaryObject(isA(COSName.class));
    verify(dic).getInt(isA(COSName.class), eq(0));
    verify(dic).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   *
   * <ul>
   *   <li>Then calls {@link PDStructureElement#attributeChanged(PDAttributeObject)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); then calls attributeChanged(PDAttributeObject)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAttributeObject.notifyChanged()"})
  void testNotifyChanged_thenCallsAttributeChanged() {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.
   *   <li>Then return {@code O=null, attributes={}}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDDefaultAttributeObject(); then return 'O=null, attributes={}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.toString()"})
  void testToString_givenPDDefaultAttributeObject_thenReturnONullAttributes() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", new PDDefaultAttributeObject().toString());
  }

  /**
   * Test {@link PDAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Then return {@code O=null, attributes={Length=COSInt{0}}}.
   * </ul>
   *
   * <p>Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null, attributes={Length=COSInt{0}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.toString()"})
  void testToString_thenReturnONullAttributesLengthCOSInt0() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject =
        new PDDefaultAttributeObject(new COSStream());
    pdDefaultAttributeObject.setStructureElement(new PDStructureElement(new COSDictionary()));

    // Act and Assert
    assertEquals("O=null, attributes={Length=COSInt{0}}", pdDefaultAttributeObject.toString());
  }

  /**
   * Test {@link PDAttributeObject#arrayToString(float[])} with {@code float[]}.
   *
   * <p>Method under test: {@link PDAttributeObject#arrayToString(float[])}
   */
  @Test
  @DisplayName("Test arrayToString(float[]) with 'float[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.arrayToString(float[])"})
  void testArrayToStringWithFloat() {
    // Arrange, Act and Assert
    assertEquals(
        "[10.0, 0.5, 10.0, 0.5]",
        PDAttributeObject.arrayToString(new float[] {10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Test {@link PDAttributeObject#arrayToString(Object[])} with {@code Object[]}.
   *
   * <p>Method under test: {@link PDAttributeObject#arrayToString(Object[])}
   */
  @Test
  @DisplayName("Test arrayToString(Object[]) with 'Object[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDAttributeObject.arrayToString(Object[])"})
  void testArrayToStringWithObject() {
    // Arrange, Act and Assert
    assertEquals("[Array]", PDAttributeObject.arrayToString(new Object[] {"Array"}));
  }
}
