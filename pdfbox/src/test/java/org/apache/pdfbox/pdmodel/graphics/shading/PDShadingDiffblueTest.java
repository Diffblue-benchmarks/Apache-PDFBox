package org.apache.pdfbox.pdmodel.graphics.shading;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBoolean;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSIncrement;
import org.apache.pdfbox.cos.COSObjectKey;
import org.apache.pdfbox.cos.COSStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.function.PDFunction;
import org.apache.pdfbox.pdmodel.common.function.PDFunctionType0;
import org.apache.pdfbox.pdmodel.graphics.color.PDCalGray;
import org.apache.pdfbox.pdmodel.graphics.color.PDColorSpace;
import org.apache.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import org.apache.pdfbox.util.Matrix;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDShadingDiffblueTest {
  /**
   * Test {@link PDShading#getCOSObject()}.
   * <p>
   * Method under test: {@link PDShading#getCOSObject()}
   */
  @Test
  @DisplayName("Test getCOSObject()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSDictionary PDShading.getCOSObject()"})
  void testGetCOSObject() {
    // Arrange
    COSDictionary shadingDictionary = new COSDictionary();

    // Act and Assert
    assertSame(shadingDictionary, (new PDShadingType1(shadingDictionary)).getCOSObject());
  }

  /**
   * Test {@link PDShading#getType()}.
   * <p>
   * Method under test: {@link PDShading#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String PDShading.getType()"})
  void testGetType() {
    // Arrange, Act and Assert
    assertEquals("Shading", (new PDShadingType1(new COSDictionary())).getType());
  }

  /**
   * Test {@link PDShading#setShadingType(int)}.
   * <p>
   * Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  @DisplayName("Test setShadingType(int)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#setShadingType(int)}
   */
  @Test
  @DisplayName("Test setShadingType(int); when MIN_VALUE")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setBackground(COSArray)}
   */
  @Test
  @DisplayName("Test setBackground(COSArray)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link PDShading#getBackground()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#getBackground()}
   */
  @Test
  @DisplayName("Test getBackground(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"COSArray PDShading.getBackground()"})
  void testGetBackground_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getBackground());
  }

  /**
   * Test {@link PDShading#getBBox()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDRectangle PDShading.getBBox()"})
  void testGetBBox_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getBBox());
  }

  /**
   * Test {@link PDShading#setBBox(PDRectangle)}.
   * <p>
   * Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShading.setBBox(PDRectangle)"})
  void testSetBBox() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDRectangle newBBox = PDRectangle.A1;

    // Act
    pdShadingType1.setBBox(newBBox);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDRectangle expectedBBox = newBBox.A1;
    assertSame(expectedBBox, pdShadingType1.getBBox());
  }

  /**
   * Test {@link PDShading#setBBox(PDRectangle)}.
   * <p>
   * Method under test: {@link PDShading#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#getBounds(AffineTransform, Matrix)}
   */
  @Test
  @DisplayName("Test getBounds(AffineTransform, Matrix)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  @DisplayName("Test setAntiAlias(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is {@link COSDictionary#COSDictionary()} AntiAlias.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#setAntiAlias(boolean)}
   */
  @Test
  @DisplayName("Test setAntiAlias(boolean); then PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary() AntiAlias")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName("Test getAntiAlias()")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link PDShadingType1#PDShadingType1(COSDictionary)} with shadingDictionary is {@link COSDictionary#COSDictionary()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName("Test getAntiAlias(); given PDShadingType1(COSDictionary) with shadingDictionary is COSDictionary()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_givenPDShadingType1WithShadingDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertFalse((new PDShadingType1(new COSDictionary())).getAntiAlias());
  }

  /**
   * Test {@link PDShading#getAntiAlias()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#getAntiAlias()}
   */
  @Test
  @DisplayName("Test getAntiAlias(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PDShading.getAntiAlias()"})
  void testGetAntiAlias_thenReturnTrue() {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    pdShadingType1.setAntiAlias(true);

    // Act and Assert
    assertTrue(pdShadingType1.getAntiAlias());
  }

  /**
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShading.setColorSpace(PDColorSpace)"})
  void testSetColorSpace() throws IOException {
    // Arrange
    PDShadingType1 pdShadingType1 = new PDShadingType1(new COSDictionary());
    PDDeviceGray colorSpace = PDDeviceGray.INSTANCE;

    // Act
    pdShadingType1.setColorSpace(colorSpace);

    // Assert
    COSDictionary cOSObject = pdShadingType1.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    PDDeviceGray expectedColorSpace = colorSpace.INSTANCE;
    assertSame(expectedColorSpace, pdShadingType1.getColorSpace());
  }

  /**
   * Test {@link PDShading#setColorSpace(PDColorSpace)}.
   * <p>
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setColorSpace(PDColorSpace)}
   */
  @Test
  @DisplayName("Test setColorSpace(PDColorSpace)")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link PDShading#create(COSDictionary)}.
   * <ul>
   *   <li>When {@link COSDictionary#COSDictionary()}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#create(COSDictionary)}
   */
  @Test
  @DisplayName("Test create(COSDictionary); when COSDictionary(); then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDShading PDShading.create(COSDictionary)"})
  void testCreate_whenCOSDictionary_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> PDShading.create(new COSDictionary()));
  }

  /**
   * Test {@link PDShading#setFunction(PDFunction)} with {@code newFunction}.
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link COSObjectKey#COSObjectKey(long, int)} with num is one and gen is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'; given COSObjectKey(long, int) with num is one and gen is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShading.setFunction(PDFunction)"})
  void testSetFunctionWithNewFunction_givenCOSObjectKeyWithNumIsOneAndGenIsOne() throws IOException {
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
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link COSDictionary#COSDictionary()} Direct is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'; given 'true'; when COSDictionary() Direct is 'true'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#setFunction(PDFunction)}
   */
  @Test
  @DisplayName("Test setFunction(PDFunction) with 'newFunction'; when 'null'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void PDShading.setFunction(COSArray)"})
  void testSetFunctionWithNewFunctions() {
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
   * Test {@link PDShading#setFunction(COSArray)} with {@code newFunctions}.
   * <p>
   * Method under test: {@link PDShading#setFunction(COSArray)}
   */
  @Test
  @DisplayName("Test setFunction(COSArray) with 'newFunctions'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link PDShading#getFunction()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#getFunction()}
   */
  @Test
  @DisplayName("Test getFunction(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PDFunction PDShading.getFunction()"})
  void testGetFunction_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull((new PDShadingType1(new COSDictionary())).getFunction());
  }

  /**
   * Test {@link PDShading#evalFunction(float)} with {@code inputValue}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#evalFunction(float)}
   */
  @Test
  @DisplayName("Test evalFunction(float) with 'inputValue'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDShading.evalFunction(float)"})
  void testEvalFunctionWithInputValue_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class, () -> (new PDShadingType1(new COSDictionary())).evalFunction(10.0f));
  }

  /**
   * Test {@link PDShading#evalFunction(float[])} with {@code input}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PDShading#evalFunction(float[])}
   */
  @Test
  @DisplayName("Test evalFunction(float[]) with 'input'; then throw IOException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"float[] PDShading.evalFunction(float[])"})
  void testEvalFunctionWithInput_thenThrowIOException() throws IOException {
    // Arrange, Act and Assert
    assertThrows(IOException.class,
        () -> (new PDShadingType1(new COSDictionary())).evalFunction(new float[]{10.0f, 0.0f, 10.0f, 0.0f}));
  }
}
