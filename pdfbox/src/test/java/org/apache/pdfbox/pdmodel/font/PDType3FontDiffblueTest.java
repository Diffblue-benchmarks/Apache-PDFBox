package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.apache.fontbox.util.BoundingBox;
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
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.DefaultResourceCache;
import org.apache.pdfbox.pdmodel.ResourceCache;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.util.Matrix;
import org.apache.pdfbox.util.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDType3FontDiffblueTest {
  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private PDType3Font pDType3Font;

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#PDType3Font(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDType3Font(COSDictionary); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType3Font.<init>(COSDictionary)"})
  void testNewPDType3Font_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary);

    // Assert
    float[][] values = actualPdType3Font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return COSObject is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDType3Font(COSDictionary, ResourceCache); when COSDictionary(); then return COSObject is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType3Font.<init>(COSDictionary, ResourceCache)"})
  void testNewPDType3Font_whenCOSDictionary_thenReturnCOSObjectIsCOSDictionary2()
      throws IOException {
    // Arrange
    COSDictionary fontDictionary = new COSDictionary();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary, new DefaultResourceCache());

    // Assert
    float[][] values = actualPdType3Font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#PDType3Font(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDType3Font(COSDictionary); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType3Font.<init>(COSDictionary)"})
  void testNewPDType3Font_whenCOSStream_thenReturnCOSObjectIsCOSStream() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary);

    // Assert
    float[][] values = actualPdType3Font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then return COSObject is {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#PDType3Font(COSDictionary, ResourceCache)}
   */
  @Test
  @DisplayName(
      "Test new PDType3Font(COSDictionary, ResourceCache); when COSStream(); then return COSObject is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDType3Font.<init>(COSDictionary, ResourceCache)"})
  void testNewPDType3Font_whenCOSStream_thenReturnCOSObjectIsCOSStream2() throws IOException {
    // Arrange
    COSStream fontDictionary = new COSStream();

    // Act
    PDType3Font actualPdType3Font = new PDType3Font(fontDictionary, new DefaultResourceCache());

    // Assert
    float[][] values = actualPdType3Font.getFontMatrix().getValues();
    assertEquals(3, values.length);
    assertSame(fontDictionary, actualPdType3Font.getCOSObject());
    assertArrayEquals(new float[] {0.001f, 0.0f, 0.0f}, values[0], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.001f, 0.0f}, values[1], 0.0f);
    assertArrayEquals(new float[] {0.0f, 0.0f, 1.0f}, values[2], 0.0f);
  }

  /**
   * Test {@link PDType3Font#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType3Font.getName()"})
  void testGetName_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSDictionary()).getName());
  }

  /**
   * Test {@link PDType3Font#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDType3Font.getName()"})
  void testGetName_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSStream()).getName());
  }

  /**
   * Test {@link PDType3Font#readEncodingFromFont()}.
   *
   * <p>Method under test: {@link PDType3Font#readEncodingFromFont()}
   */
  @Test
  @DisplayName("Test readEncodingFromFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.apache.pdfbox.pdmodel.font.encoding.Encoding PDType3Font.readEncodingFromFont()"
  })
  void testReadEncodingFromFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDType3Font(new COSDictionary()).readEncodingFromFont());
  }

  /**
   * Test {@link PDType3Font#isFontSymbolic()}.
   *
   * <p>Method under test: {@link PDType3Font#isFontSymbolic()}
   */
  @Test
  @DisplayName("Test isFontSymbolic()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean PDType3Font.isFontSymbolic()"})
  void testIsFontSymbolic() throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType3Font(new COSDictionary()).isFontSymbolic());
  }

  /**
   * Test {@link PDType3Font#getPath(String)}.
   *
   * <p>Method under test: {@link PDType3Font#getPath(String)}
   */
  @Test
  @DisplayName("Test getPath(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.geom.GeneralPath PDType3Font.getPath(String)"})
  void testGetPath() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDType3Font(new COSDictionary()).getPath("Name"));
  }

  /**
   * Test {@link PDType3Font#hasGlyph(String)}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#hasGlyph(String)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(String); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType3Font.hasGlyph(String)"})
  void testHasGlyph_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType3Font(new COSDictionary()).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType3Font#hasGlyph(String)}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#hasGlyph(String)}
   */
  @Test
  @DisplayName(
      "Test hasGlyph(String); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDType3Font.hasGlyph(String)"})
  void testHasGlyph_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnFalse()
      throws IOException {
    // Arrange, Act and Assert
    assertFalse(new PDType3Font(new COSStream()).hasGlyph("Name"));
  }

  /**
   * Test {@link PDType3Font#getFontBoxFont()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontBoxFont()}
   */
  @Test
  @DisplayName("Test getFontBoxFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.fontbox.FontBoxFont PDType3Font.getFontBoxFont()"})
  void testGetFontBoxFont() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new PDType3Font(new COSDictionary()).getFontBoxFont());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
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
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(6L, 6));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement3() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    COSObjectKey key = new COSObjectKey(6L, 6);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement4() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    COSObject object = new COSObject(new COSObjectKey(6L, 6), null);
    cosArray.add((COSBase) object);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given COSArray(List) with cosObjectables is ArrayList() add FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenCOSArrayWithCosObjectablesIsArrayListAddFalse() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given COSArray(List) with cosObjectables is ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenCOSArrayWithCosObjectablesIsArrayListAddOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSInteger.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.001f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given COSDictionary getCOSArray(COSName) return COSArray(); then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenCOSDictionaryGetCOSArrayReturnCOSArray_thenCallsGetInt()
      throws IOException {
    // Arrange
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return minus one.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given COSDictionary getInt(COSName, int) return minus one; then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenCOSDictionaryGetIntReturnMinusOne_thenCallsGetInt()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(-1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return six.
   *   <li>Then calls {@link COSDictionary#getInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given COSDictionary getInt(COSName, int) return six; then calls getInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenCOSDictionaryGetIntReturnSix_thenCallsGetInt() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(6);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = new PDType3Font(new COSDictionary()).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName(
      "Test getDisplacement(int); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    Vector actualDisplacement = new PDType3Font(new COSStream()).getDisplacement(1);

    // Assert
    assertEquals(0.0f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Then return X is {@code 0.001}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); then return X is '0.001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_thenReturnXIs0001() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Vector actualDisplacement = pDType3Font.getDisplacement(1);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.001f, actualDisplacement.getX());
    assertEquals(0.0f, actualDisplacement.getY());
  }

  /**
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Then return X is {@code 0.010000001}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); then return X is '0.010000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
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
   * Test {@link PDType3Font#getDisplacement(int)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getDisplacement(int)}
   */
  @Test
  @DisplayName("Test getDisplacement(int); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDType3Font.getDisplacement(int)"})
  void testGetDisplacement_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDType3Font.getDisplacement(1));
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSBase, ICOSParser)}
   *       with object is {@link COSBoolean#FALSE} and parser is {@link
   *       COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given COSArray() add COSObject(COSBase, ICOSParser) with object is FALSE and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSArrayAddCOSObjectWithObjectIsFalseAndParserIsCOSParser()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object =
        new COSObject(COSBoolean.FALSE, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSArrayAddFalse_thenCallsGetCOSArray() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given COSArray() add ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSArrayAddOne_thenReturnOne() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(1.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given COSArray() add ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSArrayAddOne_thenReturnOne2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(1.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return minus one.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given COSDictionary getInt(COSName, int) return minus one; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSDictionaryGetIntReturnMinusOne_thenCallsGetCOSArray()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(-1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName, int)} return one.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given COSDictionary getInt(COSName, int) return one; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenCOSDictionaryGetIntReturnOne_thenCallsGetCOSArray() throws IOException {
    // Arrange
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt())).thenReturn(1);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    float actualWidth = pDType3Font.getWidth(1);

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getInt(Mockito.<COSName>any(), eq(-1));
    assertEquals(0.0f, actualWidth);
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} MissingWidth is ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); given PDFontDescriptor() MissingWidth is ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
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
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType3Font(new COSDictionary()).getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType3Font(new COSStream()).getWidth(1));
  }

  /**
   * Test {@link PDType3Font#getWidth(int)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidth(int)"})
  void testGetWidth_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    when(cOSDictionary.getInt(Mockito.<COSName>any(), anyInt()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDType3Font.getWidth(1));
    verify(cOSDictionary).getInt(isA(COSName.class), eq(-1));
  }

  /**
   * Test {@link PDType3Font#getWidthFromFont(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getWidthFromFont(int)}
   */
  @Test
  @DisplayName("Test getWidthFromFont(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getWidthFromFont(int)"})
  void testGetWidthFromFont() throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType3Font(new COSDictionary()).getWidthFromFont(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
  void testGetHeight() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect = new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
  void testGetHeight2() throws IOException {
    // Arrange
    PDFontDescriptor fontDescriptor = new PDFontDescriptor();
    PDRectangle rect =
        new PDRectangle(Float.NEGATIVE_INFINITY, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f);
    fontDescriptor.setFontBoundingBox(rect);

    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(fontDescriptor);

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   *
   * <ul>
   *   <li>Given {@link PDFontDescriptor#PDFontDescriptor()} FontBoundingBox is {@link
   *       PDRectangle#A0}.
   *   <li>Then return {@code 1685.1969}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName(
      "Test getHeight(int); given PDFontDescriptor() FontBoundingBox is A0; then return '1685.1969'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
  void testGetHeight_givenPDFontDescriptorFontBoundingBoxIsA0_thenReturn16851969()
      throws IOException {
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
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName(
      "Test getHeight(int); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
  void testGetHeight_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnZero()
      throws IOException {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDType3Font(new COSDictionary()).getHeight(1));
  }

  /**
   * Test {@link PDType3Font#getHeight(int)}.
   *
   * <ul>
   *   <li>Then return {@link Float#NEGATIVE_INFINITY}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return NEGATIVE_INFINITY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
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
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getHeight(int)}
   */
  @Test
  @DisplayName("Test getHeight(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDType3Font.getHeight(int)"})
  void testGetHeight_thenReturnZero() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    pdType3Font.setFontDescriptor(new PDFontDescriptor());

    // Act and Assert
    assertEquals(0.0f, pdType3Font.getHeight(1));
  }

  /**
   * Test {@link PDType3Font#encode(int)} with {@code unicode}.
   *
   * <p>Method under test: {@link PDType3Font#encode(int)}
   */
  @Test
  @DisplayName("Test encode(int) with 'unicode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] PDType3Font.encode(int)"})
  void testEncodeWithUnicode() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> new PDType3Font(new COSDictionary()).encode(1));
  }

  /**
   * Test {@link PDType3Font#readCode(InputStream)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#readCode(InputStream)}
   */
  @Test
  @DisplayName("Test readCode(InputStream); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType3Font.readCode(InputStream)"})
  void testReadCode_thenThrowUnsupportedOperationException() throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());

    DataInputStream in = mock(DataInputStream.class);
    when(in.read()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pdType3Font.readCode(in));
    verify(in).read();
  }

  /**
   * Test {@link PDType3Font#readCode(InputStream)}.
   *
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX}
   *       Bytes is {@code UTF-8}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#readCode(InputStream)}
   */
  @Test
  @DisplayName(
      "Test readCode(InputStream); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDType3Font.readCode(InputStream)"})
  void testReadCode_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8_thenReturnSixtyFive()
      throws IOException {
    // Arrange
    PDType3Font pdType3Font = new PDType3Font(new COSDictionary());
    ByteArrayInputStream in = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));

    // Act
    int actualReadCodeResult = pdType3Font.readCode(in);

    // Assert
    assertEquals(65, actualReadCodeResult);
    byte[] byteArray = new byte[7];
    assertEquals(7, in.read(byteArray));
    assertArrayEquals("XAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(6L, 6));
    cosArray.add((COSBase) object);
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    COSObjectKey key = new COSObjectKey(6L, 6);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix3() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    COSObject object = new COSObject(new COSObjectKey(6L, 6), null);
    cosArray.add((COSBase) object);
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName(
      "Test getFontMatrix(); given COSArray(List) with cosObjectables is ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_givenCOSArrayWithCosObjectablesIsArrayListAddOne() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSFloat.ONE);
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName(
      "Test getFontMatrix(); given COSArray(List) with cosObjectables is ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_givenCOSArrayWithCosObjectablesIsArrayListAddOne2() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSInteger.ONE);
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    Matrix actualFontMatrix = pDType3Font.getFontMatrix();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertSame(PDFont.DEFAULT_FONT_MATRIX, actualFontMatrix);
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName(
      "Test getFontMatrix(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertSame(PDFont.DEFAULT_FONT_MATRIX, new PDType3Font(new COSDictionary()).getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName(
      "Test getFontMatrix(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertSame(PDFont.DEFAULT_FONT_MATRIX, new PDType3Font(new COSStream()).getFontMatrix());
  }

  /**
   * Test {@link PDType3Font#getFontMatrix()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontMatrix()}
   */
  @Test
  @DisplayName("Test getFontMatrix(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Matrix PDType3Font.getFontMatrix()"})
  void testGetFontMatrix_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDType3Font.getFontMatrix());
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDType3Font#isDamaged()}
   *   <li>{@link PDType3Font#isEmbedded()}
   *   <li>{@link PDType3Font#isStandard14()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PDType3Font.isDamaged()",
    "boolean PDType3Font.isEmbedded()",
    "boolean PDType3Font.isStandard14()"
  })
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
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getResources()}
   */
  @Test
  @DisplayName(
      "Test getResources(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.PDResources PDType3Font.getResources()"})
  void testGetResources_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSDictionary()).getResources());
  }

  /**
   * Test {@link PDType3Font#getResources()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getResources()}
   */
  @Test
  @DisplayName(
      "Test getResources(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.PDResources PDType3Font.getResources()"})
  void testGetResources_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSStream()).getResources());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add((COSBase) new COSObject(COSFloat.ONE));
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualFontBBox.getUpperRightX());
    assertEquals(1.0f, actualFontBBox.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox2() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFontBBox.getHeight());
    assertEquals(0.0f, actualFontBBox.getUpperRightX());
    assertEquals(0.0f, actualFontBBox.getUpperRightY());
    assertEquals(0.0f, actualFontBBox.getWidth());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox3() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    cosArray.add((COSBase) object);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFontBBox.getHeight());
    assertEquals(0.0f, actualFontBBox.getUpperRightX());
    assertEquals(0.0f, actualFontBBox.getUpperRightY());
    assertEquals(0.0f, actualFontBBox.getWidth());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName(
      "Test getFontBBox(); given COSArray(List) with cosObjectables is ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_givenCOSArrayWithCosObjectablesIsArrayListAddOne() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualFontBBox.getUpperRightX());
    assertEquals(1.0f, actualFontBBox.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName(
      "Test getFontBBox(); given COSArray(List) with cosObjectables is ArrayList() add ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_givenCOSArrayWithCosObjectablesIsArrayListAddOne2() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSInteger.ONE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualFontBBox.getUpperRightX());
    assertEquals(1.0f, actualFontBBox.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox(); given COSDictionary getCOSArray(COSName) return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals(0.0f, actualFontBBox.getHeight());
    assertEquals(0.0f, actualFontBBox.getUpperRightX());
    assertEquals(0.0f, actualFontBBox.getUpperRightY());
    assertEquals(0.0f, actualFontBBox.getWidth());
    COSBase getResult3 = toListResult.get(0);
    assertEquals(getResult3, getResult);
    assertEquals(getResult3, getResult2);
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName(
      "Test getFontBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_givenPDType3FontWithFontDictionaryIsCOSDictionary_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSDictionary()).getFontBBox());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName(
      "Test getFontBBox(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSStream()).getFontBBox());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Then return COSArray toList fourth Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox(); then return COSArray toList fourth Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_thenReturnCOSArrayToListFourthKeyIsNull() {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualFontBBox = pDType3Font.getFontBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualFontBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(3);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualFontBBox.getHeight());
    assertEquals(1.0f, actualFontBBox.getUpperRightY());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDType3Font#getFontBBox()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getFontBBox()}
   */
  @Test
  @DisplayName("Test getFontBBox(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDType3Font.getFontBBox()"})
  void testGetFontBBox_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDType3Font.getFontBBox());
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> pDType3Font.getBoundingBox());
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox2() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    LinkedHashSet<COSName> cosNameSet = new LinkedHashSet<>();
    cosNameSet.add(COSName.A);
    when(cOSDictionary.keySet()).thenReturn(cosNameSet);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    LinkedHashSet<COSName> cosNameSet2 = new LinkedHashSet<>();
    cosNameSet2.add(COSName.A);
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cOSDictionary.keySet()).thenReturn(cosNameSet2);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    BoundingBox actualBoundingBox = pDType3Font.getBoundingBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSStream(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).keySet();
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName("Test getBoundingBox()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox3() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);

    LinkedHashSet<COSName> cosNameSet = new LinkedHashSet<>();
    cosNameSet.add(COSName.A);
    when(cOSDictionary.keySet()).thenReturn(cosNameSet);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    LinkedHashSet<COSName> cosNameSet2 = new LinkedHashSet<>();
    cosNameSet2.add(COSName.A);
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cOSDictionary.keySet()).thenReturn(cosNameSet2);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    BoundingBox actualBoundingBox = pDType3Font.getBoundingBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSStream(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).keySet();
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSObjectKey,
   *       ICOSParser)} with key is {@link COSObjectKey#COSObjectKey(long, int)} and parser is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given COSArray() add COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox_givenCOSArrayAddCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    cosArray.add((COSBase) object);

    LinkedHashSet<COSName> cosNameSet = new LinkedHashSet<>();
    cosNameSet.add(COSName.A);
    when(cOSDictionary.keySet()).thenReturn(cosNameSet);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    LinkedHashSet<COSName> cosNameSet2 = new LinkedHashSet<>();
    cosNameSet2.add(COSName.A);
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cOSDictionary.keySet()).thenReturn(cosNameSet2);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    BoundingBox actualBoundingBox = pDType3Font.getBoundingBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSStream(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).keySet();
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSStream(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given COSArray() add FALSE; then calls getCOSStream(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox_givenCOSArrayAddFalse_thenCallsGetCOSStream() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    LinkedHashSet<COSName> cosNameSet = new LinkedHashSet<>();
    cosNameSet.add(COSName.A);
    when(cOSDictionary.keySet()).thenReturn(cosNameSet);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());

    LinkedHashSet<COSName> cosNameSet2 = new LinkedHashSet<>();
    cosNameSet2.add(COSName.A);
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(new COSStream());
    when(cOSDictionary.keySet()).thenReturn(cosNameSet2);
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cOSDictionary);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    BoundingBox actualBoundingBox = pDType3Font.getBoundingBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).getCOSStream(isA(COSName.class));
    verify(cOSDictionary, atLeast(1)).keySet();
    assertEquals(0.0f, actualBoundingBox.getHeight());
    assertEquals(0.0f, actualBoundingBox.getUpperRightX());
    assertEquals(0.0f, actualBoundingBox.getUpperRightY());
    assertEquals(0.0f, actualBoundingBox.getWidth());
  }

  /**
   * Test {@link PDType3Font#getBoundingBox()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = new PDType3Font(new COSDictionary()).getBoundingBox();

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
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getBoundingBox()}
   */
  @Test
  @DisplayName(
      "Test getBoundingBox(); given PDType3Font(COSDictionary) with fontDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BoundingBox PDType3Font.getBoundingBox()"})
  void testGetBoundingBox_givenPDType3FontWithFontDictionaryIsCOSStream() throws IOException {
    // Arrange and Act
    BoundingBox actualBoundingBox = new PDType3Font(new COSStream()).getBoundingBox();

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
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getCharProcs()}
   */
  @Test
  @DisplayName(
      "Test getCharProcs(); given PDType3Font(COSDictionary) with fontDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDType3Font.getCharProcs()"})
  void testGetCharProcs_givenPDType3FontWithFontDictionaryIsCOSDictionary() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSDictionary()).getCharProcs());
  }

  /**
   * Test {@link PDType3Font#getCharProcs()}.
   *
   * <ul>
   *   <li>Given {@link PDType3Font#PDType3Font(COSDictionary)} with fontDictionary is {@link
   *       COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDType3Font#getCharProcs()}
   */
  @Test
  @DisplayName(
      "Test getCharProcs(); given PDType3Font(COSDictionary) with fontDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDType3Font.getCharProcs()"})
  void testGetCharProcs_givenPDType3FontWithFontDictionaryIsCOSStream_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSStream()).getCharProcs());
  }

  /**
   * Test {@link PDType3Font#getCharProc(int)}.
   *
   * <p>Method under test: {@link PDType3Font#getCharProc(int)}
   */
  @Test
  @DisplayName("Test getCharProc(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDType3CharProc PDType3Font.getCharProc(int)"})
  void testGetCharProc() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDType3Font(new COSDictionary()).getCharProc(1));
  }
}
