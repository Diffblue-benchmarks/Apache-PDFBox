package org.apache.pdfbox.pdmodel.fdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.junit.jupiter.api.Test;

class FDFAnnotationCaretDiffblueTest {
  /**
   * Method under test: {@link FDFAnnotationCaret#setFringe(PDRectangle)}
   */
  @Test
  void testSetFringe() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setFringe(PDRectangle.A0);

    // Assert
    PDRectangle fringe = fdfAnnotationCaret.getFringe();
    assertEquals(0.0f, fringe.getLowerLeftX());
    assertEquals(0.0f, fringe.getLowerLeftY());
    assertEquals(2383.937f, fringe.getUpperRightX());
    assertEquals(2383.937f, fringe.getWidth());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(3370.3938f, fringe.getHeight());
    assertEquals(3370.3938f, fringe.getUpperRightY());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    COSArray expectedCOSObject = fringe.getCOSArray();
    assertSame(expectedCOSObject, fringe.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#setFringe(PDRectangle)}
   */
  @Test
  void testSetFringe2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setFringe(null);

    // Assert
    assertNull(fdfAnnotationCaret.getFringe());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  void testGetFringe() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getFringe());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  void testGetFringe2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setFringe(PDRectangle.A0);

    // Act
    PDRectangle actualFringe = fdfAnnotationCaret.getFringe();

    // Assert
    COSArray cOSArray = actualFringe.getCOSArray();
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
    assertEquals(0.0f, actualFringe.getLowerLeftX());
    assertEquals(0.0f, actualFringe.getLowerLeftY());
    assertEquals(2383.937f, actualFringe.getUpperRightX());
    assertEquals(2383.937f, actualFringe.getWidth());
    assertEquals(3370.3938f, actualFringe.getHeight());
    assertEquals(3370.3938f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult4.isDirect());
    assertEquals(getResult, getResult2);
    assertSame(cOSArray, actualFringe.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getFringe()}
   */
  @Test
  void testGetFringe3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setFringe(new PDRectangle(2.14748365E9f, 2.14748365E9f, 2.14748365E9f, 2.14748365E9f));

    // Act
    PDRectangle actualFringe = fdfAnnotationCaret.getFringe();

    // Assert
    COSArray cOSArray = actualFringe.getCOSArray();
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
    assertEquals(0.0f, actualFringe.getHeight());
    assertEquals(0.0f, actualFringe.getWidth());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftX());
    assertEquals(2.14748365E9f, actualFringe.getLowerLeftY());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightX());
    assertEquals(2.14748365E9f, actualFringe.getUpperRightY());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
    assertEquals(getResult, getResult3);
    assertEquals(getResult, getResult4);
    assertSame(cOSArray, actualFringe.getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#setSymbol(String)}
   */
  @Test
  void testSetSymbol() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSymbol("Symbol");

    // Assert
    assertEquals("None", fdfAnnotationCaret.getSymbol());
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#setSymbol(String)}
   */
  @Test
  void testSetSymbol2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();

    // Act
    fdfAnnotationCaret.setSymbol("paragraph");

    // Assert
    COSDictionary cOSObject = fdfAnnotationCaret.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfAnnotationCaret.getSymbol());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  void testGetSymbol() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationCaret()).getSymbol());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  void testGetSymbol2() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSymbol("Symbol");

    // Act and Assert
    assertEquals("None", fdfAnnotationCaret.getSymbol());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#getSymbol()}
   */
  @Test
  void testGetSymbol3() {
    // Arrange
    FDFAnnotationCaret fdfAnnotationCaret = new FDFAnnotationCaret();
    fdfAnnotationCaret.setSymbol("paragraph");

    // Act and Assert
    assertEquals(FDFIconFit.SCALE_TYPE_PROPORTIONAL, fdfAnnotationCaret.getSymbol());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationCaret#FDFAnnotationCaret(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationCaret() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationCaret(a)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationCaret#FDFAnnotationCaret()}
   */
  @Test
  void testNewFDFAnnotationCaret2() throws IOException {
    // Arrange and Act
    FDFAnnotationCaret actualFdfAnnotationCaret = new FDFAnnotationCaret();

    // Assert
    assertEquals("", actualFdfAnnotationCaret.getRichContents());
    assertNull(actualFdfAnnotationCaret.getColor());
    assertNull(actualFdfAnnotationCaret.getPage());
    assertNull(actualFdfAnnotationCaret.getContents());
    assertNull(actualFdfAnnotationCaret.getDate());
    assertNull(actualFdfAnnotationCaret.getIntent());
    assertNull(actualFdfAnnotationCaret.getName());
    assertNull(actualFdfAnnotationCaret.getSubject());
    assertNull(actualFdfAnnotationCaret.getTitle());
    assertNull(actualFdfAnnotationCaret.getSymbol());
    assertNull(actualFdfAnnotationCaret.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationCaret.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationCaret.getRectangle());
    assertNull(actualFdfAnnotationCaret.getFringe());
    assertNull(actualFdfAnnotationCaret.getBorderEffect());
    assertNull(actualFdfAnnotationCaret.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationCaret.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationCaret.isHidden());
    assertFalse(actualFdfAnnotationCaret.isInvisible());
    assertFalse(actualFdfAnnotationCaret.isLocked());
    assertFalse(actualFdfAnnotationCaret.isLockedContents());
    assertFalse(actualFdfAnnotationCaret.isNoRotate());
    assertFalse(actualFdfAnnotationCaret.isNoView());
    assertFalse(actualFdfAnnotationCaret.isNoZoom());
    assertFalse(actualFdfAnnotationCaret.isPrinted());
    assertFalse(actualFdfAnnotationCaret.isReadOnly());
    assertFalse(actualFdfAnnotationCaret.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
