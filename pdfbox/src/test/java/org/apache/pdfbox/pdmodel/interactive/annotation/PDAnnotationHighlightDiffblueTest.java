package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationHighlightDiffblueTest {
  /**
   * Test {@link PDAnnotationHighlight#PDAnnotationHighlight()}.
   * <p>
   * Method under test: {@link PDAnnotationHighlight#PDAnnotationHighlight()}
   */
  @Test
  @DisplayName("Test new PDAnnotationHighlight()")
  void testNewPDAnnotationHighlight() throws IOException {
    // Arrange and Act
    PDAnnotationHighlight actualPdAnnotationHighlight = new PDAnnotationHighlight();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationHighlight.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationHighlight.getAnnotationName());
    assertNull(actualPdAnnotationHighlight.getContents());
    assertNull(actualPdAnnotationHighlight.getModifiedDate());
    assertNull(actualPdAnnotationHighlight.getIntent());
    assertNull(actualPdAnnotationHighlight.getRichContents());
    assertNull(actualPdAnnotationHighlight.getSubject());
    assertNull(actualPdAnnotationHighlight.getTitlePopup());
    assertNull(actualPdAnnotationHighlight.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationHighlight.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationHighlight.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationHighlight.getPage());
    assertNull(actualPdAnnotationHighlight.getRectangle());
    assertNull(actualPdAnnotationHighlight.getOptionalContent());
    assertNull(actualPdAnnotationHighlight.getColor());
    assertNull(actualPdAnnotationHighlight.getInReplyTo());
    assertNull(actualPdAnnotationHighlight.getPopup());
    assertNull(actualPdAnnotationHighlight.getAppearance());
    assertNull(actualPdAnnotationHighlight.getNormalAppearanceStream());
    assertNull(actualPdAnnotationHighlight.getBorderStyle());
    assertNull(actualPdAnnotationHighlight.getExternalData());
    assertEquals(-1, actualPdAnnotationHighlight.getStructParent());
    assertEquals(0, actualPdAnnotationHighlight.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationHighlight.getQuadPoints().length);
    assertEquals(1.0f, actualPdAnnotationHighlight.getConstantOpacity());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationHighlight.isHidden());
    assertFalse(actualPdAnnotationHighlight.isInvisible());
    assertFalse(actualPdAnnotationHighlight.isLocked());
    assertFalse(actualPdAnnotationHighlight.isLockedContents());
    assertFalse(actualPdAnnotationHighlight.isNoRotate());
    assertFalse(actualPdAnnotationHighlight.isNoView());
    assertFalse(actualPdAnnotationHighlight.isNoZoom());
    assertFalse(actualPdAnnotationHighlight.isPrinted());
    assertFalse(actualPdAnnotationHighlight.isReadOnly());
    assertFalse(actualPdAnnotationHighlight.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationHighlight.SUB_TYPE, actualPdAnnotationHighlight.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationHighlight.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationHighlight#PDAnnotationHighlight(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationHighlight#PDAnnotationHighlight(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationHighlight(COSDictionary)")
  void testNewPDAnnotationHighlight2() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationHighlight actualPdAnnotationHighlight = new PDAnnotationHighlight(dict);

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationHighlight.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationHighlight.getQuadPoints());
    assertNull(actualPdAnnotationHighlight.getAnnotationName());
    assertNull(actualPdAnnotationHighlight.getContents());
    assertNull(actualPdAnnotationHighlight.getModifiedDate());
    assertNull(actualPdAnnotationHighlight.getSubtype());
    assertNull(actualPdAnnotationHighlight.getIntent());
    assertNull(actualPdAnnotationHighlight.getRichContents());
    assertNull(actualPdAnnotationHighlight.getSubject());
    assertNull(actualPdAnnotationHighlight.getTitlePopup());
    assertNull(actualPdAnnotationHighlight.getCreationDate());
    assertNull(actualPdAnnotationHighlight.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(actualPdAnnotationHighlight.getPage());
    assertNull(actualPdAnnotationHighlight.getRectangle());
    assertNull(actualPdAnnotationHighlight.getOptionalContent());
    assertNull(actualPdAnnotationHighlight.getColor());
    assertNull(actualPdAnnotationHighlight.getInReplyTo());
    assertNull(actualPdAnnotationHighlight.getPopup());
    assertNull(actualPdAnnotationHighlight.getAppearance());
    assertNull(actualPdAnnotationHighlight.getNormalAppearanceStream());
    assertNull(actualPdAnnotationHighlight.getBorderStyle());
    assertNull(actualPdAnnotationHighlight.getExternalData());
    assertEquals(-1, actualPdAnnotationHighlight.getStructParent());
    assertEquals(0, actualPdAnnotationHighlight.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationHighlight.getConstantOpacity());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(actualPdAnnotationHighlight.isHidden());
    assertFalse(actualPdAnnotationHighlight.isInvisible());
    assertFalse(actualPdAnnotationHighlight.isLocked());
    assertFalse(actualPdAnnotationHighlight.isLockedContents());
    assertFalse(actualPdAnnotationHighlight.isNoRotate());
    assertFalse(actualPdAnnotationHighlight.isNoView());
    assertFalse(actualPdAnnotationHighlight.isNoZoom());
    assertFalse(actualPdAnnotationHighlight.isPrinted());
    assertFalse(actualPdAnnotationHighlight.isReadOnly());
    assertFalse(actualPdAnnotationHighlight.isToggleNoView());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationHighlight.getReplyType());
    assertSame(dict, actualPdAnnotationHighlight.getCOSObject());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray() add FALSE")
  void testConstructAppearancesWithPDDocument_givenCOSArrayAddFalse() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.</li>
   *   <li>Then calls {@link COSArray#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationHighlight#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSArray size() return three; then calls get(int)")
  void testConstructAppearancesWithPDDocument_givenCOSArraySizeReturnThree_thenCallsGet() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    PDAnnotationHighlight pdAnnotationHighlight = new PDAnnotationHighlight(dict);

    // Act
    pdAnnotationHighlight.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosArray).toFloatArray();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.</li>
   *   <li>Then calls {@link COSDictionary#getCOSArray(COSName)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray() add FALSE; then calls getCOSArray(COSName)")
  void testConstructAppearances_givenCOSArrayAddFalse_thenCallsGetCOSArray() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#size()} return three.</li>
   *   <li>Then calls {@link COSArray#get(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray size() return three; then calls get(int)")
  void testConstructAppearances_givenCOSArraySizeReturnThree_thenCallsGet() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(true);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).get(anyInt());
    verify(cosArray).isEmpty();
    verify(cosArray, atLeast(1)).size();
    verify(cosArray).toFloatArray();
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDAnnotationHighlight#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationHighlight#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act
    (new PDAnnotationHighlight(dict)).constructAppearances();

    // Assert
    verify(dict, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(dict).getDictionaryObject(isA(COSName.class));
  }
}
