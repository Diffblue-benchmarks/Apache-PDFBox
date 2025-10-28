package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Paint;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.Test;

class PDShadingType2DiffblueTest {
  /**
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  void testGetExtend() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getExtend());
  }

  /**
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  void testGetExtend2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newExtend = new COSArray();
    pdShadingType2.setExtend(newExtend);

    // Act
    COSArray actualExtend = pdShadingType2.getExtend();

    // Assert
    assertTrue(actualExtend.toList().isEmpty());
    assertSame(newExtend, actualExtend);
  }

  /**
   * Method under test: {@link PDShadingType2#getExtend()}
   */
  @Test
  void testGetExtend3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newExtend = new COSArray();
    newExtend.add(object);

    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    pdShadingType2.setExtend(newExtend);

    // Act
    COSArray actualExtend = pdShadingType2.getExtend();

    // Assert
    verify(object).getCOSObject();
    assertSame(newExtend, actualExtend);
  }

  /**
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  void testSetExtend() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSArray newExtend = new COSArray();

    // Act
    pdShadingType2.setExtend(newExtend);

    // Assert
    assertSame(newExtend, pdShadingType2.getExtend());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  void testSetExtend2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);

    // Act
    pdShadingType2.setExtend(null);

    // Assert
    assertNull(pdShadingType2.getExtend());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setExtend(COSArray)}
   */
  @Test
  void testSetExtend3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newExtend = new COSArray();
    newExtend.add(object);

    // Act
    pdShadingType2.setExtend(newExtend);

    // Assert
    verify(object).getCOSObject();
    assertSame(newExtend, pdShadingType2.getExtend());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  void testGetDomain() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getDomain());
  }

  /**
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  void testGetDomain2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newDomain = new COSArray();
    pdShadingType2.setDomain(newDomain);

    // Act
    COSArray actualDomain = pdShadingType2.getDomain();

    // Assert
    assertTrue(actualDomain.toList().isEmpty());
    assertSame(newDomain, actualDomain);
  }

  /**
   * Method under test: {@link PDShadingType2#getDomain()}
   */
  @Test
  void testGetDomain3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newDomain = new COSArray();
    newDomain.add(object);

    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    pdShadingType2.setDomain(newDomain);

    // Act
    COSArray actualDomain = pdShadingType2.getDomain();

    // Assert
    verify(object).getCOSObject();
    assertSame(newDomain, actualDomain);
  }

  /**
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  void testSetDomain() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSArray newDomain = new COSArray();

    // Act
    pdShadingType2.setDomain(newDomain);

    // Assert
    assertSame(newDomain, pdShadingType2.getDomain());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  void testSetDomain2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);

    // Act
    pdShadingType2.setDomain(null);

    // Assert
    assertNull(pdShadingType2.getDomain());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setDomain(COSArray)}
   */
  @Test
  void testSetDomain3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newDomain = new COSArray();
    newDomain.add(object);

    // Act
    pdShadingType2.setDomain(newDomain);

    // Assert
    verify(object).getCOSObject();
    assertSame(newDomain, pdShadingType2.getDomain());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  void testGetCoords() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType2(new COSDictionary())).getCoords());
  }

  /**
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  void testGetCoords2() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    COSArray newCoords = new COSArray();
    pdShadingType2.setCoords(newCoords);

    // Act
    COSArray actualCoords = pdShadingType2.getCoords();

    // Assert
    assertTrue(actualCoords.toList().isEmpty());
    assertSame(newCoords, actualCoords);
  }

  /**
   * Method under test: {@link PDShadingType2#getCoords()}
   */
  @Test
  void testGetCoords3() {
    // Arrange
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newCoords = new COSArray();
    newCoords.add(object);

    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    pdShadingType2.setCoords(newCoords);

    // Act
    COSArray actualCoords = pdShadingType2.getCoords();

    // Assert
    verify(object).getCOSObject();
    assertSame(newCoords, actualCoords);
  }

  /**
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  void testSetCoords() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSArray newCoords = new COSArray();

    // Act
    pdShadingType2.setCoords(newCoords);

    // Assert
    assertSame(newCoords, pdShadingType2.getCoords());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  void testSetCoords2() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);

    // Act
    pdShadingType2.setCoords(null);

    // Assert
    assertNull(pdShadingType2.getCoords());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#setCoords(COSArray)}
   */
  @Test
  void testSetCoords3() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();
    PDShadingType2 pdShadingType2 = new PDShadingType2(shadingDictionary);
    COSObjectable object = mock(COSObjectable.class);
    when(object.getCOSObject()).thenReturn(COSBoolean.FALSE);

    COSArray newCoords = new COSArray();
    newCoords.add(object);

    // Act
    pdShadingType2.setCoords(newCoords);

    // Assert
    verify(object).getCOSObject();
    assertSame(newCoords, pdShadingType2.getCoords());
    assertSame(shadingDictionary, pdShadingType2.getCOSObject());
  }

  /**
   * Method under test: {@link PDShadingType2#toPaint(Matrix)}
   */
  @Test
  void testToPaint() {
    // Arrange
    PDShadingType2 pdShadingType2 = new PDShadingType2(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType2.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof AxialShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType2, ((AxialShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((AxialShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Method under test: {@link PDShadingType2#toPaint(Matrix)}
   */
  @Test
  void testToPaint2() {
    // Arrange
    PDShadingType3 pdShadingType3 = new PDShadingType3(new COSDictionary());
    Matrix matrix = new Matrix();

    // Act
    Paint actualToPaintResult = pdShadingType3.toPaint(matrix);

    // Assert
    assertTrue(actualToPaintResult instanceof RadialShadingPaint);
    assertEquals(0, actualToPaintResult.getTransparency());
    assertSame(pdShadingType3, ((RadialShadingPaint) actualToPaintResult).getShading());
    assertSame(matrix, ((RadialShadingPaint) actualToPaintResult).getMatrix());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PDShadingType2#PDShadingType2(COSDictionary)}
   *   <li>{@link PDShadingType2#getShadingType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act
    PDShadingType2 actualPdShadingType2 = new PDShadingType2(shadingDictionary);

    // Assert
    assertEquals(2, actualPdShadingType2.getShadingType());
    assertSame(shadingDictionary, actualPdShadingType2.getCOSObject());
  }
}
