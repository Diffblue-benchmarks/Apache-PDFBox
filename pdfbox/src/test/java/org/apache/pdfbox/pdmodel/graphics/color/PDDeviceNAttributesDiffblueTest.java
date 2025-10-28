package org.apache.pdfbox.pdmodel.graphics.color;

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
import java.util.HashMap;
import java.util.HashSet;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDeviceNAttributesDiffblueTest {
  /**
   * Method under test: {@link PDDeviceNAttributes#getColorants()}
   */
  @Test
  void testGetColorants() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDDeviceNAttributes()).getColorants().isEmpty());
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#getColorants()}
   */
  @Test
  void testGetColorants2() throws IOException {
    // Arrange
    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes();
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act and Assert
    assertTrue(pdDeviceNAttributes.getColorants().isEmpty());
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#getProcess()}
   */
  @Test
  void testGetProcess() {
    // Arrange, Act and Assert
    assertNull((new PDDeviceNAttributes()).getProcess());
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#isNChannel()}
   */
  @Test
  void testIsNChannel() {
    // Arrange, Act and Assert
    assertFalse((new PDDeviceNAttributes()).isNChannel());
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString() {
    // Arrange
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{null} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString2() {
    // Arrange
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(attributes, atLeast(1)).setItem(isA(COSName.class), Mockito.<COSBase>any());
    assertEquals("Name As String{Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString3() {
    // Arrange
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary(new COSDictionary()));
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{null} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString4() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString5() {
    // Arrange
    HashSet<COSName> cosNameSet = new HashSet<>();
    cosNameSet.add(COSName.A);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(cosNameSet);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} ERROR}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString6() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString7() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString8() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString9() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any()))
        .thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(123L, 123)));
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString10() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(null);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{null} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString11() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString12() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString13() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSStream());
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString14() {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSBoolean.FALSE);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosObject).getObject();
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString15() {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(null);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosObject).getObject();
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString16() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(cosArray).isEmpty();
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosObject).getObject();
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  void testToString17() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosObject);
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(attributes.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    doNothing().when(attributes).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes(attributes);
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act
    String actualToStringResult = pdDeviceNAttributes.toString();

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).isEmpty();
    verify(attributes, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(attributes).getNameAsString(isA(COSName.class));
    verify(cosDictionary).keySet();
    verify(attributes).setItem(isA(COSName.class), isA(COSBase.class));
    verify(cosObject).getObject();
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDDeviceNAttributes#PDDeviceNAttributes(COSDictionary)}
   *   <li>{@link PDDeviceNAttributes#getCOSDictionary()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary attributes = new COSDictionary();

    // Act and Assert
    assertSame(attributes, (new PDDeviceNAttributes(attributes)).getCOSDictionary());
  }
}
