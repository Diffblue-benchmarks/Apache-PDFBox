package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationPolygonDiffblueTest {
  /**
   * Test {@link PDAnnotationPolygon#PDAnnotationPolygon()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#PDAnnotationPolygon()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolygon()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.<init>()"})
  void testNewPDAnnotationPolygon() throws IOException {
    // Arrange and Act
    PDAnnotationPolygon actualPdAnnotationPolygon = new PDAnnotationPolygon();

    // Assert
    assertNull(actualPdAnnotationPolygon.getVertices());
    assertNull(actualPdAnnotationPolygon.getPath());
    assertNull(actualPdAnnotationPolygon.getAnnotationName());
    assertNull(actualPdAnnotationPolygon.getContents());
    assertNull(actualPdAnnotationPolygon.getModifiedDate());
    assertNull(actualPdAnnotationPolygon.getIntent());
    assertNull(actualPdAnnotationPolygon.getRichContents());
    assertNull(actualPdAnnotationPolygon.getSubject());
    assertNull(actualPdAnnotationPolygon.getTitlePopup());
    assertNull(actualPdAnnotationPolygon.getCreationDate());
    assertNull(actualPdAnnotationPolygon.getAppearanceState());
    assertNull(actualPdAnnotationPolygon.getPage());
    assertNull(actualPdAnnotationPolygon.getRectangle());
    assertNull(actualPdAnnotationPolygon.getOptionalContent());
    assertNull(actualPdAnnotationPolygon.getColor());
    assertNull(actualPdAnnotationPolygon.getInteriorColor());
    assertNull(actualPdAnnotationPolygon.getInReplyTo());
    assertNull(actualPdAnnotationPolygon.getPopup());
    assertNull(actualPdAnnotationPolygon.getAppearance());
    assertNull(actualPdAnnotationPolygon.getNormalAppearanceStream());
    assertNull(actualPdAnnotationPolygon.getBorderEffect());
    assertNull(actualPdAnnotationPolygon.getBorderStyle());
    assertNull(actualPdAnnotationPolygon.getExternalData());
    assertEquals(-1, actualPdAnnotationPolygon.getStructParent());
    assertEquals(0, actualPdAnnotationPolygon.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationPolygon.getConstantOpacity());
    assertFalse(actualPdAnnotationPolygon.isHidden());
    assertFalse(actualPdAnnotationPolygon.isInvisible());
    assertFalse(actualPdAnnotationPolygon.isLocked());
    assertFalse(actualPdAnnotationPolygon.isLockedContents());
    assertFalse(actualPdAnnotationPolygon.isNoRotate());
    assertFalse(actualPdAnnotationPolygon.isNoView());
    assertFalse(actualPdAnnotationPolygon.isNoZoom());
    assertFalse(actualPdAnnotationPolygon.isPrinted());
    assertFalse(actualPdAnnotationPolygon.isReadOnly());
    assertFalse(actualPdAnnotationPolygon.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationPolygon.getReplyType());
    assertEquals(PDAnnotationPolygon.SUB_TYPE, actualPdAnnotationPolygon.getSubtype());
  }

  /**
   * Test {@link PDAnnotationPolygon#PDAnnotationPolygon(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then return Vertices is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#PDAnnotationPolygon(COSDictionary)}
   */
  @Test
  @DisplayName(
      "Test new PDAnnotationPolygon(COSDictionary); when COSDictionary(); then return Vertices is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.<init>(COSDictionary)"})
  void testNewPDAnnotationPolygon_whenCOSDictionary_thenReturnVerticesIsNull() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationPolygon actualPdAnnotationPolygon = new PDAnnotationPolygon(dict);

    // Assert
    assertNull(actualPdAnnotationPolygon.getVertices());
    assertNull(actualPdAnnotationPolygon.getPath());
    assertNull(actualPdAnnotationPolygon.getAnnotationName());
    assertNull(actualPdAnnotationPolygon.getContents());
    assertNull(actualPdAnnotationPolygon.getModifiedDate());
    assertNull(actualPdAnnotationPolygon.getSubtype());
    assertNull(actualPdAnnotationPolygon.getIntent());
    assertNull(actualPdAnnotationPolygon.getRichContents());
    assertNull(actualPdAnnotationPolygon.getSubject());
    assertNull(actualPdAnnotationPolygon.getTitlePopup());
    assertNull(actualPdAnnotationPolygon.getCreationDate());
    assertNull(actualPdAnnotationPolygon.getAppearanceState());
    assertNull(actualPdAnnotationPolygon.getPage());
    assertNull(actualPdAnnotationPolygon.getRectangle());
    assertNull(actualPdAnnotationPolygon.getOptionalContent());
    assertNull(actualPdAnnotationPolygon.getColor());
    assertNull(actualPdAnnotationPolygon.getInteriorColor());
    assertNull(actualPdAnnotationPolygon.getInReplyTo());
    assertNull(actualPdAnnotationPolygon.getPopup());
    assertNull(actualPdAnnotationPolygon.getAppearance());
    assertNull(actualPdAnnotationPolygon.getNormalAppearanceStream());
    assertNull(actualPdAnnotationPolygon.getBorderEffect());
    assertNull(actualPdAnnotationPolygon.getBorderStyle());
    assertNull(actualPdAnnotationPolygon.getExternalData());
    assertEquals(-1, actualPdAnnotationPolygon.getStructParent());
    assertEquals(0, actualPdAnnotationPolygon.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationPolygon.getConstantOpacity());
    assertFalse(actualPdAnnotationPolygon.isHidden());
    assertFalse(actualPdAnnotationPolygon.isInvisible());
    assertFalse(actualPdAnnotationPolygon.isLocked());
    assertFalse(actualPdAnnotationPolygon.isLockedContents());
    assertFalse(actualPdAnnotationPolygon.isNoRotate());
    assertFalse(actualPdAnnotationPolygon.isNoView());
    assertFalse(actualPdAnnotationPolygon.isNoZoom());
    assertFalse(actualPdAnnotationPolygon.isPrinted());
    assertFalse(actualPdAnnotationPolygon.isReadOnly());
    assertFalse(actualPdAnnotationPolygon.isToggleNoView());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationPolygon.getReplyType());
    assertSame(dict, actualPdAnnotationPolygon.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationPolygon#setInteriorColor(PDColor)}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    PDColor ic = new PDColor(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, PDDeviceGray.INSTANCE);

    // Act
    pdAnnotationPolygon.setInteriorColor(ic);

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    PDColorSpace colorSpace = interiorColor.getColorSpace();
    COSBase cOSObject = colorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSName);
    assertTrue(colorSpace instanceof PDDeviceCMYK);
    assertEquals("DeviceCMYK", ((COSName) cOSObject).getName());
    assertEquals("DeviceCMYK", colorSpace.getName());
    PDColor initialColor = colorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(cOSObject.getKey());
    assertEquals(4, colorSpace.getNumberOfComponents());
    assertFalse(cOSObject.isDirect());
    assertFalse(((COSName) cOSObject).isEmpty());
    assertFalse(initialColor.isPattern());
    assertSame(colorSpace, initialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f, 1.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[] {10.0f, 0.5f, 10.0f, 0.5f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} InteriorColor Pattern.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolygon() InteriorColor Pattern")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolygonInteriorColorPattern() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[] {0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#setInteriorColor(PDColor)}.
   *
   * <ul>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} InteriorColor PatternName is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName(
      "Test setInteriorColor(PDColor); then PDAnnotationPolygon() InteriorColor PatternName is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolygonInteriorColorPatternNameIsNull() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[] {}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#getInteriorColor()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDAnnotationPolygon.getInteriorColor()"})
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolygon().getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSDictionary dict = new COSDictionary();
    dict.setKey(new COSObjectKey(1L, 1));

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_givenTrue_whenCOSDictionaryDirectIsTrue() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSDictionary dict = new COSDictionary();
    dict.setDirect(true);

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary(dict));

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
    assertSame(dict, borderEffect.getCOSObject());
  }

  /**
   * Test {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} COSObject Values size is two.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName(
      "Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then PDAnnotationPolygon() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenNull_thenPDAnnotationPolygonCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setBorderEffect(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}.
   *
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setBorderEffect(PDBorderEffectDictionary)"})
  void testSetBorderEffect_whenPDBorderEffectDictionary() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = pdAnnotationPolygon.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDBorderEffectDictionary.STYLE_SOLID, borderEffect.getStyle());
  }

  /**
   * Test {@link PDAnnotationPolygon#getBorderEffect()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDBorderEffectDictionary PDAnnotationPolygon.getBorderEffect()"})
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolygon().getBorderEffect());
  }

  /**
   * Test {@link PDAnnotationPolygon#getVertices()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDAnnotationPolygon.getVertices()"})
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolygon().getVertices());
  }

  /**
   * Test {@link PDAnnotationPolygon#setVertices(float[])}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.setVertices(float[])"})
  void testSetVertices() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setVertices(new float[] {10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(
        new float[] {10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#getPath()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[][] PDAnnotationPolygon.getPath()"})
  void testGetPath() {
    // Arrange, Act and Assert
    assertNull(new PDAnnotationPolygon().getPath());
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).size();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances(PDDocument)} with {@code PDDocument}.
   *
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(PDDocument) with 'PDDocument'; then calls getUpdateState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances(PDDocument)"})
  void testConstructAppearancesWithPDDocument_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddA_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSName#A}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add A; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddA_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSName.A);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSArray_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSArray#COSArray()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSArray(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSArray_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSArray());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSDictionary(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSDictionary_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSDictionary#COSDictionary()}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add COSDictionary(); then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddCOSDictionary_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSDictionary());

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddOne_thenCallsGetCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray() add ONE; then calls getCOSArray(COSName)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayAddOne_thenCallsGetCOSArray2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSInteger.ONE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSBoolean#FALSE}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(3);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosArray).getObject(2);
    verify(cosArray, atLeast(1)).size();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code false}.
   *   <li>Then calls {@link COSArray#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosArray).size();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#isDirect()} return {@code true}.
   *   <li>Then calls {@link COSArray#getUpdateState()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray isDirect() return 'true'; then calls getUpdateState()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArrayIsDirectReturnTrue_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));

    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return four.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSArray size() return four; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSArraySizeReturnFour_thenCallsGetObject() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray, atLeast(1)).size();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@link
   *       COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnCOSDictionary() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSDictionary(COSName)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSDictionary getCOSDictionary(COSName) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSDictionaryGetCOSDictionaryReturnNull2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName(
      "Test constructAppearances(); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenCOSObjectKeyWithNumIsOneAndGenIsOne2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);

    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    when(dict.getCOSDictionary(Mockito.<COSName>any())).thenReturn(new COSDictionary());
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(dict);
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getCOSDictionary(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link
   *       COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDRectangle getCOSArray() return COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();
    pdAnnotationPolygon.setRectangle(rectangle);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }
}
