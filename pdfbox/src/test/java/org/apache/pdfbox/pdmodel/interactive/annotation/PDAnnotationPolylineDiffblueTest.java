package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PDAnnotationPolylineDiffblueTest {
  /**
   * Test {@link PDAnnotationPolyline#PDAnnotationPolyline()}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#PDAnnotationPolyline()}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolyline()")
  void testNewPDAnnotationPolyline() throws IOException {
    // Arrange and Act
    PDAnnotationPolyline actualPdAnnotationPolyline = new PDAnnotationPolyline();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationPolyline.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationPolyline.getVertices());
    assertNull(actualPdAnnotationPolyline.getAnnotationName());
    assertNull(actualPdAnnotationPolyline.getContents());
    assertNull(actualPdAnnotationPolyline.getModifiedDate());
    assertNull(actualPdAnnotationPolyline.getIntent());
    assertNull(actualPdAnnotationPolyline.getRichContents());
    assertNull(actualPdAnnotationPolyline.getSubject());
    assertNull(actualPdAnnotationPolyline.getTitlePopup());
    assertNull(actualPdAnnotationPolyline.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationPolyline.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationPolyline.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationPolyline.getPage());
    assertNull(actualPdAnnotationPolyline.getRectangle());
    assertNull(actualPdAnnotationPolyline.getOptionalContent());
    assertNull(actualPdAnnotationPolyline.getColor());
    assertNull(actualPdAnnotationPolyline.getInteriorColor());
    assertNull(actualPdAnnotationPolyline.getInReplyTo());
    assertNull(actualPdAnnotationPolyline.getPopup());
    assertNull(actualPdAnnotationPolyline.getAppearance());
    assertNull(actualPdAnnotationPolyline.getNormalAppearanceStream());
    assertNull(actualPdAnnotationPolyline.getBorderStyle());
    assertNull(actualPdAnnotationPolyline.getExternalData());
    assertEquals(-1, actualPdAnnotationPolyline.getStructParent());
    assertEquals(0, actualPdAnnotationPolyline.getAnnotationFlags());
    assertEquals(1.0f, actualPdAnnotationPolyline.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationPolyline.isHidden());
    assertFalse(actualPdAnnotationPolyline.isInvisible());
    assertFalse(actualPdAnnotationPolyline.isLocked());
    assertFalse(actualPdAnnotationPolyline.isLockedContents());
    assertFalse(actualPdAnnotationPolyline.isNoRotate());
    assertFalse(actualPdAnnotationPolyline.isNoView());
    assertFalse(actualPdAnnotationPolyline.isNoZoom());
    assertFalse(actualPdAnnotationPolyline.isPrinted());
    assertFalse(actualPdAnnotationPolyline.isReadOnly());
    assertFalse(actualPdAnnotationPolyline.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getEndPointEndingStyle());
    assertEquals(PDAnnotationLine.LE_NONE, actualPdAnnotationPolyline.getStartPointEndingStyle());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationPolyline.getReplyType());
    assertEquals(PDAnnotationPolyline.SUB_TYPE, actualPdAnnotationPolyline.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolyline(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationPolyline_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationPolyline actualPdAnnotationPolyline = new PDAnnotationPolyline(dict);

    // Assert
    assertEquals(1, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationPolyline.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationPolyline.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#PDAnnotationPolyline(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationPolyline(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationPolyline_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream dict = new COSStream();

    // Act
    PDAnnotationPolyline actualPdAnnotationPolyline = new PDAnnotationPolyline(dict);

    // Assert
    assertEquals(2, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationPolyline.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationPolyline.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle2() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setStartPointEndingStyle(String)")
  void testSetStartPointEndingStyle3() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setStartPointEndingStyle("NoneNone");

    // Assert
    assertEquals("NoneNone", pdAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#getStartPointEndingStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getStartPointEndingStyle()")
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationPolyline()).getStartPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()}
   * EndPointEndingStyle is {@link PDAnnotationLine#LE_NONE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is LE_NONE")
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIsLe_none() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()}
   * EndPointEndingStyle is {@code NoneNone}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is 'NoneNone'")
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIsNoneNone() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("NoneNone");

    // Assert
    assertEquals("NoneNone", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()}
   * EndPointEndingStyle is {@code Style}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  @DisplayName("Test setEndPointEndingStyle(String); then PDAnnotationPolyline() EndPointEndingStyle is 'Style'")
  void testSetEndPointEndingStyle_thenPDAnnotationPolylineEndPointEndingStyleIsStyle() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationPolyline#getEndPointEndingStyle()}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  @DisplayName("Test getEndPointEndingStyle()")
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationPolyline()).getEndPointEndingStyle());
  }

  /**
   * Test {@link PDAnnotationPolyline#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Given {@link COSBoolean#FALSE}.</li>
   *   <li>When {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); given FALSE; when COSArray() add FALSE")
  void testSetInteriorColor_givenFalse_whenCOSArrayAddFalse() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} InteriorColor
   * ColorSpace is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolyline() InteriorColor ColorSpace is 'null'")
  void testSetInteriorColor_thenPDAnnotationPolylineInteriorColorColorSpaceIsNull() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertEquals(0, interiorColor.getComponents().length);
    assertFalse(interiorColor.isPattern());
  }

  /**
   * Test {@link PDAnnotationPolyline#setInteriorColor(PDColor)}.
   * <ul>
   *   <li>Then {@link PDAnnotationPolyline#PDAnnotationPolyline()} InteriorColor
   * Pattern.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#setInteriorColor(PDColor)}
   */
  @Test
  @DisplayName("Test setInteriorColor(PDColor); then PDAnnotationPolyline() InteriorColor Pattern")
  void testSetInteriorColor_thenPDAnnotationPolylineInteriorColorPattern() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setInteriorColor(new PDColor(COSName.A, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationPolyline.getInteriorColor();
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#getInteriorColor()}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#getInteriorColor()}
   */
  @Test
  @DisplayName("Test getInteriorColor()")
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolyline()).getInteriorColor());
  }

  /**
   * Test {@link PDAnnotationPolyline#getVertices()}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#getVertices()}
   */
  @Test
  @DisplayName("Test getVertices()")
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationPolyline()).getVertices());
  }

  /**
   * Test {@link PDAnnotationPolyline#setVertices(float[])}.
   * <p>
   * Method under test: {@link PDAnnotationPolyline#setVertices(float[])}
   */
  @Test
  @DisplayName("Test setVertices(float[])")
  void testSetVertices() {
    // Arrange
    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();

    // Act
    pdAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = pdAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, pdAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray getObject(int) return FALSE")
  void testConstructAppearancesWithPDDocument_givenCOSArrayGetObjectReturnFalse() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray size() return three")
  void testConstructAppearancesWithPDDocument_givenCOSArraySizeReturnThree() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDRectangle getCOSArray() return COSArray()")
  void testConstructAppearancesWithPDDocument_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationPolyline#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls toFloatArray()")
  void testConstructAppearancesWithPDDocument_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return
   * {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray getObject(int) return FALSE; then calls getObject(int)")
  void testConstructAppearances_givenCOSArrayGetObjectReturnFalse_thenCallsGetObject() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  void testConstructAppearances_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.</li>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray size() return three; then calls getUpdateState()")
  void testConstructAppearances_givenCOSArraySizeReturnThree_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDRectangle} {@link PDRectangle#getCOSArray()} return
   * {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDRectangle getCOSArray() return COSArray()")
  void testConstructAppearances_givenPDRectangleGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationPolyline#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link COSArray#toFloatArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationPolyline#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls toFloatArray()")
  void testConstructAppearances_thenCallsToFloatArray() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationPolyline pdAnnotationPolyline = new PDAnnotationPolyline();
    pdAnnotationPolyline.setRectangle(rectangle);

    // Act
    pdAnnotationPolyline.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }
}
