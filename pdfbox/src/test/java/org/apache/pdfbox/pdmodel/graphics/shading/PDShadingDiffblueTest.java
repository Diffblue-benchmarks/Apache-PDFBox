package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSObject;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.io.RandomAccessReadWriteBuffer;
import org.apache.pdfbox.pdfparser.COSParser;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionTypeIdentity;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PDShadingDiffblueTest {
  @Mock private COSArray cOSArray;

  @Mock private COSDictionary cOSDictionary;

  @Mock private PDColorSpace pDColorSpace;

  @Mock private PDFunction pDFunction;

  @Mock private PDRectangle pDRectangle;

  @InjectMocks private PDShadingType1 pDShadingType1;

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
   *   <li>Given {@link COSDictionary}.
   *   <li>When one.
   *   <li>Then calls {@link COSDictionary#setInt(COSName, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  @DisplayName(
      "Test setShadingType(int); given COSDictionary; when one; then calls setInt(COSName, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setShadingType(int)"})
  void testSetShadingType_givenCOSDictionary_whenOne_thenCallsSetInt() {
    // Arrange
    doNothing().when(cOSDictionary).setInt(Mockito.<COSName>any(), anyInt());

    // Act
    new PDShadingType1(cOSDictionary).setShadingType(1);

    // Assert
    verify(cOSDictionary).setInt(isA(COSName.class), eq(1));
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
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground3() {
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
   * <p>Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setBackground(COSArray)"})
  void testSetBackground4() {
    // Arrange
    doNothing().when(cOSArray).setDirect(anyBoolean());
    doNothing().when(cOSArray).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDShadingType1 pdShadingType1 = new PDShadingType1(cOSDictionary);
    cOSArray.setDirect(false);
    cOSArray.setKey(new COSObjectKey(1L, 1));

    // Act
    pdShadingType1.setBackground(cOSArray);

    // Assert
    verify(cOSArray).setDirect(false);
    verify(cOSArray).setKey(isA(COSObjectKey.class));
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    assertSame(cOSArray, pdShadingType1.getBackground());
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
   *   <li>Given {@link COSDictionary}.
   *   <li>Then return toList Empty.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground(); given COSDictionary; then return toList Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDShading.getBackground()"})
  void testGetBackground_givenCOSDictionary_thenReturnToListEmpty() {
    // Arrange
    COSArray cosArray = new COSArray();
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    COSArray actualBackground = new PDShadingType1(cOSDictionary).getBackground();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    assertTrue(actualBackground.toList().isEmpty());
    assertSame(cosArray, actualBackground);
  }

  /**
   * Test {@link PDShading#getBackground()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBackground()}
   */
  @Test
  @DisplayName(
      "Test getBackground(); given PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDShading.getBackground()"})
  void testGetBackground_givenPDShadingType1WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getBackground());
  }

  /**
   * Test {@link PDShading#getBackground()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBackground()}
   */
  @Test
  @DisplayName(
      "Test getBackground(); given PDShadingType1(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"COSArray PDShading.getBackground()"})
  void testGetBackground_givenPDShadingType1WithShadingDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSStream()).getBackground());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSObjectKey,
   *       ICOSParser)} with key is {@link COSObjectKey#COSObjectKey(long, int)} and parser is
   *       {@link COSParser#COSParser(RandomAccessRead)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given COSArray() add COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is COSParser(RandomAccessRead)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddCOSObjectWithKeyIsCOSObjectKeyAndParserIsCOSParser()
      throws IOException {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObjectKey key = new COSObjectKey(1L, 1);
    COSObject object = new COSObject(key, new COSParser(new RandomAccessReadWriteBuffer()));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSObjectKey,
   *       ICOSParser)} with key is {@link COSObjectKey#COSObjectKey(long, int)} and parser is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given COSArray() add COSObject(COSObjectKey, ICOSParser) with key is COSObjectKey(long, int) and parser is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddCOSObjectWithKeyIsCOSObjectKeyAndParserIsNull() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(new COSObjectKey(1L, 1), null);
    cosArray.add((COSBase) object);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSObject#COSObject(COSBase, COSObjectKey)}
   *       with object is {@link COSBoolean#FALSE} and objectKey is {@link
   *       COSObjectKey#COSObjectKey(long, int)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given COSArray() add COSObject(COSBase, COSObjectKey) with object is FALSE and objectKey is COSObjectKey(long, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddCOSObjectWithObjectIsFalseAndObjectKeyIsCOSObjectKey() {
    // Arrange
    COSArray cosArray = new COSArray();
    COSObject object = new COSObject(COSBoolean.FALSE, new COSObjectKey(1L, 1));
    cosArray.add((COSBase) object);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSBoolean#FALSE}.
   *   <li>Then return LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given COSArray() add FALSE; then return LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddFalse_thenReturnLowerLeftXIsZero() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSBoolean.FALSE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSFloat#ONE}.
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given COSArray() add ONE; then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddOne_thenReturnCOSArrayToListThirdKeyIsNull() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSFloat.ONE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualBBox.getUpperRightX());
    assertEquals(1.0f, actualBBox.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link COSArray#COSArray()} add {@link COSInteger#ONE}.
   *   <li>Then return COSArray toList third Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given COSArray() add ONE; then return COSArray toList third Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenCOSArrayAddOne_thenReturnCOSArrayToListThirdKeyIsNull2() {
    // Arrange
    COSArray cosArray = new COSArray();
    cosArray.add(COSInteger.ONE);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cosArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(2);
    assertTrue(getResult instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(1.0f, actualBBox.getUpperRightX());
    assertEquals(1.0f, actualBBox.getWidth());
    assertFalse(getResult.isDirect());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenPDShadingType1WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getBBox());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName(
      "Test getBBox(); given PDShadingType1(COSDictionary) with shadingDictionary is COSStream(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_givenPDShadingType1WithShadingDictionaryIsCOSStream_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSStream()).getBBox());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Then return COSArray toList second Key is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return COSArray toList second Key is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_thenReturnCOSArrayToListSecondKeyIsNull() {
    // Arrange
    when(cOSArray.toFloatArray()).thenReturn(new float[] {10.0f, 0.5f, 10.0f, 0.5f});
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(cOSArray);

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSArray).toFloatArray();
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(3);
    assertTrue(getResult2 instanceof COSFloat);
    assertNull(getResult.getKey());
    assertEquals(0.5f, actualBBox.getLowerLeftY());
    assertEquals(0.5f, actualBBox.getUpperRightY());
    assertEquals(10.0f, actualBBox.getLowerLeftX());
    assertEquals(10.0f, actualBBox.getUpperRightX());
    assertFalse(getResult.isDirect());
    assertEquals(getResult, getResult2);
  }

  /**
   * Test {@link PDShading#getBBox()}.
   *
   * <ul>
   *   <li>Then return LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_thenReturnLowerLeftXIsZero() {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());

    // Act
    PDRectangle actualBBox = pDShadingType1.getBBox();

    // Assert
    verify(cOSDictionary).getCOSArray(isA(COSName.class));
    List<? extends COSBase> toListResult = actualBBox.getCOSArray().toList();
    assertEquals(4, toListResult.size());
    COSBase getResult = toListResult.get(1);
    assertTrue(getResult instanceof COSFloat);
    COSBase getResult2 = toListResult.get(2);
    assertTrue(getResult2 instanceof COSFloat);
    COSBase getResult3 = toListResult.get(3);
    assertTrue(getResult3 instanceof COSFloat);
    assertEquals(0.0f, actualBBox.getLowerLeftX());
    assertEquals(0.0f, actualBBox.getLowerLeftY());
    assertEquals(0.0f, actualBBox.getUpperRightX());
    assertEquals(0.0f, actualBBox.getUpperRightY());
    assertEquals(0.0f, actualBBox.getWidth());
    COSBase getResult4 = toListResult.get(0);
    assertEquals(getResult4, getResult);
    assertEquals(getResult4, getResult2);
    assertEquals(getResult4, getResult3);
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
    pdShadingType1.setBBox(PDRectangle.A0);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertSame(PDRectangle.A0, pdShadingType1.getBBox());
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
    assertTrue(cOSObject.getValues().isEmpty());
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
  void testSetBBox3() {
    // Arrange
    when(pDRectangle.getCOSArray()).thenReturn(new COSArray());
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDShadingType1 pdShadingType1 = new PDShadingType1(cOSDictionary);

    // Act
    pdShadingType1.setBBox(pDRectangle);

    // Assert
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pDRectangle).getCOSArray();
    assertSame(pDRectangle, pdShadingType1.getBBox());
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
   *   <li>Given {@link COSDictionary}.
   *   <li>When {@code false}.
   *   <li>Then calls {@link COSDictionary#setBoolean(COSName, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  @DisplayName(
      "Test setAntiAlias(boolean); given COSDictionary; when 'false'; then calls setBoolean(COSName, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setAntiAlias(boolean)"})
  void testSetAntiAlias_givenCOSDictionary_whenFalse_thenCallsSetBoolean() {
    // Arrange
    doNothing().when(cOSDictionary).setBoolean(Mockito.<COSName>any(), anyBoolean());

    // Act
    new PDShadingType1(cOSDictionary).setAntiAlias(false);

    // Assert
    verify(cOSDictionary).setBoolean(isA(COSName.class), eq(false));
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
    pdShadingType1.setAntiAlias(true);

    // Act and Assert
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
  void testGetAntiAlias2() {
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
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getBoolean(COSName, boolean)} return
   *       {@code true}.
   *   <li>Then calls {@link COSDictionary#getBoolean(COSName, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName(
      "Test getAntiAlias(); given COSDictionary getBoolean(COSName, boolean) return 'true'; then calls getBoolean(COSName, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_givenCOSDictionaryGetBooleanReturnTrue_thenCallsGetBoolean() {
    // Arrange
    when(cOSDictionary.getBoolean(Mockito.<COSName>any(), anyBoolean())).thenReturn(true);

    // Act
    boolean actualAntiAlias = pDShadingType1.getAntiAlias();

    // Assert
    verify(cOSDictionary).getBoolean(isA(COSName.class), eq(false));
    assertTrue(actualAntiAlias);
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
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName(
      "Test getAntiAlias(); given PDShadingType1(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_givenPDShadingType1WithShadingDictionaryIsCOSStream() {
    // Arrange, Act and Assert
    assertFalse(new PDShadingType1(new COSStream()).getAntiAlias());
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
   *   <li>Given {@link COSArray} {@link COSArray#size()} return one.
   *   <li>Then calls {@link COSArray#size()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getColorSpace()}
   */
  @Test
  @DisplayName("Test getColorSpace(); given COSArray size() return one; then calls size()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDColorSpace PDShading.getColorSpace()"})
  void testGetColorSpace_givenCOSArraySizeReturnOne_thenCallsSize() throws IOException {
    // Arrange
    COSArray cosArray = mock(COSArray.class);
    when(cosArray.size()).thenReturn(1);
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
    verify(cosArray).getObject(0);
    verify(cosArray).isEmpty();
    verify(cosArray).size();
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
  void testSetColorSpace2() throws IOException {
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
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   *
   * <p>Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace3() {
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
   * <ul>
   *   <li>Then {@link PDShadingType1} ColorSpace is {@link PDColorSpace}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace); then PDShadingType1 ColorSpace is PDColorSpace")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace_thenPDShadingType1ColorSpaceIsPDColorSpace() throws IOException {
    // Arrange
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());

    COSBoolean cosBoolean = COSBoolean.FALSE;
    cosBoolean.setDirect(false);
    cosBoolean.setKey(new COSObjectKey(1L, 1));
    when(pDColorSpace.getCOSObject()).thenReturn(cosBoolean);

    // Act
    pDShadingType1.setColorSpace(pDColorSpace);

    // Assert
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSBase.class));
    verify(pDColorSpace).getCOSObject();
    assertSame(pDColorSpace, pDShadingType1.getColorSpace());
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
   * Test {@link PDShading#create(COSDictionary)}.
   *
   * <ul>
   *   <li>When {@link COSStream#COSStream()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSStream(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDShading PDShading.create(COSDictionary)"})
  void testCreate_whenCOSStream_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDShading.create(new COSStream()));
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
   * <p>Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction4() throws IOException {
    // Arrange
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSObjectable>any());
    PDShadingType1 pdShadingType1 = new PDShadingType1(cOSDictionary);

    // Act
    pdShadingType1.setFunction(pDFunction);

    // Assert
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSObjectable.class));
    assertSame(pDFunction, pdShadingType1.getFunction());
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
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions2() {
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
   *   <li>Given {@link COSDictionary}.
   *   <li>Then calls {@link COSArray#setDirect(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName(
      "Test setFunction(COSArray) with 'newFunctions'; given COSDictionary; then calls setDirect(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions_givenCOSDictionary_thenCallsSetDirect() {
    // Arrange
    doNothing().when(cOSArray).setDirect(anyBoolean());
    doNothing().when(cOSArray).setKey(Mockito.<COSObjectKey>any());
    doNothing().when(cOSDictionary).setItem(Mockito.<COSName>any(), Mockito.<COSBase>any());
    PDShadingType1 pdShadingType1 = new PDShadingType1(cOSDictionary);
    cOSArray.setDirect(false);
    cOSArray.setKey(new COSObjectKey(1L, 1));

    // Act
    pdShadingType1.setFunction(cOSArray);

    // Assert
    verify(cOSArray).setDirect(false);
    verify(cOSArray).setKey(isA(COSObjectKey.class));
    verify(cOSDictionary).setItem(isA(COSName.class), isA(COSBase.class));
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
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getFunction()}
   */
  @Test
  @DisplayName(
      "Test getFunction(); given PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDShading.getFunction()"})
  void testGetFunction_givenPDShadingType1WithShadingDictionaryIsCOSDictionary()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSDictionary()).getFunction());
  }

  /**
   * Test {@link PDShading#getFunction()}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getFunction()}
   */
  @Test
  @DisplayName(
      "Test getFunction(); given PDShadingType1(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDShading.getFunction()"})
  void testGetFunction_givenPDShadingType1WithShadingDictionaryIsCOSStream() throws IOException {
    // Arrange, Act and Assert
    assertNull(new PDShadingType1(new COSStream()).getFunction());
  }

  /**
   * Test {@link PDShading#getFunction()}.
   *
   * <ul>
   *   <li>Then return {@link PDFunctionTypeIdentity}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#getFunction()}
   */
  @Test
  @DisplayName("Test getFunction(); then return PDFunctionTypeIdentity")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDFunction PDShading.getFunction()"})
  void testGetFunction_thenReturnPDFunctionTypeIdentity() throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSName.IDENTITY);

    // Act
    PDFunction actualFunction = new PDShadingType1(cOSDictionary).getFunction();

    // Assert
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    assertTrue(actualFunction instanceof PDFunctionTypeIdentity);
    assertNull(actualFunction.getCOSObject());
    assertEquals(0, actualFunction.getNumberOfOutputParameters());
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   *
   * <p>Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName("Test evalFunction(float[]) with 'input'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDShadingType1(new COSDictionary())
                .evalFunction(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   *
   * <p>Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName("Test evalFunction(float) with 'inputValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class, () -> new PDShadingType1(new COSDictionary()).evalFunction(10.0f));
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   *
   * <p>Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName("Test evalFunction(float) with 'inputValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue2() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> new PDShadingType1(new COSStream()).evalFunction(10.0f));
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName(
      "Test evalFunction(float) with 'inputValue'; given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue_givenCOSDictionaryGetDictionaryObjectReturnFalse()
      throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(IOException.class, () -> pDShadingType1.evalFunction(10.0f));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   *
   * <ul>
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName("Test evalFunction(float) with 'inputValue'; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cOSDictionary.getFloat(Mockito.<COSName>any())).thenReturn(10.0f);
    when(cOSDictionary.getInt(Mockito.<COSName>any())).thenReturn(2);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    float[] actualEvalFunctionResult = pDShadingType1.evalFunction(10.0f);

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(cOSDictionary).getFloat(isA(COSName.class));
    verify(cOSDictionary).getInt(isA(COSName.class));
    assertArrayEquals(new float[] {}, actualEvalFunctionResult, 0.0f);
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary} {@link COSDictionary#getDictionaryObject(COSName)} return
   *       {@link COSBoolean#FALSE}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName(
      "Test evalFunction(float[]) with 'input'; given COSDictionary getDictionaryObject(COSName) return FALSE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput_givenCOSDictionaryGetDictionaryObjectReturnFalse()
      throws IOException {
    // Arrange
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(COSBoolean.FALSE);

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> pDShadingType1.evalFunction(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   *
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is
   *       {@link COSStream#COSStream()}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName(
      "Test evalFunction(float[]) with 'input'; given PDShadingType1(COSDictionary) with shadingDictionary is COSStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput_givenPDShadingType1WithShadingDictionaryIsCOSStream()
      throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        IOException.class,
        () ->
            new PDShadingType1(new COSStream())
                .evalFunction(new float[] {10.0f, 0.0f, 10.0f, 0.0f}));
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   *
   * <ul>
   *   <li>Then return empty array of {@code float}.
   * </ul>
   *
   * <p>Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName("Test evalFunction(float[]) with 'input'; then return empty array of float")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput_thenReturnEmptyArrayOfFloat() throws IOException {
    // Arrange
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cOSDictionary.getFloat(Mockito.<COSName>any())).thenReturn(10.0f);
    when(cOSDictionary.getInt(Mockito.<COSName>any())).thenReturn(2);
    when(cOSDictionary.getCOSArray(Mockito.<COSName>any())).thenReturn(new COSArray());
    when(cOSDictionary.getDictionaryObject(Mockito.<COSName>any())).thenReturn(cOSDictionary);

    // Act
    float[] actualEvalFunctionResult =
        pDShadingType1.evalFunction(new float[] {10.0f, 0.0f, 10.0f, 0.0f});

    // Assert
    verify(cOSDictionary, atLeast(1)).getCOSArray(Mockito.<COSName>any());
    verify(cOSDictionary).getDictionaryObject(isA(COSName.class));
    verify(cOSDictionary).getFloat(isA(COSName.class));
    verify(cOSDictionary).getInt(isA(COSName.class));
    assertArrayEquals(new float[] {}, actualEvalFunctionResult, 0.0f);
  }
}
