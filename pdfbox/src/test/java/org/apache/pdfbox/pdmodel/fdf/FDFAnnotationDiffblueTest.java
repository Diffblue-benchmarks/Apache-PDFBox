package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.io.RandomAccessStreamCache;
import org.apache.pdfbox.io.RandomAccessStreamCacheImpl;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDLineDashPattern;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFAnnotationDiffblueTest {
  /**
   * Method under test: {@link FDFAnnotation#create(COSDictionary)}
   */
  @Test
  void testCreate() {
    // Arrange, Act and Assert
    assertNull(FDFAnnotation.create(new COSDictionary()));
    assertNull(FDFAnnotation.create(null));
  }

  /**
   * Method under test: {@link FDFAnnotation#getCOSObject()}
   */
  @Test
  void testGetCOSObject() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertSame(fdfAnnotationCaret.annot, fdfAnnotationCaret.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotation#getPage()}
   */
  @Test
  void testGetPage() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getPage());
  }

  /**
   * Method under test: {@link FDFAnnotation#getPage()}
   */
  @Test
  void testGetPage2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPage(1);

    // Act and Assert
    assertEquals(1, fdfAnnotationCaret.getPage().intValue());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPage(int)}
   */
  @Test
  void testSetPage() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPage(1);

    // Assert
    assertEquals(1, fdfAnnotationCaret.getPage().intValue());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPage(int)}
   */
  @Test
  void testSetPage2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPage(-1901805651);

    // Assert
    assertEquals(-1901805651, fdfAnnotationCaret.getPage().intValue());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getColor()}
   */
  @Test
  void testGetColor() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getColor());
  }

  /**
   * Method under test: {@link FDFAnnotation#getColor()}
   */
  @Test
  void testGetColor2() throws NumberFormatException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    Color c = Color.decode("42");
    fdfAnnotationCaret.setColor(c);

    // Act and Assert
    assertEquals(c, fdfAnnotationCaret.getColor());
  }

  /**
   * Method under test: {@link FDFAnnotation#setColor(Color)}
   */
  @Test
  void testSetColor() throws NumberFormatException {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret(a);

    // Act
    fdfAnnotationCaret.setColor(Color.decode("42"));

    // Assert
    verify(a).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  void testGetDate() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getDate());
  }

  /**
   * Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  void testGetDate2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setDate("2020-03-01");

    // Act and Assert
    assertEquals("2020-03-01", fdfAnnotationCaret.getDate());
  }

  /**
   * Method under test: {@link FDFAnnotation#getDate()}
   */
  @Test
  void testGetDate3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setDate("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getDate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setDate(String)}
   */
  @Test
  void testSetDate() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setDate("2020-03-01");

    // Assert
    assertEquals("2020-03-01", fdfAnnotationCaret.getDate());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#isInvisible()}
   */
  @Test
  void testIsInvisible() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#isInvisible()}
   */
  @Test
  void testIsInvisible2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setInvisible(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setHidden(true);

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#setInvisible(boolean)}
   */
  @Test
  void testSetInvisible4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setInvisible(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isInvisible());
  }

  /**
   * Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  void testIsHidden() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  void testIsHidden2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#isHidden()}
   */
  @Test
  void testIsHidden3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setHidden(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setHidden(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#setHidden(boolean)}
   */
  @Test
  void testSetHidden5() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoRotate(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setHidden(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isHidden());
  }

  /**
   * Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  void testIsPrinted() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  void testIsPrinted2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#isPrinted()}
   */
  @Test
  void testIsPrinted3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPrinted(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setPrinted(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#setPrinted(boolean)}
   */
  @Test
  void testSetPrinted4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setPrinted(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isPrinted());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  void testIsNoZoom() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  void testIsNoZoom2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoZoom()}
   */
  @Test
  void testIsNoZoom3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoZoom(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoZoom(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoZoom(boolean)}
   */
  @Test
  void testSetNoZoom4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoZoom(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoZoom());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  void testIsNoRotate() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  void testIsNoRotate2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoRotate()}
   */
  @Test
  void testIsNoRotate3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoRotate(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoRotate(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoRotate(boolean)}
   */
  @Test
  void testSetNoRotate4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoRotate(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoRotate());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  void testIsNoView() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  void testIsNoView2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isNoView()}
   */
  @Test
  void testIsNoView3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoView(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setNoView(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setNoView(boolean)}
   */
  @Test
  void testSetNoView5() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setNoZoom(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  void testIsReadOnly() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  void testIsReadOnly2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#isReadOnly()}
   */
  @Test
  void testIsReadOnly3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setReadOnly(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setReadOnly(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#setReadOnly(boolean)}
   */
  @Test
  void testSetReadOnly4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setReadOnly(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isReadOnly());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  void testIsLocked() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  void testIsLocked2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLocked()}
   */
  @Test
  void testIsLocked3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setLocked(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLocked(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked4() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLocked(boolean)}
   */
  @Test
  void testSetLocked5() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setPrinted(true);
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLocked(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLocked());
  }

  /**
   * Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  void testIsToggleNoView() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  void testIsToggleNoView2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isToggleNoView()}
   */
  @Test
  void testIsToggleNoView3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setToggleNoView(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  void testSetToggleNoView() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setToggleNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  void testSetToggleNoView2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setToggleNoView(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#setToggleNoView(boolean)}
   */
  @Test
  void testSetToggleNoView3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setToggleNoView(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isToggleNoView());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  void testIsLockedContents() {
    // Arrange, Act and Assert
    assertFalse((new FDFAnnotationCaret()).isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  void testIsLockedContents2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act and Assert
    assertFalse(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#isLockedContents()}
   */
  @Test
  void testIsLockedContents3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setLockedContents(true);

    // Act and Assert
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  void testSetLockedContents() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  void testSetLockedContents2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setLockedContents(false);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertFalse(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setLockedContents(boolean)}
   */
  @Test
  void testSetLockedContents3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setInvisible(true);

    // Act
    fdfAnnotationCaret.setLockedContents(true);

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertTrue(fdfAnnotationCaret.isLockedContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setName(String)}
   */
  @Test
  void testSetName() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setName("Name");

    // Assert
    assertEquals("Name", fdfAnnotationCaret.getName());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  void testGetName() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getName());
  }

  /**
   * Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  void testGetName2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setName("Name");

    // Act and Assert
    assertEquals("Name", fdfAnnotationCaret.getName());
  }

  /**
   * Method under test: {@link FDFAnnotation#getName()}
   */
  @Test
  void testGetName3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setName("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getName());
  }

  /**
   * Method under test: {@link FDFAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  void testSetRectangle() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRectangle(PDRectangle.A0);

    // Assert
    PDRectangle rectangle = fdfAnnotationCaret.getRectangle();
    assertEquals(0.0f, rectangle.getLowerLeftX());
    assertEquals(0.0f, rectangle.getLowerLeftY());
    assertEquals(2383.937f, rectangle.getUpperRightX());
    assertEquals(2383.937f, rectangle.getWidth());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3370.3938f, rectangle.getHeight());
    assertEquals(3370.3938f, rectangle.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray expectedCOSObject = rectangle.getCOSArray();
    assertSame(expectedCOSObject, rectangle.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotation#setRectangle(PDRectangle)}
   */
  @Test
  void testSetRectangle2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRectangle(null);

    // Assert
    assertNull(fdfAnnotationCaret.getRectangle());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getRectangle());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRectangle(PDRectangle.A0);

    // Act
    PDRectangle actualRectangle = fdfAnnotationCaret.getRectangle();

    // Assert
    COSArray cOSArray = actualRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult4.getKey());
    assertEquals(0.0f, actualRectangle.getLowerLeftX());
    assertEquals(0.0f, actualRectangle.getLowerLeftY());
    assertEquals(2383.937f, actualRectangle.getUpperRightX());
    assertEquals(2383.937f, actualRectangle.getWidth());
    assertEquals(3370.3938f, actualRectangle.getHeight());
    assertEquals(3370.3938f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRectangle()}
   */
  @Test
  void testGetRectangle3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRectangle(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualRectangle = fdfAnnotationCaret.getRectangle();

    // Assert
    COSArray cOSArray = actualRectangle.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(1);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(2);
    assertTrue(getResult3 instanceof COSFloat);
    COSBase getResult4 = toListResult.get(3);
    assertTrue(getResult4 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.0f, actualRectangle.getHeight());
    assertEquals(0.0f, actualRectangle.getWidth());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftX());
    assertEquals(2.14748365E9f, actualRectangle.getLowerLeftY());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightX());
    assertEquals(2.14748365E9f, actualRectangle.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualRectangle.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotation#setContents(String)}
   */
  @Test
  void testSetContents() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setContents("Not all who wander are lost");

    // Assert
    assertEquals("Not all who wander are lost", fdfAnnotationCaret.getContents());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  void testGetContents() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  void testGetContents2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setContents("Not all who wander are lost");

    // Act and Assert
    assertEquals("Not all who wander are lost", fdfAnnotationCaret.getContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#getContents()}
   */
  @Test
  void testGetContents3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setContents("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setTitle(String)}
   */
  @Test
  void testSetTitle() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setTitle("Dr");

    // Assert
    assertEquals("Dr", fdfAnnotationCaret.getTitle());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getTitle());
  }

  /**
   * Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  void testGetTitle2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setTitle("Dr");

    // Act and Assert
    assertEquals("Dr", fdfAnnotationCaret.getTitle());
  }

  /**
   * Method under test: {@link FDFAnnotation#getTitle()}
   */
  @Test
  void testGetTitle3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setTitle("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getTitle());
  }

  /**
   * Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  void testGetCreationDate() throws IOException {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getCreationDate());
  }

  /**
   * Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  void testGetCreationDate2() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Act
    Calendar actualCreationDate = fdfAnnotationCaret.getCreationDate();

    // Assert
    assertTrue(actualCreationDate instanceof GregorianCalendar);
    assertEquals("gregory", actualCreationDate.getCalendarType());
    assertEquals(0, actualCreationDate.getTimeZone().getDSTSavings());
    assertEquals(1, actualCreationDate.getFirstDayOfWeek());
    assertEquals(1, actualCreationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, actualCreationDate.getWeekYear());
    assertEquals(53, actualCreationDate.getWeeksInWeekYear());
    assertFalse(actualCreationDate.isLenient());
    assertTrue(actualCreationDate.isWeekDateSupported());
  }

  /**
   * Method under test: {@link FDFAnnotation#getCreationDate()}
   */
  @Test
  void testGetCreationDate3() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setCreationDate(new GregorianCalendar(Integer.MIN_VALUE, 1, 1));

    // Act and Assert
    assertNull(fdfAnnotationCaret.getCreationDate());
  }

  /**
   * Method under test: {@link FDFAnnotation#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setCreationDate(new GregorianCalendar(1, 1, 1));

    // Assert
    Calendar creationDate = fdfAnnotationCaret.getCreationDate();
    assertTrue(creationDate instanceof GregorianCalendar);
    assertEquals("gregory", creationDate.getCalendarType());
    assertEquals(0, creationDate.getTimeZone().getDSTSavings());
    assertEquals(1, creationDate.getFirstDayOfWeek());
    assertEquals(1, creationDate.getMinimalDaysInFirstWeek());
    assertEquals(1, creationDate.getWeekYear());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(53, creationDate.getWeeksInWeekYear());
    assertFalse(creationDate.isLenient());
    assertTrue(creationDate.isWeekDateSupported());
  }

  /**
   * Method under test: {@link FDFAnnotation#setCreationDate(Calendar)}
   */
  @Test
  void testSetCreationDate2() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setCreationDate(null);

    // Assert
    assertNull(fdfAnnotationCaret.getCreationDate());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#setOpacity(float)}
   */
  @Test
  void testSetOpacity() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setOpacity(10.0f);

    // Assert
    assertEquals(10.0f, fdfAnnotationCaret.getOpacity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getOpacity()}
   */
  @Test
  void testGetOpacity() {
    // Arrange, Act and Assert
    assertEquals(1.0f, (new FDFAnnotationCaret()).getOpacity());
  }

  /**
   * Method under test: {@link FDFAnnotation#getOpacity()}
   */
  @Test
  void testGetOpacity2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setOpacity(1.0f);

    // Act and Assert
    assertEquals(1.0f, fdfAnnotationCaret.getOpacity());
  }

  /**
   * Method under test: {@link FDFAnnotation#setSubject(String)}
   */
  @Test
  void testSetSubject() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSubject("Hello from the Dreaming Spires");

    // Assert
    assertEquals("Hello from the Dreaming Spires", fdfAnnotationCaret.getSubject());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  void testGetSubject() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getSubject());
  }

  /**
   * Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  void testGetSubject2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSubject("Hello from the Dreaming Spires");

    // Act and Assert
    assertEquals("Hello from the Dreaming Spires", fdfAnnotationCaret.getSubject());
  }

  /**
   * Method under test: {@link FDFAnnotation#getSubject()}
   */
  @Test
  void testGetSubject3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSubject("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getSubject());
  }

  /**
   * Method under test: {@link FDFAnnotation#setIntent(String)}
   */
  @Test
  void testSetIntent() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setIntent("Intent");

    // Assert
    assertEquals("Intent", fdfAnnotationCaret.getIntent());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#setIntent(String)}
   */
  @Test
  void testSetIntent2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setIntent("42");

    // Assert
    assertEquals("42", fdfAnnotationCaret.getIntent());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getIntent()}
   */
  @Test
  void testGetIntent() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getIntent());
  }

  /**
   * Method under test: {@link FDFAnnotation#getIntent()}
   */
  @Test
  void testGetIntent2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setIntent("Intent");

    // Act and Assert
    assertEquals("Intent", fdfAnnotationCaret.getIntent());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  void testGetRichContents() {
    // Arrange, Act and Assert
    assertEquals("", (new FDFAnnotationCaret()).getRichContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  void testGetRichContents2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRichContents("Rc");

    // Act and Assert
    assertEquals("Rc", fdfAnnotationCaret.getRichContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#getRichContents()}
   */
  @Test
  void testGetRichContents3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setRichContents("");

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getRichContents());
  }

  /**
   * Method under test: {@link FDFAnnotation#setRichContents(String)}
   */
  @Test
  void testSetRichContents() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setRichContents("Rc");

    // Assert
    assertEquals("Rc", fdfAnnotationCaret.getRichContents());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderStyle(new PDBorderStyleDictionary());

    // Assert
    PDBorderStyleDictionary borderStyle = fdfAnnotationCaret.getBorderStyle();
    PDLineDashPattern dashStyle = borderStyle.getDashStyle();
    COSBase cOSObject = dashStyle.getCOSObject();
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSArray);
    assertTrue(cOSObject instanceof COSArray);
    assertEquals(0, dashStyle.getPhase());
    assertEquals(1.0f, borderStyle.getWidth());
    COSDictionary cOSObject2 = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject2.getValues().size());
    assertEquals(3, cOSObject2.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, borderStyle.getStyle());
    assertArrayEquals(new float[]{3.0f}, dashStyle.getDashArray(), 0.0f);
  }

  /**
   * Method under test:
   * {@link FDFAnnotation#setBorderStyle(PDBorderStyleDictionary)}
   */
  @Test
  void testSetBorderStyle2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderStyle(null);

    // Assert
    assertNull(fdfAnnotationCaret.getBorderStyle());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getBorderStyle()}
   */
  @Test
  void testGetBorderStyle() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getBorderStyle());
  }

  /**
   * Method under test:
   * {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary());

    // Assert
    PDBorderEffectDictionary borderEffect = fdfAnnotationCaret.getBorderEffect();
    assertEquals(0.0f, borderEffect.getIntensity());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, borderEffect.getStyle());
  }

  /**
   * Method under test:
   * {@link FDFAnnotation#setBorderEffect(PDBorderEffectDictionary)}
   */
  @Test
  void testSetBorderEffect2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setBorderEffect(null);

    // Assert
    assertNull(fdfAnnotationCaret.getBorderEffect());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotation#getBorderEffect()}
   */
  @Test
  void testGetBorderEffect() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getBorderEffect());
  }

  /**
   * Method under test: {@link FDFAnnotation#getBorderEffect()}
   */
  @Test
  void testGetBorderEffect2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setBorderEffect(new PDBorderEffectDictionary());

    // Act
    PDBorderEffectDictionary actualBorderEffect = fdfAnnotationCaret.getBorderEffect();

    // Assert
    COSDictionary cOSObject = actualBorderEffect.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertEquals(0, cOSObject.size());
    assertEquals(0.0f, actualBorderEffect.getIntensity());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_SMALLER, actualBorderEffect.getStyle());
  }

  /**
   * Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream() {
    // Arrange, Act and Assert
    assertEquals("", (new FDFAnnotationCaret()).getStringOrStream(COSBoolean.FALSE));
    assertEquals("", (new FDFAnnotationCaret()).getStringOrStream(null));
  }

  /**
   * Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream2() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertEquals("\u0001#Eg›«Íï", fdfAnnotationCaret.getStringOrStream(COSString.parseHex("0123456789ABCDEF")));
  }

  /**
   * Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertEquals("", fdfAnnotationCaret.getStringOrStream(new COSStream()));
  }

  /**
   * Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream4() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_OPTION_ONLY_WHEN_ICON_IS_BIGGER,
        fdfAnnotationCaret.getStringOrStream(COSString.parseHex("42")));
  }

  /**
   * Method under test: {@link FDFAnnotation#getStringOrStream(COSBase)}
   */
  @Test
  void testGetStringOrStream5() throws IOException {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    RandomAccessStreamCache.StreamCacheCreateFunction streamCacheCreateFunction = mock(
        RandomAccessStreamCache.StreamCacheCreateFunction.class);
    when(streamCacheCreateFunction.create()).thenReturn(new RandomAccessStreamCacheImpl());

    // Act
    String actualStringOrStream = fdfAnnotationCaret.getStringOrStream(new COSDocument(streamCacheCreateFunction));

    // Assert
    verify(streamCacheCreateFunction).create();
    assertEquals("", actualStringOrStream);
  }
}
