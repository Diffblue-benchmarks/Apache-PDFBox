package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceCMYK;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PDShadingDiffblueTest {
  /**
   * Test {@link PDShading#getCOSObject()}.
   *
   * <p>Method under test: {@link PDShading#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSDictionary PDShading.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, new PDShadingType1(shadingDictionary).getCOSObject());
  }

  /**
   * Test {@link PDShading#getType()}.
   *
   * <p>Method under test: {@link PDShading#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String PDShading.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Shading", new PDShadingType1(new COSDictionary()).getType());
  }

  /**
   * Test {@link PDShading#setShadingType(int)}.
   *
   * <p>Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  @DisplayName("Test setShadingType(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setShadingType(int)"})
  void testSetShadingType() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setShadingType(1);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShading#setShadingType(int)}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  @DisplayName("Test setShadingType(int); when MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setShadingType(int)"})
  void testSetShadingType_whenMin_value() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setShadingType(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShading#setBackground(COSArray)}.
   *
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    COSArray newBackground = new COSArray();

    // Act
    pdShadingType1.setBackground(newBackground);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newBackground, pdShadingType1.getBackground());
  }

  /**
   * Test {@link PDShading#setBackground(COSArray)}.
   *
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setBackground(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShading#setBackground(COSArray)}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBackground(COSArray); given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSArray newBackground = new COSArray(new ArrayList<>());
    newBackground.setDirect(false);
    newBackground.setKey(new COSObjectKey(1L, 1));

    // Act
    pdShadingType1.setBackground(newBackground);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newBackground, pdShadingType1.getBackground());
  }

  /**
   * Test {@link PDShading#setBackground(COSArray)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link COSArray#COSArray(List)} with cosObjectables is {@link ArrayList#ArrayList()}
   *       Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setBackground(COSArray); given 'null'; when COSArray(List) with cosObjectables is ArrayList() Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground_givenNull_whenCOSArrayWithCosObjectablesIsArrayListKeyIsNull() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSArray newBackground = new COSArray(new ArrayList<>());
    newBackground.setDirect(false);
    newBackground.setKey(null);

    // Act
    pdShadingType1.setBackground(newBackground);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newBackground, pdShadingType1.getBackground());
  }

  /**
   * Test {@link PDShading#getBackground()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDShading.getBackground()"})
  void testGetBackground_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getBackground());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getBBox());
  }

  /**
   * Test {@link PDShading#setBBox(PDRectangle)}.
   *
   * <p>Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBBox(PDRectangle)"})
  void testSetBBox() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setBBox(PDRectangle.A1);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(toIncrementResult.getObjects().isEmpty());
    assertSame(PDRectangle.A1, pdShadingType1.getBBox());
  }

  /**
   * Test {@link PDShading#setBBox(PDRectangle)}.
   *
   * <p>Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBBox(PDRectangle)"})
  void testSetBBox2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setBBox(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    COSIncrement toIncrementResult = cOSObject.toIncrement();
    assertFalse(toIncrementResult.iterator().hasNext());
    assertTrue(cOSObject.getValues().isEmpty());
    assertTrue(toIncrementResult.getObjects().isEmpty());
  }

  /**
   * Test {@link PDShading#getBounds(AffineTransform, Matrix)}.
   *
   * <p>Method under test: {@link PDShading#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.awt.geom.Rectangle2D PDShading.getBounds(AffineTransform, Matrix)"})
  void testGetBounds() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    AffineTransform xform = new AffineTransform();

    // Act and Assert
    assertNull(pdShadingType1.getBounds(xform, new Matrix()));
  }

  /**
   * Test {@link PDShading#setAntiAlias(boolean)}.
   *
   * <p>Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  @DisplayName("Test setAntiAlias(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setAntiAlias(boolean)"})
  void testSetAntiAlias() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setAntiAlias(false);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertFalse(pdShadingType1.getAntiAlias());
  }

  /**
   * Test {@link PDShading#setAntiAlias(boolean)}.
   *
   * <ul>
   *   <li>Then {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()} AntiAlias.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAntiAlias(boolean); then PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary() AntiAlias")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setAntiAlias(boolean)"})
  void testSetAntiAlias_thenPDShadingType1WithShadingDictionaryIsCOSDictionaryAntiAlias() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setAntiAlias(true);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdShadingType1.getAntiAlias());
  }

  /**
   * Test {@link PDShading#getAntiAlias()}.
   *
   * <p>Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName("Test getAntiAlias()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setAntiAlias(false);

    // Act and Assert
    assertFalse(pdShadingType1.getAntiAlias());
  }

  /**
   * Test {@link PDShading#getAntiAlias()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName(
      "Test getAntiAlias(); given PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_givenPDShadingType1WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse(new PDShadingType1(new COSDictionary()).getAntiAlias());
  }

  /**
   * Test {@link PDShading#getAntiAlias()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName("Test getAntiAlias(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_thenReturnTrue() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setAntiAlias(true);

    // Act and Assert
    assertTrue(pdShadingType1.getAntiAlias());
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSArray} {@link COSArray#getObject(int)} return {@link COSName#DEVICECMYK}.
   *   <li>Then return {@link PDDeviceCMYK#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given COSArray getObject(int) return DEVICECMYK; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSArrayGetObjectReturnDevicecmyk_thenReturnInstance()
      throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.DEVICECMYK);

    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(cosArray).getObject(0);
    verify(cosArray).isEmpty();
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    assertSame(((PDDeviceCMYK) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray(List)} with cosObjectables is {@link
   *       ArrayList#ArrayList()} add {@link COSName#PATTERN}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given COSArray(List) with cosObjectables is ArrayList() add PATTERN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSArrayWithCosObjectablesIsArrayListAddPattern() throws IOException {
    // Arrange
    COSArray cosArray = new COSArray(new ArrayList<>());
    cosArray.add(COSName.PATTERN);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosArray);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("Pattern", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualColorSpace).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSName#DEVICECMYK}.
   *   <li>Then return {@link PDDeviceCMYK#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given COSObject getObject() return DEVICECMYK; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSObjectGetObjectReturnDevicecmyk_thenReturnInstance()
      throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSName.DEVICECMYK);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    assertSame(((PDDeviceCMYK) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSName#DEVICEGRAY}.
   *   <li>Then return {@link PDDeviceGray#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given COSObject getObject() return DEVICEGRAY; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSObjectGetObjectReturnDevicegray_thenReturnInstance()
      throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSName.DEVICEGRAY);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    assertSame(((PDDeviceGray) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSName#DEVICERGB}.
   *   <li>Then return {@link PDDeviceRGB#INSTANCE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName(
      "Test getColorSpace(); given COSObject getObject() return DEVICERGB; then return INSTANCE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSObjectGetObjectReturnDevicergb_thenReturnInstance()
      throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSName.DEVICERGB);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    assertSame(((PDDeviceRGB) actualColorSpace).INSTANCE, actualColorSpace);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Given {@link COSObject} {@link COSObject#getObject()} return {@link COSName#PATTERN}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given COSObject getObject() return PATTERN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSObjectGetObjectReturnPattern() throws IOException {
    // Arrange
    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(COSName.PATTERN);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    COSBase cOSObject = actualColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    assertTrue(toListResult.get(0) instanceof COSName);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("Pattern", actualColorSpace.getName());
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertNull(initialColor.getPatternName());
    assertNull(initialColor.getColorSpace());
    assertNull(((PDPattern) actualColorSpace).getUnderlyingColorSpace());
    assertFalse(initialColor.isPattern());
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Then UnderlyingColorSpace COSObject return {@link COSArray}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then UnderlyingColorSpace COSObject return COSArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_thenUnderlyingColorSpaceCOSObjectReturnCOSArray() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.PATTERN);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.PATTERN);

    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(cosArray).get(1);
    verify(cosArray).getObject(0);
    verify(cosArray).isEmpty();
    verify(cosArray).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    PDColorSpace underlyingColorSpace = ((PDPattern) actualColorSpace).getUnderlyingColorSpace();
    COSBase cOSObject = underlyingColorSpace.getCOSObject();
    assertTrue(cOSObject instanceof COSArray);
    COSBase cOSObject2 = actualColorSpace.getCOSObject();
    assertTrue(cOSObject2 instanceof COSArray);
    assertTrue(underlyingColorSpace instanceof PDPattern);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("Pattern", underlyingColorSpace.getName());
    assertNull(((PDPattern) underlyingColorSpace).getUnderlyingColorSpace());
    List<? extends COSBase> toListResult = ((COSArray) cOSObject).toList();
    assertEquals(1, toListResult.size());
    List<? extends COSBase> toListResult2 = ((COSArray) cOSObject2).toList();
    assertEquals(2, toListResult2.size());
    assertSame(toListResult2.get(0), toListResult.get(0));
    PDColor initialColor = actualColorSpace.getInitialColor();
    assertSame(initialColor, underlyingColorSpace.getInitialColor());
    assertSame(cOSObject, toListResult2.get(1));
    assertArrayEquals(new float[] {}, initialColor.getComponents(), 0.0f);
  }

  /**
   * Test {@link PDShading#getColorSpace()}.
   *
   * <ul>
   *   <li>Then UnderlyingColorSpace COSObject return {@link COSName}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); then UnderlyingColorSpace COSObject return COSName")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_thenUnderlyingColorSpaceCOSObjectReturnCOSName() throws IOException {
    // Arrange
    COSDictionary cosDictionary = mock(COSDictionary.class);
    when(cosDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.DEVICECMYK);
    when(cosDictionary.containsKey(Mockito.<COSName>any())).thenReturn(true);

    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(3);
    when(cosArray.get(anyInt())).thenReturn(cosDictionary);
    when(cosArray.isEmpty()).thenReturn(false);
    when(cosArray.getObject(anyInt())).thenReturn(COSName.PATTERN);

    COSObject cosObject = mock(COSObject.class);
    when(cosObject.getObject()).thenReturn(cosArray);

    COSDictionary shadingDictionary = mock(COSDictionary.class);
    when(shadingDictionary.getDictionaryObject(Mockito.<COSName>any(), Mockito.<COSName>any()))
        .thenReturn(cosObject);

    // Act
    PDColorSpace actualColorSpace = new PDShadingType1(shadingDictionary).getColorSpace();

    // Assert
    verify(cosArray).get(1);
    verify(cosArray).getObject(0);
    verify(cosArray).isEmpty();
    verify(cosArray).size();
    verify(cosDictionary).containsKey(isA(COSName.class));
    verify(cosDictionary).getDictionaryObject(isA(COSName.class));
    verify(shadingDictionary).getDictionaryObject(isA(COSName.class), isA(COSName.class));
    verify(cosObject).getObject();
    PDColorSpace underlyingColorSpace = ((PDPattern) actualColorSpace).getUnderlyingColorSpace();
    assertTrue(underlyingColorSpace.getCOSObject() instanceof COSName);
    assertTrue(underlyingColorSpace instanceof PDDeviceCMYK);
    assertTrue(actualColorSpace instanceof PDPattern);
    assertEquals("DeviceCMYK", underlyingColorSpace.getName());
    assertEquals(4, underlyingColorSpace.getNumberOfComponents());
    assertArrayEquals(new float[] {}, actualColorSpace.getInitialColor().getComponents(), 0.0f);
  }

  /**
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setColorSpace(PDDeviceGray.INSTANCE);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(PDDeviceGray.INSTANCE, pdShadingType1.getColorSpace());
  }

  /**
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace2() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setColorSpace(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace3() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDCalGray colorSpace = new PDCalGray();

    // Act
    pdShadingType1.setColorSpace(colorSpace);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(colorSpace, pdShadingType1.getColorSpace());
  }

  /**
   * Test {@link PDShading#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDShading.create(COSDictionary)"})
  void testCreate_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDShading.create(new COSDictionary()));
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDFunctionType0 newFunction = new PDFunctionType0(COSBoolean.FALSE);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction2() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDFunctionType0 newFunction = new PDFunctionType0(new COSDictionary());

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction3() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDFunctionType0 newFunction = new PDFunctionType0(new COSStream());

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName(
      "Test setFunction(PDFunction) with 'newFunction'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction_givenCOSObjectKeyWithNumIsOneAndGenIsOne()
      throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSDictionary function = new COSDictionary();
    function.setKey(new COSObjectKey(1L, 1));
    PDFunctionType0 newFunction = new PDFunctionType0(function);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName(
      "Test setFunction(PDFunction) with 'newFunction'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction_givenTrue_whenCOSDictionaryDirectIsTrue() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSDictionary function = new COSDictionary();
    function.setDirect(true);
    PDFunctionType0 newFunction = new PDFunctionType0(function);

    // Act
    pdShadingType1.setFunction(newFunction);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(newFunction, pdShadingType1.getFunction());
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'; when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction_whenNull() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setFunction((PDFunction) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShading#setFunction(COSArray)} with {@code newFunctions}.
   *
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setFunction((COSArray) null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(0, cOSObject.size());
    assertTrue(cOSObject.getValues().isEmpty());
  }

  /**
   * Test {@link PDShading#setFunction(COSArray)} with {@code newFunctions}.
   *
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setFunction(COSArray) with 'newFunctions'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions_givenCOSObjectKeyWithNumIsOneAndGenIsOne() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSArray newFunctions = new COSArray(new ArrayList<>());
    newFunctions.setDirect(false);
    newFunctions.setKey(new COSObjectKey(1L, 1));

    // Act
    pdShadingType1.setFunction(newFunctions);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShading#setFunction(COSArray)} with {@code newFunctions}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions_givenNull() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    COSArray newFunctions = new COSArray(new ArrayList<>());
    newFunctions.setDirect(false);
    newFunctions.setKey(null);

    // Act
    pdShadingType1.setFunction(newFunctions);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShading#setFunction(COSArray)} with {@code newFunctions}.
   *
   * <ul>
   *   <li>When {@link COSArray#COSArray()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'; when COSArray()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions_whenCOSArray() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());

    // Act
    pdShadingType1.setFunction(new COSArray());

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
  }

  /**
   * Test {@link PDShading#getFunction()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getFunction()}
   */
  @Test
  @DisplayName("Test getFunction(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDShading.getFunction()"})
  void testGetFunction_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getFunction());
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName("Test evalFunction(float) with 'inputValue'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDShadingType1(new COSDictionary()).evalFunction(10.0f));
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   *
   * <ul>
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName("Test evalFunction(float[]) with 'input'; then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDShadingType1(new COSDictionary())
                .evalFunction(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }
}
