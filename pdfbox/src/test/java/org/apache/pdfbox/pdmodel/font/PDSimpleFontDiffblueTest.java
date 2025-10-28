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
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.encoding.Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.GlyphList;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDSimpleFontDiffblueTest {
  /**
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding2() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding3() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding4() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding5() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding6() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding7() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding8() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding9() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding10() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding11() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding12() throws IOException {
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
   * Method under test: {@link PDSimpleFont#readEncoding()}
   */
  @Test
  void testReadEncoding13() throws IOException {
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
   * Method under test: {@link PDSimpleFont#getEncoding()}
   */
  @Test
  void testGetEncoding() throws IOException {
    // Arrange and Act
    Encoding actualEncoding = (new PDMMType1Font(new COSDictionary())).getEncoding();

    // Assert
    assertSame(((StandardEncoding) actualEncoding).INSTANCE, actualEncoding);
  }

  /**
   * Method under test: {@link PDSimpleFont#getGlyphList()}
   */
  @Test
  void testGetGlyphList() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertSame(pdmmType1Font.glyphList, pdmmType1Font.getGlyphList());
  }

  /**
   * Method under test: {@link PDSimpleFont#isSymbolic()}
   */
  @Test
  void testIsSymbolic() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isSymbolic());
  }

  /**
   * Method under test: {@link PDSimpleFont#isSymbolic()}
   */
  @Test
  void testIsSymbolic2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.isSymbolic());
  }

  /**
   * Method under test: {@link PDSimpleFont#isFontSymbolic()}
   */
  @Test
  void testIsFontSymbolic() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isFontSymbolic());
  }

  /**
   * Method under test: {@link PDSimpleFont#isFontSymbolic()}
   */
  @Test
  void testIsFontSymbolic2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.isFontSymbolic());
  }

  /**
   * Method under test: {@link PDSimpleFont#getSymbolicFlag()}
   */
  @Test
  void testGetSymbolicFlag() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).getSymbolicFlag());
  }

  /**
   * Method under test: {@link PDSimpleFont#getSymbolicFlag()}
   */
  @Test
  void testGetSymbolicFlag2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());
    pdmmType1Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertFalse(pdmmType1Font.getSymbolicFlag());
  }

  /**
   * Method under test: {@link PDSimpleFont#toUnicode(int)}
   */
  @Test
  void testToUnicode() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDMMType1Font(new COSDictionary())).toUnicode(1));
    assertEquals(".", (new PDMMType1Font(new COSDictionary())).toUnicode(46));
  }

  /**
   * Method under test: {@link PDSimpleFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertNull(pdmmType1Font.toUnicode(1, GlyphList.getAdobeGlyphList()));
  }

  /**
   * Method under test: {@link PDSimpleFont#toUnicode(int, GlyphList)}
   */
  @Test
  void testToUnicode3() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertEquals(".", pdmmType1Font.toUnicode(46, GlyphList.getAdobeGlyphList()));
  }

  /**
   * Method under test: {@link PDSimpleFont#isVertical()}
   */
  @Test
  void testIsVertical() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isVertical());
  }

  /**
   * Method under test: {@link PDSimpleFont#getStandard14Width(int)}
   */
  @Test
  void testGetStandard14Width() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> (new PDMMType1Font(new COSDictionary())).getStandard14Width(1));
  }

  /**
   * Method under test: {@link PDSimpleFont#isStandard14()}
   */
  @Test
  void testIsStandard14() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).isStandard14());
  }

  /**
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  void testIsNonZeroBoundingBox() throws IOException {
    // Arrange, Act and Assert
    assertTrue((new PDMMType1Font(new COSDictionary())).isNonZeroBoundingBox(PDRectangle.A0));
    assertFalse((new PDMMType1Font(new COSDictionary())).isNonZeroBoundingBox(null));
  }

  /**
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  void testIsNonZeroBoundingBox2() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertFalse(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle()));
  }

  /**
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  void testIsNonZeroBoundingBox3() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle(10.0f, 10.0f, 10.0f, 10.0f)));
  }

  /**
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  void testIsNonZeroBoundingBox4() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(new PDRectangle(0.0f, 10.0f, 10.0f, 10.0f)));
  }

  /**
   * Method under test: {@link PDSimpleFont#isNonZeroBoundingBox(PDRectangle)}
   */
  @Test
  void testIsNonZeroBoundingBox5() throws IOException {
    // Arrange
    PDMMType1Font pdmmType1Font = new PDMMType1Font(new COSDictionary());

    PDRectangle bbox = new PDRectangle();
    bbox.setUpperRightY(10.0f);

    // Act and Assert
    assertTrue(pdmmType1Font.isNonZeroBoundingBox(bbox));
  }

  /**
   * Method under test: {@link PDSimpleFont#addToSubset(int)}
   */
  @Test
  void testAddToSubset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDMMType1Font(new COSDictionary())).addToSubset(2));
  }

  /**
   * Method under test: {@link PDSimpleFont#subset()}
   */
  @Test
  void testSubset() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDMMType1Font(new COSDictionary())).subset());
  }

  /**
   * Method under test: {@link PDSimpleFont#willBeSubset()}
   */
  @Test
  void testWillBeSubset() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).willBeSubset());
  }

  /**
   * Method under test: {@link PDSimpleFont#hasExplicitWidth(int)}
   */
  @Test
  void testHasExplicitWidth() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDMMType1Font(new COSDictionary())).hasExplicitWidth(1));
  }
}
