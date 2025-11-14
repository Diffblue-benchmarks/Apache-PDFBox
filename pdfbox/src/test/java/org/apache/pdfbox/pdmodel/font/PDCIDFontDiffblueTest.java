package org.apache.pdfbox.pdmodel.font;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.io.RandomAccessReadView;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
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
class PDCIDFontDiffblueTest {
  @Mock private COSDictionary cOSDictionary;

  @InjectMocks private PDCIDFontType0 pDCIDFontType0;

  @Mock private PDType0Font pDType0Font;

  /**
   * Test {@link PDCIDFont#getCOSObject()}.
   *
   * <p>Method under test: {@link PDCIDFont#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDCIDFont.getCOSObject()"})
  void testGetCOSObject() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act
    COSDictionary actualCOSObject = pdcidFontType0.getCOSObject();

    // Assert
    assertSame(pdcidFontType0.dict, actualCOSObject);
  }

  /**
   * Test {@link PDCIDFont#getBaseFont()}.
   *
   * <p>Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  @DisplayName("Test getBaseFont()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCIDFont.getBaseFont()"})
  void testGetBaseFont() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getBaseFont());
  }

  /**
   * Test {@link PDCIDFont#getBaseFont()}.
   *
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)} with
   *       fontDictionary is {@link COSStream#COSStream()} and parent is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getBaseFont()}
   */
  @Test
  @DisplayName(
      "Test getBaseFont(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSStream() and parent is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCIDFont.getBaseFont()"})
  void testGetBaseFont_givenPDCIDFontType0WithFontDictionaryIsCOSStreamAndParentIsNull()
      throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getBaseFont());
  }

  /**
   * Test {@link PDCIDFont#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)} with
   *       fontDictionary is {@link COSDictionary#COSDictionary()} and parent is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSDictionary() and parent is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCIDFont.getName()"})
  void testGetName_givenPDCIDFontType0WithFontDictionaryIsCOSDictionaryAndParentIsNull()
      throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getName());
  }

  /**
   * Test {@link PDCIDFont#getName()}.
   *
   * <ul>
   *   <li>Given {@link PDCIDFontType0#PDCIDFontType0(COSDictionary, PDType0Font)} with
   *       fontDictionary is {@link COSStream#COSStream()} and parent is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getName()}
   */
  @Test
  @DisplayName(
      "Test getName(); given PDCIDFontType0(COSDictionary, PDType0Font) with fontDictionary is COSStream() and parent is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCIDFont.getName()"})
  void testGetName_givenPDCIDFontType0WithFontDictionaryIsCOSStreamAndParentIsNull()
      throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getName());
  }

  /**
   * Test {@link PDCIDFont#getFontDescriptor()}.
   *
   * <p>Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDCIDFont.getFontDescriptor()"})
  void testGetFontDescriptor() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getFontDescriptor());
  }

  /**
   * Test {@link PDCIDFont#getFontDescriptor()}.
   *
   * <p>Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDCIDFont.getFontDescriptor()"})
  void testGetFontDescriptor2() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getFontDescriptor());
  }

  /**
   * Test {@link PDCIDFont#getFontDescriptor()}.
   *
   * <ul>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getFontDescriptor()}
   */
  @Test
  @DisplayName("Test getFontDescriptor(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFontDescriptor PDCIDFont.getFontDescriptor()"})
  void testGetFontDescriptor_thenCallsGetCOSArray() throws IOException {
    // Arrange
    when(cOSDictionary.getNameAsString(Mockito.<COSName>any())).thenReturn("Name As String");
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    COSDictionary cosDictionary = new COSDictionary();
    when(cOSDictionary.getCOSDictionary(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    PDFontDescriptor actualFontDescriptor =
        new PDCIDFontType0(cOSDictionary, pDType0Font).getFontDescriptor();

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getCOSDictionary(Mockito.<COSName>any());
    verify(cOSDictionary, atLeast(1)).getNameAsString(isA(COSName.class));
    assertNull(actualFontDescriptor.getCharSet());
    assertNull(actualFontDescriptor.getFontFamily());
    assertNull(actualFontDescriptor.getFontName());
    assertNull(actualFontDescriptor.getFontStretch());
    assertNull(actualFontDescriptor.getFontBoundingBox());
    assertNull(actualFontDescriptor.getCIDSet());
    assertNull(actualFontDescriptor.getFontFile());
    assertNull(actualFontDescriptor.getFontFile2());
    assertNull(actualFontDescriptor.getFontFile3());
    assertNull(actualFontDescriptor.getPanose());
    assertEquals(0, actualFontDescriptor.getFlags());
    assertEquals(0.0f, actualFontDescriptor.getAscent());
    assertEquals(0.0f, actualFontDescriptor.getAverageWidth());
    assertEquals(0.0f, actualFontDescriptor.getCapHeight());
    assertEquals(0.0f, actualFontDescriptor.getDescent());
    assertEquals(0.0f, actualFontDescriptor.getFontWeight());
    assertEquals(0.0f, actualFontDescriptor.getItalicAngle());
    assertEquals(0.0f, actualFontDescriptor.getLeading());
    assertEquals(0.0f, actualFontDescriptor.getMaxWidth());
    assertEquals(0.0f, actualFontDescriptor.getMissingWidth());
    assertEquals(0.0f, actualFontDescriptor.getStemH());
    assertEquals(0.0f, actualFontDescriptor.getStemV());
    assertEquals(0.0f, actualFontDescriptor.getXHeight());
    assertFalse(actualFontDescriptor.isAllCap());
    assertFalse(actualFontDescriptor.isFixedPitch());
    assertFalse(actualFontDescriptor.isForceBold());
    assertFalse(actualFontDescriptor.isItalic());
    assertFalse(actualFontDescriptor.isNonSymbolic());
    assertFalse(actualFontDescriptor.isScript());
    assertFalse(actualFontDescriptor.isSerif());
    assertFalse(actualFontDescriptor.isSmallCap());
    assertFalse(actualFontDescriptor.isSymbolic());
    assertSame(cosDictionary, actualFontDescriptor.getCOSObject());
  }

  /**
   * Test {@link PDCIDFont#getParent()}.
   *
   * <p>Method under test: {@link PDCIDFont#getParent()}
   */
  @Test
  @DisplayName("Test getParent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDType0Font PDCIDFont.getParent()"})
  void testGetParent() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getParent());
  }

  /**
   * Test {@link PDCIDFont#hasExplicitWidth(int)}.
   *
   * <p>Method under test: {@link PDCIDFont#hasExplicitWidth(int)}
   */
  @Test
  @DisplayName("Test hasExplicitWidth(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDCIDFont.hasExplicitWidth(int)"})
  void testHasExplicitWidth() throws IOException {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    boolean actualHasExplicitWidthResult = pDCIDFontType0.hasExplicitWidth(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    assertFalse(actualHasExplicitWidthResult);
  }

  /**
   * Test {@link PDCIDFont#getPositionVector(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSFloat#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getPositionVector(int)}
   */
  @Test
  @DisplayName(
      "Test getPositionVector(int); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDCIDFont.getPositionVector(int)"})
  void testGetPositionVector_givenCOSDictionaryGetDictionaryObjectReturnOne() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    Vector actualPositionVector = pDCIDFontType0.getPositionVector(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(0.5f, actualPositionVector.getX());
    assertEquals(880.0f, actualPositionVector.getY());
  }

  /**
   * Test {@link PDCIDFont#getPositionVector(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSInteger#ONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getPositionVector(int)}
   */
  @Test
  @DisplayName(
      "Test getPositionVector(int); given COSDictionary getDictionaryObject(COSName) return ONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDCIDFont.getPositionVector(int)"})
  void testGetPositionVector_givenCOSDictionaryGetDictionaryObjectReturnOne2() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    Vector actualPositionVector = pDCIDFontType0.getPositionVector(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(0.5f, actualPositionVector.getX());
    assertEquals(880.0f, actualPositionVector.getY());
  }

  /**
   * Test {@link PDCIDFont#getPositionVector(int)}.
   *
   * <ul>
   *   <li>Then return X is five hundred.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getPositionVector(int)}
   */
  @Test
  @DisplayName("Test getPositionVector(int); then return X is five hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Vector PDCIDFont.getPositionVector(int)"})
  void testGetPositionVector_thenReturnXIsFiveHundred() {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    Vector actualPositionVector = pDCIDFontType0.getPositionVector(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(500.0f, actualPositionVector.getX());
    assertEquals(880.0f, actualPositionVector.getY());
  }

  /**
   * Test {@link PDCIDFont#getVerticalDisplacementVectorY(int)}.
   *
   * <p>Method under test: {@link PDCIDFont#getVerticalDisplacementVectorY(int)}
   */
  @Test
  @DisplayName("Test getVerticalDisplacementVectorY(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getVerticalDisplacementVectorY(int)"})
  void testGetVerticalDisplacementVectorY() {
    // Arrange
    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualVerticalDisplacementVectorY = pDCIDFontType0.getVerticalDisplacementVectorY(1);

    // Assert
    verify(cMap).toCID(1);
    verify(pDType0Font).getCMap();
    assertEquals(-1000.0f, actualVerticalDisplacementVectorY);
  }

  /**
   * Test {@link PDCIDFont#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSFloat#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given COSDictionary getDictionaryObject(COSName) return ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getWidth(int)"})
  void testGetWidth_givenCOSDictionaryGetDictionaryObjectReturnOne_thenReturnOne()
      throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSFloat.ONE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualWidth = pDCIDFontType0.getWidth(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(1.0f, actualWidth);
  }

  /**
   * Test {@link PDCIDFont#getWidth(int)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSInteger#ONE}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getWidth(int)}
   */
  @Test
  @DisplayName(
      "Test getWidth(int); given COSDictionary getDictionaryObject(COSName) return ONE; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getWidth(int)"})
  void testGetWidth_givenCOSDictionaryGetDictionaryObjectReturnOne_thenReturnOne2()
      throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSInteger.ONE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualWidth = pDCIDFontType0.getWidth(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(1.0f, actualWidth);
  }

  /**
   * Test {@link PDCIDFont#getWidth(int)}.
   *
   * <ul>
   *   <li>Then return one thousand.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#getWidth(int)}
   */
  @Test
  @DisplayName("Test getWidth(int); then return one thousand")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getWidth(int)"})
  void testGetWidth_thenReturnOneThousand() throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    CMap cMap = mock(CMap.class);
    when(cMap.toCID(anyInt())).thenReturn(1);
    when(pDType0Font.getCMap()).thenReturn(cMap);

    // Act
    float actualWidth = pDCIDFontType0.getWidth(1);

    // Assert
    verify(cMap).toCID(1);
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(pDType0Font).getCMap();
    assertEquals(1000.0f, actualWidth);
  }

  /**
   * Test {@link PDCIDFont#getAverageFontWidth()}.
   *
   * <p>Method under test: {@link PDCIDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getAverageFontWidth()"})
  void testGetAverageFontWidth() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSDictionary(), null);

    // Act and Assert
    assertEquals(1000.0f, pdcidFontType2.getAverageFontWidth());
  }

  /**
   * Test {@link PDCIDFont#getAverageFontWidth()}.
   *
   * <p>Method under test: {@link PDCIDFont#getAverageFontWidth()}
   */
  @Test
  @DisplayName("Test getAverageFontWidth()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDCIDFont.getAverageFontWidth()"})
  void testGetAverageFontWidth2() throws IOException {
    // Arrange
    PDCIDFontType2 pdcidFontType2 = new PDCIDFontType2(new COSStream(), null);

    // Act and Assert
    assertEquals(1000.0f, pdcidFontType2.getAverageFontWidth());
  }

  /**
   * Test {@link PDCIDFont#getCIDSystemInfo()}.
   *
   * <p>Method under test: {@link PDCIDFont#getCIDSystemInfo()}
   */
  @Test
  @DisplayName("Test getCIDSystemInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDCIDSystemInfo PDCIDFont.getCIDSystemInfo()"})
  void testGetCIDSystemInfo() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getCIDSystemInfo());
  }

  /**
   * Test {@link PDCIDFont#getCIDSystemInfo()}.
   *
   * <p>Method under test: {@link PDCIDFont#getCIDSystemInfo()}
   */
  @Test
  @DisplayName("Test getCIDSystemInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"org.apache.pdfbox.pdmodel.font.PDCIDSystemInfo PDCIDFont.getCIDSystemInfo()"})
  void testGetCIDSystemInfo2() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act and Assert
    assertNull(pdcidFontType0.getCIDSystemInfo());
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSDictionary(), null);

    // Act and Assert
    assertNull(pdcidFontType0.readCIDToGIDMap());
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap2() throws IOException {
    // Arrange
    PDCIDFontType0 pdcidFontType0 = new PDCIDFontType0(new COSStream(), null);

    // Act and Assert
    assertNull(pdcidFontType0.readCIDToGIDMap());
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap3() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(), 1L, 3L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap4() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream cosStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 8L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {321, 321, 321}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap5() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache,
            new RandomAccessReadView(
                new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L), 1L, 3L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap6() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    RandomAccessReadView randomAccessReadView =
        new RandomAccessReadView(
            new RandomAccessReadView(new RandomAccessReadWriteBuffer(), -1L, 3L),
            Long.MAX_VALUE,
            3L);

    COSStream cosStream = new COSStream(streamCache, randomAccessReadView);
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSStream(COSName)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName(
      "Test readCIDToGIDMap(); given COSDictionary getCOSStream(COSName) return 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap_givenCOSDictionaryGetCOSStreamReturnNull_thenReturnNull()
      throws IOException {
    // Arrange
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(null);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertNull(actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <ul>
   *   <li>Given {@link RandomAccessReadWriteBuffer#RandomAccessReadWriteBuffer(int)} with
   *       definedChunkSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName(
      "Test readCIDToGIDMap(); given RandomAccessReadWriteBuffer(int) with definedChunkSize is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap_givenRandomAccessReadWriteBufferWithDefinedChunkSizeIsZero()
      throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    COSStream cosStream =
        new COSStream(
            streamCache, new RandomAccessReadView(new RandomAccessReadWriteBuffer(0), 1L, 3L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with {@code 65345} and {@code 65345}.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap(); then return array of int with '65345' and '65345'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap_thenReturnArrayOfIntWith65345And65345() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteBuffer input = ByteBuffer.wrap(new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream cosStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 4096L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {65345, 65345, 65345}, actualReadCIDToGIDMapResult);
  }

  /**
   * Test {@link PDCIDFont#readCIDToGIDMap()}.
   *
   * <ul>
   *   <li>Then return array of {@code int} with three hundred twenty-one.
   * </ul>
   *
   * <p>Method under test: {@link PDCIDFont#readCIDToGIDMap()}
   */
  @Test
  @DisplayName("Test readCIDToGIDMap(); then return array of int with three hundred twenty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int[] PDCIDFont.readCIDToGIDMap()"})
  void testReadCIDToGIDMap_thenReturnArrayOfIntWithThreeHundredTwentyOne() throws IOException {
    // Arrange
    RandomAccessStreamCacheImpl streamCache = new RandomAccessStreamCacheImpl();
    ByteArrayInputStream input =
        new ByteArrayInputStream(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});
    RandomAccessReadBuffer randomAccessRead = new RandomAccessReadBuffer(input);
    COSStream cosStream =
        new COSStream(streamCache, new RandomAccessReadView(randomAccessRead, 1L, 3L));
    when(cOSDictionary.getCOSStream(Mockito.<COSName>any())).thenReturn(cosStream);

    // Act
    int[] actualReadCIDToGIDMapResult = pDCIDFontType0.readCIDToGIDMap();

    // Assert
    verify(cOSDictionary).getCOSStream(isA(COSName.class));
    assertArrayEquals(new int[] {321}, actualReadCIDToGIDMapResult);
  }
}
