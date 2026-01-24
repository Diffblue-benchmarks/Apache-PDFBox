package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdfparser.COSParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDDeviceNAttributesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDDeviceNAttributes#PDDeviceNAttributes(COSDictionary)}
   *   <li>{@link PDDeviceNAttributes#getCOSDictionary()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PDDeviceNAttributes.<init>(COSDictionary)",
    "COSDictionary PDDeviceNAttributes.getCOSDictionary()"
  })
  void testGettersAndSetters() {
    // Arrange
    COSDictionary attributes = new COSDictionary();

    // Act and Assert
    assertSame(attributes, new PDDeviceNAttributes(attributes).getCOSDictionary());
  }

  /**
   * Test {@link PDDeviceNAttributes#getColorants()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNAttributes#PDDeviceNAttributes()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#getColorants()}
   */
  @Test
  @DisplayName("Test getColorants(); given PDDeviceNAttributes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map PDDeviceNAttributes.getColorants()"})
  void testGetColorants_givenPDDeviceNAttributes() throws IOException {
    // Arrange, Act and Assert
    assertTrue(new PDDeviceNAttributes().getColorants().isEmpty());
  }

  /**
   * Test {@link PDDeviceNAttributes#getColorants()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNAttributes#PDDeviceNAttributes()} Colorants is {@link
   *       HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#getColorants()}
   */
  @Test
  @DisplayName("Test getColorants(); given PDDeviceNAttributes() Colorants is HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map PDDeviceNAttributes.getColorants()"})
  void testGetColorants_givenPDDeviceNAttributesColorantsIsHashMap() throws IOException {
    // Arrange
    PDDeviceNAttributes pdDeviceNAttributes = new PDDeviceNAttributes();
    pdDeviceNAttributes.setColorants(new HashMap<>());

    // Act and Assert
    assertTrue(pdDeviceNAttributes.getColorants().isEmpty());
  }

  /**
   * Test {@link PDDeviceNAttributes#getProcess()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNAttributes#PDDeviceNAttributes()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#getProcess()}
   */
  @Test
  @DisplayName("Test getProcess(); given PDDeviceNAttributes(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.graphics.color.PDDeviceNProcess PDDeviceNAttributes.getProcess()"
  })
  void testGetProcess_givenPDDeviceNAttributes_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDDeviceNAttributes().getProcess());
  }

  /**
   * Test {@link PDDeviceNAttributes#isNChannel()}.
   *
   * <ul>
   *   <li>Given {@link PDDeviceNAttributes#PDDeviceNAttributes()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#isNChannel()}
   */
  @Test
  @DisplayName("Test isNChannel(); given PDDeviceNAttributes(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDDeviceNAttributes.isNChannel()"})
  void testIsNChannel_givenPDDeviceNAttributes_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new PDDeviceNAttributes().isNChannel());
  }

  /**
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString() {
    // Arrange
    COSDictionary attributes = mock(COSDictionary.class);
    when(attributes.getCOSDictionary(Mockito.<COSName>any()))
        .thenReturn(new COSDictionary(new COSDictionary()));
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString2() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    COSObject cosObject = new COSObject(COSBoolean.FALSE, new COSObjectKey(123L, 123));
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
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString3() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosStream);

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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetCOSArray() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSName#A}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSDictionary getDictionaryObject(COSName) return A")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnA() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSDictionary getDictionaryObject(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnCOSArray() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSDictionary getDictionaryObject(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnCOSDictionary() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSDictionary getDictionaryObject(COSName) return COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnCOSStream() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnFalse() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnOne() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSDictionaryGetDictionaryObjectReturnOne2() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSName} {@link COSName#getName()} return {@code Name}.
   *   <li>Then calls {@link COSName#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSName getName() return 'Name'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSNameGetNameReturnName_thenCallsGetName() {
    // Arrange
    COSName cosName = mock(COSName.class);
    when(cosName.getName()).thenReturn("Name");

    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosName);

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
    verify(cosName).getName();
    verify(cosObject).getObject();
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSObject#getObject()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); given COSObject getObject() return FALSE; then calls getObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSObjectGetObjectReturnFalse_thenCallsGetObject() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link COSParser#COSParser(RandomAccessRead)} with source is {@link
   *       RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer()}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given COSParser(RandomAccessRead) with source is RandomAccessReadWriteBuffer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenCOSParserWithSourceIsRandomAccessReadWriteBuffer() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.keySet()).thenReturn(new HashSet<>());
    COSObjectKey key = new COSObjectKey(123L, 123);
    COSObject cosObject = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
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
    assertEquals("Name As String{Process{ERROR} Colorants{}}", actualToStringResult);
  }

  /**
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link COSName#A}.
   *   <li>Then return {@code Name As String{Process{ERROR} ERROR}}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given HashSet() add A; then return 'Name As String{Process{ERROR} ERROR}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_givenHashSetAddA_thenReturnNameAsStringProcessErrorError() {
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
   * Test {@link PDDeviceNAttributes#toString()}.
   *
   * <ul>
   *   <li>Then return {@code Name As String{Colorants{}}}.
   * </ul>
   *
   * <p>Method under test: {@link PDDeviceNAttributes#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'Name As String{Colorants{}}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDDeviceNAttributes.toString()"})
  void testToString_thenReturnNameAsStringColorants() {
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
}
