package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDAnnotationLineDiffblueTest {
  /**
   * Method under test: {@link PDAnnotationLine#setLine(float[])}
   */
  @Test
  void testSetLine() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLine(new float[]{10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    float[] line = pdAnnotationLine.getLine();
    assertEquals(10.0f, line[0]);
    assertEquals(10.0f, line[2]);
    assertEquals(4, line.length);
  }

  /**
   * Method under test: {@link PDAnnotationLine#getLine()}
   */
  @Test
  void testGetLine() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f, 0.0f}, (new PDAnnotationLine()).getLine(), 0.0f);
    assertNull((new PDAnnotationLine(new COSDictionary())).getLine());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle2() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationLine.getStartPointEndingStyle());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle3() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setStartPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationLine.getStartPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getStartPointEndingStyle()}
   */
  @Test
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationLine()).getStartPointEndingStyle());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", pdAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle2() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle(null);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertEquals(PDAnnotationLine.LE_NONE, pdAnnotationLine.getEndPointEndingStyle());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle3() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setEndPointEndingStyle("42");

    // Assert
    assertEquals("42", pdAnnotationLine.getEndPointEndingStyle());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getEndPointEndingStyle()}
   */
  @Test
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals(PDAnnotationLine.LE_NONE, (new PDAnnotationLine()).getEndPointEndingStyle());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(new COSArray(), PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    assertEquals(0, interiorColor.getComponents().length);
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(interiorColor.isPattern());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor2() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    COSArray array = new COSArray();
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor3() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertNull(interiorColor.getPatternName());
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f, 0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLine#setInteriorColor(PDColor)}
   */
  @Test
  void testSetInteriorColor4() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdAnnotationLine.setInteriorColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
    PDColor interiorColor = pdAnnotationLine.getInteriorColor();
    assertNull(interiorColor.getColorSpace());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(interiorColor.isPattern());
    assertArrayEquals(new float[]{0.0f}, interiorColor.getComponents(), 0.0f);
  }

  /**
   * Method under test: {@link PDAnnotationLine#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLine()).getInteriorColor());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaption(boolean)}
   */
  @Test
  void testSetCaption() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaption(true);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertTrue(pdAnnotationLine.hasCaption());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaption(boolean)}
   */
  @Test
  void testSetCaption2() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaption(false);

    // Assert
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
    assertFalse(pdAnnotationLine.hasCaption());
  }

  /**
   * Method under test: {@link PDAnnotationLine#hasCaption()}
   */
  @Test
  void testHasCaption() {
    // Arrange, Act and Assert
    assertFalse((new PDAnnotationLine()).hasCaption());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getLeaderLineLength()}
   */
  @Test
  void testGetLeaderLineLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDAnnotationLine()).getLeaderLineLength());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setLeaderLineLength(float)}
   */
  @Test
  void testSetLeaderLineLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getLeaderLineExtensionLength()}
   */
  @Test
  void testGetLeaderLineExtensionLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDAnnotationLine()).getLeaderLineExtensionLength());
  }

  /**
   * Method under test:
   * {@link PDAnnotationLine#setLeaderLineExtensionLength(float)}
   */
  @Test
  void testSetLeaderLineExtensionLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineExtensionLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineExtensionLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getLeaderLineOffsetLength()}
   */
  @Test
  void testGetLeaderLineOffsetLength() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDAnnotationLine()).getLeaderLineOffsetLength());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setLeaderLineOffsetLength(float)}
   */
  @Test
  void testSetLeaderLineOffsetLength() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setLeaderLineOffsetLength(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getLeaderLineOffsetLength());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getCaptionPositioning()}
   */
  @Test
  void testGetCaptionPositioning() {
    // Arrange, Act and Assert
    assertNull((new PDAnnotationLine()).getCaptionPositioning());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaptionPositioning(String)}
   */
  @Test
  void testSetCaptionPositioning() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionPositioning("Caption Positioning");

    // Assert
    assertEquals("Caption Positioning", pdAnnotationLine.getCaptionPositioning());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaptionPositioning(String)}
   */
  @Test
  void testSetCaptionPositioning2() {
    // Arrange
    COSDictionary field = new COSDictionary();
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);

    // Act
    pdAnnotationLine.setCaptionPositioning("Caption Positioning");

    // Assert
    assertEquals("Caption Positioning", pdAnnotationLine.getCaptionPositioning());
    assertSame(field, pdAnnotationLine.getCOSObject());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaptionHorizontalOffset(float)}
   */
  @Test
  void testSetCaptionHorizontalOffset() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionHorizontalOffset(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getCaptionHorizontalOffset());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getCaptionHorizontalOffset()}
   */
  @Test
  void testGetCaptionHorizontalOffset() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDAnnotationLine()).getCaptionHorizontalOffset());
  }

  /**
   * Method under test: {@link PDAnnotationLine#setCaptionVerticalOffset(float)}
   */
  @Test
  void testSetCaptionVerticalOffset() {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();

    // Act
    pdAnnotationLine.setCaptionVerticalOffset(10.0f);

    // Assert
    assertEquals(10.0f, pdAnnotationLine.getCaptionVerticalOffset());
    COSDictionary cOSObject = pdAnnotationLine.getCOSObject();
    assertEquals(4, cOSObject.getValues().size());
    assertEquals(4, cOSObject.size());
  }

  /**
   * Method under test: {@link PDAnnotationLine#getCaptionVerticalOffset()}
   */
  @Test
  void testGetCaptionVerticalOffset() {
    // Arrange, Act and Assert
    assertEquals(0.0f, (new PDAnnotationLine()).getCaptionVerticalOffset());
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(new COSArray());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances2() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances3() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.getObject(anyInt())).thenReturn(COSBoolean.FALSE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray).getObject(eq(0));
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances4() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances5() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(true);
    when(cosArray.getUpdateState()).thenReturn(new COSUpdateState(new COSArray()));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).getUpdateState();
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances6() {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.toFloatArray()).thenReturn(new float[]{10.0f, 0.5f, 10.0f, 0.5f});
    when(cosArray.getObject(anyInt())).thenReturn(COSFloat.ONE);
    when(cosArray.size()).thenReturn(4);
    when(cosArray.isDirect()).thenReturn(false);
    when(cosArray.getKey()).thenReturn(new COSObjectKey(1L, 1));
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(cosArray);

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(cosArray, atLeast(1)).getObject(anyInt());
    verify(cosArray).size();
    verify(cosArray).toFloatArray();
    verify(cosArray, atLeast(1)).getKey();
    verify(cosArray).isDirect();
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances7() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances8() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances9() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSBoolean.FALSE);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances10() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances11() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSName.A);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances12() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSArray());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances13() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add((COSBase) new COSDictionary());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances14() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSInteger.ONE);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances15() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add(COSName.A);
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances16() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSArray());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances()}
   */
  @Test
  void testConstructAppearances17() {
    // Arrange
    PDRectangle rectangle = mock(PDRectangle.class);
    when(rectangle.getCOSArray()).thenReturn(mock(COSArray.class));

    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    cosArray.add((COSBase) new COSDictionary());
    COSDictionary field = mock(COSDictionary.class);
    when(field.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);
    when(field.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);
    doNothing().when(field).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(field);
    pdAnnotationLine.setRectangle(rectangle);

    // Act
    pdAnnotationLine.constructAppearances();

    // Assert
    verify(field).getCOSArray(isA(COSName.class));
    verify(field).getDictionaryObject(isA(COSName.class));
    verify(field).setItem(isA(COSName.class), isA(COSBase.class));
    verify(rectangle).getCOSArray();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances18() throws IOException {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances19() throws IOException {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine();
    pdAnnotationLine.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }

  /**
   * Method under test: {@link PDAnnotationLine#constructAppearances(PDDocument)}
   */
  @Test
  void testConstructAppearances20() throws IOException {
    // Arrange
    PDAnnotationLine pdAnnotationLine = new PDAnnotationLine(new COSDictionary());
    pdAnnotationLine.setRectangle(PDRectangle.A0);
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    pdAnnotationLine.constructAppearances(new PDDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
  }
}
