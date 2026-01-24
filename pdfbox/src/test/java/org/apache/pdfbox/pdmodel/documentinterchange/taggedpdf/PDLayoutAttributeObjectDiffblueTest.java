package org.apache.pdfbox.pdmodel.documentinterchange.taggedpdf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.color.PDGamma;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class PDLayoutAttributeObjectDiffblueTest {
  /**
   * Test {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#PDLayoutAttributeObject(COSDictionary)}
   */
  @Test
  @DisplayName("Test new PDLayoutAttributeObject(COSDictionary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.<init>(COSDictionary)"})
  void testNewPDLayoutAttributeObject() {
    // Arrange
    COSDictionary dictionary = new COSDictionary();

    // Act and Assert
    assertSame(dictionary, new PDLayoutAttributeObject(dictionary).getCOSObject());
  }

  /**
   * Test {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}
   */
  @Test
  @DisplayName("Test new PDLayoutAttributeObject()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.<init>()"})
  void testNewPDLayoutAttributeObject2() {
    // Arrange and Act
    PDLayoutAttributeObject actualPdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Assert
    assertNull(actualPdLayoutAttributeObject.getBorderColors());
    assertNull(actualPdLayoutAttributeObject.getBorderThickness());
    assertNull(actualPdLayoutAttributeObject.getColumnGap());
    assertNull(actualPdLayoutAttributeObject.getColumnWidths());
    assertNull(actualPdLayoutAttributeObject.getBBox());
    assertNull(actualPdLayoutAttributeObject.getBackgroundColor());
    assertNull(actualPdLayoutAttributeObject.getColor());
    assertNull(actualPdLayoutAttributeObject.getTextDecorationColor());
    assertEquals(-1.0f, actualPdLayoutAttributeObject.getTextDecorationThickness());
    assertEquals(0.0f, ((Float) actualPdLayoutAttributeObject.getPadding()).floatValue());
    assertEquals(0.0f, ((Float) actualPdLayoutAttributeObject.getTPadding()).floatValue());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getBaselineShift());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getEndIndent());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getSpaceAfter());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getSpaceBefore());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getStartIndent());
    assertEquals(0.0f, actualPdLayoutAttributeObject.getTextIndent());
    assertEquals(1, actualPdLayoutAttributeObject.getColumnCount());
    assertTrue(actualPdLayoutAttributeObject.isEmpty());
    assertEquals(
        PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, actualPdLayoutAttributeObject.getBlockAlign());
    assertEquals(
        PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE,
        actualPdLayoutAttributeObject.getRubyPosition());
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE,
        actualPdLayoutAttributeObject.getTextDecorationType());
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdLayoutAttributeObject.getBorderStyle());
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE, actualPdLayoutAttributeObject.getTBorderStyle());
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdLayoutAttributeObject.getGlyphOrientationVertical());
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdLayoutAttributeObject.getHeight());
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        actualPdLayoutAttributeObject.getWidth());
    assertEquals(
        PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdLayoutAttributeObject.getInlineAlign());
    assertEquals(
        PDLayoutAttributeObject.INLINE_ALIGN_START, actualPdLayoutAttributeObject.getTextAlign());
    assertEquals(
        PDLayoutAttributeObject.LINE_HEIGHT_NORMAL, actualPdLayoutAttributeObject.getLineHeight());
    assertEquals(PDLayoutAttributeObject.OWNER_LAYOUT, actualPdLayoutAttributeObject.getOwner());
    assertEquals(
        PDLayoutAttributeObject.PLACEMENT_INLINE, actualPdLayoutAttributeObject.getPlacement());
    assertEquals(
        PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE,
        actualPdLayoutAttributeObject.getRubyAlign());
    assertEquals(
        PDLayoutAttributeObject.WRITING_MODE_LRTB, actualPdLayoutAttributeObject.getWritingMode());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getPlacement()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#PLACEMENT_INLINE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getPlacement()}
   */
  @Test
  @DisplayName("Test getPlacement(); given PDLayoutAttributeObject(); then return PLACEMENT_INLINE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getPlacement()"})
  void testGetPlacement_givenPDLayoutAttributeObject_thenReturnPlacement_inline() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.PLACEMENT_INLINE, new PDLayoutAttributeObject().getPlacement());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setPlacement(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Placement is {@code
   *       Placement}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setPlacement(String)}
   */
  @Test
  @DisplayName("Test setPlacement(String); then PDLayoutAttributeObject() Placement is 'Placement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setPlacement(String)"})
  void testSetPlacement_thenPDLayoutAttributeObjectPlacementIsPlacement() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setPlacement("Placement");

    // Assert
    assertEquals("Placement", pdLayoutAttributeObject.getPlacement());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setPlacement(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Placement is {@code
   *       PlacementPlacement}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setPlacement(String)}
   */
  @Test
  @DisplayName(
      "Test setPlacement(String); then PDLayoutAttributeObject() Placement is 'PlacementPlacement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setPlacement(String)"})
  void testSetPlacement_thenPDLayoutAttributeObjectPlacementIsPlacementPlacement() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setPlacement("PlacementPlacement");

    // Assert
    assertEquals("PlacementPlacement", pdLayoutAttributeObject.getPlacement());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getWritingMode()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#WRITING_MODE_LRTB}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getWritingMode()}
   */
  @Test
  @DisplayName(
      "Test getWritingMode(); given PDLayoutAttributeObject(); then return WRITING_MODE_LRTB")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getWritingMode()"})
  void testGetWritingMode_givenPDLayoutAttributeObject_thenReturnWriting_mode_lrtb() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.WRITING_MODE_LRTB, new PDLayoutAttributeObject().getWritingMode());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setWritingMode(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} WritingMode is {@code
   *       Writing Mode}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setWritingMode(String)}
   */
  @Test
  @DisplayName(
      "Test setWritingMode(String); then PDLayoutAttributeObject() WritingMode is 'Writing Mode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setWritingMode(String)"})
  void testSetWritingMode_thenPDLayoutAttributeObjectWritingModeIsWritingMode() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setWritingMode("Writing Mode");

    // Assert
    assertEquals("Writing Mode", pdLayoutAttributeObject.getWritingMode());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBackgroundColor()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBackgroundColor()}
   */
  @Test
  @DisplayName("Test getBackgroundColor(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDLayoutAttributeObject.getBackgroundColor()"})
  void testGetBackgroundColor_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getBackgroundColor());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BackgroundColor B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setBackgroundColor(PDGamma); then PDLayoutAttributeObject() BackgroundColor B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBackgroundColor(PDGamma)"})
  void testSetBackgroundColor_thenPDLayoutAttributeObjectBackgroundColorBIsZero() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBackgroundColor(new PDGamma());

    // Assert
    PDGamma backgroundColor = pdLayoutAttributeObject.getBackgroundColor();
    assertEquals(0.0f, backgroundColor.getB());
    assertEquals(0.0f, backgroundColor.getG());
    assertEquals(0.0f, backgroundColor.getR());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBackgroundColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setBackgroundColor(PDGamma); then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBackgroundColor(PDGamma)"})
  void testSetBackgroundColor_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBackgroundColor(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBorderColors()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()} addAll {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBorderColors()}
   */
  @Test
  @DisplayName(
      "Test getBorderColors(); given COSDictionary(COSDictionary) with dict is COSDictionary() addAll COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getBorderColors()"})
  void testGetBorderColors_givenCOSDictionaryWithDictIsCOSDictionaryAddAllCOSDictionary() {
    // Arrange
    COSDictionary dictionary = new COSDictionary(new COSDictionary());
    dictionary.addAll(new COSDictionary());

    // Act and Assert
    assertNull(new PDLayoutAttributeObject(dictionary).getBorderColors());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBorderColors()}.
   *
   * <ul>
   *   <li>Given {@link COSDictionary#COSDictionary(COSDictionary)} with dict is {@link
   *       COSDictionary#COSDictionary()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBorderColors()}
   */
  @Test
  @DisplayName(
      "Test getBorderColors(); given COSDictionary(COSDictionary) with dict is COSDictionary(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getBorderColors()"})
  void testGetBorderColors_givenCOSDictionaryWithDictIsCOSDictionary_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new PDLayoutAttributeObject(new COSDictionary(new COSDictionary())).getBorderColors());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBorderColors()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBorderColors()}
   */
  @Test
  @DisplayName("Test getBorderColors(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getBorderColors()"})
  void testGetBorderColors_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getBorderColors());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BorderColors {@link
   *       PDGamma}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setAllBorderColors(PDGamma); then PDLayoutAttributeObject() BorderColors PDGamma")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderColors(PDGamma)"})
  void testSetAllBorderColors_thenPDLayoutAttributeObjectBorderColorsPDGamma() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderColors(new PDGamma());

    // Assert
    Object borderColors = pdLayoutAttributeObject.getBorderColors();
    assertTrue(borderColors instanceof PDGamma);
    assertEquals(0.0f, ((PDGamma) borderColors).getB());
    assertEquals(0.0f, ((PDGamma) borderColors).getG());
    assertEquals(0.0f, ((PDGamma) borderColors).getR());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderColors(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setAllBorderColors(PDGamma); then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderColors(PDGamma)"})
  void testSetAllBorderColors_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderColors(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BorderColors {@link
   *       PDFourColours}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}
   */
  @Test
  @DisplayName(
      "Test setBorderColors(PDFourColours); then PDLayoutAttributeObject() BorderColors PDFourColours")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBorderColors(PDFourColours)"})
  void testSetBorderColors_thenPDLayoutAttributeObjectBorderColorsPDFourColours() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBorderColors(new PDFourColours());

    // Assert
    Object borderColors = pdLayoutAttributeObject.getBorderColors();
    assertTrue(borderColors instanceof PDFourColours);
    assertNull(((PDFourColours) borderColors).getAfterColour());
    assertNull(((PDFourColours) borderColors).getBeforeColour());
    assertNull(((PDFourColours) borderColors).getEndColour());
    assertNull(((PDFourColours) borderColors).getStartColour());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBorderColors(PDFourColours)}
   */
  @Test
  @DisplayName(
      "Test setBorderColors(PDFourColours); when 'null'; then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBorderColors(PDFourColours)"})
  void testSetBorderColors_whenNull_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBorderColors(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBorderStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#BORDER_STYLE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBorderStyle()}
   */
  @Test
  @DisplayName(
      "Test getBorderStyle(); given PDLayoutAttributeObject(); then return BORDER_STYLE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getBorderStyle()"})
  void testGetBorderStyle_givenPDLayoutAttributeObject_thenReturnBorder_style_none() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE, new PDLayoutAttributeObject().getBorderStyle());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderStyles(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BorderStyle is {@code
   *       Border Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderStyles(String)}
   */
  @Test
  @DisplayName(
      "Test setAllBorderStyles(String); then PDLayoutAttributeObject() BorderStyle is 'Border Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderStyles(String)"})
  void testSetAllBorderStyles_thenPDLayoutAttributeObjectBorderStyleIsBorderStyle() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderStyles("Border Style");

    // Assert
    assertEquals("Border Style", pdLayoutAttributeObject.getBorderStyle());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBorderThickness()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBorderThickness()}
   */
  @Test
  @DisplayName("Test getBorderThickness(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getBorderThickness()"})
  void testGetBorderThickness_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getBorderThickness());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderThicknesses(float)} with {@code float}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderThicknesses(float)}
   */
  @Test
  @DisplayName("Test setAllBorderThicknesses(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderThicknesses(float)"})
  void testSetAllBorderThicknessesWithFloat() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderThicknesses(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getBorderThickness()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)}
   */
  @Test
  @DisplayName("Test setAllBorderThicknesses(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderThicknesses(int)"})
  void testSetAllBorderThicknessesWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderThicknesses(1);

    // Assert
    assertEquals(1.0f, ((Float) pdLayoutAttributeObject.getBorderThickness()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllBorderThicknesses(int)}
   */
  @Test
  @DisplayName("Test setAllBorderThicknesses(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllBorderThicknesses(int)"})
  void testSetAllBorderThicknessesWithInt2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllBorderThicknesses(Integer.MIN_VALUE);

    // Assert
    assertEquals(
        -2.14748365E9f, ((Float) pdLayoutAttributeObject.getBorderThickness()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getPadding()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getPadding()}
   */
  @Test
  @DisplayName("Test getPadding(); given PDLayoutAttributeObject(); then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getPadding()"})
  void testGetPadding_givenPDLayoutAttributeObject_thenReturnFloatValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, ((Float) new PDLayoutAttributeObject().getPadding()).floatValue());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllPaddings(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Padding floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllPaddings(float)}
   */
  @Test
  @DisplayName(
      "Test setAllPaddings(float) with 'float'; then PDLayoutAttributeObject() Padding floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllPaddings(float)"})
  void testSetAllPaddingsWithFloat_thenPDLayoutAttributeObjectPaddingFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllPaddings(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getPadding()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllPaddings(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllPaddings(int)}
   */
  @Test
  @DisplayName("Test setAllPaddings(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllPaddings(int)"})
  void testSetAllPaddingsWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllPaddings(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getPadding()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllPaddings(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Padding floatValue is two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllPaddings(int)}
   */
  @Test
  @DisplayName(
      "Test setAllPaddings(int) with 'int'; then PDLayoutAttributeObject() Padding floatValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllPaddings(int)"})
  void testSetAllPaddingsWithInt_thenPDLayoutAttributeObjectPaddingFloatValueIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllPaddings(2);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2.0f, ((Float) pdLayoutAttributeObject.getPadding()).floatValue());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getColor()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getColor()}
   */
  @Test
  @DisplayName("Test getColor(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDLayoutAttributeObject.getColor()"})
  void testGetColor_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getColor());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColor(PDGamma)} with {@code color}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setColor(PDGamma) with 'color'; then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColor(PDGamma)"})
  void testSetColorWithColor_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColor(PDGamma)} with {@code color}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Color B is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setColor(PDGamma) with 'color'; then PDLayoutAttributeObject() Color B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColor(PDGamma)"})
  void testSetColorWithColor_thenPDLayoutAttributeObjectColorBIsZero() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColor(new PDGamma());

    // Assert
    PDGamma color = pdLayoutAttributeObject.getColor();
    assertEquals(0.0f, color.getB());
    assertEquals(0.0f, color.getG());
    assertEquals(0.0f, color.getR());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getSpaceBefore()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getSpaceBefore()}
   */
  @Test
  @DisplayName("Test getSpaceBefore(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getSpaceBefore()"})
  void testGetSpaceBefore_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getSpaceBefore());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceBefore(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceBefore is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(float)}
   */
  @Test
  @DisplayName(
      "Test setSpaceBefore(float) with 'float'; then PDLayoutAttributeObject() SpaceBefore is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceBefore(float)"})
  void testSetSpaceBeforeWithFloat_thenPDLayoutAttributeObjectSpaceBeforeIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceBefore(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getSpaceBefore());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceBefore(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceBefore is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(int)}
   */
  @Test
  @DisplayName(
      "Test setSpaceBefore(int) with 'int'; then PDLayoutAttributeObject() SpaceBefore is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceBefore(int)"})
  void testSetSpaceBeforeWithInt_thenPDLayoutAttributeObjectSpaceBeforeIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceBefore(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getSpaceBefore());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceBefore(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceBefore is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceBefore(int)}
   */
  @Test
  @DisplayName(
      "Test setSpaceBefore(int) with 'int'; then PDLayoutAttributeObject() SpaceBefore is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceBefore(int)"})
  void testSetSpaceBeforeWithInt_thenPDLayoutAttributeObjectSpaceBeforeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceBefore(1);

    // Assert
    assertEquals(1.0f, pdLayoutAttributeObject.getSpaceBefore());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getSpaceAfter()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getSpaceAfter()}
   */
  @Test
  @DisplayName("Test getSpaceAfter(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getSpaceAfter()"})
  void testGetSpaceAfter_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getSpaceAfter());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceAfter(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceAfter is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(float)}
   */
  @Test
  @DisplayName(
      "Test setSpaceAfter(float) with 'float'; then PDLayoutAttributeObject() SpaceAfter is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceAfter(float)"})
  void testSetSpaceAfterWithFloat_thenPDLayoutAttributeObjectSpaceAfterIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceAfter(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getSpaceAfter());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceAfter(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceAfter is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(int)}
   */
  @Test
  @DisplayName(
      "Test setSpaceAfter(int) with 'int'; then PDLayoutAttributeObject() SpaceAfter is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceAfter(int)"})
  void testSetSpaceAfterWithInt_thenPDLayoutAttributeObjectSpaceAfterIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceAfter(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getSpaceAfter());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setSpaceAfter(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} SpaceAfter is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setSpaceAfter(int)}
   */
  @Test
  @DisplayName(
      "Test setSpaceAfter(int) with 'int'; then PDLayoutAttributeObject() SpaceAfter is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setSpaceAfter(int)"})
  void testSetSpaceAfterWithInt_thenPDLayoutAttributeObjectSpaceAfterIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setSpaceAfter(1);

    // Assert
    assertEquals(1.0f, pdLayoutAttributeObject.getSpaceAfter());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getStartIndent()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getStartIndent()}
   */
  @Test
  @DisplayName("Test getStartIndent(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getStartIndent()"})
  void testGetStartIndent_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getStartIndent());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setStartIndent(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} StartIndent is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setStartIndent(float)}
   */
  @Test
  @DisplayName(
      "Test setStartIndent(float) with 'float'; then PDLayoutAttributeObject() StartIndent is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setStartIndent(float)"})
  void testSetStartIndentWithFloat_thenPDLayoutAttributeObjectStartIndentIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setStartIndent(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getStartIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setStartIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} StartIndent is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setStartIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setStartIndent(int) with 'int'; then PDLayoutAttributeObject() StartIndent is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setStartIndent(int)"})
  void testSetStartIndentWithInt_thenPDLayoutAttributeObjectStartIndentIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setStartIndent(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getStartIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setStartIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} StartIndent is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setStartIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setStartIndent(int) with 'int'; then PDLayoutAttributeObject() StartIndent is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setStartIndent(int)"})
  void testSetStartIndentWithInt_thenPDLayoutAttributeObjectStartIndentIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setStartIndent(1);

    // Assert
    assertEquals(1.0f, pdLayoutAttributeObject.getStartIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getEndIndent()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getEndIndent()}
   */
  @Test
  @DisplayName("Test getEndIndent(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getEndIndent()"})
  void testGetEndIndent_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getEndIndent());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setEndIndent(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} EndIndent is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setEndIndent(float)}
   */
  @Test
  @DisplayName(
      "Test setEndIndent(float) with 'float'; then PDLayoutAttributeObject() EndIndent is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setEndIndent(float)"})
  void testSetEndIndentWithFloat_thenPDLayoutAttributeObjectEndIndentIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setEndIndent(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getEndIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setEndIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} EndIndent is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setEndIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setEndIndent(int) with 'int'; then PDLayoutAttributeObject() EndIndent is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setEndIndent(int)"})
  void testSetEndIndentWithInt_thenPDLayoutAttributeObjectEndIndentIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setEndIndent(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getEndIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setEndIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} EndIndent is three.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setEndIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setEndIndent(int) with 'int'; then PDLayoutAttributeObject() EndIndent is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setEndIndent(int)"})
  void testSetEndIndentWithInt_thenPDLayoutAttributeObjectEndIndentIsThree() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setEndIndent(3);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3.0f, pdLayoutAttributeObject.getEndIndent());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTextIndent()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTextIndent()}
   */
  @Test
  @DisplayName("Test getTextIndent(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getTextIndent()"})
  void testGetTextIndent_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getTextIndent());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextIndent(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TextIndent is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextIndent(float)}
   */
  @Test
  @DisplayName(
      "Test setTextIndent(float) with 'float'; then PDLayoutAttributeObject() TextIndent is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextIndent(float)"})
  void testSetTextIndentWithFloat_thenPDLayoutAttributeObjectTextIndentIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextIndent(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getTextIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TextIndent is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setTextIndent(int) with 'int'; then PDLayoutAttributeObject() TextIndent is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextIndent(int)"})
  void testSetTextIndentWithInt_thenPDLayoutAttributeObjectTextIndentIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextIndent(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getTextIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextIndent(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TextIndent is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextIndent(int)}
   */
  @Test
  @DisplayName(
      "Test setTextIndent(int) with 'int'; then PDLayoutAttributeObject() TextIndent is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextIndent(int)"})
  void testSetTextIndentWithInt_thenPDLayoutAttributeObjectTextIndentIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextIndent(1);

    // Assert
    assertEquals(1.0f, pdLayoutAttributeObject.getTextIndent());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTextAlign()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#INLINE_ALIGN_START}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTextAlign()}
   */
  @Test
  @DisplayName(
      "Test getTextAlign(); given PDLayoutAttributeObject(); then return INLINE_ALIGN_START")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getTextAlign()"})
  void testGetTextAlign_givenPDLayoutAttributeObject_thenReturnInline_align_start() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.INLINE_ALIGN_START, new PDLayoutAttributeObject().getTextAlign());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextAlign(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TextAlign is {@code Text
   *       Indent}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextAlign(String)}
   */
  @Test
  @DisplayName(
      "Test setTextAlign(String); then PDLayoutAttributeObject() TextAlign is 'Text Indent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextAlign(String)"})
  void testSetTextAlign_thenPDLayoutAttributeObjectTextAlignIsTextIndent() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextAlign("Text Indent");

    // Assert
    assertEquals("Text Indent", pdLayoutAttributeObject.getTextAlign());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBBox()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBBox()}
   */
  @Test
  @DisplayName("Test getBBox(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDRectangle PDLayoutAttributeObject.getBBox()"})
  void testGetBBox_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getBBox());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BBox LowerLeftX is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName("Test setBBox(PDRectangle); then PDLayoutAttributeObject() BBox LowerLeftX is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBBox(PDRectangle)"})
  void testSetBBox_thenPDLayoutAttributeObjectBBoxLowerLeftXIsZero() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBBox(PDRectangle.A0);

    // Assert
    PDRectangle bBox = pdLayoutAttributeObject.getBBox();
    assertEquals(0.0f, bBox.getLowerLeftX());
    assertEquals(0.0f, bBox.getLowerLeftY());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2383.937f, bBox.getUpperRightX());
    assertEquals(2383.937f, bBox.getWidth());
    assertEquals(3370.3938f, bBox.getHeight());
    assertEquals(3370.3938f, bBox.getUpperRightY());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    COSArray expectedCOSObject = bBox.getCOSArray();
    assertSame(expectedCOSObject, bBox.getCOSObject());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBBox(PDRectangle)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBBox(PDRectangle)}
   */
  @Test
  @DisplayName(
      "Test setBBox(PDRectangle); when 'null'; then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBBox(PDRectangle)"})
  void testSetBBox_whenNull_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBBox(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getWidth()}.
   *
   * <ul>
   *   <li>Then return {@link PDLayoutAttributeObject#GLYPH_ORIENTATION_VERTICAL_AUTO}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getWidth()}
   */
  @Test
  @DisplayName("Test getWidth(); then return GLYPH_ORIENTATION_VERTICAL_AUTO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getWidth()"})
  void testGetWidth_thenReturnGlyph_orientation_vertical_auto() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        new PDLayoutAttributeObject().getWidth());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setWidthAuto()}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setWidthAuto()}
   */
  @Test
  @DisplayName("Test setWidthAuto(); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setWidthAuto()"})
  void testSetWidthAuto_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setWidthAuto();

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setWidth(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Width floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setWidth(float)}
   */
  @Test
  @DisplayName(
      "Test setWidth(float) with 'float'; then PDLayoutAttributeObject() Width floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setWidth(float)"})
  void testSetWidthWithFloat_thenPDLayoutAttributeObjectWidthFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setWidth(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getWidth()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setWidth(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Width floatValue is {@code
   *       -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setWidth(int)}
   */
  @Test
  @DisplayName(
      "Test setWidth(int) with 'int'; then PDLayoutAttributeObject() Width floatValue is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setWidth(int)"})
  void testSetWidthWithInt_thenPDLayoutAttributeObjectWidthFloatValueIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setWidth(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getWidth()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setWidth(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Width floatValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setWidth(int)}
   */
  @Test
  @DisplayName(
      "Test setWidth(int) with 'int'; then PDLayoutAttributeObject() Width floatValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setWidth(int)"})
  void testSetWidthWithInt_thenPDLayoutAttributeObjectWidthFloatValueIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setWidth(1);

    // Assert
    assertEquals(1.0f, ((Float) pdLayoutAttributeObject.getWidth()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getHeight()}.
   *
   * <ul>
   *   <li>Then return {@link PDLayoutAttributeObject#GLYPH_ORIENTATION_VERTICAL_AUTO}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getHeight()}
   */
  @Test
  @DisplayName("Test getHeight(); then return GLYPH_ORIENTATION_VERTICAL_AUTO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getHeight()"})
  void testGetHeight_thenReturnGlyph_orientation_vertical_auto() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        new PDLayoutAttributeObject().getHeight());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setHeightAuto()}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setHeightAuto()}
   */
  @Test
  @DisplayName("Test setHeightAuto(); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setHeightAuto()"})
  void testSetHeightAuto_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setHeightAuto();

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setHeight(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Height floatValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setHeight(float)}
   */
  @Test
  @DisplayName(
      "Test setHeight(float) with 'float'; then PDLayoutAttributeObject() Height floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setHeight(float)"})
  void testSetHeightWithFloat_thenPDLayoutAttributeObjectHeightFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setHeight(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getHeight()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setHeight(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Height floatValue is
   *       {@code -2.14748365E9}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setHeight(int)}
   */
  @Test
  @DisplayName(
      "Test setHeight(int) with 'int'; then PDLayoutAttributeObject() Height floatValue is '-2.14748365E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setHeight(int)"})
  void testSetHeightWithInt_thenPDLayoutAttributeObjectHeightFloatValueIs214748365e9() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setHeight(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getHeight()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setHeight(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} Height floatValue is one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setHeight(int)}
   */
  @Test
  @DisplayName(
      "Test setHeight(int) with 'int'; then PDLayoutAttributeObject() Height floatValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setHeight(int)"})
  void testSetHeightWithInt_thenPDLayoutAttributeObjectHeightFloatValueIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setHeight(1);

    // Assert
    assertEquals(1.0f, ((Float) pdLayoutAttributeObject.getHeight()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBlockAlign()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#BLOCK_ALIGN_BEFORE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBlockAlign()}
   */
  @Test
  @DisplayName(
      "Test getBlockAlign(); given PDLayoutAttributeObject(); then return BLOCK_ALIGN_BEFORE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getBlockAlign()"})
  void testGetBlockAlign_givenPDLayoutAttributeObject_thenReturnBlock_align_before() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE, new PDLayoutAttributeObject().getBlockAlign());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBlockAlign(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BlockAlign is {@code Block
   *       Align}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBlockAlign(String)}
   */
  @Test
  @DisplayName(
      "Test setBlockAlign(String); then PDLayoutAttributeObject() BlockAlign is 'Block Align'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBlockAlign(String)"})
  void testSetBlockAlign_thenPDLayoutAttributeObjectBlockAlignIsBlockAlign() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBlockAlign("Block Align");

    // Assert
    assertEquals("Block Align", pdLayoutAttributeObject.getBlockAlign());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getInlineAlign()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#INLINE_ALIGN_START}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getInlineAlign()}
   */
  @Test
  @DisplayName(
      "Test getInlineAlign(); given PDLayoutAttributeObject(); then return INLINE_ALIGN_START")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getInlineAlign()"})
  void testGetInlineAlign_givenPDLayoutAttributeObject_thenReturnInline_align_start() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.INLINE_ALIGN_START, new PDLayoutAttributeObject().getInlineAlign());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setInlineAlign(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} InlineAlign is {@code
   *       Inline Align}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setInlineAlign(String)}
   */
  @Test
  @DisplayName(
      "Test setInlineAlign(String); then PDLayoutAttributeObject() InlineAlign is 'Inline Align'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setInlineAlign(String)"})
  void testSetInlineAlign_thenPDLayoutAttributeObjectInlineAlignIsInlineAlign() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setInlineAlign("Inline Align");

    // Assert
    assertEquals("Inline Align", pdLayoutAttributeObject.getInlineAlign());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTBorderStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with
   *       owner is {@code 42RowSpan42}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTBorderStyle()}
   */
  @Test
  @DisplayName(
      "Test getTBorderStyle(); given PDExportFormatAttributeObject(String) with owner is '42RowSpan42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getTBorderStyle()"})
  void testGetTBorderStyle_givenPDExportFormatAttributeObjectWithOwnerIs42RowSpan42() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE,
        new PDExportFormatAttributeObject("42RowSpan42").getTBorderStyle());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTBorderStyle()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#BORDER_STYLE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTBorderStyle()}
   */
  @Test
  @DisplayName(
      "Test getTBorderStyle(); given PDLayoutAttributeObject(); then return BORDER_STYLE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getTBorderStyle()"})
  void testGetTBorderStyle_givenPDLayoutAttributeObject_thenReturnBorder_style_none() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE, new PDLayoutAttributeObject().getTBorderStyle());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllTBorderStyles(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TBorderStyle is {@code T
   *       Border Style}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllTBorderStyles(String)}
   */
  @Test
  @DisplayName(
      "Test setAllTBorderStyles(String); then PDLayoutAttributeObject() TBorderStyle is 'T Border Style'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllTBorderStyles(String)"})
  void testSetAllTBorderStyles_thenPDLayoutAttributeObjectTBorderStyleIsTBorderStyle() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllTBorderStyles("T Border Style");

    // Assert
    assertEquals("T Border Style", pdLayoutAttributeObject.getTBorderStyle());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTPadding()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTPadding()}
   */
  @Test
  @DisplayName(
      "Test getTPadding(); given PDLayoutAttributeObject(); then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getTPadding()"})
  void testGetTPadding_givenPDLayoutAttributeObject_thenReturnFloatValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, ((Float) new PDLayoutAttributeObject().getTPadding()).floatValue());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllTPaddings(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TPadding floatValue is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(float)}
   */
  @Test
  @DisplayName(
      "Test setAllTPaddings(float) with 'float'; then PDLayoutAttributeObject() TPadding floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllTPaddings(float)"})
  void testSetAllTPaddingsWithFloat_thenPDLayoutAttributeObjectTPaddingFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllTPaddings(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getTPadding()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllTPaddings(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(int)}
   */
  @Test
  @DisplayName("Test setAllTPaddings(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllTPaddings(int)"})
  void testSetAllTPaddingsWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllTPaddings(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getTPadding()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllTPaddings(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TPadding floatValue is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllTPaddings(int)}
   */
  @Test
  @DisplayName(
      "Test setAllTPaddings(int) with 'int'; then PDLayoutAttributeObject() TPadding floatValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllTPaddings(int)"})
  void testSetAllTPaddingsWithInt_thenPDLayoutAttributeObjectTPaddingFloatValueIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllTPaddings(2);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2.0f, ((Float) pdLayoutAttributeObject.getTPadding()).floatValue());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getBaselineShift()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getBaselineShift()}
   */
  @Test
  @DisplayName("Test getBaselineShift(); given PDLayoutAttributeObject(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getBaselineShift()"})
  void testGetBaselineShift_givenPDLayoutAttributeObject_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, new PDLayoutAttributeObject().getBaselineShift());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBaselineShift(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BaselineShift is ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBaselineShift(float)}
   */
  @Test
  @DisplayName(
      "Test setBaselineShift(float) with 'float'; then PDLayoutAttributeObject() BaselineShift is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBaselineShift(float)"})
  void testSetBaselineShiftWithFloat_thenPDLayoutAttributeObjectBaselineShiftIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBaselineShift(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getBaselineShift());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBaselineShift(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBaselineShift(int)}
   */
  @Test
  @DisplayName("Test setBaselineShift(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBaselineShift(int)"})
  void testSetBaselineShiftWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBaselineShift(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getBaselineShift());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setBaselineShift(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} BaselineShift is two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setBaselineShift(int)}
   */
  @Test
  @DisplayName(
      "Test setBaselineShift(int) with 'int'; then PDLayoutAttributeObject() BaselineShift is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setBaselineShift(int)"})
  void testSetBaselineShiftWithInt_thenPDLayoutAttributeObjectBaselineShiftIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setBaselineShift(2);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2.0f, pdLayoutAttributeObject.getBaselineShift());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getLineHeight()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#LINE_HEIGHT_NORMAL}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getLineHeight()}
   */
  @Test
  @DisplayName(
      "Test getLineHeight(); given PDLayoutAttributeObject(); then return LINE_HEIGHT_NORMAL")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getLineHeight()"})
  void testGetLineHeight_givenPDLayoutAttributeObject_thenReturnLine_height_normal() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.LINE_HEIGHT_NORMAL, new PDLayoutAttributeObject().getLineHeight());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setLineHeightNormal()}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setLineHeightNormal()}
   */
  @Test
  @DisplayName(
      "Test setLineHeightNormal(); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setLineHeightNormal()"})
  void testSetLineHeightNormal_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeightNormal();

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setLineHeightAuto()}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setLineHeightAuto()}
   */
  @Test
  @DisplayName(
      "Test setLineHeightAuto(); then PDLayoutAttributeObject() COSObject Values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setLineHeightAuto()"})
  void testSetLineHeightAuto_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeightAuto();

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        pdLayoutAttributeObject.getLineHeight());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setLineHeight(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} LineHeight floatValue is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setLineHeight(float)}
   */
  @Test
  @DisplayName(
      "Test setLineHeight(float) with 'float'; then PDLayoutAttributeObject() LineHeight floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setLineHeight(float)"})
  void testSetLineHeightWithFloat_thenPDLayoutAttributeObjectLineHeightFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeight(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getLineHeight()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setLineHeight(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setLineHeight(int)}
   */
  @Test
  @DisplayName("Test setLineHeight(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setLineHeight(int)"})
  void testSetLineHeightWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeight(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getLineHeight()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setLineHeight(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} LineHeight floatValue is
   *       two.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setLineHeight(int)}
   */
  @Test
  @DisplayName(
      "Test setLineHeight(int) with 'int'; then PDLayoutAttributeObject() LineHeight floatValue is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setLineHeight(int)"})
  void testSetLineHeightWithInt_thenPDLayoutAttributeObjectLineHeightFloatValueIsTwo() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setLineHeight(2);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(2.0f, ((Float) pdLayoutAttributeObject.getLineHeight()).floatValue());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTextDecorationColor()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTextDecorationColor()}
   */
  @Test
  @DisplayName("Test getTextDecorationColor(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PDGamma PDLayoutAttributeObject.getTextDecorationColor()"})
  void testGetTextDecorationColor_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getTextDecorationColor());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} COSObject Values size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setTextDecorationColor(PDGamma); then PDLayoutAttributeObject() COSObject Values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationColor(PDGamma)"})
  void testSetTextDecorationColor_thenPDLayoutAttributeObjectCOSObjectValuesSizeIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationColor(null);

    // Assert that nothing has changed
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(1, cOSObject.getValues().size());
    assertEquals(1, cOSObject.size());
    assertTrue(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} TextDecorationColor B is
   *       zero.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationColor(PDGamma)}
   */
  @Test
  @DisplayName(
      "Test setTextDecorationColor(PDGamma); then PDLayoutAttributeObject() TextDecorationColor B is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationColor(PDGamma)"})
  void testSetTextDecorationColor_thenPDLayoutAttributeObjectTextDecorationColorBIsZero() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationColor(new PDGamma());

    // Assert
    PDGamma textDecorationColor = pdLayoutAttributeObject.getTextDecorationColor();
    assertEquals(0.0f, textDecorationColor.getB());
    assertEquals(0.0f, textDecorationColor.getG());
    assertEquals(0.0f, textDecorationColor.getR());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTextDecorationThickness()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTextDecorationThickness()}
   */
  @Test
  @DisplayName(
      "Test getTextDecorationThickness(); given PDLayoutAttributeObject(); then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float PDLayoutAttributeObject.getTextDecorationThickness()"})
  void testGetTextDecorationThickness_givenPDLayoutAttributeObject_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1.0f, new PDLayoutAttributeObject().getTextDecorationThickness());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationThickness(float)} with {@code float}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationThickness(float)}
   */
  @Test
  @DisplayName("Test setTextDecorationThickness(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationThickness(float)"})
  void testSetTextDecorationThicknessWithFloat() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationThickness(10.0f);

    // Assert
    assertEquals(10.0f, pdLayoutAttributeObject.getTextDecorationThickness());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationThickness(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationThickness(int)}
   */
  @Test
  @DisplayName("Test setTextDecorationThickness(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationThickness(int)"})
  void testSetTextDecorationThicknessWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationThickness(1);

    // Assert
    assertEquals(1.0f, pdLayoutAttributeObject.getTextDecorationThickness());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationThickness(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationThickness(int)}
   */
  @Test
  @DisplayName("Test setTextDecorationThickness(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationThickness(int)"})
  void testSetTextDecorationThicknessWithInt2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationThickness(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, pdLayoutAttributeObject.getTextDecorationThickness());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getTextDecorationType()}.
   *
   * <ul>
   *   <li>Then return {@link PDLayoutAttributeObject#BORDER_STYLE_NONE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getTextDecorationType()}
   */
  @Test
  @DisplayName("Test getTextDecorationType(); then return BORDER_STYLE_NONE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getTextDecorationType()"})
  void testGetTextDecorationType_thenReturnBorder_style_none() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BORDER_STYLE_NONE,
        new PDLayoutAttributeObject().getTextDecorationType());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setTextDecorationType(String)}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setTextDecorationType(String)}
   */
  @Test
  @DisplayName("Test setTextDecorationType(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setTextDecorationType(String)"})
  void testSetTextDecorationType() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setTextDecorationType("Text Decoration Type");

    // Assert
    assertEquals("Text Decoration Type", pdLayoutAttributeObject.getTextDecorationType());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getRubyAlign()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#RUBY_ALIGN_DISTRIBUTE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getRubyAlign()}
   */
  @Test
  @DisplayName(
      "Test getRubyAlign(); given PDLayoutAttributeObject(); then return RUBY_ALIGN_DISTRIBUTE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getRubyAlign()"})
  void testGetRubyAlign_givenPDLayoutAttributeObject_thenReturnRuby_align_distribute() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.RUBY_ALIGN_DISTRIBUTE,
        new PDLayoutAttributeObject().getRubyAlign());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setRubyAlign(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} RubyAlign is {@code Ruby
   *       Align}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setRubyAlign(String)}
   */
  @Test
  @DisplayName(
      "Test setRubyAlign(String); then PDLayoutAttributeObject() RubyAlign is 'Ruby Align'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setRubyAlign(String)"})
  void testSetRubyAlign_thenPDLayoutAttributeObjectRubyAlignIsRubyAlign() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setRubyAlign("Ruby Align");

    // Assert
    assertEquals("Ruby Align", pdLayoutAttributeObject.getRubyAlign());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getRubyPosition()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@link PDLayoutAttributeObject#BLOCK_ALIGN_BEFORE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getRubyPosition()}
   */
  @Test
  @DisplayName(
      "Test getRubyPosition(); given PDLayoutAttributeObject(); then return BLOCK_ALIGN_BEFORE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getRubyPosition()"})
  void testGetRubyPosition_givenPDLayoutAttributeObject_thenReturnBlock_align_before() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.BLOCK_ALIGN_BEFORE,
        new PDLayoutAttributeObject().getRubyPosition());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setRubyPosition(String)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} RubyPosition is {@code
   *       Ruby Position}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setRubyPosition(String)}
   */
  @Test
  @DisplayName(
      "Test setRubyPosition(String); then PDLayoutAttributeObject() RubyPosition is 'Ruby Position'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setRubyPosition(String)"})
  void testSetRubyPosition_thenPDLayoutAttributeObjectRubyPositionIsRubyPosition() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setRubyPosition("Ruby Position");

    // Assert
    assertEquals("Ruby Position", pdLayoutAttributeObject.getRubyPosition());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getGlyphOrientationVertical()}.
   *
   * <ul>
   *   <li>Then return {@link PDLayoutAttributeObject#GLYPH_ORIENTATION_VERTICAL_AUTO}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getGlyphOrientationVertical()}
   */
  @Test
  @DisplayName("Test getGlyphOrientationVertical(); then return GLYPH_ORIENTATION_VERTICAL_AUTO")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.getGlyphOrientationVertical()"})
  void testGetGlyphOrientationVertical_thenReturnGlyph_orientation_vertical_auto() {
    // Arrange, Act and Assert
    assertEquals(
        PDLayoutAttributeObject.GLYPH_ORIENTATION_VERTICAL_AUTO,
        new PDLayoutAttributeObject().getGlyphOrientationVertical());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setGlyphOrientationVertical(String)}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setGlyphOrientationVertical(String)}
   */
  @Test
  @DisplayName("Test setGlyphOrientationVertical(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setGlyphOrientationVertical(String)"})
  void testSetGlyphOrientationVertical() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setGlyphOrientationVertical("Glyph Orientation Vertical");

    // Assert
    assertEquals(
        "Glyph Orientation Vertical", pdLayoutAttributeObject.getGlyphOrientationVertical());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getColumnCount()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getColumnCount()}
   */
  @Test
  @DisplayName("Test getColumnCount(); given PDLayoutAttributeObject(); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int PDLayoutAttributeObject.getColumnCount()"})
  void testGetColumnCount_givenPDLayoutAttributeObject_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, new PDLayoutAttributeObject().getColumnCount());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColumnCount(int)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} ColumnCount is {@link
   *       Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColumnCount(int)}
   */
  @Test
  @DisplayName("Test setColumnCount(int); then PDLayoutAttributeObject() ColumnCount is MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColumnCount(int)"})
  void testSetColumnCount_thenPDLayoutAttributeObjectColumnCountIsMin_value() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColumnCount(Integer.MIN_VALUE);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
    assertEquals(Integer.MIN_VALUE, pdLayoutAttributeObject.getColumnCount());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColumnCount(int)}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} ColumnCount is three.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColumnCount(int)}
   */
  @Test
  @DisplayName("Test setColumnCount(int); then PDLayoutAttributeObject() ColumnCount is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColumnCount(int)"})
  void testSetColumnCount_thenPDLayoutAttributeObjectColumnCountIsThree() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColumnCount(3);

    // Assert
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertEquals(3, pdLayoutAttributeObject.getColumnCount());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getColumnGap()}.
   *
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(COSDictionary)}
   *       with dictionary is {@link COSDictionary#COSDictionary()}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getColumnGap()}
   */
  @Test
  @DisplayName(
      "Test getColumnGap(); given PDExportFormatAttributeObject(COSDictionary) with dictionary is COSDictionary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getColumnGap()"})
  void testGetColumnGap_givenPDExportFormatAttributeObjectWithDictionaryIsCOSDictionary() {
    // Arrange, Act and Assert
    assertNull(new PDExportFormatAttributeObject(new COSDictionary()).getColumnGap());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getColumnGap()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getColumnGap()}
   */
  @Test
  @DisplayName("Test getColumnGap(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getColumnGap()"})
  void testGetColumnGap_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getColumnGap());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColumnGap(float)} with {@code float}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} ColumnGap floatValue is
   *       ten.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColumnGap(float)}
   */
  @Test
  @DisplayName(
      "Test setColumnGap(float) with 'float'; then PDLayoutAttributeObject() ColumnGap floatValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColumnGap(float)"})
  void testSetColumnGapWithFloat_thenPDLayoutAttributeObjectColumnGapFloatValueIsTen() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColumnGap(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getColumnGap()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColumnGap(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColumnGap(int)}
   */
  @Test
  @DisplayName("Test setColumnGap(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColumnGap(int)"})
  void testSetColumnGapWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColumnGap(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getColumnGap()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setColumnGap(int)} with {@code int}.
   *
   * <ul>
   *   <li>Then {@link PDLayoutAttributeObject#PDLayoutAttributeObject()} ColumnGap floatValue is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setColumnGap(int)}
   */
  @Test
  @DisplayName(
      "Test setColumnGap(int) with 'int'; then PDLayoutAttributeObject() ColumnGap floatValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setColumnGap(int)"})
  void testSetColumnGapWithInt_thenPDLayoutAttributeObjectColumnGapFloatValueIsOne() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setColumnGap(1);

    // Assert
    assertEquals(1.0f, ((Float) pdLayoutAttributeObject.getColumnGap()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#getColumnWidths()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#getColumnWidths()}
   */
  @Test
  @DisplayName("Test getColumnWidths(); given PDLayoutAttributeObject(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PDLayoutAttributeObject.getColumnWidths()"})
  void testGetColumnWidths_givenPDLayoutAttributeObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new PDLayoutAttributeObject().getColumnWidths());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllColumnWidths(float)} with {@code float}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(float)}
   */
  @Test
  @DisplayName("Test setAllColumnWidths(float) with 'float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllColumnWidths(float)"})
  void testSetAllColumnWidthsWithFloat() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllColumnWidths(10.0f);

    // Assert
    assertEquals(10.0f, ((Float) pdLayoutAttributeObject.getColumnWidths()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllColumnWidths(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(int)}
   */
  @Test
  @DisplayName("Test setAllColumnWidths(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllColumnWidths(int)"})
  void testSetAllColumnWidthsWithInt() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllColumnWidths(1);

    // Assert
    assertEquals(1.0f, ((Float) pdLayoutAttributeObject.getColumnWidths()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#setAllColumnWidths(int)} with {@code int}.
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#setAllColumnWidths(int)}
   */
  @Test
  @DisplayName("Test setAllColumnWidths(int) with 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PDLayoutAttributeObject.setAllColumnWidths(int)"})
  void testSetAllColumnWidthsWithInt2() {
    // Arrange
    PDLayoutAttributeObject pdLayoutAttributeObject = new PDLayoutAttributeObject();

    // Act
    pdLayoutAttributeObject.setAllColumnWidths(Integer.MIN_VALUE);

    // Assert
    assertEquals(-2.14748365E9f, ((Float) pdLayoutAttributeObject.getColumnWidths()).floatValue());
    COSDictionary cOSObject = pdLayoutAttributeObject.getCOSObject();
    assertEquals(2, cOSObject.getValues().size());
    assertEquals(2, cOSObject.size());
    assertFalse(pdLayoutAttributeObject.isEmpty());
  }

  /**
   * Test {@link PDLayoutAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDExportFormatAttributeObject#PDExportFormatAttributeObject(String)} with
   *       {@code Owner}.
   *   <li>Then return {@code O=Owner}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given PDExportFormatAttributeObject(String) with 'Owner'; then return 'O=Owner'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.toString()"})
  void testToString_givenPDExportFormatAttributeObjectWithOwner_thenReturnOOwner() {
    // Arrange, Act and Assert
    assertEquals("O=Owner", new PDExportFormatAttributeObject("Owner").toString());
  }

  /**
   * Test {@link PDLayoutAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Given {@link PDLayoutAttributeObject#PDLayoutAttributeObject()}.
   *   <li>Then return {@code O=Layout}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); given PDLayoutAttributeObject(); then return 'O=Layout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.toString()"})
  void testToString_givenPDLayoutAttributeObject_thenReturnOLayout() {
    // Arrange, Act and Assert
    assertEquals("O=Layout", new PDLayoutAttributeObject().toString());
  }

  /**
   * Test {@link PDLayoutAttributeObject#toString()}.
   *
   * <ul>
   *   <li>Then return {@code O=null}.
   * </ul>
   *
   * <p>Method under test: {@link PDLayoutAttributeObject#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'O=null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String PDLayoutAttributeObject.toString()"})
  void testToString_thenReturnONull() {
    // Arrange, Act and Assert
    assertEquals("O=null", new PDLayoutAttributeObject(new COSDictionary()).toString());
  }
}
