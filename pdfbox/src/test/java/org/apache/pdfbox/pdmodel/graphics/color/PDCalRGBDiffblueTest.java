package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSUpdateState;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCalRGBDiffblueTest {
  /**
   * Test {@link PDCalRGB#PDCalRGB()}.
   * <p>
   * Method under test: {@link PDCalRGB#PDCalRGB()}
   */
  @Test
  @DisplayName("Test new PDCalRGB()")
  void testNewPDCalRGB() {
    // Arrange and Act
    PDCalRGB actualPdCalRGB = new PDCalRGB();

    // Assert
    COSBase cOSObject = actualPdCalRGB.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus blackPoint = actualPdCalRGB.getBlackPoint();
    COSBase cOSObject2 = blackPoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDTristimulus whitepoint = actualPdCalRGB.getWhitepoint();
    COSBase cOSObject3 = whitepoint.getCOSObject();
    assertTrue(cOSObject3 instanceof COSArray);
    PDGamma gamma = actualPdCalRGB.getGamma();
    COSArray cOSArray = gamma.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    List<? extends COSBase> toListResult3 = ((COSArray) cOSObject).toList();
    assertEquals(2, toListResult3.size());
    COSBase getResult3 = toListResult3.get(0);
    assertTrue(getResult3 instanceof COSName);
    assertEquals("CalRGB", ((COSName) getResult3).getName());
    assertEquals("CalRGB", actualPdCalRGB.getName());
    COSDictionary cosDictionary = actualPdCalRGB.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdCalRGB.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult3.getKey());
    assertNull(getResult2.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdCalRGB.wpX);
    assertEquals(1.0f, actualPdCalRGB.wpY);
    assertEquals(1.0f, actualPdCalRGB.wpZ);
    assertEquals(3, actualPdCalRGB.getNumberOfComponents());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult3.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(((COSName) getResult3).isEmpty());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(toListResult, ((COSArray) cOSObject3).toList());
    assertSame(actualPdCalRGB, initialColor.getColorSpace());
    assertSame(cOSArray, gamma.getCOSObject());
    assertSame(actualPdCalRGB.dictionary, toListResult3.get(1));
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, actualPdCalRGB.getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#PDCalRGB(COSArray)}.
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then BlackPoint COSObject return {@link COSArray}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCalRGB#PDCalRGB(COSArray)}
   */
  @Test
  @DisplayName("Test new PDCalRGB(COSArray); given COSDictionary(); then BlackPoint COSObject return COSArray")
  void testNewPDCalRGB_givenCOSDictionary_thenBlackPointCOSObjectReturnCOSArray() {
    // Arrange
    COSArray rgb = mock(COSArray.class);
    when(rgb.getObject(anyInt())).thenReturn(new COSDictionary());

    // Act
    PDCalRGB actualPdCalRGB = new PDCalRGB(rgb);

    // Assert
    verify(rgb).getObject(eq(1));
    PDTristimulus blackPoint = actualPdCalRGB.getBlackPoint();
    COSBase cOSObject = blackPoint.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    PDTristimulus whitepoint = actualPdCalRGB.getWhitepoint();
    COSBase cOSObject2 = whitepoint.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    PDGamma gamma = actualPdCalRGB.getGamma();
    COSArray cOSArray = gamma.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult2.size());
    COSBase getResult2 = toListResult2.get(0);
    assertTrue(getResult2 instanceof COSFloat);
    assertEquals("CalRGB", actualPdCalRGB.getName());
    COSDictionary cosDictionary = actualPdCalRGB.dictionary;
    COSUpdateState updateState = cosDictionary.getUpdateState();
    assertNull(updateState.getOriginDocumentState());
    PDColor initialColor = actualPdCalRGB.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(getResult.getKey());
    assertNull(getResult2.getKey());
    assertNull(cosDictionary.getKey());
    assertEquals(0.0f, blackPoint.getX());
    assertEquals(0.0f, blackPoint.getY());
    assertEquals(0.0f, blackPoint.getZ());
    assertEquals(1, cosDictionary.getValues().size());
    assertEquals(1, cosDictionary.size());
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
    assertEquals(1.0f, whitepoint.getX());
    assertEquals(1.0f, whitepoint.getY());
    assertEquals(1.0f, whitepoint.getZ());
    assertEquals(1.0f, actualPdCalRGB.wpX);
    assertEquals(1.0f, actualPdCalRGB.wpY);
    assertEquals(1.0f, actualPdCalRGB.wpZ);
    assertEquals(3, actualPdCalRGB.getNumberOfComponents());
    COSIncrement toIncrementResult = cosDictionary.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertFalse(getResult.isDirect());
    assertFalse(getResult2.isDirect());
    assertFalse(cosDictionary.isDirect());
    assertFalse(cosDictionary.isNeedToBeUpdated());
    assertFalse(updateState.isUpdated());
    assertFalse(initialColor.isPattern());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertEquals(toListResult, ((COSArray) cOSObject2).toList());
    assertSame(actualPdCalRGB, initialColor.getColorSpace());
    assertSame(cOSArray, gamma.getCOSObject());
    assertSame(rgb, actualPdCalRGB.getCOSObject());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
    assertSame(getResult2, toListResult2.get(1));
    assertSame(getResult2, toListResult2.get(2));
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, initialColor.getComponents(), 0.0f);
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, actualPdCalRGB.getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#getName()}.
   * <p>
   * Method under test: {@link PDCalRGB#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalRGB", (new PDCalRGB()).getName());
  }

  /**
   * Test {@link PDCalRGB#getDefaultDecode(int)}.
   * <p>
   * Method under test: {@link PDCalRGB#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, (new PDCalRGB()).getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PDCalRGB#getInitialColor()}
   *   <li>{@link PDCalRGB#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    PDColor actualInitialColor = pdCalRGB.getInitialColor();
    int actualNumberOfComponents = pdCalRGB.getNumberOfComponents();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(3, actualNumberOfComponents);
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalRGB, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalRGB#toRGB(float[])}.
   * <p>
   * Method under test: {@link PDCalRGB#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  void testToRGB() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{0.0f, 0.0f, 0.0f}, (new PDCalRGB()).toRGB(new float[]{10.0f, 0.0f, 10.0f, 0.0f}),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#getGamma()}.
   * <p>
   * Method under test: {@link PDCalRGB#getGamma()}
   */
  @Test
  @DisplayName("Test getGamma()")
  void testGetGamma() {
    // Arrange and Act
    PDGamma actualGamma = (new PDCalRGB()).getGamma();

    // Assert
    COSArray cOSArray = actualGamma.getCOSArray();
    List<? extends COSBase> toListResult = cOSArray.toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualGamma.getB());
    assertEquals(1.0f, actualGamma.getG());
    assertEquals(1.0f, actualGamma.getR());
    assertFalse(getResult.isDirect());
    assertSame(cOSArray, actualGamma.getCOSObject());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDCalRGB#getMatrix()}.
   * <p>
   * Method under test: {@link PDCalRGB#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  void testGetMatrix() {
    // Arrange, Act and Assert
    assertArrayEquals(new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, (new PDCalRGB()).getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   * <p>
   * Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName("Test setGamma(PDGamma)")
  void testSetGamma() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    pdCalRGB.setGamma(new PDGamma());

    // Assert
    COSBase cOSObject = pdCalRGB.getWhitepoint().getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    COSBase getResult = toListResult.get(0);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    PDGamma gamma = pdCalRGB.getGamma();
    assertEquals(0.0f, gamma.getB());
    assertEquals(0.0f, gamma.getG());
    assertEquals(0.0f, gamma.getR());
    assertFalse(getResult.isDirect());
    assertSame(getResult, toListResult.get(1));
    assertSame(getResult, toListResult.get(2));
  }

  /**
   * Test {@link PDCalRGB#setMatrix(Matrix)}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)}
   * return {@code null}.</li>
   *   <li>Then calls {@link COSArray#getObject(int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDCalRGB#setMatrix(Matrix)}
   */
  @Test
  @DisplayName("Test setMatrix(Matrix); given COSDictionary getCOSArray(COSName) return 'null'; then calls getObject(int)")
  void testSetMatrix_givenCOSDictionaryGetCOSArrayReturnNull_thenCallsGetObject() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);
    doNothing().when(cosDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    COSArray rgb = mock(COSArray.class);
    when(rgb.getObject(anyInt())).thenReturn(cosDictionary);
    PDCalRGB pdCalRGB = new PDCalRGB(rgb);

    // Act
    pdCalRGB.setMatrix(new Matrix());

    // Assert
    verify(rgb).getObject(eq(1));
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }
}
