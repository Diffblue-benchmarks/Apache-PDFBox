package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSimpleFontDiffblueTest {
  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding()")
  void testReadEncoding() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    PDMMType1Font pdmmType1Font = new PDMMType1Font(fontDictionary);
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act
    pdmmType1Font.readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSDictionary#containsKey(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray() add FALSE; then calls containsKey(COSName)")
  void testReadEncoding_givenCOSArrayAddFalse_thenCallsContainsKey() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return A; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnA_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSInteger.ONE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return two hundred
   * fifty.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray size() return two hundred fifty; then calls getObject(int)")
  void testReadEncoding_givenCOSArraySizeReturnTwoHundredFifty_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray.size()).thenReturn(250);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testReadEncoding_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getCOSDictionary(COSName)} return {@code null}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getCOSDictionary(COSName) return 'null'; then calls getObject(int)")
  void testReadEncoding_givenCOSDictionaryGetCOSDictionaryReturnNull_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(COSName.A);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSName(COSName)}
   * return {@code null}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getCOSName(COSName) return 'null'; then calls getObject(int)")
  void testReadEncoding_givenCOSDictionaryGetCOSNameReturnNull_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(cosDictionary.getCOSName(Mockito.<COSName>any())).thenReturn(null);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).containsKey(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(cosDictionary, atLeast(1)).getCOSName(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getDictionaryObject(COSName) return A")
  void testReadEncoding_givenCOSDictionaryGetDictionaryObjectReturnA() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.A);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getDictionaryObject(COSName) return COSDictionary()")
  void testReadEncoding_givenCOSDictionaryGetDictionaryObjectReturnCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getDictionaryObject(COSName) return COSStream()")
  void testReadEncoding_givenCOSDictionaryGetDictionaryObjectReturnCOSStream() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getDictionaryObject(COSName) return FALSE")
  void testReadEncoding_givenCOSDictionaryGetDictionaryObjectReturnFalse() throws IOException {
    // Arrange
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDMMType1Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDSimpleFont#getEncoding()}.
   * <p>
   * Method under test: {@link PDSimpleFont#getEncoding()}
   */
  @Test
  @DisplayName("Test getEncoding()")
  void testGetEncoding() throws IOException {
    // Arrange and Act
    Encoding actualEncoding = (new PDMMType1Font(new COSDictionary())).getEncoding();

    // Assert
    assertSame(((StandardEncoding) actualEncoding).INSTANCE, actualEncoding);
  }

  /**
   * Test {@link PDSimpleFont#getGlyphList()}.
   * <p>
   * Method under test: {@link PDSimpleFont#getGlyphList()}
   */
  @Test
  @DisplayName("Test getGlyphList()")
  void testGetGlyphList() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertSame(pdmmType1Font.glyphList, pdmmType1Font.getGlyphList());
  }

  /**
   * Test {@link PDSimpleFont#isSymbolic()}.
   * <p>
   * Method under test: {@link PDSimpleFont#isSymbolic()}
   */
  @Test
  @DisplayName("Test isSymbolic()")
  void testIsSymbolic() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.isSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#isSymbolic()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isSymbolic()}
   */
  @Test
  @DisplayName("Test isSymbolic(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testIsSymbolic_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#isSymbolic()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isSymbolic()}
   */
  @Test
  @DisplayName("Test isSymbolic(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testIsSymbolic_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSStream())).isSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#isFontSymbolic()}.
   * <p>
   * Method under test: {@link PDSimpleFont#isFontSymbolic()}
   */
  @Test
  @DisplayName("Test isFontSymbolic()")
  void testIsFontSymbolic() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.isFontSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#isFontSymbolic()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isFontSymbolic()}
   */
  @Test
  @DisplayName("Test isFontSymbolic(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testIsFontSymbolic_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isFontSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#isFontSymbolic()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isFontSymbolic()}
   */
  @Test
  @DisplayName("Test isFontSymbolic(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testIsFontSymbolic_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSStream())).isFontSymbolic());
  }

  /**
   * Test {@link PDSimpleFont#getSymbolicFlag()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#getSymbolicFlag()}
   */
  @Test
  @DisplayName("Test getSymbolicFlag(); then return 'false'")
  void testGetSymbolicFlag_thenReturnFalse() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.getSymbolicFlag());
  }

  /**
   * Test {@link PDSimpleFont#getSymbolicFlag()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#getSymbolicFlag()}
   */
  @Test
  @DisplayName("Test getSymbolicFlag(); then return 'null'")
  void testGetSymbolicFlag_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getSymbolicFlag());
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int, GlyphList)} with {@code code},
   * {@code customGlyphList}.
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int, GlyphList)}
   */
  @Test
  @DisplayName("Test toUnicode(int, GlyphList) with 'code', 'customGlyphList'")
  void testToUnicodeWithCodeCustomGlyphList() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSStream());

    // Act and Assert
    assertNull(pdmmType1Font.toUnicode(1, GlyphList.getAdobeGlyphList()));
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int, GlyphList)} with {@code code},
   * {@code customGlyphList}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int, GlyphList)}
   */
  @Test
  @DisplayName("Test toUnicode(int, GlyphList) with 'code', 'customGlyphList'; then return 'null'")
  void testToUnicodeWithCodeCustomGlyphList_thenReturnNull() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertNull(pdmmType1Font.toUnicode(1, GlyphList.getAdobeGlyphList()));
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int, GlyphList)} with {@code code},
   * {@code customGlyphList}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int, GlyphList)}
   */
  @Test
  @DisplayName("Test toUnicode(int, GlyphList) with 'code', 'customGlyphList'; when forty-six; then return '.'")
  void testToUnicodeWithCodeCustomGlyphList_whenFortySix_thenReturnDot() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertEquals(".", pdmmType1Font.toUnicode(46, GlyphList.getAdobeGlyphList()));
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testToUnicodeWithCode_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSStream())).toUnicode(1));
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; then return 'null'")
  void testToUnicodeWithCode_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).toUnicode(1));
  }

  /**
   * Test {@link PDSimpleFont#toUnicode(int)} with {@code code}.
   * <ul>
   *   <li>When forty-six.</li>
   *   <li>Then return {@code .}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#toUnicode(int)}
   */
  @Test
  @DisplayName("Test toUnicode(int) with 'code'; when forty-six; then return '.'")
  void testToUnicodeWithCode_whenFortySix_thenReturnDot() throws IOException {
    // Arrange, Act and Assert
    assertEquals(".", (new PDMMType1Font(new COSDictionary())).toUnicode(46));
  }

  /**
   * Test {@link PDSimpleFont#isVertical()}.
   * <p>
   * Method under test: {@link PDSimpleFont#isVertical()}
   */
  @Test
  @DisplayName("Test isVertical()")
  void testIsVertical() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isVertical());
  }

  /**
   * Test {@link PDSimpleFont#getStandard14Width(int)}.
   * <p>
   * Method under test: {@link PDSimpleFont#getStandard14Width(int)}
   */
  @Test
  @DisplayName("Test getStandard14Width(int)")
  void testGetStandard14Width() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDMMType1Font(new COSDictionary())).getStandard14Width(1));
  }

  /**
   * Test {@link PDSimpleFont#isStandard14()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isStandard14()}
   */
  @Test
  @DisplayName("Test isStandard14(); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testIsStandard14_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isStandard14());
  }

  /**
   * Test {@link PDSimpleFont#isStandard14()}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isStandard14()}
   */
  @Test
  @DisplayName("Test isStandard14(); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testIsStandard14_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSStream())).isStandard14());
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle)")
  void testIsNonZeroBoundingBox() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle(10.0f, 10.0f, 10.0f, 10.0f)));
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle)")
  void testIsNonZeroBoundingBox2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle(0.0f, 10.0f, 10.0f, 10.0f)));
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <ul>
   *   <li>Given ten.</li>
   *   <li>When {@link PDRectangle#PDRectangle()} UpperRightY is ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle); given ten; when PDRectangle() UpperRightY is ten; then return 'true'")
  void testIsNonZeroBoundingBox_givenTen_whenPDRectangleUpperRightYIsTen_thenReturnTrue() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    PDRectangle bbox = new PDRectangle();
    bbox.setUpperRightY(10.0f);

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(bbox));
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#A0}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle); when A0; then return 'true'")
  void testIsNonZeroBoundingBox_whenA0_thenReturnTrue() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSDictionary())).isNonZeroBoundingBox(PDRectangle.A0));
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle); when 'null'; then return 'false'")
  void testIsNonZeroBoundingBox_whenNull_thenReturnFalse() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isNonZeroBoundingBox(null));
  }

  /**
   * Test {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}.
   * <ul>
   *   <li>When {@link PDRectangle#PDRectangle()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test isNonZeroBoundingBox(PDRectangle); when PDRectangle(); then return 'false'")
  void testIsNonZeroBoundingBox_whenPDRectangle_thenReturnFalse() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertFalse(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle()));
  }

  /**
   * Test {@link PDSimpleFont#addToSubset(int)}.
   * <p>
   * Method under test: {@link PDSimpleFont#addToSubset(int)}
   */
  @Test
  @DisplayName("Test addToSubset(int)")
  void testAddToSubset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDMMType1Font(new COSDictionary())).addToSubset(2));
  }

  /**
   * Test {@link PDSimpleFont#subset()}.
   * <p>
   * Method under test: {@link PDSimpleFont#subset()}
   */
  @Test
  @DisplayName("Test subset()")
  void testSubset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDMMType1Font(new COSDictionary())).subset());
  }

  /**
   * Test {@link PDSimpleFont#willBeSubset()}.
   * <p>
   * Method under test: {@link PDSimpleFont#willBeSubset()}
   */
  @Test
  @DisplayName("Test willBeSubset()")
  void testWillBeSubset() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).willBeSubset());
  }

  /**
   * Test {@link PDSimpleFont#hasExplicitWidth(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#hasExplicitWidth(int)}
   */
  @Test
  @DisplayName("Test hasExplicitWidth(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testHasExplicitWidth_givenPDMMType1FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).hasExplicitWidth(1));
  }

  /**
   * Test {@link PDSimpleFont#hasExplicitWidth(int)}.
   * <ul>
   *   <li>Given {@link PDMMType1Font#PDMMType1Font(COSDictionary)} with
   * fontDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDSimpleFont#hasExplicitWidth(int)}
   */
  @Test
  @DisplayName("Test hasExplicitWidth(int); given PDMMType1Font(COSDictionary) with fontDictionary is COSStream()")
  void testHasExplicitWidth_givenPDMMType1FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSStream())).hasExplicitWidth(1));
  }
}
