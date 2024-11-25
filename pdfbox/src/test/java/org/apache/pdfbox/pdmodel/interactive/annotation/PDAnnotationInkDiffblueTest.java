package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.apache.pdfbox.cos.COSDocumentState;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
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

class PDAnnotationInkDiffblueTest {
  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#PDAnnotationInk()}
   */
  @Test
  @DisplayName("Test new PDAnnotationInk()")
  void testNewPDAnnotationInk() throws IOException {
    // Arrange and Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk();

    // Assert
    List<? extends COSBase> toListResult = actualPdAnnotationInk.getBorder().toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSInteger);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSInteger);
    assertNull(actualPdAnnotationInk.getAnnotationName());
    assertNull(actualPdAnnotationInk.getContents());
    assertNull(actualPdAnnotationInk.getModifiedDate());
    assertNull(actualPdAnnotationInk.getIntent());
    assertNull(actualPdAnnotationInk.getRichContents());
    assertNull(actualPdAnnotationInk.getSubject());
    assertNull(actualPdAnnotationInk.getTitlePopup());
    assertNull(actualPdAnnotationInk.getCreationDate());
    COSDictionary cOSObject = actualPdAnnotationInk.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(actualPdAnnotationInk.getAppearanceState());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cOSObject.getKey());
    assertNull(actualPdAnnotationInk.getPage());
    assertNull(actualPdAnnotationInk.getRectangle());
    assertNull(actualPdAnnotationInk.getOptionalContent());
    assertNull(actualPdAnnotationInk.getColor());
    assertNull(actualPdAnnotationInk.getInReplyTo());
    assertNull(actualPdAnnotationInk.getPopup());
    assertNull(actualPdAnnotationInk.getAppearance());
    assertNull(actualPdAnnotationInk.getNormalAppearanceStream());
    assertNull(actualPdAnnotationInk.getBorderStyle());
    assertNull(actualPdAnnotationInk.getExternalData());
    assertEquals(-1, actualPdAnnotationInk.getStructParent());
    assertEquals(0, actualPdAnnotationInk.getAnnotationFlags());
    assertEquals(0, actualPdAnnotationInk.getInkList().length);
    assertEquals(1.0f, actualPdAnnotationInk.getConstantOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualPdAnnotationInk.isHidden());
    assertFalse(actualPdAnnotationInk.isInvisible());
    assertFalse(actualPdAnnotationInk.isLocked());
    assertFalse(actualPdAnnotationInk.isLockedContents());
    assertFalse(actualPdAnnotationInk.isNoRotate());
    assertFalse(actualPdAnnotationInk.isNoView());
    assertFalse(actualPdAnnotationInk.isNoZoom());
    assertFalse(actualPdAnnotationInk.isPrinted());
    assertFalse(actualPdAnnotationInk.isReadOnly());
    assertFalse(actualPdAnnotationInk.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertTrue(((COSInteger) getResult).isValid());
    assertTrue(((COSInteger) getResult2).isValid());
    assertEquals(PDAnnotationInk.SUB_TYPE, actualPdAnnotationInk.getSubtype());
    assertEquals(PDAnnotationMarkup.RT_REPLY, actualPdAnnotationInk.getReplyType());
    assertSame(getResult, toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then {@link COSDictionary#COSDictionary()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationInk(COSDictionary); when COSDictionary(); then COSDictionary() size is one")
  void testNewPDAnnotationInk_whenCOSDictionary_thenCOSDictionarySizeIsOne() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk(dict);

    // Assert
    assertEquals(1, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationInk.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationInk.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.</li>
   *   <li>Then {@link COSStream#COSStream()} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#PDAnnotationInk(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDAnnotationInk(COSDictionary); when COSStream(); then COSStream() size is two")
  void testNewPDAnnotationInk_whenCOSStream_thenCOSStreamSizeIsTwo() {
    // Arrange
    COSStream dict = new COSStream();

    // Act
    PDAnnotationInk actualPdAnnotationInk = new PDAnnotationInk(dict);

    // Assert
    assertEquals(2, dict.size());
    List<? extends COSBase> toListResult = actualPdAnnotationInk.getBorder().toList();
    assertEquals(3, toListResult.size());
    assertSame(dict, actualPdAnnotationInk.getCOSObject());
    assertSame(toListResult.get(0), toListResult.get(1));
  }

  /**
   * Test {@link PDAnnotationInk#setInkList(float[][])}.
   * <ul>
   *   <li>When array of {@code float} with ten and {@code 0.5}.</li>
   *   <li>Then array length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#setInkList(float[][])}
   */
  @Test
  @DisplayName("Test setInkList(float[][]); when array of float with ten and '0.5'; then array length is one")
  void testSetInkList_whenArrayOfFloatWithTenAnd05_thenArrayLengthIsOne() {
    // Arrange
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();

    // Act
    pdAnnotationInk.setInkList(new float[][]{new float[]{10.0f, 0.5f, 10.0f, 0.5f}});

    // Assert
    float[][] inkList = pdAnnotationInk.getInkList();
    assertEquals(1, inkList.length);
    COSDictionary cOSObject = pdAnnotationInk.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, inkList[0], 0.0f);
  }

  /**
   * Test {@link PDAnnotationInk#setInkList(float[][])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#setInkList(float[][])}
   */
  @Test
  @DisplayName("Test setInkList(float[][]); when 'null'; then array length is zero")
  void testSetInkList_whenNull_thenArrayLengthIsZero() {
    // Arrange
    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();

    // Act
    pdAnnotationInk.setInkList(null);

    // Assert
    assertEquals(0, pdAnnotationInk.getInkList().length);
    COSDictionary cOSObject = pdAnnotationInk.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Test {@link PDAnnotationInk#getInkList()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#getInkList()}
   */
  @Test
  @DisplayName("Test getInkList()")
  void testGetInkList() {
    // Arrange, Act and Assert
    assertEquals(0, (new PDAnnotationInk()).getInkList().length);
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances2() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances3() {
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances4() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(256);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances5() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances()")
  void testConstructAppearances6() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument() {
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument2() {
    // Arrange
    PDAnnotationCaret annotation = mock(PDAnnotationCaret.class);
    doNothing().when(annotation).setRectangle(Mockito.<PDRectangle>any());
    doNothing().when(annotation).setRectDifferences(anyFloat());
    when(annotation.getConstantOpacity()).thenReturn(-9.223372E18f);
    when(annotation.getCOSObject()).thenReturn(new COSDictionary());
    when(annotation.getNormalAppearanceStream()).thenReturn(new PDAppearanceStream(new COSStream()));
    when(annotation.getColor()).thenReturn(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
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
    COSArray array = new COSArray();
    when(annotation.getColor()).thenReturn(new PDColor(array, new PDCalGray()));
    when(annotation.getRectangle()).thenReturn(PDRectangle.A0);
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument4() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(256);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument5() {
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
    when(annotation.getAppearance()).thenReturn(new PDAppearanceDictionary());
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
    verify(annotation).setRectangle(isA(PDRectangle.class));
    verify(annotation).setRectDifferences(eq(5.0f));
    verify(annotation).getConstantOpacity();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'")
  void testConstructAppearancesWithPDDocument6() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSStream()));
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given COSObjectKey(long, int) with num is one and gen is one")
  void testConstructAppearancesWithPDDocument_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return A")
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnA() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSName.A);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return FALSE")
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnFalse() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; given PDColorSpace getCOSObject() return ONE")
  void testConstructAppearancesWithPDDocument_givenPDColorSpaceGetCOSObjectReturnOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSInteger.ONE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls generateAppearanceStreams()")
  void testConstructAppearancesWithPDDocument_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert that nothing has changed
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls
   * {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls setAppearance(PDAppearanceDictionary)")
  void testConstructAppearancesWithPDDocument_thenCallsSetAppearance() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls setNormalAppearance(PDAppearanceEntry)")
  void testConstructAppearancesWithPDDocument_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances(PDDocument)} with
   * {@code PDDocument}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances(PDDocument)}
   */
  @Test
  @DisplayName("Test constructAppearances(PDDocument) with 'PDDocument'; then calls setOriginDocumentState(COSDocumentState)")
  void testConstructAppearancesWithPDDocument_thenCallsSetOriginDocumentState() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances(new PDDocument());

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSArray} {@link COSBase#isDirect()} return
   * {@code false}.</li>
   *   <li>Then calls {@link COSBase#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and
   * gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given COSObjectKey(long, int) with num is one and gen is one")
  void testConstructAppearances_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1)));
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSName#A}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return A")
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnA() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSName.A);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSBoolean#FALSE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return FALSE")
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnFalse() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSBoolean.FALSE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Given {@link PDColorSpace} {@link PDColorSpace#getCOSObject()} return
   * {@link COSInteger#ONE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); given PDColorSpace getCOSObject() return ONE")
  void testConstructAppearances_givenPDColorSpaceGetCOSObjectReturnOne() {
    // Arrange
    PDColorSpace colorSpace = mock(PDColorSpace.class);
    when(colorSpace.getNumberOfComponents()).thenReturn(10);
    when(colorSpace.getCOSObject()).thenReturn(COSInteger.ONE);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Then calls {@link PDAppearanceHandler#generateAppearanceStreams()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls generateAppearanceStreams()")
  void testConstructAppearances_thenCallsGenerateAppearanceStreams() {
    // Arrange
    PDAppearanceHandler appearanceHandler = mock(PDAppearanceHandler.class);
    doNothing().when(appearanceHandler).generateAppearanceStreams();

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert that nothing has changed
    verify(appearanceHandler).generateAppearanceStreams();
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAnnotation#setAppearance(PDAppearanceDictionary)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setAppearance(PDAppearanceDictionary)")
  void testConstructAppearances_thenCallsSetAppearance() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Then calls
   * {@link PDAppearanceDictionary#setNormalAppearance(PDAppearanceEntry)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setNormalAppearance(PDAppearanceEntry)")
  void testConstructAppearances_thenCallsSetNormalAppearance() {
    // Arrange
    PDAppearanceDictionary pdAppearanceDictionary = mock(PDAppearanceDictionary.class);
    when(pdAppearanceDictionary.getNormalAppearance()).thenReturn(new PDAppearanceEntry(new COSDictionary()));
    doNothing().when(pdAppearanceDictionary).setNormalAppearance(Mockito.<PDAppearanceEntry>any());
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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
    when(annotation.getAppearance()).thenReturn(pdAppearanceDictionary);
    PDCaretAppearanceHandler appearanceHandler = new PDCaretAppearanceHandler(annotation);

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
    verify(pdAppearanceDictionary).getNormalAppearance();
    verify(pdAppearanceDictionary).setNormalAppearance(isA(PDAppearanceEntry.class));
  }

  /**
   * Test {@link PDAnnotationInk#constructAppearances()}.
   * <ul>
   *   <li>Then calls
   * {@link COSUpdateState#setOriginDocumentState(COSDocumentState)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDAnnotationInk#constructAppearances()}
   */
  @Test
  @DisplayName("Test constructAppearances(); then calls setOriginDocumentState(COSDocumentState)")
  void testConstructAppearances_thenCallsSetOriginDocumentState() {
    // Arrange
    COSUpdateState cosUpdateState = mock(COSUpdateState.class);
    doNothing().when(cosUpdateState).setOriginDocumentState(Mockito.<COSDocumentState>any());
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(cosUpdateState);
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

    PDAnnotationInk pdAnnotationInk = new PDAnnotationInk();
    pdAnnotationInk.setCustomAppearanceHandler(appearanceHandler);

    // Act
    pdAnnotationInk.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).isDirect();
    verify(cosUpdateState).setOriginDocumentState(isNull());
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
}
