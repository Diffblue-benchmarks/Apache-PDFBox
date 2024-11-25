package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType3FontDiffblueTest {
  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#PDType3Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType3Font(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDType3Font_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary);

    // Assert
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test new PDType3Font(COSDictionary, ResourceCache); when COSDictionary(); then return COSObject is COSDictionary()")
  void testNewPDType3Font_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary, new DefaultResourceCache());

    // Assert
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#PDType3Font(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDType3Font(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  void testNewPDType3Font_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary);

    // Assert
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName("Test new PDType3Font(COSDictionary, ResourceCache); when COSStream(); then return COSObject is COSStream()")
  void testNewPDType3Font_whenCOSStream_thenReturnCOSObjectIsCOSStream2() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary, new DefaultResourceCache());

    // Assert
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#getName()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetName_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getName());
  }

  /**
   * Test {@link PDType3Font#getName()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getName()}
   */
  @Test
  @DisplayName("Test getName(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetName_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSStream())).getName());
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  void testReadEncoding_givenCOSArrayAddFalse_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSName#A}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return A; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnA_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.A);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSFloat#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnOne_thenCallsGetObject() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSInteger#ONE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSArray getObject(int) return ONE; then calls getObject(int)")
  void testReadEncoding_givenCOSArrayGetObjectReturnOne_thenCallsGetObject2() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSInteger.ONE);
    when(cosArray.size()).thenReturn(3);
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  @DisplayName("Test readEncoding(); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testReadEncoding_givenCOSDictionaryGetCOSArrayReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    COSDictionary fontDictionary = mock(COSDictionary.class);
    when(fontDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(fontDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);
    when(fontDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());

    // Act
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(cosDictionary, atLeast(1)).getCOSArray(isA(COSName.class));
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
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
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
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
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncoding()}.
   * <ul>
   *   <li>Given {@link COSDictionary}
   * {@link COSDictionary#getDictionaryObject(COSName)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readEncoding()}
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
    (new PDType3Font(fontDictionary)).readEncoding();

    // Assert
    verify(fontDictionary).getCOSDictionary(isA(COSName.class));
    verify(fontDictionary, atLeast(1)).getDictionaryObject(Mockito.<COSName>any());
    verify(fontDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#readEncodingFromFont()}.
   * <p>
   * Method under test: {@link PDType3Font#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  void testReadEncodingFromFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDType3Font(new COSDictionary())).readEncodingFromFont());
  }

  /**
   * Test {@link PDType3Font#isFontSymbolic()}.
   * <p>
   * Method under test: {@link PDType3Font#isFontSymbolic()}
   */
  @Test
  @DisplayName("Test isFontSymbolic()")
  void testIsFontSymbolic() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType3Font(new COSDictionary())).isFontSymbolic());
  }

  /**
   * Test {@link PDType3Font#getPath(String)}.
   * <p>
   * Method under test: {@link PDType3Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String)")
  void testGetPath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).getPath("Name"));
  }

  /**
   * Test {@link PDType3Font#hasGlyph(String)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testHasGlyph_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType3Font(new COSDictionary())).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType3Font#hasGlyph(String)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#hasGlyph(String)}
   */
  @Test
  @DisplayName("Test hasGlyph(String); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testHasGlyph_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType3Font(new COSStream())).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType3Font#getFontBoxFont()}.
   * <p>
   * Method under test: {@link PDType3Font#getFontBoxFont()}
   */
  @Test
  @DisplayName("Test getFontBoxFont()")
  void testGetFontBoxFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).getFontBoxFont());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int)")
  void testGetDisplacement() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act
    Vector actualDisplacement = pdType3Font.getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetDisplacement_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDType3Font(new COSDictionary())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetDisplacement_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDType3Font(new COSStream())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   * <ul>
   *   <li>Then return X is {@code 0.010000001}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); then return X is '0.010000001'")
  void testGetDisplacement_thenReturnXIs0010000001() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setMissingWidth(10.0f);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act
    Vector actualDisplacement = pdType3Font.getDisplacement(1);

    // Assert
    assertEquals(0.010000001f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int)")
  void testGetWidth() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MissingWidth is
   * ten.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDFontDescriptor() MissingWidth is ten; then return ten")
  void testGetWidth_givenPDFontDescriptorMissingWidthIsTen_thenReturnTen() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setMissingWidth(10.0f);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(10.0f, pdType3Font.getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  void testGetWidth_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return zero")
  void testGetWidth_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSStream())).getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidthFromFont(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int)")
  void testGetWidthFromFont() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  void testGetHeight() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  void testGetHeight2() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor
        .setFontBoundingBox(new PDRectangle(Float.NEGATIVE_INFINITY, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is
   * {@link PDRectangle#A0}.</li>
   *   <li>Then return {@code 1685.1969}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given PDFontDescriptor() FontBoundingBox is A0; then return '1685.1969'")
  void testGetHeight_givenPDFontDescriptorFontBoundingBoxIsA0_thenReturn16851969() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(1685.1969f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  void testGetHeight_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnZero() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <ul>
   *   <li>Then return {@link Float#NEGATIVE_INFINITY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return NEGATIVE_INFINITY")
  void testGetHeight_thenReturnNegative_infinity() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setAscent(Float.NEGATIVE_INFINITY);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(Float.NEGATIVE_INFINITY, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return zero")
  void testGetHeight_thenReturnZero() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#encode(int)} with {@code unicode}.
   * <p>
   * Method under test: {@link PDType3Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'")
  void testEncodeWithUnicode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).encode(1));
  }

  /**
   * Test {@link PDType3Font#readCode(InputStream)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return sixty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(65, pdType3Font.readCode(in));
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   * <p>
   * Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  void testGetFontMatrix() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertSame(pdType3Font.DEFAULT_FONT_MATRIX, pdType3Font.getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   * <p>
   * Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  void testGetFontMatrix2() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSStream());

    // Act and Assert
    assertSame(pdType3Font.DEFAULT_FONT_MATRIX, pdType3Font.getFontMatrix());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDType3Font#isDamaged()}
   *   <li>{@link PDType3Font#isEmbedded()}
   *   <li>{@link PDType3Font#isStandard14()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());

    // Act
    boolean actualIsDamagedResult = pdType3Font.isDamaged();
    boolean actualIsEmbeddedResult = pdType3Font.isEmbedded();

    // Assert
    assertFalse(actualIsDamagedResult);
    assertFalse(pdType3Font.isStandard14());
    assertTrue(actualIsEmbeddedResult);
  }

  /**
   * Test {@link PDType3Font#getResources()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetResources_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getResources());
  }

  /**
   * Test {@link PDType3Font#getResources()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getResources()}
   */
  @Test
  @DisplayName("Test getResources(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetResources_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSStream())).getResources());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetFontBBox_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getFontBBox());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetFontBBox_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSStream())).getFontBBox());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetBoundingBox_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType3Font(new COSDictionary())).getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetBoundingBox_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = (new PDType3Font(new COSStream())).getBoundingBox();

    // Assert
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftX());
    assertEquals(0.0f, actualBoundingBox.getLowerLeftY());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getCharProcs()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getCharProcs()}
   */
  @Test
  @DisplayName("Test getCharProcs(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  void testGetCharProcs_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getCharProcs());
  }

  /**
   * Test {@link PDType3Font#getCharProcs()}.
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary
   * is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDType3Font#getCharProcs()}
   */
  @Test
  @DisplayName("Test getCharProcs(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  void testGetCharProcs_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSStream())).getCharProcs());
  }

  /**
   * Test {@link PDType3Font#getCharProc(int)}.
   * <p>
   * Method under test: {@link PDType3Font#getCharProc(int)}
   */
  @Test
  @DisplayName("Test getCharProc(int)")
  void testGetCharProc() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getCharProc(1));
  }
}
