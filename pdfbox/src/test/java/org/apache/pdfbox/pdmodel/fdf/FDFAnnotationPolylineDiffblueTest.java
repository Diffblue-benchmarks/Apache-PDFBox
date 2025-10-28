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
import java.awt.Color;
import java.io.IOException;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FDFAnnotationPolylineDiffblueTest {
  /**
   * Method under test: {@link FDFAnnotationPolyline#setVertices(float[])}
   */
  @Test
  void testSetVertices() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Assert
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  void testGetVertices() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline()).getVertices());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getVertices()}
   */
  @Test
  void testGetVertices2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setVertices(new float[]{10.0f, 0.5f, 10.0f, 0.5f});

    // Act and Assert
    assertArrayEquals(new float[]{10.0f, 0.5f, 10.0f, 0.5f}, fdfAnnotationPolyline.getVertices(), 0.0f);
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle3() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setStartPointEndingStyle(String)}
   */
  @Test
  void testSetStartPointEndingStyle4() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setEndPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setStartPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getStartPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  void testGetStartPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline()).getStartPointEndingStyle());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getStartPointEndingStyle()}
   */
  @Test
  void testGetStartPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getStartPointEndingStyle());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(null);

    // Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle3() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle(",|;");

    // Assert
    assertEquals(",|;", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#setEndPointEndingStyle(String)}
   */
  @Test
  void testSetEndPointEndingStyle4() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act
    fdfAnnotationPolyline.setEndPointEndingStyle("Style");

    // Assert
    assertEquals("Style", fdfAnnotationPolyline.getEndPointEndingStyle());
    COSDictionary cOSObject = fdfAnnotationPolyline.getCOSObject();
    assertEquals(3, cOSObject.getValues().size());
    assertEquals(3, cOSObject.size());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  void testGetEndPointEndingStyle() {
    // Arrange, Act and Assert
    assertEquals("None", (new FDFAnnotationPolyline()).getEndPointEndingStyle());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getEndPointEndingStyle()}
   */
  @Test
  void testGetEndPointEndingStyle2() {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    fdfAnnotationPolyline.setStartPointEndingStyle("None");

    // Act and Assert
    assertEquals("None", fdfAnnotationPolyline.getEndPointEndingStyle());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#setInteriorColor(Color)}
   */
  @Test
  void testSetInteriorColor() throws NumberFormatException {
    // Arrange
    COSDictionary a = mock(COSDictionary.class);
    doNothing().when(a).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline(a);

    // Act
    fdfAnnotationPolyline.setInteriorColor(Color.decode("42"));

    // Assert
    verify(a).setItem(isA(COSName.class), isA(COSBase.class));
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor() {
    // Arrange, Act and Assert
    assertNull((new FDFAnnotationPolyline()).getInteriorColor());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#getInteriorColor()}
   */
  @Test
  void testGetInteriorColor2() throws NumberFormatException {
    // Arrange
    FDFAnnotationPolyline fdfAnnotationPolyline = new FDFAnnotationPolyline();
    Color color = Color.decode("42");
    fdfAnnotationPolyline.setInteriorColor(color);

    // Act and Assert
    assertEquals(color, fdfAnnotationPolyline.getInteriorColor());
  }

  /**
   * Method under test:
   * {@link FDFAnnotationPolyline#FDFAnnotationPolyline(COSDictionary)}
   */
  @Test
  void testNewFDFAnnotationPolyline() {
    // Arrange
    COSDictionary a = new COSDictionary();

    // Act and Assert
    assertSame(a, (new FDFAnnotationPolyline(a)).getCOSObject());
  }

  /**
   * Method under test: {@link FDFAnnotationPolyline#FDFAnnotationPolyline()}
   */
  @Test
  void testNewFDFAnnotationPolyline2() throws IOException {
    // Arrange and Act
    FDFAnnotationPolyline actualFdfAnnotationPolyline = new FDFAnnotationPolyline();

    // Assert
    assertEquals("", actualFdfAnnotationPolyline.getRichContents());
    assertEquals("None", actualFdfAnnotationPolyline.getEndPointEndingStyle());
    assertEquals("None", actualFdfAnnotationPolyline.getStartPointEndingStyle());
    assertNull(actualFdfAnnotationPolyline.getVertices());
    assertNull(actualFdfAnnotationPolyline.getColor());
    assertNull(actualFdfAnnotationPolyline.getInteriorColor());
    assertNull(actualFdfAnnotationPolyline.getPage());
    assertNull(actualFdfAnnotationPolyline.getContents());
    assertNull(actualFdfAnnotationPolyline.getDate());
    assertNull(actualFdfAnnotationPolyline.getIntent());
    assertNull(actualFdfAnnotationPolyline.getName());
    assertNull(actualFdfAnnotationPolyline.getSubject());
    assertNull(actualFdfAnnotationPolyline.getTitle());
    assertNull(actualFdfAnnotationPolyline.getCreationDate());
    COSDictionary cOSObject = actualFdfAnnotationPolyline.getCOSObject();
    COSUpdateState updateState = cOSObject.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    assertNull(cOSObject.getKey());
    assertNull(actualFdfAnnotationPolyline.getRectangle());
    assertNull(actualFdfAnnotationPolyline.getBorderEffect());
    assertNull(actualFdfAnnotationPolyline.getBorderStyle());
    assertEquals(1.0f, actualFdfAnnotationPolyline.getOpacity());
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(cOSObject.isDirect());
    assertFalse(cOSObject.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(actualFdfAnnotationPolyline.isHidden());
    assertFalse(actualFdfAnnotationPolyline.isInvisible());
    assertFalse(actualFdfAnnotationPolyline.isLocked());
    assertFalse(actualFdfAnnotationPolyline.isLockedContents());
    assertFalse(actualFdfAnnotationPolyline.isNoRotate());
    assertFalse(actualFdfAnnotationPolyline.isNoView());
    assertFalse(actualFdfAnnotationPolyline.isNoZoom());
    assertFalse(actualFdfAnnotationPolyline.isPrinted());
    assertFalse(actualFdfAnnotationPolyline.isReadOnly());
    assertFalse(actualFdfAnnotationPolyline.isToggleNoView());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }
}
