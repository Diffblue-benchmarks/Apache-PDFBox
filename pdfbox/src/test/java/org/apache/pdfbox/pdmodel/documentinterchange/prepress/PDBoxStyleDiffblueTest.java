package org.apache.pdfbox.pdmodel.documentinterchange.prepress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDBoxStyleDiffblueTest {
  /**
   * Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  void testSetGuideLineColor() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSBoolean.FALSE);

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link PDBoxStyle#setGuideLineColor(PDColor)}
   */
  @Test
  void testSetGuideLineColor2() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    array.add(COSName.A);

    // Act
    pdBoxStyle.setGuideLineColor(new PDColor(array, PDDeviceGray.INSTANCE));

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  void testGetGuidelineWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDBoxStyle()).getGuidelineWidth());
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  void testGetGuidelineWidth2() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineWidth(1.0f);

    // Act and Assert
    assertEquals(1.0f, pdBoxStyle.getGuidelineWidth());
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineWidth()}
   */
  @Test
  void testGetGuidelineWidth3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDColor color = new PDColor(array, PDDeviceGray.INSTANCE);

    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(color);

    // Act
    float actualGuidelineWidth = pdBoxStyle.getGuidelineWidth();

    // Assert
    verify(object).getCOSObject();
    assertEquals(1.0f, actualGuidelineWidth);
  }

  /**
   * Method under test: {@link PDBoxStyle#setGuidelineWidth(float)}
   */
  @Test
  void testSetGuidelineWidth() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setFloat(Mockito.<COSName>any(), anyFloat());

    // Act
    (new PDBoxStyle(dic)).setGuidelineWidth(10.0f);

    // Assert that nothing has changed
    verify(dic).setFloat(isA(COSName.class), eq(10.0f));
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  void testGetGuidelineStyle() {
    // Arrange, Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, (new PDBoxStyle()).getGuidelineStyle());
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  void testGetGuidelineStyle2() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuidelineStyle(PDBoxStyle.GUIDELINE_STYLE_SOLID);

    // Act and Assert
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, pdBoxStyle.getGuidelineStyle());
  }

  /**
   * Method under test: {@link PDBoxStyle#getGuidelineStyle()}
   */
  @Test
  void testGetGuidelineStyle3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray array = new COSArray();
    array.add(object);
    PDColor color = new PDColor(array, PDDeviceGray.INSTANCE);

    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    pdBoxStyle.setGuideLineColor(color);

    // Act
    String actualGuidelineStyle = pdBoxStyle.getGuidelineStyle();

    // Assert
    verify(object).getCOSObject();
    assertEquals(PDBoxStyle.GUIDELINE_STYLE_SOLID, actualGuidelineStyle);
  }

  /**
   * Method under test: {@link PDBoxStyle#setGuidelineStyle(String)}
   */
  @Test
  void testSetGuidelineStyle() {
    // Arrange
    COSDictionary dic = mock(COSDictionary.class);
    doNothing().when(dic).setName(Mockito.<COSName>any(), Mockito.<String>any());

    // Act
    (new PDBoxStyle(dic)).setGuidelineStyle("Style");

    // Assert that nothing has changed
    verify(dic).setName(isA(COSName.class), eq("Style"));
  }

  /**
   * Method under test: {@link PDBoxStyle#setLineDashPattern(COSArray)}
   */
  @Test
  void testSetLineDashPattern() {
    // Arrange
    PDBoxStyle pdBoxStyle = new PDBoxStyle();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray dashArray = new COSArray();
    dashArray.add(object);

    // Act
    pdBoxStyle.setLineDashPattern(dashArray);

    // Assert
    verify(object).getCOSObject();
  }

  /**
   * Method under test: {@link PDBoxStyle#PDBoxStyle(COSDictionary)}
   */
  @Test
  void testNewPDBoxStyle() {
    // Arrange
    COSDictionary dic = new COSDictionary();

    // Act and Assert
    assertSame(dic, (new PDBoxStyle(dic)).getCOSObject());
  }
}
