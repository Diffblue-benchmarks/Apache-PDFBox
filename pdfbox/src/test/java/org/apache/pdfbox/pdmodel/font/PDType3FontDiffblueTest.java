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
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDType3FontDiffblueTest {
  /**
   * Method under test: {@link PDType3Font#getName()}
   */
  @Test
  void testGetName() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getName());
  }

  /**
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding2() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding3() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding4() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding5() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding6() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding7() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding8() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncoding()}
   */
  @Test
  void testReadEncoding9() throws IOException {
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
   * Method under test: {@link PDType3Font#readEncodingFromFont()}
   */
  @Test
  void testReadEncodingFromFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new PDType3Font(new COSDictionary())).readEncodingFromFont());
  }

  /**
   * Method under test: {@link PDType3Font#isFontSymbolic()}
   */
  @Test
  void testIsFontSymbolic() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType3Font(new COSDictionary())).isFontSymbolic());
  }

  /**
   * Method under test: {@link PDType3Font#getPath(String)}
   */
  @Test
  void testGetPath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).getPath("Name"));
  }

  /**
   * Method under test: {@link PDType3Font#hasGlyph(String)}
   */
  @Test
  void testHasGlyph() throws IOException {
    // Arrange, Act and Assert
    assertFalse((new PDType3Font(new COSDictionary())).hasGlyph("Name"));
  }

  /**
   * Method under test: {@link PDType3Font#getFontBoxFont()}
   */
  @Test
  void testGetFontBoxFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).getFontBoxFont());
  }

  /**
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  void testGetDisplacement() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = (new PDType3Font(new COSDictionary())).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  void testGetDisplacement2() throws IOException {
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
   * Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  void testGetDisplacement3() throws IOException {
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
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  void testGetWidth() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getWidth(1));
  }

  /**
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  void testGetWidth2() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getWidth(1));
  }

  /**
   * Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  void testGetWidth3() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setMissingWidth(10.0f);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(10.0f, pdType3Font.getWidth(1));
  }

  /**
   * Method under test: {@link PDType3Font#getWidthFromFont(int)}
   */
  @Test
  void testGetWidthFromFont() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getWidthFromFont(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDType3Font(new COSDictionary())).getHeight(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight2() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight3() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(PDRectangle.A0);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(1685.1969f, pdType3Font.getHeight(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight4() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setAscent(Float.NEGATIVE_INFINITY);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(Float.NEGATIVE_INFINITY, pdType3Font.getHeight(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight5() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    fontDescriptor.setFontBoundingBox(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  void testGetHeight6() throws IOException {
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
   * Method under test: {@link PDType3Font#encode(int)}
   */
  @Test
  void testEncode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new PDType3Font(new COSDictionary())).encode(1));
  }

  /**
   * Method under test: {@link PDType3Font#readCode(InputStream)}
   */
  @Test
  void testReadCode() throws IOException {
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
   * Method under test: {@link PDType3Font#readCode(InputStream)}
   */
  @Test
  void testReadCode2() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenReturn(1);

    // Act
    int actualReadCodeResult = pdType3Font.readCode(in);

    // Assert
    verify(in).read();
    assertEquals(1, actualReadCodeResult);
  }

  /**
   * Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  void testGetFontMatrix() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());

    // Act and Assert
    assertSame(pdType3Font.DEFAULT_FONT_MATRIX, pdType3Font.getFontMatrix());
  }

  /**
   * Method under test: {@link PDType3Font#getResources()}
   */
  @Test
  void testGetResources() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getResources());
  }

  /**
   * Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  void testGetFontBBox() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getFontBBox());
  }

  /**
   * Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  void testGetBoundingBox() throws IOException {
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
   * Method under test: {@link PDType3Font#getCharProcs()}
   */
  @Test
  void testGetCharProcs() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getCharProcs());
  }

  /**
   * Method under test: {@link PDType3Font#getCharProc(int)}
   */
  @Test
  void testGetCharProc() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDType3Font(new COSDictionary())).getCharProc(1));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDType3Font#isDamaged()}
   *   <li>{@link PDType3Font#isEmbedded()}
   *   <li>{@link PDType3Font#isStandard14()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link PDType3Font#PDType3Font(COSDictionary)}
   */
  @Test
  void testNewPDType3Font() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary);

    // Assert
    assertNull(actualPdType3Font.getSymbolicFlag());
    assertNull(actualPdType3Font.getSubType());
    assertNull(actualPdType3Font.getType());
    assertNull(actualPdType3Font.getName());
    assertNull(actualPdType3Font.getStandard14AFM());
    assertNull(actualPdType3Font.getToUnicodeCMap());
    assertNull(actualPdType3Font.getCharProcs());
    assertNull(actualPdType3Font.getResources());
    assertNull(actualPdType3Font.getFontBBox());
    assertNull(actualPdType3Font.getFontDescriptor());
    assertNull(actualPdType3Font.getEncoding());
    BoundingBox boundingBox = actualPdType3Font.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, actualPdType3Font.getAverageFontWidth());
    assertEquals(0.0f, actualPdType3Font.getSpaceWidth());
    assertFalse(actualPdType3Font.isVertical());
    assertFalse(actualPdType3Font.isDamaged());
    assertFalse(actualPdType3Font.isStandard14());
    assertTrue(actualPdType3Font.getWidths().isEmpty());
    assertTrue(actualPdType3Font.isEmbedded());
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }

  /**
   * Method under test:
   * {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}
   */
  @Test
  void testNewPDType3Font2() throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary, new DefaultResourceCache());

    // Assert
    assertNull(actualPdType3Font.getSymbolicFlag());
    assertNull(actualPdType3Font.getSubType());
    assertNull(actualPdType3Font.getType());
    assertNull(actualPdType3Font.getName());
    assertNull(actualPdType3Font.getStandard14AFM());
    assertNull(actualPdType3Font.getToUnicodeCMap());
    assertNull(actualPdType3Font.getCharProcs());
    assertNull(actualPdType3Font.getResources());
    assertNull(actualPdType3Font.getFontBBox());
    assertNull(actualPdType3Font.getFontDescriptor());
    assertNull(actualPdType3Font.getEncoding());
    BoundingBox boundingBox = actualPdType3Font.getBoundingBox();
    assertEquals(0.0f, boundingBox.getHeight());
    assertEquals(0.0f, boundingBox.getLowerLeftX());
    assertEquals(0.0f, boundingBox.getLowerLeftY());
    assertEquals(0.0f, boundingBox.getUpperRightX());
    assertEquals(0.0f, boundingBox.getUpperRightY());
    assertEquals(0.0f, boundingBox.getWidth());
    assertEquals(0.0f, actualPdType3Font.getAverageFontWidth());
    assertEquals(0.0f, actualPdType3Font.getSpaceWidth());
    assertFalse(actualPdType3Font.isVertical());
    assertFalse(actualPdType3Font.isDamaged());
    assertFalse(actualPdType3Font.isStandard14());
    assertTrue(actualPdType3Font.getWidths().isEmpty());
    assertTrue(actualPdType3Font.isEmbedded());
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    Matrix expectedFontMatrix = actualPdType3Font.DEFAULT_FONT_MATRIX;
    assertSame(expectedFontMatrix, actualPdType3Font.getFontMatrix());
  }
}
