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
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAttributeObjectDiffblueTest {
  /**
   * Test {@link PDAttributeObject#create(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return AttributeNames Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then return AttributeNames Empty")
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
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return AttributeNames size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSStream(); then return AttributeNames size is one")
  void testCreate_whenCOSStream_thenReturnAttributeNamesSizeIsOne() {
    // Arrange
    COSStream dictionary = new COSStream();

    // Act
    PDAttributeObject actualCreateResult = PDAttributeObject.create(dictionary);

    // Assert
    assertTrue(actualCreateResult instanceof PDDefaultAttributeObject);
    List<String> attributeNames = ((PDDefaultAttributeObject) actualCreateResult).getAttributeNames();
    assertEquals(1, attributeNames.size());
    assertEquals("Length", attributeNames.get(0));
    assertSame(dictionary, actualCreateResult.getCOSObject());
  }

  /**
   * Test {@link PDAttributeObject#getOwner()}.
   * <ul>
   *   <li>Given
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)} with
   * dictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner(); given PDDefaultAttributeObject(COSDictionary) with dictionary is COSStream()")
  void testGetOwner_givenPDDefaultAttributeObjectWithDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject(new COSStream())).getOwner());
  }

  /**
   * Test {@link PDAttributeObject#getOwner()}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#getOwner()}
   */
  @Test
  @DisplayName("Test getOwner(); given PDDefaultAttributeObject(); then return 'null'")
  void testGetOwner_givenPDDefaultAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDDefaultAttributeObject()).getOwner());
  }

  /**
   * Test {@link PDAttributeObject#setOwner(String)}.
   * <p>
   * Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  @DisplayName("Test setOwner(String)")
  void testSetOwner() {
    // Arrange
    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject(new COSDictionary());

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
   * Test {@link PDAttributeObject#setOwner(String)}.
   * <ul>
   *   <li>Then {@link PDDefaultAttributeObject#PDDefaultAttributeObject()} Owner is
   * {@code Owner}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#setOwner(String)}
   */
  @Test
  @DisplayName("Test setOwner(String); then PDDefaultAttributeObject() Owner is 'Owner'")
  void testSetOwner_thenPDDefaultAttributeObjectOwnerIsOwner() {
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
   * <ul>
   *   <li>Given
   * {@link PDDefaultAttributeObject#PDDefaultAttributeObject(COSDictionary)} with
   * dictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given PDDefaultAttributeObject(COSDictionary) with dictionary is COSStream()")
  void testIsEmpty_givenPDDefaultAttributeObjectWithDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse((new PDDefaultAttributeObject(new COSStream())).isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#isEmpty()}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given PDDefaultAttributeObject(); then return 'false'")
  void testIsEmpty_givenPDDefaultAttributeObject_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new PDDefaultAttributeObject()).isEmpty());
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSArray getObject(int) return A; then calls getObject(int)")
  void testPotentiallyNotifyChanged_givenCOSArrayGetObjectReturnA_thenCallsGetObject() {
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
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSArray getObject(int) return FALSE")
  void testPotentiallyNotifyChanged_givenCOSArrayGetObjectReturnFalse() {
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
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testPotentiallyNotifyChanged_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() {
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
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testPotentiallyNotifyChanged_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() {
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
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testPotentiallyNotifyChanged_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSDictionary getInt(COSName, int) return MIN_VALUE")
  void testPotentiallyNotifyChanged_givenCOSDictionaryGetIntReturnMin_value() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(Integer.MIN_VALUE);
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
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return one.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
  void testPotentiallyNotifyChanged_givenCOSDictionaryGetIntReturnOne_thenCallsGetInt() {
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
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); then calls attributeChanged(PDAttributeObject)")
  void testPotentiallyNotifyChanged_thenCallsAttributeChanged() {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSBoolean.TRUE, COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String, boolean)} with {@code Text} and
   * forceHex is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); when COSString(String, boolean) with 'Text' and forceHex is 'true'")
  void testPotentiallyNotifyChanged_whenCOSStringWithTextAndForceHexIsTrue() {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    COSString oldBase = new COSString("Text", true);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(oldBase, new COSString("Text"));

    // Assert
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>When {@link COSString#COSString(String)} with {@code Text}.</li>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); when COSString(String) with 'Text'; then calls attributeChanged(PDAttributeObject)")
  void testPotentiallyNotifyChanged_whenCOSStringWithText_thenCallsAttributeChanged() throws IOException {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    COSString oldBase = COSString.parseHex("0123456789ABCDEF");

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(oldBase, new COSString("Text"));

    // Assert
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 42}.</li>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); when parseHex '42'; then calls attributeChanged(PDAttributeObject)")
  void testPotentiallyNotifyChanged_whenParseHex42_thenCallsAttributeChanged() throws IOException {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);
    COSString oldBase = COSString.parseHex("42");

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(oldBase, COSString.parseHex("0123456789ABCDEF"));

    // Assert
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}.
   * <ul>
   *   <li>When parseHex {@code 0123456789ABCDEF}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAttributeObject#potentiallyNotifyChanged(COSBase, COSBase)}
   */
  @Test
  @DisplayName("Test potentiallyNotifyChanged(COSBase, COSBase); when parseHex '0123456789ABCDEF'")
  void testPotentiallyNotifyChanged_whenParseHex0123456789abcdef() throws IOException {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.potentiallyNotifyChanged(COSString.parseHex("0123456789ABCDEF"), COSBoolean.FALSE);

    // Assert that nothing has changed
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSArray getObject(int) return A; then calls getObject(int)")
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

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
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

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSArray getObject(int) return ONE; then calls getObject(int)")
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

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSArray getObject(int) return ONE; then calls getObject(int)")
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

    // Assert that nothing has changed
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  void testNotifyChanged_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    PDStructureElement structureElement = new PDStructureElement(dic);

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert that nothing has changed
    verify(dic).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAttributeObject#notifyChanged()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return {@link Integer#MIN_VALUE}.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSDictionary getInt(COSName, int) return MIN_VALUE; then calls getInt(COSName, int)")
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
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return minus one hundred.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSDictionary getInt(COSName, int) return minus one hundred; then calls getInt(COSName, int)")
  void testNotifyChanged_givenCOSDictionaryGetIntReturnMinusOneHundred_thenCallsGetInt() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    when(dic.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(-100);
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
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)}
   * return one.</li>
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); given COSDictionary getInt(COSName, int) return one; then calls getInt(COSName, int)")
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
   * <ul>
   *   <li>Then calls
   * {@link PDStructureElement#attributeChanged(PDAttributeObject)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#notifyChanged()}
   */
  @Test
  @DisplayName("Test notifyChanged(); then calls attributeChanged(PDAttributeObject)")
  void testNotifyChanged_thenCallsAttributeChanged() {
    // Arrange
    PDStructureElement structureElement = mock(PDStructureElement.class);
    doNothing().when(structureElement).attributeChanged(Mockito.<PDAttributeObject>any());

    PDDefaultAttributeObject pdDefaultAttributeObject = new PDDefaultAttributeObject();
    pdDefaultAttributeObject.setStructureElement(structureElement);

    // Act
    pdDefaultAttributeObject.notifyChanged();

    // Assert that nothing has changed
    verify(structureElement).attributeChanged(isA(PDAttributeObject.class));
  }

  /**
   * Test {@link PDAttributeObject#toString()}.
   * <ul>
   *   <li>Given {@link PDDefaultAttributeObject#PDDefaultAttributeObject()}.</li>
   *   <li>Then return {@code O=null, attributes={}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDDefaultAttributeObject(); then return 'O=null, attributes={}'")
  void testToString_givenPDDefaultAttributeObject_thenReturnONullAttributes() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={}", (new PDDefaultAttributeObject()).toString());
  }

  /**
   * Test {@link PDAttributeObject#toString()}.
   * <ul>
   *   <li>Then return {@code O=null, attributes={Length=COSInt{0}}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null, attributes={Length=COSInt{0}}'")
  void testToString_thenReturnONullAttributesLengthCOSInt0() {
    // Arrange, Act and Assert
    assertEquals("O=null, attributes={Length=COSInt{0}}", (new PDDefaultAttributeObject(new COSStream())).toString());
  }

  /**
   * Test {@link PDAttributeObject#arrayToString(float[])} with {@code float[]}.
   * <p>
   * Method under test: {@link PDAttributeObject#arrayToString(float[])}
   */
  @Test
  @DisplayName("Test arrayToString(float[]) with 'float[]'")
  void testArrayToStringWithFloat() {
    // Arrange, Act and Assert
    assertEquals("[10.0, 0.5, 10.0, 0.5]", PDAttributeObject.arrayToString(new float[]{10.0f, 0.5f, 10.0f, 0.5f}));
  }

  /**
   * Test {@link PDAttributeObject#arrayToString(Object[])} with {@code Object[]}.
   * <p>
   * Method under test: {@link PDAttributeObject#arrayToString(Object[])}
   */
  @Test
  @DisplayName("Test arrayToString(Object[]) with 'Object[]'")
  void testArrayToStringWithObject() {
    // Arrange, Act and Assert
    assertEquals("[Array]", PDAttributeObject.arrayToString(new Object[]{"Array"}));
  }
}
