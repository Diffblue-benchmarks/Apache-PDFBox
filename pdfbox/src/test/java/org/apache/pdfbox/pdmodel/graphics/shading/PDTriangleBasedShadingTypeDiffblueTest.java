package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRange;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDTriangleBasedShadingTypeDiffblueTest {
  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerComponent()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getBitsPerComponent()}
   */
  @Test
  @DisplayName("Test getBitsPerComponent(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerComponent()"})
  void testGetBitsPerComponent_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType4(new COSDictionary())).getBitsPerComponent());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}.
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerComponent(int)"})
  void testSetBitsPerComponent() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerComponent(1);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setBitsPerComponent(int)}
   */
  @Test
  @DisplayName("Test setBitsPerComponent(int); when MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerComponent(int)"})
  void testSetBitsPerComponent_whenMin_value() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerComponent(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}.
   * <ul>
   *   <li>Then return minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getBitsPerCoordinate()}
   */
  @Test
  @DisplayName("Test getBitsPerCoordinate(); then return minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getBitsPerCoordinate()"})
  void testGetBitsPerCoordinate_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, (new PDShadingType4(new COSDictionary())).getBitsPerCoordinate());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}.
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  @DisplayName("Test setBitsPerCoordinate(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerCoordinate(int)"})
  void testSetBitsPerCoordinate() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerCoordinate(1);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}.
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setBitsPerCoordinate(int)}
   */
  @Test
  @DisplayName("Test setBitsPerCoordinate(int); when MIN_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setBitsPerCoordinate(int)"})
  void testSetBitsPerCoordinate_whenMin_value() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setBitsPerCoordinate(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getNumberOfColorComponents()}.
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getInt(COSName)} return zero.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getNumberOfColorComponents()}
   */
  @Test
  @DisplayName("Test getNumberOfColorComponents(); given COSDictionary getInt(COSName) return zero; then return one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int PDTriangleBasedShadingType.getNumberOfColorComponents()"})
  void testGetNumberOfColorComponents_givenCOSDictionaryGetIntReturnZero_thenReturnOne() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getInt(Mockito.<COSName>any())).thenReturn(0);
    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cosDictionary);

    // Act
    int actualNumberOfColorComponents = (new PDShadingType4(shadingDictionary)).getNumberOfColorComponents();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class));
    verify(cosDictionary).getInt(isA(COSName.class));
    assertEquals(1, actualNumberOfColorComponents);
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setDecodeValues(new COSArray());

    // Assert
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}.
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#setDecodeValues(COSArray)}
   */
  @Test
  @DisplayName("Test setDecodeValues(COSArray)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDTriangleBasedShadingType.setDecodeValues(COSArray)"})
  void testSetDecodeValues2() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());

    // Act
    pdShadingType4.setDecodeValues(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType4.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}.
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDTriangleBasedShadingType.getDecodeForParameter(int)"})
  void testGetDecodeForParameter() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType4(new COSDictionary())).getDecodeForParameter(10));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDTriangleBasedShadingType.getDecodeForParameter(int)"})
  void testGetDecodeForParameter_thenReturnNull() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    pdShadingType4.setDecodeValues(new COSArray());

    // Act and Assert
    assertNull(pdShadingType4.getDecodeForParameter(10));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}.
   * <ul>
   *   <li>When minus one.</li>
   *   <li>Then return COSArray toList Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getDecodeForParameter(int)}
   */
  @Test
  @DisplayName("Test getDecodeForParameter(int); when minus one; then return COSArray toList Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRange PDTriangleBasedShadingType.getDecodeForParameter(int)"})
  void testGetDecodeForParameter_whenMinusOne_thenReturnCOSArrayToListEmpty() {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    COSArray cosArray = new COSArray();
    pdShadingType4.setDecodeValues(cosArray);

    // Act
    PDRange actualDecodeForParameter = pdShadingType4.getDecodeForParameter(-1);

    // Assert
    COSArray cOSArray = actualDecodeForParameter.getCOSArray();
    assertTrue(cOSArray.toList().isEmpty());
    assertSame(cosArray, cOSArray);
    assertSame(cosArray, actualDecodeForParameter.getCOSObject());
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   * <ul>
   *   <li>When {@code 0.5}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when '0.5'; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_when05_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(0.5f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   * <ul>
   *   <li>When {@code -0.5}.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when '-0.5'; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_when05_thenReturnTen2() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(-0.5f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when five; then return ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_whenFive_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new PDShadingType4(new COSDictionary())).interpolate(10.0f, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}.
   * <ul>
   *   <li>When {@link Float#NaN}.</li>
   *   <li>Then return {@link Float#NaN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#interpolate(float, long, float, float)}
   */
  @Test
  @DisplayName("Test interpolate(float, long, float, float); when NaN; then return NaN")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float PDTriangleBasedShadingType.interpolate(float, long, float, float)"})
  void testInterpolate_whenNaN_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Float.NaN, (new PDShadingType4(new COSDictionary())).interpolate(Float.NaN, 5L, 10.0f, 10.0f));
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D PDTriangleBasedShadingType.getBounds(AffineTransform, Matrix)"})
  void testGetBounds_givenPDShadingType4WithShadingDictionaryIsCOSDictionary() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSDictionary());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }

  /**
   * Test {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}.
   * <ul>
   *   <li>Given {@link PDShadingType4#PDShadingType4(COSDictionary)} with shadingDictionary is {@link COSStream#COSStream()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDTriangleBasedShadingType#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix); given PDShadingType4(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Rectangle2D PDTriangleBasedShadingType.getBounds(AffineTransform, Matrix)"})
  void testGetBounds_givenPDShadingType4WithShadingDictionaryIsCOSStream() throws IOException {
    // Arrange
    PDShadingType4 pdShadingType4 = new PDShadingType4(new COSStream());
    AffineTransform affineTransform = new AffineTransform();

    // Act
    Rectangle2D actualBounds = pdShadingType4.getBounds(affineTransform, new Matrix());

    // Assert
    Rectangle2D frame = actualBounds.getFrame();
    assertTrue(frame instanceof Double);
    Rectangle2D bounds2D = actualBounds.getBounds2D();
    assertTrue(bounds2D instanceof Rectangle2D.Float);
    assertTrue(actualBounds instanceof Rectangle2D.Float);
    assertEquals(actualBounds, actualBounds.getBounds());
    assertEquals(actualBounds, frame);
    assertEquals(actualBounds, bounds2D);
  }
}
