package org.apache.pdfbox.pdmodel.graphics.color;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDCalRGBDiffblueTest {
  /**
   * Test {@link PDCalRGB#PDCalRGB()}.
   *
   * <p>Method under test: {@link PDCalRGB#PDCalRGB()}
   */
  @Test
  @DisplayName("Test new PDCalRGB()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.<init>()"})
  void testNewPDCalRGB() {
    // Arrange and Act
    PDCalRGB actualPdCalRGB = new PDCalRGB();

    // Assert
    assertTrue(actualPdCalRGB.getCOSObject() instanceof COSArray);
    assertEquals("CalRGB", actualPdCalRGB.getName());
    assertEquals(1.0f, actualPdCalRGB.wpX);
    assertEquals(1.0f, actualPdCalRGB.wpY);
    assertEquals(1.0f, actualPdCalRGB.wpZ);
    assertEquals(3, actualPdCalRGB.getNumberOfComponents());
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        actualPdCalRGB.getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#PDCalRGB(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then return Name is {@code CalRGB}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#PDCalRGB(COSArray)}
   */
  @Test
  @DisplayName(
      "Test new PDCalRGB(COSArray); given COSDictionary getCOSArray(COSName) return 'null'; then return Name is 'CalRGB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.<init>(COSArray)"})
  void testNewPDCalRGB_givenCOSDictionaryGetCOSArrayReturnNull_thenReturnNameIsCalRGB() {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(null);

    COSArray rgb = mock(COSArray.class);
    when(rgb.getObject(anyInt())).thenReturn(cosDictionary);

    // Act
    PDCalRGB actualPdCalRGB = new PDCalRGB(rgb);

    // Assert
    verify(rgb).getObject(1);
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    assertEquals("CalRGB", actualPdCalRGB.getName());
    assertEquals(1.0f, actualPdCalRGB.wpX);
    assertEquals(1.0f, actualPdCalRGB.wpY);
    assertEquals(1.0f, actualPdCalRGB.wpZ);
    assertEquals(3, actualPdCalRGB.getNumberOfComponents());
    assertSame(rgb, actualPdCalRGB.getCOSObject());
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        actualPdCalRGB.getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#getName()}.
   *
   * <p>Method under test: {@link PDCalRGB#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDCalRGB.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("CalRGB", new PDCalRGB().getName());
  }

  /**
   * Test {@link PDCalRGB#getDefaultDecode(int)}.
   *
   * <p>Method under test: {@link PDCalRGB#getDefaultDecode(int)}
   */
  @Test
  @DisplayName("Test getDefaultDecode(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCalRGB.getDefaultDecode(int)"})
  void testGetDefaultDecode() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f}, new PDCalRGB().getDefaultDecode(1), 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PDCalRGB#getInitialColor()}
   *   <li>{@link PDCalRGB#getNumberOfComponents()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColor PDCalRGB.getInitialColor()", "int PDCalRGB.getNumberOfComponents()"})
  void testGettersAndSetters() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    PDColor actualInitialColor = pdCalRGB.getInitialColor();

    // Assert
    assertNull(actualInitialColor.getPatternName());
    assertEquals(3, pdCalRGB.getNumberOfComponents());
    assertFalse(actualInitialColor.isPattern());
    assertSame(pdCalRGB, actualInitialColor.getColorSpace());
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, actualInitialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDCalRGB#toRGB(float[])}.
   *
   * <p>Method under test: {@link PDCalRGB#toRGB(float[])}
   */
  @Test
  @DisplayName("Test toRGB(float[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCalRGB.toRGB(float[])"})
  void testToRGB() {
    // Arrange and Act
    float[] actualToRGBResult = new PDCalRGB().toRGB(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    assertArrayEquals(new float[] {0.0f, 0.0f, 0.0f}, actualToRGBResult, 0.0f);
  }

  /**
   * Test {@link PDCalRGB#getMatrix()}.
   *
   * <p>Method under test: {@link PDCalRGB#getMatrix()}
   */
  @Test
  @DisplayName("Test getMatrix()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDCalRGB.getMatrix()"})
  void testGetMatrix() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new float[] {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f},
        new PDCalRGB().getMatrix(),
        0.0f);
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setGamma(PDGamma); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setGamma(PDGamma)"})
  void testSetGamma_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(new COSObjectKey(1L, 1));

    // Act
    pdCalRGB.setGamma(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdCalRGB.getWhitepoint().getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    PDGamma gamma = pdCalRGB.getGamma();
    assertSame(array, gamma.getCOSArray());
    assertSame(array, gamma.getCOSObject());
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setGamma(PDGamma); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setGamma(PDGamma)"})
  void testSetGamma_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    COSArray array = new COSArray(new ArrayList<>());
    array.setDirect(false);
    array.setKey(null);

    // Act
    pdCalRGB.setGamma(new PDGamma(array));

    // Assert
    COSBase cOSObject = pdCalRGB.getWhitepoint().getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    PDGamma gamma = pdCalRGB.getGamma();
    assertSame(array, gamma.getCOSArray());
    assertSame(array, gamma.getCOSObject());
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDCalRGB#PDCalRGB()} Gamma B is one.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName("Test setGamma(PDGamma); when 'null'; then PDCalRGB() Gamma B is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setGamma(PDGamma)"})
  void testSetGamma_whenNull_thenPDCalRGBGammaBIsOne() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    pdCalRGB.setGamma(null);

    // Assert that nothing has changed
    PDGamma gamma = pdCalRGB.getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma(COSArray)} with array is {@code null}.
   *   <li>Then {@link PDCalRGB#PDCalRGB()} Gamma B is one.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setGamma(PDGamma); when PDGamma(COSArray) with array is 'null'; then PDCalRGB() Gamma B is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setGamma(PDGamma)"})
  void testSetGamma_whenPDGammaWithArrayIsNull_thenPDCalRGBGammaBIsOne() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    pdCalRGB.setGamma(new PDGamma(null));

    // Assert that nothing has changed
    PDGamma gamma = pdCalRGB.getGamma();
    assertEquals(1.0f, gamma.getB());
    assertEquals(1.0f, gamma.getG());
    assertEquals(1.0f, gamma.getR());
  }

  /**
   * Test {@link PDCalRGB#setGamma(PDGamma)}.
   *
   * <ul>
   *   <li>When {@link PDGamma#PDGamma()}.
   *   <li>Then {@link PDCalRGB#PDCalRGB()} Gamma B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setGamma(PDGamma)}
   */
  @Test
  @DisplayName("Test setGamma(PDGamma); when PDGamma(); then PDCalRGB() Gamma B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setGamma(PDGamma)"})
  void testSetGamma_whenPDGamma_thenPDCalRGBGammaBIsZero() {
    // Arrange
    PDCalRGB pdCalRGB = new PDCalRGB();

    // Act
    pdCalRGB.setGamma(new PDGamma());

    // Assert
    COSBase cOSObject = pdCalRGB.getWhitepoint().getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(3, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSFloat);
    PDGamma gamma = pdCalRGB.getGamma();
    assertEquals(0.0f, gamma.getB());
    assertEquals(0.0f, gamma.getG());
    assertEquals(0.0f, gamma.getR());
  }

  /**
   * Test {@link PDCalRGB#setMatrix(Matrix)}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getCOSArray(COSName)} return {@code
   *       null}.
   *   <li>Then calls {@link COSArray#getObject(int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDCalRGB#setMatrix(Matrix)}
   */
  @Test
  @DisplayName(
      "Test setMatrix(Matrix); given COSDictionary getCOSArray(COSName) return 'null'; then calls getObject(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDCalRGB.setMatrix(Matrix)"})
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
    verify(rgb).getObject(1);
    verify(cosDictionary).getCOSArray(isA(COSName.class));
    verify(cosDictionary).setItem(isA(COSName.class), isA(COSBase.class));
  }
}
