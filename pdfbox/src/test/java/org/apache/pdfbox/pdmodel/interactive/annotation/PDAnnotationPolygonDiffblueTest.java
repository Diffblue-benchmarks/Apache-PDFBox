package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDAnnotationPolygonDiffblueTest {
  /**
   * Test {@link PDAnnotationPolygon#PDAnnotationPolygon()}.
   * <p>
   * Method under test: {@link PDAnnotationPolygon#PDAnnotationPolygon()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolygon()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then return Vertices is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#PDAnnotationPolygon(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolygon(COSDictionary); when COSDictionary(); then return Vertices is 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); given FALSE; when COSArray() add FALSE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor_givenFalse_whenCOSArrayAddFalse() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} InteriorColor ColorSpace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolygon() InteriorColor ColorSpace is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolygonInteriorColorColorSpaceIsNull() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} InteriorColor Pattern.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolygon() InteriorColor Pattern")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationPolygon.setInteriorColor(PDColor)"})
  void testSetInteriorColor_thenPDAnnotationPolygonInteriorColorPattern() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolygon.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#getInteriorColor()}.
   * <p>
   * Method under test: {@link PDAnnotationPolygon#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDColor PDAnnotationPolygon.getInteriorColor()"})
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link PDAnnotationPolygon#PDAnnotationPolygon()} COSObject Values size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when 'null'; then PDAnnotationPolygon() COSObject Values size is two")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link PDBorderEffectDictionary#PDBorderEffectDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  @DisplayName("Test setBorderEffect(PDBorderEffectDictionary); when PDBorderEffectDictionary()")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDAnnotationPolygon#getBorderEffect()}
   */
  @Test
  @DisplayName("Test getBorderEffect()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDBorderEffectDictionary PDAnnotationPolygon.getBorderEffect()"})
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getBorderEffect());
  }

  /**
   * Test {@link PDAnnotationPolygon#getVertices()}.
   * <p>
   * Method under test: {@link PDAnnotationPolygon#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDAnnotationPolygon.getVertices()"})
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getVertices());
  }

  /**
   * Test {@link PDAnnotationPolygon#setVertices(float[])}.
   * <p>
   * Method under test: {@link PDAnnotationPolygon#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDAnnotationPolygon.setVertices(float[])"})
  void testSetVertices() {
    // Arrange
    PDAnnotationPolygon pdAnnotationPolygon = new PDAnnotationPolygon();

    // Act
    pdAnnotationPolygon.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolygon.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolygon.getVertices(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolygon#getPath()}.
   * <p>
   * Method under test: {@link PDAnnotationPolygon#getPath()}
   */
  @Test
  @DisplayName("Test getPath()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[][] PDAnnotationPolygon.getPath()"})
  void testGetPath() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolygon()).getPath());
  }

  /**
   * Test {@link PDAnnotationPolygon#constructAppearances(PDDocument)} with {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return COSArray()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getUpdateState()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return {@code true}.</li>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray isDirect() return 'true'; then calls getUpdateState()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolygon#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDRectangle getCOSArray() return COSArray()")
  @Tag("MaintainedByDiffblue")
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
