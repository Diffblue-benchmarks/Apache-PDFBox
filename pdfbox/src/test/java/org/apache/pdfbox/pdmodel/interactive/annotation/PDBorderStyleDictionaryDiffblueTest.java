package org.apache.pdfbox.pdmodel.interactive.annotation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.junit.jupiter.api.Test;

class PDBorderStyleDictionaryDiffblueTest {
  /**
   * Method under test: {@link PDBorderStyleDictionary#setWidth(float)}
   */
  @Test
  void testSetWidth() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary(dict);

    // Act
    pdBorderStyleDictionary.setWidth(10.0f);

    // Assert
    assertEquals(10.0f, pdBorderStyleDictionary.getWidth());
    assertSame(dict, pdBorderStyleDictionary.getCOSObject());
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#getWidth()}
   */
  @Test
  void testGetWidth() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new PDBorderStyleDictionary()).getWidth());
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#setStyle(String)}
   */
  @Test
  void testSetStyle() {
    // Arrange
    COSDictionary dict = new COSDictionary();
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary(dict);

    // Act
    pdBorderStyleDictionary.setStyle("foo");

    // Assert
    assertEquals("foo", pdBorderStyleDictionary.getStyle());
    assertSame(dict, pdBorderStyleDictionary.getCOSObject());
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#getStyle()}
   */
  @Test
  void testGetStyle() {
    // Arrange, Act and Assert
    assertEquals(PDBorderStyleDictionary.STYLE_SOLID, (new PDBorderStyleDictionary()).getStyle());
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  void testSetDashStyle() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Act
    pdBorderStyleDictionary.setDashStyle(new COSArray());

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getDashArray().length);
    assertTrue(((COSArray) getResult).toList().isEmpty());
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  void testSetDashStyle2() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();

    // Act
    pdBorderStyleDictionary.setDashStyle(null);

    // Assert
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(1, ((COSArray) getResult).toList().size());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test: {@link PDBorderStyleDictionary#setDashStyle(COSArray)}
   */
  @Test
  void testSetDashStyle3() {
    // Arrange
    PDBorderStyleDictionary pdBorderStyleDictionary = new PDBorderStyleDictionary();
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray dashArray = new COSArray();
    dashArray.add(object);

    // Act
    pdBorderStyleDictionary.setDashStyle(dashArray);

    // Assert
    verify(object).getCOSObject();
    PDLineDashPattern dashStyle = pdBorderStyleDictionary.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(1, ((COSArray) getResult).toList().size());
    assertArrayEquals(new float[]{0.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link PDBorderStyleDictionary#PDBorderStyleDictionary(COSDictionary)}
   */
  @Test
  void testNewPDBorderStyleDictionary() {
    // Arrange
    COSDictionary dict = new COSDictionary();

    // Act and Assert
    assertSame(dict, (new PDBorderStyleDictionary(dict)).getCOSObject());
  }
}
