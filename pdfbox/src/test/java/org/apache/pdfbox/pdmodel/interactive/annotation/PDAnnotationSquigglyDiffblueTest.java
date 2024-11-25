package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler;
import org.apache.pdfbox.pdmodel.interactive.annotation.handlers.PDCaretAppearanceHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationSquigglyDiffblueTest {
  /**
   * Test {@link PDAnnotationSquiggly#PDAnnotationSquiggly()}.
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#PDAnnotationSquiggly()}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquiggly()")
  void testNewPDAnnotationSquiggly() throws IOException {
    // Arrange and Act
    PDAnnotationSquiggly actualPdAnnotationSquiggly = new PDAnnotationSquiggly();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationSquiggly.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationSquiggly.getAnnotationName());
    assertNull(actualPdAnnotationSquiggly.getContents());
    assertNull(actualPdAnnotationSquiggly.getModifiedDate());
    assertNull(actualPdAnnotationSquiggly.getIntent());
    assertNull(actualPdAnnotationSquiggly.getRichContents());
    assertNull(actualPdAnnotationSquiggly.getSubject());
    assertNull(actualPdAnnotationSquiggly.getTitlePopup());
    assertNull(actualPdAnnotationSquiggly.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationSquiggly.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationSquiggly.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationSquiggly.getPage());
    assertNull(actualPdAnnotationSquiggly.getRectangle());
    assertNull(actualPdAnnotationSquiggly.getOptionalContent());
    assertNull(actualPdAnnotationSquiggly.getColor());
    assertNull(actualPdAnnotationSquiggly.getInReplyTo());
    assertNull(actualPdAnnotationSquiggly.getPopup());
    assertNull(actualPdAnnotationSquiggly.getAppearance());
    assertNull(actualPdAnnotationSquiggly.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquiggly.getBorderStyle());
    assertNull(actualPdAnnotationSquiggly.getExternalData());
    assertEquals(-1, actualPdAnnotationSquiggly.getStructParent());
    assertEquals(0, actualPdAnnotationSquiggly.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationSquiggly.getQuadPoints().length);
    assertEquals(1.0f, actualPdAnnotationSquiggly.getConstantOpacity());
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationSquiggly.isHidden());
    assertFalse(actualPdAnnotationSquiggly.isInvisible());
    assertFalse(actualPdAnnotationSquiggly.isLocked());
    assertFalse(actualPdAnnotationSquiggly.isLockedContents());
    assertFalse(actualPdAnnotationSquiggly.isNoRotate());
    assertFalse(actualPdAnnotationSquiggly.isNoView());
    assertFalse(actualPdAnnotationSquiggly.isNoZoom());
    assertFalse(actualPdAnnotationSquiggly.isPrinted());
    assertFalse(actualPdAnnotationSquiggly.isReadOnly());
    assertFalse(actualPdAnnotationSquiggly.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquiggly.getReplyType());
    assertEquals(PDAnnotationSquiggly.SUB_TYPE, actualPdAnnotationSquiggly.getSubtype());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSquiggly#PDAnnotationSquiggly(COSDictionary)}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#PDAnnotationSquiggly(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationSquiggly(COSDictionary)")
  void testNewPDAnnotationSquiggly2() throws IOException {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationSquiggly actualPdAnnotationSquiggly = new PDAnnotationSquiggly(dict);

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationSquiggly.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationSquiggly.getQuadPoints());
    assertNull(actualPdAnnotationSquiggly.getAnnotationName());
    assertNull(actualPdAnnotationSquiggly.getContents());
    assertNull(actualPdAnnotationSquiggly.getModifiedDate());
    assertNull(actualPdAnnotationSquiggly.getSubtype());
    assertNull(actualPdAnnotationSquiggly.getIntent());
    assertNull(actualPdAnnotationSquiggly.getRichContents());
    assertNull(actualPdAnnotationSquiggly.getSubject());
    assertNull(actualPdAnnotationSquiggly.getTitlePopup());
    assertNull(actualPdAnnotationSquiggly.getCreationDate());
    assertNull(actualPdAnnotationSquiggly.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(actualPdAnnotationSquiggly.getPage());
    assertNull(actualPdAnnotationSquiggly.getRectangle());
    assertNull(actualPdAnnotationSquiggly.getOptionalContent());
    assertNull(actualPdAnnotationSquiggly.getColor());
    assertNull(actualPdAnnotationSquiggly.getInReplyTo());
    assertNull(actualPdAnnotationSquiggly.getPopup());
    assertNull(actualPdAnnotationSquiggly.getAppearance());
    assertNull(actualPdAnnotationSquiggly.getNormalAppearanceStream());
    assertNull(actualPdAnnotationSquiggly.getBorderStyle());
    assertNull(actualPdAnnotationSquiggly.getExternalData());
    assertEquals(-1, actualPdAnnotationSquiggly.getStructParent());
    assertEquals(0, actualPdAnnotationSquiggly.getAnnotationFlags());
    assertEquals(1, dict.size());
    assertEquals(1.0f, actualPdAnnotationSquiggly.getConstantOpacity());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(actualPdAnnotationSquiggly.isHidden());
    assertFalse(actualPdAnnotationSquiggly.isInvisible());
    assertFalse(actualPdAnnotationSquiggly.isLocked());
    assertFalse(actualPdAnnotationSquiggly.isLockedContents());
    assertFalse(actualPdAnnotationSquiggly.isNoRotate());
    assertFalse(actualPdAnnotationSquiggly.isNoView());
    assertFalse(actualPdAnnotationSquiggly.isNoZoom());
    assertFalse(actualPdAnnotationSquiggly.isPrinted());
    assertFalse(actualPdAnnotationSquiggly.isReadOnly());
    assertFalse(actualPdAnnotationSquiggly.isToggleNoView());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationSquiggly.getReplyType());
    assertSame(dict, actualPdAnnotationSquiggly.getCOSObject());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument3() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSDictionary getCOSArray(COSName) return 'null'")
  void testConstructAppearancesWithPDDocument_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return 'null'")
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnNull() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert that nothing has changed
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getKey()")
  void testConstructAppearancesWithPDDocument_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray, atLeast(1)).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PDAnnotationSquiggly#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls getUpdateState()")
  void testConstructAppearancesWithPDDocument_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSArray isDirect() return 'false'; then calls getKey()")
  void testConstructAppearances_givenCOSArrayIsDirectReturnFalse_thenCallsGetKey() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray, atLeast(1)).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@link COSArray#COSArray()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return COSArray()")
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnCOSArray() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSDictionary getCOSArray(COSName) return 'null'")
  void testConstructAppearances_givenCOSDictionaryGetCOSArrayReturnNull() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());
    COSDictionary dict = mock(COSDictionary.class);
    when(dict.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    when(dict.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(dict).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly(dict);
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(dict).getCOSArray(isA(COSName.class));
    verify(dict).getDictionaryObject(isA(COSName.class));
    verify(dict).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDAnnotationSquiggly#PDAnnotationSquiggly()} Rectangle is
   * {@link PDRectangle}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDAnnotationSquiggly() Rectangle is PDRectangle")
  void testConstructAppearances_givenPDAnnotationSquigglyRectangleIsPDRectangle() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setRectangle(rectangle);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return 'null'")
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnNull() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(null);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDCaretAppearanceHandler appearanceHandler = mock(PDCaretAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert that nothing has changed
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationSquiggly#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link COSArray#getUpdateState()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationSquiggly#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls getUpdateState()")
  void testConstructAppearances_thenCallsGetUpdateState() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(cosArray);
    PDColor pdColor = new PDColor(new COSArray(), colorSpace);

    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(10.0f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(pdColor);
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(null);
    doNothing().when(annotation).setAppearance(Mockito.<PDAppearanceDictionary>any());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationSquiggly pdAnnotationSquiggly = new PDAnnotationSquiggly();
    pdAnnotationSquiggly.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationSquiggly.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(colorSpace, atLeast(1)).getCOSObject();
    verify(colorSpace, atLeast(1)).getNumberOfComponents();
    verify(annotation).getAppearance();
    verify(annotation).getCOSObject();
    verify(annotation, atLeast(1)).getColor();
    verify(annotation).getNormalAppearanceStream();
    verify(annotation, atLeast(1)).getRectangle();
    verify(annotation).setAppearance(isA(PDAppearanceDictionary.class));
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }
}
