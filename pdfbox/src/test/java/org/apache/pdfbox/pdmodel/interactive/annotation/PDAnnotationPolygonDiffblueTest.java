package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
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
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCaretAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
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
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    COSArray array = new COSArray();
    PDColor pdColor = new PDColor(array, new PDCalGray());
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances2() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(new PDRectangle(9.223372E18f, 9.223372E18f));
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances3() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSStream()));

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
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

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCaretAppearanceHandler#generateAppearanceStreams()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDCalGray#getNumberOfComponents()}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getNumberOfComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_thenCallsGetNumberOfComponents() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setAppearance(PDAppearanceDictionary)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_thenCallsSetAppearance() {
    // Arrange
    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setNormalAppearance(PDAppearanceEntry)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance())
        .thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());

    PDCalGray colorSpace = mock(PDCalGray.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSStream stream = mock(COSStream.class);
    doNothing().when(stream).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    doNothing().when(stream).setName(Mockito.<COSName>any(), Mockito.<String>any());
    PDAppearanceStream pdAppearanceStream = new PDAppearanceStream(stream);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(cosDictionary);
    when(annotation.getNormalAppearanceStream()).thenReturn(pdAppearanceStream);
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(stream).setItem(isA(COSName.class), isA(COSBase.class));
    verify(stream, atLeast(1)).setName(Mockito.<COSName>any(), Mockito.<String>any());
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).getConstantOpacity();
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances()}.
   *
   * <ul>
   *   <li>Then calls {@link PDAnnotationCaret#setRectangle(PDRectangle)}.
   * </ul>
   *
   * <p>Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setRectangle(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDAnnotationPolygon.constructAppearances()"})
  void testConstructAppearances_thenCallsSetRectangle() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(ArgumentMatchers.anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream())
        .thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon(new COSDictionary());
    pdAnnotationPolygon.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationPolygon.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(5.0f);
    verify(annotation).getConstantOpacity();
  }
}
